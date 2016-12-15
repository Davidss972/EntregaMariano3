/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentadores.Interfaces;

import Productos.Alquiler;
import Productos.Cliente;

/**
 *
 * @author gokud
 */
public interface IAlquilerPresentador 
{
    boolean añadirAlquiler(Alquiler newCliente);
    boolean borrarAlquiler(String fecha);
    boolean modificarAlquiler(Alquiler modifyCliente);  
    Cliente buscarCliente(String Dni);
}
