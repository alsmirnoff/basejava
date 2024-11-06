package ru.javawebinar.basejava.storage;

import java.util.List;
import java.util.ArrayList;

import ru.javawebinar.basejava.model.Resume;

public class ListStorage extends AbstractStorage {

    private List<Resume> listStorage = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if(listStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        listStorage.set((Integer) searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        listStorage.add(resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return listStorage.get((Integer) searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        listStorage.remove(((Integer) searchKey).intValue());
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[listStorage.size()]);
    }

}
