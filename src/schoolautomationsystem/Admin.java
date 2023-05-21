package schoolautomationsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.JXDatePicker;

public class Admin extends JPanel{
    
    JPanel upperLineP;
    JPanel sideP;
    JPanel bodyP;
    
    JPanel actRepP;
        JScrollPane dataSP;
        JTable dataT;
        JLabel totalL;
    JPanel ediCouP;
    JPanel teaaloP;
        DefaultTableCellRenderer centerRen;
        JTable teaaloT;
        
        int coun=1;
    
    public Admin() {
    }
    
    void design(MainFrame f){
        
        f.adminV=1;
        
        renew();
        
        add(upperLineP);
        add(sideP);
        add(bodyP);
        
        f.setBounds(0, 0,f.width, f.height);
        
        setBounds(0, 0,f.width, f.height);
        setBackground(Color.white);
        setVisible(true);
        setLayout(null);
        
        int x=getWidth()/100 , y=getHeight()/100;
        
        upperLineP.setBounds(x*10, 0, getWidth(), y);
        upperLineP.setBackground(Color.blue);
        desSideP(f, x, y);
        desBodyP(f, x, y);
        
        
    }
    
    void desBodyP(MainFrame f,int x,int y){
        bodyP.setBounds(x*10, y, x*100, getHeight());
        bodyP.setLayout(null);
        desActRep(f, x, y);
        desEdiCou(f, x, y);
        desteaaloP(f, x, y);
            
        bodyP.add(actRepP);
        bodyP.add(ediCouP);
        bodyP.add(teaaloP);
    }
    
