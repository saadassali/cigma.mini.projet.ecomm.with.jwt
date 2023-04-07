package ma.cigma.ecomm.mini.project.domaine;


import java.util.ArrayList;
import java.util.List;

public class ProductConverter {
    public static ProductDTO toVo(Product bo) {
        if (bo == null || bo.getId() ==null)
            return null;
        ProductDTO vo = new ProductDTO();
        vo.setId(bo.getId());
        //vo.setCategory(bo.getCategory());
        vo.setAboutProduct(bo.getAboutProduct());
        vo.setImage(bo.getImage());
        vo.setProductName(bo.getProductName());
        vo.setModelNumber(bo.getModelNumber());
        vo.setQuantity(bo.getQuantity());
        vo.setModelNumber(bo.getModelNumber());
        vo.setPrice(bo.getPrice());

        vo.setTechnicalDetails(bo.getTechnicalDetails());
        return vo;
    }
    public static Product toBo(ProductDTO vo) {
        Product bo = new Product();
        bo.setId(vo.getId());
        //bo.setCategory(vo.getCategory());
        bo.setAboutProduct(vo.getAboutProduct());
        bo.setImage(vo.getImage());
        bo.setProductName(vo.getProductName());
        bo.setModelNumber(vo.getModelNumber());
        bo.setQuantity(vo.getQuantity());
        bo.setPrice(vo.getPrice());

        bo.setModelNumber(vo.getModelNumber());
        bo.setTechnicalDetails(vo.getTechnicalDetails());
        return bo;
    }
    public static List<ProductDTO> toListVo(List<Product> listBo) {
        List<ProductDTO> listVo = new ArrayList<>();
        for (Product pro : listBo) {
            listVo.add(toVo(pro));
        }
        return listVo;
    }
}
