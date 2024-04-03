package miu.edu;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int id;
    List<CartLine> lineList = new ArrayList<>();

    public ShoppingCart(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CartLine> getLineList() {
        return lineList;
    }

    public void setLineList(List<CartLine> lineList) {
        this.lineList = lineList;
    }

    public void addLine (CartLine cartLine) {
        lineList.add(cartLine);
    }

    public List<CartLine> checkout() {
        return lineList;
    }
}
