package com.example.utility;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassScanner {
    public static List<Class<?>> scanPackage(String packageName) throws Exception {
        List<Class<?>> classes = new ArrayList<>();

        String path = packageName.replace('.', '/');
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        URL resource = loader.getResource(path);
        if (resource == null) {
            System.out.println("Package not found: " + path);
            return classes;
        }

        File dir = new File(resource.toURI());
        File[] files = dir.listFiles();

        if (files == null)
            return classes;

        for (File file : files) {
            if (file.getName().endsWith(".class")) {
                String className = packageName + "." + file.getName().replace(".class", "");
                classes.add(Class.forName(className));
            }
        }
        return classes;
    }
}
