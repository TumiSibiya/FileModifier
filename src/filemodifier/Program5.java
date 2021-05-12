package filemodifier;
//Exceptions
import java.io.IOException;
import java.io.FileNotFoundException;
//iO Classes
import java.io.File;
import java.io.PrintWriter;

//util
import java.util.Scanner;

/**
*This program search and edits files.
*@Tumi Sibiya
*@version 8
*
*/
public class Program5{

/**This function search for the file in the current directory, and modify the file so that it is writable
*by using the API method from File class. setWritable(boolean value)
*@param fileName String
*@return void
*@throws FileNotFoundException
*/
    public static void makeWritable(String fileName)throws FileNotFoundException{
    
        File file = new File(fileName);
            file.setWritable(true);
    }
  /**
*@param fileName String
*@return void
*@throws FileNotFoundException
*/  
    public static void makeReadOnly(String fileName)throws FileNotFoundException{
    
        File file = new File(fileName);
        
        try(PrintWriter output = new PrintWriter(file)){
            
            System.out.println(file.setReadOnly());
        }
    }   
/**Search and delete. This function is searched file given the file name and will delete the file instantly.
*@param fileName String
*@return void
*@throws FileNotFoundException
*/
    public static void deleteFile(String fileName)throws FileNotFoundException{

            File file = new File(fileName);

            PrintWriter output = new PrintWriter(file);
            
            output.print(file.delete());
            
            output.close();
            
    }

/**Search files and rename files given only the files Directory. This method throws and FileNoteFoundException
*if the directory is incorrect or the file does not exit.
*@param fileDirectory String
*@return void
*@throws FileNotFoundException
*/


    public static void renameFile(String fileDirectory)throws FileNotFoundException{
    
            File file = new File(fileDirectory);
            String newName = "NewNsme";
            try(PrintWriter output = new PrintWriter(file)){

                output.print(file.renameTo(file));
            }
    }

/**Program entry point
*@param args String[]
*@return void
*@throws IOException
*/
    public static void main(String[] args)throws IOException{

        Scanner input  = new Scanner(System.in);

        String dir;
        try{
          
            dir = input.nextLine();
                   
           renameFile(dir);
                   
          System.out.println(new filemodifier.Program4().viewFileDetails(dir));

          makeReadOnly(dir);
          
          System.out.println("\n");
          
          System.out.println(new filemodifier.Program4().viewFileDetails(dir));
          
          makeWrittable(dir);
          
          deleteFile(dir);
          
          System.out.println(new filemodifier.Program4().viewFileDetails(dir));
        }catch(IllegalArgumentException iaex){  
            System.out.println("Illigal Argument");
        }catch(FileNotFoundException fnfex){
            System.out.println("File not found");
        }
    }
 }