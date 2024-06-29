package com.dashboard.controller;

import com.dashboard.model.Company;
import com.dashboard.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    CompanyServiceImpl cServiceImpl;

    @GetMapping("/getData")
    public List<Company> getData() {
        return cServiceImpl.getData();
    }

    @GetMapping("/saveFile")
    public void saveFile() {
        cServiceImpl.saveFileV2();
    }

    @GetMapping("/getDataBy/{filterName}/{filterValue}")
    public List<Object> getDataBy(@PathVariable String filterName, @PathVariable String filterValue) {
        return cServiceImpl.getDataBy(filterName, filterValue);
    }
    
}
