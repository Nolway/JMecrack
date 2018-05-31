/*     */ package IhmMCD2;
/*     */ 
/*     */ import IhmMCD.IhmCadre;
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
/*     */ 
/*     */ public class IhmCadre2
/*     */   extends IhmCadre
/*     */   implements Serializable
/*     */ {
/*     */   private Color clCadre2;
/*     */   private Color clFond2;
/*     */   private Color clText2;
/*     */   private Color clOmbre2;
/*     */   private Font font;
/*     */   private Color clSelected;
/*     */   private double zoom;
/*     */   private String nom;
/*     */   private String code;
/*     */   private String commentaire;
/*     */   private ArrayList<Historique> historique;
/*     */   float epaisseur;
/*     */   String aligner;
/*     */   private String identifiant;
/*     */   
/*     */   public IhmCadre2(int x, int y, int width, int hight)
/*     */   {
/*  46 */     super(x, y, width, hight);
/*  47 */     this.font = Parametres.fontNormal;
/*  48 */     this.zoom = FormeInterneMCD.zoom;
/*  49 */     this.clCadre2 = Color.BLACK;
/*  50 */     this.clFond2 = Color.WHITE;
/*  51 */     this.clText2 = Color.BLACK;
/*     */     
/*  53 */     this.clSelected = FormeInterneMCD.clSelected;
/*  54 */     this.historique = new ArrayList();
/*  55 */     this.historique.add(Historique.getHistoriqueCreation());
/*  56 */     this.commentaire = "";
/*  57 */     this.code = "";
/*  58 */     this.nom = "";
/*  59 */     this.epaisseur = FormeInterneMCD.traitContraintes2;
/*  60 */     this.clOmbre2 = FormeInterneMCD.clOmbre2;
/*  61 */     setOmbre(FormeInterneMCD.isOmbree2);
/*  62 */     setClDegradee(FormeInterneMCD.isDegradee2);
/*  63 */     this.aligner = FormeInterneMCD.alignerCommentaire;
/*  64 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/*  71 */     if (isOmbre()) dessinerOmbre(g);
/*  72 */     g.setColor(getClFond2());
/*  73 */     Graphics2D g2d = (Graphics2D)g;
/*  74 */     if (isClDegradee()) {
/*  75 */       g2d.setPaint(new GradientPaint(getX(), getY(), getClFond2(), getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*     */     }
/*  77 */     g.fillRect(getX(), getY(), getWidth(), getHeight());
/*  78 */     g.setColor(getClCadre2());
/*  79 */     g.drawRect(getX(), getY(), getWidth(), getHeight());
/*  80 */     dessinerNom(g2d);
/*     */     
/*  82 */     if (isSelected() == true) {
/*  83 */       g.setColor(getClSelected());
/*  84 */       g.drawRect(getX(), getY(), getWidth(), getHeight());
/*  85 */       g.setColor(Color.BLACK);
/*  86 */       g.fillRect(getX(), getY() + getHeight() / 2, 4, 4);
/*  87 */       g.fillRect(getX() + getWidth() / 2, getY() - 4, 4, 4);
/*  88 */       g.fillRect(getX() + getWidth() / 2, getY() + getHeight(), 4, 4);
/*  89 */       g.fillRect(getX() + getWidth() - 2, getY() + getHeight() / 2, 4, 4);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerNom(Graphics2D g2d) {
/*  94 */     g2d.setColor(getClText2());
/*  95 */     String aligne = getAligner();
/*  96 */     g2d.setFont(this.font);
/*     */     
/*  98 */     int hn = g2d.getFontMetrics().getHeight();
/*  99 */     int wn = g2d.getFontMetrics().stringWidth(getNom());
/*     */     
/* 101 */     if (aligne.equals("GAUCHE")) {
/* 102 */       g2d.drawString(getNom(), getX() + 5, getY() + hn + 1);
/*     */     }
/* 104 */     if (aligne.equals("DROITE")) {
/* 105 */       g2d.drawString(getNom(), getX() + getWidth() - wn - 5, getY() + hn + 1);
/*     */     }
/* 107 */     if (aligne.equals("CENTRE")) {
/* 108 */       g2d.drawString(getNom(), getX() + (getWidth() - wn) / 2 - 5, getY() + hn + 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics g)
/*     */   {
/* 114 */     Color clgard = g.getColor();
/*     */     
/* 116 */     g.setColor(getClOmbre2());
/* 117 */     g.fillRect(getX() + 2, getY() + 2, getWidth() + 3, getHeight() + 3);
/* 118 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   public int aggrandir(int x, int y)
/*     */   {
/* 123 */     if ((x > getX()) && (y > getY() + getHeight() / 2) && (x < getX() + 4) && (y < getY() + getHeight() / 2 + 4)) return -1;
/* 124 */     if ((x > getX() + getWidth() / 2) && (y > getY() - 4) && (x < getX() + getWidth() / 2 + 4) && (y < getY())) return -1;
/* 125 */     if ((x > getX() + getWidth() - 4) && (y > getY()) && (x < getX() + getWidth() + 4) && (y < getY() + getHeight())) return 1;
/* 126 */     if ((x > getX()) && (y > getY() + getHeight() - 4) && (x < getX() + getWidth()) && (y < getY() + getHeight() + 4)) return 2;
/* 127 */     return -1;
/*     */   }
/*     */   
/*     */   private Color getCouleurs(String cl) {
/* 131 */     return new Color(Integer.parseInt(cl));
/*     */   }
/*     */   
/*     */   private String getColeurString(Color cl) {
/* 135 */     return cl.getRGB() + "";
/*     */   }
/*     */   
/*     */   public Color getClCadre2()
/*     */   {
/* 140 */     return this.clCadre2;
/*     */   }
/*     */   
/*     */   public Color getClFond2() {
/* 144 */     return this.clFond2;
/*     */   }
/*     */   
/*     */   public Color getClOmbre2() {
/* 148 */     return this.clOmbre2;
/*     */   }
/*     */   
/*     */   public Color getClSelected() {
/* 152 */     return this.clSelected;
/*     */   }
/*     */   
/*     */   public Color getClText2() {
/* 156 */     return this.clText2;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 160 */     return this.code;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/* 164 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public float getEpaisseur() {
/* 168 */     return this.epaisseur;
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 172 */     return this.font;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/* 176 */     return this.historique;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 180 */     return this.nom;
/*     */   }
/*     */   
/*     */   public double getZoom() {
/* 184 */     return this.zoom;
/*     */   }
/*     */   
/*     */   public void setClCadre2(Color clCadre2) {
/* 188 */     this.clCadre2 = clCadre2;
/*     */   }
/*     */   
/*     */   public void setClFond2(Color clFond2) {
/* 192 */     this.clFond2 = clFond2;
/*     */   }
/*     */   
/*     */   public void setClOmbre2(Color clOmbre) {
/* 196 */     this.clOmbre2 = clOmbre;
/*     */   }
/*     */   
/*     */   public void setClSelected(Color clSelected) {
/* 200 */     this.clSelected = clSelected;
/*     */   }
/*     */   
/*     */   public void setClText2(Color clText2) {
/* 204 */     this.clText2 = clText2;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 208 */     this.code = code;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/* 212 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public void setEpaisseur(float epaisseur) {
/* 216 */     this.epaisseur = epaisseur;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 220 */     this.font = font;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/* 224 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 228 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public void setZoom(double zoom) {
/* 232 */     this.zoom = zoom;
/*     */   }
/*     */   
/*     */   public String getAligner() {
/* 236 */     return this.aligner;
/*     */   }
/*     */   
/*     */   public void setAligner(String aligner) {
/* 240 */     this.aligner = aligner;
/*     */   }
/*     */   
/*     */   public String getIdentifiant() {
/* 244 */     return this.identifiant;
/*     */   }
/*     */   
/*     */   public void setIdentifiant(String identifiant) {
/* 248 */     this.identifiant = identifiant;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmCadre2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */