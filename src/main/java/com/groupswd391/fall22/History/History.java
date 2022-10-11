package com.groupswd391.fall22.History;


import com.groupswd391.fall22.User.User;
import com.groupswd391.fall22.HistoryType.HistoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = HistoryType.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "historytype_ID", referencedColumnName = "id")
    private HistoryType historyType;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID", referencedColumnName = "id")
    private User user;

    private String description;


}
