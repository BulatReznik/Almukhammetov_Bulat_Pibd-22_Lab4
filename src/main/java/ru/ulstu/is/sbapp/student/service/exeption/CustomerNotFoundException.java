package ru.ulstu.is.sbapp.student.service.exeption;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super(String.format("Customer with id [%s] is not found", id));
    }
}
