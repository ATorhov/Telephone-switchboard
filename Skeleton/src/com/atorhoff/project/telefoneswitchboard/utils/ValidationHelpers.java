package com.atorhoff.project.telefoneswitchboard.utils;

import com.atorhoff.project.telefoneswitchboard.exceptions.InvalidArgumentCountException;

import java.util.List;

public class ValidationHelpers {

    public static void validateIntRange(int minLength, int maxLength, int actualLength, String errorMessage) {
        if (actualLength < minLength || actualLength > maxLength) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateStringLength(String stringToValidate, int minLength, int maxLength, String errorMessage) {
        validateIntRange(minLength, maxLength, stringToValidate.length(), errorMessage);
    }

    public static void validateArgumentCounts(List<String> list, int expectedListSize){
        if (list.size() != expectedListSize){
            throw new InvalidArgumentCountException(
                    String.format("Invalid number of arguments. Expected: %d; received: %d.",
                            expectedListSize, list.size())
            );
        }
    }
}
