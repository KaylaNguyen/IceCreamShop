/**
* The QueueLL class implements a Queue using a LinkedList.
**/
public class QueueLL<T> implements Queue<T>
{
	private LinkedList<T> list; //underlying linked list
	/**
	* Constructor creates an empty QueueLL
	**/
	public QueueLL()
	{
		list = new LinkedList<T>();
	}

	/** 
	 * Tests if the queue is empty.
	 * @return true iff the queue is empty
	 **/
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
 
	/** 
	 * Gets the element at the front of the queue without removing it.
	 * @return the peeked data
	 **/
	public T peek()
 	{
		// if the list is empty
		if(list.isEmpty())
			return null;
		else
			return list.getLast();
 	}

	/**
	 * Removes the front element of the queue and returns it.
	 * @return the dequeued data
	 **/
	public T dequeue() {
		// if the list is not empty
		if (list.isEmpty()) {
			return null;
		}
		else {
			// store data in head node
			T poppedData = peek();
			// now remove it
			if(list.size() == 1)
				list.deleteFirst();
			else
				list.deleteLast();
			// return popedData
			return poppedData;
		}
	}
 
	/**
	 * Adds an element to the end of the queue.
	 **/
	public void enqueue( T data )
	{
		list.insertFirst(data);
	}
 
	/** 
	 * Returns a String representation of the queue.
	 * @return queue as String
	 **/
	public String toString()
	{
		return list.toString();
	}
}