package com.kruger.app.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import lombok.Data;
//@Data
public class OrderItem {
	private UUID productId;
	private BigDecimal price;
	
	public OrderItem(final Product product) {
		this.productId = product.getId();
		this.price = product.getPrice();
	}
	public OrderItem() {
		
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(price, other.price) && Objects.equals(productId, other.productId);
	}

		
	

}
