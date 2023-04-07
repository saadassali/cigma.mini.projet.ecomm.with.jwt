package ma.cigma.ecomm.mini.project.dao;

import ma.cigma.ecomm.mini.project.domaine.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}