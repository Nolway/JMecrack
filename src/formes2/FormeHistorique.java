/*     */ package formes2;
/*     */ 
/*     */ import Merise2.Historique;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class FormeHistorique extends javax.swing.JDialog
/*     */ {
/*     */   ArrayList<Historique> historiques;
/*     */   ihm.Principale frm;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private JTextArea jTA;
/*     */   private JTextField jTFDate;
/*     */   private JTextField jTFDeveloppeur;
/*     */   
/*     */   public FormeHistorique(ihm.Principale parent, boolean modal, ArrayList<Historique> historiques, String typeEntite, String nomEntite)
/*     */   {
/*  29 */     super(parent, modal);
/*  30 */     setTitle("Historiques : " + nomEntite);
/*  31 */     initComponents();
/*  32 */     this.frm = parent;
/*  33 */     setLocation(this.frm.getX() + 300, this.frm.getY() + 100);
/*  34 */     this.historiques = historiques;
/*  35 */     initField();
/*  36 */     this.jBtAnnuler.setMnemonic(65);
/*     */   }
/*     */   
/*     */   private void initField() {
/*  40 */     this.jTFDate.setText(((Historique)this.historiques.get(0)).getDate());
/*  41 */     this.jTFDeveloppeur.setText(((Historique)this.historiques.get(0)).getDeveloppeur());
/*  42 */     this.jTA.setText(getHistoriquesString());
/*     */   }
/*     */   
/*     */   private String getHistoriquesString()
/*     */   {
/*  47 */     String s = "";
/*  48 */     for (int i = 1; i < this.historiques.size(); i++) {
/*  49 */       s = s + ((Historique)this.historiques.get(i)).getHistoiqueString() + "\n";
/*     */     }
/*  51 */     return s;
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
/*  66 */     this.jBtAnnuler = new javax.swing.JButton();
/*  67 */     this.jPanel1 = new javax.swing.JPanel();
/*  68 */     this.jLabel1 = new JLabel();
/*  69 */     this.jTFDate = new JTextField();
/*  70 */     this.jLabel2 = new JLabel();
/*  71 */     this.jTFDeveloppeur = new JTextField();
/*  72 */     this.jLabel3 = new JLabel();
/*  73 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  74 */     this.jTA = new JTextArea();
/*     */     
/*  76 */     setDefaultCloseOperation(2);
/*  77 */     setTitle("Historique");
/*  78 */     setResizable(false);
/*     */     
/*  80 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/*  81 */     this.jBtAnnuler.setText("Fermer ");
/*  82 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  84 */         FormeHistorique.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/*  87 */     });
/*  88 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  90 */     this.jLabel1.setText("Date de création");
/*     */     
/*  92 */     this.jTFDate.setEditable(false);
/*     */     
/*  94 */     this.jLabel2.setText("Développeur");
/*     */     
/*  96 */     this.jTFDeveloppeur.setEditable(false);
/*     */     
/*  98 */     this.jLabel3.setText("Actions ");
/*     */     
/* 100 */     this.jTA.setColumns(20);
/* 101 */     this.jTA.setEditable(false);
/* 102 */     this.jTA.setRows(5);
/* 103 */     this.jScrollPane1.setViewportView(this.jTA);
/*     */     
/* 105 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 106 */     this.jPanel1.setLayout(jPanel1Layout);
/* 107 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 651, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jTFDate, -2, 101, -2).addGap(79, 79, 79).addComponent(this.jLabel2, -2, 89, -2).addGap(18, 18, 18).addComponent(this.jTFDeveloppeur, -1, 266, 32767)).addComponent(this.jLabel3)).addContainerGap()));
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
/* 124 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFDate, -2, -1, -2).addComponent(this.jTFDeveloppeur, -2, -1, -2).addComponent(this.jLabel2)).addGap(18, 18, 18).addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 270, 32767).addContainerGap()));
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
/* 140 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 141 */     getContentPane().setLayout(layout);
/* 142 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jBtAnnuler, -2, 109, -2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 151 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtAnnuler).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 161 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 165 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeHistorique.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */