package org.puzzleduck.ui;

import java.util.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.border.*;


public class UiUtils {
  //colors
  private static final Color purple = new Color(0x330033);
  private static final Color bone = new Color(0xFFFFCC);
  private static final Color white = new Color(0xFFFFFF);
  private static final Color yellow = new Color(0xFFFF00);
  private static final Color grey = new Color(0x666666);
  private static final Color lightGrey = new Color(0x999999);
  //font    
  private static final Font kirsty = new Font("kirsty",Font.BOLD,16);
  private static final Font kirstySmall = new Font("kirsty",Font.	PLAIN,14);
  private static final Font kirstyBig = new Font("kirsty",Font.	PLAIN,19);
  //borders
  private static final Border defaultBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, purple, white);
  //images
  private static final ImageIcon puzzleIcon128 = new ImageIcon("res/puzzle128.png","puzzle piece");
  private static final ImageIcon puzzleIcon64 = new ImageIcon("res/puzzle64.png","puzzle piece");
  private static final ImageIcon puzzleIcon32 = new ImageIcon("res/puzzle32.png","puzzle piece");
  private static final ImageIcon puzzleIcon16 = new ImageIcon("res/puzzle16.png","puzzle piece");

  static { //UI color hacks for tabs -- must fire early
    UIManager.put("TabbedPane.selected", yellow);
    UIManager.put("TabbedPane.contentAreaColor",purple);
    UIManager.put("TabbedPane.borderColor", purple);
    UIManager.put("TabbedPane.darkShadow", purple);
    UIManager.put("TabbedPane.focus", purple);
    UIManager.put("TabbedPane.selectHighlight", purple);
    UIManager.put("TabbedPane.tabAreaBackground", purple);
    UIManager.put("TabbedPane.borderHightlightColor", purple);
  }

  public static void main(String args[]) {
    System.out.println("Waddaya want from me?!?"); //demo i suppose
    System.out.println("main is Event Dispatch Thread?" + SwingUtilities.isEventDispatchThread());
    
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        System.out.println("new is Event Dispatch Thread?" + SwingUtilities.isEventDispatchThread());    

        JFrame newWindow = generateMainWindow(); 
        JFrame buttonDemo = generateSubWindow(); 
        JFrame labelDemo = generateSubWindow(newWindow); 
        newWindow.add(decorateLabel(new JLabel("Label")));
        buttonDemo.add(decorateButton(new JButton("Button")));
        buttonDemo.add(decorateButton(new JButton("zip")));
        buttonDemo.add(decorateButton(new JButton("long long button name")));
        buttonDemo.add(decorateButton(new JButton("who\nin their\nright mind\nwould do\nthis")));
        labelDemo.add(new JLabel("Test"));

      }
    } );//invokeLater
  }//main

