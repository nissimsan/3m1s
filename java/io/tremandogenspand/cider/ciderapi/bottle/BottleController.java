package io.tremandogenspand.cider.ciderapi.bottle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.tremandogenspand.cider.ciderapi.batch.Batch;

@RestController
@Api(value="bottle", description="Cider bottle operations")
public class BottleController {

	@Autowired
	private BottleService bottleService; 
	
	@RequestMapping("/hello")
	public String hello() {
        return "hej david og henrik!";
    }
	
	
	@RequestMapping("/bottles")
	public List<Bottle> getAllBottles() {
        return bottleService.getAllBottles();
    }
	
	@RequestMapping("/batches/{id}/bottles")
	public List<Bottle> getAllBottlesByBatch(@PathVariable String id) {
        return bottleService.getAllBottlesByBatch(id);
    }
	
	@RequestMapping("/batches/{batchId}/bottles/{id}")
	public Bottle getBottle(@PathVariable String id) {
		return bottleService.getBottle(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/batches/{batchId}/bottle")
	public void addBottle(@RequestBody Bottle bottle, @PathVariable String batchId) {
		bottle.setBottle(new Batch(batchId, "", ""));
		bottleService.addBottle(bottle);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/batches/{batchId}/bottles")
	public void addBottles(@RequestBody List<Bottle> bottles, @PathVariable String batchId) {
		for (Bottle bottle : bottles) {
			bottle.setBottle(new Batch(batchId, "", ""));
			bottleService.addBottle(bottle);	
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/batches/{batchId}/bottles/{id}")
	public void updateBottle(@RequestBody Bottle bottle,  @PathVariable String batchId, @PathVariable String id) {
		bottle.setBottle(new Batch(batchId, "", ""));
		bottleService.updateBottle(bottle);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/batches/{batchId}/bottles/{id}")
	public void deleteBottle(@PathVariable String id) {
		bottleService.deleteBottle(id);
	}
	
}
