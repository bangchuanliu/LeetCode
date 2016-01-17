package leetcode.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackbyQueues {
	
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();
	
	// Push element x onto stack.
	public void push(int x) {
		if (!q2.isEmpty()) {
			q2.offer(x);
		} else {
			q1.offer(x);
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (!q2.isEmpty()) {
			int size = q2.size();
			for (int i = 0; i < size - 1; i++) {
				q1.offer(q2.poll());
			}
			q2.poll();
		} else if (!q1.isEmpty()) {
			int size = q1.size();
			for (int i = 0; i < size - 1; i++) {
				q2.offer(q1.poll());
			}
			q1.poll();
		} 
	}

	// Get the top element.
	public int top() {
		if (!q2.isEmpty()) {
			int size = q2.size();
			for (int i = 0; i < size - 1; i++) {
				q1.offer(q2.poll());
			}
			int top = q2.poll();
			q1.offer(top);
			return top;
		} else if (!q1.isEmpty()) {
			int size = q1.size();
			for (int i = 0; i < size - 1; i++) {
				q2.offer(q1.poll());
			}
			int top = q1.poll();
			q2.offer(top);
			return top;
		}else {
			return 0; // or throw exception
		} 
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();
	}
}
