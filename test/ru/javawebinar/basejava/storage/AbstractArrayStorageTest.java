package ru.javawebinar.basejava.storage;

import org.junit.Test;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("name" + i));
            }
        } catch (StorageException e) {
            fail("ERROR: Storage overflowing before reaching the limit!");
        }
        storage.save(new Resume("Overflow"));
    }

}