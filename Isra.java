/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gusta
 */
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.Shape3D;
import javax.media.j3d.BranchGroup;

public class FiguraFactory {

    // Método para crear una esfera
    public static Shape3D crearEsfera(float radio) {
        return new Sphere(radio).getShape();
    }

    // Método para crear un cubo
   

    // Método para crear un BranchGroup con la figura
    public static BranchGroup crearBranchGroup(Shape3D figura) {
        BranchGroup bg = new BranchGroup();
        bg.addChild(figura);
        return bg;
    }

}