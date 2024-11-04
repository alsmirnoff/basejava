package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage{
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected void doUpdate(Resume resume, int index) {
        storage[index] = resume;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected void doSave(Resume resume, int index) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("ERROR: storage overflow!", resume.getUuid());
        }
        else {
            insertElement(resume, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    /*protected void doDelete(int index) {
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }*/

    public Resume get(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        //return doGet(index);
        return storage[index];
    }

    /*protected Resume doGet(int index) {
        return storage[index];
    }*/

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void fillDeletedElement(int index);

}
