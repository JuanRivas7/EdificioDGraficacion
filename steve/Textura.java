/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package steve;

import com.sun.j3d.utils.image.TextureLoader;
import java.awt.Container;
import java.io.File;
import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.vecmath.Color3f;



/**
 *
 * @author gusta
 */
public class Textura {
    public Appearance crearTextura (String nomarch){
        File file = new File("");
        String ruta = file.getAbsolutePath()+"\\src\\img\\";
        TextureLoader loader = new TextureLoader((ruta + nomarch), new Container());
        Texture texture = loader.getTexture();
        Appearance app = new Appearance();
        
        app.setTexture(texture);
        // Configurar cómo la textura interactúa con la iluminación
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE); // Permite que la luz afecte la textura
        app.setTextureAttributes(texAttr);
        
        Material material = new Material();
        material.setAmbientColor(new Color3f(0.2f, 0.2f, 0.2f));  // Soft ambient color
        material.setDiffuseColor(new Color3f(0.5f, 0.5f, 0.5f));  // Main color under light
        material.setSpecularColor(new Color3f(0.1f, 0.1f, 0.1f)); // Shiny reflections
        material.setShininess(50.0f);  // Higher = more glossy
        app.setMaterial(material);
        return app;
    }
    
    
}
