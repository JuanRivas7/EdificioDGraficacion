package steve;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import javax.media.j3d.BranchGroup;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.PointLight;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;


public class steven  {
    int pasos = 0;
    int paraTecxtura = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
    Textura textura = new Textura();
    BranchGroup bgRaiz = new BranchGroup();
    TransformGroup tgSpHomDer;
    TransformGroup tgSpCodoDer;
    TransformGroup tgSpHomIzq;
    TransformGroup tgSpCodoIzq;

    TransformGroup tgSpMusDer;
    TransformGroup tgSpRodDer;
    TransformGroup tgSpMusIzq;
    TransformGroup tgSpRodIzq;
    TransformGroup tgSpCuello;
    TransformGroup tgPanza;
    TransformGroup tgmoverMouse;
    TransformGroup tgMundo;

    public steven () {
        //----------------Movimiento con el Mouse---------------------------
       
        //----------------------------------------------------------------

        color c = new color(); // Objeto para todas las apariencias de color
        
        

        
        Box bxPanza = new Box(0.20f, 0.3f, 0.1f, paraTecxtura,textura.crearTextura("cuerAtras.png")); // PANZA de Steve
        bxPanza.setAppearance(0,textura.crearTextura("cuerAdelante.png"));
        bxPanza.setAppearance(1,textura.crearTextura("cuerAtras.png"));
        
        Box bxCabeza = new Box(0.24f, 0.20f, 0.14f, paraTecxtura,textura.crearTextura("peloSteve.jpeg")); // CABEZA de Steve
        bxCabeza.setAppearance(0,textura.crearTextura("cara.png"));
        bxCabeza.setAppearance(1,textura.crearTextura("caraAtras.png"));
        bxCabeza.setAppearance(2,textura.crearTextura("caraDer.png"));
        bxCabeza.setAppearance(3,textura.crearTextura("caraIzq.png"));
        bxCabeza.setAppearance(4,textura.crearTextura("caraArriba.png"));
        
        Sphere spCuello = new Sphere(0.05f, c.setColor(255, 0, 0)); // Esfera para el cuello de Steve

        Box bxHomDer = new Box(0.1f, 0.15f, 0.1f, paraTecxtura,textura.crearTextura("hombro.png")); // HOMBRO DERECHO de Steve
       
        Box bxBraDer = new Box(0.1f, 0.15f, 0.1f, paraTecxtura,textura.crearTextura("brazo.png")); // BRAZO DERECHO de Steve
        bxBraDer.setAppearance(5,textura.crearTextura("puno2.png"));
        Sphere spHomDer = new Sphere(0.05f, c.setColor(255, 0, 0)); // Esfera para el hombro derecho
        Sphere spCodoDer = new Sphere(0.05f, c.setColor(255, 0, 0)); // Esfera para el codo derecho

        Box bxHomIzq = new Box(0.1f, 0.15f, 0.1f, paraTecxtura,textura.crearTextura("homIzq.png")); // HOMBRO IZQUIERDO de Steve
        Box bxBraIzq = new Box(0.1f, 0.15f, 0.1f, paraTecxtura,textura.crearTextura("brazoIzq.png")); // BRAZO IZQUIERDO de Steve
        bxBraIzq.setAppearance(5,textura.crearTextura("puno.png"));
        Sphere spHomIzq = new Sphere(0.05f, c.setColor(255, 0, 0)); // Esfera para el hombro izquierdo
        Sphere spCodoIzq = new Sphere(0.05f, c.setColor(255, 0, 0)); // Esfera para el codo izquierdo

        Box bxMusDer = new Box(0.1f, 0.15f, 0.1f, paraTecxtura,textura.crearTextura("musDer.png")); // MUSLO DERECHO de Steve
        Box bxPieDer = new Box(0.1f, 0.15f, 0.1f, paraTecxtura,textura.crearTextura("pieDerecho.png")); // PIE DERECHO de Steve
        bxPieDer.setAppearance(5,textura.crearTextura("peloSteve.jpeg"));
        Sphere spMusDer = new Sphere(0.05f, c.setColor(255, 0, 0)); // Esfera para el muslo derecho
        Sphere spRodDer = new Sphere(0.05f, c.setColor(255, 0, 0)); // Esfera para la rodilla derecha

        Box bxMusIzq = new Box(0.1f, 0.15f, 0.1f, paraTecxtura,textura.crearTextura("musIzq.png")); // MUSLO IZQUIERDO de Steve
        Box bxPieIzq = new Box(0.1f, 0.15f, 0.1f, paraTecxtura,textura.crearTextura("pieIzq.png")); // PIE IZQUIERDO de Steve
        bxPieIzq.setAppearance(5,textura.crearTextura("peloSteve.jpeg"));
        Sphere spMusIzq = new Sphere(0.05f, c.setColor(255, 0, 0)); // Esfera para el muslo izquierdo
        Sphere spRodIzq = new Sphere(0.05f, c.setColor(255, 0, 0)); // Esfera para la rodilla izquierda

        Transform3D t3dPanza = new Transform3D();
        Transform3D t3dCabeza = new Transform3D(); // Objeto 3D CABEZA
        Transform3D t3dCuello = new Transform3D();
        Transform3D t3dHomDer = new Transform3D(); // Objeto 3D HOMBRO DERECHO
        Transform3D t3dBraDer = new Transform3D(); // Objeto 3D BRAZO DERECHO
        Transform3D t3dSpHomDer = new Transform3D(); // Esfera para rotar el HOMBRO DERECHO
        Transform3D t3dSpCodoDer = new Transform3D(); // Esfera para rotar el BRAZO DERECHO

        Transform3D t3dHomIzq = new Transform3D(); // Objeto 3D HOMBRO IZQUIERDO
        Transform3D t3dBraIzq = new Transform3D(); // Objeto 3D BRAZO IZQUIERDO
        Transform3D t3dSpHomIzq = new Transform3D(); // Esfera para rotar el HOMBRO IZQUIERDO
        Transform3D t3dSpCodoIzq = new Transform3D(); // Esfera para rotar el BRAZO IZQUIERDO

        Transform3D t3dMusDer = new Transform3D(); // Objeto 3D MUSLO DERECHO
        Transform3D t3dPieDer = new Transform3D(); // Objeto 3D PIE DERECHO
        Transform3D t3dSpMusDer = new Transform3D(); // Esfera para rotar el MUSLO DERECHO
        Transform3D t3dSpRodDer = new Transform3D(); // Esfera para rotar el PIE DERECHO

        Transform3D t3dMusIzq = new Transform3D(); // Objeto 3D MUSLO IZQUIERDO
        Transform3D t3dPieIzq = new Transform3D(); // Objeto 3D PIE IZQUIERDO
        Transform3D t3dSpMusIzq = new Transform3D(); // Esfera para rotar el MUSLO IZQUIERDO
        Transform3D t3dSpRodIzq = new Transform3D(); // Esfera para rotar el PIE IZQUIERDO
        
        t3dPanza.set(new Vector3d(0.0f, 0.0f, 1.0f));

        t3dCabeza.set(new Vector3d(0.0f, 0.20f, 0.0f)); // Mover la cabeza 50y

        t3dCuello.set(new Vector3d(0.0f, 0.30f, 0.0f)); // Mover el cuello 35y

        t3dHomDer.set(new Vector3d(0.10f, -0.15f, 0.0f)); // Mover el hombro derecho
        t3dBraDer.set(new Vector3d(-0.01f, -0.15f, 0.0f)); // Mover el brazo derecho
        t3dSpHomDer.set(new Vector3d(0.20f, 0.30f, 0.0f));
        t3dSpCodoDer.set(new Vector3d(0.01f, -0.15f, 0.0f));

        t3dHomIzq.set(new Vector3d(-0.10f, -0.15f, 0.0f)); // Mover el hombro izquierdo
        t3dBraIzq.set(new Vector3d(0.01f, -0.15f, 0.0f)); // Mover el brazo izquierdo
        t3dSpHomIzq.set(new Vector3d(-0.20f, 0.30f, 0.0f));
        t3dSpCodoIzq.set(new Vector3d(-0.01f, -0.15f, 0.0f));

        t3dMusDer.set(new Vector3d(0.0f, -0.15f, 0.0f)); // Mover el muslo derecho
        t3dPieDer.set(new Vector3d(0.0f, -0.15f, 0.0f)); // Mover el pie derecho
        t3dSpMusDer.set(new Vector3d(0.10f, -0.30f, 0.0f));
        t3dSpRodDer.set(new Vector3d(0.0f, -0.15f, 0.0f));

        t3dMusIzq.set(new Vector3d(0.0f, -0.15f, 0.0f)); // Mover el muslo izquierdo
        t3dPieIzq.set(new Vector3d(0.0f, -0.15f, 0.0f)); // Mover el pie izquierdo
        t3dSpMusIzq.set(new Vector3d(-0.10f, -0.30f, 0.0f));
        t3dSpRodIzq.set(new Vector3d(0.0f, -0.15f, 0.0f));

       
       
       
        tgMundo.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        
        tgPanza.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        tgSpCuello = new TransformGroup(t3dCuello);
        tgSpCuello.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); // Dar permiso para reescribirse

