package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataFiles {
    //fields
    private static String OUTPUT_FILE_NAME = "D:\\result.txt";
    private static String DIRECTORY = "D:\\testQuestPack";

    public static void main(String [] args) throws IOException {
        System.out.println("Please enter directory");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DIRECTORY = reader.readLine();

        Finder fileFinder = new Finder();
        Reader fileReader = new Reader();

        File output = new File(OUTPUT_FILE_NAME);
        File dir = new File(DIRECTORY);

        fileFinder.setFileNameToSearch(".txt");
        fileFinder.searchDirectory(dir,fileFinder.getFileNameToSearch());

        Collections.sort(fileFinder.getFilePath());
        Collections.sort(fileFinder.getNames());

        for (String a : fileFinder.getFilePath()) {
            fileReader.readWrite(new File(a),output); }
        System.out.println(fileFinder.getNames()); }

//    public void copyFiles(File source, File dest){
//    }

}

