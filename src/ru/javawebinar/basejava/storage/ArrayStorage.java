package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage{

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index == -1) System.out.println("ERROR: resume " + resume + " not exist!");
        else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        if (indexOf(resume.getUuid()) != -1) System.out.println("ERROR: resume " + resume + " already exist!");
        else if (size >= STORAGE_LIMIT) System.out.println("ERROR: storage overflow!");
        else {
            storage[size] = resume;
            size++;
        }
    }

    public void delete(String uuid) {
        int index = indexOf(uuid);
        if (index == -1) System.out.println("ERROR: resume " + uuid + " not exist!");
        else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected int indexOf(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) return i;
        }
        return -1;
    }
}
