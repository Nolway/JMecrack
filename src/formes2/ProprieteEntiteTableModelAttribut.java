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
/*     */ public class ProprieteEntiteTableModelAttribut
/*     */   extends AbstractTableModel
/*     */ {
/*  21 */   private String[] columnNames = { "Num", "Nom", "Code", "type", "taille", "decimal", "Null" };
/*  22 */   private ArrayList<Attribut> listeAttribut = new ArrayList();
/*     */   JTable jtable;
/*     */   
/*     */   public ProprieteEntiteTableModelAttribut(List<Attribut> listEvent) {
/*  26 */     this.listeAttribut.addAll(listEvent);
/*     */   }
/*     */   
/*     */   public int getColumnCount()
/*     */   {
/*  31 */     return this.columnNames.length;
/*     */   }
/*     */   
/*     */   public String getColumnName(int column)
/*     */   {
/*  36 */     return this.columnNames[column];
/*     */   }
/*     */   
/*     */ 
/*     */   public Class getColumnClass(int column)
/*     */   {
/*  42 */     if (column == 0) return JButton.class;
/*  43 */     if (column == 6) { return Boolean.class;
/*     */     }
/*     */     
/*  46 */     return Object.class;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getRowCount()
/*     */   {
/*  52 */     return this.listeAttribut.size();
/*     */   }
/*     */   
/*     */   public void setValueAt(Object value, int rowIndex, int columnIndex)
/*     */   {
/*  57 */     Attribut2 attribut = (Attribut2)this.listeAttribut.get(rowIndex);
/*     */     
/*  59 */     switch (columnIndex)
/*     */     {
/*     */     case 0: 
/*     */       break;
/*     */     
/*     */     case 1: 
/*  65 */       attribut.setNom((String)value);
/*  66 */       if ((attribut.getNom().trim().length() > 0) && 
/*  67 */         (attribut.getCode().trim().length() == 0)) {
/*  68 */         attribut.setCode(attribut.getNom().trim().toUpperCase());
/*     */       }
/*     */       
/*     */       break;
/*     */     case 2: 
/*  73 */       attribut.setCode(((String)value).trim().toUpperCase());
/*  74 */       if ((attribut.getNom().trim().length() > 0) && 
/*  75 */         (attribut.getCode().trim().length() == 0)) {
/*  76 */         attribut.setCode(attribut.getNom().toUpperCase());
/*     */       }
/*     */       
/*     */       break;
/*     */     case 3: 
/*  81 */       attribut.setType((String)value);
/*  82 */       if ((attribut.getType().trim().toUpperCase().equals("VARCHAR")) && 
/*  83 */         (attribut.getLongueur() == -1)) {
/*  84 */         attribut.setLongueur(FormeEntite2.longVarchar);
/*     */       }
/*  86 */       if ((attribut.getType().trim().toUpperCase().equals("CHAR")) && 
/*  87 */         (attribut.getLongueur() == -1)) {
/*  88 */         attribut.setLongueur(FormeEntite2.longChar);
/*     */       }
/*     */       break;
/*     */     case 4: 
/*  92 */       if (value.toString().trim().equals("")) {
/*  93 */         attribut.setLongueur(-1);
/*     */       }
/*  95 */       else if (estEntier(value.toString())) {
/*  96 */         attribut.setLongueur(Integer.parseInt(value.toString()));
/*  97 */         FormeEntite2.longVarchar = attribut.getLongueur();
/*     */       } else {
/*  99 */         attribut.setLongueur(-1);
/*     */       }
/*     */       
/* 102 */       break;
/*     */     case 5: 
/* 104 */       if (value.toString().trim().equals("")) {
/* 105 */         attribut.setLongDecimale(-1);
/*     */       }
/* 107 */       else if (estEntier(value.toString())) {
/* 108 */         attribut.setLongDecimale(Integer.parseInt(value.toString()));
/* 109 */         FormeEntite2.longChar = attribut.getLongueur();
/*     */       } else {
/* 111 */         attribut.setLongDecimale(-1);
/*     */       }
/*     */       
/*     */ 
/* 115 */       break;
/*     */     
/*     */     case 6: 
/* 118 */       attribut.setNulle(((Boolean)value).booleanValue());
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Object getValueAt(int rowIndex, int columnIndex)
/*     */   {
/* 128 */     Object returnValue = null;
/* 129 */     Attribut2 attribut = (Attribut2)this.listeAttribut.get(rowIndex);
/*     */     
/* 131 */     switch (columnIndex) {
/*     */     case 0: 
/* 133 */       returnValue = Integer.valueOf(rowIndex);
/* 134 */       break;
/*     */     case 1: 
/* 136 */       returnValue = attribut.getNom();
/* 137 */       break;
/*     */     case 2: 
/* 139 */       returnValue = attribut.getCode();
/* 140 */       break;
/*     */     case 3: 
/* 142 */       returnValue = attribut.getType();
/* 143 */       break;
/*     */     case 4: 
/* 145 */       if (attribut.getLongueur() == -1)
/* 146 */         returnValue = ""; else
/* 147 */         returnValue = "" + attribut.getLongueur();
/* 148 */       break;
/*     */     case 5: 
/* 150 */       if (attribut.getLongDecimale() == -1)
/* 151 */         returnValue = ""; else {
/* 152 */         returnValue = "" + attribut.getLongDecimale();
/*     */       }
/* 154 */       break;
/*     */     
/*     */     case 6: 
/* 157 */       returnValue = Boolean.valueOf(attribut.isNulle());
/*     */     }
/*     */     
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 164 */     return returnValue;
/*     */   }
/*     */   
/*     */   private boolean estEntier(String ent) {
/* 168 */     if (ent.trim().length() == 0) return true;
/*     */     try {
/* 170 */       int nb = Integer.parseInt(ent);
/* 171 */       if (nb >= 0) return true;
/* 172 */       return false;
/*     */     } catch (Exception e) {}
/* 174 */     return false;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getListeAttribut()
/*     */   {
/* 179 */     return this.listeAttribut;
/*     */   }
/*     */   
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex)
/*     */   {
/* 184 */     return columnIndex >= 0;
/*     */   }
/*     */   
/*     */   public void addAttribut(Attribut2 att) {
/* 188 */     this.listeAttribut.add(att);
/* 189 */     fireTableRowsInserted(this.listeAttribut.size() - 1, this.listeAttribut.size() - 1);
/*     */   }
/*     */   
/*     */   public void removeAttribut(int index)
/*     */   {
/* 194 */     this.listeAttribut.remove(index);
/* 195 */     fireTableRowsDeleted(this.listeAttribut.size() - 1, this.listeAttribut.size() - 1);
/*     */   }
/*     */   
/*     */   public void setListeAttribut(List<Attribut> listAtt) {
/* 199 */     this.listeAttribut.clear();
/* 200 */     this.listeAttribut.addAll(listAtt);
/* 201 */     fireTableDataChanged();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\ProprieteEntiteTableModelAttribut.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */