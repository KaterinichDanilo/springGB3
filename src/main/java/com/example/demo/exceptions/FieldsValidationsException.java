package com.example.demo.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class FieldsValidationsException {
    private List<String> errorFieldsMessages;

    public FieldsValidationsException(List<String> errors) {
        this.errorFieldsMessages = errors;
    }
}
