/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylinkedlist;

import java.util.ArrayList;

/**
 *
 * @author 91987
 */
public class MyLL {

    Node head = null;
    Node tail = null;
    Node now = null;
    int size = 0;

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " => ");
            curr = curr.next;
        }
        System.out.print("END \n");
        System.out.println(size);
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
        now = head.next;
    }
    
    public void nextGreaterInt(){
        Node curr = head;
        Node next = curr.next;
        int index =0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(curr !=null){
            ans.add(index,0);
            while(next!=null){
                if(curr.val < next.val){
                    ans.add(index,next.val);
                    break;
                }
                next = next.next;
            }
            curr = curr.next;
            if(curr !=null){
            next = curr.next;
            }
            index++;
        }
        int a[] = new int[index];
        for(int i=0;i<index;i++){
            a[i] = ans.get(i);
            System.out.println(a[i]);
        }
        
        
    }

    public Node middleOfList() {
        if (head.next == null || head.next.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void reverseHalf(int val) {
        Node now = head;
        Node prev = null;

        while (now.val != val) {
            prev = now;
            now = now.next;

        }

        prev.next = reverseHalfII(now);

    }

    public Node reverseHalfII(Node node) {
        Node prev = null;
        Node curr = node;
        Node next = node.next;

        for (int i = 0; i < size; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next.next != null) {
                next = next.next;
            }

        }

        return curr;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node();
        Node ans = dummyHead;
        int carry = 0, total = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            dummyHead.next = new Node(num);
            dummyHead = dummyHead.next;
        }

        return ans.next;

    }

    public Node addTwoNumbersII(Node l1, Node l2) {
        Node dummyHead = new Node();
        Node ans = dummyHead;
        int carry = 0, total = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            Node node = new Node(num);
            node.next = dummyHead;
            dummyHead = node;
        }

        return dummyHead;
    }

    public void reverseLinkedList(Node node) {

        if (node == tail) {
            head = tail;
            return;
        }
        reverseLinkedList(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public void rotate(Node node, int k) {
        if (node == null || node.next == null) {
            return;
        }
        Node fast = head;
        Node slow = head;
        int n = k % size;
        if (n == 0) {
            return;
        }
        while (n > 0) {
            if (fast.next == null) {
                fast = head;
            }
            fast = fast.next;
            n--;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node newHead = slow.next;
        slow.next = null;
        fast.next = head;
        head = newHead;

        System.out.println(slow.val);

    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        for (int i = 0; i < size; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next.next != null) {
                next = next.next;
            }

        }
        head = curr;
    }

    public void reverseII(int left, int right) {
        if (left == right) {
            return;
        }
        Node prev = null;
        Node curr = head;

        for (int i = 0; curr != null && i < left - 1; i++) {
            prev = curr;
            curr = curr.next;
        }

        Node last = prev;
        Node newEnd = curr;
        Node next = curr.next;

        for (int i = 0; i < right - left + 1; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = curr;

    }

    public Node reverseIII(Node node) {
        Node prev = null;
        Node curr = node;
        Node next = node.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;

    }

    public void reorderList() {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        Node mid = middleOfList();
        Node l1 = head;
        Node curr = l1.next;
        Node l2 = reverseIII(mid.next);
        Node curr2 = l2.next;
        mid.next = null;

        while (l2 != null) {
            l1.next = l2;
            l2.next = curr;

            l1 = curr;
            l2 = curr2;

            if (curr != null) {
                curr = curr.next;
            }
            if (curr2 != null) {
                curr2 = curr2.next;
            }
        }

    }
    
    public void reorderII(){
        Node dummyHead = new Node(0);
        Node prev = dummyHead;
        Node curr = head;
        Node next = curr.next;
        
        while(curr != null && next!=null){
           prev.next = next;
           curr.next = next.next;
           next.next = curr;
           prev = curr;
           curr = prev.next;
           if(curr != null){
               next = curr.next;
           }
            
        }
        head = dummyHead.next;
    }
    
    public void evenOdd(){
        Node secHead = head.next;
        Node prev = null;
        Node curr = head;
        Node next = curr.next;
        int i = 0;
        
        for( i =1 ;curr.next!=null ;i++){
            curr.next = next.next;
            prev = curr;
            curr = next;
            next = next.next;
        }
        System.out.println(i);
        
        
        if(i%2 == 0){
            prev.next = secHead;
        }
        else{
            curr.next = secHead;
        }
    }

    public void addAtTail(int val) {
        if (tail == null) {
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index >= size || index < 0) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node curr = head;
        Node prev = curr;
        int i = 0;
        while (i < index) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        Node node = new Node(val);
        prev.next = node;
        node.next = curr;
        if (node.next == null) {
            tail = node;
        }
        size++;
    }

    public void deleteDuplicates(Node head) {
        Node dummy = null;
        Node tail = null;
        Node curr = head;
        Node next = head.next;

        while (next != null) {
            if (next.val != curr.val) {
                if (curr.next == next) {
                    Node node = new Node(curr.val);
                    node.next = null;
                    if (dummy == null) {
                        dummy = node;
                        tail = node;
                    } else {
                        tail.next = node;
                        tail = node;
                    }

                }
                curr = next;
            }
            next = next.next;
        }
        if (curr.next == null) {
            Node node = new Node(curr.val);
                    node.next = null;
                    if (dummy == null) {
                        dummy = node;
                        tail = node;
                    } else {
                        tail.next = node;
                        tail = node;
                    }
        }
    }

    int nth = 0;

    public void removeNthNodeFromEnd(Node node, int n) {
        nth = n;
        if (node == null) {
            return;
        } else if (n == 1) {

            if (head.next == null) {
                head = null;
                return;
            }

            while (node.next.next != null) {
                node = node.next;
            }
            node.next = null;
            size--;

        }
        removeNthNodeFromEndII(node);
    }

    public void removeNthNodeFromEndII(Node node) {
        if (node.next == null) {

            nth = nth - 1;

            return;
        }
        removeNthNodeFromEndII(node.next);
        if (nth == 0) {
            return;
        } else if (nth == 1) {
            node.val = node.next.val;
            node.next = node.next.next;
            size--;
        }
        nth = nth - 1;

    }

    public Node removeNthFromEnd(Node head, int n) {

        Node slow = head;
        Node fast = head;

        while (n-- > 0) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public Node swapNthNode(Node head, int n) {

        Node slow = head;
        Node fast = head;

        while (n-- > 1) {
            fast = fast.next;
        }

        Node val1 = fast;
        System.out.println(val1.val);

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node val2 = slow;
        System.out.println(val2.val);

        return head;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        if (index == 0) {
            if (head != null) {
                head = head.next;
                size--;
            }
            return;
        }

        Node current = head;
        Node prev = null;
        int i = 0;

        while (current != null && i < index) {
            prev = current;
            current = current.next;
            i++;
        }

        if (current != null) {
            prev.next = current.next;
        }
    }
    
    public void insertionSort(){
        Node dummyHead = new Node();
        dummyHead.next = head;
        Node check = dummyHead;
        Node i = dummyHead.next;
        Node j = i.next;
        
        while(i != null && j != null){
            
            while(check.next != i.next){
                if(j.val<=check.next.val){ 
                    i.next = j.next;
                    j.next = check.next;
                    check.next = j;
                    break;
                }
                check = check.next;
            }
            if(i.next == j){
            i = i.next;
            }
            j = i.next;
            check = dummyHead;
        }
        head = dummyHead.next;
    }
    
    public void mergeInBetweenList(Node list1,Node list2,int a,int b){
        Node first = list1;
        Node second = list1;
        
        while(a-->1){
            first = first.next;
        }
        
        while(b-->0){
            second = second.next;
        }
        
        first.next = list2;
        
        while(first.next != null){
            first = first.next;
            
        }
        first.next = second.next;
        
        head = list1;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;

    }

    public class Node {

        int val = 0;
        Node next = null;

        Node() {
        }

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
