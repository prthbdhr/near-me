package com.app.nearme.dto;

import lombok.*;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Long id;
    private String title;
    private double latitude;
    private double longitude;
    private List<String> tags;
    private double distance;
}

