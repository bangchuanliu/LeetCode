package leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

	private Map<K, Node<K, V>> map = new HashMap<>();
	private Node<K, V> head;
	private Node<K, V> tail;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public V get(K key) {
		if (map.containsKey(key)) {
			Node<K, V> node = map.get(key);
			removeNode(node);
			setHead(node);
			return map.get(key).value;
		}

		return null;
	}

	public void removeNode(Node<K,V> node) {
		if (node != null) {
			if (node.pre != null) {
				node.pre.next = node.next;
			} else {
				head = node.next;
			}

			if (node.next != null) {
				node.next.pre = node.pre;
			} else {
				tail = node.pre;
			}
		}
	}

	public void setHead(Node<K,V> node) {
		if (node != null) {
			node.next = head;
			node.pre = null;

			if (head != null) {
				head.pre = node;
			}

			head = node;

			if (tail == null) {
				tail = head;
			}
		}
	}

	public void set(K key, V value) {

		if (map.containsKey(key)) {
			Node<K,V> node = map.get(key);
			node.value = value;
			removeNode(node);
			setHead(node);
		} else {
			Node<K,V> node = new Node<K,V>(key, value);

			if (map.size() == capacity) {
				map.remove(tail.key);
				removeNode(tail);
			}
			setHead(node);
			map.put(key, node);
		}
	}

	class Node<KEY, VAL> {
		KEY key;
		VAL value;
		Node<KEY, VAL> pre;
		Node<KEY, VAL> next;

		public Node(KEY key, VAL value) {
			this.key = key;
			this.value = value;
		}
	}
}
