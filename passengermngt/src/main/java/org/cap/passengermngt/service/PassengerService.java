package org.cap.passengermngt.service;

import java.math.BigInteger;

import org.cap.passengermngt.entities.Passenger;

public interface PassengerService {

	Passenger addPassenger(Passenger passenger);

	Passenger findPassengerByUin(BigInteger uin);

	Boolean deletePassenger(BigInteger uin);

}
