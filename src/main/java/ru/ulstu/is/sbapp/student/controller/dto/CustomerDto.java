package ru.ulstu.is.sbapp.student.controller.dto;
import ru.ulstu.is.sbapp.student.model.Consignment;
import ru.ulstu.is.sbapp.student.model.Orderr;
import ru.ulstu.is.sbapp.student.model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDto {
    private  Long id;
    private  String firstName;
    private  String lastName;
    private  String login;
    private List<Long> orderrs= new ArrayList<>();

    public CustomerDto(){

    }
    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.login = customer.getLogin();
        this.orderrs = new ArrayList<>();
        List<Orderr> orderrList = customer.getOrderrs();
        if(orderrList != null) {
            for (Orderr orderr : orderrList) {
                this.orderrs.add(orderr.getId());
            }
        }else {
            this.orderrs = Collections.emptyList();
        }

    }

    public CustomerDto(Consignment consignment) {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getLogin() {
        return login;
    }

    public List<Long> getOrderrs() {
        return orderrs;
    }
}
