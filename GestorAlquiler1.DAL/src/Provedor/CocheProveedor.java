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

import Productos.Coche;
import Provedor.Interfaces.ICocheProveedor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CocheProveedor implements ICocheProveedor
{
    String nombreFichero = "libretaCoches.csv";
    ArrayList<Coche> listacoches = new ArrayList<>();
    
    public CocheProveedor()
    {
        listacoches = cargarCochesDesdeArchivo();
    }
    
    public ArrayList<Coche> cargarCochesDesdeArchivo()
    {
        ArrayList<Coche> listacoches1 = new ArrayList<>();
        try  
        {
           
            Scanner sc = new Scanner(new File(this.nombreFichero)).useDelimiter("\n");
                sc.next();
            while (sc.hasNext()) 
            {
                Coche coche = new Coche(sc.next());
                listacoches1.add(coche);
            }
        }     
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(CocheProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }

            return listacoches1;
    }
    private void volcarCoches() //antes de volcar manera de borrar todo lo que haya dentro/*porque lo que cargamos es la lista.*/
    {
        try {
                FileWriter fw = new FileWriter(new File(this.nombreFichero));
                fw.write("MATRICULA;MARCA;MODELO\n");
                for (Coche coche : listacoches) 
                {
                    fw.write(coche.toString() + "\n"); 
                    
                }
                fw.close();
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(CocheProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void mostrarCoches()
    {
        for (Coche coche : listacoches)
        {
            System.out.println(coche);
        }
    }

    public Coche conseguirCoche(String matricula)
    {
        String cochematricula = "";
            
        for (Coche coche : listacoches) 
        {
            cochematricula = coche.getMatricula();
            if(cochematricula != null)
            {
                if(cochematricula == null ? matricula == null : cochematricula.equals(matricula))
                {
                    return coche;
                }  
            }
        }
        return null;    
    }
    
    public void añadirCoche (Coche newCoche)
        {
           listacoches.add(newCoche);
           volcarCoches();
        }
    public void borrarCoche(Coche deleteCoche)
        {
           listacoches.remove(deleteCoche);
           volcarCoches();
        }
    public void modificarCoche(Coche modifyCoche)//llamar a getclient y modificar diretamente
        {
           Coche coche = conseguirCoche(modifyCoche.getMatricula());
           borrarCoche(coche);
           añadirCoche(modifyCoche);
        }
    
}
