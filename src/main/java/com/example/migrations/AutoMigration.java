package com.example.migrations;

import java.util.Set;
import com.example.database.Database;
import com.example.utility.SqlGenerator;
import java.sql.Connection;
import java.sql.Statement;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.ClasspathHelper;
import org.reflections.scanners.Scanners;

public class AutoMigration {
    public static void run(String packageName) {
        // Reflections reflections = new Reflections(packageName);
        Reflections reflections = new Reflections(
                new ConfigurationBuilder()
                        .setUrls(ClasspathHelper.forPackage(packageName))
                        .setScanners(Scanners.SubTypes, Scanners.TypesAnnotated)
                        .addClassLoaders(Thread.currentThread().getContextClassLoader()));

        // Find all classes under the package
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);
        System.out.println("Size = " + allClasses.size());
        for (Class<?> cls : allClasses) {
            try {
                // Skip abstract/interface
                if (!cls.isInterface() && !java.lang.reflect.Modifier.isAbstract(cls.getModifiers())) {
                    String sql = SqlGenerator.generateCreateTable(cls);
                    Connection conn = Database.getInstance().getConnection();
                    Statement stmt = conn.createStatement();
                    int result = stmt.executeUpdate(sql);
                    System.out.println(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
