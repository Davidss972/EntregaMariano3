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
package Presentadores;

import Presentadores.Interfaces.IClientePresentador;
import Productos.Cliente;
import Provedor.Interfaces.IClienteProveedor;
import colores.ColorTexto;
import colores.Interfaces.IColorTexto;

/**
 *
 * @author gokud
 */
public class ClientePresentador implements IClientePresentador
{
    private IClienteProveedor clienteProveedor;
    private IColorTexto colorcitotexto;
       
    public ClientePresentador(IClienteProveedor Clientep)
    {
        clienteProveedor = Clientep;
    } 
        
    public boolean añadirCliente(Cliente newCliente)
    {
        Cliente ClienteAAñadir = clienteProveedor.conseguirCliente(newCliente.getDni());
            
        if (ClienteAAñadir == null )
        {
            clienteProveedor.añadirCliente(newCliente);
            ColorTexto.println(ColorTexto.ANSI_RED,"El cliente ha sido creado");
            return true;
        }
        else
        {   
            return false;
        }
            
    }

    
    public boolean borrarCliente(String dni) 
    {
        Cliente ClienteABorrar = clienteProveedor.conseguirCliente(dni);

        if (ClienteABorrar != null )
        {
            clienteProveedor.borrarCliente(ClienteABorrar);
            ColorTexto.println(ColorTexto.ANSI_RED,"El cliente ha sido borrado");
            return true;
        }
        else
        {
            return false;
        }

          
    }

    
    
    @Override
    public boolean modificarCliente(Cliente modifyCliente) 
    {
        Cliente ClienteAModificar = clienteProveedor.conseguirCliente(modifyCliente.getDni());

        if (ClienteAModificar != null )
        {
            clienteProveedor.modificarCliente(modifyCliente);
            return true;
        }
        else
        {
            return false;  
        }
    }  
    
    public Cliente buscarCliente(String Dni)
    {
        return clienteProveedor.conseguirCliente(Dni);
    }
}

