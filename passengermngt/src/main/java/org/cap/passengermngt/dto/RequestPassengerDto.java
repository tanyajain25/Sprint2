package org.cap.passengermngt.dto;

import java.math.BigInteger;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class RequestPassengerDto {

	@Min(value = 99999999999L)
	@Max(value = 999999999999L)
	private BigInteger passengerUIN;
	private BigInteger pnrNumber;
	private String passengerName;
	private Integer passengerAge;
	private double passegerLuggage;
	private String gender;

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

}