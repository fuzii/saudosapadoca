package model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Order {
	
	private Long id;
	private Establishment establishment;
	private Account account;
	private List<OrderItem> orderItem;
	private String status;
        private Date created;
	
        public Order(){
            id = -1L;
        }
        
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Establishment getEstablishment() {
		return establishment;
	}
	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
	public Account getAccount() {
		return account;
	}
        public Date getCreated() {
            return created;
        }
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
        public void setCreated(Date created) {
            this.created = created;
        }
}