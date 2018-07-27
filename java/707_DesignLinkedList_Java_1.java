class MyLinkedList {
    Node head;
    Node tail;
    int length;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
        length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < length) {
            Node cur = head;
            
            for (int i = 0; i < index; ++i) {
                cur = cur.next;
            }
            
            return cur.next.val;
        }
        else {
            return -1;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node tmp = new Node(val, head.next, head);
        tmp.next.prev = tmp;
        head.next = tmp;
        
        length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node tmp = new Node(val, tail, tail.prev);
        tmp.prev.next = tmp;
        tail.prev = tmp;
        
        length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index >= 0 && index < length) {
            Node cur = head;
            
            for (int i = 0; i < index; ++i) {
                cur  = cur.next;
            }
            
            Node tmp = new Node(val, cur.next, cur);
            tmp.next.prev = tmp;
            cur.next = tmp;
            
            length++;
        }
        else if (index == length) {
            addAtTail(val);
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < length) {
            Node cur = head;
            
            for (int i = 0; i < index; ++i) {
                cur = cur.next;
            }
            
            cur.next = cur.next.next;
            cur.next.prev = cur;
            
            length--;
        }
    }
}
class Node {
    int val;
    Node next;
    Node prev;
    
    public Node() {
        this.val = -1;
        this.next = null;
        this.prev = null;
    }
    
    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