    void desActRep(MainFrame f,int x,int y){
        actRepP.setLayout(null);
        actRepP.setBackground(Color.red);
        actRepP.setBounds(0, 0, bodyP.getWidth(), bodyP.getHeight());
            JPanel uppP=new JPanel();
            uppP.setBackground(Color.white);
            uppP.setLayout(null);
            uppP.setBounds(0, 0, bodyP.getWidth(), y*3);
                JLabel staDatL=new JLabel("<html> <pre>Select Date     FROM");
                staDatL.setBounds(0, 0, x*15, uppP.getHeight());
                
                JXDatePicker staDat=new JXDatePicker();
                staDat.setBounds(x*17, 0, x*15, uppP.getHeight());
                
                JLabel endDatL=new JLabel("<html> <pre>To");
                endDatL.setBounds(x*35, 0, x*4, uppP.getHeight());
                
                JXDatePicker endDat=new JXDatePicker();
                endDat.setBounds(x*40, 0, x*15, uppP.getHeight());
                
                JButton getDataAccToDate=new JButton("Get Details");
                getDataAccToDate.setBounds(x*57, 0, x*10, uppP.getHeight());
                getDataAccToDate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        dataT =new JTable(100,7){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        
                        tableContent(dataT);
                        
                        DateModifier datMod=new DateModifier();
                        String staDatS=datMod.convert(staDat);
                        String endDatS=datMod.convert(endDat);
                        if(staDat.getDate().after(endDat.getDate())){
                            JOptionPane.showMessageDialog(null, "Please Select Date in Order", "Selected Date", 0);
                        }else{
                            System.out.println("start "+staDatS+" end "+endDatS);
                            try{
                                int sum=0;
                                MyConnection conn=new MyConnection();
                                conn.pre_s=conn.conn.prepareStatement("SELECT * FROM receipt where "
                                        + "ReceiptDate between cast(? as date) and cast(? as date);");
                                conn.pre_s.setString(1, staDatS);
                                conn.pre_s.setString(2, endDatS);
                                conn.r_set=conn.pre_s.executeQuery();
                                int row=0;
                                int srno=row+1;
                                while(conn.r_set.next()){
                                    
                                    dataT.setValueAt(srno, row, 0);
                                    dataT.setValueAt(conn.r_set.getInt(2), row, 2);
                                    dataT.setValueAt(conn.r_set.getInt(3), row, 3);
                                    dataT.setValueAt(conn.r_set.getInt(5), row, 4);
                                    dataT.setValueAt(conn.r_set.getString(6), row, 5);
                                    dataT.setValueAt(conn.r_set.getDate(4), row, 6);
                                    
                                    sum+=conn.r_set.getInt(5);
                                    totalL.setText("Total= "+sum);
                                    
                                    try{
                                        MyConnection conn1=new MyConnection();
                                        conn1.pre_s=conn1.conn.prepareStatement("Select StudentFirstName,StudentLastName "
                                                + "from studentname where CourseId=? and Class_rn=?");
                                        conn1.pre_s.setInt(1, conn.r_set.getInt(2));
                                        conn1.pre_s.setInt(2, conn.r_set.getInt(3));
                                        conn1.r_set=conn1.pre_s.executeQuery();
                                        while(conn1.r_set.next()){
                                            dataT.setValueAt(conn1.r_set.getString(1)+" "+conn1.r_set.getString(2), row, 1);
                                        }
                                    }catch(SQLException ex){
                                        JOptionPane.showMessageDialog(null, "select * from receipt", "fetching receipt data", 0);
                                    }
                                    
                                    row++;
                                    srno++;
                                }
                                System.out.println("row= "+row+" --row= "+ --row);
                                totalL.setText("Total= "+sum);
                            }catch(SQLException ex){
                                JOptionPane.showMessageDialog(null, "select * from receipt", "fetching receipt data", 0);
                            } 
                        }
                    }
                });
                
                JButton getAllDetBut=new JButton("Fetch All Record");
                getAllDetBut.setBounds(x*69, 0, x*10, uppP.getHeight());
                getAllDetBut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                                int sum=0;
                                MyConnection conn=new MyConnection();
                                conn.pre_s=conn.conn.prepareStatement("SELECT * FROM receipt ;");
                                conn.r_set=conn.pre_s.executeQuery();
                                int row=0;
                                int srno=row+1;
                                while(conn.r_set.next()){
                                    
                                    dataT.setValueAt(srno, row, 0);
                                    dataT.setValueAt(conn.r_set.getInt(2), row, 2);
                                    dataT.setValueAt(conn.r_set.getInt(3), row, 3);
                                    dataT.setValueAt(conn.r_set.getInt(5), row, 4);
                                    dataT.setValueAt(conn.r_set.getString(6), row, 5);
                                    dataT.setValueAt(conn.r_set.getDate(4), row, 6);
                                    sum+=conn.r_set.getInt(5);
                                    
                                    
                                    try{
                                        MyConnection conn1=new MyConnection();
                                        conn1.pre_s=conn1.conn.prepareStatement("Select StudentFirstName,StudentLastName "
                                                + "from studentname where CourseId=? and Class_rn=?");
                                        conn1.pre_s.setInt(1, conn.r_set.getInt(2));
                                        conn1.pre_s.setInt(2, conn.r_set.getInt(3));
                                        conn1.r_set=conn1.pre_s.executeQuery();
                                        while(conn1.r_set.next()){
                                            dataT.setValueAt(conn1.r_set.getString(1)+" "+conn1.r_set.getString(2), row, 1);
                                        }
                                    }catch(SQLException ex){
                                        JOptionPane.showMessageDialog(null, "select * from receipt", "fetching receipt data", 0);
                                    }
                                    
                                    row++;
                                    srno++;
                                }
                                totalL.setText("Total= "+sum);
                                //System.out.println("row= "+row+" --row= "+ --row);
                                
                            }catch(SQLException ex){
                                JOptionPane.showMessageDialog(null, "select * from receipt", "fetching receipt data", 0);
                            }
                    }
                });
                
                
                totalL.setBounds(x*80, 0, x*10, uppP.getHeight());
                
            uppP.add(staDatL);
            uppP.add(staDat);
            uppP.add(endDatL);
            uppP.add(endDat);
            uppP.add(getDataAccToDate);
            uppP.add(getAllDetBut);
            uppP.add(totalL);
            
            dataSP.setBounds(0, y*3, x*95, y*90);
            dataSP.setViewportView(dataT);
            
            JPanel bottomP=new JPanel();
                bottomP.setBounds(0, y*93, x*95, y*5);
                bottomP.setLayout(new GridLayout(1, 3));
                JButton print=new JButton("<html> <font style=\"font-size:10\">Print");
                print.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MessageFormat header=new MessageFormat("Page {0,number,integer}");
                        try {
                            dataT.print(JTable.PrintMode.FIT_WIDTH, header, null);
                        } catch (PrinterException ex) {
                            JOptionPane.showMessageDialog(null, "Printin is not done", "Printing Error", 0);
                        }
                    }
                });
                
            bottomP.add(print);
            
        actRepP.add(uppP);
        actRepP.add(dataSP);
        actRepP.add(bottomP);
        
        LocalDate date=LocalDate.now();
        System.out.println("date= "+date.toString());
        
        dataT = new JTable(100, 7) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        try {
            MyConnection conn = new MyConnection();
            conn.pre_s = conn.conn.prepareStatement("SELECT * FROM receipt where "
                    + "ReceiptDate =cast(? as date)");
            conn.pre_s.setString(1, date.toString());
            conn.r_set = conn.pre_s.executeQuery();
            int row = 0,sum=0;
            int srno=row+1;
            while (conn.r_set.next()) {
                
                dataT.setValueAt(srno, row, 0);
                dataT.setValueAt(conn.r_set.getInt(2), row, 2);
                dataT.setValueAt(conn.r_set.getInt(3), row, 3);
                dataT.setValueAt(conn.r_set.getInt(5), row, 4);
                dataT.setValueAt(conn.r_set.getString(6), row, 5);
                dataT.setValueAt(conn.r_set.getDate(4), row, 6);
                
                sum+=conn.r_set.getInt(5);
                totalL.setText("Total= "+sum);

                try {
                    MyConnection conn1 = new MyConnection();
                    conn1.pre_s = conn1.conn.prepareStatement("Select StudentFirstName,StudentLastName "
                            + "from studentname where CourseId=? and Class_rn=?");
                    conn1.pre_s.setInt(1, conn.r_set.getInt(2));
                    conn1.pre_s.setInt(2, conn.r_set.getInt(3));
                    conn1.r_set = conn1.pre_s.executeQuery();
                    while (conn1.r_set.next()) {
                        dataT.setValueAt(conn1.r_set.getString(1) + " " + conn1.r_set.getString(2), row, 1);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "select * from receipt", "fetching receipt data", 0);
                }

                row++;
                srno++;
            }
            System.out.println("row= " + row + " --row= " + --row);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "select * from receipt", "fetching receipt data", 0);
        }
        
        tableContent(dataT);
        
        actRepP.setVisible(false);
    }
    
    void desteaaloP(MainFrame f,int x, int y){
        teaaloP.setLayout(null);
        teaaloP.setBounds(0, 0, bodyP.getWidth(), bodyP.getHeight());
        teaaloP.setBackground(Color.white);
            JLabel head=new JLabel("<html> <font style=\"font-size:20;\">Teacher Allocation");
            head.setBounds(0, 0, teaaloP.getWidth(),y*7);
            
            teaaloT=teaaloTContent(teaaloT);
            teaaloT=teaaloTwrite(teaaloT);
            
            JScrollPane teaaloTSP=new JScrollPane();
            teaaloTSP.setViewportView(teaaloT);
            teaaloTSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            teaaloTSP.setBounds(x, y*8, teaaloP.getWidth()-(x*2), y*85);
            
            JButton updateB=new JButton("Update");
            updateB.setBounds(x, y*94, x*10, y*2);
            updateB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MyConnection uBcon=new MyConnection();
                    try{
                        uBcon.pre_s=uBcon.conn.prepareStatement("delete from teachalocation;");
                        uBcon.pre_s.execute();
                        uBcon.pre_s=uBcon.conn.prepareStatement("alter table teachalocation AUTO_INCREMENT=1;");
                        uBcon.pre_s.execute();
                        int i=0;
                        for(i=0;i<coun-1;i++){
                            uBcon.pre_s=uBcon.conn.prepareStatement("insert into teachalocation (Tid,Cid) values(?,?);");
                            System.out.println("Tid= i "+i+" "+teaaloT.getValueAt(i, 2));
                            uBcon.pre_s.setInt(1, Integer.parseInt(""+teaaloT.getValueAt(i, 2)));
                            
                            uBcon.pre_s.setInt(2, Integer.parseInt(""+teaaloT.getValueAt(i, 5)));
                            System.out.println("Cid= "+teaaloT.getValueAt(i, 5));
                            uBcon.pre_s.executeUpdate();
                        }
                        
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, "Error while deleting data in teacheralocation Table "+ex, "teaaloP()", 0);
                    };
                    
                    teaaloT=teaaloTwrite(teaaloT);
                }
            });
            
        teaaloP.add(head);
        teaaloP.add(teaaloTSP);
        teaaloP.add(updateB);
        
        teaaloP.setVisible(false);
    }
    
    JTable teaaloTwrite(JTable table){
        
        System.out.println("writing content at teaalo table");
        int r=0,c=0;
        MyConnection conn=new MyConnection();
            MyConnection mycon2=new MyConnection();
        try{
            conn.pre_s=conn.conn.prepareStatement("SELECT id,subjectpref1,subjectpref2,firstname,lastname "
                    + "FROM teacher where teachercol=\"Teacher\";");
            conn.r_set=conn.pre_s.executeQuery();
            while(conn.r_set.next()){
                c=0;
                table.setValueAt(coun,r , c);
                c++;System.out.println("1");
                table.setValueAt(""+conn.r_set.getString(4)+" "+conn.r_set.getString(5),r , c);
                c++;System.out.println("2");
                table.setValueAt(conn.r_set.getInt(1),r , c);
                c++;System.out.println("2");
                table.setValueAt(""+conn.r_set.getString(2),r , c);
                c++;System.out.println("4");
                table.setValueAt(""+conn.r_set.getString(3),r , c);
                c++;System.out.println("5");
                try{
                    
                    mycon2.pre_s=mycon2.conn.prepareStatement("SELECT Cid FROM teachalocation where Tid=?;");
                    mycon2.pre_s.setInt(1, conn.r_set.getInt(1));
                    mycon2.r_set=mycon2.pre_s.executeQuery();
                    while(mycon2.r_set.next()){
                        table.setValueAt(mycon2.r_set.getInt(1), r, c);
                        System.out.println("6"+" "+mycon2.r_set.getInt(1));
                    }
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error while fetch data from teacheralocation Table "+ex, "teaaloTWrite()", 0);
                }
                
                r++;coun++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error while fetch data from Teacher Table "+ex, "teaaloTWrite()", 0);
        } 
        return table;
    }
            
    JTable teaaloTContent(JTable table){
        int ro=0;
        System.out.println("in teaaloCintent");
        MyConnection conn=new MyConnection();
        try{
            conn.pre_s=conn.conn.prepareStatement("SELECT count(*) FROM teacher where teacherCol=\"Teacher\"");
            conn.r_set=conn.pre_s.executeQuery();
            while(conn.r_set.next()){
                ro=conn.r_set.getInt(1);
                System.out.println("row=="+ro);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error while fetch data from Teacher Table", "teaaloTContent()", 0);
        }
        
        if(ro<25){
            table=new JTable(25, 6){
                @Override
                public boolean isCellEditable(int row, int column) {
                    if(column==5){return true;}
                    return false;
                }
                
            };
        }else{
            table=new JTable(ro, 6){
                @Override
                public boolean isCellEditable(int row, int column) {
                    if(column==5){return true;}
                    return false;
                }
                
            };
        }
        
        table.getColumnModel().getColumn(0).setHeaderValue("Sr No.");
        table.getColumnModel().getColumn(1).setHeaderValue("Name");
        table.getColumnModel().getColumn(2).setHeaderValue("Id");
        table.getColumnModel().getColumn(3).setHeaderValue("Subject Preference");
        table.getColumnModel().getColumn(4).setHeaderValue("Subject Preference");
        table.getColumnModel().getColumn(5).setHeaderValue("Class Allocated");
        
        TableColumn column=table.getColumnModel().getColumn(0);
        column.setPreferredWidth(40);
        column.setMaxWidth(40);
        column.setMinWidth(40);
        
        //table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getTableHeader().setBackground(new Color(32,134,203));
        table.setShowVerticalLines(false);
        table.setSelectionForeground(Color.white);
        table.setSelectionBackground(new Color(255, 61, 50));
        table.getTableHeader().setForeground(Color.white);
        table.setRowHeight(25);
        table.setIntercellSpacing(new Dimension(0, 0));
        
        //table.getColumnModel().getColumn(1).setPreferredWidth(5);
        
        
        centerRen.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRen);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRen);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRen);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRen);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRen);
        table.getColumnModel().getColumn(5).setCellRenderer(centerRen);
        
        System.out.println("in teaaloCintent end");
        return table;
    }
    
    void desEdiCou(MainFrame f,int x,int y){
        //ediCouP.setBackground(Color.yellow);
        ediCouP.setBounds(0, 0, bodyP.getWidth(), bodyP.getHeight());
        ediCouP.setLayout(null);
        
        f.addCourseP.design(f);
        
        ediCouP.add(f.addCourseP);
        ediCouP.setVisible(false);
    }
    
    void desSideP(MainFrame f,int x,int y){
        sideP.setBounds(0,0,x*10,getHeight());
        sideP.setBackground(Color.blue);
        sideP.setLayout(new GridLayout(15,1,10,0));
        sideP.setVisible(true);
        
            JButton one=new JButton("<html> <font style=\"font-size:12;\">Activity Report");
            butDes(one);
            one.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    actRepP.setVisible(true);
                    ediCouP.setVisible(false);
                    teaaloP.setVisible(false);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    one.setForeground(Color.red);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    one.setForeground(Color.blue);
                }
            });
            
            JButton two=new JButton("<html> <font style=\"font-size:12;\">EditCourse");
            butDes(two);
            two.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    actRepP.setVisible(false);
                    ediCouP.setVisible(true);
                    f.addCourseP.setVisible(true);
                    teaaloP.setVisible(false);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    two.setForeground(Color.red);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    two.setForeground(Color.blue);
                }
            });
            
            JButton teaaloB=new JButton("<html> <font style=\"font-size:12;\">Allocation");
            butDes(teaaloB);
            teaaloB.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    actRepP.setVisible(false);
                    ediCouP.setVisible(false);
                    teaaloP.setVisible(true);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    two.setForeground(Color.red);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    two.setForeground(Color.blue);
                }
            });
            
            JButton logout=new JButton("<html> <font style=\"font-size:12;\">logout");
            butDes(logout);
            logout.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    f.login.setVisible(true);
                    f.setBounds(f.x*20, f.y*20,f.x*70 , f.y*70);
                    setVisible(false);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    logout.setForeground(Color.red);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    logout.setForeground(Color.blue);
                }
            });
            
            
            
        sideP.add(one,0);
        sideP.add(two,1);
        sideP.add(teaaloB,2);
        sideP.add(logout,3);
    }
    
    void tableContent(JTable table){
        
        table.getColumnModel().getColumn(0).setHeaderValue("Sr No.");
        table.getColumnModel().getColumn(1).setHeaderValue("Name");
        table.getColumnModel().getColumn(2).setHeaderValue("Class");
        table.getColumnModel().getColumn(3).setHeaderValue("Roll No");
        table.getColumnModel().getColumn(4).setHeaderValue("Amount");
        table.getColumnModel().getColumn(5).setHeaderValue("Reason");
        table.getColumnModel().getColumn(6).setHeaderValue("Transaction date");
        
        TableColumn column=table.getColumnModel().getColumn(0);
        column.setPreferredWidth(40);
        column.setMaxWidth(40);
        column.setMinWidth(40);
        
        
        
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getTableHeader().setBackground(new Color(32,134,203));
        table.setShowVerticalLines(false);
        table.setSelectionForeground(Color.white);
        table.setSelectionBackground(new Color(255, 61, 50));
        table.getTableHeader().setForeground(Color.white);
        table.setRowHeight(25);
        table.setIntercellSpacing(new Dimension(0, 0));
        
        //table.getColumnModel().getColumn(1).setPreferredWidth(5);
        
        DefaultTableCellRenderer centerRen=new DefaultTableCellRenderer();
        centerRen.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRen);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRen);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRen);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRen);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRen);
        table.getColumnModel().getColumn(5).setCellRenderer(centerRen);
        table.getColumnModel().getColumn(6).setCellRenderer(centerRen);
        
        dataSP.setViewportView(table);
    }
    
    void butDes(JButton but){
        but.setBackground(Color.YELLOW);
        but.setForeground(Color.blue);
    }
    
    void renew(){
        upperLineP=new JPanel();
        sideP=new JPanel();
        bodyP=new JPanel();
        actRepP=new JPanel();
            dataSP=new JScrollPane();
            dataT=new JTable(100,10);
            totalL=new JLabel("Total= :");
        ediCouP=new JPanel();
        teaaloP=new JPanel();
            teaaloT=new JTable(10,10);
            centerRen=new DefaultTableCellRenderer();
        
    }
    
}
