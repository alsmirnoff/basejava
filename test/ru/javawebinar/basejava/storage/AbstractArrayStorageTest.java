package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    //private Storage storage = new ArrayStorage();
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() {
        System.out.println("size in abstract");
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        System.out.println("clear in abstract");
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
    }

    @Test
    public void getAll() {
        System.out.println("get in abstract");
        Resume [] resumes = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        Assert.assertArrayEquals(resumes, storage.getAll());
    }

    @Test
    public void getNotAll() {
        System.out.println("getNotAll in abstract");
        Resume [] resumes = {new Resume(UUID_1), new Resume(UUID_2)};
        Assert.assertArrayEquals(resumes, storage.getAll());
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
        System.out.println("get in abstract");
        Assert.assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        System.out.println("getNotExist in abstract");
        storage.get("dummy");
    }
}