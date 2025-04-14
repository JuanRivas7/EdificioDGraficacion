package pruebaD;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.j3d.*;
import javax.vecmath.*;

import steve.steven;

public class crearEscenaGrafica implements KeyListener {

    public BranchGroup objRaiz;
    private TransformGroup tgSteven;
    private Transform3D transform3D;
    private float x = 0.0f, y = 0.0f, z = 0.0f;

    public BranchGroup crearEscena() {
        objRaiz = new BranchGroup();

        // Crear fondo
        Background background = new Background(new Color3f(0.8f, 0.9f, 1.0f));
        background.setApplicationBounds(new BoundingSphere(new Point3d(), 1000.0));
        objRaiz.addChild(background);

        // Iluminación
        Color3f luzColor = new Color3f(1.0f, 1.0f, 1.0f);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0, 0, 0), 100.0);
        DirectionalLight luzDir = new DirectionalLight(luzColor, new Vector3f(-1.0f, -1.0f, -1.0f));
        luzDir.setInfluencingBounds(bounds);
        objRaiz.addChild(luzDir);

        AmbientLight luzAmb = new AmbientLight(true, new Color3f(0.3f, 0.3f, 0.3f));
        luzAmb.setInfluencingBounds(bounds);
        objRaiz.addChild(luzAmb);

        // Piso
        Appearance aparienciaPiso = new Appearance();
        Color3f colorPiso = new Color3f(0.3f, 0.6f, 0.3f);
        ColoringAttributes caPiso = new ColoringAttributes(colorPiso, ColoringAttributes.NICEST);
        aparienciaPiso.setColoringAttributes(caPiso);
        Box piso = new Box(1.5f, 0.02f, 1.5f, aparienciaPiso);
        objRaiz.addChild(piso);

        // Crear el muñeco (steven)
        steven muñeco = new steven();
        tgSteven = muñeco.getTransformGroup();
        tgSteven.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgSteven.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        objRaiz.addChild(tgSteven);

        return objRaiz;
    }

    // Método llamado desde el hilo para hacer alguna animación simple
    public void caminar() {
        // Por ejemplo, oscilar la posición un poco al caminar
        z += 0.005f;
        actualizarTransformacion();
    }

    private void actualizarTransformacion() {
        transform3D = new Transform3D();
        transform3D.setTranslation(new Vector3f(x, y, z));
        tgSteven.setTransform(transform3D);
    }

    // KeyListener
    @Override
    public void keyPressed(KeyEvent e) {
        float delta = 0.05f;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W : x += delta;
            case KeyEvent.VK_S : x -= delta;
            case KeyEvent.VK_A : y += delta;
            case KeyEvent.VK_D : y -= delta;
            case KeyEvent.VK_P : z += delta;
            case KeyEvent.VK_L : z -= delta;
        }
        actualizarTransformacion();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No usado
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No usado
    }
}
