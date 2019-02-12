package boat;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;

public final class tease extends JFrame {
    
    JLabel label;
    JLabel label2,label3,label4;
    String[] str = new String[1000];
    File file,file1,file2,file3,file4,file5;   
    JTextField textfield;
    FileReader reader = null;
    BufferedReader bufferr = null ;
    BufferedWriter bufferw = null ;
    FileWriter writer = null;
    int instance = 0;
    int load = 0;
    JPanel panel;
    String hji[];
    JButton butt1,butt2,butt3;
    
    tease() 
      {    
          time();
           file = new File("C:\\boat\\string.txt");
           file1 = new File("C:\\boat\\show.txt");
           file2 = new File("C:\\boat\\datafile.txt");
           file3 = new File("C:\\boat\\task.txt");
           file4 = new File("C:\\boat\\problem.txt"); 
           file5 =new File("C:\\boat\\coding lines.txt");
           try {
               if(file.createNewFile() && file1.createNewFile() &&file2.createNewFile())
               {
                    System.out.print("files are maked now");
                    instance = 1000;
                    writer =  new FileWriter(file);
                    bufferw = new BufferedWriter(writer);
                    
                    bufferw.write(Integer.toString(instance));
                    
                    bufferw.close();
                    writer.close();
                    
                    writer = new FileWriter(file2);
                    bufferw = new BufferedWriter(writer);
                    
                    bufferw.write(Integer.toString(instance));
                    bufferw.close();
                    writer.close();      
               }
               else
               {
                   System.out.println("files are already created");
               }
           } catch (IOException ex) {
               Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           dataload();
           
           setSize(210,730);
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           setLocation(1160,0);
           setUndecorated(true);
           setDefaultLookAndFeelDecorated(true);
           
            panel =new JPanel();
           getContentPane().add(panel);
           panel.setBackground(Color.white);
           panel.setLayout(null);
           
           textfield = new JTextField();
           textfield.setBounds(10,10,190,40);
           
           panel.add(textfield);
           
           JButton button=new JButton("FIND");
           button.setBounds(10,60,60,30);
           button.addActionListener((ActionEvent e) -> {
               read();   
           });
           
           panel.add(button);
           
           JButton button2=new JButton("ADD");
           button2.setBounds(130,60,60,30);
           button2.addActionListener((ActionEvent e)->{
               write();
           });
           
           JButton button3 = new JButton("alter");
           button3.setBounds(70,64,60,20);
           button3.addActionListener((ActionEvent e)->
                   {
                       change();
                   }
                   );
           panel.add(button3);
           panel.add(button2);
           label = new JLabel();
           
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.PLAIN, 52));
        label.setBounds(10,90,190,80);
        label.setText("");
        label2 =new JLabel();
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Arial",Font.PLAIN,13));
        label2.setText("");
        label2.setBounds(10,120,190,80);
        panel.add(label);    
        panel.add(label2);
        
        //butt1 for file problems
        butt1 = new JButton();
        butt1.setBounds(10,190,80,80);
        try {
            Image img =ImageIO.read(getClass().getResource("icon1.png"));
            butt1.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
        }
        //butt1.setPressedIcon(pressedIcon);
        butt1.addActionListener((ActionEvent e)->
        {
         if(Desktop.isDesktopSupported())
          {
            try
            {
                Desktop.getDesktop().edit(file3);
            }
             catch (IOException ex) {
                    Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
                }
             } else {
               // dunno, up to you to handle this
         }   
        });
        panel.add(butt1);
        
        //butt2 for file new code
        butt2 = new JButton();
        butt2.setBounds(110,190,80,80);
        try
        {
            Image imgg = ImageIO.read(getClass().getResource("problem.png"));
            butt2.setIcon(new ImageIcon(imgg));
        }
        catch (IOException e)
        {
            Logger.getLogger(tease.class.getName()).log(Level.SEVERE,null,e);
        }
        //
        butt2.addActionListener((ActionEvent e )->
        {
          if(Desktop.isDesktopSupported())
        {
            try
            {
                Desktop.getDesktop().edit(file4);
            }
             catch (IOException ex) {
                    Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
                }
             } else {
               // dunno, up to you to handle this
         }
          
       });
        panel.add(butt2);
        
        label3 =new JLabel("TASKS");
        label3.setBounds(30,250,60,60);
        panel.add(label3);
        
        label4 = new JLabel("PROBLEMS");
        label4.setBounds(120,250,80,60);
        panel.add(label4);
        butt3 = new JButton();
        butt3.setBounds(10,295,180,80);
        panel.add(butt3);
        
