package com.example.progettofinalehibernate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progettofinalehibernate.models.Cliente;
import com.example.progettofinalehibernate.models.Prodotto;
import com.example.progettofinalehibernate.repositories.ProdottoRepository;

@Service
public class ProdottoService {
	
	@Autowired
	private ProdottoRepository prodottoRepository;
	
	public List<Prodotto> getAllProdotti() {
		return prodottoRepository.findAll();
	}
	
	public Optional<Prodotto> getProdottoById(Long id) {
		return prodottoRepository.findById(id);
	}
	
	public Prodotto createProdotto(Prodotto newProdotto) {

		newProdotto = prodottoRepository.save(newProdotto);

        return newProdotto;
    }
	
	public Prodotto updateProdotto(long id, Prodotto updateProdotto) {
        Optional<Prodotto> optionalProdotto = prodottoRepository.findById(id);

        if (optionalProdotto.isEmpty()) {
            throw new IllegalStateException("Prodotto not found");
        }

        Prodotto prodottoToUpdate = optionalProdotto.get();

        updateProdotto.setId(prodottoToUpdate.getId());

        updateProdotto = prodottoRepository.save(updateProdotto);

        return updateProdotto;
    }
	
	public Prodotto deleteProdotto(long id) {
        Optional<Prodotto> optionalProdotto = prodottoRepository.findById(id);

        if (optionalProdotto.isEmpty()) {
            throw new IllegalStateException("Prodotto not found");
        }

        Prodotto prodottoToDelete = optionalProdotto.get();

        prodottoRepository.delete(prodottoToDelete);

        return prodottoToDelete;
    }
}
