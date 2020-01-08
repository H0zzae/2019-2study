import java.util.*;

interface Key {
	public int GetKey();
}

// Item Class
// this is the key-value pair
// We are going to put this pair into each node of the BinaryST
class Item implements Key {
	private int key;
	public Item(int k) {key = k;};
	Item() {key = -1;};
	public int GetKey() { return key;}
};



@SuppressWarnings("unchecked")
class LabTest {
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		BST<Item> bst = new BST<Item>();
		while(true) {
			System.err.print("BST > ");
			String command;
			command = in.next();
			if(command.equals("quit"))
				break;	// stop the program
        	else if(command.equals("ins")) {
				int key = in.nextInt();
				if(bst.Insert(new Item(key)) == false)
					System.out.println("Key Exists");
			} else if(command.equals("del")) {
				int key = in.nextInt();;
				if(bst.Delete(new Item(key)) == false);
					System.out.print("");
			}

			// show the current binary search tree
			bst.Show();
		}
	}
}
