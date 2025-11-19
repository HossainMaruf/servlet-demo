package com.example.migrations;

import java.util.Set;
import com.example.database.Database;
import com.example.utility.SqlGenerator;
import org.reflections.Reflections;


public class AutoMigration {
   public static void run(String packageName) {
        Reflections reflections = new Reflections(packageName);

        // Find all classes under the package
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);

        for (Class<?> cls : allClasses) {
            try {
                // Skip abstract/interface
                if (!cls.isInterface() && !java.lang.reflect.Modifier.isAbstract(cls.getModifiers())) {
                    String sql = SqlGenerator.generateCreateTable(cls);
                    // Database.execute(sql);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } 
}
