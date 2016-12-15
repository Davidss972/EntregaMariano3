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
import Presentadores.Interfaces.IAlquilerPresentador;
import Productos.Alquiler;
import Productos.Cliente;
import Provedor.Interfaces.IAlquilerProveedor;
import Provedor.Interfaces.IClienteProveedor;
import Provedor.Interfaces.ICocheProveedor;
import colores.ColorTexto;

/**
 *
 * @author gokud
 */
public class AlquilerPresentador implements IAlquilerPresentador
{
    private IAlquilerProveedor alquilerProveedor;
    private IClienteProveedor clienteProveedor;
    private ICocheProveedor cocheProveedor;
    public AlquilerPresentador(IAlquilerProveedor alquilerp,IClienteProveedor clientep,ICocheProveedor cochep)
    {
        alquilerProveedor = alquilerp;
        clienteProveedor = clientep;
        cocheProveedor = cochep;
    }
    
    
    public boolean añadirAlquiler(Alquiler newAlquiler)
    {
        Alquiler AlquilerAAñadir = alquilerProveedor.conseguirAlquiler(newAlquiler.getFecha());
        if(AlquilerAAñadir == null)
        {
            alquilerProveedor.añadirAlquiler(newAlquiler);
            ColorTexto.println(ColorTexto.ANSI_RED,"El alquiler ha sido creado");
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean borrarAlquiler(String fecha)
    {
        Alquiler AlquilerABorrar = alquilerProveedor.conseguirAlquiler(fecha);
        if(AlquilerABorrar != null)
        {
            alquilerProveedor.borrarAlquiler(AlquilerABorrar);
            ColorTexto.println(ColorTexto.ANSI_RED,"El alquiler ha sido borrado");
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean modificarAlquiler(Alquiler modifyAlquiler) 
    {
        Alquiler AlquilerAModificar = alquilerProveedor.conseguirAlquiler(modifyAlquiler.getFecha());
            
        if (AlquilerAModificar != null )
        {
            alquilerProveedor.modificarAlquiler(modifyAlquiler);
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
