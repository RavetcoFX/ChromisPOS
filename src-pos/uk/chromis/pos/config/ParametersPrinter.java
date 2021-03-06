//    Chromis POS  - The New Face of Open Source POS
//    Copyright (C) 2009 
//    http://www.chromis.co.uk
//
//    This file is part of Chromis POS
//
//     Chromis POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Chromis POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Chromis POS.  If not, see <http://www.gnu.org/licenses/>.

package uk.chromis.pos.config;

import java.awt.Component;
import uk.chromis.data.user.DirtyManager;
import uk.chromis.pos.forms.AppLocal;
import uk.chromis.pos.util.StringParser;

/**
 *
 * @author adrian
 */
public class ParametersPrinter extends javax.swing.JPanel implements ParametersConfig {

    private String othersizename = "standard";

    /** Creates new form ParametersPrinter
     * @param printernames */
    public ParametersPrinter(String [] printernames) {
        initComponents();
        
        jPrinters.addItem("(Default)");
        jPrinters.addItem("(Show dialog)");
        for (String name : printernames) {
            jPrinters.addItem(name);
        }
    }

    /**
     *
     * @return
     */
    public Component getComponent() {
        return this;
    }

    /**
     *
     * @param dirty
     */
    public void addDirtyManager(DirtyManager dirty) {
        jPrinters.addActionListener(dirty);
        jReceiptPrinter.addActionListener(dirty);
    }

    /**
     *
     * @param p
     */
    public void setParameters(StringParser p) {
        jPrinters.setSelectedItem(p.nextToken(','));
        String sizename = p.nextToken(',');
        jReceiptPrinter.setSelected("receipt".equals(sizename));
        othersizename = "receipt".equals(sizename) ? "standard" : sizename;
    }

    /**
     *
     * @return
     */
    public String getParameters() {
        return comboValue(jPrinters.getSelectedItem()) + "," + boolValue(jReceiptPrinter.isSelected());
    }

    private static String comboValue(Object value) {
        return value == null ? "" : value.toString();
    }

    private String boolValue(boolean value) {
        return value ? "receipt" : othersizename;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPrinters = new javax.swing.JComboBox();
        jReceiptPrinter = new eu.hansolo.custom.SteelCheckBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPrinters.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPrinters.setMinimumSize(new java.awt.Dimension(29, 24));
        jPrinters.setPreferredSize(new java.awt.Dimension(200, 23));
        jPrinters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrintersActionPerformed(evt);
            }
        });
        add(jPrinters, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2, -1, -1));

        jReceiptPrinter.setBorder(null);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        jReceiptPrinter.setText(bundle.getString("label.receiptprinter")); // NOI18N
        add(jReceiptPrinter, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jPrintersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrintersActionPerformed

    }//GEN-LAST:event_jPrintersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jPrinters;
    private eu.hansolo.custom.SteelCheckBox jReceiptPrinter;
    // End of variables declaration//GEN-END:variables

}
