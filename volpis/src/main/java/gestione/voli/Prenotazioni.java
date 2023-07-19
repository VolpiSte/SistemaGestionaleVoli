package gestione.voli;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prenotazioni {
    private Map<String, Prenotazione> prenotazioni;

    public Prenotazioni() {
        this.prenotazioni = new HashMap<>();
    }

    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        String key = prenotazione.getCodiceCliente() + "_" + prenotazione.getCodiceVolo();
        prenotazioni.put(key, prenotazione);
    }

    public void rimuoviPrenotazione(String codiceCliente, String codiceVolo) {
        String key = codiceCliente + "_" + codiceVolo;
        prenotazioni.remove(key);
    }

    public void modificaPrenotazione(String codiceCliente, String codiceVolo, int numeroBagagli, double pesoComplessivo) {
    String key = codiceCliente + "_" + codiceVolo;
    Prenotazione prenotazione = prenotazioni.get(key);
        if (prenotazione != null) {
            prenotazione.setNumeroBagagli(numeroBagagli);
            prenotazione.setPesoComplessivo(pesoComplessivo);
            prenotazioni.put(key, prenotazione);
        }
    }

    public Prenotazione ricercaPrenotazione(String codiceCliente, String codiceVolo) {
        String key = codiceCliente + "_" + codiceVolo;
        return prenotazioni.get(key);
    }

    public List<Prenotazione> ricercaPrenotazioniCliente(String codiceCliente) {
        List<Prenotazione> prenotazioniCliente = new ArrayList<>();
        for (Prenotazione prenotazione : prenotazioni.values()) {
            if (prenotazione.getCodiceCliente().equals(codiceCliente)) {
                prenotazioniCliente.add(prenotazione);
            }
        }
        return prenotazioniCliente;
    }

    public List<Prenotazione> ricercaPrenotazioniVolo(String codiceVolo) {
        List<Prenotazione> prenotazioniVolo = new ArrayList<>();
        for (Prenotazione prenotazione : prenotazioni.values()) {
            if (prenotazione.getCodiceVolo().equals(codiceVolo)) {
                prenotazioniVolo.add(prenotazione);
            }
        }
        return prenotazioniVolo;
    }

    public void salvaPrenotazioniSuFile(String nomeFile) {
        try (FileOutputStream fos = new FileOutputStream(nomeFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(prenotazioni);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void ripristinaPrenotazioniDaFile(String nomeFile) {
        try (FileInputStream fis = new FileInputStream(nomeFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            prenotazioni = (Map<String, Prenotazione>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Prenotazione> getPrenotazioni() {
        return new ArrayList<>(prenotazioni.values());
    }
    
}
