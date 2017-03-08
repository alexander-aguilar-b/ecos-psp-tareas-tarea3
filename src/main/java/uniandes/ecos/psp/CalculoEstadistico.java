/******************************************************************/
/* Autor: Edgar Alexander Aguilar Bolaños
/* Fecha de Creación: 07/03/2017
/* Propósito: Clase encargada de realizar calculos estadisticos
/* Notas especiales:
/******************************************************************/
package uniandes.ecos.psp;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase encargada de realizar calculos estadisticos
 * @author edgaguil
 */
public class CalculoEstadistico
{
    /***
     * Metodo que realiza el calculo de la media a partir del listado de datos de entrada
     * @param listadoDatos Listado de numeros enteros
     * @return Valor de la media del listado de numeros ingresados
     */
    public static float calcularMedia(LinkedList<Float> listadoDatos)
    {
        float sumatoria = 0;
        float media = 0;

        for(float numero : listadoDatos)
        {
            sumatoria += numero;
        }

        if (listadoDatos.size() > 0) {
            media = sumatoria / listadoDatos.size();
        }

        return media;
    }

    /**
     * Metodo que realiza el calculo de la desviación estandar a partir del listado de datos de entrada
     * @param listadoDatos Listado de numeros enteros
     * @return Valor de la desviacion estandar del listado de numeros ingresados
     */
    public static double calcularDesviacionEstandar(LinkedList<Float> listadoDatos)
    {
        double desviacionEstandar = 0;
        float media = calcularMedia(listadoDatos);
        float sumatoria = 0;


        if (listadoDatos.size() > 0)
        {
            for(float numero : listadoDatos)
            {
                sumatoria += Math.pow(numero - media, 2);
            }
            desviacionEstandar = Math.sqrt(sumatoria / (listadoDatos.size() - 1));
        }

        return desviacionEstandar;
    }


    /**
     * Metodo que realiza el calcuo de la sumatoria sobre un listado de datos
     * @param listaDatos Listado de numeros reales
     * @return Valor de la sumatoria
     */
    public static float calcularSumatoria(LinkedList<Float> listaDatos)
    {
        float totalSumatoria = 0;

        if (listaDatos != null)
        {
            for (float numero: listaDatos)
            {
                totalSumatoria += numero;
            }
        }

        return totalSumatoria;
    }

    /**
     * Metodo que realiza el calcuo de la sumatoria del producto de una lista de parejas de datos
     * @param listadoParejaDatos Listado de parejas de  numeros reales
     * @return Valor de la sumatoria
     */
    public  static float calcularSumatoriaProductoParejaDatos(List<ModeloParejaXY> listadoParejaDatos)
    {
        float totalSumatoria = 0;

        if (listadoParejaDatos != null)
        {
            for (ModeloParejaXY parejaDatos: listadoParejaDatos)
            {
                totalSumatoria += parejaDatos.getDatoX() * parejaDatos.getDatoY();
            }
        }

        return totalSumatoria;
    }


    /**
     * Metodo que realiza el calcuo de la sumatoria del cuadrado de una lista de numeros reales
     * @param listaDatos Listado de numeros reales
     * @return Valor de la sumatoria
     */
    public static float calcularSumatoriaCuadrado(LinkedList<Float> listaDatos)
    {
        float totalSumatoria = 0;

        if (listaDatos != null)
        {
            for (float numero: listaDatos)
            {
                totalSumatoria += numero * numero;
            }
        }

        return totalSumatoria;
    }

    /**
     * Metodo que realiza el calculo de los parametros de regresion y los coeficientes de regresion
     * @param modeloRegresion Modelo que contiene el listado de datos y un punto estimado
     * @return Modelo que contiene los parametros de regresion y los coeficientes de regresion
     */
    public static ModeloRegresion calcularValoresRegresion(ModeloRegresion modeloRegresion)
    {
        if (modeloRegresion != null)
        {
            LinkedList<ModeloParejaXY> listadoParejaDatos = modeloRegresion.getDatosEntrada();

        if (listadoParejaDatos != null)
        {
            LinkedList<Float> listadoDatosX = new LinkedList<Float>();
            LinkedList<Float> listadoDatosY = new LinkedList<Float>();

            for (ModeloParejaXY parejaDatoXY: listadoParejaDatos)
            {
                listadoDatosX.add(parejaDatoXY.getDatoX());
                listadoDatosY.add(parejaDatoXY.getDatoY());
            }

            int numeroDatos = listadoParejaDatos.size();
            float mediaX = calcularMedia(listadoDatosX);
            float mediaY = calcularMedia(listadoDatosY);

            float sumatoriaProductoXY =calcularSumatoriaProductoParejaDatos(listadoParejaDatos);
            float sumatoriaX = calcularSumatoria(listadoDatosX);
            float sumatoriaY = calcularSumatoria(listadoDatosY);
            float sumatoriaCuadradoX = calcularSumatoriaCuadrado(listadoDatosX);
            float sumatoriaCuadradoY = calcularSumatoriaCuadrado(listadoDatosY);

            double denominadorB1 = (sumatoriaCuadradoX - (numeroDatos*Math.pow(mediaX,2)));

            double parametroB1 = denominadorB1 != 0 ?  ((sumatoriaProductoXY - (numeroDatos*mediaX*mediaY)) / denominadorB1) : 0;

            double denominadorCoeficienteRegresionRxy = (Math.sqrt(( (numeroDatos* sumatoriaCuadradoX) - Math.pow(sumatoriaX, 2)) * ((numeroDatos* sumatoriaCuadradoY) - Math.pow(sumatoriaY, 2)) ) );

            double coeficienteRegresionRxy = denominadorCoeficienteRegresionRxy != 0 ?  (((numeroDatos* sumatoriaProductoXY) - (sumatoriaX*sumatoriaY)) / denominadorCoeficienteRegresionRxy) : 0;

            double coeficienteRegresionR2 = Math.pow(coeficienteRegresionRxy, 2);

            double parametroB0 = mediaY - (parametroB1*mediaX);

            double prediccionYk = parametroB0 + (parametroB1* modeloRegresion.getValorEstimadoXk());

            modeloRegresion.setCoeficienteRegresionRxy(coeficienteRegresionRxy);
            modeloRegresion.setCoeficienteRegresionR2(coeficienteRegresionR2);
            modeloRegresion.setParametroRegresionB0(parametroB0);
            modeloRegresion.setParametroRegresionB1(parametroB1);
            modeloRegresion.setPrediccionYk(prediccionYk);
        }
        }

        return modeloRegresion;
    }
}

