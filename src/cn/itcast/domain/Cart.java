package cn.itcast.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<String,CartItem> map=new HashMap<String, CartItem>();
	private float totalPrice;//�����鼮�ܼ۸�
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public float getTotalPrice() {//�����ܼ�
		totalPrice=0;
		for(Map.Entry<String,CartItem> m:map.entrySet()){
			totalPrice +=m.getValue().getPrice();
		}
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void addBook(Book book){//���ﳵ����
		if (!map.containsKey(book.getId())) {
			CartItem item=new CartItem();
			item.setBook(book);
			item.setNum(1);
			item.setPrice(Float.parseFloat(book.getPrice()));
			map.put(book.getId(), item);
		}else{
		
			CartItem item=map.get(book.getId());
			item.setNum(item.getNum()+1);
			item.setPrice(item.getPrice());
		}
	}
}
