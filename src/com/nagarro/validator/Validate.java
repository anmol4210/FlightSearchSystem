package com.nagarro.validator;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.nagarro.exception.FlightException;


public class Validate {
	String locationPattern="[A-Za-z][A-Za-z][A-Za-z]";
    public void validate(String input, String data) throws FlightException{
    	switch(data){
    	case "Departure Location":
    		validateDepartureLocation(input);
    		break;
    	case "Arrival Location":
    		validateArrivalLocation(input);
    		break;
    	case "Flight Class E or B or EB":
    		validateFlightClass(input);
    		break;
    	case "Flight Date(dd/MM/yyyy)":
    		validateFlightDate(input,data);
    		break;
    	case "Sort Result by flight duration: y/n":
    		validateOutputPreferences(input);
    		break;  	
    	}
    }
    
    public void validateDepartureLocation(String input) throws FlightException{
    	if (!input.matches(locationPattern) ) {
			throw new FlightException("Enter a valid Departure Location code! Enter Again!");
		}
    }
    public void validateArrivalLocation(String input) throws FlightException{
    	if (!input.matches(locationPattern)) {
			throw new FlightException("Enter a valid Arrival Location Code! Enter Again!");
		}
    	
    }
    public void validateFlightClass(String input) throws FlightException{
    	if (input.length() < 1) {
			throw new FlightException("Flight Class can not be left blank! Enter Again!");
		}
    	if(!((input.equalsIgnoreCase("E"))|| (input.equalsIgnoreCase("B"))||(input.equalsIgnoreCase("EB")))){
    		throw new FlightException("Enter a valid Flght Class");
    	}
    }
    public void validateFlightDate(String input,String data) throws FlightException{
    	if (input.length() < 1) {
			throw new FlightException("Flight Date can not be left blank! Enter Again!");
		}
    	try{
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    		LocalDate.parse(input,formatter);
    	//System.out.println( new SimpleDateFormat("dd/MM/yyyy").parse(input));
    	}catch(Exception e){
    		throw new FlightException("Enter a valid "+data+"! Enter Again! ");
    	}
    }
    public void validateOutputPreferences(String input) throws FlightException{
    	if (input.length() < 1) {
			throw new FlightException("Enter a vaid Output Preference! Enter Again!");
		}
    	if(!(input.equalsIgnoreCase("y")|| input.equalsIgnoreCase("n"))){
    		throw new FlightException("Enter a vaid Output Preference! Enter Again!");
    	}
    }
}