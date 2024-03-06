package business;

import core.Helper;
import dao.BrandDao;
import dao.ModelDao;
import entities.Brand;
import entities.Model;

import java.util.ArrayList;

public class ModelManager {
    private final ModelDao modelDao;


    public ModelManager() {
        this.modelDao = new ModelDao();
    }

    public Model getById(int modelId){
        return this.modelDao.getById(modelId);
    }

    public ArrayList<Model> findAll(){
        return this.modelDao.fetchAll();
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Model> models){
        ArrayList<Object[]> modelList = new ArrayList<>();
        for (Model model: models){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = model.getModel_id();
            rowObject[i++] = model.getModel_brand_id();
            rowObject[i++] = model.getModel_name();
            rowObject[i++] = model.getModel_type();
            rowObject[i++] = model.getModel_year();
            rowObject[i++] = model.getModel_fuel();
            rowObject[i++] = model.getModel_gear();
           modelList.add(rowObject);
        }
        return modelList;
    }

    public boolean saveModel(Model model){
        if (this.getById(model.getModel_id()) != null){
            Helper.showErrorMessage("Invalid entry.");
        }
        return this.modelDao.saveModel(model);
    }

    public boolean updateModel(Model model){
        if (this.getById(model.getModel_id()) == null){
            Helper.showErrorMessage("ID not found.");
        }
        return this.modelDao.updateModel(model);
    }

    public boolean deleteModel(int modelId){
        if (this.getById(modelId) == null){
            Helper.showErrorMessage("Cannot find ID.");
            return false;
        } else {
            return this.modelDao.deleteModel(modelId);
        }
    }

//    public ArrayList<Model> searchForTable(Model.Fuel fuel, Model.Gear gear, Model.Type type){
//        String query = "SELECT * FROM public.model";
//        ArrayList<String> whereList = new ArrayList<>();
//
////        if (brandId != 0){
////            whereList.add("model_brand_id = " + brandId);
////        }
//
//        if (fuel != null){
//            whereList.add("model_fuel = '" + fuel.toString() + "'");
//        }
//
//        if (gear != null){
//            whereList.add("model_gear = '" + gear.toString() + "'");
//        }
//
//        if (type != null){
//            whereList.add("model_type = '" + type.toString() + "'");
//        }
//
//        String whereQuery = String.join(" AND ", whereList);
//        String finalQuery = query;
//        if (!whereQuery.isEmpty()){
//            finalQuery += " WHERE " + whereQuery;
//        }
//
//        return this.modelDao.selectByQuery(finalQuery);
//    }

}
