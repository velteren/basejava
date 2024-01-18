package com.javaops.webapp.storage;

import com.javaops.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage implements Storage {
    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0 , size, null);
        size = 0;
    }
    private boolean inStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) return true;
        }
        return false;
    }
    public void save(Resume r) {
        if (inStorage(r.getUuid())) {
            System.out.println("Already in storage");
        } else {
            if (size < storage.length) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Storage is full");
            }
        }
    }

    public Resume get(String uuid) {
        if (!inStorage(uuid)) {
            System.out.println("Not in storage");
            return null;
        }
        Resume result = null;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) result = storage[i];
        }
        return result;
    }

    public void delete(String uuid) {
        if (inStorage(uuid)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                }
            }
        } else {
            System.out.println("Not in storage");
        }

    }

    public void update(Resume resume) {
        if (inStorage(resume.getUuid())) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(resume.getUuid())) {
                    storage[i] = resume;
                }
            }
        } else {
            System.out.println("Not in storage");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
