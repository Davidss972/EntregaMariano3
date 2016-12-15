/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Interfaces;

import Productos.Alquiler;
import java.io.IOException;

/**
 *
 * @author gokud
 */
public interface IAlquilerVista 
{
    Alquiler getAlquilerDetails() throws IOException; 
    String getAlquilerFecha()throws IOException;
    int getAlquilerAction()throws IOException;
    void run()throws IOException;
}
