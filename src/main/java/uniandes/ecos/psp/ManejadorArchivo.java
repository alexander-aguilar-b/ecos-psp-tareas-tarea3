/******************************************************************/
/* Autor: Edgar Alexander Aguilar Bolaños
/* Fecha de Creación: 07/03/2017
/* Propósito: Clase encargada del manejo de archivos
/* Notas especiales:
/******************************************************************/

package uniandes.ecos.psp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


/**
 * Clase encargada del manejo de archivos
 * @author edgaguil
 */
public class ManejadorArchivo
{
    /***
     * Metodo encargado de obtener un listado de numeros reales a partir de un archivo de texto plano
     * @param rutaArchivo
     * @return Listado de numeros reales
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public LinkedList<Float> obtenerDatosArchivo(String rutaArchivo) throws FileNotFoundException, IOException, Exception
    {
        LinkedList<Float> listaDatos = new LinkedList<Float>();

        File f = new File(rutaArchivo);

        if (f.exists() && !f.isDirectory())
        {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            try
            {
                String line = br.readLine();
                while (line != null)
                {
                    listaDatos.add(Float.parseFloat(line));
                    line = br.readLine();
                }
            }
            finally
            {
                br.close();
            }
        }
        else
        {
            throw new Exception("No existe un archivo en la ruta especificada");
        }

        return listaDatos;
    }

    /***
     * Metodo encargado de obtener un listado de parejas de numeros reales a partir de un archivo de texto plano
     * @param rutaArchivo
     * @return Listado de parejas de numeros reales
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public LinkedList<ModeloParejaXY> obtenerListadoParejaDatosArchivo(String rutaArchivo) throws FileNotFoundException, IOException, Exception
    {
        LinkedList<ModeloParejaXY> listaDatos = new LinkedList<ModeloParejaXY>();

        if (rutaArchivo == null || rutaArchivo.isEmpty())
        {
            throw new Exception("Por favor ingrese una ruta de archivo para realizar el calculo");
        }

        File f = new File(rutaArchivo);

        if (f.exists() && !f.isDirectory())
        {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            try
            {
                String line = br.readLine();
                while (line != null)
                {
                    String[] arregloEntradaXY = line.split(";");
                    ModeloParejaXY entradaDatosXY = new ModeloParejaXY();
                    entradaDatosXY.setDatoX(Float.parseFloat((arregloEntradaXY[0])));
                    entradaDatosXY.setDatoY(Float.parseFloat((arregloEntradaXY[1])));
                    listaDatos.add(entradaDatosXY);
                    line = br.readLine();
                }
            }
            finally
            {
                br.close();
            }
        }
        else
        {
            throw new Exception("No existe un archivo en la ruta especificada");
        }

        return listaDatos;
    }


}
