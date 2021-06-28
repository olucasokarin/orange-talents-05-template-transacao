package br.zupedu.olucas.transacao.response;

import br.zupedu.olucas.transacao.model.Card;

import java.util.UUID;

public class CardResponse {

    private UUID id;
    private String email;

    public CardResponse(Card card) {
        this.id = card.getExternalId();
        this.email = card.getEmail();
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
