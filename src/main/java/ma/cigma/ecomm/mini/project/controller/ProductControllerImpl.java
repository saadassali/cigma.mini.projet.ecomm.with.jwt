package ma.cigma.ecomm.mini.project.controller;

import ma.cigma.ecomm.mini.project.domaine.Product;
import ma.cigma.ecomm.mini.project.domaine.ProductConverter;
import ma.cigma.ecomm.mini.project.domaine.ProductDTO;
import ma.cigma.ecomm.mini.project.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/product")
@RestController
public class ProductControllerImpl {
    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        Product product = ProductConverter.toBo(productDTO);
        return ProductConverter.toVo(productService.save(product));
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable("id") Long id) {
        Product product = productService.findById(id).orElse(null);
        return ProductConverter.toVo(product);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.deleteById(id);
    }

    @GetMapping
    public List<ProductDTO> list() {
        return ProductConverter.toListVo(productService.findAll());
    }

    @GetMapping("/page-query")
    public Page<ProductDTO> pageQuery(Pageable pageable) {
        Page<Product> productPage = productService.findAll(pageable);
        List<ProductDTO> dtoList = productPage
                .stream()
                .map(ProductConverter::toVo).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, productPage.getTotalElements());
    }

    @PutMapping("/{id}")
    public ProductDTO update(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {
        Product product = ProductConverter.toBo(productDTO);
        return ProductConverter.toVo(productService.update(product, id));
    }
}