package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {

    int size();

    void clear();

    void update(Resume resume);

    Resume get(String uuid);

    Resume[] getAll();

    void save(Resume resume);

    void delete(String uuid);

}
