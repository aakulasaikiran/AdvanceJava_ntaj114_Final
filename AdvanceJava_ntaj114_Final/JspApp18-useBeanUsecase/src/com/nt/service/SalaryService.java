package com.nt.service;

import com.nt.dto.EmployeeDTO;

public class SalaryService {
	
	public void  generatePaySlip(EmployeeDTO dto){
		float bSalary=0.0f;
		float netSalary=0.0f;
		float grossSalary=0.0f;
		//get Basic salary;
		bSalary=dto.getBasicSalary();
		//calculate netSalary,grossSalary
		grossSalary=bSalary+ (bSalary*0.4f);
		netSalary=grossSalary-(grossSalary*0.2f);
		//set salaries to DTO
		dto.setGrossSalary(grossSalary);
		dto.setNetSalary(netSalary);
	}//method
}//class
