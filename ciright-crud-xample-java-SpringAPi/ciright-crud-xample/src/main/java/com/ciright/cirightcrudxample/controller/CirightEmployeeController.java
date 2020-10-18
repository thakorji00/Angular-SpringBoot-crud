package com.ciright.cirightcrudxample.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ciright.cirightcrudxample.service.CirightEmployeeService;

@RestController
@RequestMapping("employee")
public class CirightEmployeeController {

	
	@Autowired
	CirightEmployeeService service;
	Map<String, Object> responseMap;
	
	
	
	@RequestMapping(value = "add_emp",method = RequestMethod.POST)
	private Map<String, Object> getAllCirightEmployee(@RequestBody String data){
			return service.addOrUpdateInfo(data);
	}
	
	@RequestMapping(value = "get_all_emp",method = RequestMethod.GET)
	private Map<String, Object> getAllCirightEmployee(){
			return service.sendAllEmp();
	}
	
	@RequestMapping(value = "add_emp/{id}",method = RequestMethod.GET)
	private Map<String, Object> deleteEmployee(@RequestParam Integer id){
			return service.deleteEmp(id);
	}
	
	
}
