/*      */ package formes;
/*      */ 
/*      */ import IhmMCD.IhmRelation;
/*      */ import Merise.Attribut;
/*      */ import Merise.Relation;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.util.ArrayList;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ 
/*      */ public class FormeEntite extends javax.swing.JDialog
/*      */ {
/*      */   private IhmMCD.IhmEntite entite;
/*      */   private IhmRelation relation;
/*      */   private ArrayList<Attribut> listeAtt;
/*      */   private Attribut attributSel;
/*      */   private ArrayList<IhmMCD.IhmEntiteRelation> listeEntiteRelation;
/*      */   private Merise.EntiteRelation entiteRela;
/*      */   private IhmMLD2.MLDEntite2 mldEntite;
/*      */   private ihm.Principale frm;
/*      */   private boolean modifier;
/*      */   private JButton jBtAnnuler;
/*      */   private JButton jBtCommAtt;
/*      */   private JButton jBtCreer;
/*      */   private JButton jBtDescendre;
/*      */   private JButton jBtDico;
/*      */   private JButton jBtDictionnaire;
/*      */   private JButton jBtModifier;
/*      */   private JButton jBtMonter;
/*      */   private JButton jBtOk;
/*      */   private JButton jBtSupprimer;
/*      */   private JButton jBtcommTable;
/*      */   private JComboBox jCBCle;
/*      */   private javax.swing.JCheckBox jCBNull;
/*      */   private JComboBox jCBType;
/*      */   
/*      */   public FormeEntite(ihm.Principale parent, boolean modal, int x, int y, IhmMCD.IhmEntite entite, ArrayList<IhmMCD.IhmEntiteRelation> listeEntite)
/*      */   {
/*   46 */     super(parent, modal);
/*   47 */     initComponents();
/*   48 */     this.frm = parent;
/*   49 */     setTitle("Propriété de l'entité");
/*   50 */     setLocation(300, 100);
/*   51 */     this.entite = entite;
/*   52 */     this.jTACommentaireEnt.setText(entite.getEntite().getCommentaire());
/*   53 */     this.relation = null;
/*   54 */     this.entiteRela = entite.getEntite();
/*   55 */     this.jTFNomEntRel.setText(entite.getEntite().getNom());
/*   56 */     this.listeAtt = creerListeAttribut(entite.getEntite().getListeAttributs());
/*   57 */     this.jListAttribut.setListData(this.listeAtt.toArray());
/*   58 */     this.listeEntiteRelation = listeEntite;
/*   59 */     this.attributSel = null;
/*   60 */     this.mldEntite = null;
/*   61 */     remplirType();
/*   62 */     this.modifier = false;
/*   63 */     this.jBtAnnuler.setMnemonic(65);
/*   64 */     this.jBtCreer.setMnemonic(67);
/*   65 */     this.jBtDescendre.setMnemonic(68);
/*   66 */     this.jBtModifier.setMnemonic(77);
/*   67 */     this.jBtMonter.setMnemonic(85);
/*   68 */     this.jBtOk.setMnemonic(10);
/*   69 */     this.jBtSupprimer.setMnemonic(83);
/*   70 */     this.jBtDico.setMnemonic(73);
/*   71 */     this.jTACommentaireEnt.getInputMap().put(javax.swing.KeyStroke.getKeyStroke(9, 0), "tab");
/*   72 */     this.jTACommentaire.getInputMap().put(javax.swing.KeyStroke.getKeyStroke(9, 0), "tab");
/*      */   }
/*      */   
/*      */   public FormeEntite(ihm.Principale parent, boolean modal, int x, int y, IhmRelation relation, ArrayList<IhmMCD.IhmEntiteRelation> listeRelation)
/*      */   {
/*   77 */     super(parent, modal);
/*   78 */     initComponents();
/*   79 */     setTitle("Propriétés de la relation");
/*   80 */     setLocation(300, 100);
/*   81 */     this.frm = parent;
/*   82 */     this.relation = relation;
/*   83 */     this.jTACommentaireEnt.setText(relation.getRelation().getCommentaire());
/*   84 */     this.entite = null;
/*   85 */     this.entiteRela = relation.getRelation();
/*   86 */     this.jTFNomEntRel.setText(relation.getRelation().getNom());
/*   87 */     this.listeAtt = creerListeAttribut(relation.getRelation().getListeAttributs());
/*   88 */     this.jListAttribut.setListData(this.listeAtt.toArray());
/*   89 */     this.listeEntiteRelation = listeRelation;
/*   90 */     this.attributSel = null;
/*   91 */     this.jCBCle.setEnabled(false);
/*   92 */     this.mldEntite = null;
/*   93 */     remplirType();
/*   94 */     this.modifier = false;
/*   95 */     this.jBtAnnuler.setMnemonic(65);
/*   96 */     this.jBtCreer.setMnemonic(67);
/*   97 */     this.jBtDescendre.setMnemonic(68);
/*   98 */     this.jBtModifier.setMnemonic(77);
/*   99 */     this.jBtMonter.setMnemonic(85);
/*  100 */     this.jBtOk.setMnemonic(10);
/*  101 */     this.jBtSupprimer.setMnemonic(83);
/*  102 */     this.jBtDico.setMnemonic(73);
/*  103 */     this.jTACommentaireEnt.getInputMap().put(javax.swing.KeyStroke.getKeyStroke(9, 0), "tab");
/*  104 */     this.jTACommentaire.getInputMap().put(javax.swing.KeyStroke.getKeyStroke(9, 0), "tab");
/*      */   }
/*      */   
/*      */   public FormeEntite(ihm.Principale parent, boolean modal, int x, int y, IhmMLD2.MLDEntite2 mldEntite) {
/*  108 */     super(parent, modal);
/*  109 */     initComponents();
/*  110 */     setTitle("Propriétés de l'entité");
/*  111 */     setLocation(300, 100);
/*  112 */     this.frm = parent;
/*  113 */     this.relation = null;
/*  114 */     this.entite = null;
/*  115 */     this.mldEntite = mldEntite;
/*  116 */     this.entiteRela = null;
/*  117 */     this.jBtDictionnaire.setEnabled(false);
/*  118 */     this.jTFNomEntRel.setText(mldEntite.getNom());
/*  119 */     this.jTFNomEntRel.setEditable(false);
/*  120 */     this.jTACommentaireEnt.setText(mldEntite.getCommentaire());
/*  121 */     this.jBtCreer.setEnabled(false);
/*  122 */     this.jBtSupprimer.setEnabled(false);
/*  123 */     this.jBtModifier.setEnabled(false);
/*  124 */     this.jBtOk.setVisible(false);
/*      */     
/*  126 */     this.listeAtt = creerListeAttribut(mldEntite == null ? null : mldEntite.getListeAttributs());
/*  127 */     this.jListAttribut.setListData(this.listeAtt.toArray());
/*  128 */     remplirType();
/*  129 */     this.modifier = false;
/*  130 */     this.attributSel = null;
/*  131 */     this.jCBCle.setEnabled(false);
/*  132 */     this.jBtOk.setMnemonic(10);
/*  133 */     this.jBtAnnuler.setMnemonic(65);
/*  134 */     this.jBtCreer.setMnemonic(67);
/*  135 */     this.jBtDescendre.setMnemonic(68);
/*  136 */     this.jBtModifier.setMnemonic(77);
/*  137 */     this.jBtMonter.setMnemonic(85);
/*  138 */     this.jBtSupprimer.setMnemonic(83);
/*  139 */     this.jBtDico.setMnemonic(73);
/*  140 */     this.jTACommentaireEnt.getInputMap().put(javax.swing.KeyStroke.getKeyStroke(9, 0), "tab");
/*  141 */     this.jTACommentaire.getInputMap().put(javax.swing.KeyStroke.getKeyStroke(9, 0), "tab");
/*      */   }
/*      */   
/*      */   public boolean uniqueAttributListe(String att, ArrayList<Attribut> liste) {
/*  145 */     for (int i = 0; i < liste.size(); i++) {
/*  146 */       if (att.trim().toUpperCase().equals(((Attribut)liste.get(i)).getNom().trim().toUpperCase())) return false;
/*      */     }
/*  148 */     return true;
/*      */   }
/*      */   
/*      */   public boolean uniqueAttribut(String att) {
/*  152 */     int n = this.frm.getFormeMCD().getPage().getListeEntiteRelation().size();
/*  153 */     for (int i = 0; i < n; i++) {
/*  154 */       if (((this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i) instanceof IhmMCD.IhmEntite)) && 
/*  155 */         (!uniqueAttributListe(att, ((IhmMCD.IhmEntite)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs()))) {
/*  156 */         return false;
/*      */       }
/*      */       
/*  159 */       if (((this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i) instanceof IhmRelation)) && 
/*  160 */         (!uniqueAttributListe(att, ((IhmRelation)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs()))) {
/*  161 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  165 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void remplirType()
/*      */   {
/*  172 */     this.jCBType.removeAllItems();
/*  173 */     this.jCBType.addItem("");
/*  174 */     for (int i = 0; i < this.frm.getPage().getListeDomaine().size(); i++) {
/*  175 */       this.jCBType.addItem(((Merise.Domaine)this.frm.getPage().getListeDomaine().get(i)).getNom());
/*      */     }
/*  177 */     if (this.frm.getPage().getListeDomaine().size() > 0) this.jCBType.addItem("");
/*  178 */     for (int i = 0; i < Outil.Parametres.DomaineDefini.length; i++) {
/*  179 */       if ((!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("ENUM")) && (!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("SET")))
/*  180 */         this.jCBType.addItem(Outil.Parametres.DomaineDefini[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> creerListeAttribut(ArrayList<Attribut> liste) {
/*  185 */     ArrayList<Attribut> li = new ArrayList();
/*  186 */     if (liste == null) return li;
/*  187 */     for (int i = 0; i < liste.size(); i++) {
/*  188 */       li.add(new Attribut(((Attribut)liste.get(i)).getNom(), ((Attribut)liste.get(i)).getType(), ((Attribut)liste.get(i)).getLongueur(), ((Attribut)liste.get(i)).getLongDecimale(), ((Attribut)liste.get(i)).getKey(), ((Attribut)liste.get(i)).isNulle(), ((Attribut)liste.get(i)).getCommentaire(), this.entiteRela));
/*      */     }
/*  190 */     return li;
/*      */   }
/*      */   
/*      */   private String verifierSaisie() {
/*  194 */     if (this.jTFNom.getText().trim().length() == 0) return "Nom ne doit pas être vide ";
/*  195 */     if (this.jCBType.getSelectedIndex() == 0) return "Aucun type n'a été désigné ";
/*  196 */     if (!estEntier(this.jTFLongueur.getText().trim())) return "La longueur n'est pas un entier";
/*  197 */     if (!estEntier(this.jTFDecimal.getText().trim())) { return "La longueur décimale n'est pas un entier";
/*      */     }
/*  199 */     return "";
/*      */   }
/*      */   
/*      */   private boolean existeNom(String nom) {
/*  203 */     for (int i = 0; i < this.listeAtt.size(); i++) {
/*  204 */       if (((Attribut)this.listeAtt.get(i)).getNom().equals(nom)) return true;
/*      */     }
/*  206 */     return false;
/*      */   }
/*      */   
/*      */   private boolean existeNomDiff(String nom) {
/*  210 */     for (int i = 0; i < this.listeAtt.size(); i++) {
/*  211 */       if ((!((Attribut)this.listeAtt.get(i)).equals(this.attributSel)) && 
/*  212 */         (((Attribut)this.listeAtt.get(i)).getNom().equals(nom))) { return true;
/*      */       }
/*      */     }
/*  215 */     return false;
/*      */   }
/*      */   
/*      */   private boolean estEntier(String ent) {
/*  219 */     if (ent.trim().length() == 0) return true;
/*      */     try {
/*  221 */       Integer.parseInt(ent);
/*  222 */       return true;
/*      */     } catch (Exception e) {}
/*  224 */     return false;
/*      */   }
/*      */   
/*      */   private int indexejCBType(String str)
/*      */   {
/*  229 */     for (int i = 0; i < this.jCBType.getModel().getSize(); i++) {
/*  230 */       this.jCBType.setSelectedIndex(i);
/*  231 */       if (((String)this.jCBType.getSelectedItem()).equals(str)) return i;
/*      */     }
/*  233 */     return 0;
/*      */   }
/*      */   
/*      */   private int indexejCBCle(String str) {
/*  237 */     for (int i = 0; i < this.jCBCle.getModel().getSize(); i++) {
/*  238 */       this.jCBCle.setSelectedIndex(i);
/*  239 */       if (((String)this.jCBCle.getSelectedItem()).equals(str)) return i;
/*      */     }
/*  241 */     return 0;
/*      */   }
/*      */   
/*      */   private void afficherAttributSel() {
/*  245 */     this.jTFNom.setText(this.attributSel.getNom());
/*  246 */     this.jTFLongueur.setText(this.attributSel.getLongueur() + "");
/*  247 */     this.jTFDecimal.setText(this.attributSel.getLongDecimale() + "");
/*  248 */     this.jCBType.setSelectedIndex(indexejCBType(this.attributSel.getType()));
/*  249 */     this.jCBCle.setSelectedIndex(indexejCBCle(this.attributSel.getKey()));
/*  250 */     this.jTACommentaire.setText(this.attributSel.getCommentaire());
/*  251 */     this.jCBNull.setSelected(this.attributSel.isNulle());
/*      */   }
/*      */   
/*      */   private void afficherAttributDic(Attribut att) {
/*  255 */     this.jTFNom.setText(att.getNom());
/*  256 */     this.jTFLongueur.setText(att.getLongueur() + "");
/*  257 */     this.jTFDecimal.setText(att.getLongDecimale() + "");
/*  258 */     this.jCBType.setSelectedIndex(indexejCBType(att.getType()));
/*  259 */     this.jCBCle.setSelectedIndex(indexejCBCle(att.getKey()));
/*  260 */     this.jTACommentaire.setText(att.getCommentaire());
/*  261 */     this.jCBNull.setSelected(att.isNulle());
/*      */   }
/*      */   
/*      */   private void supprimerListe(ArrayList<Attribut> liste) {
/*  265 */     int i = 0;
/*  266 */     while (i != liste.size()) {
/*  267 */       liste.remove(i);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean existeEntite(String nom) {
/*  272 */     for (int i = 0; i < this.listeEntiteRelation.size(); i++) {
/*  273 */       if ((((IhmMCD.IhmEntiteRelation)this.listeEntiteRelation.get(i)).getClass().getName().toString().equals("IhmMCD.IhmEntite")) && 
/*  274 */         ((IhmMCD.IhmEntite)this.listeEntiteRelation.get(i) != this.entite) && 
/*  275 */         (((IhmMCD.IhmEntite)this.listeEntiteRelation.get(i)).getEntite().getNom().trim().toUpperCase().equals(nom.trim().toUpperCase()))) {
/*  276 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  288 */     return false;
/*      */   }
/*      */   
/*      */   private boolean existeEntiteRelation(String nom) {
/*  292 */     return existeEntite(nom);
/*      */   }
/*      */   
/*      */   private String verifierNom() {
/*  296 */     if (this.jTFNomEntRel.getText().trim().length() == 0) return "ERREUR : Le champ nom doit être renseigné!!";
/*  297 */     return "";
/*      */   }
/*      */   
/*      */   private void supprimerAttributListe() {
/*  301 */     int[] att = this.jListAttribut.getSelectedIndices();
/*  302 */     if (att.length > 0) this.modifier = true;
/*  303 */     for (int i = att.length - 1; i >= 0; i--) {
/*  304 */       this.listeAtt.remove(att[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean verifierNomEntite() {
/*  309 */     if (this.entite.getEntite().getNom().trim().equals(this.jTFNom.getText().trim())) return true;
/*  310 */     return false;
/*      */   }
/*      */   
/*      */   private boolean verifierNomRelation() {
/*  314 */     if (this.relation.getRelation().getNom().trim().equals(this.jTFNom.getText().trim())) return true;
/*  315 */     return false;
/*      */   }
/*      */   
/*      */   public boolean accepterVide(String s)
/*      */   {
/*  320 */     if (this.listeAtt.size() > 0) return false;
/*  321 */     return true;
/*      */   }
/*      */   
/*      */   public boolean existeNomEntite(String s) {
/*  325 */     int n = this.frm.getFormeMCD().getPage().getListeEntiteRelation().size();
/*  326 */     for (int i = 0; i < n; i++) {
/*  327 */       if (((this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i) instanceof IhmMCD.IhmEntite)) && 
/*  328 */         (((IhmMCD.IhmEntite)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(s.trim().toUpperCase()))) {
/*  329 */         return true;
/*      */       }
/*      */     }
/*      */     
/*  333 */     return false;
/*      */   }
/*      */   
/*      */   private boolean existeEntiteRelationNonVide(String nom) {
/*  337 */     for (int i = 0; i < this.listeEntiteRelation.size(); i++) {
/*  338 */       if ((((IhmMCD.IhmEntiteRelation)this.listeEntiteRelation.get(i)).getClass().getName().toString().equals("IhmMCD.IhmEntite")) && 
/*  339 */         ((IhmMCD.IhmEntite)this.listeEntiteRelation.get(i) != this.entite) && 
/*  340 */         (((IhmMCD.IhmEntite)this.listeEntiteRelation.get(i)).getEntite().getNom().trim().toUpperCase().equals(nom.trim().toUpperCase()))) {
/*  341 */         return true;
/*      */       }
/*      */       
/*      */ 
/*  345 */       if ((((IhmMCD.IhmEntiteRelation)this.listeEntiteRelation.get(i)).getClass().getName().toString().equals("IhmMCD.IhmRelation")) && 
/*  346 */         (((IhmRelation)this.listeEntiteRelation.get(i)).getRelation().getNom().trim().length() > 0) && 
/*  347 */         ((IhmRelation)this.listeEntiteRelation.get(i) != this.relation) && 
/*  348 */         (((IhmRelation)this.listeEntiteRelation.get(i)).getRelation().getNom().trim().toUpperCase().equals(nom.trim().toUpperCase()))) {
/*  349 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  355 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel10;
/*      */   private JLabel jLabel2;
/*      */   private JLabel jLabel3;
/*      */   private JLabel jLabel4;
/*      */   private JLabel jLabel5;
/*      */   
/*      */   private void initComponents()
/*      */   {
/*  368 */     this.jPanel1 = new javax.swing.JPanel();
/*  369 */     this.jBtOk = new JButton();
/*  370 */     this.jBtAnnuler = new JButton();
/*  371 */     this.jPanel2 = new javax.swing.JPanel();
/*  372 */     this.jLabel1 = new JLabel();
/*  373 */     this.jTFNomEntRel = new JTextField();
/*  374 */     this.jScrollPane3 = new javax.swing.JScrollPane();
/*  375 */     this.jTACommentaireEnt = new JTextArea();
/*  376 */     this.jLabel2 = new JLabel();
/*  377 */     this.jBtcommTable = new JButton();
/*  378 */     this.jPanel3 = new javax.swing.JPanel();
/*  379 */     this.jPanel4 = new javax.swing.JPanel();
/*  380 */     this.jLabel4 = new JLabel();
/*  381 */     this.jCBType = new JComboBox();
/*  382 */     this.jLabel5 = new JLabel();
/*  383 */     this.jTFNom = new JTextField();
/*  384 */     this.jCBNull = new javax.swing.JCheckBox();
/*  385 */     this.jLabel6 = new JLabel();
/*  386 */     this.jTFLongueur = new JTextField();
/*  387 */     this.jLabel7 = new JLabel();
/*  388 */     this.jCBCle = new JComboBox();
/*  389 */     this.jLabel8 = new JLabel();
/*  390 */     this.jTFDecimal = new JTextField();
/*  391 */     this.jLabel9 = new JLabel();
/*  392 */     this.jBtCreer = new JButton();
/*  393 */     this.jLabel10 = new JLabel();
/*  394 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  395 */     this.jTACommentaire = new JTextArea();
/*  396 */     this.jBtModifier = new JButton();
/*  397 */     this.jBtCommAtt = new JButton();
/*  398 */     this.jLabel3 = new JLabel();
/*  399 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/*  400 */     this.jListAttribut = new javax.swing.JList();
/*  401 */     this.jBtSupprimer = new JButton();
/*  402 */     this.jBtDescendre = new JButton();
/*  403 */     this.jBtMonter = new JButton();
/*  404 */     this.jBtDico = new JButton();
/*  405 */     this.jBtDictionnaire = new JButton();
/*      */     
/*  407 */     setDefaultCloseOperation(2);
/*  408 */     setResizable(false);
/*      */     
/*  410 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
/*      */     
/*  412 */     this.jBtOk.setBackground(new java.awt.Color(255, 255, 255));
/*  413 */     this.jBtOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/*  414 */     this.jBtOk.setText("OK");
/*  415 */     this.jBtOk.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  417 */         FormeEntite.this.jBtOkActionPerformed(evt);
/*      */       }
/*      */       
/*  420 */     });
/*  421 */     this.jBtAnnuler.setBackground(new java.awt.Color(255, 255, 255));
/*  422 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/*  423 */     this.jBtAnnuler.setText("Annuler");
/*  424 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  426 */         FormeEntite.this.jBtAnnulerActionPerformed(evt);
/*      */       }
/*      */       
/*  429 */     });
/*  430 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  431 */     this.jPanel1.setLayout(jPanel1Layout);
/*  432 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(394, 32767).addComponent(this.jBtAnnuler, -2, 109, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtOk, -2, 96, -2).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  441 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtOk).addComponent(this.jBtAnnuler)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  451 */     this.jPanel2.setBackground(new java.awt.Color(153, 153, 153));
/*  452 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*      */     
/*  454 */     this.jLabel1.setText("Nom  ");
/*      */     
/*  456 */     this.jTACommentaireEnt.setColumns(10);
/*  457 */     this.jTACommentaireEnt.setRows(1);
/*  458 */     this.jTACommentaireEnt.addKeyListener(new java.awt.event.KeyAdapter() {
/*      */       public void keyPressed(java.awt.event.KeyEvent evt) {
/*  460 */         FormeEntite.this.jTACommentaireEntKeyPressed(evt);
/*      */       }
/*  462 */     });
/*  463 */     this.jScrollPane3.setViewportView(this.jTACommentaireEnt);
/*      */     
/*  465 */     this.jLabel2.setText("Commentaire ");
/*      */     
/*  467 */     this.jBtcommTable.setText("...");
/*  468 */     this.jBtcommTable.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  470 */         FormeEntite.this.jBtcommTableActionPerformed(evt);
/*      */       }
/*      */       
/*  473 */     });
/*  474 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  475 */     this.jPanel2.setLayout(jPanel2Layout);
/*  476 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel2).addComponent(this.jLabel1, -2, 38, -2).addComponent(this.jBtcommTable)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 511, 32767).addComponent(this.jTFNomEntRel, -1, 511, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  490 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFNomEntRel, -2, 30, -2).addComponent(this.jLabel1)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtcommTable, -2, 19, -2)).addComponent(this.jScrollPane3, -1, 59, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  507 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*      */     
/*  509 */     this.jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));
/*      */     
/*  511 */     this.jLabel4.setText("type :");
/*      */     
/*  513 */     this.jCBType.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  514 */     this.jCBType.setForeground(new java.awt.Color(0, 0, 153));
/*  515 */     this.jCBType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Auto_increment", "Varchar", "Char", "Bool", "Date", "Int", "Float", "Money", "BigInt", "Blob", "Datetime", "Decimal", "Double", "Double Precision", "Longblob", "Longtext", "Mediumblob", "Mediumint", "Mediumtext", "Numeric", "Real", "Smallint", "Text", "Time", "TimeStamp", "TinyBlob", "TinyINT", "TinyText", "Year" }));
/*      */     
/*  517 */     this.jLabel5.setText("Nom :");
/*      */     
/*  519 */     this.jCBNull.setSelected(true);
/*      */     
/*  521 */     this.jLabel6.setText("Taille :");
/*      */     
/*  523 */     this.jTFLongueur.setText("25");
/*      */     
/*  525 */     this.jLabel7.setText("Clés :");
/*      */     
/*  527 */     this.jCBCle.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  528 */     this.jCBCle.setForeground(new java.awt.Color(0, 0, 153));
/*  529 */     this.jCBCle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "PRIMARY KEY", "UNIQUE", "INDEX" }));
/*      */     
/*  531 */     this.jLabel8.setText(",");
/*      */     
/*  533 */     this.jTFDecimal.setText("0");
/*      */     
/*  535 */     this.jLabel9.setText("Null :");
/*      */     
/*  537 */     this.jBtCreer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ajouter.png")));
/*  538 */     this.jBtCreer.setText("Créer");
/*  539 */     this.jBtCreer.setToolTipText("Créer un attribut");
/*  540 */     this.jBtCreer.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  542 */         FormeEntite.this.jBtCreerActionPerformed(evt);
/*      */       }
/*      */       
/*  545 */     });
/*  546 */     this.jLabel10.setText("Commentaire ");
/*      */     
/*  548 */     this.jTACommentaire.setColumns(10);
/*  549 */     this.jTACommentaire.setRows(1);
/*  550 */     this.jTACommentaire.addKeyListener(new java.awt.event.KeyAdapter() {
/*      */       public void keyPressed(java.awt.event.KeyEvent evt) {
/*  552 */         FormeEntite.this.jTACommentaireKeyPressed(evt);
/*      */       }
/*  554 */     });
/*  555 */     this.jScrollPane1.setViewportView(this.jTACommentaire);
/*      */     
/*  557 */     this.jBtModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/modifier.png")));
/*  558 */     this.jBtModifier.setText("Modifier");
/*  559 */     this.jBtModifier.setToolTipText("Modifier l'attribut selectionné");
/*  560 */     this.jBtModifier.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  562 */         FormeEntite.this.jBtModifierActionPerformed(evt);
/*      */       }
/*      */       
/*  565 */     });
/*  566 */     this.jBtCommAtt.setText("...");
/*  567 */     this.jBtCommAtt.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  569 */         FormeEntite.this.jBtCommAttActionPerformed(evt);
/*      */       }
/*      */       
/*  572 */     });
/*  573 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  574 */     this.jPanel4.setLayout(jPanel4Layout);
/*  575 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 282, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup().addComponent(this.jLabel6).addGap(18, 18, 18).addComponent(this.jTFLongueur, -2, 63, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel8).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTFDecimal, -2, 50, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel10, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup().addComponent(this.jLabel9).addGap(39, 39, 39).addComponent(this.jCBNull))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtCommAtt)).addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup().addComponent(this.jLabel7, -2, 47, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCBCle, 0, 231, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jBtModifier).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtCreer, -2, 90, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addComponent(this.jLabel4, -2, 47, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBType, 0, 231, 32767).addComponent(this.jTFNom, -1, 231, 32767)))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  616 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFNom, -2, -1, -2).addComponent(this.jLabel5)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBType, -2, -1, -2).addComponent(this.jLabel4)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.jTFLongueur, -2, -1, -2).addComponent(this.jLabel8).addComponent(this.jTFDecimal, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.jCBCle, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBNull).addComponent(this.jLabel9)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.jBtCommAtt, -2, 19, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 73, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtCreer).addComponent(this.jBtModifier)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  654 */     this.jLabel3.setText("Liste d'attributs :");
/*      */     
/*  656 */     this.jListAttribut.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseReleased(java.awt.event.MouseEvent evt) {
/*  658 */         FormeEntite.this.jListAttributMouseReleased(evt);
/*      */       }
/*  660 */     });
/*  661 */     this.jScrollPane2.setViewportView(this.jListAttribut);
/*      */     
/*  663 */     this.jBtSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/supprimer.png")));
/*  664 */     this.jBtSupprimer.setText("Supprimer");
/*  665 */     this.jBtSupprimer.setToolTipText("Supprimer la selection d'attribut");
/*  666 */     this.jBtSupprimer.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  668 */         FormeEntite.this.jBtSupprimerActionPerformed(evt);
/*      */       }
/*      */       
/*  671 */     });
/*  672 */     this.jBtDescendre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/descendre.png")));
/*  673 */     this.jBtDescendre.setToolTipText("Descendre attribut");
/*  674 */     this.jBtDescendre.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  676 */         FormeEntite.this.jBtDescendreActionPerformed(evt);
/*      */       }
/*      */       
/*  679 */     });
/*  680 */     this.jBtMonter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/monter.png")));
/*  681 */     this.jBtMonter.setToolTipText("Monter attribut");
/*  682 */     this.jBtMonter.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  684 */         FormeEntite.this.jBtMonterActionPerformed(evt);
/*      */       }
/*      */       
/*  687 */     });
/*  688 */     this.jBtDico.setForeground(new java.awt.Color(255, 0, 0));
/*  689 */     this.jBtDico.setText("Dictionnaire de données");
/*  690 */     this.jBtDico.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  692 */         FormeEntite.this.jBtDicoActionPerformed(evt);
/*      */       }
/*      */       
/*  695 */     });
/*  696 */     this.jBtDictionnaire.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  697 */     this.jBtDictionnaire.setForeground(new java.awt.Color(0, 51, 204));
/*  698 */     this.jBtDictionnaire.setText("Importer Attributs");
/*  699 */     this.jBtDictionnaire.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  701 */         FormeEntite.this.jBtDictionnaireActionPerformed(evt);
/*      */       }
/*      */       
/*  704 */     });
/*  705 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  706 */     this.jPanel3.setLayout(jPanel3Layout);
/*  707 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jBtDico, GroupLayout.Alignment.TRAILING, -1, 304, 32767).addComponent(this.jPanel4, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane2, -2, 281, -2).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jBtMonter).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtDescendre).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jBtSupprimer))).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addComponent(this.jLabel3, -2, 112, -2).addGap(18, 18, 18).addComponent(this.jBtDictionnaire, -2, 145, -2))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  730 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtDico).addComponent(this.jBtDictionnaire).addComponent(this.jLabel3)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jScrollPane2, -1, 269, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jBtSupprimer).addComponent(this.jBtMonter).addComponent(this.jBtDescendre))).addComponent(this.jPanel4, -1, -1, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  751 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  752 */     getContentPane().setLayout(layout);
/*  753 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  763 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  775 */     pack(); }
/*      */   
/*      */   private JLabel jLabel6;
/*      */   
/*  779 */   private void jBtOkActionPerformed(ActionEvent evt) { if (this.entite != null) {
/*  780 */       if (verifierNom().trim().length() == 0) {
/*  781 */         if (!existeEntiteRelation(this.jTFNomEntRel.getText().trim())) {
/*  782 */           this.entite.getEntite().setNom(this.jTFNomEntRel.getText());
/*  783 */           this.entite.getEntite().setCommentaire(this.jTACommentaireEnt.getText());
/*  784 */           supprimerListe(this.entite.getEntite().getListeAttributs());
/*  785 */           this.entite.getEntite().setListeAttributs(this.listeAtt);
/*  786 */           if (!this.modifier) this.modifier = verifierNomEntite();
/*  787 */           this.frm.getFormeMCD().setModifier(this.modifier);
/*  788 */           dispose();
/*      */         } else {
/*  790 */           javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de l'entité existe deja !!! ");
/*      */         }
/*      */       } else {
/*  793 */         javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de l'entité doit être renseigné !!! ");
/*      */       }
/*      */     }
/*  796 */     if (this.relation != null)
/*  797 */       if (!Outil.Setting.videNomAss) {
/*  798 */         if (Outil.Setting.redondNomAss) {
/*  799 */           if (verifierNom().trim().length() == 0) {
/*  800 */             if (existeEntiteRelation(this.jTFNomEntRel.getText().trim())) {
/*  801 */               this.relation.getRelation().setNom(this.jTFNomEntRel.getText());
/*  802 */               this.relation.getRelation().setCommentaire(this.jTACommentaireEnt.getText());
/*  803 */               supprimerListe(this.relation.getRelation().getListeAttributs());
/*  804 */               this.relation.getRelation().setListeAttributs(this.listeAtt);
/*  805 */               if (!this.modifier) this.modifier = verifierNomRelation();
/*  806 */               this.frm.getFormeMCD().setModifier(this.modifier);
/*  807 */               dispose();
/*      */             } else {
/*  809 */               javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de la relation existe deja 1!!! ");
/*      */             }
/*      */           } else {
/*  812 */             javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de la relation doit être renseigné 2!!! ");
/*      */           }
/*      */         }
/*  815 */         else if (!existeEntite(this.jTFNomEntRel.getText().trim())) {
/*  816 */           this.relation.getRelation().setNom(this.jTFNomEntRel.getText());
/*  817 */           this.relation.getRelation().setCommentaire(this.jTACommentaireEnt.getText());
/*  818 */           supprimerListe(this.relation.getRelation().getListeAttributs());
/*  819 */           this.relation.getRelation().setListeAttributs(this.listeAtt);
/*  820 */           if (!this.modifier) this.modifier = verifierNomRelation();
/*  821 */           this.frm.getFormeMCD().setModifier(this.modifier);
/*  822 */           dispose();
/*      */         } else {
/*  824 */           javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de la relation existe deja 3!!! ");
/*      */         }
/*      */         
/*      */       }
/*  828 */       else if (this.jTFNomEntRel.getText().trim().length() == 0) {
/*  829 */         if (accepterVide(this.jTFNomEntRel.getText())) {
/*  830 */           this.relation.getRelation().setNom(this.jTFNomEntRel.getText());
/*  831 */           this.relation.getRelation().setCommentaire(this.jTACommentaireEnt.getText());
/*  832 */           supprimerListe(this.relation.getRelation().getListeAttributs());
/*  833 */           this.relation.getRelation().setListeAttributs(this.listeAtt);
/*  834 */           if (!this.modifier) this.modifier = verifierNomRelation();
/*  835 */           this.relation.getRelation().setNom("    ");
/*  836 */           this.frm.getFormeMCD().setModifier(this.modifier);
/*  837 */           dispose();
/*      */         } else {
/*  839 */           javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de la relation doit être renseigné 4!!! ");
/*      */         }
/*      */       }
/*  842 */       else if (Outil.Setting.redondNomAss) {
/*  843 */         if (!existeEntite(this.jTFNomEntRel.getText().trim())) {
/*  844 */           this.relation.getRelation().setNom(this.jTFNomEntRel.getText());
/*  845 */           this.relation.getRelation().setCommentaire(this.jTACommentaireEnt.getText());
/*  846 */           supprimerListe(this.relation.getRelation().getListeAttributs());
/*  847 */           this.relation.getRelation().setListeAttributs(this.listeAtt);
/*  848 */           if (!this.modifier) this.modifier = verifierNomRelation();
/*  849 */           this.frm.getFormeMCD().setModifier(this.modifier);
/*  850 */           dispose();
/*      */         } else {
/*  852 */           javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de la relation existe deja 5!!! ");
/*      */         }
/*      */       }
/*  855 */       else if (!existeEntiteRelationNonVide(this.jTFNomEntRel.getText().trim())) {
/*  856 */         this.relation.getRelation().setNom(this.jTFNomEntRel.getText());
/*  857 */         this.relation.getRelation().setCommentaire(this.jTACommentaireEnt.getText());
/*  858 */         supprimerListe(this.relation.getRelation().getListeAttributs());
/*  859 */         this.relation.getRelation().setListeAttributs(this.listeAtt);
/*  860 */         if (!this.modifier) this.modifier = verifierNomRelation();
/*  861 */         this.frm.getFormeMCD().setModifier(this.modifier);
/*  862 */         dispose();
/*      */       } else {
/*  864 */         javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de la relation existe deja 6!!! ");
/*      */       } }
/*      */   
/*      */   private JLabel jLabel7;
/*      */   private JLabel jLabel8;
/*      */   private JLabel jLabel9;
/*      */   private javax.swing.JList jListAttribut;
/*      */   private javax.swing.JPanel jPanel1;
/*      */   private javax.swing.JPanel jPanel2;
/*      */   
/*  874 */   private void jBtAnnulerActionPerformed(ActionEvent evt) { dispose(); }
/*      */   
/*      */   private javax.swing.JPanel jPanel3;
/*      */   
/*  878 */   private void jListAttributMouseReleased(java.awt.event.MouseEvent evt) { if (this.jListAttribut.getSelectedIndex() >= 0) {
/*  879 */       this.attributSel = ((Attribut)this.listeAtt.get(this.jListAttribut.getSelectedIndex()));
/*  880 */       if (this.attributSel != null) afficherAttributSel(); } }
/*      */   
/*      */   private javax.swing.JPanel jPanel4;
/*      */   private javax.swing.JScrollPane jScrollPane1;
/*      */   
/*  885 */   private void jBtCreerActionPerformed(ActionEvent evt) { String verifSaisie = verifierSaisie();
/*  886 */     if (verifSaisie.length() == 0) {
/*  887 */       if (!existeNom(this.jTFNom.getText().trim())) {
/*  888 */         if (!Outil.Parametres.isMotReserve(this.jTFNom.getText())) {
/*  889 */           if (!Outil.Setting.attUniq) {
/*  890 */             if (this.jTFLongueur.getText().trim().length() == 0) this.jTFLongueur.setText("0");
/*  891 */             if (this.jTFDecimal.getText().trim().length() == 0) this.jTFDecimal.setText("0");
/*  892 */             this.listeAtt.add(new Attribut(this.jTFNom.getText().trim(), (String)this.jCBType.getSelectedItem(), Integer.parseInt(this.jTFLongueur.getText().trim()), Integer.parseInt(this.jTFDecimal.getText().trim()), (String)this.jCBCle.getSelectedItem(), this.jCBNull.isSelected(), this.jTACommentaire.getText(), this.entiteRela));
/*      */             
/*  894 */             this.frm.getPage().ajouterAttribut(this.jTFNom.getText().trim(), (String)this.jCBType.getSelectedItem(), Integer.parseInt(this.jTFLongueur.getText().trim()), Integer.parseInt(this.jTFDecimal.getText().trim()));
/*  895 */             this.jListAttribut.setListData(this.listeAtt.toArray());
/*  896 */             this.jTFNom.setText("");
/*  897 */             this.jCBNull.setSelected(true);
/*  898 */             this.jCBType.setSelectedIndex(0);
/*  899 */             this.jTFLongueur.setText("25");
/*  900 */             this.jTFDecimal.setText("0");
/*  901 */             this.jCBCle.setSelectedIndex(0);
/*  902 */             this.jTACommentaire.setText("");
/*  903 */             this.modifier = true;
/*      */ 
/*      */           }
/*  906 */           else if (uniqueAttribut(this.jTFNom.getText().trim())) {
/*  907 */             if (this.jTFLongueur.getText().trim().length() == 0) this.jTFLongueur.setText("0");
/*  908 */             if (this.jTFDecimal.getText().trim().length() == 0) this.jTFDecimal.setText("0");
/*  909 */             this.listeAtt.add(new Attribut(this.jTFNom.getText().trim(), (String)this.jCBType.getSelectedItem(), Integer.parseInt(this.jTFLongueur.getText().trim()), Integer.parseInt(this.jTFDecimal.getText().trim()), (String)this.jCBCle.getSelectedItem(), this.jCBNull.isSelected(), this.jTACommentaire.getText(), this.entiteRela));
/*      */             
/*  911 */             this.frm.getPage().ajouterAttribut(this.jTFNom.getText().trim(), (String)this.jCBType.getSelectedItem(), Integer.parseInt(this.jTFLongueur.getText().trim()), Integer.parseInt(this.jTFDecimal.getText().trim()));
/*  912 */             this.jListAttribut.setListData(this.listeAtt.toArray());
/*  913 */             this.jTFNom.setText("");
/*  914 */             this.jCBNull.setSelected(true);
/*  915 */             this.jCBType.setSelectedIndex(0);
/*  916 */             this.jTFLongueur.setText("25");
/*  917 */             this.jTFDecimal.setText("0");
/*  918 */             this.jCBCle.setSelectedIndex(0);
/*  919 */             this.jTACommentaire.setText("");
/*  920 */             this.modifier = true;
/*      */           } else {
/*  922 */             javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de l'attribut n'est pas unique dans le MCD !! ");
/*      */           }
/*      */         }
/*      */         else {
/*  926 */           javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de l'attribut est un mot reservé !! ");
/*      */         }
/*      */       } else {
/*  929 */         javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de l'attribut existe deja dans la liste des attributs ");
/*      */       }
/*      */     } else
/*  932 */       javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : " + verifSaisie);
/*      */   }
/*      */   
/*      */   private javax.swing.JScrollPane jScrollPane2;
/*      */   private javax.swing.JScrollPane jScrollPane3;
/*  937 */   private void jBtModifierActionPerformed(ActionEvent evt) { String verifSaisie = verifierSaisie();
/*  938 */     if (verifSaisie.length() == 0) {
/*  939 */       if (!existeNomDiff(this.jTFNom.getText().trim())) {
/*  940 */         if (!Outil.Setting.attUniq) {
/*  941 */           if (this.jTFLongueur.getText().trim().length() == 0) this.jTFLongueur.setText("0");
/*  942 */           if (this.jTFDecimal.getText().trim().length() == 0) this.jTFDecimal.setText("0");
/*  943 */           this.attributSel.setNom(this.jTFNom.getText().trim());
/*  944 */           this.attributSel.setType((String)this.jCBType.getSelectedItem());
/*  945 */           this.attributSel.setLongueur(Integer.parseInt(this.jTFLongueur.getText().trim()));
/*  946 */           this.attributSel.setLongDecimale(Integer.parseInt(this.jTFDecimal.getText().trim()));
/*  947 */           this.attributSel.setNulle(this.jCBNull.isSelected());
/*  948 */           this.attributSel.setCommentaire(this.jTACommentaire.getText());
/*  949 */           this.attributSel.setKey((String)this.jCBCle.getSelectedItem());
/*  950 */           this.jListAttribut.setListData(this.listeAtt.toArray());
/*  951 */           this.jTFNom.setText("");
/*  952 */           this.jCBNull.setSelected(true);
/*  953 */           this.jCBType.setSelectedIndex(0);
/*  954 */           this.jTFLongueur.setText("25");
/*  955 */           this.jTFDecimal.setText("2");
/*  956 */           this.jCBCle.setSelectedIndex(0);
/*  957 */           this.jTACommentaire.setText("");
/*  958 */           this.modifier = true;
/*      */ 
/*      */         }
/*  961 */         else if (uniqueAttribut(this.jTFNom.getText().trim())) {
/*  962 */           if (this.jTFLongueur.getText().trim().length() == 0) this.jTFLongueur.setText("0");
/*  963 */           if (this.jTFDecimal.getText().trim().length() == 0) this.jTFDecimal.setText("0");
/*  964 */           this.attributSel.setNom(this.jTFNom.getText().trim());
/*  965 */           this.attributSel.setType((String)this.jCBType.getSelectedItem());
/*  966 */           this.attributSel.setLongueur(Integer.parseInt(this.jTFLongueur.getText().trim()));
/*  967 */           this.attributSel.setLongDecimale(Integer.parseInt(this.jTFDecimal.getText().trim()));
/*  968 */           this.attributSel.setNulle(this.jCBNull.isSelected());
/*  969 */           this.attributSel.setCommentaire(this.jTACommentaire.getText());
/*  970 */           this.attributSel.setKey((String)this.jCBCle.getSelectedItem());
/*  971 */           this.jListAttribut.setListData(this.listeAtt.toArray());
/*  972 */           this.jTFNom.setText("");
/*  973 */           this.jCBNull.setSelected(true);
/*  974 */           this.jCBType.setSelectedIndex(0);
/*  975 */           this.jTFLongueur.setText("25");
/*  976 */           this.jTFDecimal.setText("2");
/*  977 */           this.jCBCle.setSelectedIndex(0);
/*  978 */           this.jTACommentaire.setText("");
/*  979 */           this.modifier = true;
/*  980 */           javax.swing.JOptionPane.showMessageDialog(this, "L'attribut a été modifié avec succès !!! ");
/*      */         } else {
/*  982 */           javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de l'attribut n'est pas unique dans le MCD !! ");
/*      */         }
/*      */       }
/*      */       else {
/*  986 */         javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom de l'attribut existe deja dans la liste des attributs ");
/*      */       }
/*      */     } else {
/*  989 */       javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : " + verifSaisie);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jBtSupprimerActionPerformed(ActionEvent evt) {
/*  994 */     supprimerAttributListe();
/*  995 */     this.jListAttribut.setListData(this.listeAtt.toArray());
/*      */   }
/*      */   
/*      */   private void jBtMonterActionPerformed(ActionEvent evt)
/*      */   {
/* 1000 */     if (this.jListAttribut.getSelectedValue() != null) {
/* 1001 */       Attribut attSel = (Attribut)this.jListAttribut.getSelectedValue();
/* 1002 */       int ind = this.jListAttribut.getSelectedIndex();
/* 1003 */       if (ind > 0) {
/* 1004 */         Attribut attr = (Attribut)this.listeAtt.get(ind - 1);
/* 1005 */         this.listeAtt.set(ind - 1, attSel);
/* 1006 */         this.listeAtt.set(ind, attr);
/* 1007 */         this.jListAttribut.setSelectedIndex(ind - 1);
/* 1008 */         this.jListAttribut.setListData(this.listeAtt.toArray());
/* 1009 */         this.jListAttribut.setSelectedIndex(ind - 1);
/* 1010 */         this.modifier = true; } } }
/*      */   
/*      */   private JTextArea jTACommentaire;
/*      */   private JTextArea jTACommentaireEnt;
/*      */   private JTextField jTFDecimal;
/*      */   private JTextField jTFLongueur;
/*      */   private JTextField jTFNom;
/*      */   private JTextField jTFNomEntRel;
/* 1018 */   private void jBtDescendreActionPerformed(ActionEvent evt) { if (this.jListAttribut.getSelectedValue() != null) {
/* 1019 */       Attribut attSel = (Attribut)this.jListAttribut.getSelectedValue();
/* 1020 */       int ind = this.jListAttribut.getSelectedIndex();
/* 1021 */       if (ind < this.listeAtt.size() - 1) {
/* 1022 */         Attribut attr = (Attribut)this.listeAtt.get(ind + 1);
/* 1023 */         this.listeAtt.set(ind + 1, attSel);
/* 1024 */         this.listeAtt.set(ind, attr);
/* 1025 */         this.jListAttribut.setSelectedIndex(ind + 1);
/* 1026 */         this.jListAttribut.setListData(this.listeAtt.toArray());
/* 1027 */         this.jListAttribut.setSelectedIndex(ind + 1);
/* 1028 */         this.modifier = true;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void jBtDicoActionPerformed(ActionEvent evt) {
/* 1034 */     FormeSelectAttribut fatt = new FormeSelectAttribut(this.frm, true);
/* 1035 */     fatt.setVisible(true);
/* 1036 */     if ((fatt.getFermer().equals("OK")) && 
/* 1037 */       (fatt.getAttributSel() != null)) {
/* 1038 */       afficherAttributDic(fatt.getAttributSel());
/* 1039 */       this.attributSel = null;
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTACommentaireEntKeyPressed(java.awt.event.KeyEvent evt)
/*      */   {
/* 1045 */     if (evt.getKeyCode() == 9) this.jBtDico.requestFocus();
/*      */   }
/*      */   
/*      */   private void jTACommentaireKeyPressed(java.awt.event.KeyEvent evt) {
/* 1049 */     if (evt.getKeyCode() == 9) this.jBtModifier.requestFocus();
/*      */   }
/*      */   
/*      */   private void jBtcommTableActionPerformed(ActionEvent evt) {
/* 1053 */     FormeText f = new FormeText(this.frm, true, this.jTACommentaireEnt);
/* 1054 */     f.setTitle("Commentaire entité/relation");
/* 1055 */     f.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jBtCommAttActionPerformed(ActionEvent evt) {
/* 1059 */     FormeText f = new FormeText(this.frm, true, this.jTACommentaire);
/* 1060 */     f.setTitle("Commentaire de l'attribut " + this.jTFNom.getText());
/* 1061 */     f.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jBtDictionnaireActionPerformed(ActionEvent evt) {
/* 1065 */     FormeImporterAttribut f = new FormeImporterAttribut(this.frm, this.listeAtt, true);
/* 1066 */     f.setVisible(true);
/* 1067 */     if (f.isModifier()) {
/* 1068 */       this.listeAtt = f.getListAttribut();
/* 1069 */       this.jListAttribut.setListData(this.listeAtt.toArray());
/*      */     }
/* 1071 */     this.modifier = ((this.modifier) || (f.isModifier()));
/* 1072 */     this.frm.getPage().repaint();
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeEntite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */