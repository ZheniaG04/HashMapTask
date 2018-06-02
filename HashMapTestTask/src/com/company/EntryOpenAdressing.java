package com.company;

import static java.util.Objects.hash;

//code for entry with open addressing

public class EntryOpenAdressing {
    private int hash;
    private int key;
    private long value;

    public EntryOpenAdressing(int key, long value) {
        hash = hash(key);
        this.key = key;
        this.value = value;
    }

    public int getHash() {
        return hash;
    }


    public int getKey() {
        return key;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
