package com.AOP_Basic.Repository;

import com.AOP_Basic.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AOPRepository extends JpaRepository<Product,String> {
}
