/*     */ package IhmMLD;
/*     */ 
/*     */ import Merise.Attribut;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MLDEntite
/*     */   implements Serializable
/*     */ {
/*     */   private int x;
/*     */   private int y;
/*     */   private int height;
/*     */   private int width;
/*     */   private String nom;
/*     */   private String Commentaire;
/*     */   private boolean selected;
/*     */   private boolean variable;
/*     */   private boolean degradee;
/*     */   private boolean ombre;
/*     */   private ArrayList<Attribut> listeAttributs;
/*     */   private int corXType;
/*  37 */   private static Font fontGras = new Font("Arial", 1, 12);
/*     */   private static Font fontNormal;
/*     */   
/*     */   public MLDEntite(String nom, String commentaire)
/*     */   {
/*  42 */     this.nom = nom;
/*  43 */     this.Commentaire = commentaire;
/*  44 */     this.listeAttributs = new ArrayList();
/*  45 */     this.variable = true;
/*  46 */     this.ombre = true;
/*  47 */     this.selected = false;
/*  48 */     this.corXType = (getX() + 10);
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/*  52 */     fontNormal = Parametres.fontNormal;
/*  53 */     fontGras = Parametres.fontGras;
/*  54 */     g.setFont(fontNormal);
/*  55 */     ajousterTaille(g);
/*     */     
/*     */ 
/*  58 */     if (isOmbre()) dessinerOmbre(g);
/*  59 */     g.setColor(FormeInterneMCD.clEntiteFond);
/*  60 */     Graphics2D g2d = (Graphics2D)g;
/*  61 */     if (isDegradee()) { g2d.setPaint(new GradientPaint(getX(), getY(), FormeInterneMCD.clEntiteFond, getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*     */     }
/*  63 */     g.fillRect(getX(), getY(), getWidth(), getHeight());
/*  64 */     g.setColor(FormeInterneMCD.clEntiteCadre);
/*  65 */     g.drawRect(getX(), getY(), getWidth(), getHeight());
/*     */     
/*  67 */     dessinerLineSep(g);
/*  68 */     g.setColor(FormeInterneMCD.clString);
/*  69 */     ecrireNom(g);
/*  70 */     ecrireAttributs(g);
/*  71 */     if (isSelected()) {
/*  72 */       if (isOmbre()) dessinerOmbre(g);
/*  73 */       g.setColor(FormeInterneMCD.clEntiteFond);
/*  74 */       if (isDegradee()) g2d.setPaint(new GradientPaint(getX(), getY(), FormeInterneMCD.clEntiteFond, getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*  75 */       g.fillRect(getX(), getY(), getWidth(), getHeight());
/*  76 */       g.setColor(Color.red);
/*  77 */       ecrireNom(g);
/*  78 */       g.drawRect(getX(), getY(), getWidth(), getHeight());
/*     */       
/*  80 */       dessinerLineSep(g);
/*  81 */       g.setColor(Color.BLACK);
/*  82 */       g.fillRect(getX() - 1, getY() - 1, 4, 4);
/*  83 */       g.fillRect(getX() - 1, getY() - 2 + getHeight(), 4, 4);
/*  84 */       g.fillRect(getX() - 1 + getWidth(), getY() - 1, 4, 4);
/*  85 */       g.fillRect(getX() - 1 + getWidth(), getY() - 2 + getHeight(), 4, 4);
/*  86 */       ecrireAttributs(g);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerLineSep(Graphics g) {
/*  91 */     int h = g.getFontMetrics().getHeight();
/*  92 */     h += h / 2;
/*  93 */     g.drawLine(getX(), getY() + h, getX() + getWidth(), getY() + h);
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics g)
/*     */   {
/*  98 */     Color clgard = g.getColor();
/*  99 */     g.setColor(Color.GRAY);
/* 100 */     g.fillRect(getX() + 2, getY() + 2, getWidth() + 2, getHeight() + 2);
/* 101 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private void ajousterTaille(Graphics g) {
/* 105 */     if (isVariable()) {
/* 106 */       calculerTailleVariable(g);
/*     */     } else {
/* 108 */       calculerTailleNonVariable(g);
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculerTailleVariable(Graphics g) {
/* 113 */     int wMax = g.getFontMetrics().stringWidth(getNom() + "MESS");
/* 114 */     int wAttrib = 0;
/* 115 */     int wtype = 0;
/* 116 */     int h = g.getFontMetrics().getHeight();
/* 117 */     this.corXType = 0;
/*     */     
/* 119 */     for (int i = 0; i < getListeAttributs().size(); i++) {
/* 120 */       if (wAttrib < g.getFontMetrics().stringWidth(((Attribut)getListeAttributs().get(i)).getNom())) {
/* 121 */         wAttrib = g.getFontMetrics().stringWidth(((Attribut)getListeAttributs().get(i)).getNom());
/*     */       }
/*     */       
/* 124 */       if (wtype < g.getFontMetrics().stringWidth(((Attribut)getListeAttributs().get(i)).getType())) {
/* 125 */         wtype = g.getFontMetrics().stringWidth(((Attribut)getListeAttributs().get(i)).getType());
/*     */       }
/*     */     }
/* 128 */     this.corXType = (g.getFontMetrics().stringWidth("MESs") + wAttrib + g.getFontMetrics().stringWidth("S"));
/* 129 */     if (wMax < this.corXType + wtype) {
/* 130 */       wMax = this.corXType + wtype + g.getFontMetrics().stringWidth("m");
/*     */     }
/* 132 */     h = h * getListeAttributs().size() + (getListeAttributs().size() == 0 ? 2 * h : h * 2);
/* 133 */     redimentionner(getX(), getY(), wMax, h);
/*     */   }
/*     */   
/*     */   private void calculerTailleNonVariable(Graphics g)
/*     */   {
/* 138 */     int wMax = 0;
/*     */     
/* 140 */     int h = g.getFontMetrics().getHeight();
/*     */     
/* 142 */     wMax = g.getFontMetrics().stringWidth(getNom() + "MESS");
/* 143 */     for (int i = 0; i < getListeAttributs().size(); i++) {
/* 144 */       if (wMax < g.getFontMetrics().stringWidth(((Attribut)getListeAttributs().get(i)).getNom() + "MESME")) {
/* 145 */         wMax = g.getFontMetrics().stringWidth(((Attribut)getListeAttributs().get(i)).getNom() + "MESME");
/*     */       }
/*     */     }
/* 148 */     h = h * getListeAttributs().size() + (getListeAttributs().size() == 0 ? 2 * h : h * 2);
/* 149 */     redimentionner(getX(), getY(), wMax, h);
/*     */   }
/*     */   
/*     */   private void ecrireNom(Graphics g) {
/* 153 */     g.setFont(fontGras);
/* 154 */     int h = g.getFontMetrics().getHeight();
/*     */     
/* 156 */     if (!isVariable()) {
/* 157 */       g.drawString(getNom(), getX() + (getWidth() - g.getFontMetrics().stringWidth(getNom())) / 2, getY() + h);
/*     */     } else {
/* 159 */       g.drawString(getNom(), getX() + (getWidth() - g.getFontMetrics().stringWidth(getNom())) / 2, getY() + h);
/*     */     }
/* 161 */     g.setFont(fontNormal);
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getCle() {
/* 165 */     ArrayList<Attribut> listeCle = new ArrayList();
/* 166 */     for (int i = 0; i < getListeAttributs().size(); i++) {
/* 167 */       if (Parametres.Cle.equals(((Attribut)getListeAttributs().get(i)).getKey())) {
/* 168 */         listeCle.add(((Attribut)getListeAttributs().get(i)).copier());
/*     */       }
/*     */     }
/*     */     
/* 172 */     return listeCle;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getNonCle() {
/* 176 */     ArrayList<Attribut> listeCle = new ArrayList();
/* 177 */     for (int i = 0; i < getListeAttributs().size(); i++) {
/* 178 */       if (!Parametres.Cle.equals(((Attribut)getListeAttributs().get(i)).getKey())) {
/* 179 */         listeCle.add(((Attribut)getListeAttributs().get(i)).copier());
/*     */       }
/*     */     }
/*     */     
/* 183 */     return listeCle;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getCleEtrangere() {
/* 187 */     ArrayList<Attribut> listeCle = new ArrayList();
/* 188 */     for (int i = 0; i < getListeAttributs().size(); i++) {
/* 189 */       if (Parametres.CleEtr.equals(((Attribut)getListeAttributs().get(i)).getKey())) {
/* 190 */         listeCle.add(((Attribut)getListeAttributs().get(i)).copier());
/*     */       }
/*     */     }
/*     */     
/* 194 */     return listeCle;
/*     */   }
/*     */   
/*     */   private void ecrireAttributs(Graphics g) {
/* 198 */     if (getListeAttributs() != null) {
/* 199 */       int yy = (int)(g.getFontMetrics().getHeight() * 2.5D);
/* 200 */       int i = 0;
/* 201 */       if (!isVariable()) {
/* 202 */         int h = g.getFontMetrics().getHeight();
/* 203 */         while (i < getListeAttributs().size()) {
/* 204 */           ecrireAttribut(g, (Attribut)getListeAttributs().get(i), getX(), getY() + yy);
/* 205 */           i++;
/* 206 */           yy += h;
/*     */         }
/*     */       } else {
/* 209 */         int h = g.getFontMetrics().getHeight();
/* 210 */         while (i < getListeAttributs().size()) {
/* 211 */           ecrireAttribut(g, (Attribut)getListeAttributs().get(i), getX(), getY() + yy);
/* 212 */           i++;
/* 213 */           yy += h;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void ecrireAttribut(Graphics g, Attribut att, int x, int y) {
/* 220 */     int dec = g.getFontMetrics().stringWidth("MeSs");
/*     */     
/* 222 */     if (isVariable()) {
/* 223 */       if (att.getKey().trim().toUpperCase().equals(Parametres.Cle)) g.drawString("PrK", getX() + 3, y);
/* 224 */       if (att.getKey().trim().toUpperCase().equals(Parametres.Index)) g.drawString("Idx", getX() + 3, y);
/* 225 */       if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) g.drawString("Uni", getX() + 3, y);
/* 226 */       if (att.getKey().trim().toUpperCase().equals(Parametres.CleEtr)) g.drawString("FrK", getX() + 3, y);
/* 227 */       if (att.getKey().equals(Parametres.Cle)) {
/* 228 */         fontNormal = g.getFont();
/* 229 */         g.setFont(fontGras);
/* 230 */         g.drawString(att.getNom(), x + dec, y);
/* 231 */         g.drawLine(getX() + dec, y + 1, getX() + dec + g.getFontMetrics().stringWidth(att.getNom()), y + 1);
/* 232 */         g.setFont(fontNormal);
/*     */       } else {
/* 234 */         g.drawString(att.getNom(), x + dec, y);
/*     */       }
/* 236 */       g.drawString(att.getType(), this.corXType + x, y);
/*     */     } else {
/* 238 */       if (att.getKey().trim().toUpperCase().equals(Parametres.Cle)) g.drawString("PrK", getX() + 3, y);
/* 239 */       if (att.getKey().trim().toUpperCase().equals(Parametres.Index)) g.drawString("Idx", getX() + 3, y);
/* 240 */       if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) g.drawString("Uni", getX() + 3, y);
/* 241 */       if (att.getKey().trim().toUpperCase().equals(Parametres.CleEtr)) g.drawString("FrK", getX() + 3, y);
/* 242 */       if (att.getKey().equals(Parametres.Cle)) {
/* 243 */         fontNormal = g.getFont();
/* 244 */         g.setFont(fontGras);
/* 245 */         g.drawString(att.getNom(), x + dec, y);
/* 246 */         g.drawLine(getX() + dec, y + 1, getX() + dec + g.getFontMetrics().stringWidth(att.getNom()), y + 1);
/* 247 */         g.setFont(fontNormal);
/*     */       } else {
/* 249 */         g.drawString(att.getNom(), x + dec, y);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isOmbre() {
/* 255 */     return this.ombre;
/*     */   }
/*     */   
/*     */   public boolean isVariable() {
/* 259 */     return this.variable;
/*     */   }
/*     */   
/*     */   public boolean isSelected() {
/* 263 */     return this.selected;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getListeAttributs() {
/* 267 */     return this.listeAttributs;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 271 */     return this.nom;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/* 275 */     return this.Commentaire;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 279 */     return this.height;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 283 */     return this.width;
/*     */   }
/*     */   
/*     */   public int getX() {
/* 287 */     return this.x;
/*     */   }
/*     */   
/*     */   public int getCentreX() {
/* 291 */     return getX() + getWidth() / 2;
/*     */   }
/*     */   
/*     */   public int getCentreY() {
/* 295 */     return getY() + getHeight() / 2;
/*     */   }
/*     */   
/*     */   public int getY() {
/* 299 */     return this.y;
/*     */   }
/*     */   
/*     */   public void setHeight(int height) {
/* 303 */     this.height = height;
/*     */   }
/*     */   
/*     */   public void setWidth(int width) {
/* 307 */     this.width = width;
/*     */   }
/*     */   
/*     */   public void setX(int x) {
/* 311 */     this.x = x;
/*     */   }
/*     */   
/*     */   public void setY(int y) {
/* 315 */     this.y = y;
/*     */   }
/*     */   
/*     */   public void setOmbre(boolean ombre) {
/* 319 */     this.ombre = ombre;
/*     */   }
/*     */   
/*     */   public void setSelected(boolean selected) {
/* 323 */     this.selected = selected;
/*     */   }
/*     */   
/*     */   public void setVariable(boolean variable) {
/* 327 */     this.variable = variable;
/*     */   }
/*     */   
/*     */   public void setListeAttribut(ArrayList<Attribut> listeAttribut) {
/* 331 */     this.listeAttributs = listeAttribut;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 335 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String Commentaire) {
/* 339 */     this.Commentaire = Commentaire;
/*     */   }
/*     */   
/*     */   public void setPosition(int x, int y, int h, int w) {
/* 343 */     setX(x);
/* 344 */     setY(y);
/* 345 */     setHeight(h);
/* 346 */     setWidth(w);
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y) {
/* 350 */     if ((x > getX()) && (y > getY()) && (x < getX() + getWidth()) && (y < getY() + getHeight()))
/*     */     {
/* 352 */       return true;
/*     */     }
/* 354 */     this.selected = false;
/* 355 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void redimentionner(int x, int y, int width, int hight)
/*     */   {
/* 361 */     if (x > 0) setX(x);
/* 362 */     if (y > 0) setY(y);
/* 363 */     setHeight(hight);
/* 364 */     setWidth(width);
/*     */   }
/*     */   
/*     */   public void setDegradee(boolean degradee) {
/* 368 */     this.degradee = degradee;
/*     */   }
/*     */   
/*     */   public boolean isDegradee() {
/* 372 */     return this.degradee;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD\MLDEntite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */