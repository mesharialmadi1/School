package com.example.School.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//DataResponse usually used with post update methods to return message
public class DataResponse {
    private String message;
}
