package com.ocr.ExamenOscarCastroNTTDatta.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "persona")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Getter
@Setter 
public class PersonaEntity implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6973748592826507739L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_person")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private Date age;
}
