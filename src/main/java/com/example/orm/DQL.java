package com.example.orm;

import java.util.List;
import java.util.ArrayList;

public class DQL {
    private final String SELECT = "SELECT";
    private final String ALL = "*";
    private final String FROM = "FROM";
    private final String WHERE = "WHERE";
    private final String MIN = "MIN";
    private final String MAX = "MAX";
    private final String COUNT = "COUNT";
    private final String SPACE = " ";
    private final String COMMA = ",";
    private final String SEMICOLON = ";";

    private final String table;
    private List<String> sql = null;

    public DQL(String table) {
        this.table = table;
        sql = new ArrayList<String>();
        sql.add(SELECT);
    }

    public DQL all() {
        sql.add(ALL);
        return this;
    }

    public DQL all(String... cols) {
        sql.add(String.join(COMMA, cols));
        return this;
    }

    public String where(String col, String operator, String value) {
        sql.add(String.join(SPACE, List.of(WHERE, col, operator, value)));
        return String.join(SPACE, sql);
    }

    public String get() {
        sql.add(FROM);
        sql.add(table + SEMICOLON);
        return String.join(SPACE, sql);
    }

}
