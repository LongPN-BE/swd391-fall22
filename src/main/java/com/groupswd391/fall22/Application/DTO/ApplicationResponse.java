package com.groupswd391.fall22.Application.DTO;

import com.groupswd391.fall22.Application.Application;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponse {
    private int id;
    private int projectItemID;
    private int userID;
    private String requirement;
    private double price;
    private Date time;
    private int status;

    public static ApplicationResponse buildFromApplication(Application application) {
        return new ApplicationResponse(
                application.getId(),
                application.getProjectItem().getId(),
                application.getUser().getId(),
                application.getRequirement(),
                application.getPrice(),
                application.getTime(),
                application.getStatus()
        );
    }
}
