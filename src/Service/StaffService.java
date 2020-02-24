/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Staff;
import Connexion.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class StaffService implements IService<Staff>{
    
private Connection cnx;
private Statement st;
private PreparedStatement pst;
private ResultSet rs;
    public StaffService() {
    cnx=DataSource.getInstance().getCon();
    }

    @Override
    public boolean insert(Staff t) {
  
    //java.sql.Date date_sql = new java.sql.Date(t.getDate().toEpochDay());
    
         String req="insert into staff (firstname,lastname,salary,post,rib,prime,statut,Date_deb_trav,Nb_conj,Nb_heur,Phone,reference) values ('"+t.getPrenom()+"','"+t.getNom()+"','"+t.getSalary()+"','"+t.getPost()+"','"+t.getRib()+"',0,0,'"+t.getDate()+"',0,0,'"+t.getNumber()+"','"+t.getReference()+"')";
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
    public boolean update(Staff t) {
    String req="UPDATE staff SET statut='"+t.getStatut()+"',firstname='"+t.getPrenom()+"', lastname='"+t.getNom()+"',salary='"+t.getSalary()+"',post='"+t.getPost()+"',rib='"+t.getRib()+"',prime='"+t.getPrime()+"',Phone='"+t.getNumber()+"',Date_deb_trav='"+t.getDate()+"',Nb_conj='"+t.getNb_c()+"',Nb_heur='"+t.getNb_heur()+"',reference='"+t.getReference()+"' where id_staff='"+t.getId()+"'";
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
    public List<Staff> displayAll() {
String red="select firstname,lastname,salary,post,rib,prime,statut,Date_deb_trav,Nb_conj,Nb_heur,Phone,reference from staff";
    List<Staff> list=new ArrayList<>();
    try {
        st=cnx.createStatement();
        rs=st.executeQuery(red);
        while(rs.next()){
           list.add(new Staff(rs.getString(1),rs.getString(2),rs.getFloat(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getInt(7),rs.getDate(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getString(12)));
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
    
    public ResultSet search() {
 String req="select * from staff where year(NOW())-year(Date_deb_trav) <= 3 and Nb_conj >=5 and Nb_heur < 30";
     
     try {
        st=cnx.createStatement();
        rs=st.executeQuery(req);
         
     }catch(Exception e)
     {
                 Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
     }
return rs;
    }

    
public ResultSet displayNom_nb()
{
    String req="select lastname,Nb_heur from staff where Nb_heur > 30";
    
    try {
        st=cnx.createStatement();
        rs=st.executeQuery(req);
        
    } catch (SQLException ex) {
        Logger.getLogger(StaffService.class.getName()).log(Level.SEVERE, null, ex);
    }
        return rs;
}
public int nombre()
    {int nb=0;
        try {
        String req="select COUNT(id_staff) from staff ";
        st=cnx.createStatement();
        rs=st.executeQuery(req);
     while(rs.next())
     {
      nb=rs.getInt(1); 
     } 
    }
        catch (SQLException ex) {
        Logger.getLogger(StaffService.class.getName()).log(Level.SEVERE, null, ex);
    }
        return nb;
}

    @Override
    public boolean delete(String ref) {
 String req="DELETE FROM staff WHERE reference='"+ref+"'";
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
    public ResultSet display(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet display(int number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet display(String nom, String prenom) {
 String req="select * from staff where firstname='"+prenom+"' AND lastname='"+nom+"' ";
     
     try {
        st=cnx.createStatement();
        rs=st.executeQuery(req);
         
     }catch(Exception e)
     {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
     }
return rs;
    }
}