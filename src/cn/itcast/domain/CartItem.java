package cn.itcast.domain;

public class CartItem {

	private Book book;
	private int num;
	private float price;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
		this.price=price*this.num;//�����鼮���ܼ۸�
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
