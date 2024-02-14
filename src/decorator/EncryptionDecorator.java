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
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionDecorator extends FileProcessorDecorator {
    
    private static final String SECRET = Config.getProperty("security.secret");

    public EncryptionDecorator(FileProcessor fileProcessor) {
        super(fileProcessor);
    }

    @Override
    public void process(File inputFile, File outputFile) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException{
        
        System.out.println("Encrypting file: " + inputFile.getName());

        // File streams
        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile.getAbsolutePath()+".enc");

        // KeyGen
        KeySpec keySpec = new PBEKeySpec(SECRET.toCharArray(), SECRET.getBytes(), 128, 256);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] keyBytes = keyFactory.generateSecret(keySpec).getEncoded();

        // Encryption
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Output stream
        CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);

        // Write to output stream
        byte[] buffer = new byte[1024];
        
        int bytesRead;
        while((bytesRead = inputStream.read(buffer)) != -1) {
            cipherOutputStream.write(buffer, 0, bytesRead);
        }

        // Close streams
        inputStream.close();
        cipherOutputStream.close();
    }
}
