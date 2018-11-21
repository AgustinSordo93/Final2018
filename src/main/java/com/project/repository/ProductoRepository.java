package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Long> {

}
