package com.example.progettofinalehibernate.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordine")
public class Ordine {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "dataOrdine")
	private LocalDate dataOrdine;
	
	@ManyToOne()
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(
			name = "prodotti_ordinati", //nome tabella pivot
			joinColumns = @JoinColumn(name = "id_ordine"), //PK associata a questa tabella
			inverseJoinColumns = @JoinColumn(name = "id_prodotto")) //PK associata alla tabella prodotto (lo sa perché il tipo della lista è "Prodotto")
	List<Prodotto> prodotti = new ArrayList<>();
	
	public Ordine() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(LocalDate dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	
	
}
