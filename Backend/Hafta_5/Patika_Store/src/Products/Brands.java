package Products;

import java.util.TreeSet;

public class Brands {

    public static TreeSet<String> generateBrands(){
        TreeSet<String> brandSet = new TreeSet<>();
        brandSet.add("Samsung");
        brandSet.add("Lenovo");
        brandSet.add("Apple");
        brandSet.add("Huawei");
        brandSet.add("Casper");
        brandSet.add("Asus");
        brandSet.add("HP");
        brandSet.add("Monster");

        return brandSet;
    }

    public static void showBrands(TreeSet<String> listOfBrands){
        System.out.println("======BRANDS IN STOCK======");
        listOfBrands.forEach(System.out::println);
    }
}
