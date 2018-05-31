/*     */ package IhmMCD2;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmCardinalite
/*     */   implements Serializable
/*     */ {
/*     */   public Color clFond2;
/*     */   public Color clText2;
/*     */   public Font font;
/*     */   public String min;
/*     */   public String max;
/*     */   public String nom;
/*     */   public String Commentaire;
/*     */   public boolean relatif;
/*     */   public String aligner;
/*     */   private String stabilite;
/*     */   public int x;
/*     */   public int y;
/*     */   public int width;
/*     */   public int height;
/*     */   private String identifiant;
/*     */   
/*     */   public IhmCardinalite(String min, String max, String nom)
/*     */   {
/*  34 */     this.min = min;
/*  35 */     this.max = max;
/*  36 */     this.nom = nom;
/*  37 */     this.Commentaire = "";
/*  38 */     this.relatif = false;
/*  39 */     this.clFond2 = Color.WHITE;
/*  40 */     this.clText2 = Color.BLACK;
/*  41 */     this.x = 0;
/*  42 */     this.y = 0;
/*  43 */     this.width = 0;
/*  44 */     this.height = 0;
/*  45 */     this.stabilite = "";
/*  46 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */   public IhmCardinalite(String min, String max) {
/*  50 */     this.min = min;
/*  51 */     this.max = max;
/*  52 */     this.nom = (min + "," + max);
/*  53 */     this.Commentaire = "";
/*  54 */     this.relatif = false;
/*  55 */     this.clFond2 = Color.WHITE;
/*  56 */     this.clText2 = Color.BLACK;
/*  57 */     this.x = 0;
/*  58 */     this.y = 0;
/*  59 */     this.width = 0;
/*  60 */     this.height = 0;
/*  61 */     this.stabilite = "";
/*  62 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */   public IhmCardinalite(String card) {
/*  66 */     this.min = "1";
/*  67 */     this.max = "n";
/*  68 */     this.nom = card;
/*  69 */     this.Commentaire = "";
/*  70 */     this.relatif = false;
/*  71 */     this.clFond2 = Color.WHITE;
/*  72 */     this.clText2 = Color.BLACK;
/*  73 */     this.x = 0;
/*  74 */     this.y = 0;
/*  75 */     this.width = 0;
/*  76 */     this.height = 0;
/*  77 */     this.stabilite = "";
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/*  81 */     return this.Commentaire;
/*     */   }
/*     */   
/*     */   public String getAligner() {
/*  85 */     return this.aligner;
/*     */   }
/*     */   
/*     */   public Color getClFond2() {
/*  89 */     return this.clFond2;
/*     */   }
/*     */   
/*     */   public Color getClText2() {
/*  93 */     return this.clText2;
/*     */   }
/*     */   
/*     */   public Font getFont() {
/*  97 */     return this.font;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 101 */     return this.height;
/*     */   }
/*     */   
/*     */   public String getMax() {
/* 105 */     return this.max;
/*     */   }
/*     */   
/*     */   public String getMin() {
/* 109 */     return this.min;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 113 */     return this.nom;
/*     */   }
/*     */   
/*     */   public boolean isRelatif() {
/* 117 */     return this.relatif;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 121 */     return this.width;
/*     */   }
/*     */   
/*     */   public int getX() {
/* 125 */     return this.x;
/*     */   }
/*     */   
/*     */   public int getY() {
/* 129 */     return this.y;
/*     */   }
/*     */   
/*     */   public String getStabilite() {
/* 133 */     return this.stabilite;
/*     */   }
/*     */   
/*     */   public String getIdentifiant() {
/* 137 */     return this.identifiant;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String Commentaire) {
/* 141 */     this.Commentaire = Commentaire;
/*     */   }
/*     */   
/*     */   public void setAligner(String aligner) {
/* 145 */     this.aligner = aligner;
/*     */   }
/*     */   
/*     */   public void setClFond2(Color clFond2) {
/* 149 */     this.clFond2 = clFond2;
/*     */   }
/*     */   
/*     */   public void setClText2(Color clText2) {
/* 153 */     this.clText2 = clText2;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 157 */     this.font = font;
/*     */   }
/*     */   
/*     */   public void setHeight(int height) {
/* 161 */     this.height = height;
/*     */   }
/*     */   
/*     */   public void setMax(String max)
/*     */   {
/* 166 */     this.max = max;
/*     */   }
/*     */   
/*     */   public void setMin(String min) {
/* 170 */     this.min = min;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 174 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public void setRelatif(boolean relatif) {
/* 178 */     this.relatif = relatif;
/*     */   }
/*     */   
/*     */   public void setStabilite(String stabilite) {
/* 182 */     this.stabilite = stabilite;
/*     */   }
/*     */   
/*     */   public void setWidth(int width) {
/* 186 */     this.width = width;
/*     */   }
/*     */   
/*     */   public void setX(int x) {
/* 190 */     this.x = x;
/*     */   }
/*     */   
/*     */   public void setY(int y) {
/* 194 */     this.y = y;
/*     */   }
/*     */   
/*     */   public void setIdentifiant(String identifiant) {
/* 198 */     this.identifiant = identifiant;
/*     */   }
/*     */   
/*     */   public IhmCardinalite copier() {
/* 202 */     IhmCardinalite car = new IhmCardinalite(this.nom);
/* 203 */     car.setClFond2(getClFond2());
/* 204 */     car.setClText2(getClText2());
/* 205 */     car.setFont(getFont());
/* 206 */     car.setMin(getMin());
/* 207 */     car.setMax(getMax());
/* 208 */     car.setNom(getNom());
/* 209 */     car.setCommentaire(getCommentaire());
/* 210 */     car.setRelatif(isRelatif());
/* 211 */     car.setAligner(getAligner());
/* 212 */     car.setStabilite(getStabilite());
/* 213 */     car.setX(getX());
/* 214 */     car.setY(getY());
/* 215 */     car.setWidth(getWidth());
/* 216 */     car.setHeight(getHeight());
/* 217 */     return car;
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y) {
/* 221 */     if ((x >= getX()) && (y > getY()) && (x <= getX() + getWidth()) && (y <= getY() + getHeight())) return true;
/* 222 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmCardinalite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */