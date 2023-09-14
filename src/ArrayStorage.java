/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10];

    void clear() {
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
        return storage;
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
