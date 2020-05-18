package org.cap.passengermngt.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "passengerdetails")
public class Passenger {

	@Id
	private BigInteger passengerUIN;
	private BigInteger pnrNumber;
	private String passengerName;
	private Integer passengerAge;
	private double passegerLuggage;
	private String gender;

	public Passenger() {
		super();
	}

	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}

	public BigInteger getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public double getPassegerLuggage() {
		return passegerLuggage;
	}

	public void setPassegerLuggage(double passegerLuggage) {
		this.passegerLuggage = passegerLuggage;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || !(object instanceof Passenger))
			return false;
		Passenger passenger = (Passenger) object;
		return this.passengerUIN.equals(passenger.passengerUIN);
	}

	@Override
	public int hashCode() {
		return passengerUIN.hashCode();
	}

}