        try {
            Image img3 = ImageIO.read(getClass().getResource("coding.png"));
            butt3.setIcon(new ImageIcon(img3));
        } catch (IOException ex) {
            Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
        }
        //butt1.setPressedIcon(pressedIcon);
        butt3.addActionListener((ActionEvent e)->
        {
         if(Desktop.isDesktopSupported())
           {
            try
            {
                Desktop.getDesktop().edit(file5);
            }
             catch (IOException ex) {
                    Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
                }
             } else {
               // dunno, up to you to handle this
         }   
        });
     }
    
    void dataload() 
    {     
        try {
            Scanner scan = null;
            scan = new Scanner(file);            
            String stg = null ;
            int i = 0  ;
            while(scan.hasNextLine())
            {
               stg = scan.nextLine();
               str[i] = stg ;
               i++;
               System.out.println("Diagnose: " + "\n" +str[i]);
            }             
            load = i-1 ;
            instance = Integer.parseInt(str[i-1]); 
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    void time()
    {
       Thread thread =new Thread(){     
        public void run()
         {
            
            for(;;)  
                {  
                  try 
                      {
                    sleep(1000);
                    Date dd =new Date();
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("  HH:mm  ");
                    label.setText(sdf.format(cal.getTime()));
                    String gg=dd.toString();
                    label2.setText(gg);
                }
                  catch(Exception e)
                  {                      
                      
                  }
                    
                }
         }};
        thread.start();
    }
    void read()   
    {
       String st = textfield.getText();
       String prev = null ;
       String next = null ;
       int y = 0  ;
       String jki = null;
       while(y  <=  load)
       {
         if(str[y].equals(st))
         {             
             jki = str[y];
             prev = str[y-1];
             next = str[y+1];
             ggu(prev,next);
             break;
         }
         if(y==load)
         {
             textfield.setText("not found");
         }
         y++;   
       }
      
         System.out.println("addresses ="+prev + "\n" + next);
    }
    
        void ggu(String prev,String next)
        {    
         Scanner scan = null;
           try {
               scan = new Scanner(file2);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
           }   
       
                try {
                    writer = new FileWriter(file1);
                } catch (IOException ex) {
                    Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               
       while(scan.hasNextLine())
           {
              String stg = scan.nextLine();              
         
              if(stg.contains(prev))
                {           
                  while(!stg.contains(next))
                   {
                     String df = scan.nextLine();          
                      try {
                          if(df.contains(next))
                          {
                              break;
                          }
                          writer.write(df);
                          writer.write("\r\n");
                          } catch (IOException ex) {
                          Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
                          }
                         System.out.println(df);  
                      stg = df;
                   }    
               }
              
          } 
           try {
               writer.close();
           } catch (IOException ex) {
               Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
           }
           if (Desktop.isDesktopSupported()) 
            {
                try {
                    Desktop.getDesktop().edit(file1);
                } catch (IOException ex) {
                    Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
                }
             } else {
               // dunno, up to you to handle this
            }
    }

    void write()
    {
         String st = textfield.getText();
         String pd = st;
         int kl = 0;
         while(kl <= load )
         {
             if(str[kl].equals(st))
             {
              textfield.setText("Title present already "); 
              pd = textfield.getText();
             }
             kl++;
         }
         if(pd == null ? st == null : pd.equals(st))
         {
             write2(st);
         }
    }
    void write2( String stf)
    {
         String st2 = null ;
         String st = stf;
         st2 = Integer.toString(instance +1);
         
         try {
           //code for writing in string file
            writer =  new FileWriter(file.getAbsoluteFile(),true);
            bufferw = new BufferedWriter(writer);
            bufferw.newLine();
            bufferw.append(st);
            bufferw.newLine();
            bufferw.append(st2);
            bufferw.close();
            writer.close();
            
            //code for writing data in datafile
            
            writer = new FileWriter(file2.getAbsoluteFile(),true);
            bufferw = new BufferedWriter(writer);
            
            bufferw.newLine();
            bufferw.newLine();
            bufferw.write(st.toUpperCase());
            bufferw.newLine();
            bufferw.newLine();
            bufferw.write("write here but first delete it");
            bufferw.newLine();
            bufferw.write(st2);
            
            bufferw.close();
            writer.close();
            
             if (Desktop.isDesktopSupported()) 
            {
                try {
                    Desktop.getDesktop().edit(file2);
                } catch (IOException ex) {
                    Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
                }
             } else {
               // dunno, up to you to handle this
            }
            dataload();            
        } catch (IOException ex) {
            Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    void change()
    {
            if (Desktop.isDesktopSupported()) 
            {
                try {
                    Desktop.getDesktop().edit(file2);
                } catch (IOException ex) {
                    Logger.getLogger(tease.class.getName()).log(Level.SEVERE, null, ex);
                }
             } else {
               // dunno, up to you to handle this
            }
    }
    
  public static void main (String args[])
   {
    tease tes =new tease();
    tes.setVisible(true);
    
   }
 }