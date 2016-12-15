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


import Presentadores.Interfaces.IClientePresentador;
import Productos.Cliente;
import Provedor.ClienteProveedor;
import Provedor.Interfaces.IClienteProveedor;
import Vistas.Interfaces.IClienteVista;
import colores.ColorTexto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gokud
 */
public class ClienteVista implements IClienteVista
{
    BufferedReader console;
    IClientePresentador clientePresenter;
    IClienteProveedor clienteProvider;
    ClienteProveedor mostrar = new ClienteProveedor();
    
    public ClienteVista(IClientePresentador diseño)
    {
    clientePresenter = diseño;
    console = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public Cliente getClienteDetails() throws IOException//detalles para cuando te hayas metido en cliente.
    {
        Cliente newCLiente = new Cliente();
        String continuamos;
        do{
            newCLiente.setDni(getClienteDni());
            ColorTexto.println(ColorTexto.ANSI_CYAN,"introduce el Nombre");
            newCLiente.setNombre(console.readLine());
            ColorTexto.println(ColorTexto.ANSI_CYAN,"introduce los appelidos");
            newCLiente.setApellidos(console.readLine()); 
            ColorTexto.println(ColorTexto.ANSI_GREEN,"¿Deseea introducir un nuevo cliente(S/N)?");
            continuamos = console.readLine();
            return newCLiente;
           } while (continuamos.startsWith("s") || continuamos.startsWith("S"));    
    }
    public String getClienteDni() throws IOException//pedir dni
    {
        ColorTexto.println(ColorTexto.ANSI_CYAN,"Introduzca el DNI: ");
    
        return console.readLine();
    }
    public int getClienteAction() throws IOException//switch 
    {
        
        console.readLine();
        
        int op;
        String menu="";
        Cliente cliente;
            menu="";
            menu+="****** Menú ******\n";
            menu+="1.- Añadir Cliente \n";
            menu+="2.- Borrar Cliente \n";
            menu+="3.- Modificar Cliente \n";
            //menu+="4.- Buscar Cliente \n";
            menu+="4.- Mostrar Clientes \n";
            menu+="5.- Salir \n";
            
            ColorTexto.println(ColorTexto.ANSI_PURPLE,menu);
            op=Integer.parseInt(console.readLine());
            
            switch(op)
            {
                case 1:
                cliente = getClienteDetails();
                clientePresenter.añadirCliente(cliente);
                if(clientePresenter.añadirCliente(cliente) == false)
                {
                    
                } 
                    break;
                case 2:
                
                if(clientePresenter.borrarCliente(getClienteDni()) == false)
                {
                    ColorTexto.println(ColorTexto.ANSI_RED,"El cliente no existe");
                }
                    
                    break;  
                case 3:
                    cliente = getClienteDetails();
                    clientePresenter.modificarCliente(cliente);
                    if(clientePresenter.modificarCliente(cliente) == false)
                    {
                        ColorTexto.println(ColorTexto.ANSI_RED,"El cliente ha sido modificado");
                    }
                    break;
               
                case 4:
                    mostrar.mostrarClientes();
                    break;
                case 5:
                    break;
                 
            }
            return op;
        
    }
    public void run() throws IOException//while bucle
    { 
        while(getClienteAction() != 5)
        {
        
        }
        
    }
    private Cliente buscarcliente(String Dni) 
    {
        return clientePresenter.buscarCliente(Dni);
    }

}
