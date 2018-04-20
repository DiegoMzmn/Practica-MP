package prac2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TestFrame extends javax.swing.JFrame implements Border{
    private JPanel[][] matriz;
    private ActualizaTablero at;
    
    
    public TestFrame(){
        initComponents(); 
        
        int opc= JOptionPane.showConfirmDialog(null,"¿Quiere iniciar el juego?","INICIO",JOptionPane.YES_NO_OPTION);
        
        if (opc==0){
       
            matriz=new JPanel[60][60];
            for (int i=0;i<60;i++){
                for (int j=0;j<60;j++){
                    JPanel p1=new JPanel();
                    p1.setBackground(Color.white);
                    jPanel1.add(p1);
                    matriz[i][j]=p1;
                }
            }

            jPanel1.setBackground(Color.LIGHT_GRAY); 
            at = new ActualizaTablero(matriz);           
            at.start(); 
        }
        else{
            System.exit(0);
        }       
    }

    public JPanel[][] getMatriz() {
        return matriz;
    }
    
    public void crearHebra(){
        ActualizaTablero at= new ActualizaTablero(matriz);
        at.start();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(900, 900));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.setSize(new java.awt.Dimension(500, 500));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel1KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new java.awt.GridLayout(60, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyTyped
    }//GEN-LAST:event_jPanel1KeyTyped

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
  
    }//GEN-LAST:event_jPanel1KeyPressed

    
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        try{
            if (evt.getKeyCode()==evt.VK_P){
                at.ponerPause();
            }
            if (!at.getPulsado()){
                if(((evt.getKeyCode()==evt.VK_LEFT))&& (at.queDireccion()!=2)){
                    at.cambiarDireccion(false,false,false,true);           
                  }
                if((evt.getKeyCode()==evt.VK_RIGHT) && (at.queDireccion()!=4)){
                   at.cambiarDireccion(false,false,true,false);
                }
                if((evt.getKeyCode()==evt.VK_UP)&& (at.queDireccion()!=3)){
                    at.cambiarDireccion(true,false,false,false);           
                }
                if((evt.getKeyCode()==evt.VK_DOWN)&& (at.queDireccion()!=1)){
                    at.cambiarDireccion(false,true,false,false);   
                }
                if (evt.getKeyCode()==evt.VK_1){               
                    at.aumentarVelocidad();               
                }
                if (evt.getKeyCode()==evt.VK_2){
                    at.disminuirVelocidad();                
                }
                at.setPulsado(true);
            }
        }catch(NullPointerException ex){}
    }//GEN-LAST:event_formKeyPressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
   
    }//GEN-LAST:event_formMouseClicked
   
  
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
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TestFrame p =new TestFrame();
                p.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Insets getBorderInsets(Component c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isBorderOpaque() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}