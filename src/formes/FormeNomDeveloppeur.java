/*     */ package formes;
/*     */ 
/*     */ import ihm.Principale;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class FormeNomDeveloppeur extends javax.swing.JDialog
/*     */ {
/*     */   Principale frm;
/*     */   private JButton jBtAnnuler;
/*     */   private JButton jBtValider;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JPanel jPanel1;
/*     */   private JTextField jTFDeveloppeur;
/*     */   
/*     */   public FormeNomDeveloppeur(Principale frm, boolean modal)
/*     */   {
/*  26 */     super(frm, modal);
/*  27 */     initComponents();
/*  28 */     this.frm = frm;
/*  29 */     setLocation(frm.getX() + 220, frm.getY() + 150);
/*  30 */     this.jTFDeveloppeur.setText(Outil.Setting.developpeur);
/*  31 */     this.jBtValider.setMnemonic(10);
/*  32 */     this.jBtAnnuler.setMnemonic(65);
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
/*  44 */     this.jPanel1 = new JPanel();
/*  45 */     this.jLabel1 = new JLabel();
/*  46 */     this.jTFDeveloppeur = new JTextField();
/*  47 */     this.jLabel2 = new JLabel();
/*  48 */     this.jBtValider = new JButton();
/*  49 */     this.jBtAnnuler = new JButton();
/*     */     
/*  51 */     setDefaultCloseOperation(2);
/*  52 */     setTitle("Personnaliser nom développeur");
/*  53 */     setResizable(false);
/*     */     
/*  55 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  57 */     this.jLabel1.setText("Développeur ");
/*     */     
/*  59 */     this.jLabel2.setText("D'autres paramètres de configuration sont disponibles dans Configuration -> paramètres");
/*     */     
/*  61 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  62 */     this.jPanel1.setLayout(jPanel1Layout);
/*  63 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jTFDeveloppeur, -1, 538, 32767)).addComponent(this.jLabel2)).addContainerGap()));
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
/*  75 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFDeveloppeur, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jLabel2).addContainerGap(-1, 32767)));
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
/*  87 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/*  88 */     this.jBtValider.setText("Valider");
/*  89 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  91 */         FormeNomDeveloppeur.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/*  94 */     });
/*  95 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/*  96 */     this.jBtAnnuler.setText("Annuler");
/*  97 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  99 */         FormeNomDeveloppeur.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 102 */     });
/* 103 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 104 */     getContentPane().setLayout(layout);
/* 105 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 99, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtValider, -2, 93, -2))).addContainerGap()));
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
/* 117 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
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
/* 129 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(ActionEvent evt) {
/* 133 */     Outil.Setting.developpeur = this.jTFDeveloppeur.getText().trim();
/* 134 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(ActionEvent evt) {
/* 138 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeNomDeveloppeur.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */