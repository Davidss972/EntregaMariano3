/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Interfaces;

import Productos.Cliente;
import java.io.IOException;

/**
 *
 * @author gokud
 */
public interface IClienteVista 
{
    Cliente getClienteDetails() throws IOException; 
    String getClienteDni()throws IOException;
    int getClienteAction()throws IOException;
    void run()throws IOException;
}
