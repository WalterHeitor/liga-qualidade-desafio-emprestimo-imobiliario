package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.impl;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.Event;

public abstract class EventGeneric implements Event {

    protected String eventId;
    protected String eventSchema;
    protected String eventAction;
    protected String eventTimestamp;
    protected String proposalId;

    protected EventGeneric() {}

    public EventGeneric(String eventId, String eventSchema, String eventAction, String eventTimestamp, String proposalId) {
        this.eventId = eventId;
        this.eventSchema = eventSchema;
        this.eventAction = eventAction;
        this.eventTimestamp = eventTimestamp;
        this.proposalId = proposalId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventSchema() {
        return eventSchema;
    }

    public String getEventAction() {
        return eventAction;
    }

    public String getEventTimestamp() {
        return eventTimestamp;
    }

    @Override
    public String getProposalId() {
        return proposalId;
    }
}

