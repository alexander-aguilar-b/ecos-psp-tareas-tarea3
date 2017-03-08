/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniandes.ecos.psp;

import java.util.LinkedList;

/**
 * Clase que representa el modelo de salida de los calculos estadisticos
 * @author edgaguil
 */
public class ModeloCalculoEstadistico
{
    /***
     * Listado de numeros reales sobres los que se efectuo el calculo
     */
    LinkedList<Float> datosEntrada;

    /***
     * Valor calculado de la desviación estandar
     */
    double valorDesviacionEstandar;

    /***
     * Valor calculado de la media
     */
    float valorMedia;

    public LinkedList<Float> getDatosEntrada()
    {
        return datosEntrada;
    }

    public void setDatosEntrada(LinkedList<Float> datosEntrada)
    {
        this.datosEntrada = datosEntrada;
    }

    public double getValorDesviacionEstandar()
    {
        return valorDesviacionEstandar;
    }

    public void setValorDesviacionEstandar(double valorDesviacionEstandar)
    {
        this.valorDesviacionEstandar = valorDesviacionEstandar;
    }

    public float getValorMedia()
    {
        return valorMedia;
    }

    public void setValorMedia(float valorMedia)
    {
        this.valorMedia = valorMedia;
    }
}
