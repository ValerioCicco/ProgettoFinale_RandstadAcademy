package progettofinalejava.classes;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
	private List<Giocattolo> giocattoli;

    public Inventario() {
        giocattoli = new ArrayList<>();
    }

    public void aggiungiGiocattolo(Giocattolo giocattolo) {
        giocattoli.add(giocattolo);
    }

    public List<Giocattolo> getGiocattoliDisponibili() {
        return giocattoli;
    }
}
