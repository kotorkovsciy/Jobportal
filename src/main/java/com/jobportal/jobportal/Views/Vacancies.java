/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jobportal.jobportal.Views;
import java.util.List;

import java.io.IOException;
import org.json.JSONException;
import org.apache.http.HttpException;
import com.jobportal.jobportal.Api.modules.TokenFile;
import com.jobportal.jobportal.Api.modules.Vacancy;
import com.jobportal.jobportal.Api.modules.Responses.Vacancy.AmountResponsesResponse;
import com.jobportal.jobportal.SnowBackground;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.Graphics;

/**
 *
 * @author Ковинько Никита Владимирович ДКИП-404
 */
public class Vacancies extends javax.swing.JFrame {

    /**
     * Creates new form Vacancies
     */
    private int logoX = -200;
    private int logoY = 30;
    private Timer logoTimer;
    
    public Vacancies() {
        SnowBackground snowBackground = new SnowBackground();
        setContentPane(snowBackground);
        initComponents();

        logoTimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveLogo();
                repaint();
            }
        });
        logoTimer.start();
        
        ImageIcon image = new ImageIcon("assets/logo.jpg");
        setIconImage(image.getImage());
        setTitle("Список вакансий");
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("Вакансия");
        model.addColumn("Количество откликов");
        
        tableVacancies.setModel(model);
        tableVacancies.getColumn("ID").setMinWidth(0);
        tableVacancies.getColumn("ID").setMaxWidth(0);
        tableVacancies.getColumn("ID").setWidth(0);
        
        try {
            TokenFile token = new TokenFile();
            List<AmountResponsesResponse> amountResponses = Vacancy.getAmountResponses(token.readToken());
            for (AmountResponsesResponse response : amountResponses) {
                model.addRow(new Object[]{response.id, response.title, response.amountResponses});
            }
        } catch (IOException | JSONException | HttpException e) {
            e.printStackTrace();
        }
        
        tableVacancies.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tableVacancies.getSelectedRow();
                    if (selectedRow != -1) {
 
                        int id = (int) model.getValueAt(selectedRow, 0);
                        String title = (String) model.getValueAt(selectedRow, 1);
                        
                        VacancyResponses vacancyResponsesnewFrame = new VacancyResponses(id);
                        vacancyResponsesnewFrame.setVisible(true);
                        vacancyResponsesnewFrame.setTitle("Отклики на вакансию: " + title);
                    }
                }
            }
        });
        jScrollPane1.setViewportView(tableVacancies);
    }
    
    private void moveLogo() {
        logoX += 1;
        if (logoX > getWidth()) {
            logoX = -200;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        ImageIcon logoImage = new ImageIcon("assets/logo.jpg");
        g.drawImage(logoImage.getImage(), logoX, logoY, this);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableVacancies = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableVacancies.setColumnSelectionAllowed(false);
        tableVacancies.setEditingColumn(0);
        tableVacancies.setEditingRow(0);
        jScrollPane1.setViewportView(tableVacancies);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableVacancies;
    // End of variables declaration//GEN-END:variables
}
