package com.airtribe.meditrack.util;

import java.util.*;

public class DataStore<T> {

    private final Map<String, T> store = new HashMap<>();

    public void save(String id, T obj) {
        store.put(id, obj);
    }

    public T get(String id) {
        return store.get(id);
    }

    public Collection<T> getAll() {
        return store.values();
    }
}