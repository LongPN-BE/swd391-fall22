package com.groupswd391.fall22.entity;

public class History {
    String id;
    String historyType_ID;
    String user_ID;
    String description;

    public History() {
    }

    public History(String id, String historyType_ID, String user_ID, String description) {
        this.id = id;
        this.historyType_ID = historyType_ID;
        this.user_ID = user_ID;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHistoryType_ID() {
        return historyType_ID;
    }

    public void setHistoryType_ID(String historyType_ID) {
        this.historyType_ID = historyType_ID;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
