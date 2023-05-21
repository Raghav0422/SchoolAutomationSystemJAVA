package schoolautomationsystem;

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jdesktop.swingx.JXComboBox;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateStringConverter;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.util.Date;


public class FeeP extends JScrollPane{

    JPanel body=new JPanel();
    JLabel heading=new JLabel("<html> <font style=\"font-size:20;\">Student FEE<font style=\"color:#ffd700;\"> RECEIPT");
    JPanel line1=new JPanel();
    JPanel infoP=new JPanel();
    
    JLabel recnoL;
    JLabel nameL;
    JLabel fnameL;
    JComboBox course=new JComboBox();
    JComboBox rolno=new JComboBox();
    
    MyConnection conn=new MyConnection();
    
    JPanel feebilP=new JPanel();
    JPanel sR=new JPanel(); //session report
        JLabel year=new JLabel();
        JLabel jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec,janf,febf,marf,aprf,mayf,junf,julf,augf,sepf,octf,novf,decf;
        JLabel payAmoL,payAmof;
        int payAmo=0;
        
    JComboBox payMonCB=new JComboBox();
    
    JLabel feeLL=new JLabel();
    JTextField amountTF=new JTextField();
    
    int amoCal=0;
    int sID=0;
    String monStr="",email="",name="";
    
    FeeP(){
        
    }
    
