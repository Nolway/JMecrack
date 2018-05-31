/*     */ package formes2;
/*     */ 
/*     */ import Merise.Attribut;
/*     */ import Merise2.Attribut2;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ProprieteEntiteTableModel
/*     */   extends AbstractTableModel
/*     */ {
/*  21 */   private String[] columnNames = { "Num", "Nom", "Code", "type", "taille", "decimal", "Contrainte", "Null", "Afficher" };
/*  22 */   private ArrayList<Attribut> listeAttribut = new ArrayList();
/*     */   JTable jtable;
/*     */   boolean isMCD;
/*     */   
/*     */   public ProprieteEntiteTableModel(List<Attribut> listAtt, boolean isMCD) {
/*  27 */     this.listeAttribut.addAll(listAtt);
/*  28 */     this.isMCD = isMCD;
/*     */   }
/*     */   
/*     */   public int getColumnCount()
/*     */   {
/*  33 */     return this.columnNames.length;
/*     */   }
/*     */   
/*     */   public String getColumnName(int column)
/*     */   {
/*  38 */     return this.columnNames[column];
/*     */   }
/*     */   
/*     */ 
/*     */   public Class getColumnClass(int column)
/*     */   {
/*  44 */     if (column == 0) return JButton.class;
/*  45 */     if (column == 7) return Boolean.class;
/*  46 */     if (column == 8) { return Boolean.class;
/*     */     }
/*  48 */     return Object.class;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getRowCount()
/*     */   {
/*  54 */     return this.listeAttribut.size();
/*     */   }
/*     */   
/*     */   public void setValueAt(Object value, int rowIndex, int columnIndex)
/*     */   {
/*  59 */     Attribut2 attribut = (Attribut2)this.listeAttribut.get(rowIndex);
/*     */     
/*  61 */     switch (columnIndex)
/*     */     {
/*     */     case 0: 
/*     */       break;
/*     */     
/*     */     case 1: 
/*  67 */       attribut.setNom((String)value);
/*  68 */       if ((attribut.getNom().trim().length() > 0) && 
/*  69 */         (attribut.getCode().trim().length() == 0)) {
/*  70 */         attribut.setCode(attribut.getNom().trim().toUpperCase());
/*     */       }
/*     */       
/*     */       break;
/*     */     case 2: 
/*  75 */       attribut.setCode(((String)value).trim().toUpperCase());
/*  76 */       if ((attribut.getNom().trim().length() > 0) && 
/*  77 */         (attribut.getCode().trim().length() == 0)) {
/*  78 */         attribut.setCode(attribut.getNom().toUpperCase());
/*     */       }
/*     */       
/*     */       break;
/*     */     case 3: 
/*  83 */       attribut.setType((String)value);
/*  84 */       if ((attribut.getType().trim().toUpperCase().equals("VARCHAR")) && 
/*  85 */         (attribut.getLongueur() == -1)) {
/*  86 */         attribut.setLongueur(FormeEntite2.longVarchar);
/*     */       }
/*  88 */       if ((attribut.getType().trim().toUpperCase().equals("CHAR")) && 
/*  89 */         (attribut.getLongueur() == -1)) {
/*  90 */         attribut.setLongueur(FormeEntite2.longChar);
/*     */       }
/*     */       break;
/*     */     case 4: 
/*  94 */       if (value.toString().trim().equals("")) {
/*  95 */         attribut.setLongueur(-1);
/*     */       }
/*  97 */       else if (estEntier(value.toString())) {
/*  98 */         attribut.setLongueur(Integer.parseInt(value.toString()));
/*  99 */         FormeEntite2.longVarchar = attribut.getLongueur();
/*     */       } else {
/* 101 */         attribut.setLongueur(-1);
/*     */       }
/*     */       
/* 104 */       break;
/*     */     case 5: 
/* 106 */       if (value.toString().trim().equals("")) {
/* 107 */         attribut.setLongDecimale(-1);
/*     */       }
/* 109 */       else if (estEntier(value.toString())) {
/* 110 */         attribut.setLongDecimale(Integer.parseInt(value.toString()));
/* 111 */         FormeEntite2.longChar = attribut.getLongueur();
/*     */       } else {
/* 113 */         attribut.setLongDecimale(-1);
/*     */       }
/*     */       
/*     */ 
/* 117 */       break;
/*     */     case 6: 
/* 119 */       attribut.setKey(setKeyNew((String)value));
/*     */       
/* 121 */       break;
/*     */     case 7: 
/* 123 */       attribut.setNulle(((Boolean)value).booleanValue());
/* 124 */       break;
/*     */     case 8: 
/* 126 */       attribut.setAfficher(((Boolean)value).booleanValue());
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */   public Object getValueAt(int rowIndex, int columnIndex)
/*     */   {
/* 133 */     Object returnValue = null;
/* 134 */     Attribut2 attribut = (Attribut2)this.listeAttribut.get(rowIndex);
/*     */     
/* 136 */     switch (columnIndex) {
/*     */     case 0: 
/* 138 */       returnValue = Integer.valueOf(rowIndex);
/* 139 */       break;
/*     */     case 1: 
/* 141 */       returnValue = attribut.getNom();
/* 142 */       break;
/*     */     case 2: 
/* 144 */       returnValue = attribut.getCode();
/* 145 */       break;
/*     */     case 3: 
/* 147 */       returnValue = attribut.getType();
/* 148 */       break;
/*     */     case 4: 
/* 150 */       if (attribut.getLongueur() == -1)
/* 151 */         returnValue = ""; else
/* 152 */         returnValue = "" + attribut.getLongueur();
/* 153 */       break;
/*     */     case 5: 
/* 155 */       if (attribut.getLongDecimale() == -1)
/* 156 */         returnValue = ""; else {
/* 157 */         returnValue = "" + attribut.getLongDecimale();
/*     */       }
/* 159 */       break;
/*     */     case 6: 
/* 161 */       returnValue = getKeyNew(attribut.getKey());
/* 162 */       break;
/*     */     case 7: 
/* 164 */       returnValue = Boolean.valueOf(attribut.isNulle());
/* 165 */       break;
/*     */     case 8: 
/* 167 */       returnValue = Boolean.valueOf(attribut.isAfficher());
/*     */     }
/*     */     
/*     */     
/* 171 */     return returnValue;
/*     */   }
/*     */   
/*     */   private String getKeyNew(String cl) {
/* 175 */     if (this.isMCD) {
/* 176 */       if (cl.equals("PRIMARY KEY")) return "IDENTIFIANT";
/* 177 */       if (cl.equals("UNIQUE")) return "IDENTIFIANT ALTERNATIF";
/* 178 */       if (cl.equals("INDEX")) return "INDEX";
/* 179 */       if (cl.equals("INDEX")) return "INDEX";
/*     */     } else {
/* 181 */       if (cl.equals("PRIMARY KEY")) return "CLE PRIMAIRE";
/* 182 */       if (cl.equals("UNIQUE")) return "CLE ALTERNATIVE";
/* 183 */       if (cl.equals("INDEX")) return "INDEX";
/* 184 */       if (cl.equals("FOREING KEY")) return "CLE ETRANGERE";
/*     */     }
/* 186 */     return "";
/*     */   }
/*     */   
/*     */   private String setKeyNew(String cl) {
/* 190 */     if (this.isMCD) {
/* 191 */       if (cl.equals("IDENTIFIANT")) return "PRIMARY KEY";
/* 192 */       if (cl.equals("IDENTIFIANT ALTERNATIF")) return "UNIQUE";
/* 193 */       if (cl.equals("INDEX")) return "INDEX";
/*     */     } else {
/* 195 */       if (cl.equals("CLE PRIMAIRE")) return "PRIMARY KEY";
/* 196 */       if (cl.equals("CLE ALTERNATIVE")) return "UNIQUE";
/* 197 */       if (cl.equals("INDEX")) return "INDEX";
/* 198 */       if (cl.equals("CLE ETRANGERE")) return "FOREING KEY";
/*     */     }
/* 200 */     return "";
/*     */   }
/*     */   
/*     */   private boolean estEntier(String ent)
/*     */   {
/* 205 */     if (ent.trim().length() == 0) return true;
/*     */     try {
/* 207 */       int nb = Integer.parseInt(ent);
/* 208 */       if (nb >= 0) return true;
/* 209 */       return false;
/*     */     } catch (Exception e) {}
/* 211 */     return false;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getListeAttribut()
/*     */   {
/* 216 */     return this.listeAttribut;
/*     */   }
/*     */   
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex)
/*     */   {
/* 221 */     return columnIndex >= 0;
/*     */   }
/*     */   
/*     */   public void addAttribut(Attribut2 att) {
/* 225 */     this.listeAttribut.add(att);
/* 226 */     fireTableRowsInserted(this.listeAttribut.size() - 1, this.listeAttribut.size() - 1);
/*     */   }
/*     */   
/*     */   public void removeAttribut(int index)
/*     */   {
/* 231 */     this.listeAttribut.remove(index);
/* 232 */     fireTableRowsDeleted(this.listeAttribut.size() - 1, this.listeAttribut.size() - 1);
/*     */   }
/*     */   
/*     */   public void setListeAttribut(List<Attribut> listAtt) {
/* 236 */     this.listeAttribut.clear();
/* 237 */     this.listeAttribut.addAll(listAtt);
/* 238 */     fireTableDataChanged();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\ProprieteEntiteTableModel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */