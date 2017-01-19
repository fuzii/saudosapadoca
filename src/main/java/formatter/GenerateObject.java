package formatter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import dao.PriceListDao;
import dao.ProductDao;
import model.Account;
import model.Address;
import model.Establishment;
import model.Lead;
import model.Order;
import model.OrderItem;
import model.PriceList;
import model.Product;
import model.Schedule;
import util.Util;

public class GenerateObject {

	public static Account GetAccount (HttpServletRequest request){
		
		Account account = new Account(); 
		account.setName(request.getParameter("name"));
		account.setEmail(request.getParameter("email"));
		account.setPhone(request.getParameter("phone"));
		account.setUserLogin(request.getParameter("email"));
		account.setUserPassword(request.getParameter("password").toCharArray());
		
		return account;
	
	}
	
	public static Lead GetLead (HttpServletRequest request){
		
		Lead lead = new Lead();
		lead.setName(request.getParameter("name"));
		lead.setEmail(request.getParameter("email"));
		
		return lead;

	}
	
	public static PriceList GetPriceList (HttpServletRequest request){
		
		PriceList priceList = new PriceList(); 
		priceList.setEstablishment((Establishment)request.getSession().getAttribute("establishment"));
		priceList.setProduct(ProductDao.GetProductById(Long.parseLong(request.getParameter("product_id"))));
		priceList.setPrice(Double.parseDouble(request.getParameter("price")));
		priceList.setUnit(request.getParameter("unit"));
		
		return priceList;

	}

	public static Order GetOrder (HttpServletRequest request){
		
		// inputs
		Establishment establishment = (Establishment)request.getSession().getAttribute("establishment");
		Account account = (Account)request.getSession().getAttribute("account");
		Product product = ProductDao.GetProductById(Long.parseLong(request.getParameter("product_id"))); //FASE 2 - descer para o nível de itens
		Double price = PriceListDao.GetPriceList(establishment, product).getPrice(); //FASE 2 - descer para o nível de itens
		
		Order order = new Order(); 
		order.setEstablishment(establishment);
		order.setAccount(account);
		order.setStatus(request.getParameter("status"));
		
		List<OrderItem> itens = new ArrayList<OrderItem>();
		
		// monday
		if(!Util.IsEmpty(request.getParameter("monday_time")) && !Util.IsEmpty(request.getParameter("monday_amount"))){

			OrderItem item = new OrderItem();
			item.setProduct(product);
			item.setPrice(price);
			item.setDayOfWeek("segunda");
			item.setUnit("unidade");
			item.setDeliveryTime(Date.valueOf(request.getParameter("monday_time")));
			item.setQuantity(Integer.parseInt(request.getParameter("monday_amount")));
			itens.add(item);
			
		}
		// tueday
		if(!Util.IsEmpty(request.getParameter("tuesday_time")) && !Util.IsEmpty(request.getParameter("tuesday_amount"))){

			OrderItem item = new OrderItem();
			item.setProduct(product);
			item.setPrice(price);
			item.setDayOfWeek("terça");
			item.setUnit("unidade");
			item.setDeliveryTime(Date.valueOf(request.getParameter("tuesday_time")));
			item.setQuantity(Integer.parseInt(request.getParameter("tuesday_amount")));
			itens.add(item);
			
		}
		// wednesday
		if(!Util.IsEmpty(request.getParameter("wednesday_time")) && !Util.IsEmpty(request.getParameter("wednesday_amount"))){

			OrderItem item = new OrderItem();
			item.setProduct(product);
			item.setPrice(price);
			item.setDayOfWeek("quarta");
			item.setUnit("unidade");
			item.setDeliveryTime(Date.valueOf(request.getParameter("wednesday_time")));
			item.setQuantity(Integer.parseInt(request.getParameter("wednesday_amount")));
			itens.add(item);
			
		}		
		// thursday
		if(!Util.IsEmpty(request.getParameter("thursday_time")) && !Util.IsEmpty(request.getParameter("thursday_amount"))){

			OrderItem item = new OrderItem();
			item.setProduct(product);
			item.setPrice(price);
			item.setDayOfWeek("quinta");
			item.setUnit("unidade");
			item.setDeliveryTime(Date.valueOf(request.getParameter("thursday_time")));
			item.setQuantity(Integer.parseInt(request.getParameter("thursday_amount")));
			itens.add(item);
			
		}
		// friday
		if(!Util.IsEmpty(request.getParameter("friday_time")) && !Util.IsEmpty(request.getParameter("friday_amount"))){

			OrderItem item = new OrderItem();
			item.setProduct(product);
			item.setPrice(price);
			item.setDayOfWeek("sexta");
			item.setUnit("unidade");
			item.setDeliveryTime(Date.valueOf(request.getParameter("friday_time")));
			item.setQuantity(Integer.parseInt(request.getParameter("friday_amount")));
			itens.add(item);
			
		}		
		// saturday
		if(!Util.IsEmpty(request.getParameter("saturday_time")) && !Util.IsEmpty(request.getParameter("saturday_amount"))){

			OrderItem item = new OrderItem();
			item.setProduct(product);
			item.setPrice(price);
			item.setDayOfWeek("sábado");
			item.setUnit("unidade");
			item.setDeliveryTime(Date.valueOf(request.getParameter("saturday_time")));
			item.setQuantity(Integer.parseInt(request.getParameter("saturday_amount")));
			itens.add(item);
			
		}		
		// sunday
		if(!Util.IsEmpty(request.getParameter("sunday_time")) && !Util.IsEmpty(request.getParameter("sunday_amount"))){

			OrderItem item = new OrderItem();
			item.setProduct(product);
			item.setPrice(price);
			item.setDayOfWeek("domingo");
			item.setUnit("unidade");
			item.setDeliveryTime(Date.valueOf(request.getParameter("sunday_time")));
			item.setQuantity(Integer.parseInt(request.getParameter("sunday_amount")));
			itens.add(item);
			
		}
		order.setOrderItem(itens);
		
		return order;

	}

