package com.example.demo.repository;

import com.example.demo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
//    @Procedure(procedureName = "spProductoSearch")
//    List<Producto> spproductosearch(String arg);
//    @Query(value = "SELECT p.* FROM Producto p where p.nombre like %?1%", nativeQuery = true)
//    List<Producto> findByName(String nombre);
}
