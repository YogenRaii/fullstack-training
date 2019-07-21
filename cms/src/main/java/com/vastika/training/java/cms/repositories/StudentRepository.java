package com.vastika.training.java.cms.repositories;

import com.vastika.training.java.cms.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
