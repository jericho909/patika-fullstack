package business;

import dao.BrandDao;
import entities.Brand;

import java.util.ArrayList;

public class BrandManager {
    private final BrandDao brandDao;

    public BrandManager() {
        this.brandDao = new BrandDao();
    }

    public ArrayList<Brand> findAll(){
        return this.brandDao.fetchAll();
    }
}