/*

  protected static void decorateMenu(JMenu inputMenu) {
  protected static void setupMenuItem(JMenuItem inputMenuItem) {
  	protected static void setupPanel(JPanel inputPanel, String title) {
  	protected static JLabel setupLabel(String title) {
  	protected static JButton setupButton(String title) {
  	



*/


  protected static JButton decorateButton(JButton button) {
    System.out.print("(b)");
    button.setBorder(defaultBorder);
    button.setBackground(bone);
    button.setForeground(purple);
    button.setFont(kirsty);
    button.setMaximumSize(new Dimension((int)button.getPreferredSize().getWidth()*2,(int)button.getPreferredSize().getHeight()));
    button.setMaximumSize(new Dimension((int)button.getMaximumSize().getWidth(),(int)button.getPreferredSize().getHeight()));
    button.setIcon(puzzleIcon16);
    return button;
  }
  
  protected static JLabel decorateLabel(JLabel label) {
    //label.setBorder(defaultBorder);
    label.setBackground(bone);
    label.setForeground(purple);
    label.setFont(kirsty);
    label.setIcon(puzzleIcon16);
    return label;
  }


  protected static JMenuBar setupDefaultMenus() {
    JMenuBar menuBar = new JMenuBar();
    
    JMenu fileMenu = new JMenu("File");
    decorateMenu(fileMenu);
      JMenuItem exitMI = new JMenuItem("Quit", KeyEvent.VK_Q);
      decorateMenuItem(exitMI);
      fileMenu.add(exitMI);
      JMenuItem newMI = new JMenuItem("New Tab", KeyEvent.VK_N);
      decorateMenuItem(newMI);
      fileMenu.add(newMI);
    JMenu editMenu = new JMenu("Edit");
    decorateMenu(editMenu);
      JMenuItem saveMI = new JMenuItem("Save data", KeyEvent.VK_S);
      decorateMenuItem(saveMI);
      editMenu.add(saveMI);
      JMenuItem logMI = new JMenuItem("Log Data", KeyEvent.VK_L);
      decorateMenuItem(logMI);
      editMenu.add(logMI);
    JMenu helpMenu = new JMenu("Help");
    decorateMenu(helpMenu);

    menuBar.add(fileMenu);
    menuBar.add(editMenu);
    menuBar.add(helpMenu);

    menuBar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, purple, white));
    menuBar.setBackground(bone);
    menuBar.setMaximumSize(new Dimension(3200, (int)menuBar.getPreferredSize().getHeight()));
    menuBar.setToolTipText("It's a menu... men it you!"); 
  
    return menuBar;
  }

  protected static JFrame generateMainWindow() {
    System.out.println("generateMainWindow is Event Dispatch Thread?" + SwingUtilities.isEventDispatchThread());
    JFrame frame = new JFrame("::PuZZleDucK::"); //Default title
    Container pane = frame.getContentPane();
    pane.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
    frame.setForeground(purple);
    frame.setBackground(bone);
    ((JComponent)pane).setBorder(defaultBorder);
    frame.setIconImage(puzzleIcon128.getImage());
    frame.add(setupDefaultMenus());
    //pane.add(new JLabel("Main Window"));
    
    frame.setMinimumSize(new Dimension(300,100));
    frame.setPreferredSize(new Dimension(500,300));
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    return frame;
  }
  
  protected static JFrame generateSubWindow() {
    JFrame frame = new JFrame("::SubWindow::"); //Default title... n/a for undecorated
    frame.setUndecorated(true); //sub window
    Container pane = frame.getContentPane();
    pane.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
    frame.setForeground(purple);
    frame.setBackground(bone);
    ((JComponent)pane).setBorder(defaultBorder);
    frame.setIconImage(puzzleIcon128.getImage());
    
    frame. setPreferredSize(new Dimension(250,500));
    frame.pack();
    frame.setVisible(true);
    return frame;
  }
  
  protected static JFrame generateSubWindow(JFrame parent) {
    JFrame frame = new JFrame("::Child SubWindow::"); //Default title
    frame.setUndecorated(true); //sub window
    Container pane = frame.getContentPane();
    frame.setForeground(purple);
    frame.setBackground(bone);
    ((JComponent)pane).setBorder(defaultBorder);
    frame.setIconImage(puzzleIcon128.getImage());
    
    //place under parent component ... woot, works on the EDT
    frame.setLocation((int)parent.getLocation().getY(),(int)parent.getLocation().getX()+parent.getHeight());

    frame. setPreferredSize(new Dimension(parent.getWidth(),parent.getHeight()));
    frame.pack();
    frame.setVisible(true);
    return frame;
  }



  protected static void decorateMenu(JMenu inputMenu) {
    inputMenu.setFont(kirstySmall);
    inputMenu.setForeground(purple);
    inputMenu.setBackground(bone);
    inputMenu.setIcon(puzzleIcon16);
  }

  protected static void decorateMenuItem(JMenuItem inputMenuItem) {
    inputMenuItem.setFont(kirstySmall);
    inputMenuItem.setForeground(purple);
    inputMenuItem.setBackground(bone);
    inputMenuItem.setIcon(puzzleIcon16);
  }








}//class


















