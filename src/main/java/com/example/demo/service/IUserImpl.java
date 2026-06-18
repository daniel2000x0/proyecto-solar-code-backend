package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserdao;
import com.example.demo.entity.User;
import com.example.demo.interfaces.IUserServices;

@Service
public class IUserImpl implements IUserServices {

	private final IUserdao userdao;

	public IUserImpl(IUserdao userdao) {
		this.userdao = userdao;
	}

	@Override
	public User save(User user) {
		return userdao.save(user);
	}

	@Override
	public List<User> findAll() {
		return userdao.findAll();
	}

	@Override
	public User update(User user) {
		return userdao.save(user);
	}

	@Override
	public User findById(Long id) {
		return userdao.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}

}
