package DataStructure.linkedlist;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 * @Auther: tinntetuki
 */
public class LinkedListAlgo {
    // 单链表反转
    public static Node reverse(Node list){
        Node cur = list, pre = null;
        while (cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 检测环
    public static boolean checkCircle(Node list){
        if (list == null) {
            return false;
        }
        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 合并两个链表
     * @param n1
     * @param n2
     * @return
     */
    public Node mergeTwoLists(Node n1, Node n2){
        Node soldier = new Node(0);
        Node p = soldier;
        while (n1 != null && n2!= null) {
            if (n1.data < n2.data) {
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        if (n1 != null) {
            p.next = n1;
        }
        if (n2 != null) {
            p.next = n2;
        }
        return soldier.next;
    }

    /**
     * 删除倒数第K个结点
     * @param list
     * @param k
     * @return
     */
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k){
            fast = fast.next;
            ++i;
        }
        if (fast == null) {
            return list;
        }

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }

        return list;
    }

    /**
     * 查找中间节点
     * @param list
     * @return
     */
    public static Node findMiddleNode(Node list) {
        if (list == null){
            return null;
        }

        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node {
        private int data;
        private Node next;

        public Node (int x){
            this.data = x;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        Node list = new Node(1, new Node(2, new Node(3, null)));
        Node pre = reverse(list);
        System.out.println(pre);
    }
}
