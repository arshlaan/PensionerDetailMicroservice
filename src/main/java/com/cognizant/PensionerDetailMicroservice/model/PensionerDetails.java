package com.cognizant.PensionerDetailMicroservice.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PensionerDetails {
	@Id
	private String aadhaarNumber;
	private String name;
	private String DOB;
	private String panNumber;
	private double salary;
	private double allowance;
	private String pensionType;
	@Embedded
	private BankDetails bankDetails;
	public PensionerDetails(String aadhaarNumber, String name, String dOB, String panNumber, double salary,
			double allowance, String pensionType, BankDetails bankDetails) {
		super();
		this.aadhaarNumber = aadhaarNumber;
		this.name = name;
		DOB = dOB;
		this.panNumber = panNumber;
		this.salary = salary;
		this.allowance = allowance;
		this.pensionType = pensionType;
		this.bankDetails = bankDetails;
	}
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	public PensionerDetails() {
	}
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getAllowance() {
		return allowance;
	}
	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	public String getPensionType() {
		return pensionType;
	}
	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}
	public BankDetails getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
}
