package com.doganilbars.businnes.services.impl;

import com.doganilbars.businnes.dto.EmployeeDto;
import com.doganilbars.businnes.services.EmployeeServices;
import com.doganilbars.data.entity.EmployeeEntity;
import com.doganilbars.data.repository.EmployeeRepository;
import com.doganilbars.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    //LIST
    //http://localhost:8080/api/v1/employees
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> entityList = employeeRepository.findAll();
        for(EmployeeEntity entity:entityList){
            EmployeeDto employeeDto = entityToDto(entity);
            listDto.add(employeeDto);
        }
        return listDto;
    }

    //SAVE
    //http://localhost:8080/api/v1/employees/1
    @PostMapping("/employees")
    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employee = dtoToEntity(employeeDto);
        employeeRepository.save(employee);
        return employeeDto;
    }

    //FIND
    //http://localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) throws Throwable {
        EmployeeEntity employee =(EmployeeEntity) employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+id));
        EmployeeDto employeeDto = entityToDto(employee);
        return ResponseEntity.ok(employeeDto);
    }

    //UPDATE
    //http://localhost:8080/api/v1/employees/1
    @PutMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) throws Throwable {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDto);
        EmployeeEntity employee =(EmployeeEntity) employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id: "+id));
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmailId(employeeEntity.getEmailId());

        EmployeeEntity updatedEmployee =(EmployeeEntity) employeeRepository.save(employee);
        EmployeeDto dtoEmployee = entityToDto(updatedEmployee);
        return ResponseEntity.ok(dtoEmployee);
    }

    //DELETE
    //http://localhost:8080/api/v1/employees/1
    @DeleteMapping("/employees/{id}")
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        EmployeeEntity employee =(EmployeeEntity)employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id: "+id));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

///////////////////////////////////////////////////////////////////////////////////////////////
    //Model Mapper
    //Entity ==> DTO
    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapper.map(employeeEntity,EmployeeDto.class);
        return employeeDto;
    }

    //DTO ==> Entity
    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
        return employeeEntity;
    }
}
