package schoolautomationsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
//import javax.swing.JTable;

public class ViewStudentsRecords extends JPanel{
    
    JLabel registerB=new JLabel("<html> <pre><font style=\" font-size:20; font-family:arial;\">  View All Data");
    
  //  JTable table=new JTable();
    JScrollPane scrollP=new JScrollPane();
    
    MyConnection mycon=new MyConnection();
    
    int HEIGHT=50,BOND_LOCATION=0;
    JPanel buttonP=new JPanel();
    JLabel showall=new JLabel("<html><pre> <b>SHOW ALL");
    JLabel search=new JLabel("<html><pre> <b>SHOW ALL");
    
    
    JPanel displayP=new JPanel();
    
    JPanel infoP=new JPanel();
    JLabel imgL=new JLabel("<html><pre>Image");
    JLabel nameL=new JLabel("<html><pre>Name");
    JLabel clasL=new JLabel("<html><pre>Class");
    JLabel markL=new JLabel("<html><pre>Marks");
    JLabel mobileNoL=new JLabel("<html><pre>Contact Number");
    JLabel emailL=new JLabel("<html><pre>Email");
    JLabel yearJoinL=new JLabel("<html><pre>Year Of Joining");
    
    JLabel test =new JLabel("anna vau vau");
    
    JPanel info[];
    JLabel img[];
    JLabel name[];
    JLabel clas[];
    JLabel marks[];
    JLabel mobileNumber[];
    JLabel email[];
    JLabel yearJoin[];
    
    JComboBox classCB=new JComboBox();

    JPanel tableP;
    int count=0,i=0;
    String str="";   
    
    Thread t;
    
    public ViewStudentsRecords() {
        add(infoP);
        add(buttonP);
        add(scrollP);
        add(displayP,0);
        i=0;
        str="";
        count=0;
        BOND_LOCATION=0;
    }
    
