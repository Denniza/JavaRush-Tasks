package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean markName = true;
        //boolean markContent = true;
        //boolean markMinSize = true;
        //boolean markMaxSize = true;
        byte[] content = Files.readAllBytes(file);

        if(partOfName!=null){
            if(!file.toString().contains(partOfName)) markName &= false;
        }
        if (partOfContent!=null){
            String text = content.toString();
            if(Files.lines(file).noneMatch(line -> line.contains(partOfContent))) markName &= false;
                //markContent = false;
            // размер файла: content.length
        }
        if(minSize!=0){
            if(!(content.length>minSize)) markName &= false;
                //markMinSize = false;
        }
        if (maxSize!=0){
            if(!(content.length<maxSize)) markName &= false;
                //markMaxSize = false;
        }
        if(markName) foundFiles.add(file);
        return super.visitFile(file, attrs);
    }
}
