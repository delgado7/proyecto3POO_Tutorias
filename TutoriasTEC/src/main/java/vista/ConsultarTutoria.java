/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import Controlador.Controlador;
import Modelo.Tutoría;
import Modelo.Estudiante;
import Modelo.Persona;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JPRN1
 */
public class ConsultarTutoria extends javax.swing.JFrame {
    private static DefaultListModel<Tutoría> modelo = new DefaultListModel<Tutoría>();
    Controlador controlador = new Controlador();
    Estudiante estudianteActual = controlador.getEstudianteActivo();

    /**
     * Creates new form ConsultarTutoria
     */
    public ConsultarTutoria() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        escuela = new javax.swing.JComboBox<>();
        materia = new javax.swing.JComboBox<>();
        modalidad = new javax.swing.JComboBox<>();
        codigo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        atras = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tutorías TEC - Consulta tutoría");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tutorías");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Escuela");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Materia");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Modalidad");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Código");
        jLabel5.setToolTipText("");

        escuela.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Matemática", "Computación", "Cultura y deporte", "Ciencias del lenguaje", "Ciencias sociales" }));
        escuela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escuelaActionPerformed(evt);
            }
        });

        materia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "POO", "FOC", "Intro y taller", "Cálculo", "MG", "MD", "Inglés", "CE", "CO" }));
        materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materiaActionPerformed(evt);
            }
        });

        modalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Presencial", "Virtual"}));
        modalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modalidadActionPerformed(evt);
            }
        });

        codigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Item 2", "Item 3", "Item 4" }));
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        jList1.setModel(modelo);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        atras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        atras.setText("Atrás");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        confirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(escuela, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(materia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modalidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codigo, 0, 113, Short.MAX_VALUE))
                .addGap(93, 93, 93)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmar)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(atras))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(escuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(modalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(confirmar)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // TODO add your handling code here:
        MenuEstudiante menu = new MenuEstudiante();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        // TODO add your handling code here:
        String cod = jList1.getSelectedValue();
        controlador.agregarEstudianteATutoría(cod, estudianteActual);
    }//GEN-LAST:event_confirmarActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jList1MouseClicked

    private void escuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escuelaActionPerformed
        // TODO add your handling code here:
        
        String datoCodigo = codigo.getSelectedItem().toString();
        String datoEscuela = escuela.getSelectedItem().toString();
        String datoMateria = materia.getSelectedItem().toString();
        String datoModalidad = modalidad.getSelectedItem().toString();
        if(datoEscuela!=""&&datoCodigo.equals("")&&datoMateria.equals("")&&datoModalidad.equals("")){
            modelo.clear();
            ArrayList<Tutoría> listaFiltrada = new ArrayList<Tutoría>();
            listaFiltrada = controlador.getListaTutoríasPorEscuela(datoEscuela);
            modelo.addAll(listaFiltrada);
            jList1.ensureIndexIsVisible(modelo.getSize());
        } else{
            JOptionPane.showMessageDialog(this, "Error: Solo puede tener un filtro activo");
        }
    }//GEN-LAST:event_escuelaActionPerformed

    private void materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materiaActionPerformed
        // TODO add your handling code here:
        String datoCodigo = codigo.getSelectedItem().toString();
        String datoEscuela = escuela.getSelectedItem().toString();
        String datoMateria = materia.getSelectedItem().toString();
        String datoModalidad = modalidad.getSelectedItem().toString();
        if(datoEscuela.equals("")&&datoCodigo!=""&&datoMateria.equals("")&&datoModalidad.equals("")){
            modelo.clear();
            ArrayList<Tutoría> listaFiltrada = new ArrayList<Tutoría>();
            listaFiltrada = controlador.getListaTutoríasPorMateria(datoMateria);
            modelo.addAll(listaFiltrada);
            jList1.ensureIndexIsVisible(modelo.getSize());
        } else{
            JOptionPane.showMessageDialog(this, "Error: Solo puede tener un filtro activo");
        }
    }//GEN-LAST:event_materiaActionPerformed

    private void modalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modalidadActionPerformed
        // TODO add your handling code here:
        String datoCodigo = codigo.getSelectedItem().toString();
        String datoEscuela = escuela.getSelectedItem().toString();
        String datoMateria = materia.getSelectedItem().toString();
        String datoModalidad = modalidad.getSelectedItem().toString();
        if(datoEscuela.equals("")&&datoCodigo.equals("")&&datoMateria!=""&&datoModalidad.equals("")){
            modelo.clear();
            ArrayList<Tutoría> listaFiltrada = new ArrayList<Tutoría>();
            listaFiltrada = controlador.getListaTutoríasPorModalidad(datoModalidad);
            modelo.addAll(listaFiltrada);
            jList1.ensureIndexIsVisible(modelo.getSize());
        } else{
            JOptionPane.showMessageDialog(this, "Error: Solo puede tener un filtro activo");
        }
    }//GEN-LAST:event_modalidadActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
        String datoCodigo = codigo.getSelectedItem().toString();
        String datoEscuela = escuela.getSelectedItem().toString();
        String datoMateria = materia.getSelectedItem().toString();
        String datoModalidad = modalidad.getSelectedItem().toString();
        if(datoEscuela.equals("")&&datoCodigo.equals("")&&datoMateria.equals("")&&datoModalidad!=""){
            modelo.clear();
            ArrayList<Tutoría> listaFiltrada = new ArrayList<Tutoría>();
            listaFiltrada = controlador.getListaTutoríasPorCódigo(datoCodigo);
            modelo.addAll(listaFiltrada);
            jList1.ensureIndexIsVisible(modelo.getSize());
        } else{
            JOptionPane.showMessageDialog(this, "Error: Solo puede tener un filtro activo");
        }
        
    }//GEN-LAST:event_codigoActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarTutoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarTutoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarTutoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarTutoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarTutoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JComboBox<String> codigo;
    private javax.swing.JButton confirmar;
    private javax.swing.JComboBox<String> escuela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> materia;
    private javax.swing.JComboBox<String> modalidad;
    // End of variables declaration//GEN-END:variables
}
