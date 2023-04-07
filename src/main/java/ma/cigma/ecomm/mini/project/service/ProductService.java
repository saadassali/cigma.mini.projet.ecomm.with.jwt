package ma.cigma.ecomm.mini.project.service;


import ma.cigma.ecomm.mini.project.domaine.Product;

public interface ProductService extends GenericService<Product, Long> {
    Product update(Product entity, Long id);
}