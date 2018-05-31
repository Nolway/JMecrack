/*     */ package formes;
/*     */ 
/*     */ import ihm.Principale;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormeLegendeRetro extends javax.swing.JDialog
/*     */ {
/*     */   private Principale frm;
/*     */   private JButton jBtValider;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   
/*     */   public FormeLegendeRetro(Principale frm, boolean modal)
/*     */   {
/*  26 */     super(frm, modal);
/*  27 */     initComponents();
/*  28 */     this.frm = frm;
/*  29 */     setLocation(frm.getX() + 300, frm.getY() + 200);
/*  30 */     getContentPane().setBackground(java.awt.Color.WHITE);
/*  31 */     this.jBtValider.setMnemonic(10);
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
/*  43 */     this.jLabel1 = new JLabel();
/*  44 */     this.jLabel2 = new JLabel();
/*  45 */     this.jLabel3 = new JLabel();
/*  46 */     this.jLabel4 = new JLabel();
/*  47 */     this.jBtValider = new JButton();
/*  48 */     this.jLabel5 = new JLabel();
/*  49 */     this.jLabel6 = new JLabel();
/*     */     
/*  51 */     setDefaultCloseOperation(2);
/*  52 */     setTitle("Légende");
/*  53 */     setResizable(false);
/*     */     
/*  55 */     this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Images/colonneCle16.png")));
/*  56 */     this.jLabel1.setText("Clé primaire ");
/*     */     
/*  58 */     this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/Images/colonneIndex16.png")));
/*  59 */     this.jLabel2.setText("Index");
/*     */     
/*  61 */     this.jLabel3.setIcon(new ImageIcon(getClass().getResource("/Images/colonne16.png")));
/*  62 */     this.jLabel3.setText("Colonne");
/*     */     
/*  64 */     this.jLabel4.setIcon(new ImageIcon(getClass().getResource("/Images/table16.png")));
/*  65 */     this.jLabel4.setText("Table ");
/*     */     
/*  67 */     this.jBtValider.setIcon(new ImageIcon(getClass().getResource("/Images/OK.png")));
/*  68 */     this.jBtValider.setText("Ok");
/*  69 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  71 */         FormeLegendeRetro.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/*  74 */     });
/*  75 */     this.jLabel5.setIcon(new ImageIcon(getClass().getResource("/Images/cleEtrangere16.png")));
/*  76 */     this.jLabel5.setText("Clé étrangère");
/*     */     
/*  78 */     this.jLabel6.setIcon(new ImageIcon(getClass().getResource("/Images/colonneUnique16.png")));
/*  79 */     this.jLabel6.setText("Unique");
/*     */     
/*  81 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  82 */     getContentPane().setLayout(layout);
/*  83 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2)).addContainerGap(107, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6).addContainerGap(133, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addComponent(this.jLabel3).addComponent(this.jLabel4)).addContainerGap(100, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(121, 32767).addComponent(this.jBtValider).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 107 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jLabel6).addGap(18, 18, 18).addComponent(this.jLabel5).addGap(18, 18, 18).addComponent(this.jLabel3).addGap(18, 18, 18).addComponent(this.jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 127 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(ActionEvent evt) {
/* 131 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeLegendeRetro.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */