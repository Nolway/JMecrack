/*     */ package formes;
/*     */ 
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ 
/*     */ public class FormeCreationCompteJFreeSoft extends javax.swing.JDialog {
/*     */   ihm.Principale frm;
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JCheckBox jCheckBox1;
/*     */   private javax.swing.JComboBox jComboBox1;
/*     */   private javax.swing.JComboBox jComboBox2;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JLabel jLabel5;
/*     */   private javax.swing.JLabel jLabel6;
/*     */   private javax.swing.JLabel jLabel7;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPasswordField jPasswordField1;
/*     */   private javax.swing.JTextField jTextField1;
/*     */   private javax.swing.JTextField jTextField2;
/*     */   private javax.swing.JTextField jTextField3;
/*     */   
/*     */   public FormeCreationCompteJFreeSoft(ihm.Principale parent, boolean modal) {
/*  24 */     super(parent, modal);
/*  25 */     initComponents();
/*  26 */     this.frm = parent;
/*  27 */     setLocation(this.frm.getY() + 300, this.frm.getY() + 100);
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
/*  39 */     this.jPanel1 = new javax.swing.JPanel();
/*  40 */     this.jLabel3 = new javax.swing.JLabel();
/*  41 */     this.jTextField3 = new javax.swing.JTextField();
/*  42 */     this.jLabel4 = new javax.swing.JLabel();
/*  43 */     this.jComboBox1 = new javax.swing.JComboBox();
/*  44 */     this.jCheckBox1 = new javax.swing.JCheckBox();
/*  45 */     this.jLabel5 = new javax.swing.JLabel();
/*  46 */     this.jLabel2 = new javax.swing.JLabel();
/*  47 */     this.jTextField1 = new javax.swing.JTextField();
/*  48 */     this.jLabel6 = new javax.swing.JLabel();
/*  49 */     this.jTextField2 = new javax.swing.JTextField();
/*  50 */     this.jComboBox2 = new javax.swing.JComboBox();
/*  51 */     this.jPasswordField1 = new javax.swing.JPasswordField();
/*  52 */     this.jLabel7 = new javax.swing.JLabel();
/*  53 */     this.jButton1 = new javax.swing.JButton();
/*     */     
/*  55 */     setDefaultCloseOperation(2);
/*  56 */     setTitle("créer un compte JFreeSoft");
/*  57 */     setResizable(false);
/*     */     
/*  59 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  61 */     this.jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  62 */     this.jLabel3.setForeground(new java.awt.Color(255, 51, 0));
/*  63 */     this.jLabel3.setText("email *");
/*     */     
/*  65 */     this.jLabel4.setText("Pays");
/*     */     
/*  67 */     this.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Etudiant", "Enseignant", "Professionnel", "Particulier" }));
/*     */     
/*  69 */     this.jCheckBox1.setSelected(true);
/*  70 */     this.jCheckBox1.setText("M'informer par mail de nouvelles versions");
/*     */     
/*  72 */     this.jLabel5.setText("Fonction");
/*     */     
/*  74 */     this.jLabel2.setText("Nom *");
/*     */     
/*  76 */     this.jLabel6.setText("Organisme");
/*     */     
/*  78 */     this.jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FR: FRANCE", "BE: BELGIQUE", "CH: SUISSE ", "IT: ITALIE", "CA: CANADA", "US: USA", "RU: RUSSIE", "GB: ROYAUME UNI", "DZ: ALGERIE", "MA: MAROC", "TN:TUNISIE", "CI: COTE D'IVOIRE", "SN: SENEGAL", "MG: MADAGASCAR", "CM: CAMEROUN", "MR: MAURITANIE", "ML: MALI", "LB: LIBAN", "DE: ALLEMAGNE", "PF: POLYNESIE FRAN9AISE", "TG: TOGO", "JP:JAPON", "GA: GABON", "BF: BURKINA-FASO", "NL: ", "NG:", "RE: ", "CD: ", "HT: ", "CG: ", "PE: ", "AU: ", "LU", "RO", "NC", "BJ", "SE", "VN", "RW", "ES", "AE", "BO", "GN", "GR", "MQ", "PT", "CN", "IE", "BY", "GP", "BI", "ZM", "TR", "IN", "HK", "PL", "CZ", "MF", "IL", "MX", "QA", "GE", "EU", "UA", "DJ", "A2", "MU", "HU", "CS", "FI", "AR", "LT", "BR", "BG", "SG", "HR", "CL", "NE", "DK", "NO", "IQ", "SL", "IM", "NZ", "KE", "GF", "LV", "OM", "KM", "GH", "AT", "SC", "KZ", "GQ", "Autres" }));
/*     */     
/*  80 */     this.jLabel7.setText("mot de passe*");
/*     */     
/*  82 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/*  83 */     this.jPanel1.setLayout(jPanel1Layout);
/*  84 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel7, -2, 82, -2).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel3, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel2, javax.swing.GroupLayout.Alignment.LEADING, -1, 74, 32767))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jTextField3, -1, 425, 32767).addComponent(this.jTextField1, -1, 425, 32767).addComponent(this.jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING, -1, 425, 32767))).addComponent(this.jLabel6).addComponent(this.jLabel4).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel5).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jTextField2, -1, 458, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(this.jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, -2, 187, -2)).addGap(18, 18, 18).addComponent(this.jCheckBox1, -1, -1, 32767))))).addContainerGap()));
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
/* 115 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jTextField3, -2, -1, -2).addComponent(this.jLabel2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jTextField1, -2, -1, -2).addComponent(this.jLabel3)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jPasswordField1, -2, -1, -2).addComponent(this.jLabel7)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jComboBox1, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jCheckBox1).addComponent(this.jComboBox2, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.jTextField2, -2, -1, -2)).addContainerGap(-1, 32767)));
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
/* 146 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/web.png")));
/* 147 */     this.jButton1.setText("Envoyer");
/*     */     
/* 149 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 150 */     getContentPane().setLayout(layout);
/* 151 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jButton1, -2, 138, -2).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 160 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jButton1).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 170 */     pack();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeCreationCompteJFreeSoft.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */