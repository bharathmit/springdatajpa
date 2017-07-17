package com.accenture.springcore.DI;

public class ExcelHelper {
	
	ReportGenerator reportGenerator;

	public void DisplayOutput() {
		reportGenerator.generateReport();
	}
	
	//DI via constructor
	public ExcelHelper(ReportGenerator ReportGenerator) {
		this.reportGenerator = ReportGenerator;
	}

}
