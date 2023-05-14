package net.muhammadsaad.rest.entity;

import javax.persistence.Entity;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "Category name is required")
    private String name;

    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;

    private Boolean isActive;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Category(String name) {
        this.name = name;
    }
    public Category() {

    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
