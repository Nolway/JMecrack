/*     */ package formes;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ 
/*     */ public class FormeInformationSite extends javax.swing.JDialog
/*     */ {
/*     */   public ihm.Principale frm;
/*     */   private JButton jBtInfo;
/*     */   private JButton jBtValider;
/*     */   private JLabel jLabLogo;
/*     */   private JLabel jLabel2;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private JTextArea jTextArea1;
/*     */   
/*     */   public FormeInformationSite(ihm.Principale frm, boolean modal)
/*     */   {
/*  26 */     super(frm, modal);
/*  27 */     this.frm = frm;
/*  28 */     initComponents();
/*  29 */     this.jLabLogo.setText(Outil.Parametres.version);
/*  30 */     setLocation(frm.getX() + 300, frm.getY() + 90);
/*  31 */     this.jBtInfo.setMnemonic(73);
/*  32 */     this.jBtValider.setMnemonic(10);
/*     */   }
/*     */   
/*     */   public String valeurChamp(String ch, String settin) {
/*  36 */     String s = settin.substring(settin.indexOf(ch));
/*  37 */     s = s.substring(s.indexOf(">") + 1);
/*  38 */     s = s.substring(0, s.indexOf("<"));
/*  39 */     return s.trim();
/*     */   }
/*     */   
/*     */   private String traiterInfo(String info) {
/*  43 */     String s = "";
/*  44 */     if (info.trim().toUpperCase().indexOf("ERREURRM") >= 0) {
/*  45 */       return "Erreur : Vérifiez votre connexion internet ou vos parametres proxy (configuration -> parametres -> onglet réseau)";
/*     */     }
/*  47 */     if (valeurChamp("<important>", info).trim().length() > 0) {
/*  48 */       s = s + "IMPORTANT :\n" + valeurChamp("<important>", info) + "\n";
/*     */     }
/*  50 */     s = s + "Version : " + valeurChamp("<version>", info) + "\n\n";
/*  51 */     s = s + "date : " + valeurChamp("<date>", info) + "\n\n";
/*  52 */     s = s + "NOUVEAUTE : \n";
/*  53 */     s = s + "========= \n";
/*  54 */     s = s + valeurChamp("<nouveaute>", info) + "\n\n";
/*  55 */     if (valeurChamp("<message>", info).trim().length() > 0) {
/*  56 */       s = s + "Message :\n" + valeurChamp("<message>", info) + "\n\n";
/*     */     }
/*     */     
/*  59 */     s = s + "Envoyez moi vos remarques ou suggestions par mail : admin@jfreesoft.com";
/*  60 */     return s;
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
/*  73 */     this.jPanel1 = new javax.swing.JPanel();
/*  74 */     this.jLabLogo = new JLabel();
/*  75 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  76 */     this.jTextArea1 = new JTextArea();
/*  77 */     this.jLabel2 = new JLabel();
/*  78 */     this.jBtInfo = new JButton();
/*  79 */     this.jBtValider = new JButton();
/*     */     
/*  81 */     setDefaultCloseOperation(2);
/*  82 */     setTitle("Informations disponible sur le site");
/*     */     
/*  84 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));
/*     */     
/*  86 */     this.jLabLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/newLogo64.gif")));
/*     */     
/*  88 */     this.jTextArea1.setColumns(20);
/*  89 */     this.jTextArea1.setRows(5);
/*  90 */     this.jTextArea1.setText("\t\n\tCliquez sur le bouton JMerise info...\n\t**************************************");
/*  91 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*     */     
/*  93 */     this.jLabel2.setText("Informations disponibles sur le site ");
/*     */     
/*  95 */     this.jBtInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/infosite.jpg")));
/*  96 */     this.jBtInfo.setText("JMerise info ...");
/*  97 */     this.jBtInfo.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  99 */         FormeInformationSite.this.jBtInfoActionPerformed(evt);
/*     */       }
/*     */       
/* 102 */     });
/* 103 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 104 */     this.jPanel1.setLayout(jPanel1Layout);
/* 105 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 789, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2).addGap(55, 55, 55).addComponent(this.jLabLogo, -2, 212, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 139, 32767).addComponent(this.jBtInfo, -2, 215, -2))).addContainerGap()));
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
/* 119 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addGap(18, 18, 18)).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabLogo))).addGap(15, 15, 15)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jBtInfo).addGap(18, 18, 18))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 385, 32767).addContainerGap()));
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
/* 142 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 143 */     this.jBtValider.setText("OK");
/* 144 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 146 */         FormeInformationSite.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 149 */     });
/* 150 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 151 */     getContentPane().setLayout(layout);
/* 152 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jBtValider, GroupLayout.Alignment.TRAILING)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 161 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 171 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(ActionEvent evt) {
/* 175 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtInfoActionPerformed(ActionEvent evt) {
/* 179 */     String s = input.InfoSite.dump("http://www.jfreesoft.com/infoSite.php");
/* 180 */     this.jTextArea1.setText(traiterInfo(s));
/* 181 */     this.jTextArea1.setCaretPosition(0);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeInformationSite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */