/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    int indexOf(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) return i;
        }
        return -1;
    }

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void update(Resume resume) {
        if (indexOf(resume.uuid) < 0) System.out.println("ERROR: resume " + resume + " not found!");
        else {
            storage[indexOf(resume.uuid)] = resume;
        }
    }

    void save(Resume resume) {
        if (indexOf(resume.uuid) > 0) System.out.println("ERROR: resume " + resume + " already exist!");
        else {
            if (size + 1 > storage.length) System.out.println("ERROR: storage overfilled!");
            else {
                storage[size] = resume;
                size++;
            }
        }
    }

    Resume get(String uuid) {
        if (indexOf(uuid) < 0) System.out.println("ERROR: resume " + uuid + " not found!");
        else {
            return storage[indexOf(uuid)];
        }
        return null;
    }

    void delete(String uuid) {
        if (indexOf(uuid) < 0) System.out.println("ERROR: resume " + uuid + " not found!");
        else {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[size];
        for (int i = 0; i < allResume.length; i++) {
            allResume[i] = storage[i];
        }
        return allResume;
    }

    int size() {
        return size;
    }
}
