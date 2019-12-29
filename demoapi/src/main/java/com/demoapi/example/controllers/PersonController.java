package com.demoapi.example.controllers;

import com.demoapi.example.domain.Person;
import com.demoapi.example.services.PersonService;
import com.demoapi.util.ServiceException;
import com.demoapi.util.ErrorType.MsgCodeEnum;
import com.demoapi.util.ErrorType.MsgScopeEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/v2/persons/")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
public class PersonController {

    private PersonService personService;

    // test

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("${personcontroller.getallpersons}")

    
    public List<Person>  getAllPersons() {
    	//
    	try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    	
    	return personService.getAllPersons();
    	
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    @ApiOperation("${personcontroller.getpersonbyid}")

    public Person getPersonById(@ApiParam("Id of the person to be obtained. Cannot be empty.")
                                    @PathVariable int id) {
        return personService.getPersonById(id);
    }
    //Get method for detailed person
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ApiOperation("${personcontroller.deleteperson}")
    public void deletePerson(@ApiParam("Id of the person to be deleted. Cannot be empty.")
                                 @PathVariable int id) {
        personService.deletePerson(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation("${personcontroller.createperson}")
    public Person createPerson(@ApiParam("Person information for a new person to be created.")
                                   @RequestBody Person person) {
        return personService.createPerson(person);
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
