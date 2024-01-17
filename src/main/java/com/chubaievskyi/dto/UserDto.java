package com.chubaievskyi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Value
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String ipn;
}