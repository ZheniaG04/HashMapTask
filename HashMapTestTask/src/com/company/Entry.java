package com.company;
import static java.util.Objects.hash;

//code for entry without open addressing

public class Entry{
    private int hash;
    private int key;
    private long value;
    private Entry nextEntry;

    public Entry(int key, long value) {
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

    public Entry getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(Entry nextEntry) {
        this.nextEntry = nextEntry;
    }
}
