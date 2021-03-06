package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.schema;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.impl.EventInvalid;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.proponent.impl.EventProponentAddedImpl;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.proposal.impl.EventProposalCreateImpl;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.proposal.impl.EventProposalDeleteImpl;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.proposal.impl.EventProposalUpdateImpl;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.warranty.impl.EventWarrantyAddedImpl;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.warranty.impl.EventWarrantyRemovedImpl;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.warranty.impl.EventWarrantyUpdatedImpl;

public enum Schema {

    PROPOSAL_CREATE("proposal", "created", new EventProposalCreateImpl()),
    PROPOSAL_UPDATE("proposal", "added", new EventProposalUpdateImpl()),
    PROPOSAL_DELETED("proposal", "deleted", new EventProposalDeleteImpl()),
    WARRANTY_ADDED("warranty", "added", new EventWarrantyAddedImpl()),
    WARRANTY_UPDATED("warranty", "updated", new EventWarrantyUpdatedImpl()),
    WARRANTY_DELETE("warranty", "removed", new EventWarrantyRemovedImpl()),
    PROPONENT_ADDED("proponent", "added", new EventProponentAddedImpl()),
    INVALID_SCHEMA("", "", new EventInvalid());

    private String schema, action;
    private Event event;

    Schema(String schema, String action, Event event) {
        this.schema = schema;
        this.action = action;
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public static Schema getSchema(String eventSchema, String eventAction) {
        for (Schema schema : values()) {
            if (schema.schema.equalsIgnoreCase(eventSchema) &&
                schema.action.equalsIgnoreCase(eventAction)) {
                return schema;
            }
        }
        return INVALID_SCHEMA;
    }
}

