package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Beans.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
