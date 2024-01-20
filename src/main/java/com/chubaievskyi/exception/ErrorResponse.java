package com.chubaievskyi.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Error Info")
public class ErrorResponse {

    @Schema(description = "Date", example = "00:00:00 01.01.2023")
    private String date;

    @Schema(description = "Error status code", example = "404")
    private int statusCode;

    @Schema(description = "Error status", example = "Not found")
    private String status;

    @Schema(description = "Detailed error message", example = "User not found with ID: 22")
    private String message;


}