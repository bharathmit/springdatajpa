package com.accenture.springcore.DI;

public class PDFHelper {
	
	ReportGenerator reportGenerator;

	public void DisplayOutput() {
		reportGenerator.generateReport();
	}
	
	//DI via setter method
	public void setReportGenerator(ReportGenerator ReportGenerator) {
		this.reportGenerator = ReportGenerator;
	}

}
