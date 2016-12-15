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
package Productos;

public class Cliente 
{
    String dni;
    String nombre;
    String apellidos;

    public Cliente()
    {
        nombre = "sin nombre";
        apellidos = "sin apellidos";
        dni = "sin dni"; 
    }
    // Recibe String Formato Dni;Nombre;Apellidos
    public Cliente(String clienteData)
    {
       String[] parts = clienteData.split(";");
       dni = parts[0];
       nombre = parts[1];
       apellidos = parts[2];
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setDni(String dni)
    {
        this.dni = dni;
    }
    public String getDni()
    {
        return dni;
    }
    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }
    public String getApellidos()
    {
        return apellidos;
    }
    @Override
    public String toString()
    {
        return dni+";"+nombre+";"+apellidos;
    }
}