package co.edu.uptc.view;

import co.edu.uptc.interfaces.IPresenter;
import co.edu.uptc.interfaces.IView;

public class Menu {
    private IView view;
    private IPresenter presenter;

    public Menu(IView view, IPresenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    public void run() {
        int option;
        do {
            showOptions();
            option = readOption();
            executeOption(option);
        } while (option != 0);
    }

    private void showOptions() {
        view.show("\n===== GESTIÓN DE PRODUCTOS =====");
        view.show("1. Agregar producto");
        view.show("2. Listar productos");
        view.show("3. Listar ordenados por nombre");
        view.show("4. Eliminar producto");
        view.show("0. Salir");
    }

    private int readOption() {
        try {
            return Integer.parseInt(view.read("Opción: "));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void executeOption(int option) {
        switch (option) {
            case 1 -> presenter.AddProduct();
            case 2 -> presenter.ListProducts();
            case 3 -> presenter.ListSorted();
            case 4 -> presenter.DeleteProduct();
            case 0 -> view.show("Hasta luego.");
            default -> view.show("Opción inválida.");
        }
    }
}