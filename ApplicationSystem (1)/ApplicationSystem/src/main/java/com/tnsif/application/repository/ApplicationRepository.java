package com.tnsif.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.application.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer>{

}
