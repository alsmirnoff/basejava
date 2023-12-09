package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage{
    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size;

    private int indexOf(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) return i;
        }
        return -1;
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

    public void save(Resume resume) {
        if (indexOf(resume.getUuid()) > 0) System.out.println("ERROR: resume " + resume + " already exist!");
        else if (size == STORAGE_LIMIT) System.out.println("ERROR: storage overflow!");
            else {
                storage[size] = resume;
                size++;
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

    public void delete(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) System.out.println("ERROR: resume " + uuid + " not exist!");
        else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
