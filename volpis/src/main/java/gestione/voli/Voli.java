package gestione.voli;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.*;

public class Voli {
    private List<Volo> voli;

    public Voli() {
        this.voli = new ArrayList<>();
    }

    public void aggiungiVolo(Volo volo) {
        voli.add(volo);
    }

    public void rimuoviVolo(Volo volo) {
        voli.remove(volo);
    }

    public void modificaVolo(String codiceVolo, String aeroportoPartenza, String aeroportoArrivo, Date dataVolo, String oraPartenza, String oraArrivo, int numeroPosti, double costoVolo) {
        Volo volo = ricercaVolo(codiceVolo);
        if (volo != null) {
            volo.setAeroportoPartenza(aeroportoPartenza);
            volo.setAeroportoArrivo(aeroportoArrivo);
            volo.setDataVolo(dataVolo);
            volo.setOraPartenza(oraPartenza);
            volo.setOraArrivo(oraArrivo);
            volo.setNumeroPosti(numeroPosti);
            volo.setCostoVolo(costoVolo);
        }
    }
    
    public void rimuoviVolo(String codiceVolo) {
        for (Volo volo : voli) {
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                voli.remove(volo);
                break;
            }
        }
    }
    
    public Volo ricercaVolo(String codiceVolo) {
        for (Volo volo : voli) {
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                return volo;
            }
        }
        return null;
    }
    
    public List<Volo> ricercaVoli(Date dataVolo, String aeroportoPartenza, String aeroportoArrivo, String oraPartenza) {
        List<Volo> voliRicercati = new ArrayList<>();
        for (Volo volo : voli) {
            if (volo.getDataVolo().equals(dataVolo) &&
                volo.getAeroportoPartenza().equals(aeroportoPartenza) &&
                volo.getAeroportoArrivo().equals(aeroportoArrivo) &&
                volo.getOraPartenza().equals(oraPartenza)) {
                voliRicercati.add(volo);
            }
        }
        return voliRicercati;
    }
    
    public void salvaVoliSuFile(String nomeFile) {
        try (FileOutputStream fos = new FileOutputStream(nomeFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(voli);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void ripristinaVoliDaFile(String nomeFile) {
        try (FileInputStream fis = new FileInputStream(nomeFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            voli = (List<Volo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Volo> getVoli() {
        return voli;
    }
}