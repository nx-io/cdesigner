package com.cdesigner.util.cdn;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;

import com.cdesigner.constant.CommonConstant;
import com.cdesigner.constant.GlobalProperties;
import com.cdesigner.constant.ResponseCode;
import com.cdesigner.exception.CException;
import com.cdesigner.exception.CExceptionFactory;
import com.cdesigner.util.FileUtil;
import com.cdesigner.util.ValidationUtil;

public final class LocalCDN implements CDN {

    @Override
    public String uploadFile(final InputStream in, final String fileName) throws CException {
        String savePath = new StringBuilder(GlobalProperties.CDN_LOCAL_PATH.trim()).append(CommonConstant.SEPARATOR)
                .toString();
        try {
            FileUtil.saveFile(in, savePath, fileName);
        } catch (IOException e) {
            throw CExceptionFactory.getException(CException.class, ResponseCode.FILE_UPLOAD_ERROR);
        }

        return fileName;
    }

    @Override
    public boolean deleteFile(final String path) {
        File file = new File(GlobalProperties.CDN_LOCAL_PATH.trim() + CommonConstant.SEPARATOR + path);
        if (file.isFile()) {
            file.delete();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getHttpPath(final String path) {
        String url = null;
        if (ValidationUtil.isFullURL(path)) {
            url = path;
        } else if (StringUtils.isNotBlank(path)) {
            url = GlobalProperties.CDN_DOMAIN.concat(
                    GlobalProperties.CDN_DOMAIN.endsWith(CommonConstant.SEPARATOR) ? "" : CommonConstant.SEPARATOR)
                    .concat(path);
        } else {
            url = GlobalProperties.DEFAULT_AVATAR_URL;
        }

        return url;
    }

    @Override
    public String getFileHttpPath(String filePath) {
        String url = null;
        if (ValidationUtil.isFullURL(filePath)) {
            url = filePath;
        } else if (StringUtils.isNotBlank(filePath)) {
            url = GlobalProperties.CDN_DOMAIN.concat(
                    GlobalProperties.CDN_DOMAIN.endsWith(CommonConstant.SEPARATOR) ? "" : CommonConstant.SEPARATOR)
                    .concat(filePath);
        }

        return url;
    }

}
