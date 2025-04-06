package ru.javawebinar.basejava.storage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.serializer.StreamSerializer;

public class FileStorage extends AbstractStorage<File> {

    private File directory;
    private StreamSerializer streamSerializer;

    protected FileStorage(File directory, StreamSerializer streamSerializer){
        Objects.requireNonNull(directory, "directory must not be null");
       
        this.streamSerializer = streamSerializer;
        if(!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not a directory");
        }
        if(!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    public int size() {
        String[] list = directory.list();
        if(list == null) {
            throw new StorageException("Directory read error");
        }
        return list.length;
    }

    @Override
    public void clear() {
        File[] list = directory.listFiles();
        if(list != null) {
            for (File file : list) {
                doDelete(file);
            }
        }
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doUpdate(Resume resume, File file) {
        try {
            streamSerializer.doWrite(resume, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File write error", resume.getUuid(), e);
        }
    }

    @Override
    protected void doSave(Resume resume, File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(resume, file);
    }
     
    @Override
    protected void doDelete(File file) {
        if(!file.delete()) {
            throw new StorageException("File delete error", file.getName());
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return streamSerializer.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName());
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        File[] list = directory.listFiles();
        if(list == null) {
            throw new StorageException("Directory read error");
        }
        List<Resume> resumes = new ArrayList<>(list.length);
        for (File file : list) {
            resumes.add(doGet(file));
        }
        return resumes;
    }

}
