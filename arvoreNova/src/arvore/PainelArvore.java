
package arvore;

import javax.swing.*;
import java.awt.*;

public class PainelArvore extends JPanel {

    private BIntNo raiz;

    public PainelArvore(BIntNo raiz) {
        this.raiz = raiz;
    }

    public void atualizarRaiz(BIntNo novaRaiz) {
        this.raiz = novaRaiz;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (raiz != null) {
            desenhar(g, raiz, getWidth() / 2, 30, getWidth() / 4);
        }
    }

    private void desenhar(Graphics g, BIntNo no, int x, int y, int deslocamento) {
        g.setColor(Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(no.valor), x - 5, y + 5);

        g.setColor(Color.BLACK);
        if (no.esq != null) {
            g.drawLine(x, y, x - deslocamento, y + 50);
            desenhar(g, no.esq, x - deslocamento, y + 50, deslocamento / 2);
        }
        if (no.dir != null) {
            g.drawLine(x, y, x + deslocamento, y + 50);
            desenhar(g, no.dir, x + deslocamento, y + 50, deslocamento / 2);
        }
    }
}
