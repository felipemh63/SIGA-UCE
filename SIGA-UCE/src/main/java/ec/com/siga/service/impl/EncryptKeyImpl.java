package ec.com.siga.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ec.com.siga.service.EncryptKey;

@Service("encryptKey")
public class EncryptKeyImpl implements EncryptKey {

	@Override
	public String encryptKey(String clave) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		return pe.encode(clave);
	}

}
