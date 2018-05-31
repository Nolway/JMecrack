/*     */ package ihm;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class FormeInterneRequete extends javax.swing.JInternalFrame
/*     */ {
/*     */   private javax.swing.JMenu jMenu1;
/*     */   private javax.swing.JMenu jMenu2;
/*     */   private javax.swing.JMenuBar jMenuBar1;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JPanel jPanel4;
/*     */   private JPanel jPanel5;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JSplitPane jSplitPane1;
/*     */   private javax.swing.JTextArea jTextArea1;
/*     */   
/*     */   public FormeInterneRequete()
/*     */   {
/*  22 */     initComponents();
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
/*  34 */     this.jSplitPane1 = new javax.swing.JSplitPane();
/*  35 */     this.jPanel1 = new JPanel();
/*  36 */     this.jPanel2 = new JPanel();
/*  37 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  38 */     this.jTextArea1 = new javax.swing.JTextArea();
/*  39 */     this.jPanel3 = new JPanel();
/*  40 */     this.jPanel4 = new JPanel();
/*  41 */     this.jPanel5 = new JPanel();
/*  42 */     this.jMenuBar1 = new javax.swing.JMenuBar();
/*  43 */     this.jMenu1 = new javax.swing.JMenu();
/*  44 */     this.jMenu2 = new javax.swing.JMenu();
/*     */     
/*  46 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  47 */     this.jPanel1.setLayout(jPanel1Layout);
/*  48 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 91, 32767));
/*     */     
/*     */ 
/*     */ 
/*  52 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 402, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  57 */     this.jSplitPane1.setLeftComponent(this.jPanel1);
/*     */     
/*  59 */     this.jTextArea1.setColumns(20);
/*  60 */     this.jTextArea1.setRows(5);
/*  61 */     this.jTextArea1.setText("Select * \nfrom table\nwhere  \n");
/*  62 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*     */     
/*  64 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  66 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  67 */     this.jPanel3.setLayout(jPanel3Layout);
/*  68 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 122, 32767));
/*     */     
/*     */ 
/*     */ 
/*  72 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 98, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  77 */     this.jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  79 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  80 */     this.jPanel4.setLayout(jPanel4Layout);
/*  81 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 109, 32767));
/*     */     
/*     */ 
/*     */ 
/*  85 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 98, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  90 */     this.jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
/*     */     
/*  92 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  93 */     this.jPanel5.setLayout(jPanel5Layout);
/*  94 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 800, 32767));
/*     */     
/*     */ 
/*     */ 
/*  98 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 53, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 103 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 104 */     this.jPanel2.setLayout(jPanel2Layout);
/* 105 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 547, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel4, -2, -1, -2)).addComponent(this.jPanel5, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 119 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel4, javax.swing.GroupLayout.Alignment.LEADING, -2, -1, -2).addComponent(this.jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, -1, 98, 32767).addComponent(this.jPanel3, javax.swing.GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap(236, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */     this.jSplitPane1.setRightComponent(this.jPanel2);
/*     */     
/* 134 */     this.jMenu1.setText("File");
/* 135 */     this.jMenuBar1.add(this.jMenu1);
/*     */     
/* 137 */     this.jMenu2.setText("Edit");
/* 138 */     this.jMenuBar1.add(this.jMenu2);
/*     */     
/* 140 */     setJMenuBar(this.jMenuBar1);
/*     */     
/* 142 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 143 */     getContentPane().setLayout(layout);
/* 144 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jSplitPane1, -1, 920, 32767));
/*     */     
/*     */ 
/*     */ 
/* 148 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jSplitPane1, -1, 404, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 155 */     pack();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\ihm\FormeInterneRequete.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */