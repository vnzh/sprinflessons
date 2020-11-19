import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component("cartService")
@Scope("prototype")
public class CartService {
    private List<Product> cart = new ArrayList<Product>();

    public List<Product> getCart() {
        return Collections.unmodifiableList(cart);
    }

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Long id) {
//        System.out.println(id);
        try {
            cart.add(productRepository.getProductById(id));
            System.out.println(cart.get(cart.size()-1));
        } catch (ExceptionProductRepository exceptionProductRepository) {
            exceptionProductRepository.printStackTrace();
        }
    }

    public Double cost () {
        Double cost = 0d;
        for (Product product: cart ) {
            cost = cost + product.getPrice();
        }
        return cost;
    }

    public void  printCost () {
        System.out.format("Cost is %6.2f\n", cost());
    }

    public void  printCart () {
        for (Product product: cart
             ) {
            System.out.println(product);
        }
    }


}
