package model;

import java.util.Date;

public class OrderItem {

	private Long id;
	private Product product;
	private String dayOfWeek;
	private Date deliveryTime;
        private Date deliveryDate;
	private String unit;
	private Integer quantity;
	private Double price;
        
        public OrderItem() {
            id = -1L;
        }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
        public Date getDeliveryDate() {
            return deliveryDate;
        }
        public void setDeliveryDate(Date deliveryDay) {
            this.deliveryDate = deliveryDay;
        }
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}	
	
}
