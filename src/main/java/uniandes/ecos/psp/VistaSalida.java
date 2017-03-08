/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniandes.ecos.psp;

/**
 * Clase encargada de mostrar los resultados de los calculos
 * @author edgaguil
 */
public class VistaSalida
{
    /***
     * Metodo encargado de mostrar la informacion empleada para realizar el calculo, asi como los valores calculados
     * @param modeloCalculoEstadistico
     */
    public void mostrarResultado(ModeloCalculoEstadistico modeloCalculoEstadistico)
    {
        System.out.println("Datos de Entrada:");

        for (Float item : modeloCalculoEstadistico.getDatosEntrada())
        {
            System.out.println((float)item);
        }

        System.out.println("Media:" + modeloCalculoEstadistico.getValorMedia());
        System.out.println("Desviación Estandar:" + modeloCalculoEstadistico.getValorDesviacionEstandar());
    }

    /**
     * Metodo encargado de mostrar la informacion empleada para realizar el calculo, asi como los valores calculados
     * @param modeloRegresion Modelo que contiene los valores caculados y las entradas empleadas
     */
    public void mostrarResultadoCalculoParametrosRegresionCoeficienteCorrelacion(ModeloRegresion modeloRegresion)
    {
        if (modeloRegresion != null)
        {
            System.out.println();
            System.out.println("*********************RESULTADOS****************************************************************");
            System.out.println("Datos de Entrada:");
            for (ModeloParejaXY item : modeloRegresion.getDatosEntrada())
            {
                System.out.println(item.getDatoX() +  " " + item.getDatoY());
            }
            System.out.println();

            System.out.println("Valores estimado:");
            System.out.println("Xk : " + modeloRegresion.getValorEstimadoXk());
            System.out.println("Valores calculados:");
            System.out.println("B0 : " + modeloRegresion.getParametroRegresionB0());
            System.out.println("B1 : " + modeloRegresion.getParametroRegresionB1());
            System.out.println("rxy : " + modeloRegresion.getCoeficienteRegresionRxy());
            System.out.println("r2 : " + modeloRegresion.getCoeficienteRegresionR2());
            System.out.println("yk : " + modeloRegresion.getPrediccionYk());
            }
    }
}
