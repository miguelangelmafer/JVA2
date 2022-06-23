package com.bosonit.EJ2.application.usecase;

import com.bosonit.EJ2.application.port.DeletePersonPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.exceptions.NotFoundException;
import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonUseCase implements DeletePersonPort {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    GetPersonUseCase getPersonUseCase;
    @Autowired
    ModelMapper modelMapper;

    public String deletePerson(Integer id){
        try {
            PersonaEnt personaEnt = new PersonaEnt();

            personaEnt.setId_persona(id);
            personaEnt.setUsuario(getPersonUseCase.getPersonaByID(id).usuario());
            personaEnt.setPassword(getPersonUseCase.getPersonaByID(id).password());
            personaEnt.setName(getPersonUseCase.getPersonaByID(id).name());
            personaEnt.setSurname(getPersonUseCase.getPersonaByID(id).surname());
            personaEnt.setCompany_email(getPersonUseCase.getPersonaByID(id).company_email());
            personaEnt.setPersona_email(getPersonUseCase.getPersonaByID(id).persona_email());
            personaEnt.setCity(getPersonUseCase.getPersonaByID(id).city());
            personaEnt.setActive(getPersonUseCase.getPersonaByID(id).active());
            personaEnt.setCreated_date(getPersonUseCase.getPersonaByID(id).created_date());
            personaEnt.setImagen_url(getPersonUseCase.getPersonaByID(id).imagen_url());
            personaEnt.setTermination_date(getPersonUseCase.getPersonaByID(id).termination_date());
            personaRepository.delete(personaEnt);

            return "Persona eliminada";
        } catch (Exception e) {
            throw new NotFoundException("El ususario: " + id + " no existe y no se puede eliminar");
        }
    }
}
