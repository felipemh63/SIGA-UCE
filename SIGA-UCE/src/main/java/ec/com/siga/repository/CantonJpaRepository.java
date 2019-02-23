package ec.com.siga.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.siga.entity.Canton;

@Repository("cantonRepository")
public interface CantonJpaRepository extends JpaRepository<Canton, Serializable>{
		
}
