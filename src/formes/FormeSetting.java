/*      */ package formes;
/*      */ 
/*      */ import Outil.Setting;
/*      */ import Output.SQLOutil;
/*      */ import ihm.Principale;
/*      */ import input.InfoSite;
/*      */ import java.awt.Color;
/*      */ import java.awt.Container;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
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
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*      */ import javax.swing.LayoutStyle.ComponentPlacement;
/*      */ import javax.swing.event.ChangeEvent;
/*      */ import javax.swing.event.ChangeListener;
/*      */ import mythread.ThreadSite;
/*      */ 
/*      */ public class FormeSetting
/*      */   extends JDialog
/*      */ {
/*      */   private Principale frm;
/*      */   private ButtonGroup BGScriptDefaut;
/*      */   private ButtonGroup BtGrpColoration;
/*      */   private ButtonGroup buttonGroup1;
/*      */   private JButton jBtAnnuler;
/*      */   private JButton jBtValider;
/*      */   private JButton jButton3;
/*      */   private JCheckBox jCBAttMajuscule;
/*      */   private JCheckBox jCBAttMere;
/*      */   private JCheckBox jCBAttUniq;
/*      */   private JCheckBox jCBCardinalite2points;
/*      */   private JCheckBox jCBCardinaliteMajuscule;
/*      */   private JCheckBox jCBCleMere;
/*      */   private JCheckBox jCBCleSiNecessaireMere;
/*      */   private JCheckBox jCBConvertTypeAtt;
/*      */   private JCheckBox jCBDesactiverHeritage;
/*      */   private JCheckBox jCBHeritageMult;
/*      */   private JCheckBox jCBHistoriqueSave;
/*      */   private JCheckBox jCBImprimerDeveloppeur;
/*      */   private JCheckBox jCBImprimerNomMCD;
/*      */   private JCheckBox jCBImprimerNumPage;
/*      */   private JComboBox jCBImprimerOrientation;
/*      */   private JCheckBox jCBInclureCommentAttSQL;
/*      */   private JCheckBox jCBInclureCommentTableSQL;
/*      */   private JCheckBox jCBInformProprieteMCD;
/*      */   private JCheckBox jCBLimitationPages;
/*      */   private JCheckBox jCBMeLaisserChoix;
/*      */   private JCheckBox jCBPetitCarreau;
/*      */   
/*      */   public FormeSetting(Principale frm, boolean modal)
/*      */   {
/*   29 */     super(frm, modal);
/*   30 */     initComponents();
/*   31 */     this.frm = frm;
/*   32 */     setLocation(200, 150);
/*   33 */     this.jBtAnnuler.setMnemonic(65);
/*   34 */     this.jBtValider.setMnemonic(10);
/*   35 */     initialisation();
/*      */   }
/*      */   
/*      */   private JCheckBox jCBPrkvisible;
/*      */   private JCheckBox jCBRedondNomAss;
/*      */   private JCheckBox jCBSurchargeAttMere;
/*      */   private JCheckBox jCBSurchargeNom;
/*      */   private JCheckBox jCBVerifTypeAtt;
/*      */   private JCheckBox jCBVideNomAss;
/*      */   
/*      */   private void initSQL(String s)
/*      */   {
/*   39 */     if (s.equals(SQLOutil.SQLACCESS)) {
/*   40 */       this.jRBAccess.setSelected(true);
/*      */     }
/*   42 */     if (s.equals(SQLOutil.SQLDERBY)) {
/*   43 */       this.jRBDerby.setSelected(true);
/*      */     }
/*   45 */     if (s.equals(SQLOutil.SQLFIREBIRD)) {
/*   46 */       this.jRBFireBird.setSelected(true);
/*      */     }
/*   48 */     if (s.equals(SQLOutil.SQLITE)) {
/*   49 */       this.jRBSQLite.setSelected(true);
/*      */     }
/*   51 */     if (s.equals(SQLOutil.SQLMYSQL)) {
/*   52 */       this.jRBMySQL.setSelected(true);
/*      */     }
/*   54 */     if (s.equals(SQLOutil.SQLPOSTGRE)) {
/*   55 */       this.jRBPostGres.setSelected(true);
/*      */     }
/*   57 */     if (s.equals(SQLOutil.SQLSERVER)) {
/*   58 */       this.jRBSQLServer.setSelected(true);
/*      */     }
/*   60 */     if (s.equals(SQLOutil.SQLORACLE)) {
/*   61 */       this.jRBOracle.setSelected(true);
/*      */     }
/*   63 */     if (s.equals(SQLOutil.HSQLDB)) {
/*   64 */       this.jRBHSQLDB.setSelected(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private JCheckBox jCheckBox1;
/*      */   private JLabel jLabcardinal;
/*      */   private JLabel jLabel1;
/*      */   
/*      */   private String getSQL()
/*      */   {
/*   70 */     if (this.jRBAccess.isSelected()) {
/*   71 */       return SQLOutil.SQLACCESS;
/*      */     }
/*      */     
/*   74 */     if (this.jRBOracle.isSelected()) {
/*   75 */       return SQLOutil.SQLORACLE;
/*      */     }
/*      */     
/*   78 */     if (this.jRBSQLServer.isSelected()) {
/*   79 */       return SQLOutil.SQLSERVER;
/*      */     }
/*      */     
/*   82 */     if (this.jRBDerby.isSelected()) {
/*   83 */       return SQLOutil.SQLDERBY;
/*      */     }
/*      */     
/*   86 */     if (this.jRBFireBird.isSelected()) {
/*   87 */       return SQLOutil.SQLFIREBIRD;
/*      */     }
/*      */     
/*   90 */     if (this.jRBMySQL.isSelected()) {
/*   91 */       return SQLOutil.SQLMYSQL;
/*      */     }
/*      */     
/*   94 */     if (this.jRBPostGres.isSelected()) {
/*   95 */       return SQLOutil.SQLPOSTGRE;
/*      */     }
/*      */     
/*   98 */     if (this.jRBSQLite.isSelected()) {
/*   99 */       return SQLOutil.SQLITE;
/*      */     }
/*      */     
/*  102 */     if (this.jRBHSQLDB.isSelected()) {
/*  103 */       return SQLOutil.HSQLDB;
/*      */     }
/*  105 */     return "";
/*      */   }
/*      */   
/*      */   private JLabel jLabel10;
/*      */   private JLabel jLabel11;
/*      */   private JLabel jLabel12;
/*      */   
/*      */   private void initReseau(boolean reseau)
/*      */   {
/*  109 */     if (reseau)
/*      */     {
/*  110 */       this.jRBProxy.setSelected(true);
/*  111 */       this.jTFLogin.setEnabled(true);
/*  112 */       this.jTFPassword.setEnabled(true);
/*  113 */       this.jTFPort.setEnabled(true);
/*  114 */       this.jTFProxy.setEnabled(true);
/*      */     }
/*      */     else
/*      */     {
/*  116 */       this.jRBPasDeProxy.setSelected(true);
/*  117 */       this.jTFLogin.setEnabled(false);
/*  118 */       this.jTFPassword.setEnabled(false);
/*  119 */       this.jTFPort.setEnabled(false);
/*  120 */       this.jTFProxy.setEnabled(false);
/*      */     }
/*      */   }
/*      */   
/*      */   private JLabel jLabel13;
/*      */   private JLabel jLabel14;
/*      */   private JLabel jLabel15;
/*      */   
/*      */   public void initialisation()
/*      */   {
/*  126 */     this.jTFDeveloppeur.setText(Setting.developpeur);
/*  127 */     this.jTFLogin.setText(Setting.proxyLogin);
/*  128 */     this.jTFPassword.setText(Setting.proxyPassW);
/*  129 */     this.jTFPort.setText(Setting.proxyPort);
/*  130 */     this.jTFProxy.setText(Setting.proxyHTTP);
/*  131 */     this.jTFdateDerUse.setText(Setting.dateDerUse);
/*      */     
/*  133 */     this.jCBCardinalite2points.setSelected(Setting.cardinalite2points);
/*  134 */     this.jCBCardinaliteMajuscule.setSelected(Setting.cardinaliteMajuscule);
/*  135 */     this.jCBDesactiverHeritage.setSelected(Setting.desactiverHeritage);
/*  136 */     this.jCBPrkvisible.setSelected(Setting.prkvisible);
/*      */     
/*  138 */     this.jCBAttMere.setSelected(Setting.attMere);
/*  139 */     this.jCBAttUniq.setSelected(Setting.attUniq);
/*  140 */     this.jCBCleMere.setSelected(Setting.cleMere);
/*  141 */     this.jCBCleSiNecessaireMere.setSelected(Setting.cleSiNecessaireMere);
/*  142 */     this.jCBConvertTypeAtt.setSelected(Setting.convertTypeAtt);
/*  143 */     this.jCBHeritageMult.setSelected(Setting.heritageMult);
/*  144 */     this.jCBHistoriqueSave.setSelected(Setting.historiqueSave);
/*  145 */     this.jCBInclureCommentAttSQL.setSelected(Setting.inclureCommentAttSQL);
/*  146 */     this.jCBInclureCommentTableSQL.setSelected(Setting.inclureCommentTableSQL);
/*  147 */     this.jCBInformProprieteMCD.setSelected(Setting.informProprieteMCD);
/*      */     
/*  149 */     this.jCBMeLaisserChoix.setSelected(Setting.meLaisserChoix);
/*  150 */     this.jCBPetitCarreau.setSelected(Setting.petitCarreau);
/*  151 */     this.jCBRedondNomAss.setSelected(Setting.redondNomAss);
/*  152 */     this.jCBSurchargeAttMere.setSelected(Setting.surchargeAttMere);
/*  153 */     this.jCBSurchargeNom.setSelected(Setting.surchargeNom);
/*  154 */     this.jCBVerifTypeAtt.setSelected(Setting.verifTypeAtt);
/*      */     
/*  156 */     this.jCBVideNomAss.setSelected(Setting.videNomAss);
/*  157 */     this.jCBAttMajuscule.setSelected(Setting.attMajuscule);
/*      */     
/*      */ 
/*  160 */     initSQL(Setting.SQLDefaut);
/*  161 */     initReseau(Setting.proxy);
/*      */     
/*      */ 
/*  164 */     this.jCBImprimerDeveloppeur.setSelected(Setting.imprimerNomDev);
/*  165 */     this.jCBImprimerNomMCD.setSelected(Setting.imprimerNomMcd);
/*  166 */     this.jCBImprimerNumPage.setSelected(Setting.imprimerNumPage);
/*  167 */     this.jTFImprimerMargeBas.setText(Setting.imprimerMargeB);
/*  168 */     this.jTFImprimerMargeDroite.setText(Setting.imprimerMargeD);
/*  169 */     this.jTFImprimerMargeGauche.setText(Setting.imprimerMargeG);
/*  170 */     this.jTFImprimerMargeHaut.setText(Setting.imprimerMargeH);
/*      */     
/*  172 */     if (Setting.imprimerOrientation.equals("PORTRAIT")) this.jCBImprimerOrientation.setSelectedIndex(0);
/*  173 */     if (Setting.imprimerOrientation.equals("PAYSAGE")) {
/*  173 */       this.jCBImprimerOrientation.setSelectedIndex(1);
/*      */     }
/*      */   }
/*      */   
/*      */   private JLabel jLabel16;
/*      */   private JLabel jLabel2;
/*      */   private JLabel jLabel3;
/*      */   private JLabel jLabel4;
/*      */   
/*      */   public void enregistrerSetting()
/*      */   {
/*  178 */     Setting.developpeur = this.jTFDeveloppeur.getText();
/*  179 */     Setting.proxyLogin = this.jTFLogin.getText();
/*  180 */     Setting.proxyPassW = this.jTFPassword.getText();
/*  181 */     Setting.proxyPort = this.jTFPort.getText();
/*  182 */     Setting.proxyHTTP = this.jTFProxy.getText();
/*  183 */     Setting.dateDerUse = this.jTFdateDerUse.getText();
/*      */     
/*  185 */     Setting.cardinalite2points = this.jCBCardinalite2points.isSelected();
/*  186 */     Setting.cardinaliteMajuscule = this.jCBCardinaliteMajuscule.isSelected();
/*  187 */     Setting.desactiverHeritage = this.jCBDesactiverHeritage.isSelected();
/*  188 */     Setting.prkvisible = this.jCBPrkvisible.isSelected();
/*      */     
/*      */ 
/*  191 */     Setting.attMere = this.jCBAttMere.isSelected();
/*  192 */     Setting.attUniq = this.jCBAttUniq.isSelected();
/*  193 */     Setting.cleMere = this.jCBCleMere.isSelected();
/*  194 */     Setting.cleSiNecessaireMere = this.jCBCleSiNecessaireMere.isSelected();
/*  195 */     Setting.convertTypeAtt = this.jCBConvertTypeAtt.isSelected();
/*  196 */     Setting.heritageMult = this.jCBHeritageMult.isSelected();
/*  197 */     Setting.historiqueSave = this.jCBHistoriqueSave.isSelected();
/*  198 */     Setting.inclureCommentAttSQL = this.jCBInclureCommentAttSQL.isSelected();
/*  199 */     Setting.inclureCommentTableSQL = this.jCBInclureCommentTableSQL.isSelected();
/*  200 */     Setting.informProprieteMCD = this.jCBInformProprieteMCD.isSelected();
/*      */     
/*  202 */     Setting.meLaisserChoix = this.jCBMeLaisserChoix.isSelected();
/*  203 */     Setting.petitCarreau = this.jCBPetitCarreau.isSelected();
/*  204 */     Setting.redondNomAss = this.jCBRedondNomAss.isSelected();
/*  205 */     Setting.surchargeAttMere = this.jCBSurchargeAttMere.isSelected();
/*  206 */     Setting.surchargeNom = this.jCBSurchargeNom.isSelected();
/*  207 */     Setting.verifTypeAtt = this.jCBVerifTypeAtt.isSelected();
/*      */     
/*  209 */     Setting.videNomAss = this.jCBVideNomAss.isSelected();
/*  210 */     Setting.SQLDefaut = getSQL();
/*      */     
/*  212 */     Setting.proxy = this.jRBProxy.isSelected();
/*  213 */     Setting.attMajuscule = this.jCBAttMajuscule.isSelected();
/*      */     
/*      */ 
/*  216 */     Setting.imprimerOrientation = "PORTRAIT";
/*  217 */     if (this.jCBImprimerOrientation.getSelectedIndex() == 1) { Setting.imprimerOrientation = "PAYSAGE";
/*      */     }
/*  219 */     Setting.imprimerNomDev = this.jCBImprimerDeveloppeur.isSelected();
/*  220 */     Setting.imprimerNomMcd = this.jCBImprimerNomMCD.isSelected();
/*  221 */     Setting.imprimerNumPage = this.jCBImprimerNumPage.isSelected();
/*  222 */     Setting.imprimerMargeB = this.jTFImprimerMargeBas.getText();
/*  223 */     Setting.imprimerMargeD = this.jTFImprimerMargeDroite.getText();
/*  224 */     Setting.imprimerMargeG = this.jTFImprimerMargeGauche.getText();
/*  225 */     Setting.imprimerMargeH = this.jTFImprimerMargeHaut.getText();
/*      */   }
/*      */   
/*      */   private JLabel jLabel5;
/*      */   private JLabel jLabel6;
/*      */   
/*      */   public boolean isDouble(String s)
/*      */   {
/*  229 */     if (s.trim().length() == 0) return true;
/*      */     try {
/*  231 */       Double.parseDouble(s);
/*  232 */       return true;
/*      */     } catch (Exception e) {}
/*  234 */     return false;
/*      */   }
/*      */   
/*      */   private JLabel jLabel7;
/*      */   private JLabel jLabel8;
/*      */   private JLabel jLabel9;
/*      */   
/*      */   public boolean controleMarge()
/*      */   {
/*  239 */     if ((isDouble(this.jTFImprimerMargeBas.getText())) && (isDouble(this.jTFImprimerMargeDroite.getText())) && (isDouble(this.jTFImprimerMargeGauche.getText())) && (isDouble(this.jTFImprimerMargeHaut.getText()))) {
/*  240 */       return true;
/*      */     }
/*  242 */     return false;
/*      */   }
/*      */   
/*      */   private JPanel jPanel1;
/*      */   private JPanel jPanel10;
/*      */   private JPanel jPanel11;
/*      */   private JPanel jPanel12;
/*      */   private JPanel jPanel13;
/*      */   private JPanel jPanel14;
/*      */   private JPanel jPanel15;
/*      */   private JPanel jPanel2;
/*      */   private JPanel jPanel3;
/*      */   private JPanel jPanel4;
/*      */   
/*      */   private void initComponents()
/*      */   {
/*  254 */     this.buttonGroup1 = new ButtonGroup();
/*  255 */     this.BGScriptDefaut = new ButtonGroup();
/*  256 */     this.BtGrpColoration = new ButtonGroup();
/*  257 */     this.jTabbedPane1 = new JTabbedPane();
/*  258 */     this.jPanel1 = new JPanel();
/*  259 */     this.jCBInformProprieteMCD = new JCheckBox();
/*  260 */     this.jCBHeritageMult = new JCheckBox();
/*  261 */     this.jCBPetitCarreau = new JCheckBox();
/*  262 */     this.jCBDesactiverHeritage = new JCheckBox();
/*  263 */     this.jCBPrkvisible = new JCheckBox();
/*  264 */     this.jPanel14 = new JPanel();
/*  265 */     this.jPanel15 = new JPanel();
/*  266 */     this.jCBAttMajuscule = new JCheckBox();
/*  267 */     this.jCBHistoriqueSave = new JCheckBox();
/*  268 */     this.jCBVideNomAss = new JCheckBox();
/*  269 */     this.jCBRedondNomAss = new JCheckBox();
/*  270 */     this.jCBAttUniq = new JCheckBox();
/*  271 */     this.jPanel12 = new JPanel();
/*  272 */     this.jLabel8 = new JLabel();
/*  273 */     this.jLabcardinal = new JLabel();
/*  274 */     this.jCBCardinalite2points = new JCheckBox();
/*  275 */     this.jCBCardinaliteMajuscule = new JCheckBox();
/*  276 */     this.jPanel6 = new JPanel();
/*  277 */     this.jCBConvertTypeAtt = new JCheckBox();
/*  278 */     this.jCBVerifTypeAtt = new JCheckBox();
/*  279 */     this.jPanel5 = new JPanel();
/*  280 */     this.jLabel6 = new JLabel();
/*  281 */     this.jCBAttMere = new JCheckBox();
/*  282 */     this.jCBCleSiNecessaireMere = new JCheckBox();
/*  283 */     this.jLabel7 = new JLabel();
/*  284 */     this.jCBSurchargeNom = new JCheckBox();
/*  285 */     this.jCBMeLaisserChoix = new JCheckBox();
/*  286 */     this.jCBSurchargeAttMere = new JCheckBox();
/*  287 */     this.jCBCleMere = new JCheckBox();
/*  288 */     this.jPanel2 = new JPanel();
/*  289 */     this.jLabel1 = new JLabel();
/*  290 */     this.jPanel7 = new JPanel();
/*  291 */     this.jRBMySQL = new JRadioButton();
/*  292 */     this.jRBSQLite = new JRadioButton();
/*  293 */     this.jRBFireBird = new JRadioButton();
/*  294 */     this.jRBDerby = new JRadioButton();
/*  295 */     this.jRBPostGres = new JRadioButton();
/*  296 */     this.jRBAccess = new JRadioButton();
/*  297 */     this.jRBSQLServer = new JRadioButton();
/*  298 */     this.jRBOracle = new JRadioButton();
/*  299 */     this.jRBHSQLDB = new JRadioButton();
/*  300 */     this.jRadioButton2 = new JRadioButton();
/*  301 */     this.jPanel8 = new JPanel();
/*  302 */     this.jCBInclureCommentTableSQL = new JCheckBox();
/*  303 */     this.jCBInclureCommentAttSQL = new JCheckBox();
/*  304 */     this.jCheckBox1 = new JCheckBox();
/*  305 */     this.jPanel9 = new JPanel();
/*  306 */     this.jPanel10 = new JPanel();
/*  307 */     this.jPanel11 = new JPanel();
/*  308 */     this.jCBImprimerOrientation = new JComboBox();
/*  309 */     this.jLabel9 = new JLabel();
/*  310 */     this.jCBImprimerNumPage = new JCheckBox();
/*  311 */     this.jCBImprimerNomMCD = new JCheckBox();
/*  312 */     this.jCBImprimerDeveloppeur = new JCheckBox();
/*  313 */     this.jPanel13 = new JPanel();
/*  314 */     this.jLabel10 = new JLabel();
/*  315 */     this.jLabel12 = new JLabel();
/*  316 */     this.jLabel11 = new JLabel();
/*  317 */     this.jTFImprimerMargeGauche = new JTextField();
/*  318 */     this.jTFImprimerMargeHaut = new JTextField();
/*  319 */     this.jLabel13 = new JLabel();
/*  320 */     this.jLabel16 = new JLabel();
/*  321 */     this.jTFImprimerMargeDroite = new JTextField();
/*  322 */     this.jTFImprimerMargeBas = new JTextField();
/*  323 */     this.jCBLimitationPages = new JCheckBox();
/*  324 */     this.jPanel3 = new JPanel();
/*  325 */     this.jRBPasDeProxy = new JRadioButton();
/*  326 */     this.jRBProxy = new JRadioButton();
/*  327 */     this.jLabel4 = new JLabel();
/*  328 */     this.jTFProxy = new JTextField();
/*  329 */     this.jLabel5 = new JLabel();
/*  330 */     this.jTFPort = new JTextField();
/*  331 */     this.jLabel2 = new JLabel();
/*  332 */     this.jLabel3 = new JLabel();
/*  333 */     this.jTFLogin = new JTextField();
/*  334 */     this.jTFPassword = new JPasswordField();
/*  335 */     this.jButton3 = new JButton();
/*  336 */     this.jPanel4 = new JPanel();
/*  337 */     this.jLabel14 = new JLabel();
/*  338 */     this.jLabel15 = new JLabel();
/*  339 */     this.jTFDeveloppeur = new JTextField();
/*  340 */     this.jTFdateDerUse = new JTextField();
/*  341 */     this.jBtAnnuler = new JButton();
/*  342 */     this.jBtValider = new JButton();
/*      */     
/*  344 */     setDefaultCloseOperation(2);
/*  345 */     setTitle("Configuration de paramétres");
/*  346 */     setResizable(false);
/*      */     
/*  348 */     this.jCBInformProprieteMCD.setText("Afficher propriété du MCD");
/*      */     
/*  350 */     this.jCBHeritageMult.setText("Accepter l'héritage multiple des entités .");
/*  351 */     this.jCBHeritageMult.setEnabled(false);
/*      */     
/*  353 */     this.jCBPetitCarreau.setText("Petit carreau en arrière plan");
/*      */     
/*  355 */     this.jCBDesactiverHeritage.setText("Désactiver l'héritage");
/*      */     
/*  357 */     this.jCBPrkvisible.setText("Afficher \" PrK \" dans le MCD");
/*      */     
/*  359 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  360 */     this.jPanel1.setLayout(jPanel1Layout);
/*  361 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBInformProprieteMCD).addComponent(this.jCBPetitCarreau).addComponent(this.jCBDesactiverHeritage).addComponent(this.jCBHeritageMult).addComponent(this.jCBPrkvisible)).addContainerGap(483, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  373 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(47, 47, 47).addComponent(this.jCBInformProprieteMCD).addGap(18, 18, 18).addComponent(this.jCBPetitCarreau).addGap(18, 18, 18).addComponent(this.jCBDesactiverHeritage).addGap(18, 18, 18).addComponent(this.jCBHeritageMult).addGap(18, 18, 18).addComponent(this.jCBPrkvisible).addContainerGap(32, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  389 */     this.jTabbedPane1.addTab("Général", this.jPanel1);
/*      */     
/*  391 */     this.jCBAttMajuscule.setText("Afficher le type des attributs en majuscule");
/*  392 */     this.jCBAttMajuscule.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  394 */         FormeSetting.this.jCBAttMajusculeActionPerformed(evt);
/*      */       }
/*      */       
/*  397 */     });
/*  398 */     this.jCBHistoriqueSave.setText("Garder dans l'historique les dates de sauvegarde des MCD ");
/*  399 */     this.jCBHistoriqueSave.setEnabled(false);
/*      */     
/*  401 */     this.jCBVideNomAss.setText("Accepter des noms vides des associations qui ne seront pas des tables dans le MLD ");
/*      */     
/*  403 */     this.jCBRedondNomAss.setText("Redondance des noms des associations qui ne seront pas des tables dans le MLD ");
/*      */     
/*  405 */     this.jCBAttUniq.setText("l'attribut doit être unique dans tout le MCD");
/*      */     
/*  407 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/*  408 */     this.jPanel15.setLayout(jPanel15Layout);
/*  409 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBAttUniq).addComponent(this.jCBRedondNomAss).addComponent(this.jCBVideNomAss).addComponent(this.jCBHistoriqueSave).addComponent(this.jCBAttMajuscule)).addContainerGap(31, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  421 */     jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addComponent(this.jCBAttUniq).addGap(18, 18, 18).addComponent(this.jCBRedondNomAss).addGap(18, 18, 18).addComponent(this.jCBVideNomAss).addGap(18, 18, 18).addComponent(this.jCBHistoriqueSave).addGap(18, 18, 18).addComponent(this.jCBAttMajuscule).addContainerGap(35, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  437 */     this.jPanel12.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  438 */     this.jPanel12.setEnabled(false);
/*      */     
/*  440 */     this.jLabel8.setText("Afficher les cardinalités : ");
/*      */     
/*  442 */     this.jLabcardinal.setFont(new Font("Tahoma", 3, 12));
/*  443 */     this.jLabcardinal.setForeground(new Color(255, 0, 0));
/*  444 */     this.jLabcardinal.setText("0,n");
/*      */     
/*  446 */     this.jCBCardinalite2points.setText("Séparateur ':'");
/*  447 */     this.jCBCardinalite2points.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  449 */         FormeSetting.this.jCBCardinalite2pointsStateChanged(evt);
/*      */       }
/*  451 */     });
/*  452 */     this.jCBCardinalite2points.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  454 */         FormeSetting.this.jCBCardinalite2pointsActionPerformed(evt);
/*      */       }
/*      */       
/*  457 */     });
/*  458 */     this.jCBCardinaliteMajuscule.setText("Majuscule");
/*  459 */     this.jCBCardinaliteMajuscule.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  461 */         FormeSetting.this.jCBCardinaliteMajusculeStateChanged(evt);
/*      */       }
/*      */       
/*  464 */     });
/*  465 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/*  466 */     this.jPanel12.setLayout(jPanel12Layout);
/*  467 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel12Layout.createSequentialGroup().addComponent(this.jCBCardinalite2points).addGap(18, 18, 18).addComponent(this.jCBCardinaliteMajuscule)).addGroup(jPanel12Layout.createSequentialGroup().addComponent(this.jLabel8).addGap(18, 18, 18).addComponent(this.jLabcardinal, -1, -1, 32767))).addContainerGap(-1, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  482 */     jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.jLabcardinal)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBCardinalite2points).addComponent(this.jCBCardinaliteMajuscule)).addContainerGap(19, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  496 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/*  497 */     this.jPanel14.setLayout(jPanel14Layout);
/*  498 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel15, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.jPanel12, -2, -1, -2).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  507 */     jPanel14Layout.setVerticalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addGap(60, 60, 60).addComponent(this.jPanel12, -2, -1, -2)).addGroup(jPanel14Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.jPanel15, -1, -1, 32767))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  520 */     this.jTabbedPane1.addTab("Contraintes MCD", this.jPanel14);
/*      */     
/*  522 */     this.jCBConvertTypeAtt.setText("Convertir les types des bases de données importées.");
/*  523 */     this.jCBConvertTypeAtt.setEnabled(false);
/*      */     
/*  525 */     this.jCBVerifTypeAtt.setText("Vérifier les types des attributs");
/*  526 */     this.jCBVerifTypeAtt.setEnabled(false);
/*      */     
/*  528 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  529 */     this.jPanel6.setLayout(jPanel6Layout);
/*  530 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(17, 17, 17).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBVerifTypeAtt).addComponent(this.jCBConvertTypeAtt)).addContainerGap(408, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  539 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.jCBVerifTypeAtt).addGap(18, 18, 18).addComponent(this.jCBConvertTypeAtt).addContainerGap(177, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  549 */     this.jTabbedPane1.addTab("Rétro conception", this.jPanel6);
/*      */     
/*  551 */     this.jLabel6.setFont(new Font("Tahoma", 1, 11));
/*  552 */     this.jLabel6.setText("Héritage");
/*      */     
/*  554 */     this.jCBAttMere.setText("Importer tous les attributs (non clés primaires ) de l'entité mère");
/*      */     
/*  556 */     this.jCBCleSiNecessaireMere.setText("Ne pas importer la clé mère si la l'entité fille possède sa propre clé primaire");
/*      */     
/*  558 */     this.jLabel7.setFont(new Font("Tahoma", 1, 11));
/*  559 */     this.jLabel7.setText("Migration des attributs ");
/*      */     
/*  561 */     this.jCBSurchargeNom.setText("Surcharger le nom des clés par le nom de l'entité sources.");
/*      */     
/*  563 */     this.jCBMeLaisserChoix.setText("me laisser le choix de renommer la surcharge d'un attribut");
/*  564 */     this.jCBMeLaisserChoix.setEnabled(false);
/*      */     
/*  566 */     this.jCBSurchargeAttMere.setText("surcharger les noms des attributs par le nom de leur entité mère.");
/*  567 */     this.jCBSurchargeAttMere.setEnabled(false);
/*      */     
/*  569 */     this.jCBCleMere.setText("Importer les clés primaires de l'entité mère");
/*  570 */     this.jCBCleMere.setEnabled(false);
/*      */     
/*  572 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  573 */     this.jPanel5.setLayout(jPanel5Layout);
/*  574 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addGroup(jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBAttMere).addComponent(this.jCBCleSiNecessaireMere).addComponent(this.jCBCleMere).addComponent(this.jCBSurchargeAttMere))).addComponent(this.jLabel7).addGroup(jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBMeLaisserChoix).addComponent(this.jCBSurchargeNom)))).addContainerGap(307, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  595 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCBAttMere).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBCleSiNecessaireMere).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBCleMere).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBSurchargeAttMere).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, 32767).addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBSurchargeNom).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBMeLaisserChoix).addGap(24, 24, 24)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  617 */     this.jTabbedPane1.addTab("Clé étrangère", this.jPanel5);
/*      */     
/*  619 */     this.jLabel1.setFont(new Font("Tahoma", 1, 11));
/*  620 */     this.jLabel1.setText("Script SQL par défaut :");
/*      */     
/*  622 */     this.jPanel7.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  624 */     this.BGScriptDefaut.add(this.jRBMySQL);
/*  625 */     this.jRBMySQL.setSelected(true);
/*  626 */     this.jRBMySQL.setText("MySQL");
/*      */     
/*  628 */     this.BGScriptDefaut.add(this.jRBSQLite);
/*  629 */     this.jRBSQLite.setText("SQLite");
/*      */     
/*  631 */     this.BGScriptDefaut.add(this.jRBFireBird);
/*  632 */     this.jRBFireBird.setText("FireBird");
/*      */     
/*  634 */     this.BGScriptDefaut.add(this.jRBDerby);
/*  635 */     this.jRBDerby.setText("Derby");
/*      */     
/*  637 */     this.BGScriptDefaut.add(this.jRBPostGres);
/*  638 */     this.jRBPostGres.setText("PostGres");
/*      */     
/*  640 */     this.BGScriptDefaut.add(this.jRBAccess);
/*  641 */     this.jRBAccess.setText("Access");
/*      */     
/*  643 */     this.BGScriptDefaut.add(this.jRBSQLServer);
/*  644 */     this.jRBSQLServer.setText("SQL Server");
/*      */     
/*  646 */     this.BGScriptDefaut.add(this.jRBOracle);
/*  647 */     this.jRBOracle.setText("Oracle");
/*      */     
/*  649 */     this.BGScriptDefaut.add(this.jRBHSQLDB);
/*  650 */     this.jRBHSQLDB.setText("HSQLDB (OpenOffice Base)");
/*      */     
/*  652 */     this.BGScriptDefaut.add(this.jRadioButton2);
/*  653 */     this.jRadioButton2.setText("DB2");
/*  654 */     this.jRadioButton2.setEnabled(false);
/*      */     
/*  656 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  657 */     this.jPanel7.setLayout(jPanel7Layout);
/*  658 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRBMySQL).addComponent(this.jRBSQLite).addComponent(this.jRBFireBird).addComponent(this.jRBDerby).addComponent(this.jRBHSQLDB)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRBPostGres).addComponent(this.jRBAccess).addComponent(this.jRBSQLServer).addComponent(this.jRBOracle).addComponent(this.jRadioButton2)).addGap(17, 17, 17)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  677 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jRBPostGres).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBAccess).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBSQLServer).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBOracle).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRadioButton2)).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jRBMySQL).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBSQLite).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBFireBird).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBDerby).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBHSQLDB))).addContainerGap(-1, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  705 */     this.jPanel8.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  707 */     this.jCBInclureCommentTableSQL.setText("Inclure les commentaires associés aux tables dans le script ");
/*      */     
/*  709 */     this.jCBInclureCommentAttSQL.setText("Inclure les commentaires associés aux attributs dans le script ");
/*      */     
/*  711 */     this.jCheckBox1.setText("Documenter le script de sortie. ");
/*  712 */     this.jCheckBox1.setEnabled(false);
/*      */     
/*  714 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  715 */     this.jPanel8.setLayout(jPanel8Layout);
/*  716 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBInclureCommentTableSQL).addComponent(this.jCheckBox1).addComponent(this.jCBInclureCommentAttSQL)).addContainerGap(43, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  726 */     jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.jCBInclureCommentTableSQL).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBInclureCommentAttSQL).addGap(30, 30, 30).addComponent(this.jCheckBox1).addContainerGap(20, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  738 */     this.jPanel9.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  740 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  741 */     this.jPanel9.setLayout(jPanel9Layout);
/*  742 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 684, 32767));
/*      */     
/*      */ 
/*      */ 
/*  746 */     jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 67, 32767));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  751 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  752 */     this.jPanel2.setLayout(jPanel2Layout);
/*  753 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel9, -1, -1, 32767).addComponent(this.jLabel1).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jPanel7, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.jPanel8, -2, -1, -2))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  766 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel8, -1, -1, 32767).addComponent(this.jPanel7, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel9, -2, -1, -2).addGap(39, 39, 39)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  780 */     this.jTabbedPane1.addTab("Script de sortie", this.jPanel2);
/*      */     
/*  782 */     this.jPanel11.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  784 */     this.jCBImprimerOrientation.setModel(new DefaultComboBoxModel(new String[] { "Portrait", "Paysage" }));
/*      */     
/*  786 */     this.jLabel9.setText("Orientation");
/*      */     
/*  788 */     this.jCBImprimerNumPage.setSelected(true);
/*  789 */     this.jCBImprimerNumPage.setText("Afficher numéro de la page");
/*      */     
/*  791 */     this.jCBImprimerNomMCD.setSelected(true);
/*  792 */     this.jCBImprimerNomMCD.setText("Afficher le nom du MCD");
/*      */     
/*  794 */     this.jCBImprimerDeveloppeur.setSelected(true);
/*  795 */     this.jCBImprimerDeveloppeur.setText("Afficher le nom du développeur");
/*      */     
/*  797 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/*  798 */     this.jPanel11.setLayout(jPanel11Layout);
/*  799 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jCBImprimerDeveloppeur).addContainerGap()).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jCBImprimerNomMCD).addContainerGap()).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jCBImprimerNumPage).addGap(180, 180, 180)).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jLabel9, -2, 62, -2).addGap(18, 18, 18).addComponent(this.jCBImprimerOrientation, 0, 245, 32767).addContainerGap())))));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  820 */     jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGap(24, 24, 24).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBImprimerOrientation, -2, -1, -2).addComponent(this.jLabel9)).addGap(28, 28, 28).addComponent(this.jCBImprimerNumPage).addGap(18, 18, 18).addComponent(this.jCBImprimerNomMCD).addGap(18, 18, 18).addComponent(this.jCBImprimerDeveloppeur).addContainerGap(29, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  836 */     this.jPanel13.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  838 */     this.jLabel10.setText("Marges (cm)");
/*      */     
/*  840 */     this.jLabel12.setText("Haut");
/*      */     
/*  842 */     this.jLabel11.setText("Gauche");
/*      */     
/*  844 */     this.jTFImprimerMargeGauche.setEditable(false);
/*      */     
/*  846 */     this.jTFImprimerMargeHaut.setEditable(false);
/*      */     
/*  848 */     this.jLabel13.setText("Droite");
/*      */     
/*  850 */     this.jLabel16.setText("Bas");
/*      */     
/*  852 */     this.jTFImprimerMargeDroite.setEditable(false);
/*      */     
/*  854 */     this.jTFImprimerMargeBas.setEditable(false);
/*      */     
/*  856 */     this.jCBLimitationPages.setText("Afficher les limites des pages");
/*  857 */     this.jCBLimitationPages.setEnabled(false);
/*      */     
/*  859 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/*  860 */     this.jPanel13.setLayout(jPanel13Layout);
/*  861 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addComponent(this.jCBLimitationPages).addContainerGap()).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addComponent(this.jLabel10).addContainerGap(233, 32767)).addGroup(jPanel13Layout.createSequentialGroup().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)).addGroup(jPanel13Layout.createSequentialGroup().addComponent(this.jLabel12).addGap(23, 23, 23))).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jTFImprimerMargeHaut, GroupLayout.Alignment.LEADING).addComponent(this.jTFImprimerMargeGauche, GroupLayout.Alignment.LEADING, -2, 47, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel13).addComponent(this.jLabel16)).addGap(18, 18, 18).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jTFImprimerMargeBas).addComponent(this.jTFImprimerMargeDroite, -2, 54, -2)).addGap(56, 56, 56))))));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  894 */     jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel10).addGap(37, 37, 37).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFImprimerMargeDroite, -2, -1, -2).addComponent(this.jLabel13)).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.jTFImprimerMargeGauche, -2, -1, -2))).addGap(42, 42, 42).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFImprimerMargeBas, -2, -1, -2).addComponent(this.jLabel16)).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.jTFImprimerMargeHaut, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, 32767).addComponent(this.jCBLimitationPages).addGap(21, 21, 21)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  920 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  921 */     this.jPanel10.setLayout(jPanel10Layout);
/*  922 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel11, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767).addComponent(this.jPanel13, -2, -1, -2).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  931 */     jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel11, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel13, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addGap(37, 37, 37)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  941 */     this.jTabbedPane1.addTab("Impression", this.jPanel10);
/*      */     
/*  943 */     this.buttonGroup1.add(this.jRBPasDeProxy);
/*  944 */     this.jRBPasDeProxy.setSelected(true);
/*  945 */     this.jRBPasDeProxy.setText("Pas de proxy");
/*  946 */     this.jRBPasDeProxy.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  948 */         FormeSetting.this.jRBPasDeProxyStateChanged(evt);
/*      */       }
/*      */       
/*  951 */     });
/*  952 */     this.buttonGroup1.add(this.jRBProxy);
/*  953 */     this.jRBProxy.setText("Parametres proxy");
/*  954 */     this.jRBProxy.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  956 */         FormeSetting.this.jRBProxyStateChanged(evt);
/*      */       }
/*      */       
/*  959 */     });
/*  960 */     this.jLabel4.setText("Proxy HTTP ");
/*      */     
/*  962 */     this.jTFProxy.setEnabled(false);
/*      */     
/*  964 */     this.jLabel5.setText("Port");
/*      */     
/*  966 */     this.jTFPort.setEnabled(false);
/*      */     
/*  968 */     this.jLabel2.setText("Login");
/*      */     
/*  970 */     this.jLabel3.setText("Password");
/*      */     
/*  972 */     this.jTFLogin.setEnabled(false);
/*      */     
/*  974 */     this.jTFPassword.setEnabled(false);
/*      */     
/*  976 */     this.jButton3.setText("Tester Connexion ...");
/*  977 */     this.jButton3.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  979 */         FormeSetting.this.jButton3ActionPerformed(evt);
/*      */       }
/*      */       
/*  982 */     });
/*  983 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  984 */     this.jPanel3.setLayout(jPanel3Layout);
/*  985 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(29, 29, 29).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel3, GroupLayout.Alignment.LEADING, -1, 59, 32767).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -1, 59, 32767).addComponent(this.jLabel4, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFPassword, -1, 382, 32767).addComponent(this.jTFLogin, -1, 382, 32767).addComponent(this.jTFProxy, -2, 382, -2).addComponent(this.jButton3, GroupLayout.Alignment.TRAILING, -2, 160, -2)).addGap(18, 18, 18).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFPort, -2, 61, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jRBProxy, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 456, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jRBPasDeProxy, -1, 214, 32767).addGap(375, 375, 375))).addGap(111, 111, 111)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1014 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jRBPasDeProxy).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRBProxy).addGap(12, 12, 12).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jTFProxy, -2, -1, -2).addComponent(this.jTFPort, -2, -1, -2).addComponent(this.jLabel5)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTFLogin, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTFPassword, -2, -1, -2)).addGap(29, 29, 29).addComponent(this.jButton3).addContainerGap(46, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1040 */     this.jTabbedPane1.addTab("Réseau", this.jPanel3);
/*      */     
/* 1042 */     this.jLabel14.setText("Dernière utilisation");
/*      */     
/* 1044 */     this.jLabel15.setText("Développeur");
/*      */     
/* 1046 */     this.jTFdateDerUse.setEditable(false);
/*      */     
/* 1048 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1049 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1050 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel15).addGap(46, 46, 46).addComponent(this.jTFDeveloppeur, -2, 534, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel14).addGap(18, 18, 18).addComponent(this.jTFdateDerUse, -2, 109, -2))).addContainerGap(55, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1065 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(49, 49, 49).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel15).addComponent(this.jTFDeveloppeur, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel14).addComponent(this.jTFdateDerUse, -2, -1, -2)).addContainerGap(159, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1079 */     this.jTabbedPane1.addTab("Informations", this.jPanel4);
/*      */     
/* 1081 */     this.jBtAnnuler.setIcon(new ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 1082 */     this.jBtAnnuler.setText("Annuler");
/* 1083 */     this.jBtAnnuler.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1085 */         FormeSetting.this.jBtAnnulerActionPerformed(evt);
/*      */       }
/*      */       
/* 1088 */     });
/* 1089 */     this.jBtValider.setIcon(new ImageIcon(getClass().getResource("/Images/OK.png")));
/* 1090 */     this.jBtValider.setText("Ok");
/* 1091 */     this.jBtValider.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1093 */         FormeSetting.this.jBtValiderActionPerformed(evt);
/*      */       }
/*      */       
/* 1096 */     });
/* 1097 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 1098 */     getContentPane().setLayout(layout);
/* 1099 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jTabbedPane1, GroupLayout.Alignment.LEADING, -1, 711, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtValider, -2, 81, -2))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1111 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -2, 294, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtAnnuler).addComponent(this.jBtValider)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1123 */     pack();
/*      */   }
/*      */   
/*      */   private JPanel jPanel5;
/*      */   private JPanel jPanel6;
/*      */   
/*      */   private void jRBPasDeProxyStateChanged(ChangeEvent evt)
/*      */   {
/* 1127 */     if (this.jRBPasDeProxy.isSelected())
/*      */     {
/* 1128 */       this.jTFProxy.setEnabled(false);
/* 1129 */       this.jTFPort.setEnabled(false);
/* 1130 */       this.jTFLogin.setEnabled(false);
/* 1131 */       this.jTFPassword.setEnabled(false);
/*      */     }
/*      */   }
/*      */   
/*      */   private JPanel jPanel7;
/*      */   private JPanel jPanel8;
/*      */   private JPanel jPanel9;
/*      */   private void jRBProxyStateChanged(ChangeEvent evt)
/*      */   {
/* 1136 */     if (this.jRBProxy.isSelected())
/*      */     {
/* 1137 */       this.jTFProxy.setEnabled(true);
/* 1138 */       this.jTFPort.setEnabled(true);
/* 1139 */       this.jTFLogin.setEnabled(true);
/* 1140 */       this.jTFPassword.setEnabled(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jBtAnnulerActionPerformed(ActionEvent evt)
/*      */   {
/* 1145 */     dispose();
/*      */   }
/*      */   
/*      */   private void jBtValiderActionPerformed(ActionEvent evt)
/*      */   {
/* 1149 */     if (controleMarge())
/*      */     {
/* 1150 */       enregistrerSetting();
/* 1151 */       dispose();
/*      */     }
/*      */     else
/*      */     {
/* 1153 */       JOptionPane.showMessageDialog(this, "Erreur : Verifiez les champs de saisie Marge dans l'onglet 'Impression'");
/*      */     }
/*      */   }
/*      */   private JRadioButton jRBAccess;
/*      */   private JRadioButton jRBDerby;
/*      */   private JRadioButton jRBFireBird;
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt)
/*      */   {
/* 1159 */     String s = InfoSite.dump("http://www.jfreesoft.com/infoSite.php");
/* 1160 */     if (s.indexOf("ErreurRM") >= 0)
/*      */     {
/* 1161 */       if (this.jRBPasDeProxy.isSelected()) {
/* 1162 */         JOptionPane.showMessageDialog(this, "Impossible de se connecter sans les paramètres du proxy, \nVérifier avec paramètres proxy ou la connexion internet");
/*      */       } else {
/* 1164 */         JOptionPane.showMessageDialog(this, "Impossible de se connecter avec les paramètres du proxy,\nVérifier la connexion internet");
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1167 */       JOptionPane.showMessageDialog(this, "Connexion réussie !!");
/* 1168 */       new ThreadSite(this.frm);
/*      */     }
/*      */   }
/*      */   
/*      */   private JRadioButton jRBHSQLDB;
/*      */   private JRadioButton jRBMySQL;
/*      */   
/*      */   private void jCBCardinalite2pointsActionPerformed(ActionEvent evt) {}
/*      */   private JRadioButton jRBOracle;
/*      */   private JRadioButton jRBPasDeProxy;
/*      */   private JRadioButton jRBPostGres;
/*      */   
/*      */   private void jCBCardinalite2pointsStateChanged(ChangeEvent evt)
/*      */   {
/* 1177 */     if (this.jCBCardinalite2points.isSelected()) {
/* 1178 */       this.jLabcardinal.setText(this.jLabcardinal.getText().replace(",", ":"));
/*      */     } else {
/* 1180 */       this.jLabcardinal.setText(this.jLabcardinal.getText().replace(":", ","));
/*      */     }
/*      */   }
/*      */   
/*      */   private JRadioButton jRBProxy;
/*      */   private JRadioButton jRBSQLServer;
/*      */   private JRadioButton jRBSQLite;
/*      */   
/*      */   private void jCBCardinaliteMajusculeStateChanged(ChangeEvent evt)
/*      */   {
/* 1185 */     if (this.jCBCardinaliteMajuscule.isSelected()) {
/* 1186 */       if (this.jCBCardinalite2points.isSelected()) {
/* 1187 */         this.jLabcardinal.setText("0:N");
/*      */       } else {
/* 1189 */         this.jLabcardinal.setText("0,N");
/*      */       }
/*      */     }
/* 1192 */     else if (this.jCBCardinalite2points.isSelected()) {
/* 1193 */       this.jLabcardinal.setText("0:n");
/*      */     } else {
/* 1195 */       this.jLabcardinal.setText("0,n");
/*      */     }
/*      */   }
/*      */   
/*      */   private JRadioButton jRadioButton2;
/*      */   private JTextField jTFDeveloppeur;
/*      */   private JTextField jTFImprimerMargeBas;
/*      */   private JTextField jTFImprimerMargeDroite;
/*      */   private JTextField jTFImprimerMargeGauche;
/*      */   private JTextField jTFImprimerMargeHaut;
/*      */   private JTextField jTFLogin;
/*      */   private JPasswordField jTFPassword;
/*      */   private JTextField jTFPort;
/*      */   private JTextField jTFProxy;
/*      */   private JTextField jTFdateDerUse;
/*      */   private JTabbedPane jTabbedPane1;
/*      */   private void jCBAttMajusculeActionPerformed(ActionEvent evt) {}
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeSetting.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */