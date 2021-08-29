package lk.ijse.parkingSystem.memory;

import lk.ijse.parkingSystem.model.Driver;
import java.util.ArrayList;

public class DriverArray {
    private static DriverArray arrays;
    private ArrayList<Driver> arrayDrivers;

    private DriverArray() {
        arrayDrivers = new ArrayList<>();
        arrayDrivers.add ( new Driver ( "Sumith Kumara" , "7835348345V" , "B6474845" , "Panadura" , "0725637456" ) );
        arrayDrivers.add ( new Driver ( "Amila Pathirana" , "8826253734V" , "B3354674" , "Galle" , "0717573583" ) );
        arrayDrivers.add ( new Driver ( "Jithmal Perera" , "9425245373V" , "B3674589" , "Horana" , "0772452457" ) );
        arrayDrivers.add ( new Driver ( "Sumith Dissanayaka" , "7835348345V" , "B8366399" , "Kaluthara" , "0782686390" ) );
        arrayDrivers.add ( new Driver ( "Sumanasiri Herath" , "9283289272V" , "B6474845" , "Beruwala" , "0772534436" ) );
        arrayDrivers.add ( new Driver ( "Awantha Fernando " , "7835348345V" , "B3554789" , "Colombo 5" , "0714534356" ) );
        arrayDrivers.add ( new Driver ( "Charith Sudara" , "9573536833V" , "B6474845" , "Baththaramulla" , "0771536662" ) );
        arrayDrivers.add ( new Driver ( "Prashan Dineth " , "7835348345V" , "B2683536" , "Wadduwa" , "0715353434" ) );
        arrayDrivers.add ( new Driver ( "Chethiya Dilan" , "7835348345V" , "B6474845" , "Panadura" , "0772436737" ) );
        arrayDrivers.add ( new Driver ( "Dushantha Perera" , "9255556343V" , "B2683536" , "Matara" , "0777245343" ) );
        arrayDrivers.add ( new Driver ( "Sumith Udayanga" , "7835348345V" , "B5343783" , "Galle" , "0703635442" ) );
        arrayDrivers.add ( new Driver ( "Dinesh Udara " , "7835348345V" , "B6474845" , "Hettimulla" , "0713456878" ) );
        arrayDrivers.add ( new Driver ( "Udana Chathuranga " , "9026344373V" , "B6474845" , "Kottawa" , "0772442444" ) );
        arrayDrivers.add ( new Driver ( "Mohommad Riaz " , "7835348345V" , "B6474845" , "Kaluthara" , "0777544222" ) );
        arrayDrivers.add ( new Driver ( "Sandun Kumara" , "9124537733V" , "B6474845" , "Panadura" , "0777544222" ) );
        arrayDrivers.add ( new Driver ( "Priyanga Perera " , "9135343537V" , "B2263333" , "Matara" , "0723344562" ) );
    }

    public static DriverArray getInstance() {
        if (arrays==null){
            arrays=new DriverArray();
        }
        return arrays;
    }

    public  ArrayList<Driver> getArrayDrivers() {
        return arrayDrivers;
    }

    public boolean setArrayDrivers(Driver driver) {
        arrayDrivers.add(driver);
        return true;
    }

}
