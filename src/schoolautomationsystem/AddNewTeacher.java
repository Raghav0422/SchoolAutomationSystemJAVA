package schoolautomationsystem;

import com.sun.imageio.plugins.jpeg.JPEG;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.MouseInputListener;
import org.jdesktop.swingx.JXDatePicker;

public class AddNewTeacher extends JPanel{

    JPanel body;
    
    JScrollPane sp=new JScrollPane();
    
    JLabel logo;
    JLabel name;
    JLabel fpic;
    JPanel line;
    
    JLabel heading;
    
    JLabel heading2;
    JPanel block;
    JLabel text;
    JComboBox post;
    JLabel text2;
    JComboBox pref;
    String prefs;
    JLabel text3;
    JComboBox pref2;
    String pref2s;
    
    JLabel heading3;
    JPanel block2;
    JLabel text4;
    JComboBox salu;//saluation Mr,Mrs
    JTextField fname;
    JPanel line1;
    JTextField lname;
    JPanel line2;
    JLabel text5;
    JXDatePicker picker;
    String pickerS="";
    JLabel text6;
    JTextField bplace;
    JPanel line3;
    JLabel text7;
    JTextField bstate;
    JPanel line4;
    JLabel text8;
    JComboBox gender;
    JLabel text9;
    JComboBox religion;
    JLabel text10;
    JTextField natlty;
    JPanel line5;
    JLabel text11;
    JComboBox mstatus;
    JLabel text12;
    JTextField adhar;
    JPanel line6;
    JLabel text13;
    JTextField pan;
    JPanel line7;
    
    JLabel heading4;
    JPanel block3;
    JLabel text14;
    JTextField hno;
    JPanel line8;
    JLabel text15;
    JTextField sname;
    JPanel line9;
    JLabel text16;
    JTextField city;
    JPanel line10;
    JLabel text17;
    JTextField state;
    JPanel line11;
    JLabel text18;
    JTextField pin;
    JPanel line12;
    JLabel text19;
    JTextField mno;
    JPanel line13;
    JLabel text20;
    JTextField email;
    JPanel line14;
    
    JLabel heading5;
    JPanel block4;
    JLabel text21;
    JTextField pname;
    JPanel line15;
    JLabel text22;
    JTextField pocc;
    JPanel line16;
    JLabel text23;
    JTextField pcno;
    JPanel line17;
    JLabel text24;
    JTextField mname;
    JPanel line18;
    JLabel text25;
    JTextField mocc;
    JPanel line19;
    JLabel text26;
    JTextField mcno;
    JPanel line20;
    
    JLabel heading6;
    JPanel block5;
    JLabel text27;
    JComboBox course;
    JLabel text28;
    JComboBox bed;
    
    JLabel heading7;
        JButton tenB=new JButton("<html> X<sup>th");
        JButton plus2B=new JButton("<html> XII<sup>th");
        JButton graduB=new JButton("<html> Graduation");
        JButton pgraduB=new JButton("<html> Post Graduation");
        JButton doctorateB=new JButton("<html> Doctorate");
        JButton mphillB=new JButton("<html> M.phill");                    
        JButton add=new JButton("<html> Add++");
    JPanel label;
    JPanel tenP;
        JTextField tinsTF;
        JTextField tboardTF;
        JTextField tperTF;
        JXDatePicker tpicker;
        String tpickers="";
    JPanel plus2P;
        JTextField plinsTF;
        JTextField plboardTF;
        JTextField plperTF;
        JXDatePicker plpicker;
        String plpickers="";
    JPanel graduP;
        JTextField ginsTF;
        JTextField gboardTF;
        JTextField gperTF;
        JXDatePicker gpicker;
        String gpickers="";
    JPanel pgraduP;
        JTextField pginsTF;
        JTextField pgboardTF;
        JTextField pgperTF;
        JXDatePicker pgpicker;
        String pgpickers="";
    JPanel doctorateP;
        JTextField dinsTF;
        JTextField dboardTF;
        JTextField dperTF;
        JXDatePicker dpicker;
        String dpickers="";
    JPanel mphillP;
        JTextField minsTF;
        JTextField mboardTF;
        JTextField mperTF;
        JXDatePicker mpicker;
        String mppickers="";
        
    JButton print;
    
    String imgPath;
    
    MyConnection mycon=new MyConnection();
    
    DateModifier date =new DateModifier();
    
    int id=0;
    String pass="";
    
    public AddNewTeacher() {
    }
    
