package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
