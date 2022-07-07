package entities;

import interfaces.ICoreInterface;

import java.sql.Connection;
import java.sql.Date;


public class Stock implements ICoreInterface {

	private int stockId;
	private String stockName;
	private String unit;
	private String barcode;
	private String stockDescription;
	private Date createdDate;



	private int stockType;
	private double kdv;
	private float price;

	@Override
	public String toString() {
		return "Stock{" +
				"stockId=" + stockId +
				", stockName='" + stockName + '\'' +
				", unit='" + unit + '\'' +
				", barcode='" + barcode + '\'' +
				", stockDescription='" + stockDescription + '\'' +
				", createdDate=" + createdDate +
				", stockType=" + stockType +
				", kdv=" + kdv +
				", price=" + price +
				'}';
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getStockDescription() {
		return stockDescription;
	}

	public void setStockDescription(String stockDescription) {
		this.stockDescription = stockDescription;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public double getKdv() {
		return kdv;
	}

	public void setKdv(double kdv) {
		this.kdv = kdv;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public Connection getConnection() {
		return null;
	}
}
