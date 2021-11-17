package com.example.datagriptoolsdesign;

import com.example.datagriptoolsdesign.demo.Data_Processing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataGripToolsDesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataGripToolsDesignApplication.class, args);
		Data_Processing data_processing = new Data_Processing();
		try {

			//data_processing.init("D:\\Study\\Study in MUC\\DataGripToolsDesign\\src\\main\\resources\\进入登记.xlsx");
			data_processing.init("src/main/resources/进入登记.xlsx");
			data_processing.processing();
			data_processing.getLogs().forEach(System.out::println);
			data_processing.upload();
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

}
