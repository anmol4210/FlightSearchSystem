package com.nagarro.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import com.nagarro.model.FlightDetails;
import com.nagarro.model.TravelDetails;

public class FileRead implements FileSearch, Callable<ArrayList<FlightDetails>> {

	private String fileName;
	private TravelDetails traveDetail;

	public FileRead(String fileName, TravelDetails traveDetail) {
		this.fileName = fileName;
		this.traveDetail = traveDetail;
	}

	public ArrayList<FlightDetails> searchFile() {
		FileReader fileReader;
		String line = "";

		FlightDetails detail;

		ArrayList<FlightDetails> flightDetail = new ArrayList<FlightDetails>();

		try {
			fileReader = new FileReader(this.fileName);
			BufferedReader br = new BufferedReader(fileReader);
			line=br.readLine();
			while ((line = br.readLine()) != null) {
			String[] data=line.split(",");
			if(data[1].equalsIgnoreCase(this.traveDetail.getDepartureLocation().toString())&&
					data[2].equalsIgnoreCase(this.traveDetail.getArrivalLocation().toString())&&
					data[7].equalsIgnoreCase("Y")&&
					(data[8].toLowerCase().contains(this.traveDetail.getFlightClass().toString().toLowerCase())||
							this.traveDetail.getFlightClass().toString().toLowerCase().contains(data[8].toLowerCase()))
					){
					detail=new FlightDetails();
					detail.setFlightNo(data[0]);
					detail.setDepLoc(data[1]);
					detail.setArrLoc(data[2]);
					detail.setValidTill(data[3]);
					detail.setFlightTime(data[4]);
					detail.setFlightDur(data[5]);
					detail.setFare(Integer.parseInt(data[6]));
					detail.setSeatAvailability(data[7]);
					detail.setTravelClass(data[8]);
					flightDetail.add(detail);
			}
			//System.out.println();
			}
			br.close();
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return flightDetail;

	}

	@Override
	public ArrayList<FlightDetails> call() throws Exception {
		// TODO Auto-generated method stub
		return searchFile();
	}
}