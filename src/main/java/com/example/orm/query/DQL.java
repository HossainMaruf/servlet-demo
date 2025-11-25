package com.example.orm.query;

import java.util.List;
import java.util.ArrayList;

public class DQL {
    // FLAGS
    private boolean TAIL_ADDED = false; 
    private boolean WHERE_ADDED = false; 
    private boolean ORDER_BY_ADDED = false; 
    private boolean GROUP_BY_ADDED = false; 
    // CONSTANT (TOKENS)
    private final String SELECT = "SELECT";
    private final String ALL = "*";
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

    public DQL(String table) {
        this.table = table;
        sql = new ArrayList<String>();
        sql.add(SELECT);
    }

    public DQL1 all() {
        sql.add(ALL);
        return new DQL1(table, sql);
    }

    public DQL1 all(String... cols) {
        sql.add(String.join(COMMA+SPACE, cols));
        return new DQL1(table, sql);
    }





    private void addWhere() {
        if(!WHERE_ADDED) {
            sql.add(WHERE);
            WHERE_ADDED = true;
        }
    }

    private boolean clauseAdded() {
        return WHERE_ADDED || GROUP_BY_ADDED || ORDER_BY_ADDED;
    }

}
