package ru.javawebinar.basejava.storage;

import java.util.Comparator;
import java.util.List;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {

    Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing((Resume r) -> r.getFullName()).thenComparing(r -> r.getUuid());

    int size();

    void clear();

    void update(Resume resume);

    Resume get(String uuid);

    //Resume[] getAll();
    
    //return list sorted by name
    List<Resume> getAllSorted();

    void save(Resume resume);

    void delete(String uuid);

}
