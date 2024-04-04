/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author AraFl
 */
public class Gasto {
    
    String identificador;
    String fecha;
    String descripcion;
    double cantidad;
    String categoria;
    
    public Gasto(String identificador, String categoria, double cantidad, String descripcion, String fecha){
        this.identificador=identificador;
        this.categoria=categoria;
        this.cantidad=cantidad;
        this.descripcion=descripcion;
        this.fecha=fecha;
        
    }
    public String getIdentificador(){
        return this.identificador;
    }
    public String getCategoria(){
        return this.categoria;
    }
    public double getCantidad(){
        return this.cantidad;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    public String getFecha(){
        return this.fecha;
    }
    
    public void mostrar(){
        System.out.println("    GASTOR REGISTRADOS    ");
        System.out.println("ID: "+identificador);
        System.out.println("Categoria:\n" +categoria);
        System.out.println("Cantidad:\n$" +cantidad);
        System.out.println("Descripcion:\n" +descripcion);
        System.out.println("Fecha:\n"+fecha);
    }
}