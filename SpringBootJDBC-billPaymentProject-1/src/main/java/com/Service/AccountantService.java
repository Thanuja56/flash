package com.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Beans.Accountant;
import com.Repository.AccountantRepository;

@Service
@Transactional
public class AccountantService {

	@Autowired
	private AccountantRepository repo;
	
	public List<Accountant> listAll() {
		return repo.findAll();
	}
	
	public void save(Accountant accountant) {
		repo.save(accountant);
	}
	
	public Accountant get(long aid) {
		return repo.findById(aid).get();
	}
	
	public void delete(long aid) {
		repo.deleteById(aid);
	}
}



