/*     */ package zDonnation;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ public class FormeNewDonnation extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   private String adresse;
/*     */   private JButton jBt10;
/*     */   private JButton jBt15;
/*     */   private JButton jBt20;
/*     */   private JButton jBt3;
/*     */   private JButton jBt30;
/*     */   private JButton jBt5;
/*     */   private JButton jBt50;
/*     */   private JButton jBt80;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   private javax.swing.JScrollPane jScrollPane3;
/*     */   private JTextArea jTextArea1;
/*     */   private JTextArea jTextArea2;
/*     */   private JTextArea jTextArea3;
/*     */   
/*     */   public FormeNewDonnation(ihm.Principale parent, boolean modal)
/*     */   {
/*  32 */     super(parent, modal);
/*  33 */     initComponents();
/*  34 */     this.frm = parent;
/*  35 */     this.adresse = "";
/*  36 */     setLocation(this.frm.getX() + 200, this.frm.getY() + 90);
/*     */   }
/*     */   
/*     */ 
/*     */   private void accederAPaypal(String adr)
/*     */   {
/*  42 */     if (java.awt.Desktop.isDesktopSupported())
/*     */     {
/*  44 */       java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
/*     */       
/*     */ 
/*  47 */       if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
/*     */         try
/*     */         {
/*     */           try {
/*  51 */             desktop.browse(new java.net.URI(adr));
/*     */           }
/*     */           catch (java.net.URISyntaxException ex) {
/*  54 */             java.util.logging.Logger.getLogger(FormeNewDonnation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */           }
/*     */         } catch (java.io.IOException ex) {
/*  57 */           java.util.logging.Logger.getLogger(ihm.Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */         }
/*     */       }
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
/*  73 */     this.jPanel1 = new javax.swing.JPanel();
/*  74 */     this.jPanel2 = new javax.swing.JPanel();
/*  75 */     this.jBt3 = new JButton();
/*  76 */     this.jBt5 = new JButton();
/*  77 */     this.jBt10 = new JButton();
/*  78 */     this.jBt15 = new JButton();
/*  79 */     this.jBt20 = new JButton();
/*  80 */     this.jBt30 = new JButton();
/*  81 */     this.jBt50 = new JButton();
/*  82 */     this.jBt80 = new JButton();
/*  83 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  84 */     this.jTextArea1 = new JTextArea();
/*  85 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/*  86 */     this.jTextArea2 = new JTextArea();
/*  87 */     this.jScrollPane3 = new javax.swing.JScrollPane();
/*  88 */     this.jTextArea3 = new JTextArea();
/*     */     
/*  90 */     setDefaultCloseOperation(2);
/*  91 */     setTitle("Merci pour votre générosité");
/*  92 */     setResizable(false);
/*     */     
/*  94 */     this.jPanel1.setBackground(new java.awt.Color(255, 255, 250));
/*  95 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  97 */     this.jPanel2.setBackground(new java.awt.Color(255, 255, 250));
/*     */     
/*  99 */     this.jBt3.setBackground(new java.awt.Color(255, 255, 255));
/* 100 */     this.jBt3.setFont(new java.awt.Font("Tahoma", 1, 16));
/* 101 */     this.jBt3.setForeground(new java.awt.Color(102, 102, 102));
/* 102 */     this.jBt3.setText("3");
/* 103 */     this.jBt3.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 105 */         FormeNewDonnation.this.jBt3ActionPerformed(evt);
/*     */       }
/*     */       
/* 108 */     });
/* 109 */     this.jBt5.setBackground(new java.awt.Color(255, 255, 255));
/* 110 */     this.jBt5.setFont(new java.awt.Font("Tahoma", 1, 16));
/* 111 */     this.jBt5.setForeground(new java.awt.Color(102, 102, 102));
/* 112 */     this.jBt5.setText("5");
/* 113 */     this.jBt5.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 115 */         FormeNewDonnation.this.jBt5ActionPerformed(evt);
/*     */       }
/*     */       
/* 118 */     });
/* 119 */     this.jBt10.setBackground(new java.awt.Color(255, 255, 255));
/* 120 */     this.jBt10.setFont(new java.awt.Font("Tahoma", 1, 16));
/* 121 */     this.jBt10.setForeground(new java.awt.Color(51, 51, 51));
/* 122 */     this.jBt10.setText("10");
/* 123 */     this.jBt10.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 125 */         FormeNewDonnation.this.jBt10ActionPerformed(evt);
/*     */       }
/*     */       
/* 128 */     });
/* 129 */     this.jBt15.setBackground(new java.awt.Color(255, 255, 255));
/* 130 */     this.jBt15.setFont(new java.awt.Font("Tahoma", 1, 16));
/* 131 */     this.jBt15.setForeground(new java.awt.Color(51, 51, 51));
/* 132 */     this.jBt15.setText("15");
/* 133 */     this.jBt15.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 135 */         FormeNewDonnation.this.jBt15ActionPerformed(evt);
/*     */       }
/*     */       
/* 138 */     });
/* 139 */     this.jBt20.setBackground(new java.awt.Color(255, 255, 255));
/* 140 */     this.jBt20.setFont(new java.awt.Font("Tahoma", 1, 16));
/* 141 */     this.jBt20.setForeground(new java.awt.Color(51, 0, 102));
/* 142 */     this.jBt20.setText("20");
/* 143 */     this.jBt20.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 145 */         FormeNewDonnation.this.jBt20ActionPerformed(evt);
/*     */       }
/*     */       
/* 148 */     });
/* 149 */     this.jBt30.setBackground(new java.awt.Color(255, 255, 255));
/* 150 */     this.jBt30.setFont(new java.awt.Font("Tahoma", 1, 16));
/* 151 */     this.jBt30.setForeground(new java.awt.Color(51, 0, 102));
/* 152 */     this.jBt30.setText("30");
/* 153 */     this.jBt30.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 155 */         FormeNewDonnation.this.jBt30ActionPerformed(evt);
/*     */       }
/*     */       
/* 158 */     });
/* 159 */     this.jBt50.setBackground(new java.awt.Color(255, 255, 255));
/* 160 */     this.jBt50.setFont(new java.awt.Font("Tahoma", 1, 16));
/* 161 */     this.jBt50.setForeground(new java.awt.Color(102, 0, 0));
/* 162 */     this.jBt50.setText("50");
/* 163 */     this.jBt50.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 165 */         FormeNewDonnation.this.jBt50ActionPerformed(evt);
/*     */       }
/*     */       
/* 168 */     });
/* 169 */     this.jBt80.setBackground(new java.awt.Color(255, 255, 255));
/* 170 */     this.jBt80.setFont(new java.awt.Font("Tahoma", 1, 16));
/* 171 */     this.jBt80.setForeground(new java.awt.Color(255, 51, 0));
/* 172 */     this.jBt80.setText("80");
/* 173 */     this.jBt80.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 175 */         FormeNewDonnation.this.jBt80ActionPerformed(evt);
/*     */       }
/*     */       
/* 178 */     });
/* 179 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 180 */     this.jPanel2.setLayout(jPanel2Layout);
/* 181 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jBt3).addGap(18, 18, 18).addComponent(this.jBt5).addGap(18, 18, 18).addComponent(this.jBt10).addGap(18, 18, 18).addComponent(this.jBt15).addGap(18, 18, 18).addComponent(this.jBt20).addGap(18, 18, 18).addComponent(this.jBt30).addGap(18, 18, 18).addComponent(this.jBt50).addGap(30, 30, 30).addComponent(this.jBt80).addContainerGap(-1, 32767)));
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
/* 202 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBt80, -2, 107, -2).addComponent(this.jBt3).addComponent(this.jBt5).addComponent(this.jBt10, -2, 45, -2).addComponent(this.jBt15, -2, 55, -2).addComponent(this.jBt20, -2, 65, -2).addComponent(this.jBt30, -2, 73, -2).addComponent(this.jBt50, -2, 89, -2)).addContainerGap(-1, 32767)));
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
/* 218 */     this.jTextArea1.setColumns(20);
/* 219 */     this.jTextArea1.setEditable(false);
/* 220 */     this.jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 15));
/* 221 */     this.jTextArea1.setRows(5);
/* 222 */     this.jTextArea1.setText("\n  Si VOUS AUSSI, VOUS voulez aider JMerise à s'améliorer d'avantage et \navoir le privilège de recevoir JMerise dès sa sortie. Merci de faire un don \nen cliquant sur l'un des boutons ci-dessous. \n\nChaque bouton correspondant à une somme à offrir.    \n                                                            Merci d'avance \n                                                                JMerise");
/* 223 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*     */     
/* 225 */     this.jTextArea2.setColumns(20);
/* 226 */     this.jTextArea2.setEditable(false);
/* 227 */     this.jTextArea2.setFont(new java.awt.Font("Monospaced", 1, 18));
/* 228 */     this.jTextArea2.setForeground(new java.awt.Color(255, 0, 0));
/* 229 */     this.jTextArea2.setRows(1);
/* 230 */     this.jTextArea2.setText("      JMerise 0.5 sera exclusivement pour les donateurs");
/* 231 */     this.jScrollPane2.setViewportView(this.jTextArea2);
/*     */     
/* 233 */     this.jTextArea3.setBackground(new java.awt.Color(255, 255, 204));
/* 234 */     this.jTextArea3.setColumns(20);
/* 235 */     this.jTextArea3.setEditable(false);
/* 236 */     this.jTextArea3.setFont(new java.awt.Font("Monospaced", 3, 14));
/* 237 */     this.jTextArea3.setRows(1);
/* 238 */     this.jTextArea3.setText("            JMerise version 0.5 sera disponible avant le mois de Mai 2018");
/* 239 */     this.jScrollPane3.setViewportView(this.jTextArea3);
/*     */     
/* 241 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 242 */     this.jPanel1.setLayout(jPanel1Layout);
/* 243 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 727, 32767)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -1, 727, 32767)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 727, 32767)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGap(85, 85, 85).addComponent(this.jPanel2, -2, -1, -2))).addContainerGap()));
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
/* 261 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -2, 42, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane3, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 188, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()));
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
/* 275 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 276 */     getContentPane().setLayout(layout);
/* 277 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 284 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 292 */     pack();
/*     */   }
/*     */   
/*     */   private void jBt3ActionPerformed(ActionEvent evt) {
/* 296 */     this.adresse = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=7TUEWZZ47S2HG";
/* 297 */     accederAPaypal(this.adresse);
/* 298 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBt5ActionPerformed(ActionEvent evt) {
/* 302 */     this.adresse = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=XLPRTBEHWHVPY";
/* 303 */     accederAPaypal(this.adresse);
/* 304 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBt10ActionPerformed(ActionEvent evt) {
/* 308 */     this.adresse = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=524W2LKCT97FN";
/* 309 */     accederAPaypal(this.adresse);
/* 310 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBt15ActionPerformed(ActionEvent evt) {
/* 314 */     this.adresse = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=HHSMR3ZUC5WZU";
/* 315 */     accederAPaypal(this.adresse);
/* 316 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBt20ActionPerformed(ActionEvent evt) {
/* 320 */     this.adresse = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=PSZCTY5HJ3J7L";
/* 321 */     accederAPaypal(this.adresse);
/* 322 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBt30ActionPerformed(ActionEvent evt) {
/* 326 */     this.adresse = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=CZ6GKX7FXSC9S";
/* 327 */     accederAPaypal(this.adresse);
/* 328 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBt50ActionPerformed(ActionEvent evt) {
/* 332 */     this.adresse = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=58JY6JHT5YRCL";
/* 333 */     accederAPaypal(this.adresse);
/* 334 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBt80ActionPerformed(ActionEvent evt) {
/* 338 */     this.adresse = "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=VTMHFQAVUBLZJ";
/* 339 */     accederAPaypal(this.adresse);
/* 340 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\zDonnation\FormeNewDonnation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */