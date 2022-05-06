package com.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Beans.Payment;
import com.Repository.PaymentRepository;

@Service
@Transactional

public class PaymentService {
	@Autowired
	private PaymentRepository repo;
	
	public List<Payment> listAll() {
		return repo.findAll();
	}
	
	public void save(Payment billing) {
		repo.save(billing);
	}
	
	public Payment get(long pid) {
		return repo.findById(pid).get();
	}

	public void delete(long pid) {
		repo.deleteById(pid);
	}
	}

	

