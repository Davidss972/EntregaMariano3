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

public class Coche 
{
    String matricula;
    String marca;
    String modelo;
    
    /*@Override
    public boolean equals(Object objeto)
    {
        Coche coche = (Coche) objeto;
        return this.matricula.equals(coche.matricula);
    }*/
    
    public Coche()
    {
        matricula = "sin matricula";
        marca = "sin marca";
        modelo = "sin modelo";
    }
    public Coche(String cocheData)
    {
       String[] parts = cocheData.split(";");
       matricula = parts[0];
       marca = parts[1];
       modelo = parts[2];
    }
    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }
    public String getMatricula()
    {
        return matricula;
    }
    public void setMarca(String marca)
    {
        this.marca = marca;
    }
    public String getMarca()
    {
        return marca;
    }
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }
    public String getModelo()
    {
        return modelo;
    }
    @Override
    public String toString()
    {
        return matricula + ";" + marca + ";" + modelo;
    }
    
}
