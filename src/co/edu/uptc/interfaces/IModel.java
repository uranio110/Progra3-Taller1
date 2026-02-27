package co.edu.uptc.interfaces;

import co.edu.uptc.model.MyList;
import co.edu.uptc.model.Product;

public interface IModel {
    void addProduct(Product p);
    MyList<Product> getProducts();
    MyList<Product> getProductsSorted();
    int deleteByName(String keyword);
}