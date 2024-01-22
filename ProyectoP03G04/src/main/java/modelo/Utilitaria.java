/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jmuni
 */
public class Utilitaria implements Serializable{
    private static String nameFileFerias = "feriasArchivo.dat";
    private static String nameFileEmprendedores = "emprendedoresArchivo.dat";
    private static String nameFileAuspiciantes = "auspiciantesArchivo.dat";
    private static String nameFileStands = "stands.dat";
    
    //Feria
    public static ArrayList<Feria> readListFromFileFeria(){
        ArrayList<Feria> usuarios = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(Utilitaria.nameFileFerias))){
            usuarios = (ArrayList<Feria>)in.readObject();
        }
        catch(IOException ioe){
        }
        catch(ClassNotFoundException c ){
        }
        return usuarios;
    }

    public static void saveListToFileFeria (ArrayList<Feria> usuarios)
    {
        try(ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(Utilitaria.nameFileFerias)))
        {
            out.writeObject(usuarios);
        }
        catch(IOException ioe){
        }
    }

    public static void  add_feria_file(Feria user){
        if(user != null){
            ArrayList<Feria> usuarios =  readListFromFileFeria();
            usuarios.add(user);
            Utilitaria.saveListToFileFeria(usuarios);
        }
    }
    
    //Emprendedor
    public static ArrayList<Emprendedor> readListFromFileEmprendedor(){
        ArrayList<Emprendedor> usuarios = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(Utilitaria.nameFileEmprendedores))){
            usuarios = (ArrayList<Emprendedor>)in.readObject();
        }
        catch(IOException ioe){
        }
        catch(ClassNotFoundException c ){
        }
        return usuarios;
    }

    public static void saveListToFileEmprendedor(ArrayList<Emprendedor> usuarios)
    {
        try(ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(Utilitaria.nameFileEmprendedores)))
        {
            out.writeObject(usuarios);
        }
        catch(IOException ioe){
        }
    }

    public static void  add_emprendedor_file(Emprendedor user){
        if(user != null){
            ArrayList<Emprendedor> usuarios =  readListFromFileEmprendedor();
            usuarios.add(user);
            Utilitaria.saveListToFileEmprendedor(usuarios);
        }
    }
    
    //Auspiciante
    public static ArrayList<Auspiciante> readListFromFileAuspiciante(){
        ArrayList<Auspiciante> usuarios = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(Utilitaria.nameFileAuspiciantes))){
            usuarios = (ArrayList<Auspiciante>)in.readObject();
        }
        catch(IOException ioe){
        }
        catch(ClassNotFoundException c ){
        }
        return usuarios;
    }

    public static void saveListToFileAuspiciante (ArrayList<Auspiciante> usuarios)
    {
        try(ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(Utilitaria.nameFileAuspiciantes)))
        {
            out.writeObject(usuarios);
        }
        catch(IOException ioe){
        }
    }

    public static void  add_auspiciante_file(Auspiciante user){
        if(user != null){
            ArrayList<Auspiciante> usuarios =  readListFromFileAuspiciante();
            usuarios.add(user);
            Utilitaria.saveListToFileAuspiciante(usuarios);
        }
    }
}
