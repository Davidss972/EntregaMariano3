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
package colores;

import colores.Interfaces.IColorTexto;



public class ColorTexto /*implements IColorTexto*/
{
   public static final String ANSI_RESET = "\u001B[0m";

   public static final String ANSI_BLACK = "\u001B[30m";

   public static final String ANSI_RED = "\u001B[31m";

   public static final String ANSI_GREEN = "\u001B[32m";

   public static final String ANSI_YELLOW = "\u001B[33m";

   public static final String ANSI_BLUE = "\u001B[34m";
  
   public static final String ANSI_PURPLE = "\u001B[35m";

   public static final String ANSI_CYAN = "\u001B[36m";

   public static final String ANSI_WHITE = "\u001B[37m";

   public static void print(String color, String txt){
     System.out.print(color+txt);
   }

   public static void println(String color, String txt){
     System.out.println(color+txt);
   }

   public static String getStringInColor(String color, String txt){
     return color+txt;
   }
  /* public void printearPorConsola()
   {
   
   }*/

}


