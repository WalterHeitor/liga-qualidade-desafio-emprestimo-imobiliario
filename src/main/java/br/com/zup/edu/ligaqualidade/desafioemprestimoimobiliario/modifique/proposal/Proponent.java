package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.proposal;

public class Proponent {
    private String proponentName;
    private String proponentAge;
    private String proponentMonthlyIncome;
    private String proponentIsMain;

    public Proponent(String proponentName, String proponentAge, String proponentMonthlyIncome, String proponentIsMain) {
        this.proponentName = proponentName;
        this.proponentAge = proponentAge;
        this.proponentMonthlyIncome = proponentMonthlyIncome;
        this.proponentIsMain = proponentIsMain;
    }

    public String getProponentName() {
        return proponentName;
    }

    public void setProponentName(String proponentName) {
        this.proponentName = proponentName;
    }

    public String getProponentAge() {
        return proponentAge;
    }

    public void setProponentAge(String proponentAge) {
        this.proponentAge = proponentAge;
    }

    public String getProponentMonthlyIncome() {
        return proponentMonthlyIncome;
    }

    public void setProponentMonthlyIncome(String proponentMonthlyIncome) {
        this.proponentMonthlyIncome = proponentMonthlyIncome;
    }

    public String getProponentIsMain() {
        return proponentIsMain;
    }

    public void setProponentIsMain(String proponentIsMain) {
        this.proponentIsMain = proponentIsMain;
    }
}