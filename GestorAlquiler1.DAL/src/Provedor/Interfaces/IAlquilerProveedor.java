/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Provedor.Interfaces;

import Productos.Alquiler;

/**
 *
 * @author gokud
 */
public interface IAlquilerProveedor 
{
    void añadirAlquiler(Alquiler newAlquiler);
    void borrarAlquiler(Alquiler deleteAlquiler);
    void modificarAlquiler(Alquiler modifyAlquiler);
    Alquiler conseguirAlquiler(String fecha);
    void mostrarAlquiler();   
}
