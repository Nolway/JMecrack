/*     */ package IhmMCD;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.GradientPaint;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmCommentaireIndip
/*     */   extends IhmEntiteRelation
/*     */   implements Serializable
/*     */ {
/*     */   private String commentaire;
/*     */   private int hight;
/*     */   private int weidth;
/*     */   private Color clFond;
/*     */   private Color clCadre;
/*     */   private Color clTexte;
/*     */   private String clFondSt;
/*     */   private String clCadreSt;
/*     */   private String clTexteSt;
/*     */   
/*     */   public IhmCommentaireIndip(String Commentaire, int x, int y, int weidth, int hight)
/*     */   {
/*  33 */     super(x, y, weidth, hight, true);
/*  34 */     this.commentaire = Commentaire;
/*     */     
/*     */ 
/*  37 */     this.hight = hight;
/*  38 */     this.weidth = weidth;
/*     */     
/*  40 */     this.clFond = Color.WHITE;
/*  41 */     this.clCadre = Color.WHITE;
/*  42 */     this.clTexte = Color.BLACK;
/*     */     
/*  44 */     this.clFondSt = getColeurString(this.clFond);
/*  45 */     this.clCadreSt = getColeurString(this.clCadre);
/*  46 */     this.clTexteSt = getColeurString(this.clTexte);
/*     */     
/*  48 */     if (this.commentaire.trim().length() == 0) this.commentaire = "Votre commentaire ici";
/*  49 */     setSelected(true);
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  54 */     adapterTaille(g, getCommentaire());
/*  55 */     if (isOmbre()) dessinerOmbre(g);
/*  56 */     g.setColor(this.clFond);
/*  57 */     Graphics2D g2d = (Graphics2D)g;
/*  58 */     if (isClDegradee()) g2d.setPaint(new GradientPaint(getX(), getY(), this.clFond, getX() + getWeidth(), getY() + getHeight(), Color.WHITE, true));
/*  59 */     g.fillRect(getX(), getY(), getWeidth(), getHeight());
/*  60 */     g.setColor(this.clCadre);
/*  61 */     g.drawRect(getX(), getY(), getWeidth(), getHeight());
/*  62 */     g.setColor(Color.WHITE);
/*  63 */     g.drawRect(getX() + getWeidth() - 5, getY() - 1, 6, 4);
/*  64 */     g.setColor(this.clCadre);
/*  65 */     g.drawLine(getX() + getWeidth() - 5, getY(), getX() + getWeidth() - 5, getY() + 5);
/*  66 */     g.drawLine(getX() + getWeidth() - 5, getY() + 5, getX() + getWeidth(), getY() + 5);
/*  67 */     ecrireCommentaire(g);
/*  68 */     if (isSelected() == true)
/*     */     {
/*  70 */       g.setColor(Color.red);
/*  71 */       g.drawRect(getX(), getY(), getWeidth(), getHeight());
/*  72 */       ecrireCommentaire(g);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics g) {
/*  77 */     Color clgard = g.getColor();
/*  78 */     g.setColor(Color.GRAY);
/*  79 */     g.fillRect(getX() + Parametres.retournerVal(g, 2), getY() + Parametres.retournerVal(g, 7), getWeidth() + Parametres.retournerVal(g, 2), getHeight() - Parametres.retournerVal(g, 4));
/*  80 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private void ecrireCommentaire(Graphics g) {
/*  84 */     int h = g.getFontMetrics().getHeight();
/*  85 */     int index = 0;
/*  86 */     int ligne = getY() + h;
/*     */     
/*  88 */     g.setColor(this.clTexte);
/*  89 */     String str = getCommentaire();
/*  90 */     if (getCommentaire().indexOf("\n") == -1) {
/*  91 */       g.drawString(getCommentaire(), getX() + (getWeidth() - g.getFontMetrics().stringWidth(getCommentaire())) / 2, ligne);
/*     */     } else {
/*  93 */       while (str.indexOf("\n") != -1) {
/*  94 */         String strLigne = str.substring(0, str.indexOf("\n"));
/*  95 */         index = str.indexOf("\n") + 1;
/*  96 */         str = str.substring(index, str.length());
/*  97 */         g.drawString(strLigne, getX() + (getWeidth() - g.getFontMetrics().stringWidth(strLigne)) / 2, ligne);
/*  98 */         ligne += h;
/*  99 */         if ((str.indexOf("\n") == -1) && 
/* 100 */           (str.trim().length() != 0)) {
/* 101 */           g.drawString(str, getX() + (getWeidth() - g.getFontMetrics().stringWidth(str)) / 2, ligne);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private Color getCouleurs(String cl)
/*     */   {
/* 109 */     return new Color(Integer.parseInt(cl));
/*     */   }
/*     */   
/*     */   public void initialiserCouleur() {
/* 113 */     setClCadre(getCouleurs(getClCadreSt()));
/* 114 */     setClFond(getCouleurs(getClFondSt()));
/* 115 */     setClTexte(getCouleurs(getClTexteSt()));
/*     */   }
/*     */   
/*     */   private String getColeurString(Color cl) {
/* 119 */     return cl.getRGB() + "";
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/* 123 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public int getHight() {
/* 127 */     return this.hight;
/*     */   }
/*     */   
/*     */   public int getWeidth() {
/* 131 */     return this.weidth;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String Commentaire) {
/* 135 */     this.commentaire = Commentaire;
/*     */   }
/*     */   
/*     */   public void setHight(int hight) {
/* 139 */     this.hight = hight;
/* 140 */     super.setHeight(hight);
/*     */   }
/*     */   
/*     */   public void setWeidth(int weidth) {
/* 144 */     this.weidth = weidth;
/* 145 */     super.setWidth(weidth);
/*     */   }
/*     */   
/*     */   public Color getClCadre() {
/* 149 */     return this.clCadre;
/*     */   }
/*     */   
/*     */   public Color getClFond() {
/* 153 */     return this.clFond;
/*     */   }
/*     */   
/*     */   public Color getClTexte() {
/* 157 */     return this.clTexte;
/*     */   }
/*     */   
/*     */   public String getClCadreSt() {
/* 161 */     return this.clCadreSt;
/*     */   }
/*     */   
/*     */   public String getClFondSt() {
/* 165 */     return this.clFondSt;
/*     */   }
/*     */   
/*     */   public String getClTexteSt() {
/* 169 */     return this.clTexteSt;
/*     */   }
/*     */   
/*     */   public void setClCadre(Color clCadre) {
/* 173 */     setClCadreSt(getColeurString(clCadre));
/* 174 */     this.clCadre = clCadre;
/*     */   }
/*     */   
/*     */   public void setClFond(Color clFond) {
/* 178 */     setClFondSt(getColeurString(clFond));
/* 179 */     this.clFond = clFond;
/*     */   }
/*     */   
/*     */   public void setClTexte(Color clTexte) {
/* 183 */     setClTexteSt(getColeurString(clTexte));
/* 184 */     this.clTexte = clTexte;
/*     */   }
/*     */   
/*     */   public void setClCadreSt(String clCadreSt) {
/* 188 */     this.clCadreSt = clCadreSt;
/*     */   }
/*     */   
/*     */   public void setClFondSt(String clFondSt) {
/* 192 */     this.clFondSt = clFondSt;
/*     */   }
/*     */   
/*     */   public void setClTexteSt(String clTexteSt) {
/* 196 */     this.clTexteSt = clTexteSt;
/*     */   }
/*     */   
/*     */   public IhmCommentaireIndip copier() {
/* 200 */     return new IhmCommentaireIndip(getCommentaire(), getX(), getY(), getWeidth(), getHeight());
/*     */   }
/*     */   
/*     */   public void adapterTaille(Graphics g, String str)
/*     */   {
/* 205 */     int h = g.getFontMetrics().getHeight();
/* 206 */     int ww = g.getFontMetrics().stringWidth("MESS");
/* 207 */     int wMax = 0;int hMax = h / 2;int index = 0;
/* 208 */     if (str.indexOf("\n") == -1) {
/* 209 */       setWeidth(g.getFontMetrics().stringWidth(str) + 40);
/* 210 */       setHight(h * 2);
/*     */     } else {
/* 212 */       while (str.indexOf("\n") != -1) {
/* 213 */         hMax += h;
/* 214 */         String strLigne = str.substring(0, str.indexOf("\n"));
/* 215 */         index = str.indexOf("\n") + 1;
/* 216 */         str = str.substring(index, str.length());
/*     */         
/* 218 */         if ((str.indexOf("\n") == -1) && 
/* 219 */           (str.trim().length() != 0)) {
/* 220 */           strLigne = str;
/* 221 */           hMax += h;
/* 222 */           if (wMax < g.getFontMetrics().stringWidth(strLigne) + ww) {
/* 223 */             wMax = g.getFontMetrics().stringWidth(strLigne) + ww;
/*     */           }
/*     */         }
/*     */         
/* 227 */         if (wMax < g.getFontMetrics().stringWidth(strLigne) + ww) {
/* 228 */           wMax = g.getFontMetrics().stringWidth(strLigne) + ww;
/*     */         }
/*     */       }
/* 231 */       setWeidth(wMax);
/* 232 */       setHight(hMax);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmCommentaireIndip.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */