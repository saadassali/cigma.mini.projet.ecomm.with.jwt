package ma.cigma.ecomm.mini.project.domaine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO  {
    private Long id;
    private String productName;
    private Category category;
    private Integer quantity;
    private String modelNumber;
    private String aboutProduct;
    private String technicalDetails;
    private String shippingWeight;
    private String image;
    private Float price;



    }