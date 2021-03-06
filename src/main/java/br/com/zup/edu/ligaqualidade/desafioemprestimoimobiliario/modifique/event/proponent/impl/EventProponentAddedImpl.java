package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.proponent.impl;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.impl.EventGeneric;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.proponent.EventProponent;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.schema.Schema;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.proposal.Proponent;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.proposal.Proposal;

import java.util.List;
import java.util.stream.Collectors;

public class EventProponentAddedImpl extends EventGeneric implements EventProponent {

    private String proponentId;
    private String proponentName;
    private String proponentAge;
    private String proponentMonthlyIncome;
    private String proponentIsMain;

    public EventProponentAddedImpl() {

    }

    public EventProponentAddedImpl(String eventId, String eventSchema, String eventAction, String eventTimestamp, String proposalId, String proponentId, String proponentName, String proponentAge, String proponentMonthlyIncome, String proponentIsMain) {
        super(eventId, eventSchema, eventAction, eventTimestamp, proposalId);
        this.proponentId = proponentId;
        this.proponentName = proponentName;
        this.proponentAge = proponentAge;
        this.proponentMonthlyIncome = proponentMonthlyIncome;
        this.proponentIsMain = proponentIsMain;
    }

    @Override
    public Schema getSchema() {
        return Schema.PROPONENT_ADDED;
    }

    @Override
    public Boolean isValid() {
        return true;
    }

    @Override
    public Event newEvent(String... info) {
        return new EventProponentAddedImpl(info[0], info[1],info[2],info[3],info[4],info[5],info[6],info[7],info[8],info[9]);
    }

    @Override
    public Proposal enrichmentProposal(Proposal proposal) {
        proposal.getProponentList().add(new Proponent(proponentName, proponentAge, proponentMonthlyIncome, proponentIsMain)) ;
        List<Proponent> collect = proposal.getProponentList().stream().filter(proponent -> Boolean.valueOf(proponent.getProponentIsMain())).collect(Collectors.toList());
        List<Proponent> collectAge = proposal.getProponentList().stream().filter(proponent -> Integer.valueOf(proponent.getProponentAge()) < 18).collect(Collectors.toList());
        return proposal.setValid(collect.size() == 1 && proposal.getProponentList().size() >= 2 && collectAge.size() == 0);
    }
}
