public class BST {
    
    class BSTNode {
        public int value;
        public BSTNode left, right;
        
        public BSTNode(int val) {
            value = val;
            left = right = null;
        }
        
        public void print() {
            if (left == null && right == null)
                System.out.printf("<%d, null, null>", value);
            else if (left == null)
                System.out.printf("<%d, null, %d>", value, right.value);
            else if (right == null)
                System.out.printf("<%d, %d, null>", value, left.value);
            else
                System.out.printf("<%d, %d, %d>", value, left.value, right.value);
        }
    }
    
    public BSTNode root;
    public int size;
    
    public BST() {
        root = null;
        size = 0;
    }
    
    public BSTNode search(int val) {
        // Complete this function.
        // Searches for val and returns the node if found, else returns NULL.
        BSTNode tmp = root;
        while(tmp != null) {
        if (tmp.value == val)
        	return tmp;
        else if (tmp.value > val)
        	tmp = tmp.left;
        else
        	tmp=tmp.right;
    }
    return null;
        
}
    
    public boolean insert(int val) {
        // Complete this function.
        // If val is present in the BST, then it returns false, and does nothing else.
        // Otherwise inserts val to the BST, and returns true.
        if (size ==0) {
        	root= new BSTNode (val);
        }
        else {
        	BSTNode tmp = root, parent = null;
        	while (tmp!= null) {
        		if (tmp.value == val) {
        			return false;
        		}
        		else if (tmp.value>val) {
        			parent = tmp;
        			tmp=tmp.left;
        		}
        		else {
        			parent = tmp;
        			tmp = tmp.right;
        		}
        	}
        	BSTNode newNode = new BSTNode (val);
		//fix right and left
			
        	if (parent.value < val)
        		parent.right=newNode;
        	else
        		parent.left =newNode;
        }
        size ++;
        return true;
    }
    
    public void print(BSTNode node) {
        if (null == node)
            return;
        else {
            node.print();
            System.out.print(" ");
        }
        print(node.left);
        print(node.right);
    }
    
    public void print() {
        print(root);
    }
    
    public static void main(String[] args) {
        BST bst = new BST();
        int arrayIns[] = { 60, 48, 29, 47, 15 };
        for (int i : arrayIns) {
            System.out.println("Adding " + i);
            bst.insert(i);
        }
        System.out.print("Tree: ");
        bst.print();
        System.out.println();
        int arraySearch[] = { 47, 29, 10, 15, 5 };
        for (int key : arraySearch) {
            if (bst.search(key) == null)
                System.out.println(key + " not found.");
            else
                System.out.println(key + " found.");
        }
        bst.insert(19);
        if (!bst.insert(15))
            System.out.println("Node 15 already exists.");
        System.out.print("Tree: ");
        bst.print();
        System.out.println();
        System.out.println("Size = " + bst.size);
    }
}