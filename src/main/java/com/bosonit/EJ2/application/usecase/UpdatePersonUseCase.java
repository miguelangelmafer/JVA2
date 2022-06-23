package com.bosonit.EJ2.application.usecase;

import com.bosonit.EJ2.application.port.GetPersonPort;
import com.bosonit.EJ2.application.port.UpdatePersonaPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.exceptions.NotFoundException;
import com.bosonit.EJ2.exceptions.UnprocesableException;
import com.bosonit.EJ2.infraestructure.DTOs.InputPersonaDTO;
import com.bosonit.EJ2.infraestructure.DTOs.OutPutPersonaDTO;
import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonUseCase implements UpdatePersonaPort {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ModelMapper modelMapper;


    public OutPutPersonaDTO updatePerson(Integer id, InputPersonaDTO personaNew) {

        if (personaRepository.findById(id).isEmpty()){
            throw new NotFoundException("No se encuenta la persona con el id: " + id);
        }else{
            PersonaEnt personaEnt = new PersonaEnt();

            personaEnt.setId_persona(id);
            personaEnt.setUsuario(personaNew.usuario());
            personaEnt.setPassword(personaNew.password());
            personaEnt.setName(personaNew.name());
            personaEnt.setSurname(personaNew.surname());
            personaEnt.setCompany_email(personaNew.company_email());
            personaEnt.setPersona_email(personaNew.persona_email());
            personaEnt.setCity(personaNew.city());
            personaEnt.setActive(personaNew.active());
            personaEnt.setCreated_date(personaNew.created_date());
            personaEnt.setImagen_url(personaNew.imagen_url());
            personaEnt.setTermination_date(personaNew.termination_date());


            if (personaEnt.getUsuario().length() > 10) {
                throw new UnprocesableException("Usuario debe tener menos de 10 caracteres");
            }
            if(personaEnt.getUsuario() == null){
                throw new UnprocesableException("Usuario no puede ser nulo");
            }
            if(personaEnt.getPassword() == null){
                throw new UnprocesableException("Password no puede ser nula");
            }
            if(personaEnt.getName() == null){
                throw new UnprocesableException("Name no puede ser nulo");
            }
            if(personaEnt.getCompany_email() == null){
                throw new UnprocesableException("Company email no puede ser nulo");
            }
            if(personaEnt.getPersona_email() == null){
                throw new UnprocesableException("Persona email no puede ser nulo");
            }
            if(personaEnt.getCity() == null){
                throw new UnprocesableException("City no puede ser nulo");
            }
            if(personaEnt.getActive() == null){
                throw new UnprocesableException("Active no puede ser nulo");
            }
            if(personaEnt.getCreated_date() == null){
                throw new UnprocesableException("Created date no puede ser nulo");
            }
            personaRepository.save(personaEnt);

            OutPutPersonaDTO outPutPersonaDTO = new OutPutPersonaDTO(personaEnt.getId_persona(), personaEnt.getUsuario(), personaEnt.getPassword(), personaEnt.getName(), personaEnt.getSurname(), personaEnt.getCompany_email(), personaEnt.getPersona_email(), personaEnt.getCity(), personaEnt.getActive(), personaEnt.getCreated_date(), personaEnt.getImagen_url(), personaEnt.getTermination_date());
            return outPutPersonaDTO;
        }
    }
}