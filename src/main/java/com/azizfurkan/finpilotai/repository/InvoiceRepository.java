package com.azizfurkan.finpilotai.repository;

import com.azizfurkan.finpilotai.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
