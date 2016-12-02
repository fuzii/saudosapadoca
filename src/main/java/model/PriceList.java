package model;

import java.util.Date;
import java.util.List;

public class PriceList {

	private Long id;
	private Establishment establishment;
	private List<PriceListItem> priceListItem;
	private Date startDate;
	private Date entDate;
	private String status;
	
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
	public List<PriceListItem> getPriceListItem() {
		return priceListItem;
	}
	public void setPriceListItem(List<PriceListItem> priceListItem) {
		this.priceListItem = priceListItem;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEntDate() {
		return entDate;
	}
	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
		
}
