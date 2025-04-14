/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebad;


import javax.media.j3d.TransparencyAttributes;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;

public class Salon extends Group {
    
    // Dimensiones del salón
    private static final float ANCHO = 5.0f;
    private static final float LARGO = 7.0f;
    private static final float ALTO = 3.0f;
    private static final float GROSOR_PARED = 0.2f;
    
    // Colores
    private static final Color3f COLOR_PARED = new Color3f(0.9f, 0.9f, 0.8f);
    private static final Color3f COLOR_PUERTA = new Color3f(0.5f, 0.35f, 0.05f);
    private static final Color3f COLOR_VENTANA = new Color3f(0.7f, 0.8f, 1.0f);
    
    public Salon() {
        // Crear las 4 paredes
        crearParedFrontal();
        crearParedTrasera();
        crearParedIzquierda(); // Con puerta
        crearParedDerecha();    // Con ventanas
        
        // Opcional: agregar piso y techo
        crearPiso();
        crearTecho();
    }
    
    private void crearParedFrontal() {
        // Pared frontal simple (sin aberturas)
        Box paredFrontal = new Box(ANCHO/2, ALTO/2, GROSOR_PARED/2, 
                                 Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 
                                 crearApariencia(COLOR_PARED));
        
        // Posicionar la pared frontal
        Transform3D tfFrontal = new Transform3D();
        tfFrontal.setTranslation(new Vector3f(0.0f, ALTO/2, LARGO/2 - GROSOR_PARED/2));
        TransformGroup tgFrontal = new TransformGroup(tfFrontal);
        tgFrontal.addChild(paredFrontal);
        this.addChild(tgFrontal);
    }
    
    private void crearParedTrasera() {
        // Pared trasera simple (sin aberturas)
        Box paredTrasera = new Box(ANCHO/2, ALTO/2, GROSOR_PARED/2, 
                                  Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 
                                  crearApariencia(COLOR_PARED));
        
        // Posicionar la pared trasera
        Transform3D tfTrasera = new Transform3D();
        tfTrasera.setTranslation(new Vector3f(0.0f, ALTO/2, -LARGO/2 + GROSOR_PARED/2));
        TransformGroup tgTrasera = new TransformGroup(tfTrasera);
        tgTrasera.addChild(paredTrasera);
        this.addChild(tgTrasera);
    }
    
    private void crearParedIzquierda() {
        // Pared izquierda con puerta
        
        // Primero creamos la pared completa
        Box paredIzquierda = new Box(GROSOR_PARED/2, ALTO/2, LARGO/2, 
                                   Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 
                                   crearApariencia(COLOR_PARED));
        
        // Dimensiones de la puerta
        float altoPuerta = ALTO * 0.6f;
        float anchoPuerta = ANCHO * 0.25f;
        
        // Crear la puerta
        Box puerta = new Box(anchoPuerta/2, altoPuerta/2, GROSOR_PARED/2, 
                           Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 
                           crearApariencia(COLOR_PUERTA));
        
        // Posicionar la puerta (parte inferior izquierda)
        Transform3D tfPuerta = new Transform3D();
        tfPuerta.setTranslation(new Vector3f(-ANCHO/2 + GROSOR_PARED/2, altoPuerta/2, -LARGO/2 + anchoPuerta/2));
        TransformGroup tgPuerta = new TransformGroup(tfPuerta);
        tgPuerta.addChild(puerta);
        
        // Crear un grupo para combinar pared y puerta
        Group paredConPuerta = new Group();
        paredConPuerta.addChild(paredIzquierda);
        paredConPuerta.addChild(tgPuerta);
        
        // Posicionar todo el conjunto de la pared izquierda
        Transform3D tfParedIzq = new Transform3D();
        tfParedIzq.setTranslation(new Vector3f(-ANCHO/2 + GROSOR_PARED/2, ALTO/2, 0.0f));
        TransformGroup tgParedIzq = new TransformGroup(tfParedIzq);
        tgParedIzq.addChild(paredConPuerta);
        
        this.addChild(tgParedIzq);
    }
    
