package interfaces;

import java.util.List;

public interface IDal<T>{
	
	 void Insert(T entity);
	 List<T> getAll();
	 T Delete(T entity);
	 void Update (T entity);
	 List<T> GetById(int id);
}
