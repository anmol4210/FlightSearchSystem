package com.nagarro.dto;

import java.text.ParseException;

import com.nagarro.io.Input;
import com.nagarro.model.TravelDetails;
import com.nagarro.services.FileRead;

public class FlightSearchSystem {
    public static void main(String[] args){
     	do{
    	try {
    	Input input=new Input();
 		TravelDetails traveDetail=(input.getInput());
 		
    		SearchFlights search=new SearchFlights();
 		search.searchAirline(traveDetail);
    // 		FileRead fr=new FileRead();
     //		fr.searchFile("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
    	}while(true);
    }
}