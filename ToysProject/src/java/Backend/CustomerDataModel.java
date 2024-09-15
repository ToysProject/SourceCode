package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Alex
 */
public class CustomerDataModel {
    
    private int _customerID = 0;
    private String _firstName = "";
    private String _lastName = "";
    private String _email = "";
    private String _password = "";
    private String _address = "";
    private String _city = "";
    private String _state = "";
    private String _zipCode = "";
    private String _phone = "";
    
    
    public CustomerDataModel(){
        
    }
    public CustomerDataModel(int customerID, String firstName, String lastName, String email, String password, String address, String city, String state, String zipCode, String phone){
        
        _customerID = customerID;
        _firstName = firstName;
        _lastName = lastName;
        _email = email;
        _password = password;
        _address = address;
        _city = city;
        _state = state;
        _zipCode = zipCode;
        _phone = phone;
        
    }
    
    public void setCustID(int customerId){_customerID = customerId;}
    public int getCustID(){return _customerID;}
    public void setFirstName(String firstName){_firstName = firstName;}
    public String getFirstName(){return _firstName;}
    public void setLastName(String lastName){_lastName = lastName;}
    public String getLastName(){return _lastName;}
    public void setAddress(String address){_address = address;}
    public String getAddress(){return _address;}
    public void setEmail(String email){_email = email;}
    public String getEmail(){return _email;}
    public void setPassword(String password){_password = password;}
    public String getPassword(){return _password;}
    public void setCity(String city){_city = city;}
    public String getCity(){return _city;}
    public void setState(String state){_state = state;}
    public String getState(){return _state;}
    public void setZipCode(String zipCode){_zipCode = zipCode;}
    public String getZipCode() {return _zipCode;}
    public void setPhone(String phone) {_phone = phone;}
    public String getPhone() {return _phone;}
    
    
        public void Read(int customerID){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        
            Connection con = DriverManager.getConnection(//UcanaccessDriver.URL_PREFIX + 
                "jdbc:ucanaccess://" + 
                "C://Users//Alex//Desktop//Documents//School Documents//CIST2931//ToysDatabase.accdb");
            
            Statement stmt = con.createStatement();
            String sql = "Select CustomerID, Password, FirstName, LastName, Address, Email, City, State, ZipCode, PhoneNumber from Customers where CustomerID = " + customerID;
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()){
            setCustID(rs.getInt(1));
            setPassword(rs.getString(2));
            setFirstName(rs.getString(3));
            setLastName(rs.getString(4));
            setAddress(rs.getString(5));
            setEmail(rs.getString(6));
            setCity(rs.getString(7));
            setState(rs.getString(8));
            setZipCode(rs.getString(9));
            setPhone(rs.getString(10));
            
           
            }
            else{
                System.out.println("Customer Not Found");
                
            }
            con.close();
        }
        catch(Exception e){
            System.out.println("Exception: " + e.toString());
        }

    }
    
}
