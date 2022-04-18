import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Java program for building Heap from Array
public class fileReader{

    public static void main (String args[]) throws FileNotFoundException{

         File unsortedData = new File(data_random.txt); 
	    try (Scanner scanFile = new Scanner(unsortedData)) {
            System.out.println(scanFile.nextLine());
        }
    }
}