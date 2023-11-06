package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public int indexOf(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) return i;
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume resume) {
        if (indexOf(resume.getUuid()) < 0) System.out.println("ERROR: resume " + resume + " not found!");
        else {
            storage[indexOf(resume.getUuid())] = resume;
        }
    }

    public void save(Resume resume) {
        if (indexOf(resume.getUuid()) > 0) System.out.println("ERROR: resume " + resume + " already exist!");
        else {
            if (size + 1 > storage.length) System.out.println("ERROR: storage overfilled!");
            else {
                storage[size] = resume;
                size++;
            }
        }
    }

    public Resume get(String uuid) {
        if (indexOf(uuid) < 0) System.out.println("ERROR: resume " + uuid + " not found!");
        else {
            return storage[indexOf(uuid)];
        }
        return null;
    }

    public void delete(String uuid) {
        if (indexOf(uuid) < 0) System.out.println("ERROR: resume " + uuid + " not found!");
        else {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] allResume = new Resume[size];
        for (int i = 0; i < allResume.length; i++) {
            allResume[i] = storage[i];
        }
        return allResume;
    }

    public int size() {
        return size;
    }
}
