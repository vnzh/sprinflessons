package less2.repository;

import less2.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init() {
        this.productList = new ArrayList<>();
        this.productList.add(new Product(1L, "Fuct1", "DESCRIPTION1", "BRAND1", 2.5));
        this.productList.add(new Product(2L, "Fuct2", "DESCRIPTION2", "BRAND2", 1.8));
        this.productList.add(new Product(3L, "Fuct3", "DESCRIPTION3", "BRAND3", 1.9));
        this.productList.add(new Product(4L, "Fuct4", "DESCRIPTION4", "BRAND4", 2.15));
        this.productList.add(new Product(5L, "Fuct5", "DESCRIPTION5", "BRAND5", 2.05));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(productList);
    }

    public Product saveOrUpdate(Product product) {
        if (product.getId() == null) {
            product.setId(productList.size() + 1L);
            productList.add(product);
            return product;
        } else {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId().equals(product.getId())) {
                    productList.set(i, product);
                    return product;
                }
            }
        }
        throw new RuntimeException("Error save or update customer");
    }

    public Product findById(Long id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new RuntimeException("Customer not found");
    }
}

