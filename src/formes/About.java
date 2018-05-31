/*     */ package formes;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class About extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   private JLabel jLabActiver;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel12;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   
/*     */   public About(ihm.Principale parent, boolean modal)
/*     */   {
/*  26 */     super(parent, modal);
/*  27 */     this.frm = parent;
/*  28 */     initComponents();
/*  29 */     setLocation(parent.getX() + 250, parent.getY() + 100);
/*     */     
/*  31 */     if (Outil.Setting.licence.isLicence()) {
/*  32 */       this.jLabActiver.setText("Activée");
/*     */     } else {
/*  34 */       this.jLabActiver.setText("Non activée");
/*     */     }
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
/*  48 */     this.jLabel1 = new JLabel();
/*  49 */     this.jLabel2 = new JLabel();
/*  50 */     this.jLabel3 = new JLabel();
/*  51 */     this.jLabel4 = new JLabel();
/*  52 */     this.jLabel5 = new JLabel();
/*  53 */     this.jLabel6 = new JLabel();
/*  54 */     this.jLabel7 = new JLabel();
/*  55 */     this.jLabel8 = new JLabel();
/*  56 */     this.jLabel9 = new JLabel();
/*  57 */     this.jLabel10 = new JLabel();
/*  58 */     this.jLabel11 = new JLabel();
/*  59 */     this.jLabel12 = new JLabel();
/*  60 */     this.jLabActiver = new JLabel();
/*     */     
/*  62 */     setDefaultCloseOperation(2);
/*  63 */     setTitle("A propos");
/*  64 */     setResizable(false);
/*     */     
/*  66 */     this.jLabel1.setHorizontalAlignment(0);
/*  67 */     this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/newLogo128.png")));
/*     */     
/*  69 */     this.jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
/*  70 */     this.jLabel2.setHorizontalAlignment(4);
/*  71 */     this.jLabel2.setText("Ce logiciel est la propriété de");
/*     */     
/*  73 */     this.jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
/*  74 */     this.jLabel3.setText("Version");
/*     */     
/*  76 */     this.jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
/*  77 */     this.jLabel4.setText("Année de développement");
/*     */     
/*  79 */     this.jLabel5.setText("Mise à jour");
/*     */     
/*  81 */     this.jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12));
/*  82 */     this.jLabel6.setText("email: jmerise@jfreesoft.com");
/*     */     
/*  84 */     this.jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12));
/*  85 */     this.jLabel7.setText("Localisation : Marseille.");
/*     */     
/*  87 */     this.jLabel8.setHorizontalAlignment(0);
/*  88 */     this.jLabel8.setText("Copyright©2011 JMerise.All rights reserved.");
/*     */     
/*  90 */     this.jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
/*  91 */     this.jLabel9.setForeground(new java.awt.Color(153, 0, 0));
/*  92 */     this.jLabel9.setText("0.5 ");
/*     */     
/*  94 */     this.jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
/*  95 */     this.jLabel10.setForeground(new java.awt.Color(0, 0, 102));
/*  96 */     this.jLabel10.setText("2011");
/*     */     
/*  98 */     this.jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  99 */     this.jLabel11.setText("17 Mai 2018");
/*     */     
/* 101 */     this.jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 102 */     this.jLabel12.setForeground(new java.awt.Color(255, 0, 0));
/* 103 */     this.jLabel12.setText(" M.MESSOUCI");
/*     */     
/* 105 */     this.jLabActiver.setForeground(new java.awt.Color(255, 0, 0));
/* 106 */     this.jLabActiver.setHorizontalAlignment(0);
/* 107 */     this.jLabActiver.setText("non Activée");
/*     */     
/* 109 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 110 */     getContentPane().setLayout(layout);
/* 111 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabel8, -1, 539, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addComponent(this.jLabel3)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel9).addComponent(this.jLabel11)).addGap(19, 19, 19)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(35, 35, 35).addComponent(this.jLabActiver, -1, -1, 32767)).addComponent(this.jLabel4, javax.swing.GroupLayout.Alignment.LEADING)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, 32767).addComponent(this.jLabel10, -2, 41, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1, -2, 136, -2).addGap(24, 24, 24)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel2, -2, 176, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel12))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, 32767)).addComponent(this.jLabel6, -1, 165, 32767)))).addContainerGap()));
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
/* 153 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel12)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(37, 37, 37).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jLabel11)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel9)).addGap(18, 18, 18).addComponent(this.jLabActiver).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jLabel10))).addComponent(this.jLabel1).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.jLabel7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, 32767).addComponent(this.jLabel6).addGap(35, 35, 35))).addGap(18, 18, 18).addComponent(this.jLabel8).addContainerGap()));
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
/* 189 */     pack();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\About.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */