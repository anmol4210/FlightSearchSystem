package com.nagarro.io;

import com.nagarro.exception.FlightException;
import com.nagarro.model.TravelDetails;
import com.nagarro.validator.Validate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);
    Validate valid=new Validate();
    public TravelDetails getInput() throws ParseException{
    	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        TravelDetails travelDetails=new TravelDetails();
        
        travelDetails.setDepartureLocation(new StringBuffer(fetch("Departure Location")));
        travelDetails.setArrivalLocation(new StringBuffer(fetch("Arrival Location")));
        travelDetails.setFlightClass(new StringBuffer(fetch("Flight Class E or B or EB")));
        travelDetails.setOutputPreference(new StringBuffer(fetch("Sort Result by flight duration: y/n")));
       // System.out.println();
        travelDetails.setFlightDate(LocalDate.parse(fetch("Flight Date(dd/MM/yyyy)"),formatter));
        return travelDetails;
    }
    private String fetch(String data){
        String input;
        do{
            try{
                System.out.println("Enter " + data);
                input = scanner.nextLine();
                valid.validate(input, data);
                break;
            }
            catch (FlightException fe){}
            catch (NumberFormatException e){
                System.out.println("Incorrect Value Entered! Enter again");
            }
            catch (Exception e) {
                System.out.println("Error occured: "+e);
            }
        }while(true);
        return input;

    }

}