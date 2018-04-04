package com.company;

import java.io.*;
import java.util.ArrayList;

public class Reader {

    //reading a file and writing to a document
    public void readWrite(File folder, File output) {
        ArrayList<String> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(folder));
            BufferedWriter writer = new BufferedWriter(new FileWriter(output,true));
            while (reader.ready()){
                data.add(reader.readLine());
            }
            for (String a : data) {
                writer.write(a);
                writer.newLine();
            }
            reader.close();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


