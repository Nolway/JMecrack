/*     */ package LibraryPan;
/*     */ 
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JRadioButton;
/*     */ 
/*     */ public class FormeCouleurLibrairie extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   private javax.swing.ButtonGroup buttonGroup1;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtValider;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private javax.swing.JPanel jPanel5;
/*     */   private JRadioButton jRBBleu;
/*     */   private JRadioButton jRBGris;
/*     */   private JRadioButton jRBRouge;
/*     */   private JRadioButton jRBVert;
/*     */   
/*     */   public FormeCouleurLibrairie(ihm.Principale parent, boolean modal)
/*     */   {
/*  26 */     super(parent, modal);
/*  27 */     initComponents();
/*  28 */     this.frm = parent;
/*  29 */     setLocation(this.frm.getX() + this.frm.getWidth() - 250 - getWidth(), this.frm.getY() + 120);
/*  30 */     initData();
/*     */   }
/*     */   
/*     */   private void initData() {
/*  34 */     java.awt.Color cl = this.frm.getPanLibibrary().getCouleurSel();
/*  35 */     this.jRBRouge.setSelected(true);
/*  36 */     if (cl.getRGB() == this.jRBBleu.getBackground().getRGB()) {
/*  37 */       this.jRBBleu.setSelected(true);
/*     */     }
/*  39 */     if (cl.getRGB() == this.jRBGris.getBackground().getRGB()) {
/*  40 */       this.jRBGris.setSelected(true);
/*     */     }
/*  42 */     if (cl.getRGB() == this.jRBVert.getBackground().getRGB()) {
/*  43 */       this.jRBVert.setSelected(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private void sauvegardeCouleur() {
/*  48 */     if (this.jRBBleu.isSelected()) {
/*  49 */       this.frm.getPanLibibrary().setCouleurSel(this.jRBBleu.getBackground());
/*     */     }
/*  51 */     if (this.jRBGris.isSelected()) {
/*  52 */       this.frm.getPanLibibrary().setCouleurSel(this.jRBGris.getBackground());
/*     */     }
/*  54 */     if (this.jRBRouge.isSelected()) {
/*  55 */       this.frm.getPanLibibrary().setCouleurSel(this.jRBRouge.getBackground());
/*     */     }
/*  57 */     if (this.jRBVert.isSelected()) {
/*  58 */       this.frm.getPanLibibrary().setCouleurSel(this.jRBVert.getBackground());
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
/*  72 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/*  73 */     this.jPanel5 = new javax.swing.JPanel();
/*  74 */     this.jLabel3 = new JLabel();
/*  75 */     this.jRBVert = new JRadioButton();
/*  76 */     this.jRBRouge = new JRadioButton();
/*  77 */     this.jRBBleu = new JRadioButton();
/*  78 */     this.jRBGris = new JRadioButton();
/*  79 */     this.jLabel1 = new JLabel();
/*  80 */     this.jLabel2 = new JLabel();
/*  81 */     this.jLabel4 = new JLabel();
/*  82 */     this.jLabel5 = new JLabel();
/*  83 */     this.jBtAnnuler = new javax.swing.JButton();
/*  84 */     this.jBtValider = new javax.swing.JButton();
/*     */     
/*  86 */     setDefaultCloseOperation(2);
/*  87 */     setTitle("Couleur de la Librairie");
/*  88 */     setResizable(false);
/*     */     
/*  90 */     this.jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  92 */     this.jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
/*  93 */     this.jLabel3.setText("Couleur de la séléction d'une entitée ou d'une relation ");
/*     */     
/*  95 */     this.jRBVert.setBackground(new java.awt.Color(0, 150, 0));
/*  96 */     this.buttonGroup1.add(this.jRBVert);
/*     */     
/*  98 */     this.jRBRouge.setBackground(new java.awt.Color(255, 0, 0));
/*  99 */     this.buttonGroup1.add(this.jRBRouge);
/* 100 */     this.jRBRouge.setSelected(true);
/*     */     
/* 102 */     this.jRBBleu.setBackground(new java.awt.Color(0, 0, 50));
/* 103 */     this.buttonGroup1.add(this.jRBBleu);
/*     */     
/* 105 */     this.jRBGris.setBackground(new java.awt.Color(100, 100, 100));
/* 106 */     this.buttonGroup1.add(this.jRBGris);
/*     */     
/* 108 */     this.jLabel1.setBackground(new java.awt.Color(255, 0, 0));
/* 109 */     this.jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 110 */     this.jLabel1.setForeground(new java.awt.Color(255, 255, 255));
/* 111 */     this.jLabel1.setHorizontalAlignment(0);
/* 112 */     this.jLabel1.setText("RE");
/* 113 */     this.jLabel1.setOpaque(true);
/* 114 */     this.jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 116 */         FormeCouleurLibrairie.this.jLabel1MouseClicked(evt);
/*     */       }
/*     */       
/* 119 */     });
/* 120 */     this.jLabel2.setBackground(new java.awt.Color(0, 150, 0));
/* 121 */     this.jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 122 */     this.jLabel2.setForeground(new java.awt.Color(255, 255, 255));
/* 123 */     this.jLabel2.setHorizontalAlignment(0);
/* 124 */     this.jLabel2.setText("GR");
/* 125 */     this.jLabel2.setOpaque(true);
/* 126 */     this.jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 128 */         FormeCouleurLibrairie.this.jLabel2MouseClicked(evt);
/*     */       }
/*     */       
/* 131 */     });
/* 132 */     this.jLabel4.setBackground(new java.awt.Color(0, 0, 50));
/* 133 */     this.jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 134 */     this.jLabel4.setForeground(new java.awt.Color(255, 255, 255));
/* 135 */     this.jLabel4.setHorizontalAlignment(0);
/* 136 */     this.jLabel4.setText("BL");
/* 137 */     this.jLabel4.setOpaque(true);
/* 138 */     this.jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 140 */         FormeCouleurLibrairie.this.jLabel4MouseClicked(evt);
/*     */       }
/*     */       
/* 143 */     });
/* 144 */     this.jLabel5.setBackground(new java.awt.Color(100, 100, 100));
/* 145 */     this.jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 146 */     this.jLabel5.setForeground(new java.awt.Color(255, 255, 255));
/* 147 */     this.jLabel5.setHorizontalAlignment(0);
/* 148 */     this.jLabel5.setText("GR");
/* 149 */     this.jLabel5.setOpaque(true);
/* 150 */     this.jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 152 */         FormeCouleurLibrairie.this.jLabel5MouseClicked(evt);
/*     */       }
/*     */       
/* 155 */     });
/* 156 */     javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(this.jPanel5);
/* 157 */     this.jPanel5.setLayout(jPanel5Layout);
/* 158 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3)).addGroup(jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jRBVert).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2, -2, 35, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jRBRouge).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel1, -2, 35, -2).addGap(56, 56, 56).addComponent(this.jRBBleu).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel4, -2, 35, -2).addGap(46, 46, 46))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addComponent(this.jRBGris).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel5, -2, 35, -2).addContainerGap()));
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
/* 185 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel5, -1, -1, 32767).addComponent(this.jLabel2, -1, -1, 32767).addComponent(this.jRBVert, -1, -1, 32767).addComponent(this.jRBGris, -1, -1, 32767)).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel1, -1, -1, 32767).addComponent(this.jRBRouge, -1, -1, 32767)).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(this.jRBBleu, -1, -1, 32767).addComponent(this.jLabel4, -1, -1, 32767))).addContainerGap(18, 32767)));
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
/* 206 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 207 */     this.jBtAnnuler.setText("Annuler");
/* 208 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 210 */         FormeCouleurLibrairie.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 213 */     });
/* 214 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 215 */     this.jBtValider.setText("Valider ");
/* 216 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 218 */         FormeCouleurLibrairie.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 221 */     });
/* 222 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 223 */     getContentPane().setLayout(layout);
/* 224 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 103, -2).addGap(18, 18, 18).addComponent(this.jBtValider, -2, 104, -2))).addContainerGap()));
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
/* 237 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
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
/* 249 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(java.awt.event.ActionEvent evt) {
/* 253 */     sauvegardeCouleur();
/* 254 */     this.frm.getPanLibibrary().getSelectedLibrary().saveLib();
/* 255 */     this.frm.getPanLibibrary().repaindrePan();
/* 256 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 260 */     dispose();
/*     */   }
/*     */   
/*     */   private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
/* 264 */     this.jRBVert.setSelected(true);
/*     */   }
/*     */   
/*     */   private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
/* 268 */     this.jRBRouge.setSelected(true);
/*     */   }
/*     */   
/*     */   private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
/* 272 */     this.jRBBleu.setSelected(true);
/*     */   }
/*     */   
/*     */   private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {
/* 276 */     this.jRBGris.setSelected(true);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\LibraryPan\FormeCouleurLibrairie.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */