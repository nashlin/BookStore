package cn.itcast.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Orders {

	private String id;
	private Date date;
	private float totalPrice;
	private User user;
	private int status;
	private Set<OrderItem> set=new HashSet<OrderItem>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Set<OrderItem> getSet() {
		return set;
	}
	public void setSet(Set<OrderItem> set) {
		this.set = set;
	}
	
}
