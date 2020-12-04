package Controller;

import dao.serviceImp.PurchaseServiceImp;
import models.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.Purchasepojo;

import java.util.List;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    private PurchaseServiceImp purchaseServiceImp;

    @Autowired
    public void setPurchaseServiceImp(PurchaseServiceImp purchaseServiceImp) {
        this.purchaseServiceImp = purchaseServiceImp;
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Purchase> queryPurchases() {
        return this.purchaseServiceImp.queryPurchase();
    }

    @RequestMapping("/add")
    @ResponseBody
    public boolean addPurchase(@ModelAttribute Purchasepojo purchasepojo) {
        return this.purchaseServiceImp.addPurchase(purchasepojo);
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean updatePurchase(@ModelAttribute Purchasepojo purchasepojo){
        return this.purchaseServiceImp.updatePurchase(purchasepojo);
    }
    @RequestMapping("/query")
    @ResponseBody
    public List<Purchase> queryPurchaseByProductName(@RequestParam String name){
        return this.purchaseServiceImp.queryPurchaseByName(name);
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public boolean deletePurchase(@PathVariable int id){
        return this.purchaseServiceImp.deletePurchase(id);
    }
}
