
package schoolautomationsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;


public class MarkSheet extends JPanel{
    JButton closeB;
    JPanel bodyP;
    JTable table;
    
    public MarkSheet() {
    }
    
    void design(MainFrame f){
        
        renew();
        
        setBounds(f.x*20,7, f.x*60, f.y*95);
        setBackground(Color.gray);
        setLayout(null);
        setBorder(new LineBorder(Color.YELLOW, 4, true));
        
        int x=getWidth()/100,y=7;
        
        JButton print=new JButton("Print");
        print.setBounds(x*7, y*93, getWidth()-(x*14), y*2);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Print(bodyP);
            }
        });
        
        add(print);
        add(closeB);
        add(bodyP);
        
        System.out.println("schoolautomationsystem.MarkSheet.design() x and y "+x+" "+y);
        
        closeB.setBounds(0, 0, x*10, y*3);
        
            closeB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    f.teacherP.scrPan.setVisible(true);
                    f.teacherP.container.setBackground(Color.white);
                }
            });
            
            bodyP.setBounds(x*7, y*3, getWidth()-(x*14), y*90);
            bodyP.setLayout(null);
            bodyP.setBackground(Color.white);
            bodyP.setBorder(new LineBorder(Color.blue, 3, true));
            
            String str="";
            str="Class"+" "+f.teacherP.activeClass+" Examination Detailed Marksheet of Term "+f.teacherP.term;
            LocalDate date=LocalDate.now();
            
            JLabel symbolL=new JLabel();
            symbolL.setBounds(x*5, y, x*20, y*10);
            symbolL.setOpaque(true);
            
            JLabel headingL=new JLabel("<html> <pre><b><i> <font style=\"font-size:20;color:#2f3c7e;\">     R.V School<br>"
                    + "<font style=\"font-size:10;color:#2f3c7e;\">"+str+"<br><font style=\"font-size:15;color:#2f3c7e;\">       "+date.toString());
            headingL.setBounds(x*30, 0, x*42, y*12);
            
            JLabel dpL=new JLabel();
            dpL.setBounds(x*75, y, x*22, y*10);
            
            
            int rolno=f.teacherP.selClaRolNo;
            int clas=Integer.parseInt(f.teacherP.activeClass);
            int sid=0;
            int term=f.teacherP.term;
            String name="no name";
            String dpS="";
            
            try{
                MyConnection conn=new MyConnection();
                conn.pre_s=conn.conn.prepareStatement("select Id,StudentFirstName,StudentLastName,DOB,"
                        + "Fname,Image from studentname where CourseId=? and Class_Rn=?");
                conn.pre_s.setInt(1,clas );
                conn.pre_s.setInt(2,rolno );
                conn.r_set=conn.pre_s.executeQuery();
                while(conn.r_set.next()){
                    sid=conn.r_set.getInt(1);
                    name=conn.r_set.getString(2)+" "+conn.r_set.getString(3);
                    dpS=conn.r_set.getString(6);
                    System.out.println("sid name "+sid+" "+name);
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex, "select studname", 0);
            }
            
            File fstr=new File(dpS);
            
            try {
                dpL.setIcon(new ImageIcon(ImageIO.read(fstr).getScaledInstance(dpL.getWidth(), dpL.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex, "dpL.setIcon", 0);
            }
            
            JPanel infoP=new JPanel();
            infoP.setBounds(x*15, y*12, x*70, y*12);
            infoP.setLayout(null);
            infoP.setOpaque(false);
            infoP.setBackground(Color.white);
                
                JLabel idL=new JLabel("<html><pre><font style=\"color:#2f3c7e\">Id:   <font style=\"color:#000000\">"+sid);
                idL.setBounds(0, 0, x*12, y*2);
                JLabel nameL=new JLabel("<html><pre><font style=\"color:#2f3c7e\">Name:   <font style=\"color:#000000\">"+name);
                nameL.setBounds(0, y*2, x*70, y*2);
                JLabel classL=new JLabel("<html><pre><font style=\"color:#2f3c7e\">Class:  <font style=\"color:#000000\">"+clas);
                classL.setBounds(0, y*4, x*12, y*2);
                JLabel rollnoL=new JLabel("<html><pre><font style=\"color:#2f3c7e\">Roll No:   <font style=\"color:#000000\">"+rolno);
                rollnoL.setBounds(0, y*6, x*12, y*6);
                
            infoP.add(idL);
            infoP.add(nameL);
            infoP.add(classL);
            infoP.add(rollnoL);
            
            int row=0;
            
            try{
                MyConnection conn=new MyConnection();
                conn.pre_s=conn.conn.prepareStatement("select count(Name) from subjects where CourseId=?");
                conn.pre_s.setInt(1, clas);
                conn.r_set=conn.pre_s.executeQuery();
                while(conn.r_set.next()){
                    row=conn.r_set.getInt(1);
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex, "select count(Name)", 0);
            }
            
            table =new JTable(11,5){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
            for(int i=0,j=1;i<row;i++,j++){
                table.setValueAt(j, i, 0);
            }
            
            try{
                MyConnection conn=new MyConnection();
                conn.pre_s=conn.conn.prepareStatement("select Name,MaxMarks from subjects where CourseId=?");
                conn.pre_s.setInt(1, clas);
                conn.r_set=conn.pre_s.executeQuery();
                int r=0;
                while(conn.r_set.next()){
                    table.setValueAt(conn.r_set.getString(1), r, 1);
                    table.setValueAt(conn.r_set.getInt(2), r, 3);
                    r++;
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex, "select Name,MaxMarks", 0);
            }
            
            int sum=0;
            
            try{
                MyConnection conn=new MyConnection();
                conn.pre_s=conn.conn.prepareStatement("select S_Id,Sub_Id,Marks from marks where Term=? and S_Id=? ;");
                conn.pre_s.setInt(1, term);
                conn.pre_s.setInt(2, sid);
                conn.r_set=conn.pre_s.executeQuery();
                int r=0;
                while(conn.r_set.next()){
                    table.setValueAt(conn.r_set.getInt(3), r, 2);
                    table.setValueAt(conn.r_set.getInt(3), r, 4);
                    sum=sum+conn.r_set.getInt(3);
                    r++;
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex, "select S_Id,Sub_Id", 0);
            }
            
            table.setValueAt("Total Marks ", 10, 0);
            table.setValueAt(sum, 10, 3);
            
            JScrollPane resultP=new JScrollPane();
            //resultP.setLayout(null);
            resultP.setBounds(x*10, y*24, x*80, y*50);
            resultP.setViewportView(table);
            resultP.setViewportBorder(null);
            resultP.getViewport().setBorder(null);
            resultP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            
            
            table.getColumnModel().getColumn(0).setHeaderValue("Sr No.");
            table.getColumnModel().getColumn(1).setHeaderValue("Subject");
            table.getColumnModel().getColumn(2).setHeaderValue("Marks Obtained");
            table.getColumnModel().getColumn(3).setHeaderValue("Max Marks");
            table.getColumnModel().getColumn(4).setHeaderValue("Over All Marks");
                       
            table.getTableHeader().setBackground(new Color(32,134,203));
            table.setShowVerticalLines(false);
            table.setSelectionForeground(Color.white);
            table.setSelectionBackground(new Color(255, 61, 50));
            table.getTableHeader().setForeground(Color.white);
            table.setRowHeight(29);
            table.setIntercellSpacing(new Dimension(0, 0));
            
            DefaultTableCellRenderer centerRen=f.teacherP.centerRen;
            
            table.getColumnModel().getColumn(0).setCellRenderer(centerRen);
            table.getColumnModel().getColumn(1).setCellRenderer(centerRen);
            table.getColumnModel().getColumn(2).setCellRenderer(centerRen);
            table.getColumnModel().getColumn(3).setCellRenderer(centerRen);
            table.getColumnModel().getColumn(4).setCellRenderer(centerRen);
                
                TableColumn column=table.getColumnModel().getColumn(0);
                column.setMinWidth(50);
                column.setMaxWidth(50);
                column.setPreferredWidth(30);                
                
                column=table.getColumnModel().getColumn(2);
                column.setMinWidth(90);
                column.setMaxWidth(90);
                column.setPreferredWidth(90);
                
                column=table.getColumnModel().getColumn(3);
                column.setMinWidth(80);
                column.setMaxWidth(80);
                column.setPreferredWidth(80);
                
                column=table.getColumnModel().getColumn(4);
                column.setMinWidth(80);
                column.setMaxWidth(80);
                column.setPreferredWidth(30);
                
            JPanel line=new JPanel();
            line.setBounds(x*2, y*82-3, bodyP.getWidth()-(x*4), 2);
            line.setBackground(Color.lightGray);
                
            JLabel endDetL=new JLabel("<html><pre> RESULT:    : Total Marks Obtained: ");
            endDetL.setBounds(x*2, y*82, bodyP.getWidth()-(x*2), y*3);
            
            JLabel signL=new JLabel("<html><b> Teacher Incharge (Examination) ");
            signL.setBounds(x*70, y*85, x*10, y*3);
            
            
            bodyP.add(symbolL);
            bodyP.add(headingL);
            bodyP.add(dpL);
            bodyP.add(infoP);
            bodyP.add(resultP);
            bodyP.add(line);
            bodyP.add(endDetL);
            bodyP.add(signL);
    }
    
    void renew(){
        closeB=new JButton("<html> <Font style=\"font-size:20;\">X");
        bodyP=new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d=(Graphics2D) g;
                //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp=new GradientPaint(0, getHeight(), new Color(255,255,255),
                        getWidth()/2, getHeight()/2,new Color(251,234,235),false);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
            
        };
        table=new JTable();
    }
    
}
