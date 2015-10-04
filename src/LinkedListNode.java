/**
* LinkedListNode<T> class
**/

public class LinkedListNode<T>
{
	//INSTANCE FIELD
	//data stored in the node
	private T data;
	//pointer to the next node
	private LinkedListNode<T> next;

	//METHODS
	/**
	 * Get the data stored at this node.
	 **/
	public T getData()
	{
		return data;
	}
	 
	/**
	 * Set the data stored at this node.
	 **/
	public void setData( T data )
	{
		this.data = data;
	}
	 
	/**
	 * Get (pointer to) next node.
	 **/
	public LinkedListNode<T> getNext()
	{
		return next;
	}
	 
	/**
	 * Set the next pointer to passed node.
	 **/
	public void setNext( LinkedListNode<T> node )
	{
		next = node;
	}
	 
	/**
	 * Returns a String representation of this node.
	 **/
	public String toString()
	{
		return data.toString();
	}
}