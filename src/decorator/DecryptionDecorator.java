package decorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class DecryptionDecorator extends FileProcessorDecorator {
    
    private static final String SECRET = Config.getProperty("security.secret");

    public DecryptionDecorator(FileProcessor fileProcessor) {
        super(fileProcessor);
    }

    @Override
    public void process(File inputFile, File outputFile) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException{

        // Check if file is encrypted
        if(!inputFile.getName().endsWith(".enc")) {
            System.out.println("File is not encrypted.");
            return;
        }

        System.out.println("Decrypting file: " + inputFile.getName());

        // File streams
        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile.getAbsolutePath().replace(".enc", ""));
        
        // KeyGen
        KeySpec keySpec = new PBEKeySpec(SECRET.toCharArray(), SECRET.getBytes(), 128, 256);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] keyBytes = keyFactory.generateSecret(keySpec).getEncoded();

        // Decryption
        SecretKeySpec secret = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        
        cipher.init(Cipher.DECRYPT_MODE, secret);
        
        // Output stream
        CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
        
        // Write to output stream
        byte[] buffer = new byte[1024];
        
        int bytesRead;
        while((bytesRead = cipherInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        // Close streams
        cipherInputStream.close();
        outputStream.close();
    }
}
