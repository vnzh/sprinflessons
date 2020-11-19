import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        try {
            System.out.println(productRepository.getProductById(2l));
        } catch (ExceptionProductRepository exceptionProductRepository) {
            exceptionProductRepository.printStackTrace();
        }
        CartService cartService = context.getBean("cartService", CartService.class);
        cartService.addProduct(7l);
        cartService.addProduct(1l);
        cartService.addProduct(3l);
//        cartService.printCart();
//        System.out.println(cartService.cost().toString());
        cartService.printCost();
        System.out.println();
        System.out.println();
        CartService cartService2 = context.getBean("cartService", CartService.class);
        cartService2.addProduct(5l);
        cartService2.addProduct(2l);
        cartService2.addProduct(4l);
//        cartService2.printCart();
//        System.out.println(cartService2.cost().toString());
        cartService2.printCost();
        cartService.printCost();
    }
}
