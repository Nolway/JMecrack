/*     */ package formes2;
/*     */ 
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormeLegendeMCD extends javax.swing.JDialog {
/*     */   ihm.Principale frm;
/*     */   private javax.swing.JButton jBtValider;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel12;
/*     */   private JLabel jLabel13;
/*     */   private JLabel jLabel14;
/*     */   private JLabel jLabel15;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   
/*     */   public FormeLegendeMCD(ihm.Principale parent, boolean modal) {
/*  26 */     super(parent, modal);
/*  27 */     initComponents();
/*  28 */     this.frm = parent;
/*  29 */     setLocation(this.frm.getX() + (this.frm.getWidth() - getWidth()) / 2, this.frm.getY() + 100);
/*  30 */     this.jBtValider.setMnemonic(10);
/*  31 */     setBackground(java.awt.Color.WHITE);
/*     */   }
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
/*  43 */     this.jPanel1 = new javax.swing.JPanel();
/*  44 */     this.jLabel1 = new JLabel();
/*  45 */     this.jLabel2 = new JLabel();
/*  46 */     this.jLabel3 = new JLabel();
/*  47 */     this.jLabel4 = new JLabel();
/*  48 */     this.jLabel5 = new JLabel();
/*  49 */     this.jLabel6 = new JLabel();
/*  50 */     this.jLabel7 = new JLabel();
/*  51 */     this.jLabel8 = new JLabel();
/*  52 */     this.jLabel9 = new JLabel();
/*  53 */     this.jLabel10 = new JLabel();
/*  54 */     this.jLabel11 = new JLabel();
/*  55 */     this.jLabel12 = new JLabel();
/*  56 */     this.jLabel13 = new JLabel();
/*  57 */     this.jLabel14 = new JLabel();
/*  58 */     this.jLabel15 = new JLabel();
/*  59 */     this.jBtValider = new javax.swing.JButton();
/*     */     
/*  61 */     setDefaultCloseOperation(2);
/*  62 */     setTitle("Légende");
/*  63 */     setResizable(false);
/*     */     
/*  65 */     this.jPanel1.setBackground(new java.awt.Color(255, 255, 255));
/*     */     
/*  67 */     this.jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12));
/*  68 */     this.jLabel1.setText("Légende dans le MCD et le MLD");
/*     */     
/*  70 */     this.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clefNoire.png")));
/*  71 */     this.jLabel2.setText("Attribut identifiant (clé primaire)");
/*     */     
/*  73 */     this.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clefNoireAlterne.png")));
/*  74 */     this.jLabel3.setText("Attribut identifiant Alternatif (unique) ");
/*     */     
/*  76 */     this.jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clefNoireIndex.png")));
/*  77 */     this.jLabel4.setText("Attribut index ");
/*     */     
/*  79 */     this.jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
/*  80 */     this.jLabel5.setForeground(new java.awt.Color(153, 0, 0));
/*  81 */     this.jLabel5.setText("Id");
/*     */     
/*  83 */     this.jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
/*  84 */     this.jLabel6.setForeground(new java.awt.Color(153, 0, 0));
/*  85 */     this.jLabel6.setText("IdA");
/*     */     
/*  87 */     this.jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
/*  88 */     this.jLabel7.setForeground(new java.awt.Color(153, 0, 0));
/*  89 */     this.jLabel7.setText("Idx");
/*     */     
/*  91 */     this.jLabel8.setText("Lien relatif ");
/*     */     
/*  93 */     this.jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
/*  94 */     this.jLabel9.setForeground(new java.awt.Color(153, 0, 0));
/*  95 */     this.jLabel9.setText("<1,1>");
/*     */     
/*  97 */     this.jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clefForeing.png")));
/*  98 */     this.jLabel10.setText("Clé Primaire et Etrangère");
/*     */     
/* 100 */     this.jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 101 */     this.jLabel11.setForeground(new java.awt.Color(153, 0, 0));
/* 102 */     this.jLabel11.setText("PFK");
/*     */     
/* 104 */     this.jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clefPrimaryForeing.png")));
/* 105 */     this.jLabel12.setText("Clé Etrangère");
/*     */     
/* 107 */     this.jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 108 */     this.jLabel13.setForeground(new java.awt.Color(153, 0, 0));
/* 109 */     this.jLabel13.setText("FK");
/*     */     
/* 111 */     this.jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 112 */     this.jLabel14.setForeground(new java.awt.Color(153, 0, 0));
/* 113 */     this.jLabel14.setText("( PK )");
/*     */     
/* 115 */     this.jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 116 */     this.jLabel15.setForeground(new java.awt.Color(153, 0, 0));
/* 117 */     this.jLabel15.setText("( Unq )");
/*     */     
/* 119 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/* 120 */     this.jPanel1.setLayout(jPanel1Layout);
/* 121 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel14)).addComponent(this.jLabel1).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3).addGap(18, 18, 18).addComponent(this.jLabel6).addGap(10, 10, 10).addComponent(this.jLabel15, -2, 53, -2)).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel8).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel9)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel4).addGap(18, 18, 18).addComponent(this.jLabel7))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel10).addGap(18, 18, 18).addComponent(this.jLabel11)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel12).addGap(18, 18, 18).addComponent(this.jLabel13))).addContainerGap(20, 32767)));
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
/* 158 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addGap(31, 31, 31).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel5).addComponent(this.jLabel14)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel6).addComponent(this.jLabel15)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jLabel7)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.jLabel9)).addGap(26, 26, 26).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.jLabel11)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.jLabel13)).addContainerGap(23, 32767)));
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
/* 192 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 193 */     this.jBtValider.setText("OK");
/* 194 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 196 */         FormeLegendeMCD.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 199 */     });
/* 200 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 201 */     getContentPane().setLayout(layout);
/* 202 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jBtValider, -2, 83, -2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 211 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jBtValider).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 221 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(java.awt.event.ActionEvent evt) {
/* 225 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeLegendeMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */