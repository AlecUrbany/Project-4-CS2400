import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.sql.Array;
import java.io.FileWriter;
public class BuildHeap 
{
	private static int size;
	private int[] arr;
	private static int arraycopy;

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
		public static void buildheap2(int arr[], int n)
		{
			size= arr.length;
			
			arr= new int[arraycopy];
			
			for(int i=0;i<arr.length;i++)
			{
				arr[i] = arr[i];	
			}
			 for(int i=(arr.length)/2;i>=0;i--){
            heapify(arr, n, i);
        }
		}

	public int removeHeap()
	{
		if (this.size<1)
			return -1;
		int temp = this.arr[0];
		this.arr[0] = this.arr[size-1];
		this.arr[size-1] = temp;
		size--;
		return this.arr[size];
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
	public static void main(String args[]) throws FileNotFoundException
	{
		//File parser
		File unsortedData = new File("data_random.txt");
        int i = 0; 
        int ii = 0;
        int array[];
        array = new int[100];
	    try (Scanner scanFile = new Scanner(unsortedData))
        {
            array[i] = scanFile.nextInt();
            while (scanFile.hasNextInt())
            {
                array[i] = scanFile.nextInt();
				i++;
            }

		int n = array.length;

		buildHeap(array, n);
		printHeap(array, n);
		System.out.println("THIS IS BUILD HEAP 2 BELOW");
		
		buildheap2(array, n);

		printHeap(array, n);
		System.out.println("The total swap count is "+swapCount);	
		//File maker
		// FileWriter output = null;
		// try 
		// {
		//   output = new FileWriter("heapOutput.txt");
		// 	for (String line : lines)
		// 	{
		// 		output.write(line + "\n");
		// 	}
		// } 
		// catch (IOException error) 
		// {
		//   System.out.println("Oopsies, there's a mistake");
		//   error.printStackTrace();
		// }
		}
	}

	
	
}

