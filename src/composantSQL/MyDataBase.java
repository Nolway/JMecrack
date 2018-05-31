/*     */ package composantSQL;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import Output.SQLOutil;
/*     */ import ihm.Principale;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyDataBase
/*     */ {
/*     */   private String name;
/*     */   private String typeSQL;
/*     */   private Connection connection;
/*     */   private DatabaseMetaData dmd;
/*     */   private ArrayList<Table> tableList;
/*     */   private Principale frm;
/*     */   
/*     */   public MyDataBase(Principale frm, String name)
/*     */   {
/*  33 */     this.name = name;
/*  34 */     this.tableList = new ArrayList();
/*  35 */     this.frm = frm;
/*     */   }
/*     */   
/*     */   public MyDataBase(String name) {
/*  39 */     this.name = name;
/*  40 */     this.tableList = new ArrayList();
/*  41 */     this.frm = null;
/*     */   }
/*     */   
/*     */   public ArrayList<Table> getTableList() {
/*  45 */     return this.tableList;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  49 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setTableList(ArrayList<Table> tableList) {
/*  53 */     this.tableList = tableList;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  57 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Connection getConnection() {
/*  61 */     return this.connection;
/*     */   }
/*     */   
/*     */   public Principale getFrm() {
/*  65 */     return this.frm;
/*     */   }
/*     */   
/*     */   public DatabaseMetaData getDmd() {
/*  69 */     return this.dmd;
/*     */   }
/*     */   
/*     */   public String getTypeSQL() {
/*  73 */     return this.typeSQL;
/*     */   }
/*     */   
/*     */   public void setConnection(Connection connection) {
/*  77 */     this.connection = connection;
/*  78 */     if (this.connection != null) {
/*     */       try {
/*  80 */         this.dmd = this.connection.getMetaData();
/*     */       } catch (SQLException ex) {
/*  82 */         Logger.getLogger(MyDataBase.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void setFrm(Principale frm) {
/*  88 */     this.frm = frm;
/*     */   }
/*     */   
/*     */   public void addTable(Table tab) {
/*  92 */     this.tableList.add(tab);
/*     */   }
/*     */   
/*     */   public void removeTable(Table tab) {
/*  96 */     this.tableList.remove(tab);
/*     */   }
/*     */   
/*     */   private boolean estNull(String nul) {
/* 100 */     if (nul.trim().toUpperCase().equals("NO")) return false;
/* 101 */     return true;
/*     */   }
/*     */   
/*     */   public void setDmd(DatabaseMetaData dmd) {
/* 105 */     this.dmd = dmd;
/*     */   }
/*     */   
/*     */   public void setTypeSQL(String typeSQL) {
/* 109 */     this.typeSQL = typeSQL;
/*     */   }
/*     */   
/*     */   public void getListeTable() {
/* 113 */     ArrayList<Table> liste = new ArrayList();
/*     */     try
/*     */     {
/* 116 */       ResultSet tables = this.dmd.getTables(this.connection.getCatalog(), null, "%", null);
/* 117 */       while (tables.next()) {
/* 118 */         String NomTable = tables.getString("TABLE_NAME");
/* 119 */         String typeTable = tables.getString("TABLE_TYPE");
/* 120 */         if ((typeTable != null) && 
/* 121 */           (typeTable.toUpperCase().equals("TABLE"))) {
/* 122 */           liste.add(new Table(NomTable, tables.getString("REMARKS")));
/*     */         }
/*     */       }
/*     */       
/* 126 */       this.tableList = liste;
/*     */     }
/*     */     catch (SQLException ex) {}
/*     */   }
/*     */   
/*     */ 
/*     */   public void getListeAttribut(Table tab)
/*     */   {
/*     */     try
/*     */     {
/* 136 */       String nomTable = tab.getName();
/* 137 */       ResultSet resultat = this.dmd.getColumns(this.connection.getCatalog(), null, nomTable, "%");
/* 138 */       while (resultat.next()) {
/* 139 */         boolean b = false;
/* 140 */         if (this.typeSQL.equals(SQLOutil.SQLITE)) { b = false;
/* 141 */         } else if (this.typeSQL.equals(SQLOutil.HSQLDB)) {
/* 142 */           b = false;
/*     */         } else
/* 144 */           b = resultat.getBoolean("IS_AUTOINCREMENT");
/* 145 */         int longDecim = resultat.getInt("DECIMAL_DIGITS");
/*     */         
/* 147 */         Column col = new Column(resultat.getString("COLUMN_NAME"), resultat.getString("TYPE_NAME"), resultat.getInt("COLUMN_SIZE"), longDecim, "", resultat.getBoolean("NULLABLE"), resultat.getString("REMARKS"), b);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 155 */         tab.getColumnList().add(col);
/*     */       }
/*     */     } catch (SQLException ex) {
/* 158 */       Logger.getLogger(MyDataBase.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private void getIndexTable(Table tab)
/*     */   {
/*     */     try
/*     */     {
/* 166 */       ResultSet resultatA = this.dmd.getIndexInfo(this.connection.getCatalog(), null, tab.getName(), false, false);
/* 167 */       while (resultatA.next()) {
/* 168 */         Column cl = getColonne(tab, resultatA.getString("COLUMN_NAME"));
/* 169 */         if (cl != null) {
/* 170 */           if (cl.getName().equals(resultatA.getString("INDEX_NAME"))) {
/* 171 */             cl.setIndex(Parametres.Index);
/*     */           }
/* 173 */           if (resultatA.getBoolean("NON_UNIQUE")) {
/* 174 */             cl.setIndex(Parametres.Unique);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (SQLException ex) {
/* 180 */       Logger.getLogger(MyDataBase.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   public void getListeAttributFrKey(Table tab)
/*     */   {
/*     */     try
/*     */     {
/* 188 */       String nomTable = tab.getName();
/* 189 */       ResultSet lesClefs; if (this.typeSQL.equals(SQLOutil.SQLPOSTGRE)) lesClefs = this.dmd.getImportedKeys(null, "", nomTable); else {
/* 190 */         lesClefs = this.dmd.getImportedKeys(null, this.dmd.getUserName(), nomTable);
/*     */       }
/* 192 */       if (lesClefs != null) {
/* 193 */         while (lesClefs.next()) {
/* 194 */           Column cl = getColonne(getTable(nomTable), lesClefs.getString("FKCOLUMN_NAME"));
/* 195 */           cl.setTableFrKy(lesClefs.getString("PKTABLE_NAME"), lesClefs.getString("PKCOLUMN_NAME"));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (SQLException ex)
/*     */     {
/* 201 */       Logger.getLogger(MyDataBase.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   public void getListeAttributKey(Table tab)
/*     */   {
/*     */     try
/*     */     {
/* 209 */       String nomTable = tab.getName();
/* 210 */       ResultSet lesClefs = this.dmd.getPrimaryKeys(this.connection.getCatalog(), null, nomTable);
/* 211 */       if (lesClefs != null) {
/* 212 */         while (lesClefs.next()) {
/* 213 */           Column cl = getColonne(getTable(nomTable), lesClefs.getString("COLUMN_NAME"));
/* 214 */           cl.setKey(Parametres.Cle);
/*     */         }
/*     */       }
/*     */     } catch (SQLException ex) {
/* 218 */       Logger.getLogger(MyDataBase.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   public void remplirTableAttribut()
/*     */   {
/* 224 */     for (int i = 0; i < this.tableList.size(); i++) {
/* 225 */       getListeAttribut((Table)this.tableList.get(i));
/* 226 */       getListeAttributKey((Table)this.tableList.get(i));
/* 227 */       getListeAttributFrKey((Table)this.tableList.get(i));
/* 228 */       getIndexTable((Table)this.tableList.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   private Column getColonne(Table tab, String col) {
/* 233 */     if (tab == null) return null;
/* 234 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/* 235 */       if (((Column)tab.getColumnList().get(i)).getName().trim().toUpperCase().equals(col.trim().toUpperCase()))
/* 236 */         return (Column)tab.getColumnList().get(i);
/*     */     }
/* 238 */     return null;
/*     */   }
/*     */   
/*     */   private Table getTable(String tab) {
/* 242 */     for (int i = 0; i < this.tableList.size(); i++) {
/* 243 */       if (((Table)this.tableList.get(i)).getName().trim().toUpperCase().equals(tab.trim().toUpperCase()))
/* 244 */         return (Table)this.tableList.get(i);
/*     */     }
/* 246 */     return null;
/*     */   }
/*     */   
/*     */   public void afficherTable() {
/* 250 */     for (int i = 0; i < this.tableList.size(); i++) {
/* 251 */       ((Table)this.tableList.get(i)).afficherTable();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\composantSQL\MyDataBase.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */