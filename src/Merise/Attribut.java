/*     */ package Merise;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Attribut
/*     */   implements Serializable
/*     */ {
/*     */   private String nom;
/*     */   private String type;
/*     */   private int longueur;
/*     */   private int longDecimale;
/*     */   private String key;
/*     */   private boolean nulle;
/*     */   private String commentaire;
/*     */   private EntiteRelation entiteRelation;
/*     */   
/*     */   public Attribut(String nom, String type, int longueur, int longDecimale, String key, boolean nulle, String commentaire, EntiteRelation entiteRelation)
/*     */   {
/*  26 */     this.nom = nom;
/*  27 */     this.type = type;
/*  28 */     this.longueur = longueur;
/*  29 */     this.longDecimale = longDecimale;
/*  30 */     this.key = key;
/*  31 */     this.nulle = nulle;
/*  32 */     this.commentaire = commentaire;
/*  33 */     this.entiteRelation = entiteRelation;
/*     */   }
/*     */   
/*     */   public int getLongDecimale()
/*     */   {
/*  38 */     return this.longDecimale;
/*     */   }
/*     */   
/*     */   public int getLongueur() {
/*  42 */     return this.longueur;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  46 */     return this.nom;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/*  50 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public String getKey() {
/*  54 */     return this.key;
/*     */   }
/*     */   
/*     */   public boolean isNulle() {
/*  58 */     return this.nulle;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  62 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setKey(String key) {
/*  66 */     this.key = key;
/*     */   }
/*     */   
/*     */   public void setLongDecimale(int longDecimale) {
/*  70 */     this.longDecimale = longDecimale;
/*     */   }
/*     */   
/*     */   public void setLongueur(int longueur) {
/*  74 */     this.longueur = longueur;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  78 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public void setNulle(boolean nulle) {
/*  82 */     this.nulle = nulle;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  86 */     this.type = type;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/*  90 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public EntiteRelation getEntiteRelation() {
/*  94 */     return this.entiteRelation;
/*     */   }
/*     */   
/*     */   public void setEntiteRelation(EntiteRelation entiteRelation) {
/*  98 */     this.entiteRelation = entiteRelation;
/*     */   }
/*     */   
/*     */   public Attribut copier() {
/* 102 */     return new Attribut(getNom(), getType(), getLongueur(), getLongDecimale(), getKey(), isNulle(), getCommentaire(), getEntiteRelation());
/*     */   }
/*     */   
/*     */   public String getConversionToString() {
/* 106 */     String plus = "";
/* 107 */     if (getLongueur() > 0) plus = plus + " (" + getLongueur();
/* 108 */     if (getLongDecimale() > 0) plus = plus + "," + getLongDecimale();
/* 109 */     if (getLongueur() > 0) plus = plus + ")";
/* 110 */     return getNom() + "     " + getType() + plus;
/*     */   }
/*     */   
/*     */   public String getConversionToMLDR() {
/* 114 */     if (this.key.equals(Parametres.Cle)) return " #" + getNom();
/* 115 */     return getNom();
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 120 */     return this.nom + "  : " + this.type;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise\Attribut.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */