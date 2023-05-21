package schoolautomationsystem;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Configuration extends JPanel {
    
    JPanel upperButtonP = new JPanel();
    JPanel bodyP = new JPanel();
    
    JButton addCourseB = new JButton("Add Course");
    JButton feeB = new JButton("Fee Settings");
    
    AddCourse addCourseP=new AddCourse();

    public Configuration() {
        add(upperButtonP);
        add(bodyP);
    }
    
    void design(int x, int y, int width, int height,MainFrame f){
    
        f.setTitle("School Automation System/Home/Configuration*\"Settings\"");
        setLayout(null);
        
        designUpperButtonP(x,y);
        designBodyP(x,y);
       
       
        
        setBounds(0,0,width,height);
        setVisible(true); 
    }
    
    void designUpperButtonP(int x, int y){
        upperButtonP.setLayout(new GridLayout(1, 7,2,3));
        upperButtonP.setBounds(0,0,x*100,y*7);
        upperButtonP.setBorder(new LineBorder(Color.BLACK, 2, true));
        
        addCourseB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //addCourseP.design(x,y,x*100,y*91);
            }
        });
        
        upperButtonP.add(addCourseB,0);
        upperButtonP.add(feeB,1);
        
    }
    
    void designBodyP(int x,int y){
        bodyP.setBounds(0, y*8, x*100, y*91);
        bodyP.setBorder(new LineBorder(Color.BLACK, 2, true));
        bodyP.setLayout(null);
        bodyP.add(addCourseP);
        
    }
}
