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
/*     */ public class IhmCommentaire2
/*     */   extends IhmCommentaireIndip
/*     */   implements Serializable
/*     */ {
/*     */   String code;
/*     */   String aligner;
/*     */   double zoom;
/*     */   Font font;
/*     */   Font fontGras;
/*     */   Color clSelected;
/*     */   public Color clActiver;
/*     */   public boolean activer;
/*     */   ArrayList<Historique> historique;
/*     */   Color clOmbre;
/*     */   
/*     */   public IhmCommentaire2(String Commentaire, int x, int y, int weidth, int hight)
/*     */   {
/*  41 */     super(Commentaire, x, y, weidth, hight);
/*  42 */     this.code = "";
/*  43 */     this.activer = false;
/*  44 */     this.clActiver = Color.GRAY;
/*     */     
/*  46 */     this.aligner = FormeInterneMCD.alignerCommentaire;
/*     */     
/*  48 */     this.font = Parametres.fontNormal;
/*  49 */     this.fontGras = Parametres.fontGras;
/*     */     
/*  51 */     setClCadre(FormeInterneMCD.clCommentaireCadre2);
/*  52 */     setClFond(FormeInterneMCD.clCommentaireFond2);
/*  53 */     setClTexte(FormeInterneMCD.clCommentaireText2);
/*  54 */     this.clSelected = FormeInterneMCD.clSelected;
/*     */     
/*  56 */     setOmbre(FormeInterneMCD.isOmbrePage());
/*  57 */     setClDegradee(FormeInterneMCD.isClDegradeePage());
/*  58 */     this.historique = new ArrayList();
/*  59 */     this.historique.add(Historique.getHistoriqueCreation());
/*  60 */     this.clOmbre = FormeInterneMCD.clOmbre2;
/*  61 */     setOmbre(FormeInterneMCD.isOmbree2);
/*  62 */     setClDegradee(FormeInterneMCD.isDegradee2);
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  67 */     Graphics2D g2d = (Graphics2D)g;
/*  68 */     ajusterLaTaille(g2d);
/*  69 */     if (isOmbre()) dessinerOmbre(g2d);
/*  70 */     dessinerCadreFond(g2d);
/*  71 */     dessinerCommentaire(g2d);
/*  72 */     if (isSelected()) dessinerSelected(g2d);
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics2D g) {
/*  76 */     g.setColor(this.clOmbre);
/*  77 */     g.fillRect(getX() + 2, getY() + 2, getWidth() + 1, getHeight() + 1);
/*     */   }
/*     */   
/*     */   private void dessinerCadreFond(Graphics2D g) {
/*  81 */     g.setColor(getClFond());
/*  82 */     if (isClDegradee()) { g.setPaint(new GradientPaint(getX(), getY(), getClFond(), getX() + getWeidth(), getY() + getHeight(), Color.WHITE, true));
/*     */     }
/*  84 */     g.fillRect(getX(), getY(), getWidth(), getHeight());
/*  85 */     g.setColor(getClCadre());
/*  86 */     g.drawRect(getX(), getY(), getWidth(), getHeight());
/*     */   }
/*     */   
/*     */   private void dessinerSelected(Graphics2D g) {
/*  90 */     Color clgard = g.getColor();
/*  91 */     g.setColor(this.clSelected);
/*  92 */     g.drawRect(getX(), getY(), getWidth(), getHeight());
/*     */     
/*  94 */     g.setColor(Color.BLACK);
/*  95 */     g.fillRect(getX() - 1, getY() - 1, 4, 4);
/*  96 */     g.fillRect(getX() - 1, getY() - 2 + getHeight(), 4, 4);
/*  97 */     g.fillRect(getX() - 1 + getWidth(), getY() - 1, 4, 4);
/*  98 */     g.fillRect(getX() - 1 + getWidth(), getY() - 2 + getHeight(), 4, 4);
/*     */     
/* 100 */     g.fillRect(getCentreX() - 1, getY() + getHeight() - 1, 4, 4);
/* 101 */     g.fillRect(getCentreX() - 1, getY() - 1, 4, 4);
/*     */     
/* 103 */     g.fillRect(getX() - 1, getCentreY(), 4, 4);
/* 104 */     g.fillRect(getX() + getWidth() - 1, getCentreY(), 4, 4);
/*     */     
/* 106 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */ 
/*     */   private int getHeightComm(Graphics2D g, String str)
/*     */   {
/* 112 */     int h = g.getFontMetrics().getHeight();
/* 113 */     int nbLig = 0;
/*     */     
/* 115 */     if (str.length() > 0) { nbLig = 1;
/*     */     }
/* 117 */     while (str.indexOf("\n") != -1) {
/* 118 */       nbLig++;
/* 119 */       str = str.substring(str.indexOf("\n") + 1, str.length());
/*     */     }
/* 121 */     return (int)(nbLig * (h * 1.25D)) + h / 2;
/*     */   }
/*     */   
/*     */   private int getWidthComm(Graphics2D g, String str) {
/* 125 */     int wDec = g.getFontMetrics().stringWidth("ME");
/* 126 */     int wMax = 0;
/*     */     
/*     */ 
/*     */ 
/* 130 */     int indD = 0;
/* 131 */     int indF = str.indexOf("\n");
/* 132 */     while (indF != -1) {
/* 133 */       String strW = str.substring(indD, indF);
/* 134 */       int wStr = g.getFontMetrics().stringWidth(strW);
/* 135 */       if (wStr > wMax) {
/* 136 */         wMax = wStr;
/*     */       }
/* 138 */       str = str.substring(indF + 1, str.length());
/* 139 */       indF = str.indexOf("\n");
/*     */     }
/* 141 */     if (str.length() > 0) {
/* 142 */       String strW = str.substring(indD, str.length());
/* 143 */       int wStr = g.getFontMetrics().stringWidth(strW);
/* 144 */       if (wStr > wMax) {
/* 145 */         wMax = wStr;
/*     */       }
/*     */     }
/* 148 */     wMax += wDec;
/* 149 */     return wMax;
/*     */   }
/*     */   
/*     */   private void ajusterLaTaille(Graphics2D g) {
/* 153 */     int w = getWidthComm(g, getCommentaire());
/* 154 */     int h = getHeightComm(g, getCommentaire());
/* 155 */     setHeight(h);
/* 156 */     setWidth(w);
/*     */   }
/*     */   
/*     */   private void dessinerString(Graphics2D g, String str, int y) {
/* 160 */     if (getAligner().equals("CENTRE")) {
/* 161 */       int w = g.getFontMetrics().stringWidth(str);
/* 162 */       g.drawString(str, getX() + (getWidth() - w) / 2, y);
/*     */     }
/*     */     
/* 165 */     if (getAligner().equals("DROITE")) {
/* 166 */       int w = g.getFontMetrics().stringWidth(str);
/* 167 */       g.drawString(str, getX() - 5 + getWidth() - w, y);
/*     */     }
/* 169 */     if (getAligner().equals("GAUCHE")) {
/* 170 */       g.drawString(str, getX() + 5, y);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerCommentaire(Graphics2D g) {
/* 175 */     Font f = g.getFont();
/* 176 */     String str = getCommentaire();
/* 177 */     int indD = 0;
/* 178 */     int h = (int)(g.getFontMetrics().getHeight() * 1.25D);
/* 179 */     int y = getY() + h;
/*     */     
/* 181 */     int indF = str.indexOf("\n");
/* 182 */     if (str.length() == 0) { return;
/*     */     }
/* 184 */     g.setFont(this.font);
/* 185 */     g.setColor(getClTexte());
/* 186 */     while (indF != -1) {
/* 187 */       String subStr = str.substring(indD, indF);
/* 188 */       dessinerString(g, subStr, y);
/* 189 */       str = str.substring(indF + 1, str.length());
/* 190 */       indF = str.indexOf("\n");
/* 191 */       y += h;
/*     */     }
/* 193 */     if (str.length() > 0) {
/* 194 */       dessinerString(g, str, y);
/*     */     }
/*     */     
/* 197 */     g.setFont(f);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHight(int hight)
/*     */   {
/* 204 */     super.setHight(hight);
/* 205 */     super.setHeight(hight);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWidth(int weidth)
/*     */   {
/* 216 */     super.setWeidth(weidth);
/* 217 */     super.setWidth(weidth);
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 221 */     return this.font;
/*     */   }
/*     */   
/*     */   public Color getClOmbre() {
/* 225 */     return this.clOmbre;
/*     */   }
/*     */   
/*     */   public Font getFontGras() {
/* 229 */     return this.fontGras;
/*     */   }
/*     */   
/*     */   public String getAligner() {
/* 233 */     return this.aligner;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 237 */     return this.code;
/*     */   }
/*     */   
/*     */   public boolean isActiver() {
/* 241 */     return this.activer;
/*     */   }
/*     */   
/*     */   public Color getClActiver() {
/* 245 */     return this.clActiver;
/*     */   }
/*     */   
/*     */   public Color getClSelected() {
/* 249 */     return this.clSelected;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/* 253 */     return this.historique;
/*     */   }
/*     */   
/*     */   public double getZoom() {
/* 257 */     return this.zoom;
/*     */   }
/*     */   
/*     */   public void setAligner(String aligne) {
/* 261 */     this.aligner = aligne;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 265 */     this.code = code;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/* 269 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public void setZoom(double zoom) {
/* 273 */     this.zoom = zoom;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 277 */     this.font = font;
/*     */   }
/*     */   
/*     */   public void setFontGras(Font fontGras) {
/* 281 */     this.fontGras = fontGras;
/*     */   }
/*     */   
/*     */   public void setActiver(boolean activer) {
/* 285 */     this.activer = activer;
/*     */   }
/*     */   
/*     */   public void setClActiver(Color clActiver) {
/* 289 */     this.clActiver = clActiver;
/*     */   }
/*     */   
/*     */   public void setClSelected(Color clSelected) {
/* 293 */     this.clSelected = clSelected;
/*     */   }
/*     */   
/*     */   public void setClOmbre(Color clOmbre) {
/* 297 */     this.clOmbre = clOmbre;
/*     */   }
/*     */   
/*     */   public void ajouterCopier(ArrayList<Historique> lhis) {
/* 301 */     Historique h = Historique.getHistoriqueCopie();
/* 302 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/* 303 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*     */     {
/* 305 */       lhis.add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public static IhmCommentaire2 parseCommenataire(IhmCommentaireIndip com) {
/* 310 */     if ((com instanceof IhmPostIt)) return null;
/* 311 */     IhmCommentaire2 c = new IhmCommentaire2(com.getCommentaire(), com.getX(), com.getY(), com.getWidth(), com.getHeight());
/* 312 */     c.setCode("");
/* 313 */     c.setClCadre(com.getClCadre());
/* 314 */     c.setClFond(com.getClFond());
/* 315 */     c.setClTexte(com.getClTexte());
/*     */     
/* 317 */     return c;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmCommentaire2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */