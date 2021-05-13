package com.veterinary.veterinary.controllers;

import com.veterinary.veterinary.models.AppointmentModel;
import com.veterinary.veterinary.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/")
    public ArrayList<AppointmentModel> getAppointments() {
        return appointmentService.getAppointments();
    }

    @PostMapping("/create")
    public AppointmentModel create(@RequestParam("idPet") Integer idPet, @RequestParam("motive") String motive, @RequestParam("date") String dates) {
        AppointmentModel objAppointment = new AppointmentModel();
        objAppointment.setIdPet(idPet);
        objAppointment.setMotive(motive);
        objAppointment.setDate(dates);

        return appointmentService.saveAppointments(objAppointment);
    }

    @GetMapping("/history")
    public ArrayList<AppointmentModel> getHistoryPet(@RequestParam(value = "idpet", defaultValue = "0") Integer idPet) {
        return appointmentService.getHistoryPet(idPet);
    }
}
