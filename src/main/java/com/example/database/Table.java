// package com.example.database;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Table {
     private String tableName;
     private String CREATE_COMMAND_PREFIX = "CREATE TABLE %s (";
     private Map<String, String> tableCreateQueryRecord;
     private Map<String, String> tableDropQueryRecord;

     public Table() {
          tableCreateQueryRecord = new HashMap<String, String>();
          tableDropQueryRecord = new HashMap<String, String>();
     }

     public List<String> getAllTableNames() {
          return new ArrayList<String>(tableCreateQueryRecord.keySet());
     }

     public Table register(String tableName) {
          this.tableName = tableName;
          tableCreateQueryRecord.put(tableName, String.format(CREATE_COMMAND_PREFIX, tableName));
          return this;
     }

     public void updateQuery(String amend) {
          tableCreateQueryRecord.put(tableName, tableCreateQueryRecord.get(tableName) + " " + amend);
     }

     public Table id() {
          updateQuery("id INT PRIMARY KEY,");
          return this;
     }

     public Table id(String colName) {
          updateQuery(colName + " " + "INT PRIMARY KEY,");
          return this;
     }

     public Table string(String colName) {
          updateQuery(colName + " " + "VARCHAR(100),");
          return this;
     }

     public Table string(String colName, int length) {
          updateQuery(colName + " " + "VARCHAR(" + length + "),");
          return this;
     }

     public String getCreateQuery() {
          return tableCreateQueryRecord.get(tableName);
     }

     public String getDropQuery() {
          return tableCreateQueryRecord.get(tableName);
     }
}

class Main {
     public static void main(String[] args) {
          Table table = new Table();
          table.register("users")
                    .id()
                    .string("name")
                    .string("email")
                    .string("phone");
          System.out.println(table.getCreateQuery());
     }
}