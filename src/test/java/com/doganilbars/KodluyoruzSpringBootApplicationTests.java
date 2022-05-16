package com.doganilbars;

import com.doganilbars.data.entity.EmployeeEntity;
import com.doganilbars.data.repository.EmployeeRepository;
import com.doganilbars.test.TestCRUD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KodluyoruzSpringBootApplicationTests implements TestCRUD {

    @Autowired
    EmployeeRepository employeeRepository;

    //CREATE
    @Test
    @Override
    public void testCreate() {
        EmployeeEntity employeeEntity = EmployeeEntity.builder().firstName("Doğan Test").lastName("İlbars Test").emailId("doganilbars80qmail.com").build();
        employeeRepository.save(employeeEntity);
        //nesne null ise assertionerror hatası göndersin
        assertNotNull(employeeRepository.findById(1L).get());
    }

    //LIST
    @Test
    @Override
    public void testList() {
        List<EmployeeEntity> list = employeeRepository.findAll();
        //Eğer sıfırdan büyükse liste vardır
        assertThat(list).size().isGreaterThan(0);
    }

    //FIND
    @Test
    @Override
    public void testFindById() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        //Doğan Test adında kayıt var mı yok mu
        assertEquals("Doğan Test",employeeEntity.getFirstName());
    }

    //UPDATE
    @Test
    @Override
    public void testUpdate() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        employeeEntity.setFirstName("Doğan80 Test");
        employeeRepository.save(employeeEntity);
        //Eşit değilse bir sorun olmayacak eşitse exception fırlatır
        assertNotEquals("Doğan Test",employeeRepository.findById(1L).get().getFirstName());
    }

    //DELETE
    @Test
    @Override
    public void testDelete() {
        employeeRepository.deleteById(1L);
        //isFalse
        assertThat(employeeRepository.existsById(1L)).isFalse();
    }
}
