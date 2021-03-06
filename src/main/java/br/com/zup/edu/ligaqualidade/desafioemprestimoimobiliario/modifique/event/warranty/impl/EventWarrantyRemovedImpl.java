package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.warranty.impl;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.impl.EventGeneric;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.schema.Schema;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.warranty.EventWarranty;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.proposal.Proposal;

public class EventWarrantyRemovedImpl extends EventGeneric implements EventWarranty {

    private String  warrantyId;

    public EventWarrantyRemovedImpl() {
    }

    public EventWarrantyRemovedImpl(String eventId, String eventSchema, String eventAction, String eventTimestamp, String proposalId, String warrantyId) {
        super(eventId, eventSchema, eventAction, eventTimestamp, proposalId);
        this.warrantyId = warrantyId;
    }

    @Override
    public Schema getSchema() {
        return Schema.WARRANTY_DELETE;
    }

    @Override
    public Boolean isValid() {
        return null;
    }

    @Override
    public Event newEvent(String... info) {
        return new EventWarrantyRemovedImpl(info[0], info[1], info[2], info[3], info[4], info[5]);
    }

    @Override
    public Proposal enrichmentProposal(Proposal proposal) {
        return proposal;
    }
}
