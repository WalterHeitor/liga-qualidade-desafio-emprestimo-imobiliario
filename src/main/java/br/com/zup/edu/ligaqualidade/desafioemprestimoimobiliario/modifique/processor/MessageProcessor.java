package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.processor;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.Event;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.event.factory.EventFactory;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.proposal.Proposal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageProcessor {

    private final List<String> messages;
    private Map<String, Proposal> proposal = new HashMap<>();

    public MessageProcessor(List<String> messages) {
        this.messages = messages;
        for (String msg : messages) {
            String[] attributes = msg.split(",");
            String proposalId = attributes[4];
            String schema = attributes[1];
            String action = attributes[2];
            proposal.putIfAbsent(proposalId, new Proposal(proposalId));
            Event event = EventFactory.newEvent(schema, action, attributes);
            proposal.put(event.getProposalId(), event.enrichmentProposal(proposal.get(event.getProposalId())));
        }
    }

    public String execute() {
        StringBuilder builder = new StringBuilder("");
        for (Proposal proposal: proposal.values()) {
            if (proposal.isValid()) {
                builder.append(proposal.getProposalId());
                builder.append(",");
            }
        }
        return  builder.toString().substring(0,builder.lastIndexOf(","));
    }
}
