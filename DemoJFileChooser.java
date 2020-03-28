import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.applet.Applet;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;


public class DemoJFileChooser extends JFrame
   implements ActionListener {
   JButton go;
   private JPanel contentPane;
   public JPanel panel,panel_1,panel_2,panel_3;
   JFileChooser chooser;
   String choosertitle;
   StringBuffer ank = new StringBuffer();
   File SelectedDirectory;
   private Font font = new Font("monospaced",Font.BOLD,25);
   
   
  public DemoJFileChooser() {
  
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 1000);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(6, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        panel = new JPanel();
        panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        contentPane.add(panel, BorderLayout.CENTER);
        
        
    go = new JButton("Select");
    go.setFont(new Font("Arial", Font.PLAIN, 45));
    go.addActionListener(this);
    //contentPane.add(go);
    
    
    
    // Figure out where in the filesystem to start displaying
    File root;
    root = new File("/home/ankitz/Desktop");

    // Create a TreeModel object to represent our tree of files
    FileTreeModel model = new FileTreeModel(root);

    // Create a JTree and tell it to display our model
    JTree tree = new JTree();
    tree.setModel(model);

    // The JTree can get big, so allow it to scroll.
    JScrollPane scrollpane = new JScrollPane(tree);
    
    
    
    
    //Yahan se Mera Experiment
   //
   ////////
   
   JLabel lblSelectTargetPicture = new JLabel("Select target Directory :");
   lblSelectTargetPicture.setFont(new Font("Arial", Font.PLAIN, 45));
   
   JLabel label1 = new JLabel("Selected Directory :");
   label1.setFont(new Font("Arial", Font.PLAIN, 40));
   
   
   /*
   JButton btnBrowse = new JButton("Browse");
        //btnBrowse.setFont(new Font("Arial", Font.PLAIN, 40));
        btnBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        */
	JButton btnDetect = new JButton("Detect");
        btnDetect.setFont(new Font("Arial", Font.PLAIN, 45));
        btnDetect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
   JButton btnAddDigit = new JButton("Results");
        btnAddDigit.setFont(new Font("Arial", Font.PLAIN, 45));
        btnAddDigit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        JButton button = new JButton("Exit");
        button.setFont(new Font("Arial", Font.PLAIN, 45));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });
        panel_1 = new JPanel(); //The Smaller Panel
        panel_1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        GroupLayout gl_panel = new GroupLayout(panel);
        
        // HORIZONTAL LAYOUT
        
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(100)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addComponent(lblSelectTargetPicture)
                            .addGap(30)
                            .addComponent(go))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(180) //for the detect button
                            .addComponent(btnDetect)
                            .addGap(80)
                            .addComponent(btnAddDigit)
                            )))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(430) //for Exit button
                    .addComponent(button))
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addContainerGap()                  
                    .addComponent(label1)
                    .addGap(10)
                    .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                    
                    .addGroup(gl_panel.createSequentialGroup()
                    .addGap(20) //for Scrollpane
                    .addComponent(scrollpane))
                    
        ); // Width ke liye
        
        // VERTICAL LAYOUT
        
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(10)
                            .addComponent(lblSelectTargetPicture))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(10)
                            .addComponent(go)))
                    .addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
                    .addGap(20)
                    .addComponent(label1)                    
                    .addGroup(gl_panel.createSequentialGroup()
                    .addGap(10)
                    .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.DEFAULT_SIZE))) //Height ke liye
                    .addGap(40)
                    .addGroup(gl_panel.createParallelGroup(Alignment.CENTER)
                    .addGap(20)
                    .addComponent(scrollpane)) //For Scrollpane
                    
                    .addGap(200) //Smaller Panel ke neeche ka gap
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnDetect)
                        .addComponent(btnAddDigit)
                        )
                    .addGap(18)
                    .addComponent(button)
                    .addContainerGap())
        );
        panel.setLayout(gl_panel);
   //Mere exp ki ending
   //
   ///////
   }

  public void actionPerformed(ActionEvent e) {
    int result;
       
    chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle(choosertitle);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    //    
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
      System.out.println("getCurrentDirectory(): " 
         +  chooser.getCurrentDirectory());
      System.out.println("getSelectedFile() : " 
         +  chooser.getSelectedFile());
         SelectedDirectory = chooser.getSelectedFile();
         ank.append(SelectedDirectory.getPath());
         System.out.println(ank.toString());
         panel_1.setLayout(new BorderLayout(0, 0));
         JLabel newlabel = new JLabel();
     
     panel_1.removeAll();
     newlabel.setText(ank.toString());
     newlabel.setFont(new Font("Arial", Font.BOLD, 30));
      panel_1.add(newlabel);
      setVisible(true);  
      ank.delete(0, ank.length());
      }
    else {
      System.out.println("No Selection ");
      }
     }
     
     
   
  public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DemoJFileChooser frame = new DemoJFileChooser();
                    frame.setVisible(true);
                    frame.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    }