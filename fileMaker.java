import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
public class fileMaker 
{
    public static void main(String[] args) 
    {
      try 
      {
        File output = new File("heapOutput.txt");
        if (output.createNewFile()) 
        {
          System.out.println("File created: " +output.getName());
        } 
        else 
        {
          System.out.println("The output file has already been created.");
        }
      } 
      catch (IOException error) 
      {
        System.out.println("Oopsies, there's a mistake");
        error.printStackTrace();
      }
    }
}
