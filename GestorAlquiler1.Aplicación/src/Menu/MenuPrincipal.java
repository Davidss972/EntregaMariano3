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
package Menu;

import Presentadores.AlquilerPresentador;
import Presentadores.ClientePresentador;
import Presentadores.CochePresentador;
import Presentadores.Interfaces.IAlquilerPresentador;
import Presentadores.Interfaces.IClientePresentador;
import Presentadores.Interfaces.ICochePresentador;
import Provedor.AlquilerProveedor;
import Provedor.ClienteProveedor;
import Provedor.CocheProveedor;
import Provedor.Interfaces.IAlquilerProveedor;
import Provedor.Interfaces.IClienteProveedor;
import Provedor.Interfaces.ICocheProveedor;
import Vistas.AlquilerVista;
import Vistas.ClienteVista;
import Vistas.CocheVista;
import Vistas.Interfaces.IAlquilerVista;
import Vistas.Interfaces.IClienteVista;
import Vistas.Interfaces.ICocheVista;
import colores.ColorTexto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gokud
 */
public class MenuPrincipal 
{
    public void ejecutar() throws IOException
    {
        BufferedReader console;
        console = new BufferedReader(new InputStreamReader(System.in));
        console.readLine();
        int op;
        String menu=";";
        do{
            menu="";
            menu+="****** Menú ******\n";
            menu+="1.- Añadir Clientes \n";
            menu+="2.- Añadir Coches \n";
            menu+="3.- Añadir Alquileres \n";
            //menu+="4.- Consultar Alquileres\n";
            menu+="4.- Salir \n";
            
            ColorTexto.println(ColorTexto.ANSI_YELLOW,menu);
            op = 0;
            try{
            op=Integer.parseInt(console.readLine());//hacer un try catch para capturar la excepcion de poner enter
            }
            
            catch(Exception ex)
            {
                ColorTexto.println(ColorTexto.ANSI_RED,"introduzca una opcion");
                continue;
            }
            IAlquilerProveedor alquilerproveedor = new AlquilerProveedor();
            ICocheProveedor cocheproveedor = new CocheProveedor();
            IClienteProveedor clienteproveedor = new ClienteProveedor();
            switch(op)
            {
                case 1:
                    
                    IClientePresentador clientepresentador = new ClientePresentador(clienteproveedor);
                    IClienteVista clientsview =  new ClienteVista(clientepresentador);
                    clientsview.run();
                   
                    break;
                case 2:
                    
                    ICochePresentador cochepresentador = new CochePresentador(cocheproveedor);
                    ICocheVista cochevista = new CocheVista(cochepresentador);
                    cochevista.run();
                    break;  
                case 3 :

                    IAlquilerPresentador alquilerpresentador = new AlquilerPresentador(alquilerproveedor,clienteproveedor,cocheproveedor);
                    IAlquilerVista alquilervista = new AlquilerVista(alquilerpresentador);
                    alquilervista.run();
                    break;
                //case 4 :
                    
                case 4:
                    System.exit(0);
                    break;
                default :
                    ColorTexto.println(ColorTexto.ANSI_BLUE,"introduzca una opcion de la lista");
                    break;
                        
            }
        }while(op!=4);
    }
}
