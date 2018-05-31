/*     */ package IhmMCD;
/*     */ 
/*     */ import Merise.Attribut;
/*     */ import Merise.Entite;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import ihm.FormeInterneMCD;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.GradientPaint;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class IhmEntite extends IhmEntiteRelation implements java.io.Serializable
/*     */ {
/*     */   private Entite entite;
/*  19 */   private static Color clEntiteCadre = FormeInterneMCD.clEntiteCadre;
/*  20 */   private static Color clEntiteFond = FormeInterneMCD.clEntiteFond;
/*  21 */   private static Color clString = FormeInterneMCD.clEntiteText;
/*  22 */   private static Font fontGras = Parametres.fontGras;
/*     */   private static Font fontNormal;
/*     */   private int corXType;
/*     */   
/*     */   public IhmEntite(Entite entite, int x, int y, boolean isvariable) {
/*  27 */     super(x, y, 100, 70, isvariable);
/*  28 */     this.entite = entite;
/*  29 */     setSelected(true);
/*  30 */     this.corXType = (getX() + 10);
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/*  34 */     g.setFont(Parametres.fontNormal);
/*  35 */     fontNormal = g.getFont();
/*  36 */     fontGras = Parametres.fontGras;
/*  37 */     ajousterTaille(g);
/*     */     
/*     */ 
/*  40 */     if (isOmbre()) dessinerOmbre(g);
/*  41 */     g.setColor(clEntiteFond);
/*  42 */     if (isClDegradee()) {
/*  43 */       Graphics2D g2d = (Graphics2D)g;
/*  44 */       g2d.setPaint(new GradientPaint(getX(), getY(), clEntiteFond, getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*     */     }
/*     */     
/*  47 */     g.fillRect(getX(), getY(), getWidth(), getHeight());
/*  48 */     g.setColor(clEntiteCadre);
/*  49 */     g.drawRect(getX(), getY(), getWidth(), getHeight());
/*     */     
/*  51 */     dessinerLineSep(g);
/*  52 */     g.setColor(clString);
/*  53 */     ecrireNom(g);
/*  54 */     ecrireAttributs(g);
/*  55 */     if (isSelected()) {
/*  56 */       if (isOmbre()) dessinerOmbre(g);
/*  57 */       g.setColor(clEntiteFond);
/*  58 */       if (isClDegradee()) {
/*  59 */         Graphics2D g2d = (Graphics2D)g;
/*  60 */         g2d.setPaint(new GradientPaint(getX(), getY(), clEntiteFond, getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*     */       }
/*  62 */       g.fillRect(getX(), getY(), getWidth(), getHeight());
/*  63 */       g.setColor(Color.red);
/*  64 */       ecrireNom(g);
/*  65 */       g.drawRect(getX(), getY(), getWidth(), getHeight());
/*     */       
/*  67 */       dessinerLineSep(g);
/*  68 */       g.setColor(Color.BLACK);
/*  69 */       g.fillRect(getX() - 1, getY() - 1, 4, 4);
/*  70 */       g.fillRect(getX() - 1, getY() - 2 + getHeight(), 4, 4);
/*  71 */       g.fillRect(getX() - 1 + getWidth(), getY() - 1, 4, 4);
/*  72 */       g.fillRect(getX() - 1 + getWidth(), getY() - 2 + getHeight(), 4, 4);
/*  73 */       ecrireAttributs(g);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerLineSep(Graphics g) {
/*  78 */     int h = g.getFontMetrics().getHeight();
/*  79 */     h += h / 2;
/*  80 */     g.drawLine(getX(), getY() + h, getX() + getWidth(), getY() + h);
/*     */   }
/*     */   
/*     */   private void ajousterTaille(Graphics g)
/*     */   {
/*  85 */     if (isVariable()) {
/*  86 */       calculerTailleVariable(g);
/*     */     } else {
/*  88 */       calculerTailleNonVariable(g);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics g) {
/*  93 */     Color clgard = g.getColor();
/*  94 */     g.setColor(Color.GRAY);
/*  95 */     g.fillRect(getX() + Parametres.retournerVal(g, 2), getY() + Parametres.retournerVal(g, 2), getWidth() + Parametres.retournerVal(g, 2), getHeight() + Parametres.retournerVal(g, 2));
/*  96 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private void calculerTailleVariable(Graphics g) {
/* 100 */     int wMax = g.getFontMetrics().stringWidth(this.entite.getNom() + "MESS");
/*     */     
/* 102 */     int wAttrib = 0;
/* 103 */     int wtype = 0;
/* 104 */     int h = g.getFontMetrics().getHeight();
/* 105 */     this.corXType = 0;
/* 106 */     int nb = 1;
/* 107 */     if (nb == -1) nb = getEntite().getListeAttributs().size();
/* 108 */     if (nb > getEntite().getListeAttributs().size()) nb = getEntite().getListeAttributs().size();
/* 109 */     if ((nb > -1) && (nb < getEntite().getListeAttributs().size())) nb += 1;
/* 110 */     for (int i = 0; i < nb; i++) {
/* 111 */       if (wAttrib < g.getFontMetrics().stringWidth(((Attribut)getEntite().getListeAttributs().get(i)).getNom())) {
/* 112 */         wAttrib = g.getFontMetrics().stringWidth(((Attribut)getEntite().getListeAttributs().get(i)).getNom());
/*     */       }
/* 114 */       if (Setting.attMajuscule) {
/* 115 */         if (wtype < g.getFontMetrics().stringWidth(((Attribut)getEntite().getListeAttributs().get(i)).getType().toUpperCase())) {
/* 116 */           wtype = g.getFontMetrics().stringWidth(((Attribut)getEntite().getListeAttributs().get(i)).getType().toUpperCase());
/*     */         }
/*     */       }
/* 119 */       else if (wtype < g.getFontMetrics().stringWidth(((Attribut)getEntite().getListeAttributs().get(i)).getType())) {
/* 120 */         wtype = g.getFontMetrics().stringWidth(((Attribut)getEntite().getListeAttributs().get(i)).getType());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 125 */     this.corXType = (g.getFontMetrics().stringWidth("MESs") + wAttrib + g.getFontMetrics().stringWidth("S"));
/*     */     
/* 127 */     if (wMax < this.corXType + wtype) {
/* 128 */       if (!Setting.prkvisible) {
/* 129 */         this.corXType -= g.getFontMetrics().stringWidth("MEs");
/*     */       }
/* 131 */       wMax = this.corXType + wtype + g.getFontMetrics().stringWidth("m");
/*     */     }
/*     */     
/* 134 */     h = h * nb + (nb == 0 ? 2 * h : h * 2);
/*     */     
/* 136 */     redimentionner(getX(), getY(), wMax, h);
/*     */   }
/*     */   
/*     */   private void calculerTailleNonVariable(Graphics g) {
/* 140 */     int wMax = 0;
/*     */     
/* 142 */     int h = g.getFontMetrics().getHeight();
/* 143 */     int nb = 1;
/* 144 */     if (nb == -1) nb = getEntite().getListeAttributs().size();
/* 145 */     if (nb > getEntite().getListeAttributs().size()) nb = getEntite().getListeAttributs().size();
/* 146 */     if ((nb > -1) && (nb < getEntite().getListeAttributs().size())) { nb += 1;
/*     */     }
/* 148 */     wMax = g.getFontMetrics().stringWidth(this.entite.getNom() + "MESS");
/*     */     
/*     */ 
/* 151 */     for (int i = 0; i < nb; i++) {
/* 152 */       if (wMax < g.getFontMetrics().stringWidth(((Attribut)getEntite().getListeAttributs().get(i)).getNom() + "MESME")) {
/* 153 */         wMax = g.getFontMetrics().stringWidth(((Attribut)getEntite().getListeAttributs().get(i)).getNom() + "MESME");
/*     */       }
/*     */     }
/*     */     
/* 157 */     if ((!Setting.prkvisible) && 
/* 158 */       (wMax != g.getFontMetrics().stringWidth(this.entite.getNom() + "MESS"))) {
/* 159 */       wMax -= g.getFontMetrics().stringWidth("MES");
/*     */     }
/*     */     
/*     */ 
/* 163 */     h = h * nb + (nb == 0 ? 2 * h : h * 2);
/* 164 */     redimentionner(getX(), getY(), wMax, h);
/*     */   }
/*     */   
/*     */   private void ecrireNom(Graphics g) {
/* 168 */     g.setFont(fontGras);
/* 169 */     int h = g.getFontMetrics().getHeight();
/*     */     
/* 171 */     if (!isVariable()) {
/* 172 */       g.drawString(this.entite.getNom(), getX() + (getWidth() - g.getFontMetrics().stringWidth(this.entite.getNom())) / 2, getY() + h);
/*     */     } else {
/* 174 */       g.drawString(this.entite.getNom(), getX() + (getWidth() - g.getFontMetrics().stringWidth(this.entite.getNom())) / 2, getY() + h);
/*     */     }
/* 176 */     g.setFont(fontNormal);
/*     */   }
/*     */   
/*     */   private void ecrireAttributs(Graphics g) {
/* 180 */     if (this.entite.getListeAttributs() != null)
/*     */     {
/* 182 */       int nb = 1;
/* 183 */       if (nb == -1) nb = getEntite().getListeAttributs().size();
/* 184 */       if (nb > getEntite().getListeAttributs().size()) { nb = getEntite().getListeAttributs().size();
/*     */       }
/* 186 */       int y = (int)(g.getFontMetrics().getHeight() * 2.5D);
/* 187 */       int i = 0;
/* 188 */       if (!isVariable()) {
/* 189 */         int h = g.getFontMetrics().getHeight();
/* 190 */         while (i < nb) {
/* 191 */           ecrireAttribut(g, (Attribut)this.entite.getListeAttributs().get(i), getX(), getY() + y);
/* 192 */           i++;
/* 193 */           y += h;
/*     */         }
/* 195 */         if (nb < getEntite().getListeAttributs().size()) {
/* 196 */           ecrireAttribut(g, "...", getX(), getY() + y);
/*     */         }
/*     */       } else {
/* 199 */         int h = g.getFontMetrics().getHeight();
/* 200 */         while (i < nb) {
/* 201 */           ecrireAttribut(g, (Attribut)this.entite.getListeAttributs().get(i), getX(), getY() + y);
/* 202 */           i++;
/* 203 */           y += h;
/*     */         }
/* 205 */         if (nb < getEntite().getListeAttributs().size()) {
/* 206 */           ecrireAttribut(g, "...", getX(), getY() + y);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void ecrireAttribut(Graphics g, Attribut att, int x, int y) {
/* 213 */     int dec = g.getFontMetrics().stringWidth("MeSs");
/* 214 */     if (!Setting.prkvisible) {
/* 215 */       dec = 6;
/*     */     }
/* 217 */     if (isVariable()) {
/* 218 */       if (Setting.prkvisible) {
/* 219 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Cle)) g.drawString("PrK", getX() + 3, y);
/* 220 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Index)) g.drawString("Idx", getX() + 3, y);
/* 221 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) { g.drawString("Uni", getX() + 3, y);
/*     */         }
/*     */       }
/* 224 */       if (att.getKey().equals(Parametres.Cle)) {
/* 225 */         fontNormal = g.getFont();
/* 226 */         g.setFont(fontGras);
/* 227 */         g.drawString(att.getNom(), x + dec, y);
/* 228 */         g.drawLine(getX() + dec, y + 1, getX() + dec + g.getFontMetrics().stringWidth(att.getNom()), y + 1);
/* 229 */         g.setFont(fontNormal);
/*     */       } else {
/* 231 */         g.drawString(att.getNom(), x + dec, y);
/*     */       }
/* 233 */       if (Setting.attMajuscule) {
/* 234 */         g.drawString(att.getType().toUpperCase(), this.corXType + x, y);
/*     */       } else {
/* 236 */         g.drawString(att.getType(), this.corXType + x, y);
/*     */       }
/*     */     } else {
/* 239 */       if (Setting.prkvisible) {
/* 240 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Cle)) g.drawString("PrK", getX() + 3, y);
/* 241 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Index)) g.drawString("Idx", getX() + 3, y);
/* 242 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) { g.drawString("Uni", getX() + 3, y);
/*     */         }
/*     */       }
/* 245 */       if (att.getKey().equals(Parametres.Cle)) {
/* 246 */         fontNormal = g.getFont();
/* 247 */         g.setFont(fontGras);
/* 248 */         g.drawString(att.getNom(), x + dec, y);
/* 249 */         g.drawLine(getX() + dec, y + 1, getX() + dec + g.getFontMetrics().stringWidth(att.getNom()), y + 1);
/* 250 */         g.setFont(fontNormal);
/*     */       } else {
/* 252 */         g.drawString(att.getNom(), x + dec, y);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void ecrireAttribut(Graphics g, String att, int x, int y) {
/* 258 */     int dec = g.getFontMetrics().stringWidth("MeSs");
/* 259 */     if (!Setting.prkvisible) {
/* 260 */       dec = 3;
/*     */     }
/* 262 */     g.drawString(att, x + dec, y);
/*     */   }
/*     */   
/*     */   public Entite getEntite() {
/* 266 */     return this.entite;
/*     */   }
/*     */   
/*     */   public void setEntite(Entite entite) {
/* 270 */     this.entite = entite;
/*     */   }
/*     */   
/*     */   public static Color getClEntiteCadre() {
/* 274 */     return clEntiteCadre;
/*     */   }
/*     */   
/*     */   public static Color getClEntiteFond() {
/* 278 */     return clEntiteFond;
/*     */   }
/*     */   
/*     */   public static Color getClString() {
/* 282 */     return clString;
/*     */   }
/*     */   
/*     */   public static void setClEntiteCadre(Color clEntiteCadre) {
/* 286 */     clEntiteCadre = clEntiteCadre;
/*     */   }
/*     */   
/*     */   public static void setClEntiteFond(Color clEntiteFond) {
/* 290 */     clEntiteFond = clEntiteFond;
/*     */   }
/*     */   
/*     */   public static void setClString(Color clString) {
/* 294 */     clString = clString;
/*     */   }
/*     */   
/*     */   public IhmEntite copier() {
/* 298 */     return new IhmEntite(getEntite().copier(), getX(), getY(), isVariable());
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 303 */     return getEntite().getNom();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmEntite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */