package miu.edu;

public abstract class Catalog {
    protected String name;

    public Catalog(String name) {
        this.name = name;
    }

    public abstract void print();
}
