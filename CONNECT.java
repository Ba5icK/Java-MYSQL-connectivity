/*

JPL Assignment-4


Write a swing aplication to make an application form which includes the following:
    1) Labels: Name (Textbox), Roll No (Textbox), CGPI (Textbox), Semester (Combobox), Gender (Radio Button)
    2) Buttons: Submit, Clear, Exit
Connect it to a database via JDBC

*/

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class CONNECT
  {
    JFrame f;
   JLabel l1,l2,l3,l4,l5,l7,l8;
   JTextField t1,t2,t3,t4,t5,t8;
   JButton b1,b2,b3,b4,b5,b6;

    Connection con1;
    Statement st1;
    ResultSet rs;
    
    public static void main(String args[])
     {
       CONNECT r1=new CONNECT();
        r1.frame();
    }


    public void connect1(String s1,String s2,String s3,String s4) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","RayanC","password@123");
            st1 = con1.createStatement();
            String str = "INSERT INTO book VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
            st1.executeUpdate(str);
            }
         catch (Exception ex) 
            {
            ex.printStackTrace();
            }
    }

    public void dele(String s1)
    {
         try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","RayanC","password@123");
            st1 = con1.createStatement();
            String str = "DELETE FROM book WHERE bname='"+s1+"';";
            st1.executeUpdate(str);
            }
         catch (Exception ex) 
            {
            ex.printStackTrace();
            }
    }

     public void disp(String s2)
    {
         try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","RayanC","password@123");
            st1 = con1.createStatement();
            String str = "SELECT *FROM book WHERE bname='"+s2+"';";
           // st1.executeUpdate(str);
            //}

            ResultSet rs=st1.executeQuery(str);
            
            //to print the resultset on console
            if(rs.next())
            { 
                /*
                do{
                System.out.println("Book no: "+rs.getString(1)+"\n"+"Book name: "+rs.getString(2)+"\n"+"Book Author: "+rs.getString(3)+"\n"+"Book Price:"+rs.getString(4));//+","+rs.getString(5));
                }while(rs.next());
                */

                String str1="Book no: "+rs.getString(1);
                String str2="Book name: "+rs.getString(2);
                String str3="Book Author: "+rs.getString(3);
                String str4="Book Price:"+rs.getString(4);
                
                JTextField t6=new JTextField();
                t6.setBounds(400,450,200,30);
                t6.setText(str1);
                f.add(t6);

                JTextField t11=new JTextField();
                t11.setBounds(400,500,200,30);
                t11.setText(str2);
                f.add(t11);

                JTextField t12=new JTextField();
                t12.setBounds(400,550,200,30);
                t12.setText(str3);
                f.add(t12);

                JTextField t13=new JTextField();
                t13.setBounds(400,600,200,30);
                t13.setText(str4);
                f.add(t13);

            }
            else{
                String strr="Record Not Found...";
                JTextField t6=new JTextField();
                t6.setBounds(400,450,400,400);
                t6.setText(strr);
                f.add(t6);
            }
        }
         catch (Exception ex) 
            {
            ex.printStackTrace();
            }
    }

    public void frame() 
    {

     f=new JFrame ("Student Information");


        l1=new JLabel("Book No");
        l1.setBounds(50,20,100,40 );
        t1= new JTextField();
        t1.setBounds(150,20, 200,30); 


        l2=new JLabel("Book name");
        l2.setBounds(50,60, 100,40 );
        t2= new JTextField();
        t2.setBounds(150,60,200,30);

        l3=new JLabel("Book  author");
        l3.setBounds(50,100,100,40 );
        t3= new JTextField();
        t3.setBounds(150,100,200,30);

        l4=new JLabel("Book price");
        l4.setBounds(50,140,100,40 );
        t4= new JTextField();
        t4.setBounds(150,150,200,30);

        JLabel l6=new JLabel("DELETE A RECORD");
        l6.setBounds(50,270,200,20);

        l5=new JLabel("Book name");
        l5.setBounds(50,300,150,30);
        t5=new JTextField("");
        t5.setBounds(150,300,200,30);

        l7=new JLabel("DISPLAY INFO ABOUT A BOOK");
        l7.setBounds(50,450,200,30);

        l8=new JLabel("Book name");
        l8.setBounds(50,500,150,30);
        t8=new JTextField("");
        t8.setBounds(150,500,200,30);


        b1=new JButton("Submit");
        b1.setBounds(200,200,100,50);

        b2=new JButton("Clear");
        b2.setBounds(400,200,100,50);

        b3=new JButton("Exit");
        b3.setBounds(600,200,100,50);

        b4=new JButton("DELETE");
        b4.setBounds(200,370,100,50);

        b6=new JButton("DISPLAY");
        b6.setBounds(200,550,100,50);

        b5=new JButton("Welcome");
        b5.setBounds(200,400,100,50);

     //f.setLayout(null);
    
         f.add(l1);
         f.add(l2);
         f.add(l3);
         f.add(l4);
         f.add(l5);
         f.add(l6);
         f.add(l7);
         f.add(l8);
         f.add(t1);
         f.add(t2);
         f.add(t4);
        f.add(t3);
        
        f.add(t5);
        f.add(t8);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b6);
        f.add(b5);
        

         f.setVisible(true);
         f.pack();


     b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
       
         String s1=t1.getText();
         String s2=t2.getText();
         String s3=t3.getText();
        String s4=t4.getText();
         
            connect1(s1,s2,s3,s4);
        }

    });


        b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        }
        });


        b3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
        System.exit(0);
        }
        });

        b4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
        String s5=t5.getText(); 
        dele(s5);
        } });

        b6.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
        String s8=t8.getText(); 
        disp(s8);
        } });

        

        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,800);
        f.setVisible(true);

}
}
