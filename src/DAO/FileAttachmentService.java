/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileAttachmentService {

    private static final String FILE_DIRECTORY = "C:\\FileAttachments";

    public FileAttachmentService() {
        // Kiểm tra và tạo thư mục nếu chưa tồn tại
        File directory = new File(FILE_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public boolean saveFileToDisk(String fileName, InputStream fileContent) {
        File targetFile = new File(FILE_DIRECTORY, fileName);
        try (InputStream input = fileContent) {
            Files.copy(input, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving file to disk: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
