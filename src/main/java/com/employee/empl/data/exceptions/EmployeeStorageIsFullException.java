package com.employee.empl.data.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
