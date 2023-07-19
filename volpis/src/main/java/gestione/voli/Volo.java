package gestione.voli;

import java.util.Date;

public class Volo {
    private String codiceVolo;
    private String aeroportoPartenza;
    private String aeroportoArrivo;
    private Date dataVolo;
    private String oraPartenza;
    private String oraArrivo;
    private int numeroPosti;
    private double costoVolo;

    // Costruttore
    public Volo(String codiceVolo, String aeroportoPartenza, String aeroportoArrivo, Date dataVolo, String oraPartenza, String oraArrivo, int numeroPosti, double costoVolo) {
        this.codiceVolo = codiceVolo;
        this.aeroportoPartenza = aeroportoPartenza;
        this.aeroportoArrivo = aeroportoArrivo;
        this.dataVolo = dataVolo;
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
        this.numeroPosti = numeroPosti;
        this.costoVolo = costoVolo;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public void setCodiceVolo(String codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

    public String getAeroportoPartenza() {
        return aeroportoPartenza;
    }

    public void setAeroportoPartenza(String aeroportoPartenza) {
        this.aeroportoPartenza = aeroportoPartenza;
    }

    public String getAeroportoArrivo() {
        return aeroportoArrivo;
    }

    public void setAeroportoArrivo(String aeroportoArrivo) {
        this.aeroportoArrivo = aeroportoArrivo;
    }

    public Date getDataVolo() {
        return dataVolo;
    }

    public void setDataVolo(Date dataVolo) {
        this.dataVolo = dataVolo;
    }

    public String getOraPartenza() {
        return oraPartenza;
    }

    public void setOraPartenza(String oraPartenza) {
        this.oraPartenza = oraPartenza;
    }

    public String getOraArrivo() {
        return oraArrivo;
    }

    public void setOraArrivo(String oraArrivo) {
        this.oraArrivo = oraArrivo;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public double getCostoVolo() {
        return costoVolo;
    }

    public void setCostoVolo(double costoVolo) {
        this.costoVolo = costoVolo;
    }

}
