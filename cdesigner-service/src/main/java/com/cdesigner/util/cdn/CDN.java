package com.cdesigner.util.cdn;

import java.io.InputStream;

import com.cdesigner.exception.CException;

public interface CDN {

    String uploadFile(InputStream in, String fileName) throws CException;

    boolean deleteFile(String path);

    String getHttpPath(String path);

    String getFileHttpPath(String filePath);
}
