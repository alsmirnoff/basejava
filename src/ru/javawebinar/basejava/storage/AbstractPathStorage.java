package ru.javawebinar.basejava.storage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {

    private Path directory;

    protected AbstractPathStorage(String dir){
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if(!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directiry or is not writable");
        }
    }

    @Override
    public int size() {
        String[] list = directory.list();
        if(list == null) {
            throw new StorageException("Directory read error", null);
        }
        return list.length;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return new Path(directory, uuid);
    }

    @Override
    protected boolean isExist(Path Path) {
        return Path.exists();
    }

    @Override
    protected void doUpdate(Resume resume, Path Path) {
        try {
            doWrite(resume, new BufferedOutputStream(new PathOutputStream(Path)));
        } catch (IOException e) {
            throw new StorageException("Path write error", resume.getUuid(), e);
        }
    }

    @Override
    protected void doSave(Resume resume, Path Path) {
        try {
            Path.createNewPath();
        } catch (IOException e) {
            throw new StorageException("Couldn't create Path " + Path.getAbsolutePath(), Path.getName(), e);
        }
        doUpdate(resume, Path);
    }
     
    @Override
    protected void doDelete(Path Path) {
        if(!Path.delete()) {
            throw new StorageException("Path delete error", Path.getName());
        }
    }

    @Override
    protected Resume doGet(Path Path) {
        try {
            return doRead(new BufferedInputStream(new PathInputStream(Path)));
        } catch (IOException e) {
            throw new StorageException("Path read error", Path.getName());
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        Path[] list = directory.listPaths();
        if(list == null) {
            throw new StorageException("Directory read error", null);
        }
        List<Resume> resumes = new ArrayList<>(list.length);
        for (Path Path : list) {
            resumes.add(doGet(Path));
        }
        return resumes;
    }

    protected abstract void doWrite(Resume resume, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

}
