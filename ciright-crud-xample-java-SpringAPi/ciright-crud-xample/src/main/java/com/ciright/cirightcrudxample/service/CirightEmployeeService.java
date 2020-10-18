package com.ciright.cirightcrudxample.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciright.cirightcrudxample.dao.CirightEmployeeDao;
import com.ciright.cirightcrudxample.model.CirightEmployeeModel;

@Service
public class CirightEmployeeService {

	@Autowired
	private CirightEmployeeDao empDao;

	private Map<String, Object> responsMap;
	private List<CirightEmployeeModel> employeeModelList;
	private CirightEmployeeModel employeeModel;
	
	
	// Add or update Ciright Employee
	public Map<String, Object> addOrUpdateInfo(String data) {
		responsMap = new HashMap<String, Object>();
		try {

			int id = 0;
			JSONObject obj = new JSONObject(data);

			if (!obj.has("empName") || obj.getString("empName") == null || obj.getString("empName").length() == 0
					|| obj.getString("empName").equals("")) {

				responsMap.put("status", "fail");
				responsMap.put("message", "please enter Employee Name");
				return responsMap;
			}
			if (!obj.has("empDesignation") || obj.getString("empDesignation") == null
					|| obj.getString("empDesignation").length() == 0 || obj.getString("empDesignation").equals("")) {

				responsMap.put("status", "fail");
				responsMap.put("message", "please enter Employee Designation");
				return responsMap;
			}
			if (!obj.has("empCity") || obj.getString("empCity") == null || obj.getString("empCity").length() == 0
					|| obj.getString("empCity").equals("")) {

				responsMap.put("status", "fail");
				responsMap.put("message", "please enter Employee City");
				return responsMap;
			}

			CirightEmployeeModel empModel = new CirightEmployeeModel();
			empModel.setEmpCity(obj.getString("empCity"));
			empModel.setEmpDesination(obj.getString("empDesignation"));
			empModel.setEmpName(obj.getString("empName"));
			empModel.setIsActive(1);
			if (!obj.has("id") && obj.getInt("id") != 0) {
				empModel.setId(obj.getInt("id"));
			}

			empDao.addEmployee(empModel);
			responsMap.put("status", "success");
			responsMap.put("message", "Employee Added Successfully");
			return responsMap;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responsMap.put("status", "fail");
			responsMap.put("message", "Something is wrong! please try again");
			return responsMap;

		}
	}

	
	// Get All employee
	public Map<String, Object> sendAllEmp() {
		responsMap = new HashMap<String, Object>();
		try {

			employeeModelList = new ArrayList<CirightEmployeeModel>();

			employeeModelList = empDao.getAllEmployee();
			if (employeeModelList != null) {
				responsMap.put("status", "success");
				responsMap.put("data", employeeModelList);
				return responsMap;

			} else {
				responsMap.put("status", "fail");
				responsMap.put("message", "Employee data not availabe");
				return responsMap;

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responsMap.put("status", "fail");
			responsMap.put("message", "Something is wrong! please try again");
			return responsMap;

		}
	}

	
	// Delete Employee
	public Map<String, Object> deleteEmp(int id) {
		responsMap = new HashMap<String, Object>();
		try {

			employeeModel = new CirightEmployeeModel();
			employeeModel = empDao.findByIdEmployee(id);
			if (employeeModel != null) {
				
				employeeModel.setIsActive(0);
				empDao.addEmployee(employeeModel);
				
				responsMap.put("status", "success");
				responsMap.put("message", "employee deleted successfully");
				return responsMap;

			} else {
				responsMap.put("status", "fail");
				responsMap.put("message", "Please Enter valid employee id");
				return responsMap;

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responsMap.put("status", "fail");
			responsMap.put("message", "Something is wrong! please try again");
			return responsMap;

		}
	}

}
