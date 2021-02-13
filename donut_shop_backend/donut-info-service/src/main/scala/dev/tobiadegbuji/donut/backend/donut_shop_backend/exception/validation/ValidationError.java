package dev.tobiadegbuji.donut.backend.donut_shop_backend.exception.validation;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationError {

    @JsonInclude(JsonInclude.Include.NON_EMPTY) //Hide field if empty
    private final String errorMessage;
    private List<String> errorList;

    public ValidationError(String errorMessage) {
        this.errorMessage = errorMessage;
        errorList = new ArrayList<>();
    }

    public void insertError(String error){
        errorList.add(error);
    }


}
