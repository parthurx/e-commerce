package e_commerce.com.springboot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do produto é obrigatório")
    @Size(min = 2, max = 50, message = "Nome do produto deve ter entre 2 e 50 caracteres")
    private String name;
    @NotBlank(message = "Descrição do produto é obrigatória")
    @Size(min = 3, max = 50, message = "Descrição do produto deve ter entre 3 e 50 caracteres")
    private String description;
    @NotNull(message = "Preço do produto é obrigatório")
    @DecimalMin(value = "0.01", message = "Preço do produto deve ser maior que 0")
    private BigDecimal price;
    @Min(value = 0, message = "Quantidade em estoque deve ser maior ou igual a 0")
    @NotNull(message = "Quantidade em estoque é obrigatória")
    private int stock;
    @Size(max = 50, message = "Cor deve ter no máximo 50 caracteres")
    private String color;
    @NotNull(message = "Tamanho é obrigatório")
    private String size;
    @NotBlank(message = "URL da imagem é obrigatória")
    private String imageUrl;

    @ManyToOne
    private Category category;

    @CreatedDate
    private LocalDateTime createdAt; // Data de criação

    @LastModifiedDate
    private LocalDateTime updatedAt; // Data da última atualização

}
