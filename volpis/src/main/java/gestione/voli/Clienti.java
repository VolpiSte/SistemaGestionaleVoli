package gestione.voli;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.*;

public class Clienti {
    private List<Cliente> clienti;

    public Clienti() {
        this.clienti = new ArrayList<>();
    }

    public void aggiungiCliente(Cliente cliente) {
        clienti.add(cliente);
    }

    public void rimuoviCliente(Cliente cliente) {
        clienti.remove(cliente);
    }

    public void modificaCliente(String codiceCliente, String cognome, String nome, String nazioneNascita, String cittaNascita, Date dataNascita) {
        Cliente cliente = ricercaCliente(codiceCliente);
        if (cliente != null) {
            cliente.setCognome(cognome);
            cliente.setNome(nome);
            cliente.setNazioneNascita(nazioneNascita);
            cliente.setCittaNascita(cittaNascita);
            cliente.setDataNascita(dataNascita);
        }
    }
    
    public void rimuoviCliente(String codiceCliente) {
        for (Cliente cliente : clienti) {
            if (cliente.getCodiceCliente().equals(codiceCliente)) {
                clienti.remove(cliente);
                break;
            }
        }
    }
    
    public Cliente ricercaCliente(String codiceCliente) {
        for (Cliente cliente : clienti) {
            if (cliente.getCodiceCliente().equals(codiceCliente)) {
                return cliente;
            }
        }
        return null;
    }
    
    public List<Cliente> ricercaClienti(String cognome, String nome) {
        List<Cliente> clientiRicercati = new ArrayList<>();
        for (Cliente cliente : clienti) {
            if (cliente.getCognome().equals(cognome) && cliente.getNome().equals(nome)) {
                clientiRicercati.add(cliente);
            }
        }
        return clientiRicercati;
    }
    
    public void salvaClientiSuFile(String nomeFile) {
        try (FileOutputStream fos = new FileOutputStream(nomeFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(clienti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void ripristinaClientiDaFile(String nomeFile) {
        try (FileInputStream fis = new FileInputStream(nomeFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            clienti = (List<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> getClienti() {
        return clienti;
    }
}