package com.veterinary.veterinary.services;

import com.veterinary.veterinary.models.AppointmentModel;
import com.veterinary.veterinary.models.InvoiceModel;
import com.veterinary.veterinary.repositories.AppointmentRepository;
import com.veterinary.veterinary.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public ArrayList<InvoiceModel> getInvoices() {
        return invoiceRepository.getInvoices();
    }

    public InvoiceModel saveInvoice(InvoiceModel invoiceModel) {
        return invoiceRepository.saveInvoice(invoiceModel.getIdAppointment(), invoiceModel.getTotal());
    }
}
