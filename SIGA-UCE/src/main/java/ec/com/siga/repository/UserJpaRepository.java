package ec.com.siga.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.siga.entity.User;

@Repository("userRepository")
public interface UserJpaRepository extends JpaRepository<User, Serializable>{
	
	public abstract User findByUsuario(String usuario); // usa spring security para devolver el usuario logiado
	
}
