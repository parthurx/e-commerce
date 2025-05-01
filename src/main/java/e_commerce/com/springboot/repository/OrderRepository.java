package e_commerce.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import e_commerce.com.springboot.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Adicione métodos personalizados, se necessário
}