package proxy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<Image> images = new ArrayList<>();
        boolean exit = false;

        while (!exit) {

            // Clear the console
            System.out.print("\033[H\033[2J");

            // Print image folder
            System.out.println("Image folder:");
            for (Image image : images) {
                image.showData();
            }
            System.out.println();

            System.out.println("1. Display image");
            System.out.println("2. Add image");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            switch (System.console().readLine()) {
                case "1":
                    System.out.print("Enter the image filename: ");
                    String filenameToDisplay = System.console().readLine();

                    boolean found = false;
                    for (Image image : images) {
                        if(((ProxyImage) image).getFilename().startsWith(filenameToDisplay)) {
                            image.displayImage();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Image not found");
                    } 

                    System.out.print("Press Enter to continue...");
                    System.console().readLine();

                    break;
                case "2":
                    System.out.print("Enter the image filename: ");
                    String filename = System.console().readLine();
                    Image image = new ProxyImage(filename);
                    images.add(image);
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
