/**
* The StackLL class implements a Stack using a LinkedList.
**/
public class StackLL<T> implements Stack<T>
{
	private LinkedList<T> list; //underlying linked list
	/**
	* Constructor creates an empty StackLL
	**/
	public StackLL()
	{
		list = new LinkedList<T>();
	}

	/**
	* Tests if the stack is empty.
	* @return true if the stack is empty 
	**/
	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	/**
	* Gets the element at the top of the stack without removing it.
	* @return the peeked data
	**/
	public T peek()
	{
		return list.getFirst();
	}

	/**
	* Removes the top of the stack and returns it.
	* @return the popped data
	**/
	public T pop()
	{
		//store data in head node
		T poppedData = peek();
		//now remove it
		list.deleteFirst();
		//return popedData
		return poppedData;
	}

	/**
	* Pushes an element onto the top of the stack.
	**/
	public void push(T data)
	{
		list.insertFirst(data);
	}

	/**
	* Returns a String representation of the stack.
	* @return stack as String
	**/
	public String toString()
	{
		return list.toString();
	}	
}