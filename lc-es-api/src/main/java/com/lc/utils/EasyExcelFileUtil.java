package com.lc.utils;

import java.io.File;
import java.io.InputStream;

public class EasyExcelFileUtil {

    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }

    public static String getPath() {
        return EasyExcelFileUtil.class.getResource("/").getPath();
    }

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static File createNewFile(String pathName) {
        File file = new File(getPath() + pathName);
        if (file.exists()) {
            file.delete();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
        return file;
    }

    public static File readFile(String pathName) {
        return new File(getPath() + pathName);
    }

    public static File readUserHomeFile(String pathName) {
        return new File(System.getProperty("user.home") + File.separator + pathName);
    }

    public static void main(String[] args) {
        System.out.println(EasyExcelFileUtil.getPath()); // /C:/_developSoftKu/ideaIU-2019.1.3.win/%23CodeKu/lc-es-api/lc-es-api/target/classes/
        System.out.println(EasyExcelFileUtil.getPath().substring(1)); // C:/_developSoftKu/ideaIU-2019.1.3.win/%23CodeKu/lc-es-api/lc-es-api/target/classes/

        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath==" + projectPath); // projectPath==C:\_developSoftKu\ideaIU-2019.1.3.win\#CodeKu\lc-es-api

        System.out.println(EasyExcelFileUtil.getProjectPath()); // C:\_developSoftKu\ideaIU-2019.1.3.win\#CodeKu\lc-es-api
    }
}
