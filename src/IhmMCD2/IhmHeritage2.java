/*     */ package IhmMCD2;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmHeritage;
/*     */ import Merise2.Historique;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import ihm.FormeInterneMCD;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Stroke;
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
/*     */ public class IhmHeritage2
/*     */   extends IhmHeritage
/*     */   implements Serializable
/*     */ {
/*     */   private Color clCadre2;
/*     */   private Color clFond2;
/*     */   private Color clText2;
/*     */   private Font font;
/*     */   private Color clLienActiver;
/*     */   private Color clSelected;
/*     */   private double zoom;
/*     */   private String code;
/*     */   private String commentaire;
/*     */   private IhmEntiteRelation entitePere;
/*     */   private int cote;
/*     */   private ArrayList<Historique> historique;
/*     */   public static final int COTEDROIT = 3;
/*     */   public static final int COTEHAUT = 2;
/*     */   public static final int COTEGAUCHE = 1;
/*     */   public static final int COTEBAS = 4;
/*     */   float epaisseur;
/*     */   Color clOmbre;
/*     */   String identifiant;
/*     */   
/*     */   public IhmHeritage2(int x, int y, IhmEntite entite)
/*     */   {
/*  53 */     super(x, y, entite);
/*  54 */     this.epaisseur = 1.0F;
/*  55 */     this.clOmbre = FormeInterneMCD.clOmbre2;
/*  56 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */   public IhmHeritage2(int x, int y, IhmEntiteRelation entite, int nb) {
/*  60 */     super(x, y, null);
/*  61 */     setWidth(42);
/*  62 */     setHeight(26);
/*  63 */     setNom("");
/*  64 */     this.entitePere = entite;
/*  65 */     this.font = Parametres.fontGras;
/*  66 */     this.zoom = FormeInterneMCD.zoom;
/*  67 */     this.clCadre2 = FormeInterneMCD.clHeritageCadre2;
/*  68 */     this.clFond2 = FormeInterneMCD.clHeritageFond2;
/*  69 */     this.clText2 = FormeInterneMCD.clHeritageText2;
/*  70 */     this.clSelected = FormeInterneMCD.clSelected;
/*  71 */     this.clLienActiver = FormeInterneMCD.clLienActiverHeritage2;
/*  72 */     this.historique = new ArrayList();
/*  73 */     this.historique.add(Historique.getHistoriqueCreation());
/*  74 */     this.commentaire = "";
/*  75 */     this.code = "";
/*  76 */     this.epaisseur = FormeInterneMCD.traitContraintes2;
/*  77 */     this.clOmbre = FormeInterneMCD.clOmbre2;
/*  78 */     setOmbre(FormeInterneMCD.isOmbree2);
/*  79 */     setClDegradee(FormeInterneMCD.isDegradee2);
/*  80 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  85 */     Graphics2D g2d = (Graphics2D)g;
/*  86 */     dessinerHeritage(g2d);
/*     */   }
/*     */   
/*     */   private void getCoteHeritage() {
/*  90 */     this.cote = 4;
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics2D g) {
/*  94 */     Color clgard = g.getColor();
/*  95 */     g.setColor(this.clOmbre);
/*  96 */     int[] x = { getX() + getWidth() / 2 + 3, getX() + 3, getX() + getWidth() + 3 };
/*  97 */     int[] y = { getY() + 4, getY() + getHeight() + 4, getY() + getHeight() + 4 };
/*  98 */     g.fillPolygon(x, y, 3);
/*  99 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private void ecrireContrainte(Graphics2D g)
/*     */   {
/* 104 */     if (getNom().length() > 0) {
/* 105 */       int h = g.getFontMetrics().getHeight();
/* 106 */       int w = g.getFontMetrics().stringWidth(getNom());
/* 107 */       Font f = g.getFont();
/* 108 */       g.setFont(this.font);
/*     */       
/* 110 */       g.setColor(getClText2());
/* 111 */       int x = (getWidth() - w) / 2;
/* 112 */       x = getX() + x;
/* 113 */       g.drawString(getNom(), x, getY() + getHeight() - 3);
/*     */       
/* 115 */       g.setFont(f);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerSelected(Graphics2D g)
/*     */   {
/* 121 */     Color clgard = g.getColor();
/*     */     
/* 123 */     int[] x = { getX() + getWidth() / 2, getX(), getX() + getWidth() };
/* 124 */     int[] y = { getY(), getY() + getHeight(), getY() + getHeight() };
/* 125 */     g.setColor(getClSelected());
/* 126 */     if (Setting.agraverSelection2) {
/* 127 */       Stroke stro = g.getStroke();
/* 128 */       float[] style = { 5.0F, 0.0F };
/* 129 */       g.setStroke(new BasicStroke(4.0F, 0, 0, 10.0F, style, 0.0F));
/* 130 */       g.drawPolygon(x, y, 3);
/* 131 */       g.setStroke(stro);
/*     */     }
/*     */     
/*     */ 
/* 135 */     g.drawPolygon(x, y, 3);
/* 136 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private void dessinerContrainte(Graphics2D g) {
/* 140 */     Color clgard = g.getColor();
/* 141 */     int[] x = { getX() + getWidth() / 2, getX(), getX() + getWidth() };
/* 142 */     int[] y = { getY(), getY() + getHeight(), getY() + getHeight() };
/* 143 */     g.setColor(getClFond2());
/* 144 */     g.fillPolygon(x, y, 3);
/* 145 */     g.setColor(getClCadre2());
/* 146 */     g.drawPolygon(x, y, 3);
/* 147 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private void dessinerHeritage(Graphics2D g) {
/* 151 */     getCoteHeritage();
/* 152 */     if (isOmbre()) dessinerOmbre(g);
/* 153 */     Graphics2D g2d = g;
/* 154 */     Stroke stro = g2d.getStroke();
/* 155 */     float[] style = { 5.0F, 0.0F };
/* 156 */     g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*     */     
/* 158 */     dessinerContrainte(g);
/* 159 */     ecrireContrainte(g);
/* 160 */     if (isSelected()) { dessinerSelected(g);
/*     */     }
/* 162 */     g2d.setStroke(stro);
/*     */   }
/*     */   
/*     */   public Color getClCadre2() {
/* 166 */     return this.clCadre2;
/*     */   }
/*     */   
/*     */   public Color getClFond2() {
/* 170 */     return this.clFond2;
/*     */   }
/*     */   
/*     */   public Color getClLienActiver() {
/* 174 */     return this.clLienActiver;
/*     */   }
/*     */   
/*     */   public Color getClSelected() {
/* 178 */     return this.clSelected;
/*     */   }
/*     */   
/*     */   public Color getClOmbre() {
/* 182 */     return this.clOmbre;
/*     */   }
/*     */   
/*     */   public Color getClText2() {
/* 186 */     return this.clText2;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 190 */     return this.code;
/*     */   }
/*     */   
/*     */   public String getIdentifiant() {
/* 194 */     return this.identifiant;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/* 198 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation getPere() {
/* 202 */     return this.entitePere;
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 206 */     return this.font;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/* 210 */     return this.historique;
/*     */   }
/*     */   
/*     */   public double getZoom() {
/* 214 */     return this.zoom;
/*     */   }
/*     */   
/*     */   public float getEpaisseur() {
/* 218 */     return this.epaisseur;
/*     */   }
/*     */   
/*     */   public void setClCadre2(Color clCadre2) {
/* 222 */     this.clCadre2 = clCadre2;
/*     */   }
/*     */   
/*     */   public void setClFond2(Color clFond2) {
/* 226 */     this.clFond2 = clFond2;
/*     */   }
/*     */   
/*     */   public void setClLienActiver(Color clLienActiver) {
/* 230 */     this.clLienActiver = clLienActiver;
/*     */   }
/*     */   
/*     */   public void setEpaisseur(float epaisseur) {
/* 234 */     this.epaisseur = epaisseur;
/*     */   }
/*     */   
/*     */   public void setClSelected(Color clSelected) {
/* 238 */     this.clSelected = clSelected;
/*     */   }
/*     */   
/*     */   public void setClText2(Color clText2) {
/* 242 */     this.clText2 = clText2;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 246 */     this.code = code;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/* 250 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public void setEntitePere(IhmEntiteRelation entitePere) {
/* 254 */     this.entitePere = entitePere;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 258 */     this.font = font;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/* 262 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public void setZoom(double zoom) {
/* 266 */     this.zoom = zoom;
/*     */   }
/*     */   
/*     */   public void setClOmbre(Color clOmbre) {
/* 270 */     this.clOmbre = clOmbre;
/*     */   }
/*     */   
/*     */   public void ajouterModification() {
/* 274 */     Historique h = Historique.getHistoriqueModification();
/* 275 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/* 276 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/* 277 */       getHistorique().add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public void ajouterCopier(ArrayList<Historique> lhis) {
/* 282 */     Historique h = Historique.getHistoriqueCopie();
/* 283 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/* 284 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*     */     {
/* 286 */       lhis.add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/* 291 */     ArrayList<Historique> l = new ArrayList();
/* 292 */     for (int i = 0; i < lhis.size(); i++) {
/* 293 */       l.add(((Historique)lhis.get(i)).copier());
/*     */     }
/* 295 */     ajouterCopier(l);
/* 296 */     return l;
/*     */   }
/*     */   
/*     */   public IhmHeritage2 copier(IhmEntiteRelation pere) {
/* 300 */     IhmHeritage2 her = new IhmHeritage2(getX() + 5, getY() + 5, pere, 0);
/* 301 */     her.setClCadre2(getClCadre2());
/* 302 */     her.setClFond2(getClFond2());
/* 303 */     her.setClText2(getClText2());
/* 304 */     her.setClLienActiver(getClLienActiver());
/* 305 */     her.setNom(getNom());
/* 306 */     her.setCode(getCode());
/* 307 */     her.setCommentaire(getCommentaire());
/* 308 */     her.setHistorique(copierHistoriques(getHistorique()));
/* 309 */     ajouterCopier(her.getHistorique());
/* 310 */     return her;
/*     */   }
/*     */   
/*     */   public static IhmHeritage2 ParseHeritage(IhmHeritage her, IhmEntiteRelation pere)
/*     */   {
/* 315 */     IhmHeritage2 h = new IhmHeritage2(her.getX(), her.getY(), pere, 0);
/* 316 */     h.setNom(her.getNom());
/* 317 */     h.setCommentaire("");
/* 318 */     h.setCode("");
/* 319 */     return h;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmHeritage2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */