package com.example.orm;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import com.example.database.Database;
import com.example.model.User;

public abstract class Model<T extends Model<T>> {
    private transient Connection con = null;

    // protected Model(Class<T> modelClass) {
    // this.modelClass = modelClass;
    // this.table = modelClass.getSimpleName().toLowerCase() + "s";
    // con = Database.getInstance().getConnection();
    // }

    private String getTableName(Class<?> modelClass) {
        return modelClass.getSimpleName().toLowerCase() + "s"; // User -> users
    }

    public DQL query() {
        String tableName = getTableName(this.getClass());
        return new DQL(tableName);
        // List<T> list = new ArrayList<T>();
        // try (Statement stmt = con.createStatement()) {
        //     String sql = "SELECT * FROM " + table;
        //     ResultSet rs = stmt.executeQuery(sql);
        //     while (rs.next()) {
        //         T obj = modelClass.getDeclaredConstructor().newInstance();
        //         mapRowToObject(obj, rs);
        //         list.add(obj);
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // return list;
    }

    /* Find By Id */
    // public T find(int id) {
    //     String sql = "SELECT * FROM " + table + " WHERE id = ? LIMIT 1";
    //     try (PreparedStatement stmt = con.prepareStatement(sql)) {
    //         stmt.setInt(1, id);
    //         ResultSet rs = stmt.executeQuery();
    //         if (rs.next()) {
    //             T obj = modelClass.getDeclaredConstructor().newInstance();
    //             mapRowToObject(obj, rs);
    //             return obj;
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }

    /* WHERE (field, value) */
    // public List<T> where(String field, Object value) {
    //     List<T> list = new ArrayList<T>();
    //     String sql = "SELECT * FROM " + table + " WHERE " + field + " = ?";
    //     try (PreparedStatement stmt = con.prepareStatement(sql)) {
    //         stmt.setObject(1, value);
    //         ResultSet rs = stmt.executeQuery();
    //         while (rs.next()) {
    //             T obj = modelClass.getDeclaredConstructor().newInstance();
    //             mapRowToObject(obj, rs);
    //             list.add(obj);
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return list;
    // }

    private static void mapRowToObject(Object obj, ResultSet rs) throws Exception {
        Class<?> cls = obj.getClass();
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            Object val = rs.getObject(f.getName());
            f.set(obj, val);
        }
    }
}
