package decorator;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;

abstract class FileProcessorDecorator implements FileProcessor {
    
    private final FileProcessor fileProcessor;

    public FileProcessorDecorator(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    @Override
    public void process(File inputFile, File outputFile) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        fileProcessor.process(inputFile, outputFile);
    }
}
