package com.ocr.ExamenOscarCastroNTTDatta.model;

import java.util.Date;

import javax.persistence.Column;

import com.ocr.ExamenOscarCastroNTTDatta.entity.PersonaEntity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Getter
@Setter
public class RequestPersona {
	
	private String name;
	
	
	private String lastName;
	
	
	private String age;
}
