/*      */ package formes2;
/*      */ 
/*      */ import IhmMCD.IhmPageMCD;
/*      */ import IhmMCD2.ApercuProprieteMCD;
/*      */ import IhmMCD2.ConfigurationMCD2;
/*      */ import IhmMCD2.IhmCIF2;
/*      */ import IhmMCD2.IhmCommentaire2;
/*      */ import IhmMCD2.IhmContrainte2;
/*      */ import IhmMCD2.IhmEntite2;
/*      */ import IhmMCD2.IhmHeritage2;
/*      */ import IhmMCD2.IhmLien2;
/*      */ import IhmMCD2.IhmLienCIF2;
/*      */ import IhmMCD2.IhmLienContraintes2;
/*      */ import IhmMCD2.IhmRelation2;
/*      */ import Merise2.Historique;
/*      */ import ihm.FormeInterneMCD;
/*      */ import ihm.Principale;
/*      */ import java.awt.Color;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.ComponentEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.util.ArrayList;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*      */ import javax.swing.LayoutStyle.ComponentPlacement;
/*      */ 
/*      */ public class FormeProprieteMCD2 extends javax.swing.JDialog
/*      */ {
/*      */   Principale frm;
/*      */   FormeInterneMCD frmMCD;
/*      */   ConfigurationMCD2 config;
/*      */   ApercuProprieteMCD panApercu;
/*   48 */   public static float EPAISSEUR_FIN = 1.0F;
/*   49 */   public static float EPAISSEUR_MOYEN = 1.5F;
/*   50 */   public static float EPAISSEUR_GRAS = 3.0F;
/*   51 */   static boolean INTERLIGNE = true;
/*      */   private ButtonGroup buttonGroup1;
/*      */   private JComboBox jBoxContrainte;
/*      */   private JComboBox jBoxEntite;
/*      */   
/*      */   public FormeProprieteMCD2(Principale parent, boolean modal, FormeInterneMCD frmMCD)
/*      */   {
/*   55 */     super(parent, modal);
/*   56 */     initComponents();
/*   57 */     this.frm = parent;
/*   58 */     this.frmMCD = frmMCD;
/*   59 */     this.config = frmMCD.getPage().getConfigurationMCD();
/*      */     
/*   61 */     setLocation(this.frm.getX() + 200, this.frm.getY() + 50);
/*   62 */     this.panApercu = new ApercuProprieteMCD();
/*   63 */     this.panApercu.setSize(this.jPanelApercu.getWidth(), this.jPanelApercu.getHeight());
/*   64 */     this.jPanelApercu.add(this.panApercu);
/*      */     
/*   66 */     initialiserFenetre(this.config);
/*      */     
/*   68 */     this.panApercu.repaint();
/*      */     
/*      */ 
/*   71 */     this.jBtAnnuler.setMnemonic(65);
/*   72 */     this.jBtValider.setMnemonic(10);
/*      */   }
/*      */   
/*      */   private JComboBox jBoxLienContrainte;
/*      */   private JComboBox jBoxLienEntite;
/*      */   private JButton jBtAnnuler;
/*      */   private JButton jBtCommetaire;
/*      */   private JButton jBtHistorique;
/*      */   private JButton jBtRegleGest;
/*      */   private JButton jBtValider;
/*      */   private JCheckBox jCBAfficherType;
/*      */   private JCheckBox jCBArrondir;
/*      */   private JCheckBox jCBCardinaliteMajuscule;
/*      */   private JCheckBox jCBCardinaliteSeparateur;
/*      */   private JComboBox jCBChoixCouleur;
/*      */   private JCheckBox jCBDegradee;
/*      */   private JCheckBox jCBInterLigne;
/*      */   private JCheckBox jCBOmbre;
/*      */   private JCheckBox jCBPrk;
/*      */   
/*      */   public void corrigeAuteur(ConfigurationMCD2 config)
/*      */   {
/*   90 */     if (config.getHistorique().size() == 1)
/*      */     {
/*   91 */       String nom = this.jTFDeveloppeur.getText().trim();
/*   92 */       ((Historique)config.getHistorique().get(0)).setDeveloppeur(this.jTFDeveloppeur.getText().trim());
/*      */     }
/*      */   }
/*      */   
/*      */   public void ajouterModficationHistorique()
/*      */   {
/*   97 */     Outil.Setting.developpeur = this.jTFDeveloppeur.getText().trim();
/*   98 */     corrigeAuteur(this.config);
/*   99 */     String nom = Outil.Setting.developpeur;
/*  100 */     Historique h = Historique.getHistoriqueModification();
/*  101 */     if (this.config.getHistorique().size() == 1)
/*      */     {
/*  101 */       this.config.getHistorique().add(h);
/*      */     }
/*      */     else
/*      */     {
/*  103 */       Historique hD = (Historique)this.config.getHistorique().get(this.config.getHistorique().size() - 1);
/*  104 */       if (!hD.getHistoiqueString().equals(h.getHistoiqueString())) {
/*  105 */         this.config.getHistorique().add(h);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void initialiserFenetre(ConfigurationMCD2 config)
/*      */   {
/*  111 */     this.jTFDeveloppeur.setText(config.auteur);
/*  112 */     this.jTFVersion.setText(config.version);
/*      */     
/*  114 */     this.jTFNomMCD.setText(config.getNomMCD());
/*  115 */     this.jTFPath.setText(config.getChemin());
/*      */     
/*  117 */     this.jCBAfficherType.setSelected(config.afficheType2);
/*  118 */     this.jCBCardinaliteMajuscule.setSelected(config.cardinaliteMajuscule2);
/*  119 */     this.jCBCardinaliteSeparateur.setSelected(config.cardinalite2points2);
/*  120 */     this.jCBDegradee.setSelected(config.isDegradee2);
/*      */     
/*  122 */     this.jCBInterLigne.setSelected(config.interLigne2 >= 1.2D);
/*  123 */     this.jCBOmbre.setSelected(config.isOmbree2);
/*      */     
/*  125 */     this.jCBPrk.setSelected(config.afficherPrk2);
/*  126 */     this.jRBPrkImage.setSelected(config.afficherPrkImage2);
/*  127 */     this.jRBPrkTexte.setSelected(!config.afficherPrkImage2);
/*      */     
/*  129 */     if (config.afficherPrk2) {
/*  130 */       this.jRBPrkImage.setEnabled(true);
/*  131 */       this.jRBPrkTexte.setEnabled(true);
/*      */     } else {
/*  133 */       this.jRBPrkImage.setEnabled(false);
/*  134 */       this.jRBPrkTexte.setEnabled(false);
/*      */     }
/*      */     
/*      */ 
/*  138 */     this.jCBTypeMajuscule.setSelected(config.typeMajuscule2);
/*      */     
/*  140 */     this.jBoxEntite.setSelectedIndex(getSelectedEpaisseur(config.traitEntiteRelation2));
/*  141 */     this.jBoxLienEntite.setSelectedIndex(getSelectedEpaisseur(config.lienEntiteRelation2));
/*  142 */     this.jBoxContrainte.setSelectedIndex(getSelectedEpaisseur(config.traitContraintes2));
/*  143 */     this.jBoxLienContrainte.setSelectedIndex(getSelectedEpaisseur(config.lienContraintes2));
/*      */     
/*  145 */     this.jLabClPage.setBackground(ConfigurationMCD2.getColor(config.clPage2));
/*  146 */     this.jLabOmbre.setBackground(ConfigurationMCD2.getColor(config.clOmbre2));
/*  147 */     this.panApercu.setCouleurConfiguration(config);
/*  148 */     this.jTACommenaire.setText(config.Commentaire);
/*  149 */     this.jTARegleGestion.setText(config.regleGestion);
/*  150 */     this.jCBArrondir.setSelected(config.arrondirEntite2);
/*      */   }
/*      */   
/*      */   private void setOmbreDegradee()
/*      */   {
/*  155 */     Color ombre = this.jLabOmbre.getBackground();
/*  156 */     Color page = this.jLabClPage.getBackground();
/*  157 */     boolean isOmbre = this.jCBOmbre.isSelected();
/*  158 */     boolean degrad = this.jCBDegradee.isSelected();
/*  159 */     float traitEnt = getEpaisseur(this.jBoxEntite.getSelectedItem().toString());
/*      */     
/*      */ 
/*      */ 
/*  163 */     float inter = this.jCBInterLigne.isSelected() ? 1.15F : 1.35F;
/*      */     
/*  165 */     this.panApercu.setProprieteEntiteRelation(this.jCBTypeMajuscule.isSelected(), inter, traitEnt, this.jCBPrk.isSelected(), this.jCBAfficherType.isSelected());
/*  166 */     this.panApercu.setOmbreDegradee(degrad, isOmbre, ombre);
/*  167 */     this.panApercu.setClPage(page);
/*      */     
/*  169 */     this.panApercu.repaint();
/*      */   }
/*      */   private JCheckBox jCBTypeMajuscule;
/*      */   private JCheckBox jCheckBox1;
/*      */   
/*      */   private Color choixDeCouleur(Color color, String titre)
/*      */   {
/*  173 */     Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/*  174 */     if (col == null) return color;
/*  175 */     return col;
/*      */   }
/*      */   
/*      */   private JLabel jLabClPage;
/*      */   private JLabel jLabOmbre;
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel10;
/*      */   
/*      */   private float getEpaisseur(String ep)
/*      */   {
/*  179 */     if (ep.equals("FIN")) return EPAISSEUR_FIN;
/*  180 */     if (ep.equals("MOYEN")) return EPAISSEUR_MOYEN;
/*  181 */     return EPAISSEUR_GRAS;
/*      */   }
/*      */   
/*      */   private JLabel jLabel12;
/*      */   private JLabel jLabel13;
/*      */   
/*      */   private int getSelectedEpaisseur(float ep)
/*      */   {
/*  185 */     if (ep == EPAISSEUR_FIN) return 0;
/*  186 */     if (ep == EPAISSEUR_MOYEN) return 1;
/*  187 */     if (ep == EPAISSEUR_GRAS) return 2;
/*  188 */     return 0;
/*      */   }
/*      */   
/*      */   private JLabel jLabel18;
/*      */   
/*      */   private void setEpaisseurMCD()
/*      */   {
/*  192 */     float epEnt = getEpaisseur(this.jBoxEntite.getSelectedItem().toString());
/*  193 */     float epLienEnt = getEpaisseur(this.jBoxLienEntite.getSelectedItem().toString());
/*  194 */     float epCont = getEpaisseur(this.jBoxContrainte.getSelectedItem().toString());
/*  195 */     float epLienCont = getEpaisseur(this.jBoxLienContrainte.getSelectedItem().toString());
/*      */     
/*  197 */     for (int i = 0; i < this.frmMCD.getPage().getListeEntiteRelation().size(); i++) {
/*  198 */       if ((this.frmMCD.getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/*  199 */         ((IhmRelation2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setEpaisseur(epEnt);
/*      */ 
/*      */       }
/*  202 */       else if ((this.frmMCD.getPage().getListeEntiteRelation().get(i) instanceof IhmEntite2)) {
/*  203 */         ((IhmEntite2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setEpaisseur(epEnt);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  208 */     for (int i = 0; i < this.frmMCD.getPage().getListeLien().size(); i++) {
/*  209 */       ((IhmLien2)this.frmMCD.getPage().getListeLien().get(i)).setEpaisseur(epLienEnt);
/*      */     }
/*      */     
/*  212 */     for (int i = 0; i < this.frmMCD.getPage().getListeContrainte().size(); i++) {
/*  213 */       ((IhmContrainte2)this.frmMCD.getPage().getListeContrainte().get(i)).setEpaisseur(epCont);
/*      */     }
/*      */     
/*  216 */     for (int i = 0; i < this.frmMCD.getPage().getListeCIF().size(); i++) {
/*  217 */       ((IhmCIF2)this.frmMCD.getPage().getListeCIF().get(i)).setEpaisseur(epCont);
/*      */     }
/*      */     
/*  220 */     for (int i = 0; i < this.frmMCD.getPage().getListeHeritage().size(); i++) {
/*  221 */       ((IhmHeritage2)this.frmMCD.getPage().getListeHeritage().get(i)).setEpaisseur(epCont);
/*      */     }
/*      */     
/*  224 */     for (int i = 0; i < this.frmMCD.getPage().getListeLienContrainte().size(); i++) {
/*  225 */       ((IhmLienContraintes2)this.frmMCD.getPage().getListeLienContrainte().get(i)).setEpaisseur(epLienCont);
/*      */     }
/*      */     
/*  228 */     for (int i = 0; i < this.frmMCD.getPage().getListelienCIF().size(); i++) {
/*  229 */       ((IhmLienCIF2)this.frmMCD.getPage().getListelienCIF().get(i)).setEpaisseur(epLienCont);
/*      */     }
/*      */     
/*  232 */     for (int i = 0; i < this.frmMCD.getPage().getListeLienContrainteHeritage().size(); i++)
/*  233 */       ((IhmMCD2.IhmLienContrainteHeritage2)this.frmMCD.getPage().getListeLienContrainteHeritage().get(i)).setEpaisseur(epLienCont); }
/*      */   
/*      */   private JLabel jLabel2;
/*      */   private JLabel jLabel3;
/*      */   
/*  238 */   private void setPropritesMCD() { boolean afficheType = this.jCBAfficherType.isSelected();
/*  239 */     boolean cardMaj = this.jCBCardinaliteMajuscule.isSelected();
/*  240 */     boolean cardSepar = this.jCBCardinaliteSeparateur.isSelected();
/*  241 */     boolean clDegradee = this.jCBDegradee.isSelected();
/*  242 */     boolean clOmbre = this.jCBOmbre.isSelected();
/*  243 */     boolean prk = this.jCBPrk.isSelected();
/*  244 */     boolean typeMaj = this.jCBTypeMajuscule.isSelected();
/*  245 */     boolean interLigne = this.jCBInterLigne.isSelected();
/*  246 */     float intLigne = interLigne ? 1.35F : 1.15F;
/*  247 */     boolean arrondir = this.jCBArrondir.isSelected();
/*      */     
/*  249 */     for (int i = 0; i < this.frmMCD.getPage().getListeEntiteRelation().size(); i++) {
/*  250 */       if ((this.frmMCD.getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/*  251 */         ((IhmRelation2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setClDegradee(clDegradee);
/*  252 */         ((IhmRelation2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setOmbre(clOmbre);
/*  253 */         ((IhmRelation2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setVariable(afficheType);
/*  254 */         ((IhmRelation2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setAttMajuscule(typeMaj);
/*  255 */         ((IhmRelation2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setAttEspace(intLigne);
/*  256 */         ((IhmRelation2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setPrkvisible(prk);
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*  261 */       else if ((this.frmMCD.getPage().getListeEntiteRelation().get(i) instanceof IhmEntite2))
/*      */       {
/*  263 */         ((IhmEntite2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setClDegradee(clDegradee);
/*  264 */         ((IhmEntite2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setOmbre(clOmbre);
/*  265 */         ((IhmEntite2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setVariable(afficheType);
/*  266 */         ((IhmEntite2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setAttMajuscule(typeMaj);
/*  267 */         ((IhmEntite2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setAttEspace(intLigne);
/*  268 */         ((IhmEntite2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setPrkvisible(prk);
/*  269 */         ((IhmEntite2)this.frmMCD.getPage().getListeEntiteRelation().get(i)).setArrondir(arrondir);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  274 */     for (int i = 0; i < this.frmMCD.getPage().getListeLien().size(); i++) {
/*  275 */       ((IhmLien2)this.frmMCD.getPage().getListeLien().get(i)).setCardinalite2points(cardSepar);
/*  276 */       ((IhmLien2)this.frmMCD.getPage().getListeLien().get(i)).setCardinaliteMajuscule(cardMaj);
/*      */     }
/*      */   }
/*      */   
/*      */   private JLabel jLabel4;
/*      */   private JLabel jLabel5;
/*      */   private JLabel jLabel7;
/*      */   private JLabel jLabel8;
/*      */   
/*  285 */   private void enregsitrerConfiguration() { this.config.auteur = this.jTFDeveloppeur.getText();
/*  286 */     this.config.version = this.jTFVersion.getText();
/*  287 */     this.config.nomMCD = this.jTFNomMCD.getText();
/*  288 */     this.config.afficheType2 = this.jCBAfficherType.isSelected();
/*  289 */     this.config.isOmbree2 = this.jCBOmbre.isSelected();
/*  290 */     this.config.isDegradee2 = this.jCBDegradee.isSelected();
/*      */     
/*  292 */     this.config.afficherPrk2 = this.jCBPrk.isSelected();
/*  293 */     this.config.afficherPrkImage2 = this.jRBPrkImage.isSelected();
/*  294 */     this.config.typeMajuscule2 = this.jCBTypeMajuscule.isSelected();
/*  295 */     this.config.cardinaliteMajuscule2 = this.jCBCardinaliteMajuscule.isSelected();
/*  296 */     this.config.cardinalite2points2 = this.jCBCardinaliteSeparateur.isSelected();
/*      */     
/*  298 */     this.config.interLigne2 = (this.jCBInterLigne.isSelected() ? 1.35F : 1.15F);
/*      */     
/*  300 */     this.config.traitEntiteRelation2 = getEpaisseur(this.jBoxEntite.getSelectedItem().toString());
/*  301 */     this.config.lienEntiteRelation2 = getEpaisseur(this.jBoxLienEntite.getSelectedItem().toString());
/*  302 */     this.config.traitContraintes2 = getEpaisseur(this.jBoxContrainte.getSelectedItem().toString());
/*  303 */     this.config.lienContraintes2 = getEpaisseur(this.jBoxLienContrainte.getSelectedItem().toString());
/*      */     
/*      */ 
/*  306 */     this.config.regleGestion = this.jTARegleGestion.getText();
/*  307 */     this.config.Commentaire = this.jTACommenaire.getText();
/*      */     
/*  309 */     this.config.clPage2 = ConfigurationMCD2.getColor(this.jLabClPage.getBackground());
/*  310 */     this.config.clOmbre2 = ConfigurationMCD2.getColor(this.jLabOmbre.getBackground());
/*  311 */     this.config.arrondirEntite2 = this.jCBArrondir.isSelected();
/*  312 */     this.config.addModifiactionHistorique(); }
/*      */   
/*      */   private JLabel jLabel9;
/*      */   private JPanel jPanel1;
/*  316 */   private void modifierParametreMCD() { Color ombre = this.jLabOmbre.getBackground();
/*  317 */     Color clpage = this.jLabClPage.getBackground();
/*  318 */     boolean isOmbre = this.jCBOmbre.isSelected();
/*  319 */     boolean degrad = this.jCBDegradee.isSelected();
/*  320 */     float traitEnt = getEpaisseur(this.jBoxEntite.getSelectedItem().toString());
/*  321 */     float traitLienEnt = getEpaisseur(this.jBoxLienEntite.getSelectedItem().toString());
/*  322 */     float traitCnt = getEpaisseur(this.jBoxContrainte.getSelectedItem().toString());
/*  323 */     float traitlienCnt = getEpaisseur(this.jBoxLienContrainte.getSelectedItem().toString());
/*  324 */     boolean arrondir = this.jCBArrondir.isSelected();
/*      */     
/*  326 */     float inter = this.jCBInterLigne.isSelected() ? 1.35F : 1.15F;
/*  327 */     IhmPageMCD page = this.frmMCD.getPage();
/*  328 */     for (int i = 0; i < page.getListeEntiteRelation().size(); i++) {
/*  329 */       if ((page.getListeEntiteRelation().get(i) instanceof IhmEntite2)) {
/*  330 */         ((IhmEntite2)page.getListeEntiteRelation().get(i)).setAttMajuscule(this.config.typeMajuscule2);
/*  331 */         ((IhmEntite2)page.getListeEntiteRelation().get(i)).setPrkvisible(this.config.afficherPrk2);
/*  332 */         ((IhmEntite2)page.getListeEntiteRelation().get(i)).setPrkImage(this.config.afficherPrkImage2);
/*      */         
/*  334 */         ((IhmEntite2)page.getListeEntiteRelation().get(i)).setVariable(this.config.afficheType2);
/*  335 */         ((IhmEntite2)page.getListeEntiteRelation().get(i)).setOmbre(this.config.isOmbree2);
/*  336 */         ((IhmEntite2)page.getListeEntiteRelation().get(i)).setClDegradee(this.config.isDegradee2);
/*  337 */         ((IhmEntite2)page.getListeEntiteRelation().get(i)).setClOmbre(ombre);
/*  338 */         ((IhmEntite2)page.getListeEntiteRelation().get(i)).setAttEspace(inter);
/*      */         
/*  340 */         ((IhmEntite2)page.getListeEntiteRelation().get(i)).setEpaisseur(traitEnt);
/*  341 */         ((IhmEntite2)page.getListeEntiteRelation().get(i)).setArrondir(arrondir);
/*      */ 
/*      */       }
/*  344 */       else if ((page.getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/*  345 */         ((IhmRelation2)page.getListeEntiteRelation().get(i)).setAttMajuscule(this.config.typeMajuscule2);
/*  346 */         ((IhmRelation2)page.getListeEntiteRelation().get(i)).setPrkvisible(this.config.afficherPrk2);
/*  347 */         ((IhmRelation2)page.getListeEntiteRelation().get(i)).setVariable(this.config.afficheType2);
/*  348 */         ((IhmRelation2)page.getListeEntiteRelation().get(i)).setOmbre(this.config.isOmbree2);
/*  349 */         ((IhmRelation2)page.getListeEntiteRelation().get(i)).setClDegradee(this.config.isDegradee2);
/*  350 */         ((IhmRelation2)page.getListeEntiteRelation().get(i)).setClOmbre(ombre);
/*  351 */         ((IhmRelation2)page.getListeEntiteRelation().get(i)).setAttEspace(inter);
/*      */         
/*  353 */         ((IhmRelation2)page.getListeEntiteRelation().get(i)).setEpaisseur(traitEnt);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  358 */     for (int i = 0; i < page.getListeCIF().size(); i++) {
/*  359 */       ((IhmCIF2)page.getListeCIF().get(i)).setOmbre(this.config.isOmbree2);
/*  360 */       ((IhmCIF2)page.getListeCIF().get(i)).setClDegradee(this.config.isDegradee2);
/*  361 */       ((IhmCIF2)page.getListeCIF().get(i)).setClOmbre(ombre);
/*  362 */       ((IhmCIF2)page.getListeCIF().get(i)).setEpaisseur(traitCnt);
/*      */     }
/*      */     
/*  365 */     for (int i = 0; i < page.getListeContrainte().size(); i++) {
/*  366 */       ((IhmContrainte2)page.getListeContrainte().get(i)).setOmbre(this.config.isOmbree2);
/*  367 */       ((IhmContrainte2)page.getListeContrainte().get(i)).setClDegradee(this.config.isDegradee2);
/*  368 */       ((IhmContrainte2)page.getListeContrainte().get(i)).setClOmbre(ombre);
/*  369 */       ((IhmContrainte2)page.getListeContrainte().get(i)).setEpaisseur(traitCnt);
/*      */     }
/*      */     
/*  372 */     for (int i = 0; i < page.getListeHeritage().size(); i++) {
/*  373 */       ((IhmHeritage2)page.getListeHeritage().get(i)).setOmbre(this.config.isOmbree2);
/*  374 */       ((IhmHeritage2)page.getListeHeritage().get(i)).setClDegradee(this.config.isDegradee2);
/*  375 */       ((IhmHeritage2)page.getListeHeritage().get(i)).setClOmbre(ombre);
/*  376 */       ((IhmHeritage2)page.getListeHeritage().get(i)).setEpaisseur(traitCnt);
/*      */     }
/*      */     
/*  379 */     for (int i = 0; i < page.getListeCommentaire().size(); i++) {
/*  380 */       if ((page.getListeCommentaire().get(i) instanceof IhmCommentaire2)) {
/*  381 */         ((IhmCommentaire2)page.getListeCommentaire().get(i)).setOmbre(this.config.isOmbree2);
/*  382 */         ((IhmCommentaire2)page.getListeCommentaire().get(i)).setClDegradee(this.config.isDegradee2);
/*  383 */         ((IhmCommentaire2)page.getListeCommentaire().get(i)).setClOmbre(ombre);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  388 */     for (int i = 0; i < page.getListeLien().size(); i++) {
/*  389 */       ((IhmLien2)page.getListeLien().get(i)).setEpaisseur(traitLienEnt);
/*  390 */       ((IhmLien2)page.getListeLien().get(i)).setCardinaliteMajuscule(this.config.cardinaliteMajuscule2);
/*  391 */       ((IhmLien2)page.getListeLien().get(i)).setCardinalite2points(this.config.cardinalite2points2);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  396 */     for (int i = 0; i < page.getListeLienContrainte().size(); i++) {
/*  397 */       ((IhmLienContraintes2)page.getListeLienContrainte().get(i)).setEpaisseur(traitlienCnt);
/*      */     }
/*      */     
/*  400 */     for (int i = 0; i < page.getListeLienCommentaire().size(); i++) {
/*  401 */       ((IhmMCD2.IhmLienCommentaire2)page.getListeLienCommentaire().get(i)).setEpaisseur(traitlienCnt);
/*      */     }
/*      */     
/*  404 */     for (int i = 0; i < page.getListelienCIF().size(); i++) {
/*  405 */       ((IhmLienCIF2)page.getListelienCIF().get(i)).setEpaisseur(traitlienCnt);
/*      */     }
/*      */     
/*  408 */     for (int i = 0; i < page.getListeLienContrainteHeritage().size(); i++) {
/*  409 */       ((IhmMCD2.IhmLienContrainteHeritage2)page.getListeLienContrainteHeritage().get(i)).setEpaisseur(traitlienCnt);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private JPanel jPanel2;
/*      */   
/*      */   private JPanel jPanel3;
/*      */   
/*      */   private JPanel jPanel4;
/*      */   private JPanel jPanel5;
/*      */   private JPanel jPanel7;
/*      */   private JPanel jPanel8;
/*      */   private JPanel jPanelApercu;
/*      */   private JRadioButton jRBPrkImage;
/*      */   private JRadioButton jRBPrkTexte;
/*      */   
/*      */   private void initComponents()
/*      */   {
/*  428 */     this.buttonGroup1 = new ButtonGroup();
/*  429 */     this.jBtAnnuler = new JButton();
/*  430 */     this.jBtValider = new JButton();
/*  431 */     this.jPanel1 = new JPanel();
/*  432 */     this.jTabbedPane1 = new JTabbedPane();
/*  433 */     this.jPanel2 = new JPanel();
/*  434 */     this.jLabel3 = new JLabel();
/*  435 */     this.jLabel4 = new JLabel();
/*  436 */     this.jTFDeveloppeur = new JTextField();
/*  437 */     this.jTFVersion = new JTextField();
/*  438 */     this.jBtHistorique = new JButton();
/*  439 */     this.jPanel7 = new JPanel();
/*  440 */     this.jCBAfficherType = new JCheckBox();
/*  441 */     this.jCBCardinaliteSeparateur = new JCheckBox();
/*  442 */     this.jCBPrk = new JCheckBox();
/*  443 */     this.jCBTypeMajuscule = new JCheckBox();
/*  444 */     this.jCBCardinaliteMajuscule = new JCheckBox();
/*  445 */     this.jRBPrkTexte = new JRadioButton();
/*  446 */     this.jRBPrkImage = new JRadioButton();
/*  447 */     this.jCBInterLigne = new JCheckBox();
/*  448 */     this.jPanel8 = new JPanel();
/*  449 */     this.jBoxEntite = new JComboBox();
/*  450 */     this.jLabel7 = new JLabel();
/*  451 */     this.jBoxLienEntite = new JComboBox();
/*  452 */     this.jLabel8 = new JLabel();
/*  453 */     this.jBoxContrainte = new JComboBox();
/*  454 */     this.jLabel9 = new JLabel();
/*  455 */     this.jLabel10 = new JLabel();
/*  456 */     this.jBoxLienContrainte = new JComboBox();
/*  457 */     this.jPanel3 = new JPanel();
/*  458 */     this.jScrollPane1 = new JScrollPane();
/*  459 */     this.jTACommenaire = new JTextArea();
/*  460 */     this.jBtCommetaire = new JButton();
/*  461 */     this.jLabel12 = new JLabel();
/*  462 */     this.jPanel4 = new JPanel();
/*  463 */     this.jScrollPane2 = new JScrollPane();
/*  464 */     this.jTARegleGestion = new JTextArea();
/*  465 */     this.jBtRegleGest = new JButton();
/*  466 */     this.jLabel13 = new JLabel();
/*  467 */     this.jPanel5 = new JPanel();
/*  468 */     this.jPanelApercu = new JPanel();
/*  469 */     this.jLabel18 = new JLabel();
/*  470 */     this.jCBChoixCouleur = new JComboBox();
/*  471 */     this.jCBDegradee = new JCheckBox();
/*  472 */     this.jCBOmbre = new JCheckBox();
/*  473 */     this.jCheckBox1 = new JCheckBox();
/*  474 */     this.jLabel5 = new JLabel();
/*  475 */     this.jLabClPage = new JLabel();
/*  476 */     this.jLabOmbre = new JLabel();
/*  477 */     this.jCBArrondir = new JCheckBox();
/*  478 */     this.jLabel1 = new JLabel();
/*  479 */     this.jLabel2 = new JLabel();
/*  480 */     this.jTFPath = new JTextField();
/*  481 */     this.jTFNomMCD = new JTextField();
/*      */     
/*  483 */     setDefaultCloseOperation(2);
/*  484 */     setTitle("Propriétés du MCD");
/*      */     
/*  486 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/*  487 */     this.jBtAnnuler.setText("Annuler ");
/*  488 */     this.jBtAnnuler.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  490 */         FormeProprieteMCD2.this.jBtAnnulerActionPerformed(evt);
/*      */       }
/*      */       
/*  493 */     });
/*  494 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/*  495 */     this.jBtValider.setText("Valider");
/*  496 */     this.jBtValider.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  498 */         FormeProprieteMCD2.this.jBtValiderActionPerformed(evt);
/*      */       }
/*      */       
/*  501 */     });
/*  502 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  504 */     this.jLabel3.setText("Developpeur ");
/*      */     
/*  506 */     this.jLabel4.setText("Version");
/*      */     
/*  508 */     this.jTFDeveloppeur.setEditable(false);
/*      */     
/*  510 */     this.jTFVersion.setEditable(false);
/*      */     
/*  512 */     this.jBtHistorique.setText("Historique...");
/*  513 */     this.jBtHistorique.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  515 */         FormeProprieteMCD2.this.jBtHistoriqueActionPerformed(evt);
/*      */       }
/*      */       
/*  518 */     });
/*  519 */     this.jCBAfficherType.setText("Afficher le type dans les entités et les relations du  MCD");
/*      */     
/*  521 */     this.jCBCardinaliteSeparateur.setText("Utiliser le caractère : comme séparateur des cardinalités");
/*      */     
/*  523 */     this.jCBPrk.setText("Afficher Prk ( Clé primaire) dans les entités ");
/*  524 */     this.jCBPrk.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  526 */         FormeProprieteMCD2.this.jCBPrkActionPerformed(evt);
/*      */       }
/*      */       
/*  529 */     });
/*  530 */     this.jCBTypeMajuscule.setText("Afficher le type des attributs en majuscule");
/*      */     
/*  532 */     this.jCBCardinaliteMajuscule.setText("Afficher les cadinalités en Majuscule");
/*      */     
/*  534 */     this.buttonGroup1.add(this.jRBPrkTexte);
/*  535 */     this.jRBPrkTexte.setText("Afficher texte");
/*      */     
/*  537 */     this.buttonGroup1.add(this.jRBPrkImage);
/*  538 */     this.jRBPrkImage.setSelected(true);
/*  539 */     this.jRBPrkImage.setText("Afficher Image");
/*      */     
/*  541 */     this.jCBInterLigne.setText("Espacer les interlignes des attributs");
/*      */     
/*  543 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  544 */     this.jPanel7.setLayout(jPanel7Layout);
/*  545 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(17, 17, 17).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBAfficherType).addComponent(this.jCBTypeMajuscule).addComponent(this.jCBInterLigne).addComponent(this.jCBCardinaliteMajuscule).addComponent(this.jCBCardinaliteSeparateur).addComponent(this.jCBPrk).addGroup(jPanel7Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRBPrkImage).addComponent(this.jRBPrkTexte)))).addContainerGap(28, 32767)));
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
/*  563 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.jCBPrk).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRBPrkTexte).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRBPrkImage).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.jCBAfficherType).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBTypeMajuscule).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBInterLigne).addGap(24, 24, 24).addComponent(this.jCBCardinaliteMajuscule).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBCardinaliteSeparateur).addGap(23, 23, 23)));
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
/*  585 */     this.jBoxEntite.setModel(new DefaultComboBoxModel(new String[] { "FIN", "MOYEN", "GRAS" }));
/*      */     
/*  587 */     this.jLabel7.setText("Epaisseur trait Entité/Relation ");
/*      */     
/*  589 */     this.jBoxLienEntite.setModel(new DefaultComboBoxModel(new String[] { "FIN", "MOYEN", "GRAS" }));
/*      */     
/*  591 */     this.jLabel8.setText("Epaisseur lien Entité/Relation  ");
/*      */     
/*  593 */     this.jBoxContrainte.setModel(new DefaultComboBoxModel(new String[] { "FIN", "MOYEN", "GRAS" }));
/*      */     
/*  595 */     this.jLabel9.setText("Epaisseur trait Contraintes ");
/*      */     
/*  597 */     this.jLabel10.setText("Epaisseur lien contraintes");
/*      */     
/*  599 */     this.jBoxLienContrainte.setModel(new DefaultComboBoxModel(new String[] { "FIN", "MOYEN", "GRAS" }));
/*      */     
/*  601 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  602 */     this.jPanel8.setLayout(jPanel8Layout);
/*  603 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup().addContainerGap(143, 32767).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel8Layout.createSequentialGroup().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel10).addComponent(this.jLabel9).addComponent(this.jLabel8)).addGap(19, 19, 19)).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.jLabel7, -1, -1, 32767).addGap(18, 18, 18))).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jBoxLienContrainte, 0, -1, 32767).addComponent(this.jBoxContrainte, GroupLayout.Alignment.TRAILING, 0, -1, 32767).addComponent(this.jBoxLienEntite, GroupLayout.Alignment.TRAILING, 0, -1, 32767).addComponent(this.jBoxEntite, GroupLayout.Alignment.TRAILING, 0, 114, 32767)).addContainerGap()));
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
/*  624 */     jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBoxEntite, -2, -1, -2).addComponent(this.jLabel7)).addGap(18, 18, 18).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBoxLienEntite, -2, -1, -2).addComponent(this.jLabel8)).addGap(18, 18, 18).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBoxContrainte, -2, -1, -2).addComponent(this.jLabel9)).addGap(18, 18, 18).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBoxLienContrainte, -2, -1, -2).addComponent(this.jLabel10)).addContainerGap(141, 32767)));
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
/*  646 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  647 */     this.jPanel2.setLayout(jPanel2Layout);
/*  648 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jLabel4)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jTFDeveloppeur, -2, 423, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 189, 32767).addComponent(this.jBtHistorique)).addComponent(this.jTFVersion, -2, 65, -2))).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel7, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel8, -1, -1, 32767))).addContainerGap()));
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
/*  670 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTFDeveloppeur, -2, -1, -2).addComponent(this.jBtHistorique)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jTFVersion, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel8, -1, -1, 32767).addComponent(this.jPanel7, -1, -1, 32767)).addContainerGap()));
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
/*  689 */     this.jTabbedPane1.addTab("Genéralités", this.jPanel2);
/*      */     
/*  691 */     this.jTACommenaire.setColumns(20);
/*  692 */     this.jTACommenaire.setRows(5);
/*  693 */     this.jScrollPane1.setViewportView(this.jTACommenaire);
/*      */     
/*  695 */     this.jBtCommetaire.setText("...");
/*      */     
/*  697 */     this.jLabel12.setText("Commentaire ");
/*      */     
/*  699 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  700 */     this.jPanel3.setLayout(jPanel3Layout);
/*  701 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 787, 32767).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel12).addGap(18, 18, 18).addComponent(this.jBtCommetaire))).addContainerGap()));
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
/*  713 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtCommetaire).addComponent(this.jLabel12)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 331, 32767).addContainerGap()));
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
/*  725 */     this.jTabbedPane1.addTab("Commentaire", this.jPanel3);
/*      */     
/*  727 */     this.jTARegleGestion.setBackground(new Color(234, 234, 255));
/*  728 */     this.jTARegleGestion.setColumns(20);
/*  729 */     this.jTARegleGestion.setRows(5);
/*  730 */     this.jScrollPane2.setViewportView(this.jTARegleGestion);
/*      */     
/*  732 */     this.jBtRegleGest.setText("...");
/*      */     
/*  734 */     this.jLabel13.setText("Régles de gestion");
/*      */     
/*  736 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  737 */     this.jPanel4.setLayout(jPanel4Layout);
/*  738 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 787, 32767).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel13).addGap(18, 18, 18).addComponent(this.jBtRegleGest))).addContainerGap()));
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
/*  750 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtRegleGest).addComponent(this.jLabel13)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -1, 331, 32767).addContainerGap()));
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
/*  762 */     this.jTabbedPane1.addTab("Régles de gestion", this.jPanel4);
/*      */     
/*  764 */     this.jPanel5.addComponentListener(new java.awt.event.ComponentAdapter() {
/*      */       public void componentShown(ComponentEvent evt) {
/*  766 */         FormeProprieteMCD2.this.jPanel5ComponentShown(evt);
/*      */       }
/*      */       
/*  769 */     });
/*  770 */     this.jPanelApercu.setBackground(new Color(255, 255, 255));
/*      */     
/*  772 */     GroupLayout jPanelApercuLayout = new GroupLayout(this.jPanelApercu);
/*  773 */     this.jPanelApercu.setLayout(jPanelApercuLayout);
/*  774 */     jPanelApercuLayout.setHorizontalGroup(jPanelApercuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 787, 32767));
/*      */     
/*      */ 
/*      */ 
/*  778 */     jPanelApercuLayout.setVerticalGroup(jPanelApercuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 252, 32767));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  783 */     this.jLabel18.setText("Coloration Prédéfinie");
/*      */     
/*  785 */     this.jCBChoixCouleur.setModel(new DefaultComboBoxModel(new String[] { "COULEURS ACTUELLES", "NOIR &  BLANC", "AZUR", "BRIQUE", "ADAM", "LAHNA" }));
/*  786 */     this.jCBChoixCouleur.setEnabled(false);
/*      */     
/*  788 */     this.jCBDegradee.setText("Couleur dégradée");
/*  789 */     this.jCBDegradee.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  791 */         FormeProprieteMCD2.this.jCBDegradeeActionPerformed(evt);
/*      */       }
/*      */       
/*  794 */     });
/*  795 */     this.jCBOmbre.setText("Ombré");
/*  796 */     this.jCBOmbre.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  798 */         FormeProprieteMCD2.this.jCBOmbreActionPerformed(evt);
/*      */       }
/*      */       
/*  801 */     });
/*  802 */     this.jCheckBox1.setText("Appliquer ces couleurs à mon MCD");
/*  803 */     this.jCheckBox1.setEnabled(false);
/*      */     
/*  805 */     this.jLabel5.setText("Fond de la page MCD ");
/*      */     
/*  807 */     this.jLabClPage.setBackground(new Color(255, 255, 255));
/*  808 */     this.jLabClPage.setText("                  ");
/*  809 */     this.jLabClPage.setCursor(new java.awt.Cursor(12));
/*  810 */     this.jLabClPage.setOpaque(true);
/*  811 */     this.jLabClPage.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  813 */         FormeProprieteMCD2.this.jLabClPageMouseClicked(evt);
/*      */       }
/*      */       
/*  816 */     });
/*  817 */     this.jLabOmbre.setBackground(new Color(102, 102, 102));
/*  818 */     this.jLabOmbre.setText("                  ");
/*  819 */     this.jLabOmbre.setCursor(new java.awt.Cursor(12));
/*  820 */     this.jLabOmbre.setOpaque(true);
/*  821 */     this.jLabOmbre.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  823 */         FormeProprieteMCD2.this.jLabOmbreMouseClicked(evt);
/*      */       }
/*      */       
/*  826 */     });
/*  827 */     this.jCBArrondir.setText("Arrondir les entités");
/*  828 */     this.jCBArrondir.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  830 */         FormeProprieteMCD2.this.jCBArrondirActionPerformed(evt);
/*      */       }
/*      */       
/*  833 */     });
/*  834 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  835 */     this.jPanel5.setLayout(jPanel5Layout);
/*  836 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jPanelApercu, -1, -1, 32767).addContainerGap()).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel18).addComponent(this.jCBChoixCouleur, -2, 302, -2).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel5).addGap(18, 18, 18).addComponent(this.jLabClPage, -2, 72, -2))).addGap(18, 18, 18).addComponent(this.jCheckBox1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBArrondir).addComponent(this.jCBDegradee).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jCBOmbre).addGap(31, 31, 31).addComponent(this.jLabOmbre, -2, 72, -2))).addGap(46, 46, 46)))));
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
/*  864 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup().addComponent(this.jLabel18).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBChoixCouleur, -2, -1, -2).addComponent(this.jCheckBox1)).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jLabClPage, -2, 22, -2))).addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup().addComponent(this.jCBDegradee).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBOmbre).addComponent(this.jLabOmbre, -2, 22, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBArrondir))).addGap(26, 26, 26).addComponent(this.jPanelApercu, -2, -1, -2).addContainerGap()));
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
/*  892 */     this.jTabbedPane1.addTab("Affichage (Couleurs)", this.jPanel5);
/*      */     
/*  894 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  895 */     this.jPanel1.setLayout(jPanel1Layout);
/*  896 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -1, 812, 32767).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  903 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  911 */     this.jLabel1.setText("Emplacement ");
/*      */     
/*  913 */     this.jLabel2.setText("Nom MCD");
/*      */     
/*  915 */     this.jTFPath.setEditable(false);
/*      */     
/*  917 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  918 */     getContentPane().setLayout(layout);
/*  919 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFNomMCD, -1, 750, 32767).addComponent(this.jTFPath, -1, 750, 32767))).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider, -2, 98, -2))).addContainerGap()));
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
/*  939 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFPath, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTFNomMCD, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
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
/*  959 */     pack(); }
/*      */   
/*      */   private JScrollPane jScrollPane1;
/*      */   
/*  963 */   private void jBtAnnulerActionPerformed(ActionEvent evt) { dispose(); }
/*      */   
/*      */   private JScrollPane jScrollPane2;
/*      */   
/*  967 */   private void jBtValiderActionPerformed(ActionEvent evt) { enregsitrerConfiguration();
/*  968 */     this.frmMCD.initialiserParametreMCD(this.config);
/*  969 */     modifierParametreMCD();
/*  970 */     this.frmMCD.getPage().repaint();
/*  971 */     dispose(); }
/*      */   
/*      */   private JTextArea jTACommenaire;
/*      */   
/*  975 */   private void jLabClPageMouseClicked(MouseEvent evt) { this.jLabClPage.setBackground(choixDeCouleur(this.jLabClPage.getBackground(), "Couleur de la Page MCD"));
/*  976 */     this.panApercu.setClPage(this.jLabClPage.getBackground());
/*  977 */     setOmbreDegradee();
/*  978 */     this.panApercu.repaint(); }
/*      */   
/*      */   private JTextArea jTARegleGestion;
/*      */   private JTextField jTFDeveloppeur;
/*  982 */   private void jLabOmbreMouseClicked(MouseEvent evt) { this.jLabOmbre.setBackground(choixDeCouleur(this.jLabOmbre.getBackground(), "Couleur de la Page MCD"));
/*  983 */     setOmbreDegradee();
/*  984 */     this.panApercu.repaint(); }
/*      */   
/*      */   private JTextField jTFNomMCD;
/*      */   private JTextField jTFPath;
/*  988 */   private JTextField jTFVersion; private JTabbedPane jTabbedPane1; private void jCBDegradeeActionPerformed(ActionEvent evt) { setOmbreDegradee(); }
/*      */   
/*      */ 
/*      */   private void jCBOmbreActionPerformed(ActionEvent evt) {
/*  992 */     setOmbreDegradee();
/*      */   }
/*      */   
/*      */   private void jPanel5ComponentShown(ComponentEvent evt) {
/*  996 */     setOmbreDegradee();
/*      */   }
/*      */   
/*      */   private void jBtHistoriqueActionPerformed(ActionEvent evt) {
/* 1000 */     new FormeHistorique(this.frm, true, this.config.getHistorique(), "", "").setVisible(true);
/*      */   }
/*      */   
/*      */   private void jCBArrondirActionPerformed(ActionEvent evt) {
/* 1004 */     this.panApercu.setArrondir(this.jCBArrondir.isSelected());
/* 1005 */     this.panApercu.repaint();
/*      */   }
/*      */   
/*      */   private void jCBPrkActionPerformed(ActionEvent evt) {
/* 1009 */     if (this.jCBPrk.isSelected()) {
/* 1010 */       this.jRBPrkImage.setEnabled(true);
/* 1011 */       this.jRBPrkTexte.setEnabled(true);
/*      */     } else {
/* 1013 */       this.jRBPrkImage.setEnabled(false);
/* 1014 */       this.jRBPrkTexte.setEnabled(false);
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeProprieteMCD2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */