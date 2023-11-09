
public class BST {
	public Node root;
	public int time;// The root node of the tree.

	public BST() {
		root = null;
	}

	/**
		Inserts a time, along with the req_id. The tree is keyed on time, while req_id provides a pointer to the request.
		This is a public wrapper function that calls the recursive insert method.
		Note that the insert method should return the root node of the subtree in which we insert the key (and its value).
	**/
	public void insert(int time, int req_index) {
        // TODO: Code for insert here.
        root = insert(root, time, req_index);

    }

    private Node insert(Node t, int time, int req_index) {
        if (t == null) {
            return new Node(time, req_index);
        }
        if (time < t.getTime()) {
            t.setLeft(insert(t.getLeft(), time, req_index));
        } else {
            t.setRight(insert(t.getRight(), time, req_index));
        }
        return t;
    }

	/**
		Returns a pointer to the Node that is the predecessor of time. The predecessor element is the largest
		element within the tree that is smaller or equal to time. This is the deepest ancestor with this property.
		Please return the predecessor element. You may return null if time does not have a predecessor.
	**/
	public Node pred(int time) {
        // TODO: code for pred here.
        Node head = root;
        Node tail = null;
        while (head != null) {
            int t = head.getTime();
            if (t <= time) {
                tail = head;
                head = head.getRight();
            } else {
                head = head.getLeft();
            }
        }
        return tail; // Replace this line with returning the actual predecessor.
    }

    /**
     * Returns a pointer to the Node that is the successor of time. The successor
     * element is the largest
     * element within the tree that is larger or equal to time. This is the deepest
     * ancestor with this property.
     * Please return the successor element. You may return null if time does not
     * have a successor.
     **/
    public Node succ(int time) {
        // TODO: code for succ here.
        Node head = root;
        Node tail = null;
        while (head != null) {
            int t = head.getTime();
            if (t >= time) {
                tail = head;
                head = head.getLeft();
            } else {
                head = head.getRight();
            }
        }
        return tail;
        // Replace this line with returning the actual successor.
    } 	

	/**
		Returns a pointer to the Node that is the successor of time. The successor element is the largest
		element within the tree that is larger or equal to time. This is the deepest ancestor with this property.
		Please return the successor element. You may return null if time does not have a successor.
	**/
	

	/**
		Returns the minimum element in the binary search tree or null if the tree is empty.
	**/
	public Node min() {
		// TODO: Code for min here.
		return min(root); // Replace this line with returning the actual minimum.
	}
	
	public Node min(Node t) {
		if (t.getLeft() == null) {
			return t;
		}
		else {
			return min(t.getLeft());
		}
	}

	/**
		Returns the maximum element in the binary search tree or null if the tree is empty.
	**/
	public Node max() {
		// TODO: Code for max here.
		return max(root); // Replace this line with returning the actual maximum.
	}
	
	// recursive 
	public Node max(Node t) {
		if (t.getRight() == null) {
			return t;
		}
		else {
			return max(t.getRight());
		}
	}

	/**
		Remove the node that contains this time. If this time is not present in the structure, this method does nothing.
	**/
	public void delete(int time) {
        // TODO: Code for delete here.
        delete(root, time);
    }

    public Node delete(Node i, int time) {
    	if (i == null) {
            return i;
    	}
    	else if (time > i.getTime()) {
            i.setRight(delete(i.getRight(), time));
            return i;
    	}
    	else if (time < i.getTime()) {
            i.setLeft(delete(i.getLeft(), time));
            return i;
    	}
    	else {
            if (i.getLeft() == null && i.getRight() == null) {
            	//node with no child
            	i = null;
            	return i;
            }
            //node with no right child
            if (i.getLeft() != null && i.getRight() == null) {
                    return i.getLeft();
            }
            //node with no left child
            if (i.getLeft() == null && i.getRight() != null) {
                    return i.getRight();
            }
            // 2 children test
            if (i.getLeft() != null && i.getRight() != null) {
                    Node chil2 = pred(i.getTime());
                    i.setTime(chil2.getTime());
                    i.setReq_index(chil2.getReq_index());
            Node d = delete(i.getLeft(), i.getTime());
            i.setLeft(d);
            return i;
            }

    	}
    	return i;
}

	/**
		Prints the contents of the tree in sorted order.
	**/
	public void print() {
		// TODO: Code for print here.
		print(root);
	}
	
	public void print(Node t) {
		if (t != null) {
			print(t.getLeft());
			System.out.println(t.getTime() + " ");
			print(t.getRight());
		}
		else {
			return;
		}
	}
	
	// adding a find method to use for delete
	public Node find(int time) {
		return find(root, time);
	}
	
	private Node find(Node n, int time) {
		if (n == null) {
			return null;
		}
		if (n.getTime() == time) {
			return n;
		}
		if (time < n.getTime()) {
			return find(n.getLeft(), time);
		}	
		return find(n.getRight(), time);
	}

	public boolean valid(int time, int n) {
		if (root == null) {
			return true;
		}
		return valid(root, time, n);
	}
	
	public boolean valid(Node t, int time, int n) {
		if (t == null) {
			return true;
		}
		if ((t.getTime() - time) < n) {
			return false;
		}
		if ((t.getTime() - time) >= n) {
			return valid(t.getLeft(), time, n);
		}
		if (t.getTime() < time) {
			return valid(t.getRight(), time, n);
		}
		return false;
	}
	

}
