package dao;

import core.DbConnection;
import entities.Brand;
import entities.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelDao {
    private final Connection conn;
    private BrandDao brandDao;


    public ModelDao() {
        this.conn = DbConnection.getInstance();
    }

    public Model getById(int modelId){
        Model model = null;
        String query = "SELECT * FROM public.model WHERE (model_id) = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setInt(1, modelId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                model = this.match(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return model;
    }

    public Model match(ResultSet rs) throws SQLException {
        Model model = new Model();
        model.setModel_id(rs.getInt("model_id"));
        model.setModel_brand_id(rs.getInt("model_brand_id"));
        model.setModel_name(rs.getString("model_name"));
        model.setModel_fuel(Model.Fuel.valueOf(rs.getString("model_fuel")));
        model.setModel_gear(Model.Gear.valueOf(rs.getString("model_gear")));
        model.setModel_type(Model.Type.valueOf(rs.getString("model_type")));
        //model.setModel_brand(this.brandDao.getById(rs.getInt("model_brand_id")));
        model.setModel_year(rs.getString("model_year"));

        return model;
    }

    public ArrayList<Model> fetchAll(){
        return this.selectByQuery("SELECT * FROM public.model ORDER BY model_id ASC");
    }

    public boolean saveModel(Model model){
        String query = "INSERT INTO public.model " +
                "(model_brand_id, " +
                "model_name, " +
                "model_type, " +
                "model_year, " +
                "model_fuel, " +
                "model_gear) " +
                "VALUES " +
                "(?,?,?,?,?,?)";

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, model.getModel_id());
            preparedStatement.setString(2, model.getModel_name());
            preparedStatement.setString(3, model.getModel_type().toString());
            preparedStatement.setString(4, model.getModel_year());
            preparedStatement.setString(5, model.getModel_fuel().toString());
            preparedStatement.setString(6, model.getModel_gear().toString());
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateModel(Model model) {
        String query = "UPDATE public.model SET " +
                "model_brand_id = ?, " +
                "model_name = ?, " +
                "model_type = ?, " +
                "model_year = ?, " +
                "model_fuel = ?, " +
                "model_gear = ? " +
                "WHERE model_id = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, model.getModel_brand_id());
            preparedStatement.setString(2, model.getModel_name());
            preparedStatement.setString(3, model.getModel_type().toString());
            preparedStatement.setString(4, model.getModel_year());
            preparedStatement.setString(5, model.getModel_fuel().toString());
            preparedStatement.setString(6, model.getModel_gear().toString());
            preparedStatement.setInt(7, model.getModel_id());

            return preparedStatement.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    public boolean deleteModel(int modelId){
        String query = "DELETE FROM public.model WHERE model = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setInt(1, modelId);
            return preparedStatement.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    public ArrayList<Model> selectByQuery(String query){
        ArrayList<Model> modelList = new ArrayList<>();
        try {
            ResultSet rs = this.conn.createStatement().executeQuery(query);
            while (rs.next()){
                modelList.add(this.match(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return modelList;
    }


}
