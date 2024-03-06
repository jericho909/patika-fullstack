package dao;

import core.DbConnection;
import entities.Brand;
import entities.Car;
import entities.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDao {

    private final Connection conn;
    private final BrandDao brandDao;
    private final ModelDao modelDao;


    public CarDao() {
        this.brandDao = new BrandDao();
        this.modelDao = new ModelDao();
        this.conn = DbConnection.getInstance();
    }

    public Car getById(int id){
        Car car = null;
        String query = "SELECT * FROM public.car WHERE car_id = ?";

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                this.match(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return car;
    }

    public Car match(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("car_id"));
        car.setModel_id(rs.getInt("car_model_id"));
        car.setColor(Car.Color.valueOf(rs.getString("car_color")));
        car.setKm(rs.getInt("car_km"));
        car.setPlate(rs.getString("car_plate"));
        car.setModel(this.modelDao.getById(car.getModel_id()));

        return car;
    }

    public ArrayList<Car> selectByQuery(String query){
        ArrayList<Car> carList = new ArrayList<>();
        try {
            ResultSet rs = this.conn.createStatement().executeQuery(query);
            while (rs.next()){
                carList.add(this.match(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public ArrayList<Car> findAll(){return this.selectByQuery("SELECT * FROM public.car ORDER BY car_id ASC");};

    public boolean updateCar(Car car) {
        String query = "UPDATE public.car SET " +
                "car_model_id = ?, " +
                "car_color = ?, " +
                "car_km = ?, " +
                "car_plate = ?, " +
                "WHERE model_id = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, car.getModel_id());
            preparedStatement.setString(2, car.getColor().toString());
            preparedStatement.setInt(3, car.getKm());
            preparedStatement.setString(4, car.getPlate());
            preparedStatement.setInt(5, car.getId());

            return preparedStatement.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteCar(int carId){
        String query = "DELETE FROM public.car WHERE car_id = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setInt(1, carId);
            return preparedStatement.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    public boolean saveCar(Car car){
        String query = "INSERT INTO public.car " +
                "(car_model_id, " +
                "car_color, " +
                "car_km, " +
                "car_plate) " +
                " VALUES " +
                "(?,?,?,?)";

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, car.getModel_id());
            preparedStatement.setString(2, car.getColor().toString());
            preparedStatement.setInt(3, car.getKm());
            preparedStatement.setString(4, car.getPlate());

            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
