
package schoolautomationsystem;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Student extends JPanel{
    
    JPanel upperButtonPanel=new JPanel();
    JPanel bodyP=new JPanel();
    
    
    JLabel addB=new JLabel("<html><pre><font style=\" font-size:20;\">  📋    Add New Student");
    JLabel viewB=new JLabel("<html><pre><font style=\" font-size:20;\"> 📜  View Students Record");
    JLabel deleteB=new JLabel("<html><pre><font style=\" font-size:20;\">  🗑   Delete Record");
    
    /*JLabel calculatedAgeL=new JLabel();
    JLabel dayOfJoining=new JLabel();*/
    
    
    
    //AddNewStudent aNSP = new AddNewStudent();
    
    //ViewStudentsRecords vSRP=new ViewStudentsRecords();
    
    MyConnection con=new MyConnection();

    public Student() {
        //add(fileChooserP,0);
        add(upperButtonPanel,0);
        add(bodyP,1);
        
    }
    
    void design(int x, int y, int width, int height,MainFrame f){
        System.out.println("inside Studet");
        f.setTitle("School Automation System/Home/Student*\"Here You Can Manage Student Record\"");
        
        setLayout(null);
        
        setBackground(Color.red);
        
        designUpperButtonPanel(x,y,f);
        designBodyP(x,y,f);

        setBounds(0,0,width,height);
        //setVisible(true); 
    }
    
    void hid(){
        setVisible(false);
    }
    
    void sho(){
        setVisible(true);
    }
    
    void designUpperButtonPanel(int x,int y,MainFrame f){
        upperButtonPanel.setBounds(0,0,x*100,y*8);
        upperButtonPanel.setBackground(Color.WHITE);
        upperButtonPanel.setLayout(null);
        
        addB.setBounds(x, 0, x*25, upperButtonPanel.getHeight());
        addB.setBorder(new LineBorder(Color.black, 1, true));
        addB.setOpaque(true);
        addB.setBackground(Color.WHITE);
            addB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
                //aNSP.design(x, y);
               f.aNS.setVisible(true);
                f.vSR.hid();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                addB.setBackground(Color.gray);
                addB.setForeground(Color.WHITE);
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addB.setBackground(Color.WHITE);
                addB.setForeground(Color.black);
            }
        });
            
        viewB.setBounds(x*32, 0, x*25, upperButtonPanel.getHeight());
        viewB.setBorder(new LineBorder(Color.black, 1, true));
        viewB.setOpaque(true);
        viewB.setBackground(Color.WHITE);
        viewB.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                //f.vSR.design(x,y);
                //if(!t2.isAlive())
                f.vSR.sho();
                f.aNS.hid();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                viewB.setBackground(Color.gray);
                viewB.setForeground(Color.WHITE);
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                viewB.setBackground(Color.WHITE);
                viewB.setForeground(Color.black);
            }
        });
        
        deleteB.setBounds(x*62, 0, x*20, upperButtonPanel.getHeight());
        deleteB.setBorder(new LineBorder(Color.black, 1, true));
        deleteB.setOpaque(true);
        deleteB.setBackground(Color.WHITE);
        deleteB.addMouseListener(new MouseListener() {
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
                deleteB.setBackground(Color.gray);
                deleteB.setForeground(Color.WHITE);
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deleteB.setBackground(Color.WHITE);
                deleteB.setForeground(Color.black);
            }
        });
        
        upperButtonPanel.add(addB);
        upperButtonPanel.add(viewB);
        upperButtonPanel.add(deleteB);
    }
    
    void designBodyP(int x,int y,MainFrame f){
        bodyP.setLayout(null);
        bodyP.setBounds(0, y*8, x*100, y*92);
        bodyP.add(f.aNS);
        bodyP.add(f.vSR);
        //bodyP.setBackground(Color.white);
        
    }
    
     
}
