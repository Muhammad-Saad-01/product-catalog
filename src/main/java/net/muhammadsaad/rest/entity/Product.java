package net.muhammadsaad.rest.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.URL;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "products")
public class Product implements Comparable<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be greater than zero")
    private BigDecimal price;

    @URL(message = "Product image URL is invalid")
    private String imageUrl;

    private Boolean isAvailable;

    private Boolean isActive;

    @Size(max = 1000, message = "Product description must be no more than 1000 characters")
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
