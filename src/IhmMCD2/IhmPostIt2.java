/*     */ package IhmMCD2;
/*     */ 
/*     */ import IhmMCD.IhmCommentaireIndip;
/*     */ import IhmMCD.IhmPostIt;
/*     */ import Merise2.Historique;
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
/*     */ 
/*     */ public class IhmPostIt2
/*     */   extends IhmCommentaireIndip
/*     */   implements Serializable
/*     */ {
/*     */   String code;
/*     */   String aligner;
/*     */   double zoom;
/*     */   Font font;
/*     */   Font fontGras;
/*     */   Color clSelected;
/*     */   public Color clPunaise;
/*     */   public boolean activer;
/*     */   ArrayList<Historique> historique;
/*     */   String identifiant;
/*     */   
/*     */   public IhmPostIt2(String Commentaire, int x, int y, int weidth, int hight)
/*     */   {
/*  42 */     super(Commentaire, x, y, weidth, hight);
/*  43 */     setCommentaire("Vos notes et remarques ici\n");
/*     */     
/*  45 */     this.code = "";
/*  46 */     this.activer = false;
/*  47 */     this.clPunaise = FormeInterneMCD.clPostItPunaise2;
/*     */     
/*  49 */     this.aligner = FormeInterneMCD.aligner;
/*     */     
/*  51 */     this.font = Parametres.fontNormal;
/*  52 */     this.fontGras = Parametres.fontGras;
/*     */     
/*  54 */     setClCadre(FormeInterneMCD.clPostItCadre2);
/*  55 */     setClFond(FormeInterneMCD.clPostItFond2);
/*  56 */     setClTexte(FormeInterneMCD.clPostItText2);
/*  57 */     this.clSelected = FormeInterneMCD.clSelected;
/*     */     
/*  59 */     this.historique = new ArrayList();
/*  60 */     this.historique.add(Historique.getHistoriqueCreation());
/*     */     
/*  62 */     setOmbre(true);
/*  63 */     setClDegradee(FormeInterneMCD.isDegradee2);
/*  64 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  69 */     Graphics2D g2d = (Graphics2D)g;
/*  70 */     ajusterLaTaille(g2d);
/*  71 */     if (isOmbre()) {
/*  72 */       dessinerOmbre(g2d);
/*     */     }
/*  74 */     dessinerPostIt(g2d);
/*  75 */     ecrireCommentaire(g2d);
/*  76 */     if (isSelected() == true) {
/*  77 */       g.setColor(getClSelected());
/*  78 */       dessinerSelect(g2d);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics2D g) {
/*  83 */     g.setColor(Color.GRAY);
/*  84 */     g.fillRect(getX(), getY(), getWeidth(), getHeight());
/*     */   }
/*     */   
/*     */   private void dessinerPostIt(Graphics2D g) {
/*  88 */     int[] xPoint = { 0, 0, 0, 0 };
/*  89 */     int[] yPoint = { 0, 0, 0, 0 };
/*  90 */     xPoint[0] = (getX() - 1);
/*  91 */     yPoint[0] = (getY() - 1);
/*     */     
/*  93 */     xPoint[1] = (getX() + getWeidth() + 4);
/*  94 */     yPoint[1] = (getY() - 1);
/*     */     
/*  96 */     xPoint[2] = (getX() + getWeidth() + 9);
/*  97 */     yPoint[2] = (getY() + getHeight());
/*     */     
/*  99 */     xPoint[3] = (getX() + 8);
/* 100 */     yPoint[3] = (getY() + getHeight());
/*     */     
/* 102 */     g.setColor(getClFond());
/* 103 */     g.drawPolygon(xPoint, yPoint, 4);
/* 104 */     xPoint[0] = getX();
/* 105 */     yPoint[0] = getY();
/*     */     
/* 107 */     xPoint[1] = (getX() + getWeidth() + 3);
/* 108 */     yPoint[1] = getY();
/*     */     
/* 110 */     xPoint[2] = (getX() + getWeidth() + 8);
/* 111 */     yPoint[2] = (getY() + getHeight());
/*     */     
/* 113 */     xPoint[3] = (getX() + 7);
/* 114 */     yPoint[3] = (getY() + getHeight());
/*     */     
/* 116 */     Graphics2D g2d = g;
/* 117 */     if (isClDegradee()) g2d.setPaint(new GradientPaint(getX(), getY(), getClFond(), getX() + getWeidth() + 8, getY() + getHeight(), Color.WHITE, true));
/* 118 */     g.fillPolygon(xPoint, yPoint, 4);
/*     */     
/* 120 */     g.setColor(Color.GRAY);
/* 121 */     g.fillOval(getX() + getWeidth() / 2, getY(), 10, 10);
/*     */     
/* 123 */     g.setColor(getClPunaise());
/* 124 */     g.fillOval(getX() + getWeidth() / 2 + 3, getY() + 2, 6, 6);
/* 125 */     g.fillOval(getX() + getWeidth() / 2 + 7, getY(), 10, 10);
/*     */   }
/*     */   
/*     */   private void dessinerSelect(Graphics2D g)
/*     */   {
/* 130 */     int[] xPoint = { 0, 0, 0, 0 };
/* 131 */     int[] yPoint = { 0, 0, 0, 0 };
/* 132 */     xPoint[0] = (getX() - 1);
/* 133 */     yPoint[0] = (getY() - 1);
/*     */     
/* 135 */     xPoint[1] = (getX() + getWeidth() + 4);
/* 136 */     yPoint[1] = (getY() - 1);
/*     */     
/* 138 */     xPoint[2] = (getX() + getWeidth() + 9);
/* 139 */     yPoint[2] = (getY() + getHeight());
/*     */     
/* 141 */     xPoint[3] = (getX() + 8);
/* 142 */     yPoint[3] = (getY() + getHeight());
/* 143 */     g.drawPolygon(xPoint, yPoint, 4);
/*     */   }
/*     */   
/*     */   private void dessinerString(Graphics2D g, String str, int y)
/*     */   {
/* 148 */     if (getAligner().equals("CENTRE")) {
/* 149 */       int w = g.getFontMetrics().stringWidth(str);
/* 150 */       g.drawString(str, getX() + (getWidth() - w) / 2, y);
/*     */     }
/*     */     
/* 153 */     if (getAligner().equals("DROITE")) {
/* 154 */       int w = g.getFontMetrics().stringWidth(str);
/* 155 */       g.drawString(str, getX() - 5 + getWidth() - w, y);
/*     */     }
/* 157 */     if (getAligner().equals("GAUCHE")) {
/* 158 */       g.drawString(str, getX() + 12, y);
/*     */     }
/*     */   }
/*     */   
/*     */   private void ecrireCommentaire(Graphics2D g) {
/* 163 */     Font f = g.getFont();
/* 164 */     String str = getCommentaire();
/* 165 */     int indD = 0;
/* 166 */     int h = (int)(g.getFontMetrics().getHeight() * 1.25D);
/* 167 */     int y = getY() + h + 10;
/*     */     
/* 169 */     int indF = str.indexOf("\n");
/* 170 */     if (str.length() == 0) { return;
/*     */     }
/* 172 */     g.setFont(this.font);
/* 173 */     g.setColor(getClTexte());
/* 174 */     while (indF != -1) {
/* 175 */       String subStr = str.substring(indD, indF);
/* 176 */       dessinerString(g, subStr, y);
/* 177 */       str = str.substring(indF + 1, str.length());
/* 178 */       indF = str.indexOf("\n");
/* 179 */       y += h;
/*     */     }
/* 181 */     if (str.length() > 0) {
/* 182 */       dessinerString(g, str, y);
/*     */     }
/*     */     
/* 185 */     g.setFont(f);
/*     */   }
/*     */   
/*     */   private int getHeightComm(Graphics2D g, String str)
/*     */   {
/* 190 */     int h = g.getFontMetrics().getHeight();
/* 191 */     int nbLig = 0;
/*     */     
/* 193 */     if (str.length() > 0) { nbLig = 1;
/*     */     }
/* 195 */     while (str.indexOf("\n") != -1) {
/* 196 */       nbLig++;
/* 197 */       str = str.substring(str.indexOf("\n") + 1, str.length());
/*     */     }
/* 199 */     return (int)(nbLig * (h * 1.25D)) + h / 2 + 10;
/*     */   }
/*     */   
/*     */   private int getWidthComm(Graphics2D g, String str) {
/* 203 */     int wDec = g.getFontMetrics().stringWidth("ME");
/* 204 */     int wMax = 0;
/*     */     
/*     */ 
/*     */ 
/* 208 */     int indD = 0;
/* 209 */     int indF = str.indexOf("\n");
/* 210 */     while (indF != -1) {
/* 211 */       String strW = str.substring(indD, indF);
/* 212 */       int wStr = g.getFontMetrics().stringWidth(strW);
/* 213 */       if (wStr > wMax) {
/* 214 */         wMax = wStr;
/*     */       }
/* 216 */       str = str.substring(indF + 1, str.length());
/* 217 */       indF = str.indexOf("\n");
/*     */     }
/* 219 */     if (str.length() > 0) {
/* 220 */       String strW = str.substring(indD, str.length());
/* 221 */       int wStr = g.getFontMetrics().stringWidth(strW);
/* 222 */       if (wStr > wMax) {
/* 223 */         wMax = wStr;
/*     */       }
/*     */     }
/* 226 */     wMax += wDec;
/* 227 */     return wMax;
/*     */   }
/*     */   
/*     */   private void ajusterLaTaille(Graphics2D g)
/*     */   {
/* 232 */     int w = getWidthComm(g, getCommentaire());
/* 233 */     int h = getHeightComm(g, getCommentaire());
/* 234 */     setHeight(h);
/* 235 */     setWidth(w);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Color getClPunaise()
/*     */   {
/* 243 */     return this.clPunaise;
/*     */   }
/*     */   
/*     */   public Color getClSelected() {
/* 247 */     return this.clSelected;
/*     */   }
/*     */   
/*     */   public String getAligner() {
/* 251 */     return this.aligner;
/*     */   }
/*     */   
/*     */   public boolean isActiver() {
/* 255 */     return this.activer;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 259 */     return this.code;
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 263 */     return this.font;
/*     */   }
/*     */   
/*     */   public Font getFontGras() {
/* 267 */     return this.fontGras;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/* 271 */     return this.historique;
/*     */   }
/*     */   
/*     */   public double getZoom() {
/* 275 */     return this.zoom;
/*     */   }
/*     */   
/*     */   public String getIdentifiant() {
/* 279 */     return this.identifiant;
/*     */   }
/*     */   
/*     */   public void setActiver(boolean activer) {
/* 283 */     this.activer = activer;
/*     */   }
/*     */   
/*     */   public void setAligner(String aligner) {
/* 287 */     this.aligner = aligner;
/*     */   }
/*     */   
/*     */   public void setClPunaise(Color clPunaise) {
/* 291 */     this.clPunaise = clPunaise;
/*     */   }
/*     */   
/*     */   public void setClSelected(Color clSelected) {
/* 295 */     this.clSelected = clSelected;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 299 */     this.code = code;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 303 */     this.font = font;
/*     */   }
/*     */   
/*     */   public void setFontGras(Font fontGras) {
/* 307 */     this.fontGras = fontGras;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/* 311 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public void setZoom(double zoom) {
/* 315 */     this.zoom = zoom;
/*     */   }
/*     */   
/*     */   public void setIdentifiant(String identifiant) {
/* 319 */     this.identifiant = identifiant;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setHight(int hight)
/*     */   {
/* 325 */     super.setHight(hight);
/* 326 */     super.setHeight(hight);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWidth(int weidth)
/*     */   {
/* 333 */     super.setWeidth(weidth);
/* 334 */     super.setWidth(weidth);
/*     */   }
/*     */   
/*     */   public void ajouterCopier(ArrayList<Historique> lhis) {
/* 338 */     Historique h = Historique.getHistoriqueCopie();
/* 339 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/* 340 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*     */     {
/* 342 */       lhis.add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/* 347 */     ArrayList<Historique> l = new ArrayList();
/* 348 */     for (int i = 0; i < lhis.size(); i++) {
/* 349 */       l.add(((Historique)lhis.get(i)).copier());
/*     */     }
/* 351 */     return l;
/*     */   }
/*     */   
/*     */   public IhmPostIt2 copier()
/*     */   {
/* 356 */     IhmPostIt2 p = new IhmPostIt2(getCommentaire(), getX() + 5, getY() + 5, getWeidth(), getHight());
/* 357 */     p.setCode(getCode());
/* 358 */     p.setCommentaire(getCommentaire());
/* 359 */     p.setClCadre(getClCadre());
/* 360 */     p.setClDegradee(isClDegradee());
/* 361 */     p.setClFond(getClFond());
/* 362 */     p.setClPunaise(getClPunaise());
/* 363 */     p.setClTexte(getClTexte());
/* 364 */     p.setClSelected(getClSelected());
/* 365 */     p.setOmbre(isOmbre());
/* 366 */     p.setAligner(getAligner());
/* 367 */     p.setHistorique(copierHistoriques(getHistorique()));
/* 368 */     ajouterCopier(p.getHistorique());
/* 369 */     return p;
/*     */   }
/*     */   
/*     */   public static IhmPostIt2 parsePostIt(IhmPostIt post) {
/* 373 */     IhmPostIt2 p = new IhmPostIt2(post.getCommentaire(), post.getX(), post.getY(), post.getWeidth(), post.getHight());
/*     */     
/* 375 */     p.setCommentaire(post.getCommentaire());
/* 376 */     p.setClCadre(post.getClCadre());
/* 377 */     p.setClDegradee(post.isClDegradee());
/* 378 */     p.setClFond(post.getClFond());
/* 379 */     p.setClPunaise(post.getClCadre());
/* 380 */     p.setClTexte(post.getClTexte());
/* 381 */     p.setOmbre(post.isOmbre());
/* 382 */     return p;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmPostIt2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */