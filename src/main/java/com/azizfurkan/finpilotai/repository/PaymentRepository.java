package com.azizfurkan.finpilotai.repository;

import com.azizfurkan.finpilotai.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
