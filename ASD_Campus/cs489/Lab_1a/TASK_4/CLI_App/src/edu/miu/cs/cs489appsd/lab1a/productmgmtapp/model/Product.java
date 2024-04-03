package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;

public class Product implements Comparable<Product>{
    private Long productId;
    private String name;
    private LocalDate dateSupplied;
    private Integer quantityInStock;
    private Double unitPrice;

    public Product() {
    }

    public Product(Long productId, String name, LocalDate dateSupplied, Integer quantityInStock, Double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product(String name, LocalDate dateSupplied, Integer quantityInStock, Double unitPrice) {
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return
                "\"productId\":" + productId +
                ", \"name\":" + name +
                ", \"dateSupplied\":" + dateSupplied +
                ", \"quantityInStock\":" + quantityInStock +
                ", \"unitPrice\":" + unitPrice
                ;
    }

    @Override
    public int compareTo(Product p) {
        return this.name.compareTo(p.name);
    }
}
