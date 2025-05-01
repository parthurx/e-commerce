package e_commerce.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import e_commerce.com.springboot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Adicione métodos personalizados, se necessário
}