/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmProjet;
/*     */ import Outil.ProprieteMCD;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.Principale;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ public class FormeText extends JDialog
/*     */ {
/*     */   Principale frm;
/*     */   private boolean accesPropriete;
/*     */   ProprieteMCD proprieteMCD;
/*     */   private JTextArea jtext;
/*     */   private boolean regleDegestion;
/*     */   IhmMCD2.ConfigurationMCD2 configurationMCD;
/*     */   private JButton jBtAnnuler;
/*     */   private JButton jBtValider;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private JTextArea jTANote;
/*     */   
/*     */   public FormeText(Principale frm, boolean modal, JTextArea jtext)
/*     */   {
/*  33 */     super(frm, modal);
/*  34 */     initComponents();
/*  35 */     this.frm = frm;
/*  36 */     setLocation(frm.getX() + 180, getY() + 70);
/*  37 */     setTitle("Notes MCD: " + frm.getProjetSel().toString());
/*  38 */     this.jtext = jtext;
/*  39 */     this.accesPropriete = true;
/*  40 */     this.regleDegestion = false;
/*  41 */     this.configurationMCD = null;
/*  42 */     initialisationChamp(jtext);
/*  43 */     this.jBtAnnuler.setMnemonic(65);
/*  44 */     this.jBtValider.setMnemonic(10);
/*     */   }
/*     */   
/*     */   public FormeText(Principale frm, boolean modal, ProprieteMCD proprieteMCD) {
/*  48 */     super(frm, modal);
/*  49 */     initComponents();
/*  50 */     this.frm = frm;
/*  51 */     setLocation(frm.getX() + 180, getY() + 70);
/*  52 */     setTitle("Notes MCD: " + frm.getProjetSel().toString());
/*  53 */     this.proprieteMCD = proprieteMCD;
/*  54 */     this.accesPropriete = false;
/*  55 */     this.regleDegestion = false;
/*  56 */     initialisationChamp(proprieteMCD);
/*  57 */     this.configurationMCD = null;
/*  58 */     this.jBtAnnuler.setMnemonic(65);
/*  59 */     this.jBtValider.setMnemonic(10);
/*     */   }
/*     */   
/*     */   public FormeText(Principale frm, boolean modal, ProprieteMCD proprieteMCD, boolean regleGestion) {
/*  63 */     super(frm, modal);
/*  64 */     initComponents();
/*  65 */     this.frm = frm;
/*  66 */     setLocation(frm.getX() + 180, getY() + 70);
/*  67 */     setTitle("Notes MCD: " + frm.getProjetSel().toString());
/*  68 */     this.proprieteMCD = proprieteMCD;
/*  69 */     this.accesPropriete = true;
/*  70 */     this.regleDegestion = true;
/*  71 */     initialisationChamp(proprieteMCD, "Regle");
/*  72 */     this.configurationMCD = null;
/*  73 */     this.jBtAnnuler.setMnemonic(65);
/*  74 */     this.jBtValider.setMnemonic(10);
/*     */   }
/*     */   
/*     */   public FormeText(Principale frm, boolean modal, IhmMCD2.ConfigurationMCD2 config, boolean regleGestion) {
/*  78 */     super(frm, modal);
/*  79 */     initComponents();
/*  80 */     this.frm = frm;
/*  81 */     setLocation(frm.getX() + 180, getY() + 70);
/*  82 */     setTitle("Commentaire MCD: " + frm.getProjetSel().toString());
/*  83 */     this.proprieteMCD = null;
/*  84 */     this.accesPropriete = false;
/*  85 */     this.regleDegestion = regleGestion;
/*     */     
/*  87 */     this.configurationMCD = config;
/*  88 */     if (!regleGestion) this.jTANote.setText(config.getCommentaire()); else
/*  89 */       this.jTANote.setText(config.regleGestion);
/*  90 */     this.jBtAnnuler.setMnemonic(65);
/*  91 */     this.jBtValider.setMnemonic(10);
/*     */   }
/*     */   
/*     */   private void initialisationChamp(JTextArea text) {
/*  95 */     this.jTANote.setText(text.getText());
/*     */   }
/*     */   
/*     */   private void initialisationChamp(ProprieteMCD p)
/*     */   {
/* 100 */     this.jTANote.setText(p.getCommentaire());
/*     */   }
/*     */   
/*     */   private void initialisationChamp(ProprieteMCD p, String regle) {
/* 104 */     if (p.getNote().trim().length() <= 0) p.setNote("<regle> </regle> <action> <nbafficher>  </nbafficher> </action>");
/* 105 */     this.jTANote.setText(Outil.Setting.valeurChamp("regle", p.note));
/*     */   }
/*     */   
/*     */   private void setData() {
/* 109 */     if (this.regleDegestion) {
/* 110 */       String s = this.proprieteMCD.getNote().substring(this.proprieteMCD.getNote().indexOf("<action>"), this.proprieteMCD.getNote().length());
/* 111 */       s = "<regle>" + this.jTANote.getText().trim() + "</regle>\n" + s;
/* 112 */       aGauche();
/* 113 */       this.proprieteMCD.setNote(s);
/* 114 */       this.frm.getFormeMCD().setModifier(true);
/*     */ 
/*     */     }
/* 117 */     else if (this.accesPropriete) {
/* 118 */       if (!this.jtext.getText().equals(this.jTANote.getText())) this.frm.getProjetSel().getFormeMCD().setModifier(true);
/* 119 */       this.jtext.setText(this.jTANote.getText());
/*     */     }
/*     */     else {
/* 122 */       if (!this.proprieteMCD.getCommentaire().equals(this.jTANote.getText())) this.frm.getProjetSel().getFormeMCD().setModifier(true);
/* 123 */       this.proprieteMCD.setCommentaire(this.jTANote.getText());
/*     */     }
/*     */   }
/*     */   
/*     */   public void aDroite()
/*     */   {
/* 129 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 130 */     getContentPane().setLayout(layout);
/* 131 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtValider, -2, 79, -2))).addContainerGap()));
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
/* 143 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
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
/*     */   public void aGauche()
/*     */   {
/* 157 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 158 */     getContentPane().setLayout(layout);
/* 159 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtValider, -2, 79, -2))).addContainerGap()));
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
/* 171 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
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
/* 196 */     this.jPanel1 = new javax.swing.JPanel();
/* 197 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 198 */     this.jTANote = new JTextArea();
/* 199 */     this.jLabel1 = new javax.swing.JLabel();
/* 200 */     this.jBtValider = new JButton();
/* 201 */     this.jBtAnnuler = new JButton();
/*     */     
/* 203 */     setDefaultCloseOperation(2);
/* 204 */     setTitle("Notes concernant");
/*     */     
/* 206 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 208 */     this.jTANote.setColumns(20);
/* 209 */     this.jTANote.setRows(5);
/* 210 */     this.jScrollPane1.setViewportView(this.jTANote);
/*     */     
/* 212 */     this.jLabel1.setText("Note ");
/*     */     
/* 214 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 215 */     this.jPanel1.setLayout(jPanel1Layout);
/* 216 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 773, 32767).addComponent(this.jLabel1)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 225 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 462, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 235 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 236 */     this.jBtValider.setText("OK");
/* 237 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 239 */         FormeText.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 242 */     });
/* 243 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 244 */     this.jBtAnnuler.setText("Annuler");
/* 245 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 247 */         FormeText.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 250 */     });
/* 251 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 252 */     getContentPane().setLayout(layout);
/* 253 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtValider, -2, 79, -2))).addContainerGap()));
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
/* 265 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
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
/* 277 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(ActionEvent evt) {
/* 281 */     if (this.configurationMCD != null) {
/* 282 */       if (!this.regleDegestion) {
/* 283 */         this.configurationMCD.Commentaire = this.jTANote.getText();
/* 284 */         this.frm.getFormeMCD().setModifier(true);
/* 285 */         dispose();
/*     */       } else {
/* 287 */         this.configurationMCD.regleGestion = this.jTANote.getText();
/* 288 */         this.frm.getFormeMCD().setModifier(true);
/* 289 */         dispose();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 295 */     setData();
/* 296 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(ActionEvent evt) {
/* 300 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeText.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */