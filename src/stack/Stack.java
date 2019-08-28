package stack;

public interface Stack<T> {
	public void push(T elem);
	public T pull();
	public T peek();
	public int size();
}
