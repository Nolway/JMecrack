/*     */ package formes;
/*     */ 
/*     */ import ihm.Principale;
/*     */ import java.awt.Color;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
/*     */ 
/*     */ public class FormeConstruction extends javax.swing.JDialog
/*     */ {
/*     */   private Color clFermer;
/*     */   private Color clFermerX;
/*     */   Principale frm;
/*     */   private JLabel jLabFermer;
/*     */   private JLabel jLabNom;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JProgressBar jProgBar;
/*     */   
/*     */   public FormeConstruction(Principale parent, boolean modal)
/*     */   {
/*  29 */     super(parent, modal);
/*  30 */     initComponents();
/*  31 */     this.frm = parent;
/*  32 */     setLocation(this.frm.getX() + 400, this.frm.getY() + 250);
/*  33 */     this.clFermer = new Color(255, 50, 50);
/*  34 */     this.clFermerX = Color.BLACK;
/*     */   }
/*     */   
/*     */   public JLabel getjLabNom() {
/*  38 */     return this.jLabNom;
/*     */   }
/*     */   
/*     */   public JProgressBar getjProgBar() {
/*  42 */     return this.jProgBar;
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
/*  55 */     this.jPanel2 = new JPanel();
/*  56 */     this.jPanel1 = new JPanel();
/*  57 */     this.jLabNom = new JLabel();
/*  58 */     this.jProgBar = new JProgressBar();
/*  59 */     this.jLabel2 = new JLabel();
/*  60 */     this.jLabel3 = new JLabel();
/*  61 */     this.jLabFermer = new JLabel();
/*     */     
/*  63 */     setDefaultCloseOperation(2);
/*  64 */     setBackground(new Color(153, 153, 153));
/*  65 */     setResizable(false);
/*  66 */     setUndecorated(true);
/*     */     
/*  68 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/*     */     
/*  70 */     this.jPanel1.setBackground(new Color(255, 255, 255));
/*  71 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  72 */     this.jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/*  74 */         FormeConstruction.this.jPanel1MouseClicked(evt);
/*     */       }
/*     */       
/*  77 */     });
/*  78 */     this.jLabNom.setText("En Construction ...");
/*     */     
/*  80 */     this.jProgBar.setValue(50);
/*     */     
/*  82 */     this.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/indicateur-progression-1.gif")));
/*     */     
/*  84 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  85 */     this.jPanel1.setLayout(jPanel1Layout);
/*  86 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jProgBar, -2, 293, -2).addComponent(this.jLabNom, -2, 190, -2)).addGap(10, 10, 10).addComponent(this.jLabel2, -2, 50, -2).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabNom).addGap(18, 18, 18).addComponent(this.jProgBar, -2, -1, -2)).addComponent(this.jLabel2, -1, 51, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */     this.jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
/* 111 */     this.jLabel3.setHorizontalAlignment(2);
/* 112 */     this.jLabel3.setText("JMerise");
/*     */     
/* 114 */     this.jLabFermer.setBackground(new Color(255, 51, 51));
/* 115 */     this.jLabFermer.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 116 */     this.jLabFermer.setHorizontalAlignment(0);
/* 117 */     this.jLabFermer.setText("X");
/* 118 */     this.jLabFermer.setToolTipText("Fermer");
/* 119 */     this.jLabFermer.setOpaque(true);
/* 120 */     this.jLabFermer.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 122 */         FormeConstruction.this.jLabFermerMouseClicked(evt);
/*     */       }
/*     */       
/* 125 */       public void mouseEntered(MouseEvent evt) { FormeConstruction.this.jLabFermerMouseEntered(evt); }
/*     */       
/*     */       public void mouseExited(MouseEvent evt) {
/* 128 */         FormeConstruction.this.jLabFermerMouseExited(evt);
/*     */       }
/*     */       
/* 131 */     });
/* 132 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 133 */     this.jPanel2.setLayout(jPanel2Layout);
/* 134 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addGap(142, 142, 142).addComponent(this.jLabel3, -2, 93, -2))).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(373, 32767).addComponent(this.jLabFermer, -2, 22, -2)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 149 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3)).addComponent(this.jLabFermer)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 162 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 163 */     getContentPane().setLayout(layout);
/* 164 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/* 168 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 173 */     pack();
/*     */   }
/*     */   
/*     */   private void jPanel1MouseClicked(MouseEvent evt) {
/* 177 */     dispose();
/*     */   }
/*     */   
/*     */   private void jLabFermerMouseClicked(MouseEvent evt) {
/* 181 */     dispose();
/*     */   }
/*     */   
/*     */   private void jLabFermerMouseEntered(MouseEvent evt) {
/* 185 */     this.jLabFermer.setBackground(Color.RED);
/* 186 */     this.jLabFermer.setForeground(Color.WHITE);
/*     */   }
/*     */   
/*     */   private void jLabFermerMouseExited(MouseEvent evt) {
/* 190 */     this.jLabFermer.setBackground(this.clFermer);
/* 191 */     this.jLabFermer.setForeground(this.clFermerX);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeConstruction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */