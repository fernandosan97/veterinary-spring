package com.veterinary.veterinary.controllers;

import com.veterinary.veterinary.models.AppointmentModel;
import com.veterinary.veterinary.models.InvoiceModel;
import com.veterinary.veterinary.services.AppointmentService;
import com.veterinary.veterinary.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/")
    public ArrayList<InvoiceModel> getInvoices() {
        return invoiceService.getInvoices();
    }

    @PostMapping("/create")
    public InvoiceModel create(@RequestParam("idAppointment") Integer idAppointment, @RequestParam("total") Double total) {
        InvoiceModel objInvoice = new InvoiceModel();
        objInvoice.setIdAppointment(idAppointment);
        objInvoice.setTotal(total);

        return invoiceService.saveInvoice(objInvoice);
    }
}
