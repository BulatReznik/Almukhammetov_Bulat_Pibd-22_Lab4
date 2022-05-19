package ru.ulstu.is.sbapp.student.controller.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.ulstu.is.sbapp.student.model.Consignment;
import ru.ulstu.is.sbapp.student.model.Orderr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderrDto {
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String orderrName;
    private String orderrDate;
    private List<Long> consignments= new ArrayList<>();
    private CustomerDto customer;

    public OrderrDto() {

    }

    public OrderrDto(Orderr orderr) {
        this.id = orderr.getId();
        this.orderrName = orderr.getOrderrName();
        this.orderrDate = orderr.getOrderrDate();
        this.consignments = new ArrayList<>();
        List<Consignment> consignmentList = orderr.getConsignments();
        if(consignmentList != null) {
            for (Consignment consignment : consignmentList) {
                this.consignments.add(consignment.getId());
            }
        }else {
            this.consignments = Collections.emptyList();
        }

        if(orderr.getCustomer() != null){
            this.customer = new CustomerDto(orderr.getCustomer());
        }
    }

    public Long getId() {
        return id;
    }

    public String getOrderrName() {
        return orderrName;
    }

    public String getOrderrDate() {
        return orderrDate;
    }

    public List<Long> getConsignments() {
        return consignments;
    }

    public CustomerDto getCustomer(){return customer;}


}