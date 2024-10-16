package ru.javawebinar.basejava.storage;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    protected static final int STORAGE_LIMIT = 10000;
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

    @After
    public void tearDown() {
        storage.clear();
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        storage.update(new Resume(UUID_1));
        assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExisted() throws Exception {
        storage.update(new Resume(UUID_4));
    }

    @Test
    public void getAll() {
        Resume [] resumes = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        Assert.assertArrayEquals(resumes, storage.getAll());
    }

    @Test(expected = StorageException.class)
    public void save() {
        storage.clear();
        try {
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                storage.save(new Resume("UUID_" + i));
            }
        }
        catch (Exception e) {
            fail("ERROR: Storage overflowing before reaching the limit!");
        }
        storage.save(new Resume("UUID_" + STORAGE_LIMIT ));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExisted() throws Exception {
        storage.save(new Resume(UUID_1));
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExisted() throws Exception {
        storage.delete(UUID_4);
    }

    @Test
    public void get() {
        Assert.assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExisted() throws Exception {
        storage.get("dummy");
    }
}