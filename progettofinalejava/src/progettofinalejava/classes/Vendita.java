package progettofinalejava.classes;

public class Vendita {
	
	private int id;
    private Cliente cliente;
    private Giocattolo giocattolo;
    private double importo;

    public Vendita(int id, Cliente cliente, Giocattolo giocattolo, double importo) {
        this.id = id;
        this.cliente = cliente;
        this.giocattolo = giocattolo;
        this.importo = importo;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Giocattolo getGiocattolo() {
        return giocattolo;
    }

    public double getImporto() {
        return importo;
    }
}
