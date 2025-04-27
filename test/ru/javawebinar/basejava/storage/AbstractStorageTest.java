package ru.javawebinar.basejava.storage;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import ru.javawebinar.basejava.ResumeTestData;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractStorageTest {
    
    protected static final File STORAGE_DIR = new File("src/ru/javawebinar/basejava/fileStorage/");

    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final String NAME_1 = "name1";
    private static final String NAME_2 = "name2";
    private static final String NAME_3 = "name3";
    private static final String NAME_4 = "name4";

    private static final Resume R1;
    private static final Resume R2;
    private static final Resume R3;
    private static final Resume R4;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    static {
        R1 = new ResumeTestData().createResume(UUID_1, NAME_1);
        R2 = new ResumeTestData().createResume(UUID_2, NAME_2);
        R3 = new ResumeTestData().createResume(UUID_3, NAME_3);
        R4 = new ResumeTestData().createResume(UUID_4, NAME_4);
    }
    
    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(R1);
        storage.save(R3);
        storage.save(R2);
    }

    /*@After
    public void tearDown() {
        storage.clear();
    }*/

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
        Resume newResume = new Resume(R1.getUuid(), "newName");
        //Resume newResume = new ResumeTestData().createResume(R1.getUuid(), "newName");
        storage.update(newResume);
        assertTrue(newResume.equals(storage.get(R1.getUuid())));
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
        assertEquals(list, Arrays.asList(R1,R2,R3));
    }

    @Test
    public void save() throws Exception {
        storage.save(R4);
        assertSize(4);
        assertGet(R4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExisted() throws Exception {
        storage.save(R1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(R1.getUuid());
        assertSize(2);
        storage.get(R1.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExisted() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void get() throws Exception {
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
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