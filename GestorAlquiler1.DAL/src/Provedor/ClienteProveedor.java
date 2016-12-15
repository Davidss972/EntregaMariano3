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

import Productos.Cliente;
import Provedor.Interfaces.IClienteProveedor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteProveedor implements IClienteProveedor
{
    String nombreArchivo ="libretaContactos.csv";
    ArrayList<Cliente> listaclientes = new ArrayList<>();
    public ClienteProveedor()
    {
        listaclientes = cargarClientesDesdeArchivo();
    }
    
    public ArrayList<Cliente> cargarClientesDesdeArchivo()
    {
        ArrayList<Cliente> listaclientes1 = new ArrayList<>();
        try
        {
            Scanner sc = new Scanner(new File(this.nombreArchivo)).useDelimiter("\n");
                sc.next();
            while(sc.hasNext())
            {
                Cliente cliente = new Cliente(sc.next());
                listaclientes1.add(cliente);
            }
        }
        catch(FileNotFoundException ex)
        {
            Logger.getLogger(ClienteProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaclientes1;
    }
    private void volcarClientes() //antes de volcar manera de borrar todo lo que haya dentro/*porque lo que cargamos es la lista.*/
    {
        try {
                FileWriter fw = new FileWriter(new File(this.nombreArchivo));
                    fw.write("DNI;NOMBRE;APELLIDOS\n");
                for (Cliente cliente : listaclientes) 
                { 
                    
                    fw.write(cliente.toString()+"\n");
                }
                fw.close();
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(ClienteProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void mostrarClientes()
    {
        for (Cliente cliente : listaclientes)
        {
            System.out.println(cliente);
        }
    }

    public Cliente conseguirCliente(String dni)
    {
        String clientdni = "";
            
        for (Cliente cliente : listaclientes) 
        {
            clientdni = cliente.getDni();
            if(clientdni != null)
            {
                if(clientdni == null ? dni == null : clientdni.equals(dni))
                {
                    return cliente;
                }  
            }
        }
        return null;    
    }
    
    public void añadirCliente (Cliente newCliente)
        {
           listaclientes.add(newCliente);
           volcarClientes();
        }
    public void borrarCliente(Cliente deleteCliente)
        {
           listaclientes.remove(deleteCliente);
           volcarClientes();
        }
    public void modificarCliente(Cliente modifyCliente)//llamar a getclient y modificar diretamente
        {
            
           Cliente cliente = conseguirCliente(modifyCliente.getDni());
           borrarCliente(cliente);
           añadirCliente(modifyCliente);
        }
    
}
