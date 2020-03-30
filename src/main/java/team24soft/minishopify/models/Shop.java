package team24soft.minishopify.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Shop {

    @NotNull
    @Size(min=2, max=30)
    public String name; //Name of the Shop
    public String category; //Category of the Shop
    public String description;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public List<Product> products;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;

    protected Shop(){}

    public Shop(String name, String category){
        this.name = name;
        this.category = category;
        this.products = new ArrayList<Product>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
