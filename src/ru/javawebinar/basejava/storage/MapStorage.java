package ru.javawebinar.basejava.storage;

import java.util.Map;
import java.util.HashMap;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public class MapStorage extends AbstractStorage {

    protected Map<String, Resume> mapStorage = new HashMap<String, Resume>();    

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

    /*@Override
    protected void doDelete(int index) {
        mapStorage.remove(Integer.toString(index));
    }*/

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

    /*@Override
    protected Resume doGet(int index) {
        return mapStorage.get();
    }*/

    @Override
    protected void doSave(Resume resume, int index) {
        mapStorage.put(resume.getUuid(), resume);
    }

}
