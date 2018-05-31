/*     */ package formes;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ 
/*     */ public class FormeDiscussion extends javax.swing.JFrame {
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JButton jButton2;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JPanel jPanel3;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   private javax.swing.JTextArea jTextArea1;
/*     */   private javax.swing.JTextArea jTextArea2;
/*     */   private javax.swing.JTextField jTextField1;
/*     */   private javax.swing.JTextField jTextField2;
/*     */   
/*     */   public FormeDiscussion() {
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
/*  34 */     this.jPanel1 = new javax.swing.JPanel();
/*  35 */     this.jTextField1 = new javax.swing.JTextField();
/*  36 */     this.jLabel1 = new javax.swing.JLabel();
/*  37 */     this.jLabel2 = new javax.swing.JLabel();
/*  38 */     this.jTextField2 = new javax.swing.JTextField();
/*  39 */     this.jButton1 = new javax.swing.JButton();
/*  40 */     this.jLabel3 = new javax.swing.JLabel();
/*  41 */     this.jPanel2 = new javax.swing.JPanel();
/*  42 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  43 */     this.jTextArea2 = new javax.swing.JTextArea();
/*  44 */     this.jPanel3 = new javax.swing.JPanel();
/*  45 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/*  46 */     this.jTextArea1 = new javax.swing.JTextArea();
/*  47 */     this.jButton2 = new javax.swing.JButton();
/*     */     
/*  49 */     setDefaultCloseOperation(3);
/*  50 */     setCursor(new java.awt.Cursor(0));
/*     */     
/*  52 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  54 */     this.jLabel1.setText("mail ");
/*     */     
/*  56 */     this.jLabel2.setText("mot de passe ");
/*     */     
/*  58 */     this.jButton1.setText("Connexion");
/*     */     
/*  60 */     this.jLabel3.setText("Connecter");
/*     */     
/*  62 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  63 */     this.jPanel1.setLayout(jPanel1Layout);
/*  64 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel1, -2, 37, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, -1, 306, 32767).addComponent(this.jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, -1, 306, 32767)).addGap(20, 20, 20).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jButton1).addComponent(this.jLabel3)).addContainerGap()));
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
/*  81 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTextField1, -2, -1, -2).addComponent(this.jLabel3)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jTextField2, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.jButton1)).addContainerGap(-1, 32767)));
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
/*  97 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  99 */     this.jTextArea2.setColumns(20);
/* 100 */     this.jTextArea2.setRows(5);
/* 101 */     this.jScrollPane1.setViewportView(this.jTextArea2);
/*     */     
/* 103 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 104 */     this.jPanel2.setLayout(jPanel2Layout);
/* 105 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 514, 32767));
/*     */     
/*     */ 
/*     */ 
/* 109 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 318, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 114 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 116 */     this.jTextArea1.setColumns(20);
/* 117 */     this.jTextArea1.setRows(3);
/* 118 */     this.jScrollPane2.setViewportView(this.jTextArea1);
/*     */     
/* 120 */     this.jButton2.setText("Envoyer");
/*     */     
/* 122 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 123 */     this.jPanel3.setLayout(jPanel3Layout);
/* 124 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 494, 32767).addComponent(this.jButton2, javax.swing.GroupLayout.Alignment.TRAILING)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 133 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -2, 77, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2).addContainerGap(15, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 144 */     getContentPane().setLayout(layout);
/* 145 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jPanel3, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 155 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addContainerGap(20, 32767)));
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
/* 167 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 174 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 176 */         new FormeDiscussion().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeDiscussion.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */