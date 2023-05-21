package schoolautomationsystem;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class Clerk extends JPanel{

    JPanel sideP=new JPanel();
    JButton studentB=new JButton("<html> <pre><font style=\" font-size:15; font-family:arial;\">🎓 Student");
    JButton teacherB=new JButton("<html> <pre><font style=\" font-size:15; font-family:arial;\">👨‍ Teacher");
    JButton logoutB=new JButton("<html> <pre><font style=\" font-size:15; font-family:arial;\">❌ Logout");
    JPanel bodyP=new JPanel();
        JPanel first=new JPanel();
        JPanel studentP=new JPanel();
        JPanel teacherP=new JPanel();
    //AddNewStudent ansP=new JPanel();
    
    public Clerk() {
       
    }
    
    void design(MainFrame f){
        
        f.clerkV=1;
        
        add(sideP);
        add(bodyP);
        
        int y=f.height/100;
        
        f.setBounds(0, 0,f.width, f.height-y);
        
        setBounds(0, 0,f.width, f.height);
        
        setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        f.aNS.hid();
        f.aNT.setVisible(false);
        
        bodyP.setBounds(f.x*10, 0, f.x*95, f.height);
        bodyP.setBackground(Color.blue);
        bodyP.setLayout(null);
        
            
        bodyP.add(first);
        bodyP.add(f.aNS);
        bodyP.add(f.aNT);
        bodyP.add(f.feeP);
        
        
        
        
        //bodyP.add(studentP);
        
        f.aNS.design(bodyP.getWidth()/100, bodyP.getHeight()/100);
        f.aNS.setVisible(false);
        //f.aNT.design(f.x, f.y);
        f.aNT.design(bodyP.getWidth()/100, bodyP.getHeight()/100);
        f.aNT.setVisible(false);
        f.feeP.design(bodyP.getWidth()/100, bodyP.getHeight()/100);
        f.feeP.setVisible(false);
        first.setBounds(0, 0, bodyP.getWidth(), bodyP.getHeight());
        
        
        System.out.println("Clerk");
        
        
        
        //sideP.setBorder(new LineBorder(Color.blue, 2, true));
        sideP.setBounds(0, 0, f.x*10, f.height);
        sideP.setBackground(Color.blue);
        sideP.setVisible(true);
        sideP.setLayout(null);
        
       // f.aNS.hid();
        
        studentB.setBounds(0, f.y, sideP.getWidth()-1, f.y*5);
        studentB.setForeground(Color.blue);
        studentB.setBackground(Color.yellow);
        studentB.setOpaque(true);
        studentB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.aNS.sho();
                f.aNT.setVisible(false);
                f.feeP.setVisible(false);
                studentP.setVisible(false);
                first.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                studentB.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                studentB.setForeground(Color.blue);
            }
        });
        
        teacherB.setBounds(0, f.y*7, sideP.getWidth()-1, f.y*5);
        teacherB.setForeground(Color.blue);
        teacherB.setBackground(Color.yellow);
        teacherB.setOpaque(true);
        teacherB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.aNS.hid();
                f.aNT.setVisible(true);
                f.feeP.setVisible(false);
                studentP.setVisible(false);
                first.setVisible(false);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                teacherB.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                teacherB.setForeground(Color.blue);
            }
        });
        
        JButton feeB=new JButton("<html> <pre><font style=\" font-size:15; font-family:arial;\">? Fee");
        feeB.setBounds(0, f.y*13, sideP.getWidth()-1, f.y*5);
        feeB.setForeground(Color.blue);
        feeB.setBackground(Color.yellow);
        feeB.setOpaque(true);
        feeB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.aNS.hid();
                f.aNT.setVisible(false);
                f.feeP.setVisible(true);
                studentP.setVisible(false);
                first.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                feeB.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                feeB.setForeground(Color.blue);
            }
        });
        
        logoutB.setBounds(0, f.y*19, sideP.getWidth()-1, f.y*5);
        logoutB.setForeground(Color.blue);
        logoutB.setBackground(Color.yellow);
        logoutB.setOpaque(true);
        logoutB.addMouseListener(new MouseListener() {
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
                logoutB.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logoutB.setForeground(Color.blue);
            }
        });
        
        sideP.add(studentB);
        sideP.add(teacherB);
        sideP.add(feeB);
        sideP.add(logoutB);
        
    }
    
}
