/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.mysql.jdbc.integration.jboss.ExtendedMysqlExceptionSorter;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author robso
 */
public class ControleRelatorios<T extends Serializable>{
    
    public void imprimirRelatorio (JDialog pai, List<T> lista, String nomeArquivo, Map params) {
        
        String arquivo = "relatorios/" + nomeArquivo + ".jasper";
        
        JRDataSource jrds = new JRBeanCollectionDataSource(lista);
        
        try {
            JDialog viewer = new JDialog(pai, "Visualização de Relatário", true);
            Insets in = Toolkit.getDefaultToolkit().getScreenInsets(viewer.getGraphicsConfiguration());
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            
            int width = d.width - (in.left + in.top);
            int height = d.height - (in.top + in.bottom);
            viewer.setSize(width, height);
            viewer.setLocationRelativeTo(pai);
            
            JasperPrint print = JasperFillManager.fillReport(arquivo, params, jrds);
            if ( !print.getPages().isEmpty()){
                JasperViewer jrViewer = new JasperViewer(print, true);
                
                jrViewer.setSize(width, height);
                viewer.getContentPane().add(jrViewer.getContentPane());
                viewer.setModal(false);
                
                viewer.setVisible(true);
                viewer.repaint();
            }else {
                JOptionPane.showMessageDialog(viewer, "Nenhuma dado á exibir");
            }
        }catch (Exception e) {
            e.printStackTrace();
    }
    }
    
}
