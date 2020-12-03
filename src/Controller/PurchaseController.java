package Controller;

import dao.serviceImp.PurchaseServiceImp;
import models.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Purchasepjo;

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
    public boolean addPurchase(@ModelAttribute Purchasepjo purchasepjo) {
        return this.purchaseServiceImp.addPurchase(purchasepjo);
    }
}
