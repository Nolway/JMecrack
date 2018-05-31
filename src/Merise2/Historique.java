/*     */ package Merise2;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Historique
/*     */   implements Serializable
/*     */ {
/*     */   public static final String MODIFICATION = "MODIFICATION";
/*     */   public static final String CREATION = "CREATION";
/*     */   public static final String COPIER = "COPIE";
/*     */   private String action;
/*     */   private String developpeur;
/*     */   private String date;
/*     */   private String description;
/*     */   private String commentaire;
/*     */   private String version;
/*     */   private String developpeurService;
/*     */   private String developpeurEquipe;
/*     */   private String developpeurGroupe;
/*     */   private String developpeurDepartement;
/*     */   private String developpeurEntreprise;
/*     */   
/*     */   public Historique(String action, String developpeur)
/*     */   {
/*  34 */     this.action = action;
/*  35 */     this.developpeur = developpeur;
/*  36 */     this.description = "";
/*  37 */     this.commentaire = "";
/*  38 */     this.version = Parametres.version;
/*  39 */     this.date = Setting.getDateJour();
/*  40 */     this.developpeurService = "";
/*  41 */     this.developpeurEquipe = "";
/*  42 */     this.developpeurGroupe = "";
/*  43 */     this.developpeurDepartement = "";
/*  44 */     this.developpeurEntreprise = "";
/*     */   }
/*     */   
/*     */   public String getAction() {
/*  48 */     return this.action;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/*  52 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public String getDate() {
/*  56 */     return this.date;
/*     */   }
/*     */   
/*     */   public String getDeveloppeur() {
/*  60 */     return this.developpeur;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  64 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setAction(String action) {
/*  68 */     this.action = action;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/*  72 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public void setDate(String date) {
/*  76 */     this.date = date;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  80 */     this.description = description;
/*     */   }
/*     */   
/*     */   public void setDeveloppeur(String developpeur) {
/*  84 */     this.developpeur = developpeur;
/*     */   }
/*     */   
/*     */   public static Historique getHistoriqueModification() {
/*  88 */     Historique h = new Historique("MODIFICATION", Setting.developpeur);
/*  89 */     return h;
/*     */   }
/*     */   
/*     */   public static Historique getHistoriqueCopie() {
/*  93 */     Historique h = new Historique("COPIE", Setting.developpeur);
/*  94 */     return h;
/*     */   }
/*     */   
/*     */   public static Historique getHistoriqueCreation() {
/*  98 */     Historique h = new Historique("CREATION", Setting.developpeur);
/*  99 */     return h;
/*     */   }
/*     */   
/*     */   public String getHistoiqueString() {
/* 103 */     return getDate() + "\t" + getAction() + "\t\t" + getDeveloppeur() + "\t version : " + getVersion() + "\n";
/*     */   }
/*     */   
/*     */   public String getVersion() {
/* 107 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setVersion(String version) {
/* 111 */     this.version = version;
/*     */   }
/*     */   
/*     */   public String getDeveloppeurDepartement() {
/* 115 */     return this.developpeurDepartement;
/*     */   }
/*     */   
/*     */   public String getDeveloppeurEntreprise() {
/* 119 */     return this.developpeurEntreprise;
/*     */   }
/*     */   
/*     */   public String getDeveloppeurEquipe() {
/* 123 */     return this.developpeurEquipe;
/*     */   }
/*     */   
/*     */   public String getDeveloppeurGroupe() {
/* 127 */     return this.developpeurGroupe;
/*     */   }
/*     */   
/*     */   public String getDeveloppeurService() {
/* 131 */     return this.developpeurService;
/*     */   }
/*     */   
/*     */   public void setDeveloppeurDepartement(String developpeurDepartement) {
/* 135 */     this.developpeurDepartement = developpeurDepartement;
/*     */   }
/*     */   
/*     */   public void setDeveloppeurEntreprise(String developpeurEntreprise) {
/* 139 */     this.developpeurEntreprise = developpeurEntreprise;
/*     */   }
/*     */   
/*     */   public void setDeveloppeurEquipe(String developpeurEquipe) {
/* 143 */     this.developpeurEquipe = developpeurEquipe;
/*     */   }
/*     */   
/*     */   public void setDeveloppeurGroupe(String developpeurGroupe) {
/* 147 */     this.developpeurGroupe = developpeurGroupe;
/*     */   }
/*     */   
/*     */   public void setDeveloppeurService(String developpeurService) {
/* 151 */     this.developpeurService = developpeurService;
/*     */   }
/*     */   
/*     */   public Historique copier() {
/* 155 */     Historique his = new Historique(this.action, this.developpeur);
/* 156 */     his.setAction(getAction());
/* 157 */     his.setDeveloppeur(getDeveloppeur());
/* 158 */     his.setDate(getDate());
/* 159 */     his.setDescription(getDescription());
/* 160 */     his.setCommentaire(getCommentaire());
/* 161 */     his.setVersion(getVersion());
/* 162 */     return his;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise2\Historique.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */