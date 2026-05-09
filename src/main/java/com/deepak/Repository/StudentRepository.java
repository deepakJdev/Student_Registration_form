package com.deepak.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
// this interface will contains the customized repository methods
}
