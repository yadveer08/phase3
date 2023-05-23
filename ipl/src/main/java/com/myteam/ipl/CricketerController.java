package com.myteam.ipl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "ipl")
public class CricketerController {
	
	@Autowired
	CricketerService service;
	// select all
	@RequestMapping("/cricketer/all")
	public List<CricketerEntity> getCricketers() {
		return service.getCricketers();
	}
	// select specific-1
	@RequestMapping("/cricketer/id/{id}")
	public CricketerEntity getCricketerbyId(@PathVariable int id) {
		return service.getCricketerById(id);
	}
	// select specific-2
	@RequestMapping("/cricketer/team/{team}")
	public CricketerEntity getCricketerbyTeam(@PathVariable String team) {
		return service.getCricketerByTeam(team);
	}
	// insert
	@RequestMapping(method = RequestMethod.POST, value = "/cricketer")
	public void addCricketer(@RequestBody CricketerEntity ce) {
		service.addCricketer(ce);
	}
	// delete
	@RequestMapping(method = RequestMethod.DELETE, value = "/cricketer/{id}")
	public void deleteCricketer(@PathVariable int id) {
		service.deleteCricketer(id);
	}
	// update
	@RequestMapping(method = RequestMethod.PUT, value = "/cricketer/{id}")
	public void updateCricketer(@PathVariable int id, @RequestBody CricketerEntity ce ) {
		service.updateCricketer(id, ce);
	}
}
