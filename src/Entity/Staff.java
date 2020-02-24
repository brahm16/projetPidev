/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Staff {
private int id;
private String nom;
private String prenom ;
private float salary;
private String rib;
private String post;
private float prime;
private int statut;
private Date date;
private int nb_c;
private int nb_heur;
private int number;
private String reference;
    public Staff(String prenom, int nb_heur) {
        this.prenom = prenom;
        this.nb_heur = nb_heur;
    }

    public Staff( String prenom,String nom,float salary, String rib, String post,Date date, int number,String reference) {
        this.nom = nom;
        this.prenom = prenom;
        this.salary = salary;
        this.rib = rib;
        this.post = post;
        this.reference=reference;
        this.date = date;
      
        this.number=number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

  
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getPost() {
        return post;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public float getPrime() {
        return prime;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNb_c() {
        return nb_c;
    }

    public void setNb_c(int nb_c) {
        this.nb_c = nb_c;
    }

    public int getNb_heur() {
        return nb_heur;
    }

    public void setNb_heur(int nb_heur) {
        this.nb_heur = nb_heur;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", salary=" + salary + ", rib=" + rib + ", post=" + post + ", prime=" + prime + ", statut=" + statut + ", date=" + date + ", nb_c=" + nb_c + ", nb_prime=" + nb_heur + '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Staff(int id, String nom, String prenom,float salary, String post, String rib, float prime, int statut, Date date, int nb_c, int nb_heur,int number,String reference) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.salary = salary;
        this.rib = rib;
        this.post = post;
        this.prime = prime;
        this.statut = statut;
        this.date = date;
        this.nb_c = nb_c;
        this.nb_heur = nb_heur;
        this.number=number;
        this.reference=reference;
    }
   public Staff(String nom, String prenom,float salary, String post, String rib, float prime, int statut, Date date, int nb_c, int nb_heur,int number,String reference) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.salary = salary;
        this.rib = rib;
        this.post = post;
        this.prime = prime;
        this.statut = statut;
        this.date = date;
        this.nb_c = nb_c;
        this.nb_heur = nb_heur;
        this.number=number;
        this.reference=reference;
    }

}
