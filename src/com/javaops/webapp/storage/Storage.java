package com.javaops.webapp.storage;

import com.javaops.webapp.model.Resume;


public interface Storage {
    public void clear();
    public void save(Resume r);
    public Resume get(String uuid);
    public void delete(String uuid);
    public void update(Resume resume);
    public Resume[] getAll();
    public int size();
}
