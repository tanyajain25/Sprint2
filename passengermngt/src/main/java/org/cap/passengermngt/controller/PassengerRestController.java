package org.cap.passengermngt.controller;

import org.cap.passengermngt.dto.RequestPassengerDto;
import org.cap.passengermngt.entities.Passenger;
import org.cap.passengermngt.exceptions.PassengerNotFoundException;
import org.cap.passengermngt.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/passengers")
@Validated
public class PassengerRestController {
	

	@Autowired
	private PassengerService service;

	/* add passengers */
	@PostMapping("/add/many")
	public ResponseEntity<Boolean> addPassengers(@RequestBody @Valid RequestPassengerDto[] requestPassengersData) {
		for (RequestPassengerDto passengerData : requestPassengersData) {
			Passenger passenger = convertFromDtoToPassenger(passengerData);
			passenger = service.addPassenger(passenger);
		}
		ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		return reponse;
	}

	/** convert passengerdtodetails to passengerdetails **/
	public Passenger convertFromDtoToPassenger(RequestPassengerDto requestData) {
		Passenger passenger = new Passenger();
		passenger.setPassengerUIN(requestData.getPassengerUIN());
		passenger.setPassengerName(requestData.getPassengerName());
		passenger.setPassengerAge(requestData.getPassengerAge());
		passenger.setPnrNumber(requestData.getPnrNumber());
		passenger.setPassegerLuggage(requestData.getPassegerLuggage());
		passenger.setGender(requestData.getGender());
		return passenger;
	}

	/* find passenger using UIN */
	@GetMapping("/getbyuin/{uin}")
	public ResponseEntity<Passenger> findPassengerByUin(@PathVariable("uin") BigInteger uin) {
		Passenger passenger = service.findPassengerByUin(uin);
		ResponseEntity<Passenger> reponse = new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
		return reponse;
	}

//	/* delete passengers */
//	@DeleteMapping("/delete/many")
//	public ResponseEntity<String> deletePassengers(@RequestBody RequestPassengerDto[] requestPassengersData) {
//		String message = "";
//		for (RequestPassengerDto passengerData : requestPassengersData) {
//			Passenger passenger = convertFromDtoToPassenger(passengerData);
//			BigInteger passengerUin = passenger.getPassengerUIN();
//			message = message + " " + service.deletePassenger(passengerUin);
//		}
//		ResponseEntity<String> reponse = new ResponseEntity<String>(message, HttpStatus.OK);
//		return reponse;
//	}
	
	@DeleteMapping("/deletebyuin/{uin}")
	public ResponseEntity<Boolean> deletePassengerByUin(@PathVariable("uin") BigInteger uin) {
		Boolean result = service.deletePassenger(uin);
		ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return reponse;
	}
	

	/* exception handler used for handling PassengerNotFoundException */
	@ExceptionHandler(PassengerNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(PassengerNotFoundException exception) {
		String message = exception.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		return response;
	}

}
