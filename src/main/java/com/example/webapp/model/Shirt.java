package com.example.webapp.model;

public class Shirt {

	
	private String brand;
	private int price;
	private int size;
	private String color;
	private boolean isChecked;
	private String fabric;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean getisChecked() {
		return isChecked;
	}
	public void setisChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
	public Shirt(String brand, int price, int size, String color, boolean isChecked, String fabric) {
		
		this.brand = brand;
		this.price = price;
		this.size = size;
		this.color = color;
		this.isChecked = isChecked;
		this.fabric = fabric;
	}
	@Override
	public String toString() {
		return "Shirt [brand=" + brand + ", price=" + price + ", size=" + size + ", color=" + color + ", isChecked="
				+ isChecked + ", fabric=" + fabric + "]";
	}
	
	
}
