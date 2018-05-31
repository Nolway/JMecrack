/*      */ package formes2;
/*      */ 
/*      */ import IhmMLD2.MLDEntite2;
/*      */ import Merise.Attribut;
/*      */ import Merise2.Attribut2;
/*      */ import java.awt.Color;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.util.ArrayList;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ 
/*      */ public class FormeMLDEntite2 extends javax.swing.JDialog
/*      */ {
/*      */   ihm.Principale frm;
/*      */   IhmMLD.IhmPageMLD page;
/*      */   MLDEntite2 entite;
/*      */   MLDEntite2 exemple;
/*      */   ArrayList<Attribut> listeAttribut;
/*      */   java.util.Map<Attribut, Attribut> listeAttributCorresp;
/*      */   ProprieteEntiteTableModel tableModel;
/*      */   ProprieteEntiteTableRender tabR;
/*      */   boolean isComposee;
/*      */   boolean isEntiteModfier;
/*      */   private javax.swing.ButtonGroup buttonGroup1;
/*      */   private javax.swing.JButton jBtAnnuler;
/*      */   private javax.swing.JButton jBtDescendre;
/*      */   private javax.swing.JButton jBtRemonter;
/*      */   private javax.swing.JButton jBtValider;
/*      */   private javax.swing.JCheckBox jCBAfficherPrk;
/*      */   private javax.swing.JCheckBox jCBAppliquer;
/*      */   private javax.swing.JCheckBox jCBAppliquerAttribut;
/*      */   private javax.swing.JComboBox jCBEpaisseurEntite;
/*      */   private javax.swing.JCheckBox jCBEspasser;
/*      */   private javax.swing.JCheckBox jCBTrierOrganiser;
/*      */   private JLabel jLabClActiver;
/*      */   private JLabel jLabClCadre;
/*      */   private JLabel jLabClCorpFond;
/*      */   private JLabel jLabClCorpTaille;
/*      */   private JLabel jLabClCorpTailleDec;
/*      */   private JLabel jLabClCorpType;
/*      */   private JLabel jLabClEnteteFond;
/*      */   private JLabel jLabClEnteteTexte;
/*      */   private JLabel jLabClOmbre;
/*      */   private JLabel jLabClPage;
/*      */   private JLabel jLabClPrk;
/*      */   private JLabel jLabClcorpsAttribut;
/*      */   
/*      */   public FormeMLDEntite2(ihm.Principale parent, IhmMLD.IhmPageMLD page, MLDEntite2 entite, boolean modal)
/*      */   {
/*   54 */     super(parent, modal);
/*   55 */     initComponents();
/*   56 */     this.frm = parent;
/*   57 */     this.page = page;
/*   58 */     this.entite = entite;
/*   59 */     this.isComposee = isComposer(entite.getListeAttributs());
/*   60 */     this.jCBTrierOrganiser.setSelected(this.isComposee);
/*   61 */     setLocation(this.frm.getX() + 300, this.frm.getY() + 60);
/*   62 */     this.jBtAnnuler.setMnemonic(65);
/*   63 */     this.jBtValider.setMnemonic(10);
/*   64 */     initData();
/*   65 */     dessinerApercu();
/*   66 */     this.listeAttributCorresp = new java.util.HashMap();
/*   67 */     this.listeAttribut = copierListeAttrbutMLD(entite);
/*   68 */     initialiserLatable();
/*   69 */     this.isEntiteModfier = false;
/*      */   }
/*      */   
/*      */   private void initData()
/*      */   {
/*   74 */     this.jTFnom.setText(this.entite.getNom());
/*   75 */     this.jTFCode.setText(this.entite.getCode());
/*      */     
/*   77 */     this.jLabClActiver.setBackground(this.entite.getClLienActiver());
/*      */     
/*   79 */     this.jLabClCadre.setBackground(this.entite.getClCadreTitre2());
/*   80 */     this.jLabClCorpType.setBackground(this.entite.getClTextType2());
/*   81 */     this.jLabClCorpFond.setBackground(this.entite.getClFond2());
/*   82 */     this.jLabClEnteteFond.setBackground(this.entite.getClFondTitre2());
/*   83 */     this.jLabClEnteteTexte.setBackground(this.entite.getClTextTitre2());
/*   84 */     this.jLabClcorpsAttribut.setBackground(this.entite.getClText2());
/*   85 */     this.jLabClCorpTaille.setBackground(this.entite.getClTextTaille2());
/*   86 */     this.jLabClCorpTailleDec.setBackground(this.entite.getClTextTailleDec2());
/*      */     
/*   88 */     this.jLabClPage.setBackground(this.page.clPage);
/*   89 */     this.jLabClOmbre.setBackground(this.entite.getClOmbre());
/*   90 */     this.jLabClPrk.setBackground(this.entite.getClPrk());
/*   91 */     this.jTAcommentaire.setText(this.entite.getCommentaire());
/*      */     
/*   93 */     creerExemple();
/*   94 */     this.jCBEspasser.setSelected(this.entite.getAttEspace() >= 1.2D);
/*   95 */     this.jCBAfficherPrk.setSelected(this.entite.isPrkvisible());
/*   96 */     if (this.entite.isPrkImage()) {
/*   97 */       this.jRBImage.setSelected(true);
/*      */     } else {
/*   99 */       this.jRBTexte.setSelected(true);
/*      */     }
/*  101 */     if (this.entite.getEpaisseur() == FormeProprieteMCD2.EPAISSEUR_FIN) {
/*  102 */       this.jCBEpaisseurEntite.setSelectedIndex(0);
/*      */     }
/*  104 */     if (this.entite.getEpaisseur() == FormeProprieteMCD2.EPAISSEUR_MOYEN) {
/*  105 */       this.jCBEpaisseurEntite.setSelectedIndex(1);
/*      */     }
/*  107 */     if (this.entite.getEpaisseur() == FormeProprieteMCD2.EPAISSEUR_GRAS) {
/*  108 */       this.jCBEpaisseurEntite.setSelectedIndex(2);
/*      */     }
/*  110 */     if (this.jCBAfficherPrk.isSelected()) {
/*  111 */       this.jRBImage.setEnabled(true);
/*  112 */       this.jRBTexte.setEnabled(true);
/*      */     } else {
/*  114 */       this.jRBImage.setEnabled(false);
/*  115 */       this.jRBTexte.setEnabled(false);
/*      */     }
/*  117 */     setCouleurExemple();
/*  118 */     dessinerApercu();
/*  119 */     if (!this.isComposee) {
/*  120 */       this.jBtRemonter.setEnabled(false);
/*  121 */       this.jBtDescendre.setEnabled(false);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean isComposer(ArrayList<Attribut> liste)
/*      */   {
/*  127 */     for (int i = 0; i < liste.size(); i++) {
/*  128 */       Attribut2 att = (Attribut2)liste.get(i);
/*  129 */       if (att.getListeAttributs().size() > 0) {
/*  130 */         return true;
/*      */       }
/*      */     }
/*  133 */     return false;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> copierListeAttrbutMLD(MLDEntite2 ent) {
/*  137 */     ArrayList<Attribut> listeC = new ArrayList();
/*  138 */     Attribut2 attpere = null;
/*  139 */     copierListeAttrbutMLD(listeC, attpere, ent.getListeAttributs());
/*      */     
/*  141 */     return listeC;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> copierListeAttrbut(ArrayList<Attribut> listeA) {
/*  145 */     ArrayList<Attribut> listeC = new ArrayList();
/*  146 */     Attribut2 attpere = null;
/*  147 */     copierListeAttrbutMLD(listeC, attpere, listeA);
/*  148 */     return listeC;
/*      */   }
/*      */   
/*      */   private void copierListeAttrbutMLD(ArrayList<Attribut> listeC, Attribut2 pere, ArrayList<Attribut> listeA)
/*      */   {
/*  153 */     for (int i = 0; i < listeA.size(); i++) {
/*  154 */       Attribut2 att = (Attribut2)listeA.get(i);
/*  155 */       Attribut2 attC = (Attribut2)att.copier();
/*  156 */       this.listeAttributCorresp.put(att, attC);
/*  157 */       attC.getListeAttributs().clear();
/*  158 */       if (pere != null) {
/*  159 */         pere.getListeAttributs().add(attC);
/*      */       } else {
/*  161 */         listeC.add(attC);
/*      */       }
/*  163 */       if (att.getListeAttributs().size() > 0) {
/*  164 */         copierListeAttrbutMLD(listeC, attC, att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private javax.swing.JComboBox remplirCle() {
/*  170 */     javax.swing.JComboBox comboBox = new javax.swing.JComboBox();
/*  171 */     comboBox.addItem("");
/*  172 */     comboBox.addItem("CLE PRIMAIRE");
/*  173 */     comboBox.addItem("CLE ALTERNATIVE");
/*  174 */     comboBox.addItem("INDEX");
/*  175 */     comboBox.addItem("CLE ETRANGERE");
/*      */     
/*  177 */     return comboBox;
/*      */   }
/*      */   
/*      */   private javax.swing.JComboBox remplirType() {
/*  181 */     javax.swing.JComboBox comboBox = new javax.swing.JComboBox();
/*      */     
/*  183 */     comboBox.addItem("");
/*  184 */     for (int i = 0; i < this.frm.getPage().getListeDomaine().size(); i++) {
/*  185 */       comboBox.addItem(((Merise.Domaine)this.frm.getPage().getListeDomaine().get(i)).getNom());
/*      */     }
/*  187 */     if (this.frm.getPage().getListeDomaine().size() > 0) comboBox.addItem("");
/*  188 */     for (int i = 0; i < Outil.Parametres.DomaineDefini.length; i++) {
/*  189 */       if ((!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("ENUM")) && (!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("SET"))) {
/*  190 */         comboBox.addItem(Outil.Parametres.DomaineDefini[i]);
/*      */       }
/*      */     }
/*      */     
/*  194 */     return comboBox;
/*      */   }
/*      */   
/*      */   private void initialiserLatable() {
/*  198 */     javax.swing.JComboBox comboBoxCle = remplirCle();
/*  199 */     javax.swing.JComboBox comboBoxType = remplirType();
/*  200 */     javax.swing.JTextField jtf = new javax.swing.JTextField();
/*  201 */     jtf.setFont(new java.awt.Font("Tahoma", 1, 14));
/*  202 */     jtf.setBackground(Color.yellow);
/*      */     
/*  204 */     if (this.entite.isComposer()) {
/*  205 */       jtf.setEnabled(false);
/*      */     }
/*      */     
/*  208 */     this.tableModel = new ProprieteEntiteTableModel(this.listeAttribut, false);
/*  209 */     this.jTableAttribut.setModel(this.tableModel);
/*      */     
/*  211 */     this.jTableAttribut.getColumnModel().getColumn(0).setCellEditor(new ProprieteBoutonCellEditor(this.listeAttribut, this.frm, this.entite, null));
/*      */     
/*  213 */     this.jTableAttribut.getColumnModel().getColumn(0).setPreferredWidth(45);
/*  214 */     this.jTableAttribut.getColumnModel().getColumn(1).setPreferredWidth(200);
/*  215 */     this.jTableAttribut.getColumnModel().getColumn(2).setPreferredWidth(150);
/*  216 */     this.jTableAttribut.getColumnModel().getColumn(3).setPreferredWidth(120);
/*  217 */     this.jTableAttribut.getColumnModel().getColumn(4).setPreferredWidth(30);
/*  218 */     this.jTableAttribut.getColumnModel().getColumn(5).setPreferredWidth(30);
/*  219 */     this.jTableAttribut.getColumnModel().getColumn(6).setPreferredWidth(120);
/*  220 */     this.jTableAttribut.getColumnModel().getColumn(7).setPreferredWidth(30);
/*  221 */     this.jTableAttribut.getColumnModel().getColumn(8).setPreferredWidth(30);
/*      */     
/*  223 */     comboBoxType.setEnabled(false);
/*      */     
/*  225 */     this.jTableAttribut.getColumnModel().getColumn(1).setCellEditor(new javax.swing.DefaultCellEditor(jtf));
/*  226 */     this.jTableAttribut.getColumnModel().getColumn(2).setCellEditor(new javax.swing.DefaultCellEditor(jtf));
/*  227 */     this.jTableAttribut.getColumnModel().getColumn(3).setCellEditor(new javax.swing.DefaultCellEditor(comboBoxType));
/*  228 */     comboBoxCle.setEnabled(false);
/*  229 */     javax.swing.JCheckBox cbx = new javax.swing.JCheckBox();
/*  230 */     cbx.setEnabled(false);
/*  231 */     this.jTableAttribut.getColumnModel().getColumn(6).setCellEditor(new javax.swing.DefaultCellEditor(comboBoxCle));
/*  232 */     this.jTableAttribut.getColumnModel().getColumn(7).setCellEditor(new javax.swing.DefaultCellEditor(cbx));
/*      */     
/*  234 */     this.tabR = new ProprieteEntiteTableRender();
/*  235 */     this.tabR.setListeAttribut(this.listeAttribut);
/*  236 */     this.jTableAttribut.setDefaultRenderer(Object.class, this.tabR);
/*  237 */     this.jTableAttribut.setDefaultRenderer(javax.swing.JButton.class, new ProprieteBoutonCellRender());
/*  238 */     this.jTableAttribut.setDefaultRenderer(Boolean.class, new CheckBoxCellRender());
/*      */     
/*      */ 
/*      */ 
/*  242 */     this.jTableAttribut.setRowHeight(30);
/*      */   }
/*      */   
/*      */   private float getEpaisseur() {
/*  246 */     if (this.jCBEpaisseurEntite.getSelectedIndex() == 1) return FormeProprieteMCD2.EPAISSEUR_MOYEN;
/*  247 */     if (this.jCBEpaisseurEntite.getSelectedIndex() == 2) return FormeProprieteMCD2.EPAISSEUR_GRAS;
/*  248 */     return FormeProprieteMCD2.EPAISSEUR_FIN;
/*      */   }
/*      */   
/*      */   private float getInterLigne() {
/*  252 */     return this.jCBEspasser.isSelected() ? 1.35F : 1.15F;
/*      */   }
/*      */   
/*      */   private Color choixDeCouleur(Color color, String titre) {
/*  256 */     Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/*  257 */     if (col == null) return color;
/*  258 */     return col;
/*      */   }
/*      */   
/*      */   private void setCouleurExemple() {
/*  262 */     this.exemple.setClLienActiver(this.jLabClActiver.getBackground());
/*  263 */     this.exemple.setClCadre2(this.jLabClCadre.getBackground());
/*  264 */     this.exemple.setClCadreTitre2(this.jLabClCadre.getBackground());
/*  265 */     this.exemple.setClFond2(this.jLabClCorpFond.getBackground());
/*  266 */     this.exemple.setClTextType2(this.jLabClCorpType.getBackground());
/*  267 */     this.exemple.setClFondTitre2(this.jLabClEnteteFond.getBackground());
/*  268 */     this.exemple.setClTextTitre2(this.jLabClEnteteTexte.getBackground());
/*  269 */     this.exemple.setClText2(this.jLabClcorpsAttribut.getBackground());
/*  270 */     this.exemple.setClOmbre(this.jLabClOmbre.getBackground());
/*  271 */     this.exemple.setClPrk(this.jLabClPrk.getBackground());
/*      */   }
/*      */   
/*      */   private void setCouleurExemple(MLDEntite2 exp)
/*      */   {
/*  276 */     exp.setClLienActiver(this.jLabClActiver.getBackground());
/*  277 */     exp.setClCadre2(this.jLabClCadre.getBackground());
/*  278 */     exp.setClCadreTitre2(this.jLabClCadre.getBackground());
/*  279 */     exp.setClFond2(this.jLabClCorpFond.getBackground());
/*  280 */     exp.setClTextType2(this.jLabClCorpType.getBackground());
/*  281 */     exp.setClFondTitre2(this.jLabClEnteteFond.getBackground());
/*  282 */     exp.setClTextTitre2(this.jLabClEnteteTexte.getBackground());
/*  283 */     exp.setClText2(this.jLabClcorpsAttribut.getBackground());
/*  284 */     exp.setClOmbre(this.jLabClOmbre.getBackground());
/*  285 */     exp.setClPrk(this.jLabClPrk.getBackground());
/*      */   }
/*      */   
/*      */   private void creerExemple()
/*      */   {
/*  290 */     this.exemple = new MLDEntite2("Exemple", 40, 30, 0, 0, true);
/*  291 */     this.exemple.setArrondir(this.entite.isArrondir());
/*  292 */     this.exemple.setAttEspace(this.entite.getAttEspace());
/*  293 */     this.exemple.setAttMajuscule(this.entite.isAttMajuscule());
/*  294 */     this.exemple.setVariable(true);
/*  295 */     setCouleurExemple();
/*  296 */     Attribut2 att = new Attribut2("attribut1", "Varchar", 50, -1, "PRIMARY KEY", false, "", null);
/*  297 */     ArrayList<Attribut> liste = new ArrayList();
/*  298 */     liste.add(att);
/*  299 */     att = new Attribut2("attribut2", "Double", 5, 2, "", false, "", null);
/*  300 */     liste.add(att);
/*  301 */     att = new Attribut2("attribut3", "Char", 15, -1, "", false, "", null);
/*  302 */     liste.add(att);
/*  303 */     att = new Attribut2("att4", "Varchar", 150, -1, "", false, "", null);
/*  304 */     liste.add(att);
/*  305 */     this.exemple.setListeAttributs(liste);
/*      */   }
/*      */   
/*      */   private void dessinerApercu() {
/*  309 */     java.awt.Graphics2D g = (java.awt.Graphics2D)this.jPanApercu.getGraphics();
/*  310 */     g.setColor(this.jLabClPage.getBackground());
/*  311 */     g.fillRect(0, 0, this.jPanApercu.getWidth(), this.jPanApercu.getHeight());
/*  312 */     g.setColor(this.jLabClActiver.getBackground());
/*  313 */     g.drawLine(0, this.jPanApercu.getHeight() / 2, this.jPanApercu.getWidth() + 10, this.jPanApercu.getHeight() / 2);
/*  314 */     this.exemple.paint(g);
/*      */   }
/*      */   
/*      */   private void enregistrerLesModification() {
/*  318 */     this.entite.setNom(this.jTFnom.getText().trim());
/*  319 */     this.entite.setCode(this.jTFCode.getText().trim().toUpperCase());
/*  320 */     this.entite.setClLienActiver(this.jLabClActiver.getBackground());
/*  321 */     this.entite.setClCadre2(this.jLabClCadre.getBackground());
/*  322 */     this.entite.setClCadreTitre2(this.jLabClCadre.getBackground());
/*  323 */     this.entite.setClFond2(this.jLabClCorpFond.getBackground());
/*  324 */     this.entite.setClTextType2(this.jLabClCorpType.getBackground());
/*  325 */     this.entite.setClFondTitre2(this.jLabClEnteteFond.getBackground());
/*  326 */     this.entite.setClTextTitre2(this.jLabClEnteteTexte.getBackground());
/*  327 */     this.entite.setClText2(this.jLabClcorpsAttribut.getBackground());
/*  328 */     this.entite.setClOmbre(this.jLabClOmbre.getBackground());
/*  329 */     this.entite.setClPrk(this.jLabClPrk.getBackground());
/*  330 */     this.entite.setAttEspace(getInterLigne());
/*  331 */     this.entite.setPrkvisible(this.jCBAfficherPrk.isSelected());
/*  332 */     this.entite.setPrkImage(this.jRBImage.isSelected());
/*  333 */     this.entite.setEpaisseur(getEpaisseur());
/*  334 */     this.page.clPage = this.jLabClPage.getBackground();
/*      */   }
/*      */   
/*      */   private void saveDate() {
/*  338 */     enregistrerLesModification();
/*      */     
/*  340 */     for (int i = 0; i < this.page.getListeMLDEntite().size(); i++) {
/*  341 */       MLDEntite2 ent = (MLDEntite2)this.page.getListeMLDEntite().get(i);
/*  342 */       if (this.jCBAppliquer.isSelected()) {
/*  343 */         setCouleurExemple(ent);
/*  344 */         if (this.jCBAppliquerAttribut.isSelected()) {
/*  345 */           setColorAllAttribut(ent.getListeAttributs(), getColor(this.jLabClcorpsAttribut.getBackground()), getColor(this.jLabClCorpType.getBackground()), getColor(this.jLabClCorpTaille.getBackground()), getColor(this.jLabClCorpTailleDec.getBackground()));
/*      */         }
/*      */       }
/*      */       
/*  349 */       ent.setClOmbre(this.jLabClOmbre.getBackground());
/*  350 */       ent.setAttEspace(getInterLigne());
/*  351 */       ent.setPrkvisible(this.jCBAfficherPrk.isSelected());
/*  352 */       ent.setPrkImage(this.jRBImage.isSelected());
/*  353 */       ent.setEpaisseur(getEpaisseur());
/*      */     }
/*      */   }
/*      */   
/*      */   private void descendreAttribut(int index)
/*      */   {
/*  359 */     if (index < this.listeAttribut.size() - 1) {
/*  360 */       Attribut att = (Attribut)this.listeAttribut.get(index + 1);
/*  361 */       this.listeAttribut.remove(index + 1);
/*  362 */       this.tableModel.removeAttribut(index + 1);
/*      */       
/*  364 */       this.listeAttribut.add(index, att);
/*  365 */       this.tableModel.getListeAttribut().add(index, att);
/*  366 */       this.jTableAttribut.repaint();
/*  367 */       this.jTableAttribut.setRowSelectionInterval(index + 1, index + 1);
/*  368 */       this.isEntiteModfier = true;
/*      */     }
/*      */   }
/*      */   
/*      */   private void remonterAttribut(int index) {
/*  373 */     if (index >= 1) {
/*  374 */       Attribut att = (Attribut)this.listeAttribut.get(index - 1);
/*  375 */       this.listeAttribut.remove(index - 1);
/*  376 */       this.tableModel.removeAttribut(index - 1);
/*      */       
/*  378 */       this.listeAttribut.add(index, att);
/*  379 */       this.tableModel.getListeAttribut().add(index, att);
/*  380 */       this.jTableAttribut.repaint();
/*  381 */       this.jTableAttribut.setRowSelectionInterval(index - 1, index - 1);
/*  382 */       this.isEntiteModfier = true;
/*      */     }
/*      */   }
/*      */   
/*      */   private void copierAttributVersAttribut(Attribut2 aC, Attribut2 aS)
/*      */   {
/*  388 */     aC.setNom(aS.getNom());
/*  389 */     aC.setCode(aS.getCode());
/*  390 */     aC.setCommentaire(aS.getCommentaire());
/*  391 */     aC.setValeurDefaut(aS.getValeurDefaut());
/*  392 */     aC.setAfficher(aS.isAfficher());
/*  393 */     aC.setClNom(aS.getClNom());
/*  394 */     aC.setClCode(aS.getClCode());
/*  395 */     aC.setClType(aS.getClType());
/*  396 */     aC.setClTaille(aS.getClTaille());
/*  397 */     aC.setClTailleDecimale(aS.getClTailleDecimale());
/*      */   }
/*      */   
/*      */   private void MAJListeAttribut() {
/*  401 */     Object[] tab = this.listeAttributCorresp.keySet().toArray();
/*      */     
/*  403 */     for (int i = 0; i < tab.length; i++) {
/*  404 */       Attribut2 aS = (Attribut2)tab[i];
/*  405 */       Attribut2 aC = (Attribut2)this.listeAttributCorresp.get(aS);
/*  406 */       copierAttributVersAttribut(aS, aC);
/*      */     }
/*      */   }
/*      */   
/*      */   private Attribut getSourceAttribut(Attribut att) {
/*  411 */     Object[] tab = this.listeAttributCorresp.keySet().toArray();
/*      */     
/*  413 */     for (int i = 0; i < tab.length; i++) {
/*  414 */       Attribut2 aC = (Attribut2)tab[i];
/*  415 */       Attribut2 aS = (Attribut2)this.listeAttributCorresp.get(aC);
/*  416 */       if (aS == att) return aC;
/*      */     }
/*  418 */     return null;
/*      */   }
/*      */   
/*      */   private void ordonnerListeAttribut(Attribut2 att, ArrayList<Attribut> list) {
/*  422 */     ArrayList<Attribut> liste = new ArrayList();
/*      */     
/*  424 */     for (int i = 0; i < list.size(); i++)
/*      */     {
/*  426 */       Attribut a = getSourceAttribut((Attribut)list.get(i));
/*  427 */       liste.add(a);
/*      */     }
/*  429 */     att.setListeAttributs(liste);
/*      */   }
/*      */   
/*      */ 
/*      */   private ArrayList<Attribut> ordonnerListeAttribut()
/*      */   {
/*  435 */     ArrayList<Attribut> liste = new ArrayList();
/*      */     
/*  437 */     for (int i = 0; i < this.listeAttribut.size(); i++)
/*      */     {
/*  439 */       Attribut a = getSourceAttribut((Attribut)this.listeAttribut.get(i));
/*  440 */       liste.add(a);
/*  441 */       if (((Attribut2)this.listeAttribut.get(i)).getListeAttributs().size() > 0) {
/*  442 */         ordonnerListeAttribut((Attribut2)a, ((Attribut2)this.listeAttribut.get(i)).getListeAttributs());
/*      */       }
/*      */     }
/*  445 */     return liste;
/*      */   }
/*      */   
/*      */   private void saveDataAttribut(MLDEntite2 ent) {
/*  449 */     MAJListeAttribut();
/*  450 */     ent.setListeAttributs(ordonnerListeAttribut());
/*      */   }
/*      */   
/*      */   private boolean isRegrouper(ArrayList<Attribut> liste)
/*      */   {
/*  455 */     for (int i = 0; i < liste.size(); i++) {
/*  456 */       Attribut2 att = (Attribut2)liste.get(i);
/*  457 */       if (att.getListeAttributs().size() > 0) {
/*  458 */         return true;
/*      */       }
/*      */     }
/*  461 */     return false;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributPrimaryKey(ArrayList<Attribut> liste)
/*      */   {
/*  466 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  468 */     for (int i = 0; i < liste.size(); i++) {
/*  469 */       Attribut2 att = (Attribut2)liste.get(i);
/*  470 */       if ((att.getKey().equals(Outil.Parametres.Cle)) && (!att.isForeingKey())) {
/*  471 */         l.add(att);
/*      */       }
/*      */     }
/*  474 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributForeingKey(ArrayList<Attribut> liste) {
/*  478 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  480 */     for (int i = 0; i < liste.size(); i++) {
/*  481 */       Attribut2 att = (Attribut2)liste.get(i);
/*  482 */       if (att.getKey().equals(Outil.Parametres.CleEtr)) {
/*  483 */         l.add(att);
/*      */       }
/*      */     }
/*  486 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributPrimaryForeingKey(ArrayList<Attribut> liste) {
/*  490 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  492 */     for (int i = 0; i < liste.size(); i++) {
/*  493 */       Attribut2 att = (Attribut2)liste.get(i);
/*  494 */       if ((att.getKey().equals(Outil.Parametres.Cle)) && (att.isForeingKey())) {
/*  495 */         l.add(att);
/*      */       }
/*      */     }
/*  498 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributUnique(ArrayList<Attribut> liste) {
/*  502 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  504 */     for (int i = 0; i < liste.size(); i++) {
/*  505 */       Attribut2 att = (Attribut2)liste.get(i);
/*  506 */       if (att.getKey().equals(Outil.Parametres.Unique)) {
/*  507 */         l.add(att);
/*      */       }
/*      */     }
/*  510 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributIndex(ArrayList<Attribut> liste) {
/*  514 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  516 */     for (int i = 0; i < liste.size(); i++) {
/*  517 */       Attribut2 att = (Attribut2)liste.get(i);
/*  518 */       if (att.getKey().equals(Outil.Parametres.Index)) {
/*  519 */         l.add(att);
/*      */       }
/*      */     }
/*  522 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributNonCle(ArrayList<Attribut> liste) {
/*  526 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  528 */     for (int i = 0; i < liste.size(); i++) {
/*  529 */       Attribut2 att = (Attribut2)liste.get(i);
/*  530 */       if (att.getKey().trim().length() == 0) {
/*  531 */         l.add(att);
/*      */       }
/*      */     }
/*  534 */     return l;
/*      */   }
/*      */   
/*      */   private void setafficherAll(ArrayList<Attribut> liste)
/*      */   {
/*  539 */     for (int i = 0; i < liste.size(); i++) {
/*  540 */       Attribut2 att = (Attribut2)liste.get(i);
/*  541 */       att.setAfficher(true);
/*  542 */       if (att.getListeAttributs().size() > 0) {
/*  543 */         setafficherAll(att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> composerLesAttributs(ArrayList<Attribut> liste) {
/*  549 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  551 */     setafficherAll(liste);
/*  552 */     ArrayList<Attribut> lp = getAttributPrimaryKey(liste);
/*  553 */     if (lp.size() > 0) {
/*  554 */       Attribut2 att = new Attribut2("Pk_Primary", "", "", -1, -1, "", false, "", null);
/*  555 */       att.setForeingKey(false);
/*  556 */       att.setListeAttributs(lp);
/*  557 */       l.add(att);
/*      */     }
/*  559 */     lp = getAttributPrimaryForeingKey(liste);
/*  560 */     if (lp.size() > 0) {
/*  561 */       Attribut2 att = new Attribut2("PFk_Prim_Forei", "", "", -1, -1, "", false, "", null);
/*  562 */       att.setForeingKey(true);
/*  563 */       att.setListeAttributs(lp);
/*  564 */       l.add(att);
/*      */     }
/*      */     
/*  567 */     lp = getAttributNonCle(liste);
/*  568 */     if (lp.size() > 0) {
/*  569 */       Attribut2 att = new Attribut2("Attributs", "", "", -1, -1, "", false, "", null);
/*  570 */       att.setForeingKey(false);
/*  571 */       att.setListeAttributs(lp);
/*  572 */       l.add(att);
/*      */     }
/*      */     
/*  575 */     lp = getAttributUnique(liste);
/*  576 */     if (lp.size() > 0) {
/*  577 */       Attribut2 att = new Attribut2("Unq_Unique", "", "", -1, -1, "", false, "", null);
/*  578 */       att.setForeingKey(false);
/*  579 */       att.setListeAttributs(lp);
/*  580 */       l.add(att);
/*      */     }
/*      */     
/*  583 */     lp = getAttributIndex(liste);
/*  584 */     if (lp.size() > 0) {
/*  585 */       Attribut2 att = new Attribut2("Idx_Index", "", "", -1, -1, "", false, "", null);
/*  586 */       att.setForeingKey(false);
/*  587 */       att.setListeAttributs(lp);
/*  588 */       l.add(att);
/*      */     }
/*      */     
/*  591 */     lp = getAttributForeingKey(liste);
/*  592 */     if (lp.size() > 0) {
/*  593 */       Attribut2 att = new Attribut2("Fk_Foreign", "", "", -1, -1, "", false, "", null);
/*  594 */       att.setForeingKey(false);
/*  595 */       att.setListeAttributs(lp);
/*  596 */       l.add(att);
/*      */     }
/*      */     
/*  599 */     return l;
/*      */   }
/*      */   
/*      */   private void decomposeAttributs(ArrayList<Attribut> listeC, ArrayList<Attribut> liste)
/*      */   {
/*  604 */     for (int i = 0; i < liste.size(); i++) {
/*  605 */       Attribut2 att = (Attribut2)liste.get(i);
/*  606 */       if (att.getListeAttributs().size() == 0) {
/*  607 */         listeC.add(att);
/*      */       } else {
/*  609 */         decomposeAttributs(listeC, att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void composerLesAttributsMLDEntite(MLDEntite2 ent)
/*      */   {
/*  616 */     if (ent == null) return;
/*  617 */     if (!ent.isComposer()) {
/*  618 */       ent.setListeAttributs(composerLesAttributs(ent.getListeAttributs()));
/*      */     }
/*      */   }
/*      */   
/*      */   private void composerAttributAllMLDEntite(ArrayList<MLDEntite2> liste)
/*      */   {
/*  624 */     for (int i = 0; i < liste.size(); i++) {
/*  625 */       composerLesAttributsMLDEntite((MLDEntite2)liste.get(i));
/*      */     }
/*      */   }
/*      */   
/*      */   private void decomposerAttributAllMLDEntite(ArrayList<MLDEntite2> liste) {
/*  630 */     for (int i = 0; i < liste.size(); i++) {
/*  631 */       decomposerLesAttributsMLDEntite((MLDEntite2)liste.get(i));
/*      */     }
/*      */   }
/*      */   
/*      */   private void decomposerLesAttributsMLDEntite(MLDEntite2 ent) {
/*  636 */     if (ent == null) return;
/*  637 */     if (!ent.isComposer()) { return;
/*      */     }
/*  639 */     ArrayList<Attribut> liste = new ArrayList();
/*  640 */     decomposeAttributs(liste, ent.getListeAttributs());
/*  641 */     ent.setListeAttributs(liste);
/*      */   }
/*      */   
/*      */   private void setColorAllAttribut(ArrayList<Attribut> liste, String clNom, String clType, String clTaille, String clTailleDec)
/*      */   {
/*  646 */     for (int i = 0; i < liste.size(); i++) {
/*  647 */       Attribut2 att = (Attribut2)liste.get(i);
/*  648 */       att.setClNom(clNom);
/*  649 */       att.setClCode(clNom);
/*  650 */       att.setClType(clType);
/*  651 */       att.setClTaille(clTaille);
/*  652 */       att.setClTailleDecimale(clTailleDec);
/*  653 */       if (att.getListeAttributs().size() > 0) {
/*  654 */         setColorAllAttribut(att.getListeAttributs(), clNom, clType, clTaille, clTailleDec);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public Color getColor(String color) {
/*  660 */     return new Color(Integer.parseInt(color));
/*      */   }
/*      */   
/*      */   public String getColor(Color color) {
/*  664 */     return color.getRGB() + "";
/*      */   }
/*      */   
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel10;
/*      */   private JLabel jLabel11;
/*      */   private JLabel jLabel14;
/*      */   private JLabel jLabel15;
/*      */   private JLabel jLabel16;
/*      */   private JLabel jLabel17;
/*      */   private JLabel jLabel18;
/*      */   
/*      */   private void initComponents() {
/*  677 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/*  678 */     this.jLabel1 = new JLabel();
/*  679 */     this.jLabel2 = new JLabel();
/*  680 */     this.jTFnom = new javax.swing.JTextField();
/*  681 */     this.jTFCode = new javax.swing.JTextField();
/*  682 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/*  683 */     this.jPanel1 = new JPanel();
/*  684 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  685 */     this.jTableAttribut = new javax.swing.JTable();
/*  686 */     this.jBtRemonter = new javax.swing.JButton();
/*  687 */     this.jBtDescendre = new javax.swing.JButton();
/*  688 */     this.jPanel2 = new JPanel();
/*  689 */     this.jPanApercu = new JPanel();
/*  690 */     this.jPanel4 = new JPanel();
/*  691 */     this.jLabClEnteteFond = new JLabel();
/*  692 */     this.jLabel4 = new JLabel();
/*  693 */     this.jLabel5 = new JLabel();
/*  694 */     this.jLabClEnteteTexte = new JLabel();
/*  695 */     this.jLabClCadre = new JLabel();
/*  696 */     this.jLabel8 = new JLabel();
/*  697 */     this.jPanel6 = new JPanel();
/*  698 */     this.jLabClCorpFond = new JLabel();
/*  699 */     this.jLabel10 = new JLabel();
/*  700 */     this.jLabel11 = new JLabel();
/*  701 */     this.jLabClcorpsAttribut = new JLabel();
/*  702 */     this.jLabClCorpType = new JLabel();
/*  703 */     this.jLabel14 = new JLabel();
/*  704 */     this.jLabClCorpTaille = new JLabel();
/*  705 */     this.jLabel18 = new JLabel();
/*  706 */     this.jLabClCorpTailleDec = new JLabel();
/*  707 */     this.jLabel19 = new JLabel();
/*  708 */     this.jPanel7 = new JPanel();
/*  709 */     this.jLabel17 = new JLabel();
/*  710 */     this.jLabClActiver = new JLabel();
/*  711 */     this.jLabClPage = new JLabel();
/*  712 */     this.jLabel20 = new JLabel();
/*  713 */     this.jLabClOmbre = new JLabel();
/*  714 */     this.jLabel22 = new JLabel();
/*  715 */     this.jLabel16 = new JLabel();
/*  716 */     this.jPanel3 = new JPanel();
/*  717 */     this.jLabel23 = new JLabel();
/*  718 */     this.jLabClPrk = new JLabel();
/*  719 */     this.jCBAppliquerAttribut = new javax.swing.JCheckBox();
/*  720 */     this.jPanel8 = new JPanel();
/*  721 */     this.jCBEspasser = new javax.swing.JCheckBox();
/*  722 */     this.jCBAfficherPrk = new javax.swing.JCheckBox();
/*  723 */     this.jRBTexte = new javax.swing.JRadioButton();
/*  724 */     this.jRBImage = new javax.swing.JRadioButton();
/*  725 */     this.jCBTrierOrganiser = new javax.swing.JCheckBox();
/*  726 */     this.jCBEpaisseurEntite = new javax.swing.JComboBox();
/*  727 */     this.jLabel15 = new JLabel();
/*  728 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/*  729 */     this.jTAcommentaire = new javax.swing.JTextArea();
/*  730 */     this.jLabel3 = new JLabel();
/*  731 */     this.jBtValider = new javax.swing.JButton();
/*  732 */     this.jBtAnnuler = new javax.swing.JButton();
/*  733 */     this.jCBAppliquer = new javax.swing.JCheckBox();
/*      */     
/*  735 */     setDefaultCloseOperation(2);
/*  736 */     setTitle("Proprieté de Entite MLD");
/*  737 */     setResizable(false);
/*      */     
/*  739 */     this.jLabel1.setText("Nom");
/*      */     
/*  741 */     this.jLabel2.setText("Code");
/*      */     
/*  743 */     this.jTFnom.setEditable(false);
/*  744 */     this.jTFnom.setFont(new java.awt.Font("Tahoma", 1, 12));
/*      */     
/*  746 */     this.jTFCode.setEditable(false);
/*  747 */     this.jTFCode.setFont(new java.awt.Font("Tahoma", 1, 12));
/*      */     
/*  749 */     this.jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  751 */     this.jTableAttribut.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  762 */     this.jScrollPane1.setViewportView(this.jTableAttribut);
/*      */     
/*  764 */     this.jBtRemonter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/monter.png")));
/*  765 */     this.jBtRemonter.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  767 */         FormeMLDEntite2.this.jBtRemonterActionPerformed(evt);
/*      */       }
/*      */       
/*  770 */     });
/*  771 */     this.jBtDescendre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/descendre.png")));
/*  772 */     this.jBtDescendre.setPreferredSize(new java.awt.Dimension(49, 30));
/*  773 */     this.jBtDescendre.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  775 */         FormeMLDEntite2.this.jBtDescendreActionPerformed(evt);
/*      */       }
/*      */       
/*  778 */     });
/*  779 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  780 */     this.jPanel1.setLayout(jPanel1Layout);
/*  781 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 737, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jBtRemonter, -2, 72, -2).addGap(18, 18, 18).addComponent(this.jBtDescendre, -2, 68, -2).addGap(285, 285, 285)))));
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
/*  795 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 310, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jBtRemonter).addComponent(this.jBtDescendre, 0, 0, 32767)).addContainerGap()));
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
/*  807 */     this.jTabbedPane1.addTab("Attributs", this.jPanel1);
/*      */     
/*  809 */     this.jPanApercu.setBackground(new Color(255, 255, 255));
/*  810 */     this.jPanApercu.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  811 */     this.jPanApercu.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  813 */         FormeMLDEntite2.this.jPanApercuMouseClicked(evt);
/*      */       }
/*      */       
/*  816 */     });
/*  817 */     GroupLayout jPanApercuLayout = new GroupLayout(this.jPanApercu);
/*  818 */     this.jPanApercu.setLayout(jPanApercuLayout);
/*  819 */     jPanApercuLayout.setHorizontalGroup(jPanApercuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 294, 32767));
/*      */     
/*      */ 
/*      */ 
/*  823 */     jPanApercuLayout.setVerticalGroup(jPanApercuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 165, 32767));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  828 */     this.jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Couleur entête", 0, 0, new java.awt.Font("Tahoma", 0, 11), new Color(204, 0, 0)));
/*      */     
/*  830 */     this.jLabClEnteteFond.setBackground(new Color(255, 255, 255));
/*  831 */     this.jLabClEnteteFond.setFont(new java.awt.Font("Tahoma", 1, 18));
/*  832 */     this.jLabClEnteteFond.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  833 */     this.jLabClEnteteFond.setCursor(new java.awt.Cursor(12));
/*  834 */     this.jLabClEnteteFond.setOpaque(true);
/*  835 */     this.jLabClEnteteFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  837 */         FormeMLDEntite2.this.jLabClEnteteFondMouseClicked(evt);
/*      */       }
/*      */       
/*  840 */     });
/*  841 */     this.jLabel4.setHorizontalAlignment(0);
/*  842 */     this.jLabel4.setText("Fond");
/*  843 */     this.jLabel4.setCursor(new java.awt.Cursor(9));
/*  844 */     this.jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  846 */         FormeMLDEntite2.this.jLabel4MouseClicked(evt);
/*      */       }
/*      */       
/*  849 */     });
/*  850 */     this.jLabel5.setHorizontalAlignment(0);
/*  851 */     this.jLabel5.setText("Texte");
/*      */     
/*  853 */     this.jLabClEnteteTexte.setBackground(new Color(255, 255, 255));
/*  854 */     this.jLabClEnteteTexte.setFont(new java.awt.Font("Tahoma", 1, 18));
/*  855 */     this.jLabClEnteteTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  856 */     this.jLabClEnteteTexte.setCursor(new java.awt.Cursor(12));
/*  857 */     this.jLabClEnteteTexte.setOpaque(true);
/*  858 */     this.jLabClEnteteTexte.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  860 */         FormeMLDEntite2.this.jLabClEnteteTexteMouseClicked(evt);
/*      */       }
/*      */       
/*  863 */     });
/*  864 */     this.jLabClCadre.setBackground(new Color(255, 255, 255));
/*  865 */     this.jLabClCadre.setFont(new java.awt.Font("Tahoma", 1, 18));
/*  866 */     this.jLabClCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  867 */     this.jLabClCadre.setCursor(new java.awt.Cursor(12));
/*  868 */     this.jLabClCadre.setOpaque(true);
/*  869 */     this.jLabClCadre.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  871 */         FormeMLDEntite2.this.jLabClCadreMouseClicked(evt);
/*      */       }
/*      */       
/*  874 */     });
/*  875 */     this.jLabel8.setHorizontalAlignment(0);
/*  876 */     this.jLabel8.setText("Cadre");
/*      */     
/*  878 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  879 */     this.jPanel4.setLayout(jPanel4Layout);
/*  880 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel4, -1, 56, 32767).addComponent(this.jLabClEnteteFond, -1, 56, 32767)).addGap(85, 85, 85).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel5, -1, 56, 32767).addComponent(this.jLabClEnteteTexte, -1, 56, 32767)).addGap(83, 83, 83).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel8, -1, 56, 32767).addComponent(this.jLabClCadre, -1, 56, 32767)).addGap(55, 55, 55)));
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
/*  897 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClEnteteFond, -1, -1, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClEnteteTexte, -2, 20, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel8).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClCadre, -1, -1, 32767))).addContainerGap(-1, 32767)));
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
/*  916 */     this.jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Couleur attribut", 0, 0, new java.awt.Font("Tahoma", 0, 11), new Color(204, 0, 0)));
/*      */     
/*  918 */     this.jLabClCorpFond.setBackground(new Color(255, 255, 255));
/*  919 */     this.jLabClCorpFond.setFont(new java.awt.Font("Tahoma", 1, 18));
/*  920 */     this.jLabClCorpFond.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  921 */     this.jLabClCorpFond.setCursor(new java.awt.Cursor(12));
/*  922 */     this.jLabClCorpFond.setOpaque(true);
/*  923 */     this.jLabClCorpFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  925 */         FormeMLDEntite2.this.jLabClCorpFondMouseClicked(evt);
/*      */       }
/*      */       
/*  928 */     });
/*  929 */     this.jLabel10.setHorizontalAlignment(0);
/*  930 */     this.jLabel10.setText("Fond");
/*  931 */     this.jLabel10.setCursor(new java.awt.Cursor(8));
/*  932 */     this.jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  934 */         FormeMLDEntite2.this.jLabel10MouseClicked(evt);
/*      */       }
/*      */       
/*  937 */     });
/*  938 */     this.jLabel11.setHorizontalAlignment(0);
/*  939 */     this.jLabel11.setText("Nom");
/*  940 */     this.jLabel11.setCursor(new java.awt.Cursor(11));
/*  941 */     this.jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  943 */         FormeMLDEntite2.this.jLabel11MouseClicked(evt);
/*      */       }
/*      */       
/*  946 */     });
/*  947 */     this.jLabClcorpsAttribut.setBackground(new Color(255, 255, 255));
/*  948 */     this.jLabClcorpsAttribut.setFont(new java.awt.Font("Tahoma", 1, 18));
/*  949 */     this.jLabClcorpsAttribut.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  950 */     this.jLabClcorpsAttribut.setCursor(new java.awt.Cursor(12));
/*  951 */     this.jLabClcorpsAttribut.setOpaque(true);
/*  952 */     this.jLabClcorpsAttribut.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  954 */         FormeMLDEntite2.this.jLabClcorpsAttributMouseClicked(evt);
/*      */       }
/*      */       
/*  957 */     });
/*  958 */     this.jLabClCorpType.setBackground(new Color(255, 255, 255));
/*  959 */     this.jLabClCorpType.setFont(new java.awt.Font("Tahoma", 1, 18));
/*  960 */     this.jLabClCorpType.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  961 */     this.jLabClCorpType.setCursor(new java.awt.Cursor(12));
/*  962 */     this.jLabClCorpType.setOpaque(true);
/*  963 */     this.jLabClCorpType.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  965 */         FormeMLDEntite2.this.jLabClCorpTypeMouseClicked(evt);
/*      */       }
/*      */       
/*  968 */     });
/*  969 */     this.jLabel14.setHorizontalAlignment(0);
/*  970 */     this.jLabel14.setText("Type");
/*  971 */     this.jLabel14.setCursor(new java.awt.Cursor(11));
/*  972 */     this.jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  974 */         FormeMLDEntite2.this.jLabel14MouseClicked(evt);
/*      */       }
/*      */       
/*  977 */     });
/*  978 */     this.jLabClCorpTaille.setBackground(new Color(255, 255, 255));
/*  979 */     this.jLabClCorpTaille.setFont(new java.awt.Font("Tahoma", 1, 18));
/*  980 */     this.jLabClCorpTaille.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  981 */     this.jLabClCorpTaille.setCursor(new java.awt.Cursor(12));
/*  982 */     this.jLabClCorpTaille.setOpaque(true);
/*  983 */     this.jLabClCorpTaille.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  985 */         FormeMLDEntite2.this.jLabClCorpTailleMouseClicked(evt);
/*      */       }
/*      */       
/*  988 */     });
/*  989 */     this.jLabel18.setHorizontalAlignment(0);
/*  990 */     this.jLabel18.setText("Taille");
/*  991 */     this.jLabel18.setCursor(new java.awt.Cursor(11));
/*  992 */     this.jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  994 */         FormeMLDEntite2.this.jLabel18MouseClicked(evt);
/*      */       }
/*      */       
/*  997 */     });
/*  998 */     this.jLabClCorpTailleDec.setBackground(new Color(255, 255, 255));
/*  999 */     this.jLabClCorpTailleDec.setFont(new java.awt.Font("Tahoma", 1, 18));
/* 1000 */     this.jLabClCorpTailleDec.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1001 */     this.jLabClCorpTailleDec.setCursor(new java.awt.Cursor(12));
/* 1002 */     this.jLabClCorpTailleDec.setOpaque(true);
/* 1003 */     this.jLabClCorpTailleDec.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1005 */         FormeMLDEntite2.this.jLabClCorpTailleDecMouseClicked(evt);
/*      */       }
/*      */       
/* 1008 */     });
/* 1009 */     this.jLabel19.setHorizontalAlignment(0);
/* 1010 */     this.jLabel19.setText("Taille Dec");
/* 1011 */     this.jLabel19.setCursor(new java.awt.Cursor(11));
/* 1012 */     this.jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1014 */         FormeMLDEntite2.this.jLabel19MouseClicked(evt);
/*      */       }
/*      */       
/* 1017 */     });
/* 1018 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1019 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1020 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabClCorpFond, -1, 56, 32767).addComponent(this.jLabel10, -1, 56, 32767)).addGap(27, 27, 27).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel11, -1, 56, 32767).addComponent(this.jLabClcorpsAttribut, -1, 56, 32767)).addGap(18, 18, 18).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabClCorpType, -1, 56, 32767).addComponent(this.jLabel14, -1, 56, 32767)).addGap(18, 18, 18).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabClCorpTaille, -1, 56, 32767).addComponent(this.jLabel18, -1, 56, 32767)).addGap(18, 18, 18).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel19, -1, -1, 32767).addComponent(this.jLabClCorpTailleDec, -1, 59, 32767)).addContainerGap(27, 32767)));
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
/* 1045 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel10).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClCorpFond, -1, -1, 32767)).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel18).addComponent(this.jLabel19)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabClCorpTailleDec, -1, 19, 32767).addComponent(this.jLabClCorpTaille, -1, -1, 32767))).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel14).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClCorpType, -1, -1, 32767)).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClcorpsAttribut, -2, 20, -2))).addContainerGap(-1, 32767)));
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
/* 1072 */     this.jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Autres Couleurs", 0, 0, new java.awt.Font("Tahoma", 0, 11), new Color(0, 0, 102)));
/*      */     
/* 1074 */     this.jLabel17.setHorizontalAlignment(0);
/* 1075 */     this.jLabel17.setText("Activation");
/*      */     
/* 1077 */     this.jLabClActiver.setBackground(new Color(255, 255, 255));
/* 1078 */     this.jLabClActiver.setFont(new java.awt.Font("Tahoma", 1, 18));
/* 1079 */     this.jLabClActiver.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1080 */     this.jLabClActiver.setCursor(new java.awt.Cursor(12));
/* 1081 */     this.jLabClActiver.setOpaque(true);
/* 1082 */     this.jLabClActiver.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1084 */         FormeMLDEntite2.this.jLabClActiverMouseClicked(evt);
/*      */       }
/*      */       
/* 1087 */     });
/* 1088 */     this.jLabClPage.setBackground(new Color(255, 255, 255));
/* 1089 */     this.jLabClPage.setFont(new java.awt.Font("Tahoma", 1, 18));
/* 1090 */     this.jLabClPage.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1091 */     this.jLabClPage.setCursor(new java.awt.Cursor(12));
/* 1092 */     this.jLabClPage.setOpaque(true);
/* 1093 */     this.jLabClPage.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1095 */         FormeMLDEntite2.this.jLabClPageMouseClicked(evt);
/*      */       }
/*      */       
/* 1098 */     });
/* 1099 */     this.jLabel20.setHorizontalAlignment(0);
/* 1100 */     this.jLabel20.setText("Page");
/*      */     
/* 1102 */     this.jLabClOmbre.setBackground(new Color(255, 255, 255));
/* 1103 */     this.jLabClOmbre.setFont(new java.awt.Font("Tahoma", 1, 18));
/* 1104 */     this.jLabClOmbre.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1105 */     this.jLabClOmbre.setCursor(new java.awt.Cursor(12));
/* 1106 */     this.jLabClOmbre.setOpaque(true);
/* 1107 */     this.jLabClOmbre.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1109 */         FormeMLDEntite2.this.jLabClOmbreMouseClicked(evt);
/*      */       }
/*      */       
/* 1112 */     });
/* 1113 */     this.jLabel22.setHorizontalAlignment(0);
/* 1114 */     this.jLabel22.setText("Ombre");
/*      */     
/* 1116 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1117 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1118 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabClActiver, -1, -1, 32767).addComponent(this.jLabel17, -2, 56, -2)).addGap(81, 81, 81).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel20, -1, -1, 32767).addComponent(this.jLabClPage, -2, 61, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, 32767).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel22, -1, -1, 32767).addComponent(this.jLabClOmbre, -2, 61, -2)).addGap(50, 50, 50)));
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
/* 1135 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jLabel17).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClActiver, -2, 20, -2)).addComponent(this.jLabel20).addGroup(jPanel7Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabClPage, -2, 20, -2)).addComponent(this.jLabel22).addGroup(jPanel7Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabClOmbre, -2, 20, -2))).addContainerGap(-1, 32767)));
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
/* 1154 */     this.jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 1155 */     this.jLabel16.setForeground(new Color(0, 0, 153));
/* 1156 */     this.jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 1157 */     this.jLabel16.setText("Aperçu");
/* 1158 */     this.jLabel16.setCursor(new java.awt.Cursor(12));
/* 1159 */     this.jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1161 */         FormeMLDEntite2.this.jLabel16MouseClicked(evt);
/*      */       }
/*      */       
/* 1164 */     });
/* 1165 */     this.jLabel23.setHorizontalAlignment(0);
/* 1166 */     this.jLabel23.setText("Colonne des clés");
/*      */     
/* 1168 */     this.jLabClPrk.setBackground(new Color(255, 255, 255));
/* 1169 */     this.jLabClPrk.setFont(new java.awt.Font("Tahoma", 1, 18));
/* 1170 */     this.jLabClPrk.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1171 */     this.jLabClPrk.setCursor(new java.awt.Cursor(12));
/* 1172 */     this.jLabClPrk.setOpaque(true);
/* 1173 */     this.jLabClPrk.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1175 */         FormeMLDEntite2.this.jLabClPrkMouseClicked(evt);
/*      */       }
/*      */       
/* 1178 */     });
/* 1179 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1180 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1181 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabel23).addGap(56, 56, 56).addComponent(this.jLabClPrk, -2, 61, -2).addContainerGap(196, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1190 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabClPrk, -2, 20, -2).addComponent(this.jLabel23)).addContainerGap(-1, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1200 */     this.jCBAppliquerAttribut.setText("Appliquer ces couleurs à tous les attributs du MLD");
/*      */     
/* 1202 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1203 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1204 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel6, -1, -1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel7, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, 32767).addComponent(this.jLabel16).addGap(124, 124, 124)).addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBAppliquerAttribut).addComponent(this.jPanApercu, -2, -1, -2)).addGap(20, 20, 20)))));
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
/* 1228 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel6, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel7, -2, -1, -2).addGap(11, 11, 11)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanApercu, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jLabel16))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel3, -2, -1, -2).addComponent(this.jCBAppliquerAttribut)).addGap(35, 35, 35)));
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
/* 1251 */     this.jTabbedPane1.addTab("Affichage/couleurs", this.jPanel2);
/*      */     
/* 1253 */     this.jCBEspasser.setText("Espacer les interlignes des attributs ");
/*      */     
/* 1255 */     this.jCBAfficherPrk.setText("Afficher les legendes Pk (clé primaire)");
/* 1256 */     this.jCBAfficherPrk.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 1258 */         FormeMLDEntite2.this.jCBAfficherPrkActionPerformed(evt);
/*      */       }
/*      */       
/* 1261 */     });
/* 1262 */     this.buttonGroup1.add(this.jRBTexte);
/* 1263 */     this.jRBTexte.setText("Texte");
/*      */     
/* 1265 */     this.buttonGroup1.add(this.jRBImage);
/* 1266 */     this.jRBImage.setText("Image");
/*      */     
/* 1268 */     this.jCBTrierOrganiser.setText("Structurer les attributs selon leur clé");
/*      */     
/* 1270 */     this.jCBEpaisseurEntite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fin", "Moyen", "Gras" }));
/*      */     
/* 1272 */     this.jLabel15.setText("Epaisseur trait entite");
/*      */     
/* 1274 */     this.jTAcommentaire.setColumns(20);
/* 1275 */     this.jTAcommentaire.setFont(new java.awt.Font("Monospaced", 1, 14));
/* 1276 */     this.jTAcommentaire.setRows(5);
/* 1277 */     this.jScrollPane2.setViewportView(this.jTAcommentaire);
/*      */     
/* 1279 */     this.jLabel3.setText("Commentaire ");
/*      */     
/* 1281 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1282 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1283 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addGroup(jPanel8Layout.createSequentialGroup().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBTrierOrganiser).addComponent(this.jCBAfficherPrk).addGroup(jPanel8Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRBImage).addComponent(this.jRBTexte)))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, 32767).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.jLabel15).addGap(18, 18, 18).addComponent(this.jCBEpaisseurEntite, -2, 140, -2)).addComponent(this.jCBEspasser))))).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 737, 32767))).addContainerGap()));
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
/* 1312 */     jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(27, 27, 27).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBAfficherPrk).addComponent(this.jCBEspasser)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRBTexte).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRBImage).addGap(32, 32, 32).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBTrierOrganiser).addComponent(this.jCBEpaisseurEntite, -2, -1, -2).addComponent(this.jLabel15)).addGap(18, 18, 18).addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 163, 32767).addContainerGap()));
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
/* 1335 */     this.jTabbedPane1.addTab("Autres prorpiétés", this.jPanel8);
/*      */     
/* 1337 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 1338 */     this.jBtValider.setText("Valider");
/* 1339 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 1341 */         FormeMLDEntite2.this.jBtValiderActionPerformed(evt);
/*      */       }
/*      */       
/* 1344 */     });
/* 1345 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 1346 */     this.jBtAnnuler.setText("Annuler");
/* 1347 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 1349 */         FormeMLDEntite2.this.jBtAnnulerActionPerformed(evt);
/*      */       }
/*      */       
/* 1352 */     });
/* 1353 */     this.jCBAppliquer.setText("Appliquer à tout le MLD");
/*      */     
/* 1355 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 1356 */     getContentPane().setLayout(layout);
/* 1357 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1, -1, 764, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jTFnom, -2, 312, -2).addGap(18, 18, 18).addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jTFCode, -1, 352, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jCBAppliquer).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, 32767).addComponent(this.jBtAnnuler, -2, 130, -2).addGap(18, 18, 18).addComponent(this.jBtValider, -2, 117, -2))).addContainerGap()));
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
/* 1379 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFnom, -2, 28, -2).addComponent(this.jTFCode, -2, 28, -2).addComponent(this.jLabel2)).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -2, 399, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider, -2, 31, -2).addComponent(this.jBtAnnuler, -2, 32, -2).addComponent(this.jCBAppliquer)).addContainerGap()));
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
/* 1398 */     pack(); }
/*      */   
/*      */   private JLabel jLabel19;
/*      */   
/* 1402 */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }
/*      */   
/*      */   private JLabel jLabel2;
/*      */   
/* 1406 */   private void jBtRemonterActionPerformed(java.awt.event.ActionEvent evt) { if (this.jTableAttribut.getSelectedRow() >= 0)
/* 1407 */       remonterAttribut(this.jTableAttribut.getSelectedRow());
/*      */   }
/*      */   
/*      */   private JLabel jLabel20;
/*      */   private JLabel jLabel22;
/*      */   
/* 1413 */   private void jBtDescendreActionPerformed(java.awt.event.ActionEvent evt) { if (this.jTableAttribut.getSelectedRow() < this.listeAttribut.size() - 1)
/* 1414 */       descendreAttribut(this.jTableAttribut.getSelectedRow());
/*      */   }
/*      */   
/*      */   private JLabel jLabel23;
/*      */   private JLabel jLabel3;
/*      */   
/* 1420 */   private void jLabClEnteteFondMouseClicked(MouseEvent evt) { this.jLabClEnteteFond.setBackground(choixDeCouleur(this.jLabClEnteteFond.getBackground(), "Couleur Fond Titre"));
/* 1421 */     setCouleurExemple();
/* 1422 */     dessinerApercu(); }
/*      */   
/*      */   private JLabel jLabel4;
/*      */   private JLabel jLabel5;
/*      */   private JLabel jLabel8;
/* 1427 */   private void jLabel16MouseClicked(MouseEvent evt) { dessinerApercu(); }
/*      */   
/*      */ 
/*      */   private void jLabClEnteteTexteMouseClicked(MouseEvent evt)
/*      */   {
/* 1432 */     this.jLabClEnteteTexte.setBackground(choixDeCouleur(this.jLabClEnteteTexte.getBackground(), "Couleur Texte Titre"));
/* 1433 */     setCouleurExemple();
/* 1434 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabClCadreMouseClicked(MouseEvent evt) {
/* 1438 */     this.jLabClCadre.setBackground(choixDeCouleur(this.jLabClCadre.getBackground(), "Couleur Cadre"));
/* 1439 */     setCouleurExemple();
/* 1440 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabClCorpFondMouseClicked(MouseEvent evt) {
/* 1444 */     this.jLabClCorpFond.setBackground(choixDeCouleur(this.jLabClCorpFond.getBackground(), "Couleur Fond Attributs"));
/* 1445 */     setCouleurExemple();
/* 1446 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabClcorpsAttributMouseClicked(MouseEvent evt) {
/* 1450 */     this.jLabClcorpsAttribut.setBackground(choixDeCouleur(this.jLabClcorpsAttribut.getBackground(), "Couleur Nom Attribut"));
/* 1451 */     setCouleurExemple();
/* 1452 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabClCorpTypeMouseClicked(MouseEvent evt) {
/* 1456 */     this.jLabClCorpType.setBackground(choixDeCouleur(this.jLabClCorpType.getBackground(), "Couleur Type Attribut"));
/* 1457 */     setCouleurExemple();
/* 1458 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabClActiverMouseClicked(MouseEvent evt) {
/* 1462 */     this.jLabClActiver.setBackground(choixDeCouleur(this.jLabClActiver.getBackground(), "Couleur Lien Activer"));
/* 1463 */     setCouleurExemple();
/* 1464 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabClPageMouseClicked(MouseEvent evt) {
/* 1468 */     this.jLabClPage.setBackground(choixDeCouleur(this.jLabClPage.getBackground(), "Couleur Fond de Page MLD"));
/* 1469 */     setCouleurExemple();
/* 1470 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabClOmbreMouseClicked(MouseEvent evt) {
/* 1474 */     this.jLabClOmbre.setBackground(choixDeCouleur(this.jLabClOmbre.getBackground(), "Couleur de l'ombre des entités"));
/* 1475 */     setCouleurExemple();
/* 1476 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jBtValiderActionPerformed(java.awt.event.ActionEvent evt) {
/* 1480 */     String rep = verificationAdaptation.VerificationMLD.verifierMLDentite2(this.listeAttribut);
/* 1481 */     if (rep.trim().length() == 0) {
/* 1482 */       saveDate();
/* 1483 */       saveDataAttribut(this.entite);
/* 1484 */       if (this.jCBTrierOrganiser.isSelected() != this.isComposee) {
/* 1485 */         if (this.jCBTrierOrganiser.isSelected()) {
/* 1486 */           composerAttributAllMLDEntite(this.page.getListeMLDEntite());
/*      */         } else {
/* 1488 */           decomposerAttributAllMLDEntite(this.page.getListeMLDEntite());
/*      */         }
/*      */       }
/* 1491 */       if (this.jCBAppliquerAttribut.isSelected()) {
/* 1492 */         setColorAllAttribut(this.entite.getListeAttributs(), getColor(this.jLabClcorpsAttribut.getBackground()), getColor(this.jLabClCorpType.getBackground()), getColor(this.jLabClCorpTaille.getBackground()), getColor(this.jLabClCorpTailleDec.getBackground()));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1498 */       this.entite.setCommentaire(this.jTAcommentaire.getText());
/* 1499 */       this.page.repaint();
/* 1500 */       if (!this.page.isEntiteModifer()) this.page.setEntiteModifer(this.isEntiteModfier);
/* 1501 */       dispose();
/*      */     } else {
/* 1503 */       javax.swing.JOptionPane.showMessageDialog(this, "Erreur  :\n " + rep, "Erreur", 0);
/* 1504 */       return;
/*      */     }
/*      */   }
/*      */   
/*      */   private void jPanApercuMouseClicked(MouseEvent evt) {
/* 1509 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jCBAfficherPrkActionPerformed(java.awt.event.ActionEvent evt) {
/* 1513 */     if (this.jCBAfficherPrk.isSelected()) {
/* 1514 */       this.jRBImage.setEnabled(true);
/* 1515 */       this.jRBTexte.setEnabled(true);
/*      */     } else {
/* 1517 */       this.jRBImage.setEnabled(false);
/* 1518 */       this.jRBTexte.setEnabled(false);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel10MouseClicked(MouseEvent evt) {
/* 1523 */     this.jLabClCorpFond.setBackground(this.jLabClEnteteFond.getBackground());
/* 1524 */     setCouleurExemple();
/* 1525 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabel4MouseClicked(MouseEvent evt) {
/* 1529 */     this.jLabClEnteteFond.setBackground(this.jLabClCorpFond.getBackground());
/* 1530 */     setCouleurExemple();
/* 1531 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabel11MouseClicked(MouseEvent evt) {
/* 1535 */     this.jLabClcorpsAttribut.setBackground(this.jLabClCorpType.getBackground());
/* 1536 */     setCouleurExemple();
/* 1537 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabel14MouseClicked(MouseEvent evt) {
/* 1541 */     this.jLabClCorpType.setBackground(this.jLabClcorpsAttribut.getBackground());
/* 1542 */     setCouleurExemple();
/* 1543 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabClPrkMouseClicked(MouseEvent evt) {
/* 1547 */     this.jLabClPrk.setBackground(choixDeCouleur(this.jLabClPrk.getBackground(), "Couleur Colonne clés"));
/* 1548 */     setCouleurExemple();
/* 1549 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabClCorpTailleMouseClicked(MouseEvent evt) {
/* 1553 */     this.jLabClCorpTaille.setBackground(choixDeCouleur(this.jLabClCorpTaille.getBackground(), "Couleur Taille Attribut"));
/* 1554 */     setCouleurExemple();
/* 1555 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private JPanel jPanApercu;
/*      */   private JPanel jPanel1;
/*      */   
/*      */   private void jLabel18MouseClicked(MouseEvent evt) {}
/*      */   
/* 1563 */   private void jLabClCorpTailleDecMouseClicked(MouseEvent evt) { this.jLabClCorpTailleDec.setBackground(choixDeCouleur(this.jLabClCorpTailleDec.getBackground(), "Couleur Taille Attribut"));
/* 1564 */     setCouleurExemple();
/* 1565 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private JPanel jPanel2;
/*      */   private JPanel jPanel3;
/*      */   private JPanel jPanel4;
/*      */   private JPanel jPanel6;
/*      */   private JPanel jPanel7;
/*      */   private JPanel jPanel8;
/*      */   private javax.swing.JRadioButton jRBImage;
/*      */   private javax.swing.JRadioButton jRBTexte;
/*      */   private javax.swing.JScrollPane jScrollPane1;
/*      */   private javax.swing.JScrollPane jScrollPane2;
/*      */   private javax.swing.JTextArea jTAcommentaire;
/*      */   private javax.swing.JTextField jTFCode;
/*      */   private javax.swing.JTextField jTFnom;
/*      */   private javax.swing.JTabbedPane jTabbedPane1;
/*      */   private javax.swing.JTable jTableAttribut;
/*      */   private void jLabel19MouseClicked(MouseEvent evt) {}
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeMLDEntite2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */