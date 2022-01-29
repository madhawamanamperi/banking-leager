package com.bl.repository;

import com.bl.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    @Query("select s from StudentNotes s where s.student.id = :userId")
//    List<StudentNotes> getAllStudentNotes(@Param("userId") Long userId);

}
