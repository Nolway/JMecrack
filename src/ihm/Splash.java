/*     */ package ihm;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JProgressBar;
/*     */ 
/*     */ public class Splash extends javax.swing.JFrame
/*     */ {
/*     */   private JProgressBar ProgressBar;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   
/*     */   public Splash()
/*     */   {
/*  27 */     initComponents();
/*  28 */     Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
/*  29 */     setLocation((int)(dim.getWidth() - getWidth()) / 2, (int)(dim.getHeight() - getHeight()) / 2);
/*  30 */     setPreferredSize(new Dimension((int)dim.getWidth(), (int)dim.getHeight() - 30));
/*     */   }
/*     */   
/*     */   public JProgressBar getProgressBar()
/*     */   {
/*  35 */     return this.ProgressBar;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  48 */     this.jPanel1 = new javax.swing.JPanel();
/*  49 */     this.jLabel1 = new JLabel();
/*  50 */     this.jLabel3 = new JLabel();
/*  51 */     this.jLabel2 = new JLabel();
/*  52 */     this.jLabel4 = new JLabel();
/*  53 */     this.jLabel6 = new JLabel();
/*  54 */     this.jLabel5 = new JLabel();
/*  55 */     this.jLabel8 = new JLabel();
/*  56 */     this.ProgressBar = new JProgressBar();
/*  57 */     this.jLabel7 = new JLabel();
/*     */     
/*  59 */     setDefaultCloseOperation(3);
/*  60 */     setBackground(new Color(51, 51, 255));
/*  61 */     setForeground(Color.white);
/*  62 */     setResizable(false);
/*  63 */     setUndecorated(true);
/*  64 */     addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mousePressed(java.awt.event.MouseEvent evt) {
/*  66 */         Splash.this.formMousePressed(evt);
/*     */       }
/*  68 */     });
/*  69 */     addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(java.awt.event.KeyEvent evt) {
/*  71 */         Splash.this.formKeyPressed(evt);
/*     */       }
/*     */       
/*  74 */     });
/*  75 */     this.jPanel1.setBackground(new Color(255, 255, 255));
/*  76 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */     
/*  78 */     this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/newLogo128.png")));
/*     */     
/*  80 */     this.jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  81 */     this.jLabel3.setText("Version : 0.5");
/*  82 */     this.jLabel3.setHorizontalTextPosition(0);
/*     */     
/*  84 */     this.jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  85 */     this.jLabel2.setForeground(new Color(0, 0, 51));
/*  86 */     this.jLabel2.setText("Propriété de :  M. MESSOUCI");
/*  87 */     this.jLabel2.setHorizontalTextPosition(0);
/*     */     
/*  89 */     this.jLabel4.setText("Création : 2011");
/*     */     
/*  91 */     this.jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  92 */     this.jLabel6.setText("Mise à jour : 17  Mai 2018  ");
/*     */     
/*  94 */     this.jLabel5.setText("Localisation : Marseille");
/*     */     
/*  96 */     this.jLabel8.setText("Mail : jmerise@jfreesoft.com");
/*     */     
/*  98 */     this.jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  99 */     this.jLabel7.setText("Copyright©2011 JMerise.All rights reserved.");
/*     */     
/* 101 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 102 */     this.jPanel1.setLayout(jPanel1Layout);
/* 103 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addComponent(this.jLabel5).addComponent(this.jLabel4).addComponent(this.jLabel2).addComponent(this.jLabel3, -2, 196, -2)).addGap(108, 108, 108).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.jLabel1, -2, 142, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGap(80, 80, 80).addComponent(this.jLabel7)).addComponent(this.ProgressBar, -1, 474, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3).addGap(18, 18, 18).addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jLabel4).addGap(18, 18, 18).addComponent(this.jLabel5)).addComponent(this.jLabel1, -1, -1, 32767)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8, -2, 14, -2).addComponent(this.jLabel6)).addGap(18, 18, 18).addComponent(this.ProgressBar, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jLabel7).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 150 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 151 */     getContentPane().setLayout(layout);
/* 152 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 167 */     pack();
/*     */   }
/*     */   
/*     */   private void formKeyPressed(java.awt.event.KeyEvent evt) {
/* 171 */     dispose();
/*     */   }
/*     */   
/*     */   private void formMousePressed(java.awt.event.MouseEvent evt) {
/* 175 */     dispose();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 193 */     Splash sp = new Splash();
/* 194 */     sp.setVisible(true);
/* 195 */     sp.getProgressBar().setValue(20);
/*     */     try {
/* 197 */       Thread.sleep(400L);
/*     */     }
/*     */     catch (InterruptedException e) {}
/* 200 */     Principale frm = new Principale(sp);
/*     */     
/* 202 */     sp.getProgressBar().setValue(100);
/*     */     try {
/* 204 */       Thread.sleep(400L);
/*     */     } catch (InterruptedException e) {}
/* 206 */     sp.dispose();
/* 207 */     frm.setVisible(true);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\ihm\Splash.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */