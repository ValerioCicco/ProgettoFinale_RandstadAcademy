package com.example.progettofinalehibernate.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "prodotto")
public class Prodotto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "prezzo", nullable = false)
	private float prezzo;
	
	@Column(name = "qta", nullable = false)
	private int qta;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "prodotti") //mapped by ha il nome della variabile presente nell'altra tabella
	List<Ordine> ordini = new ArrayList<>();

	public Prodotto(Long id, String nome, float prezzo, int qta) {
		super();
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
		this.qta = qta;
	}
	
	public Prodotto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
	
	
}
