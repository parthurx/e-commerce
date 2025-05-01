package e_commerce.com.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da rua é obrigatório")
    @Size(max = 100, message = "O nome da rua deve ter no máximo 100 caracteres")
    private String street;

    @NotBlank(message = "O número é obrigatório")
    @Size(max = 10, message = "O número deve ter no máximo 10 caracteres")
    private String number;

    @Size(max = 50, message = "O complemento deve ter no máximo 50 caracteres")
    private String complement;

    @NotBlank(message = "O bairro é obrigatório")
    @Size(max = 50, message = "O bairro deve ter no máximo 50 caracteres")
    private String neighborhood;

    @NotBlank(message = "A cidade é obrigatória")
    @Size(max = 50, message = "A cidade deve ter no máximo 50 caracteres")
    private String city;

    @NotBlank(message = "O estado é obrigatório")
    @Size(max = 50, message = "O estado deve ter no máximo 50 caracteres")
    private String state;

    @NotBlank(message = "O CEP é obrigatório")
    @Size(max = 10, message = "O CEP deve ter no máximo 10 caracteres")
    private String zipCode;

    @ManyToOne
    private User user; 
}