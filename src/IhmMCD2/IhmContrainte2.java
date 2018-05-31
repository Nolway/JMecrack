/*     */ package IhmMCD2;
/*     */ 
/*     */ import IhmMCD.IhmContrainte;
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
/*     */ 
/*     */ 
/*     */ public class IhmContrainte2
/*     */   extends IhmContrainte
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
/*     */   private String type;
/*     */   public static final String EXCLUSIVITE = "EXCLUSIVITE";
/*     */   public static final String TOTALITE = "TOTALITE";
/*     */   public static final String PARTITION = "PARTITION";
/*     */   public static final String INCLUSION = "INCLUSION";
/*     */   public static final String SIMULTANEITE = "SIMULTANEITE";
/*     */   private ArrayList<Historique> historique;
/*     */   float epaisseur;
/*     */   Color clOmbre;
/*     */   String conversionContr;
/*     */   boolean correct;
/*     */   private String identifiant;
/*     */   
/*     */   public IhmContrainte2(int x, int y, int width, int hight)
/*     */   {
/*  57 */     super(x, y, 30, 28);
/*  58 */     setNom("=");
/*  59 */     setType("SIMULTANEITE");
/*  60 */     this.font = Parametres.fontGras14;
/*  61 */     this.zoom = FormeInterneMCD.zoom;
/*  62 */     this.clCadre2 = FormeInterneMCD.clContrainteCadre2;
/*  63 */     this.clFond2 = FormeInterneMCD.clContrainteFond2;
/*  64 */     this.clText2 = FormeInterneMCD.clContrainteText2;
/*  65 */     this.clSelected = FormeInterneMCD.clSelected;
/*  66 */     this.clLienActiver = FormeInterneMCD.clLienActiverContainte2;
/*     */     
/*  68 */     this.historique = new ArrayList();
/*  69 */     this.historique.add(Historique.getHistoriqueCreation());
/*  70 */     this.commentaire = "";
/*  71 */     this.code = "";
/*  72 */     this.epaisseur = FormeInterneMCD.traitContraintes2;
/*  73 */     this.clOmbre = FormeInterneMCD.clOmbre2;
/*  74 */     setOmbre(FormeInterneMCD.isOmbree2);
/*  75 */     setClDegradee(FormeInterneMCD.isDegradee2);
/*  76 */     this.conversionContr = "";
/*  77 */     this.correct = true;
/*  78 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  83 */     Graphics2D g2d = (Graphics2D)g;
/*  84 */     if (isOmbre()) dessinerOmbre(g2d);
/*  85 */     Stroke stro = g2d.getStroke();
/*  86 */     float[] style = { 5.0F, 0.0F };
/*  87 */     g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*  88 */     dessinerContrainte(g2d);
/*     */     
/*  90 */     if (isSelected() == true) {
/*  91 */       dessinerSelected(g2d);
/*     */     }
/*  93 */     g2d.setStroke(stro);
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics2D g) {
/*  97 */     Color clgard = g.getColor();
/*  98 */     RoundRectangle2D rRect = new RoundRectangle2D.Double(getX() + 2, getY() + 2, getWidth() + 2, getHeight() + 2, getHeight(), getHeight());
/*     */     
/* 100 */     g.setColor(this.clOmbre);
/* 101 */     g.fill(rRect);
/*     */     
/* 103 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private void dessinerContrainte(Graphics2D g) {
/* 107 */     Color clgard = g.getColor();
/* 108 */     RoundRectangle2D rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight(), getHeight());
/* 109 */     g.setColor(getClFond2());
/*     */     
/* 111 */     if (isClDegradee()) {
/* 112 */       g.setPaint(new GradientPaint(getX(), getY(), getClFond2(), getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*     */     }
/* 114 */     g.fill(rRect);
/* 115 */     g.setColor(getClCadre2());
/* 116 */     g.draw(rRect);
/* 117 */     g.setColor(getClText2());
/* 118 */     int tail = g.getFontMetrics().stringWidth(getNom());
/*     */     
/* 120 */     Font f = g.getFont();
/* 121 */     g.setFont(getFont());
/* 122 */     g.drawString(getNom(), getX() + (getWidth() - tail) / 2, getY() + getHeight() - 9);
/*     */     
/* 124 */     g.setFont(f);
/* 125 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private void dessinerSelected(Graphics2D g) {
/* 129 */     Color clgard = g.getColor();
/* 130 */     g.setColor(getClSelected());
/*     */     
/* 132 */     RoundRectangle2D rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight(), getHeight());
/* 133 */     if (Setting.agraverSelection2) {
/* 134 */       Stroke stro = g.getStroke();
/* 135 */       float[] style = { 5.0F, 0.0F };
/* 136 */       g.setStroke(new BasicStroke(4.0F, 0, 0, 10.0F, style, 0.0F));
/* 137 */       g.draw(rRect);
/* 138 */       g.setStroke(stro);
/*     */     }
/*     */     
/* 141 */     g.draw(rRect);
/* 142 */     g.setColor(Color.BLACK);
/* 143 */     g.fillRect(getX() - 1 + getWidth() / 2, getY() - 1, 4, 4);
/* 144 */     g.fillRect(getX() - 1, getY() - 2 + getHeight() / 2, 4, 4);
/* 145 */     g.fillRect(getX() - 1 + getWidth() / 2, getY() - 1 + getHeight(), 4, 4);
/* 146 */     g.fillRect(getX() - 1 + getWidth(), getY() - 2 + getHeight() / 2, 4, 4);
/*     */     
/* 148 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   public Color getClCadre2()
/*     */   {
/* 153 */     return this.clCadre2;
/*     */   }
/*     */   
/*     */   public Color getClFond2() {
/* 157 */     return this.clFond2;
/*     */   }
/*     */   
/*     */   public Color getClLienActiver() {
/* 161 */     return this.clLienActiver;
/*     */   }
/*     */   
/*     */   public Color getClSelected() {
/* 165 */     return this.clSelected;
/*     */   }
/*     */   
/*     */   public Color getClText2() {
/* 169 */     return this.clText2;
/*     */   }
/*     */   
/*     */   public float getEpaisseur() {
/* 173 */     return this.epaisseur;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 177 */     return this.code;
/*     */   }
/*     */   
/*     */   public String getType() {
/* 181 */     return this.type;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/* 185 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 189 */     return this.font;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/* 193 */     return this.historique;
/*     */   }
/*     */   
/*     */   public double getZoom() {
/* 197 */     return this.zoom;
/*     */   }
/*     */   
/*     */   public Color getClOmbre() {
/* 201 */     return this.clOmbre;
/*     */   }
/*     */   
/*     */   public String getIdentifiant() {
/* 205 */     return this.identifiant;
/*     */   }
/*     */   
/*     */   public void setClCadre2(Color clCadre2) {
/* 209 */     this.clCadre2 = clCadre2;
/*     */   }
/*     */   
/*     */   public void setClFond2(Color clFond2) {
/* 213 */     this.clFond2 = clFond2;
/*     */   }
/*     */   
/*     */   public void setClLienActiver(Color clLienActiver) {
/* 217 */     this.clLienActiver = clLienActiver;
/*     */   }
/*     */   
/*     */   public void setClSelected(Color clSelected) {
/* 221 */     this.clSelected = clSelected;
/*     */   }
/*     */   
/*     */   public void setClText2(Color clText2) {
/* 225 */     this.clText2 = clText2;
/*     */   }
/*     */   
/*     */   public void setEpaisseur(float epaisseur) {
/* 229 */     this.epaisseur = epaisseur;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 233 */     this.code = code;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 237 */     this.type = type;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/* 241 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 245 */     this.font = font;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/* 249 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public void setZoom(double zoom) {
/* 253 */     this.zoom = zoom;
/*     */   }
/*     */   
/*     */   public void setClOmbre(Color clOmbre) {
/* 257 */     this.clOmbre = clOmbre;
/*     */   }
/*     */   
/*     */   public String getConversionContr() {
/* 261 */     return this.conversionContr;
/*     */   }
/*     */   
/*     */   public boolean isCorrect() {
/* 265 */     return this.correct;
/*     */   }
/*     */   
/*     */   public void setIdentifiant(String identifiant) {
/* 269 */     this.identifiant = identifiant;
/*     */   }
/*     */   
/*     */   public void setConversionContr(String conversionContr) {
/* 273 */     this.conversionContr = conversionContr;
/*     */   }
/*     */   
/*     */   public void setCorrect(boolean correct) {
/* 277 */     this.correct = correct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public IhmContrainte copier()
/*     */   {
/* 285 */     IhmContrainte2 cnt = new IhmContrainte2(getX() + 5, getY(), getWidth(), getHeight());
/* 286 */     cnt.setNom(getNom());
/* 287 */     cnt.setCode(getCode());
/* 288 */     cnt.setFont(getFont());
/* 289 */     cnt.setZoom(getZoom());
/* 290 */     cnt.setClCadre2(getClCadre2());
/* 291 */     cnt.setClFond2(getClFond2());
/* 292 */     cnt.setClText2(getClText2());
/* 293 */     cnt.setClLienActiver(getClLienActiver());
/* 294 */     cnt.setClSelected(getClSelected());
/* 295 */     cnt.setOmbre(isOmbre());
/* 296 */     cnt.setCommentaire(getCommentaire());
/* 297 */     cnt.setHistorique(copierHistoriques(getHistorique()));
/* 298 */     ajouterCopier(cnt.getHistorique());
/*     */     
/* 300 */     return cnt;
/*     */   }
/*     */   
/*     */   public void ajouterCopier(ArrayList<Historique> lhis) {
/* 304 */     Historique h = Historique.getHistoriqueCopie();
/* 305 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/* 306 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*     */     {
/* 308 */       lhis.add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/* 313 */     ArrayList<Historique> l = new ArrayList();
/* 314 */     for (int i = 0; i < lhis.size(); i++) {
/* 315 */       l.add(((Historique)lhis.get(i)).copier());
/*     */     }
/* 317 */     ajouterCopier(l);
/* 318 */     return l;
/*     */   }
/*     */   
/*     */   public void ajouterModification() {
/* 322 */     Historique h = Historique.getHistoriqueModification();
/* 323 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/* 324 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/* 325 */       getHistorique().add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public static IhmContrainte2 parseContrainte(IhmContrainte cnt)
/*     */   {
/* 331 */     IhmContrainte2 c = new IhmContrainte2(cnt.getX(), cnt.getY(), cnt.getWidth(), cnt.getHeight());
/* 332 */     c.setNom(cnt.getNom());
/* 333 */     c.setType(getTypeContrainte(c.getNom()));
/* 334 */     return c;
/*     */   }
/*     */   
/*     */   public static String getTypeContrainte(String s) {
/* 338 */     if (s.trim().toUpperCase().equals("X")) {
/* 339 */       return "EXCLUSIVITE";
/*     */     }
/* 341 */     if (s.trim().toUpperCase().equals("T")) {
/* 342 */       return "TOTALITE";
/*     */     }
/* 344 */     if ((s.trim().toUpperCase().equals("XT")) || (s.trim().toUpperCase().equals("+"))) {
/* 345 */       return "PARTITION";
/*     */     }
/* 347 */     if (s.trim().toUpperCase().equals("I")) {
/* 348 */       return "INCLUSION";
/*     */     }
/* 350 */     if ((s.trim().toUpperCase().equals("S")) || (s.trim().toUpperCase().equals("="))) {
/* 351 */       return "SIMULTANEITE";
/*     */     }
/* 353 */     return "";
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmContrainte2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */