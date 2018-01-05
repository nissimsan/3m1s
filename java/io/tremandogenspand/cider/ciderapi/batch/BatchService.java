package io.tremandogenspand.cider.ciderapi.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {

	@Autowired
	BatchRepository batchRepository; 
	
	public List<Batch> getAllBatches() {
		List<Batch> bottles = new ArrayList<>();
		batchRepository.findAll().forEach(bottles::add);
		return bottles;
	}
	
	public Batch getBatch (String id) {
		return batchRepository.findOne(id);
	}
	
	public void addBatch(Batch bottle) {
		batchRepository.save(bottle);
	}
	
	public void updateBatch(String id, Batch bottle) {
		batchRepository.save(bottle);
	}
	
	public void deleteBatch(String id) {
		batchRepository.delete(id);
	}
	
	
	
}
