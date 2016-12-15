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

import java.time.LocalDate;

public class Alquiler 
{
    private String dni;
    private String matricula;
    private String fecha;
    private String precio;
    public Alquiler()
    {
        dni = "sin dni";
        matricula = "sin matricula";
        fecha = "sin fecha";
        precio ="sin precio";
    }
    public Alquiler(String alquilerData)
    {
       String[] parts = alquilerData.split(";");
       dni = parts[0];
       matricula = parts[1];
       fecha = parts[2];
       precio = parts[3];
    }
    public void setDni(String dni)
    {
        this.dni = dni;
    }
    public String getDni()
    {
        return dni;
    }
    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }
    public String getMatricula()
    {
        return matricula;
    }

    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }
    
    public String getFecha() 
    {
        return fecha;
    }

    public void setPrecio(String precio) 
    {
        this.precio = precio;
    }
    public String getPrecio() 
    {
        return precio;
    }
    @Override
    public String toString()
    {
        
        return dni+";"+matricula+";"+fecha+";"+precio;
    }
    public LocalDate mostrarFecha()
    {
        LocalDate fechaactual = LocalDate.now();
        return fechaactual;
    }
}   
