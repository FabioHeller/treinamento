package com.codenation.treinamento.endpoints;

import com.codenation.treinamento.entity.Company;
import com.codenation.treinamento.entity.User;
import com.codenation.treinamento.service.impl.CompanyServiceImpl;
import com.codenation.treinamento.vo.CompanyVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/company")
@Api(value = "Company Controller")
public class CompanyController {
    @Autowired
    private CompanyServiceImpl service;

    @PostMapping("/createCompany")
    @ApiOperation(value = "createCompany")
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyVO createCompany(@RequestBody CompanyVO companyVO){
        return service.createCompany(companyVO);
    }

    @DeleteMapping
    @ApiOperation(value = "deleteCompany")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCompany(@Param("id") Long id){
        service.deleteCompany(id);
    }

    @GetMapping("/nameCompany")
    @ApiOperation(value = "List<Company>")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> listCompanyName(@RequestParam String name){
        return service.listCompanyName(name);
    }

    @GetMapping("/listUsers")
    @ApiOperation(value = "List<User>")
    @ResponseStatus(HttpStatus.OK)
    public List<User> listUserName(){
        return service.listUserName();
    }

}
