/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos.luengo
 */
public class VentanaGestionUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VentanaGestionUsuario
     */
    public VentanaGestionUsuario() {
        initComponents();
   
        jComboBox2.setSelectedIndex(0);
    }
/** Método para comprobar que se escriban todos los datos */
    private boolean comprobar(){
    if(jTextField1.getText().equals("")||
       jTextField2.getText().equals("")||
       jTextField3.getText().equals("")){
        return true;
    }
    else{
        return false;
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

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Universitaria -  Gestión Socios");
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("BIBLIOTECA UNIVERSITARIA");

        jLabel1.setText("Nombre:");

        jLabel2.setText("DNI:");

        jLabel3.setText("Código de socio:");

        jLabel5.setText("Categoria de socio:");

        jLabel6.setText("Fecha Inscripción:");

        jTextField5.setEnabled(false);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alumno", "Profesor" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Baja" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Comprobar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jFormattedTextField1.setText("jFormattedTextField1");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(47, 47, 47)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jButton3)
                                    .addGap(45, 45, 45)
                                    .addComponent(jButton1)
                                    .addGap(40, 40, 40)
                                    .addComponent(jButton2)))
                            .addGap(16, 16, 16))
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton4)
                        .addContainerGap())))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-572)/2, (screenSize.height-513)/2, 572, 513);
    }// </editor-fold>//GEN-END:initComponents
    //ComboBox para seleccionar alta o baja
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        
        if((String)jComboBox2.getSelectedItem() == "Baja"){
            jTextField1.enable(false);
            jTextField2.enable(false);
            jComboBox1.disable();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField5.setText("");
        }
        else{
            jTextField1.enable(true);
            jTextField2.enable(true);
            jComboBox1.enable(true);
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField5.setText("");
            
       
        }
        
        
    }//GEN-LAST:event_jComboBox2ActionPerformed
/**Boton confirmar, confirma el alta o la baja del usuario */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
   if(jComboBox2.getSelectedItem().equals("Alta")) {
    try{   
       String nombre = "";
       String dni = "";
       String codigo = "";
       String categoria = "";
       
       codigo = jTextField3.getText();
       nombre = jTextField1.getText();
       dni = jTextField2.getText();
       categoria = (String)jComboBox1.getSelectedItem();
        String numero = codigo.substring(0, 4);
        String letra= codigo.substring(4);
        int comp = Integer.parseInt(numero);
        System.out.println("Numero "+comp);
        System.out.println("Letra " + letra);
        if (letra.equals("P") && categoria.equals("Profesor") || letra.equals("A") && categoria.equals("Alumno")) {
           if(comp >= 1000){
            
         boolean test = true;   
         Persona p = new Persona(nombre, dni, codigo, categoria);
         test = GestionUsuario.consultaSocio(codigo);
         boolean campos = true;
         campos = comprobar();
            if(campos == false){
            if(test == false){
         GestionUsuario.altaSocios(p);
         GestionUsuario.guardarDatos();
         JOptionPane.showMessageDialog(this, "El usuario ha sido dado de alta:\n" + p.toString(), "Alta socio", JOptionPane.INFORMATION_MESSAGE);
         
        }
         else{
             JOptionPane.showMessageDialog(this, "El usuario ya esta dado de alta", "Alta socio", JOptionPane.INFORMATION_MESSAGE);
        }
         }
         else{
          JOptionPane.showMessageDialog(this, "Hay campos vacios. Reviselo y vuelva a intentarlo", "Alta socio", JOptionPane.INFORMATION_MESSAGE);
         }
            
        }
        }
        else{
         JOptionPane.showMessageDialog(this, "Código no valido", "Alta socio", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    catch(Exception IOE){
        JOptionPane.showMessageDialog(this, "No ha sido posible dar de alta al socio", "Alta socio", JOptionPane.ERROR_MESSAGE);
        System.out.println("Error al introducir el socio: \n" + IOE.toString());
    }
   
   }
   /**Boton para dar de baja un usuario y volver al estado */
  if(jComboBox2.getSelectedItem().equals("Baja")){
       try{
       String codigo = jTextField3.getText();
       if (GestionUsuario.consultaSocio(codigo) == false){
     
            JOptionPane.showMessageDialog(this, "El socio no existe", "Error", JOptionPane.ERROR_MESSAGE);
            jTextField3.setText("");
       
       }
       else{
            GestionUsuario.bajaSocios(codigo);
            GestionUsuario.guardarDatos();
            JOptionPane.showMessageDialog(this, "El usuario ha sido dado de baja", "Baja socio", JOptionPane.INFORMATION_MESSAGE);
            jComboBox2.setSelectedIndex(0);
            
       }
       }
       catch(Exception IOE){
        JOptionPane.showMessageDialog(this, "Error al dar de baja al socio", "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println("Error al dar de baja al socio " + IOE.toString());
       }
       
   }


    }//GEN-LAST:event_jButton1ActionPerformed
    /**Boton limpiar, deja todos los campos a 0 */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        
    }//GEN-LAST:event_jButton2ActionPerformed
    /**Boton volver a VentanaElección*/
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        GestionUsuario.guardarDatos();
        GestionPublicacion.guardarDatos();
        VentanaEleccion ve = new VentanaEleccion();
        ve.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed
    /** Boton comprobar*/
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String consulta = "";
        consulta = (String)jTextField3.getText();
        if(GestionUsuario.consultaSocio(consulta) == true){
           jLabel7.setSize(15, 15);
           ImageIcon imagen = new ImageIcon("imagenes/checkicon.png");
           ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), 1));
           jLabel7.setIcon(imgRedimensionada);
           GestionUsuario.recuperarSocio(consulta);
           jTextField1.setText(GestionUsuario.recuperarSocio(consulta).getNombre());
           jTextField2.setText(GestionUsuario.recuperarSocio(consulta).getDNI());
           jComboBox2.setToolTipText(GestionUsuario.recuperarSocio(consulta).getCategoria_socio());
          jTextField5.setText(GestionUsuario.recuperarSocio(consulta).getFecha_alta());
        }
        else{
           jLabel7.setSize(15, 15);
           ImageIcon imagen = new ImageIcon("imagenes/erroricon.png");
           ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), 1));
           jLabel7.setIcon(imgRedimensionada);
           JOptionPane.showMessageDialog(this, "El socio no existe", "Error", JOptionPane.ERROR_MESSAGE);
           jTextField3.setText("");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void VentanaGestionUsuario(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaGestionUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
