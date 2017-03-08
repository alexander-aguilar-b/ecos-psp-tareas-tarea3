package uniandes.ecos.psp;

/**
 * Clase que contiene la estructura de una pareja de datos X, Y
 * Created by edgaguil on 8/03/2017.
 */
public class ModeloParejaXY
{
    /**
     * Constructor de la clase
     * @param datoX Dato X
     * @param datoY Dato Y
     */
    public ModeloParejaXY(float datoX, float datoY)
    {
        setDatoX(datoX);
        setDatoY(datoY);
    }

    public ModeloParejaXY()
    {
    }

    //Dato X
    private float datoX;

    //Dato Y
    private float datoY;

    public float getDatoX()
    {
        return datoX;
    }

    public void setDatoX(float datoX)
    {
        this.datoX = datoX;
    }

    public float getDatoY()
    {
        return datoY;
    }

    public void setDatoY(float datoY)
    {
        this.datoY = datoY;
    }
}
