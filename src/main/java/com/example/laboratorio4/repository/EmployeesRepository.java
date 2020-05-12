package com.example.laboratorio4.repository;

import com.example.laboratorio4.dto.RecursosHumanos;
import com.example.laboratorio4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository




public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    @Query(value = "select e.* from employees e inner join departments d on e.department_id=d.department_id inner join locations l on d.location_id=l.location_id where l.city= ?1 or d.department_name=?2 or e.last_name=?3 or e.first_name=?4",nativeQuery = true)
    List<Employees> obtenerEmpleados(String nom1,String nom2,String nom3,String nom4);

}
