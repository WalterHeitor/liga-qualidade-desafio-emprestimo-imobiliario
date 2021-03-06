package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.schema.Schema;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.proposal.Proposal;

public interface Event {

    Schema getSchema();

    Boolean isValid();

    String getProposalId();

    Event newEvent(String ...info);

    Proposal enrichmentProposal(Proposal proposal);
}
