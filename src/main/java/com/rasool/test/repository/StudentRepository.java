package com.rasool.test.repository;

import com.rasool.test.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository  extends CrudRepository<Student, Long> {

    @Override
    List<Student> findAll();

    public Student findById(long id);
}
