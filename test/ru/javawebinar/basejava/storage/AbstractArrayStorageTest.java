package ru.javawebinar.basejava.storage;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    //protected static final int STORAGE_LIMIT = 10000;
    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUID_3);

    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_4 = new Resume(UUID_4);
    
    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @After
    public void tearDown() {
        storage.clear();
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
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
        Resume [] array = storage.getAll();
        assertEquals(3, array.length);
        assertEquals(RESUME_1, array[0]);
        assertEquals(RESUME_2, array[1]);
        assertEquals(RESUME_3, array[2]);
        
    }

    //@Test(expected = StorageException.class)
    @Test
    public void save() {
        /*storage.clear();
        try {
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                storage.save(new Resume("UUID_" + i));
            }
        }
        catch (Exception e) {
            fail("ERROR: Storage overflowing before reaching the limit!");
        }
        storage.save(new Resume("UUID_" + STORAGE_LIMIT ));*/

        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExisted() throws Exception {
        storage.save(RESUME_1);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            fail("ERROR: Storage overflowing before reaching the limit!");
        }
        storage.save(new Resume());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExisted() throws Exception {
        storage.delete("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExisted() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void get() {
        assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    private void assertGet(Resume r) {
        //assertEquals(r, storage.get(r.getUuid()));
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}