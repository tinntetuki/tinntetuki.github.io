package com.tinntetuki.datastructure.queue;

/**
 * LinkedList实现队列
 *
 * @author tinntetuki
 * @since 2020/7/13
 */
public class QueueBasedOnLinkedList {
    private Node head = null;
    private Node tail = null;

    // 入队
    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    // 出队
    public String dequeue() {
        if (head == null) return null;

        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        QueueBasedOnLinkedList queueBasedOnLinkedList = new QueueBasedOnLinkedList();
        queueBasedOnLinkedList.enqueue("1");
        queueBasedOnLinkedList.enqueue("2");
        queueBasedOnLinkedList.enqueue("3");
        queueBasedOnLinkedList.printAll();
        System.out.println(queueBasedOnLinkedList.dequeue());
        System.out.println(queueBasedOnLinkedList.dequeue());
    }
}
