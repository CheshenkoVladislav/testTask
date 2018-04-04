package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Finder {

    private String fileNameToSearch;
    private List<String> filePath = new ArrayList();
    private List<String>names = new ArrayList<>();

    public List<String> getNames() {return names;}
    public List<String> getFilePath() {return filePath;}
    public String getFileNameToSearch() {return fileNameToSearch;}

    public void setFileNameToSearch(String fileNameToSearch) {this.fileNameToSearch = fileNameToSearch;}

    //Search the file in the directory
    public void searchDirectory(File dir, String fileName){
        setFileNameToSearch(fileName);
        if (dir.isDirectory())
            searchInDir(dir);
    }
    // Search in a file in a subdirectory
    public void searchInDir(File file){
        if (file.canRead()){
            for (File temp : file.listFiles()) {
                if (temp.isDirectory())
                    searchInDir(temp);
                else if (temp.getName().contains(getFileNameToSearch())) {
                    filePath.add(temp.getAbsoluteFile().toString());
                    names.add(temp.getName());
                }
            }
        }
    }
}