        tgSpHomDer = new TransformGroup(t3dSpHomDer); // Mover Esfera del Hombro derecho
        tgSpCodoDer = new TransformGroup(t3dSpCodoDer); // Mover Esfera del Codo derecho

        tgSpHomDer.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); // Dar permiso para reescribirse
        tgSpCodoDer.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); // Dar permiso para reescribirse

        tgSpHomIzq = new TransformGroup(t3dSpHomIzq); // Mover Esfera del Hombro izquierdo
        tgSpCodoIzq = new TransformGroup(t3dSpCodoIzq); // Mover Esfera del Codo izquierdo

        tgSpHomIzq.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); // Dar permiso para reescribirse
        tgSpCodoIzq.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); // Dar permiso para reescribirse

        tgSpMusDer = new TransformGroup(t3dSpMusDer); // Mover Esfera del Muslo derecho
        tgSpRodDer = new TransformGroup(t3dSpRodDer); // Mover Esfera de la Rodilla derecha

        tgSpMusDer.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); // Dar permiso para reescribirse
        tgSpRodDer.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); // Dar permiso para reescribirse

        tgSpMusIzq = new TransformGroup(t3dSpMusIzq); // Mover Esfera del Muslo izquierdo
        tgSpRodIzq = new TransformGroup(t3dSpRodIzq); // Mover Esfera de la Rodilla izquierda

        tgSpMusIzq.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); // Dar permiso para reescribirse
        tgSpRodIzq.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); // Dar permiso para reescribirse
        
        EscalarTG(tgPanza, 0.3f);

         MouseRotate myMouseRotate = new MouseRotate(); // Permite utilizar el comportamiento que tiene el Mouse
        myMouseRotate.setTransformGroup(tgMundo);
        myMouseRotate.setSchedulingBounds(new BoundingSphere()); // Donde va a aplicar? En toda la esfera
       
        
        bgRaiz.addChild(myMouseRotate);
        bgRaiz.addChild(tgPanza); // Mover mouse para la panza
        bgRaiz.addChild(tgMundo);
        // 1. Crear el TransformGroup principal con capacidad de transformación
