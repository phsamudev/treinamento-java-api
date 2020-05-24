package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.CreateUserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
	public User create(@RequestBody final CreateUserDTO dto) throws Exception {
    return userService.create(dto.getEmail(), dto.getPassword());
	}
	
  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
	public List<User> getAll() {
		return userService.getAll();
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
  @ResponseBody
  public User get(@PathVariable final String userId) {
    return userService.get(userId);
  }
}
