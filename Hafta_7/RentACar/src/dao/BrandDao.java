package dao;

import core.DbConnection;
import entities.Brand;
import entities.User;

import java.sql.Connection;
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
        String query = "SELECT * FROM public.brand";
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
}
