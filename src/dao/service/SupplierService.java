package dao.service;

import models.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> querySuppliers();

    public List<Supplier> querySupper(String supName);

    public boolean addSupper(Supplier supplier);

    public boolean updateSupper(Supplier supplier);

    public boolean deleteSupper(int supID);
}
