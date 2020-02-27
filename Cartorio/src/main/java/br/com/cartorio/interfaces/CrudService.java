package br.com.cartorio.interfaces;

import java.util.List;

public interface CrudService <T>{
	
	List<T> findAll();
    T findById(int id);
    boolean save(T objeto);
    void update(T objeto);
    void deleteById(int id);

}
