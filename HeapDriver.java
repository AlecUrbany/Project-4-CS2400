public class HeapDriver.java
{
    public static void main(String args[])
        {

            int arr[] = { 4,6,3,2,1,10,19,30,29,34,100,99,98,94};

            int n = arr.length;

            buildHeap(arr, n);

            printHeap(arr, n);
            System.out.println("The total swap count is "+swapCount);	
            
        }
}
