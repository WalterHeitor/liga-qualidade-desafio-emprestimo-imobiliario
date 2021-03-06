package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.proposal.impl;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.impl.EventGeneric;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.proposal.EventProposal;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.schema.Schema;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.proposal.Proposal;

public class EventProposalDeleteImpl extends EventGeneric implements EventProposal {

    public EventProposalDeleteImpl() {
        super();
    }

    public EventProposalDeleteImpl(String eventId, String eventSchema, String eventAction, String eventTimestamp, String proposalId) {
        super(eventId, eventSchema, eventAction, eventTimestamp, proposalId);
    }

    @Override
    public Schema getSchema() {
        return Schema.PROPOSAL_DELETED;
    }

    @Override
    public Boolean isValid() {
        return false;
    }

    @Override
    public String getProposalId() {
        return proposalId;
    }

    @Override
    public Event newEvent(String... info) {
        return new EventProposalDeleteImpl(info[0], info[1], info[2], info[3], info[4]);
    }

    @Override
    public Proposal enrichmentProposal(Proposal proposal) {
        return proposal.setValid(isValid());
    }
}
