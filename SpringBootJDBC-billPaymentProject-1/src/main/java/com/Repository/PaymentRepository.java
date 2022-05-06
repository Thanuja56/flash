package com.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Beans.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

