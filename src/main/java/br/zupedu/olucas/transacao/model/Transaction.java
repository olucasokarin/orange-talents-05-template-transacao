package br.zupedu.olucas.transacao.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID externalId;
    private BigDecimal value;
    @ManyToOne(cascade = CascadeType.ALL)
    private Establishment establishment;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Card card;
    @CreatedDate
    private LocalDateTime createdAt;

    @Deprecated
    public Transaction() {
    }

    public Transaction(UUID externalId, BigDecimal value, Establishment establishment,
                       Card card, LocalDateTime createdAt) {
        this.externalId = externalId;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.createdAt = createdAt;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
