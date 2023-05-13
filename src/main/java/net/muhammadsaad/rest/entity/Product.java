package net.muhammadsaad.rest.entity;


import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.URL;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "products")
public class Product implements Comparable<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private BigDecimal price;

    private String imageUrl;

    private Boolean isAvailable;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private int quantity;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imageUrl=" + imageUrl +
                ", isAvailable=" + isAvailable +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return this.getId().compareTo(product.getId());
    }
}
