package decorator;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

import javax.crypto.NoSuchPaddingException;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Boolean exit = false;

        while(!exit) {
            
            // Print available files
            System.out.println("Available files: ");

            File[] files = new File("src/decorator/files").listFiles();

            if(files == null || files.length == 0) {
                System.out.println("No files available. Exiting...");
                exit = true;
                continue;
            }

            for(File file : files) {
                if(file.isFile()) {
                    System.out.println(file.getName());
                }
            }

            // Get user input
            System.out.println("Enter the name of the file you want to process (or 'exit' to quit): ");
            String input = scanner.nextLine();
            
            // Check exit condition
            if(input.equals("exit")) {
                exit = true;
                continue;
            }

            // Check if file exists
            if(!new File("src/decorator/files/" + input).exists()) {
                System.out.println("File does not exist.");
                continue;
            }

            // Ask user to encrypt or decrypt
            System.out.println("Do you want to encrypt or decrypt the file? (e/d): ");
            String action = scanner.nextLine();

            // Create file objects
            File inputFile = new File("src/decorator/files/" + input);
            File outputFile = new File("src/decorator/files/" + input);

            // Create file processor
            FileProcessor fileProcessor = new ConcreteFileProcessor();

            try {
                if(action.equals("e")) {                 
                    fileProcessor = new EncryptionDecorator(fileProcessor);
                } else if(action.equals("d")) {
                    fileProcessor = new DecryptionDecorator(fileProcessor);           
                } else {
                    System.out.println("Invalid action.");
                    continue;
                }

                // Process file
                fileProcessor.process(inputFile, outputFile);

                // Delete original file
                inputFile.delete();

            } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
