package schoolautomationsystem;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class Home extends JPanel{

    JPanel sideButtonP=new JPanel();
    
    JPanel containerP=new JPanel();
    
    
    JLabel studentB=new JLabel("<html> <pre><font style=\" font-size:20; font-family:arial;\">  🎓      Student");
    JPanel selectorSP=new JPanel();
    
    JLabel teacherB=new JLabel("<html> <pre><font style=\" font-size:20; font-family:arial;\">  👨‍      Teacher");
    JPanel selectorTP=new JPanel();
    
    JLabel expensesB=new JLabel("<html> <pre><font style=\" font-size:20; font-family:arial;\">  💲     Expenses");
    JPanel selectorEP=new JPanel();
    
    JLabel settingsB=new JLabel("<html> <pre><font style=\" font-size:20; font-family:arial;\">  ⚙     Settings");
    JPanel selectorSeP=new JPanel();
    
    JLabel confiB=new JLabel("<html> <pre><font style=\" font-size:20; font-family:arial;\">  🛠    Configuration");
    JPanel selectorCP=new JPanel();
    
    JPanel upperLineP=new JPanel();
    
    JLabel introL=new JLabel("Intro");
    //Student studentP=new Student();
    Configuration configurationP=new Configuration();
    
    
    
    public Home() {
        
        add(upperLineP);
        add(sideButtonP);
        add(containerP);
        
    }
    
    void design(int x,int y,int width, int height,MainFrame f){
        
        f.setTitle("School Automation System/Home");;
  
        upperLineP.setBounds(x*20, 0, width, 10);
        upperLineP.setBackground(new Color(30,19,34));
        
        designSideButtonP(x,y,width,height,f);
        designContainerP(x,y,width,height,f);
        
        f.student.hid();
        //introP.setVisible(true);
        setLayout(null);
        setBounds(0, 0, width, height);
        setVisible(true);        
        System.out.println("inside Home");
        
    }
    
    void designSideButtonP(int x, int y, int width, int height,MainFrame f){
                
        int w=x*20;
            
        sideButtonP.setBounds(0, 0, x*20, height);
        sideButtonP.setLayout(null);
        sideButtonP.setBackground(new Color(30,19,34));
        sideButtonP.setBorder(new SoftBevelBorder(0));
        
        sideButtonP.add(studentB);
        sideButtonP.add(teacherB);
        sideButtonP.add(expensesB);
        sideButtonP.add(settingsB);
        sideButtonP.add(confiB);
            
        studentB.setBounds(0,y*10 ,w , y*10);
        studentB.setOpaque(true);
        studentB.setBackground(Color.GRAY);
        studentB.setForeground(Color.white);
        studentB.setBorder(new LineBorder(Color.white, 1, true));
        studentB.setLayout(null);
        studentB.add(selectorSP);
        
        selectorSP.setBackground(Color.RED);
        selectorSP.setBounds(2,0,10,studentB.getHeight());
        selectorSP.setVisible(false);
        
        studentB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //studentP.design(x, y, width, height, f);
                f.student.sho();
                
                configurationP.setVisible(false);
                                
            }
             @Override
            public void mousePressed(MouseEvent e) {
                selectorCP.setVisible(false);
                selectorEP.setVisible(false); 
                selectorSP.setVisible(true);
                selectorSeP.setVisible(false);
                selectorTP.setVisible(false); 
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                 
            }
             @Override
            public void mouseEntered(MouseEvent e) {
                studentB.setBackground(new Color(105,105,105));
            }
             @Override
            public void mouseExited(MouseEvent e) {
                studentB.setBackground(new Color(30,19,34));
            }
        });
                       
        teacherB.setBounds(0,y*22 ,w , y*10);
        teacherB.setBorder(new LineBorder(Color.white, 1, true));
        teacherB.setBackground(new Color(30,19,34));
        teacherB.setForeground(Color.white);
        teacherB.setOpaque(true);
        teacherB.setLayout(null);
        teacherB.add(selectorTP);
        
        selectorTP.setBackground(Color.RED);
        selectorTP.setBounds(2,0,10,studentB.getHeight());
        selectorTP.setVisible(false);
        
        teacherB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                                
            }
             @Override
            public void mousePressed(MouseEvent e) {
                selectorCP.setVisible(false);
                selectorEP.setVisible(false); 
                selectorSP.setVisible(false);
                selectorSeP.setVisible(false);
                selectorTP.setVisible(true);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                 
            }
             @Override
            public void mouseEntered(MouseEvent e) {
                teacherB.setBackground(new Color(105,105,105));
            }
             @Override
            public void mouseExited(MouseEvent e) {
                teacherB.setBackground(new Color(30,19,34));
            }
        });
        
        expensesB.setBounds(0,y*34 ,w , y*10);
        expensesB.setBorder(new LineBorder(Color.white, 1, true));
        expensesB.setBackground(new Color(30,19,34));
        expensesB.setForeground(Color.white);
        expensesB.setOpaque(true);
        expensesB.setLayout(null);
        expensesB.add(selectorEP);
        
        selectorEP.setBackground(Color.RED);
        selectorEP.setBounds(2,0,10,studentB.getHeight());
        selectorEP.setVisible(false);
        
        expensesB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                                
            }
             @Override
            public void mousePressed(MouseEvent e) {
                selectorCP.setVisible(false);
                selectorEP.setVisible(true); 
                selectorSP.setVisible(false);
                selectorSeP.setVisible(false);
                selectorTP.setVisible(false);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                 
            }
             @Override
            public void mouseEntered(MouseEvent e) {
                expensesB.setBackground(new Color(105,105,105));
            }
             @Override
            public void mouseExited(MouseEvent e) {
                expensesB.setBackground(new Color(30,19,34));
            }
        });
          
        settingsB.setBounds(0,y*46 ,w , y*10);
        settingsB.setBorder(new LineBorder(Color.white, 1, true));
        settingsB.setBackground(new Color(30,19,34));
        settingsB.setForeground(Color.white);
        settingsB.setOpaque(true);
        settingsB.setLayout(null);
        settingsB.add(selectorSeP);
        
        selectorSeP.setBackground(Color.RED);
        selectorSeP.setBounds(2,0,10,studentB.getHeight());
        selectorSeP.setVisible(false);
        
        settingsB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                                
            }
             @Override
            public void mousePressed(MouseEvent e) {
                selectorCP.setVisible(false);
                selectorEP.setVisible(false); 
                selectorSP.setVisible(false);
                selectorSeP.setVisible(true);
                selectorTP.setVisible(false);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                 
            }
             @Override
            public void mouseEntered(MouseEvent e) {
                settingsB.setBackground(new Color(105,105,105));
            }
             @Override
            public void mouseExited(MouseEvent e) {
                settingsB.setBackground(new Color(30,19,34));
            }
        });
            
        confiB.setBounds(0,y*58 ,w , y*10);
        confiB.setBackground(new Color(30,19,34));
        confiB.setForeground(Color.white);
        confiB.setBorder(new LineBorder(Color.white, 1, true));
        confiB.add(selectorCP);
        confiB.setOpaque(true);
        confiB.setLayout(null);
        
        selectorCP.setBackground(Color.RED);
        selectorCP.setBounds(2,0,10,studentB.getHeight());
        selectorCP.setVisible(false);
     
        confiB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                configurationP.design(x, y, width, height, f);
                f.student.hid();
                
                f.student.hid();   
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectorCP.setVisible(true);
                selectorEP.setVisible(false); 
                selectorSP.setVisible(false);
                selectorSeP.setVisible(false);
                selectorTP.setVisible(false);               
            }
             @Override
            public void mouseReleased(MouseEvent e) {
                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                
                confiB.setBackground(new Color(105,105,105));
            }
             @Override
            public void mouseExited(MouseEvent e) {
                
                confiB.setBackground(new Color(30,19,34));
            }
        });
        
    }
    
    void designContainerP(int x, int y, int width,int height,MainFrame f){
        
        containerP.setLayout(null);
        containerP.setBorder(new LineBorder(Color.black, 2, true));
        containerP.setBounds(x*20, 10, x*85, height);
        containerP.setBackground(Color.WHITE);
        

        introL.setBounds(x*10,y*10,x*80,y*80);
        introL.setBackground(Color.LIGHT_GRAY);
        introL.setBorder(new LineBorder(Color.black, 5, true));
        introL.setOpaque(true);
        

        containerP.add(f.student,0);
        containerP.add(configurationP,1);
    }
    
}
