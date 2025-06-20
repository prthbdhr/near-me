package com.app.nearme.dto;

import lombok.*;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RequestDTO {
    private double latitude;
    private double longitude;
    private String title;
    private List<String> tags;
    private int page = 0;
    private int size = 10;
}
