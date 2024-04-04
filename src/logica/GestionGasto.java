/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.Gasto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Mary Flores
 */
public class GestionGasto {
    String nombreArchivo1="Usuarios.txt";
    String nombreArchivo="Gastos.txt";
    String rutaArchivo= "C:\\Users\\Mary Flores\\OneDrive\\Documentos\\NetBeansProjects\\aplicacion_final";
    
    public GestionGasto(){
        
        File archivo = new File(rutaArchivo, nombreArchivo);

        // Verificar si el archivo ya existe
        if (archivo.exists()) {
            System.out.println("El archivo ya existe en el directorio.");
        } else {
            // El archivo no existe, crearlo
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado con éxito.");
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean linea1Blanco(){ //Retornara true si la linea esta en blanco o si el archivo es nuevo. Ya que esto nos sirve si es nuevo usuario o no
        File archivo = new File(rutaArchivo, nombreArchivo1);
        boolean boleano=true;
        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo1))) {
            // Lee la primera línea
            String primeraLinea = br.readLine();

                // Verifica si la primera línea está vacía o es null
                if (primeraLinea == null || primeraLinea.trim().isEmpty()) {
                    boleano=true;
                    
                } else {
                    boleano=false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }else {
            // El archivo no existe, crearlo
            try {
                if (archivo.createNewFile()) {
                    boleano= true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return boleano;
    }
    public boolean nuevoUsuario(String email, String contraseña){

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo1))) {
            bw.write("\nEmail: "+email+"\nContraseña: "+contraseña);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean eliminarGasto(String identificador){
        boolean booleano=false;
        if(buscarGasto(identificador)==true){
            HashMap<String, Gasto> existentes =recuperarGastos();
            existentes.remove(identificador);
            File archivoEliminar=new File(nombreArchivo);
            archivoEliminar.delete();
            
            Collection<Gasto> elementos=existentes.values();
            for(Gasto gas: elementos){
                boolean band=agregarGasto(gas.getIdentificador(), gas.getCategoria(), gas.getCantidad(), gas.getDescripcion());
            }
            return true;
        } else {
            return false;
        }
        
    }
    public boolean agregarGasto(String identificador,String categoria, double cantidad, String descripcion){
        boolean boleano=false;
         LocalDate fechaActual=LocalDate.now();//Se utiliza para crear la fecha del sistema la almacena en YYYY-MM-DD
        if(buscarGasto(identificador)==false){//Primero busca si ya existe ese gasto sino lo agrega 
            try(FileOutputStream fos=new FileOutputStream(nombreArchivo,true);
                PrintStream sal=new PrintStream(fos)){
                sal.println(identificador+"|"+categoria+"|"+cantidad+"|"+descripcion+"|"+fechaActual);   //Escribe sobre el archivo añadiendo los elementos que recibe 
                boleano= true;
        }catch(IOException e){
            e.printStackTrace();       
        }
        }
        return boleano;
    }
    
    
    
    public boolean buscarGasto(String identificador){
        
        boolean booleano=false;
        try(BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo))){
           String read;
           while((read=bf.readLine())!=null){
               String [] datos= read.split("[|]");
               if(datos[0].equals(identificador)){
                 booleano=true;  
                   
               }
           }
           
       }
       catch(IOException e){
           e.printStackTrace();
       }
        return booleano;
    }
    public boolean compararUsuario(String nombre, String contraseña){
        boolean booleano=false;
        try(BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo1))){
           String read;
           while((read=bf.readLine())!=null){
               String [] datos= read.split("[|]");
               if(datos[1].equals(nombre)&&datos[2].equals(contraseña)){
                 booleano=true;  
                   
               }
           }
           
       }
       catch(IOException e){
           e.printStackTrace();
       }
        return booleano;
    }
    
    
    
    
    public HashMap<String,Gasto> filtrarCategoría(String opcionCategoria){
        HashMap<String, Gasto> existentes =recuperarGastos();
        HashMap<String,Gasto> recuperados=new HashMap<>();
       Collection<Gasto> elementos=existentes.values();
            for(Gasto gas: elementos){
                if(opcionCategoria.equals(gas.getCategoria())){
                    System.out.println("lll");
                    recuperados.put(gas.getCategoria(), gas); //porque categoría y no identificador
                }
            }
         return recuperados;
        
    }
    
    public double filtrarEstadisticas(String fechaInicial, String fechaFinal, int opcestadistica) throws ParseException{
        SimpleDateFormat diaFormato=new SimpleDateFormat("yyyy-MM-dd");//Le indicamos el formato necesario para las fechas
        Date fechaIni=diaFormato.parse(fechaInicial);
        Date fechaFin=diaFormato.parse(fechaFinal);
        double sumaTotal=0.0;
        double sumaTotal1=0.0;
        try(BufferedReader bf= new BufferedReader(new FileReader(nombreArchivo))){
            String r;
            while((r=bf.readLine())!=null){
                String[] datos=r.split("[|]");
                Date fecha=diaFormato.parse(datos[4]);  //Convertimos el String de la fecha del archivo a un formato de fecha
                if (fecha.after(fechaIni)&&fecha.before(fechaFin)){//Verificamos que fechas estan en el periodo dado utilizando unos metodos del Date
                    sumaTotal=Double.parseDouble(datos[2])+sumaTotal;// Vamos almacenando la suma de todos los gastos 
                            
                }
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        Date fecha1=diaFormato.parse(fechaInicial);
        Date fecha2=diaFormato.parse(fechaFinal);
        long dias1=fecha1.getTime();
        long dias2=fecha2.getTime();
        long diario=(dias2-dias1)/86400000;
        switch(opcestadistica){
            case 1:
               sumaTotal1=sumaTotal/diario;
               break;
            case 2:
               sumaTotal1=sumaTotal/(diario*7);
               break;
            case 3:
               sumaTotal1=sumaTotal/(diario*30);
               break;
            case 4:
               sumaTotal1=sumaTotal/(diario*365);
               break;
        }
        return sumaTotal1;
    }
    public HashMap<String,Gasto> recuperarGastos(){//Este atributo es añadido para facilitar la eliminacion y filtrar mediante los Hash Map
        HashMap<String,Gasto> existentes=new HashMap<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(nombreArchivo))){
          String r;
          while((r=bf.readLine())!=null){
              String[] datos=r.split("[|]");
              Gasto gas= new Gasto(datos[0], datos[1],Double.parseDouble(datos[2]),datos[3],datos[4]);
              existentes.put(datos[0], gas);
          }
       }catch(IOException e){
            e.printStackTrace();
            
        }
        return existentes;
    }
    
    public boolean actualizarDatos(String identificadorAnterior, String identificador, String categoria, double cantidad,String descripcion){
        boolean booleano=false;
        if(buscarGasto(identificadorAnterior)==true){
            boolean band=eliminarGasto(identificadorAnterior);
            boolean band1=agregarGasto(identificador,categoria,cantidad,descripcion);
            booleano=true;
        }
        return booleano;
    }
    
}
