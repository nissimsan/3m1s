package io.tremandogenspand.cider.ciderapi.bottle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.tremandogenspand.cider.ciderapi.batch.Batch;

@Entity
public class Bottle {
	
	@ManyToOne 
	private Batch batch;
	
	public Bottle() {
		super();
	}

	public Bottle(String id, String name, String description, String batchId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.batch = new Batch(batchId, "", "");
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBottle(Batch batch) {
		this.batch = batch;
	}

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String name;
	private String description;
}
