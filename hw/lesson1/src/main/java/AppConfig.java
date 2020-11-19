import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("my.hw.lesson1")
public class AppConfig {

@Bean (name = "productRepository")
public ProductRepository productRepository () {
     return new ProductRepository();
}
@Bean (name = "cartService")
@Scope("prototype")
    public CartService cartService () {
CartService cartService = new CartService();
cartService.setProductRepository(productRepository());
    return new CartService();
}

}
