package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.proposal;

import java.util.ArrayList;
import java.util.List;

public class Proposal {
    private boolean isValid = false;

    private String proposalId;
    private String proposalLoanValue;
    private String proposalNumberOfMonthlyInstallments;

    public String getProposalLoanValue() {
        return proposalLoanValue;
    }

    public String getProposalNumberOfMonthlyInstallments() {
        return proposalNumberOfMonthlyInstallments;
    }

    public List<Proponent> getProponentList() {
        return proponentList;
    }

    public void setProponentList(List<Proponent> proponentList) {
        this.proponentList = proponentList;
    }

    private List<Proponent> proponentList = new ArrayList<>();



    public Proposal(String proposalId) {
        this.proposalId = proposalId;
    }

    public Proposal setValid(boolean valid) {
        this.isValid = valid;
        return this;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getProposalId() {
        return proposalId;
    }

    public void setProposalId(String proposalId) {
        this.proposalId = proposalId;
    }

    public void setProposalLoanValue(String proposalLoanValue) {
        this.proposalLoanValue = proposalLoanValue;
    }

    public void setProposalNumberOfMonthlyInstallments(String proposalNumberOfMonthlyInstallments) {
        this.proposalNumberOfMonthlyInstallments = proposalNumberOfMonthlyInstallments;
    }


}