    void design(int x,int y){
        try{
        renew();
        setLayout(null);
        setBounds(0,0,x*105,y*100);
        setBackground(Color.red);
        setVisible(true);
        
        sp.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode()==17  && e.getKeyCode()==80){
                    new Print(body);
                }
                System.out.println("T "+e.getKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==17  && e.getKeyCode()==80){
                    new Print(body);
                }
                System.out.println("P "+e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==17  && e.getKeyCode()==80){
                    new Print(body);
                }
                System.out.println("R "+e.getKeyCode());
            }
        });
        sp.setBounds(0, 0, getWidth(), y*90);
        sp.setViewportView(body);
        //sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        JPanel bholder=new JPanel();
        bholder.setBounds(0, y*91, getWidth(), y*8);
        bholder.setLayout(new GridLayout(1, 3));
        
            print.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Print(body);
                }
            });

            buttonDeco(print);
            
            int xx=x,yy=y;
            
            JButton clear =new JButton("<html>  <font style=\"font-size:20;\">Reset");
            clear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    design(xx,yy);
                }
            });
            
            buttonDeco(clear);
            
            JButton  submit=new JButton("<html>  <font style=\"font-size:20;\">Submit");
            submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(check()==0){
                //if(false){    
                }              
                else{
                    try{
                        
                      //  mycon.pre_s=mycon.conn.prepareStatement("insert into teacher(id) values(?)");
                      //  mycon.pre_s.setInt(1, 2);
                        
                        mycon.pre_s=mycon.conn.prepareStatement("insert into teacher (subjectpref1,subjectpref2,teachercol,salution,"
                                + "firstname,lastname,dob,birthCity,birthState,gender,religion,nationality,martialStatus,adharcardno,pancardno,"
                                + "housenumber,streetName,city,state,pin,mobileno,email,fathername,fatherOccupation,fatherContactNumber,"
                                + "motherName,motheroccupation,mothercontactnumber,highestQualification,bed,XIN,XBoard,Xper,Xdate,XIIIN,XIIIBoard,"
                                + "XIIper,XIIdate,GIN,GUniversity,Graduationper,Gdate,PGIN,PGUniversity,PGper,PGdate,MPhillIN,MphillUniversity,MPhillper,"
                                + "MPhilldate,DIN,DUniversity,Dper,Ddate,pic) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                        mycon.pre_s.setString(1, pref.getSelectedItem().toString());
                        mycon.pre_s.setString(2, pref2.getSelectedItem().toString());
                        mycon.pre_s.setString(3, post.getSelectedItem().toString());
                        mycon.pre_s.setString(4, salu.getSelectedItem().toString());
                        mycon.pre_s.setString(5, fname.getText());
                        mycon.pre_s.setString(6, lname.getText());
                        System.out.println("pickers Value="+pickerS);
                        Date d=null;
                        d=Date.valueOf(pickerS);
                        System.out.println("date d vali="+d);
                        if(pickerS==""){
                            mycon.pre_s.setDate(7, null);
                        }
                        else{
                            mycon.pre_s.setDate(7, d);
                        }
                        mycon.pre_s.setString(8, bplace.getText());
                        mycon.pre_s.setString(9, bstate.getText());
                        mycon.pre_s.setString(10, gender.getSelectedItem().toString());
                        mycon.pre_s.setString(11, religion.getSelectedItem().toString()); 
                        mycon.pre_s.setString(12, natlty.getText());
                        mycon.pre_s.setString(13, mstatus.getSelectedItem().toString());
                        mycon.pre_s.setString(14, adhar.getText());
                        if(pan.getText()==""){
                            mycon.pre_s.setInt(15, 0 );
                        }else{
                            mycon.pre_s.setString(15,pan.getText());
                        }
                        
                        mycon.pre_s.setString(16, hno.getText());
                        mycon.pre_s.setString(17, sname.getText());
                        mycon.pre_s.setString(18, city.getText());
                        mycon.pre_s.setString(19, state.getText());
                        mycon.pre_s.setInt(20, Integer.parseInt(pin.getText()));
                        mycon.pre_s.setString(21, mno.getText());
                        mycon.pre_s.setString(22, email.getText());
                        mycon.pre_s.setString(23, pname.getText());
                        mycon.pre_s.setString(24, pocc.getText());
                        mycon.pre_s.setString(25, pcno.getText());
                        mycon.pre_s.setString(26, mname.getText());
                        mycon.pre_s.setString(27, mocc.getText());
                        mycon.pre_s.setString(28, mcno.getText());
                        mycon.pre_s.setString(29, course.getSelectedItem().toString()); 
                        mycon.pre_s.setString(30, bed.getSelectedItem().toString()); 
                        mycon.pre_s.setString(31, tinsTF.getText());
                        mycon.pre_s.setString(32, tboardTF.getText());
                        mycon.pre_s.setString(33, tperTF.getText());
                        if(tpickers==""){
                            mycon.pre_s.setDate(34, null);
                        }else{
                            mycon.pre_s.setDate(34, Date.valueOf(tpickers));
                        }
                        mycon.pre_s.setString(35, plinsTF.getText());
                        mycon.pre_s.setString(36, plboardTF.getText());
                        mycon.pre_s.setString(37,plperTF.getText());
                        if(plpickers==""){
                            mycon.pre_s.setDate(38, null);
                        }else{
                            mycon.pre_s.setDate(38, Date.valueOf(plpickers));
                        }
                        mycon.pre_s.setString(39, ginsTF.getText());
                        mycon.pre_s.setString(40, gboardTF.getText());
                        mycon.pre_s.setString(41, gperTF.getText());
                        if(gpickers==""){
                            mycon.pre_s.setDate(42, null);
                        }else{
                            mycon.pre_s.setDate(42, Date.valueOf(gpickers));
                        }
                        mycon.pre_s.setString(43, pginsTF.getText());
                        mycon.pre_s.setString(44, pgboardTF.getText());
                        mycon.pre_s.setString(45,pgperTF.getText());
                        if(pgpickers==""){
                            mycon.pre_s.setDate(46, null);
                        }else{
                            mycon.pre_s.setDate(46, Date.valueOf(pgpickers));
                        }
                        mycon.pre_s.setString(47, minsTF.getText());
                        mycon.pre_s.setString(48, mboardTF.getText());
                        mycon.pre_s.setString(49,mperTF.getText());
                        if(mppickers==""){
                            mycon.pre_s.setDate(50, null);
                        }else{
                            mycon.pre_s.setDate(50, Date.valueOf(mppickers));
                        }
                        mycon.pre_s.setString(51, dinsTF.getText());
                        mycon.pre_s.setString(52, dboardTF.getText());
                        mycon.pre_s.setString(53, dperTF.getText());
                        if(dpickers==""){
                            mycon.pre_s.setDate(54, null);
                        }else{
                            mycon.pre_s.setDate(54, Date.valueOf(dpickers));
                        }
                        mycon.pre_s.setString(55, imgPath);
                        
                        int num=mycon.pre_s.executeUpdate();
     
                                        try{
                                            System.out.println("second");
                                            mycon.pre_s=mycon.conn.prepareStatement("select max(id) from teacher");
                                            mycon.r_set=mycon.pre_s.executeQuery();
                                            while(mycon.r_set.next()){
                                                id=mycon.r_set.getInt(1);
                                            }
                                        }catch(SQLException ex){
                                            JOptionPane.showMessageDialog(null, ex,"SubBAP Thread max(id)",1);
                                        }
                                                                        
                                        pass=fname.getText().substring(0, 3)+lname.getText().substring(0,3)+id;
                                        
                                        String cat=post.getSelectedItem().toString().toLowerCase().substring(0, 1);
                                        
                                        try{  
                                            System.out.println("third");
                                            mycon.pre_s=mycon.conn.prepareStatement("insert into user (Id,email,password,category,date)"
                                                    + "values(?,?,?,?,?)");
                                            mycon.pre_s.setString(1, ""+id);
                                            mycon.pre_s.setString(2,email.getText().trim());
                                            mycon.pre_s.setString(3,pass);
                                            mycon.pre_s.setString(4,cat);
                                            LocalDate dd=LocalDate.now();
                                            mycon.pre_s.setDate(5,java.sql.Date.valueOf(dd));
                                            if(mycon.pre_s.executeUpdate()>0){
                                                System.out.println("entery done in users");
                                            }
                                        }catch(SQLException ex){
                                            JOptionPane.showMessageDialog(null, ex,"Sub BAP insert user",1);
                                        }
                        
                        if(num>0){
                            JOptionPane.showMessageDialog(null,post.getSelectedItem()+" Is Registered", "Sucessful", JOptionPane.PLAIN_MESSAGE);
                           // AddNewStudent obj=new AddNewStudent();
                            //obj.email.setText(email.getText());
                            System.out.println("thread start hon toh pehla naam   "+email.getText()+"  obj value=  "+email.getText());
                            Thread mail=new Thread(new Runnable() {
                                @Override
                                public void run() {

                                     System.out.println("starting mail thread");

                                    try{
                                        System.out.println("1");
                                        FileReader senderfr=new FileReader("mailerInfo.txt");
                                        System.out.println("2");
                                        BufferedReader senderbr= new BufferedReader(senderfr);
                                        System.out.println("3");
                                        String lineRead,s1,messageRead="";
                                        lineRead=senderbr.readLine();
                                        String[] lineSplit=lineRead.split(":");
                                        
                                        System.out.println("4");
                                        FileReader messagefr=new FileReader("welComMaiTea.txt");
                                        System.out.println("5");
                                        BufferedReader messagebr= new BufferedReader(messagefr);
                                        System.out.println("6");
                                        messageRead="Dear "+fname.getText()+ ""+lname.getText();
                                        
                                        while((s1=messagebr.readLine())!=null){
                                            messageRead+="\n"+s1;
                                        }
                                        
                                        
                                        messageRead+="\n\n Your "+post.getSelectedItem()+" Id and password is as follows \n Id   "+id+"\n Password   "+pass;
                                        System.out.println("my id= "+lineSplit[0]+"pass="+lineSplit[1]);
                                        System.out.println("for Reciever checking ki naam ehdr thk aanda hai k nhi  "+email.getText());

                                       // if(JOptionPane.showConfirmDialog(null, "mailer "+lineSplit[0]+"  reciever "+email.getText()+" message "+messageRead, "Check", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
                                            Mailer.send(lineSplit[0], lineSplit[1], email.getText(), "Welcome To My School", messageRead);
                                       // }f

                                        System.out.println("mail is sent \n"+"mailer "+lineSplit[0]+"  reciever "+email.getText()+" message "+messageRead);

                                    }catch(IOException e){
                                        System.err.println("input output"+e.getStackTrace());
                                    }catch(ArrayIndexOutOfBoundsException e){
                                        System.err.println("Array"+e.getStackTrace());
                                    }/*catch(Exception e){
                                        System.err.println("exceptoion"+e.getStackTrace());
                                    }*/
                                    System.out.println("existing mail thread");

                                }
                            });
                            mail.start();
                          // JOptionPane.showMessageDialog(null,email.getText()+" \n "+picAddress.toString(), "Sucessful", 1);
                           //System.out.println("thread khtm hon toh badh da nam  "+mailReciever);
                        }else{
                            JOptionPane.showMessageDialog(null,"Teacher Is not Registered", "Not Sucessful", 0);
                        }

                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, ex, "SQL teacher Submit", 0);
                        System.out.println("SQl teacher submit "+ex);
                        ex.printStackTrace();
                    }
                    catch(NullPointerException ex){
                        JOptionPane.showMessageDialog(null, ex, "Null teacher Submit", 0);
                        System.out.println("Null teacher submit "+ex);
                        ex.printStackTrace();
                    }
                }
            }
        });
            
        buttonDeco(submit);
        
        bholder.add(print);    
        bholder.add(clear);
        bholder.add(submit);
            
        add(sp);
        add(bholder);
        
        //setVisible(true);
        
        x=getWidth()/100;y=7;
        System.out.println("yrr="+y);
        
        body.setPreferredSize(new Dimension(getWidth()-(x*2), y*150));
        body.setVisible(true);
        body.setBackground(Color.white);
        body.setLayout(null);
        
        logo.setBounds(x, y,x*10 , y*10);

        name.setBounds(x*11, y, x*40, y*10);
        
        fpic.setBounds(x*85, 4, x*12, y*15);

        line.setBounds(x, y*10, getWidth()-(x*3), 3);
        line.setBackground(Color.lightGray);

        heading.setBounds(x*30, y*11, x*40, y*4);

        heading2.setBounds(x, y*16, getWidth()-(x*3), y*3);
        heading2.setOpaque(true);

        block.setBounds(x, y*19,getWidth()-(x*3) , y*3);
        block.setLayout(null);
        block.setBackground(Color.white);

            text.setBounds(x, 0, x*10, block.getHeight());

            post.setBounds(x*10, 0, x*15, block.getHeight());
            post.addItem("--SELECT POST--");
            post.addItem("Teacher");
            post.addItem("Clerk");
            
            text2.setBounds(x*35, 0, x*12, block.getHeight());

            pref.setBounds(x*47, 0, x*15, block.getHeight());
            pref.addItem("--SELECT SUBJECTS--");
            pref.addItem("English");
            pref.addItem("Math");
            pref.addItem("Hindi");
            pref.addItem("Punjabi");
            pref.addItem("Science");
            
            text3.setBounds(x*70, 0, x*12, block.getHeight());

            pref2.setBounds(x*82, 0, x*15, block.getHeight());
            pref2.addItem("--SELECT SUBJECTS--");
            pref2.addItem("English");
            pref2.addItem("Math");
            pref2.addItem("Hindi");
            pref2.addItem("Punjabi");
            pref2.addItem("Science");
            
            
            pref.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pref2.removeAllItems();
                    pref2.addItem("--SELECT SUBJECTS--");
                    pref2.addItem("English");
                    pref2.addItem("Math");
                    pref2.addItem("Hindi");
                    pref2.addItem("Punjabi");
                    pref2.addItem("Science");
                    pref2.removeItem(pref.getSelectedItem());
                }
            });
            
        block.add(post);
        block.add(text);
        block.add(pref);
        block.add(text2);
        block.add(pref2);
        block.add(text3);
       
        heading3.setBounds(x, y*23, getWidth()-(x*3), y*3);
        heading3.setOpaque(true);
        
        block2.setBounds(x, y*28,getWidth()-(x*3) , y*15);
        block2.setLayout(null);
        block2.setBackground(Color.white);
        
            text4.setBounds(x, 0, x*5, y*3);
            
            salu.setBounds(x*5, 0,x*15,y*3);
            salu.addItem("--SELECT SALUTION--");
            salu.addItem("Mr");
            salu.addItem("Mrs");
            
            fname.setBounds(x*22, 0,x*30,y*3);
            fname.setBorder(null);
            fname.setOpaque(false);
            fname.setText("First Name");
            fname.setForeground(Color.lightGray);
            textRemove(fname);
            
            line1.setBounds(x*22, y*3-2,x*30,2);
            line1.setBackground(Color.lightGray);
            
            lname.setBounds(x*54, 0,x*30,y*3);
            lname.setBorder(null);
            lname.setOpaque(false);
            lname.setText("Last Name");
            lname.setForeground(Color.lightGray);
            textRemove(lname);
            
            line2.setBounds(x*54,y*3-2,x*30,2);
            line2.setBackground(Color.lightGray);
            
            text5.setBounds(x, y*4, x*7, y*3);
            picker.setBounds(x*8, y*4, x*25, y*3);
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
            
            text6.setBounds(x*35, y*4, x*7, y*3);
            bplace.setBounds(x*42, y*4, x*25, y*3-2);
            bplace.setBorder(null);
            bplace.setOpaque(false);
            bplace.setText("City");
            bplace.setForeground(Color.lightGray);
            textRemove(bplace);
            line3.setBounds(x*42, y*7-2, x*25, 2);
            line3.setBackground(Color.lightGray);
            
            text7.setBounds(x*69, y*4, x*7, y*3);
            bstate.setBounds(x*76, y*4, x*25, y*3-2);
            bstate.setBorder(null);
            bstate.setOpaque(false);
            bstate.setText("State");
            bstate.setForeground(Color.lightGray);
            textRemove(bstate);
            line4.setBounds(x*76, y*7-2, x*25, 2);
            line4.setBackground(Color.lightGray);
            
            text8.setBounds(x, y*8, x*7, y*3);
            gender.setBounds(x*7, y*8, x*20, y*3);
            gender.addItem("--Select Gender--");
            gender.addItem("Male");
            gender.addItem("Female");
            
            text9.setBounds(x*33, y*8, x*4, y*3);
            religion.setBounds(x*37, y*8, x*20, y*3);
            religion.addItem("--Select Religion--");
            religion.addItem("Buddhist");
            religion.addItem("Christan");
            religion.addItem("Hindusim");
            religion.addItem("Jainism");
            religion.addItem("Islam");
            religion.addItem("Sikh");
            
            text10.setBounds(x*59, y*8, x*7, y*3);
            natlty.setBounds(x*66, y*8, x*20,y*3-2);
            natlty.setBorder(null);
            natlty.setOpaque(false);
            natlty.setText("Enter");
            natlty.setForeground(Color.lightGray);
            textRemove(natlty);
            line5.setBounds(x*66, y*11-2, x*20, 2);
            line5.setBackground(Color.lightGray);
            
            text11.setBounds(x, y*12, x*7,y*3);
            mstatus.setBounds(x*8, y*12, x*20,y*3);
            mstatus.addItem("--Select Status--");
            mstatus.addItem("Married");
            mstatus.addItem("UnMarried");
            
            text12.setBounds(x*30, y*12, x*10, y*3);
            adhar.setBounds(x*40, y*12, x*20,y*3-2);
            adhar.setBorder(null);
            adhar.setOpaque(false);
            adhar.setText("Adhar Number");
            adhar.setForeground(Color.lightGray);
            textRemove(adhar);
            line6.setBounds(x*40, y*15-2, x*20, 2);
            line6.setBackground(Color.lightGray);
            
            text13.setBounds(x*62, y*12, x*10, y*3);
            pan.setBounds(x*72, y*12, x*20,y*3-2);
            pan.setBorder(null);
            pan.setOpaque(false);
            pan.setText("Pan Number");
            pan.setForeground(Color.lightGray);
            textRemove(pan);
            line7.setBounds(x*72, y*15-2, x*20, 2);
            line7.setBackground(Color.lightGray);
            
        block2.add(text4);
        block2.add(salu);
        block2.add(fname);
        block2.add(line1);
        block2.add(lname);
        block2.add(line2);
        block2.add(text5);
        block2.add(picker);
        block2.add(text6);
        block2.add(bplace);
        block2.add(line3);
        block2.add(text7);
        block2.add(bstate);
        block2.add(line4);
        block2.add(text8);
        block2.add(gender);
        block2.add(text9);
        block2.add(religion);
        block2.add(text10);
        block2.add(natlty);
        block2.add(line5);
        block2.add(text11);
        block2.add(mstatus);
        block2.add(text12);
        block2.add(adhar);
        block2.add(line6);
        block2.add(text13);
        block2.add(pan);
        block2.add(line7);
        
        heading4.setBounds(x, y*44, getWidth()-(x*3), y*3);
        heading4.setOpaque(true);
        block3.setBounds(x, y*47,getWidth()-(x*3) , y*11);
        block3.setLayout(null);
        block3.setBackground(Color.white);
        
            text14.setBounds(x, 0, x*10,y*3 );
            hno.setBounds(x*10, 0, x*20,y*3-2);
            hno.setBorder(null);
            hno.setOpaque(false);
            hno.setText("House Number");
            hno.setForeground(Color.lightGray);
            textRemove(hno);
            line8.setBounds(x*10, y*3-2, x*20, 2);
            line8.setBackground(Color.lightGray);
            
            text15.setBounds(x*35, 0, x*7,y*3 );
            sname.setBounds(x*42, 0, x*20,y*3-2);
            sname.setBorder(null);
            sname.setOpaque(false);
            sname.setText("street name");
            sname.setForeground(Color.lightGray);
            textRemove(sname);
            line9.setBounds(x*42, y*3-2, x*20, 2);
            line9.setBackground(Color.lightGray);
            
            text16.setBounds(x*68, 0, x*3,y*3 );
            city.setBounds(x*71, 0, x*20,y*3-2);
            city.setBorder(null);
            city.setOpaque(false);
            city.setText("city");
            city.setForeground(Color.lightGray);
            textRemove(city);
            line10.setBounds(x*71, y*3-2, x*20, 2);
            line10.setBackground(Color.lightGray);
            
            text17.setBounds(x, y*4, x*5,y*3 );
            state.setBounds(x*5, y*4, x*20,y*3-2);
            state.setBorder(null);
            state.setOpaque(false);
            state.setText("state");
            state.setForeground(Color.lightGray);
            textRemove(state);
            line11.setBounds(x*5, y*7-2, x*20, 2);
            line11.setBackground(Color.lightGray);
            
            text18.setBounds(x*30, y*4, x*3,y*3 );
            pin.setBounds(x*33, y*4, x*20,y*3-2);
            pin.setBorder(null);
            pin.setOpaque(false);
            pin.setText("pin");
            pin.setForeground(Color.lightGray);
            textRemove(pin);
            line12.setBounds(x*33, y*7-2, x*20, 2);
            line12.setBackground(Color.lightGray);
            
            text19.setBounds(x, y*8, x*7,y*3 );
            mno.setBounds(x*7, y*8, x*20,y*3-2);
            mno.setBorder(null);
            mno.setOpaque(false);
            mno.setText("mobile number");
            mno.setForeground(Color.lightGray);
            textRemove(mno);
            line13.setBounds(x*7, y*11-2, x*20, 2);
            line13.setBackground(Color.lightGray);
            
            text20.setBounds(x*40, y*8, x*3,y*3 );
            email.setBounds(x*43, y*8, x*20,y*3-2);
            email.setBorder(null);
            email.setOpaque(false);
            email.setText("email is");
            email.setForeground(Color.lightGray);
            email.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!email.getText().contains("@")){
                    JOptionPane.showMessageDialog(null, "Use @ in mail id", "Error", 0);
                    email.setText("");
                }
                if(!email.getText().contains(".com")){
                    JOptionPane.showMessageDialog(null, "Use .com in end ofl id", "Error", 0);
                    email.setText("");
                }
            }
        });
            textRemove(email);
            line14.setBounds(x*43, y*11-2, x*20, 2);
            line14.setBackground(Color.lightGray);
        
        block3.add(text14);
        block3.add(hno);
        block3.add(line8);
        block3.add(text15);
        block3.add(sname);
        block3.add(line9);
        block3.add(text16);
        block3.add(city);
        block3.add(line10);
        block3.add(text17);
        block3.add(state);
        block3.add(line11);
        block3.add(text18);
        block3.add(pin);
        block3.add(line12);
        block3.add(text19);
        block3.add(mno);
        block3.add(line13);
        block3.add(text20);
        block3.add(email);
        block3.add(line14);
               
        heading5.setBounds(x, y*59, getWidth()-(x*3), y*3);
        heading5.setOpaque(true);
      
        block4.setBounds(x, y*63,getWidth()-(x*3) , y*8);
        block4.setLayout(null);
        block4.setBackground(Color.white);
        
            text21.setBounds(x, 0, x*7,y*3 );
            pname.setBounds(x*8, 0, x*20,y*3-2);
            pname.setBorder(null);
            pname.setOpaque(false);
            pname.setText("name");
            pname.setForeground(Color.lightGray);
            textRemove(pname);
            line15.setBounds(x*8, y*3-2, x*20, 2);
            line15.setBackground(Color.lightGray);
            
            text22.setBounds(x*31, 0, x*9,y*3 );
            pocc.setBounds(x*41, 0, x*20,y*3-2);
            pocc.setBorder(null);
            pocc.setOpaque(false);
            pocc.setText("occupation");
            pocc.setForeground(Color.lightGray);
            textRemove(pocc);
            line16.setBounds(x*41, y*3-2, x*20, 2);
            line16.setBackground(Color.lightGray);
            
            text23.setBounds(x*63, 0, x*11,y*3 );
            pcno.setBounds(x*75, 0, x*20,y*3-2);
            pcno.setBorder(null);
            pcno.setOpaque(false);
            pcno.setText("mobile number");
            pcno.setForeground(Color.lightGray);
            textRemove(pcno);
            line17.setBounds(x*75, y*3-2, x*20, 2);
            line17.setBackground(Color.lightGray);
            
            text24.setBounds(x, y*4, x*7,y*3 );
            mname.setBounds(x*8, y*4, x*20,y*3-2);
            mname.setBorder(null);
            mname.setOpaque(false);
            mname.setText("name");
            mname.setForeground(Color.lightGray);
            textRemove(mname);
            line18.setBounds(x*8, y*7-2, x*20, 2);
            line18.setBackground(Color.lightGray);
            
            text25.setBounds(x*31, y*4, x*9,y*3 );
            mocc.setBounds(x*41, y*4, x*20,y*3-2);
            mocc.setBorder(null);
            mocc.setOpaque(false);
            mocc.setText("occupation");
            mocc.setForeground(Color.lightGray);
            textRemove(mocc);
            line19.setBounds(x*41, y*7-2, x*20, 2);
            line19.setBackground(Color.lightGray);
            
            text26.setBounds(x*63, y*4, x*11,y*3 );
            mcno.setBounds(x*75, y*4, x*20,y*3-2);
            mcno.setBorder(null);
            mcno.setOpaque(false);
            mcno.setText("mobile number");
            mcno.setForeground(Color.lightGray);
            textRemove(mcno);
            line20.setBounds(x*75, y*7-2, x*20, 2);
            line20.setBackground(Color.lightGray);
        
        block4.add(text21);
        block4.add(pname);
        block4.add(line15);
        block4.add(text22);
        block4.add(pocc);
        block4.add(line16);
        block4.add(text23);
        block4.add(pcno);
        block4.add(line17);
        block4.add(text24);
        block4.add(mname);
        block4.add(line18);
        block4.add(text25);
        block4.add(mocc);
        block4.add(line19);
        block4.add(text26);
        block4.add(mcno);
        block4.add(line20);
        
        heading6.setBounds(x, y*72, getWidth()-(x*3), y*3);
        heading6.setOpaque(true);
        block5.setBounds(x, y*76,getWidth()-(x*3) , y*3);
        block5.setLayout(null);
        block5.setBackground(Color.white);
        
            text27.setBounds(x, 0, x*12, y*3);
            course.setBounds(x*13, 0,x*12, y*3);
            course.addItem("--Select--");
            course.addItem("Graduation");
            course.addItem("Post-Graduation");
            course.addItem("M.Phill");
            course.addItem("Doctorate");
            course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pgraduP.setVisible(true);
                doctorateP.setVisible(true);
                mphillP.setVisible(true);
                switch(course.getSelectedIndex()){
                    case 1:
                        pgraduP.setVisible(false);
                        doctorateP.setVisible(false);
                        mphillP.setVisible(false);
                        break;
                        
                    case 2:
                        doctorateP.setVisible(false);
                        mphillP.setVisible(false);
                        break;
                    case 3:
                        doctorateP.setVisible(false);
                        break;
                }
            }
        });
            
            text28.setBounds(x*50, 0, x*5, y*3);
            bed.setBounds(x*55, 0,x*12, y*3);
            bed.addItem("--Select--");
            bed.addItem("Yes");
            bed.addItem("No");
        
        block5.add(text27);
        block5.add(course);
        block5.add(text28);
        block5.add(bed);
        
        heading7.setBounds(x, y*80,getWidth()-(x*3) , y*3);
        heading7.setOpaque(true);
        
        JPanel block6=new JPanel();
        block6.setBounds(x,y*84,getWidth()-(x*3),y*30);
        block6.setLayout(null);
        block6.setBackground(Color.WHITE);
        JPanel ask = new JPanel();
        
            ask.setBounds(0,0, block6.getWidth(),block6.getHeight());
            ask.setLayout(new GridLayout(7, 1, 0, 2));
                
                label.setBackground(Color.white);
                label.setLayout(null);
                
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
                    
                    JLabel dateL=new JLabel("<html> <pre>     Date");
                    dateL.setBounds(x*82, 2, x*12-2, (y*3));
                    dateL.setOpaque(true);
                    dateL.setBackground(Color.BLUE);
                    dateL.setForeground(Color.white);
                 
                label.add(clsL);
                label.add(schL);
                label.add(boardL);
                label.add(marksL);
                label.add(dateL);
            
                tenP.setBackground(Color.white);
                tenP.setLayout(null);
                
                    JLabel tenl=new JLabel("<html> <pre>X<sup>th");
                    tenl.setBounds(0, 2, x*7-2, (y*3));
                    tenl.setOpaque(true);
                    tenl.setBackground(Color.BLUE);
                    tenl.setForeground(Color.white);
                    
                    tinsTF.setBounds(x*7, 2, x*25-2, (y*3));
                    textRemove(tinsTF);
                    tboardTF.setBounds(x*32, 2, x*25-2, (y*3));
                    textRemove(tboardTF);
                    tperTF.setBounds(x*57, 2, x*25-2, (y*3));
                    textRemove(tperTF);
                    tpicker.setBounds(x*82, 2, x*12-2, (y*3));
                    
                    tpicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tpickers=date.convert(tpicker);
                    }
                    });
                 
                 tenP.add(tenl);
                 tenP.add(tinsTF);
                 tenP.add(tboardTF);
                 tenP.add(tperTF);
                 tenP.add(tpicker);
                    
                plus2P.setBackground(Color.white);
                plus2P.setLayout(null);
                
                    JLabel plus2l=new JLabel("<html> <pre>XII<sup>th");
                    plus2l.setBounds(0, 2, x*7-2, (y*3));
                    plus2l.setOpaque(true);
                    plus2l.setBackground(Color.BLUE);
                    plus2l.setForeground(Color.white);
                    plpicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        plpickers=date.convert(plpicker);
                    }
                    });
                    
                    plinsTF.setBounds(x*7, 2, x*25-2, (y*3));
                    textRemove(plinsTF);
                    plboardTF.setBounds(x*32, 2, x*25-2, (y*3));
                    textRemove(plboardTF);
                    plperTF.setBounds(x*57, 2, x*25-2, (y*3));
                    textRemove(plperTF);
                    plpicker.setBounds(x*82, 2, x*12-2, (y*3));
                 
                 plus2P.add(plus2l);   
                 plus2P.add(plinsTF);
                 plus2P.add(plboardTF);
                 plus2P.add(plperTF);
                 plus2P.add(plpicker);
                 
                graduP.setBackground(Color.white);
                graduP.setLayout(null);
                
                    JLabel gradul=new JLabel("<html> <pre>Graduation<sup>th");
                    gradul.setBounds(0, 2, x*7-2, (y*3));
                    gradul.setOpaque(true);
                    gradul.setBackground(Color.BLUE);
                    gradul.setForeground(Color.white);
                    
                    ginsTF.setBounds(x*7, 2, x*25-2, (y*3));
                    textRemove(ginsTF);
                    gboardTF.setBounds(x*32, 2, x*25-2, (y*3));
                    textRemove(gboardTF);
                    gperTF.setBounds(x*57, 2, x*25-2, (y*3));
                    textRemove(gperTF);
                    gpicker.setBounds(x*82, 2, x*12-2, (y*3));
                    gpicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gpickers=date.convert(gpicker);
                    }
                    });
                 
                 graduP.add(gradul);   
                 graduP.add(ginsTF);
                 graduP.add(gboardTF);
                 graduP.add(gperTF);
                 graduP.add(gpicker);

                pgraduP.setBackground(Color.white);
                pgraduP.setLayout(null);
                
                    JLabel pgradul=new JLabel("<html> <pre>Post-Graduation<sup>th");
                    pgradul.setBounds(0, 2, x*7-2, (y*3));
                    pgradul.setOpaque(true);
                    pgradul.setBackground(Color.BLUE);
                    pgradul.setForeground(Color.white);
                    
                    pginsTF.setBounds(x*7, 2, x*25-2, (y*3));
                    textRemove(pginsTF);
                    pgboardTF.setBounds(x*32, 2, x*25-2, (y*3));
                    textRemove(pgboardTF);
                    pgperTF.setBounds(x*57, 2, x*25-2, (y*3));
                    textRemove(pgperTF);
                    pgpicker.setBounds(x*82, 2, x*12-2, (y*3));
                    pgpicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pgpickers=date.convert(pgpicker);
                    }
                    });
                  
                 pgraduP.add(pgradul);   
                 pgraduP.add(pginsTF);
                 pgraduP.add(pgboardTF);
                 pgraduP.add(pgperTF);
                 pgraduP.add(pgpicker);
                
                doctorateP.setBackground(Color.white);
                doctorateP.setLayout(null);
                
                    JLabel doctratel=new JLabel("<html> <pre>Doctorate<sup>th");
                    doctratel.setBounds(0, 2, x*7-2, (y*3));
                    doctratel.setOpaque(true);
                    doctratel.setBackground(Color.BLUE);
                    doctratel.setForeground(Color.white);
                    
                    dinsTF.setBounds(x*7, 2, x*25-2, (y*3));
                    textRemove(dinsTF);
                    dboardTF.setBounds(x*32, 2, x*25-2, (y*3));
                    textRemove(dboardTF);
                    dperTF.setBounds(x*57, 2, x*25-2, (y*3));
                    textRemove(dperTF);
                    dpicker.setBounds(x*82, 2, x*12-2, (y*3));
                    dpicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dpickers=date.convert(dpicker);
                    }
                    });
                    
                 doctorateP.add(doctratel);
                 doctorateP.add(dinsTF);
                 doctorateP.add(dboardTF);
                 doctorateP.add(dperTF);
                 doctorateP.add(dpicker);
               
                mphillP.setBackground(Color.white);
                mphillP.setLayout(null);
                
                    JLabel mphilll=new JLabel("<html> <pre> MPhill<sup>th");
                    mphilll.setBounds(0, 2, x*7-2, (y*3));
                    mphilll.setOpaque(true);
                    mphilll.setBackground(Color.BLUE);
                    mphilll.setForeground(Color.white);
                    
                    minsTF.setBounds(x*7, 2, x*25-2, (y*3));
                    textRemove(minsTF);
                    mboardTF.setBounds(x*32, 2, x*25-2, (y*3));
                    textRemove(mboardTF);
                    mperTF.setBounds(x*57, 2, x*25-2, (y*3));
                    textRemove(mperTF);
                    mpicker.setBounds(x*82, 2, x*12-2, (y*3));
                    mpicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mppickers=date.convert(mpicker);
                    }
                    });
                    
                 mphillP.add(mphilll);   
                 mphillP.add(minsTF);
                 mphillP.add(mboardTF);
                 mphillP.add(mperTF);
                 mphillP.add(mpicker);
                
              
            ask.add(label);
            ask.add(tenP);
            ask.add(plus2P);
            ask.add(graduP);
            ask.add(pgraduP);
            ask.add(mphillP);
            ask.add(doctorateP);
            
        block6.add(ask);
        
        JLabel heading8=new JLabel("<html>  <font style=\"font-size:20;\"> Profile Pic");
        heading8.setBounds(x, y*115,getWidth()-(x*3) , y*3);
        heading8.setOpaque(true);
        
        JPanel block7=new JPanel();
        block7.setBounds(x,y*118,getWidth()-(x*3),y*15);
        block7.setLayout(null);
        block7.setBackground(Color.WHITE);
        
            JLabel ipic=new JLabel();
            ipic.setBounds(0, 0, x*10, y*10);
            ipic.setBackground(Color.lightGray);
            ipic.setOpaque(true);
            
            JButton selpic=new JButton("select Pic");
            selpic.setBounds(x*5, y*11, x*5, y*3);
            
            JFileChooser fileChooserFC=new JFileChooser("C:\\Users\\Os\\Pictures");
            
            selpic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //picAddress=null;
                    int r= fileChooserFC.showDialog(null,null);
                    if(r == JFileChooser.APPROVE_OPTION){
                        File str=fileChooserFC.getSelectedFile().getAbsoluteFile(); //sttr used to get file location
                        /*try{
                           // picAddress=new FileInputStream(str);//pic address is used to convert file to image stream
                        }catch(FileNotFoundException ex){
                            System.err.println("not foundc"+ex.getStackTrace());
                        }*/
                        imgPath=str.getAbsolutePath();
                        System.out.println(str.getAbsolutePath());
                        System.out.println(str);
                        System.out.println("setPic "+ str);
                        System.out.println("picAddress "+ str);
                        
                        try {

                            ipic.setIcon(new ImageIcon(ImageIO.read(str).getScaledInstance(ipic.getWidth(), ipic.getHeight(), 4)));
                            fpic.setIcon(new ImageIcon(ImageIO.read(str).getScaledInstance(fpic.getWidth(), fpic.getHeight(), 4)));
                        } catch (IOException ex) {
                            System.err.println("error uploading a pic "+ex.getStackTrace());

                        }
                        catch (NullPointerException ex) {
                            javax.swing.JOptionPane.showMessageDialog(null, "Wrong File Format", "Select only .jpg or .png", 1);
                            
                        }
                    }
                    else{
                        System.out.println("no file selected");
                    }
                    
                    System.out.println(imgPath);
            }
        });
            
        block7.add(ipic);
        block7.add(selpic);
        
        body.add(logo);
        body.add(name);
        body.add(fpic);
        body.add(line);
        body.add(heading);
        body.add(heading2);
        body.add(block);
        body.add(heading3);
        body.add(block2);       
        body.add(heading4);
        body.add(block3);
        body.add(heading5);
        body.add(block4);
        body.add(heading6);
        body.add(block5);
        body.add(heading7);
        body.add(block6);
        body.add(heading8);
        body.add(block7);
        
    }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Fake Your device is not compatible");
    }
    }
    
    int check(){
        
        if(imgPath==""){
            JOptionPane.showMessageDialog(null, "Add Image", "Empty Image", 1);
            return 0;
        }
        
        if(tinsTF.getText()=="" || tinsTF.getText().isEmpty()){
            tinsTF.setText("");
        }
        if(tboardTF.getText()=="" || tboardTF.getText().isEmpty()){
            tboardTF.setText("");
        }
        if(tperTF.getText()=="" || tperTF.getText().isEmpty()){
            tperTF.setText("");
        }
        if(tpickers==""){
           tpickers="";
        }
        
        
        if(plinsTF.getText()=="" || plinsTF.getText().isEmpty()){
            plinsTF.setText("");
        }
        if(plboardTF.getText()=="" || plboardTF.getText().isEmpty()){
            plboardTF.setText("");
        }
        if(plperTF.getText()=="" || plperTF.getText().isEmpty()){
            plperTF.setText("");
        }
        if(plpickers==""){
            plpickers="";
        }
        
        
        if(ginsTF.getText()=="" || ginsTF.getText().isEmpty()){
            ginsTF.setText("");
        }
        if(gboardTF.getText()=="" || gboardTF.getText().isEmpty()){
            gboardTF.setText("");
        }
        if(gperTF.getText()=="" || gperTF.getText().isEmpty()){
            gperTF.setText("");
        }
        if(gpickers==""){
            gpickers="";
        }
        
        
        if(pginsTF.getText().equals("") || pginsTF.getText().isEmpty()){
            pginsTF.setText("");
        }
        if(pgboardTF.getText().equals("") || pgboardTF.getText().isEmpty()){
            tboardTF.setText("");
        }
        if(pgperTF.getText().equals("") || pgperTF.getText().isEmpty()){
            pgperTF.setText("");
        }
        if(pgpickers==""){
            pgpickers="";
        }
        
        
        if(minsTF.getText().equals("") || minsTF.getText().isEmpty()){
            minsTF.setText("");
        }
        if(mboardTF.getText().equals("") || mboardTF.getText().isEmpty()){
            mboardTF.setText("");
        }
        if(mperTF.getText().equals("") || mperTF.getText().isEmpty()){
            mperTF.setText("");
        }
        if(mppickers==""){
            mppickers="";
        }
        
        if(dinsTF.getText().equals("") || dinsTF.getText().isEmpty()){
            dinsTF.setText("");
        }
        if(dboardTF.getText().equals("")|| dboardTF.getText().isEmpty()){
            dboardTF.setText("");
        }
        if(dperTF.getText().equals("") || dperTF.getText().isEmpty()){
            dperTF.setText("");
        }
        if(dpickers==""){
            dpickers="";
        }
        
                            if(bed.getSelectedIndex()==0){
                                JOptionPane.showMessageDialog(null, "Select B.Ed option", "Empty Field", 1);
                                return 0;
                            }
                            if(course.getSelectedIndex()==0){
                                JOptionPane.showMessageDialog(null, "Select Highest Qualification", "Empty Field", 1);
                                return 0;
                            }
                            if(mcno.getText().trim().equals("mobile number") || mcno.getText().equals("")){
                                mcno.setText("");
                            }
                            if(mocc.getText().trim().equals("occupation") || mocc.getText().equals("")){
                                mocc.setText("");
                            }
                            if(mname.getText().trim().equals("name") || mname.getText().equals("")){
                                mname.setText("");
                            }
                            if(pcno.getText().trim().equals("mobile number") || pcno.getText().equals("")){
                                pcno.setText("");
                            }
                            if(pocc.getText().trim().equals("occupation") || pocc.getText().equals("")){
                                pocc.setText("");
                            }
                            if(pname.getText().trim().equals("name") || pname.getText().equals("")){
                                pname.setText("");
                            }
                            if(email.getText().trim().equals("email is") || email.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Fill Email Id", "Empty Field", 1);
                                return 0;
                            }
                            if(mno.getText().trim().equals("mobile number") || mno.getText().equals("") || mno.getText().length()!=10 ){
                                JOptionPane.showMessageDialog(null, "Fill Ten Digit Mobile Number", "Empty Field", 1);
                                return 0;
                            }
                            if(pin.getText().trim().equals("pin") || pin.getText().equals("") || pin.getText().length()<5 || pin.getText().length()>7 ){
                                JOptionPane.showMessageDialog(null, "Fill PIN", "Empty Field", 1);
                                return 0;
                            }
                            if(state.getText().trim().equals("state") || state.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Fill State Name", "Empty Field", 1);
                                return 0;
                            }
                            if(city.getText().trim().equals("city") || city.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Fill City Name", "Empty Field", 1);
                                return 0;
                            }
                            if(sname.getText().trim().equals("street name") || sname.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Fill Street Name", "Empty Field", 1);
                                return 0;
                            }
                            if(hno.getText().trim().equals("House Number") || hno.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Fill House Number", "Empty Field", 1);
                                return 0;
                            }
                            if(pan.getText().trim().equals("Pan Number") || pan.getText().equals("")){
                                pan.setText("0");
                            }
                        
                            if(adhar.getText().trim().equals("Adhar Number") || adhar.getText().equals("") || adhar.getText().length()==13 ){
                                JOptionPane.showMessageDialog(null, "Fill adhar number", "Empty Field", 1);
                                return 0;
                            }
                            
                            if(mstatus.getSelectedIndex()==0){
                                JOptionPane.showMessageDialog(null, "Select Martial Status", "Empty Field", 1);
                                return 0;
                            }
                            
                            if(natlty.getText().trim().equals("Enter") || bstate.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Fill Birth State", "Empty Field", 1);
                                return 0;
                            }
                        
                            if(religion.getSelectedIndex()==0){
                                JOptionPane.showMessageDialog(null, "Select Religon", "Empty Field", 1);
                                return 0;
                            }
                        
                            if(gender.getSelectedIndex()==0){
                                JOptionPane.showMessageDialog(null, "Select Gender", "Empty Field", 1);
                                return 0;
                            }
                            
                            if(bstate.getText().trim().equals("State") || bstate.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Fill Birth State", "Empty Field", 1);
                                return 0;
                            }
                            if(bplace.getText().trim().equals("City") || bplace.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Fill Birth City", "Empty Field", 1);
                                return 0;
                            }
                            
                            if(post.getSelectedIndex()==0){
                                JOptionPane.showMessageDialog(null, "Fill Post", "Empty Field", 1);
                                return 0;
                            }
                            
                            if(pref.getSelectedIndex()==0){
                                JOptionPane.showMessageDialog(null, "Fill SubjectPref1", "Empty Field", 1);
                                return 0;
                            }
                            
                            if(pref2.getSelectedIndex()==0){
                                JOptionPane.showMessageDialog(null, "Fill Subject Prefference", "Empty Field", 1);
                                return 0;
                            }
                            
                            if(salu.getSelectedIndex()==0){
                                JOptionPane.showMessageDialog(null, "Select Saluation", "Empty Field", 1);
                                return 0;
                            }
                            
                            if(fname.getText().equalsIgnoreCase("First Name") || fname.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Fill First Name", "Empty Field", 1);
                                return 0;
                            }
                            
                            if(lname.getText().equals("Last Name") || lname.getText().equals("")){
                                JOptionPane.showMessageDialog(null, "Fill Last Name", "Empty Field", 1);
                                return 0;
                            }

        if(pickerS==""){
            pickerS="";
            JOptionPane.showMessageDialog(null, "Fill Birth Date", "Empty", 1);
        }
                            return 1;
                            
                            
    }
    
    void renew(){
        
        imgPath="";
        
        body=new JPanel();
        logo=new JLabel();
        name=new JLabel("<html>  <font style=\"font-size:20;\">R.V SCHOOL <font style=\"color:#ffd700;\">AMRITSAR");
        fpic=new JLabel();
        line=new JPanel();
        
        heading=new JLabel("<html> <pre> <font style=\"font-size:25;\"> <b>Teacher Application Form");
        
        heading2=new JLabel("<html>  <font style=\"font-size:20;\"> Job Information");
        block=new JPanel();
        text=new JLabel("Post Applied for");
        post=new JComboBox();
        text2=new JLabel("Subject (Prederence 1)");
        pref=new JComboBox();
        prefs="";
        text3=new JLabel("Subject (Prederence 1)");
        pref2=new JComboBox();
        pref2s="";
        heading3=new JLabel("<html>  <font style=\"font-size:20;\"> Personal Information");
        block2=new JPanel();
        text4=new JLabel("Name");
        salu=new JComboBox();
        fname=new JTextField();
        line1=new JPanel();
        lname=new JTextField();
        line2=new JPanel();
        text5=new JLabel("Date of Birth");
        picker=new JXDatePicker();
        pickerS="";
        text6=new JLabel("Place of Birth");
        bplace=new JTextField();
        line3=new JPanel();
        text7=new JLabel("Birth State");
        bstate=new JTextField();
        line4=new JPanel();
        text8=new JLabel("Gender");
        gender=new JComboBox();
        text9=new JLabel("Religion");
        religion=new JComboBox();
        text10=new JLabel("Nationality");
        natlty=new JTextField();
        line5=new JPanel();
        text11=new JLabel("Martial Status");
        mstatus=new JComboBox();
        text12=new JLabel("Addhar Card Number");
        adhar=new JTextField();
        line6=new JPanel();
        text13=new JLabel("PAN Card Number");
        pan=new JTextField();
        line7=new JPanel();
        
        heading4=new JLabel("<html>  <font style=\"font-size:20;\"> Contact Information");
        block3=new JPanel();
        text14=new JLabel(" House Number");
        hno=new JTextField();
        line8=new JPanel();
        text15=new JLabel(" Street Name");
        sname=new JTextField();
        line9=new JPanel();
        text16=new JLabel(" City");
        city=new JTextField();
        line10=new JPanel();
        text17=new JLabel(" State");
        state=new JTextField();
        line11=new JPanel();
        text18=new JLabel("PIN");
        pin=new JTextField();
        line12=new JPanel();
        text19=new JLabel(" Mobile No");
        mno=new JTextField();
        line13=new JPanel();
        text20=new JLabel("Email");
        email=new JTextField();
        line14=new JPanel();

        heading5=new JLabel("<html>  <font style=\"font-size:20;\"> Family Information");
        block4=new JPanel();
        text21=new JLabel("Father Name");
        pname=new JTextField();
        line15=new JPanel();
        text22=new JLabel("Father Occupation");
        pocc=new JTextField();
        line16=new JPanel();
        text23=new JLabel("Father contact number");
        pcno=new JTextField();
        line17=new JPanel();
        text24=new JLabel("Mother Name");
        mname=new JTextField();
        line18=new JPanel();
        text25=new JLabel("Mother Occupation");
        mocc=new JTextField();
        line19=new JPanel();
        text26=new JLabel("Mother contact number");
        mcno=new JTextField();
        line20=new JPanel();
        
        heading6=new JLabel("<html>  <font style=\"font-size:20;\"> Academic/Professional Qualifications");
        block5=new JPanel();
        text27=new JLabel("Highest Qualifiaction");
        course=new JComboBox();
        text28=new JLabel("B.Ed");
        bed=new JComboBox();
        
        heading7=new JLabel("<html>  <font style=\"font-size:20;\"> Academic/Professional Details");
        //block6
        label=new JPanel();
        
        tenP=new JPanel();
        tinsTF=new JTextField();
        tboardTF=new JTextField();
        tperTF=new JTextField();
        tpicker=new JXDatePicker();
        tpickers="";
        plus2P=new JPanel();
        plinsTF=new JTextField();
        plboardTF=new JTextField();
        plperTF=new JTextField();
        plpicker=new JXDatePicker();
        plpickers="";
        graduP=new JPanel();
        ginsTF=new JTextField();
        gboardTF=new JTextField();
        gperTF=new JTextField();
        gpicker=new JXDatePicker();
        gpickers="";
        pgraduP=new JPanel();
        pginsTF=new JTextField();
        pgboardTF=new JTextField();
        pgperTF=new JTextField();
        pgpicker=new JXDatePicker();
        pgpickers="";
        doctorateP=new JPanel();
        dinsTF=new JTextField();
        dboardTF=new JTextField();
        dperTF=new JTextField();
        dpicker=new JXDatePicker();
        dpickers="";
        mphillP=new JPanel();
        minsTF=new JTextField();
        mboardTF=new JTextField();
        mperTF=new JTextField();
        mpicker=new JXDatePicker();
        mppickers="";
        
        print=new JButton("<html>  <font style=\"font-size:20;\">Print");
    }
    
    void textRemove(JTextField t){
        t.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                t.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });
    }
    
    void buttonDeco(JButton b){
       
        
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
                b.setForeground(Color.black);
            }
        });
        
    }
    
}
