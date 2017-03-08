/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniandes.ecos.psp;

/**
 *
 * @author edgaguil
 */
public class PSPProgram3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        try
        {
            ControladorEstadistica controladorEstadistica = new ControladorEstadistica();
            controladorEstadistica.calcularParametrosRegresionCoeficienteCorrelacion();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
