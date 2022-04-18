
public class BuildHeap {

	// To heapify a subtree rooted with node i which is
	// an index in arr[].Nn is size of heap
	
 static int swapCount=0;
	static void heapify(int arr[], int n, int i)
	{
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2
		
		// If left child is larger than root
		if (l < n && arr[l] > arr[largest]){
			largest = l;
			swapCount++;
		}
		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest]){
			largest = r;
			swapCount++;
		}
		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			
			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
			swapCount++;
		}
		
	}
	
	// Function to build a Max-Heap from the Array
	static void buildHeap(int arr[], int n)
	{
		
		// Index of last non-leaf node
		int startIdx = (n / 2) - 1;

		// Perform reverse level order traversal
		// from last non-leaf node and heapify
		// each node
		for (int i = startIdx; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

	// A utility function to print the array
	// representation of Heap
	static void printHeap(int arr[], int n)
	{
		System.out.println("Array representation of Heap is:");
		
		for (int i = 0; i < 10; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
		
	}

	// Driver Code
	public static void main(String args[])
	{
	
		int arr[] = { 4,6,3,2,1,10,19,30,29,34,100,99,98,94};

		int n = arr.length;

		buildHeap(arr, n);

		printHeap(arr, n);
		System.out.println("The total swap count is "+swapCount);	
		
	}
}