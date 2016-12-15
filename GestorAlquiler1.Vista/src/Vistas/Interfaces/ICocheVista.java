/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Interfaces;

import Productos.Coche;
import java.io.IOException;

/**
 *
 * @author gokud
 */
public interface ICocheVista 
{
    Coche getCocheDetails() throws IOException; 
    String getCocheMatricula()throws IOException;
    int getCocheAction()throws IOException;
    void run()throws IOException;  
}
