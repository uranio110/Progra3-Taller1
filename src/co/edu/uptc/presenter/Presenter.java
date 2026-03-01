package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.IModel;
import co.edu.uptc.interfaces.IPresenter;
import co.edu.uptc.interfaces.IView;
import co.edu.uptc.model.MyList;
import co.edu.uptc.model.Product;
import co.edu.uptc.view.Menu;

public class Presenter implements IPresenter {
    private IModel model;
    private IView view;

    public Presenter(IModel model, IView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void start() {
        Menu menu = new Menu(view, this);
        menu.run();
    }

    @Override
    public void AddProduct() {
        Product p = readProductFromView();
        model.addProduct(p);
        view.show("Producto agregado correctamente.");
    }

    @Override
    public void ListProducts() {
        showProductList(model.getProducts());
    }

    @Override
    public void ListSorted() {
        showProductList(model.getProductsSorted());
    }

    @Override
    public void DeleteProduct() {
        String keyword = view.read("Nombre o parte del nombre: ");
        int deleted = model.deleteByName(keyword);
        view.show("Se eliminaron " + deleted + " producto(s).");
    }

    // --- submetodos privados ---

    // lee los campos del producto uno a uno
    private Product readProductFromView() {
        String desc  = view.read("Descripción: ");
        double price = parsePrice();
        String unit  = view.read("Unidad de medida: ");
        return new Product(desc, price, unit);
    }

    // maneja el caso en que el usuario escriba texto en el precio
    private double parsePrice() {
        try {
            return Double.parseDouble(view.read("Precio: "));
        } catch (NumberFormatException e) {
            view.show("Precio inválido, se asignó 0.");
            return 0;
        }
    }

    // convierte la lista a texto y la muestra
    private void showProductList(MyList<Product> list) {
        if (list.isEmpty()) {
            view.show("No hay productos registrados.");
            return;
        }
        view.show("\n--- PRODUCTOS ---");
        for (int i = 0; i < list.size(); i++) {
            view.show((i + 1) + ". " + list.get(i));
        }
    }
}