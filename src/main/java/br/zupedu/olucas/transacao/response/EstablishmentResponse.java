package br.zupedu.olucas.transacao.response;

import br.zupedu.olucas.transacao.model.Establishment;

import java.util.UUID;

public class EstablishmentResponse {
    private UUID id;
    private String name;
    private String city;
    private String address;

    public EstablishmentResponse(Establishment establishment) {
        this.id = establishment.getExternalId();
        this.name = establishment.getName();
        this.city = establishment.getCity();
        this.address = establishment.getAddress();
    }

    public UUID getId() {
        return id;
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
