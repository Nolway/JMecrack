/*     */ package formes;
/*     */ 
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class FormeProprieteMCD extends javax.swing.JDialog
/*     */ {
/*     */   private ihm.Principale frm;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtRegleGestion;
/*     */   private javax.swing.JButton jBtValider;
/*     */   private javax.swing.JButton jBtVoir;
/*     */   private javax.swing.JCheckBox jCBverouiller;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JLabel jLabel5;
/*     */   private javax.swing.JLabel jLabel7;
/*     */   private javax.swing.JLabel jLabel8;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   
/*     */   public FormeProprieteMCD(ihm.Principale parent, boolean modal)
/*     */   {
/*  25 */     super(parent, modal);
/*  26 */     initComponents();
/*  27 */     setLocation(200, 50);
/*  28 */     this.frm = parent;
/*  29 */     remplirChamps();
/*  30 */     this.jBtAnnuler.setMnemonic(65);
/*  31 */     this.jBtValider.setMnemonic(10);
/*  32 */     this.jBtVoir.setMnemonic(86);
/*     */   }
/*     */   
/*     */   private String remplacerBalise(String st)
/*     */   {
/*  37 */     String s = st;
/*     */     
/*  39 */     s = s.replace("<H><Action>", "");
/*  40 */     s = s.replace("</Action><Dev>", "\t");
/*  41 */     s = s.replace("</Dev>", "");
/*  42 */     s = s.replace("<Date>", "\t");
/*  43 */     s = s.replace("</Date></H>", "\n");
/*  44 */     s = s.trim();
/*  45 */     return s;
/*     */   }
/*     */   
/*     */   private void remplirChamps() {
/*  49 */     this.jTFNom.setText(getNom(this.frm.getFormeMCD().getPage().getProprieteMCD().getNote()));
/*  50 */     this.jTFNBAfficher.setText(getNBAfficher(this.frm.getFormeMCD().getPage().getProprieteMCD().getNote()));
/*  51 */     setVerouiller(this.frm.getFormeMCD().getPage().getProprieteMCD().getNote());
/*  52 */     this.jTARegleGestion.setText(getRegle(this.frm.getFormeMCD().getPage().getProprieteMCD().getNote()));
/*  53 */     this.jTFEmplacement.setText(this.frm.getNomFichier());
/*  54 */     this.jTFCreateur.setText(this.frm.getFormeMCD().getPage().getProprieteMCD().getCreateur());
/*  55 */     this.jTFDeveloppeur.setText(this.frm.getFormeMCD().getPage().getProprieteMCD().getDeveloppeur());
/*  56 */     this.jTFDateCreation.setText(this.frm.getFormeMCD().getPage().getProprieteMCD().getDateCreation());
/*  57 */     this.jTFDateModification.setText(this.frm.getFormeMCD().getPage().getProprieteMCD().getDateDerniereUtilisation());
/*  58 */     this.jTACommentaire.setText(this.frm.getFormeMCD().getPage().getProprieteMCD().getCommentaire());
/*  59 */     this.jTAHistorique.setText(remplacerBalise(this.frm.getFormeMCD().getPage().getProprieteMCD().getHistorique()));
/*     */   }
/*     */   
/*     */   private String getNom(String s) {
/*  63 */     if ((s == null) || (s.length() == 0)) return "";
/*  64 */     if (s.indexOf("<action>") < 0) return "";
/*  65 */     if (s.indexOf("</action>") < 0) return "";
/*  66 */     if (s.indexOf("<nommcd>") < 0) return "";
/*  67 */     if (s.indexOf("</nommcd>") < 0) return "";
/*  68 */     s = s.substring(s.indexOf("<nommcd>") + 8, s.indexOf("</nommcd>"));
/*  69 */     return s;
/*     */   }
/*     */   
/*     */   private String getRegle(String s) {
/*  73 */     if ((s == null) || (s.length() == 0)) return "";
/*  74 */     if (s.indexOf("<regle>") < 0) return "";
/*  75 */     s = s.substring(s.indexOf("<regle>") + 7, s.length() - 8);
/*  76 */     return s;
/*     */   }
/*     */   
/*     */   private String getNBAfficher(String s) {
/*  80 */     if ((s == null) || (s.length() == 0)) return "";
/*  81 */     if (s.indexOf("<action>") < 0) return "";
/*  82 */     if (s.indexOf("</action>") < 0) return "";
/*  83 */     if (s.indexOf("<nbafficher>") < 0) return "";
/*  84 */     if (s.indexOf("</nbafficher>") < 0) return "";
/*  85 */     s = s.substring(s.indexOf("<nbafficher>") + 12, s.indexOf("</nbafficher>"));
/*  86 */     return s;
/*     */   }
/*     */   
/*     */   private String getVerouiller(String s) {
/*  90 */     if ((s == null) || (s.length() == 0)) return "";
/*  91 */     if (s.indexOf("<action>") < 0) return "";
/*  92 */     if (s.indexOf("</action>") < 0) return "";
/*  93 */     if (s.indexOf("<verouiller>") < 0) return "";
/*  94 */     if (s.indexOf("</verouiller>") < 0) return "";
/*  95 */     s = s.substring(s.indexOf("<verouiller>") + 12, s.indexOf("</verouiller>"));
/*  96 */     return s;
/*     */   }
/*     */   
/*     */   private boolean isInteger(String s) {
/* 100 */     if (s.trim().length() == 0) return true;
/*     */     try {
/* 102 */       Integer.parseInt(s);
/* 103 */       return true;
/*     */     } catch (Exception e) {}
/* 105 */     return false;
/*     */   }
/*     */   
/*     */   private String ecrireVerouiller()
/*     */   {
/* 110 */     if (this.jCBverouiller.isSelected()) return "True";
/* 111 */     return "False";
/*     */   }
/*     */   
/*     */   private void setVerouiller(String note) {
/* 115 */     String s = getVerouiller(note);
/* 116 */     if (s.length() == 0) {
/* 117 */       this.jCBverouiller.setSelected(false);
/* 118 */       return;
/*     */     }
/* 120 */     if (s.trim().toUpperCase().equals("TRUE")) {
/* 121 */       this.jCBverouiller.setSelected(true);
/* 122 */       return;
/*     */     }
/* 124 */     if (s.trim().toUpperCase().equals("FALSE")) {
/* 125 */       this.jCBverouiller.setSelected(false);
/* 126 */       return;
/*     */     }
/* 128 */     this.jCBverouiller.setSelected(false);
/*     */   }
/*     */   
/*     */   public String sauvegarderNode() {
/* 132 */     String nb = this.jTFNBAfficher.getText().trim();
/* 133 */     if ((nb.length() > 0) && 
/* 134 */       (!isInteger(nb.trim()))) { nb = "";
/*     */     }
/* 136 */     nb = nb.trim() + "";
/* 137 */     String s = "<action><nommcd>" + this.jTFNom.getText().trim() + "</nommcd>" + "<verouiller>" + ecrireVerouiller() + "</verouiller>" + "<nbafficher>" + nb + "</nbafficher></action>" + "<regle>" + this.jTARegleGestion.getText().trim() + "</regle>";
/*     */     
/*     */ 
/*     */ 
/* 141 */     return s;
/*     */   }
/*     */   
/*     */   private javax.swing.JPanel jPanel3;
/*     */   private javax.swing.JPanel jPanel4;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   private javax.swing.JScrollPane jScrollPane3;
/*     */   private javax.swing.JTextArea jTACommentaire;
/*     */   private javax.swing.JTextArea jTAHistorique;
/*     */   private javax.swing.JTextArea jTARegleGestion;
/*     */   
/* 153 */   private void initComponents() { this.jPanel1 = new javax.swing.JPanel();
/* 154 */     this.jLabel7 = new javax.swing.JLabel();
/* 155 */     this.jTFEmplacement = new javax.swing.JTextField();
/* 156 */     this.jCBverouiller = new javax.swing.JCheckBox();
/* 157 */     this.jLabel1 = new javax.swing.JLabel();
/* 158 */     this.jTFDateCreation = new javax.swing.JTextField();
/* 159 */     this.jLabel2 = new javax.swing.JLabel();
/* 160 */     this.jTFCreateur = new javax.swing.JTextField();
/* 161 */     this.jTFDateModification = new javax.swing.JTextField();
/* 162 */     this.jTFDeveloppeur = new javax.swing.JTextField();
/* 163 */     this.jLabel8 = new javax.swing.JLabel();
/* 164 */     this.jTFNBAfficher = new javax.swing.JTextField();
/* 165 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/* 166 */     this.jPanel4 = new javax.swing.JPanel();
/* 167 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 168 */     this.jTAHistorique = new javax.swing.JTextArea();
/* 169 */     this.jPanel2 = new javax.swing.JPanel();
/* 170 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/* 171 */     this.jTACommentaire = new javax.swing.JTextArea();
/* 172 */     this.jBtVoir = new javax.swing.JButton();
/* 173 */     this.jLabel4 = new javax.swing.JLabel();
/* 174 */     this.jPanel3 = new javax.swing.JPanel();
/* 175 */     this.jBtRegleGestion = new javax.swing.JButton();
/* 176 */     this.jScrollPane3 = new javax.swing.JScrollPane();
/* 177 */     this.jTARegleGestion = new javax.swing.JTextArea();
/* 178 */     this.jLabel3 = new javax.swing.JLabel();
/* 179 */     this.jLabel5 = new javax.swing.JLabel();
/* 180 */     this.jTFNom = new javax.swing.JTextField();
/* 181 */     this.jBtValider = new javax.swing.JButton();
/* 182 */     this.jBtAnnuler = new javax.swing.JButton();
/*     */     
/* 184 */     setDefaultCloseOperation(2);
/* 185 */     setTitle("Propriété du modèle");
/* 186 */     setResizable(false);
/*     */     
/* 188 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 190 */     this.jLabel7.setText("Emplacement");
/*     */     
/* 192 */     this.jTFEmplacement.setEditable(false);
/*     */     
/* 194 */     this.jCBverouiller.setText("Protection en écriture");
/* 195 */     this.jCBverouiller.setEnabled(false);
/*     */     
/* 197 */     this.jLabel1.setText("Création ");
/*     */     
/* 199 */     this.jTFDateCreation.setEditable(false);
/*     */     
/* 201 */     this.jLabel2.setText("Modification");
/*     */     
/* 203 */     this.jTFCreateur.setEditable(false);
/*     */     
/* 205 */     this.jTFDateModification.setEditable(false);
/*     */     
/* 207 */     this.jTFDeveloppeur.setEditable(false);
/*     */     
/* 209 */     this.jLabel8.setText("Nombre d'attribut affiché pour chaque entité ");
/*     */     
/* 211 */     this.jTAHistorique.setColumns(20);
/* 212 */     this.jTAHistorique.setEditable(false);
/* 213 */     this.jTAHistorique.setRows(5);
/* 214 */     this.jScrollPane1.setViewportView(this.jTAHistorique);
/*     */     
/* 216 */     javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(this.jPanel4);
/* 217 */     this.jPanel4.setLayout(jPanel4Layout);
/* 218 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 513, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 225 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 246, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 233 */     this.jTabbedPane1.addTab("Historique des modifications", this.jPanel4);
/*     */     
/* 235 */     this.jTACommentaire.setColumns(20);
/* 236 */     this.jTACommentaire.setRows(5);
/* 237 */     this.jScrollPane2.setViewportView(this.jTACommentaire);
/*     */     
/* 239 */     this.jBtVoir.setText("...");
/* 240 */     this.jBtVoir.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 242 */         FormeProprieteMCD.this.jBtVoirActionPerformed(evt);
/*     */       }
/*     */       
/* 245 */     });
/* 246 */     this.jLabel4.setText("Commentaire");
/*     */     
/* 248 */     javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this.jPanel2);
/* 249 */     this.jPanel2.setLayout(jPanel2Layout);
/* 250 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 513, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel4, -2, 86, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtVoir))).addContainerGap()));
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
/* 262 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jBtVoir, -2, 19, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -1, 216, 32767).addContainerGap()));
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
/* 274 */     this.jTabbedPane1.addTab("Commentaire ", this.jPanel2);
/*     */     
/* 276 */     this.jBtRegleGestion.setText("...");
/* 277 */     this.jBtRegleGestion.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 279 */         FormeProprieteMCD.this.jBtRegleGestionActionPerformed(evt);
/*     */       }
/*     */       
/* 282 */     });
/* 283 */     this.jTARegleGestion.setColumns(20);
/* 284 */     this.jTARegleGestion.setRows(5);
/* 285 */     this.jScrollPane3.setViewportView(this.jTARegleGestion);
/*     */     
/* 287 */     this.jLabel3.setText("Règles de gestion");
/*     */     
/* 289 */     javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(this.jPanel3);
/* 290 */     this.jPanel3.setLayout(jPanel3Layout);
/* 291 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 513, 32767).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel3, -2, 106, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtRegleGestion))).addContainerGap()));
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
/* 303 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jBtRegleGestion, -2, 19, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane3, -1, 216, 32767).addContainerGap()));
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
/* 315 */     this.jTabbedPane1.addTab("Règles de gestion", this.jPanel3);
/*     */     
/* 317 */     this.jLabel5.setText("Nom MCD");
/*     */     
/* 319 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/* 320 */     this.jPanel1.setLayout(jPanel1Layout);
/* 321 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel7).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel2, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel1, javax.swing.GroupLayout.Alignment.LEADING, -2, 74, -2)).addComponent(this.jLabel5)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jTFNom, -1, 460, 32767).addComponent(this.jTFEmplacement, javax.swing.GroupLayout.Alignment.TRAILING, -1, 460, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(this.jTFDateModification).addComponent(this.jTFDateCreation, -2, 109, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jTFCreateur, -1, 345, 32767).addComponent(this.jTFDeveloppeur, -1, 345, 32767))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jCBverouiller).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, 32767).addComponent(this.jLabel8).addGap(18, 18, 18).addComponent(this.jTFNBAfficher, -2, 58, -2))))).addContainerGap()));
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
/*     */ 
/*     */ 
/* 354 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jTFNom, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.jTFEmplacement, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFDateCreation, -2, -1, -2).addComponent(this.jTFCreateur, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTFDateModification, -2, -1, -2).addComponent(this.jTFDeveloppeur, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jCBverouiller).addComponent(this.jLabel8).addComponent(this.jTFNBAfficher, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -2, 296, -2).addContainerGap(-1, 32767)));
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
/* 385 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 386 */     this.jBtValider.setText("Valider");
/* 387 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 389 */         FormeProprieteMCD.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 392 */     });
/* 393 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 394 */     this.jBtAnnuler.setText("Annuler ");
/* 395 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 397 */         FormeProprieteMCD.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 400 */     });
/* 401 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 402 */     getContentPane().setLayout(layout);
/* 403 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 103, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider, -2, 98, -2))).addContainerGap()));
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
/* 415 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
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
/* 427 */     pack(); }
/*     */   
/*     */   private javax.swing.JTextField jTFCreateur;
/*     */   
/* 431 */   private void jBtValiderActionPerformed(java.awt.event.ActionEvent evt) { this.frm.getFormeMCD().getPage().getProprieteMCD().setNote(sauvegarderNode());
/* 432 */     this.frm.getFormeMCD().getPage().getProprieteMCD().setCommentaire(this.jTACommentaire.getText());
/* 433 */     this.frm.getProjetSel().getFormeMCD().setModifier(true);
/* 434 */     dispose(); }
/*     */   
/*     */   private javax.swing.JTextField jTFDateCreation;
/*     */   
/* 438 */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }
/*     */   
/*     */   private javax.swing.JTextField jTFDateModification;
/*     */   
/* 442 */   private void jBtVoirActionPerformed(java.awt.event.ActionEvent evt) { new FormeText(this.frm, true, this.jTACommentaire).setVisible(true); }
/*     */   
/*     */   private javax.swing.JTextField jTFDeveloppeur;
/*     */   
/* 446 */   private void jBtRegleGestionActionPerformed(java.awt.event.ActionEvent evt) { FormeText f = new FormeText(this.frm, true, this.jTARegleGestion);
/* 447 */     f.setTitle("Règles de gestion");
/* 448 */     f.setVisible(true);
/*     */   }
/*     */   
/*     */   private javax.swing.JTextField jTFEmplacement;
/*     */   private javax.swing.JTextField jTFNBAfficher;
/*     */   private javax.swing.JTextField jTFNom;
/*     */   private javax.swing.JTabbedPane jTabbedPane1;
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeProprieteMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */