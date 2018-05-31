/*     */ package formes;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class FormeAjouterAttribut extends javax.swing.JDialog
/*     */ {
/*     */   private java.util.ArrayList<Merise.Attribut> listeAttribut;
/*     */   private ihm.Principale frm;
/*     */   private JButton jBtAnnuler;
/*     */   private JButton jBtOK;
/*     */   private JComboBox jCBType;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel8;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private JTextField jTFDecimal;
/*     */   private JTextField jTFLongueur;
/*     */   private JTextField jTFNom;
/*     */   
/*     */   public FormeAjouterAttribut(ihm.Principale frm, boolean modal, java.util.ArrayList<Merise.Attribut> listeAttribut)
/*     */   {
/*  30 */     super(frm, modal);
/*  31 */     initComponents();
/*  32 */     this.frm = frm;
/*  33 */     setLocation(frm.getX() + 500, frm.getY() + 400);
/*  34 */     remplirType();
/*  35 */     this.listeAttribut = listeAttribut;
/*  36 */     this.jBtOK.setMnemonic(10);
/*  37 */     this.jBtAnnuler.setMnemonic(65);
/*     */   }
/*     */   
/*     */   private void remplirType() {
/*  41 */     this.jCBType.removeAllItems();
/*  42 */     this.jCBType.addItem("");
/*  43 */     for (int i = 0; i < this.frm.getPage().getListeDomaine().size(); i++) {
/*  44 */       this.jCBType.addItem(((Merise.Domaine)this.frm.getPage().getListeDomaine().get(i)).getNom());
/*     */     }
/*  46 */     if (this.frm.getPage().getListeDomaine().size() > 0) this.jCBType.addItem("");
/*  47 */     for (int i = 0; i < Outil.Parametres.DomaineDefini.length; i++) {
/*  48 */       if ((!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("ENUM")) && (!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("SET")))
/*  49 */         this.jCBType.addItem(Outil.Parametres.DomaineDefini[i]);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean ajouterAttribut(String nom, String type, int tail1, int tail2) {
/*  54 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  55 */       if ((((Merise.Attribut)this.listeAttribut.get(i)).getNom().trim().toUpperCase().equals(nom.trim().toUpperCase())) && (((Merise.Attribut)this.listeAttribut.get(i)).getType().trim().toUpperCase().equals(type.trim().toUpperCase())))
/*     */       {
/*  57 */         return false; }
/*     */     }
/*  59 */     this.listeAttribut.add(new Merise.Attribut(nom.trim(), type.trim(), tail1, tail2, "", false, "", null));
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   private String verifierSaisie() {
/*  64 */     if (this.jTFNom.getText().trim().length() == 0) return "Nom ne doit pas être vide ";
/*  65 */     if (this.jCBType.getSelectedIndex() == 0) return "Aucun type n'a été désigné ";
/*  66 */     if (!estEntier(this.jTFLongueur.getText().trim())) return "La longueur n'est pas un entier";
/*  67 */     if (!estEntier(this.jTFDecimal.getText().trim())) { return "La longueur décimale n'est pas un entier";
/*     */     }
/*  69 */     return "";
/*     */   }
/*     */   
/*     */   private boolean estEntier(String ent) {
/*  73 */     if (ent.trim().length() == 0) return true;
/*     */     try {
/*  75 */       Integer.parseInt(ent);
/*  76 */       return true;
/*     */     } catch (Exception e) {}
/*  78 */     return false;
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
/*  91 */     this.jPanel1 = new javax.swing.JPanel();
/*  92 */     this.jLabel5 = new JLabel();
/*  93 */     this.jTFNom = new JTextField();
/*  94 */     this.jLabel4 = new JLabel();
/*  95 */     this.jCBType = new JComboBox();
/*  96 */     this.jLabel6 = new JLabel();
/*  97 */     this.jTFLongueur = new JTextField();
/*  98 */     this.jLabel8 = new JLabel();
/*  99 */     this.jTFDecimal = new JTextField();
/* 100 */     this.jBtAnnuler = new JButton();
/* 101 */     this.jBtOK = new JButton();
/*     */     
/* 103 */     setDefaultCloseOperation(2);
/* 104 */     setTitle("Nouvel attribut");
/* 105 */     setResizable(false);
/*     */     
/* 107 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 109 */     this.jLabel5.setText("Nom :");
/*     */     
/* 111 */     this.jLabel4.setText("type :");
/*     */     
/* 113 */     this.jCBType.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 114 */     this.jCBType.setForeground(new java.awt.Color(0, 0, 153));
/* 115 */     this.jCBType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Auto_increment", "Varchar", "Char", "Bool", "Date", "Int", "Integer", "Float", "Blob", "Datetime", "Decimal", "Double", "Double Precision", "Enum", "Longblob", "Longtext", "Mediumblob", "Mediumint", "Mediumtext", "Numeric", "Real", "Set", "Smallint", "Text", "Time", "TimeStamp", "TinyBlob", "TinyINT", "TinyText", "Year" }));
/*     */     
/* 117 */     this.jLabel6.setText("Taille :");
/*     */     
/* 119 */     this.jTFLongueur.setText("25");
/*     */     
/* 121 */     this.jLabel8.setText(",");
/*     */     
/* 123 */     this.jTFDecimal.setText("0");
/*     */     
/* 125 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 126 */     this.jPanel1.setLayout(jPanel1Layout);
/* 127 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6).addGap(32, 32, 32).addComponent(this.jTFLongueur, -2, 63, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel8).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTFDecimal, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, -2, 47, -2).addComponent(this.jLabel5)).addGap(16, 16, 16).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jCBType, 0, -1, 32767).addComponent(this.jTFNom, -1, 235, 32767)))).addContainerGap(18, 32767)));
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
/* 150 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFNom, -2, -1, -2).addComponent(this.jLabel5)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBType, -2, -1, -2).addComponent(this.jLabel4)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.jTFLongueur, -2, -1, -2).addComponent(this.jLabel8).addComponent(this.jTFDecimal, -2, -1, -2)).addContainerGap(39, 32767)));
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
/* 170 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 171 */     this.jBtAnnuler.setText("Annuler");
/* 172 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 174 */         FormeAjouterAttribut.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 177 */     });
/* 178 */     this.jBtOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ajouter.png")));
/* 179 */     this.jBtOK.setText("Ajouter");
/* 180 */     this.jBtOK.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 182 */         FormeAjouterAttribut.this.jBtOKActionPerformed(evt);
/*     */       }
/*     */       
/* 185 */     });
/* 186 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 187 */     getContentPane().setLayout(layout);
/* 188 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtOK))).addContainerGap()));
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
/* 200 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtOK).addComponent(this.jBtAnnuler)).addContainerGap(-1, 32767)));
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
/* 212 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtOKActionPerformed(java.awt.event.ActionEvent evt) {
/* 216 */     String verifSaisie = verifierSaisie();
/* 217 */     if (verifSaisie.length() == 0) {
/* 218 */       if (!Outil.Parametres.isMotReserve(this.jTFNom.getText())) {
/* 219 */         if (this.jTFLongueur.getText().trim().length() == 0) this.jTFLongueur.setText("0");
/* 220 */         if (this.jTFDecimal.getText().trim().length() == 0) this.jTFDecimal.setText("0");
/* 221 */         if (ajouterAttribut(this.jTFNom.getText().trim(), (String)this.jCBType.getSelectedItem(), Integer.parseInt(this.jTFLongueur.getText().trim()), Integer.parseInt(this.jTFDecimal.getText().trim()))) {
/* 222 */           this.frm.getProjetSel().getFormeMCD().setModifier(true);
/* 223 */           dispose();
/*     */         } else {
/* 225 */           javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : l'attribut existe déja dans la liste !! ");
/*     */         }
/*     */       } else {
/* 228 */         javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de l'attribut est un mot reservé !! ");
/*     */       }
/*     */     } else {
/* 231 */       javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : " + verifSaisie);
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 236 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeAjouterAttribut.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */