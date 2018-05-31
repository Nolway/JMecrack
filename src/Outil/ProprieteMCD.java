/*     */ package Outil;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ProprieteMCD
/*     */   implements Serializable
/*     */ {
/*     */   public String createur;
/*     */   public String dateCreation;
/*     */   public String dateDerniereUtil;
/*     */   public String developpeur;
/*     */   public String commentaire;
/*     */   public String historique;
/*     */   public String note;
/*     */   
/*     */   public ProprieteMCD()
/*     */   {
/*  36 */     this.developpeur = "";
/*  37 */     this.dateDerniereUtil = "";
/*  38 */     this.dateCreation = "";
/*  39 */     this.commentaire = "";
/*  40 */     this.historique = "";
/*  41 */     this.note = "<action><nommcd></nommcd><verouiller>False</verouiller><nbafficher></nbafficher></action><regle></regle>";
/*     */   }
/*     */   
/*     */   public ProprieteMCD(String Dev) {
/*  45 */     this.createur = Dev;
/*  46 */     this.developpeur = Dev;
/*  47 */     this.dateDerniereUtil = "";
/*  48 */     this.dateCreation = getDateJour();
/*  49 */     this.commentaire = "";
/*  50 */     this.historique = "";
/*  51 */     addHistorique(Setting.developpeur, "Création");
/*  52 */     this.note = "<action><nommcd></nommcd><verouiller>False</verouiller><nbafficher></nbafficher></action><regle></regle>";
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/*  56 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public String getDateCreation() {
/*  60 */     return this.dateCreation;
/*     */   }
/*     */   
/*     */   public String getDateDerniereUtilisation() {
/*  64 */     return this.dateDerniereUtil;
/*     */   }
/*     */   
/*     */   public String getDeveloppeur() {
/*  68 */     return this.developpeur;
/*     */   }
/*     */   
/*     */   public String getHistorique() {
/*  72 */     return this.historique;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/*  76 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public void setDateCreation(String dateCreation) {
/*  80 */     this.dateCreation = dateCreation;
/*     */   }
/*     */   
/*     */   public void setDateDerniereUtilisation(String dateDerniereUtil) {
/*  84 */     this.dateDerniereUtil = dateDerniereUtil;
/*     */   }
/*     */   
/*     */   public void setDeveloppeur(String developpeur) {
/*  88 */     this.developpeur = developpeur;
/*     */   }
/*     */   
/*     */   public void setHistorique(String historique) {
/*  92 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public void addHistorique(String dev, String action) {
/*  96 */     String s = "<H><Action>" + action + "</Action><Dev>" + dev + "</Dev> <Date>" + getDateJour() + "</Date></H>";
/*  97 */     if (this.historique.indexOf(s) < 0)
/*  98 */       this.historique += s;
/*     */   }
/*     */   
/*     */   public void setCreateur(String createur) {
/* 102 */     this.createur = createur;
/*     */   }
/*     */   
/*     */   public String getCreateur() {
/* 106 */     return this.createur;
/*     */   }
/*     */   
/*     */   public String getNote() {
/* 110 */     return this.note;
/*     */   }
/*     */   
/*     */   public void setNote(String note) {
/* 114 */     this.note = note;
/*     */   }
/*     */   
/*     */   public String getDateJour() {
/* 118 */     SimpleDateFormat sdfrancaise = new SimpleDateFormat("dd/MM/yyyy");
/* 119 */     Date now = new Date();
/* 120 */     return sdfrancaise.format(now);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Outil\ProprieteMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */