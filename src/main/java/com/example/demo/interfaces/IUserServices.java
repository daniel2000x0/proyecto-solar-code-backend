package com.example.demo.interfaces;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.User;




public interface IUserServices {
	public User save(User user);
	public List<User> findAll();
	public User update(User user);
	public User findById(Long id);

}
