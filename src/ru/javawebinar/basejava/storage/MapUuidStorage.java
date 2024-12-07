package ru.javawebinar.basejava.storage;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.javawebinar.basejava.model.Resume;


public class MapUuidStorage extends AbstractStorage<String> {

    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) { return uuid; }

    @Override
    protected boolean isExist(String uuid) {
        return mapStorage.containsKey(uuid);
    }

    @Override
    protected void doUpdate(Resume resume, String uuid) {
        mapStorage.put(uuid, resume);
    }

    @Override
    protected void doSave(Resume resume, String uuid) {
        mapStorage.put(uuid, resume);
    }

    @Override
    protected Resume doGet(String uuid) {
        return mapStorage.get(uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        mapStorage.remove(uuid);
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public int size() {
        return mapStorage.size();
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(mapStorage.values());
    }


}
