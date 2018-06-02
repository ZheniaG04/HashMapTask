package com.company;

import static java.util.Objects.hash;

//code for hashmap without open addressing
public class HashMap{
    private Entry[] table;
    private int tableSize = 16;

    public HashMap() {
        table = new Entry[tableSize];
    }

    public void put(int key, long value){
        Entry entry = new Entry(key,value);
        int index = entry.getHash() % tableSize;
        if(table[index] == null){
            table[index] = entry;
        }
        else{
            Entry entryFromTable = table[index];
            while (entryFromTable.getNextEntry() != null && entryFromTable.getKey()!=key){
                entryFromTable = entryFromTable.getNextEntry();
            }

            if(entryFromTable.getKey() == key){
                entryFromTable.setValue(value);
            } else {
                entryFromTable.setNextEntry(entry);
            }
        }
    }

    public Long get(int key){
        int hash = hash(key);
        int index = hash % tableSize;

        Entry entryFromTable = table[index];

        while (entryFromTable.getKey()!=key && entryFromTable.getNextEntry() !=null){
            entryFromTable = entryFromTable.getNextEntry();
        }

        if(entryFromTable.getKey() == key)
        {
            return entryFromTable.getValue();
        }
        else {
            return null;
        }
    }

    public int size()
    {
        int size = 0;

        for (Entry entry: table) {
            if(entry!=null){
                size++;
                Entry entryFromTable = entry;
                while (entryFromTable.getNextEntry()!=null){
                    size++;
                    entryFromTable = entryFromTable.getNextEntry();
                }

            }
        }
        return size;
    }

}