    private void crearParedDerecha() {
        // Pared derecha con 2 ventanas
        
        // Primero creamos la pared completa
        Box paredDerecha = new Box(GROSOR_PARED/2, ALTO/2, LARGO/2, 
                                 Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 
                                 crearApariencia(COLOR_PARED));
        
        // Dimensiones de las ventanas
        float altoVentana = ALTO * 0.4f;
        float anchoVentana = LARGO * 0.2f;
        
        // Crear las ventanas
        Box ventana1 = new Box(anchoVentana/2, altoVentana/2, GROSOR_PARED/2, 
                             Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 
                             crearAparienciaVentana());
        
        Box ventana2 = new Box(anchoVentana/2, altoVentana/2, GROSOR_PARED/2, 
                             Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 
                             crearAparienciaVentana());
        
        // Posicionar las ventanas
        Transform3D tfVentana1 = new Transform3D();
        tfVentana1.setTranslation(new Vector3f(ANCHO/2 - GROSOR_PARED/2, ALTO * 0.6f, LARGO * 0.2f));
        TransformGroup tgVentana1 = new TransformGroup(tfVentana1);
        tgVentana1.addChild(ventana1);
        
        Transform3D tfVentana2 = new Transform3D();
        tfVentana2.setTranslation(new Vector3f(ANCHO/2 - GROSOR_PARED/2, ALTO * 0.6f, -LARGO * 0.2f));
        TransformGroup tgVentana2 = new TransformGroup(tfVentana2);
        tgVentana2.addChild(ventana2);
        
        // Crear un grupo para combinar pared y ventanas
        Group paredConVentanas = new Group();
        paredConVentanas.addChild(paredDerecha);
        paredConVentanas.addChild(tgVentana1);
        paredConVentanas.addChild(tgVentana2);
        
        // Posicionar todo el conjunto de la pared derecha
        Transform3D tfParedDer = new Transform3D();
        tfParedDer.setTranslation(new Vector3f(ANCHO/2 - GROSOR_PARED/2, ALTO/2, 0.0f));
        TransformGroup tgParedDer = new TransformGroup(tfParedDer);
        tgParedDer.addChild(paredConVentanas);
        
        this.addChild(tgParedDer);
    }
    
    private void crearPiso() {
        // Crear el piso
        Box piso = new Box(ANCHO/2, GROSOR_PARED/2, LARGO/2, 
                         Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 
                         crearApariencia(new Color3f(0.6f, 0.6f, 0.6f)));
        
        Transform3D tfPiso = new Transform3D();
        tfPiso.setTranslation(new Vector3f(0.0f, GROSOR_PARED/2, 0.0f));
        TransformGroup tgPiso = new TransformGroup(tfPiso);
        tgPiso.addChild(piso);
        this.addChild(tgPiso);
    }
    
    private void crearTecho() {
        // Crear el techo
        Box techo = new Box(ANCHO/2, GROSOR_PARED/2, LARGO/2, 
                          Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS, 
                          crearApariencia(new Color3f(0.8f, 0.8f, 0.9f)));
        
        Transform3D tfTecho = new Transform3D();
        tfTecho.setTranslation(new Vector3f(0.0f, ALTO - GROSOR_PARED/2, 0.0f));
        TransformGroup tgTecho = new TransformGroup(tfTecho);
        tgTecho.addChild(techo);
        this.addChild(tgTecho);
    }
    
    private Appearance crearApariencia(Color3f color) {
        Appearance ap = new Appearance();
        Material mat = new Material();
        mat.setDiffuseColor(color);
        mat.setSpecularColor(new Color3f(0.1f, 0.1f, 0.1f));
        mat.setShininess(64.0f);
        ap.setMaterial(mat);
        return ap;
    }
    
    private Appearance crearAparienciaVentana() {
    Appearance ap = new Appearance();
    Material mat = new Material();
    mat.setDiffuseColor(COLOR_VENTANA);
    
    // Configurar transparencia (forma correcta para Java 3D 1.5+)
    TransparencyAttributes transparency = new TransparencyAttributes();
    transparency.setTransparencyMode(TransparencyAttributes.BLENDED);
    transparency.setTransparency(0.5f); // 0.5f = 50% de transparencia
    
    ap.setMaterial(mat);
    ap.setTransparencyAttributes(transparency);
    
    return ap;
}
}