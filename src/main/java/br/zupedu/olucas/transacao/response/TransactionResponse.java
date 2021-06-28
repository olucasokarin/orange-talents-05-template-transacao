package br.zupedu.olucas.transacao.response;

import br.zupedu.olucas.transacao.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionResponse {

    private UUID id;
    private BigDecimal value;
    private EstablishmentResponse establishment;
    private CardResponse card;
    private LocalDateTime createdAt;

    public TransactionResponse(Transaction transaction) {
        this.id = transaction.getExternalId();
        this.value = transaction.getValue();
        this.createdAt = transaction.getCreatedAt();
        this.card = new CardResponse(transaction.getCard());
        this.establishment = new EstablishmentResponse(transaction.getEstablishment());
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public EstablishmentResponse getEstablishment() {
        return establishment;
    }

    public CardResponse getCard() {
        return card;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
