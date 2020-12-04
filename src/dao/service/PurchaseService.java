package dao.service;

import models.Purchase;
import pojo.Purchasepojo;

import java.util.List;

public interface PurchaseService {
    public List<Purchase> queryPurchase();
    public boolean addPurchase(Purchasepojo purchase);
    public boolean deletePurchase(int id);
    public boolean updatePurchase(Purchasepojo purchase);
    public List<Purchase> queryPurchaseByName(String name);
}
