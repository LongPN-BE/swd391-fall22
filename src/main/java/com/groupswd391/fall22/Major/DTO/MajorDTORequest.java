package com.groupswd391.fall22.Major.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorDTORequest {
    @NotNull
    private String name;
    @NotNull
    private String description;
}
