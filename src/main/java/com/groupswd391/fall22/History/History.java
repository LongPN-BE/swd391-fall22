package com.groupswd391.fall22.History;


import com.groupswd391.fall22.User.User;
import com.groupswd391.fall22.HistoryType.HistoryType;

import javax.persistence.*;

@Entity
@Table(name = "tbl_history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(targetEntity = HistoryType.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "historytype_ID", referencedColumnName = "id")
    private HistoryType historyType;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID", referencedColumnName = "id")
    private User user;

    private String description;

    public History() {
    }

    public History(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HistoryType getHistoryType() {
        return historyType;
    }

    public void setHistoryType(HistoryType historyType) {
        this.historyType = historyType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
