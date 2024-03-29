/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author alexa
 */
public class AppBackup {
    
    
    private static final String INPUT_FILE = "C:\\Users\\alexa\\Desktop\\backup\\teste";
    private static final String INPUT_FILE_2 = "C:\\Users\\alexa\\Downloads\\teste";
    private static final String OUTPUT_FILE = "C:\\Users\\alexa\\Desktop\\backup\\output.zip";
    
    public static void main(String[] args) {
        zipFile(new File(INPUT_FILE_2), OUTPUT_FILE);
    }

    public static void zipFile(File inputFile, String zipFilePath) {
        try {
            // Wrap a FileOutputStream around a ZipOutputStream
            // to store the zip stream to a file. Note that this is
            // not absolutely necessary
            FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
 
            // a ZipEntry represents a file entry in the zip archive
            // We name the ZipEntry after the original file's name
            ZipEntry zipEntry = new ZipEntry(inputFile.getName());
            zipOutputStream.putNextEntry(zipEntry);
 
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            byte[] buf = new byte[1024];
            int bytesRead;
 
            // Read the input file by chucks of 1024 bytes
            // and write the read bytes to the zip stream
            while ((bytesRead = fileInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
            }
 
            // close ZipEntry to store the stream to the file
            zipOutputStream.closeEntry();
 
            zipOutputStream.close();
            fileOutputStream.close();
 
            System.out.println("Regular file :" + inputFile.getCanonicalPath()+" is zipped to archive :"+zipFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
