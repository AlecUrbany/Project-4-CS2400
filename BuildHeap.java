import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;
public class BuildHeap 
{
	private static int size;
	private int[] arr;
	private static int arraycopy;


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
	static int removeHeap(int arr[], int n)
	{
		for (int i = 0; i < 10; i++)
		{
			int lastItem = arr[n-1];

			arr[0] = lastItem;
			n = n - 1;
			heapify(arr, n, 0);
		}
		System.out.print("Heap after 10 removals: ");
		
		for (int i = 0; i < 10; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
		return n;
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
			size = arr.length;
			
			arr = new int[arraycopy];
			
			for(int i=0;i<arr.length;i++)
			{
				arr[i] = arr[i];	
			}
			 for(int i=(arr.length)/2;i>=0;i--){
            heapify(arr, n, i);
        }
		}

	// A utility function to print the array
	// representation of Heap
	static void printHeap(int arr[], int n)
	{
		System.out.print("Heap built using optimal method ");
		
		for (int i = 0; i < 10; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
		
	}

	// Driver Code
	public static void main(String args[]) throws FileNotFoundException
	{
		//File Printer
		File output = null;
		try 
		{
			output = new File("heapOutput.txt");
			PrintStream stream = new PrintStream(output);
			System.setOut(stream);
		} 
		catch (IOException error) 
		{
		  System.out.println("Oopsies, there's a mistake");
		  error.printStackTrace();
		}
		//File parser
		File unsortedData = new File("data_random.txt");
        int i = 0; 
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
		System.out.println("=====================================================================");
		buildHeap(array, n);
		printHeap(array, n);
		System.out.println("Number of swaps in the heap creation: "+swapCount);
		swapCount=0;
		removeHeap(array, n);
		System.out.println("Number of swaps in the heap removal code "+swapCount);
		System.out.println("\nTHIS IS BUILD HEAP 2 BELOW:");
		buildheap2(array, n);
		printHeap(array, n);
		System.out.println("=====================================================================");
		System.out.println("The total swap count is "+swapCount);	
		}
	}
}

