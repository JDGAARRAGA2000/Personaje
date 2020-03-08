package personaje;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

/**
 *
 * @author JoseDaniel
 */
public class FrmPersonaje extends javax.swing.JFrame implements KeyListener {

    public FrmPersonaje() {
        initComponents();
        addKeyListener(this);

    }
    int posX, posY, lastPosX;

    int filas, columnas;
    public static int x = new Color(255, 0, 0).getRGB();
    public static int o = new Color(255, 255, 255).getRGB();
    public static int p = new Color(252, 213, 131).getRGB();
    public static int c = new Color(128, 64, 0).getRGB();

    int decimas, ContadorCinco, ContadorDiez, ContadorTiempo;

    int sprite = 1;
    int Direccion = 1;

    int aux;

    boolean MovLateral = false;
    boolean Salto = false;
    boolean encerarDecimas = false;

    private int[][] still = {{o, o, o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, o, o, o, o, o},
    {o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, o, o, o, o, o},
    {o, o, o, o, o, c, c, c, c, c, c, p, p, p, p, p, c, c, p, p, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, c, c, c, c, c, c, p, p, p, p, p, c, c, p, p, o, o, o, o, o, o, o, o, o},
    {o, o, o, c, c, p, p, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, o, o, o, o, o},
    {o, o, o, c, c, p, p, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, o, o, o, o, o},
    {o, o, o, c, c, p, p, c, c, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, o, o, o},
    {o, o, o, c, c, p, p, c, c, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, o, o, o},
    {o, o, o, c, c, c, c, p, p, p, p, p, p, p, p, p, c, c, c, c, c, c, c, c, o, o, o, o, o},
    {o, o, o, c, c, c, c, p, p, p, p, p, p, p, p, p, c, c, c, c, c, c, c, c, o, o, o, o, o},
    {o, o, o, o, o, o, o, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, o, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, o, o, o, o, o, o, o},
    {o, o, o, o, o, c, c, c, c, c, c, x, x, c, c, c, c, o, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, c, c, c, c, c, c, x, x, c, c, c, c, o, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, c, c, c, c, c, c, c, c, x, x, x, x, c, c, c, c, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, c, c, c, c, c, c, c, c, x, x, x, x, c, c, c, c, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, c, c, c, c, c, c, x, x, x, x, p, p, x, x, x, x, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, c, c, c, c, c, c, x, x, x, x, p, p, x, x, x, x, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, c, c, c, c, c, c, c, c, x, x, x, x, x, x, x, x, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, c, c, c, c, c, c, c, c, x, x, x, x, x, x, x, x, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, x, x, c, c, c, c, p, p, p, p, x, x, x, x, x, x, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, x, x, c, c, c, c, p, p, p, p, x, x, x, x, x, x, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, x, x, c, c, p, p, p, p, x, x, x, x, o, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, x, x, c, c, p, p, p, p, x, x, x, x, o, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, o, x, x, x, x, x, x, c, c, c, c, c, c, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, o, x, x, x, x, x, x, c, c, c, c, c, c, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, o, c, c, c, c, c, c, c, c, o, o, o, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, o, c, c, c, c, c, c, c, c, o, o, o, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o}};

//imagen para jump
    private int[][] walk1 = {{o, o, o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, o, o, o, o, o},
    {o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, o, o, o, o, o},
    {o, o, o, o, o, c, c, c, c, c, c, p, p, p, p, p, c, c, p, p, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, c, c, c, c, c, c, p, p, p, p, p, c, c, p, p, o, o, o, o, o, o, o, o, o},
    {o, o, o, c, c, p, p, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, o, o, o, o, o},
    {o, o, o, c, c, p, p, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, o, o, o, o, o},
    {o, o, o, c, c, p, p, c, c, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, o, o, o},
    {o, o, o, c, c, p, p, c, c, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, o, o, o},
    {o, o, o, c, c, c, c, p, p, p, p, p, p, p, p, p, c, c, c, c, c, c, c, c, o, o, o, o, o},
    {o, o, o, c, c, c, c, p, p, p, p, p, p, p, p, p, c, c, c, c, c, c, c, c, o, o, o, o, o},
    {o, o, o, o, o, o, o, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, o, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, o, o, o, o, o, o, o},
    {o, o, o, c, c, c, c, c, c, c, c, x, x, c, c, c, c, c, c, x, x, o, o, o, o, o, o, o, o},
    {o, o, o, c, c, c, c, c, c, c, c, x, x, c, c, c, c, c, c, x, x, o, o, o, o, o, o, o, o},
    {p, p, p, c, c, c, c, c, c, c, c, x, x, x, x, c, c, c, c, c, c, x, x, c, c, p, p, p, o},
    {p, p, p, c, c, c, c, c, c, c, c, x, x, x, x, c, c, c, c, c, c, x, x, c, c, p, p, p, o},
    {p, p, p, p, p, o, o, c, c, c, c, x, x, x, x, x, x, x, x, x, x, x, x, c, c, c, p, p, o},
    {p, p, p, p, p, o, o, c, c, c, c, x, x, x, x, x, x, x, x, x, x, x, x, c, c, c, p, p, o},
    {p, p, p, o, o, o, o, x, x, x, x, x, x, p, p, x, x, x, x, o, o, o, o, o, o, o, c, c, o},
    {p, p, p, o, o, o, o, x, x, x, x, x, x, p, p, x, x, x, x, o, o, o, o, o, o, o, c, c, o},
    {o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, c, c, c, c, o},
    {o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, c, c, c, c, o},
    {o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, c, c, c, c, o},
    {o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, c, c, c, c, o},
    {o, c, c, c, c, x, x, x, x, x, x, o, o, o, o, o, o, o, x, x, x, x, x, x, c, c, c, c, o},
    {o, c, c, c, c, x, x, x, x, x, x, o, o, o, o, o, o, o, x, x, x, x, x, x, c, c, c, c, o},
    {o, c, c, c, c, c, c, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o},
    {o, c, c, c, c, c, c, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, c, c, c, c, c, c, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o}};

