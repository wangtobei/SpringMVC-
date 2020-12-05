package dao.service;

import models.Sale;

import java.util.List;

public interface SaleService {
    public List<Sale> querySales();

    public List<Sale> querySalesByProductName(String name);

    public boolean addSale(Sale sale);

    public boolean updateSale(Sale sale);

    public boolean deleteSale(int sid);
}
