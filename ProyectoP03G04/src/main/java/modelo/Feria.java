/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import ec.edu.espol.proyectop03g04.AdministracionFeriasController;
import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;

/**
 *
 * @author isabella
 */
public class Feria implements Comparable<Feria>, Serializable {
    private String codigo;
    private String nombre;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private String lugar;
    private String descripcion;
    private String horario;
    private ArrayList<EmprendedorEnFeria> emprendedores;
    private ArrayList<AuspicianteEnFeria> auspiciantes;
    private OrganizacionStands seccion1;
    private OrganizacionStands seccion2;
    private OrganizacionStands seccion3;
    private OrganizacionStands seccion4;

    // Constructor de la clase Feria
  
    public Feria(String nombre, LocalDate fechaIni, LocalDate fechaFin, String lugar, String descripcion, String horario, int cntSec1, int cntSec2, int cntSec3, int cntSec4) {
        
        this.codigo = "F" + (AdministracionFeriasController.ferias.size() + 1);
        this.nombre = nombre;
        this.fechaIni  = fechaIni;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this. descripcion = descripcion;
        this.horario = horario;
        this.emprendedores = new ArrayList<>();
        this.auspiciantes = new ArrayList<>();
        this.seccion1 = new OrganizacionStands(cntSec1,1);
        this.seccion2 = new OrganizacionStands(cntSec2,2);
        this.seccion3 = new OrganizacionStands(cntSec3,3);
        this.seccion4 = new OrganizacionStands(cntSec4,4);
    }
  
    // Método toString() de la clase Feria
    
    public String toString() {
        String string1 = "Nombre: " + nombre + "\nDescripción: " + descripcion + "\nLugar: " + lugar + "\nFecha de inicio: " + fechaIni + "\nFecha de fin: " + fechaFin + "\nHorario: " + horario + "\nLista de auspiciantes: ";
       
        String string2 = null;
        for (AuspicianteEnFeria ausF: auspiciantes) {
            string2 = "\n>>> " + ausF;
        }
        String string3 = "\nCantidad de stands en sección 1: " + seccion1.getCantStands() + "\nCantidad de stands en sección 2: " + seccion2.getCantStands() + "\nCantidad de stands en sección 3: " + seccion3.getCantStands() + "\nCantidad de stands en sección 4: " + seccion4.getCantStands();

        return string1 + string2 + string3;
    }

    // Método útil para mostrar Feria
  
    public String verInfoFeria() {
        return "Código: " + codigo + "\n   Nombre: " + nombre + "\n   Fecha de inicio: " + fechaIni + "\n   Lugar: " +     lugar + "\n   Cantidad de auspiciantes: " + auspiciantes.size();
    }

    // Metodo util para ver informacion general de la feria
    public String verInfoGeneralFeria() {
        return "\n1. Nombre: " + nombre + "\n2. Descripción: " + descripcion + "\n3. Lugar: " + lugar + "\n4. Fecha de inicio: " + fechaIni + "\n5. Fecha de fin: " + fechaFin + "\n6. Horario: " + horario;
    }
  
    // Getters
  
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getLugar() {
        return lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public ArrayList<EmprendedorEnFeria> getEmprendedores() {
        return emprendedores;
    }

    public ArrayList<AuspicianteEnFeria> getAuspiciantes() {
        return auspiciantes;
    }

    public OrganizacionStands getSeccion1() {
        return seccion1;
    }

    public OrganizacionStands getSeccion2() {
        return seccion2;
    }

    public OrganizacionStands getSeccion3() {
        return seccion3;
    }

    public OrganizacionStands getSeccion4() {
        return seccion4;
    }

  
    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  
    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public void setEmprendedores(ArrayList<EmprendedorEnFeria> emp) {
        this.emprendedores = emp;
    }

    public void setAuspiciantes(ArrayList<AuspicianteEnFeria> aus) {
        this.auspiciantes = aus;
    }
    
    public void setSeccion1(OrganizacionStands seccion1) {
        this.seccion1 = seccion1;
    }
  
    public void setSeccion2(OrganizacionStands seccion2) {
        this.seccion2 = seccion2;
    }
  
    public void setSeccion3(OrganizacionStands seccion3) {
        this.seccion3 = seccion3;
    }
  
    public void setSeccion4(OrganizacionStands seccion4) {
        this.seccion4 = seccion4;
    }
    
    @Override
    public int compareTo(Feria o){
        return o.getFechaIni().compareTo(fechaIni);
    }
}
