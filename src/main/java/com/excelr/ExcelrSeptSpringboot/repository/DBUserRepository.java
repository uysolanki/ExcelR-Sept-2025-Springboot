package com.excelr.ExcelrSeptSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.ExcelrSeptSpringboot.entity.DBUser;

@Repository
public interface DBUserRepository extends JpaRepository<DBUser, Long> {

	public DBUser findByUsername(String s);
}
