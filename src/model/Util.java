/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author robso
 */
public class Util {

    public static Date converteStringEmDate(String data) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = (Date) formatter.parse(data);
        } catch (ParseException ex) {

        }
        return date;
    }

    public static String convertDoubleEmString_Valor(Double valor) {
        DecimalFormat formato = new DecimalFormat("##,##,###,##0.00",
                new DecimalFormatSymbols(new Locale("pt", "BR")));
        formato.setMinimumFractionDigits(2);
        formato.setParseBigDecimal(true);

        return String.valueOf(formato.format(valor));
    }

    public static DefaultTableCellRenderer alinhaDireita() {
        DefaultTableCellRenderer d = new DefaultTableCellRenderer();
        d.setHorizontalAlignment(SwingConstants.RIGHT);
        return d;
    }

    public static void larguraColunas(JTable table) {
        String iu = "";
        for (int i = 0; i < table.getColumnCount(); i++) {
            iu += "Coluna " + i + ": " + table.getColumnModel()
                    .getColumn(i).getPreferredWidth() + "\n";
        }
        JOptionPane.showMessageDialog(null, iu);
    }

    public static String dataFormatoSql(String data) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoSql = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;

        try {
            date = (Date) formatter.parse(data);
        } catch (ParseException ex) {

        }
        return formatoSql.format(date);
    }

    public static String dataFormatPadrao(Date date) {
        SimpleDateFormat fomatoSQL = new SimpleDateFormat("dd/MM/yyyy");
        return fomatoSQL.format(date);
    }

}
