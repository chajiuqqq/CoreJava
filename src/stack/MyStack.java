package stack;

import java.util.LinkedList;

public class MyStack<T> implements Stack<T> {
	LinkedList<T> stackList;
	public MyStack() {
		stackList=new LinkedList<T>();
	}
	@Override
	public synchronized void push(T elem) {
		stackList.addLast(elem);;
	}

	@Override
	public synchronized T pull() {
		T temp=stackList.removeFirst();
		return temp;
	}

	@Override
	public synchronized T peek() {
		T temp=stackList.getFirst();
		return temp;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stackList.size();
	}
	
}
