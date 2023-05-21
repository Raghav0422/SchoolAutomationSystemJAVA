package schoolautomationsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.LineBorder;
import org.jdesktop.swingx.JXDatePicker;
import schoolautomationsystem.Mailer;


public class AddNewStudent extends JPanel{
    
    
    JScrollPane bodySP=new JScrollPane();;
    JPanel bodyP ;
    JPanel upperButtonP ;
    JPanel calendarP;
   
    JComboBox dateCB;
    JComboBox monthCB;
    JComboBox yearCB;
    JLabel profilePicL;
    Calendar calendarC;
   
    JPanel headingP=new JPanel();
    
    JComboBox salu=new JComboBox();
    JTextField sFirstName;
    JTextField sSurName;
    JXDatePicker picker =new JXDatePicker();
    String pickerS="";
    JTextField birthCTF=new JTextField();
    JTextField birthSTF=new JTextField();
    JComboBox genderCB=new JComboBox();
    JComboBox religionCB=new JComboBox();
    JTextField nationTF=new JTextField();
    JTextField adharTF=new JTextField();
    
    //blockCI components
    JTextField hnoTF=new JTextField();
    JTextField streetTF=new JTextField();
    JTextField cityTF=new JTextField();
    JTextField stateTF=new JTextField();
    JTextField pinTF=new JTextField();
    JTextField mobilenoTF=new JTextField();
    JTextField emailTF=new JTextField();
    
    //blockFI components
    JTextField fnameTF=new JTextField();
    JTextField foccuTF=new JTextField();
    JTextField fcnoTF=new JTextField();
    JTextField mnameTF=new JTextField();
    JTextField moccuTF=new JTextField();
    JTextField mcnoTF=new JTextField();
    
    //blockAQ components
    JComboBox hqCB=new JComboBox();
    JTextField instinTF=new JTextField();
    JTextField boardTF=new JTextField();
    JTextField percenTF=new JTextField();
    JXDatePicker courseCompDP=new JXDatePicker();
    
    JPanel bottomP=new JPanel();
    JButton print;
    JButton reset;
    JButton submit;
    
    //blockCD components
    JComboBox scCB=new JComboBox();
    
    String stR="";int fee=0;
    
    JTextField payingTF;
    JPanel payingP;
    
    String lineRead,lineSplit[]=null;
    InputStream picAddress;
    
    JFileChooser fileChooserFC=new JFileChooser("C:\\Users\\Os\\Pictures");
    
    JScrollPane classInfoSP=new JScrollPane();
    JTextArea classInfoTA=new JTextArea();
    
    MyConnection conn;
    
    Date d;
    
    DateModifier date=new DateModifier();
    
    String mailReciever="";
    String imgPath="";
    
    public AddNewStudent() {

    }
    
