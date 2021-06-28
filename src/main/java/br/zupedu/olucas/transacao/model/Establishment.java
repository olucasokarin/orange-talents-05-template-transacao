package br.zupedu.olucas.transacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Establishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID externalId;
    private String name;
    private String city;
    private String address;

    @Deprecated
    public Establishment() {
    }

    public Establishment(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.externalId = UUID.randomUUID();
    }

    public UUID getExternalId() {
        return externalId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
