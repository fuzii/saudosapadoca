package model;

import java.util.Currency;

public class PriceListItem {

	private Long id;
	private PriceList priceList;
	private Product product;
	private Currency price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PriceList getPriceList() {
		return priceList;
	}
	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Currency getPrice() {
		return price;
	}
	public void setPrice(Currency price) {
		this.price = price;
	}
	
}
