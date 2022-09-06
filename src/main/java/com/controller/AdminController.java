package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Admin;
import com.exception.ResourseNotFoundException;
import com.repository.AdminRepository;




@CrossOrigin(origins = "*")



@RequestMapping("/api/")



@RestController
public class AdminController {
    
    @Autowired
    private AdminRepository adminRepository;
    


   
    
    //get All Admins
    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }



   
    //create admin rest api



   @PostMapping("/create")
    public Admin createAdmin(@Valid @RequestBody Admin admin) {
        return adminRepository.save(admin);
    }
    
//get admin by id rest api
    @GetMapping("/admins/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id)
     {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourseNotFoundException("Admin not found for this id :: " + id));
        return ResponseEntity.ok(admin);
    }
    
    //update admin rest api



   @PutMapping("/update/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails){
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourseNotFoundException("Admin not exist with id :" + id));
        
        admin.setFirstName(adminDetails.getFirstName());
        admin.setLastName(adminDetails.getLastName());
        admin.setEmailId(adminDetails.getEmailId());
        
        Admin updatedAdmin = adminRepository.save(admin);
        return ResponseEntity.ok(updatedAdmin);
    }



   @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteAdmin(@PathVariable(value = "id") Long adminId)
            throws ResourseNotFoundException {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourseNotFoundException("Admin not found for this id :: " + adminId));



       adminRepository.delete(admin);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}