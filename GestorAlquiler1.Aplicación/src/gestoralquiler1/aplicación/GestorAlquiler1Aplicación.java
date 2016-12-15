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
package gestoralquiler1.aplicación;

import Menu.MenuPrincipal;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GestorAlquiler1Aplicación 
{

    public static void main(String[] args) throws IOException 
    {
        MenuPrincipal menu = new MenuPrincipal();
        menu.ejecutar();
    }
    
}
