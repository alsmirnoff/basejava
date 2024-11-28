package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.MapUuidStorage;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestMapStorage {
    private static final MapUuidStorage MAP_STORAGE = new MapUuidStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1");
        final Resume r2 = new Resume("uuid2");
        final Resume r3 = new Resume("uuid3");
        final Resume r4 = new Resume("uuid4");

        MAP_STORAGE.save(r1);
        MAP_STORAGE.save(r2);
        MAP_STORAGE.save(r3);

        printAll();

        System.out.println("Get r1: " + MAP_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + MAP_STORAGE.size());

        //System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        //System.out.println("Index of r2: " + Arrays.binarySearch(ARRAY_STORAGE.storage, 0, ARRAY_STORAGE.size(), r3));

        System.out.println("---All---------------------------");
        printAll();

        /*System.out.println("---Update-non-existed------------");
        MAP_STORAGE.update(r4);
        printAll();*/

        System.out.println("---Update-existed----------------");
        MAP_STORAGE.update(r2);
        printAll();

        System.out.println("---Delete------------------------");
        MAP_STORAGE.delete(r1.getUuid());
        printAll();

        System.out.println("---Clear-------------------------");
        MAP_STORAGE.clear();
        printAll();

        System.out.println("---Size--------------------------");
        System.out.println("Size: " + MAP_STORAGE.size());
        
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : MAP_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
