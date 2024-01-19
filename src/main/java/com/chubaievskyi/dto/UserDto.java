package com.chubaievskyi.dto;

import com.chubaievskyi.validation.IpnValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "User DTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @Schema(description = "User ID", example = "1234567899", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100, message = "The first name must contain between 2 and 100 characters")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯґҐєЄіІїЇ]*$", message = "This field should contain only Ukrainian or English letters.")
    @Schema(description = "User first name", example = "Rod")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 100, message = "The last name must contain between 2 and 100 characters")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯґҐєЄіІїЇ]*$", message = "This field should contain only Ukrainian or English letters.")
    @Schema(description = "User last name", example = "Johnson")
    private String lastName;

    @IpnValidation
    @Schema(description = "IPN of the user", example = "1234567899")
    private String ipn;
}