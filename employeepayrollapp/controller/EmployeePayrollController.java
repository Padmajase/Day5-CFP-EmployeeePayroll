package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.model.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // curl localhost:8080/employeepayrollservice -w "\n"
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,new EmployeePayrollDTO("neha", 3000));
        ResponseDTO respDTO = new ResponseDTO("Get Call Successfull", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    // curl localhost:8080/employeepayrollservice/get/{empId} -w "\n"
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,new EmployeePayrollDTO("neha", 3000));
        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successfull", empData);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    // curl -X POST -H "Content-Type: application/json"
    // -d '{"firstName" : "Padmaja", "salary" : "20000"}'
    // curl localhost:8080/employeepayrollservice/create -w "\n"
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
                            @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //curl -X PUT -H "Content-Type: application/json"
    //  -d '{"firstName" : "Padmaja", "salary" : "20000"}'
    //localhost:8080/employeepayrollservice/update -w "\n"
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
            @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId")int empId) {
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : " +empId);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
