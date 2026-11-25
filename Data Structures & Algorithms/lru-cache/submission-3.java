class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer,Node>map ;
    public LRUCache(int capacity) {
     this.map = new HashMap<>();
     this.capacity = capacity;
     head = new Node(0,0);
     tail = new Node(0,0);
     head.next = tail;
     tail.prev = head;
    }
    private void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    private void insert(Node node){
         Node nextNode = head.next;
         head.next = node;
         node.prev = head;
         node.next = nextNode;
         nextNode.prev = node;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node =map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            node.value = value;
            insert(node);
            return;
        }
        Node node = new Node(key,value);
        insert(node);
        map.put(key,node);
        if(map.size()>capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
