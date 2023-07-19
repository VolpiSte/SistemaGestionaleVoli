package gestione.voli;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

public class GestioneVoliTest {

    @Test
    public void testAggiuntaCliente() {
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("Rossi", "Mario", "Italia", "Roma", new Date(), "CL001");
        clienti.aggiungiCliente(cliente);

        assertEquals(1, clienti.getClienti().size());
        assertEquals(cliente, clienti.getClienti().get(0));
    }

    @Test
    public void testEliminazioneCliente() {
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("Rossi", "Mario", "Italia", "Roma", new Date(), "CL001");
        clienti.aggiungiCliente(cliente);

        clienti.rimuoviCliente(cliente);

        assertEquals(0, clienti.getClienti().size());
    }

    @Test
    public void testModificaCliente() {
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("Rossi", "Mario", "Italia", "Roma", new Date(), "CL001");
        clienti.aggiungiCliente(cliente);

        String nuovoCognome = "Bianchi";
        cliente.setCognome(nuovoCognome);
        //clienti.modificaCliente(cliente);

        assertEquals(nuovoCognome, clienti.getClienti().get(0).getCognome());
    }

    @Test
    public void testRicercaClientePerCodice() {
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("Rossi", "Mario", "Italia", "Roma", new Date(), "CL001");
        clienti.aggiungiCliente(cliente);

        Cliente clienteTrovato = clienti.ricercaCliente("CL001");

        assertEquals(cliente, clienteTrovato);
    }

    @Test
    public void testRicercaClientePerCognomeENome() {
        Clienti clienti = new Clienti();
        Cliente cliente1 = new Cliente("Rossi", "Mario", "Italia", "Roma", new Date(), "CL001");
        Cliente cliente2 = new Cliente("Bianchi", "Luca", "Italia", "Milano", new Date(), "CL002");
        clienti.aggiungiCliente(cliente1);
        clienti.aggiungiCliente(cliente2);

        List<Cliente> clientiTrovati = clienti.ricercaClienti("Bianchi", "Luca");

        assertEquals(1, clientiTrovati.size());
        assertEquals(cliente2, clientiTrovati.get(0));
    }

    @Test
    public void testAggiuntaVolo() {
        Voli voli = new Voli();
        Volo volo = new Volo("V001", "Fiumicino", "Heathrow", new Date(), "10:00", "14:00", 200, 250.0);
        voli.aggiungiVolo(volo);

        assertEquals(1, voli.getVoli().size());
        assertEquals(volo, voli.getVoli().get(0));
    }

    @Test
    public void testEliminazioneVolo() {
        Voli voli = new Voli();
        Volo volo = new Volo("V001", "Fiumicino", "Heathrow", new Date(), "10:00", "14:00", 200, 250.0);
        voli.aggiungiVolo(volo);

        voli.rimuoviVolo(volo);

        assertEquals(0, voli.getVoli().size());
    }

    @Test
    public void testModificaVolo() {
        Voli voli = new Voli();
        Volo volo = new Volo("V001", "Fiumicino", "Heathrow", new Date(), "10:00", "14:00", 200, 250.0);
        voli.aggiungiVolo(volo);

        String nuovaAeroportoPartenza = "Ciampino";
        volo.setAeroportoPartenza(nuovaAeroportoPartenza);
        //voli.modificaVolo(volo);

        assertEquals(nuovaAeroportoPartenza, voli.getVoli().get(0).getAeroportoPartenza());
    }

    @Test
    public void testRicercaVoloPerCodice() {
        Voli voli = new Voli();
        Volo volo = new Volo("V001", "Fiumicino", "Heathrow", new Date(), "10:00", "14:00", 200, 250.0);
        voli.aggiungiVolo(volo);

        Volo voloTrovato = voli.ricercaVolo("V001");

        assertEquals(volo, voloTrovato);
    }

    @Test
    public void testRicercaVoloPerDataAeroportoEOraPartenza() {
        Voli voli = new Voli();
        Volo volo1 = new Volo("V001", "Fiumicino", "Heathrow", new Date(), "10:00", "14:00", 200, 250.0);
        Volo volo2 = new Volo("V002", "Fiumicino", "Heathrow", new Date(), "14:00", "18:00", 150, 200.0);
        voli.aggiungiVolo(volo1);
        voli.aggiungiVolo(volo2);

        List<Volo> voliTrovati = voli.ricercaVoli(new Date(), "Fiumicino", "Heathrow", "10:00");

        assertEquals(1, voliTrovati.size());
        assertEquals(volo1, voliTrovati.get(0));
    }

    @Test
    public void testAggiuntaPrenotazione() {
        Clienti clienti = new Clienti();
        Voli voli = new Voli();
        Prenotazioni prenotazioni = new Prenotazioni();
    
        Cliente cliente = new Cliente("Rossi", "Mario", "Italia", "Roma", new Date(), "CL001");
        Volo volo = new Volo("V001", "Fiumicino", "Heathrow", new Date(), "10:00", "14:00", 200, 250.0);
    
        clienti.aggiungiCliente(cliente);
        voli.aggiungiVolo(volo);
    
        Prenotazione prenotazione = new Prenotazione(cliente.getCodiceCliente(), volo.getCodiceVolo(), 1, 20);
        prenotazioni.aggiungiPrenotazione(prenotazione);
    
        assertEquals(1, prenotazioni.getPrenotazioni().size());
        assertEquals(prenotazione, prenotazioni.getPrenotazioni().get(0));
    }
     

