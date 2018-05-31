/*     */ package mythread;
/*     */ 
/*     */ import MyExplorer.ConsolePane;
/*     */ import MySqlEditor.JTextEditorPan;
/*     */ import MySqlEditor.MySqlTextPane;
/*     */ import Outil.Connexion;
/*     */ import Output.SQLDerby;
/*     */ import Output.SQLFirebird;
/*     */ import Output.SQLMySQL;
/*     */ import Output.SQLOutil;
/*     */ import Output.SQLPostGre;
/*     */ import formes.FormeConstruction;
/*     */ import ihm.FormeInterneSQL;
/*     */ import ihm.Principale;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JCheckBoxMenuItem;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.SwingWorker;
/*     */ 
/*     */ public class ThreadScriptBDD extends SwingWorker
/*     */ {
/*     */   private Principale frm;
/*     */   private String typeSql;
/*     */   private ArrayList<String> listeTable;
/*     */   
/*     */   public ThreadScriptBDD(Principale frm)
/*     */   {
/*  33 */     this.frm = frm;
/*  34 */     this.listeTable = new ArrayList();
/*  35 */     this.typeSql = frm.getFormeSQL().getPanelsql().getTypeSql();
/*     */   }
/*     */   
/*     */   private void creerListeTable()
/*     */   {
/*  40 */     if (this.typeSql.equals(SQLOutil.SQLITE)) {
/*  41 */       this.listeTable = Output.SQLite.creerListeTable(this.frm.getFormeSQL().getPanelsql().getPane().getText());
/*     */     }
/*  43 */     if (this.typeSql.equals(SQLOutil.SQLMYSQL))
/*     */     {
/*  45 */       this.listeTable = SQLMySQL.creerListeTable(this.frm.getFormeSQL().getPanelsql().getPane().getText());
/*     */     }
/*  47 */     if (this.typeSql.equals(SQLOutil.SQLPOSTGRE)) {
/*  48 */       this.listeTable = SQLPostGre.creerListeTable(this.frm.getFormeSQL().getPanelsql().getPane().getText());
/*     */     }
/*  50 */     if (this.typeSql.equals(SQLOutil.SQLDERBY)) {
/*  51 */       this.listeTable = SQLDerby.creerListeTable(this.frm.getFormeSQL().getPanelsql().getPane().getText());
/*     */     }
/*     */     
/*  54 */     if (this.typeSql.equals(SQLOutil.SQLFIREBIRD)) {
/*  55 */       this.listeTable = SQLFirebird.creerListeTable(this.frm.getFormeSQL().getPanelsql().getPane().getText());
/*     */     }
/*     */     
/*  58 */     if (this.typeSql.equals(SQLOutil.SQLORACLE)) {
/*  59 */       this.listeTable = Output.SQLOracle.creerListeTable(this.frm.getFormeSQL().getPanelsql().getPane().getText());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void afficherLsiteTable()
/*     */   {
/*  66 */     for (int i = 0; i < this.listeTable.size(); i++) {
/*  67 */       System.out.println((String)this.listeTable.get(i));
/*  68 */       System.out.println("========================= i : " + i);
/*     */     }
/*     */   }
/*     */   
/*     */   private void voirConsole() {
/*  73 */     if (!this.frm.getjMIConsole().isSelected()) {
/*  74 */       this.frm.getjMIConsole().setSelected(true);
/*  75 */       this.frm.getConsole().setVisible(this.frm.getjMIConsole().isSelected());
/*  76 */       if (this.frm.getjMIConsole().isSelected()) {
/*  77 */         this.frm.getConsole().setSize(this.frm.getConsole().getWidth(), 20);
/*  78 */         this.frm.getSplitCon().setDividerLocation(this.frm.getHeight() - 200 - this.frm.getConsole().getHeight());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected Object doInBackground()
/*     */     throws Exception
/*     */   {
/*  87 */     double pas = 0.0D;
/*  88 */     boolean creation = true;
/*  89 */     creerListeTable();
/*  90 */     pas = this.listeTable.size() > 0 ? 100.0D / this.listeTable.size() : 100.0D;
/*  91 */     FormeConstruction frmCons = new FormeConstruction(this.frm, true);
/*  92 */     frmCons.setModal(false);
/*  93 */     frmCons.getjLabNom().setText("Création de la base de données");
/*     */     
/*  95 */     frmCons.setVisible(true);
/*  96 */     frmCons.getjProgBar().setValue(1);
/*  97 */     this.frm.getConsole().getRapport().setText("");
/*  98 */     for (int i = 0; i < this.listeTable.size(); i++) {
/*     */       try {
/* 100 */         Connexion.executerMAJ(this.frm.getFormeMCD().getConnexion(), (String)this.listeTable.get(i));
/*     */       } catch (Exception e) {
/* 102 */         creation = false;
/* 103 */         voirConsole();
/* 104 */         this.frm.getConsole().getRapport().setText(((String)this.listeTable.get(i)).trim() + "\n\n" + e.toString());
/* 105 */         JOptionPane.showMessageDialog(this.frm, "ERREUR : Erreur est survenue lors de l'execution du script  !! ");
/* 106 */         break;
/*     */       }
/* 108 */       frmCons.getjProgBar().setValue((int)(i * pas));
/*     */     }
/* 110 */     frmCons.getjProgBar().setValue(100);
/* 111 */     frmCons.dispose();
/* 112 */     if (creation) { JOptionPane.showMessageDialog(this.frm, " La création de la base de données est réussie :)  !! ");
/*     */     }
/* 114 */     return Integer.valueOf(1);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadScriptBDD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */