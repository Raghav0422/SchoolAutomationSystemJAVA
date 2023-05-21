package schoolautomationsystem;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.TableColumn;



public class AddCourse extends JPanel{
    
    JTextField courseNameTF;
    JTextField courseAFeeTF;
    JTextField courseMFeeTF;
    JTextField subjectTF[];
    
    JPanel subjectP;  //add subject
    JScrollPane subjectSP;//add subject
    
    JPanel bodyP;
    
    JScrollPane subjectTableSP;
    //JPanel subjectTableP;
    JTable subjectT;
    
    JScrollPane courseTableSP;
    JTable courseT;
    
    JButton addSubjectB;
    JButton submitB;
    
    //MyConnection mycon;
    
    //AddNewStudent objANSP = new AddNewStudent();
    
    int[] colummWidth={40,200,200};
    int ph=0,i=1,j=0,id=0; //for text field which is going to create in every click of button
    String str="",subject="";

    public AddCourse() {
        
    }
    
    void design(MainFrame f) {

        int x = f.x, y = f.y, w = f.width, h = f.height;
        renew();

        setBounds(0, 0, w, h);
        //setBackground(new Color(5,0,5));
        setBorder(new LineBorder(Color.black, 2, true));
        setLayout(null);
        //setVisible(true);

        add(bodyP);
        add(courseTableSP);

        bodyP.setBounds(0, 0, getWidth(), y * 60 - y);
        bodyP.setLayout(null);
        bodyP.setBackground(Color.white);

        JLabel heading = new JLabel("<html> <font style=\"font-size:30;\">Add Class");
        heading.setBounds(x, y, bodyP.getWidth() - x, y * 5);
        heading.setHorizontalTextPosition(JLabel.CENTER);
        
        bodyP.add(subjectSP);
        bodyP.add(heading);
        bodyP.add(courseNameTF);
        bodyP.add(courseAFeeTF);
        bodyP.add(courseMFeeTF);
        bodyP.add(addSubjectB);
        bodyP.add(submitB);
        bodyP.add(subjectTableSP);

        courseNameTF.setBounds(x, y * 7, x * 15, y * 6);
        courseNameTF.setBorder(BorderFactory.createTitledBorder("Write Class Name"));

        courseAFeeTF.setBounds(x * 18, y * 7, x * 15, y * 6);
        courseAFeeTF.setBorder(BorderFactory.createTitledBorder("Enter Admission Fee"));

        courseMFeeTF.setBounds(x * 34, y * 7, x * 15, y * 6);
        courseMFeeTF.setBorder(BorderFactory.createTitledBorder("Enter Monthly Charges"));

        //designSubjectP(x,y,w,h);
        subjectSP.setBounds(x, y * 14, x*49, y * 40);
        subjectSP.setViewportView(subjectP);
        //subjectSP.setVisible(true);

        try {
            MyConnection mycon = new MyConnection();
            mycon.pre_s = mycon.conn.prepareStatement("select max(id) from courses;");

            mycon.r_set = mycon.pre_s.executeQuery();
            mycon.r_set.next();
            id = mycon.r_set.getInt(1);
            System.out.println("max id in course is " + id);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        id++;

        subjectP.setLayout(null);
        subjectP.setBackground(Color.white);
        subjectP.setPreferredSize(new java.awt.Dimension(x*45,ph+30));
        
        subjectTableSP.setViewportView(subjectT);
        
        designSubjectTableSP(x, y, w, h);
        designCourseTableSP(x, y, w, h);

        addSubjectB.setBounds(x, y * 55, x * 15, y * 5);
        addSubjectB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                designSubjectP(x, y, w, h);

            }
        });

        submitB.setBounds(x * 17, y * 55, x * 15, y * 5);;
        submitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int arrcount = 1, insertCount = 1;

                try {
                    MyConnection mycon = new MyConnection();
                    mycon = new MyConnection();
                    mycon.pre_s = mycon.conn.prepareStatement("INSERT INTO `courses` (`Id`, `Name`, `AdmissionFee`,`PerMFee`) VALUES (?,?,?,?);");
                    mycon.pre_s.setInt(1, id);
                    mycon.pre_s.setString(2, courseNameTF.getText().trim());
                    mycon.pre_s.setInt(3, Integer.parseInt(courseAFeeTF.getText().trim()));
                    mycon.pre_s.setInt(4, Integer.parseInt(courseMFeeTF.getText().trim()));

                    mycon.pre_s.executeUpdate();

                    try {
                        MyConnection con = new MyConnection();
                        while (arrcount < i) {
                            con.pre_s = con.conn.prepareStatement("INSERT INTO `subjects` (`CourseId`,`ID`, `Name`) VALUES (?,?,?);");
                            con.pre_s.setInt(1, id);
                            con.pre_s.setInt(2, arrcount);
                            con.pre_s.setString(3, subjectTF[arrcount].getText());
                            System.out.println(subjectTF[arrcount].getText() + " added");
                            arrcount++;
                            con.pre_s.executeUpdate();
                        }
                        mycon.pre_s.executeUpdate();
                        id++;
                        generateTableData();
                        CourseT();

                    } catch (SQLException ex) {
                        javax.swing.JOptionPane.showMessageDialog(null, ex + "VV", "ERROR", 2);
                        System.err.println(ex.getStackTrace());
                    } catch (Exception exc) {
                        javax.swing.JOptionPane.showMessageDialog(null, exc + "VV", "ERROR", 2);
                        System.err.println(exc.getStackTrace());
                    }

                    javax.swing.JOptionPane.showMessageDialog(null, "New Course has been added", "Course Added", 1);

                } catch (SQLException ex) {
                    javax.swing.JOptionPane.showMessageDialog(null, ex + "RR", "ERROR", 2);
                    System.err.println(ex);
                } catch (Exception exc) {
                    javax.swing.JOptionPane.showMessageDialog(null, exc + "RR", "ERROR", 2);
                    System.err.println(exc.getStackTrace());
                }

                str = "";
                subject = "";
                subjectP.removeAll();
                subjectP.setVisible(false);
                subjectP.setVisible(true);
                ph = 0;
                i = 1;
                generateTableData();
                CourseT();
                //objANSP.fillSelectClassCB();
                courseNameTF.setText("");
                courseAFeeTF.setText("");

            }
        });
    }
    
    void designSubjectP(int x, int y, int w,int h){
            
            subjectSP.setViewportView(subjectP);

            subjectTF[i]=new JTextField();
            subjectTF[i].setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.black, 1, true), "Subject"+i));
            subjectTF[i].setBounds(0,ph , subjectP.getWidth(), 40);
            subjectP.add(subjectTF[i]);
           
            
            ph=ph+42;i++;
            subjectP.setPreferredSize(new java.awt.Dimension(x*45,ph+30));
            //subjectP.setBackground(Color.gray);
    }
    
    void designSubjectTableSP(int x, int y, int w, int h) {

        subjectTableSP.setBounds(x*50, y, x*45, bodyP.getHeight()-y);
        subjectTableSP.setBorder(new LineBorder(Color.CYAN, 6, true));
        //subjectT.setModel(new javax.swing.table.DefaultTableModel(new Object[10][5],new String [] {"Id","Name","Fee"}));
        subjectT = new JTable(id + 10, 4) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1 || column == 2) {
                    return false;
                }
                return true;
            }
        };

        subjectTableSP.setViewportView(subjectT);

        TableColumn column = subjectT.getColumnModel().getColumn(0);
        column.setMinWidth(40);
        column.setMaxWidth(40);
        column.setPreferredWidth(40);

        i = 1;

        DefaultTableCellRenderer celRen = new DefaultTableCellRenderer();
        celRen.setHorizontalAlignment(JLabel.CENTER);

        subjectT.getColumnModel().getColumn(0).setHeaderValue("Id");
        subjectT.getColumnModel().getColumn(0).setCellRenderer(celRen);

        subjectT.getColumnModel().getColumn(1).setHeaderValue("Name");
        subjectT.getColumnModel().getColumn(1).setCellRenderer(celRen);

        subjectT.getColumnModel().getColumn(2).setCellRenderer(celRen);
        subjectT.getColumnModel().getColumn(2).setHeaderValue("Admission Fee");
        
        subjectT.getColumnModel().getColumn(3).setCellRenderer(celRen);
        subjectT.getColumnModel().getColumn(3).setHeaderValue("Per Month Charges");
        

        subjectT.setAutoCreateRowSorter(true);

        subjectT.getTableHeader().setBackground(new Color(32, 134, 203));
        subjectT.setShowVerticalLines(false);
        subjectT.setSelectionForeground(Color.white);
        subjectT.setSelectionBackground(new Color(255, 61, 50));
        subjectT.getTableHeader().setForeground(Color.white);
        subjectT.setRowHeight(25);
        subjectT.setIntercellSpacing(new Dimension(0, 0));
        //subjectT.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        generateTableData();

    }
    
    void generateTableData(){
        
        try{
            MyConnection mycon=new MyConnection();
            mycon.pre_s=mycon.conn.prepareStatement("Select * from courses");
            mycon.r_set=mycon.pre_s.executeQuery();
            i=0;
            while(mycon.r_set.next()){
                j=0;
                subjectT.setValueAt(mycon.r_set.getInt(1), i, j);
                j++;
                subjectT.setValueAt(mycon.r_set.getString(2), i, j);
                j++;
                subjectT.setValueAt(mycon.r_set.getString(4), i, j);
                j++;
                subjectT.setValueAt(mycon.r_set.getString(5), i, j);
                i++;
            }
            i=1;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", 2);
        }catch(NullPointerException npex){
            JOptionPane.showMessageDialog(null, npex, "Server Down", 2);
        }   
    }
    
    void designCourseTableSP(int x, int y, int w,int h){
        
        courseTableSP.setBounds(x, y*60, x*93, y*40);
        courseTableSP.setBorder(new LineBorder(Color.CYAN, 6, true));
        courseTableSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        CourseT();
    }
    
    void CourseT(){
        MyConnection conn=new MyConnection();
        int colCoun=id-1;
        courseT=new JTable(15,colCoun){
            @Override
            public boolean isCellEditable(int row, int column) {
       
                return false;
            }
        };;
        
        TableColumn column ;
        
        DefaultTableCellRenderer celRen = new DefaultTableCellRenderer();
        celRen.setHorizontalAlignment(JLabel.CENTER);
        
        try{
            conn.pre_s=conn.conn.prepareStatement("Select Name,Id from courses order by Id");
            conn.r_set=conn.pre_s.executeQuery();
            int c=0;
            while(conn.r_set.next()){
                courseT.getColumnModel().getColumn(c).setHeaderValue(conn.r_set.getString(1));
                
                column = courseT.getColumnModel().getColumn(c);
                
                courseT.getColumnModel().getColumn(c).setCellRenderer(celRen);
                
                column.setMinWidth(120);
                
                MyConnection conn1=new MyConnection();
                conn1.pre_s=conn1.conn.prepareStatement("Select Name from subjects where CourseId=? order by Id");
                conn1.pre_s.setInt(1, conn.r_set.getInt(2));
                conn1.r_set=conn1.pre_s.executeQuery();
                int r=0;
                while(conn1.r_set.next()){
                    courseT.setValueAt(conn1.r_set.getString(1), r, c);
                    r++;
                }
                c++;
            }
           c=1;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", 2);
            System.err.println(ex.getStackTrace());
        }catch(NullPointerException npex){
            JOptionPane.showMessageDialog(null, npex, "Server Down", 2);
            System.err.println(npex.getStackTrace());
        }
        courseT.getTableHeader().setBackground(new Color(32, 134, 203));
        courseT.setShowHorizontalLines(false);
        courseT.setSelectionForeground(Color.white);
        courseT.setSelectionBackground(new Color(255, 61, 50));
        courseT.getTableHeader().setForeground(Color.white);
        courseT.setRowHeight(25);
        courseT.setIntercellSpacing(new Dimension(0, 0));
        
        courseTableSP.setViewportView(courseT);
    }
    
    void renew(){
        courseNameTF=new JTextField();
        courseAFeeTF=new JTextField();
        courseMFeeTF=new JTextField();
        subjectTF=new JTextField[20];

        bodyP=new JPanel();

        subjectP=new JPanel();
        subjectSP=new JScrollPane();

        subjectTableSP=new JScrollPane();
        //subjectTableP=new JPanel();
        subjectT=new JTable(7,3);

        courseTableSP=new JScrollPane();
        courseT=new JTable(10,2);

        addSubjectB=new JButton("Click here for new Subject Row");
        submitB=new JButton("Add Recor");

        //mycon=new MyConnection();

        ph=0;i=1;j=0; //for text field which is going to create in every click of button
        str="";subject="";
    }
    
}
