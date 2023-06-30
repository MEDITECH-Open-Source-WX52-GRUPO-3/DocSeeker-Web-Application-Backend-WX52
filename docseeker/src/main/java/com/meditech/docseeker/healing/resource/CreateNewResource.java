package com.meditech.docseeker.healing.resource;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewResource {

    @NotNull(message = "image is required")
    private String image;

    @NotBlank
    @NotNull(message = "title is required")
    private String title;
    private String description;
    private String info;
    private Integer views;
}
