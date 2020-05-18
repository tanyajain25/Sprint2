package org.cap.passengermngt.service;

import java.math.BigInteger;
import java.util.Optional;

import org.cap.passengermngt.dao.PassengerDao;
import org.cap.passengermngt.entities.Passenger;
import org.cap.passengermngt.exceptions.PassengerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	private PassengerDao passengerDao;

	public PassengerDao getPassengerDao() {
		return passengerDao;
	}

	@Autowired
	public void setPassengerDao(PassengerDao passengerDao) {
		this.passengerDao = passengerDao;
	}

	/* add passenger */
	@Override
	public Passenger addPassenger(Passenger passenger) {
		passenger = passengerDao.save(passenger);
		return passenger;
	}

	/* find passenger using UIN */
	@Override
	public Passenger findPassengerByUin(BigInteger uin) {
		Optional<Passenger> optional = passengerDao.findById(uin);
		if (optional.isPresent()) {
			Passenger passenger = optional.get();
			return passenger;
		}
		throw new PassengerNotFoundException("Passengers not found for UIN=" + uin);
	}

	/* delete passenger using UIN */
	@Override
	public Boolean deletePassenger(BigInteger uin) {
		Optional<Passenger> optional = passengerDao.findById(uin);
		if (optional.isPresent()) {
			passengerDao.deleteById(uin);
			return true;
		}
		throw new PassengerNotFoundException("Passengers not found for UIN=" + uin);

	}

}
