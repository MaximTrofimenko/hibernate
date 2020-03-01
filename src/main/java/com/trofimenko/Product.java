package com.trofimenko;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private int cost;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "customers_products",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "customers_id")
    )
    private List<Customer> customers;

    @Override
    public String toString() {
        String allcustomers = "";
        for (Customer o : customers) {
            allcustomers += o.getName() + " ";
        }
        return "Product = " + name + ", Customers = " + allcustomers;
    }
}
