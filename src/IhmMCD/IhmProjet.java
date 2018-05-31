/*     */ package IhmMCD;
/*     */ 
/*     */ import IhmMLD.IhmPageMLD;
/*     */ import MyExplorer.ExplorerPan;
/*     */ import MyExplorer.NodeProjet;
/*     */ import MySqlEditor.JTextEditorPan;
/*     */ import Output.SQLOutil;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.FormeInterneMLD;
/*     */ import ihm.FormeInterneSQL;
/*     */ import ihm.FormeInterneXML;
/*     */ import ihm.Principale;
/*     */ import java.io.File;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmProjet
/*     */ {
/*     */   private FormeInterneMCD formeMCD;
/*     */   private FormeInterneMLD formeMLD;
/*     */   private FormeInterneSQL formeSQL;
/*     */   private FormeInterneXML formeXML;
/*     */   private Principale frm;
/*     */   private NodeProjet nodeRacineProj;
/*  29 */   private static int numproj = 0;
/*     */   
/*     */   private int num;
/*     */   private boolean mainProject;
/*  33 */   public static int xlocal = 0; public static int ylocal = 0;
/*     */   
/*  35 */   public IhmProjet(Principale frm) { this.frm = frm;
/*  36 */     this.mainProject = true;
/*  37 */     this.formeMCD = new FormeInterneMCD(frm, this);
/*  38 */     frm.setFormeMCD(this.formeMCD);
/*  39 */     this.formeMLD = new FormeInterneMLD(frm, null, this);
/*  40 */     frm.setFormeMLD(this.formeMLD);
/*  41 */     this.formeSQL = new FormeInterneSQL(frm, this);
/*  42 */     frm.setFormeSQL(this.formeSQL);
/*  43 */     this.formeXML = new FormeInterneXML(frm, this);
/*  44 */     frm.setFormeXML(this.formeXML);
/*  45 */     this.nodeRacineProj = new NodeProjet(this);
/*  46 */     this.nodeRacineProj.add(this.formeSQL.getRacineNodeSQL());
/*  47 */     this.nodeRacineProj.add(this.formeXML.getRacineXML());
/*  48 */     this.nodeRacineProj.add(this.formeMCD.getRacineMCD());
/*  49 */     this.nodeRacineProj.add(this.formeMLD.getRacineMLD());
/*  50 */     this.formeMLD.getPageMld().setClPage(this.formeMCD.getPage().clPage);
/*  51 */     this.formeMCD.setSize(900, 500);
/*  52 */     this.formeMCD.setLocation(100 + xlocal, 30 + ylocal);
/*  53 */     xlocal += 20;
/*  54 */     if (xlocal > 100) xlocal = 0;
/*  55 */     ylocal += 20;
/*  56 */     if (ylocal > 100) { ylocal = 0;
/*     */     }
/*  58 */     this.formeSQL.setSize(700, 400);
/*  59 */     this.formeSQL.setLocation(0, 0);
/*  60 */     this.formeMLD.setSize(700, 400);
/*  61 */     this.formeMLD.setLocation(50, 50);
/*  62 */     this.formeSQL.getPanelsql().setTypeSql(SQLOutil.SQLMYSQL);
/*  63 */     frm.getExplorer().getRacineArbre().add(this.nodeRacineProj);
/*  64 */     frm.getExplorer().getTree().updateUI();
/*  65 */     this.num = numproj;
/*  66 */     numproj += 1;
/*     */   }
/*     */   
/*     */   public IhmProjet(Principale frm, FormeInterneMCD formeMCD, FormeInterneMLD formeMLD, FormeInterneSQL formeSQL, FormeInterneXML formeXML) {
/*  70 */     this.formeMCD = formeMCD;
/*  71 */     this.formeMLD = formeMLD;
/*  72 */     this.formeSQL = formeSQL;
/*  73 */     this.formeXML = formeXML;
/*  74 */     this.frm = frm;
/*  75 */     this.mainProject = true;
/*     */   }
/*     */   
/*     */   public FormeInterneMCD getFormeMCD() {
/*  79 */     return this.formeMCD;
/*     */   }
/*     */   
/*     */   public FormeInterneMLD getFormeMLD() {
/*  83 */     return this.formeMLD;
/*     */   }
/*     */   
/*     */   public FormeInterneSQL getFormeSQL() {
/*  87 */     return this.formeSQL;
/*     */   }
/*     */   
/*     */   public FormeInterneXML getFormeXML() {
/*  91 */     return this.formeXML;
/*     */   }
/*     */   
/*     */   public boolean isMainProject() {
/*  95 */     return this.mainProject;
/*     */   }
/*     */   
/*     */   public void setFormeMCD(FormeInterneMCD formeMCD) {
/*  99 */     this.formeMCD = formeMCD;
/*     */   }
/*     */   
/*     */   public void setFormeMLD(FormeInterneMLD formeMLD) {
/* 103 */     this.formeMLD = formeMLD;
/*     */   }
/*     */   
/*     */   public void setFormeSQL(FormeInterneSQL formeSQL) {
/* 107 */     this.formeSQL = formeSQL;
/*     */   }
/*     */   
/*     */   public void setFormeXML(FormeInterneXML formeXML) {
/* 111 */     this.formeXML = formeXML;
/*     */   }
/*     */   
/*     */   public void setMainProject(boolean mainProject) {
/* 115 */     this.mainProject = mainProject;
/*     */   }
/*     */   
/*     */   private String getNomMCD(String name) {
/* 119 */     if (name == null) return "Nouveau MCD_" + this.num;
/* 120 */     if (name.trim().length() == 0) { return "Nouveau MCD_" + this.num;
/*     */     }
/* 122 */     if (name.indexOf(File.separator) < 0) return "Nouveau MCD_" + this.num;
/* 123 */     while (name.indexOf(File.separator) >= 0) {
/* 124 */       name = name.substring(name.indexOf(File.separator) + 1, name.length());
/*     */     }
/* 126 */     return name;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 131 */     if (getFormeMCD().isModifier()) return getNomMCD(getFormeMCD().getNomFichier() + "*");
/* 132 */     return getNomMCD(getFormeMCD().getNomFichier());
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmProjet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */