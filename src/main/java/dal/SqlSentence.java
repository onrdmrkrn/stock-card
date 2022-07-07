package dal;

import core.ObjectHelper;
import entities.Stock;
import types.StockComplexType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlSentence extends ObjectHelper {

    public  Stock findSqlSentence(int stockId){
        Stock stock = new Stock();
        Connection connection = getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stock WHERE stockId = "+stockId+"");
            while (resultSet.next()){
                stock.setStockId(resultSet.getInt("stockId"));
                stock.setStockName(resultSet.getString("stockName"));
                stock.setStockType(resultSet.getInt("stockType"));
                stock.setStockDescription(resultSet.getString("stockDescription"));
                stock.setBarcode(resultSet.getString("barcode"));
                stock.setUnit(resultSet.getString("unit"));
                stock.setCreatedDate(Date.valueOf(resultSet.getString("createdDate")));
                stock.setKdv(resultSet.getDouble("kdv"));
                stock.setPrice(resultSet.getFloat("price"));
            }
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stock;
    }

    public List<Stock> listSqlSentence (int stockId){
        List<Stock> stockList = new ArrayList<Stock>();
        Connection connection = getConnection();

        try {
            Statement statement =connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stock WHERE stockId LIKE '"
                    +'%'
                    +stockId
                    +'%'
                    +"'");

            while(resultSet.next()){
                Stock stock = new Stock();
                stock.setStockName(resultSet.getString("stockName"));
                stock.setStockType(resultSet.getInt("stockType"));
                stock.setBarcode(resultSet.getString("barcode"));
                stock.setKdv(resultSet.getDouble("kdv"));
                stock.setPrice(resultSet.getFloat("price"));
                stock.setCreatedDate(Date.valueOf(resultSet.getString("createdDate")));
                stock.setStockDescription(resultSet.getString("stockDescription"));
                stock.setStockId(resultSet.getInt("stockId"));
                stock.setUnit(resultSet.getString("unit"));

                stockList.add(stock);
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stockList;
    }

    public void updateSqlSentence (Stock entity){
        Connection connection = getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE stock SET stockName='"
                    +entity.getStockName()
                    +"', stockDescription='"
                    +entity.getStockDescription()
                    +"', unit='"
                    +entity.getUnit()
                    +"',barcode='"
                    +entity.getBarcode()
                    +"', kdv='"
                    +entity.getKdv()
                    +"', price='"
                    +entity.getPrice()
                    +"',stockType = "
                    +entity.getStockType()
                    +" WHERE stockId= "
                    +entity.getStockId()
                    +"");

            statement.close();
            connection.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Stock deleteSqlSentence (Stock entity){
        Stock stock = new Stock();
        Connection connection = getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE  FROM stock WHERE stockId = "+entity.getStockId()+"");

            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stock;
    }

    public List<Stock> getAllSqlSentence(){
        List<Stock> productList = new ArrayList<Stock>();
        Connection connection = getConnection();
        Stock product;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stock");

            while (resultSet.next()) {

                product = new Stock();
                product.setStockId(resultSet.getInt("stockId"));
                product.setStockName(resultSet.getString("stockName"));
                product.setStockDescription(resultSet.getString("stockDescription"));
                product.setStockType(resultSet.getInt("stockType"));
                product.setBarcode(resultSet.getString("barcode"));
                product.setKdv(resultSet.getDouble("kdv"));
                product.setPrice(resultSet.getFloat("price"));
                product.setUnit(resultSet.getString("unit"));
                product.setCreatedDate(Date.valueOf(resultSet.getString("createdDate")));

                productList.add(product);
            }
            statement.close();
            resultSet.close();
        }

        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return productList;
    }

    public void ınsertSqlSentence(Stock entity){
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO stock  (stockName, unit, barcode, stockDescription,createdDate,stockType,kdv,price) "
                    +"VALUES('"
                    + entity.getStockName()
                    +"','"
                    + entity.getUnit()
                    + "','"
                    +entity.getBarcode()
                    +"','"
                    +entity.getStockDescription()
                    +"','"
                    +entity.getCreatedDate()
                    +"',"
                    +entity.getStockType()
                    +","
                    +entity.getKdv()
                    +","
                    +entity.getPrice()
                    +")");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public List<StockComplexType> getAllSqlSentenceType(){
        List<StockComplexType> productList = new ArrayList<StockComplexType>();
        Connection connection = getConnection();
        StockComplexType product;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stock");

            while (resultSet.next()) {

                product = new StockComplexType();
                product.setStockId(resultSet.getInt("stockId"));
                product.setStockName(resultSet.getString("stockName"));
                product.setStockDescription(resultSet.getString("stockDescription"));
                product.setStockType(resultSet.getInt("stockType"));
                product.setBarcode(resultSet.getString("barcode"));
                product.setKdv(resultSet.getDouble("kdv"));
                product.setPrice(resultSet.getFloat("price"));
                product.setUnit(resultSet.getString("unit"));
                product.setCreatedDate(Date.valueOf(resultSet.getString("createdDate")));

                productList.add(product);
            }
            statement.close();
            resultSet.close();
        }

        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return productList;
    }
}
