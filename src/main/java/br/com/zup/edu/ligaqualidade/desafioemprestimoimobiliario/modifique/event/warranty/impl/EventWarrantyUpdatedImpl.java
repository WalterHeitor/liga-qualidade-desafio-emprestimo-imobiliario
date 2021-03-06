package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.warranty.impl;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.impl.EventGeneric;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.schema.Schema;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.warranty.EventWarranty;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.proposal.Proposal;

public class EventWarrantyUpdatedImpl extends EventGeneric implements EventWarranty {

    private String  warrantyId;
    private String  warrantyValue;
    private String  warrantyProvince;

    public EventWarrantyUpdatedImpl() {
    }

    public EventWarrantyUpdatedImpl(String eventId, String eventSchema, String eventAction, String eventTimestamp, String proposalId, String warrantyId, String warrantyValue, String warrantyProvince) {
        super(eventId, eventSchema, eventAction, eventTimestamp, proposalId);
        this.warrantyId = warrantyId;
        this.warrantyValue = warrantyValue;
        this.warrantyProvince = warrantyProvince;
    }

    @Override
    public Schema getSchema() {
        return Schema.WARRANTY_UPDATED;
    }

    @Override
    public Boolean isValid() {
        return null;
    }

    @Override
    public Event newEvent(String... info) {
        return new EventWarrantyUpdatedImpl(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7]);
    }

    @Override
    public Proposal enrichmentProposal(Proposal proposal) {
        return proposal;
    }
}
