package ru.javawebinar.basejava.storage;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import ru.javawebinar.basejava.ResumeTestData;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final String NAME_1 = "name1";
    private static final String NAME_2 = "name2";
    private static final String NAME_3 = "name3";
    private static final String NAME_4 = "name4";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    static {
        /*RESUME_1 = new Resume(UUID_1, NAME_1);
        RESUME_2 = new Resume(UUID_2, NAME_2);
        RESUME_3 = new Resume(UUID_3, NAME_3);
        RESUME_4 = new Resume(UUID_4, NAME_4);*/
        RESUME_1 = new ResumeTestData().createResume(UUID_1, NAME_1);
        RESUME_2 = new ResumeTestData().createResume(UUID_2, NAME_2);
        RESUME_3 = new ResumeTestData().createResume(UUID_3, NAME_3);
        RESUME_4 = new ResumeTestData().createResume(UUID_4, NAME_4);
    }
    
    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_3);
        storage.save(RESUME_2);
    }

    @After
    public void tearDown() {
        storage.clear();
    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    @Test
    public void clear()  throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(RESUME_1.getUuid(), "newName");
        storage.update(newResume);
        assertTrue(newResume == storage.get(RESUME_1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExisted() throws Exception {
        storage.update(new Resume("dummy"));
    }

    /*@Test
    public void getAll() throws Exception {
        Resume [] array = storage.getAll();
        assertEquals(3, array.length);
        assertEquals(RESUME_1, array[0]);
        assertEquals(RESUME_2, array[1]);
        assertEquals(RESUME_3, array[2]); 
    }*/

    @Test
    public void getAllSorted(){
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        assertEquals(list, Arrays.asList(RESUME_1,RESUME_2,RESUME_3));
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExisted() throws Exception {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(RESUME_1.getUuid());
        assertSize(2);
        storage.get(RESUME_1.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExisted() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExisted() throws Exception {
        storage.get("dummy");
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}