    private int[][] jump = {{o, o, o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, p, p, p, p, p},
    {o, o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, p, p, p, p, p},
    {o, o, o, o, o, c, c, c, c, c, c, p, p, p, p, p, c, c, p, p, o, o, p, p, p, p, p, p, p},
    {o, o, o, o, o, c, c, c, c, c, c, p, p, p, p, p, c, c, p, p, o, o, p, p, p, p, p, p, p},
    {o, o, o, c, c, p, p, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, c, c, c, c, c},
    {o, o, o, c, c, p, p, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, c, c, c, c, c},
    {o, o, o, c, c, p, p, c, c, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, c, c, c},
    {o, o, o, c, c, p, p, c, c, c, c, p, p, p, p, p, p, p, c, c, p, p, p, p, p, p, c, c, c},
    {o, o, o, c, c, c, c, p, p, p, p, p, p, p, p, p, c, c, c, c, c, c, c, c, o, c, c, c, c},
    {o, o, o, c, c, c, c, p, p, p, p, p, p, p, p, p, c, c, c, c, c, c, c, c, o, c, c, c, c},
    {o, o, o, o, o, o, o, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, o, o, c, c, c, c, c},
    {o, o, o, o, o, o, o, p, p, p, p, p, p, p, p, p, p, p, p, p, p, p, o, c, c, c, c, o, o},
    {o, o, o, c, c, c, c, c, c, c, c, x, x, c, c, c, c, c, c, x, x, c, c, c, c, o, o, o, o},
    {o, o, o, c, c, c, c, c, c, c, c, x, x, c, c, c, c, c, c, x, x, c, c, c, c, o, o, o, o},
    {p, p, p, c, c, c, c, c, c, c, c, x, x, x, x, c, c, c, c, c, c, x, x, o, o, o, o, o, o},
    {p, p, p, c, c, c, c, c, c, c, c, x, x, x, x, c, c, c, c, c, c, x, x, o, o, o, o, o, o},
    {p, p, p, p, p, o, o, c, c, c, c, x, x, x, x, x, x, x, x, x, x, p, p, o, o, o, o, o, o},
    {p, p, p, p, p, o, o, c, c, c, c, x, x, x, x, x, x, x, x, x, x, p, p, o, o, o, o, o, o},
    {p, p, p, o, o, o, o, x, x, x, x, x, x, p, p, x, x, x, x, o, o, o, o, o, o, o, c, c, o},
    {p, p, p, o, o, o, o, x, x, x, x, x, x, p, p, x, x, x, x, o, o, o, o, o, o, o, c, c, o},
    {o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, c, c, c, c, o},
    {o, o, o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, c, c, c, c, o},
    {o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, c, c, c, c, o},
    {o, o, o, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, c, c, c, c, o},
    {o, c, c, c, c, x, x, x, x, x, x, o, o, o, o, o, o, o, x, x, x, x, x, x, c, c, c, c, o},
    {o, c, c, c, c, x, x, x, x, x, x, o, o, o, o, o, o, o, x, x, x, x, x, x, c, c, c, c, o},
    {o, c, c, c, c, c, c, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o},
    {o, c, c, c, c, c, c, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o},
    {o, o, o, c, c, c, c, c, c, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o, o}};

