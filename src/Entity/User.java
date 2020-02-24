/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author HP
 */
public class User {
private int idu;
    private String firstname_u;
    private String lastname_u;
    private String password;
    private String usertype;
    private String Email;
    private String photo;
    private int number;

    public User() {
    }

    public User(int idu, String firstname_u, String lastname_u, String password, String usertype, String Email, String photo, int number) {
        this.idu = idu;
        this.firstname_u = firstname_u;
        this.lastname_u = lastname_u;
        this.password = password;
        this.usertype = usertype;
        this.Email = Email;
        this.photo = photo;
        this.number = number;
    }

    public User(String firstname_u, String lastname_u, String password, String usertype, String Email, String photo, int number) {
        this.firstname_u = firstname_u;
        this.lastname_u = lastname_u;
        this.password = password;
        this.usertype = usertype;
        this.Email = Email;
        this.photo = photo;
        this.number = number;
    }
public User(String firstname_u, String lastname_u,String usertype, String Email, String photo, int number) {
        this.firstname_u = firstname_u;
        this.lastname_u = lastname_u;
        this.password = password;
        this.usertype = usertype;
        this.Email = Email;
        this.photo = photo;
        this.number = number;
    }
    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getFirstname_u() {
        return firstname_u;
    }

    public void setFirstname_u(String firstname_u) {
        this.firstname_u = firstname_u;
    }

    public String getLastname_u() {
        return lastname_u;
    }

    public void setLastname_u(String lastname_u) {
        this.lastname_u = lastname_u;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" + "idu=" + idu + ", firstname_u=" + firstname_u + ", lastname_u=" + lastname_u + ", password=" + password + ", usertype=" + usertype + ", Email=" + Email + ", photo=" + photo + ", number=" + number + '}';
    }
    
}
