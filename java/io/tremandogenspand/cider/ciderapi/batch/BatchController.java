package io.tremandogenspand.cider.ciderapi.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
//@RequestMapping("/cider")
@Api(value="batch", description="Cider batch operations")
public class BatchController {

	@Autowired
	private BatchService batchService; 
	
	@RequestMapping("/batches")
	public List<Batch> getBatches () {
        return batchService.getAllBatches();
    }
	
	@RequestMapping("/batches/{id}")
	public Batch getBatches(@PathVariable String id) {
		return batchService.getBatch(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/batches")
	public void addBatch(@RequestBody Batch bottle) {
		batchService.addBatch(bottle);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/batches/{id}")
	public void updateBottle(@RequestBody Batch bottle, @PathVariable String id) {
		batchService.updateBatch(id, bottle);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/batches/{id}")
	public void deleteBottle(@PathVariable String id) {
		batchService.deleteBatch(id);
	}
	
}
