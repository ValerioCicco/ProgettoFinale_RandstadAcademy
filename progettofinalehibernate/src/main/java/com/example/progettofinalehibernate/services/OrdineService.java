package com.example.progettofinalehibernate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progettofinalehibernate.models.Ordine;
import com.example.progettofinalehibernate.repositories.OrdineRepository;

@Service
public class OrdineService {

	@Autowired
	private OrdineRepository ordineRepository;

	public List<Ordine> getAllOrdini() {
		return ordineRepository.findAll();
	}

	public Optional<Ordine> getOrdineById(Long id) {
		return ordineRepository.findById(id);
	}
	
	public Ordine createOrdine(Ordine newOrdine) {

		if (newOrdine.getCliente() == null || newOrdine.getProdotti() == null) {
			throw new IllegalStateException("Cliente and Prodotti must not be null");
		}

		newOrdine = ordineRepository.save(newOrdine);

		return newOrdine;
	}
	
	public Ordine updateOrdine(long id, Ordine updateOrdine) {
		if (updateOrdine.getCliente() == null || updateOrdine.getProdotti() == null) {
			throw new IllegalStateException("Cliente and Prodotti must not be null");
		}

        Optional<Ordine> optionalOrdine = ordineRepository.findById(id);
        if (optionalOrdine.isEmpty()) {
            throw new IllegalStateException("Ordine not found");
        }

        Ordine ordineToUpdate = optionalOrdine.get();

        updateOrdine.setId(ordineToUpdate.getId());

        updateOrdine = ordineRepository.save(updateOrdine);

        return updateOrdine;
    }
	
	public Ordine deleteOrdine(long id) {
        Optional<Ordine> optionalOrdine = ordineRepository.findById(id);

        if (optionalOrdine.isEmpty()) {
            throw new IllegalStateException("Ordine not found");
        }

        Ordine ordineToDelete = optionalOrdine.get();

        ordineRepository.delete(ordineToDelete);

        return ordineToDelete;
    }
}