    private void VoltearMatrizEnX(int[][] matriz) {
        for (filas = 0; filas < 32; filas++) {
            for (columnas = 0; columnas < 29; columnas++) {

                aux = matriz[filas][columnas];
                matriz[filas][columnas] = matriz[filas][28 - columnas];
                matriz[filas][28 - columnas] = aux;
            }
        }
    }

    public void paint(Graphics g) {

        super.paint(g);

        for (filas = posY; filas < posY + (30); filas++) {
            for (columnas = posX; columnas < posX + (26); columnas++) {
                if (sprite == 1) {
                    g.setColor(new Color(still[filas - posY][columnas - posX]));
                }
                if (sprite == -1) {
                    g.setColor(new Color(walk1[filas - posY][columnas - posX]));
                }
                if (sprite == 2) {
                    g.setColor(new Color(jump[filas - posY][columnas - posX]));
                }
                g.fillRect(columnas * 4, (filas * 4) + 500, 10, 10);
            }

        }

    }

    Timer temporizador = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            decimas++;

            ContadorCinco++;
            ContadorDiez++;

            if (ContadorCinco == 5) {

                repaint();
                ContadorCinco = 0;

                lastPosX = posX;

                if (MovLateral) {
                    sprite = sprite * -1;
                }

            }

            if (ContadorDiez == 10) {
                ContadorDiez = 0;
                if (lastPosX == posX) {
                    sprite = 1;
                    MovLateral = false;
                }
            }

            if (Salto) {
                sprite = 2;
                if (encerarDecimas == false) {
                    decimas = 0;
                    encerarDecimas = true;
                }

                if (decimas < 10) {
                    posY -= 5;
                } else if (decimas >= 10 && decimas < 20) {
                    posY += 5;
                } else if (decimas == 20) {
                    Salto = false;
                }
            }

        }

    });
    
    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == 38) {

            if (!Salto) {
                encerarDecimas = false;
            }
            Salto = true;
            sprite = 2;

        }

        if (e.getKeyCode() == 37) {
            MovLateral = true;

            if (Direccion == 1) {
                Direccion = -1;
                VoltearMatrizEnX(walk1);
                VoltearMatrizEnX(still);
                VoltearMatrizEnX(jump);
            }

            posX -= 10;
        }

        if (e.getKeyCode() == 39) {

            MovLateral = true;

            if (Direccion == -1) {
                Direccion = 1;
                VoltearMatrizEnX(walk1);
                VoltearMatrizEnX(still);
                VoltearMatrizEnX(jump);
            }

            posX += 10;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                temporizador.start();

    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
            
            
        
       
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
