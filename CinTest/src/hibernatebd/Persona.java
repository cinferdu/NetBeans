/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatebd;

import java.io.Serializable;

/**
 *
 * @author cinthya.fernandez
 */
public class Persona implements Serializable{
    private String nombre;
    private String apellido;
    private int edad;
    private int dni;
    
    public void guardarPersona(){
        
    }
    
    public void setNombre(String nom){
        nombre=nom;
    }
    
    public void setApellido(String ap){
        apellido=ap;
    }
    
    public void setDNI(int id){
        dni=id;
    }
    
    public void setEdad(int ed){
        edad=ed;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public int getDNI(){
        return dni;
    }
    
    public int getEdad(){
        return edad;
    }
    
}
