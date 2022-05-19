package ru.ulstu.is.sbapp.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.is.sbapp.student.model.Consignment;
import ru.ulstu.is.sbapp.student.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    /* @Query("SELECT cs FROM Orderr cs WHERE cs.customer.id = :customerId")
     List<Orderr> getOrderForCustomer(@Param("customerId")Long customerId);
 */

}
