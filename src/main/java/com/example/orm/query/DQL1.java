package com.example.orm.query;

import java.util.List;

public class DQL1 {
    // FLAGS
    private boolean TAIL_ADDED = false; 
    private boolean WHERE_ADDED = false; 
    private boolean ORDER_BY_ADDED = false; 
    private boolean GROUP_BY_ADDED = false;
    // CONSTANT (TOKENS)
    private final String FROM = "FROM";
    private final String WHERE = "WHERE";
    private final String AND = "AND";
    private final String OR = "OR";
    private final String NOT = "NOT";
    private final String MIN = "MIN";
    private final String MAX = "MAX";
    private final String COUNT = "COUNT";
    private final String SPACE = " ";
    private final String COMMA = ",";
    private final String SEMICOLON = ";";

    private final String table;
    private List<String> sql = null;

    public DQL1(String table, List<String> sql) {
        this.table = table;
        this.sql = sql;
    }

    public String get() {
        sql.add(FROM);
        sql.add(table+SEMICOLON);
        return String.join(SPACE, sql);
    }

    public String where(String col, String operator, String value) {
        addTail();
        sql.add(String.join(SPACE, List.of(WHERE, col, operator, value + SEMICOLON)));
        return String.join(SPACE, sql);
    }

    public DQL1 whereAND(String col, String operator, String value) {
        addTail();
        sql.add(String.join(SPACE, List.of(col, operator, value, AND)));
        return this;
    }

    private void addTail() {
        if(!TAIL_ADDED) {
            sql.add(FROM);
            sql.add(table);
            TAIL_ADDED = true;
        }
    }
}
