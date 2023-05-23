package com.myteam.ipl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myteam.ipl.CricketerEntity;

@Service
public class CricketerService {
	
	@Autowired
	private CricketerRepository repository;
	// select all
	public List<CricketerEntity> getCricketers() {
		return repository.findAll();
	}
	public CricketerEntity getCricketerByTeam(String team) {
		return repository.findByTeam(team);
	}
	// get
	public CricketerEntity getCricketerById(int id) {
		return repository.findById(id).get();
	}
	// insert
	public void addCricketer(CricketerEntity ce) {
		repository.save(ce);
	}
	// update
	public void updateCricketer(int id, CricketerEntity newEntity) {
		if(repository.findById(id).isPresent() == true) {
			CricketerEntity oldEntity = repository.findById(id).get();
			oldEntity.setName(newEntity.getName());
			oldEntity.setAge(newEntity.getAge());
			oldEntity.setPhone(newEntity.getPhone());
			oldEntity.setAddress(newEntity.getAddress());
			oldEntity.setTeam(newEntity.getTeam());
			repository.save(oldEntity);
		}
	}
	// delete
	public void deleteCricketer(int id) {
		repository.deleteById(id);
	}

}
