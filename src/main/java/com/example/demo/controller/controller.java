package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.interfaces.IUserServices;



@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class controller {

	private final IUserServices userService;

	public controller(IUserServices userService) {
		this.userService = userService;
	}

	@GetMapping("/listaruser")
	public List<User> index() {
		return userService.findAll();
	}

	@GetMapping("/user/{id}")
	public User showe(@PathVariable Long id) {
		return userService.findById(id);
	}

	
	@PostMapping("/usersave")
	public ResponseEntity<?> createproductos(@Validated @RequestBody User user, BindingResult result) {

		User userNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			userNew = userService.save(user);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "el usuario ha sido creado con éxito!");
		response.put("user", userNew);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}




	
	@PutMapping("/userup/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody User usuario, BindingResult result, @PathVariable Long id) {

		User usuActual = userService.findById(id);
		User usuUpdated = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (usuActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el cliente ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			usuActual.setFirstname(usuario.getFirstname());
			usuActual.setPassword(usuario.getPassword());
			usuUpdated = userService.save(usuActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la falta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido actualizado con éxito!");
		response.put("cliente", usuUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}




}
