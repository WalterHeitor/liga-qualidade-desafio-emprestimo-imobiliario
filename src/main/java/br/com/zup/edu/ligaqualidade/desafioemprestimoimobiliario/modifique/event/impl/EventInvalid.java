package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.impl;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.schema.Schema;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.proposal.Proposal;

public class EventInvalid implements Event {
    @Override
    public Schema getSchema() {
        return null;
    }

    @Override
    public Boolean isValid() {
        return false;
    }

    @Override
    public String getProposalId() {
        return "";
    }

    @Override
    public Event newEvent(String... info) {
        return new EventInvalid();
    }

    @Override
    public Proposal enrichmentProposal(Proposal proposal) {
        return proposal;
    }
}
