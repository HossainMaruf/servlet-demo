package com.example.migrations;

import java.util.List;
import com.example.database.Database;
import com.example.utility.ClassScanner;
import com.example.utility.SqlGenerator;
import java.sql.Connection;
import java.sql.Statement;

public class Migration {
    public static void run() {
        try {
            List<Class<?>> classes = ClassScanner.scanPackage("com.example.model");
            for (Class<?> cls : classes) {
                // Skip abstract/interface
                if (!cls.isInterface() && !java.lang.reflect.Modifier.isAbstract(cls.getModifiers())) {
                    String sql = SqlGenerator.generateCreateTable(cls);
                    Connection conn = Database.getInstance().getConnection();
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
