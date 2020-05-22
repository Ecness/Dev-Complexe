package com.application.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Questionaire;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.MediaType;

@RestController( "restController" )
public class RestControlleur {

	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	@RequestMapping( value = "/restController/test" )
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "EnseignantFavoris found"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal error") })
	public String getInformation (@RequestBody Questionaire questionaire) {

		int etat = etatPatient(questionaire);
		if (etat < 10) {
			String message = "Rester chez vous. Si des symptomes persiste au bout d'une semaine ou s'agrave consulter l'avis d'un médecin";
			if (questionaire.getContact()) {
				message+="Rester en quarantaine pour les 14 prochains jours.";
			}
			return message;
		}
		if (etat < 15) {
			return "Consulter l'avis de votre medecin traitant, rester en quarantaine pour les 14 prochains jours. Si des symptomes persiste au bout d'une semaine ou s'agrave consulter l'avis d'un médecin";
		}
		return "Consulter votre medecin traitant pour une validation de ca part. Rester en quarantaine pour les 14 prochains jours si celui-ci vous l'autorise sinon consulter l'avie du 15.";
	}

	private int etatPatient(Questionaire questionaire) {

		return etatAge(questionaire.getAge()) + symptome(questionaire);
	}

	private int etatAge(int age) {

		if (age < 20) {
			return -5;
		}
		if (age < 30) {
			return 0;
		}
		if (age < 50) {
			return 2;
		}
		return 5;
	}
	
	private int symptome(Questionaire questionaire) {

		int etat = 0;
		
		if (questionaire.getDiabete()) {
			etat+=5;
		}
		if (questionaire.getFievre()) {
			etat+=2;
		}
		if (questionaire.getToux()) {
			etat+=3;
		}
		if (questionaire.getContact()) {
			etat+=5;
		}
		return etat;
	}
	
	
}
