package com.tinntetuki.datastructure.stack;

/**
 * 数据结构-基于链表实现的栈
 *
 * @author tinntetuki
 * @since 2020/7/13
 */
public class StackBasedOnLinkedList {

    private static Node top = null;

    public void push (int value) {
        Node newNode = new Node(value, null);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
    }

    public int pop () {
        if (top == null) {
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        StackBasedOnLinkedList stackBasedOnLinkedList = new StackBasedOnLinkedList();
        stackBasedOnLinkedList.push(1);
        stackBasedOnLinkedList.push(2);
        stackBasedOnLinkedList.push(3);
        stackBasedOnLinkedList.printAll();

        System.out.println(stackBasedOnLinkedList.pop());
        System.out.println(stackBasedOnLinkedList.pop());
        stackBasedOnLinkedList.printAll();
    }
}
