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
package Vistas;

import Presentadores.Interfaces.ICochePresentador;
import Productos.Coche;
import Provedor.CocheProveedor;
import Provedor.Interfaces.ICocheProveedor;
import Vistas.Interfaces.ICocheVista;
import colores.ColorTexto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gokud
 */
public class CocheVista implements ICocheVista
{
    BufferedReader console;
    ICochePresentador cochePresenter;
    ICocheProveedor cocheProvider;
    CocheProveedor mostrar = new CocheProveedor();
    public CocheVista(ICochePresentador diseño)
    {
        cochePresenter = diseño;
        console = new BufferedReader(new InputStreamReader(System.in));
    }
    public Coche getCocheDetails() throws IOException//detalles para cuando te hayas metido en coche.
    {
        Coche newcoche = new Coche();
        String continuamos;
        do{
            newcoche.setMatricula(getCocheMatricula());
            ColorTexto.println(ColorTexto.ANSI_CYAN,"introduce Marca");
            newcoche.setMarca(console.readLine());
            ColorTexto.println(ColorTexto.ANSI_CYAN,"introduce Modelo");
            newcoche.setModelo(console.readLine()); 
            ColorTexto.println(ColorTexto.ANSI_GREEN,"¿Deseea introducir un nuevo coche(S/N)?");
            continuamos = console.readLine();        
            return newcoche;
        }while (continuamos.startsWith("s") || continuamos.startsWith("S"));
    }
    public String getCocheMatricula() throws IOException//pedir matricula
    {
        ColorTexto.println(ColorTexto.ANSI_CYAN,"Introduzca la matricula: ");
        
        return console.readLine();
    }
    public int getCocheAction() throws IOException//switch 
    {
        console.readLine();
        int op;
        String menu="";
        Coche coche;
            menu="";
            menu+="****** Menú ******\n";
            menu+="1.- Añadir Coche \n";
            menu+="2.- Borrar Coche \n";
            menu+="3.- Modificar Coche \n";
            //menu+="4.- Buscar Coche \n";
            menu+="4.- Mostrar Coches \n";
            menu+="5.- Salir \n";
            ColorTexto.println(ColorTexto.ANSI_PURPLE,menu);
            op=Integer.parseInt(console.readLine());
            
            switch(op)
            {
                case 1:
                coche = getCocheDetails();
                cochePresenter.añadirCoche(coche);
                if(cochePresenter.añadirCoche(coche) == false)
                {

                }
                    break;
                case 2:
                
                if(cochePresenter.borrarCoche(getCocheMatricula()) == false)
                {
                    ColorTexto.println(ColorTexto.ANSI_RED,"El coche no existe");
                }
                    break;
                case 3:
                coche = getCocheDetails();
                cochePresenter.modificarCoche(coche);
                if(cochePresenter.modificarCoche(coche) == false)
                {
                    ColorTexto.println(ColorTexto.ANSI_RED,"El coche ha sido modificado");
                }
                    break;
                case 4:
                    mostrar.mostrarCoches();
                    break;
                case 5:
                    break;
            }
        
        return op;
        
    }
    public void run() throws IOException//while bucle
    {
        while(getCocheAction() != 5)
        {
        
        }    
           
    }
}
