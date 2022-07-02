package com.company;

public class Entry<E> {
    int key;
    E data;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Entry(int key, E data) {
        this.key = key;
        this.data = data;
    }


}
