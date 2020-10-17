package com.company;

public class List<E> implements Collection<E> {
    private ListNode head;
    private ListNode tail;

    @Override
    public void insert(E newValue) {
        ListNode l = new ListNode();
        l.value = newValue;
        if (head == null) {
            head = l;
            tail = l;
        } else {
            tail.next = l;
            tail = l;
        }
    }

    public void printList() {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.value + " ");
            t = t.next;
        }
    }
}