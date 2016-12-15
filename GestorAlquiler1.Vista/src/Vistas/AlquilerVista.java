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

import Productos.Alquiler;
import Vistas.Interfaces.IAlquilerVista;
import java.io.BufferedReader;
import Presentadores.Interfaces.IAlquilerPresentador;
import Productos.Cliente;
import Provedor.Interfaces.IAlquilerProveedor;
import Provedor.AlquilerProveedor;
import Provedor.CocheProveedor;
import colores.ColorTexto;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
/**
 *
 * @author gokud
 */
public class AlquilerVista implements IAlquilerVista
{
    BufferedReader console;
    IAlquilerPresentador alquilerPresenter;
    IAlquilerProveedor alquilerProveedor;
    AlquilerProveedor mostrar = new AlquilerProveedor();
    
    public AlquilerVista(IAlquilerPresentador diseño)
    {
        alquilerPresenter = diseño;
        console = new BufferedReader(new InputStreamReader(System.in));
    }
    public Alquiler getAlquilerDetails()throws IOException
    {
        Alquiler newalquiler = new Alquiler();
        String continuamos;
        do
        {
            String dni = getClDni();
            if(!"".equals(dni))
            {
               Cliente clienteEncontrado = buscarcliente(dni);
               if (clienteEncontrado == null)
               {
                   System.out.println("El cliente no existe");
               }
               else
               {
               
                    mostrarCliente(clienteEncontrado);
                    newalquiler.setDni(dni);
                    newalquiler.setMatricula(getChMatri());
                    newalquiler.setFecha(getAlquilerFecha());
                    ColorTexto.println(ColorTexto.ANSI_CYAN,"Introduce el precio");
                    newalquiler.setPrecio(console.readLine());
                    ColorTexto.println(ColorTexto.ANSI_GREEN,"¿Deseea introducir un nuevo alquiler(S/N)?");
                    continuamos = console.readLine();
               }   
            }
        
            return newalquiler;
        
        }while (continuamos.startsWith("s") || continuamos.startsWith("S"));
    }
    public String getAlquilerFecha()throws IOException
    {
        
        Alquiler mostrarfechaactual = new Alquiler();
        ColorTexto.println(ColorTexto.ANSI_CYAN,"Usted alquilara los servicios desde "+mostrarfechaactual.mostrarFecha()+" hasta ");
        return console.readLine();
    }
    public String getClDni()throws IOException
    {
        ColorTexto.println(ColorTexto.ANSI_CYAN,"Introduzca el dni");
        return console.readLine();
    }
    public String getChMatri()throws IOException
    {
        ColorTexto.println(ColorTexto.ANSI_CYAN,"Introduzca la matricula correspondiente al coche que desea alquilar: ");
        CocheProveedor mostrarCoche = new CocheProveedor();
        mostrarCoche.mostrarCoches();
        return console.readLine();
    }
    public int getAlquilerAction()throws IOException
    {
        console.readLine();
        
        int op;
        String menu="";
        Alquiler alquiler;
            menu="";
            menu+="****** Menú ******\n";
            menu+="1.- Añadir Alquiler \n";
            menu+="2.- Borrar Alquiler \n";
            menu+="3.- Modificar Alquiler \n";
            //menu+="4.- Buscar Alquiler \n";
            menu+="4.- Mostrar Alquiler \n";
            menu+="5.- Salir \n";
            
            ColorTexto.println(ColorTexto.ANSI_PURPLE,menu);
            op=Integer.parseInt(console.readLine());
        
        switch(op)
        {
            case 1:
                alquiler = getAlquilerDetails();
                alquilerPresenter.añadirAlquiler(alquiler);
                if(alquilerPresenter.añadirAlquiler(alquiler) == false)
                {
                
                }
                break;
            case 2:
                if(alquilerPresenter.borrarAlquiler(getAlquilerFecha()) == false)
                {
                    ColorTexto.println(ColorTexto.ANSI_RED,"El alquiler no existe");
                }
                break;
            case 3:
                alquiler = getAlquilerDetails();
                alquilerPresenter.modificarAlquiler(alquiler);
                if(alquilerPresenter.modificarAlquiler(alquiler) == false)
                {
                    System.out.println("El alquiler ha sido modificado");
                }
                break;
            
            case 4:
                mostrar.mostrarAlquiler();
                break;
            case 5:
                break;
                
        }
        return op;
    }
    public void run()throws IOException
    {
        while(getAlquilerAction() != 5)
        {
            
        }
    
    }

    private Cliente buscarcliente(String Dni) 
        {
            return alquilerPresenter.buscarCliente(Dni);
        }

    private void mostrarCliente(Cliente cliente) 
        {
            System.out.println(cliente.toString());
        }


   }
