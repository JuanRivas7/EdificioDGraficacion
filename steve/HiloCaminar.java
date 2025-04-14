package steve;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloCaminar extends Thread {

    private steven escena;

    public HiloCaminar(steven es) {
        this.escena = es;
    }

    @Override
    public void run() {
        while (true) {
            escena.caminar(); // llama al método que mueve al muñeco según las teclas
            try {
                Thread.sleep(30); // más fluido
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloCaminar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
