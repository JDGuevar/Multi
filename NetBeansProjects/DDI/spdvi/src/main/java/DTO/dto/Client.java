/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.dto;


import java.util.Date;


/**
 *
 * @author Alumne
 */
public class Client {
    private String document;
    private String nom;
    private String cognoms;
    private Date date;
    private String illa;

    public Client(String document, String nom, String cognoms, Date date, String illa) {
        this.document = document;
        this.nom = nom;
        this.cognoms = cognoms;
        this.date = date;
        this.illa = illa;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getNom() {
        return nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public Date getDate() {
        return date;
    }

    public String getIlla() {
        return illa;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIlla(String illa) {
        this.illa = illa;
    }

    public String[] toArrayString() {
        String[] client = new String[]{this.document,this.nom,this.cognoms,this.date.toString(),this.illa};
        return client;
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
