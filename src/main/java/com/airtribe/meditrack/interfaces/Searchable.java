package com.airtribe.meditrack.interfaces;

public interface Searchable {
    default void logSearch(String key) {
        System.out.println("Searching for: " + key);
    }
}