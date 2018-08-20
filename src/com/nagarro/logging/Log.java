package com.nagarro.logging;

/*
 * Class Name:Log
 * Version: 1.0
 * Author: Anmol Narang
 * Created date:19-070-2018
 * Description:Used to log the values
 * 
 * */
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
	public Logger logger;
	FileHandler fh;

	/**
	 * @param file_name
	 * @throws SecurityException
	 * @throws IOException
	 */
	public Log(String file_name) throws SecurityException, IOException {
		// System.out.println("Hello!");

		File f = new File(file_name);
		if (!f.exists()) {
			f.createNewFile();
		}
		fh = new FileHandler(file_name, true);
		logger = Logger.getLogger("test");
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
	}
	/**
	 * @param message
	 * @return void
	 */
	public void log(String message){
		Date now = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd 'at' h:m:s a z");
		//Log log = new Log("log/log.txt");
		this.logger.setLevel(Level.INFO);
		this.logger.info(message+" at " + dateFormatter.format(now));

	}
}