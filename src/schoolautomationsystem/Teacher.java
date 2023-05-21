package schoolautomationsystem;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.awt.image.ImageObserver.HEIGHT;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Teacher extends JPanel{

    int Tid=0;
    JPanel sidPan;
    JLabel proPic;
    String proPicAdr="",email="";
    JLabel nameL;
    JButton logOut;
    
    JPanel container;
    JPanel coursesP;
    
    JLabel headingL;
    JScrollPane scrPan;
    JTable table;
    int colCou,rowCou;
    
   // String term="no value";
    String activeClass="no value",selStudMailId="";
    int term=0,selClaRolNo=0;
    
    JPanel dpP;
    JPanel maiCreP;
    
    DefaultTableCellRenderer centerRen;
    
    MyConnection conn;
    
    Mailer mail;  
    
    
    public Teacher() {
    }
    
    void intial(int id){
        Tid=id;
    }
    
    void design(MainFrame f){
        f.teacherV=1;
        renew();
        
        f.setBounds(0, 0,f.width, f.height);
        
        setBounds(0, 0,f.width, f.height);
        setBackground(Color.white);
        setVisible(true);
        setLayout(null);
        
        int x=getWidth()/100,y=7;
        
        try {
            conn.pre_s=conn.conn.prepareStatement("select firstname,lastname,email,pic from teacher where id=?");
            conn.pre_s.setInt(1, Tid);
            
            conn.r_set=conn.pre_s.executeQuery();
            
            while(conn.r_set.next()){
                nameL.setText(conn.r_set.getString(1)+" "+conn.r_set.getString(2));
                email=conn.r_set.getString(3);
                proPicAdr=conn.r_set.getString(4);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "select fname", 1);
        }
        
        System.out.println("Teacher x and y "+x+"  "+y);
        
        sidPan.setBounds(0, 0, x*10-2,getHeight());
        sidPan.setLayout(null);
        sidPan.setBackground(Color.white);
                        
            proPic.setBounds(x*1, y*5, x*8, y*12);
            proPic.setOpaque(true);
            
            
           
                      
            try {
                     File proPicAdrF=new File(proPicAdr);
                proPic.setIcon(new ImageIcon(ImageIO.read(proPicAdrF).getScaledInstance(proPic.getWidth(), proPic.getHeight(),Image.SCALE_SMOOTH )));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex, "pro pic set", HEIGHT);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex, "File not found", HEIGHT);
            }
            
            nameL.setBounds(x*2, y*21, x*8, y*3);
            
            JPanel bulkMailP=new JPanel();
            bulkMailP.setLayout(null);
            bulkMailP.setBounds(x*15, y*30, x*30, y*40);
            bulkMailP.setVisible(false);
                
                JButton close=new JButton("<html> <font style=\"font-size:20\">X");
                close.setBounds(x, 0, x*10, y*2);
                close.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bulkMailP.setVisible(false);
                    }
                });
                
                JTextArea bulkMailTA=new JTextArea();
                bulkMailTA.setBounds(0, y*2, bulkMailP.getWidth(), bulkMailP.getHeight()-(y*2));
                
                JButton send=new JButton("<html> <font style=\"font-size:20\">Send");
                send.setBounds(x*12, 0, x*10, y*2);
                send.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MyConnection conn=new MyConnection();
                        try{
                            conn.pre_s=conn.conn.prepareStatement("select Email from studentname where CourseId=?");
                            conn.pre_s.setInt(1, Integer.parseInt(activeClass));
                            conn.r_set=conn.pre_s.executeQuery();
                            
                            while(conn.r_set.next()){
                                System.out.print(" "+conn.r_set.getString(1));
                                //mail.send(email, JOptionPane.showInputDialog(null,"Enter GMail Password"), conn.r_set.getString(1), "Information Reagarding Class", bulkMailTA.getText());
                                
                                mail.send("kumarraghav561@gmail.com","2000raghav22", conn.r_set.getString(1), "Information Reagarding Class", bulkMailTA.getText());
                            }
                        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(null, "bulk Mail Not Send", "Bulk Mail Erroe",0);
                        }
                        
                    }
                });
                
            bulkMailP.add(bulkMailTA);
            bulkMailP.add(close);
            bulkMailP.add(send);
            
            JButton bulkMailB=new JButton("Mail");
            bulkMailB.setBounds(x*1, y*35, x*8, y*3);
            butDes(bulkMailB);
            bulkMailB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bulkMailP.setVisible(false);
                    bulkMailP.setVisible(true);
                }
            });
            
            logOut.setBounds(x*1, y*40, x*8, y*3);
            butDes(logOut);
            logOut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.login.setVisible(true);
                    f.setBounds(f.x*20, f.y*20,f.x*70 , f.y*70);
                    setVisible(false);
                }
            });
            
            JButton tct=new JButton("Tic Tac Toe");
            tct.setBounds(x*1, y*45, x*8, y*3);
            butDes(tct);
            tct.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    try {
                        File loc=new File("E:\\PythonProgram\\zeroKantaGame.py");
                        Desktop desktop=Desktop.getDesktop();
                        desktop.open(loc);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "File denied", "Error", 0);
                    }
                }
            });
            
            JButton tenis=new JButton("Tennis");
            tenis.setBounds(x*1, y*50, x*8, y*3);
            butDes(tenis);
            tenis.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    try {
                        File loc=new File("E:\\HTMLProgram\\TennisGame.html");
                        Desktop desktop=Desktop.getDesktop();
                        desktop.open(loc);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "File denied", "Error", 0);
                    }
                }
            });
            
            
        sidPan.add(bulkMailB);    
        sidPan.add(logOut);
        sidPan.add(proPic);
        sidPan.add(nameL);
        sidPan.add(tct);
        sidPan.add(tenis);
        
        JPanel lineP=new JPanel();
        lineP.setBounds(x*10-2, 0, 2, getHeight());
        lineP.setBackground(Color.lightGray);
        
        container.setBounds(x*10, y,x*100, getHeight());
        container.setVisible(true);
        container.setBackground(Color.white);
        container.setLayout(null);
        
        
            coursesP.setBounds(0, 0, x*5-2, getHeight());
            coursesP.setLayout(new GridLayout(20,1));
            coursesP.setBackground(Color.white);
            coursesP.add(new JLabel("<html><ptr>    Classes"));
            
            JPanel lineCp=new JPanel();
            lineCp.setBounds(x*5-2, 0, 2, getHeight());
            lineCp.setBackground(Color.lightGray);
            
                try {
                    conn.pre_s=conn.conn.prepareStatement("select distinct Cid from teachalocation where Tid=?");
                    conn.pre_s.setInt(1, Tid);
                    conn.r_set=conn.pre_s.executeQuery();
                    while(conn.r_set.next()){
                        final JButton coursesB=new JButton();
                        coursesB.setText(""+conn.r_set.getInt(1));
                        coursesB.setName(coursesB.getText());
                        butDes(coursesB);
                        coursesP.add(coursesB);
                        coursesB.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(coursesB.getText());
                                activeClass=coursesB.getText();
                                headingL.setText("<html> <pre> <font style=\"font-size:20;\">Marks Sheet of <font style=\"color:#ffd700;\">Class "+coursesB.getText()+" Term 1");
                                
                                try{
                                    final MyConnection conn1=new MyConnection();
                                    conn1.pre_s=conn1.conn.prepareStatement("select count(Name) from subjects where CourseId=?");
                                    conn1.pre_s.setInt(1, Integer.parseInt(coursesB.getText()));
                                    conn1.r_set=conn1.pre_s.executeQuery();
                                    while(conn1.r_set.next()){
                                        System.out.println("colCou"+conn1.r_set.getInt(1));                                        
                                        colCou=conn1.r_set.getInt(1);
                                        System.out.println("colCou"+colCou);                                        
                                    }
                                }catch(SQLException ex){
                                    JOptionPane.showMessageDialog(null, ex, "select count(Name)", 1);
                                }
                                
                                table =new JTable(100,colCou+3){
                                    @Override
                                    public boolean isCellEditable(int row, int column) {
                                        if(column==0 || column==1 || column==2){
                                            return false;
                                        }
                                        return true;
                                    }
                                };
                                tableWork(table,f);

                                try{
                                    final MyConnection conn1=new MyConnection();
                                    conn1.pre_s=conn1.conn.prepareStatement("select Name from subjects where CourseId=?");
                                    conn1.pre_s.setInt(1, Integer.parseInt(coursesB.getText()));
                                    conn1.r_set=conn1.pre_s.executeQuery();
                                    int i=3;
                                    while(conn1.r_set.next()){
                                        System.out.print(" "+conn1.r_set.getString(1));                                        
                                        //columns[i]=conn1.r_set.getString(1);
                                        table.getColumnModel().getColumn(i).setHeaderValue(conn1.r_set.getString(1));
                                        table.getColumnModel().getColumn(i).setCellRenderer(centerRen);
                                        i++;
                                    }
                                }catch(SQLException ex){
                                    JOptionPane.showMessageDialog(null, ex, "select Name", 1);
                                }
               
                                try{
                                    final MyConnection conn1=new MyConnection();
                                    conn1.pre_s=conn1.conn.prepareStatement("select StudentFirstName,StudentLastName,Class_Rn from studentname where CourseId=?");
                                    conn1.pre_s.setInt(1, Integer.parseInt(coursesB.getText()));
                                    conn1.r_set=conn1.pre_s.executeQuery();
                                    int i=0;
                                    
                                    while(conn1.r_set.next()){
                                        System.out.println(conn1.r_set.getString(1));                                        
                                        //columns[i]=conn1.r_set.getString(1);
                                        table.setValueAt(conn1.r_set.getString(1)+" "+conn1.r_set.getString(2), i, 0);
                                        table.setValueAt(conn1.r_set.getInt(3), i, 1);
                                        i++;
                                    }
                                }catch(SQLException ex){
                                    JOptionPane.showMessageDialog(null, ex, "select StudentFirstName", 1);
                                }
                                try{
                                    term=1;
                                    final MyConnection conn1=new MyConnection();
                                    conn1.pre_s=conn1.conn.prepareStatement("select Marks from marks where C_Id=? and Term=1");
                                    conn1.pre_s.setInt(1, Integer.parseInt(coursesB.getText()));
                                    conn1.r_set=conn1.pre_s.executeQuery();
                                    int i=3;
                                    int row=0;
                                    int column=colCou+2;
                                    while(conn1.r_set.next()){
                                        table.setValueAt(conn1.r_set.getInt(1), row, i);
                                        if(i==column){
                                            row++;
                                            i=2;
                                        }
                                        i++;
                                        rowCou=row;
                                    }
                                }catch(SQLException ex){
                                    JOptionPane.showMessageDialog(null, ex, "select Marks", 1);
                                }
                            }
                        });
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex, "courseP tea Allo distinct CId ", HEIGHT);
                }
            
            headingL.setBounds(x*5,0, x*85, y*5);
            
            scrPan.setBounds(x*5, y*5, x*90, y*80);
            scrPan.getVerticalScrollBar();
            scrPan.getHorizontalScrollBar();
            
            tableWork(table,f);
                
            JPanel botP=new JPanel();
            botP.setBounds(x*5, y*85, x*90, y*10);
            botP.setLayout(new GridLayout(2, 3));
                
                JButton term1B=new JButton("<html> <pre> <font style=\"font-size:15;\">Term 1");
                term1B.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setContent(activeClass,1);
                        System.out.println("value of term vali class is: "+activeClass);
                        headingL.setText("<html> <pre> <font style=\"font-size:20;\">Marks Sheet of <font style=\"color:#ffd700;\">Class "+activeClass+" Term 1");                               
                        term=1;
                    }
                });
                
                JButton term2B=new JButton("<html> <pre> <font style=\"font-size:15;\">Term 2");
                term2B.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setContent(activeClass,2);
                        term=2;
                        System.out.println("value of term vali class is: "+activeClass);
                        headingL.setText("<html> <pre> <font style=\"font-size:20;\">Marks Sheet of <font style=\"color:#ffd700;\">Class "+activeClass+" Term 2");                               
                    }
                });
                
                JButton term3B=new JButton("<html> <pre> <font style=\"font-size:15;\">Term 3");
                term3B.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setContent(activeClass,3);
                        term=3;
                        System.out.println("value of term vali class is: "+activeClass);
                        headingL.setText("<html> <pre> <font style=\"font-size:20;\">Marks Sheet of <font style=\"color:#ffd700;\">Class "+activeClass+" Term 3");                               
                    }
                });
                
                JButton printB=new JButton("<html> <pre> <font style=\"font-size:15;\">Print");
                printB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MessageFormat header=new MessageFormat("Page {0,number,integer}");
                        try {
                            table.print(JTable.PrintMode.FIT_WIDTH, header, null);
                        } catch (PrinterException ex) {
                            JOptionPane.showMessageDialog(null, "Printin is not done", "Printing Error", 0);
                        }
                    }
                });
                
                JButton changeB=new JButton("<html> <pre> <font style=\"font-size:15;\">Save Changes");
                changeB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MyConnection con2=new MyConnection();
                        if(JOptionPane.showConfirmDialog(null, "Save Changes for Class "+activeClass+" of Term "
                                +term, "Update Maks", 0)==JOptionPane.OK_OPTION){
                            
                            System.out.println("In");
                            int subId=1;

                            for(int i=0;i<rowCou;i++){
                                subId=1;
                                for(int j=3;j<colCou+3;j++){
                                    try{
                                        
                                        con2.pre_s=con2.conn.prepareStatement("update marks set Marks=? where C_Id="+activeClass
                                     +" and Sub_Id="+subId+" and Term="+term+" and C_RollNo="
                                         +table.getValueAt(i, 1));
                                        
                                        con2.pre_s.setInt(1, Integer.parseInt(""+table.getValueAt(i, j)));
                                        
                                        con2.pre_s.executeUpdate();
                                        System.out.print(" "+table.getValueAt(i, j));
                                    }catch(SQLException ex){
                                        JOptionPane.showMessageDialog(null, ex, "changeB update Marks", 1);
                                        ex.getStackTrace();
                                    }
                                    System.out.println("update marks set Marks=? where C_Id="+activeClass
                                            +"and Sub_Id="+subId+" and Term="+term+"and C_RollNo="
                                            +table.getValueAt(i, 1));
                                   // System.out.print(" "+table.getValueAt(i, j));
                                    subId++;
                                }
                                System.out.println("");
                            }
                        }
                    }
                });
                
            botP.add(term1B);
            botP.add(term2B);
            botP.add(term3B);
            botP.add(printB);
            botP.add(changeB);
            
        container.add(f.marShe);
        container.add(coursesP);
        container.add(lineCp);
        container.add(headingL); 
        container.add(scrPan); 
        container.add(botP); 
        
        f.marShe.setVisible(false);
        dpP.setVisible(false);
        
        //add(f.marShe);
        add(dpP);
        add(bulkMailP);
        add(sidPan);
        add(lineP);
        add(container);
        
    }
    
    void tableWork(JTable table, MainFrame f){
        scrPan.setViewportView(table);
                table.getColumnModel().getColumn(0).setPreferredWidth(100);

                table.getColumnModel().getColumn(0).setHeaderValue("Name");
                table.getColumnModel().getColumn(0).setCellRenderer(centerRen);
                    //table.getColumnModel().getColumn(1).setPreferredWidth(5);
                table.getColumnModel().getColumn(1).setHeaderValue("RollNo");
                table.getColumnModel().getColumn(1).setCellRenderer(centerRen);
                    //table.getColumnModel().getColumn(0).setPreferredWidth(x*5);
                table.getColumnModel().getColumn(2).setCellRenderer(centerRen);    
                table.getColumnModel().getColumn(2).setHeaderValue("Class");
                
                table.setAutoCreateRowSorter(true);
                
                table.getTableHeader().setBackground(new Color(32,134,203));
                table.setShowVerticalLines(false);
                table.setSelectionForeground(Color.white);
                table.setSelectionBackground(new Color(255, 61, 50));
                table.getTableHeader().setForeground(Color.white);
                table.setRowHeight(25);
                table.setIntercellSpacing(new Dimension(0, 0));
                
                table.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        dpP.setVisible(false);
                        System.out.println(table.getSelectedRow());
                        System.out.println(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
                        try{
                            selClaRolNo=Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 1));
                        }catch(NullPointerException ex){
                            
                        }
                        System.out.println("ClassRn is "+selClaRolNo);
                        
                        System.out.println("e.getButton "+e.getButton());
                        if(e.getButton()==3){
                            displayPanel(e,f);
                        }
                        
                        //f.marShe.removeAll();
                        //f.marShe.design(f);
                        //f.marShe.setVisible(true);
                        //scrPan.setVisible(false);
                        //container.setBackground(Color.lightGray);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                
    }
    
    void displayPanel(MouseEvent e,MainFrame f){
        
        int x=getWidth()/100,y=7;
        //dpP.removeAll();
        dpP.setVisible(false);
        dpP=new JPanel();
        add(dpP,1);
        dpP.setBounds(e.getX(), e.getY(), x*30, y*9);
        dpP.setBackground(Color.white);
        dpP.setBorder(new LineBorder(Color.blue, 2, true));
        dpP.setVisible(true);
        dpP.setLayout(new GridLayout(2,1));
        final MyConnection conn1=new MyConnection();
        JButton senMai=new JButton();
        senMai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createMailPane(f);
                System.out.println("after createMailPane call");
            }
        });
        
         try{
            
            conn1.pre_s=conn1.conn.prepareStatement("select Email from studentname where CourseId=? and Class_Rn=?");
            conn1.pre_s.setInt(1, Integer.parseInt(activeClass));
            conn1.pre_s.setInt(2, Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 1)));
            conn1.r_set=conn1.pre_s.executeQuery();
                            
            while(conn1.r_set.next()){
                System.out.println();
                selStudMailId=conn1.r_set.getString(1);
                System.out.println(selStudMailId);
                senMai.setText("generate mail to "+ selStudMailId+"");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "display panel select Email", 1);
        }
        
        
        
        JButton vieMarShe=new JButton("View Marksheet of student");
        vieMarShe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.marShe.removeAll();
                f.marShe.design(f);
                f.marShe.setVisible(true);
                //scrPan.setVisible(false);
                //container.setBackground(Color.lightGray);
                dpP.setVisible(false);
            }
        });
        dpP.add(senMai);
        dpP.add(vieMarShe);
    }
    
    void createMailPane(MainFrame f){
        int x=getWidth()/100,y=7;
        maiCreP.setVisible(false);
        maiCreP=new JPanel();
        add(maiCreP,1);
        maiCreP.setLayout(null);
        maiCreP.setVisible(true);
        maiCreP.setBounds(x*20, y*10, x*50, y*50);
        
        JTextArea patStudMaiWri=new JTextArea();
        
            JButton close=new JButton("x");
            close.setBounds(0, 0, x*10, y*5);
            close.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    maiCreP.setVisible(false);
                }
            });
            
            JButton senMailB=new JButton("Send Mail");
            senMailB.setBounds(x*12, 0, x*10, y*5);
            
            senMailB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                                                      
                   //-mail.send(email, JOptionPane.showInputDialog(null,"Mail Password", "Enter Password,2"),selStudMailId,"Student Report",patStudMaiWri.getText());
                    ///System.out.println(email+" "+JOptionPane.showInputDialog(null,"Mail Password", "Enter Password",2)+" "+selStudMailId+" "+patStudMaiWri.getText());
                    Mailer.send("kumarraghav561@gmail","2000raghav22",selStudMailId,"Student Report",patStudMaiWri.getText());
                }
            });
        
            JScrollPane mailCreaSP=new JScrollPane();
            
            patStudMaiWri.setRows(20);
            patStudMaiWri.setColumns(100);
            patStudMaiWri.setPreferredSize(new Dimension(x*30, y*50));
            patStudMaiWri.setText("Dear Parent \n This is the Information regarding your kid "+table.getValueAt(table.getSelectedRow() ,0));
            patStudMaiWri.setVisible(true);
            
            mailCreaSP.setBounds(0, y*5, x*50, y*50);
            mailCreaSP.setViewportView(patStudMaiWri);
        
        maiCreP.add(mailCreaSP);
        maiCreP.add(close);
        maiCreP.add(senMailB);
        maiCreP.setVisible(true);
        dpP.setVisible(false);
        
    }
    
    void setContent(String clas,int term){
        try{
            final MyConnection conn1=new MyConnection();
            conn1.pre_s=conn1.conn.prepareStatement("select Marks from marks where C_Id=? and Term=?");
            conn1.pre_s.setInt(1, Integer.parseInt(clas));
            conn1.pre_s.setInt(2, term);
            conn1.r_set=conn1.pre_s.executeQuery();
            int i=3;
            int row=0;
            int column=colCou+2;
            while(conn1.r_set.next()){
                table.setValueAt(conn1.r_set.getInt(1), row, i);
                if(i==column){
                    row++;
                    i=2;
                }
                i++;
                                        
            }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex, "select Marks", 1);
            }
    }
    
    void butDes(JButton b){
        b.setBackground(Color.blue);
        b.setForeground(Color.yellow);
        b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
        
                b.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b.setForeground(Color.yellow);
            }
        });
    }
    
    void renew(){
        proPicAdr="";email="";
        sidPan=new JPanel();
        container=new JPanel();
        proPic=new JLabel();
        nameL=new JLabel();
        logOut=new JButton("Log Out");
        conn=new MyConnection();
        coursesP=new JPanel();
        headingL=new JLabel();
        scrPan=new JScrollPane();
        colCou=0;rowCou=0;
        table =new JTable(100,13){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==0 || column==1 || column==2){
                    return false;
                }
                return true;
            }
        };
        
        dpP=new JPanel();
        maiCreP=new JPanel();
        
        centerRen=new DefaultTableCellRenderer();
        centerRen.setHorizontalAlignment(JLabel.CENTER);
        mail=new Mailer();
    }
}
