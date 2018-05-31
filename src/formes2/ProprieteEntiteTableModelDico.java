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
/*     */ public class ProprieteEntiteTableModelDico
/*     */   extends AbstractTableModel
/*     */ {
/*  21 */   private String[] columnNames = { "Num", "Nom", "Code", "type", "taille", "decimal", "Utilisé" };
/*  22 */   private ArrayList<Attribut> listeAttribut = new ArrayList();
/*     */   JTable jtable;
/*     */   
/*     */   public ProprieteEntiteTableModelDico(List<Attribut> listEvent) {
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
/*  45 */     return Object.class;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getRowCount()
/*     */   {
/*  51 */     return this.listeAttribut.size();
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getListeAttribut() {
/*  55 */     return this.listeAttribut;
/*     */   }
/*     */   
/*     */   public void setValueAt(Object value, int rowIndex, int columnIndex)
/*     */   {
/*  60 */     Attribut2 attribut = (Attribut2)this.listeAttribut.get(rowIndex);
/*     */     
/*  62 */     switch (columnIndex)
/*     */     {
/*     */     case 0: 
/*     */       break;
/*     */     
/*     */     case 1: 
/*  68 */       attribut.setNom((String)value);
/*  69 */       if ((attribut.getNom().trim().length() > 0) && 
/*  70 */         (attribut.getCode().trim().length() == 0)) {
/*  71 */         attribut.setCode(attribut.getNom().trim().toUpperCase());
/*     */       }
/*     */       
/*     */       break;
/*     */     case 2: 
/*  76 */       attribut.setCode(((String)value).trim().toUpperCase());
/*  77 */       if ((attribut.getNom().trim().length() > 0) && 
/*  78 */         (attribut.getCode().trim().length() == 0)) {
/*  79 */         attribut.setCode(attribut.getNom().toUpperCase());
/*     */       }
/*     */       
/*     */       break;
/*     */     case 3: 
/*  84 */       attribut.setType((String)value);
/*  85 */       if ((attribut.getType().trim().toUpperCase().equals("VARCHAR")) && 
/*  86 */         (attribut.getLongueur() == -1)) {
/*  87 */         attribut.setLongueur(FormeEntite2.longVarchar);
/*     */       }
/*  89 */       if ((attribut.getType().trim().toUpperCase().equals("CHAR")) && 
/*  90 */         (attribut.getLongueur() == -1)) {
/*  91 */         attribut.setLongueur(FormeEntite2.longChar);
/*     */       }
/*     */       break;
/*     */     case 4: 
/*  95 */       if (value.toString().trim().equals("")) {
/*  96 */         attribut.setLongueur(-1);
/*     */       }
/*  98 */       else if (estEntier(value.toString())) {
/*  99 */         attribut.setLongueur(Integer.parseInt(value.toString()));
/* 100 */         FormeEntite2.longVarchar = attribut.getLongueur();
/*     */       } else {
/* 102 */         attribut.setLongueur(-1);
/*     */       }
/*     */       
/* 105 */       break;
/*     */     case 5: 
/* 107 */       if (value.toString().trim().equals("")) {
/* 108 */         attribut.setLongDecimale(-1);
/*     */       }
/* 110 */       else if (estEntier(value.toString())) {
/* 111 */         attribut.setLongDecimale(Integer.parseInt(value.toString()));
/* 112 */         FormeEntite2.longChar = attribut.getLongueur();
/*     */       } else {
/* 114 */         attribut.setLongDecimale(-1);
/*     */       }
/*     */       
/*     */ 
/* 118 */       break;
/*     */     case 6: 
/* 120 */       attribut.setUsed(((Boolean)value).booleanValue());
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Object getValueAt(int rowIndex, int columnIndex)
/*     */   {
/* 129 */     Object returnValue = null;
/* 130 */     Attribut2 attribut = (Attribut2)this.listeAttribut.get(rowIndex);
/*     */     
/* 132 */     switch (columnIndex) {
/*     */     case 0: 
/* 134 */       returnValue = Integer.valueOf(rowIndex);
/* 135 */       break;
/*     */     case 1: 
/* 137 */       returnValue = attribut.getNom();
/* 138 */       break;
/*     */     case 2: 
/* 140 */       returnValue = attribut.getCode();
/* 141 */       break;
/*     */     case 3: 
/* 143 */       returnValue = attribut.getType();
/* 144 */       break;
/*     */     case 4: 
/* 146 */       if (attribut.getLongueur() == -1)
/* 147 */         returnValue = ""; else
/* 148 */         returnValue = "" + attribut.getLongueur();
/* 149 */       break;
/*     */     case 5: 
/* 151 */       if (attribut.getLongDecimale() == -1)
/* 152 */         returnValue = ""; else {
/* 153 */         returnValue = "" + attribut.getLongDecimale();
/*     */       }
/* 155 */       break;
/*     */     
/*     */     case 6: 
/* 158 */       returnValue = Boolean.valueOf(attribut.isUsed());
/*     */     }
/*     */     
/*     */     
/* 162 */     return returnValue;
/*     */   }
/*     */   
/*     */   private boolean estEntier(String ent) {
/* 166 */     if (ent.trim().length() == 0) return true;
/*     */     try {
/* 168 */       int nb = Integer.parseInt(ent);
/* 169 */       if (nb >= 0) return true;
/* 170 */       return false;
/*     */     } catch (Exception e) {}
/* 172 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isCellEditable(int rowIndex, int columnIndex)
/*     */   {
/* 179 */     return columnIndex >= 0;
/*     */   }
/*     */   
/*     */   public void addAttribut(Attribut2 att) {
/* 183 */     this.listeAttribut.add(att);
/* 184 */     fireTableRowsInserted(this.listeAttribut.size() - 1, this.listeAttribut.size() - 1);
/*     */   }
/*     */   
/*     */   public void removeAttribut(int index)
/*     */   {
/* 189 */     this.listeAttribut.remove(index);
/* 190 */     fireTableRowsDeleted(this.listeAttribut.size() - 1, this.listeAttribut.size() - 1);
/*     */   }
/*     */   
/*     */   public void setListeAttribut(List<Attribut> listAtt) {
/* 194 */     this.listeAttribut.clear();
/* 195 */     this.listeAttribut.addAll(listAtt);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\ProprieteEntiteTableModelDico.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */