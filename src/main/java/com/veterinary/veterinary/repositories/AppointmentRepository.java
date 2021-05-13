package com.veterinary.veterinary.repositories;

import com.veterinary.veterinary.models.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, Integer> {
    @Query(value = "{call SP_Get_Appointments()}", nativeQuery = true)
    ArrayList<AppointmentModel> getAppointments();

    @Query(value = "{call SP_Insert_Appointments(:idPet, :motive, :dates)}", nativeQuery = true)
    AppointmentModel saveAppointment(
            @Param("idPet") Integer idPet,
            @Param("motive") String motive,
            @Param("dates") String dates
    );

    @Query(value = "{call SP_Get_History_Pet(:idPet)}", nativeQuery = true)
    ArrayList<AppointmentModel> getHistoryPet(@Param("idPet") Integer idPet);
}
