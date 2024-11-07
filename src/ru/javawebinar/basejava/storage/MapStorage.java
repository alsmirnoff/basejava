package ru.javawebinar.basejava.storage;

import java.util.Map;
import java.util.HashMap;

import ru.javawebinar.basejava.model.Resume;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> mapStorage = new HashMap<String, Resume>();
    
    @Override
    protected Object getSearchKey(String uuid) {
        for (Map.Entry<String, Resume> entry : mapStorage.entrySet()) {
            if(uuid.equals(entry.getKey())) return entry.getKey();
        }
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        mapStorage.put((String) searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        System.out.println(" === (String) searchKey: " + (String) searchKey);
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
    public Resume[] getAll() {
        return mapStorage.entrySet().toArray(new Resume[mapStorage.size()]);
    }

    /*protected Map<String, Resume> mapStorage = new HashMap<String, Resume>();    

    @Override
    public int size() {
       return mapStorage.entrySet().size();
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        return mapStorage.values().toArray(new Resume[mapStorage.size()]);
    }

    @Override
    protected int indexOf(String uuid) {
        return mapStorage.containsKey(uuid) ? 1 : -1;
    }

    @Override
    public void delete(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        else {
            mapStorage.remove(uuid);
        }
    }

    @Override
    protected void doDelete(int index) {
        mapStorage.remove(Integer.toString(index));
    }

    @Override
    protected void doUpdate(Resume resume, int index) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    public Resume get(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return mapStorage.get(uuid);
    }

    @Override
    protected Resume doGet(int index) {
        return mapStorage.get();
    }

    @Override
    protected void doSave(Resume resume, int index) {
        mapStorage.put(resume.getUuid(), resume);
    }
    */
}
