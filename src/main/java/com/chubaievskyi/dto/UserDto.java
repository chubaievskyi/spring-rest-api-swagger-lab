package com.chubaievskyi.dto;

import com.chubaievskyi.validation.IpnValidation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Value
public class UserDto {

//    @JsonIgnore
    private Long id;

    @NotNull
    @Size(min = 2, message = "The first name must consist of at least two characters")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯґҐєЄіІїЇ]*$", message = "This field should contain only Ukrainian or English letters.")
    private String firstName;

    @NotNull
    @Size(min = 2, message = "The last name must consist of at least two characters")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯґҐєЄіІїЇ]*$", message = "This field should contain only Ukrainian or English letters.")
    private String lastName;

    @IpnValidation
    private String ipn;
}