/*     */ package IhmMCD2;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmLienHeritage;
/*     */ import java.awt.Graphics;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmLienHeritage2
/*     */   extends IhmLienHeritage
/*     */   implements Serializable
/*     */ {
/*     */   private IhmEntiteRelation pere;
/*     */   private IhmEntiteRelation fils;
/*     */   String identifiant;
/*     */   
/*     */   public IhmLienHeritage2(IhmEntiteRelation entite, IhmEntiteRelation entitefils)
/*     */   {
/*  24 */     super(null, null);
/*  25 */     this.pere = entite;
/*  26 */     this.fils = entitefils;
/*  27 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation getFils() {
/*  31 */     return this.fils;
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation getPere() {
/*  35 */     return this.pere;
/*     */   }
/*     */   
/*     */   public void setFils(IhmEntiteRelation fils) {
/*  39 */     this.fils = fils;
/*     */   }
/*     */   
/*     */   public void setPere(IhmEntiteRelation pere) {
/*  43 */     this.pere = pere;
/*     */   }
/*     */   
/*     */   public static IhmLienHeritage2 parseIhmLienHeritage(IhmEntiteRelation newPere, IhmEntiteRelation newFils)
/*     */   {
/*  48 */     IhmLienHeritage2 l = new IhmLienHeritage2(newPere, newFils);
/*     */     
/*  50 */     return l;
/*     */   }
/*     */   
/*     */   public String getIdentifiant() {
/*  54 */     return this.identifiant;
/*     */   }
/*     */   
/*     */   public void setIdentifiant(String identifiant) {
/*  58 */     this.identifiant = identifiant;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public IhmEntite getEntite()
/*     */   {
/*  68 */     return super.getEntite();
/*     */   }
/*     */   
/*     */   public IhmEntite getEntitefils()
/*     */   {
/*  73 */     return super.getEntitefils();
/*     */   }
/*     */   
/*     */   public String getNom()
/*     */   {
/*  78 */     return super.getNom();
/*     */   }
/*     */   
/*     */   public double getxCassure()
/*     */   {
/*  83 */     return super.getxCassure();
/*     */   }
/*     */   
/*     */   public double getyCassure()
/*     */   {
/*  88 */     return super.getyCassure();
/*     */   }
/*     */   
/*     */   public void initPointCassure()
/*     */   {
/*  93 */     super.initPointCassure();
/*     */   }
/*     */   
/*     */   public boolean isCardCentre()
/*     */   {
/*  98 */     return super.isCardCentre();
/*     */   }
/*     */   
/*     */   public boolean isCassure()
/*     */   {
/* 103 */     return super.isCassure();
/*     */   }
/*     */   
/*     */   public boolean isCible()
/*     */   {
/* 108 */     return super.isCible();
/*     */   }
/*     */   
/*     */   public boolean isSelect()
/*     */   {
/* 113 */     return super.isSelect();
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/* 118 */     return super.isSelected(x, y);
/*     */   }
/*     */   
/*     */   public boolean isSelectedCassure(int x, int y)
/*     */   {
/* 123 */     return super.isSelectedCassure(x, y);
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/* 128 */     super.paint(g);
/*     */   }
/*     */   
/*     */   public void redimentionnerCassure(int x, int y)
/*     */   {
/* 133 */     super.redimentionnerCassure(x, y);
/*     */   }
/*     */   
/*     */   public void setCardCentre(boolean cardCentre)
/*     */   {
/* 138 */     super.setCardCentre(cardCentre);
/*     */   }
/*     */   
/*     */   public void setCassure(boolean cassure)
/*     */   {
/* 143 */     super.setCassure(cassure);
/*     */   }
/*     */   
/*     */   public void setCible(boolean cible)
/*     */   {
/* 148 */     super.setCible(cible);
/*     */   }
/*     */   
/*     */   public void setEntite(IhmEntite entite)
/*     */   {
/* 153 */     super.setEntite(entite);
/*     */   }
/*     */   
/*     */   public void setEntitefils(IhmEntite entitefils)
/*     */   {
/* 158 */     super.setEntitefils(entitefils);
/*     */   }
/*     */   
/*     */   public void setNom(String nom)
/*     */   {
/* 163 */     super.setNom(nom);
/*     */   }
/*     */   
/*     */   public void setSelected(boolean selected)
/*     */   {
/* 168 */     super.setSelected(selected);
/*     */   }
/*     */   
/*     */   public void setxCardinal(double xCardinal)
/*     */   {
/* 173 */     super.setxCardinal(xCardinal);
/*     */   }
/*     */   
/*     */   public void setyCassure(double yCassure)
/*     */   {
/* 178 */     super.setyCassure(yCassure);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmLienHeritage2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */