/*     */ package IhmMCD2;
/*     */ 
/*     */ import IhmMCD.IhmCIF;
/*     */ import Merise2.Historique;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import ihm.FormeInterneMCD;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.GradientPaint;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.geom.RoundRectangle2D;
/*     */ import java.awt.geom.RoundRectangle2D.Double;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmCIF2
/*     */   extends IhmCIF
/*     */   implements Serializable
/*     */ {
/*     */   private Color clCadre2;
/*     */   private Color clFond2;
/*     */   private Color clText2;
/*     */   private Font font;
/*     */   private Color clLienActiver;
/*     */   private Color clSelected;
/*     */   private double zoom;
/*     */   private String nom;
/*     */   private String code;
/*     */   private String commentaire;
/*     */   private ArrayList<Historique> historique;
/*     */   float epaisseur;
/*     */   private Color clOmbre;
/*     */   private String identifiant;
/*     */   
/*     */   public IhmCIF2(int x, int y, int width, int hight)
/*     */   {
/*  48 */     super(x, y, 38, 36);
/*  49 */     this.nom = "C I F";
/*  50 */     this.font = Parametres.fontGras;
/*  51 */     this.zoom = FormeInterneMCD.zoom;
/*  52 */     this.clCadre2 = FormeInterneMCD.clCIFCadre2;
/*  53 */     this.clFond2 = FormeInterneMCD.clCIFFond2;
/*  54 */     this.clText2 = FormeInterneMCD.clCIFText2;
/*  55 */     this.clSelected = FormeInterneMCD.clSelected;
/*  56 */     this.clLienActiver = FormeInterneMCD.clLienActiverCIF2;
/*  57 */     this.historique = new ArrayList();
/*  58 */     this.historique.add(Historique.getHistoriqueCreation());
/*  59 */     this.commentaire = "";
/*  60 */     this.code = "";
/*  61 */     this.epaisseur = FormeInterneMCD.traitContraintes2;
/*  62 */     this.clOmbre = FormeInterneMCD.clOmbre2;
/*  63 */     setOmbre(FormeInterneMCD.isOmbree2);
/*  64 */     setClDegradee(FormeInterneMCD.isDegradee2);
/*  65 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/*  71 */     Graphics2D g2d = (Graphics2D)g;
/*  72 */     if (isOmbre()) { dessinerOmbre(g2d);
/*     */     }
/*  74 */     Stroke stro = g2d.getStroke();
/*  75 */     float[] style = { 5.0F, 0.0F };
/*  76 */     g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*     */     
/*  78 */     dessinerCIF(g2d);
/*     */     
/*  80 */     if (isSelected() == true) {
/*  81 */       dessinerSelected(g2d);
/*     */     }
/*  83 */     g2d.setStroke(stro);
/*     */   }
/*     */   
/*     */   private void dessinerSelected(Graphics2D g) {
/*  87 */     Color clgard = g.getColor();
/*  88 */     g.setColor(getClSelected());
/*     */     
/*  90 */     RoundRectangle2D rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight(), getHeight());
/*     */     
/*  92 */     if (Setting.agraverSelection2) {
/*  93 */       Stroke stro = g.getStroke();
/*  94 */       float[] style = { 5.0F, 0.0F };
/*  95 */       g.setStroke(new BasicStroke(4.0F, 0, 0, 10.0F, style, 0.0F));
/*  96 */       g.draw(rRect);
/*  97 */       g.setStroke(stro);
/*     */     }
/*     */     
/* 100 */     g.draw(rRect);
/*     */     
/* 102 */     g.setColor(Color.BLACK);
/* 103 */     g.fillRect(getX() - 1 + getWidth() / 2, getY() - 1, 4, 4);
/* 104 */     g.fillRect(getX() - 1, getY() - 2 + getHeight() / 2, 4, 4);
/* 105 */     g.fillRect(getX() - 1 + getWidth() / 2, getY() - 1 + getHeight(), 4, 4);
/* 106 */     g.fillRect(getX() - 1 + getWidth(), getY() - 2 + getHeight() / 2, 4, 4);
/*     */     
/* 108 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics2D g)
/*     */   {
/* 113 */     Color clgard = g.getColor();
/* 114 */     RoundRectangle2D rRect = new RoundRectangle2D.Double(getX() + 2, getY() + 2, getWidth() + 2, getHeight() + 2, getHeight(), getHeight());
/*     */     
/* 116 */     g.setColor(this.clOmbre);
/* 117 */     g.fill(rRect);
/*     */     
/* 119 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private void dessinerCIF(Graphics2D g) {
/* 123 */     Color clgard = g.getColor();
/* 124 */     RoundRectangle2D rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight(), getHeight());
/* 125 */     g.setColor(getClFond2());
/*     */     
/* 127 */     if (isClDegradee()) {
/* 128 */       g.setPaint(new GradientPaint(getX(), getY(), getClFond2(), getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*     */     }
/* 130 */     g.fill(rRect);
/* 131 */     g.setColor(getClCadre2());
/* 132 */     g.draw(rRect);
/*     */     
/* 134 */     g.setColor(getClText2());
/* 135 */     int tail = g.getFontMetrics().stringWidth(getNom());
/*     */     
/* 137 */     Font f = g.getFont();
/* 138 */     g.setFont(getFont());
/* 139 */     g.drawString(getNom(), getX() + 1 + (getWidth() - tail) / 2, getY() + getHeight() - 14);
/*     */     
/* 141 */     g.setFont(f);
/* 142 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   public IhmCIF copier()
/*     */   {
/* 147 */     IhmCIF2 cif = new IhmCIF2(getX() + 5, getY(), getWidth(), getHeight());
/* 148 */     cif.setNom(getNom());
/* 149 */     cif.setFont(getFont());
/* 150 */     cif.setZoom(getZoom());
/* 151 */     cif.setClCadre2(getClCadre2());
/* 152 */     cif.setClFond2(getClFond2());
/* 153 */     cif.setClText2(getClText2());
/* 154 */     cif.setClLienActiver(getClLienActiver());
/* 155 */     cif.setClSelected(getClSelected());
/* 156 */     cif.setOmbre(isOmbre());
/* 157 */     cif.setCommentaire(getCommentaire());
/* 158 */     cif.setHistorique(copierHistoriques(getHistorique()));
/* 159 */     ajouterCopier(cif.getHistorique());
/*     */     
/* 161 */     return cif;
/*     */   }
/*     */   
/*     */   public void ajouterCopier(ArrayList<Historique> lhis) {
/* 165 */     Historique h = Historique.getHistoriqueCopie();
/* 166 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/* 167 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*     */     {
/* 169 */       lhis.add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/* 174 */     ArrayList<Historique> l = new ArrayList();
/* 175 */     for (int i = 0; i < lhis.size(); i++) {
/* 176 */       l.add(((Historique)lhis.get(i)).copier());
/*     */     }
/* 178 */     ajouterCopier(l);
/* 179 */     return l;
/*     */   }
/*     */   
/*     */   public void ajouterModification() {
/* 183 */     Historique h = Historique.getHistoriqueModification();
/* 184 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/* 185 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/* 186 */       getHistorique().add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public Color getClOmbre() {
/* 191 */     return this.clOmbre;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Color getClCadre2()
/*     */   {
/* 198 */     return this.clCadre2;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/* 202 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public Color getClFond2() {
/* 206 */     return this.clFond2;
/*     */   }
/*     */   
/*     */   public Color getClLienActiver() {
/* 210 */     return this.clLienActiver;
/*     */   }
/*     */   
/*     */   public Color getClSelected() {
/* 214 */     return this.clSelected;
/*     */   }
/*     */   
/*     */   public Color getClText2() {
/* 218 */     return this.clText2;
/*     */   }
/*     */   
/*     */   public float getEpaisseur() {
/* 222 */     return this.epaisseur;
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 226 */     return this.font;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 230 */     return this.code;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/* 234 */     return this.historique;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 238 */     return this.nom;
/*     */   }
/*     */   
/*     */   public double getZoom() {
/* 242 */     return this.zoom;
/*     */   }
/*     */   
/*     */   public void setClCadre2(Color clCadre2) {
/* 246 */     this.clCadre2 = clCadre2;
/*     */   }
/*     */   
/*     */   public void setClFond2(Color clFond2) {
/* 250 */     this.clFond2 = clFond2;
/*     */   }
/*     */   
/*     */   public void setClLienActiver(Color clLienActiver) {
/* 254 */     this.clLienActiver = clLienActiver;
/*     */   }
/*     */   
/*     */   public void setClSelected(Color clSelected) {
/* 258 */     this.clSelected = clSelected;
/*     */   }
/*     */   
/*     */   public void setClText2(Color clText2) {
/* 262 */     this.clText2 = clText2;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 266 */     this.font = font;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 270 */     this.code = code;
/*     */   }
/*     */   
/*     */   public void setEpaisseur(float epaisseur) {
/* 274 */     this.epaisseur = epaisseur;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/* 278 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 282 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public void setZoom(double zoom) {
/* 286 */     this.zoom = zoom;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/* 290 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public void setClOmbre(Color clOmbre) {
/* 294 */     this.clOmbre = clOmbre;
/*     */   }
/*     */   
/*     */   public String getIdentifiant() {
/* 298 */     return this.identifiant;
/*     */   }
/*     */   
/*     */   public void setIdentifiant(String identifiant) {
/* 302 */     this.identifiant = identifiant;
/*     */   }
/*     */   
/*     */   public static IhmCIF2 parseCIF(IhmCIF cif)
/*     */   {
/* 307 */     IhmCIF2 c = new IhmCIF2(cif.getX(), cif.getY(), cif.getWidth(), cif.getHeight());
/* 308 */     return c;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmCIF2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */