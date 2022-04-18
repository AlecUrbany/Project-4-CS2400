import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Java program for building Heap from Array
public class fileReader
{

    public static void main (String args[]) throws FileNotFoundException
    {

        File unsortedData = new File("data_random.txt");
        int i = 0; 
        int array[];
        array = new int[100];
	    try (Scanner scanFile = new Scanner(unsortedData))
        {
            array[i] = scanFile.nextInt();
            while (scanFile.nextLine() != null)
            {
                System.out.println(array[i]);
                array[i] = scanFile.nextInt();
            }

        }
    }
}