    void design(int x, int y){
    try{
        
        add(bodySP);
        add(bottomP);
        
    setBackground(Color.white);
           
    setBounds(0,0,x*104,y*100); 
    
    bodyP = new JPanel();
    upperButtonP = new JPanel();
    
    calendarP=new JPanel();
    dateCB=new JComboBox();
    monthCB=new JComboBox();
    yearCB=new JComboBox();
    profilePicL=new JLabel("image");
    calendarC=Calendar.getInstance();
    
    sFirstName = new JTextField();
    sSurName = new JTextField();  
    genderCB=new JComboBox();
    //JComboBox courseCB=new JComboBox();
    
    stR="";fee=0;
    
    payingTF=new JTextField();
    payingP=new JPanel();
      
    
    lineRead="";
    //lineSplit[]=null ;
    InputStream picAddress;
    
    conn=new MyConnection();
        
        System.out.println("inside addNew Students");
        setLayout(null);
     
        designBodyP(getWidth()/100,y);
        
       // fileChooserFC.setBounds(0, 0, x*90, y*80);
        
        //setVisible(true); 
        
    }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Fake Your device is not compatible");
    }
    }
    
    void designHeadingP(int x,int y){
        try{
        y=7;
        
        headingP.setBounds(0,0, x*100-x, y*15);
        headingP.setLayout(null);
        headingP.setBackground(Color.white);
        
        JLabel nHeadingL=new JLabel("<html>  <font style=\"font-size:20;\">R.V SCHOOL <font style=\"color:#ffd700;\">AMRITSAR");
        nHeadingL.setBounds(x*7, y, x*30, y*7-2);
        JPanel line=new JPanel();
        line.setBackground(Color.lightGray);
        line.setBounds(x, y*7-2, headingP.getWidth()-x, 2);
        
        JLabel heading2=new JLabel("<html> <pre> <font style=\"font-size:25;\">Student Registration Form");
        heading2.setBounds(x*35, y*7, x*50, y*7-2);
        JPanel line2=new JPanel();
        line2.setBounds(x, y*14-2, headingP.getWidth()-x, 2);
        line2.setBackground(Color.lightGray);
        
        headingP.add(nHeadingL);
        headingP.add(line);
        headingP.add(heading2);
        headingP.add(line2);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Fake Your device is not compatible");
    }
    }
    
    void designBodyP(int x,int y){
        try{
            System.out.println("add new student designbodp()");
            
            y=7;
            
            
            
            bodySP.setBounds(0, 0, getWidth()-10, getHeight()-(y*5));
            bodySP.setViewportView(bodyP);
            bodySP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            
            bottomP.setLayout(new GridLayout(1, 2));
            bottomP.setBounds(0, getHeight()-(y*5), getWidth()-20,y*5);
            
                print=new JButton("Print");
                print.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Print(bodyP);
                }
            });
                
                reset=new JButton("Reset");
                reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    reset();
                }
            });
                
                submit=new JButton("Submit");
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("value nu fetch kita teh naam hai "+emailTF.getText());
                /*    date="";
                    System.out.println(yearCB.getSelectedItem());
                    date+=yearCB.getSelectedItem();
                    date+="-"+Integer.toString(monthCB.getSelectedIndex())+"-"+Integer.toString(dateCB.getSelectedIndex());*/
                    pickerS=date.convert(picker);
                
                    d=Date.valueOf(pickerS);
                    System.out.println("date Date wali  "+d);

                    int id=0;

                    try{
                        conn.pre_s=conn.conn.prepareStatement("select max(Id) from studentname");
                        conn.r_set=conn.pre_s.executeQuery();
                        while(conn.r_set.next()){
                            id=conn.r_set.getInt(1);
                        }
                    }catch(SQLException ex){
                        System.out.println("erroe while getting max id "+ex);
                    }
                    id++;

                    try {
                        conn.pre_s=conn.conn.prepareStatement("INSERT INTO `studentname`(`Id`,`salu`,`StudentFirstName`, `StudentLastName`,"
                                + " `DOB`,`Gender`, `Religion`,`Nationality`,`Adharno`,`Hno`,`StreetName`,`City`,`State`,`PIN`,"
                                + "`BirthPlace`,`BirthState`, `ContactNumber`, `Email`,`Fname`,`Foccu`,`FContactno`,`Mname`,"
                                + "`Moccu`,`MContactno`,`PSchoolClass`,`PSchoolN`,`PSchoolBoard`,PSPer ,`PSCCDate`,`Image`,`CourseId` ) "
                                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                        conn.pre_s.setInt(1, id);
                        conn.pre_s.setString(2, salu.getSelectedItem().toString());
                        conn.pre_s.setString(3, sFirstName.getText());
                        conn.pre_s.setString(4, sSurName.getText());
                        conn.pre_s.setDate(5,d );
                        conn.pre_s.setString(6, genderCB.getSelectedItem().toString());
                        conn.pre_s.setString(7, religionCB.getSelectedItem().toString());
                        conn.pre_s.setString(8, nationTF.getText());
                        conn.pre_s.setString(9, adharTF.getText());
                        conn.pre_s.setString(10, hnoTF.getText());
                        conn.pre_s.setString(11,streetTF.getText() );
                        conn.pre_s.setString(12,cityTF.getText());
                        conn.pre_s.setString(13,stateTF.getText() );
                        conn.pre_s.setString(14,pinTF.getText() );
                        conn.pre_s.setString(15,birthCTF.getText());
                        conn.pre_s.setString(16,birthSTF.getText());
                        conn.pre_s.setString(17,mobilenoTF.getText() );
                        conn.pre_s.setString(18,emailTF.getText() );
                        conn.pre_s.setString(19,fnameTF.getText());
                        conn.pre_s.setString(20,foccuTF.getText());
                        conn.pre_s.setString(21,fcnoTF.getText());
                        conn.pre_s.setString(22,mnameTF.getText());
                        conn.pre_s.setString(23,moccuTF.getText());
                        conn.pre_s.setString(24,mcnoTF.getText());
                        conn.pre_s.setString(25,hqCB.getSelectedItem().toString());
                        conn.pre_s.setString(26,instinTF.getText());
                        conn.pre_s.setString(27,boardTF.getText());
                        conn.pre_s.setString(28,percenTF.getText());
                        conn.pre_s.setString(29,date.convert(courseCompDP));
                        conn.pre_s.setString(30,imgPath);
                        conn.pre_s.setInt(31,scCB.getSelectedIndex());
                        System.out.println("img path stored to java is "+ imgPath);

                        if(conn.pre_s.executeUpdate()>0){
                            JOptionPane.showMessageDialog(null,"Student Is Registered", "Sucessful", JOptionPane.PLAIN_MESSAGE);
                           // AddNewStudent obj=new AddNewStudent();
                            //obj.email.setText(email.getText());
                            System.out.println("thread start hon toh pehla naam   "+emailTF.getText()+"  obj value=  "+emailTF.getText());
                            Thread mail=new Thread(new Runnable() {
                                @Override
                                public void run() {

                                     System.out.println("starting mail thread");

                                    try{

                                        FileReader senderfr=new FileReader("mailerInfo.txt");
                                        BufferedReader senderbr= new BufferedReader(senderfr);

                                        lineRead=senderbr.readLine();
                                        lineSplit=lineRead.split(":");

                                        FileReader messagefr=new FileReader("welcomeMail.txt");
                                        BufferedReader messagebr= new BufferedReader(messagefr);
                                        String messageRead=messagebr.readLine();
                                        messageRead+="\n\n Class Details \n\n "+classInfoTA.getText();
                                        System.out.println("my id= "+lineSplit[0]+"pass="+lineSplit[1]);
                                        System.out.println("for Reciever checking ki naam ehdr thk aanda hai k nhi  "+emailTF.getText());

                                       // if(JOptionPane.showConfirmDialog(null, "mailer "+lineSplit[0]+"  reciever "+email.getText()+" message "+messageRead, "Check", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
                                            Mailer.send(lineSplit[0], lineSplit[1], emailTF.getText(), "Welcome To My School", messageRead);
                                       // }f

                                        System.out.println("mail is sent \n"+"mailer "+lineSplit[0]+"  reciever "+emailTF.getText()+" message "+messageRead);

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
                           JOptionPane.showMessageDialog(null,emailTF.getText()+" \n "+picAddress.toString(), "Sucessful", 1);
                           System.out.println("thread khtm hon toh badh da nam  "+mailReciever);
                        }else{
                            JOptionPane.showMessageDialog(null,"Student Is not Registered", "Sucessful", 0);
                        }
                       // picAddress = null;
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,ex , "registerButton Fun", 1);
                    }

                    //date="";
                    mailReciever="";
                    }
            });
            
            bottomP.add(print);
            bottomP.add(reset);
            bottomP.add(submit);

            System.out.println("x="+x+" y="+y);

            System.out.println("x="+x+" y="+y);
            //bodyP.setBorder(new LineBorder(Color.GREEN, 6, true));
            bodyP.setBackground(new Color(255,255,255));
            bodyP.setLayout(null);
            bodyP.setPreferredSize(new Dimension(x*80,y*200));
            
            designHeadingP(getWidth()/100,y);
            
            JPanel blockPI=new JPanel();
            blockPI.setLayout(null);
            blockPI.setBounds(x, y*15, bodySP.getWidth()-(x*5), y*19);
            blockPI.setBackground(Color.white);
            
                JLabel heading1L=new JLabel("<html>  <font style=\"font-size:20;\"> Personal Information");
                heading1L.setBounds(0, 0, blockPI.getWidth()-x, y*3);
                heading1L.setOpaque(true);
               // bodyP.add(heading1L);
            
                JLabel nameL=new JLabel("Name");
                nameL.setBounds(x, y*4, x*4, y*3);
               
                salu.setBounds(x*6, y*4, x*15, y*3);
                salu.addItem("--SELECT SALUATION--");
                salu.addItem("Mr.");
                salu.addItem("Ms.");
                
                sFirstName.setBounds(x*24, y*4, x*25, y*3-2);
                sFirstName.setBorder(null);
                sFirstName.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c=e.getKeyChar();
                        if(Character.isDigit(c)){
                            getToolkit().beep();
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) { 
                    }
                });
                JPanel line1=new JPanel();
                line1.setBounds(x*24, y*7-2, x*25, 2);
                line1.setBackground(Color.lightGray);              
           
                sSurName.setBounds(x*53, y*4, x*25, y*3-2);
                sSurName.setBorder(null);
                sSurName.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c=e.getKeyChar();
                        if(Character.isDigit(c)){
                            getToolkit().beep();
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) { 
                    }
                });
                JPanel line2=new JPanel();
                line2.setBounds(x*53, y*7-2, x*25, 2);
                line2.setBackground(Color.lightGray);
                
                JLabel dateL=new JLabel("Date of Birth");
                dateL.setBounds(x, y*8, x*7, y*3);
                
                picker.setBounds(x*8, y*8, x*20, y*3);
                picker.setOpaque(false);
                picker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pickerS=date.convert(picker);
                    }
                });
                picker.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {

                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        pickerS=date.convert(picker);
                }
                });
                
                JLabel birthPL=new JLabel("Place of Birth");
                birthPL.setBounds(x*30, y*8, x*7, y*3);
                birthCTF.setBounds(x*38, y*8, x*25, y*3-2);
                birthCTF.setBorder(null);
                birthCTF.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c=e.getKeyChar();
                        if(Character.isDigit(c)){
                            getToolkit().beep();
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) { 
                    }
                });
                JPanel bPP=new JPanel();
                bPP.setBounds(x*38, y*11-2, x*25, 2);
                bPP.setBackground(Color.lightGray);
                
                JLabel birthSL=new JLabel("Birth State");
                birthSL.setBounds(x*65, y*8, x*7, y*3);
                birthSTF.setBounds(x*73, y*8, x*25, y*3-2);
                birthSTF.setBorder(null);
                birthSTF.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c=e.getKeyChar();
                        if(Character.isDigit(c)){
                            getToolkit().beep();
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) { 
                    }
                });
                JPanel bSP=new JPanel();
                bSP.setBounds(x*73, y*11-2, x*25, 2);
                bSP.setBackground(Color.lightGray);
                
                JLabel genderL=new JLabel("Gender");
                genderL.setBounds(x, y*12, x*4, y*3);
                genderCB.setBounds(x*5, y*12, x*20, y*3);
                genderCB.addItem("--Selecct Gender--");
                genderCB.addItem("Male");
                genderCB.addItem("Female");
                
                JLabel religionL=new JLabel("Religion");
                religionL.setBounds(x*27, y*12, x*4, y*3);
                religionCB.setBounds(x*32,y*12,x*20,y*3);
                religionCB.addItem("--Select Reliigion--");
                religionCB.addItem("Buddhist");
                religionCB.addItem("Christan");
                religionCB.addItem("Hinduism");
                religionCB.addItem("Jainsm");
                religionCB.addItem("Islam");
                religionCB.addItem("Sikh");
                
                JLabel nationL=new JLabel("Nationality");
                nationL.setBounds(x*54, y*12, x*5, y*3);
                nationTF.setBounds(x*60, y*12, x*25, y*3-2);
                nationTF.setBorder(null);
                nationTF.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c=e.getKeyChar();
                        if(Character.isDigit(c)){
                            getToolkit().beep();
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) { 
                    }
                });
                JPanel nationP=new JPanel();
                nationP.setBackground(Color.lightGray);
                nationP.setBounds(x*60, y*15-2, x*25, 2);
                
                JLabel adharL=new JLabel("Student Adhar Number");
                adharL.setBounds(x, y*16, x*10, y*3);
                adharTF.setBounds(x*11,y*16,x*25,y*3-2);
                adharTF.setBorder(null);
                adharTF.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c=e.getKeyChar();
                        if(!Character.isDigit(c) || adharTF.getText().length()>15){
                            getToolkit().beep();
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) { 
                    }
                });
                JPanel adharP=new JPanel();
                adharP.setBackground(Color.lightGray);
                adharP.setBounds(x*11, y*19-2, x*25, 2);
                
            blockPI.add(heading1L);
            blockPI.add(nameL);
            blockPI.add(salu);
            blockPI.add(sFirstName);
            blockPI.add(line1);
            blockPI.add(sSurName);
            blockPI.add(line2);
            blockPI.add(dateL);
            blockPI.add(picker);
            blockPI.add(birthPL);
            blockPI.add(birthCTF);
            blockPI.add(bPP);
            blockPI.add(birthSL);
            blockPI.add(birthSTF);
            blockPI.add(bSP);
            blockPI.add(genderL);
            blockPI.add(genderCB);
            blockPI.add(religionL);
            blockPI.add(religionCB);
            blockPI.add(nationL);
            blockPI.add(nationP);
            blockPI.add(nationTF);
            blockPI.add(adharL);
            blockPI.add(adharP);
            blockPI.add(adharTF);
            
            JPanel blockCI=new JPanel();
            blockCI.setBounds(x, y*35, bodySP.getWidth()-(x*5), y*16);
            blockCI.setLayout(null);
            blockCI.setBackground(Color.white);
            
                JLabel headingCI=new JLabel("<html> <font style=\"font-size:20;\"> Contact Information");
                headingCI.setBounds(x, 0, bodySP.getWidth(), y*3);
                headingCI.setOpaque(true);
                
                JLabel houseL=new JLabel("House Number");
                houseL.setBounds(x, y*3, x*7, y*3);
                hnoTF.setBounds(x*9, y*3, x*20, y*3-2);
                hnoTF.setBorder(null);
                JPanel houseP=new JPanel();
                houseP.setBounds(x*8, y*6-2, x*20, 2);
                houseP.setBackground(Color.lightGray);
                
                JLabel streetL=new JLabel("Street Name");
                streetL.setBounds(x*34, y*3, x*7, y*3);
                streetTF.setBounds(x*41, y*3, x*20, y*3-2);
                streetTF.setBorder(null);
                streetTF.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c=e.getKeyChar();
                        if(Character.isDigit(c)){
                            getToolkit().beep();
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) { 
                    }
                });
                JPanel streetP=new JPanel();
                streetP.setBackground(Color.lightGray);
                streetP.setBounds(x*41, y*6-2, x*20, 2);
                
                JLabel cityL=new JLabel("City");
                cityL.setBounds(x*67, y*3,x*4, y*3);
                cityTF.setBounds(x*71, y*3, x*20, y*3-2);
                cityTF.setBorder(null);
                cityTF.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c=e.getKeyChar();
                        if(Character.isDigit(c)){
                            getToolkit().beep();
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) { 
                    }
                });
                JPanel cityP=new JPanel();
                cityP.setBounds(x*71, y*6-2, x*20, 2);
                cityP.setBackground(Color.lightGray);
                
                JLabel stateL=new JLabel("State");
                stateL.setBounds(x, y*7, x*4, y*3);
                stateTF.setBounds(x*5, y*7, x*20, y*3-2);
                stateTF.setBorder(null);
                stateTF.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c=e.getKeyChar();
                        if(Character.isDigit(c)){
                            getToolkit().beep();
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) { 
                    }
                });
                JPanel stateP=new JPanel();
                stateP.setBounds(x*5, y*10-2, x*20, 2);
                stateP.setBackground(Color.lightGray);
                
                JLabel pinL=new JLabel("PIN");
                pinL.setBounds(x*33, y*7, x*4, y*3);
                pinTF.setBounds(x*38,y*7,x*25,y*3-2);
                pinTF.setBorder(null);
                pinTF.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c=e.getKeyChar();
                        if(!Character.isDigit(c) || pinTF.getText().length()>5){
                            getToolkit().beep();
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) { 
                    }
                });
                JPanel pinP=new JPanel();
                pinP.setBounds(x*39, y*10-2, x*25, 2);
                pinP.setBackground(Color.lightGray);
                
                JLabel contactNoL=new JLabel("Contact Number");
                contactNoL.setBounds(x, y*11, x*10, y*3);
                mobilenoTF.setBounds(x*12,y*11,x*25,y*3-2);
                mobilenoTF.setBorder(null);
                mobilenoTF.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c=e.getKeyChar();
                        if(!Character.isDigit(c) || mobilenoTF.getText().length()>9){
                            getToolkit().beep();
                            e.consume();
                        }
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) { 
                    }
                });
                JPanel contactNoP=new JPanel();
                contactNoP.setBounds(x*12, y*14-2,x*25 , 2);
                contactNoP.setBackground(Color.lightGray);
                
                JLabel contactEmailL=new JLabel("Email");
                contactEmailL.setBounds(x*45, y*11, x*5, y*3);
                emailTF.setBounds(x*52, y*11, x*25, y*3-2);
                emailTF.setBorder(null);
                emailTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!emailTF.getText().contains("@")){
                    JOptionPane.showMessageDialog(null, "Use @ in mail id", "Error", 0);
                    emailTF.setText("");
                }
                if(!emailTF.getText().contains(".com")){
                    JOptionPane.showMessageDialog(null, "Use .com in end ofl id", "Error", 0);
                    emailTF.setText("");
                }
            }
        });
                JPanel contactEmailP=new JPanel();
                contactEmailP.setBounds(x*52, y*14-2, x*25, 2);
                contactEmailP.setBackground(Color.lightGray);
                
            blockCI.add(headingCI);           
            blockCI.add(houseL);
            blockCI.add(hnoTF);
            blockCI.add(houseP);
            blockCI.add(streetL);
            blockCI.add(streetTF);
            blockCI.add(streetP);
            blockCI.add(cityL);
            blockCI.add(cityTF);
            blockCI.add(cityP);
            blockCI.add(stateL);
            blockCI.add(stateTF);
            blockCI.add(stateP);
            blockCI.add(pinL);
            blockCI.add(pinTF);
            blockCI.add(pinP);
            blockCI.add(contactNoL);
            blockCI.add(mobilenoTF);
            blockCI.add(contactNoP);
            blockCI.add(contactEmailL);
            blockCI.add(emailTF);
            blockCI.add(contactEmailP);
            
            JPanel blockFI=new JPanel();
            blockFI.setBounds(x, y*51, bodySP.getWidth(), y*10);
            blockFI.setLayout(null);        
            blockFI.setBackground(Color.white);
            
                JLabel headingFI=new JLabel("<html> <font style=\"font-size:20;\"> Family Information");
                headingFI.setBounds(x, 0, bodySP.getWidth()-(x*5), y*3);
                headingFI.setOpaque(true);
                
                JLabel fnameL=new JLabel("Father Name");
                fnameL.setBounds(x, y*3, x*7, y*3);
                fnameTF.setBounds(x*8,y*3,x*20,y*3-2);
                fnameTF.setBorder(null);
                JPanel fnameP=new JPanel();
                fnameP.setBounds(x*8, y*6-2,x*20, 2);
                fnameP.setBackground(Color.lightGray);
                
                JLabel foccuL=new JLabel("Father Occupation");
                foccuL.setBounds(x*31, y*3, x*10, y*3);
                foccuTF.setBounds(x*42,y*3,x*20,y*3-2);
                foccuTF.setBorder(null);
                JPanel foccuP=new JPanel();
                foccuP.setBounds(x*42, y*6-2,x*20, 2);
                foccuP.setBackground(Color.lightGray);
                
                JLabel fcnoL=new JLabel("Contact Number");
                fcnoL.setBounds(x*64, y*3, x*10, y*3);
                fcnoTF.setBounds(x*75,y*3,x*18,y*3-2);
                fcnoTF.setBorder(null);
                JPanel fcnoP=new JPanel();
                fcnoP.setBounds(x*75, y*6-2,x*18, 2);
                fcnoP.setBackground(Color.lightGray);
                
                JLabel mnameL=new JLabel("Mother Name");
                mnameL.setBounds(x, y*7, x*7, y*3);
                mnameTF.setBounds(x*8,y*7,x*20,y*3-2);
                mnameTF.setBorder(null);
                JPanel mnameP=new JPanel();
                mnameP.setBounds(x*8, y*10-2,x*20, 2);
                mnameP.setBackground(Color.lightGray);
                
                JLabel moccuL=new JLabel("Mother Occupation");
                moccuL.setBounds(x*31, y*7, x*10, y*3);
                moccuTF.setBounds(x*42,y*7,x*20,y*3-2);
                moccuTF.setBorder(null);
                JPanel moccuP=new JPanel();
                moccuP.setBounds(x*42, y*10-2,x*20, 2);
                moccuP.setBackground(Color.lightGray);
                
                JLabel mcnoL=new JLabel("Mother Number");
                mcnoL.setBounds(x*64, y*7, x*10, y*3);
                mcnoTF.setBounds(x*75,y*7,x*18,y*3-2);
                mcnoTF.setBorder(null);
                JPanel mcnoP=new JPanel();
                mcnoP.setBounds(x*75, y*10-2,x*18, 2);
                mcnoP.setBackground(Color.lightGray);
                                
            blockFI.add(headingFI);
            blockFI.add(fnameL);
            blockFI.add(fnameTF);
            blockFI.add(fnameP);
            blockFI.add(foccuL);
            blockFI.add(foccuTF);
            blockFI.add(foccuP);
            blockFI.add(fcnoL);
            blockFI.add(fcnoTF);
            blockFI.add(fcnoP);
            blockFI.add(mnameL);
            blockFI.add(mnameTF);
            blockFI.add(mnameP);
            blockFI.add(moccuL);
            blockFI.add(moccuTF);
            blockFI.add(moccuP);
            blockFI.add(mcnoL);
            blockFI.add(mcnoTF);
            blockFI.add(mcnoP);
            
            JPanel blockAQ=new JPanel();
            blockAQ.setBackground(Color.white);
            blockAQ.setBounds(x, y*62, bodySP.getWidth(), y*15);
            blockAQ.setLayout(null);
            
                JLabel headingHQ=new JLabel("<html> <font style=\"font-size:20;\">Academic Qualification");
                headingHQ.setBounds(x, 0,bodySP.getWidth()-(x*5), y*3);
                headingHQ.setOpaque(true);
                
                JLabel hqL=new JLabel("Highest Qualification");
                hqL.setBounds(x, y*4, x*10, y*3);
                
                JPanel label=new JPanel();
                label.setBackground(Color.white);
                label.setLayout(null);
                label.setBounds(x, y*8, blockAQ.getWidth(), y*7);
                
                    JLabel clsL=new JLabel("<html> <pre>      Class");
                    clsL.setBounds(0, 2, x*7-2, (y*3));
                    clsL.setOpaque(true);
                    clsL.setBackground(Color.BLUE);
                    clsL.setForeground(Color.white);
                    
                    JLabel schL=new JLabel("<html> <pre>        Institute");
                    schL.setBounds(x*7, 2, x*25-2, (y*3));
                    schL.setOpaque(true);
                    schL.setBackground(Color.BLUE);
                    schL.setForeground(Color.white);
                    
                    JLabel boardL=new JLabel("<html> <pre>        Board/University");
                    boardL.setBounds(x*32, 2, x*25-2, (y*3));
                    boardL.setOpaque(true);
                    boardL.setBackground(Color.BLUE);
                    boardL.setForeground(Color.white);
                    
                    JLabel marksL=new JLabel("<html> <pre>        Percentage");
                    marksL.setBounds(x*57, 2, x*25-2, (y*3));
                    marksL.setOpaque(true);
                    marksL.setBackground(Color.BLUE);
                    marksL.setForeground(Color.white);
                    
                    JLabel dateLL=new JLabel("<html> <pre>     Date");
                    dateLL.setBounds(x*82, 2, x*12-2, (y*3));
                    dateLL.setOpaque(true);
                    dateLL.setBackground(Color.BLUE);
                    dateLL.setForeground(Color.white);
                    
                    JLabel classL=new JLabel("");
                    classL.setBounds(0, (y*4), x*7-2, (y*3));
                    classL.setOpaque(true);
                    classL.setBackground(Color.BLUE);
                    classL.setForeground(Color.white);
                    
                    instinTF.setBounds(x*7, y*4, x*25-2, (y*3));
                    
                    boardTF.setBounds(x*32, y*4, x*25-2, (y*3));
                    
                    percenTF.setBounds(x*57, y*4, x*25-2, (y*3));
                    
                    courseCompDP.setBounds(x*82, y*4, x*12-2, (y*3));;
                 
                label.add(clsL);
                label.add(schL);
                label.add(boardL);
                label.add(marksL);
                label.add(dateLL);
                label.add(classL);
                label.add(instinTF);
                label.add(boardTF);
                label.add(percenTF);
                label.add(courseCompDP);
                
                label.setVisible(false);
                    
                hqCB.setBounds(x*12, y*4, x*20, y*3);
                fillSelectClassCB(hqCB);
                hqCB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        classL.setText(hqCB.getSelectedItem().toString());
                        label.setVisible(true);
                    }
                });
                
                
            blockAQ.add(headingHQ);
            blockAQ.add(hqL);
            blockAQ.add(hqCB);
            blockAQ.add(label);
            
            JPanel blockI=new JPanel();
            blockI.setLayout(null);
            blockI.setBounds(x, y*78, bodySP.getWidth(), y*12);
            blockI.setBackground(Color.white);
            
                JLabel ppL=new JLabel("<html> <font style=\"font-size:20;\">Student Image");
                ppL.setBounds(x, 0, bodySP.getWidth()-(x*5), y*3);
                ppL.setOpaque(true);
            
                profilePicL.setBounds(x, y*3, x*10, blockI.getHeight()-(y*3));
                profilePicL.setBorder(new LineBorder(Color.black, 2, true));
                try {
                    profilePicL.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/img/blank.png")).getScaledInstance(profilePicL.getWidth(), profilePicL.getHeight(), 4)));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex, "ERROR", 1);
                }
                profilePicL.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                        picAddress=null;
                        int r= fileChooserFC.showDialog(null,null);
                        if(r == JFileChooser.APPROVE_OPTION){
                            File str=fileChooserFC.getSelectedFile().getAbsoluteFile(); //sttr used to get file location
                            try{
                                picAddress=new FileInputStream(str);//pic address is used to convert file to image stream
                            }catch(FileNotFoundException ex){
                                System.err.println("not foundc"+ex.getStackTrace());
                            }
                            imgPath=str.getAbsolutePath();
                            System.out.println(str.getAbsolutePath());
                            System.out.println(str);
                            System.out.println("setPic "+ str);
                            System.out.println("picAddress "+ str);

                            try {

                                profilePicL.setIcon(new ImageIcon(ImageIO.read(str).getScaledInstance(profilePicL.getWidth(), profilePicL.getHeight(), 4)));
                            } catch (IOException ex) {
                                System.err.println("error uploading a pic "+ex.getStackTrace());

                            }
                            catch (NullPointerException ex) {
                                javax.swing.JOptionPane.showMessageDialog(null, "Wrong File Format", "Select only .jpg or .png", 1);
                                mouseClicked(e);
                            }
                        }
                        else{
                            System.out.println("no file selected");
                        }
                        //bodyP.setVisible(false);
                        System.out.println("image clicked");
                    }
                    public void mousePressed(MouseEvent e) {
                    }
                    public void mouseReleased(MouseEvent e) {
                    }
                    public void mouseEntered(MouseEvent e) {
                    }
                    public void mouseExited(MouseEvent e) {
                    }
                });
            
            blockI.add(ppL);            
            blockI.add(profilePicL);            
           
        JPanel blockCD=new JPanel();
        blockCD.setLayout(null);
        blockCD.setBackground(Color.white);
        blockCD.setBounds(x, y*91, bodySP.getWidth(), y*40);
            
            JLabel headCD=new JLabel("<html> <font style=\"font-size:20;\">Select Course");
            headCD.setBounds(x, 0, bodySP.getWidth()-(x*5), y*3);
            headCD.setOpaque(true);
            
            scCB.setBounds(x, y*4, x*20, y*3);
            fillSelectClassCB(scCB);
            scCB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    writeInfo(scCB.getSelectedIndex());
                    System.out.println("index= "+scCB.getSelectedIndex());
                }
            });
            
            payingTF.setBounds(x*25, y*4, x*20, y*3-2);
            payingTF.setText("enter Amount");
            payingTF.setBorder(null);
            payingTF.setOpaque(false);
            payingTF.setForeground(Color.gray);
            payingP.setBounds(x*25, y*7-2, x*20, 2);
            payingP.setBackground(Color.black);
            
            classInfoSP.setBounds(x, y*8, blockCD.getWidth()-(x*5), y*12);
            classInfoSP.setViewportView(classInfoTA);
            classInfoSP.setHorizontalScrollBarPolicy(ScrollPaneLayout.HORIZONTAL_SCROLLBAR_NEVER);

            classInfoTA.setPreferredSize(new Dimension(x*100,y*12));
            classInfoTA.setRows(4);
            classInfoTA.setColumns(10);
            classInfoTA.setEditable(false);
            classInfoTA.setLayout(null);
        
        blockCD.add(headCD);
        blockCD.add(scCB);
        blockCD.add(payingTF);
        blockCD.add(payingP);
        blockCD.add(classInfoSP);
        
       bodyP.add(headingP);
       // bodyP.add(heading1L);
       bodyP.add(blockPI);
       bodyP.add(blockCI);
       bodyP.add(blockFI);
       bodyP.add(blockAQ);
       bodyP.add(blockI);
       bodyP.add(blockCD);
  
       bodyP.setVisible(true);
       }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Fake Your device is not compatible");
    }
    }
    
    void hid(){
        setVisible(false);
    }
    
    void sho(){
        setVisible(true);
    }

    
    void fillSelectClassCB(JComboBox cb){
        try{
        cb.removeAllItems();
        
        cb.addItem("select class");
        try {
            
            conn.pre_s=conn.conn.prepareStatement("Select Name,Id from courses order by Id");
            conn.r_set=conn.pre_s.executeQuery();
            
            while(conn.r_set.next()){
                cb.addItem(conn.r_set.getString(1)+"      "+conn.r_set.getInt(2));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", 1);
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Fake Your device is not compatible");
    }
    }
    
    void writeInfo(int val){
        
        stR="=";
        for(int i=0;i<bodySP.getWidth();i++){
            stR+="=";
        }
        //stR+="\n";
        fee=0;
       try {
            conn.pre_s=conn.conn.prepareStatement("SELECT Fee From courses where Id = ?");
            conn.pre_s.setInt(1,val);
            conn.r_set=conn.pre_s.executeQuery();
            
            //stR+="COURSE FEE:                   ";
            
            while(conn.r_set.next()){
                //stR+=fee+=conn.r_set.getInt(1);
                fee+=conn.r_set.getInt(1);
            }
           // stR+="\n";
            for(int i=0;i<bodySP.getWidth();i++){
                //stR+="=";
            }
                    
            stR+="\n SUBJECT-      ";
            
            conn.pre_s=conn.conn.prepareStatement("SELECT Name From subjects where CourseId = ?");
            conn.pre_s.setInt(1,val);
            conn.r_set=conn.pre_s.executeQuery();
            
            while(conn.r_set.next()){
                stR+=" \" "+conn.r_set.getString(1).toUpperCase()+" \" ,";
                System.out.println(conn.r_set.getString(1).toUpperCase());
            }
            
            stR+="\n";
            for(int i=0;i<bodySP.getWidth();i++){
                stR+="=";
            }
            //stR+="\n Admission Fee:                 ";
            
            conn.pre_s=conn.conn.prepareStatement("SELECT AdmissionFee From courses where Id = ?");
            conn.pre_s.setInt(1,val);
            conn.r_set=conn.pre_s.executeQuery();
            
            while(conn.r_set.next()){
                //stR+=conn.r_set.getInt(1);
                fee+=conn.r_set.getInt(1);
            }
            
            //stR+="\n";
            for(int i=0;i<bodySP.getWidth();i++){
               // stR+="=";
            }
            //stR+="\nPer Month Fee:                 ";
            
            conn.pre_s=conn.conn.prepareStatement("SELECT PerMFee From courses where Id = ?");
            conn.pre_s.setInt(1,val);
            conn.r_set=conn.pre_s.executeQuery();
            
            while(conn.r_set.next()){
                //stR+=conn.r_set.getInt(1);
                fee+=conn.r_set.getInt(1);
            }
            
            //stR+="\n";
            for(int i=0;i<bodySP.getWidth();i++){
                //stR+="=";
            }
            //stR+="\nExamination Fee:                 ";
            
            conn.pre_s=conn.conn.prepareStatement("SELECT ExamFee From courses where Id = ?");
            conn.pre_s.setInt(1,val);
            conn.r_set=conn.pre_s.executeQuery();
            
            while(conn.r_set.next()){
                //stR+=conn.r_set.getInt(1);
                fee+=conn.r_set.getInt(1);
            }
            
            //stR+="\n";
            for(int i=0;i<bodySP.getWidth();i++){
                //stR+="=";
            }
            stR+="\nTotal Fee:                      "+fee;
            
            /*try {
                classInfoTA.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error", 1);
            }*/
            
            classInfoTA.setText(stR);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "writeInfo()"+ex, "writeinfo", 1);
        }
    }
    
    void reset(){
        try{
        try {
            salu.setSelectedIndex(0);
            sFirstName.setText("");sSurName.setText("");
            picker.setDate(null);birthCTF.setText("");birthSTF.setText("");
            genderCB.setSelectedIndex(0);religionCB.setSelectedIndex(0);nationTF.setText("");
            adharTF.setText("");
            hnoTF.setText("");streetTF.setText("");cityTF.setText("");
            stateTF.setText("");pinTF.setText("");mobilenoTF.setText("");emailTF.setText("");
            fnameTF.setText("");foccuTF.setText("");fcnoTF.setText("");
            mnameTF.setText("");moccuTF.setText("");mcnoTF.setText("");
            hqCB.setSelectedIndex(0);instinTF.setText("");boardTF.setText("");percenTF.setText("");courseCompDP.setDate(null);
            profilePicL.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/img/blank.png")).getScaledInstance(profilePicL.getWidth(), profilePicL.getHeight(), 4)));;
            } catch (IOException ex) {
                Logger.getLogger(AddNewStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
            scCB.setSelectedIndex(0);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Fake Your device is not compatible");
    }
    }

    
}
