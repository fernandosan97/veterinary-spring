package com.veterinary.veterinary.controllers;

import com.veterinary.veterinary.models.PetModel;
import com.veterinary.veterinary.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    @Autowired
    PetService petService;

    @GetMapping("/")
    public ArrayList<PetModel> getPets() {
        return petService.getPets();
    }

    @PostMapping("/create")
    public PetModel create(@RequestParam("name") String name, @RequestParam("typeAnimal") String typeAnimal, @RequestParam("age") Integer age) {
        PetModel objPet = new PetModel();
        objPet.setName(name);
        objPet.setTypeAnimal(typeAnimal);
        objPet.setAge(age);

        return petService.savePet(objPet);
    }
}
