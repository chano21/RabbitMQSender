package com.crazypco.rabbit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crazypco.rabbit.entitys.Customer;
public interface CustomerRespository extends JpaRepository <Customer,Long>{
   Customer findByName(String name);
}


