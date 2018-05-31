/*     */ package formes;
/*     */ 
/*     */ import java.awt.Graphics;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class FormeDescriptionLoadMCD extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   input.LoadMCD mcdSel;
/*     */   java.awt.Image imageMCD;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private JPanel jPanImage;
/*     */   private JPanel jPanel1;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTextPane jTADescription;
/*     */   private JTextField jTFID;
/*     */   private JTextField jTFNom;
/*     */   private JTextField jTFload;
/*     */   
/*     */   public FormeDescriptionLoadMCD(ihm.Principale frm, input.LoadMCD mcdSel, boolean modal)
/*     */   {
/*  31 */     super(frm, modal);
/*  32 */     initComponents();
/*  33 */     this.frm = frm;
/*  34 */     setLocation(frm.getX() + 320, frm.getY() + 120);
/*  35 */     this.mcdSel = mcdSel;
/*  36 */     this.jTFID.setText(mcdSel.getId());
/*  37 */     this.jTFNom.setText(mcdSel.getNom());
/*  38 */     this.jTFload.setText(mcdSel.getNbLoad());
/*  39 */     this.jTADescription.setText(mcdSel.getDescription());
/*  40 */     this.imageMCD = null;
/*     */   }
/*     */   
/*     */   private void dessinerImage(Graphics g, String img) {
/*  44 */     g.setColor(java.awt.Color.WHITE);
/*  45 */     int w = this.jPanImage.getWidth();
/*  46 */     int h = this.jPanImage.getHeight();
/*  47 */     g.fillRect(0, 0, w, h);
/*     */     
/*  49 */     g.drawString("Je télécharge ==", 20, 50);
/*  50 */     java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().getImage("http://jfreesoft.com/" + img);
/*  51 */     this.imageMCD = image;
/*  52 */     g.setColor(java.awt.Color.GREEN);
/*  53 */     g.drawImage(this.imageMCD, 0, 0, w, h, null);
/*     */   }
/*     */   
/*     */   private void dessinerImageMCD(Graphics g) {
/*  57 */     g.setColor(java.awt.Color.RED);
/*  58 */     int w = this.jPanImage.getWidth();
/*  59 */     int h = this.jPanImage.getHeight();
/*  60 */     g.fillRect(0, 0, w, h);
/*  61 */     g.drawString("Image non null  ==", 50, 50);
/*     */     
/*     */ 
/*     */ 
/*  65 */     g.drawImage(this.imageMCD, 0, 0, w, h, null);
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
/*     */   private void initComponents()
/*     */   {
/*  80 */     this.jPanel1 = new JPanel();
/*  81 */     this.jLabel1 = new javax.swing.JLabel();
/*  82 */     this.jLabel2 = new javax.swing.JLabel();
/*  83 */     this.jLabel3 = new javax.swing.JLabel();
/*  84 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  85 */     this.jTADescription = new javax.swing.JTextPane();
/*  86 */     this.jTFID = new JTextField();
/*  87 */     this.jTFNom = new JTextField();
/*  88 */     this.jLabel4 = new javax.swing.JLabel();
/*  89 */     this.jTFload = new JTextField();
/*  90 */     this.jBtAnnuler = new javax.swing.JButton();
/*  91 */     this.jPanImage = new JPanel();
/*     */     
/*  93 */     setDefaultCloseOperation(2);
/*  94 */     setTitle("Description du MCD");
/*  95 */     setResizable(false);
/*     */     
/*  97 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  99 */     this.jLabel1.setText("Numéro");
/*     */     
/* 101 */     this.jLabel2.setText("Nom ");
/*     */     
/* 103 */     this.jLabel3.setText("Description");
/*     */     
/* 105 */     this.jTADescription.setEditable(false);
/* 106 */     this.jScrollPane1.setViewportView(this.jTADescription);
/*     */     
/* 108 */     this.jTFID.setEditable(false);
/*     */     
/* 110 */     this.jTFNom.setEditable(false);
/*     */     
/* 112 */     this.jLabel4.setText("Nombre de vue");
/*     */     
/* 114 */     this.jTFload.setEditable(false);
/* 115 */     this.jTFload.setForeground(new java.awt.Color(0, 0, 153));
/*     */     
/* 117 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 118 */     this.jPanel1.setLayout(jPanel1Layout);
/* 119 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 622, 32767).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFNom, -1, 567, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jTFID, -2, 78, -2).addGap(71, 71, 71).addComponent(this.jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFload, -2, 139, -2))).addContainerGap()).addComponent(this.jLabel3))));
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
/* 143 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFID, -2, -1, -2).addComponent(this.jLabel4).addComponent(this.jTFload, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTFNom, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 206, 32767).addContainerGap()));
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
/* 163 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 164 */     this.jBtAnnuler.setText("Fermer");
/* 165 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 167 */         FormeDescriptionLoadMCD.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 170 */     });
/* 171 */     this.jPanImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 172 */     this.jPanImage.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 174 */         FormeDescriptionLoadMCD.this.jPanImageMouseClicked(evt);
/*     */       }
/*     */       
/* 177 */     });
/* 178 */     GroupLayout jPanImageLayout = new GroupLayout(this.jPanImage);
/* 179 */     this.jPanImage.setLayout(jPanImageLayout);
/* 180 */     jPanImageLayout.setHorizontalGroup(jPanImageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 15, 32767));
/*     */     
/*     */ 
/*     */ 
/* 184 */     jPanImageLayout.setVerticalGroup(jPanImageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 189 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 190 */     getContentPane().setLayout(layout);
/* 191 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jPanImage, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 517, 32767).addComponent(this.jBtAnnuler, -2, 110, -2))).addContainerGap()));
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
/* 203 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanImage, -2, -1, -2).addComponent(this.jBtAnnuler, -1, 26, 32767)).addContainerGap()));
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
/* 215 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 219 */     dispose();
/*     */   }
/*     */   
/*     */   private void jPanImageMouseClicked(java.awt.event.MouseEvent evt) {}
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeDescriptionLoadMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */