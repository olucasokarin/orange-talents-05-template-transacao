package br.zupedu.olucas.transacao.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID externalId;
    private String email;

    @Deprecated
    public Card() {
    }

    public Card(UUID externalId, String email) {
        this.externalId = externalId;
        this.email = email;
    }

    public UUID getExternalId() {
        return externalId;
    }
}
