/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylinkedlist;

/**
 *
 * @author 91987
 */
public class DoublyLL {

    Node head = null;
    Node tail = null;
    int size = 0;

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node curr = head;
        Node pre = null;
        Node node = new Node(val);
        for (int i = 0; i < index; i++) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = node;
        node.prev = pre;
        node.next = curr;
        curr.prev = node;
        size++;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Linked List is empty");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " => ");
            curr = curr.next;
        }
        System.out.print("END \n");
        System.out.println(size);
    }

    public int get(int index) {
        if (head == null || index >= size || index < 0) {
            return -1;
        }
        if (index == size - 1 && tail != null) {
            return tail.val;
        }
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;

    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void deleteAll() {
        head = null;
        tail = null;
        size = 0;
        return;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        node.next = null;
        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0 || head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return;
        }
        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }

        Node pre = null;
        Node curr = head;

        for (int i = 0; i < index; i++) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = curr.next;
        curr.next.prev = pre;
        size--;
    }

    public class Node {

        int val = 0;
        Node next = null;
        Node prev = null;

        public Node(int val) {
            this.val = val;
        }
    }
}
