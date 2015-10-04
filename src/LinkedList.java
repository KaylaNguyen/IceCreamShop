/**
* LinkedList<T>
**/
public class LinkedList<T>
{	
	
	// INSTANCE FIELD
	// hold the head node
	private LinkedListNode<T> head;
	// hold the numbers of indices in list
	private int listSize;

	//CONSTRUCTOR
    public LinkedList() {
        // initiate head
        //head = new LinkedListNode<T>();
        head = null;
        //set the size to 0
        listSize = 0;
    }
    
	//METHODS
	/**
	 * Get data stored in head node of list.
	 **/
	public T getFirst()
	{
		return head.getData();
	}
	 
	/**
	 * Get the head node of the list.
	 **/
	public LinkedListNode<T> getFirstNode()
	{
		return head;
	}
	 
	/**
	 * Get data stored in tail node of list.
	 **/
	public T getLast()
	{
		return getLastNode().getData();
	}
	 
	/**
	 * Get the tail node of the list.
	 **/
	public LinkedListNode<T> getLastNode()
	{
		//if the list is empty
		if(isEmpty()){
			return null;
		}
		//if the head is the last node
		if(head.getNext() == null){
			//return head
			return head;
		}
		
		//set current node to head node
		LinkedListNode<T> currentNode = head;
		//while there's next node
		while (currentNode.getNext()!=null){
			//current node becomes next node
			currentNode = currentNode.getNext();
		}
		//return the final node in list
		return currentNode;
	}
	 
	/**
	 * Insert a new node with data at the head of the list.
	 **/
	public void insertFirst( T data )
	{
		//make a new node to insert it
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		//add data to the node
		newNode.setData(data);
		//link up the new node by
		//have the new node point to the old current node
		newNode.setNext(head);
		//set the new node as the head
		head = newNode;	
		//increment the size of the list
		listSize++;
	}
	 
	/**
	 * Insert a new node with data after currentNode
	 **/
	public void insertAfter( LinkedListNode<T> currentNode, T data )
	{
		//make a new node to insert it
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		//add data to the node
		newNode.setData(data);
		//set the next node to be next of current node
		newNode.setNext(currentNode.getNext());
		//link up the new node by
		//have the current node point to the new node
		currentNode.setNext(newNode);	
		//increment the size of the list
		listSize++;
	}
	 
	/**
	 * Insert a new node with data at the tail of the list.
	 **/
	public void insertLast( T data )
	{
		//if the list is empty or the head is the last node
		if(isEmpty() || head.getNext() == null){
			//insert first node
			insertFirst(data);
			//increment the size of the list
			listSize++;
		}
		else
			//insert a new node after last node
			insertAfter(getLastNode(), data);
	}
	 
	/**
	 * Remove head node
	 **/
	public void deleteFirst()
	{
		//if the list is empty
		if(isEmpty())
			System.out.print("List is empty");
		else{
			//set the first node to next node
			head = head.getNext();
			//decrease the size of the list
			listSize--;
		}
	}
	 
	/**
	 * Remove tail node
	 **/
	public void deleteLast()
	{
		//hold the current node
		LinkedListNode<T> current = head;
		//loop through the list
		while (current.getNext().getNext() != null){
			current = current.getNext();
		}
		//set the last node to be null
		current.setNext(null);
		//decrease the size of the list
		listSize--;
	}
	 
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 **/
	public void deleteNext( LinkedListNode<T> currentNode )
	{
		if(currentNode != getLastNode()){
			//set next node to next next node
			currentNode.setNext(currentNode.getNext().getNext());
			//decrease the size of the list
			listSize--;
		}
	}
	 
	/**
	 * Return the number of nodes in this list.
	 **/
	public int size()
	{
		return listSize;
	}
	 
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty()
	{
		return (head == null);
	}
	 
	/**
	 * Return a String representation of the list.
	 **/
	public String toString()
	{
		//string to print out
		String printOut = "";
		//set the current node to head
		LinkedListNode<T> currentNode = head;
		//go through the list
		while (currentNode.getNext() != null){
			//add to the string
			printOut += currentNode.getData().toString() + " ";
			//set the current node to next node
			currentNode = currentNode.getNext(); 
		}
		printOut += getLastNode().getData().toString();
		return printOut;
	}
	
	/**
	 * Return a String representation of the list.
	 **/
	public LinkedListNode<T> getNode(T data){
		//if the data is the head
		if (data.equals(head.getData()))
			return head;
		//set the current node to next of head
		LinkedListNode<T> currentNode = head.getNext();
		//go through the list
		//if the current node is not null and it's not the data
        while( currentNode != null && !currentNode.getData().equals( data ) )
        	currentNode = currentNode.getNext();
        return currentNode;
	}
}