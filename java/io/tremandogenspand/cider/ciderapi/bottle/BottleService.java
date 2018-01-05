package io.tremandogenspand.cider.ciderapi.bottle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BottleService {

	
	@Autowired
	BottleRepository bottleRepository; 
	
	public List<Bottle> getAllBottlesByBatch(String batchId) {
		List<Bottle> bottles = new ArrayList<>();
		bottleRepository.findByBatchId(batchId).forEach(bottles::add);
		return bottles;
	}
	
	public List<Bottle> getAllBottles() {
		List<Bottle> bottles = new ArrayList<>();
		bottleRepository.findAll().forEach(bottles::add);
		return bottles;
	}
	
	public Bottle getBottle (String id) {
		return bottleRepository.findOne(id);
	}
	
	public void addBottle(Bottle bottle) {
		bottleRepository.save(bottle);
	}
	
	public void addBottles(List<Bottle> bottles) {
		bottleRepository.save(bottles);
	}
	
	public void updateBottle(Bottle bottle) {
		bottleRepository.save(bottle);
	}
	
	public void deleteBottle(String id) {
		bottleRepository.delete(id);
	}
	
	
	
}
