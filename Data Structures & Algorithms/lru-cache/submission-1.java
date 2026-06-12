class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void remove(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }
    private void insert(Node curr) {
        Node last = tail.prev;

        last.next = curr;
        curr.next = tail;
        curr.prev = last;
        tail.prev = curr;
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            remove(curr);
            insert(curr);
            return curr.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;

            Node curr = map.get(key);

            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            Node last = tail.prev;

            last.next = curr;
            curr.prev = last;
            curr.next = tail;
            tail.prev = curr;
        } else if (capacity > 0) {
            Node prev = tail.prev;
            Node curr = new Node(key, value);
            prev.next = curr;
            curr.next = tail;
            tail.prev = curr;
            curr.prev = prev;
            map.put(key, curr);
            capacity--;
        } else {
            map.remove(head.next.key);

            head.next = head.next.next;
            head.next.prev = head;

            Node prev = tail.prev;
            Node curr = new Node(key, value);

            prev.next = curr;
            curr.next = tail;
            tail.prev = curr;
            curr.prev = prev;

            map.put(key, curr);
        }
    }
}
