package com.badr.DroolDemo;

public class Loan {
	
	public String name;
	public String firstname;
	public int age;
	public int id;
	public int salary;
	public String maried;
	public String job;
	public String criminalHistory;
	

	
	public String getCriminalHistory() {
		return criminalHistory;
	}
	public void setCriminalHistory(String criminalHistory) {
		this.criminalHistory = criminalHistory;
	}
	private Boolean loanEligibility;
	
	public Boolean getLoanEligibility() {
		return loanEligibility;
	}
	public void setLoanEligibility(Boolean loan) {
		this.loanEligibility = loan;
	}
	public String get_name() {
		return name;
	}
	public void set_name(String _name) {
		this.name = _name;
	}
	public String get_firstname() {
		return firstname;
	}
	public void set_firstname(String _firstname) {
		this.firstname = _firstname;
	}
	public int get_id() {
		return id;
	}
	public void set_id(int _id) {
		this.id = _id;
	}
	public int get_salary() {
		return salary;
	}
	public void set_salary(int l) {
		this.salary = l;
	}
	public int get_age() {
		return age;
	}
	public void set_age(int _age) {
		this.age = _age;
	}
	public String get_maried() {
		return maried;
	}
	public void set_maried(String _maried) {
		this.maried = _maried;
	}
	public String get_job() {
		return job;
	}
	public void set_job(String _job) {
		this.job = _job;
	}
	
}
