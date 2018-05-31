/*     */ package Merise;
/*     */ 
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
/*     */ public class Domaine
/*     */   implements Serializable
/*     */ {
/*     */   private String nom;
/*     */   private ArrayList<String> listeValeurs;
/*     */   private String type;
/*     */   private String valMin;
/*     */   private String valMax;
/*     */   private String val;
/*     */   private String commentaire;
/*     */   
/*     */   public Domaine(String nom)
/*     */   {
/*  26 */     this.nom = nom;
/*  27 */     this.listeValeurs = new ArrayList();
/*  28 */     this.type = "";
/*  29 */     this.val = "";
/*  30 */     this.valMax = "";
/*  31 */     this.valMin = "";
/*  32 */     this.commentaire = "";
/*     */   }
/*     */   
/*     */   public ArrayList<String> getListeValeurs() {
/*  36 */     return this.listeValeurs;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  40 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setListeValeurs(ArrayList<String> listeValeurs) {
/*  44 */     this.listeValeurs = listeValeurs;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  48 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public Domaine copierDomaine() {
/*  52 */     Domaine d = new Domaine(getNom());
/*  53 */     for (int i = 0; i < getListeValeurs().size(); i++) {
/*  54 */       d.getListeValeurs().add(((String)getListeValeurs().get(i)).toString());
/*     */     }
/*  56 */     d.setType(this.type);
/*  57 */     d.setVal(this.val);
/*  58 */     d.setValMax(this.valMax);
/*  59 */     d.setValMin(this.valMin);
/*  60 */     d.setCommentaire(this.commentaire);
/*  61 */     return d;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/*  65 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  69 */     return this.type;
/*     */   }
/*     */   
/*     */   public String getVal() {
/*  73 */     return this.val;
/*     */   }
/*     */   
/*     */   public String getValMax() {
/*  77 */     return this.valMax;
/*     */   }
/*     */   
/*     */   public String getValMin() {
/*  81 */     return this.valMin;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/*  85 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  89 */     this.type = type;
/*     */   }
/*     */   
/*     */   public void setVal(String val) {
/*  93 */     this.val = val;
/*     */   }
/*     */   
/*     */   public void setValMax(String valMax) {
/*  97 */     this.valMax = valMax;
/*     */   }
/*     */   
/*     */   public void setValMin(String valMin) {
/* 101 */     this.valMin = valMin;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 107 */     return this.nom;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise\Domaine.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */