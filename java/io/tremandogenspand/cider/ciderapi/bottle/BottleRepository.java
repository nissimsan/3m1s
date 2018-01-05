package io.tremandogenspand.cider.ciderapi.bottle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BottleRepository extends CrudRepository<Bottle, String> {
	public List<Bottle> findByBatchId(String topicId);
}
