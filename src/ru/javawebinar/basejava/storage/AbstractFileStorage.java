package ru.javawebinar.basejava.storage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractFileStorage extends AbstractStorage<File> {

    private File directory;

    private AbstractFileStorage(File directory){
        Objects.requireNonNull(directory, "directory must not be null");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doUpdate'");
    }

    @Override
    protected void doSave(Resume resume, File file) {
        try {
            file.createNewFile();
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }
            
    protected abstract void doWrite(Resume resume, File file) throws IOException;
            
    @Override
    protected void doDelete(File file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doDelete'");
    }

    @Override
    protected Resume doGet(File file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doGet'");
    }

    @Override
    protected List<Resume> doCopyAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doCopyAll'");
    }

}
