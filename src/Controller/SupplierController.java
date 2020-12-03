package Controller;

import dao.serviceImp.SupplierServiceImp;
import models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
    private SupplierServiceImp supplierServiceImp;

    @Autowired
    public void setSupplierServiceImp(SupplierServiceImp supplierServiceImp) {
        this.supplierServiceImp = supplierServiceImp;
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Supplier> querySuppliers() {
        return this.supplierServiceImp.querySuppliers();
    }

    @RequestMapping("/query")
    @ResponseBody
    public List<Supplier> querySupplier(@RequestParam String name) {
        return this.supplierServiceImp.querySupper(name);
    }

    @RequestMapping("/add")
    @ResponseBody
    public boolean addSupplier(@ModelAttribute Supplier supplier) {
        return this.supplierServiceImp.addSupper(supplier);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean updateSupplier(@ModelAttribute Supplier supplier) {
        return this.supplierServiceImp.updateSupper(supplier);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteSupplier(@PathVariable int id) {
        return this.supplierServiceImp.deleteSupper(id);
    }
}