    void design(int p,int y){
        renew();
        
        setBounds(0, 0, p*102, y*100);
        setVisible(true);
        
        body.setLayout(null);
        body.setBackground(Color.lightGray);
        body.setPreferredSize(new Dimension(p*100, y*100));
        body.setVisible(true);
        
            y=7;
            feebilP.setBounds(0, 0, p*70-2, y*100);
            feebilP.setLayout(null);
            feebilP.setBackground(Color.white);
            
            int x=feebilP.getWidth()/100;
            
            
                heading.setBounds(feebilP.getWidth()/3, y, feebilP.getWidth()/2 ,(y*6)-2);

                line1.setBounds(x, (y*7)-2,x*100-x, 2);
                line1.setBackground(Color.lightGray);
                line1.setVisible(true);

                infoP.setBounds(x, y*7, x*100, y*16);
                infoP.setLayout(null);
                infoP.setBackground(Color.white);
                infoP.setBorder(new LineBorder(Color.lightGray));

                    recnoL=new JLabel();

                    int rno=getRecNo();
                    
                    rno++;
                    recnoL.setText("Receipt No: "+rno);
                    recnoL.setBounds(x, y, x*30, y*3);

                    LocalDate date=LocalDate.now();

                    JLabel dateL=new JLabel(date.toString());
                    dateL.setBounds(x*60, y, x*30, y*3);

                    nameL=new JLabel("Name: ");
                    nameL.setBounds(x, y*4, x*30, y*3);

                    fnameL=new JLabel("Father: ");
                    fnameL.setBounds(x, y*8, x*30, y*3);

                    JLabel courseL=new JLabel("Class: ");
                    courseL.setBounds(x, y*12, x*10, y*3);

                    course.setBounds(x*10, y*12, x*20, y*3);
                    course.addItem("--Select Class--");
                    try{
                        conn.pre_s=conn.conn.prepareStatement("Select Name,Id from courses order by Id");
                        conn.r_set=conn.pre_s.executeQuery();

                        while(conn.r_set.next()){
                            course.addItem(conn.r_set.getString(1)+"      "+conn.r_set.getInt(2));
                        }
                    }catch(SQLException ex){
                        System.out.println("after course add Item "+ex);
                    }

                    course.setBackground(Color.white);
                    course.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            rolno.removeAllItems();
                            rolno.addItem("--Selected Rollno--");
                            try{
                                conn.pre_s=conn.conn.prepareStatement("Select C_Rlno from fee where C_Id="+course.getSelectedIndex());
                                conn.r_set=conn.pre_s.executeQuery();

                                while(conn.r_set.next()){
                                    rolno.addItem(conn.r_set.getString(1));
                                }
                                }catch(SQLException ex){

                                    System.out.println("course.addActionListener "+ex);
                                }
                            }
                    });

                    JLabel rolnoL=new JLabel("Roll No:  ");
                    rolnoL.setBounds(x*60, y*12, x*10, y*3);

                    rolno.setBounds(x*70, y*12, x*20, y*3);
                    rolno.addItem("--Select RollNo--");
                    rolno.setBackground(Color.white);
                    rolno.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                conn.pre_s=conn.conn.prepareStatement("select StudentFirstName,StudentLastName,Fname,Email from studentname where"
                                        + " CourseId=? and Class_Rn=? ");
                                conn.pre_s.setInt(1, course.getSelectedIndex());
                                conn.pre_s.setInt(2, rolno.getSelectedIndex());

                                conn.r_set=conn.pre_s.executeQuery();
                                
                                while(conn.r_set.next()){
                                    name=conn.r_set.getString(1)+" "+conn.r_set.getString(2);
                                    nameL.setText("Name:  "+name);
                                    fnameL.setText("Father:   "+conn.r_set.getString(3));
                                    email=conn.r_set.getString(4);
                                }
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "top wali try catch "+ex, "FeeP rolno", 1);
                            }
                            
                            try {
                                conn.pre_s=conn.conn.prepareStatement("select * from fee where C_Id=? and C_Rlno=? ");
                                conn.pre_s.setInt(1, course.getSelectedIndex());
                                conn.pre_s.setInt(2, rolno.getSelectedIndex());

                                conn.r_set=conn.pre_s.executeQuery();
                                
                                while(conn.r_set.next()){
                                    sID=conn.r_set.getInt(1);
                                    System.out.println("Student Id= "+sID);
                                    payAmo=conn.r_set.getInt(4)+conn.r_set.getInt(5)+conn.r_set.getInt(6)+conn.r_set.getInt(7)
                                            +conn.r_set.getInt(8)+conn.r_set.getInt(9)+conn.r_set.getInt(10)+conn.r_set.getInt(11)
                                            +conn.r_set.getInt(12)+conn.r_set.getInt(13)+conn.r_set.getInt(14)+conn.r_set.getInt(15);
                                  
                                    //payMonCB.removeAllItems();
                                    if(conn.r_set.getInt(4)>0){payMonCB.addItem("January");}
                                    if(conn.r_set.getInt(5)>0){payMonCB.addItem("February");}
                                    if(conn.r_set.getInt(6)>0){payMonCB.addItem("March");}
                                    if(conn.r_set.getInt(7)>0){payMonCB.addItem("April");}
                                    if(conn.r_set.getInt(8)>0){payMonCB.addItem("May");}
                                    if(conn.r_set.getInt(9)>0){payMonCB.addItem("June");}
                                    if(conn.r_set.getInt(10)>0){payMonCB.addItem("July");}
                                    if(conn.r_set.getInt(11)>0){payMonCB.addItem("August");}
                                    if(conn.r_set.getInt(12)>0){payMonCB.addItem("September");}
                                    if(conn.r_set.getInt(13)>0){payMonCB.addItem("October");}
                                    if(conn.r_set.getInt(14)>0){payMonCB.addItem("November");}
                                    if(conn.r_set.getInt(15)>0){payMonCB.addItem("December");}
                                    
                                    year.setText(""+conn.r_set.getInt(16)+"-"+conn.r_set.getInt(17));
                                    janf.setText(""+conn.r_set.getInt(4));febf.setText(""+conn.r_set.getInt(5));
                                    marf.setText(""+conn.r_set.getInt(6));aprf.setText(""+conn.r_set.getInt(7));
                                    mayf.setText(""+conn.r_set.getInt(8));junf.setText(""+conn.r_set.getInt(9));julf.setText(""+conn.r_set.getInt(10));
                                    augf.setText(""+conn.r_set.getInt(11));sepf.setText(""+conn.r_set.getInt(12));octf.setText(""+conn.r_set.getInt(13));
                                    novf.setText(""+conn.r_set.getInt(14));decf.setText(""+conn.r_set.getInt(15));
                                            
                                    payAmoL.setText("Total Amount");payAmof.setText(""+payAmo);
                                   
                                   jan.setText("January");feb.setText("February");mar.setText("March");apr.setText("April");
                                   may.setText("May");jun.setText("June");jul.setText("July");aug.setText("August");
                                   sep.setText("September");oct.setText("October");nov.setText("November");dec.setText("December");
                                }
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "top wali try catch "+ex, "FeeP rolno", 1);
                            }
                        }
                    });

                infoP.add(recnoL);
                infoP.add(dateL);
                infoP.add(nameL);
                infoP.add(fnameL);
                infoP.add(courseL);
                infoP.add(course);
                infoP.add(rolnoL);
                infoP.add(rolno);
                
                JPanel feeInfP=new JPanel();
                feeInfP.setLayout(null);
                feeInfP.setBounds(x, y*24, x*100, y*16);
                feeInfP.setBorder(new LineBorder(Color.lightGray));
                feeInfP.setBackground(Color.white);
                
                    JLabel feeL=new JLabel("Fee");
                    feeL.setBounds(x*10, y*2, x*5, y*3);
                    
                    feeLL.setBounds(x*60,y*2,x*30,y*3);
                    
                    JPanel line=new JPanel();
                    line.setBackground(Color.lightGray);
                    line.setBounds(0, y*9, feeInfP.getWidth(), 2);
                    
                    JLabel totFeeL=new JLabel("Amount Paid");
                    totFeeL.setBounds(x*10, y*10, x*30, y*3);
                    
                    amountTF.setBounds(x*60,y*10,x*30,y*3-2);
                    amountTF.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            char c=e.getKeyChar();
                        if(!Character.isDigit(c) ){
                            getToolkit().beep();
                            e.consume();
                        }
                        }
                        @Override
                        public void keyPressed(KeyEvent e) {
                            feeLL.setText(amountTF.getText());
                        }
                        @Override
                        public void keyReleased(KeyEvent e) {
                            feeLL.setText(amountTF.getText());
                        }
                    });
                    
                    
                feeInfP.add(feeL);
                feeInfP.add(feeLL);
                feeInfP.add(line);
                feeInfP.add(totFeeL);
                feeInfP.add(amountTF);
                
            feebilP.add(heading);
            feebilP.add(infoP);
            feebilP.add(line1);
            feebilP.add(feeInfP);
            
            sR.setLayout(null);
            sR.setBounds(p*70, 0, p*30, y*100);
            sR.setBackground(Color.white);
            
                x=sR.getWidth()/100;
            
                JLabel head=new JLabel("<html> <font style=\"font-size:20;\">SESSION <font style=\"color:#ffd700;\"> Report");
                head.setBounds(sR.getWidth()/3, 0, sR.getWidth()-(sR.getWidth()/3), y*6-2);
              
                JPanel linesR=new JPanel();
                linesR.setBounds(x, y*6-2, sR.getWidth()-x, 2);
                linesR.setBackground(Color.lightGray);
              
                year.setBounds(x*40, y*7, x*30, y*3);
              
                JPanel holder=new JPanel();
                holder.setLayout(new BorderLayout());
                holder.setBackground(Color.white);
                holder.setBounds(x*10, y*12, sR.getWidth()-x*20, y*36);
              
                    JPanel leftP=new JPanel();//for left side label declaration
                    leftP.setLayout(new GridLayout(12, 1));
                    leftP.setPreferredSize(new Dimension(x*30, holder.getHeight()));
                    leftP.setBackground(Color.white);
                    leftP.add(jan);leftP.add(feb);leftP.add(mar);leftP.add(apr);leftP.add(may);leftP.add(jun);
                    leftP.add(jul);leftP.add(aug);leftP.add(sep);leftP.add(oct);leftP.add(nov);leftP.add(dec);
               
                    JPanel rightP=new JPanel();
                    rightP.setPreferredSize(new Dimension(x*30, holder.getHeight()));
                    rightP.setLayout(new GridLayout(12, 1));
                    rightP.setBackground(Color.white);
                    rightP.add(janf);rightP.add(febf);rightP.add(marf);rightP.add(aprf);rightP.add(mayf);rightP.add(junf);
                    rightP.add(julf);rightP.add(augf);rightP.add(sepf);rightP.add(octf);rightP.add(novf);rightP.add(decf);
                
                holder.add(rightP,BorderLayout.EAST);
                holder.add(leftP,BorderLayout.WEST);
                
                payAmoL.setBounds(x*10, y*49, x*30, y*3);
                payAmof.setBounds(x*70, y*49, x*30, y*3);
               
                payMonCB.setBounds(x*20, y*54, x*60, y*5);
                payMonCB.addItem("Select Paying Month");
                payMonCB.addItem("January");
                payMonCB.addItem("February");
                payMonCB.addItem("March");
                payMonCB.addItem("April");
                payMonCB.addItem("May");
                payMonCB.addItem("June");
                payMonCB.addItem("July");
                payMonCB.addItem("August");
                payMonCB.addItem("September");
                payMonCB.addItem("October");
                payMonCB.addItem("November");
                payMonCB.addItem("December");
                
                payMonCB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        try{
                            monStr=""+payMonCB.getSelectedItem().toString();
                            monStr=monStr.toLowerCase();
                            monStr=monStr.substring(0, 3);
                            System.out.println("selected Month= "+monStr);
                        }catch(NullPointerException ex){
                            JOptionPane.showMessageDialog(null, ex, "payMonCB AP monStr", 1);
                            System.out.println(ex.getStackTrace());
                        }
                        
                        try{
                            conn.pre_s=conn.conn.prepareStatement("select * from fee where C_Id=? and C_Rlno=? ");
                            conn.pre_s.setInt(1, course.getSelectedIndex());
                            conn.pre_s.setInt(2, rolno.getSelectedIndex());

                            conn.r_set=conn.pre_s.executeQuery();

                            while(conn.r_set.next()){
                                amoCal=conn.r_set.getInt(payMonCB.getSelectedIndex()+3);
                                System.out.println("Amount of Month= "+amoCal);
                            }

                        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(null, ex, "payMonCB AP", 1);
                        }
                    }
                });
                
                JButton payB=new JButton("Pay");
                payB.setBounds(x*20, y*60, x*60, y*5);
                payB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                            conn.pre_s=conn.conn.prepareStatement("Update fee set "+monStr+"=? where S_Id=?");
                            
                            conn.pre_s.setInt(1, amoCal-Integer.parseInt(amountTF.getText()));
                            conn.pre_s.setInt(2, sID);
                            
                            if(conn.pre_s.executeUpdate()>0){
                                
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex, "payB AP first", 1);
                        }
                        
                        int rno=0;
                        String str="";
                        str=recnoL.getText();
                        str=str.substring(12, str.length());
                        System.out.println("receipt no= "+str);
                        rno=Integer.parseInt(str);
                        System.out.println("receipt no= "+rno);
                        
                        try {
                            System.out.println("inside update recepit");
                            conn.pre_s=conn.conn.prepareStatement("update receipt set Amount=? where no=?;");
                            
                            conn.pre_s.setInt(1,Integer.parseInt(amountTF.getText()));
                            conn.pre_s.setInt(2, rno);
                            
                            if(conn.pre_s.executeUpdate()>0){
                                JOptionPane.showMessageDialog(null, "Payment Done of "
                                        +(Integer.parseInt(amountTF.getText())), "Successful", 1);
                            }
                            
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex, "payB second", 1);
                        }
                                               
                        Thread mail=new Thread(new Runnable() {
                                @Override
                                public void run() {

                                     System.out.println("starting mail thread");

                                    try{

                                        FileReader senderfr=new FileReader("mailerInfo.txt");
                                        BufferedReader senderbr= new BufferedReader(senderfr);

                                        String lineRead=senderbr.readLine();
                                        String[] lineSplit=lineRead.split(":");
                                        
                                        String messageRead="";
                                        
                                        messageRead+="Dear "+name+"\n";
                                        
                                        FileReader messagefr=new FileReader("pay.txt");
                                        BufferedReader messagebr= new BufferedReader(messagefr);
                                        String s1="";
                                        while((s1=messagebr.readLine())!=null){
                                            messageRead+="\n"+s1;
                                        }
                                        messageRead+="\n\n Your Paying Amount is: "+amountTF.getText()+"\n Paying Month is: "+monStr;
                                        System.out.println("my id= "+lineSplit[0]+"pass="+lineSplit[1]);
                                        System.out.println("for Reciever checking ki naam ehdr thk aanda hai k nhi  "+email);

                                       // if(JOptionPane.showConfirmDialog(null, "mailer "+lineSplit[0]+"  reciever "+email.getText()+" message "+messageRead, "Check", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
                                            Mailer.send(lineSplit[0], lineSplit[1], email, "Fee Payment Details ", messageRead);
                                       // }f

                                        System.out.println("mail is sent \n"+"mailer "+lineSplit[0]+"  reciever "+email+" message "+messageRead);

                                    }catch(IOException e){
                                        System.err.println(e.getStackTrace());
                                    }catch(ArrayIndexOutOfBoundsException e){
                                        System.err.println(e.getStackTrace());
                                    }catch(Exception e){
                                        System.err.println(e.getStackTrace());
                                    }
                                    System.out.println("existing mail thread");

                                }
                            });
                            mail.start();
                            
                            clear();
                    }
                });
                
                JButton print=new JButton("Print");
                print.setBounds(x*20, y*67, x*60, y*5);
                print.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Print(feebilP);
                    }
                });
                
            sR.add(head);
            sR.add(linesR);
            sR.add(year);
            sR.add(holder);
            sR.add(payAmoL);
            sR.add(payAmof);
            sR.add(payMonCB);
            sR.add(payB);
            sR.add(print);
            
        body.add(feebilP);
        body.add(sR);
        
        setViewportView(body);
    }
    
    int getRecNo(){
        int rno=0;
                        try{
                            conn.pre_s=conn.conn.prepareStatement("select max(no) from receipt");
                            conn.r_set=conn.pre_s.executeQuery();
                            while(conn.r_set.next()){
                                rno=conn.r_set.getInt(1);
                            }
                            
                            return rno;
                            
                        }catch(SQLException ex){
                            System.out.println("getting recipt no "+ex);
                        }
                        return rno;
    }
    
    void clear(){
        recnoL.setText("Receipt No: "+(getRecNo()+1));
        nameL.setText("Name:");
        fnameL.setText("Father:");
        course.setSelectedIndex(0);
        jan.setText("");feb.setText("");mar.setText("");apr.setText("");may.setText("");jun.setText("");jul.setText("");
        aug.setText("");sep.setText("");oct.setText("");nov.setText("");dec.setText("");
        janf.setText("");febf.setText("");marf.setText("");aprf.setText("");mayf.setText("");junf.setText("");julf.setText("");
        augf.setText("");sepf.setText("");octf.setText("");novf.setText("");decf.setText("");
        amountTF.setText("");feeLL.setText("");
    }
    
    void renew(){
        jan=new JLabel();
        feb=new JLabel();
        mar=new JLabel();
        apr=new JLabel();
        may=new JLabel();
        jun=new JLabel();
        jul=new JLabel();
        aug=new JLabel();
        sep=new JLabel();
        oct=new JLabel();
        nov=new JLabel();
        dec=new JLabel();
        janf=new JLabel();
        febf=new JLabel();
        marf=new JLabel();
        aprf=new JLabel();
        mayf=new JLabel();
        junf=new JLabel();
        julf=new JLabel();
        augf=new JLabel();
        sepf=new JLabel();
        octf=new JLabel();
        novf=new JLabel();
        decf=new JLabel();
        payAmoL=new JLabel();
        payAmof=new JLabel();
        
    }
    
}
