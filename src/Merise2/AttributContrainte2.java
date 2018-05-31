/*     */ package Merise2;
/*     */ 
/*     */ import Merise.Attribut;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AttributContrainte2
/*     */   implements Serializable
/*     */ {
/*     */   String name;
/*     */   String type;
/*     */   ArrayList<Attribut> listeAttribut;
/*     */   String clText;
/*     */   String clFond;
/*     */   String clText1;
/*     */   String clFond1;
/*     */   private ArrayList<Historique> historique;
/*     */   boolean augmentationPrefix;
/*     */   String augmentation;
/*     */   String commentaire;
/*     */   
/*     */   public AttributContrainte2(String name, String type)
/*     */   {
/*  31 */     this.name = name;
/*  32 */     this.type = type;
/*  33 */     this.listeAttribut = new ArrayList();
/*  34 */     this.clText = "";
/*  35 */     this.clFond = "";
/*  36 */     this.clText1 = "";
/*  37 */     this.clFond1 = " ";
/*  38 */     this.historique = new ArrayList();
/*  39 */     this.augmentation = "";
/*  40 */     this.augmentationPrefix = false;
/*     */   }
/*     */   
/*     */   public String getClFond() {
/*  44 */     return this.clFond;
/*     */   }
/*     */   
/*     */   public String getClFond1() {
/*  48 */     return this.clFond1;
/*     */   }
/*     */   
/*     */   public String getClText() {
/*  52 */     return this.clText;
/*     */   }
/*     */   
/*     */   public String getClText1() {
/*  56 */     return this.clText1;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/*  60 */     return this.historique;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getListeAttribut() {
/*  64 */     return this.listeAttribut;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  68 */     return this.name;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  72 */     return this.type;
/*     */   }
/*     */   
/*     */   public String getAugmentation() {
/*  76 */     return this.augmentation;
/*     */   }
/*     */   
/*     */   public boolean isAugmentationPrefix() {
/*  80 */     return this.augmentationPrefix;
/*     */   }
/*     */   
/*     */   public void setClFond(String clFond) {
/*  84 */     this.clFond = clFond;
/*     */   }
/*     */   
/*     */   public void setClFond1(String clFond1) {
/*  88 */     this.clFond1 = clFond1;
/*     */   }
/*     */   
/*     */   public void setClText(String clText) {
/*  92 */     this.clText = clText;
/*     */   }
/*     */   
/*     */   public void setClText1(String clText1) {
/*  96 */     this.clText1 = clText1;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/* 100 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public void setListeAttribut(ArrayList<Attribut> listeAttribut) {
/* 104 */     this.listeAttribut = listeAttribut;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 108 */     this.name = name;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 112 */     this.type = type;
/*     */   }
/*     */   
/*     */   public void setAugmentation(String augmentation) {
/* 116 */     this.augmentation = augmentation;
/*     */   }
/*     */   
/*     */   public void setAugmentationPrefix(boolean augmentationPrefix) {
/* 120 */     this.augmentationPrefix = augmentationPrefix;
/*     */   }
/*     */   
/*     */   public void addAttribut(Attribut att) {
/* 124 */     this.listeAttribut.add(att);
/*     */   }
/*     */   
/*     */   public void removeAttribut(Attribut att) {
/* 128 */     this.listeAttribut.remove(att);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise2\AttributContrainte2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */