/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10];

    void clear() {
        int i = 0;
        while (storage[i] != null) {
            storage[i] = null;
            i++;
        }
    }

    void save(Resume r) {
        for(int i = 0; i < storage.length; i++){
            if(storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        int i = 0;
        while (storage[i] != null) {
            if(storage[i].uuid.equals(uuid)) return storage[i];
            i++;
        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i < this.size(); i++){
            if(uuid.equals(storage[i].uuid)) {
                for (int k = i; k < this.size() - 1; k++) {
                    storage[k] = storage[k+1];
                }
                break;
            }
        }
        storage[this.size() - 1] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] shortStorage = new Resume[this.size()];
        for(int i = 0; i < shortStorage.length; i++){
            shortStorage[i] = storage[i];
        }
        return shortStorage;
    }

    int size() {
        int i = 0;
        int res = 0;
        while(i < storage.length && storage[i] != null){
            res++;
            i++;
        }
        return res;
    }
}
