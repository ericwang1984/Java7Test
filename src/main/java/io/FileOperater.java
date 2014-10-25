package io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Eric on 10/25/14.
 */
public class FileOperater {
    public static void main(String[] args) {
        fileOperater("pathA","pathB","*.pdf");
//        try {
//            FiletreeOperter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void fileOperater(String sourcePath,String targetPath,String fileType){
        Path dir = Paths.get(sourcePath);
        Path target;


        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir,fileType)){
            for(Path entry:stream){
                System.out.println(entry.getFileName());
//                source = Paths.get(entry.toFile().getAbsolutePath());
                target = Paths.get(targetPath+entry.getFileName());
               Files.move(entry,target);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());

        }


    }


    public static void  FiletreeOperter() throws IOException{
        Path startDir= Paths.get("/Users/Eric/");
        Files.walkFileTree(startDir,new FindJavaVIsitor());

    }

    private static class FindJavaVIsitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file,BasicFileAttributes attrs){
            if (file.toString().endsWith(".pdf")){
                System.out.println(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }

    }
}
