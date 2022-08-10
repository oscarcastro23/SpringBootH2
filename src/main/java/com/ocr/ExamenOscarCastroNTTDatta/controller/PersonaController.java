package com.ocr.ExamenOscarCastroNTTDatta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ocr.ExamenOscarCastroNTTDatta.entity.PersonaEntity;
import com.ocr.ExamenOscarCastroNTTDatta.model.RequestPersona;
import com.ocr.ExamenOscarCastroNTTDatta.service.IPersonaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/public/person")
public class PersonaController {

	@Autowired
	IPersonaService personaService;
	
	@Operation(summary = "muestra toda la informacion de persona")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Empleados encontrados con éxito."),
			@ApiResponse(responseCode = "404", description = "Atributos no validos", content = {
					@Content(mediaType = "application/json") }), })
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Page<PersonaEntity>> findAll(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(this.personaService.getAll(pageable));
	}
	
	
	@Operation(summary = "muestra toda la informacion de persona")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Empleados encontrados con éxito."),
			@ApiResponse(responseCode = "404", description = "Atributos no validos", content = {
					@Content(mediaType = "application/json") }), })
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/{idPerson}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<PersonaEntity> getByIDPersona(
			@PathVariable(value = "idPerson", required = true) Long idPerson) {
		return ResponseEntity.status(HttpStatus.OK).body(this.personaService.getByIdPersona(idPerson));
	}

	@Operation(summary = "registra empleado")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Empleado creado con éxito."),
			@ApiResponse(responseCode = "404", description = "Atributos no encontrado"),
			@ApiResponse(responseCode = "500", description = "Error Internal Server") })
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path = "/")
	private ResponseEntity<PersonaEntity> create(@RequestBody RequestPersona requestPersona) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.personaService.create(requestPersona));
	}

	@Operation(summary = "registra empleado")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Empleado creado con éxito."),
			@ApiResponse(responseCode = "404", description = "Atributos no encontrado"),
			@ApiResponse(responseCode = "500", description = "Error Internal Server") })
	@ResponseStatus(code = HttpStatus.CREATED)
	@PutMapping(path = "/{idPerson}")
	private ResponseEntity<PersonaEntity> update(@PathVariable(value = "idPerson", required = true) Long idPerson,
			@RequestBody RequestPersona requestPersona) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.personaService.update(idPerson, requestPersona));
	}
}
