package curso.edu.eddgooglecalendar_201503422_201404200;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

/**
 *
 * @author Dénilson Argueta
 */
public class Server {

    public Server()
    {
    }
    public static String ExisteUser(String nombre,String contrasena)
    {

        String texto=nombre+","+contrasena;
        String r = getString("EXISTEUSUARIO", texto);
        return r;
    }
    public static String AUMENTARFONDOS(String nombre,String fondos)
    {

        String texto=nombre+","+fondos;
        String r = getString("AUMENTARFONDOS", texto);
        return r;
    }
    public static String DISMINUIRFONDOS(String nombre,String fondos)
    {

        String texto=nombre+","+fondos;
        String r = getString("DISMINUIRFONDOS", texto);
        return r;
    }
    public static String ESTADOCUENTA(String nit)
    {

        String texto=nit;
        String r = getString("ESTADOCUENTA", texto);
        return r;
    }
    public static String REPORTEANDROID(String nit)
    {

        String texto=nit;
        String r = getString("REPORTEANDROID", texto);
        return r;
    }
    public static String CATEGORIAS()
    {
        String r = getString("CATEGORIAS");
        return r;
    }
    public static String PRODUCTOS(String categoria)
    {
        String texto=categoria.replace(" ","_");
        String r = getString("PRODUCTOS",texto);
        return r;
    }
    public static String PRECIOPRODUCTO(String nombre)
    {
        String texto=nombre.replace(" ","_");
        String r = getString("PRECIOPRODUCTO",texto);
        return r;
    }
    public static String IDPRODUCTO(String nombre)
    {
        String texto=nombre.replace(" ","_");
        String r = getString("IDPRODUCTO",texto);
        return r;
    }
    public static String CREARFACTURA(String nombre)
    {
        String r = getString("CREARFACTURA",nombre);
        return r;
    }


    public static String getString(String metodo, String texto) {

        try {
            URL url = new URL("http://192.168.43.145:5000/" + metodo+"/"+texto+"/");
            //URL url = new URL("http://192.168.0.20:5000/" + metodo+"/"+texto+"/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuffer sb = new StringBuffer();

            String line;

            while((line = in.readLine())!=null){

                sb.append(line);

            }

            in.close();
            return sb.toString();

        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static String getString(String metodo) {

        try {

            URL url = new URL("http://192.168.43.145:5000/" + metodo);
            //URL url = new URL("http://192.168.0.20:5000/" + metodo);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuffer sb = new StringBuffer();

            String line;

            while((line = in.readLine())!=null){

                sb.append(line);

            }

            in.close();
            return sb.toString();

        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}