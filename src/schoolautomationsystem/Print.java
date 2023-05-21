package schoolautomationsystem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Print {
    
    Print(){
        
    }
    
    Print(JPanel jPanel1){
        
        PrinterJob job= PrinterJob.getPrinterJob();
        
        job.setJobName("Print Data");
        
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex){
                
                pageFormat.setOrientation(PageFormat.PORTRAIT);
                
                if(pageIndex>0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2= (Graphics2D)graphics;
                g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                g2.scale(0.489, 0.7);
                
                jPanel1.paint(g2);  
                
                return Printable.PAGE_EXISTS;
            }
        });
        
        if(job.printDialog()==false){
            return ;
        }
        
        try{
            job.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    Print(JTable table){
        
        PrinterJob job= PrinterJob.getPrinterJob();
        
        job.setJobName("Print Data");
        
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex){
                
                pageFormat.setOrientation(PageFormat.PORTRAIT);
                
                if(pageIndex>0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2= (Graphics2D)graphics;
                g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                g2.scale(0.489, 0.7);
                
                table.paint(g2);  
                
                return Printable.PAGE_EXISTS;
            }
        });
        
        if(job.printDialog()==false){
            return ;
        }
        
        try{
            job.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
