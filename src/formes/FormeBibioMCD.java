/*     */ package formes;
/*     */ 
/*     */ import input.LoadMCD;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ 
/*     */ public class FormeBibioMCD extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   java.util.ArrayList<LoadMCD> listeMcd;
/*     */   LoadMCD mcdSelect;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JLabel jLabInfo;
/*     */   private JLabel jLabMCDSelect;
/*     */   private JLabel jLabNB;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JList jListMCD;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTextField jTFRecherche;
/*     */   
/*     */   public FormeBibioMCD(ihm.Principale frm, boolean modal)
/*     */   {
/*  34 */     super(frm, modal);
/*  35 */     this.frm = frm;
/*  36 */     this.mcdSelect = null;
/*     */     
/*  38 */     initComponents();
/*  39 */     this.frm = frm;
/*  40 */     this.mcdSelect = null;
/*  41 */     this.listeMcd = new java.util.ArrayList();
/*  42 */     this.jListMCD.setListData(this.listeMcd.toArray());
/*  43 */     setLocation(frm.getX() + 300, frm.getY() + 100);
/*     */   }
/*     */   
/*     */   public static String valueBalise(String s, String baliseDeb, String baliseFin)
/*     */   {
/*  48 */     int indexDebut = s.indexOf(baliseDeb) + baliseDeb.trim().length();
/*  49 */     int indexfin = s.indexOf(baliseFin.trim());
/*     */     
/*  51 */     return s.substring(indexDebut, indexfin);
/*     */   }
/*     */   
/*     */   public static LoadMCD stringToMCD(String s) {
/*  55 */     LoadMCD mcd = new LoadMCD("", "", "");
/*  56 */     mcd.setNom(valueBalise(s, "<nom>", "</nom>"));
/*  57 */     mcd.setUrl(valueBalise(s, "<url>", "</url>"));
/*  58 */     mcd.setId(valueBalise(s, "<id>", "</id>"));
/*  59 */     mcd.setNbLoad(valueBalise(s, "<nbload>", "</nbload>"));
/*  60 */     String img = mcd.getNom();
/*  61 */     img = img.replace(".mcd", ".jpg");
/*  62 */     mcd.setImage(img);
/*  63 */     return mcd;
/*     */   }
/*     */   
/*     */   public static String getMessage(String s) {
/*  67 */     return valueBalise(s, "<message>", "</message>");
/*     */   }
/*     */   
/*     */   public static String getBiblio(String s) {
/*  71 */     return valueBalise(s, "<biblio>", "</biblio>");
/*     */   }
/*     */   
/*     */   public void afficherMcdSelect() {
/*  75 */     if (this.mcdSelect == null) this.jLabMCDSelect.setText(""); else
/*  76 */       this.jLabMCDSelect.setText(this.mcdSelect.toString());
/*     */   }
/*     */   
/*     */   public static String effacerMCD(String s) {
/*  80 */     String ss = s.substring(0, s.indexOf("</mcd>") + 6);
/*  81 */     return s.replace(ss, "");
/*     */   }
/*     */   
/*     */   public String traiterInfo(String s)
/*     */   {
/*  86 */     String msg = getMessage(s);
/*  87 */     if (msg.trim().toUpperCase().equals("ER10")) {
/*  88 */       javax.swing.JOptionPane.showMessageDialog(this.frm, "ERREUR : Problème N°Sy2.0 Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*  89 */       this.frm.setDefaultCloseOperation(3);
/*  90 */       this.frm.dispose();
/*     */     }
/*  92 */     String biblio = getBiblio(s);
/*  93 */     biblio = biblio.trim();
/*  94 */     String mcd = "";
/*  95 */     while (biblio.length() > 0) {
/*  96 */       mcd = valueBalise(biblio, "<mcd>", "</mcd>");
/*  97 */       mcd = mcd.trim();
/*  98 */       this.listeMcd.add(stringToMCD(mcd));
/*  99 */       biblio = effacerMCD(biblio);
/* 100 */       biblio = biblio.trim();
/*     */     }
/* 102 */     return msg;
/*     */   }
/*     */   
/*     */   public String remplaceChar(String s)
/*     */   {
/* 107 */     String st = s;
/* 108 */     st = st.trim();
/* 109 */     st = st.replace(" ", "_");
/* 110 */     st = st.replace("\"", "_");
/* 111 */     st = st.replace("'", "_");
/* 112 */     st = st.replace("?", "_");
/* 113 */     st = st.replace("<", "_");
/* 114 */     st = st.replace(">", "_");
/* 115 */     st = st.replace("°", "_");
/* 116 */     st = st.replace("#", "_");
/* 117 */     st = st.replace("&", "_");
/* 118 */     st = st.replace("*", "_");
/* 119 */     st = st.replace(",", "_");
/* 120 */     st = st.replace(";", "_");
/* 121 */     st = st.replace(":", "_");
/* 122 */     st = st.replace("!", "_");
/*     */     
/* 124 */     st = st.replace("-", "_");
/* 125 */     st = st.replace("à", "_");
/* 126 */     st = st.replace("â", "_");
/* 127 */     st = st.replace("ä", "_");
/* 128 */     st = st.replace("Ä", "_");
/* 129 */     st = st.replace("Â", "_");
/*     */     
/* 131 */     st = st.replace("é", "_");
/* 132 */     st = st.replace("è", "_");
/* 133 */     st = st.replace("ê", "_");
/* 134 */     st = st.replace("ë", "_");
/* 135 */     st = st.replace("Ë", "_");
/* 136 */     st = st.replace("Ê", "_");
/*     */     
/* 138 */     st = st.replace("ô", "_");
/* 139 */     st = st.replace("Ô", "_");
/*     */     
/* 141 */     st = st.replace("ü", "_");
/* 142 */     st = st.replace("û", "_");
/* 143 */     st = st.replace("ù", "_");
/* 144 */     st = st.replace("Ü", "_");
/* 145 */     st = st.replace("Û", "_");
/*     */     
/* 147 */     st = st.replace("ç", "_");
/* 148 */     st = st.replace("(", "_");
/* 149 */     st = st.replace(")", "_");
/* 150 */     return st;
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
/* 165 */     this.jButton2 = new JButton();
/* 166 */     this.jPanel2 = new javax.swing.JPanel();
/* 167 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 168 */     this.jListMCD = new JList();
/* 169 */     this.jTFRecherche = new javax.swing.JTextField();
/* 170 */     this.jLabel2 = new JLabel();
/* 171 */     this.jButton1 = new JButton();
/* 172 */     this.jButton3 = new JButton();
/* 173 */     this.jLabel1 = new JLabel();
/* 174 */     this.jLabMCDSelect = new JLabel();
/* 175 */     this.jButton4 = new JButton();
/* 176 */     this.jLabInfo = new JLabel();
/* 177 */     this.jLabNB = new JLabel();
/*     */     
/* 179 */     setTitle("Bibiotheque MCD");
/* 180 */     setResizable(false);
/*     */     
/* 182 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 183 */     this.jButton2.setText("Fermer");
/* 184 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 186 */         FormeBibioMCD.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 189 */     });
/* 190 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 192 */     this.jListMCD.setBackground(new java.awt.Color(204, 255, 255));
/* 193 */     this.jListMCD.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mousePressed(java.awt.event.MouseEvent evt) {
/* 195 */         FormeBibioMCD.this.jListMCDMousePressed(evt);
/*     */       }
/* 197 */     });
/* 198 */     this.jListMCD.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/* 200 */         FormeBibioMCD.this.jListMCDKeyReleased(evt);
/*     */       }
/* 202 */     });
/* 203 */     this.jScrollPane1.setViewportView(this.jListMCD);
/*     */     
/* 205 */     this.jTFRecherche.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/* 207 */         FormeBibioMCD.this.jTFRechercheKeyReleased(evt);
/*     */       }
/*     */       
/* 210 */     });
/* 211 */     this.jLabel2.setText("Recherche mcd ");
/*     */     
/* 213 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/web.png")));
/* 214 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 216 */         FormeBibioMCD.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 219 */     });
/* 220 */     this.jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/about.png")));
/* 221 */     this.jButton3.setText("Description");
/* 222 */     this.jButton3.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 224 */         FormeBibioMCD.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */       
/* 227 */     });
/* 228 */     this.jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 229 */     this.jLabel1.setForeground(new java.awt.Color(255, 0, 0));
/* 230 */     this.jLabel1.setText(">>");
/*     */     
/* 232 */     this.jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/download16.png")));
/* 233 */     this.jButton4.setText("Télécharger");
/* 234 */     this.jButton4.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 236 */         FormeBibioMCD.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */       
/* 239 */     });
/* 240 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 241 */     this.jPanel2.setLayout(jPanel2Layout);
/* 242 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 765, 32767).addGroup(jPanel2Layout.createSequentialGroup().addGap(160, 160, 160).addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jTFRecherche, -1, 462, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 43, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabMCDSelect, -1, 471, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton3, -2, 123, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton4, -2, 133, -2))).addContainerGap()));
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
/* 265 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFRecherche, -2, 33, -2).addComponent(this.jButton1, -2, 33, -2).addComponent(this.jLabel2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 385, 32767).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabMCDSelect, -2, 22, -2)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton4).addComponent(this.jButton3))).addContainerGap()));
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
/* 286 */     this.jLabInfo.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 287 */     this.jLabInfo.setForeground(new java.awt.Color(0, 0, 102));
/* 288 */     this.jLabInfo.setText("Envoyez moi vos mcd par mail : jmerise@jfreesoft.com si vous voulez les partager");
/*     */     
/* 290 */     this.jLabNB.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 291 */     this.jLabNB.setText("0");
/*     */     
/* 293 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 294 */     getContentPane().setLayout(layout);
/* 295 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabNB, -2, 67, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabInfo, -1, 574, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton2, -2, 126, -2))).addContainerGap()));
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
/* 309 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabInfo, -2, 35, -2).addComponent(this.jButton2).addComponent(this.jLabNB, -2, 28, -2)).addContainerGap()));
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
/* 322 */     pack();
/*     */   }
/*     */   
/*     */   private void jListMCDMousePressed(java.awt.event.MouseEvent evt) {
/* 326 */     if (this.jListMCD.getSelectedIndex() >= 0) {
/* 327 */       this.mcdSelect = ((LoadMCD)this.listeMcd.get(this.jListMCD.getSelectedIndex()));
/*     */     } else {
/* 329 */       this.mcdSelect = null;
/*     */     }
/* 331 */     afficherMcdSelect();
/*     */   }
/*     */   
/*     */   private void jListMCDKeyReleased(java.awt.event.KeyEvent evt) {
/* 335 */     if (this.jListMCD.getSelectedIndex() >= 0) {
/* 336 */       this.mcdSelect = ((LoadMCD)this.listeMcd.get(this.jListMCD.getSelectedIndex()));
/*     */     } else {
/* 338 */       this.mcdSelect = null;
/*     */     }
/* 340 */     afficherMcdSelect();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 344 */     if (this.jTFRecherche.getText().length() > 1) {
/* 345 */       java.util.Date dDerUse = new java.util.Date();
/* 346 */       java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
/* 347 */       String s = input.InfoSite.dump("http://www.jfreesoft.com/foundmcd.php?m=" + remplaceChar(this.jTFRecherche.getText().trim()) + "&d=" + sdf.format(dDerUse));
/*     */       
/*     */ 
/* 350 */       if (s.length() > 10) {
/* 351 */         this.listeMcd.clear();
/* 352 */         this.jListMCD.removeAll();
/* 353 */         String msg = traiterInfo(s);
/* 354 */         if (msg.trim().toUpperCase().equals("ER10")) {
/* 355 */           javax.swing.JOptionPane.showMessageDialog(this.frm, "ERREUR : Problème N°Sy2.0 Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/* 356 */           this.frm.setDefaultCloseOperation(3);
/* 357 */           this.frm.dispose();
/*     */         }
/* 359 */         this.jLabNB.setText("" + this.listeMcd.size());
/* 360 */         this.jLabInfo.setText(msg);
/* 361 */         this.mcdSelect = null;
/* 362 */         afficherMcdSelect();
/*     */       }
/* 364 */       else if (s.trim().toUpperCase().equals("ERREURRM 2")) {
/* 365 */         javax.swing.JOptionPane.showMessageDialog(this, "Erreur de connexion \n Vérifiez votre connexion ou vos paramêtres proxy\n dans configuration -> parametres -> onglet réseau");
/*     */       }
/* 367 */       else if (s.trim().toUpperCase().equals("ERREURRM 1")) {
/* 368 */         javax.swing.JOptionPane.showMessageDialog(this, "Erreur de connexion \n Vérifiez votre connexion ou vos paramêtres proxy\n dans configuration -> parametres -> onglet réseau");
/*     */       }
/*     */       
/*     */ 
/* 372 */       this.jListMCD.setListData(this.listeMcd.toArray());
/*     */     } else {
/* 374 */       javax.swing.JOptionPane.showMessageDialog(this, "Le champ de recherche doit contenir au moins 2 caractères ");
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 379 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 383 */     if (this.mcdSelect != null) {
/* 384 */       if (!ihm.Principale.isActiverJMerise()) {
/* 385 */         javax.swing.JOptionPane.showMessageDialog(this.frm, "Il faut activer cette version pour télécharger les MCDs ! ");
/* 386 */         return;
/*     */       }
/* 388 */       new mythread.ThreadTelechargermcd(this.frm, this.mcdSelect.getUrl(), this.mcdSelect.getId()).execute();
/*     */     }
/*     */     else {
/* 391 */       javax.swing.JOptionPane.showMessageDialog(this.frm, "Aucun mcd n'est selectioné !!");
/*     */     }
/*     */   }
/*     */   
/*     */   private void jTFRechercheKeyReleased(java.awt.event.KeyEvent evt) {
/* 396 */     if ((evt.isControlDown()) && (evt.getKeyCode() == 10)) {
/* 397 */       if (this.jTFRecherche.getText().length() > 1) {
/* 398 */         java.util.Date dDerUse = new java.util.Date();
/* 399 */         java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
/* 400 */         String s = input.InfoSite.dump("http://www.jfreesoft.com/foundmcd.php?m=" + remplaceChar(this.jTFRecherche.getText().trim()) + "&d=" + sdf.format(dDerUse));
/*     */         
/*     */ 
/* 403 */         if (s.length() > 10) {
/* 404 */           this.listeMcd.clear();
/* 405 */           this.jListMCD.removeAll();
/* 406 */           String msg = traiterInfo(s);
/* 407 */           if (msg.trim().toUpperCase().equals("ER10")) {
/* 408 */             javax.swing.JOptionPane.showMessageDialog(this.frm, "ERREUR : Problème N°Sy2.0 Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/* 409 */             this.frm.setDefaultCloseOperation(3);
/* 410 */             this.frm.dispose();
/*     */           }
/* 412 */           this.jLabNB.setText("" + this.listeMcd.size());
/* 413 */           this.jLabInfo.setText(msg);
/* 414 */           this.mcdSelect = null;
/* 415 */           afficherMcdSelect();
/*     */         }
/* 417 */         else if (s.trim().toUpperCase().equals("ERREURRM 2")) {
/* 418 */           javax.swing.JOptionPane.showMessageDialog(this, "Erreur de connexion \n Vérifiez votre connexion ou vos paramêtres proxy\n dans configuration -> parametres -> onglet réseau");
/*     */         }
/* 420 */         else if (s.trim().toUpperCase().equals("ERREURRM 1")) {
/* 421 */           javax.swing.JOptionPane.showMessageDialog(this, "Erreur de connexion \n Vérifiez votre connexion ou vos paramêtres proxy\n dans configuration -> parametres -> onglet réseau");
/*     */         }
/*     */         
/*     */ 
/* 425 */         this.jListMCD.setListData(this.listeMcd.toArray());
/*     */       } else {
/* 427 */         javax.swing.JOptionPane.showMessageDialog(this, "Le champ de recherche doit contenir au moins 2 caractères ");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 433 */     if (this.mcdSelect != null) {
/* 434 */       new FormeDescriptionLoadMCD(this.frm, this.mcdSelect, true).setVisible(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeBibioMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */