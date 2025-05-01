package e_commerce.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import e_commerce.com.springboot.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Adicione métodos personalizados, se necessário
}