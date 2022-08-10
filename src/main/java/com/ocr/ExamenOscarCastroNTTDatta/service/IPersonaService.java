package com.ocr.ExamenOscarCastroNTTDatta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ocr.ExamenOscarCastroNTTDatta.entity.PersonaEntity;
import com.ocr.ExamenOscarCastroNTTDatta.model.RequestPersona;

public interface IPersonaService {
	
	Page<PersonaEntity> getAll(Pageable pageable);
	
	PersonaEntity getByIdPersona(Long idPersona);
	
	PersonaEntity create(RequestPersona newreRequestPersona);
	
	PersonaEntity update(Long idPersona,RequestPersona newreRequestPersona);
	
	
}