tgMundo = new TransformGroup();
tgMundo.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
tgMundo.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

// 2. Crear jerarquía para cada parte (ejemplo con panza y cabeza, deberías hacer lo mismo con el resto)
 TransformGroup tgCabeza = new TransformGroup(t3dCabeza);
tgCabeza.addChild(bxCabeza);

TransformGroup tgCuello = new TransformGroup(t3dCuello);
tgCuello.addChild(spCuello);
tgCuello.addChild(tgCabeza); // cabeza sobre cuello

TransformGroup tgPanza = new TransformGroup(t3dPanza);
tgPanza.addChild(bxPanza);
tgPanza.addChild(tgCuello); // cuello sobre panza

// Brazo derecho
tgSpCodoDer = new TransformGroup(t3dSpCodoDer);
tgSpCodoDer.addChild(bxBraDer);

tgSpHomDer = new TransformGroup(t3dSpHomDer);
tgSpHomDer.addChild(spHomDer);
tgSpHomDer.addChild(tgSpCodoDer);

TransformGroup tgHomDer = new TransformGroup(t3dHomDer);
tgHomDer.addChild(bxHomDer);
tgHomDer.addChild(tgSpHomDer); // hombro contiene a su esfera

TransformGroup tgBrazoDer = new TransformGroup(t3dBraDer);
tgBrazoDer.addChild(tgHomDer);

// Brazo izquierdo
tgSpCodoIzq = new TransformGroup(t3dSpCodoIzq);
tgSpCodoIzq.addChild(bxBraIzq);

tgSpHomIzq = new TransformGroup(t3dSpHomIzq);
tgSpHomIzq.addChild(spHomIzq);
tgSpHomIzq.addChild(tgSpCodoIzq);

TransformGroup tgHomIzq = new TransformGroup(t3dHomIzq);
tgHomIzq.addChild(bxHomIzq);
tgHomIzq.addChild(tgSpHomIzq);

TransformGroup tgBrazoIzq = new TransformGroup(t3dBraIzq);
tgBrazoIzq.addChild(tgHomIzq);

// Muslos y piernas (solo ejemplo derecho)
tgSpRodDer = new TransformGroup(t3dSpRodDer);
tgSpRodDer.addChild(bxPieDer);

tgSpMusDer = new TransformGroup(t3dSpMusDer);
tgSpMusDer.addChild(spMusDer);
tgSpMusDer.addChild(tgSpRodDer);

tgSpMusIzq = new TransformGroup(t3dSpMusIzq);
tgSpMusIzq.addChild(spMusIzq);
tgSpRodIzq = new TransformGroup(t3dSpRodIzq);
tgSpRodIzq.addChild(bxPieIzq);
tgSpMusIzq.addChild(tgSpRodIzq);

