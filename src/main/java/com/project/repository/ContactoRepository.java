package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Contacto;

public interface ContactoRepository extends JpaRepository <Contacto, Long> {

}
