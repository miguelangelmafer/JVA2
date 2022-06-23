package com.bosonit.EJ2.infraestructure.DTOs;

import java.util.Date;
public record InputPersonaDTO (Integer id_persona, String usuario, Integer password, String name, String surname, String company_email, String persona_email, String city, Boolean active, Date created_date, String imagen_url, Date termination_date){

    //generamos un nuevo inputdto?
    public InputPersonaDTO(Integer id_persona, String usuario, Integer password, String name, String surname, String company_email, String persona_email, String city, Boolean active, Date created_date, String imagen_url, Date termination_date){
        this.id_persona=id_persona;
        this.usuario = usuario;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.persona_email = persona_email;
        this.city = city;
        this.active = active;
        this.created_date = created_date;
        this.imagen_url = imagen_url;
        this.termination_date = termination_date;
    }

    public Integer id_persona() {
        return this.id_persona;
    }

    public String usuario() {
        return this.usuario;
    }

    public Integer password() {
        return this.password;
    }

    public String name() {
        return this.name;
    }

    public String surname() {
        return this.surname;
    }

    public String company_email() {
        return this.company_email;
    }

    public String persona_email() {
        return this.persona_email;
    }

    public String city() {
        return this.city;
    }


    public Boolean active() {
        return this.active;
    }


    public Date created_date() {
        return this.created_date;
    }


    public String imagen_url() {
        return this.imagen_url;
    }


    public Date termination_date() {
        return this.termination_date;
    }


}





