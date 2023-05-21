package schoolautomationsystem;

import org.jdesktop.swingx.JXDatePicker;

public class DateModifier {

    public DateModifier() {
    }
    
    String convert(JXDatePicker pic){
        try{
            String s=pic.getDate().toString();
                    System.out.println("date "+pic.getDate());
                    char m[]=new char[3];//use in switch to convert month into integer
                    char d[]=new char[11];//hold original interger date value
                    String kk;
                    s.getChars(24,28 , d, 0);
                    System.out.println(d);
                    d[4]='-';
                    s.getChars(4, 7, m, 0);
                    kk=""+m[0]+m[1]+m[2];
                    System.out.println("kk= "+kk);
                    switch(kk){
                        case "Jan":
                            d[5]='0';
                            d[6]='1';
                            break;
                        case "Feb":
                            d[5]='0';
                            d[6]='2';
                            break;
                        case "Mar":
                            d[5]='0';
                            d[6]='3';
                            break;
                        case "Apr":
                            d[5]='0';
                            d[6]='4';
                            break;
                        case "May":
                            d[5]='0';
                            d[6]='5';
                            break;
                        case "Jun":
                            d[5]='0';
                            d[6]='6';
                            break;
                        case "Jul":
                            d[5]='0';
                            d[6]='7';
                            break;
                        case "Aug":
                            d[5]='0';
                            d[6]='8';
                            break;    
                        case "Sep":
                            d[5]='0';
                            d[6]='9';
                            break;
                        case "Oct":
                            d[5]='1';
                            d[6]='0';
                            break;
                        case "Nov":
                            d[5]='1';
                            d[6]='1';
                            break;
                        case "Dec":
                            d[5]='1';
                            d[6]='2';
                            break;
                    }
                    d[7]='-';
                    System.out.println(d);
                    s.getChars(8, 10, d, 8);
                    if(d[5]=='0'){
                        if(d[8]=='0'){
                            s=""+d[0]+d[1]+d[2]+d[3]+d[4]+d[6]+d[7]+d[9];
                        }else{
                            s=""+d[0]+d[1]+d[2]+d[3]+d[4]+d[6]+d[7]+d[8]+d[9];
                        }
                    }else{
                        if(d[8]=='0'){
                            s=""+d[0]+d[1]+d[2]+d[3]+d[4]+d[5]+d[6]+d[7]+d[9];
                        }else{
                             s=""+d[0]+d[1]+d[2]+d[3]+d[4]+d[5]+d[6]+d[7]+d[8]+d[9];
                        }
                    }
                    System.out.println("date is="+s);
                    System.out.println(d);
                    System.out.println(pic.getDate()); 

                    System.out.println("date is="+s);

                    return s;
            }catch(NullPointerException ex){
                System.out.println("DateModifier "+ex);
                return "";
            }
        }
        
    }
    

