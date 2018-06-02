package com.company;

import org.junit.jupiter.api.Test;

import static java.util.Objects.hash;
import static org.junit.jupiter.api.Assertions.*;

class HashMapOpenAdressingTest {

    @Test
    void put() {
        HashMapOpenAdressing hashMap = new HashMapOpenAdressing();

        int key = 23;
        long value = 234;
        hashMap.put(key,value);
        if(hashMap.getTable()[hash(key)%16].getValue()==value){
            System.out.println("put: item is successfully putted in the hashMap");
        }
        else {
            System.out.println("put: item is not successfully putted in the hashMap");
        }

        int key1 = 7;
        long value1 = 12;

        hashMap.put(key1,value1);
        if(hashMap.getTable()[hash(key1)%16].getValue()!=value1 && hashMap.getTable()[hash(key1)%16 + 1].getValue()==value1){
            System.out.println("put: item is successfully putted in the hashMap in the next cell");
        }
        else {
            System.out.println("put: item is not successfully putted in the hashMap");
        }
    }

    @Test
    void get() {
        HashMapOpenAdressing hashMap = new HashMapOpenAdressing();

        int key = 5;
        int value = 100;

        hashMap.put(key,value);

        if(hashMap.get(key)==value){
            System.out.println("get: value of the item is correct");
        }
        else {
            System.out.println("get: value of the item is not correct");
        }


        if(hashMap.get(1)==null){
            System.out.println("get: value of wrong key is null");
        }
        else {
            System.out.println("get: value of wrong key is not null");
        }



    }

    @Test
    void size() {
        HashMapOpenAdressing hashMap = new HashMapOpenAdressing();

        if(hashMap.size() == 0){
            System.out.println("size: size of empty hashMap is 0");
        }
        else {
            System.out.println("size: size of empty hashMap is not 0");
        }

        int n = 3;

        for(int i =0;i<3;i++){
            hashMap.put(i,100+i);
        }

        if(hashMap.size() == n){
            System.out.println("size: size after putting "+n+" elements is "+n);
        }
        else {
            System.out.println("size: size after putting "+n+" elements is not "+n);
        }

    }
}