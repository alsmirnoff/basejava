package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage{
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

    public void update(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index < 0) System.out.println("ERROR: resume " + resume + " not exist!");
        else {
            storage[index] = resume;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void save(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index > 0) System.out.println("ERROR: resume " + resume + " already exist!");
        else if (size >= STORAGE_LIMIT) System.out.println("ERROR: storage overflow!");
        else {
            insertElement(resume, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) System.out.println("ERROR: resume " + uuid + " not exist!");
        else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume get(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            System.out.println("ERROR: resume " + uuid + " not exist!");
            return null;
        }
        return storage[index];
    }

    protected abstract int indexOf(String uuid);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void fillDeletedElement(int index);

}
