package miu.edu;

import java.util.ArrayList;
import java.util.Collection;

public class Categories extends Catalog{
    private Collection<Catalog> catalogs = new ArrayList<>();

    public Categories(String name) {
        super(name);
    }

    public void addItem (Catalog catalog) {
        catalogs.add(catalog);
    }

    @Override
    public void print() {
        System.out.println("Catagories name: " + name);
        for (Catalog catalog : catalogs) {
            catalog.print();
        }
    }
}
