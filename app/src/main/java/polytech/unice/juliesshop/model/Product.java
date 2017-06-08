package polytech.unice.juliesshop.model;

import java.util.ArrayList;
import java.util.List;

import polytech.unice.juliesshop.R;

/**
 * @author Marion
 */

public class Product {
    private String name;
    private String price;
    private int liked;
    private boolean news;
    private int picture;
    private boolean order;
    private List produits = new ArrayList();
    private int id;
    private List<Product> productsLike = new ArrayList<>();
    private List<Product> orders = new ArrayList<>();
    private List<Product> newsList = new ArrayList<>();
    private List<Product> productsUnlike = new ArrayList<>();
    private List<Product> productsNothing = new ArrayList<>();


    public Product() {
    }


    public Product(String name, String price, int liked, int picture, boolean news, boolean order, int id) {
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.news = news;
        this.order = order;
        this.liked = liked;
        this.id = id;
    }

    public List<Product> products() {
        Product hp = new Product("Harry Potter", "15.52 €", 0, R.drawable.hp, true, false, 0);
        produits.add(hp);
        Product celine = new Product("Celine Dion", "12.45 €", 0, R.drawable.celine, false, false, 1);
        produits.add(celine);
        Product gardiens = new Product("Les Gardiens de la Galaxie", "42.00 €", 0, R.drawable.gardiens, true, true, 2);
        produits.add(gardiens);
        Product jul = new Product("Jul", "0.01 €", 0, R.drawable.jul, true, false, 3);
        produits.add(jul);
        Product lion = new Product("Le roi lion", "19.17 €", 0, R.drawable.lion, false, true, 4);
        produits.add(lion);
        Product android = new Product("Android", "55.98 €", 0, R.drawable.android1, false, false, 5);
        produits.add(android);
        return produits;
    }

    public List<Product> productsLiked() {
        int c = products().size();
        for (int i = 0; i < c; i++) {
            Product prod = (Product) produits.get(i);
            if (prod.getLiked() == 1) {
                productsLike.add(prod);
            } else if (prod.getLiked() == 0) {
                productsNothing.add(prod);
            } else if (prod.getLiked() == 2) {
                productsUnlike.add(prod);
            }
        }
        productsLike.addAll(productsNothing);
        productsLike.addAll(productsUnlike);
        return productsLike;
    }


    public Product tri(String nom) {
        List list = products();
        int c = list.size();
        for (int i = 0; i < c; i++) {
            Product pro = (Product) list.get(i);
            if (nom.equals(pro.getName())) {
                return pro;
            }
            //return new Product("lol", String.valueOf(c), 1, R.drawable.lion, true, true, 2);
        }
        return new Product();
    }


    public List<Product> orderProducts() {
        productsLiked();
        for (int i = 0; i < productsLike.size(); i++) {
            Product prod = productsLike.get(i);
            if (prod.isOrder()) {
                orders.add(prod);
            }
        }
        return orders;
    }

    public List<Product> newsProduct() {
        productsLiked();
        for (int i = 0; i < productsLike.size(); i++) {
            Product prod = productsLike.get(i);
            if (prod.isNews()) {
                newsList.add(prod);
            }
        }
        return newsList;
    }

    public List<Product> removeOrder(int i) {
        return (List<Product>) orders.remove(i);
    }

    public List<Product> addOrder(Product product) {
        orders.add(product);
        return orders;
    }


    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public boolean isNews() {
        return news;
    }

    public int getPicture() {
        return picture;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return name + "\nPrix : " + price;
    }

}
