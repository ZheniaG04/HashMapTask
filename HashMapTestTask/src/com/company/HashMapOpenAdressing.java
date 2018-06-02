package com.company;

import static java.util.Objects.hash;

//code for hashmap with open addressing


public class HashMapOpenAdressing {
    private EntryOpenAdressing[] table;
    private int tableSize = 16;

    public HashMapOpenAdressing() {
        table = new EntryOpenAdressing[tableSize];
    }

    public void put(int key, long value){
        //creating new entry with key and value
        EntryOpenAdressing entry = new EntryOpenAdressing(key,value);
        //setting index for this entry
        int index = entry.getHash() % tableSize;

        //if table in the index is null or table has no free cells - set the entry in the index
        if(table[index] == null || !arrayHasNulles(table)){
            table[index] = entry;
        }
        else{
            //finding free cell or entry with the same key
            while (table[index] != null && table[index].getKey()!=key){
                index++;
                if(index == tableSize){
                    index = 0;
                }
            }

            if(table[index]==null) {
                table[index] = entry;
            }
            else {
                table[index].setValue(value);
            }

        }
    }

    //checking if array has free cells
    private boolean arrayHasNulles(EntryOpenAdressing[] array){
        for(int i =0;i<array.length;i++){
            if(array[i]==null)
                return true;
        }
        return false;
    }


    public Long get(int key){
        int hash = hash(key);
        int startIndex = hash % tableSize;
        int index = startIndex;

        //finding free cell or entry with the key
        while (table[index] != null && table[index].getKey()!=key){
            index++;
            if(index == tableSize){
                index = 0;
            }
            if(index == startIndex){
                return null;
            }

        }

        if(table[index] == null){
            //if free cell is found return null
            return null;
        }
        else {
            //if cell with the key found return the value
            return table[index].getValue();
        }

    }

    public int size()
    {
        int size = 0;
        // counting a number of not null elements in the table
        for (EntryOpenAdressing entry: table) {
            if(entry!=null){
                size++;
            }
        }
        return size;
    }

    //return table for perform tests
    public EntryOpenAdressing[] getTable() {
        return table;
    }
}
