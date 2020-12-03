package dao.service;

import models.Purchase;
import pojo.Purchasepjo;

import java.util.List;

public interface PurchaseService {
    public List<Purchase> queryPurchase();
    public boolean addPurchase(Purchasepjo purchase);
}
