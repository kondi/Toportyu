package com.company;

import java.io.*;

/**
 * Created by Andras.Timar on 4/12/2016.
 */
public class FileBasedIOProvider implements IOProvider {
    final String path;

    public FileBasedIOProvider()
    {
        this.path="orders.txt";
    }
    public FileBasedIOProvider(String path) {
        this.path = path;
    }

    @Override
    public Reader createReader() throws FileNotFoundException {
        return new FileReader(path);
    }

    @Override
    public PrintWriter createWriter() throws IOException {
        return new PrintWriter(new FileWriter(path));
    }
}
