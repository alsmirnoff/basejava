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
        for(int i = 0; i < storage.length; i++){
            if(uuid.equals(storage[i].toString())) {
                storage[i] = null;
                /* j = i;
                while((storage[j] != null) && (j < storage.length-1)){
                    storage[j] = storage[j+1];
                    j++;
                }*/
                /*for(int j = i; j < storage.length-1; j++) {
                    storage[j] = storage[j+1];
                }*/
            }
        }
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
