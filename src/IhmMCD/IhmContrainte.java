/*    */ package IhmMCD;
/*    */ 
/*    */ import Outil.Parametres;
/*    */ import ihm.FormeInterneMCD;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IhmContrainte
/*    */   extends IhmEntiteRelation
/*    */   implements Serializable
/*    */ {
/*    */   private static Color clContrainteCadre;
/*    */   private static Color clContrainteFond;
/*    */   private static Color clString;
/*    */   private String nom;
/*    */   
/*    */   public IhmContrainte(int x, int y, int width, int hight)
/*    */   {
/* 24 */     super(x, y, width, hight, false);
/* 25 */     clContrainteCadre = FormeInterneMCD.clContrainteCadre;
/* 26 */     clContrainteFond = FormeInterneMCD.clContrainteFond;
/* 27 */     clString = FormeInterneMCD.clContrainteText;
/* 28 */     setSelected(true);
/* 29 */     this.nom = "T";
/*    */   }
/*    */   
/*    */   public void paint(Graphics g)
/*    */   {
/* 34 */     calculerTaille(g);
/* 35 */     if (isOmbre()) dessinerOmbre(g);
/* 36 */     g.setColor(clContrainteFond);
/* 37 */     g.fillOval(getX(), getY(), getWidth(), getHeight());
/* 38 */     g.setColor(clContrainteCadre);
/* 39 */     g.drawOval(getX(), getY(), getWidth(), getHeight());
/* 40 */     g.setColor(clString);
/* 41 */     ecrireNom(g);
/*    */     
/* 43 */     if (isSelected() == true) {
/* 44 */       g.setColor(Color.red);
/* 45 */       g.drawOval(getX(), getY(), getWidth(), getHeight());
/* 46 */       ecrireNom(g);
/*    */       
/* 48 */       g.setColor(Color.BLACK);
/*    */     }
/*    */   }
/*    */   
/*    */   private void dessinerOmbre(Graphics g) {
/* 53 */     Color clgard = g.getColor();
/* 54 */     g.setColor(Color.GRAY);
/* 55 */     g.fillOval(getX() + Parametres.retournerVal(g, 1), getY() + Parametres.retournerVal(g, 1), getWidth() + Parametres.retournerVal(g, 1), getHeight() + Parametres.retournerVal(g, 1));
/* 56 */     g.setColor(clgard);
/*    */   }
/*    */   
/*    */   private void calculerTaille(Graphics g) {
/* 60 */     int wMax = g.getFontMetrics().stringWidth("CRR");
/* 61 */     int h = g.getFontMetrics().getHeight();
/* 62 */     h += h / 2;
/* 63 */     redimentionner(getX(), getY(), wMax, h);
/*    */   }
/*    */   
/*    */   private void ecrireNom(Graphics g) {
/* 67 */     int h = g.getFontMetrics().getHeight();
/* 68 */     g.drawString(getNom(), getX() + (getWidth() - g.getFontMetrics().stringWidth(getNom())) / 2, getY() + h);
/*    */   }
/*    */   
/*    */   public IhmContrainte copier() {
/* 72 */     return new IhmContrainte(getX(), getY(), getWidth(), getHeight());
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 76 */     return this.nom;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 80 */     this.nom = nom;
/*    */   }
/*    */   
/*    */   public static void setClContrainteCadre(Color clRelationCadre) {
/* 84 */     clContrainteCadre = clRelationCadre;
/*    */   }
/*    */   
/*    */   public static void setClContrainteFond(Color clRelationFond) {
/* 88 */     clContrainteFond = clRelationFond;
/*    */   }
/*    */   
/*    */   public static void setClString(Color clString) {
/* 92 */     clString = clString;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmContrainte.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */