package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage/* = new ArrayStorage()*/;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @org.junit.Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @org.junit.Test
    public void clear() {
    }

    @org.junit.Test
    public void update() {
    }

    @org.junit.Test
    public void getAll() {
    }

    @org.junit.Test
    public void save() {
    }

    @org.junit.Test
    public void delete() {
    }

    @org.junit.Test
    public void get() {
    }

    @org.junit.Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}