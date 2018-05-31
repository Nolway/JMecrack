/*     */ package formes;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class FormeProprieteAttribut extends javax.swing.JDialog
/*     */ {
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JButton jButton2;
/*     */   private javax.swing.JCheckBox jCheckBox1;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTextArea jTextArea1;
/*     */   private javax.swing.JTextField jTextField1;
/*     */   
/*     */   public FormeProprieteAttribut(java.awt.Frame parent, boolean modal)
/*     */   {
/*  22 */     super(parent, modal);
/*  23 */     initComponents();
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
/*  35 */     this.jPanel1 = new javax.swing.JPanel();
/*  36 */     this.jLabel1 = new javax.swing.JLabel();
/*  37 */     this.jTextField1 = new javax.swing.JTextField();
/*  38 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  39 */     this.jTextArea1 = new javax.swing.JTextArea();
/*  40 */     this.jLabel2 = new javax.swing.JLabel();
/*  41 */     this.jCheckBox1 = new javax.swing.JCheckBox();
/*  42 */     this.jButton1 = new javax.swing.JButton();
/*  43 */     this.jButton2 = new javax.swing.JButton();
/*     */     
/*  45 */     setDefaultCloseOperation(2);
/*     */     
/*  47 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  49 */     this.jLabel1.setText("Valeur par défaut ");
/*     */     
/*  51 */     this.jTextArea1.setColumns(20);
/*  52 */     this.jTextArea1.setRows(5);
/*  53 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*     */     
/*  55 */     this.jLabel2.setText("Historiques :");
/*     */     
/*  57 */     this.jCheckBox1.setSelected(true);
/*  58 */     this.jCheckBox1.setText("Visible sur le MCD");
/*     */     
/*  60 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  61 */     this.jPanel1.setLayout(jPanel1Layout);
/*  62 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 500, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCheckBox1).addComponent(this.jTextField1, -2, 383, -2))).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  77 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTextField1, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jCheckBox1).addGap(8, 8, 8).addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 183, -2).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/*  94 */     this.jButton1.setText("Valider");
/*     */     
/*  96 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/*  97 */     this.jButton2.setText("Annuler");
/*     */     
/*  99 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 100 */     getContentPane().setLayout(layout);
/* 101 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1)).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 113 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */     pack();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeProprieteAttribut.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */