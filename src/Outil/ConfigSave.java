/*     */ package Outil;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class ConfigSave
/*     */   implements Serializable
/*     */ {
/*     */   private boolean isVariable;
/*     */   private boolean isOmbre;
/*     */   private boolean isDegradee;
/*     */   private String etatColor;
/*     */   private String clEntiteCadre;
/*     */   private String clEntiteFond;
/*     */   private String clEntiteText;
/*     */   private String clRelationCadre;
/*     */   private String clRelationFond;
/*     */   private String clRelationText;
/*     */   private String clCIFCadre;
/*     */   private String clCIFFond;
/*     */   private String clCIFText;
/*     */   private String clContrainteCadre;
/*     */   private String clContrainteFond;
/*     */   private String clContrainteText;
/*     */   private String clLien;
/*     */   private String clLienCnt;
/*     */   private String clString;
/*     */   
/*     */   public ConfigSave(boolean isVariable, boolean isOmbre, boolean isDegradee, String etatColor, String clEntiteCadre, String clEntiteFond, String clEntiteText, String clRelationCadre, String clRelationFond, String clRelationText, String clCIFCadre, String clCIFFond, String clCIFText, String clContrainteCadre, String clContrainteFond, String clContrainteText, String clLien, String clLienCnt, String clString)
/*     */   {
/*  44 */     this.isVariable = isVariable;
/*  45 */     this.isOmbre = isOmbre;
/*  46 */     this.isDegradee = isDegradee;
/*  47 */     this.etatColor = etatColor;
/*  48 */     this.clEntiteCadre = clEntiteCadre;
/*  49 */     this.clEntiteFond = clEntiteFond;
/*  50 */     this.clEntiteText = clEntiteText;
/*  51 */     this.clRelationCadre = clRelationCadre;
/*  52 */     this.clRelationFond = clRelationFond;
/*  53 */     this.clRelationText = clRelationText;
/*  54 */     this.clCIFCadre = clCIFCadre;
/*  55 */     this.clCIFFond = clCIFFond;
/*  56 */     this.clCIFText = clCIFText;
/*  57 */     this.clContrainteCadre = clContrainteCadre;
/*  58 */     this.clContrainteFond = clContrainteFond;
/*  59 */     this.clContrainteText = clContrainteText;
/*  60 */     this.clLien = clLien;
/*  61 */     this.clLienCnt = clLienCnt;
/*  62 */     this.clString = clString;
/*     */   }
/*     */   
/*     */   public String getClCIFCadre() {
/*  66 */     return this.clCIFCadre;
/*     */   }
/*     */   
/*     */   public String getClCIFFond() {
/*  70 */     return this.clCIFFond;
/*     */   }
/*     */   
/*     */   public String getClCIFText() {
/*  74 */     return this.clCIFText;
/*     */   }
/*     */   
/*     */   public String getClContrainteCadre() {
/*  78 */     return this.clContrainteCadre;
/*     */   }
/*     */   
/*     */   public String getClContrainteFond() {
/*  82 */     return this.clContrainteFond;
/*     */   }
/*     */   
/*     */   public String getClContrainteText() {
/*  86 */     return this.clContrainteText;
/*     */   }
/*     */   
/*     */   public String getClEntiteCadre() {
/*  90 */     return this.clEntiteCadre;
/*     */   }
/*     */   
/*     */   public String getClEntiteFond() {
/*  94 */     return this.clEntiteFond;
/*     */   }
/*     */   
/*     */   public String getClEntiteText() {
/*  98 */     return this.clEntiteText;
/*     */   }
/*     */   
/*     */   public String getClLien() {
/* 102 */     return this.clLien;
/*     */   }
/*     */   
/*     */   public String getClLienCnt() {
/* 106 */     return this.clLienCnt;
/*     */   }
/*     */   
/*     */   public String getClRelationCadre() {
/* 110 */     return this.clRelationCadre;
/*     */   }
/*     */   
/*     */   public String getClRelationFond() {
/* 114 */     return this.clRelationFond;
/*     */   }
/*     */   
/*     */   public String getClRelationText() {
/* 118 */     return this.clRelationText;
/*     */   }
/*     */   
/*     */   public String getClString() {
/* 122 */     return this.clString;
/*     */   }
/*     */   
/*     */   public String getEtatColor() {
/* 126 */     return this.etatColor;
/*     */   }
/*     */   
/*     */   public boolean isIsDegradee() {
/* 130 */     return this.isDegradee;
/*     */   }
/*     */   
/*     */   public boolean isIsOmbre() {
/* 134 */     return this.isOmbre;
/*     */   }
/*     */   
/*     */   public boolean isIsVariable() {
/* 138 */     return this.isVariable;
/*     */   }
/*     */   
/*     */   public void setClCIFCadre(String clCIFCadre) {
/* 142 */     this.clCIFCadre = clCIFCadre;
/*     */   }
/*     */   
/*     */   public void setClCIFFond(String clCIFFond) {
/* 146 */     this.clCIFFond = clCIFFond;
/*     */   }
/*     */   
/*     */   public void setClCIFText(String clCIFText) {
/* 150 */     this.clCIFText = clCIFText;
/*     */   }
/*     */   
/*     */   public void setClContrainteCadre(String clContrainteCadre) {
/* 154 */     this.clContrainteCadre = clContrainteCadre;
/*     */   }
/*     */   
/*     */   public void setClContrainteFond(String clContrainteFond) {
/* 158 */     this.clContrainteFond = clContrainteFond;
/*     */   }
/*     */   
/*     */   public void setClContrainteText(String clContrainteText) {
/* 162 */     this.clContrainteText = clContrainteText;
/*     */   }
/*     */   
/*     */   public void setClEntiteCadre(String clEntiteCadre) {
/* 166 */     this.clEntiteCadre = clEntiteCadre;
/*     */   }
/*     */   
/*     */   public void setClEntiteFond(String clEntiteFond) {
/* 170 */     this.clEntiteFond = clEntiteFond;
/*     */   }
/*     */   
/*     */   public void setClEntiteText(String clEntiteText) {
/* 174 */     this.clEntiteText = clEntiteText;
/*     */   }
/*     */   
/*     */   public void setClLien(String clLien) {
/* 178 */     this.clLien = clLien;
/*     */   }
/*     */   
/*     */   public void setClLienCnt(String clLienCnt) {
/* 182 */     this.clLienCnt = clLienCnt;
/*     */   }
/*     */   
/*     */   public void setClRelationCadre(String clRelationCadre) {
/* 186 */     this.clRelationCadre = clRelationCadre;
/*     */   }
/*     */   
/*     */   public void setClRelationFond(String clRelationFond) {
/* 190 */     this.clRelationFond = clRelationFond;
/*     */   }
/*     */   
/*     */   public void setClRelationText(String clRelationText) {
/* 194 */     this.clRelationText = clRelationText;
/*     */   }
/*     */   
/*     */   public void setClString(String clString) {
/* 198 */     this.clString = clString;
/*     */   }
/*     */   
/*     */   public void setEtatColor(String etatColor) {
/* 202 */     this.etatColor = etatColor;
/*     */   }
/*     */   
/*     */   public void setIsDegradee(boolean isDegradee) {
/* 206 */     this.isDegradee = isDegradee;
/*     */   }
/*     */   
/*     */   public void setIsOmbre(boolean isOmbre) {
/* 210 */     this.isOmbre = isOmbre;
/*     */   }
/*     */   
/*     */   public void setIsVariable(boolean isVariable) {
/* 214 */     this.isVariable = isVariable;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 219 */     return "la configuration du fichier";
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Outil\ConfigSave.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */