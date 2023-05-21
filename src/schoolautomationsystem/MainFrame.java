
package schoolautomationsystem;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {

    Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
    double w=ss.getWidth() , h=ss.getHeight();
    int width=(int)w,height=(int)h;
    int x=width/100,y=height/100;
    
    int clerkV=0,teacherV=0,adminV=0;
    
    Login login=new Login();
    Home homeCP=new Home();
   
    AddNewStudent aNS=new AddNewStudent();
    AddNewTeacher aNT=new AddNewTeacher();
    
    FeeP feeP=new FeeP();
    AddCourse addCourseP=new AddCourse();
    MarkSheet marShe=new MarkSheet();
    
    ViewStudentsRecords vSR=new ViewStudentsRecords();
    Student student=new Student();
    MyConnection conn=new MyConnection();
    
    Admin adminP=new Admin();
    Teacher teacherP=new Teacher();
    Clerk clerkP=new Clerk();
    
    public MainFrame() {
        renew();
        height=height-(y*5);
        //y=height;
        //initComponents();
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("School Automation System");
        setBounds(0, 0, width, height);
        setResizable(false);
        
        student.design(x, y, width, height, this);
        login.design(this);
        
        add(login,0);
        add(homeCP,1);
        add(adminP,2);
        add(teacherP,3);
        add(clerkP,4);
        setVisible(true);
        
    }

    void renew(){
    try{    
    aNS=new AddNewStudent();
    aNT=new AddNewTeacher();
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Device not competable "+ ex);
    }
    }
}
