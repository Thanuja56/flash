package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Beans.Login;
import com.Repository.LoginRepository;

@Service
@Transactional
public class LoginService {
	@Autowired
	private LoginRepository logRepo1;
	public Login getObj(long a) {
		return logRepo1.findById(a).get();
		
	}
	public void saveAdmin(Login log) {
		logRepo1.save(log);
	}
	public List<Login> listadmin() {
		return logRepo1.findAll();
	}
	public void deleteAdmin(long id) {
		logRepo1.deleteById(id);
	}
	
}
