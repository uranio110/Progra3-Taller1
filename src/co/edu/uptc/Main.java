package co.edu.uptc;

import java.util.List;

import co.edu.uptc.model.MyList;
import co.edu.uptc.model.Product;

public class Main {
    public static void main(String[] args) {
        
        List<Product> ml = new MyList<>();
        for(int i = 0; i < 10; i++){
            //ml.addInicio("Hola" + i);
            ml.add(new Product("banano", 2000, "lb"));
        }

        
    }
}