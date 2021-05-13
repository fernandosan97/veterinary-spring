package com.veterinary.veterinary.repositories;

import com.veterinary.veterinary.models.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PetRepository extends JpaRepository<PetModel, Integer> {
    @Query(value = "{call SP_Get_Pets()}", nativeQuery = true)
    ArrayList<PetModel> getPets();

    @Query(value = "{call SP_Insert_Pet(:name, :typeAnimal, :age)}", nativeQuery = true)
    PetModel savePet(
            @Param("name") String name,
            @Param("typeAnimal") String typeAnimal,
            @Param("age") Integer age
    );
}
