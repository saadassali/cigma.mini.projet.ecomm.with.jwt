package ma.cigma.ecomm.mini.project.service;

import ma.cigma.ecomm.mini.project.dao.ProductRepository;
import ma.cigma.ecomm.mini.project.domaine.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public List<Product> save(List<Product> entities) {
        return (List<Product>) productRepository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productRepository.findById(id).get());
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product update(Product entity, Long id) {
        entity.setId(id);
        return productRepository.save(entity);
    }
}
