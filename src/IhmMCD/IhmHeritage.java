/*     */ package IhmMCD;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmHeritage
/*     */   extends IhmEntiteRelation
/*     */   implements Serializable
/*     */ {
/*  18 */   private static Color clRelationCadre = Color.BLUE;
/*  19 */   private static Color clRelationFond = Color.WHITE;
/*  20 */   private static Color clRelationText = Color.BLACK;
/*     */   private IhmEntite entitePere;
/*     */   private String nom;
/*     */   
/*     */   public IhmHeritage(int x, int y, IhmEntite entite) {
/*  25 */     super(x, y, 40, 25, false);
/*  26 */     this.entitePere = entite;
/*  27 */     this.nom = " ";
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  32 */     calculerTaille(g);
/*  33 */     if (isOmbre()) dessinerOmbre(g);
/*  34 */     g.setColor(clRelationFond);
/*  35 */     int[] x = { getX() + getWidth() / 2, getX(), getX() + getWidth() };
/*  36 */     int[] y = { getY(), getY() + getHeight(), getY() + getHeight() };
/*  37 */     g.fillPolygon(x, y, 3);
/*  38 */     g.setColor(clRelationCadre);
/*  39 */     g.drawPolygon(x, y, 3);
/*  40 */     ecrireNom(g);
/*  41 */     if (isSelected() == true) {
/*  42 */       g.setColor(Color.red);
/*  43 */       g.drawPolygon(x, y, 3);
/*  44 */       ecrireNom(g);
/*  45 */       g.setColor(Color.BLACK);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics g) {
/*  50 */     Color clgard = g.getColor();
/*  51 */     g.setColor(Color.GRAY);
/*  52 */     int[] x = { getX() + getWidth() / 2, getX(), getX() + getWidth() };
/*  53 */     int[] y = { getY(), getY() + getHeight() + Parametres.retournerVal(g, 3), getY() + getHeight() + Parametres.retournerVal(g, 3) };
/*  54 */     g.fillPolygon(x, y, 3);
/*  55 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private void calculerTaille(Graphics g) {
/*  59 */     int wMax = g.getFontMetrics().stringWidth("CIFR");
/*  60 */     int h = g.getFontMetrics().getHeight();
/*  61 */     h += 2 * h / 3;
/*  62 */     redimentionner(getX(), getY(), wMax, h);
/*     */   }
/*     */   
/*     */   private void ecrireNom(Graphics g) {
/*  66 */     int t = g.getFontMetrics().stringWidth(getNom());
/*  67 */     g.setColor(clRelationText);
/*  68 */     g.drawString(getNom(), getX() + (getWidth() - t) / 2, getY() + getHeight() - 2);
/*     */   }
/*     */   
/*     */   public IhmHeritage copier()
/*     */   {
/*  73 */     return new IhmHeritage(getX(), getY(), this.entitePere);
/*     */   }
/*     */   
/*     */   public IhmEntite getEntitePere() {
/*  77 */     return this.entitePere;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  81 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setEntitePere(IhmEntite entitePere) {
/*  85 */     this.entitePere = entitePere;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  89 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public static void setClRelationCadre(Color clRelationCadre) {
/*  93 */     clRelationCadre = clRelationCadre;
/*     */   }
/*     */   
/*     */   public static void setClRelationFond(Color clRelationFond) {
/*  97 */     clRelationFond = clRelationFond;
/*     */   }
/*     */   
/*     */   public static void setClString(Color clString) {
/* 101 */     clRelationText = clString;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmHeritage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */