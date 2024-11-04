package ru.javawebinar.basejava.storage;

import java.util.List;
import java.util.ArrayList;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public class ListStorage extends AbstractStorage {

    protected List<Resume> listStorage = new ArrayList<>();

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[listStorage.size()]);
    }

    @Override
    protected int indexOf(String uuid) {
        return listStorage.indexOf(new Resume(uuid));
    }

    @Override
    public void delete(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        else {
            listStorage.remove(index);
        }
    }

    /*@Override
    protected void doDelete(int index) {
        listStorage.remove(index);
    }*/

    @Override
    protected void doUpdate(Resume resume, int index) {
        listStorage.set(index, resume);
    }

    @Override
    public Resume get(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return listStorage.get(index);
    }

    /*@Override
    protected Resume doGet(int index) {
        return listStorage.get(index);
    }*/

    @Override
    protected void doSave(Resume resume, int index) {
        listStorage.add(resume);
    }

}
