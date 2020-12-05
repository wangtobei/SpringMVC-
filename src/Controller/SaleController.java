package Controller;

import dao.serviceImp.SaleServiceImp;
import models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sale")
public class SaleController {
    private SaleServiceImp saleServiceImp;

    @Autowired
    public void setSaleServiceImp(SaleServiceImp saleServiceImp) {
        this.saleServiceImp = saleServiceImp;
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Sale> querySales() {
        return this.saleServiceImp.querySales();
    }

    @RequestMapping("/add")
    @ResponseBody
    public boolean addSale(@ModelAttribute Sale sale) {
        return this.saleServiceImp.addSale(sale);
    }


    @RequestMapping("/query")
    @ResponseBody
    public List<Sale> querySaleByProductName(@RequestParam String name) {
        return this.saleServiceImp.querySalesByProductName(name);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean updateSale(@ModelAttribute Sale sale) {
        return this.saleServiceImp.updateSale(sale);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteSale( @PathVariable int id) {
        return this.saleServiceImp.deleteSale(id);
    }
}
