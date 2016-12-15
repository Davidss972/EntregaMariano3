/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Provedor.Interfaces;

import Productos.Coche;

/**
 *
 * @author gokud
 */
public interface ICocheProveedor 
{
    void añadirCoche(Coche newCliente);
    void borrarCoche(Coche deleteCliente);
    void modificarCoche(Coche modifyCliente);
    Coche conseguirCoche(String matricula);
    void mostrarCoches();
}
