package e_commerce.com.springboot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O valor do pagamento é obrigatório")
    private BigDecimal amount;

    @NotNull(message = "O status do pagamento é obrigatório")
    private String status; // Ex.: PENDENTE, APROVADO, CANCELADO

    private String pixKey; // Chave PIX usada para o pagamento
    private String qrCode; // Código QR gerado para o pagamento
    private String transactionId; // ID da transação no provedor de pagamento

    private LocalDateTime paymentDate; // Data do pagamento

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // Relacionamento com o pedido
}