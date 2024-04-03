package miu.edu;

public abstract class CatalogItem {
    private String name;

    public CatalogItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
