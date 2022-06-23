package com.bosonit.EJ2.application.usecase;


import com.bosonit.EJ2.application.port.CreatePersonPort;
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
public class CreatePersonUseCase implements CreatePersonPort {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ModelMapper modelMapper;

    public OutPutPersonaDTO addPersona(InputPersonaDTO inputPersonaDTO) throws Exception {
        if(inputPersonaDTO.usuario()==null){
            throw new UnprocesableException("El usuario no puede ser nulo");
        }
        if(inputPersonaDTO.password()==null){
            throw new UnprocesableException("La password no puede ser nula");
        }
        if(inputPersonaDTO.name()==null){
            throw new UnprocesableException("El name no puede ser nulo");
        }
        if(inputPersonaDTO.company_email()==null){
            throw new UnprocesableException("El Company Email no puede ser nulo");
        }
        if(inputPersonaDTO.persona_email()==null){
            throw new UnprocesableException("El Persona Email no puede ser nulo");
        }
        if(inputPersonaDTO.city()==null){
            throw new UnprocesableException("La city no puede ser nula");
        }
        if(inputPersonaDTO.active()==null){
            throw new UnprocesableException("El campo active no puede ser nulo");
        }
        if(inputPersonaDTO.created_date()==null){
            throw new UnprocesableException("El campo created date no puede ser nulo");
        }
        if (inputPersonaDTO.usuario().length() > 10){
            throw new UnprocesableException("El usuario no debe tener más de 10 caracteres");}

        //Nuevo objeto de la clase Personaent

        PersonaEnt persona = new PersonaEnt();

        persona.setUsuario(inputPersonaDTO.usuario());
        persona.setPassword(inputPersonaDTO.password());
        persona.setName(inputPersonaDTO.name());
        persona.setSurname(inputPersonaDTO.surname());
        persona.setCompany_email(inputPersonaDTO.company_email());
        persona.setPersona_email(inputPersonaDTO.persona_email());
        persona.setCity(inputPersonaDTO.city());
        persona.setActive(inputPersonaDTO.active());
        persona.setCreated_date(inputPersonaDTO.created_date());
        persona.setImagen_url(inputPersonaDTO.imagen_url());
        persona.setTermination_date(inputPersonaDTO.termination_date());
        personaRepository.save(persona);

        OutPutPersonaDTO output = new OutPutPersonaDTO(persona.getId_persona(), persona.getUsuario(), persona.getPassword(), persona.getName(), persona.getSurname(), persona.getCompany_email(), persona.getPersona_email(), persona.getCity(), persona.getActive(), persona.getCreated_date(), persona.getImagen_url(), persona.getTermination_date());
        return output;

        }
    }

