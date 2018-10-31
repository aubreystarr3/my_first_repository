public class LinkedList {
    
    class ListNode {
        
        public int value;
        public ListNode next;
        
        public ListNode(int val) {
            value = val;
            next = null;
        }
    }
    
    public ListNode head, tail;
    public int size;
    
    public LinkedList() {
        head = tail = null;
        size = 0;
    }
    
    public void insertAfter(ListNode argNode, int value) {
       ListNode newNode= new ListNode (value);
       if( size == 0) {
    	   head = tail = newNode;
    	   argNode.next = tail;
    	   tail = newNode.next;
       }
       else {
    	   newNode.next=argNode.next;
    	  argNode.next= newNode;
    	  
       if (argNode== tail) {
    	   tail = newNode;
       }
       size++;
       }
    			  
      }
   
    
    public void deleteAfter(ListNode argNode) {
        // Complete this function.
        // Deletes the node after argNode.
        if (argNode == tail) {
            System.out.println("Cannot delete after tail.");
        } else if (argNode.next == tail) {
           	argNode = tail = null;
        		tail = argNode;
        		size --;
        }
        		else {
         	ListNode temp = argNode.next;
        		argNode.next= temp.next;
        		//remove the link from temp and temp.node
        		temp = null;
        		//assign temp to null
        	size --;
            
        }
    }
    
    public int search(int key) {
        // Complete this function.
        // Returns the first position where key is found.
        // If key is not found, returns -1
    	//set heard to new node
    		ListNode newNode = head;
    		int index=0;
    		//create a loop to go through linked list
    		while(newNode!=null) {
    			if(newNode.value == key)
    			 		return index;
    			else {
    				newNode=newNode.next;
    				index ++;
    			}
    		}
    	
  return -1;
    		
    }
    
    ListNode insertAtFront(int value) {
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return newNode;
    }
    
    ListNode insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return newNode;
    }
    
    void deleteHead() {
        if (0 == size) {
            System.out.println("Cannot delete from an empty list.");
        } else if (1 == size) {
            head = tail = null;
            size--;
        } else {
            size--;
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
            tmp = null;
        }
    }
    
    public ListNode getNodeAt(int pos) {
        if (pos < 0 || pos >= size || 0 == size) {
            System.out.println("No such position exists.");
            return null;
        } else {
            ListNode tmp = head;
            for (int i = 0; i < pos; i++)
                tmp = tmp.next;
            return tmp;
        }
    }
    
    void printList() {
        if (size == 0)
            System.out.println("[]");
        else {
            ListNode tmp = head;
            String output = "[";
            for (int i = 0; i < size - 1; i++) {
                output += tmp.value + " -> ";
                tmp = tmp.next;
            }
            output += tail.value + "]";
            System.out.println(output);
        }
    }
    
    public int getSize() {
        return size;
    }
    
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        
        list.insertAtFront(5);
        System.out.print("Inserting 5 at front. Current list: ");
        list.printList();
        
        list.insertAtEnd(32);
        System.out.print("Inserting 32 at end. Current list: ");
        list.printList();
        
        list.insertAtFront(16);
        System.out.print("Inserting 16 at front. Current list: ");
        list.printList();
        
        list.insertAfter(list.getNodeAt(1), 61);
        System.out.print("Inserting 61 after position 1. Current list: ");
        list.printList();
        
        list.insertAfter(list.tail, 99);
        System.out.print("Inserting 99 after tail. Current list: ");
        list.printList();
        
        int pos = list.search(61);
        if (pos > -1)
            System.out.println("Found 61 at position " + pos);
        pos = list.search(66);
        if (pos == -1)
            System.out.println("Did not find 66.");
        
        list.deleteAfter(list.getNodeAt(1));
        System.out.print("Deleting after position 1. Current list: ");
        list.printList();
        
        list.deleteAfter(list.getNodeAt(2));
        System.out.print("Deleting after position 2. Current list: ");
        list.printList();
        
        System.out.print("Trying to delete after position 2: ");
        list.deleteAfter(list.getNodeAt(2));
    }
}