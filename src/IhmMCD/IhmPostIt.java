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
/*     */ public class IhmPostIt
/*     */   extends IhmCommentaireIndip
/*     */   implements Serializable
/*     */ {
/*     */   public String Aligntexte;
/*     */   public String action;
/*     */   
/*     */   public IhmPostIt(String Commentaire, int x, int y, int weidth, int hight)
/*     */   {
/*  23 */     super(Commentaire, x, y, weidth, hight);
/*  24 */     setCommentaire("\n\nVos notes et remarques ici\n");
/*  25 */     setClDegradee(false);
/*  26 */     setClFond(new Color(255, 255, 103));
/*  27 */     setClCadre(Color.BLACK);
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  32 */     adapterTaille(g, getCommentaire());
/*  33 */     if (isOmbre()) {
/*  34 */       dessinerOmbre(g);
/*     */     }
/*  36 */     dessinerPostIt(g);
/*  37 */     ecrireCommentaire(g);
/*  38 */     if (isSelected() == true)
/*     */     {
/*  40 */       g.setColor(Color.red);
/*  41 */       dessinerSelect(g);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics g)
/*     */   {
/*  47 */     g.setColor(Color.GRAY);
/*  48 */     g.fillRect(getX(), getY(), getWeidth(), getHeight() + Parametres.retournerVal(g, 8));
/*     */   }
/*     */   
/*     */   private void dessinerSelect(Graphics g) {
/*  52 */     int[] xPoint = { 0, 0, 0, 0 };
/*  53 */     int[] yPoint = { 0, 0, 0, 0 };
/*  54 */     xPoint[0] = (getX() - Parametres.retournerVal(g, 1));
/*  55 */     yPoint[0] = (getY() - Parametres.retournerVal(g, 1));
/*     */     
/*  57 */     xPoint[1] = (getX() + getWeidth() + Parametres.retournerVal(g, 4));
/*  58 */     yPoint[1] = (getY() - Parametres.retournerVal(g, 1));
/*     */     
/*  60 */     xPoint[2] = (getX() + getWeidth() + Parametres.retournerVal(g, 9));
/*  61 */     yPoint[2] = (getY() + getHeight());
/*     */     
/*  63 */     xPoint[3] = (getX() + Parametres.retournerVal(g, 8));
/*  64 */     yPoint[3] = (getY() + getHeight());
/*  65 */     g.drawPolygon(xPoint, yPoint, 4);
/*     */   }
/*     */   
/*     */   private void dessinerPostIt(Graphics g) {
/*  69 */     int[] xPoint = { 0, 0, 0, 0 };
/*  70 */     int[] yPoint = { 0, 0, 0, 0 };
/*  71 */     xPoint[0] = (getX() - Parametres.retournerVal(g, 1));
/*  72 */     yPoint[0] = (getY() - Parametres.retournerVal(g, 1));
/*     */     
/*  74 */     xPoint[1] = (getX() + getWeidth() + Parametres.retournerVal(g, 4));
/*  75 */     yPoint[1] = (getY() - Parametres.retournerVal(g, 1));
/*     */     
/*  77 */     xPoint[2] = (getX() + getWeidth() + Parametres.retournerVal(g, 9));
/*  78 */     yPoint[2] = (getY() + getHeight());
/*     */     
/*  80 */     xPoint[3] = (getX() + Parametres.retournerVal(g, 8));
/*  81 */     yPoint[3] = (getY() + getHeight());
/*     */     
/*  83 */     g.setColor(getClFond());
/*  84 */     g.drawPolygon(xPoint, yPoint, 4);
/*  85 */     xPoint[0] = getX();
/*  86 */     yPoint[0] = getY();
/*     */     
/*  88 */     xPoint[1] = (getX() + getWeidth() + Parametres.retournerVal(g, 3));
/*  89 */     yPoint[1] = getY();
/*     */     
/*  91 */     xPoint[2] = (getX() + getWeidth() + Parametres.retournerVal(g, 8));
/*  92 */     yPoint[2] = (getY() + getHeight());
/*     */     
/*  94 */     xPoint[3] = (getX() + Parametres.retournerVal(g, 7));
/*  95 */     yPoint[3] = (getY() + getHeight());
/*     */     
/*  97 */     Graphics2D g2d = (Graphics2D)g;
/*  98 */     if (isClDegradee()) g2d.setPaint(new GradientPaint(getX(), getY(), getClFond(), getX() + getWeidth() + 8, getY() + getHeight(), Color.WHITE, true));
/*  99 */     g.fillPolygon(xPoint, yPoint, 4);
/* 100 */     g.setColor(Color.GRAY);
/* 101 */     g.fillOval(getX() + getWeidth() / 2, getY(), Parametres.retournerVal(g, 10), Parametres.retournerVal(g, 10));
/* 102 */     g.setColor(getClCadre());
/* 103 */     g.fillOval(getX() + getWeidth() / 2 + Parametres.retournerVal(g, 3), getY() + Parametres.retournerVal(g, 2), Parametres.retournerVal(g, 6), Parametres.retournerVal(g, 6));
/* 104 */     g.fillOval(getX() + getWeidth() / 2 + Parametres.retournerVal(g, 7), getY(), Parametres.retournerVal(g, 10), Parametres.retournerVal(g, 10));
/*     */   }
/*     */   
/*     */   private void ecrireCommentaire(Graphics g) {
/* 108 */     int h = g.getFontMetrics().getHeight();
/* 109 */     int index = 0;
/* 110 */     int ligne = getY() + h + h;
/*     */     
/* 112 */     g.setColor(getClTexte());
/* 113 */     String str = getCommentaire();
/* 114 */     if (getCommentaire().indexOf("\n") == -1) {
/* 115 */       g.drawString(getCommentaire(), getX() + (getWeidth() - g.getFontMetrics().stringWidth(getCommentaire())) / 2, ligne);
/*     */     } else {
/* 117 */       while (str.indexOf("\n") != -1) {
/* 118 */         String strLigne = str.substring(0, str.indexOf("\n"));
/* 119 */         index = str.indexOf("\n") + 1;
/* 120 */         str = str.substring(index, str.length());
/* 121 */         g.drawString(strLigne, getX() + (getWeidth() - g.getFontMetrics().stringWidth(strLigne)) / 2, ligne);
/* 122 */         ligne += h;
/* 123 */         if ((str.indexOf("\n") == -1) && 
/* 124 */           (str.trim().length() != 0)) {
/* 125 */           g.drawString(str, getX() + (getWeidth() - g.getFontMetrics().stringWidth(str)) / 2, ligne);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void adapterTaille(Graphics g, String str)
/*     */   {
/* 135 */     int h = g.getFontMetrics().getHeight();
/* 136 */     int ww = g.getFontMetrics().stringWidth("MESS");
/* 137 */     int wMax = 0;int hMax = h;int index = 0;
/* 138 */     if (str.indexOf("\n") == -1) {
/* 139 */       setWeidth(g.getFontMetrics().stringWidth(str) + 40);
/* 140 */       setHight(h * 2);
/*     */     } else {
/* 142 */       while (str.indexOf("\n") != -1) {
/* 143 */         hMax += h;
/* 144 */         String strLigne = str.substring(0, str.indexOf("\n"));
/* 145 */         index = str.indexOf("\n") + 1;
/* 146 */         str = str.substring(index, str.length());
/*     */         
/* 148 */         if ((str.indexOf("\n") == -1) && 
/* 149 */           (str.trim().length() != 0)) {
/* 150 */           strLigne = str;
/* 151 */           hMax += h;
/* 152 */           if (wMax < g.getFontMetrics().stringWidth(strLigne) + ww) {
/* 153 */             wMax = g.getFontMetrics().stringWidth(strLigne) + ww;
/*     */           }
/*     */         }
/*     */         
/* 157 */         if (wMax < g.getFontMetrics().stringWidth(strLigne) + ww) {
/* 158 */           wMax = g.getFontMetrics().stringWidth(strLigne) + ww;
/*     */         }
/*     */       }
/* 161 */       setWeidth(wMax);
/* 162 */       setHeight(hMax + h);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAligntexte() {
/* 167 */     return this.Aligntexte;
/*     */   }
/*     */   
/*     */   public String getAction() {
/* 171 */     return this.action;
/*     */   }
/*     */   
/*     */   public void setAligntexte(String Aligntexte) {
/* 175 */     this.Aligntexte = Aligntexte;
/*     */   }
/*     */   
/*     */   public void setAction(String action) {
/* 179 */     this.action = action;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmPostIt.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */