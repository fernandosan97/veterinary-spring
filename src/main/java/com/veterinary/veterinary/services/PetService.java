package com.veterinary.veterinary.services;

import com.veterinary.veterinary.models.PetModel;
import com.veterinary.veterinary.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public ArrayList<PetModel> getPets() {
        return petRepository.getPets();
    }

    public PetModel savePet(PetModel petModel) {
        return petRepository.savePet(petModel.getName(), petModel.getTypeAnimal(), petModel.getAge());
    }
}