	public static Address GetAddress (HttpServletRequest request){
		
		Address address = new Address();
		address.setZipCode(request.getParameter("zipCode"));
		
		if(!Util.IsEmpty(request.getParameter("street")))
			address.setStreet(request.getParameter("street"));
		
		if(!Util.IsEmpty(request.getParameter("city")))
			address.setCity(request.getParameter("city"));
		
		if(!Util.IsEmpty(request.getParameter("state")))
			address.setState(request.getParameter("state"));			
		
		if(!Util.IsEmpty(request.getParameter("country")))
			address.setCountry(request.getParameter("country"));
		
		if(!Util.IsEmpty(request.getParameter("latitude")))
			address.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		
		if(!Util.IsEmpty(request.getParameter("longitude")))
			address.setLongitude(Double.parseDouble(request.getParameter("longitude")));

		if(!Util.IsEmpty(request.getParameter("number")))
			address.setNumber(Integer.parseInt(request.getParameter("number")));
		
		if(!Util.IsEmpty(request.getParameter("premise")))
			address.setPremise(request.getParameter("premise"));
		
		if(!Util.IsEmpty(request.getParameter("account_id")))
			address.setAccountId(Long.parseLong(request.getParameter("account_id")));
		
		if(!Util.IsEmpty(request.getParameter("establishment_id")))
			address.setEstablishmentId(Long.parseLong(request.getParameter("establishment_id")));
		
		return address;

	}
	
	public static Establishment GetEstablishment (HttpServletRequest request){
		
		Establishment establishment = new Establishment();		
		establishment.setName(request.getParameter("name"));
		establishment.setAlias(request.getParameter("alias"));
		establishment.setEmail(request.getParameter("email"));
		establishment.setRegisterNumber(Long.parseLong(request.getParameter("register_number")));
		establishment.setRadius(Integer.parseInt(request.getParameter("radius")));
		establishment.setResponsibleName(request.getParameter("responsible_name"));
		establishment.setResponsibleEmail(request.getParameter("responsible_email"));
		establishment.setResponsiblePhone(request.getParameter("responsible_phone"));
		establishment.setUserLogin(request.getParameter("email"));
		establishment.setUserPassword(request.getParameter("password").toCharArray());			
		establishment.setPhotoUrl(request.getParameter("photo_url"));
		
		if(!Util.IsEmpty(request.getParameter("rate")))
			establishment.setRate(Integer.parseInt(request.getParameter("rate")));
		
		if(!Util.IsEmpty(request.getParameter("phone")))
			establishment.setPhone(request.getParameter("phone"));
		
		return establishment;
		
	}
	
	public static Schedule GetSchedule (Establishment establishment, String startTime, String endTime, String dayWeek){
		
		Schedule schedule = new Schedule(); 
		schedule.setEstablishment(establishment);
		schedule.setStartTime(startTime);
		schedule.setEndTime(endTime);
		schedule.setDayWeek(dayWeek);
		
		return schedule;
	
	}

	public static Product GetProduct (HttpServletRequest request){
		
		Product product = new Product(); 
		product.setName(request.getParameter("name"));
		product.setDescription(request.getParameter("description"));
		
		return product;
	
	}

	
}
