package ru.ulstu.is.sbapp.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.is.sbapp.student.controller.dto.ConsignmentDto;
import ru.ulstu.is.sbapp.student.model.Consignment;
import ru.ulstu.is.sbapp.student.model.Orderr;

import java.util.List;

public interface ConsignmentRepository extends JpaRepository<Consignment, Long>{
    @Query("SELECT cons"
            + " FROM Orderr orde"
// a orde has many consignments_orders (1:n)
            + " JOIN FETCH consignments_orderrs cons_order ON cons_order.orderrs_id  = orde.id"
// a cons_order у него много consignments (1:n)
            + " JOIN FETCH Consignment cons ON cons.id = cons_order.consignment_id "
            + " WHERE orde.customer.id = :getId") //ввод айдишника customer

    List<Consignment> getConsignmentForCustomer(@Param("getId") Long getId );
}


//SELECT ID FROM consignment WHERE id IN (SELECT id FROM CONSIGNMENTS_ORDERRS WHERE orderrs_id IN (SELECT id FROM Orderr WHERE customer_id = 1))"

// @Query("SELECT cs FROM Orderr cs WHERE cs.customer.id = :customerId")