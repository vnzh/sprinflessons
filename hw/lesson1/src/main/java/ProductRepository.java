import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component("productRepository")
public class ProductRepository {

    private List<Product> productList = new ArrayList<Product>();


    @PostConstruct
    public void init() {
        productList.add(new Product(1l, "fruct1", 1.20));
        productList.add(new Product(2l, "fruct2", 2.20));
        productList.add(new Product(3l, "fruct3", 1.75));
        productList.add(new Product(4l, "fruct4", 2.10));
        productList.add(new Product(5l, "fruct5", 5.05));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(productList);

    }

    public Product getProductById(Long id) throws ExceptionProductRepository {
//        System.out.println(id);
        for (Product prod : productList) {
//            System.out.println(prod);
            if (prod.getId() == id) {
                return prod;
            }
        }
            throw new ExceptionProductRepository(id.toString());
    }


}
