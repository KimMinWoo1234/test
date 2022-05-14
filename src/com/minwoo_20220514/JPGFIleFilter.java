package com.minwoo_20220514;

import java.io.File;
import java.io.FilenameFilter;

public class JPGFIleFilter implements FilenameFilter {

    @Override
    public boolean accept(File file, String fileName) {
        if(fileName.endsWith(".jpg")) return true;
        return false;
    }
}

