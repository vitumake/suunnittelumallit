package decorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

public class ConcreteFileProcessor implements FileProcessor {

    @Override
    public void process(File inputFile, File outputFile) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        
        // File streams
        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        // Write to output stream
        byte[] buffer = new byte[1024];

        int bytesRead;
        while((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        // Close streams
        outputStream.close();
        inputStream.close();
    }
    
    
}