    void design(int x, int y){
        
         i=0;
        str="";
        count=0;
        BOND_LOCATION=0;
         tableP=new JPanel();
        System.out.println("inside view studet record panel");
        setBounds(x, y,x*82 , y*87);
        //setBackground(Color.WHITE);
        //setVisible(true);
        setLayout(null);
        
        displayP.setVisible(false);
        displayP.setBounds(x*3, y*3, getWidth()-(x*6), getHeight()-(y*6));
        displayP.setBackground(Color.red);
        displayP.setBorder(new SoftBevelBorder(0));
        
        setBackground(Color.white);
        
        addMouseListener(new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 displayP.setVisible(false);
                 scrollP.setVisible(true);
                 buttonP.setVisible(true);
             }

             @Override
             public void mousePressed(MouseEvent e) {
                 
             }

             @Override
             public void mouseReleased(MouseEvent e) {
                 
             }

             @Override
             public void mouseEntered(MouseEvent e) {
                 
             }

             @Override
             public void mouseExited(MouseEvent e) {
                 
             }
         });
        
        x=x*82;y=y*85;
        x=x/100;y=y/100;
        
        //tableP.setPreferredSize(new Dimension(scrollP.getWidth(), HEIGHT));
        
    //    table.setModel(new javax.swing.table.DefaultTableModel(new Object[100][4],new String[] {"Name","Class","Roll"}));
        
     //   scrollP.setViewportView(table);
     
        designButtonP(x,y);
        
        designInfoP(x,y);   
        
        scrollP.setBounds(0, y*40, getWidth(), y*75);
        scrollP.setViewportView(tableP);
        
      /*  t=new Thread(vst);
            t.start();*/
        
    }
    
    void hid(){
        setVisible(false);
    }
    
    void sho(){
        setVisible(true);
    }
    
    void designButtonP(int x, int y){
        
        buttonP.setBounds(x, y, getWidth()-(x*2), y*30);
        buttonP.setBorder(new SoftBevelBorder(0));
        buttonP.setLayout(null);
        
        showall.setBounds(x*2, y*7, 90, 40);
        showall.setOpaque(true);
        showall.setBorder(new LineBorder(Color.blue, 2, true));
        showall.setBackground(Color.yellow);
        
        showall.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Thread t1= new Thread(new Runnable() {
                    @Override
                    public void run() {
                        fetch("Select count(*) from studentname","Select * from studentname");
                    }
                });
                
                t1.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                showall.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                showall.setForeground(Color.black);
            }
        });
            
        classCB.setBounds(x*50, y*7, x*12, y*5);
        classCB.removeAllItems();
        
        classCB.addItem("select class");
        try {
            
            mycon.pre_s=mycon.conn.prepareStatement("Select Name,Id from courses order by Id");
            mycon.r_set=mycon.pre_s.executeQuery();
            
            while(mycon.r_set.next()){
                classCB.addItem(mycon.r_set.getString(1)+"      "+mycon.r_set.getInt(2));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", 1);
        }
        
        search.setBounds(x*50, y*20, 90, 40);
        search.setOpaque(true);
        search.setBorder(new LineBorder(Color.blue, 2, true));
        search.setBackground(Color.yellow);
        
        search.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Thread t1= new Thread(new Runnable() {
                    @Override
                    public void run() {
                        fetch("Select count(*) from studentname where CourseId="+classCB.getSelectedIndex(),"Select * from studentname where CourseId="+classCB.getSelectedIndex());
                    }
                });
                
                t1.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                search.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                search.setForeground(Color.black);
            }
        });
        
        buttonP.add(search);
        buttonP.add(classCB);
        buttonP.add(showall);
        buttonP.setVisible(true);
    }
    
    void designInfoP(int x, int y){
        
        infoP.setBounds(0, y*36, getWidth(), y*4);
        infoP.setLayout(new GridLayout(1, 7, 5, 0));
        //infoP.setBackground(Color.red);
        
        x=getWidth();x=x/100;
        int w=x;
        
        imgL.setBounds(0, 0, w*10, infoP.getHeight());
        imgL.setOpaque(true);
        
        nameL.setBounds(x*11, 0, w*20, infoP.getHeight());
        nameL.setOpaque(true);
        
        clasL.setBounds(x*32, 0, w*10, infoP.getHeight());
        clasL.setOpaque(true);
        
        markL.setBounds(x*43, 0, w*7, infoP.getHeight());
        markL.setOpaque(true);
        
        mobileNoL.setBounds(x*51, 0, w*20, infoP.getHeight());
        mobileNoL.setOpaque(true);
        
        emailL.setBounds(x*72, 0, w*20, infoP.getHeight());
        emailL.setOpaque(true);
        
        yearJoinL.setBounds(x*93, 0, w*15, infoP.getHeight());
        yearJoinL.setOpaque(true);
        
        infoP.add(imgL,0);
        infoP.add(nameL,1);
        infoP.add(clasL,2);
        infoP.add(markL,3);
        infoP.add(mobileNoL,4);
        infoP.add(emailL,5);
        infoP.add(yearJoinL,6);
    }

    public void fetch(String str,String str2) {
        tableP.removeAll();
        BOND_LOCATION=0;
        i=0;
        try {
            mycon.pre_s=mycon.conn.prepareStatement(str);
            mycon.r_set=mycon.pre_s.executeQuery();
            mycon.r_set.next();
            count=mycon.r_set.getInt(1);
            System.out.println("count "+count);
            
            info=new JPanel[count];
             img=new JLabel[count];
             name=new JLabel[count];
            clas=new JLabel[count];
             marks=new JLabel[count];
             mobileNumber=new JLabel[count];
             email=new JLabel[count];
             yearJoin=new JLabel[count];
            
            mycon.pre_s=mycon.conn.prepareStatement(str2);
            mycon.r_set=mycon.pre_s.executeQuery();
            mycon.r_set.beforeFirst();
            i=0;
            while(mycon.r_set.next()){
                scrollP.setViewportView(tableP);
                str=mycon.r_set.getString(2)+" "+mycon.r_set.getString(3);
                
                info[i]=new JPanel();
                
                name[i]=new JLabel();
                name[i].setText(str);
                System.out.print("name "+str);
                
                clas[i]=new JLabel();
                clas[i].setText(""+mycon.r_set.getInt(8));
                System.out.print("  class "+mycon.r_set.getInt(8));
                
                marks[i]=new JLabel();
                marks[i].setText("null");
                System.out.print("  marks ");
                
                mobileNumber[i]=new JLabel();
                mobileNumber[i].setText(mycon.r_set.getString(6));
                System.out.print("  MN  "+mycon.r_set.getString(6));
                
                email[i]=new JLabel();
                email[i].setText(mycon.r_set.getString(7));
                System.out.print("  email "+ mycon.r_set.getString(7));
                
                img[i]=new JLabel();
              
       
                            
                           /* System.out.print("  imageR "+ mycon.r_set.getString(9));
                            str=mycon.r_set.getString(9);
                            str=str.replace("\\", "/");
                            System.out.println("/"+str);
                            File f=new File(str);
                            img[i].setIcon(new ImageIcon(ImageIO.read(f).getScaledInstance(60, 50, 4)));*/
         
                
               
                //img[i].setOpaque(true);
                
                //img[i].setBounds(0, 0, x*10, info[i].getHeight());
                
                
                //img[i].setBackground(Color.red);
                
                
                
                //barr=blob.getBytes(1,(int)a );
                
               /* try {
                    img[i].setIcon(new ImageIcon( ImageIO.read(mycon.r_set.getBlob(8).getBinaryStream())));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex, "ERROR", 1);
                    System.out.println(ex);
                }*/
                //System.out.println("\n"+mycon.r_set.getBlob(8)+"  length  "+mycon.r_set.getBlob(8).length());

                
                //name[i].setBounds(x*11, 0, x*20, info[i].getHeight());
                //name[i].setOpaque(true);

                //clas[i].setBounds(x*32, 0, x*10, info[i].getHeight());
                //clas[i].setOpaque(true);

                //marks[i].setBounds(x*43, 0, x*7, info[i].getHeight());
                //marks[i].setOpaque(true);

                //mobileNumber[i].setBounds(x*51, 0, x*20, info[i].getHeight());
               // mobileNumber[i].setOpaque(true);

               // email[i].setBounds(x*72, 0, x*20, info[i].getHeight());
                //email[i].setOpaque(true);

                yearJoin[i]=new JLabel();
               // yearJoin[i].setBounds(x*93, 0, x*15, info[i].getHeight());
                //yearJoin[i].setOpaque(true);
                
                //info[i].setBounds(0, BOND_LOCATION,tableP.getWidth() , 40);
                //info[i].setPreferredSize(new Dimension(tableP.getWidth(), 50));
                info[i].setLayout(new GridLayout(1, 7, 0, 3));
                
                info[i].setVisible(true);
                //info[i].setBackground(Color.YELLOW);
               // info[i].setBorder(new LineBorder(Color.blue,3,true));
               info[i].setBorder(new SoftBevelBorder(1));
                //info[i].setForeground(Color.red);
                final int p=i;
                
                email[p].setToolTipText(email[p].getText());
                info[i].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(p+1);
                        displayP.setVisible(true);
                        
                        scrollP.setVisible(false);
                        buttonP.setVisible(false);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        info[p].setBorder(new SoftBevelBorder(0));
                        
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        info[p].setBorder(new SoftBevelBorder(1));
                        
                    }
                });
                
                scrollP.setViewportView(tableP);
                
             /*   test.setBounds(0, 10,tableP.getWidth()-100 , 200);
               // test.setLayout(null);
                test.setVisible(true);
                test.setOpaque(true);
                test.setBackground(Color.black);*/
                
                info[i].add(img[i],0);
                info[i].add(name[i],1);
                info[i].add(clas[i],2);
                info[i].add(marks[i],3);
                info[i].add(mobileNumber[i],4);
                info[i].add(email[i],5);
                info[i].add(yearJoin[i],6);
                
                tableP.setVisible(false);
                tableP.setVisible(true);
                tableP.setPreferredSize(new Dimension(scrollP.getWidth()-2,BOND_LOCATION ));
                tableP.setLayout(new GridLayout(count+1,1,2,5));
                //tableP.setBackground(Color.pink);
                tableP.add(info[i],i);
                System.out.println("number of components "+tableP.getComponentCount());
                
                
                BOND_LOCATION+=HEIGHT;
                System.out.println("bond location"+BOND_LOCATION);
           
                System.out.println(i);
                i++;
            }
            tableP.setVisible(false);
            tableP.setVisible(true);
           /* Thread t2=new Thread(new Runnable() {
                    @Override
                        public void run() {
                        int k=0;
                            try{
                            mycon.r_set.beforeFirst();
                        while(mycon.r_set.next()){    
                            
                                Blob blob=mycon.r_set.getBlob(8);
                                long a=blob.length();
                                System.out.println("long vale "+a);
                                byte barr[]=mycon.r_set.getBytes("Image");//new byte[(int)a];
                                System.out.println("barr "+barr);
                                InputStream is =new ByteArrayInputStream(barr);
                                BufferedImage newbi;

                                try {
                                    newbi=ImageIO.read(is);
                                    System.out.println("\n"+barr);
                                    ImageIcon imgpic;
                                    imgpic = new ImageIcon(newbi.getScaledInstance(60, 50,4));
                                    img[ k ].setIcon(imgpic);
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, ex,"error",1);
                                    System.err.println(ex);
                                    ex.getStackTrace();
                                }
                                k++;
                            }
                            } catch (SQLException ex) {
                                System.err.println(ex);
                                ex.getStackTrace();
                                JOptionPane.showMessageDialog(null, ex, "Error", 1);
                            tableP.setVisible(false);
                            tableP.setVisible(true);
                        }  
                        }
                 
                });
                t2.start();*/
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "NO data", 1);
            System.err.println(ex.getStackTrace());
            
        } /*catch (IOException ex) {
            Logger.getLogger(ViewStudentsRecords.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
       
    }
    
    
    
}
