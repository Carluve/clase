/*
 * Biblioteca, Ventana de gestion para las publicaciones
 */
package Biblioteca;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author carlos.luengo
 */
public class VentanaGestionPublicaciones extends javax.swing.JFrame {

    /** Referenciamos el array list de publicaciones */
    private ArrayList<Publicaciones> publicaciones; //Referencia al ArrayList de publicaciones (Publicaciones)
    private ListIterator li; //Iterator para recorrer el ArrayList en ambas direcciones
    private Publicaciones objpub;
   
    /**
     * Creates new form VentanaGestionPublicaciones
     */
    public VentanaGestionPublicaciones() {
        initComponents();
        Icon icono1 = new ImageIcon("imagenes/choosepic.png");
        jButton9.setIcon(icono1);
        jSpinner1.setEditor(new JSpinner.DateEditor(jSpinner1, "MMMM/yyyy"));
        limpiar();
 
                

    }
  
   
  
    
      /** Consulta los productos del ArrayList ordenadas para su presentación */
    private void consultaPublicaciones() {
        try {
            /**Referenciamos al ArrayList de GestionPublicaciones*/
           publicaciones = GestionPublicacion.getPublicaciones();
            /** Creamos el iterador sobre el ArrayList*/
                li = publicaciones.listIterator();
                int codigo = 0;
         
            //presentamos 
            if (li.hasNext()) {
                objpub = (Publicaciones) li.next();
            }
            if (objpub != null) {
                presenta(objpub);
            } else {
                JOptionPane.showMessageDialog(this, "No hay mas publicaciones.", "Gestion publicaciones", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
            return;
        }
    }//fin consultaPublicaciones

    /** Método para presentar los datos*/
    private void presenta(Publicaciones pub) {
        String tipo = pub.getClass().getSimpleName();
        jTextField1.setText(pub.getCodigo());
        jTextField2.setText(pub.getIsbn());
        jTextField3.setText(pub.getTitulo());
        jTextField4.setText(pub.getAutores());
        jSpinner1.setValue(pub.getFecha_publicacion());
        jTextField6.setText(pub.getFotografia());
        jTextField7.setText(String.valueOf(pub.getPaginas()));
        jTextField8.setText(pub.getColeccion());
        jTextField9.setText(pub.getMateria());
        jTextField10.setText(pub.getObservaciones());
        jLabel21.setSize(100, 90);
        ImageIcon imagen = new ImageIcon(jTextField6.getText());
        ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(jLabel21.getWidth(), jLabel21.getHeight(), 1));
        jLabel21.setIcon(imgRedimensionada);
        
        

        if (tipo.equals("Libro")) {
            Libro lib = (Libro) objpub;
            jTextField16.setText("");
            jComboBox1.setSelectedItem(tipo);
            jTextField11.setText(lib.getEditorial());
            jTextField12.setText(lib.getLocalidad());
            jTextField13.setText(lib.getContenido());
            jTextField14.setText(lib.getEdicion());
            jTextField15.setText(lib.getLocalizacion());
           
            
        }
        
        if(tipo.equals("Revistas")){
            Revistas rev = (Revistas) objpub;
            jTextField16.setText("");
            jComboBox1.setSelectedItem(tipo);
            jTextField11.setText(rev.getPeriocidad());
            jTextField12.setText(String.valueOf(rev.getVolumen()));
            jTextField13.setText(String.valueOf(rev.getNumero()));
            jTextField14.setText(String.valueOf(rev.getAnio_disponible()));
            jTextField15.setText(rev.getLocalizacion());
        }
        if(tipo.equals("Proyectos")){
            Proyectos pro = (Proyectos) objpub;
            jTextField16.setEnabled(false);
            jComboBox1.setSelectedItem(tipo);
            jTextField11.setText(pro.getTribunal());
            jTextField12.setText(pro.getEntidad());
            jTextField13.setText(pro.getDepartamento());
            jTextField14.setText(String.valueOf(pro.getCalificacion()));
            jTextField15.setText(pro.getFecha_lectura());
            jTextField16.setText(pro.getTitulacion());
            jTextField16.setEnabled(false);
            if(jComboBox2.getSelectedItem().equals("Modificacion")){
             jTextField16.setEnabled(true);
            
            }
        }
        if(tipo.equals("Tesis")){
            Tesis pro = (Tesis) objpub;
           
            jComboBox1.setSelectedItem(tipo);
            jTextField11.setText(pro.getTribunal());
            jTextField12.setText(pro.getEntidad());
            jTextField13.setText(pro.getDepartamento());
            jTextField14.setText(String.valueOf(pro.getCalificacion()));
            jTextField15.setText(pro.getFecha_lectura());
            jTextField16.setText(pro.getPrograma());
            jTextField16.setEnabled(false);
            if(jComboBox2.getSelectedItem().equals("Modificacion")){
             jTextField16.setEnabled(true);
            
            }
        
        }
        
        
    }
    /** Método para vaciar las jTextField y limpiar */
    private void limpiar(){
       
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox1.setEnabled(true);
        jButton9.setEnabled(true);
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTextField6.setEnabled(true);
        jTextField7.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextField9.setEnabled(true);
        jTextField10.setEnabled(true);
        jTextField11.setEnabled(true);
        jTextField12.setEnabled(true);
        jTextField13.setEnabled(true);
        jTextField14.setEnabled(true);
        jTextField15.setEnabled(true);
        jSpinner1.setEnabled(true);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jLabel21.setText("");
        jLabel21.setSize(100, 90);
        ImageIcon imagen = new ImageIcon("imagenes/libros.jpg");
        ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(jLabel21.getWidth(), jLabel21.getHeight(), 1));
        jLabel21.setIcon(imgRedimensionada);
        
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Universitaria - Gestion Publicaciones");
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("BIBLIOTECA UNIVERSITARIA");

        jLabel1.setText("Código:");

        jLabel2.setText("ISBN:");

        jLabel3.setText("Titulo:");

        jLabel5.setText("Autores:");

        jLabel6.setText("Fecha publicación:");

        jLabel7.setText("Fotografia:");

        jLabel8.setText("Páginas:");

        jLabel9.setText("Colección:");

        jLabel10.setText("Materia:");

        jLabel11.setText("Observaciones:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Libro", "Revistas", "Proyectos", "Tesis" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel12.setText("Tipo:");

        jLabel13.setText("Var1:");

        jLabel14.setText("Var2:");

        jLabel15.setText("Var3:");

        jLabel16.setText("Var4:");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jTextField6.setText("jTextField6");

        jTextField7.setText("jTextField7");

        jTextField8.setText("jTextField8");

        jTextField9.setText("jTextField9");

        jTextField10.setText("jTextField10");

        jTextField11.setText("jTextField11");

        jTextField12.setText("jTextField12");

        jTextField13.setText("jTextField13");

        jTextField14.setText("jTextField14");

        jLabel17.setText("Var5:");

        jTextField15.setText("jTextField15");

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Consulta", "Modificacion" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton5.setText("Prestar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel20.setText("Var6:");

        jTextField16.setText("jTextField16");

        jButton6.setText("Siguiente");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Anterior");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        jButton8.setText("Devolución");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Seleccionar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel21.setText("jLabel21");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField11)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton9))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                    .addComponent(jTextField16)
                                    .addComponent(jTextField14)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8))
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 5, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jButton7)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton2))
                        .addGap(178, 178, 178))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addContainerGap())))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-810)/2, (screenSize.height-810)/2, 810, 810);
    }// </editor-fold>//GEN-END:initComponents

    //ComboBox seleccion tipo de publicacion (Libro, Revista, Proyecto, Tesis)
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
       /** ComboBox que cambia las etiquetas de las variables */
        
        if(jComboBox1.getSelectedItem().equals("Libro")){
        jLabel13.setText("Editorial:");
        jLabel14.setText("Localidad:");
        jLabel15.setText("Contenido:");
        jLabel16.setText("Edición:");
        jLabel17.setText("Localización:");
        jLabel20.setText("");
        jTextField16.enable(false);
        
        }
         if(jComboBox1.getSelectedItem().equals("Revistas")){
        jLabel13.setText("Periocidad:");
        jLabel14.setText("Volumen:");
        jLabel15.setText("Número:");
        jLabel16.setText("Año disponible:");
        jLabel17.setText("Localización:");
        jLabel20.setText("");
        jTextField16.enable(false);
        }
          if(jComboBox1.getSelectedItem().equals("Proyectos")){
        jLabel13.setText("Tribunal:");
        jLabel14.setText("Entidad:");
        jLabel15.setText("Departamento:");
        jLabel16.setText("Calificación:");
        jLabel17.setText("Fecha lectura:");
        jLabel20.setText("Titulación:");
        jTextField16.enable(true);
        }
           if(jComboBox1.getSelectedItem().equals("Tesis")){
        jLabel13.setText("Tribunal:");
        jLabel14.setText("Entidad:");
        jLabel15.setText("Departamento:");
        jLabel16.setText("Calificación:");
        jLabel17.setText("Fecha lectura:");
        jLabel20.setText("Programa:"); 
        jTextField16.enable(true);
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    //Combobox seleccion "Alta, Consulta...
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        /** Prepara la ventana para dar de alta una publicación */
        if(jComboBox2.getSelectedItem().equals("Alta")){
            jButton1.setText("Confirmar");
            limpiar();
            jButton6.setEnabled(false);
            jButton7.setEnabled(false);
            jButton8.setEnabled(true);
            jButton5.setEnabled(false);
            jComboBox1.setSelectedIndex(0);
            jComboBox2.setSelectedIndex(0);
            jLabel21.setSize(100, 90);
            ImageIcon imagen = new ImageIcon("imagenes/libros.jpg");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(jLabel21.getWidth(), jLabel21.getHeight(), 1));
            jLabel21.setIcon(imgRedimensionada);
        }
       /**Prepara la ventana para realizar consultas / bajas */
        if(jComboBox2.getSelectedItem().equals("Consulta")){
        jButton1.setText("Baja");
        jButton5.setEnabled(true);
        jButton8.setEnabled(true);
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        jButton9.setEnabled(false);
        jComboBox1.setSelectedIndex(0);
        jComboBox1.setEnabled(false);
        jComboBox1.setEnabled(false);
        jSpinner1.setEnabled(false);
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setEnabled(false);
        jTextField9.setEnabled(false);
        jTextField10.setEnabled(false);
        jTextField11.setEnabled(false);
        jTextField12.setEnabled(false);
        jTextField13.setEnabled(false);
        jTextField14.setEnabled(false);
        jTextField15.setEnabled(false);
        jTextField16.setEnabled(false);
        jLabel21.setText("");
        jLabel21.setSize(100, 90);
        ImageIcon imagen = new ImageIcon("imagenes/libros.jpg");
        ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(jLabel21.getWidth(), jLabel21.getHeight(), 1));
        jLabel21.setIcon(imgRedimensionada);
        consultaPublicaciones();
        
        }
        if(jComboBox2.getSelectedItem().equals("Modificacion")){
        jButton1.setText("Confirmar");
        jButton5.setEnabled(false);
        jButton8.setEnabled(false);
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);        
        jComboBox1.setSelectedIndex(0);
        jComboBox1.setEnabled(true);
        jSpinner1.setEnabled(true);
        jButton9.setEnabled(true);
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true); 
        jTextField6.setEnabled(true);
        jTextField7.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextField9.setEnabled(true);
        jTextField10.setEnabled(true);
        jTextField11.setEnabled(true);
        jTextField12.setEnabled(true);
        jTextField13.setEnabled(true);
        jTextField14.setEnabled(true);
        jTextField15.setEnabled(true);
        jTextField16.setEnabled(true);
        jLabel21.setText("");
        jLabel21.setSize(100, 90);
        ImageIcon imagen = new ImageIcon("imagenes/libros.jpg");
        ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(jLabel21.getWidth(), jLabel21.getHeight(), 1));
        jLabel21.setIcon(imgRedimensionada);
        consultaPublicaciones();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    //Boton volver
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        /**Boton Volver */
        GestionPublicacion.guardarDatos();
        VentanaEleccion ve = new VentanaEleccion();
        ve.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    //Boton limpiar, deja todo en blanco
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        /**Boton limpiar, limpia todas los jTextField */
        limpiar();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /** Boton de accion "Confirmar" "Baja" "Confirmar modificación"*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        /**Boton de acción */
        if(jComboBox2.getSelectedItem().equals("Alta")){
        boolean compcampos= true;
        String codigo="";
        String isbn ="";
        String titulo="";
        String autor ="";
        Date fecha;
        String fotografia = "";
        int paginas = 0;
        String coleccion = "";
        String materia = "";
        String observaciones = "";
        String var1 = "";
        String var2 = "";
        String var3 = "";
        String var4 = "";
        String var5 = "";
        String var6 = "";
        try{
            if(jComboBox1.getSelectedItem().equals("Libro")){
              codigo = jTextField1.getText();
              isbn = jTextField2.getText();
              titulo = jTextField3.getText();
              autor = jTextField4.getText();
              fecha = (Date)jSpinner1.getValue();
              fotografia = jTextField6.getText();
              paginas = Integer.parseInt(jTextField7.getText());
              coleccion = jTextField8.getText();
              materia = jTextField9.getText();
              observaciones = jTextField10.getText();
              var1 = jTextField11.getText();
              var2 = jTextField12.getText();
              var3 = jTextField13.getText();
              var4 = jTextField14.getText();
              var5 = jTextField15.getText();
          
              
              Libro lib = new Libro(codigo,isbn,titulo,autor,fecha,fotografia,paginas,coleccion,materia,observaciones,var1,var2,var3,var4,var5);
              GestionPublicacion.altaPublicaciones(lib);
              GestionPublicacion.guardarDatos();
              JOptionPane.showMessageDialog(this, "La publicación (Libro)  ha sido dada de alta: \n" + lib.toString(), "Alta publicación", JOptionPane.INFORMATION_MESSAGE);
              limpiar();
              }
            if(jComboBox1.getSelectedItem().equals("Revistas")){
              int aux1 = 0;
              int aux2 = 0;
              int aux3 = 0;
              codigo = jTextField1.getText();
              isbn = jTextField2.getText();
              titulo = jTextField3.getText();
              autor = jTextField4.getText();
              fecha = (Date)jSpinner1.getValue();
              fotografia = jTextField6.getText();
              paginas = Integer.parseInt(jTextField7.getText());
              coleccion = jTextField8.getText();
              materia = jTextField9.getText();
              observaciones = jTextField10.getText();
              var1 = jTextField11.getText();
              aux1 = Integer.parseInt(jTextField12.getText());
              aux2 = Integer.parseInt(jTextField13.getText());
              aux3 = Integer.parseInt(jTextField14.getText());
              var5 = jTextField15.getText();
              Revistas rev = new Revistas(codigo,isbn,titulo,autor,fecha,fotografia,paginas,coleccion,materia,observaciones,var1,aux1,aux2,aux3,var5);
              GestionPublicacion.altaPublicaciones(rev);
              GestionPublicacion.guardarDatos();
              JOptionPane.showMessageDialog(this, "La publicación (Revista)  ha sido dada de alta: \n" + rev.toString(), "Alta publicación", JOptionPane.INFORMATION_MESSAGE);
              limpiar();
            }
            if(jComboBox1.getSelectedItem().equals("Proyectos")){
              double aux1 = 0.0;
              codigo = jTextField1.getText();
              isbn = jTextField2.getText();
              titulo = jTextField3.getText();
              autor = jTextField4.getText();
              fecha = (Date)jSpinner1.getValue();
              fotografia = jTextField6.getText();
              paginas = Integer.parseInt(jTextField7.getText());
              coleccion = jTextField8.getText();
              materia = jTextField9.getText();
              observaciones = jTextField10.getText();
              var1 = jTextField11.getText();
              var2 = jTextField12.getText();
              var3 = jTextField13.getText();
              aux1 = Double.parseDouble(jTextField14.getText());
              var5 = jTextField15.getText();
              var6 = jTextField16.getText();
              
              Proyectos pro = new Proyectos(codigo,isbn,titulo,autor,fecha,fotografia,paginas,coleccion,materia,observaciones,var1,var2,var3,aux1,var5, var6);
              GestionPublicacion.altaPublicaciones(pro);
              GestionPublicacion.guardarDatos(); 
              JOptionPane.showMessageDialog(this, "La publicación (Proyecto)  ha sido dada de alta: \n" + pro.toString(), "Alta publicación", JOptionPane.INFORMATION_MESSAGE);
              limpiar();
            }
            if(jComboBox1.getSelectedItem().equals("Tesis")){
              double aux1 = 0.0;
              codigo = jTextField1.getText();
              isbn = jTextField2.getText();
              titulo = jTextField3.getText();
              autor = jTextField4.getText();
              fecha = (Date)jSpinner1.getValue();
              fotografia = jTextField6.getText();
              paginas = Integer.parseInt(jTextField7.getText());
              coleccion = jTextField8.getText();
              materia = jTextField9.getText();
              observaciones = jTextField10.getText();
              var1 = jTextField11.getText();
              var2 = jTextField12.getText();
              var3 = jTextField13.getText();
              aux1 = Double.parseDouble(jTextField14.getText());
              var5 = jTextField15.getText();
              var6 = jTextField16.getText();
              
              Tesis tes = new Tesis(codigo,isbn,titulo,autor,fecha,fotografia,paginas,coleccion,materia,observaciones,var1,var2,var3,aux1,var5, var6);
              GestionPublicacion.altaPublicaciones(tes);
              GestionPublicacion.guardarDatos();
              JOptionPane.showMessageDialog(this, "La publicación (Tesis) ha sido dada de alta: \n" + tes.toString(), "Alta publicación", JOptionPane.INFORMATION_MESSAGE);
              limpiar();
            }
        }
        catch(Exception IOE){
            JOptionPane.showMessageDialog(this, "No ha sido posible dar de alta la publicacion.Compruebe todos los datos.", "Alta publicacion", JOptionPane.ERROR_MESSAGE);
         System.out.println("Error al introducir la publicacion: \n" + IOE.toString());
        }
        }
        
        //** Baja */
         if(jComboBox2.getSelectedItem().equals("Consulta")){
             /**Baja publicación */
             try{
             String comprobacion ="";
             comprobacion = jTextField1.getText();
             int n = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea dar de baja la publicación?", "Baja publicación", JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION){
             if(GestionPublicacion.consultaPublicaciones(comprobacion)) { 
                GestionPublicacion.bajaPublicaciones(objpub);
                limpiar();
                GestionPublicacion.guardarDatos();
                JOptionPane.showMessageDialog(this, "La publicación con código "+ comprobacion +" se ha dado de baja", "Baja publicaciones", JOptionPane.INFORMATION_MESSAGE);
            
            } else {
                JOptionPane.showMessageDialog(this, "Error al dar de baja la publicación", "Baja publicaciones", JOptionPane.INFORMATION_MESSAGE);
             }
   
            
            }
             }
             catch(Exception IOE){
                 JOptionPane.showMessageDialog(this, "Se ha producido un error al dar de baja la publicación", "Baja publicaciones", JOptionPane.ERROR_MESSAGE);
             }
            
         }
         
    /**Modificación  */
         if(jComboBox2.getSelectedItem().equals("Modificacion")){
        boolean compcampos= true;
        
        String codigo="";
        String isbn ="";
        String titulo="";
        String autor ="";
        Date fecha;
        String fotografia = "";
        int paginas = 0;
        String coleccion = "";
        String materia = "";
        String observaciones = "";
        String var1 = "";
        String var2 = "";
        String var3 = "";
        String var4 = "";
        String var5 = "";
        String var6 = "";
       int pos = publicaciones.indexOf(objpub);
        try{
            if(jComboBox1.getSelectedItem().equals("Libro")){
              codigo = jTextField1.getText();
              isbn = jTextField2.getText();
              titulo = jTextField3.getText();
              autor = jTextField4.getText();
              fecha = (Date)jSpinner1.getValue();
              fotografia = jTextField6.getText();
              paginas = Integer.parseInt(jTextField7.getText());
              coleccion = jTextField8.getText();
              materia = jTextField9.getText();
              observaciones = jTextField10.getText();
              var1 = jTextField11.getText();
              var2 = jTextField12.getText();
              var3 = jTextField13.getText();
              var4 = jTextField14.getText();
              var5 = jTextField15.getText();
              var6 = jTextField16.getText();
              Libro lib = new Libro(codigo,isbn,titulo,autor,fecha,fotografia,paginas,coleccion,materia,observaciones,var1,var2,var3,var4,var5); 
              GestionPublicacion.modificaPublicaciones(pos, lib);
              GestionPublicacion.guardarDatos();
              JOptionPane.showMessageDialog(this, "La publicación (Libro)  ha sido modificada: \n"+ lib.toString(), "Modificacion publicación", JOptionPane.INFORMATION_MESSAGE);
              limpiar();
              }
            if(jComboBox1.getSelectedItem().equals("Revistas")){
              int aux1 = 0;
              int aux2 = 0;
              int aux3 = 0;
              codigo = jTextField1.getText();
              isbn = jTextField2.getText();
              titulo = jTextField3.getText();
              autor = jTextField4.getText();
              fecha = (Date)jSpinner1.getValue();
              fotografia = jTextField6.getText();
              paginas = Integer.parseInt(jTextField7.getText());
              coleccion = jTextField8.getText();
              materia = jTextField9.getText();
              observaciones = jTextField10.getText();
              var1 = jTextField11.getText();
              aux1 = Integer.parseInt(jTextField12.getText());
              aux2 = Integer.parseInt(jTextField13.getText());
              aux3 = Integer.parseInt(jTextField14.getText());
              var5 = jTextField15.getText();
              Revistas rev = new Revistas(codigo,isbn,titulo,autor,fecha,fotografia,paginas,coleccion,materia,observaciones,var1,aux1,aux2,aux3,var5);
              
              GestionPublicacion.modificaPublicaciones(pos, rev);
              GestionPublicacion.guardarDatos();
              JOptionPane.showMessageDialog(this, "La publicación (Revista)  ha sido modificada: \n" + rev.toString(), "Modificación publicación", JOptionPane.INFORMATION_MESSAGE);
              limpiar();
            }
            if(jComboBox1.getSelectedItem().equals("Proyectos")){
              double aux1 = 0.0;
              codigo = jTextField1.getText();
              isbn = jTextField2.getText();
              titulo = jTextField3.getText();
              autor = jTextField4.getText();
              fecha = (Date)jSpinner1.getValue();
              fotografia = jTextField6.getText();
              paginas = Integer.parseInt(jTextField7.getText());
              coleccion = jTextField8.getText();
              materia = jTextField9.getText();
              observaciones = jTextField10.getText();
              var1 = jTextField11.getText();
              var2 = jTextField12.getText();
              var3 = jTextField13.getText();
              aux1 = Double.parseDouble(jTextField14.getText());
              var5 = jTextField15.getText();
              var6 = jTextField16.getText();
              
              Proyectos pro = new Proyectos(codigo,isbn,titulo,autor,fecha,fotografia,paginas,coleccion,materia,observaciones,var1,var2,var3,aux1,var5, var6);
              GestionPublicacion.modificaPublicaciones(pos, pro);
              GestionPublicacion.guardarDatos();
              JOptionPane.showMessageDialog(this, "La publicación (Proyecto)  ha sido modificada: \n" + pro.toString(), "Modificación publicación", JOptionPane.INFORMATION_MESSAGE);
              limpiar();
            }
            if(jComboBox1.getSelectedItem().equals("Tesis")){
              double aux1 = 0.0;
              codigo = jTextField1.getText();
              isbn = jTextField2.getText();
              titulo = jTextField3.getText();
              autor = jTextField4.getText();
              fecha = (Date)jSpinner1.getValue();
              fotografia = jTextField6.getText();
              paginas = Integer.parseInt(jTextField7.getText());
              coleccion = jTextField8.getText();
              materia = jTextField9.getText();
              observaciones = jTextField10.getText();
              var1 = jTextField11.getText();
              var2 = jTextField12.getText();
              var3 = jTextField13.getText();
              aux1 = Double.parseDouble(jTextField14.getText());
              var5 = jTextField15.getText();
              var6 = jTextField16.getText();
              
              Tesis tes = new Tesis(codigo,isbn,titulo,autor,fecha,fotografia,paginas,coleccion,materia,observaciones,var1,var2,var3,aux1,var5, var6);
              GestionPublicacion.modificaPublicaciones(pos, tes);
              GestionPublicacion.guardarDatos();
              JOptionPane.showMessageDialog(this, "La publicación (Tesis) ha sido modificada: \n" + tes.toString(), "Modificación publicación", JOptionPane.INFORMATION_MESSAGE);
              limpiar();
            }
            }
        catch(Exception IOE){
            JOptionPane.showMessageDialog(this, "No ha sido posible modificar la publicacion.Compruebe todos los datos.", "Modificación publicacion", JOptionPane.ERROR_MESSAGE);
         System.out.println("Error al introducir la publicacion: \n" + IOE.toString());
        }
             
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    //Boton Siguiente en la consulta de elementos
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        /**Boton siguiente , para mostrar mas publicaciones */
        if (li.hasNext()) {
            objpub = (Publicaciones) li.next();
            if (objpub != null) {
                presenta(objpub);
            } else {
                JOptionPane.showMessageDialog(this, "No hay mas publicaciones.", "Consulta publicaciones", JOptionPane.INFORMATION_MESSAGE);
            }
        }   
        
    }//GEN-LAST:event_jButton6ActionPerformed

    //Boton anterior en la consulta de elementos
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // {Boton anterior}
         /**Boton anterior , para mostrar mas publicaciones */
         if (li.hasPrevious()) {
            objpub = (Publicaciones) li.previous();
            if (objpub != null) {
                presenta(objpub);
            } else {
                JOptionPane.showMessageDialog(this, "No hay mas publicaciones.", "Consulta publicaciones", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    
    /**Boton para seleccionar imagen (File chooser) */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        cargarImagen();
        
        
    }//GEN-LAST:event_jButton9ActionPerformed
  /**Abre la ventana de devolución */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
       if(GestionPublicacion.consultaPrestamos()==false){
       VentanaGestionDevolucion vgd = new VentanaGestionDevolucion();
       vgd.setVisible(true);
       GestionPublicacion.guardarDatos();
        this.dispose();
       }
       else{
       JOptionPane.showMessageDialog(this, "Actualmente no existe ningún préstamo", "Préstamos", JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_jButton8ActionPerformed
   //**Boton para realizar el préstamo, abre una dialago para insetar el socio  */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try{
        String respuesta = JOptionPane.showInputDialog(this, "Indica el número del socio:").toUpperCase();
        if(GestionUsuario.consultaSocio(respuesta) == true){
            try{
            Persona per = GestionUsuario.recuperarSocio(respuesta);
            GestionPublicacion.prestamoPublicacion(objpub, per);
            Prestamo pres = GestionPublicacion.consultaPrestamoPres(per.getCodigo_socio());
            GestionPublicacion.guardarDatosPrestamo();
            JOptionPane.showMessageDialog(this, "El préstamo se ha realizado: " + pres.toString(), "Préstamo", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception IOE){
             JOptionPane.showMessageDialog(this, "Error al prestar la publicacion", "Préstamo", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
         JOptionPane.showMessageDialog(this, "Usuario no valido.", "Préstamo", JOptionPane.ERROR_MESSAGE);
        }
        }
        catch(Exception IOE){
            System.out.println("Ha dado a cancelar");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /** Método para cargar imagenes */
    private void cargarImagen(){
  
         JFileChooser fc = new JFileChooser(".");
         FileFilter filter1 = new CargarImagen("JPG and JPEG", new String[] { "JPG", "JPEG" });
         fc.setFileFilter(filter1);
         int returnVal= fc.showOpenDialog(this);
       
        if(returnVal == JFileChooser.APPROVE_OPTION){
             try{
             File selectedFile = fc.getSelectedFile();
             this.jTextField6.setText(selectedFile.toString());
             fc.transferFocus();
             jLabel21.setSize(100, 90);
            ImageIcon imagen = new ImageIcon(jTextField6.getText());
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(jLabel21.getWidth(), jLabel21.getHeight(), 1));
            jLabel21.setIcon(imgRedimensionada);
             }
             catch(Exception IOE){
              JOptionPane.showMessageDialog(this, "Error al cargar una imagen.", "Cargar imagenes", JOptionPane.ERROR_MESSAGE);
                 System.out.println("Error cargar imagen()" + IOE.toString() );
             }
         }
        else{
           
        JOptionPane.showMessageDialog(this, "Error al cargar una imagen.", "Cargar imagenes", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void VentanaGestionPublicaciones(String args[]) {
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
            java.util.logging.Logger.getLogger(VentanaGestionPublicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionPublicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionPublicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionPublicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaGestionPublicaciones().setVisible(true);
             
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