    @Test
    public void testEliminazionePrenotazione() {
        Clienti clienti = new Clienti();
        Voli voli = new Voli();
        Prenotazioni prenotazioni = new Prenotazioni();

        Cliente cliente = new Cliente("Rossi", "Mario", "Italia", "Roma", new Date(), "CL001");
        Volo volo = new Volo("V001", "Fiumicino", "Heathrow", new Date(), "10:00", "14:00", 200, 250.0);

        clienti.aggiungiCliente(cliente);
        voli.aggiungiVolo(volo);

        Prenotazione prenotazione = new Prenotazione(cliente.getCodiceCliente(), volo.getCodiceVolo(), 0, 0);
        prenotazioni.aggiungiPrenotazione(prenotazione);

        prenotazioni.rimuoviPrenotazione(cliente.getCodiceCliente(), volo.getCodiceVolo());

        assertEquals(0, prenotazioni.getPrenotazioni().size());
    }

    @Test
    public void testModificaPrenotazione() {
        Clienti clienti = new Clienti();
        Voli voli = new Voli();
        Prenotazioni prenotazioni = new Prenotazioni();

        Cliente cliente = new Cliente("Rossi", "Mario", "Italia", "Roma", new Date(), "CL001");
        Volo volo = new Volo("V001", "Fiumicino", "Heathrow", new Date(), "10:00", "14:00", 200, 250.0);

        clienti.aggiungiCliente(cliente);
        voli.aggiungiVolo(volo);

        Prenotazione prenotazione = new Prenotazione(cliente.getCodiceCliente(), volo.getCodiceVolo(), 2, 10);
        prenotazioni.aggiungiPrenotazione(prenotazione);

        int nuovoNumeroBagagli = 2;
        prenotazione.setNumeroBagagli(nuovoNumeroBagagli);
        prenotazioni.modificaPrenotazione(cliente.getCodiceCliente(), volo.getCodiceVolo(), nuovoNumeroBagagli, prenotazione.getPesoComplessivo());

        assertEquals(nuovoNumeroBagagli, prenotazioni.getPrenotazioni().get(0).getNumeroBagagli());
    }

    @Test
    public void testRicercaPrenotazioniCliente() {
        Clienti clienti = new Clienti();
        Voli voli = new Voli();
        Prenotazioni prenotazioni = new Prenotazioni();

        Cliente cliente1 = new Cliente("Rossi", "Mario", "Italia", "Roma", new Date(), "CL001");
        Cliente cliente2 = new Cliente("Bianchi", "Luca", "Italia", "Milano", new Date(), "CL002");
        Volo volo = new Volo("V001", "Fiumicino", "Heathrow", new Date(), "10:00", "14:00", 200, 250.0);

        clienti.aggiungiCliente(cliente1);
        clienti.aggiungiCliente(cliente2);
        voli.aggiungiVolo(volo);

        Prenotazione prenotazione1 = new Prenotazione(cliente1.getCodiceCliente(), volo.getCodiceVolo(), 2, 40);
        Prenotazione prenotazione2 = new Prenotazione(cliente2.getCodiceCliente(), volo.getCodiceVolo(), 1, 15);

        prenotazioni.aggiungiPrenotazione(prenotazione1);
        prenotazioni.aggiungiPrenotazione(prenotazione2);

        List<Prenotazione> prenotazioniCliente = prenotazioni.ricercaPrenotazioniCliente(cliente1.getCodiceCliente());

        assertEquals(1, prenotazioniCliente.size());
        assertEquals(prenotazione1, prenotazioniCliente.get(0));
    }

    @Test
    public void testRicercaPrenotazioniVolo() {
        Clienti clienti = new Clienti();
        Voli voli = new Voli();
        Prenotazioni prenotazioni = new Prenotazioni();

        Cliente cliente = new Cliente("Rossi", "Mario", "Italia", "Roma", new Date(), "CL001");
        Volo volo1 = new Volo("V001", "Fiumicino", "Heathrow", new Date(), "10:00", "14:00", 200, 250.0);
        Volo volo2 = new Volo("V002", "Fiumicino", "Heathrow", new Date(), "14:00", "18:00", 150, 200.0);

        clienti.aggiungiCliente(cliente);
        voli.aggiungiVolo(volo1);
        voli.aggiungiVolo(volo2);

        Prenotazione prenotazione1 = new Prenotazione(cliente.getCodiceCliente(), volo1.getCodiceVolo(), 1, 12);
        Prenotazione prenotazione2 = new Prenotazione(cliente.getCodiceCliente(), volo2.getCodiceVolo(), 1, 10);

        prenotazioni.aggiungiPrenotazione(prenotazione1);
        prenotazioni.aggiungiPrenotazione(prenotazione2);

        List<Prenotazione> prenotazioniVolo = prenotazioni.ricercaPrenotazioniVolo(volo1.getCodiceVolo());

        assertEquals(1, prenotazioniVolo.size());
        assertEquals(prenotazione1, prenotazioniVolo.get(0));
    }
}
