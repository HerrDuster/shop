package net.duster.ishop.service;

import java.util.List;

import net.duster.ishop.entity.Category;
import net.duster.ishop.entity.Producer;
import net.duster.ishop.entity.Product;
import net.duster.ishop.form.SearchForm;

public interface ProductService {

	List<Product> listAllProducts(int page, int limit);
	
	int countAllProducts();
	
	List<Product> listProductsByCategory(String categoryUrl, int page, int limit);
	
	int countProductsByCategory(String categoryUrl);
	
	List<Category> listAllCategories();
	
	List<Producer> listAllProducers();
	
	List<Product> listProductsBySearchForm(SearchForm searchForm, int page, int limit);
	
	int countProductsBySearchForm(SearchForm searchForm);
}
