package ru.ulstu.is.sbapp.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.is.sbapp.student.model.Orderr;

import java.util.List;

public interface OrderrRepository extends JpaRepository<Orderr, Long> {

}
