package business;

import core.Helper;
import dao.CarDao;
import entities.Car;
import entities.Model;

import java.util.ArrayList;

public class CarManager {

    private final CarDao carDao;

    public CarManager() {
        this.carDao = new CarDao();
    }

    public Car getById(int id){
        return this.carDao.getById(id);
    }

    public boolean saveModel(Car car){
        if (this.getById(car.getId()) != null){
            Helper.showErrorMessage("Invalid entry.");
        }
        return this.carDao.saveCar(car);
    }

    public boolean updateModel(Car car){
        if (this.getById(car.getId()) == null){
            Helper.showErrorMessage("ID not found.");
        }
        return this.carDao.updateCar(car);
    }

    public boolean deleteModel(int carId){
        if (this.getById(carId) == null){
            Helper.showErrorMessage("Cannot find ID.");
            return false;
        } else {
            return this.carDao.deleteCar(carId);
        }
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Car> cars){
        ArrayList<Object[]> carList = new ArrayList<>();
        for (Car car: cars){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = car.getId();
            rowObject[i++] = car.getModel().getModel_brand().getBrand_name();
            rowObject[i++] = car.getModel().getModel_name();
            rowObject[i++] = car.getPlate();
            rowObject[i++] = car.getColor();
            rowObject[i++] = car.getKm();
            rowObject[i++] = car.getModel().getModel_year();
            rowObject[i++] = car.getModel().getModel_type();
            rowObject[i++] = car.getModel().getModel_fuel();
            rowObject[i++] = car.getModel().getModel_gear();

            carList.add(rowObject);
        }
        return carList;
    }

    public ArrayList<Car> findAll(){
        return this.carDao.findAll();
    }
}
