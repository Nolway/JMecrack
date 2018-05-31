/*     */ package IhmMCD;
/*     */ 
/*     */ import Merise.Attribut;
/*     */ import Merise.Relation;
/*     */ import Outil.Parametres;
/*     */ import ihm.FormeInterneMCD;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.GradientPaint;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmRelation
/*     */   extends IhmEntiteRelation
/*     */   implements Serializable
/*     */ {
/*     */   private Relation relation;
/*  23 */   private static Color clRelationCadre = FormeInterneMCD.clRelationCadre;
/*  24 */   private static Color clRelationFond = FormeInterneMCD.clRelationFond;
/*  25 */   private static Color clString = FormeInterneMCD.clRelationText;
/*  26 */   private static Font fontGras = Parametres.fontGras;
/*     */   private static Font fontNormal;
/*     */   
/*     */   public IhmRelation(Relation relation, int x, int y, boolean isvariable)
/*     */   {
/*  31 */     super(x, y, 80, 35, isvariable);
/*  32 */     this.relation = relation;
/*  33 */     setSelected(true);
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  38 */     fontNormal = g.getFont();
/*  39 */     fontGras = Parametres.fontGras;
/*  40 */     ajousterTaille(g);
/*  41 */     dessinerRelation(g);
/*     */   }
/*     */   
/*     */   private void dessinerRelation(Graphics g) {
/*  45 */     int h = g.getFontMetrics().getHeight();
/*     */     
/*     */ 
/*  48 */     if (isOmbre()) dessinerOmbre(g);
/*  49 */     g.setColor(clRelationCadre);
/*  50 */     g.drawOval(getX(), getY(), Parametres.retournerVal(g, 20), getHeight());
/*  51 */     g.drawOval(getX() + getWidth() - Parametres.retournerVal(g, 10), getY(), Parametres.retournerVal(g, 20), getHeight());
/*  52 */     g.drawRect(getX() + Parametres.retournerVal(g, 10), getY(), getWidth() - Parametres.retournerVal(g, 10), getHeight());
/*  53 */     g.setColor(clRelationFond);
/*  54 */     if (isClDegradee()) {
/*  55 */       Graphics2D g2d = (Graphics2D)g;
/*  56 */       g2d.setPaint(new GradientPaint(getX(), getY(), clRelationFond, getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*     */     }
/*     */     
/*  59 */     g.fillOval(getX() + 1, getY(), Parametres.retournerVal(g, 19), getHeight());
/*  60 */     g.fillOval(getX() + getWidth() - Parametres.retournerVal(g, 11), getY(), Parametres.retournerVal(g, 20), getHeight());
/*  61 */     g.fillRect(getX() + Parametres.retournerVal(g, 11), getY() + 1, getWidth() - Parametres.retournerVal(g, 11), getHeight() - 1);
/*     */     
/*  63 */     g.setColor(clRelationCadre);
/*     */     
/*  65 */     if ((getRelation().getNom().trim().length() != 0) || (getRelation().getListeAttributs().size() != 0)) dessinerLigneRelation(g);
/*  66 */     g.setColor(clString);
/*  67 */     fontNormal = g.getFont();
/*  68 */     g.setFont(fontGras);
/*  69 */     g.drawString(tranquerNom(g, this.relation.getNom()), positionnerNom(g) + getX(), getY() + h);
/*  70 */     g.setFont(fontNormal);
/*  71 */     ecrireAttribut(g);
/*  72 */     if (isSelected() == true) {
/*  73 */       g.setColor(Color.red);
/*  74 */       g.drawOval(getX(), getY(), 20, getHeight());
/*  75 */       g.drawOval(getX() + getWidth() - 10, getY(), 20, getHeight());
/*  76 */       g.drawRect(getX() + 10, getY(), getWidth() - 10, getHeight());
/*     */       
/*  78 */       g.setColor(clRelationFond);
/*     */       
/*  80 */       if (isClDegradee()) {
/*  81 */         Graphics2D g2d = (Graphics2D)g;
/*  82 */         g2d.setPaint(new GradientPaint(getX(), getY(), clRelationFond, getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*     */       }
/*  84 */       g.fillOval(getX() + 1, getY(), 19, getHeight());
/*  85 */       g.fillOval(getX() + getWidth() - 11, getY(), 20, getHeight());
/*  86 */       g.fillRect(getX() + 11, getY() + 1, getWidth() - 11, getHeight() - 1);
/*     */       
/*  88 */       g.setColor(Color.red);
/*     */       
/*  90 */       if ((getRelation().getNom().trim().length() != 0) || (getRelation().getListeAttributs().size() != 0)) { dessinerLigneRelation(g);
/*     */       }
/*  92 */       g.setFont(fontGras);
/*     */       
/*  94 */       g.drawString(tranquerNom(g, this.relation.getNom()), positionnerNom(g) + getX(), getY() + h);
/*  95 */       g.setFont(fontNormal);
/*  96 */       g.setColor(Color.BLACK);
/*  97 */       g.fillRect(getX() + 5 + getWidth() / 2, getY() - 2, 4, 4);
/*  98 */       g.fillRect(getX() + 5 + getWidth() / 2, getY() + getHeight() - 2, 4, 4);
/*     */       
/* 100 */       g.fillRect(getX() - 2, getY() - 2 + getHeight() / 2, 4, 4);
/* 101 */       g.fillRect(getX() - 2 + getWidth() + 10, getY() + getHeight() / 2 - 2, 4, 4);
/* 102 */       ecrireAttribut(g);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerLigneRelation(Graphics g) {
/* 107 */     int h = g.getFontMetrics().getHeight();
/* 108 */     h += h / 4;
/* 109 */     g.drawLine(getX() - Parametres.retournerVal(g, 1) + Parametres.retournerVal(g, 11), getY(), getX() + getWidth(), getY());
/* 110 */     if (isVariable()) {
/* 111 */       int i = this.relation.getListeAttributs().size();
/* 112 */       g.drawLine(getX() + Parametres.retournerVal(g, i), getY() + h, getX() + getWidth() + Parametres.retournerVal(g, 10 - i), getY() + h);
/*     */     } else {
/* 114 */       g.drawLine(getX(), getY() + h, getX() + getWidth() + Parametres.retournerVal(g, 10), getY() + h);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics g) {
/* 119 */     Color clgard = g.getColor();
/* 120 */     g.setColor(Color.GRAY);
/* 121 */     g.fillOval(getX() + getWidth() - 11, getY() + 1, Parametres.retournerVal(g, 24), getHeight() + 1);
/* 122 */     g.fillRect(getX() + 10, getY() + 1, getWidth() - 9, getHeight() + Parametres.retournerVal(g, 2));
/* 123 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private int positionnerNom(Graphics g) {
/* 127 */     String nomSt = tranquerNom(g, getRelation().getNom());
/* 128 */     return 5 + (getWidth() - g.getFontMetrics().stringWidth(nomSt)) / 2;
/*     */   }
/*     */   
/*     */   private String tranquerNom(Graphics g, String nom) {
/* 132 */     String nomSt = nom;
/* 133 */     while (g.getFontMetrics().stringWidth(nomSt + ".") >= getWidth()) {
/* 134 */       nomSt = nomSt.substring(0, nomSt.length() - 1);
/*     */     }
/* 136 */     if (!nom.equals(nomSt)) return nomSt + "..";
/* 137 */     return nomSt;
/*     */   }
/*     */   
/*     */   private void ecrireAttribut(Graphics g) {
/* 141 */     if (this.relation.getListeAttributs() != null) {
/* 142 */       int h = g.getFontMetrics().getHeight();
/* 143 */       int y = 2 * h;
/* 144 */       int i = 0;
/* 145 */       int nb = 1;
/* 146 */       if (nb == -1) nb = getRelation().getListeAttributs().size();
/* 147 */       if (nb > getRelation().getListeAttributs().size()) { nb = getRelation().getListeAttributs().size();
/*     */       }
/* 149 */       while (i < nb) {
/* 150 */         g.drawString(tranquerNom(g, tranquerNom(g, ((Attribut)this.relation.getListeAttributs().get(i)).getNom())), getX() + 6, getY() + y);
/* 151 */         i++;
/* 152 */         y += h;
/*     */       }
/* 154 */       if (nb < getRelation().getListeAttributs().size()) {
/* 155 */         g.drawString("...", getX() + 6, getY() + y);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private int calculerLargeurRelation(Graphics g) {
/* 161 */     int wMax = 0;
/* 162 */     wMax = g.getFontMetrics().stringWidth(this.relation.getNom() + ".");
/* 163 */     for (int i = 0; i < getRelation().getListeAttributs().size(); i++) {
/* 164 */       if (wMax < g.getFontMetrics().stringWidth(((Attribut)getRelation().getListeAttributs().get(i)).getNom() + ".")) {
/* 165 */         wMax = g.getFontMetrics().stringWidth(((Attribut)getRelation().getListeAttributs().get(i)).getNom() + ".");
/*     */       }
/*     */     }
/* 168 */     return wMax + 20;
/*     */   }
/*     */   
/*     */   private void ajousterTaille(Graphics g) {
/* 172 */     setWidth(calculerLargeurRelation(g));
/* 173 */     int h = g.getFontMetrics().getHeight();
/* 174 */     int nb = 1;
/* 175 */     if (nb == -1) nb = getRelation().getListeAttributs().size();
/* 176 */     if (nb > getRelation().getListeAttributs().size()) nb = getRelation().getListeAttributs().size();
/* 177 */     if ((nb > -1) && (nb < getRelation().getListeAttributs().size())) nb += 1;
/* 178 */     setHeight(getRelation().getListeAttributs().size() == 0 ? h * 2 : h + h / 2 + h * nb);
/* 179 */     redimentionner(getX(), getY(), getWidth(), getHeight());
/*     */   }
/*     */   
/*     */   public Relation getRelation() {
/* 183 */     return this.relation;
/*     */   }
/*     */   
/*     */   public void setRelation(Relation relation) {
/* 187 */     this.relation = relation;
/*     */   }
/*     */   
/*     */   public static void setClRelationCadre(Color clRelationCadre) {
/* 191 */     clRelationCadre = clRelationCadre;
/*     */   }
/*     */   
/*     */   public static void setClRelationFond(Color clRelationFond) {
/* 195 */     clRelationFond = clRelationFond;
/*     */   }
/*     */   
/*     */   public static void setClString(Color clString) {
/* 199 */     clString = clString;
/*     */   }
/*     */   
/*     */   public static Color getClRelationCadre() {
/* 203 */     return clRelationCadre;
/*     */   }
/*     */   
/*     */   public static Color getClRelationFond() {
/* 207 */     return clRelationFond;
/*     */   }
/*     */   
/*     */   public static Color getClString() {
/* 211 */     return clString;
/*     */   }
/*     */   
/*     */   public IhmRelation copier() {
/* 215 */     return new IhmRelation(getRelation().copier(), getX(), getY(), isVariable());
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 220 */     return getRelation().getNom();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmRelation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */