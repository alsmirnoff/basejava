package ru.javawebinar.basejava.storage;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//@RunWith(Parameterized.class)
public class ArrayStorageTest extends AbstractArrayStorageTest {
    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void delete() {
        super.delete();
    }

    @Override
    public void get() {
        super.get();
    }

    @Override
    public void getAll() {
        super.getAll();
    }

    @Override
    public void getNotExist() throws Exception {
        super.getNotExist();
    }

    @Override
    public void save() {
        super.save();
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    public void size() {
        super.size();
    }

    @Override
    public void update() {
        super.update();
    }

}