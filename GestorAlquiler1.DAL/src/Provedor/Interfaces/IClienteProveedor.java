/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Provedor.Interfaces;

import Productos.Cliente;

/**
 *
 * @author gokud
 */
public interface IClienteProveedor 
{
    void añadirCliente(Cliente newCliente);
    void borrarCliente(Cliente deleteCliente);
    void modificarCliente(Cliente modifyCliente);
    Cliente conseguirCliente(String dni);
    void mostrarClientes();
}
