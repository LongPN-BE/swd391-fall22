package com.groupswd391.fall22.projectItem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectItemDTO implements Serializable {
    private int id;
    @NotNull
    private int projectID;
    @NotNull
    private Integer neededNum;
    @NotNull
    private Integer soldNum;
    @NotNull
    private Integer appliedNum;
    @NotNull
    private double minPrice;
    @NotNull
    private double maxPrice;
    @NotNull
    private String requirement;
    @NotNull
    private int status;
}
