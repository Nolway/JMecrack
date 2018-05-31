/*     */ package composantSQL;
/*     */ 
/*     */ 
/*     */ public class Column
/*     */ {
/*     */   private String name;
/*     */   
/*     */   private String type;
/*     */   
/*     */   private int size;
/*     */   
/*     */   private int sizeDec;
/*     */   
/*     */   private String key;
/*     */   
/*     */   private String Frkey;
/*     */   
/*     */   private String index;
/*     */   private String tableFrKy;
/*     */   private boolean nul;
/*     */   private boolean autoInc;
/*     */   private String comment;
/*     */   
/*     */   public Column(String name, String type, int size, int sizeDec, String key, boolean nul, String comment, boolean autoInc)
/*     */   {
/*  26 */     this.name = name;
/*  27 */     this.type = type;
/*  28 */     this.size = size;
/*  29 */     this.sizeDec = sizeDec;
/*  30 */     this.key = key;
/*  31 */     this.Frkey = "";
/*  32 */     this.index = "";
/*  33 */     this.nul = nul;
/*  34 */     this.autoInc = autoInc;
/*  35 */     this.comment = comment;
/*  36 */     this.tableFrKy = "";
/*     */   }
/*     */   
/*     */   public Column(String name, String type, int size, boolean nul) {
/*  40 */     this.name = name;
/*  41 */     this.type = type;
/*  42 */     this.size = size;
/*  43 */     this.sizeDec = 0;
/*  44 */     this.key = "";
/*  45 */     this.nul = nul;
/*  46 */     this.comment = "";
/*  47 */     this.autoInc = false;
/*  48 */     this.tableFrKy = "";
/*     */   }
/*     */   
/*     */   public String getComment() {
/*  52 */     return this.comment;
/*     */   }
/*     */   
/*     */   public String getKey() {
/*  56 */     return this.key;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  60 */     return this.name;
/*     */   }
/*     */   
/*     */   public boolean isNull() {
/*  64 */     return this.nul;
/*     */   }
/*     */   
/*     */   public int getSize() {
/*  68 */     return this.size;
/*     */   }
/*     */   
/*     */   public int getSizeDec() {
/*  72 */     return this.sizeDec;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  76 */     return this.type;
/*     */   }
/*     */   
/*     */   public String getFrkey() {
/*  80 */     return this.Frkey;
/*     */   }
/*     */   
/*     */   public boolean isAutoInc() {
/*  84 */     return this.autoInc;
/*     */   }
/*     */   
/*     */   public String getIndex() {
/*  88 */     return this.index;
/*     */   }
/*     */   
/*     */   public String getTableFrKy() {
/*  92 */     return this.tableFrKy;
/*     */   }
/*     */   
/*     */   public void setComment(String comment) {
/*  96 */     this.comment = comment;
/*     */   }
/*     */   
/*     */   public void setKey(String key) {
/* 100 */     this.key = key;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 104 */     this.name = name;
/*     */   }
/*     */   
/*     */   public void setNull(boolean nul) {
/* 108 */     this.nul = nul;
/*     */   }
/*     */   
/*     */   public void setSize(int size) {
/* 112 */     this.size = size;
/*     */   }
/*     */   
/*     */   public void setSizeDec(int sizeDec) {
/* 116 */     this.sizeDec = sizeDec;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 120 */     this.type = type;
/*     */   }
/*     */   
/*     */   public void setFrkey(String Frkey) {
/* 124 */     this.Frkey = Frkey;
/*     */   }
/*     */   
/*     */   public void setAutoInc(boolean autoInc) {
/* 128 */     this.autoInc = autoInc;
/*     */   }
/*     */   
/*     */   public void setIndex(String index) {
/* 132 */     this.index = index;
/*     */   }
/*     */   
/*     */   public void setNul(boolean nul) {
/* 136 */     this.nul = nul;
/*     */   }
/*     */   
/*     */   public void setTableFrKy(String tableFrKy) {
/* 140 */     this.tableFrKy = tableFrKy;
/*     */   }
/*     */   
/*     */   public void setTableFrKy(String tableFrKy, String frkey) {
/* 144 */     this.tableFrKy = tableFrKy;
/* 145 */     this.Frkey = frkey;
/*     */   }
/*     */   
/*     */   public Column copier() {
/* 149 */     Column c = new Column(this.name, this.type, this.size, this.sizeDec, this.key, this.nul, this.comment, this.autoInc);
/* 150 */     c.setFrkey(this.Frkey);
/* 151 */     c.setTableFrKy(this.tableFrKy);
/* 152 */     c.setIndex(this.index);
/* 153 */     return c;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 158 */     String s = "nom : " + this.name + "\t" + "type : " + this.type + "\t" + "taille : " + this.size + "\t" + "cle : " + this.key + "\t" + "cleEtr : " + this.Frkey + "\t" + "EntEtr : " + this.tableFrKy + "\t";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 165 */     return s;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\composantSQL\Column.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */