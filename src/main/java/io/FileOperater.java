package io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Eric on 10/25/14.
 */
public class FileOperater {
    public static void main(String[] args) {
        fileOperater();

    }

    public static void fileOperater(){
        Path dir = Paths.get("/Users/Eric/Documents");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir,"*.pdf")){
            for(Path entry:stream){
                System.out.println(entry.getFileName());
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }


    }

}
