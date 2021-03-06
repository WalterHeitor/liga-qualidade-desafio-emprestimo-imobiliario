package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.proposal.impl;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.impl.EventGeneric;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.proposal.EventProposal;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.schema.Schema;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.proposal.Proposal;

public class EventProposalUpdateImpl extends EventGeneric implements EventProposal {

    private String  proposalLoanValue;
    private String  proposalNumberOfMonthlyInstallments;

    private static final int TWO_YEAR_IN_MOTHS = 24;
    private static final int FIFTEEN_YEAR_IN_MOTHS = 180;

    public EventProposalUpdateImpl() {
        super();
    }

    public EventProposalUpdateImpl(String eventId,
                                   String eventSchema,
                                   String eventAction,
                                   String eventTimestamp,
                                   String proposalId,
                                   String proposalLoanValue,
                                   String proposalNumberOfMonthlyInstallments) {
        super(eventId, eventSchema, eventAction, eventTimestamp, proposalId);
        this.proposalLoanValue = proposalLoanValue;
        this.proposalNumberOfMonthlyInstallments = proposalNumberOfMonthlyInstallments;
    }

    @Override
    public Schema getSchema() {
        return Schema.PROPOSAL_UPDATE;
    }

    @Override
    public Boolean isValid() {
        Double value = Double.valueOf(proposalLoanValue);
        Integer months = Integer.valueOf(proposalNumberOfMonthlyInstallments);

        return (value >= 30000.00 && value <= 3000000.00) &&
                (months >= TWO_YEAR_IN_MOTHS && months <= FIFTEEN_YEAR_IN_MOTHS);
    }

    @Override
    public String getProposalId() {
        return proposalId;
    }

    @Override
    public Event newEvent(String... info) {
        return new EventProposalUpdateImpl(info[0], info[1], info[2], info[3], info[4], info[5], info[6] );

    }

    @Override
    public Proposal enrichmentProposal(Proposal proposal) {
        proposal.setProposalLoanValue(proposalLoanValue);
        proposal.setProposalNumberOfMonthlyInstallments(proposalNumberOfMonthlyInstallments);
        return proposal.setValid(isValid());    }
}
