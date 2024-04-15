import java.util.ArrayList;
import java.util.Iterator;

/**
 * 706. 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * 实现 MyHashMap 类：
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 */
public class MyHashMap {
    static class Node {
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int BASE = 769;
    private ArrayList[] data;

    private int hash(int key) {
        return key % BASE;
    }

    public MyHashMap() {
        data = new ArrayList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new ArrayList<Node>();
        }
    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Node> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.getKey() == key) {
                node.setValue(value);
                return;
            }
        }
        data[h].add(new Node(key, value));
    }

    public int get(int key) {
        int h = hash(key);
        Iterator<Node> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.getKey() == key) {
                return node.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Node> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.getKey() == key) {
                iterator.remove();
                return;
            }
        }
    }
}
