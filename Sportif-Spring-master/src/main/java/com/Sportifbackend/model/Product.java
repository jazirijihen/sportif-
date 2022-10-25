package com.Sportifbackend.model;

import com.Sportifbackend.model.cart.CartItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 4000)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private double price;

    @Column(nullable = false)
    private Date addedOn = new Date();

    @Lob
    @Column(nullable = true, length = Integer.MAX_VALUE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private byte[] image;

    public Product () {
    }

    public Product (String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    

    public Product(long id, String name, String description, double price, Date addedOn, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.addedOn = addedOn;
		this.image = image;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	

    
}
