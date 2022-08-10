package com.ocr.ExamenOscarCastroNTTDatta.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocr.ExamenOscarCastroNTTDatta.entity.PersonaEntity;
import com.ocr.ExamenOscarCastroNTTDatta.model.RequestPersona;
import com.ocr.ExamenOscarCastroNTTDatta.repository.IPersonaRepository;
import com.ocr.ExamenOscarCastroNTTDatta.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	
	@Autowired
	IPersonaRepository personaRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	@Transactional(readOnly = true)
	public PersonaEntity getByIdPersona(Long idPersona) {
		// TODO Auto-generated method stub
		return this.personaRepository.findById(idPersona).orElse(null);
	}

	@Override
	@Transactional
	public PersonaEntity create(RequestPersona newreRequestPersona) {
		// TODO Auto-generated method stub
		PersonaEntity newPersonaEntity = modelMapper.map(newreRequestPersona, PersonaEntity.class);
		return this.personaRepository.save(newPersonaEntity);
	}

	@Override
	@Transactional
	public PersonaEntity update(Long idPersona, RequestPersona newreRequestPersona) {
		// TODO Auto-generated method stub
		Boolean exist = this.personaRepository.existsById(idPersona);
		
		if (exist) {
		 PersonaEntity personaEntity = this.personaRepository.findById(idPersona).orElse(null);
		 PersonaEntity newPersonaEntity = modelMapper.map(newreRequestPersona, PersonaEntity.class);
		 personaEntity.setName(newPersonaEntity.getName());
		 personaEntity.setLastName(newPersonaEntity.getLastName());
		 personaEntity.setAge(newPersonaEntity.getAge());
		 return this.personaRepository.save(personaEntity);
		}
		
		return null;
	}

	@Override
	public Page<PersonaEntity> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.personaRepository.findAll(pageable);
	}

	

}
