/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public interface IService<T> {
    boolean insert(T t);
    boolean update(T t);
    boolean delete(String email);
    List<T> displayAll();
    ResultSet display(String email);
    ResultSet display(int number);
    ResultSet display(String pass,String email);
}
