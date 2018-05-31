/*     */ package mythread;
/*     */ 
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmProjet;
/*     */ import IhmMCD2.ConfigurationMCD2;
/*     */ import IhmMLD.IhmPageMLD;
/*     */ import MyExplorer.ConsolePane;
/*     */ import MyExplorer.ExplorerPan;
/*     */ import MySqlEditor.JTextEditorPan;
/*     */ import MySqlEditor.MySqlTextPane;
/*     */ import Outil.Setting;
/*     */ import Output.SQLDerby;
/*     */ import Output.SQLFirebird;
/*     */ import Output.SQLHsqldb;
/*     */ import Output.SQLMySQL;
/*     */ import Output.SQLOutil;
/*     */ import Output.SQLPostGre;
/*     */ import formes.FormeConstruction;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.FormeInterneMLD;
/*     */ import ihm.FormeInterneSQL;
/*     */ import ihm.Principale;
/*     */ import java.awt.Color;
/*     */ import java.beans.PropertyVetoException;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.SwingWorker;
/*     */ import vConversion.Transformation;
/*     */ import verificationAdaptation.Verification;
/*     */ 
/*     */ public class ThreadConstruction extends SwingWorker
/*     */ {
/*     */   private Principale frm;
/*     */   private IhmPageMCD page;
/*     */   
/*     */   public ThreadConstruction(Principale frm, IhmPageMCD page)
/*     */   {
/*  41 */     this.frm = frm;
/*  42 */     this.page = page;
/*     */   }
/*     */   
/*     */   private void passerLesParametresMCDtoMLD()
/*     */   {
/*  47 */     this.frm.getFormeMLD().isDegradee2 = this.page.getConfigurationMCD().isDegradee2;
/*  48 */     this.frm.getFormeMLD().isOmbree2 = this.page.getConfigurationMCD().isOmbree2;
/*  49 */     this.frm.getFormeMLD().afficheType2 = this.page.getConfigurationMCD().afficheType2;
/*  50 */     this.frm.getFormeMLD().arrondirEntite2 = this.page.getConfigurationMCD().arrondirEntite2;
/*  51 */     this.frm.getFormeMLD().zoom = this.page.getConfigurationMCD().zoom;
/*  52 */     this.frm.getFormeMLD().getPageMld().setZoom(this.page.getConfigurationMCD().zoom);
/*     */   }
/*     */   
/*     */   private void genererScript()
/*     */   {
/*  57 */     if (Setting.SQLDefaut.trim().equals("")) {
/*  58 */       this.frm.getFormeSQL().getPanelsql().getPane().setText(SQLMySQL.getScript(this.frm.getFormeMCD().getPage(), this.frm.getFormeMLD().getPageMld()));
/*  59 */       this.frm.getFormeSQL().getPanelsql().setTypeSql(SQLOutil.SQLMYSQL);
/*     */     }
/*  61 */     if (Setting.SQLDefaut.trim().equals(SQLOutil.SQLACCESS)) {
/*  62 */       this.frm.getFormeSQL().getPanelsql().getPane().setText(Output.SQLAccess.getScript(this.frm.getFormeMLD().getPageMld(), this.frm.getFormeMCD().getPage()));
/*  63 */       this.frm.getFormeSQL().getPanelsql().setTypeSql(SQLOutil.SQLACCESS);
/*     */     }
/*  65 */     if (Setting.SQLDefaut.trim().equals(SQLOutil.SQLDERBY)) {
/*  66 */       this.frm.getFormeSQL().getPanelsql().getPane().setText(SQLDerby.getScript(this.frm.getFormeMCD().getPage(), this.frm.getFormeMLD().getPageMld()));
/*  67 */       this.frm.getFormeSQL().getPanelsql().setTypeSql(SQLOutil.SQLDERBY);
/*     */     }
/*  69 */     if (Setting.SQLDefaut.trim().equals(SQLOutil.SQLFIREBIRD)) {
/*  70 */       this.frm.getFormeSQL().getPanelsql().getPane().setText(SQLFirebird.getScript(this.frm.getFormeMCD().getPage(), this.frm.getFormeMLD().getPageMld()));
/*  71 */       this.frm.getFormeSQL().getPanelsql().setTypeSql(SQLOutil.SQLFIREBIRD);
/*     */     }
/*  73 */     if (Setting.SQLDefaut.trim().equals(SQLOutil.SQLITE)) {
/*  74 */       this.frm.getFormeSQL().getPanelsql().getPane().setText(Output.SQLite.getScript(this.frm.getFormeMCD().getPage(), this.frm.getFormeMLD().getPageMld()));
/*  75 */       this.frm.getFormeSQL().getPanelsql().setTypeSql(SQLOutil.SQLITE);
/*     */     }
/*  77 */     if (Setting.SQLDefaut.trim().equals(SQLOutil.SQLMYSQL)) {
/*  78 */       this.frm.getFormeSQL().getPanelsql().getPane().setText(SQLMySQL.getScript(this.frm.getFormeMCD().getPage(), this.frm.getFormeMLD().getPageMld()));
/*  79 */       this.frm.getFormeSQL().getPanelsql().setTypeSql(SQLOutil.SQLMYSQL);
/*     */     }
/*  81 */     if (Setting.SQLDefaut.trim().equals(SQLOutil.SQLPOSTGRE)) {
/*  82 */       this.frm.getFormeSQL().getPanelsql().getPane().setText(SQLPostGre.getScript(this.frm.getFormeMLD().getPageMld(), this.frm.getFormeMCD().getPage()));
/*  83 */       this.frm.getFormeSQL().getPanelsql().setTypeSql(SQLOutil.SQLPOSTGRE);
/*     */     }
/*     */     
/*  86 */     if (Setting.SQLDefaut.trim().equals(SQLOutil.SQLSERVER)) {
/*  87 */       this.frm.getFormeSQL().getPanelsql().getPane().setText(Output.SQLServer.getScript(this.frm.getFormeMLD().getPageMld(), this.frm.getFormeMCD().getPage()));
/*  88 */       this.frm.getFormeSQL().getPanelsql().setTypeSql(SQLOutil.SQLSERVER);
/*     */     }
/*     */     
/*  91 */     if (Setting.SQLDefaut.trim().equals(SQLOutil.SQLORACLE)) {
/*  92 */       this.frm.getFormeSQL().getPanelsql().getPane().setText(Output.SQLOracle.getScript(this.frm.getFormeMCD().getPage(), this.frm.getFormeMLD().getPageMld()));
/*  93 */       this.frm.getFormeSQL().getPanelsql().setTypeSql(SQLOutil.SQLORACLE);
/*     */     }
/*     */     
/*  96 */     if (Setting.SQLDefaut.trim().equals(SQLOutil.HSQLDB)) {
/*  97 */       this.frm.getFormeSQL().getPanelsql().getPane().setText(SQLHsqldb.getScript(this.frm.getFormeMCD().getPage(), this.frm.getFormeMLD().getPageMld()));
/*  98 */       this.frm.getFormeSQL().getPanelsql().setTypeSql(SQLOutil.HSQLDB);
/*     */     }
/*     */   }
/*     */   
/*     */   protected Object doInBackground()
/*     */     throws Exception
/*     */   {
/* 105 */     FormeConstruction frmCons = new FormeConstruction(this.frm, true);
/* 106 */     frmCons.setModal(false);
/* 107 */     frmCons.getjLabNom().setText("Conversion du MCD");
/*     */     
/* 109 */     frmCons.setVisible(true);
/*     */     
/* 111 */     frmCons.getjProgBar().setValue(10);
/* 112 */     String rep = Verification.verifierPageMCD(this.page);
/* 113 */     frmCons.getjProgBar().setValue(50);
/* 114 */     if (rep.trim().length() == 0) {
/* 115 */       passerLesParametresMCDtoMLD();
/* 116 */       Transformation con = new Transformation(Verification.listeRelationLien, this.page);
/*     */       
/*     */ 
/* 119 */       con.convertirEntiteEnMLD(this.page.getListeEntiteRelation());
/* 120 */       frmCons.getjProgBar().setValue(55);
/*     */       
/* 122 */       con.setCleAllEntiteHeritageRelatif(this.page.getListeEntiteRelation(), this.page.getListeLienHeritage(), this.page.getListeLien());
/* 123 */       frmCons.getjProgBar().setValue(60);
/*     */       
/*     */ 
/* 126 */       con.transformerAllRelation();
/*     */       
/* 128 */       frmCons.getjProgBar().setValue(65);
/* 129 */       con.ajouterLienHeritage(this.page.getListeLienHeritage(), this.page.getListeLienContrainteHeritage());
/*     */       
/* 131 */       con.importerAttributHeritage(this.page.getListeLienHeritage());
/*     */       
/* 133 */       con.ordonnerMLDEntite();
/* 134 */       con.corrigerTypeDesCle();
/*     */       
/*     */ 
/* 137 */       frmCons.getjProgBar().setValue(75);
/* 138 */       con.setMLDEntiteDansPageMLD(this.frm.getProjetSel().getFormeMLD().getPageMld(), this.page.getZoom());
/* 139 */       frmCons.getjProgBar().setValue(80);
/* 140 */       con.structurerAttribut(this.frm.getProjetSel().getFormeMLD().getPageMld());
/* 141 */       frmCons.getjProgBar().setValue(90);
/*     */       
/* 143 */       this.frm.getFormeMLD().getPageMld().setNomAllcontrainte();
/*     */       
/* 145 */       this.frm.getFormeMLD().getPageMld().setEntiteModifer(false);
/*     */       
/* 147 */       genererScript();
/* 148 */       frmCons.getjProgBar().setValue(100);
/* 149 */       frmCons.dispose();
/*     */       try {
/* 151 */         this.frm.getFormeMLD().setIcon(false);
/* 152 */         this.frm.getFormeMLD().setVisible(true);
/* 153 */         this.frm.getFormeSQL().setIcon(false);
/* 154 */         this.frm.getFormeSQL().setVisible(true);
/*     */       } catch (PropertyVetoException ex) {
/* 156 */         Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/* 158 */       this.frm.getFormeSQL().toFront();
/* 159 */       this.frm.getFormeMLD().toFront();
/* 160 */       this.frm.repaint();
/*     */     }
/*     */     else {
/* 163 */       frmCons.dispose();
/* 164 */       this.frm.getConsole().getRapport().setBackground(Color.WHITE);
/* 165 */       this.frm.getConsole().getRapport().setText("ERREUR : Le MCD est incorrect");
/* 166 */       this.frm.getConsole().getRapport().append(rep);
/* 167 */       javax.swing.JOptionPane.showConfirmDialog(frmCons, "le MCD n'est pas correct !!! \nVoir messages dans console !", "Vérification du MCD ", -1, 0);
/*     */     }
/*     */     
/*     */ 
/* 171 */     return Integer.valueOf(0);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadConstruction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */