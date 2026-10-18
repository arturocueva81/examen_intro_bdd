package com.krakedev.fitzone.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.krakedev.fitzone.entidades.Socio;
import com.krakedev.fitzone.repository.SocioRepository;

@Service
public class ServicioSocio {

	private final SocioRepository repository;

	public ServicioSocio(SocioRepository repository) {
		this.repository = repository;
	}

	public Socio crear(Socio soc) {
		if (soc.getEdad() < 14) {
			throw new IllegalArgumentException("Edad minima permitida es: 14 años.");
		}
		return repository.save(soc);
	}

	public List<Socio> listar() {
		return repository.findAll();
	}

	public List<Socio> buscarPorEstado(boolean activo) {
		return repository.findByActivo(activo);
	}
}