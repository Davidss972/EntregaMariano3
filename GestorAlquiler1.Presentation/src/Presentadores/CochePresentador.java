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

import Presentadores.Interfaces.ICochePresentador;
import Productos.Coche;
import Provedor.Interfaces.ICocheProveedor;
import colores.ColorTexto;

/**
 *
 * @author gokud
 */
public class CochePresentador implements ICochePresentador
{
    private ICocheProveedor cocheProvider;
    
    
    public CochePresentador(ICocheProveedor Cochep)
        {
            cocheProvider = Cochep;
        } 
    
    
    public boolean añadirCoche(Coche newCoche)
        {
            Coche CocheAAñadir = cocheProvider.conseguirCoche(newCoche.getMatricula());
            
            if (CocheAAñadir == null )
                {
                    cocheProvider.añadirCoche(newCoche);
                    ColorTexto.println(ColorTexto.ANSI_RED,"El coche ha sido creado");
                    return true;
                }
            else
                {
                    return false;
                }
            
        }
    public boolean borrarCoche(String matricula)
    {
            Coche CocheABorrar = cocheProvider.conseguirCoche(matricula);
            
        if (CocheABorrar != null )
            {
                cocheProvider.borrarCoche(CocheABorrar);
                ColorTexto.println(ColorTexto.ANSI_RED,"El coche ha sido borrado");
                return true;
            }
        else
            {
                return false;
            }
            
    }
    public boolean modificarCoche(Coche modifyCoche)
        {
            Coche CocheAModificar = cocheProvider.conseguirCoche(modifyCoche.getMatricula());
            
            if (CocheAModificar == null )
                {
                    cocheProvider.modificarCoche(modifyCoche);
                    return true;
                }
            else
                {
                    return false;
                }
            
        }
}
