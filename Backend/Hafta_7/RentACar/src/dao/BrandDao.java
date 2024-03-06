package dao;

import core.DbConnection;
import entities.Brand;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandDao {
    private final Connection conn;

    public BrandDao() {
        this.conn = DbConnection.getInstance();
    }

    public ArrayList<Brand> fetchAll(){
        ArrayList<Brand> brandsList = new ArrayList<>();
        String query = "SELECT * FROM public.brand ORDER BY brand_id ASC";
        try {
            ResultSet rs = this.conn.createStatement().executeQuery(query);
            while (rs.next()){
                brandsList.add(this.match(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return brandsList;
    }

    public Brand match(ResultSet rs) throws SQLException {
        Brand brand = new Brand();
        brand.setBrand_id(rs.getInt("brand_id"));
        brand.setBrand_name(rs.getString("brand_name"));

        return brand;
    }

    public boolean saveBrand(Brand brand){
        String query = "INSERT INTO public.brand (brand_name) VALUES (?)";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setString(1, brand.getBrand_name());
            return preparedStatement.executeUpdate() != 1;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    public Brand getById(int brandId){
        Brand brand = null;
        String query = "SELECT * FROM public.brand WHERE (brand_id) = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setInt(1, brandId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                brand = this.match(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return brand;
    }

    public boolean updateBrand(Brand brand){
        String query = "UPDATE public.brand SET brand_name = ? WHERE brand_id = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setString(1, brand.getBrand_name());
            preparedStatement.setInt(2, brand.getBrand_id());
            return preparedStatement.executeUpdate() != 1;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    public boolean deleteBrand(int brandId){
        String query = "DELETE FROM public.brand WHERE brand_id = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setInt(1, brandId);
            return preparedStatement.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }
}
