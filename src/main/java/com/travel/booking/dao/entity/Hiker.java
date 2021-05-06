package com.travel.booking.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Hiker extends PanacheEntityBase  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "name_hiker")
	private String name;
	 @Min(1)
	private int ageHiker;

	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAgeHiker() {
		return ageHiker;
	}

	public void setAgeHiker(int ageHiker) {
		this.ageHiker = ageHiker;
	}

}
