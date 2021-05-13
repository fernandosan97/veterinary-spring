package com.veterinary.veterinary.repositories;

import com.veterinary.veterinary.models.AppointmentModel;
import com.veterinary.veterinary.models.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceModel, Integer> {
    @Query(value = "{call SP_Get_Invoices()}", nativeQuery = true)
    ArrayList<InvoiceModel> getInvoices();

    @Query(value = "{call SP_Insert_Invoice(:idAppointment, :total)}", nativeQuery = true)
    InvoiceModel saveInvoice(
            @Param("idAppointment") Integer idAppointment,
            @Param("total")  Double total
    );
}
