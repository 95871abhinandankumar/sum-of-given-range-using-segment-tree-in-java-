
// I think there is no need to explain
// code is self explanatory

class Node{
	int li;
	int ri;
	int sum;
	Node left, right;
	
	Node(int li,  int ri){
		this.li = li;
		this.ri = ri;
		
		this.sum = 0;
		this.left = null;
		this.right = null;
	}
	
	Node(int li, int ri, int sum)
	{
		this.li = li;
		this.ri = ri;
		
		this.sum = sum;
		this.left = null;
		this.right = null;
	}
	
}

class SegmentTree{
	
	Node root;
	
	SegmentTree(int[] arr){
		this.root = createTree(arr, 0, arr.length-1);
	}
	
	Node createTree(int [] arr, int li, int ri)
	{
		
		if(li == ri)
		{
			return new Node(li, ri, arr[li]);
		}
		
		Node root = new Node(li, ri);
		
		root.left = createTree(arr, li, (li+ri)/2);
		root.right = createTree(arr, (li+ri)/2 +1, ri);
		
		root.sum = root.left.sum + root.right.sum;
		
		
		return root;
	}
	
	int findSum(Node root,  int li , int ri){
		int sum =0;
		
		if(root.li == li && root.ri == ri)
		{
			return root.sum;
		}
		
		if(ri <= (root.li + root.ri)/2)
		{
			return findSum(root.left, li, ri);
		}
		
		if(li >= (root.li + root.ri )/2 + 1)
		{
			return findSum(root.right, li, ri);
		}
		
		if(li <= (root.li + root.ri)/2 && ri >= (root.li + root.ri )/2 + 1)
		{
			return findSum(root, li, (root.li + root.ri)/2) + findSum(root, (root.li + root.ri )/2 + 1, ri);
		}
		
		return sum;
	}
	
	void updateArray(Node root, int index, int diff)
	{
		if(root.li == index && root.ri == index)
		{
			root.sum += diff;
			return;
		}
		
		if(index <= (root.li + root.ri)/2) {
			updateArray(root.left, index, diff);
			root.sum += diff;
		}else {
			updateArray(root.right, index, diff);
			root.sum += diff;
		}
	}
	
	void displayTree(Node root) {
		if(root == null)
			return;
		
		System.out.println("left-index : " + root.li + " right-index : " + root.ri + " sum : " + root.sum);
		displayTree(root.left);
		displayTree(root.right);
	}
	
}

public class SumOfGivenRange {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4, 5, 6, 7};
		
		SegmentTree st = new SegmentTree(arr);
		
		st.displayTree(st.root);
		
		System.out.println(st.findSum(st.root, 6, 6));
		
		int diff = 10-arr[2];
		arr[2] = 10;
		st.updateArray(st.root, 2, diff);
		
		st.displayTree(st.root);

	}

}
