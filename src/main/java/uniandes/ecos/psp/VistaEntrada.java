/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniandes.ecos.psp;

/**
 * Clase encargada de solicitar los datos de entrada
 * @author edgaguil
 */
public class VistaEntrada
{

    /***
     * Metod encargado de capturar la ruta del archivo que contiene el listado de numeros reales
     * @return
     */
    public String solicitarRutaArchivo()
    {
        System.out.println("Programa para el Calculo de parametros de regresion y coeficientes de regresion - PSP3");
        System.out.println("********************************************************************************************************************************************************************************************************************************");
        System.out.println("Estimado usuario, por favor ingrese la ruta del archivo que contiene el listado de parejas de numeros reales (separados por punto y coma) sobre los cuales se van a calcular los parametros de regresion y los coeficientes de correlacion.");
        System.out.println();
        System.out.println("Ruta:");
        String rutaArchivo = System.console().readLine();
        //String rutaArchivo = "C:\\Users\\edgaguil\\Dropbox\\Alex\\ECOS\\Conceptos Avanzados de SW\\Tareas\\Tarea3\\Datos_Test4.txt";
        return rutaArchivo;
    }


}
