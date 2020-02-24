/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.User;
import Connexion.DataSource;
import Connexion.image;
import GUI.FXMLIdentificationController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author HP
 */
public class UserService  implements IService<User> {
private Connection cnx;
private Statement st;
private PreparedStatement pst;
private ResultSet rs;
    public UserService(){
        cnx=DataSource.getInstance().getCon();
        
    }



public void Insertps(User u)
{
      String req="insert into user (FirstName_U,LastName_U,Password,UserType,Email,Photo,Phone_Number) values (?,?,?,?,?,?,?)";   
          try
    {
        pst=cnx.prepareStatement(req);
        pst.setString(1, u.getFirstname_u());
        pst.setString(2, u.getLastname_u());
        pst.setString(3, u.getPassword());
        pst.setString(4, u.getUsertype());
        pst.setString(5, u.getEmail());
        pst.setString(6, u.getPhoto());
        pst.setInt(7, u.getNumber());
        pst.executeUpdate();
            }
        
       catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
        }


    @Override
    public boolean update(User t) {

String req="UPDATE user SET LastName_U='"+t.getLastname_u()+"',FirstName_U='"+t.getFirstname_u()+"',Password='"+t.getPassword()+"',UserType='"+t.getUsertype()+"',Email='"+t.getEmail()+"',Phone_Number='"+t.getNumber()+"',Photo='"+t.getPhoto()+"' WHERE IDU='"+t.getIdu()+"'";
try
    {
        st=cnx.createStatement();
        st.executeUpdate(req);
       return true;       
    }
        
       catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
return false;
    }
    public boolean update2(User t,String nom,String prenom,String type) {

String req="UPDATE user SET LastName_U='"+t.getLastname_u()+"',FirstName_U='"+t.getFirstname_u()+"',Password='"+t.getPassword()+"',UserType='"+t.getUsertype()+"',Email='"+t.getEmail()+"',Phone_Number='"+t.getNumber()+"',Photo='"+t.getPhoto()+"' WHERE FirstName_U='"+nom+"' LastName_U='"+prenom+"' UserType='"+type+"'";
try
    {
        st=cnx.createStatement();
        st.executeUpdate(req);
       return true;       
    }
        
       catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
return false;
    }

    @Override
    public boolean delete(String email) {
      String req="DELETE FROM user WHERE Email='"+email+"'";
try
    {
        st=cnx.createStatement();
        st.executeUpdate(req);
       return true;       
    }
        
       catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
return false;
    }

    @Override
    public List<User> displayAll() {
    String red="select  LastName_U,FirstName_U,UserType,Email,Photo,Phone_Number from user where UserType!='Admin'";
    List<User> list=new ArrayList<>();
    try {
        st=cnx.createStatement();
        rs=st.executeQuery(red);
        while(rs.next()){
            list.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }

    public ResultSet displayemail() {
    String red="select Email from user where UserType!='Admin' ";
     
    try {
        st=cnx.createStatement();
        rs=st.executeQuery(red);
    
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
    }
    
    @Override
    public ResultSet display(String email) {
try {
        st = cnx.createStatement();
  	String rq="select * from user where Email='"+email+"'";
        rs=st.executeQuery(rq);
}
 catch (SQLException ex) {
        Logger.getLogger(FXMLIdentificationController.class.getName()).log(Level.SEVERE, null, ex);
    }
return rs;
    }

    @Override
    public ResultSet display(int number) {
        try {
        st = cnx.createStatement();
String rq="select * from user where Phone_Number='"+number+"'";  
 rs=st.executeQuery(rq);
}
 catch (SQLException ex) {
        Logger.getLogger(FXMLIdentificationController.class.getName()).log(Level.SEVERE, null, ex);
    }
return rs;
        
        }

    @Override
    public boolean insert(User u) {

 String req="insert into user (FirstName_U,LastName_U,Password,UserType,Email,Photo,Phone_Number) values ('"+u.getFirstname_u()+"','"+u.getLastname_u()+"','"+u.getPassword()+"','"+u.getUsertype()+"','"+u.getEmail()+"','"+u.getPhoto()+"','"+u.getNumber()+"')";    try
    {
        st=cnx.createStatement();
        st.executeUpdate(req);
        return true;
            }
        
       catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
       }

    return false;
    }

    @Override
    public ResultSet display(String pass, String email) {

 try {
        st = cnx.createStatement();
String rq="select * from user where Password='"+pass+"' AND Email='"+email+"'";  
 rs=st.executeQuery(rq);
}
 catch (SQLException ex) {
        Logger.getLogger(FXMLIdentificationController.class.getName()).log(Level.SEVERE, null, ex);
    }
return rs;
        
        }
    public int number() throws SQLException
    {
        int nb=0;
        String rq="select count(idu) from user ";
    try {
        st = cnx.createStatement();
 rs=st.executeQuery(rq);

    while(rs.next())
    {
      nb=rs.getInt(1);
    }
    }
 catch (SQLException ex) {
        Logger.getLogger(FXMLIdentificationController.class.getName()).log(Level.SEVERE, null, ex);
    }
    return nb;
    }
            }
