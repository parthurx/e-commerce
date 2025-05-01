package e_commerce.com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_commerce.com.springboot.model.User;
import e_commerce.com.springboot.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user){
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com o ID: " + id);
        }
        user.setId(id); 
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            // Lógica alternativa, como lançar uma exceção personalizada ou registrar um
            // aviso
        }
    }

}
