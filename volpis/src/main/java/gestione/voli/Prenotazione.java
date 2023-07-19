package gestione.voli;

public class Prenotazione {
    private String codiceCliente;
    private String codiceVolo;
    private int numeroBagagli;
    private double pesoComplessivo;

    public Prenotazione(String codiceCliente, String codiceVolo, int numeroBagagli, double pesoComplessivo) {
        this.codiceCliente = codiceCliente;
        this.codiceVolo = codiceVolo;
        this.numeroBagagli = numeroBagagli;
        this.pesoComplessivo = pesoComplessivo;
    }

    public String getCodiceCliente() {
        return codiceCliente;
    }

    public void setCodiceCliente(String codiceCliente) {
        this.codiceCliente = codiceCliente;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public void setCodiceVolo(String codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

    public int getNumeroBagagli() {
        return numeroBagagli;
    }

    public void setNumeroBagagli(int numeroBagagli) {
        this.numeroBagagli = numeroBagagli;
    }

    public double getPesoComplessivo() {
        return pesoComplessivo;
    }

    public void setPesoComplessivo(double pesoComplessivo) {
        this.pesoComplessivo = pesoComplessivo;
    }

}
