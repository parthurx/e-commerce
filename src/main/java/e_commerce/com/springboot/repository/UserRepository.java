package e_commerce.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import e_commerce.com.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Adicione métodos personalizados, se necessário
}