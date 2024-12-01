package ru.javawebinar.basejava.storage;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;

import ru.javawebinar.basejava.model.Resume;


// TODO implement
// TODO create new MapStorage with search key not uuid
public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> mapStorage = new HashMap<>();
    
    @Override
    protected String getSearchKey(String uuid) { return uuid; }

    @Override
    protected boolean isExist(Object searchKey) {
        return mapStorage.containsKey(searchKey);
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        mapStorage.put((String) searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        mapStorage.put((String) searchKey, resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return mapStorage.get((String) searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        mapStorage.remove(searchKey);
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
    public List<Resume> getAllSorted() {
        return mapStorage.values().stream()
            .sorted(RESUME_COMPARATOR)
            .collect(Collectors.toList());
    }

}
