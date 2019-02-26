package ec.com.siga.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.siga.entity.Canton;
import ec.com.siga.entity.ProvinciaEstado;


@Repository("cantonRepository")
public interface CantonJpaRepository extends JpaRepository<Canton, Serializable>{
	public abstract List<Canton> findAllByProvinciaId(ProvinciaEstado provincia);
	
}
