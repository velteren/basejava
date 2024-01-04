/**
 * Array based storage for Resumes
 */
import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageRealSize = 0;

    void clear() {
        Arrays.fill(storage, null);
        storageRealSize = 0;
    }

    void save(Resume r) {
        storage[storageRealSize] = r;
        storageRealSize++;
    }

    Resume get(String uuid) {
        Resume result = null;
        for (int i = 0; i < storageRealSize; i++) {
            if (storage[i].uuid.equals(uuid)) result = storage[i];
        }
        return result;
    }

    void delete(String uuid) {
        Resume[] tempArr = new Resume[10000];
        for (int i = 0, j = 0; i < storageRealSize; i++, j++) {
            if (storage[i].uuid.equals(uuid)) {
                j += 1;
            }
            tempArr[i] = storage[j];
        }
        storage = tempArr;
        storageRealSize--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, storageRealSize);
    }

    int size() {
        return storageRealSize;
    }
}
