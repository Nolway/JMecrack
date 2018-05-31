/*      */ package formes2;
/*      */ 
/*      */ import Merise2.Attribut2;
/*      */ import Outil.Parametres;
/*      */ import Outil.Setting;
/*      */ import Output.SQLOutil;
/*      */ import Thasaruts.ThaOutils;
/*      */ import Thasaruts.Thassarut;
/*      */ import ihm.Principale;
/*      */ import input.InfoSite;
/*      */ import java.awt.Color;
/*      */ import java.awt.Container;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.util.ArrayList;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JPasswordField;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*      */ import javax.swing.LayoutStyle.ComponentPlacement;
/*      */ import javax.swing.event.ChangeEvent;
/*      */ import javax.swing.event.ChangeListener;
/*      */ import mythread.ThreadSite;
/*      */ 
/*      */ public class FormeSetting2
/*      */   extends JDialog
/*      */ {
/*      */   private Principale frm;
/*      */   private Attribut2 attribut;
/*      */   private JCheckBox JCBaugmentationNomComplet;
/*      */   private ButtonGroup buttonGroup1;
/*      */   private ButtonGroup buttonGroup2;
/*      */   private JButton jBtAnnuler;
/*      */   private JButton jBtValider;
/*      */   private JButton jButton1;
/*      */   private JButton jButton3;
/*      */   private JCheckBox jCBAttMere;
/*      */   private JCheckBox jCBAttUniq;
/*      */   private JCheckBox jCBAugmentation;
/*      */   private JCheckBox jCBCleSiNecessaireMere;
/*      */   private JCheckBox jCBDesactiverHeritage;
/*      */   private JCheckBox jCBHeritageMult;
/*      */   private JCheckBox jCBImprimerDeveloppeur;
/*      */   private JCheckBox jCBImprimerNomMCD;
/*      */   private JCheckBox jCBImprimerNumPage;
/*      */   private JComboBox jCBImprimerOrientation;
/*      */   private JCheckBox jCBInclureCommentAttSQL;
/*      */   private JCheckBox jCBInclureCommentTableSQL;
/*      */   private JCheckBox jCBInformProprieteMCD;
/*      */   private JCheckBox jCBLimitationPages;
/*      */   private JCheckBox jCBMLDAfficherNomLien2;
/*      */   private JCheckBox jCBMLDStructurerAtt2;
/*      */   
/*      */   public FormeSetting2(Principale parent, boolean modal)
/*      */   {
/*   36 */     super(parent, modal);
/*   37 */     initComponents();
/*   38 */     this.frm = parent;
/*   39 */     setLocation(this.frm.getX() + 200, this.frm.getY() + 100);
/*   40 */     this.jBtAnnuler.setMnemonic(65);
/*   41 */     this.jBtValider.setMnemonic(10);
/*   42 */     this.attribut = ((Attribut2)Setting.attributCle.copier());
/*      */     
/*   44 */     initData();
/*   45 */     remplirLicence();
/*      */   }
/*      */   
/*      */   private void remplirLicence()
/*      */   {
/*   50 */     if (Setting.licence == null) {
/*   51 */       this.jTALicence.setText("");
/*   52 */       return;
/*      */     }
/*   54 */     if (Setting.licence.isLicence()) {
/*   55 */       String s = "N° Activation =" + Setting.licence.getThassarouts() + "\t\t N°User = " + Setting.licence.getIdUser() + "\n";
/*   56 */       s = s + "Date début =" + Setting.licence.getAss_ivdha() + "\n";
/*   57 */       s = s + "Date Fin =" + Setting.licence.getAss_ifuk() + "\n\n";
/*   58 */       int nbjour = ThaOutils.nombreDeJour(Setting.licence.getAss_ifuk(), ThaOutils.getDateJour());
/*   59 */       if (nbjour < 45) s = s + "A renouveller dans = " + (nbjour - 1) + " jours.";
/*   60 */       this.jTALicence.setText(s);
/*   61 */       return;
/*      */     }
/*   63 */     if (!Setting.licence.isLicence())
/*      */     {
/*   64 */       String s = "N° Activation = Version limitée \n\n";
/*   65 */       s = s + "Date début = " + Setting.licence.getAss_ivdha() + "\n";
/*      */       
/*   67 */       int nbjour = ThaOutils.nombreDeJour(Setting.licence.getAss_ifuk(), ThaOutils.getDateJour());
/*   68 */       if (nbjour < 20) { s = s + "\nA A télécharger une nouvelle version JMerise avant =" + Setting.licence.getAss_ifuk() + " (" + nbjour + " jours)";
/*      */       }
/*   70 */       this.jTALicence.setText(s);
/*   71 */       return;
/*      */     }
/*      */   }
/*      */   
/*      */   private void initSQL(String s)
/*      */   {
/*   76 */     if (s.equals(SQLOutil.SQLACCESS)) {
/*   77 */       this.jRBAccess.setSelected(true);
/*      */     }
/*   79 */     if (s.equals(SQLOutil.SQLDERBY)) {
/*   80 */       this.jRBDerby.setSelected(true);
/*      */     }
/*   82 */     if (s.equals(SQLOutil.SQLFIREBIRD)) {
/*   83 */       this.jRBFireBird.setSelected(true);
/*      */     }
/*   85 */     if (s.equals(SQLOutil.SQLITE)) {
/*   86 */       this.jRBSQLite.setSelected(true);
/*      */     }
/*   88 */     if (s.equals(SQLOutil.SQLMYSQL)) {
/*   89 */       this.jRBMySQL.setSelected(true);
/*      */     }
/*   91 */     if (s.equals(SQLOutil.SQLPOSTGRE)) {
/*   92 */       this.jRBPostGres.setSelected(true);
/*      */     }
/*   94 */     if (s.equals(SQLOutil.SQLSERVER)) {
/*   95 */       this.jRBSQLServer.setSelected(true);
/*      */     }
/*   97 */     if (s.equals(SQLOutil.SQLORACLE)) {
/*   98 */       this.jRBOracle.setSelected(true);
/*      */     }
/*  100 */     if (s.equals(SQLOutil.HSQLDB)) {
/*  101 */       this.jRBHSQLDB.setSelected(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private String getSQL()
/*      */   {
/*  107 */     if (this.jRBAccess.isSelected()) {
/*  108 */       return SQLOutil.SQLACCESS;
/*      */     }
/*      */     
/*  111 */     if (this.jRBOracle.isSelected()) {
/*  112 */       return SQLOutil.SQLORACLE;
/*      */     }
/*      */     
/*  115 */     if (this.jRBSQLServer.isSelected()) {
/*  116 */       return SQLOutil.SQLSERVER;
/*      */     }
/*      */     
/*  119 */     if (this.jRBDerby.isSelected()) {
/*  120 */       return SQLOutil.SQLDERBY;
/*      */     }
/*      */     
/*  123 */     if (this.jRBFireBird.isSelected()) {
/*  124 */       return SQLOutil.SQLFIREBIRD;
/*      */     }
/*      */     
/*  127 */     if (this.jRBMySQL.isSelected()) {
/*  128 */       return SQLOutil.SQLMYSQL;
/*      */     }
/*      */     
/*  131 */     if (this.jRBPostGres.isSelected()) {
/*  132 */       return SQLOutil.SQLPOSTGRE;
/*      */     }
/*      */     
/*  135 */     if (this.jRBSQLite.isSelected()) {
/*  136 */       return SQLOutil.SQLITE;
/*      */     }
/*      */     
/*  139 */     if (this.jRBHSQLDB.isSelected()) {
/*  140 */       return SQLOutil.HSQLDB;
/*      */     }
/*  142 */     return "";
/*      */   }
/*      */   
/*      */   private void initReseau(boolean reseau)
/*      */   {
/*  146 */     if (reseau)
/*      */     {
/*  147 */       this.jRBProxy.setSelected(true);
/*  148 */       this.jTFLogin.setEnabled(true);
/*  149 */       this.jTFPassword.setEnabled(true);
/*  150 */       this.jTFPort.setEnabled(true);
/*  151 */       this.jTFProxy.setEnabled(true);
/*      */     }
/*      */     else
/*      */     {
/*  153 */       this.jRBPasDeProxy.setSelected(true);
/*  154 */       this.jTFLogin.setEnabled(false);
/*  155 */       this.jTFPassword.setEnabled(false);
/*  156 */       this.jTFPort.setEnabled(false);
/*  157 */       this.jTFProxy.setEnabled(false);
/*      */     }
/*      */   }
/*      */   private JCheckBox jCBOuvrirCreerUneCopie;
/*      */   private JCheckBox jCBPetitCarreau;
/*      */   private JCheckBox jCBRedondNomAss;
/*      */   private JCheckBox jCBSQLAugmenterNomTableParDeveloppeur;
/*      */   private JCheckBox jCBSQLPrefixerLeNomContrainte2;
/*      */   
/*      */   private void initData()
/*      */   {
/*  162 */     this.jTFDeveloppeur.setText(Setting.developpeur);
/*  163 */     this.jTFLogin.setText(Setting.proxyLogin);
/*  164 */     this.jTFPassword.setText(Setting.proxyPassW);
/*  165 */     this.jTFPort.setText(Setting.proxyPort);
/*  166 */     this.jTFProxy.setText(Setting.proxyHTTP);
/*  167 */     this.jTFdateDerUse.setText(Setting.dateDerUse);
/*      */     
/*  169 */     this.jCBDesactiverHeritage.setSelected(Setting.desactiverHeritage);
/*      */     
/*  171 */     this.jCBAttMere.setSelected(Setting.attMere);
/*  172 */     this.jCBAttUniq.setSelected(Setting.attUniq);
/*  173 */     this.jCBCleSiNecessaireMere.setSelected(Setting.cleSiNecessaireMere);
/*  174 */     this.jCBHeritageMult.setSelected(Setting.heritageMult);
/*  175 */     this.jCBInclureCommentAttSQL.setSelected(Setting.inclureCommentAttSQL);
/*  176 */     this.jCBInclureCommentTableSQL.setSelected(Setting.inclureCommentTableSQL);
/*  177 */     this.jCBInformProprieteMCD.setSelected(Setting.informProprieteMCD);
/*      */     
/*  179 */     this.jCBPetitCarreau.setSelected(Setting.petitCarreau);
/*  180 */     this.jCBRedondNomAss.setSelected(Setting.redondNomAss);
/*      */     
/*      */ 
/*  183 */     this.jCBVideNomAss.setSelected(Setting.videNomAss);
/*      */     
/*      */ 
/*  186 */     initSQL(Setting.SQLDefaut);
/*  187 */     initReseau(Setting.proxy);
/*      */     
/*      */ 
/*  190 */     this.jCBImprimerDeveloppeur.setSelected(Setting.imprimerNomDev);
/*  191 */     this.jCBImprimerNomMCD.setSelected(Setting.imprimerNomMcd);
/*  192 */     this.jCBImprimerNumPage.setSelected(Setting.imprimerNumPage);
/*  193 */     this.jTFImprimerMargeBas.setText(Setting.imprimerMargeB);
/*  194 */     this.jTFImprimerMargeDroite.setText(Setting.imprimerMargeD);
/*  195 */     this.jTFImprimerMargeGauche.setText(Setting.imprimerMargeG);
/*  196 */     this.jTFImprimerMargeHaut.setText(Setting.imprimerMargeH);
/*      */     
/*  198 */     if (Setting.imprimerOrientation.equals("PORTRAIT")) this.jCBImprimerOrientation.setSelectedIndex(0);
/*  199 */     if (Setting.imprimerOrientation.equals("PAYSAGE")) { this.jCBImprimerOrientation.setSelectedIndex(1);
/*      */     }
/*      */     
/*      */ 
/*  203 */     this.jLabIdentifiant.setText(this.attribut.getNom() + "  :  " + this.attribut.getType());
/*  204 */     this.jCBZoomToutPage.setSelected(Setting.zoomToutPage);
/*  205 */     this.jCBagraverSelection2.setSelected(Setting.agraverSelection2);
/*  206 */     this.jCBafficherOptionSelectionLib.setSelected(Setting.afficherOptionSelectionLib);
/*  207 */     this.jCBisAttributCleParDefautPourEntite.setSelected(Setting.isAttributCleParDefautPourEntite);
/*  208 */     this.jCBdragNdropAfficherAttribut.setSelected(Setting.dragNdropAfficherAttribut);
/*  209 */     this.jCBOuvrirCreerUneCopie.setSelected(Setting.ouvrirCreerUneCopie2);
/*      */     
/*  211 */     this.jCBMLDStructurerAtt2.setSelected(Setting.MLDStructurerAtt2);
/*  212 */     this.jCBMLDAfficherNomLien2.setSelected(Setting.MLDAfficherNomLien2);
/*  213 */     this.jCBAugmentation.setSelected(Setting.augmentation);
/*  214 */     this.JCBaugmentationNomComplet.setSelected(Setting.augmentationNomComplet);
/*  215 */     this.jTFaugmentationNBCaractere.setText(Setting.augmentationNBCaractere + "");
/*  216 */     this.jTFSQLCardinaliteMax.setText(Setting.SQLCardinaliteMax + "");
/*  217 */     this.jCBSQLAugmenterNomTableParDeveloppeur.setSelected(Setting.SQLAugmenterNomTableParDeveloppeur2);
/*  218 */     this.jCBSQLUtiliserCode.setSelected(Setting.SQLUtiliserCode);
/*  219 */     this.jCBSQLPrefixerLeNomContrainte2.setSelected(Setting.SQLPrefixerLeNomContrainte2);
/*  220 */     this.jCBSQLVerifierMotReserver2.setSelected(Setting.SQLVerifierMotReserver2);
/*      */     
/*  222 */     this.jCBheritageMemeSpecialisation2.setSelected(Setting.heritageMemeSpecialisation2);
/*  223 */     activationAugmentation();
/*  224 */     this.jTFVersion.setText(Parametres.version);
/*      */   }
/*      */   
/*      */   private JCheckBox jCBSQLUtiliserCode;
/*      */   private JCheckBox jCBSQLVerifierMotReserver2;
/*      */   private JCheckBox jCBVideNomAss;
/*      */   private JCheckBox jCBZoomToutPage;
/*      */   private JCheckBox jCBafficherOptionSelectionLib;
/*      */   
/*      */   public boolean isDouble(String s)
/*      */   {
/*  231 */     if (s.trim().length() == 0) return true;
/*      */     try {
/*  233 */       Double.parseDouble(s);
/*  234 */       return true;
/*      */     } catch (Exception e) {}
/*  236 */     return false;
/*      */   }
/*      */   
/*      */   private JCheckBox jCBagraverSelection2;
/*      */   private JCheckBox jCBdragNdropAfficherAttribut;
/*      */   private JCheckBox jCBheritageMemeSpecialisation2;
/*      */   public boolean isEntier(String s)
/*      */   {
/*  241 */     if (s.trim().length() == 0) return true;
/*      */     try {
/*  243 */       Integer.parseInt(s);
/*  244 */       return true;
/*      */     } catch (Exception e) {}
/*  246 */     return false;
/*      */   }
/*      */   
/*      */   private JCheckBox jCBisAttributCleParDefautPourEntite;
/*      */   private JCheckBox jCheckBox1;
/*      */   private JLabel jLabIdentifiant;
/*      */   private JLabel jLabel10;
/*      */   private JLabel jLabel11;
/*      */   private JLabel jLabel12;
/*      */   
/*      */   public boolean controleMarge()
/*      */   {
/*  252 */     if ((isDouble(this.jTFImprimerMargeBas.getText())) && (isDouble(this.jTFImprimerMargeDroite.getText())) && (isDouble(this.jTFImprimerMargeGauche.getText())) && (isDouble(this.jTFImprimerMargeHaut.getText()))) {
/*  253 */       return true;
/*      */     }
/*  255 */     return false;
/*      */   }
/*      */   
/*      */   public boolean controleCardinaliteMax()
/*      */   {
/*  260 */     String s = this.jTFSQLCardinaliteMax.getText().trim();
/*  261 */     if (s.length() == 0) s = "0";
/*  262 */     if (!isEntier(s)) { return false;
/*      */     }
/*  264 */     int max = Integer.parseInt(s);
/*  265 */     if (max < 1) return false;
/*  266 */     if (max > 15) return false;
/*  267 */     return true;
/*      */   }
/*      */   
/*      */   public boolean controleAugmentation()
/*      */   {
/*  271 */     String s = this.jTFaugmentationNBCaractere.getText().trim();
/*  272 */     if (s.length() == 0) s = "0";
/*  273 */     if (!isEntier(s)) return false;
/*  274 */     int max = Integer.parseInt(s);
/*  275 */     if (max < 1) return false;
/*  276 */     if (max > 5) return false;
/*  277 */     return true;
/*      */   }
/*      */   
/*      */   public void activationAugmentation()
/*      */   {
/*  282 */     if (this.jCBAugmentation.isSelected())
/*      */     {
/*  283 */       this.JCBaugmentationNomComplet.setEnabled(true);
/*  284 */       this.jTFaugmentationNBCaractere.setEnabled(true);
/*  285 */       if (!this.JCBaugmentationNomComplet.isSelected()) {
/*  286 */         this.jTFaugmentationNBCaractere.setEnabled(true);
/*      */       } else {
/*  288 */         this.jTFaugmentationNBCaractere.setEnabled(false);
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  291 */       this.JCBaugmentationNomComplet.setEnabled(false);
/*  292 */       this.jTFaugmentationNBCaractere.setEnabled(false);
/*      */     }
/*      */   }
/*      */   private JLabel jLabel13;
/*      */   private JLabel jLabel14;
/*      */   private JLabel jLabel15;
/*      */   private JLabel jLabel16;
/*      */   private JLabel jLabel17;
/*      */   
/*      */   private void enregistrerCardMax()
/*      */   {
/*  298 */     if (controleCardinaliteMax()) {
/*  299 */       Setting.SQLCardinaliteMax = Integer.parseInt(this.jTFSQLCardinaliteMax.getText().trim());
/*      */     } else {
/*  301 */       Setting.SQLCardinaliteMax = 3;
/*      */     }
/*      */   }
/*      */   
/*      */   private JLabel jLabel19;
/*      */   private JLabel jLabel2;
/*      */   private JLabel jLabel20;
/*      */   private JLabel jLabel3;
/*      */   private JLabel jLabel4;
/*      */   
/*      */   private void enregistrerAugmentation()
/*      */   {
/*  307 */     if (this.jCBAugmentation.isSelected())
/*      */     {
/*  308 */       Setting.augmentation = true;
/*  309 */       if (this.JCBaugmentationNomComplet.isSelected()) {
/*  310 */         Setting.augmentationNomComplet = true;
/*      */ 
/*      */       }
/*  313 */       else if (controleAugmentation())
/*      */       {
/*  314 */         Setting.augmentationNomComplet = false;
/*  315 */         Setting.augmentationNBCaractere = Integer.parseInt(this.jTFaugmentationNBCaractere.getText().trim());
/*      */       }
/*      */       else
/*      */       {
/*  317 */         Setting.augmentationNBCaractere = 3;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  321 */       Setting.augmentation = false;
/*      */     }
/*      */   }
/*      */   
/*      */   private JLabel jLabel5;
/*      */   private JLabel jLabel6;
/*      */   private JLabel jLabel8;
/*      */   private JLabel jLabel9;
/*      */   private JPanel jPanel1;
/*      */   
/*      */   public void enregistrerSetting()
/*      */   {
/*  327 */     Setting.developpeur = this.jTFDeveloppeur.getText();
/*  328 */     Setting.proxyLogin = this.jTFLogin.getText();
/*  329 */     Setting.proxyPassW = this.jTFPassword.getText();
/*  330 */     Setting.proxyPort = this.jTFPort.getText();
/*  331 */     Setting.proxyHTTP = this.jTFProxy.getText();
/*  332 */     Setting.dateDerUse = this.jTFdateDerUse.getText();
/*      */     
/*  334 */     Setting.desactiverHeritage = this.jCBDesactiverHeritage.isSelected();
/*  335 */     Setting.licence.setParametreProxy(Setting.proxyHTTP, Setting.proxyLogin, Setting.proxyPassW, Setting.proxyPort);
/*  336 */     Setting.licence.setUseProxy(this.jRBProxy.isSelected());
/*      */     
/*      */ 
/*  339 */     Setting.attMere = this.jCBAttMere.isSelected();
/*  340 */     Setting.attUniq = this.jCBAttUniq.isSelected();
/*      */     
/*  342 */     Setting.cleSiNecessaireMere = this.jCBCleSiNecessaireMere.isSelected();
/*      */     
/*  344 */     Setting.heritageMult = this.jCBHeritageMult.isSelected();
/*      */     
/*  346 */     Setting.inclureCommentAttSQL = this.jCBInclureCommentAttSQL.isSelected();
/*  347 */     Setting.inclureCommentTableSQL = this.jCBInclureCommentTableSQL.isSelected();
/*  348 */     Setting.informProprieteMCD = this.jCBInformProprieteMCD.isSelected();
/*      */     
/*      */ 
/*  351 */     Setting.petitCarreau = this.jCBPetitCarreau.isSelected();
/*  352 */     Setting.redondNomAss = this.jCBRedondNomAss.isSelected();
/*      */     
/*      */ 
/*  355 */     Setting.videNomAss = this.jCBVideNomAss.isSelected();
/*  356 */     Setting.SQLDefaut = getSQL();
/*      */     
/*  358 */     Setting.proxy = this.jRBProxy.isSelected();
/*      */     
/*      */ 
/*  361 */     Setting.imprimerOrientation = "PORTRAIT";
/*  362 */     if (this.jCBImprimerOrientation.getSelectedIndex() == 1) { Setting.imprimerOrientation = "PAYSAGE";
/*      */     }
/*  364 */     Setting.imprimerNomDev = this.jCBImprimerDeveloppeur.isSelected();
/*  365 */     Setting.imprimerNomMcd = this.jCBImprimerNomMCD.isSelected();
/*  366 */     Setting.imprimerNumPage = this.jCBImprimerNumPage.isSelected();
/*  367 */     Setting.imprimerMargeB = this.jTFImprimerMargeBas.getText();
/*  368 */     Setting.imprimerMargeD = this.jTFImprimerMargeDroite.getText();
/*  369 */     Setting.imprimerMargeG = this.jTFImprimerMargeGauche.getText();
/*  370 */     Setting.imprimerMargeH = this.jTFImprimerMargeHaut.getText();
/*      */     
/*      */ 
/*  373 */     Setting.attributCle = this.attribut;
/*  374 */     Setting.zoomToutPage = this.jCBZoomToutPage.isSelected();
/*  375 */     Setting.agraverSelection2 = this.jCBagraverSelection2.isSelected();
/*  376 */     Setting.afficherOptionSelectionLib = this.jCBafficherOptionSelectionLib.isSelected();
/*  377 */     Setting.isAttributCleParDefautPourEntite = this.jCBisAttributCleParDefautPourEntite.isSelected();
/*  378 */     Setting.dragNdropAfficherAttribut = this.jCBdragNdropAfficherAttribut.isSelected();
/*  379 */     Setting.ouvrirCreerUneCopie2 = this.jCBOuvrirCreerUneCopie.isSelected();
/*  380 */     Setting.SQLAugmenterNomTableParDeveloppeur2 = this.jCBSQLAugmenterNomTableParDeveloppeur.isSelected();
/*  381 */     Setting.MLDStructurerAtt2 = this.jCBMLDStructurerAtt2.isSelected();
/*      */     
/*  383 */     Setting.MLDAfficherNomLien2 = this.jCBMLDAfficherNomLien2.isSelected();
/*  384 */     Setting.SQLUtiliserCode = this.jCBSQLUtiliserCode.isSelected();
/*  385 */     Setting.SQLPrefixerLeNomContrainte2 = this.jCBSQLPrefixerLeNomContrainte2.isSelected();
/*  386 */     Setting.heritageMemeSpecialisation2 = this.jCBheritageMemeSpecialisation2.isSelected();
/*  387 */     Setting.SQLVerifierMotReserver2 = this.jCBSQLVerifierMotReserver2.isSelected();
/*      */     
/*  389 */     enregistrerAugmentation();
/*  390 */     enregistrerCardMax();
/*      */   }
/*      */   
/*      */   private JPanel jPanel10;
/*      */   private JPanel jPanel11;
/*      */   private JPanel jPanel12;
/*      */   private JPanel jPanel13;
/*      */   
/*      */   private void verifierActivation()
/*      */   {
/*  396 */     if ((!Principale.isActiverJMerise()) && (
/*  397 */       (Setting.ouvrirCreerUneCopie2) || (Setting.heritageMult) || (Setting.heritageMemeSpecialisation2) || (Setting.attMere != true) || (Setting.cleSiNecessaireMere) || (Setting.informProprieteMCD) || (Setting.zoomToutPage) || (Setting.SQLCardinaliteMax != 3)))
/*      */     {
/*  407 */       JOptionPane.showMessageDialog(this.frm, "Il faut activer cette version pour prendre en compte certains paramètres ! ");
/*  408 */       Setting.ouvrirCreerUneCopie2 = false;
/*  409 */       Setting.heritageMult = false;
/*  410 */       Setting.heritageMemeSpecialisation2 = false;
/*  411 */       Setting.attMere = true;
/*  412 */       Setting.cleSiNecessaireMere = false;
/*  413 */       Setting.informProprieteMCD = false;
/*  414 */       Setting.zoomToutPage = false;
/*  415 */       Setting.SQLCardinaliteMax = 3;
/*      */     }
/*      */   }
/*      */   
/*      */   private JPanel jPanel2;
/*      */   private JPanel jPanel3;
/*      */   private JPanel jPanel4;
/*      */   private JPanel jPanel5;
/*      */   private JPanel jPanel6;
/*      */   private JPanel jPanel7;
/*      */   private JPanel jPanel8;
/*      */   private JPanel jPanel9;
/*      */   private JPanel jPanelMLD;
/*      */   private JPanel jPanelSQL;
/*      */   private JRadioButton jRBAccess;
/*      */   
/*      */   private void initComponents()
/*      */   {
/*  433 */     this.buttonGroup1 = new ButtonGroup();
/*  434 */     this.buttonGroup2 = new ButtonGroup();
/*  435 */     this.jTabbedPane1 = new JTabbedPane();
/*  436 */     this.jPanel1 = new JPanel();
/*  437 */     this.jCBInformProprieteMCD = new JCheckBox();
/*  438 */     this.jCBPetitCarreau = new JCheckBox();
/*  439 */     this.jCBZoomToutPage = new JCheckBox();
/*  440 */     this.jCBisAttributCleParDefautPourEntite = new JCheckBox();
/*  441 */     this.jButton1 = new JButton();
/*  442 */     this.jCBafficherOptionSelectionLib = new JCheckBox();
/*  443 */     this.jCBagraverSelection2 = new JCheckBox();
/*  444 */     this.jLabIdentifiant = new JLabel();
/*  445 */     this.jCBOuvrirCreerUneCopie = new JCheckBox();
/*  446 */     this.jPanel2 = new JPanel();
/*  447 */     this.jCBAttUniq = new JCheckBox();
/*  448 */     this.jCBRedondNomAss = new JCheckBox();
/*  449 */     this.jCBVideNomAss = new JCheckBox();
/*  450 */     this.jCBdragNdropAfficherAttribut = new JCheckBox();
/*  451 */     this.jPanel5 = new JPanel();
/*  452 */     this.jCBDesactiverHeritage = new JCheckBox();
/*  453 */     this.jCBHeritageMult = new JCheckBox();
/*  454 */     this.jCBCleSiNecessaireMere = new JCheckBox();
/*  455 */     this.jCBAttMere = new JCheckBox();
/*  456 */     this.jCBheritageMemeSpecialisation2 = new JCheckBox();
/*  457 */     this.jCBSQLVerifierMotReserver2 = new JCheckBox();
/*  458 */     this.jPanel3 = new JPanel();
/*  459 */     this.jPanel4 = new JPanel();
/*  460 */     this.jTabbedPane2 = new JTabbedPane();
/*  461 */     this.jPanelMLD = new JPanel();
/*  462 */     this.jCBMLDStructurerAtt2 = new JCheckBox();
/*  463 */     this.jCBMLDAfficherNomLien2 = new JCheckBox();
/*  464 */     this.jLabel19 = new JLabel();
/*  465 */     this.jTFSQLCardinaliteMax = new JTextField();
/*  466 */     this.jCBAugmentation = new JCheckBox();
/*  467 */     this.JCBaugmentationNomComplet = new JCheckBox();
/*  468 */     this.jLabel20 = new JLabel();
/*  469 */     this.jTFaugmentationNBCaractere = new JTextField();
/*  470 */     this.jPanelSQL = new JPanel();
/*  471 */     this.jCBSQLUtiliserCode = new JCheckBox();
/*  472 */     this.jPanel9 = new JPanel();
/*  473 */     this.jRBMySQL = new JRadioButton();
/*  474 */     this.jRBSQLite = new JRadioButton();
/*  475 */     this.jRBFireBird = new JRadioButton();
/*  476 */     this.jRBDerby = new JRadioButton();
/*  477 */     this.jRBPostGres = new JRadioButton();
/*  478 */     this.jRBAccess = new JRadioButton();
/*  479 */     this.jRBSQLServer = new JRadioButton();
/*  480 */     this.jRBOracle = new JRadioButton();
/*  481 */     this.jRBHSQLDB = new JRadioButton();
/*  482 */     this.jRadioButton2 = new JRadioButton();
/*  483 */     this.jPanel10 = new JPanel();
/*  484 */     this.jCBInclureCommentTableSQL = new JCheckBox();
/*  485 */     this.jCBInclureCommentAttSQL = new JCheckBox();
/*  486 */     this.jCheckBox1 = new JCheckBox();
/*  487 */     this.jCBSQLAugmenterNomTableParDeveloppeur = new JCheckBox();
/*  488 */     this.jCBSQLPrefixerLeNomContrainte2 = new JCheckBox();
/*  489 */     this.jPanel6 = new JPanel();
/*  490 */     this.jPanel11 = new JPanel();
/*  491 */     this.jCBImprimerOrientation = new JComboBox();
/*  492 */     this.jLabel9 = new JLabel();
/*  493 */     this.jCBImprimerNumPage = new JCheckBox();
/*  494 */     this.jCBImprimerNomMCD = new JCheckBox();
/*  495 */     this.jCBImprimerDeveloppeur = new JCheckBox();
/*  496 */     this.jPanel13 = new JPanel();
/*  497 */     this.jLabel10 = new JLabel();
/*  498 */     this.jLabel12 = new JLabel();
/*  499 */     this.jLabel11 = new JLabel();
/*  500 */     this.jTFImprimerMargeGauche = new JTextField();
/*  501 */     this.jTFImprimerMargeHaut = new JTextField();
/*  502 */     this.jLabel13 = new JLabel();
/*  503 */     this.jLabel16 = new JLabel();
/*  504 */     this.jTFImprimerMargeDroite = new JTextField();
/*  505 */     this.jTFImprimerMargeBas = new JTextField();
/*  506 */     this.jCBLimitationPages = new JCheckBox();
/*  507 */     this.jPanel7 = new JPanel();
/*  508 */     this.jRBPasDeProxy = new JRadioButton();
/*  509 */     this.jRBProxy = new JRadioButton();
/*  510 */     this.jLabel4 = new JLabel();
/*  511 */     this.jLabel2 = new JLabel();
/*  512 */     this.jLabel3 = new JLabel();
/*  513 */     this.jTFPassword = new JPasswordField();
/*  514 */     this.jTFLogin = new JTextField();
/*  515 */     this.jTFProxy = new JTextField();
/*  516 */     this.jTFPort = new JTextField();
/*  517 */     this.jLabel5 = new JLabel();
/*  518 */     this.jButton3 = new JButton();
/*  519 */     this.jPanel8 = new JPanel();
/*  520 */     this.jTFDeveloppeur = new JTextField();
/*  521 */     this.jLabel15 = new JLabel();
/*  522 */     this.jLabel14 = new JLabel();
/*  523 */     this.jTFdateDerUse = new JTextField();
/*  524 */     this.jPanel12 = new JPanel();
/*  525 */     this.jLabel6 = new JLabel();
/*  526 */     this.jLabel8 = new JLabel();
/*  527 */     this.jTextField4 = new JTextField();
/*  528 */     this.jScrollPane1 = new JScrollPane();
/*  529 */     this.jTALicence = new JTextArea();
/*  530 */     this.jLabel17 = new JLabel();
/*  531 */     this.jTFVersion = new JTextField();
/*  532 */     this.jBtAnnuler = new JButton();
/*  533 */     this.jBtValider = new JButton();
/*      */     
/*  535 */     setDefaultCloseOperation(2);
/*  536 */     setTitle("Configuration de paramétres");
/*  537 */     setResizable(false);
/*      */     
/*  539 */     this.jCBInformProprieteMCD.setText("Afficher propriété du MCD");
/*      */     
/*  541 */     this.jCBPetitCarreau.setText("Petit carreau en arrière plan");
/*      */     
/*  543 */     this.jCBZoomToutPage.setText("Appliquer le zoom à toutes les pages MCD ouvertes");
/*      */     
/*  545 */     this.jCBisAttributCleParDefautPourEntite.setText("Créer un attribut identifiant lors de la création de l'entité");
/*      */     
/*  547 */     this.jButton1.setText("Modif");
/*  548 */     this.jButton1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  550 */         FormeSetting2.this.jButton1ActionPerformed(evt);
/*      */       }
/*      */       
/*  553 */     });
/*  554 */     this.jCBafficherOptionSelectionLib.setText("Rendre visible les options de séléction dans la librairie");
/*      */     
/*  556 */     this.jCBagraverSelection2.setText("Aggraver la séléction des éléments");
/*      */     
/*  558 */     this.jLabIdentifiant.setFont(new Font("Tahoma", 1, 11));
/*  559 */     this.jLabIdentifiant.setHorizontalAlignment(0);
/*  560 */     this.jLabIdentifiant.setText("...");
/*  561 */     this.jLabIdentifiant.setHorizontalTextPosition(0);
/*      */     
/*  563 */     this.jCBOuvrirCreerUneCopie.setText("Ouvrir une copie du MCD si sa version < 0.5");
/*      */     
/*  565 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  566 */     this.jPanel1.setLayout(jPanel1Layout);
/*  567 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBInformProprieteMCD).addComponent(this.jCBPetitCarreau).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBZoomToutPage).addComponent(this.jCBagraverSelection2).addComponent(this.jCBafficherOptionSelectionLib)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 76, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBOuvrirCreerUneCopie).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabIdentifiant, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jCBisAttributCleParDefautPourEntite, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.jButton1))))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  590 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(41, 41, 41).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jCBisAttributCleParDefautPourEntite).addComponent(this.jCBZoomToutPage)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jCBagraverSelection2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabIdentifiant).addComponent(this.jButton1)))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBafficherOptionSelectionLib).addComponent(this.jCBOuvrirCreerUneCopie)).addGap(18, 18, 18).addComponent(this.jCBInformProprieteMCD).addGap(18, 18, 18).addComponent(this.jCBPetitCarreau).addContainerGap(85, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  617 */     this.jTabbedPane1.addTab("Général", this.jPanel1);
/*      */     
/*  619 */     this.jCBAttUniq.setText("l'attribut doit être unique dans tout le MCD");
/*      */     
/*  621 */     this.jCBRedondNomAss.setText("Redondance des noms des associations qui ne seront pas des tables dans le MLD ");
/*      */     
/*  623 */     this.jCBVideNomAss.setText("Accepter des noms vides des associations qui ne seront pas des tables dans le MLD ");
/*      */     
/*  625 */     this.jCBdragNdropAfficherAttribut.setText("Rendre visibles les attributs de l'entité lors de l'insertion de la librairie");
/*      */     
/*  627 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder("Héritage"));
/*      */     
/*  629 */     this.jCBDesactiverHeritage.setText("Désactiver l'héritage");
/*      */     
/*  631 */     this.jCBHeritageMult.setText("Accepter l'héritage multiple des entités");
/*      */     
/*  633 */     this.jCBCleSiNecessaireMere.setText("Ne pas importer la clé mère si la l'entité fille possède sa propre clé primaire");
/*      */     
/*  635 */     this.jCBAttMere.setText("Importer tous les attributs (non clés primaires ) de l'entité mère");
/*      */     
/*  637 */     this.jCBheritageMemeSpecialisation2.setText("Accepter plusieurs spécialisations de la même entité");
/*      */     
/*  639 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  640 */     this.jPanel5.setLayout(jPanel5Layout);
/*  641 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBHeritageMult).addComponent(this.jCBDesactiverHeritage)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 104, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBAttMere).addComponent(this.jCBCleSiNecessaireMere))).addComponent(this.jCBheritageMemeSpecialisation2)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  657 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBDesactiverHeritage).addComponent(this.jCBAttMere)).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBHeritageMult).addComponent(this.jCBCleSiNecessaireMere)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, 32767).addComponent(this.jCBheritageMemeSpecialisation2).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  673 */     this.jCBSQLVerifierMotReserver2.setText("Vérifier les mots réservés dans le MCD");
/*      */     
/*  675 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  676 */     this.jPanel2.setLayout(jPanel2Layout);
/*  677 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -2, -1, -2).addComponent(this.jCBVideNomAss).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBRedondNomAss).addComponent(this.jCBdragNdropAfficherAttribut)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBSQLVerifierMotReserver2).addComponent(this.jCBAttUniq)))).addContainerGap(17, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  694 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.jPanel5, -2, -1, -2).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBRedondNomAss).addComponent(this.jCBAttUniq)).addGap(18, 18, 18).addComponent(this.jCBVideNomAss).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBdragNdropAfficherAttribut).addComponent(this.jCBSQLVerifierMotReserver2)).addContainerGap(22, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  712 */     this.jTabbedPane1.addTab("Contraintes MCD", this.jPanel2);
/*      */     
/*  714 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  715 */     this.jPanel3.setLayout(jPanel3Layout);
/*  716 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 745, 32767));
/*      */     
/*      */ 
/*      */ 
/*  720 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 313, 32767));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  725 */     this.jTabbedPane1.addTab("Retro Conception", this.jPanel3);
/*      */     
/*  727 */     this.jCBMLDStructurerAtt2.setText("Structurer les attributs du MLD");
/*      */     
/*  729 */     this.jCBMLDAfficherNomLien2.setText("Afficher le nom des liens dans le MLD");
/*      */     
/*  731 */     this.jLabel19.setText("Cardinalité personnalisée maximale prise en compte dans la conversion");
/*      */     
/*  733 */     this.jCBAugmentation.setText("Utiliser l'augmentation pour les attributs composés");
/*  734 */     this.jCBAugmentation.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  736 */         FormeSetting2.this.jCBAugmentationActionPerformed(evt);
/*      */       }
/*      */       
/*  739 */     });
/*  740 */     this.JCBaugmentationNomComplet.setText("Nom entier de l'attributs père");
/*  741 */     this.JCBaugmentationNomComplet.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  743 */         FormeSetting2.this.JCBaugmentationNomCompletActionPerformed(evt);
/*      */       }
/*      */       
/*  746 */     });
/*  747 */     this.jLabel20.setText("Nombre de caractères");
/*      */     
/*  749 */     GroupLayout jPanelMLDLayout = new GroupLayout(this.jPanelMLD);
/*  750 */     this.jPanelMLD.setLayout(jPanelMLDLayout);
/*  751 */     jPanelMLDLayout.setHorizontalGroup(jPanelMLDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelMLDLayout.createSequentialGroup().addGroup(jPanelMLDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelMLDLayout.createSequentialGroup().addContainerGap().addGroup(jPanelMLDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBAugmentation).addComponent(this.jCBMLDStructurerAtt2).addComponent(this.jCBMLDAfficherNomLien2))).addGroup(jPanelMLDLayout.createSequentialGroup().addGap(35, 35, 35).addGroup(jPanelMLDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelMLDLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jLabel20, -2, 110, -2).addGap(18, 18, 18).addComponent(this.jTFaugmentationNBCaractere, -2, 51, -2)).addComponent(this.JCBaugmentationNomComplet))).addGroup(jPanelMLDLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel19).addGap(18, 18, 18).addComponent(this.jTFSQLCardinaliteMax, -2, 41, -2))).addContainerGap(313, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  777 */     jPanelMLDLayout.setVerticalGroup(jPanelMLDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelMLDLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jCBMLDStructurerAtt2).addGap(18, 18, 18).addComponent(this.jCBMLDAfficherNomLien2).addGap(18, 18, 18).addComponent(this.jCBAugmentation).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBaugmentationNomComplet).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelMLDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel20).addComponent(this.jTFaugmentationNBCaractere, -2, -1, -2)).addGap(36, 36, 36).addGroup(jPanelMLDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel19).addComponent(this.jTFSQLCardinaliteMax, -2, -1, -2)).addGap(52, 52, 52)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  799 */     this.jTabbedPane2.addTab("MLD", this.jPanelMLD);
/*      */     
/*  801 */     this.jCBSQLUtiliserCode.setText("Utiliser les codes dans la génération du script");
/*      */     
/*  803 */     this.jPanel9.setBorder(BorderFactory.createTitledBorder("Script SQL par défaut :"));
/*      */     
/*  805 */     this.buttonGroup2.add(this.jRBMySQL);
/*  806 */     this.jRBMySQL.setSelected(true);
/*  807 */     this.jRBMySQL.setText("MySQL");
/*      */     
/*  809 */     this.buttonGroup2.add(this.jRBSQLite);
/*  810 */     this.jRBSQLite.setText("SQLite");
/*      */     
/*  812 */     this.buttonGroup2.add(this.jRBFireBird);
/*  813 */     this.jRBFireBird.setText("FireBird");
/*      */     
/*  815 */     this.buttonGroup2.add(this.jRBDerby);
/*  816 */     this.jRBDerby.setText("Derby");
/*      */     
/*  818 */     this.buttonGroup2.add(this.jRBPostGres);
/*  819 */     this.jRBPostGres.setText("PostGres");
/*      */     
/*  821 */     this.buttonGroup2.add(this.jRBAccess);
/*  822 */     this.jRBAccess.setText("Access");
/*      */     
/*  824 */     this.buttonGroup2.add(this.jRBSQLServer);
/*  825 */     this.jRBSQLServer.setText("SQL Server");
/*      */     
/*  827 */     this.buttonGroup2.add(this.jRBOracle);
/*  828 */     this.jRBOracle.setText("Oracle");
/*      */     
/*  830 */     this.buttonGroup2.add(this.jRBHSQLDB);
/*  831 */     this.jRBHSQLDB.setText("HSQLDB (OpenOffice Base)");
/*      */     
/*  833 */     this.buttonGroup2.add(this.jRadioButton2);
/*  834 */     this.jRadioButton2.setText("DB2");
/*  835 */     this.jRadioButton2.setEnabled(false);
/*      */     
/*  837 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  838 */     this.jPanel9.setLayout(jPanel9Layout);
/*  839 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRBMySQL).addComponent(this.jRBSQLite).addComponent(this.jRBFireBird).addComponent(this.jRBDerby).addComponent(this.jRBHSQLDB)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, 32767).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRBPostGres).addComponent(this.jRBAccess).addComponent(this.jRBSQLServer).addComponent(this.jRBOracle).addComponent(this.jRadioButton2)).addGap(17, 17, 17)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  858 */     jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.jRBPostGres).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBAccess).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBSQLServer).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBOracle).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRadioButton2)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.jRBMySQL).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBSQLite).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBFireBird).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBDerby).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBHSQLDB))).addContainerGap(23, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  886 */     this.jCBInclureCommentTableSQL.setText("Inclure les commentaires associés aux tables dans le script ");
/*      */     
/*  888 */     this.jCBInclureCommentAttSQL.setText("Inclure les commentaires associés aux attributs dans le script ");
/*      */     
/*  890 */     this.jCheckBox1.setText("Documenter le script de sortie. ");
/*  891 */     this.jCheckBox1.setEnabled(false);
/*      */     
/*  893 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  894 */     this.jPanel10.setLayout(jPanel10Layout);
/*  895 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBInclureCommentTableSQL).addComponent(this.jCheckBox1).addComponent(this.jCBInclureCommentAttSQL)).addContainerGap(14, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  905 */     jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jCBInclureCommentTableSQL).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBInclureCommentAttSQL).addGap(30, 30, 30).addComponent(this.jCheckBox1).addContainerGap(22, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  917 */     this.jCBSQLAugmenterNomTableParDeveloppeur.setText("Augmenter le nom des tables par le nom du développeur ");
/*      */     
/*  919 */     this.jCBSQLPrefixerLeNomContrainte2.setText("Préfixer le nom des contraintes par FK, PK,..");
/*      */     
/*  921 */     GroupLayout jPanelSQLLayout = new GroupLayout(this.jPanelSQL);
/*  922 */     this.jPanelSQL.setLayout(jPanelSQLLayout);
/*  923 */     jPanelSQLLayout.setHorizontalGroup(jPanelSQLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSQLLayout.createSequentialGroup().addContainerGap().addGroup(jPanelSQLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBSQLAugmenterNomTableParDeveloppeur).addGroup(jPanelSQLLayout.createSequentialGroup().addComponent(this.jCBSQLUtiliserCode).addGap(115, 115, 115).addComponent(this.jCBSQLPrefixerLeNomContrainte2)).addGroup(jPanelSQLLayout.createSequentialGroup().addComponent(this.jPanel9, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel10, -2, -1, -2))).addContainerGap(24, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  939 */     jPanelSQLLayout.setVerticalGroup(jPanelSQLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSQLLayout.createSequentialGroup().addGroup(jPanelSQLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSQLLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jPanel9, -2, -1, -2)).addGroup(jPanelSQLLayout.createSequentialGroup().addGap(37, 37, 37).addComponent(this.jPanel10, -2, -1, -2))).addGap(32, 32, 32).addGroup(jPanelSQLLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBSQLUtiliserCode).addComponent(this.jCBSQLPrefixerLeNomContrainte2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jCBSQLAugmenterNomTableParDeveloppeur).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  958 */     this.jTabbedPane2.addTab("Script SQL", this.jPanelSQL);
/*      */     
/*  960 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  961 */     this.jPanel4.setLayout(jPanel4Layout);
/*  962 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane2, -1, 725, 32767).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  969 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane2, -1, 305, 32767).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  977 */     this.jTabbedPane1.addTab("MLD & Script", this.jPanel4);
/*      */     
/*  979 */     this.jPanel11.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  981 */     this.jCBImprimerOrientation.setModel(new DefaultComboBoxModel(new String[] { "Portrait", "Paysage" }));
/*      */     
/*  983 */     this.jLabel9.setText("Orientation");
/*      */     
/*  985 */     this.jCBImprimerNumPage.setSelected(true);
/*  986 */     this.jCBImprimerNumPage.setText("Afficher numéro de la page");
/*      */     
/*  988 */     this.jCBImprimerNomMCD.setSelected(true);
/*  989 */     this.jCBImprimerNomMCD.setText("Afficher le nom du MCD");
/*      */     
/*  991 */     this.jCBImprimerDeveloppeur.setSelected(true);
/*  992 */     this.jCBImprimerDeveloppeur.setText("Afficher le nom du développeur");
/*      */     
/*  994 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/*  995 */     this.jPanel11.setLayout(jPanel11Layout);
/*  996 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jCBImprimerDeveloppeur).addContainerGap()).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jCBImprimerNomMCD).addContainerGap()).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jCBImprimerNumPage).addGap(180, 180, 180)).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jLabel9, -2, 62, -2).addGap(18, 18, 18).addComponent(this.jCBImprimerOrientation, 0, 245, 32767).addContainerGap())))));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1017 */     jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGap(24, 24, 24).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBImprimerOrientation, -2, -1, -2).addComponent(this.jLabel9)).addGap(28, 28, 28).addComponent(this.jCBImprimerNumPage).addGap(18, 18, 18).addComponent(this.jCBImprimerNomMCD).addGap(18, 18, 18).addComponent(this.jCBImprimerDeveloppeur).addContainerGap(76, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1033 */     this.jPanel13.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/* 1035 */     this.jLabel10.setText("Marges (cm)");
/*      */     
/* 1037 */     this.jLabel12.setText("Haut");
/*      */     
/* 1039 */     this.jLabel11.setText("Gauche");
/*      */     
/* 1041 */     this.jTFImprimerMargeGauche.setEditable(false);
/*      */     
/* 1043 */     this.jTFImprimerMargeHaut.setEditable(false);
/*      */     
/* 1045 */     this.jLabel13.setText("Droite");
/*      */     
/* 1047 */     this.jLabel16.setText("Bas");
/*      */     
/* 1049 */     this.jTFImprimerMargeDroite.setEditable(false);
/*      */     
/* 1051 */     this.jTFImprimerMargeBas.setEditable(false);
/*      */     
/* 1053 */     this.jCBLimitationPages.setText("Afficher les limites des pages");
/* 1054 */     this.jCBLimitationPages.setEnabled(false);
/*      */     
/* 1056 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 1057 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1058 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addComponent(this.jCBLimitationPages).addContainerGap()).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addComponent(this.jLabel10).addContainerGap(233, 32767)).addGroup(jPanel13Layout.createSequentialGroup().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)).addGroup(jPanel13Layout.createSequentialGroup().addComponent(this.jLabel12).addGap(23, 23, 23))).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jTFImprimerMargeHaut, GroupLayout.Alignment.LEADING).addComponent(this.jTFImprimerMargeGauche, GroupLayout.Alignment.LEADING, -2, 47, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel13).addComponent(this.jLabel16)).addGap(18, 18, 18).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jTFImprimerMargeBas).addComponent(this.jTFImprimerMargeDroite, -2, 54, -2)).addGap(56, 56, 56))))));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1091 */     jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel10).addGap(37, 37, 37).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFImprimerMargeDroite, -2, -1, -2).addComponent(this.jLabel13)).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.jTFImprimerMargeGauche, -2, -1, -2))).addGap(42, 42, 42).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFImprimerMargeBas, -2, -1, -2).addComponent(this.jLabel16)).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.jTFImprimerMargeHaut, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 65, 32767).addComponent(this.jCBLimitationPages).addGap(21, 21, 21)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1117 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1118 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1119 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel11, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel13, -2, -1, -2).addContainerGap(66, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1128 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel13, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel11, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addGap(37, 37, 37)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1138 */     this.jTabbedPane1.addTab("Impression ", this.jPanel6);
/*      */     
/* 1140 */     this.buttonGroup1.add(this.jRBPasDeProxy);
/* 1141 */     this.jRBPasDeProxy.setSelected(true);
/* 1142 */     this.jRBPasDeProxy.setText("Pas de proxy");
/* 1143 */     this.jRBPasDeProxy.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/* 1145 */         FormeSetting2.this.jRBPasDeProxyStateChanged(evt);
/*      */       }
/*      */       
/* 1148 */     });
/* 1149 */     this.buttonGroup1.add(this.jRBProxy);
/* 1150 */     this.jRBProxy.setText("Parametres proxy");
/* 1151 */     this.jRBProxy.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/* 1153 */         FormeSetting2.this.jRBProxyStateChanged(evt);
/*      */       }
/*      */       
/* 1156 */     });
/* 1157 */     this.jLabel4.setText("Proxy HTTP ");
/*      */     
/* 1159 */     this.jLabel2.setText("Login");
/*      */     
/* 1161 */     this.jLabel3.setText("Password");
/*      */     
/* 1163 */     this.jTFPassword.setEnabled(false);
/*      */     
/* 1165 */     this.jTFLogin.setEnabled(false);
/*      */     
/* 1167 */     this.jTFProxy.setEnabled(false);
/*      */     
/* 1169 */     this.jTFPort.setEnabled(false);
/*      */     
/* 1171 */     this.jLabel5.setText("Port");
/*      */     
/* 1173 */     this.jButton3.setText("Tester Connexion ...");
/* 1174 */     this.jButton3.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1176 */         FormeSetting2.this.jButton3ActionPerformed(evt);
/*      */       }
/*      */       
/* 1179 */     });
/* 1180 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1181 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1182 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(29, 29, 29).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel3, GroupLayout.Alignment.LEADING, -1, 59, 32767).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -1, 59, 32767).addComponent(this.jLabel4, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFPassword, -1, 316, 32767).addComponent(this.jTFLogin, -1, 316, 32767).addComponent(this.jButton3, GroupLayout.Alignment.TRAILING, -2, 160, -2).addComponent(this.jTFProxy, -1, 316, 32767)).addGap(18, 18, 18).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFPort, -2, 61, -2)).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jRBProxy, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 390, -2))).addGap(216, 216, 216)).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jRBPasDeProxy, -1, 148, 32767).addGap(591, 591, 591)))));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1213 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(27, 27, 27).addComponent(this.jRBPasDeProxy).addGap(18, 18, 18).addComponent(this.jRBProxy).addGap(12, 12, 12).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jTFProxy, -2, -1, -2).addComponent(this.jTFPort, -2, -1, -2).addComponent(this.jLabel5)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTFLogin, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTFPassword, -2, -1, -2)).addGap(29, 29, 29).addComponent(this.jButton3).addContainerGap(69, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1239 */     this.jTabbedPane1.addTab("Réseau", this.jPanel7);
/*      */     
/* 1241 */     this.jLabel15.setText("Développeur");
/*      */     
/* 1243 */     this.jLabel14.setText("Dernière utilisation");
/*      */     
/* 1245 */     this.jTFdateDerUse.setEditable(false);
/*      */     
/* 1247 */     this.jLabel6.setText("Propriétaire ");
/*      */     
/* 1249 */     this.jLabel8.setText("Informations ");
/*      */     
/* 1251 */     this.jTextField4.setEditable(false);
/*      */     
/* 1253 */     this.jTALicence.setColumns(20);
/* 1254 */     this.jTALicence.setEditable(false);
/* 1255 */     this.jTALicence.setRows(5);
/* 1256 */     this.jTALicence.setText("n°Activation : \nDate début : \nDate Fin : \nà renouveller dans : 300 jours.");
/* 1257 */     this.jScrollPane1.setViewportView(this.jTALicence);
/*      */     
/* 1259 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1260 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1261 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.jLabel8)).addGap(53, 53, 53).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextField4, -1, 588, 32767).addComponent(this.jScrollPane1, -1, 588, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1274 */     jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.jTextField4, -2, 31, -2)).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jScrollPane1, -1, 110, 32767)).addGroup(jPanel12Layout.createSequentialGroup().addGap(34, 34, 34).addComponent(this.jLabel8))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1291 */     this.jLabel17.setText("Version");
/*      */     
/* 1293 */     this.jTFVersion.setEditable(false);
/*      */     
/* 1295 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1296 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1297 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel12, -1, -1, 32767).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup().addComponent(this.jLabel14).addGap(18, 18, 18).addComponent(this.jTFdateDerUse, -2, 109, -2).addGap(207, 207, 207).addComponent(this.jLabel17).addGap(18, 18, 18).addComponent(this.jTFVersion)).addGroup(GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup().addComponent(this.jLabel15).addGap(46, 46, 46).addComponent(this.jTFDeveloppeur, -2, 534, -2)))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1318 */     jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup().addContainerGap(24, 32767).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel15).addComponent(this.jTFDeveloppeur, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel14).addComponent(this.jTFdateDerUse, -2, -1, -2).addComponent(this.jLabel17).addComponent(this.jTFVersion, -2, -1, -2)).addGap(30, 30, 30).addComponent(this.jPanel12, -2, -1, -2).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1336 */     this.jTabbedPane1.addTab("Informations", this.jPanel8);
/*      */     
/* 1338 */     this.jBtAnnuler.setIcon(new ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 1339 */     this.jBtAnnuler.setText("Annuler");
/* 1340 */     this.jBtAnnuler.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1342 */         FormeSetting2.this.jBtAnnulerActionPerformed(evt);
/*      */       }
/*      */       
/* 1345 */     });
/* 1346 */     this.jBtValider.setIcon(new ImageIcon(getClass().getResource("/Images/OK.png")));
/* 1347 */     this.jBtValider.setText("Ok");
/* 1348 */     this.jBtValider.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1350 */         FormeSetting2.this.jBtValiderActionPerformed(evt);
/*      */       }
/*      */       
/* 1353 */     });
/* 1354 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 1355 */     getContentPane().setLayout(layout);
/* 1356 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtValider, -2, 81, -2)).addComponent(this.jTabbedPane1, -1, 750, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1368 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -2, 341, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtAnnuler).addComponent(this.jBtValider)).addContainerGap(-1, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1380 */     pack();
/*      */   }
/*      */   
/*      */   private JRadioButton jRBDerby;
/*      */   private JRadioButton jRBFireBird;
/*      */   private JRadioButton jRBHSQLDB;
/*      */   private JRadioButton jRBMySQL;
/*      */   private JRadioButton jRBOracle;
/*      */   private JRadioButton jRBPasDeProxy;
/*      */   private JRadioButton jRBPostGres;
/*      */   private JRadioButton jRBProxy;
/*      */   private JRadioButton jRBSQLServer;
/*      */   
/*      */   private void jRBPasDeProxyStateChanged(ChangeEvent evt)
/*      */   {
/* 1384 */     if (this.jRBPasDeProxy.isSelected())
/*      */     {
/* 1385 */       this.jTFProxy.setEnabled(false);
/* 1386 */       this.jTFPort.setEnabled(false);
/* 1387 */       this.jTFLogin.setEnabled(false);
/* 1388 */       this.jTFPassword.setEnabled(false);
/*      */     }
/*      */   }
/*      */   
/*      */   private JRadioButton jRBSQLite;
/*      */   private JRadioButton jRadioButton2;
/*      */   private JScrollPane jScrollPane1;
/*      */   private JTextArea jTALicence;
/*      */   private JTextField jTFDeveloppeur;
/*      */   
/*      */   private void jRBProxyStateChanged(ChangeEvent evt)
/*      */   {
/* 1393 */     if (this.jRBProxy.isSelected())
/*      */     {
/* 1394 */       this.jTFProxy.setEnabled(true);
/* 1395 */       this.jTFPort.setEnabled(true);
/* 1396 */       this.jTFLogin.setEnabled(true);
/* 1397 */       this.jTFPassword.setEnabled(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private JTextField jTFImprimerMargeBas;
/*      */   private JTextField jTFImprimerMargeDroite;
/*      */   private JTextField jTFImprimerMargeGauche;
/*      */   private JTextField jTFImprimerMargeHaut;
/*      */   private JTextField jTFLogin;
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt)
/*      */   {
/* 1402 */     String s = InfoSite.dump("http://www.jfreesoft.com/infoSite.php");
/* 1403 */     if (s.indexOf("ErreurRM") >= 0)
/*      */     {
/* 1404 */       if (this.jRBPasDeProxy.isSelected()) {
/* 1405 */         JOptionPane.showMessageDialog(this, "Impossible de se connecter sans les paramètres du proxy, \nVérifier avec paramètres proxy ou la connexion internet");
/*      */       } else {
/* 1407 */         JOptionPane.showMessageDialog(this, "Impossible de se connecter avec les paramètres du proxy,\nVérifier la connexion internet");
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1410 */       JOptionPane.showMessageDialog(this, "Connexion réussie !!");
/* 1411 */       new ThreadSite(this.frm);
/*      */     }
/*      */   }
/*      */   
/*      */   private JPasswordField jTFPassword;
/*      */   private JTextField jTFPort;
/*      */   private JTextField jTFProxy;
/*      */   private JTextField jTFSQLCardinaliteMax;
/*      */   
/*      */   private void jBtAnnulerActionPerformed(ActionEvent evt)
/*      */   {
/* 1416 */     dispose();
/*      */   }
/*      */   
/*      */   private JTextField jTFVersion;
/*      */   private JTextField jTFaugmentationNBCaractere;
/*      */   private JTextField jTFdateDerUse;
/*      */   
/*      */   private void jBtValiderActionPerformed(ActionEvent evt)
/*      */   {
/* 1420 */     if (controleMarge())
/*      */     {
/* 1421 */       if (controleCardinaliteMax())
/*      */       {
/* 1422 */         enregistrerSetting();
/* 1423 */         verifierActivation();
/* 1424 */         dispose();
/*      */       }
/*      */       else
/*      */       {
/* 1426 */         JOptionPane.showMessageDialog(this, "Erreur : La cardinalité personnalisée Max doit être comprise entre 2 et 15");
/*      */       }
/*      */     }
/*      */     else {
/* 1429 */       JOptionPane.showMessageDialog(this, "Erreur : Verifiez les champs de saisie Marge dans l'onglet 'Impression'");
/*      */     }
/*      */   }
/*      */   
/*      */   private JTabbedPane jTabbedPane1;
/*      */   private JTabbedPane jTabbedPane2;
/*      */   private JTextField jTextField4;
/*      */   private void jButton1ActionPerformed(ActionEvent evt)
/*      */   {
/* 1434 */     new FormeProprieteAttribut2(this.frm, true, this.attribut, new ArrayList(), null, true).setVisible(true);
/* 1435 */     this.attribut.setKey(Parametres.Cle);
/* 1436 */     this.jLabIdentifiant.setText(this.attribut.getNom() + "  :  " + this.attribut.getType());
/*      */   }
/*      */   
/*      */   private void jCBAugmentationActionPerformed(ActionEvent evt)
/*      */   {
/* 1440 */     activationAugmentation();
/*      */   }
/*      */   
/*      */   private void JCBaugmentationNomCompletActionPerformed(ActionEvent evt)
/*      */   {
/* 1444 */     activationAugmentation();
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeSetting2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */