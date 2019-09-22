import java.util.*;

class LRUCache {
    
    int capacity;
    HashMap<Integer, Node> map;
    int count;
    
    static class Node {
        Node next;
        Node previous;
        int val;
        int key;
        
        Node(int val, int key, Node next, Node previous) {
            this.val = val;
            this.key = key;
            this.next = next;
            this.previous = previous;
        }
    }
    
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0, null, null);
        tail = new Node(0, 0, null, head);
        head.next = tail;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        cache.get(2);
        cache.get(3);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // how ot update the Deque
        // need a way to find, remove ana add back in constant time
        
        Node current = removeKey(key);
        
        addToTail(current);

        System.out.println(current.previous.val);
        System.out.println(current.next.val);
        
        return current.val;
    }
    
    public void put(int key, int value) {
        Node node = null;
        
        if (!map.containsKey(key)) {
            count++;
            node = new Node(value, key, null, null);
            map.put(key, node);
        } else {
            node = removeKey(key);
            node.val = value;
        }
        
        if (count > capacity) {

            System.out.println("in count" + head.next.key);
            
            Node current = removeKey(head.next.key);
            
            map.remove(current.key);
            
            // remove is an action to perform
            // contains, equals, has is querying states
            count--;
        }
        
        addToTail(node);
    }
    
    Node removeKey(int key) {
        Node current = map.get(key);

   
        System.out.println("remove val" + current.val);
        System.out.println(current.previous.val);
        System.out.println(current.next.val);
        
        current.previous.next = current.next;
        current.next.previous = current.previous;
        return current;
    }
    
    void addToTail(Node current) {
        tail.previous.next = current;
        current.previous = tail.previous;
        current.next = tail;
        tail.previous = current;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */