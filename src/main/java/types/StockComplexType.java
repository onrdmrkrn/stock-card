package types;

import java.sql.Date;

public class StockComplexType {

    private int stockId;
    private String stockName;
    private String unit;
    private String barcode;
    private String stockDescription;
    private Date createdDate;



    private int stockType;
    private double kdv;
    private float price;

    public Object[] getInfo(){
        Object[] info={stockId,stockName,unit,barcode,stockDescription,createdDate,stockType,kdv,price};
        return info;
    }

    @Override
    public String toString() {
        return stockName;
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
}
