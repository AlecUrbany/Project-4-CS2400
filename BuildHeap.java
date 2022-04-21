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
		
		//Cited From Geeks For Geeks 
		//https://www.geeksforgeeks.org/binary-heap/
		//THIS WAS NOT OUR CODE. WE UNDERSTAND HOW THEY DID IT, AND WHY. WE DID NOT WRITE IT. 
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // equation for the left node is 2*i+1, i being the node that is the root. and 
		int r = 2 * i + 2; // equation for the right node 
		
		// Checks for left child being bigger than largest
		if (l < n && arr[l] > arr[largest]){
			largest = l;
			swapCount++;
		}
		// Checks for right child being bigger than largest
		if (r < n && arr[r] > arr[largest]){
			largest = r;
			swapCount++;
		}
		// If statement to see if largest is larger than root.
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
		//This is a for loop that will make it so we remove 10 items. You can also just remove this for loop so it only removes once
		for (int i = 0; i < 10; i++)
		{
			//Sets up the last item in the stack
			int lastItem = arr[n-1];
			
			//Sets the first array as the last item in the stack
			arr[0] = lastItem;
			n = n - 1;
			// Calls heapify to fix this abomination we've just created.
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
		
		// Index position of last node
		int startIdx = (n / 2) - 1;


		for (int i = startIdx; i >= 0; i--) 
		{
			heapify(arr, n, i);
		}
	}
	 static int swapCount2;
	 //our attempt at making the O(n) binary heap sort algorithm
	 // Creates and array and uses that to push it into heapify. 
		public static void buildheap2(int arr2[], int n)
		{
			size= arr2.length;
			
			arr2= new int[arraycopy];
			
			
            for(int i=0;i<arr2.length;i++)
			{
				arr2[i] = arr2[i];	
                
			}
			 for(int i=(arr2.length)/2;i>0;i--){
                heapify(arr2, i, i);
        }
		}

	// print funcitonality
	static void printHeap(int arr[], int n)
	{
		System.out.print("Heap built using NOT optimal method: ");
		
		for (int i = 0; i < 10; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
		
	}
	static void printHeap2(int arr2[], int n)
	{
		System.out.print("Heap built using optimal method: ");
		
		for (int i = 0; i < 10; ++i)
			System.out.print(arr2[i] + " ");

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
		File unsortedData2 = new File("data_random.txt");
        int i = 0; 
        int array[];
		int array2[];
        array = new int[100];
		array2 = new int[100];
	    try (Scanner scanFile = new Scanner(unsortedData))
        {
            array[i] = scanFile.nextInt();
            while (scanFile.hasNextInt())
            {
                array[i] = scanFile.nextInt();
				i++;
            }
		int n = array.length;
		/*
		Our printable statements. Pulling the swapcount variable value and using that as the counter for the amount of swaps
		we got stuck on why our 2nd buildheap wouldnt print out a different value. We figured it is due to the fact that our 
		heapify is the same code. We dont know how else to write it and we were thinking about it until 11:40 PM on the night of its due date.
		wario is cool :/
		*/
		System.out.println("=====================================================================");
		buildHeap(array, n);
		printHeap(array, n);
		System.out.println("Number of swaps in the heap creation: "+swapCount);
		swapCount=0;
		removeHeap(array, n);
		System.out.println("Number of swaps in the heap removal code "+swapCount);

		System.out.println("\nTHIS IS BUILD HEAP 2 BELOW:");
		swapCount=0;
		buildheap2(array, n);
		printHeap2(array, n);
		System.out.println("Number of swaps in the heap creation: "+swapCount);
		swapCount=0;
		removeHeap(array, n);
		System.out.println("Number of swaps in the heap removal code "+swapCount);
		System.out.println("=====================================================================");	
		}
	}
}

