package es.thalesalv.simplecrud.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {
    
    private String dateTime;
    private String errorMessage;
}