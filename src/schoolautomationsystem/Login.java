package schoolautomationsystem;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Login extends JPanel {
    
    
    JPanel imgP=new JPanel();
    JPanel bodyP=new JPanel();
    JLabel headingL=new JLabel("<html> <font style=\" font-size:30; font-family:Arial;\">Login");
    JTextField loginTF=new JTextField();
    JPanel loginDLine=new JPanel();
    JTextField passwordTF=new JTextField();
    JComboBox chooseCB= new JComboBox();
    JPanel passwordDLine=new JPanel();
    JButton submitB=new JButton("<html> <pre><font style=\" font-size:12; font-family:arial;\">Login");
    JPanel borderP=new JPanel();
    
    MyConnection con=new MyConnection();
    
    String email="",pass="",cat="";
    int Tid=0;
     
    public Login() {
        
    }
    
    void design(MainFrame f){
        
        setLayout(null);
        //frame setting
        f.setBounds(f.x*20, f.y*20,f.x*70 , f.y*70);
        f.setTitle("School Automation System/Login");
        
        //panel setting
        setBackground(Color.WHITE);
        setBounds(0, 0, f.getWidth(), f.getHeight());
        setVisible(true);
        
        int x=f.getWidth()/100,y=f.getHeight()/100;
        
        System.out.println(x*4+"  "+f.getHeight());
        
        
        JLabel imgL=new JLabel("<html><font style=\" font-size:105; color:#ffffff; \">👨‍");
        imgL.setBounds(x*11,y*11,x*15,y*25);
        //imgL.setOpaque(true);
        
        //img
        JLabel heading1=new JLabel("<html><font style=\" font-size:25; color:#ffffff; font-family:Century Gothic;\">Welcome to the");
        heading1.setBounds(x*12,y*42,x*30,y*8);
        //heading1.setOpaque(true);
        
        JLabel heading2=new JLabel("<html><font style=\" font-size:25; color:#ffffff; font-family:Century Gothic;\">School Automation");
        heading2.setBounds(x*8,y*50,x*32,y*8);
        //heading2.setOpaque(true);
        
        JLabel heading3=new JLabel("<html><font style=\" font-size:25; color:#ffffff; font-family:Century Gothic;\">System");
        heading3.setBounds(x*24,y*58,x*15,y*8);
        //heading3.setOpaque(true);
        
        JLabel heading4=new JLabel("<html><font style=\" font-size:10; color:#ffffff; font-family:Century Gothic;\">Developed By");
        heading4.setBounds(x*25,y*97,x*8,y*4);
        
        JLabel heading5=new JLabel("<html><font style=\" font-size:10; color:#ffffff; font-family:Century Gothic;\">Raghav Vehgal");
        heading5.setBounds(x*24,y*101,x*10,y*4);
        
        imgP.setBounds(0, 0, x*40, f.getHeight());
        imgP.setLayout(null);
        imgP.setBackground(new Color(41,28,185));
        imgP.setVisible(true);
        imgP.setOpaque(true);
        
        imgP.add(heading1);
        imgP.add(heading2);
        imgP.add(heading3);
        imgP.add(heading4);
        imgP.add(heading5);
        imgP.add(imgL);
        //bodyP design
        bodyP.setBounds(x*40, 0, x*60, f.getHeight());
        bodyP.setBackground(Color.white);
        bodyP.setLayout(null);
        bodyP.setVisible(true);
        
        x=bodyP.getWidth()/100;y=bodyP.getHeight()/100;
        
        borderP.setBounds(0, 0, bodyP.getWidth(), 10);
        borderP.setBackground(Color.blue);
        
        headingL.setBounds(x*10, y*10, x*40, y*10);
        headingL.setForeground(Color.blue);
        
        chooseCB.setBounds(x*20, y*30,x*60,y*8);
        chooseCB.setBackground(Color.white);
        chooseCB.setForeground(Color.blue);
        chooseCB.setBorder(new LineBorder(Color.blue,2, true));
        chooseCB.addItem("Select Category");
        chooseCB.addItem("Admin");
        chooseCB.addItem("Teacher");
        chooseCB.addItem("Clerk");
        
        JLabel loginTFicon=new JLabel("<html> <font style=\" font-size:20;color:#4169E1\">👨‍");
        loginTFicon.setBounds(x*14,y*42,x*6,y*9);
        
        loginTF.setBounds(x*20,y*42,x*60,y*8);
        loginTF.setBorder(null);
        loginTF.setText("user name");
        loginTF.setForeground(Color.gray);
        loginTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                loginTF.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });
        
        loginDLine.setBounds(x*20, y*51, x*60, 2);
        loginDLine.setBackground(Color.blue);
        
        JLabel passTFicon=new JLabel("<html> <font style=\" font-size:20;color:#4169E1\">🔓");
        passTFicon.setBounds(x*14,y*64,x*6,y*9);
        
        passwordTF.setBounds(x*20,y*64,x*60,y*8);
        passwordTF.setBorder(null);
        passwordTF.setText("password");
        passwordTF.setForeground(Color.gray);
        passwordTF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordTF.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });
        
        passwordDLine.setBounds(x*20, y*72, x*60, 2);
        passwordDLine.setBackground(Color.blue);
        
        bodyP.add(borderP);
        bodyP.add(headingL);
        bodyP.add(loginTFicon);
        bodyP.add(loginTF);
        bodyP.add(loginDLine);
        bodyP.add(passTFicon);
        bodyP.add(passwordTF);
        bodyP.add(passwordDLine);
        bodyP.add(submitB);
        bodyP.add(chooseCB);
        
        
        submitB.setBounds(x*20, y*80,x*20 , y*10);
        submitB.setForeground(Color.blue);
        submitB.setBorder(new LineBorder(Color.blue, 2, true));
        submitB.setBackground(Color.white);
        submitB.setOpaque(true);
        submitB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                fun(f);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                submitB.setBackground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                submitB.setBackground(Color.white);
            }
        });
            String pass="no";
         
            
        submitB.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    fun(f);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
       
        add(imgP);
        add(bodyP);
        
    }
    
    void fun(MainFrame f){
        
        switch (chooseCB.getSelectedIndex()) {
                    case 1:
                        pass="";
                        cat="";
                        
                        try {
                            con.pre_s=con.conn.prepareStatement("select Id,password,Category from user where Id=?  or email=?");
                            con.pre_s.setString(1, loginTF.getText().trim());
                            con.pre_s.setString(2, loginTF.getText().trim());
                            con.r_set=con.pre_s.executeQuery();
                            
                            while(con.r_set.next()){
                                Tid=Integer.parseInt(con.r_set.getString(1));
                                pass=con.r_set.getString(2);
                                cat=con.r_set.getString(3);
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex, "Login case 2", 0);
                        }
                        System.out.println("Tid pass cat= "+Tid+" "+pass+" "+cat);
                        if(pass.equals(passwordTF.getText().trim()) && cat.equals("a")){
                            setVisible(false);  
                            f.login.setVisible(false);
                            if(f.adminV==0){
                                f.adminP.removeAll();
                                f.adminP.design(f);
                            }else{
                                f.adminP.setVisible(true);
                                f.setBounds(0, 0,f.width, f.height-(f.height/100));
                            }                
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "Email password or selected Category no match in database", "Mis Match", 1);
                        }
                        break;
                        
                    case 2:
                        pass="";
                        cat="";
                        
                        try {
                            con.pre_s=con.conn.prepareStatement("select Id,password,Category from user where Id=?  or email=?");
                            con.pre_s.setString(1, loginTF.getText().trim());
                            con.pre_s.setString(2, loginTF.getText().trim());
                            con.r_set=con.pre_s.executeQuery();
                            
                            while(con.r_set.next()){
                                Tid=Integer.parseInt(con.r_set.getString(1));
                                pass=con.r_set.getString(2);
                                cat=con.r_set.getString(3);
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex, "Login case 2", 0);
                        }
                        System.out.println("Tid pass cat= "+Tid+" "+pass+" "+cat);
                        if(pass.equals(passwordTF.getText().trim()) && cat.equals("t")){
                                                 
                            setVisible(false);
                            f.teacherP.removeAll();
                            f.teacherP.intial(Tid);
                            f.teacherP.design(f);
                            f.adminP.setVisible(false);
                        }else{
                            JOptionPane.showMessageDialog(null, "Email password or selected Category no match in database", "Mis Match", 1);
                        }
                        
                        break;
                        
                    case 3:
                        pass="";
                        cat="";
                        
                        try {
                            con.pre_s=con.conn.prepareStatement("select Id,password,Category from user where Id=?  or email=?");
                            con.pre_s.setString(1, loginTF.getText().trim());
                            con.pre_s.setString(2, loginTF.getText().trim());
                            con.r_set=con.pre_s.executeQuery();
                            
                            while(con.r_set.next()){
                                Tid=Integer.parseInt(con.r_set.getString(1));
                                pass=con.r_set.getString(2);
                                cat=con.r_set.getString(3);
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex, "Login case 2", 0);
                        }
                        System.out.println("Tid pass cat= "+Tid+" "+pass+" "+cat);
                        if(pass.equals(passwordTF.getText().trim()) && cat.equals("c")){
                            setVisible(false);
                            if(f.clerkV==0)
                                f.clerkP.design(f);
                            else{
                                f.clerkP.setVisible(true);
                                f.setBounds(0, 0,f.width, f.height-(f.height/100));
                            }
                            f.clerkP.setVisible(true);
                            f.adminP.setVisible(false);
                            f.teacherP.setVisible(false);                
                           
                        }else{
                            JOptionPane.showMessageDialog(null, "Email password or selected Category no match in database", "Mis Match", 1);
                        }

                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Select Category", "Category Not Selected", 1);
                        
                        break;
                }
    }
}
