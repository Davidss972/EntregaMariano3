/*
Copyright [2016] [David Sánchez Simón]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package Provedor;

import Productos.Alquiler;
import Productos.Cliente;
import Provedor.Interfaces.IAlquilerProveedor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AlquilerProveedor implements IAlquilerProveedor
{
    String nombreArchivo = "libretaAlquileres.csv";
    
    
    ArrayList<Alquiler> listaalquiler = new ArrayList<>();
    public AlquilerProveedor()
    {
        listaalquiler = cargarAlquileresDesdeArchivo();
    }
    
    public ArrayList<Alquiler> cargarAlquileresDesdeArchivo()
    {
        ArrayList<Alquiler> listaalquiler1 = new ArrayList<>();
        try
        {
            Scanner sc = new Scanner(new File(this.nombreArchivo)).useDelimiter("\n");
                sc.next();
            while(sc.hasNext())
            {
                Alquiler alquiler = new Alquiler(sc.next());
                listaalquiler1.add(alquiler);
            }
        }
        catch(FileNotFoundException ex)
        {
            Logger.getLogger(AlquilerProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaalquiler1;
    }
    private void volcarAlquileres() //antes de volcar manera de borrar todo lo que haya dentro/*porque lo que cargamos es la lista.*/
    {
        try {
                FileWriter fw = new FileWriter(new File(this.nombreArchivo));
                    fw.write("DNI;MATRICULA;FECHA;PRECIO\n");
                for (Alquiler alquiler : listaalquiler) 
                {
                    fw.write(alquiler.toString()+"\n");
                }
                fw.close();
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(AlquilerProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void mostrarAlquiler()
    {
        for (Alquiler alquiler : listaalquiler)
        {
            System.out.println(alquiler);
        }
    }
    public Alquiler conseguirAlquiler(String fecha)
    {
        String alquilermatricula = "";
            
        for (Alquiler alquiler : listaalquiler) 
        {
            alquilermatricula = alquiler.getFecha();
            if(alquilermatricula != null)
            {
                if(alquilermatricula == null ? fecha == null : alquilermatricula.equals(fecha))
                {
                    return alquiler;
                }  
            }
        }
        return null;    
    }
    public void añadirAlquiler (Alquiler newAlquiler)
        {
           listaalquiler.add(newAlquiler);
           volcarAlquileres();
        }
    public void borrarAlquiler(Alquiler deleteAlquiler)
        {
           listaalquiler.remove(deleteAlquiler);
           volcarAlquileres();
        }
    public void modificarAlquiler(Alquiler modifyAlquiler)//llamar a getclient y modificar diretamente
        {
            
           Alquiler alquiler = conseguirAlquiler(modifyAlquiler.getFecha());
           borrarAlquiler(alquiler);
           añadirAlquiler(modifyAlquiler);
        }

}
