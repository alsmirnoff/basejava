package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.ArrayStorage;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1", "name1");
        final Resume r2 = new Resume("uuid2", "name2");
        final Resume r3 = new Resume("uuid3", "name3");
        final Resume r4 = new Resume("uuid4", "name4");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        //System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        //System.out.println("Index of r2: " + Arrays.binarySearch(ARRAY_STORAGE.storage, 0, ARRAY_STORAGE.size(), r3));

        System.out.println("---All---------------------------");
        printAll();

        System.out.println("---Update-non-existed------------");
        ARRAY_STORAGE.update(r4);
        printAll();

        System.out.println("---Update-existed----------------");
        ARRAY_STORAGE.update(r2);
        printAll();

        System.out.println("---Delete------------------------");
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();

        System.out.println("---Clear-------------------------");
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("---Size--------------------------");
        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
