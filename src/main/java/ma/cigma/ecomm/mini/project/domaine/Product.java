package ma.cigma.ecomm.mini.project.domaine;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    @ManyToOne
    private Category category;
    private Integer quantity;
    private Float price;
    private String modelNumber;
    private String aboutProduct;
    private String technicalDetails;
    private String shippingWeight;
    private String image;


}
