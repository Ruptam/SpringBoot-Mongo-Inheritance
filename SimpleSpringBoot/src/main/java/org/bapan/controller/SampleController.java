/**
 * 
 */
package org.bapan.controller;

import java.util.List;
import java.util.Optional;

import org.bapan.entity.Derived;
import org.bapan.repository.InheritanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ruptam
 *
 */
@RestController
public class SampleController {
	
	@Autowired
	private InheritanceRepository inheritanceRepository;
	
	@RequestMapping(value="/test/{testName}",method=RequestMethod.GET)
	public String test(@PathVariable("testName") String name) {
		return "Hello World" + name;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@RequestBody Derived derived) {
		inheritanceRepository.save(derived);
		return "Done";
	}
	
	@RequestMapping(value="/get/{field}",method=RequestMethod.GET)
	public ResponseEntity<Derived> getDerived(@PathVariable("field") String field) {
		Derived optionalDerived = inheritanceRepository.findByFieldA(field);
		if(optionalDerived == null) {
			optionalDerived=inheritanceRepository.findByFieldB(field);
		}
		return new ResponseEntity<Derived>(optionalDerived,HttpStatus.OK);
	}
}
