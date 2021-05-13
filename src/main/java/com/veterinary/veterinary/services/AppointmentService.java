package com.veterinary.veterinary.services;

import com.veterinary.veterinary.models.AppointmentModel;
import com.veterinary.veterinary.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    public ArrayList<AppointmentModel> getAppointments() {
        return appointmentRepository.getAppointments();
    }

    public AppointmentModel saveAppointments(AppointmentModel appointmentModel) {
        return appointmentRepository.saveAppointment(appointmentModel.getIdPet(), appointmentModel.getMotive(), appointmentModel.getDate());
    }

    public ArrayList<AppointmentModel> getHistoryPet(Integer idPet) {
        return appointmentRepository.getHistoryPet(idPet);
    }
}