// Ensamblado del cuerpo
tgMundo.addChild(tgPanza);
tgMundo.addChild(tgBrazoDer);
tgMundo.addChild(tgBrazoIzq);
tgMundo.addChild(tgSpMusDer);
tgMundo.addChild(tgSpMusIzq);

// 3. Agregar tgMundo al BranchGroup
bgRaiz.addChild(tgMundo);

        float intensidad = 6.0f;
        
        addPointLight(-5.0f, 50.0f, 50.0f, 116*intensidad, 128*intensidad, 129*intensidad);
        addPointLight(2.0f, -50.0f, -50.0f, 116*intensidad, 128*intensidad, 129*intensidad);
    }
    
    

   public void girarTG(TransformGroup tg, int grados, String eje) {
    Transform3D leerBrazo = new Transform3D();
    Transform3D moverBrazo = new Transform3D();

    // Obtener la transformación inicial
    tg.getTransform(leerBrazo);

    // Crear una nueva transformación para la rotación
    if (eje.equals("X")) {
        moverBrazo.rotX(Math.PI / 180 * grados);
    } else if (eje.equals("Y")) {
        moverBrazo.rotY(Math.PI / 180 * grados);
    } else if (eje.equals("Z")) {
        moverBrazo.rotZ(Math.PI / 180 * grados);
        moverBrazo.set(new Vector3d(0.0f, 0.0f, 0.10f));
    }

    // Aplicar la rotación relativa a la transformación inicial
    leerBrazo.mul(moverBrazo);
    tg.setTransform(leerBrazo);
}
    public void TrasladarTG(TransformGroup tg, float x,float y,float z){
        Transform3D leer = new Transform3D();
        Transform3D mover = new Transform3D();
        tg.getTransform(leer);
        
        mover.set(new Vector3f(x,y,z));
        leer.mul(mover);
        tg.setTransform(leer);
    }
    
    public void EscalarTG(TransformGroup tg, float x){
        Transform3D leer = new Transform3D();
        Transform3D mover = new Transform3D();
        
        mover.setScale(x);
        leer.mul(mover);
        tg.setTransform(leer);
                
    }
    public void caminar(){
       
        if (pasos < 8) {
       
            girarTG(tgSpMusIzq, -5, "X");
            girarTG(tgSpRodIzq, 5, "X");
            girarTG(tgSpMusDer, 5, "X");
            girarTG(tgSpRodDer, 5, "X");
            
            girarTG(tgSpHomDer, -5, "X");
            girarTG(tgSpCodoDer, -5, "X");
            girarTG(tgSpHomIzq, 5, "X");
            girarTG(tgSpCodoIzq, -5, "X");
            
            
        } else {
            if (pasos < 16) {
                girarTG(tgSpMusIzq, 5, "X");
                girarTG(tgSpRodIzq, -5, "X");
                girarTG(tgSpMusDer, -5, "X");
                girarTG(tgSpRodDer, -5, "X");
                
                girarTG(tgSpHomDer, 5, "X");
            girarTG(tgSpCodoDer, 5, "X");
            girarTG(tgSpHomIzq, -5, "X");
            girarTG(tgSpCodoIzq, 5, "X");
            }else{
               if (pasos < 24) {
                girarTG(tgSpMusIzq, 5, "X");
                girarTG(tgSpRodIzq, 5, "X");
                girarTG(tgSpMusDer, -5, "X");
                girarTG(tgSpRodDer, 5, "X");
                
                girarTG(tgSpHomDer, 5, "X");
            girarTG(tgSpCodoDer, -5, "X");
            girarTG(tgSpHomIzq, -5, "X");
            girarTG(tgSpCodoIzq, -5, "X");
            
            }else{
                   if (pasos < 32) {
                girarTG(tgSpMusIzq, -5, "X");
                girarTG(tgSpRodIzq, -5, "X");
                girarTG(tgSpMusDer, 5, "X");
                girarTG(tgSpRodDer, -5, "X");
                
                girarTG(tgSpHomDer, -5, "X");
            girarTG(tgSpCodoDer, 5, "X");
            girarTG(tgSpHomIzq, 5, "X");
            girarTG(tgSpCodoIzq, 5, "X");
                     }else pasos=-1;
                   
               
               }
        }
        
        }
        pasos++;
        TrasladarTG(tgMundo, 0.0f,  0.0f,  0.1f);
    }

    
    
    
    public void addPointLight(float x, float y, float z, float r, float g, float b) {
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
        
        PointLight pointLight = new PointLight(
            new Color3f(r, g, b),
            new Point3f(x, y, z),
            new Point3f(0.0f, 1.0f, 0.0f)  // Attenuation (constant, linear, quadratic)
        );
        pointLight.setInfluencingBounds(bounds);
        bgRaiz.addChild(pointLight);
    }
    
    
    public TransformGroup getTransformGroup() {
    return tgMundo;
}
    
}
