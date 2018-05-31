/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmCadre;
/*     */ import java.awt.Color;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormeCadre extends javax.swing.JDialog
/*     */ {
/*     */   private IhmCadre cadre;
/*     */   private JButton jBtAnnuler;
/*     */   private JButton jBtOK;
/*     */   private JCheckBox jCBDegradee;
/*     */   private JCheckBox jCBOmbre;
/*     */   private JLabel jLabCadre;
/*     */   private JLabel jLabFond;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   
/*     */   public FormeCadre(java.awt.Frame parent, boolean modal, IhmCadre cadre, int x, int y)
/*     */   {
/*  28 */     super(parent, modal);
/*  29 */     initComponents();
/*  30 */     setLocation(500, 200);
/*  31 */     this.cadre = cadre;
/*  32 */     initialiser();
/*  33 */     this.jBtOK.setMnemonic(10);
/*  34 */     this.jBtAnnuler.setMnemonic(65);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private String getColeurString(Color cl)
/*     */   {
/*  41 */     return cl.getRGB() + "";
/*     */   }
/*     */   
/*     */   private Color getCouleurs(String cl) {
/*  45 */     return new Color(Integer.parseInt(cl));
/*     */   }
/*     */   
/*     */   private void initialiser() {
/*  49 */     this.jLabFond.setBackground(this.cadre.getClCadreFond());
/*  50 */     this.jLabCadre.setBackground(this.cadre.getClCadreCadre());
/*  51 */     this.jCBOmbre.setSelected(this.cadre.isOmbre());
/*  52 */     this.jCBDegradee.setSelected(this.cadre.isClDegradee());
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
/*     */   private void initComponents()
/*     */   {
/*  66 */     this.jPanel1 = new javax.swing.JPanel();
/*  67 */     this.jLabel1 = new JLabel();
/*  68 */     this.jLabel2 = new JLabel();
/*  69 */     this.jCBOmbre = new JCheckBox();
/*  70 */     this.jCBDegradee = new JCheckBox();
/*  71 */     this.jLabCadre = new JLabel();
/*  72 */     this.jLabFond = new JLabel();
/*  73 */     this.jBtOK = new JButton();
/*  74 */     this.jBtAnnuler = new JButton();
/*     */     
/*  76 */     setDefaultCloseOperation(2);
/*  77 */     setTitle("Propriété");
/*  78 */     setResizable(false);
/*     */     
/*  80 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */     
/*  82 */     this.jLabel1.setForeground(new Color(0, 51, 204));
/*  83 */     this.jLabel1.setText("Cadre");
/*  84 */     this.jLabel1.setCursor(new java.awt.Cursor(12));
/*  85 */     this.jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/*  87 */         FormeCadre.this.jLabel1MouseClicked(evt);
/*     */       }
/*     */       
/*  90 */     });
/*  91 */     this.jLabel2.setForeground(new Color(0, 51, 204));
/*  92 */     this.jLabel2.setText("Fond");
/*  93 */     this.jLabel2.setCursor(new java.awt.Cursor(12));
/*  94 */     this.jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/*  96 */         FormeCadre.this.jLabel2MouseClicked(evt);
/*     */       }
/*     */       
/*  99 */     });
/* 100 */     this.jCBOmbre.setText("Ombre");
/*     */     
/* 102 */     this.jCBDegradee.setText("Couleur Degradée");
/*     */     
/* 104 */     this.jLabCadre.setBackground(new Color(0, 51, 255));
/* 105 */     this.jLabCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 106 */     this.jLabCadre.setOpaque(true);
/*     */     
/* 108 */     this.jLabFond.setBackground(new Color(255, 255, 255));
/* 109 */     this.jLabFond.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/* 110 */     this.jLabFond.setOpaque(true);
/*     */     
/* 112 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 113 */     this.jPanel1.setLayout(jPanel1Layout);
/* 114 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(34, 34, 34).addComponent(this.jCBOmbre, -2, 94, -2).addGap(33, 33, 33).addComponent(this.jCBDegradee).addContainerGap(54, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -1, 47, 32767).addComponent(this.jLabel2, -1, 47, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabFond, -1, 80, 32767).addComponent(this.jLabCadre, -1, 80, 32767)).addGap(185, 185, 185)));
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
/* 133 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabCadre, -2, 15, -2).addComponent(this.jLabel1)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel2).addComponent(this.jLabFond, -2, 15, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBOmbre).addComponent(this.jCBDegradee)).addGap(17, 17, 17)));
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
/* 151 */     this.jBtOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 152 */     this.jBtOK.setText("OK");
/* 153 */     this.jBtOK.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 155 */         FormeCadre.this.jBtOKActionPerformed(evt);
/*     */       }
/*     */       
/* 158 */     });
/* 159 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 160 */     this.jBtAnnuler.setText("Annuler");
/* 161 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 163 */         FormeCadre.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 166 */     });
/* 167 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 168 */     getContentPane().setLayout(layout);
/* 169 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtOK, -2, 79, -2))).addContainerGap()));
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
/* 181 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtOK).addComponent(this.jBtAnnuler)).addContainerGap()));
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
/* 193 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtOKActionPerformed(java.awt.event.ActionEvent evt) {
/* 197 */     this.cadre.setClCadreFond(this.jLabFond.getBackground());
/* 198 */     this.cadre.setClCadreCadre(this.jLabCadre.getBackground());
/*     */     
/* 200 */     this.cadre.setClCadreFondSt(getColeurString(this.cadre.getClCadreFond()));
/* 201 */     this.cadre.setClCadreCadreSt(getColeurString(this.cadre.getClCadreCadre()));
/*     */     
/* 203 */     this.cadre.setOmbre(this.jCBOmbre.isSelected());
/* 204 */     this.cadre.setClDegradee(this.jCBDegradee.isSelected());
/* 205 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 209 */     dispose();
/*     */   }
/*     */   
/*     */   private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
/* 213 */     this.jLabCadre.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabCadre.getBackground()));
/*     */   }
/*     */   
/*     */   private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
/* 217 */     this.jLabFond.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabFond.getBackground()));
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeCadre.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */