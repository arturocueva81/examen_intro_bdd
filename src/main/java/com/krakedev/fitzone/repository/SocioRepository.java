package com.krakedev.fitzone.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.krakedev.fitzone.entidades.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long> {

	List<Socio> findByActivo(boolean activo);
}