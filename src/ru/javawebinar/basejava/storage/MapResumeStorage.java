package ru.javawebinar.basejava.storage;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.javawebinar.basejava.model.Resume;

public class MapResumeStorage extends AbstractStorage {

    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return mapStorage.get(uuid);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    protected void doUpdate(Resume r, Object resume) {
        mapStorage.put(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, Object resume) {
        mapStorage.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void doDelete(Object resume) {
        mapStorage.remove(((Resume) resume).getUuid());
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
