package com.kruger.app.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

//@Data
public class Product {
	
	private final UUID id;
	private final BigDecimal price;
	private final String name;
	
	@JsonCreator
	public Product(@JsonProperty("id") final UUID id, @JsonProperty("price") final BigDecimal price, @JsonProperty("name") final String name) {
		this.id = id;
		this.price = price;
		this.name = name;
	}

	@JsonCreator
	public Product(@JsonProperty("id") final UUID id, @JsonProperty("price") final BigDecimal price) {
		this.id = id;
		this.price = price;
		this.name = "";
		
	}
	
	@JsonCreator
	public Product() {
		this.id = UUID.randomUUID();
		this.price = null;
		this.name = null;
		
	}
	public UUID getId() {
		return id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}
	
	
	
	
	
	
	

}
