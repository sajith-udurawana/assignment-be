package com.sajith.udurawana.CRUDDemo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private String mapURL;
}
