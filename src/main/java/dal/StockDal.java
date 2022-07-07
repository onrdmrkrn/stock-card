package dal;


import core.ObjectHelper;

import entities.Stock;
import interfaces.IDal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StockDal  extends SqlSentence implements IDal<Stock> {
	@Override
	public void Insert(Stock entity) {
		ınsertSqlSentence(entity);
	}
	@Override
	public List<Stock> getAll() {
		return getAllSqlSentence();
	}
	@Override
	public Stock Delete(Stock entity) {
		return deleteSqlSentence(entity);
	}
	@Override
	public void Update(Stock entity) {
 		updateSqlSentence(entity);
	}
	@Override
	public List<Stock> GetById(int stockId) {
		return listSqlSentence(stockId);
	}

	public Stock find(int stockId){
		return findSqlSentence(stockId);
	}


}
