package ec.com.siga.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.siga.entity.Pais;
import ec.com.siga.entity.ProvinciaEstado;

@Repository("provinciaRepository")
public interface ProvinciaJpaRepository extends JpaRepository<ProvinciaEstado, Serializable>{
	
	public abstract List<ProvinciaEstado> findByPaisId(Pais paisId);
	
}
