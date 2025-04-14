import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBehavior extends Behavior implements KeyListener {

    private WakeupOnAWTEvent wakeupEvent;
    private Transform3D currentTransform = new Transform3D();
    private Vector3f position = new Vector3f();
    private final float step = 0.05f;

    private final TransformGroup movableTG;

    public KeyBehavior(MainScene frame) {
        this.movableTG = MainScene.movableBoxTG;
        frame.addKeyListener(this);
    }

    @Override
    public void initialize() {
        wakeupEvent = new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED);
        wakeupOn(wakeupEvent);
    }

    @Override
    public void processStimulus(java.util.Enumeration criteria) {
        wakeupOn(wakeupEvent); // volver a esperar evento de teclado
    }

    private boolean willCollide(Vector3f nextPosition) {
        // Caja movible futura (basada en la siguiente posición)
        BoundingBox nextBox = new BoundingBox(
                new Point3d(nextPosition.x - 0.1, nextPosition.y - 0.1, nextPosition.z - 0.1),
                new Point3d(nextPosition.x + 0.1, nextPosition.y + 0.1, nextPosition.z + 0.1)
        );

        // Verifica si se intersecta con la caja estática
        return nextBox.intersect(MainScene.staticBoxBounds);
    }

    private void move(float dx, float dy) {
        movableTG.getTransform(currentTransform);
        currentTransform.get(position);

        // Nueva posición propuesta
        Vector3f nextPosition = new Vector3f(position);
        nextPosition.x += dx;
        nextPosition.y += dy;

        if (!willCollide(nextPosition)) {
            // Si no hay colisión, mover
            position.set(nextPosition);
            currentTransform.setTranslation(position);
            movableTG.setTransform(currentTransform);
        } else {
            System.out.println("¡Colisión detectada! No se puede mover.");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W : move(0.0f, step);   // Arriba
            case KeyEvent.VK_S : move(0.0f, -step);  // Abajo
            case KeyEvent.VK_A : move(-step, 0.0f);  // Izquierda
            case KeyEvent.VK_D : move(step, 0.0f);   // Derecha
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
