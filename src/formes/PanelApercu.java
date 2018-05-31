/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.Grid;
/*     */ import Outil.Setting;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import javax.swing.JPanel;
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
/*     */ public class PanelApercu
/*     */   extends JPanel
/*     */ {
/*     */   private Color clEntiteCadre;
/*     */   private Color clEntiteFond;
/*     */   private Color clEntiteText;
/*     */   private Color clRelationCadre;
/*     */   private Color clRelationFond;
/*     */   private Color clRelationText;
/*     */   private Color clCIFCadre;
/*     */   private Color clCIFFond;
/*     */   private Color clCIFText;
/*     */   private Color clContrainteCadre;
/*     */   private Color clContrainteFond;
/*     */   private Color clContrainteText;
/*     */   private Color clLien;
/*     */   private Color clLienCnt;
/*     */   private Color clString;
/*     */   private boolean grille;
/*     */   
/*     */   public PanelApercu(Color clEntiteCadre, Color clEntiteFond, Color clEntiteText, Color clRelationCadre, Color clRelationFond, Color clRelationText, Color clCIFCadre, Color clCIFFond, Color clCIFText, Color clContrainteCadre, Color clContrainteFond, Color clContrainteText, Color clLien, Color clLienCnt, Color clString, boolean grille)
/*     */   {
/*  44 */     this.clEntiteCadre = clEntiteCadre;
/*  45 */     this.clEntiteFond = clEntiteFond;
/*  46 */     this.clEntiteText = clEntiteText;
/*  47 */     this.clRelationCadre = clRelationCadre;
/*  48 */     this.clRelationFond = clRelationFond;
/*  49 */     this.clRelationText = clRelationText;
/*  50 */     this.clCIFCadre = clCIFCadre;
/*  51 */     this.clCIFFond = clCIFFond;
/*  52 */     this.clCIFText = clCIFText;
/*  53 */     this.clContrainteCadre = clContrainteCadre;
/*  54 */     this.clContrainteFond = clContrainteFond;
/*  55 */     this.clContrainteText = clContrainteText;
/*  56 */     this.clLien = clLien;
/*  57 */     this.clLienCnt = clLienCnt;
/*  58 */     this.clString = clString;
/*  59 */     this.grille = grille;
/*  60 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */   public Color getClCIFCadre()
/*     */   {
/*  66 */     return this.clCIFCadre;
/*     */   }
/*     */   
/*     */   public Color getClCIFFond() {
/*  70 */     return this.clCIFFond;
/*     */   }
/*     */   
/*     */   public Color getClCIFText() {
/*  74 */     return this.clCIFText;
/*     */   }
/*     */   
/*     */   public Color getClContrainteCadre() {
/*  78 */     return this.clContrainteCadre;
/*     */   }
/*     */   
/*     */   public Color getClContrainteFond() {
/*  82 */     return this.clContrainteFond;
/*     */   }
/*     */   
/*     */   public Color getClContrainteText() {
/*  86 */     return this.clContrainteText;
/*     */   }
/*     */   
/*     */   public Color getClEntiteCadre() {
/*  90 */     return this.clEntiteCadre;
/*     */   }
/*     */   
/*     */   public Color getClEntiteFond() {
/*  94 */     return this.clEntiteFond;
/*     */   }
/*     */   
/*     */   public Color getClEntiteText() {
/*  98 */     return this.clEntiteText;
/*     */   }
/*     */   
/*     */   public Color getClLien() {
/* 102 */     return this.clLien;
/*     */   }
/*     */   
/*     */   public Color getClLienCnt() {
/* 106 */     return this.clLienCnt;
/*     */   }
/*     */   
/*     */   public Color getClRelationCadre() {
/* 110 */     return this.clRelationCadre;
/*     */   }
/*     */   
/*     */   public Color getClRelationFond() {
/* 114 */     return this.clRelationFond;
/*     */   }
/*     */   
/*     */   public Color getClRelationText() {
/* 118 */     return this.clRelationText;
/*     */   }
/*     */   
/*     */   public Color getClString() {
/* 122 */     return this.clString;
/*     */   }
/*     */   
/*     */   public void setClCIFCadre(Color clCIFCadre) {
/* 126 */     this.clCIFCadre = clCIFCadre;
/*     */   }
/*     */   
/*     */   public void setClCIFFond(Color clCIFFond) {
/* 130 */     this.clCIFFond = clCIFFond;
/*     */   }
/*     */   
/*     */   public void setClCIFText(Color clCIFText) {
/* 134 */     this.clCIFText = clCIFText;
/*     */   }
/*     */   
/*     */   public void setClContrainteCadre(Color clContrainteCadre) {
/* 138 */     this.clContrainteCadre = clContrainteCadre;
/*     */   }
/*     */   
/*     */   public void setClContrainteFond(Color clContrainteFond) {
/* 142 */     this.clContrainteFond = clContrainteFond;
/*     */   }
/*     */   
/*     */   public void setClContrainteText(Color clContrainteText) {
/* 146 */     this.clContrainteText = clContrainteText;
/*     */   }
/*     */   
/*     */   public void setClEntiteCadre(Color clEntiteCadre) {
/* 150 */     this.clEntiteCadre = clEntiteCadre;
/*     */   }
/*     */   
/*     */   public void setClEntiteFond(Color clEntiteFond) {
/* 154 */     this.clEntiteFond = clEntiteFond;
/*     */   }
/*     */   
/*     */   public void setClEntiteText(Color clEntiteText) {
/* 158 */     this.clEntiteText = clEntiteText;
/*     */   }
/*     */   
/*     */   public void setClLien(Color clLien) {
/* 162 */     this.clLien = clLien;
/*     */   }
/*     */   
/*     */   public void setClLienCnt(Color clLienCnt) {
/* 166 */     this.clLienCnt = clLienCnt;
/*     */   }
/*     */   
/*     */   public void setClRelationCadre(Color clRelationCadre) {
/* 170 */     this.clRelationCadre = clRelationCadre;
/*     */   }
/*     */   
/*     */   public void setClRelationFond(Color clRelationFond) {
/* 174 */     this.clRelationFond = clRelationFond;
/*     */   }
/*     */   
/*     */   public void setClRelationText(Color clRelationText) {
/* 178 */     this.clRelationText = clRelationText;
/*     */   }
/*     */   
/*     */   public void setClString(Color clString) {
/* 182 */     this.clString = clString;
/*     */   }
/*     */   
/*     */   private void dessinerEntite(Graphics g) {
/* 186 */     int x = 15;int y = 30;int h = 50;int w = 50;
/*     */     
/* 188 */     g.setColor(this.clEntiteFond);
/* 189 */     g.fillRect(x, y, w, h);
/* 190 */     g.setColor(this.clEntiteCadre);
/* 191 */     g.drawRect(x, y, w, h);
/* 192 */     g.drawLine(x, y + 20, x + w, y + 20);
/* 193 */     g.setColor(this.clEntiteText);
/* 194 */     g.drawString("entite", x + 3, y + 20 - 5);
/*     */     
/* 196 */     x = 170;
/* 197 */     y = 30;
/*     */     
/* 199 */     g.setColor(this.clEntiteFond);
/* 200 */     g.fillRect(x, y, w, h);
/* 201 */     g.setColor(this.clEntiteCadre);
/* 202 */     g.drawRect(x, y, w, h);
/* 203 */     g.drawLine(x, y + 20, x + w, y + 20);
/* 204 */     g.setColor(this.clEntiteText);
/* 205 */     g.drawString("entite", x + 3, y + 20 - 5);
/*     */   }
/*     */   
/*     */   private void dessinerRelation(Graphics g) {
/* 209 */     int x = 80;int y = 20;int h = 40;int w = 70;
/* 210 */     g.setColor(this.clRelationFond);
/* 211 */     g.fillOval(x, y, w, h);
/* 212 */     g.setColor(this.clRelationCadre);
/* 213 */     g.drawOval(x, y, w, h);
/* 214 */     g.drawLine(x, y + h / 2, x + w, y + h / 2);
/*     */     
/* 216 */     g.setColor(this.clRelationText);
/* 217 */     g.drawString("relation", x + 13, y + h / 2 - 5);
/*     */     
/* 219 */     x = 80;y = 90;
/*     */     
/* 221 */     g.setColor(this.clRelationFond);
/* 222 */     g.fillOval(x, y, w, h);
/* 223 */     g.setColor(this.clRelationCadre);
/* 224 */     g.drawOval(x, y, w, h);
/* 225 */     g.drawLine(x, y + h / 2, x + w, y + h / 2);
/*     */     
/* 227 */     g.setColor(this.clRelationText);
/* 228 */     g.drawString("relation", x + 13, y + h / 2 - 5);
/*     */   }
/*     */   
/*     */   private void dessinerLien(Graphics g)
/*     */   {
/* 233 */     int x = 40;int y = 40;int h = 40;int w = 70;
/* 234 */     g.setColor(this.clLien);
/* 235 */     g.drawLine(x, y, 90, y);
/* 236 */     g.drawLine(80, y, 180, y);
/*     */     
/* 238 */     x = 65;y = 80;
/* 239 */     g.setColor(this.clLien);
/* 240 */     g.drawLine(x, y, 80, 110);
/* 241 */     g.drawLine(170, 80, 150, 110);
/*     */   }
/*     */   
/*     */   private void dessinerContrainte(Graphics g)
/*     */   {
/* 246 */     g.setColor(this.clLienCnt);
/* 247 */     g.drawLine(82, 74, 105, 60);
/* 248 */     g.drawLine(82, 85, 105, 90);
/*     */     
/* 250 */     g.setColor(this.clContrainteFond);
/* 251 */     g.fillOval(75, 70, 15, 15);
/* 252 */     g.setColor(this.clContrainteCadre);
/* 253 */     g.drawOval(75, 70, 15, 15);
/* 254 */     g.setColor(this.clContrainteText);
/* 255 */     g.drawString("=", 80, 80);
/*     */   }
/*     */   
/*     */ 
/*     */   private void dessinerCIF(Graphics g)
/*     */   {
/* 261 */     g.setColor(this.clLienCnt);
/* 262 */     g.drawLine(40, 80, 40, 150);
/* 263 */     g.drawLine(40, 150, 190, 150);
/*     */     
/* 265 */     g.drawLine(195, 80, 195, 150);
/*     */     
/*     */ 
/* 268 */     g.setColor(this.clCIFFond);
/* 269 */     g.fillOval(185, 140, 25, 20);
/* 270 */     g.setColor(this.clCIFCadre);
/* 271 */     g.drawOval(185, 140, 25, 20);
/* 272 */     g.setColor(this.clCIFText);
/* 273 */     g.drawString("CIF", 188, 155);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void afficherGrille(Graphics gr)
/*     */   {
/* 280 */     int i = 15;
/*     */     
/* 282 */     gr.setColor(Color.getHSBColor(10.0F, 260.0F, 80.0F));
/* 283 */     while (i < getSize().getWidth()) {
/* 284 */       gr.drawLine(i, 0, i, (int)getSize().getHeight());
/* 285 */       i += 15;
/*     */     }
/* 287 */     i = 15;
/* 288 */     while (i < getSize().getHeight()) {
/* 289 */       gr.drawLine(0, i, (int)getSize().getWidth(), i);
/* 290 */       i += 15;
/*     */     }
/*     */   }
/*     */   
/*     */   protected void paintComponent(Graphics g)
/*     */   {
/* 296 */     g.setColor(Color.WHITE);
/* 297 */     g.fillRect(0, 0, 300, 250);
/*     */     
/* 299 */     if (Setting.petitCarreau) {
/* 300 */       afficherGrille(g);
/*     */     } else {
/* 302 */       Graphics2D g2 = (Graphics2D)g;
/* 303 */       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 304 */       Grid grid = new Grid(getSize().width, getSize().height, 1);
/* 305 */       grid.drawGrid(g2);
/*     */     }
/*     */     
/* 308 */     dessinerLien(g);
/* 309 */     dessinerEntite(g);
/* 310 */     dessinerRelation(g);
/* 311 */     dessinerContrainte(g);
/* 312 */     dessinerCIF(g);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\PanelApercu.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */