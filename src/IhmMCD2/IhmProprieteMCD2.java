/*     */ package IhmMCD2;
/*     */ 
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import Merise2.Historique;
/*     */ import Outil.Parametres;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmProprieteMCD2
/*     */   extends IhmEntiteRelation
/*     */ {
/*     */   protected Color clCadre;
/*     */   protected Color clFond;
/*     */   protected Color clString;
/*     */   protected Color clFondEntete;
/*     */   protected Color clStringEntete;
/*     */   protected Font fontGras;
/*     */   protected Font fontNormal;
/*     */   protected ConfigurationMCD2 configuration;
/*     */   int hauteur;
/*     */   int xdate;
/*     */   int xdev;
/*     */   protected boolean visible;
/*     */   String identifiant;
/*     */   
/*     */   public IhmProprieteMCD2(ConfigurationMCD2 configuration, boolean visible)
/*     */   {
/*  34 */     super(1, 1, 10, 10, true);
/*  35 */     this.fontGras = Parametres.fontGras;
/*  36 */     this.fontNormal = Parametres.fontNormal;
/*  37 */     this.configuration = configuration;
/*  38 */     this.visible = visible;
/*  39 */     this.clCadre = Color.BLACK;
/*  40 */     this.clFond = Color.WHITE;
/*  41 */     this.clString = Color.BLACK;
/*     */     
/*  43 */     this.clFondEntete = Color.WHITE;
/*  44 */     this.clStringEntete = Color.BLACK;
/*  45 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/*  51 */     Graphics2D g2d = (Graphics2D)g;
/*  52 */     ajusterTaille(g2d);
/*  53 */     dessinerPropriete(g2d);
/*     */   }
/*     */   
/*     */   protected String getDateCreation() {
/*  57 */     if (this.configuration.getHistorique().size() == 0) return "";
/*  58 */     return ((Historique)this.configuration.getHistorique().get(0)).getDate();
/*     */   }
/*     */   
/*     */   protected String getDeveloppeurCreation() {
/*  62 */     if (this.configuration.getHistorique().size() == 0) return "";
/*  63 */     return ((Historique)this.configuration.getHistorique().get(0)).getDeveloppeur();
/*     */   }
/*     */   
/*     */   protected String getDateModif() {
/*  67 */     if (this.configuration.getHistorique().size() < 2) return "";
/*  68 */     return ((Historique)this.configuration.getHistorique().get(this.configuration.getHistorique().size() - 1)).getDate();
/*     */   }
/*     */   
/*     */   protected String getDeveloppeurModif() {
/*  72 */     if (this.configuration.getHistorique().size() < 2) return "";
/*  73 */     return ((Historique)this.configuration.getHistorique().get(this.configuration.getHistorique().size() - 1)).getDeveloppeur();
/*     */   }
/*     */   
/*     */   private int calculerXDate(Graphics2D g) {
/*  77 */     return g.getFontMetrics().stringWidth("MnMODIFICATION :");
/*     */   }
/*     */   
/*     */   private int calculerXDeveloppeur(Graphics2D g) {
/*  81 */     int xDate = calculerXDate(g);
/*  82 */     int xdc = g.getFontMetrics().stringWidth(getDateCreation() + " T");
/*  83 */     int xdm = g.getFontMetrics().stringWidth(getDateModif() + " T");
/*  84 */     if (xdc > xdm) {
/*  85 */       return xDate + xdc;
/*     */     }
/*  87 */     return xDate + xdm;
/*     */   }
/*     */   
/*     */   private int getWidthConfig(Graphics2D g) {
/*  91 */     String nom = "MCD : " + this.configuration.getNomMCD().trim();
/*  92 */     int tailEnt = g.getFontMetrics().stringWidth("T" + nom + "MS");
/*  93 */     int xDevC = g.getFontMetrics().stringWidth(getDeveloppeurCreation() + "MEs");
/*  94 */     int xDevM = g.getFontMetrics().stringWidth(getDeveloppeurModif() + "MEs");
/*  95 */     int xd = xDevC > xDevM ? xDevC : xDevM;
/*  96 */     xd += calculerXDeveloppeur(g);
/*  97 */     if (tailEnt > xd) return tailEnt;
/*  98 */     return xd;
/*     */   }
/*     */   
/*     */   private int getHeightConfig(Graphics2D g) {
/* 102 */     int h = g.getFontMetrics().getHeight();
/* 103 */     this.hauteur = h;
/* 104 */     return 5 * h;
/*     */   }
/*     */   
/*     */   private void ajusterTaille(Graphics2D g) {
/* 108 */     Font f = g.getFont();
/* 109 */     g.setFont(this.fontGras);
/* 110 */     this.xdate = calculerXDate(g);
/* 111 */     this.xdev = calculerXDeveloppeur(g);
/* 112 */     int w = getWidthConfig(g);
/* 113 */     int h = getHeightConfig(g);
/* 114 */     setWidth(w);
/* 115 */     setHeight(h);
/* 116 */     g.setFont(f);
/*     */   }
/*     */   
/*     */   private void dessinerPropriete(Graphics2D g) {
/* 120 */     Font f = g.getFont();
/* 121 */     g.setFont(this.fontGras);
/* 122 */     g.setColor(this.clFond);
/* 123 */     g.fillRect(getX(), getY(), getWidth(), getHeight());
/* 124 */     g.setColor(this.clFondEntete);
/* 125 */     g.fillRect(getX(), getY(), getWidth(), (int)(this.hauteur * 1.5D));
/* 126 */     g.setColor(this.clStringEntete);
/* 127 */     String nom = "MCD : " + this.configuration.getNomMCD();
/* 128 */     int tail = g.getFontMetrics().stringWidth(nom);
/* 129 */     g.drawString(nom, getX() + (getWidth() - tail) / 2, getY() + (int)(this.hauteur * 1.25D));
/*     */     
/* 131 */     g.setColor(this.clCadre);
/* 132 */     g.drawRect(getX(), getY(), getWidth(), getHeight());
/* 133 */     g.drawLine(getX(), getY() + (int)(this.hauteur * 1.5D), getX() + getWidth(), getY() + (int)(this.hauteur * 1.5D));
/*     */     
/*     */ 
/*     */ 
/* 137 */     g.setFont(f);
/* 138 */     g.drawString("CREATION : ", getX() + 4, getY() + 3 * this.hauteur);
/* 139 */     g.drawString("MODIFICATION : ", getX() + 4, getY() + (int)(4.5D * this.hauteur));
/*     */     
/* 141 */     g.drawString(getDateCreation(), getX() + this.xdate, getY() + 3 * this.hauteur);
/* 142 */     g.drawString(getDateModif(), getX() + this.xdate, getY() + (int)(4.5D * this.hauteur));
/*     */     
/* 144 */     g.drawString(getDeveloppeurCreation(), getX() + this.xdev, getY() + 3 * this.hauteur);
/* 145 */     g.drawString(getDeveloppeurModif(), getX() + this.xdev, getY() + (int)(4.5D * this.hauteur));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/* 152 */     if ((x > getX()) && (x < getX() + getWidth()) && (y > getY()) && (y < getY() + getHeight())) {
/* 153 */       return true;
/*     */     }
/* 155 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public Color getClCadre()
/*     */   {
/* 161 */     return this.clCadre;
/*     */   }
/*     */   
/*     */   public Color getClFond() {
/* 165 */     return this.clFond;
/*     */   }
/*     */   
/*     */   public Color getClFondEntete() {
/* 169 */     return this.clFondEntete;
/*     */   }
/*     */   
/*     */   public Color getClString() {
/* 173 */     return this.clString;
/*     */   }
/*     */   
/*     */   public Color getClStringEntete() {
/* 177 */     return this.clStringEntete;
/*     */   }
/*     */   
/*     */   public ConfigurationMCD2 getConfiguration() {
/* 181 */     return this.configuration;
/*     */   }
/*     */   
/*     */   public Font getFontGras() {
/* 185 */     return this.fontGras;
/*     */   }
/*     */   
/*     */   public Font getFontNormal() {
/* 189 */     return this.fontNormal;
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 193 */     return this.visible;
/*     */   }
/*     */   
/*     */   public void setClCadre(Color clCadre) {
/* 197 */     this.clCadre = clCadre;
/*     */   }
/*     */   
/*     */   public int getHauteur() {
/* 201 */     return this.hauteur;
/*     */   }
/*     */   
/*     */   public String getIdentifiant() {
/* 205 */     return this.identifiant;
/*     */   }
/*     */   
/*     */   public int getXdate() {
/* 209 */     return this.xdate;
/*     */   }
/*     */   
/*     */   public int getXdev() {
/* 213 */     return this.xdev;
/*     */   }
/*     */   
/*     */   public void setClFond(Color clFond) {
/* 217 */     this.clFond = clFond;
/*     */   }
/*     */   
/*     */   public void setClFondEntete(Color clFondEntete) {
/* 221 */     this.clFondEntete = clFondEntete;
/*     */   }
/*     */   
/*     */   public void setClString(Color clString) {
/* 225 */     this.clString = clString;
/*     */   }
/*     */   
/*     */   public void setClStringEntete(Color clStringEntete) {
/* 229 */     this.clStringEntete = clStringEntete;
/*     */   }
/*     */   
/*     */   public void setConfiguration(ConfigurationMCD2 configuration) {
/* 233 */     this.configuration = configuration;
/*     */   }
/*     */   
/*     */   public void setFontGras(Font fontGras) {
/* 237 */     this.fontGras = fontGras;
/*     */   }
/*     */   
/*     */   public void setFontNormal(Font fontNormal) {
/* 241 */     this.fontNormal = fontNormal;
/*     */   }
/*     */   
/*     */   public void setVisible(boolean visible) {
/* 245 */     this.visible = visible;
/*     */   }
/*     */   
/*     */   public void setHauteur(int hauteur) {
/* 249 */     this.hauteur = hauteur;
/*     */   }
/*     */   
/*     */   public void setIdentifiant(String identifiant) {
/* 253 */     this.identifiant = identifiant;
/*     */   }
/*     */   
/*     */   public void setXdate(int xdate) {
/* 257 */     this.xdate = xdate;
/*     */   }
/*     */   
/*     */   public void setXdev(int xdev) {
/* 261 */     this.xdev = xdev;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmProprieteMCD2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */