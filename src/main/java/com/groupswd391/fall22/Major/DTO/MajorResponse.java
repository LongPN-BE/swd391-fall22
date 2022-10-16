package com.groupswd391.fall22.Major.DTO;

import com.groupswd391.fall22.Major.Major;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorResponse {
    private int id;
    private String name;
    private String description;

    public static MajorResponse buildFromMajor(Major major) {
        return new MajorResponse(
                major.getId(),
                major.getName(),
                major.getDescription()
        );
    }
}
