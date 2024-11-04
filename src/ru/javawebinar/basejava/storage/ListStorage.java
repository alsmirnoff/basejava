package ru.javawebinar.basejava.storage;

import java.util.List;
import java.util.ArrayList;

import ru.javawebinar.basejava.model.Resume;

public class ListStorage extends AbstractStorage {

    protected List<Resume> listStorage = new ArrayList<>();

    public int size() {
        return listStorage.size();
    }

    public void clear() {
        listStorage.clear();
    }

    public Resume[] getAll() {
        return listStorage.toArray(new Resume[listStorage.size()]);
    }

    protected int indexOf(String uuid) {
        return listStorage.indexOf(new Resume(uuid));
    }

    protected void doSave(Resume resume, int index) {
        listStorage.add(resume);
    }
    
    protected void doDelete(int index) {
        listStorage.remove(index);
    }

    protected void doUpdate(Resume resume, int index) {
        listStorage.set(index, resume);
    }

    protected Resume doGet(int index) {
        return listStorage.get(index);
    }

}
