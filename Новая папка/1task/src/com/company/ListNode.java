package com.company;

public class ListNode<E> {
    E value;
    ListNode next;

    public void insert(E newValue) {
        value = newValue;
    }
}