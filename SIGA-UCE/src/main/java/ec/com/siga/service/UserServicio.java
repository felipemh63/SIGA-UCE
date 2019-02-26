package ec.com.siga.service;

import java.util.List;

import ec.com.siga.entity.User;

public interface UserServicio {
	public abstract List<User> findAll();
}
