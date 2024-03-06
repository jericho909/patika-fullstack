package business;

import core.Helper;
import dao.BrandDao;
import entities.Brand;

import java.util.ArrayList;

public class BrandManager {
    private final BrandDao brandDao;

    public BrandManager() {
        this.brandDao = new BrandDao();
    }

    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> brandRowList = new ArrayList<>();
        for (Brand brand: this.findAll()){
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = brand.getBrand_id();
            rowObject[i++] = brand.getBrand_name();
            brandRowList.add(rowObject);
        }
        return brandRowList;
    }

    public ArrayList<Brand> findAll(){
        return this.brandDao.fetchAll();
    }

    public boolean saveBrand(Brand brand){
        if (brand.getBrand_id() != 0){
            Helper.showErrorMessage("Invalid entry.");
        }
        return this.brandDao.saveBrand(brand);
    }

    public Brand getById(int brandId){
        return this.brandDao.getById(brandId);
    }

    public boolean updateBrand(Brand brand){
        if (this.getById(brand.getBrand_id()) == null){
            Helper.showErrorMessage("ID not found.");
        }
        return this.brandDao.updateBrand(brand);
    }

    public boolean deleteBrand(int brandId){
        if (this.getById(brandId) == null){
            Helper.showErrorMessage("Cannot find ID.");
            return false;
        } else {
            return this.brandDao.deleteBrand(brandId);
        }
    }
}
