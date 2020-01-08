import java.util.*;

// Name : «„√§∏≤
// Student ID : 20181707

@SuppressWarnings("unchecked")
class BST <T extends Key> {

	class TreeNode <U extends Key> {
		U data;	// storage for data : in HW 3, T will be Item
		TreeNode<U> leftChild;	// link to the left Child
		TreeNode<U> rightChild;	// link to the right Child

		// constructors come here
		TreeNode() {
			leftChild = rightChild = null;
		}
		TreeNode(U d) {
			// data is given
			data = d;
			// the leftChild and rightChild field are null
			leftChild = rightChild = null;
		}
	};

	TreeNode <T> root;// the reference to the root node

	BST() {
		// BST constructor.
		root = null;
	}

	void Show() {
		System.out.print("In   Order : ");
		InOrder(root);
		System.out.println("");
	}

	// IMPLEMENT THE FOLLOWING FUNCTIONS

	boolean  Insert(T item)  {
		// first search the key
		if(root == null) {
			root = new TreeNode(item);
			return true;
		}

		TreeNode<T> parent;
		parent = root;
		while(true){
			if(item.GetKey()==parent.data.GetKey()){
				return false;
			}if(item.GetKey() < parent.data.GetKey()){
	      if(parent.leftChild == null) {
	          // System.out.println("<-");
	          parent.leftChild = new TreeNode(item);
	          return true;
	      } else {
	          parent = parent.leftChild;
	          continue;
	      }
	  } else {
	      if(parent.rightChild == null) {
	          // System.out.println("->");
	          parent.rightChild = new TreeNode(item);
	          return true;
	      } else {
	          parent = parent.rightChild;
	          continue;
	      }
		  }
    }

	}

	TreeNode Get(T item)  {
		// use the key field of item and find the node
		// do not use val field of item
		TreeNode<T> ptr;
		ptr = root;
		// System.out.println(root.data.GetKey());
		// System.out.println(root.leftChild.data.GetKey());
		// System.out.println(root.rightChild.data.GetKey());
		while(true){
			if(item.GetKey()==ptr.data.GetKey()){
				return ptr;
			}
			if(item.GetKey()<ptr.data.GetKey()){
				if(ptr.leftChild ==null){
					return null;
				}else{
					ptr = ptr.leftChild;
					continue;
				}
			}else {
				if(ptr.rightChild==null){
					return null;
				}else{
				ptr = ptr.rightChild;
				continue;
			}
			}
		}

	}


	boolean Delete(T item)  {
		if(root == null)
	    return true;	// non existing key
	  TreeNode<T> ptree, temp, parent;
	  // boolean lt = false;
		temp = Get(item);
	  ptree = Get(item);
		parent = Get(item);
		if (Get(item)==root&&(root.leftChild==null||root.rightChild==null)){
			if (root.leftChild==null){
				root = root.rightChild;
				return true;
			}else {
				root = root.leftChild;
				return true;
			}
		}
		if(Height(ptree.leftChild)>Height(ptree.rightChild)){
			if(ptree.rightChild==null){
				parent = Parent(ptree);
				if(parent.leftChild==ptree) {
					parent.leftChild=ptree.leftChild;
				}
				else {
					parent.rightChild=ptree.leftChild;
				}return true;
			}
			temp = Max(ptree.leftChild);
			Delete(temp.data);
			Get(item).data = temp.data;
			// ptree.data = temp.data;
			// temp.data = parent.data;
			// Delete(parent.data);
		}else if(Height(ptree.leftChild)<Height(ptree.rightChild)){
			if(ptree.leftChild==null){
				parent = Parent(ptree);
				if(parent.leftChild==ptree){
					parent.leftChild=ptree.rightChild;
				}else {
					parent.rightChild=ptree.rightChild;
				}return true;
			}
			temp = Min(ptree.rightChild);
			Delete(temp.data);
			Get(item).data = temp.data;
		}else{
			if(Count(ptree.leftChild)>=Count(ptree.rightChild)){
				if(ptree.leftChild==null&&ptree.rightChild==null){
					parent = Parent(ptree);
					if(parent.leftChild==ptree){
						parent.leftChild=null;
					}else{
						parent.rightChild=null;
					}return true;
				}
				temp = Max(ptree.leftChild);
				Delete(temp.data);
				Get(item).data = temp.data;
			}else if(Count(ptree.leftChild)<Count(ptree.rightChild)){
				temp = Min(ptree.rightChild);
				Delete(temp.data);
				Get(item).data = temp.data;
			}
		}return true;
	}

	void  InOrder(TreeNode<T> t)  {
		if(t != null){
	   InOrder(t.leftChild);
	   System.out.print( "[" + t.data.GetKey() + "]" );
	   InOrder(t.rightChild);
	 }
	}

	int  Count(TreeNode<T> t)  {
		if(t==null) return 0;
			return 1+Count(t.leftChild)+Count(t.rightChild);
	}
	TreeNode Max(TreeNode<T> t) {
		if(t.rightChild==null) return t;
		while(t.rightChild!=null){
			t = t.rightChild;
		}return t;
	}
	TreeNode Min(TreeNode<T> t) {
		if(t.leftChild==null) return t;
		while(t.leftChild!=null){
			t = t.leftChild;
		}return t;
	}
	int  Height(TreeNode<T> t)  {
		if(t == null) return 0;
        return 1 + Math.max(Height(t.leftChild), Height(t.rightChild));
	}
	TreeNode Parent(TreeNode<T> t){
		if (t==root) return root;	// non existing key
	  TreeNode<T> parent, ptree;
		ptree = root;
		parent = root;
		while(true){
			if(t.data.GetKey()<ptree.data.GetKey()){
	      parent = ptree;
	      ptree=ptree.leftChild;
	      continue;
	    }else if(t.data.GetKey()>ptree.data.GetKey()){
	      parent = ptree;
	      ptree = ptree.rightChild;
	      continue;
	    }else return parent;
	}
}
}
