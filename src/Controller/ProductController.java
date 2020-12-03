package Controller;

import dao.serviceImp.ProductServiceImp;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.ProductBindSupplier;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductServiceImp productServiceImp;

    @Autowired
    public void setProductServiceImp(ProductServiceImp productServiceImp) {
        this.productServiceImp = productServiceImp;
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteProduct(@PathVariable int id) {
        return this.productServiceImp.deleteProduct(id);
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<ProductBindSupplier> queryAllProduct() {
        return this.productServiceImp.queryAllProducts();
    }

    @RequestMapping("/add")
    @ResponseBody
    public boolean addProduct(@ModelAttribute Product product) {
        return this.productServiceImp.addProduct(product);
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean updateProduct(@ModelAttribute Product product) {
        return this.productServiceImp.updateProduct(product);
    }
    //根据商品的名称进行模糊查询
    @RequestMapping("/query")
    @ResponseBody
    public List<ProductBindSupplier> queryProduct(@RequestParam String name) {
        System.out.println(name);
        return this.productServiceImp.queryProduct(name);
    }
}
