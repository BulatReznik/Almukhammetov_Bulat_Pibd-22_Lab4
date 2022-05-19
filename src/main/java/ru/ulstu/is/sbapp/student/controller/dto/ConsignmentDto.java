package ru.ulstu.is.sbapp.student.controller.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.ulstu.is.sbapp.student.model.Consignment;
import ru.ulstu.is.sbapp.student.model.Orderr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsignmentDto {

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String consignmentName;
    private List<Long> orderrs = new ArrayList<>();

    public ConsignmentDto() {
    }

    public ConsignmentDto(Consignment consignment) {
        this.id = consignment.getId();
        this.consignmentName = consignment.getConsignmentName();
        List<Orderr> orderrList = consignment.getOrderrs();
        if(orderrList != null) {
            for (Orderr orderr : orderrList) {
                this.orderrs.add(orderr.getId());
            }
        }else {
            this.orderrs = Collections.emptyList();
        }
    }

    public Long getId() {
        return id;
    }
    public String getConsignmentName() {
        return consignmentName;
    }
    public List<Long> getOrderrs() {
        return orderrs;
    }
}
