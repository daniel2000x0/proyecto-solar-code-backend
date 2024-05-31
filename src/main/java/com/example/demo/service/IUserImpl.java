package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserdao;
import com.example.demo.entity.User;
import com.example.demo.interfaces.IUserServices;
@Service 
public class IUserImpl implements IUserServices {
	@Autowired
	private IUserdao userdao;
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userdao.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userdao.findAll();
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Long  id) {
		// TODO Auto-generated method stub
		return userdao.findById(id).get();
	}

}
