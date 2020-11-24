package less2.Controllers;

import less2.models.Product;
import less2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    //all products
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product/index";
    }

    @GetMapping("/{id}")
    //product  by  id
    public String productOnId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "product/show";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute ("product")Product product) {
        return "product/new";
    }


    @PostMapping("/create")
    public String create(@ModelAttribute ("product") Product product) {
        productRepository.saveOrUpdate(product);
        return "redirect:/product";
    }

    @GetMapping("/change/{id}")
    public String changeProduct (@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "product/update";
    }

    @GetMapping ("/update")
    public String updateProduct(@ModelAttribute ("product") Product product) {

        productRepository.saveOrUpdate(product);
        return "redirect:/product";
    }
}
