/*      */ package IhmMLD2;
/*      */ 
/*      */ import Contrainte.AttributReference;
/*      */ import Contrainte.TableReference;
/*      */ import IhmMCD.IhmEntiteRelation;
/*      */ import Merise.Attribut;
/*      */ import Merise2.Attribut2;
/*      */ import Merise2.AttributContrainte2;
/*      */ import Merise2.Historique;
/*      */ import Outil.Parametres;
/*      */ import Outil.Setting;
/*      */ import Output.SQLOutil;
/*      */ import ihm.FormeInterneMCD;
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.FontMetrics;
/*      */ import java.awt.GradientPaint;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.Paint;
/*      */ import java.awt.Stroke;
/*      */ import java.awt.geom.RoundRectangle2D;
/*      */ import java.awt.geom.RoundRectangle2D.Double;
/*      */ import java.io.Serializable;
/*      */ import java.util.ArrayList;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JOptionPane;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MLDEntite2
/*      */   extends IhmEntiteRelation
/*      */   implements Serializable
/*      */ {
/*      */   private Color clCadre2;
/*      */   private Color clFond2;
/*      */   private Color clText2;
/*      */   private Color clTextType2;
/*      */   private Color clCadreTitre2;
/*      */   private Color clFondTitre2;
/*      */   private Color clTextTitre2;
/*      */   public Color clTextTaille2;
/*      */   public Color clTextTailleDec2;
/*      */   private Font font;
/*      */   private Font fontTitre;
/*      */   private Font fontAttribut;
/*      */   private Font fontType;
/*      */   private Font fontNormal;
/*      */   private Font fontNormalItalic;
/*      */   private Color clAttributSelect;
/*      */   private Color clLienActiver;
/*      */   private Color clSelected;
/*      */   private Color clPrk;
/*      */   private String aligne;
/*      */   private String aligneTitre;
/*      */   private int xType;
/*      */   private int xCle;
/*      */   private double zoom;
/*      */   private String alignerAttribut;
/*      */   private String alignerType;
/*      */   private int widthMin;
/*      */   private int widthMax;
/*      */   private int xAttribut;
/*      */   private int hAttribut;
/*      */   private int yAttribut;
/*      */   private int yEntete;
/*      */   private int decalCompose;
/*      */   private double AttEspace;
/*      */   float epaisseur;
/*      */   boolean prkvisible;
/*      */   boolean prkImage;
/*      */   boolean attMajuscule;
/*      */   Color clOmbre;
/*      */   boolean arrondir;
/*   93 */   private Color clFillSelAttribut = new Color(175, 203, 229, 90);
/*   94 */   private Color clStrokeSelAttribut = Color.BLUE;
/*      */   
/*      */   private ArrayList<Historique> historique;
/*      */   
/*      */   String nom;
/*      */   
/*      */   String code;
/*      */   
/*      */   ArrayList<Attribut> listeAttributs;
/*      */   
/*      */   IhmEntiteRelation entiteRef;
/*      */   
/*      */   String commentaire;
/*      */   
/*      */   boolean variable;
/*      */   
/*      */   boolean ombre;
/*      */   
/*      */   String typeEntite;
/*      */   
/*      */   ArrayList<TableReference> listeCNTForeingKey;
/*      */   ArrayList<TableReference> listeCNTAlternativeKey;
/*      */   boolean SQLGenerer;
/*      */   boolean mutex;
/*      */   Attribut attributSelect2;
/*      */   ArrayList<AttributContrainte2> listeIndex2;
/*      */   ArrayList<AttributContrainte2> listeUnique2;
/*      */   ArrayList<AttributContrainte2> listeCle2;
/*      */   ArrayList<AttributContrainte2> listeCleEtrangere2;
/*      */   String codeEntete2;
/*      */   String codeAttribut2;
/*      */   String codeMethodee;
/*      */   String codeFin2;
/*      */   String augmentation2;
/*      */   boolean augmentationPrefix2;
/*      */   boolean mldGenerer2;
/*      */   boolean afficherCodeEntite2;
/*      */   boolean afficherCodeAttribut2;
/*      */   String origine2;
/*      */   boolean mldHeritageGenerer2;
/*      */   boolean afficherCntUnique2;
/*      */   boolean afficherCntIndex2;
/*      */   boolean afficherCntCle2;
/*      */   boolean afficherCntCleEtrangere2;
/*      */   
/*      */   public MLDEntite2(String nom, int x, int y, int width, int hight, boolean isvariable)
/*      */   {
/*  141 */     super(x, y, width, hight, isvariable);
/*  142 */     this.clCadre2 = FormeInterneMCD.clEntiteCadre2;
/*  143 */     this.clFond2 = FormeInterneMCD.clEntiteFond2;
/*  144 */     this.clText2 = FormeInterneMCD.clEntiteText2;
/*  145 */     this.clTextType2 = FormeInterneMCD.clEntiteTextType2;
/*      */     
/*  147 */     this.clCadreTitre2 = FormeInterneMCD.clEntiteCadre2;
/*  148 */     this.clFondTitre2 = FormeInterneMCD.clEntiteFondTitre2;
/*  149 */     this.clTextTitre2 = FormeInterneMCD.clEntiteTextTitre2;
/*  150 */     this.clTextTaille2 = FormeInterneMCD.clEntiteTextTaille2;
/*  151 */     this.clTextTailleDec2 = FormeInterneMCD.clEntiteTextTailleDec2;
/*      */     
/*  153 */     this.clPrk = FormeInterneMCD.clPrk2;
/*      */     
/*  155 */     this.clLienActiver = FormeInterneMCD.clLienActiver2;
/*      */     
/*  157 */     this.font = Parametres.fontGras;
/*  158 */     this.fontTitre = Parametres.fontGras;
/*  159 */     this.fontNormal = Parametres.fontNormal;
/*  160 */     this.fontNormalItalic = Parametres.fontItalic12;
/*      */     
/*  162 */     this.clSelected = FormeInterneMCD.clSelected;
/*  163 */     this.arrondir = FormeInterneMCD.arrondirEntite2;
/*      */     
/*  165 */     this.aligne = "";
/*  166 */     this.aligneTitre = "";
/*  167 */     this.zoom = FormeInterneMCD.zoom;
/*      */     
/*  169 */     this.historique = new ArrayList();
/*  170 */     this.historique.add(Historique.getHistoriqueCreation());
/*  171 */     this.decalCompose = 14;
/*      */     
/*  173 */     this.AttEspace = FormeInterneMCD.interLigne2;
/*  174 */     this.epaisseur = FormeInterneMCD.traitEntiteRelation2;
/*  175 */     this.prkvisible = FormeInterneMCD.afficherPrk2;
/*  176 */     this.prkImage = FormeInterneMCD.afficherPrkImage2;
/*  177 */     this.attMajuscule = FormeInterneMCD.typeMajuscule2;
/*  178 */     setVariable(isvariable);
/*      */     
/*  180 */     this.clOmbre = FormeInterneMCD.clOmbre2;
/*  181 */     setOmbre(FormeInterneMCD.isOmbree2);
/*  182 */     setClDegradee(FormeInterneMCD.isDegradee2);
/*  183 */     this.nom = nom;
/*  184 */     this.listeAttributs = new ArrayList();
/*  185 */     this.entiteRef = null;
/*  186 */     this.commentaire = "";
/*  187 */     this.code = "";
/*  188 */     this.typeEntite = "ENTITE";
/*  189 */     this.listeCNTAlternativeKey = new ArrayList();
/*  190 */     this.listeCNTForeingKey = new ArrayList();
/*  191 */     this.SQLGenerer = false;
/*  192 */     this.mutex = false;
/*      */     
/*      */ 
/*  195 */     this.attributSelect2 = null;
/*  196 */     this.listeIndex2 = new ArrayList();
/*  197 */     this.listeUnique2 = new ArrayList();
/*  198 */     this.listeCle2 = new ArrayList();
/*  199 */     this.listeCleEtrangere2 = new ArrayList();
/*      */     
/*  201 */     this.codeEntete2 = "";
/*  202 */     this.codeAttribut2 = "";
/*  203 */     this.codeMethodee = "";
/*  204 */     this.codeFin2 = "";
/*      */     
/*  206 */     this.augmentation2 = "";
/*  207 */     this.augmentationPrefix2 = false;
/*  208 */     this.mldGenerer2 = true;
/*  209 */     this.afficherCodeEntite2 = false;
/*  210 */     this.afficherCodeAttribut2 = false;
/*  211 */     this.origine2 = "RELATION";
/*  212 */     this.mldHeritageGenerer2 = true;
/*      */     
/*  214 */     this.afficherCntCle2 = false;
/*  215 */     this.afficherCntCleEtrangere2 = false;
/*  216 */     this.afficherCntIndex2 = false;
/*  217 */     this.afficherCntUnique2 = false;
/*      */   }
/*      */   
/*      */ 
/*      */   public String getNom()
/*      */   {
/*  223 */     return this.nom;
/*      */   }
/*      */   
/*      */   public void setCode(String code) {
/*  227 */     this.code = code;
/*      */   }
/*      */   
/*      */   public String getCode() {
/*  231 */     return this.code;
/*      */   }
/*      */   
/*      */   public String getCommentaire() {
/*  235 */     return this.commentaire;
/*      */   }
/*      */   
/*      */   public ArrayList<Attribut> getListeAttributs() {
/*  239 */     return this.listeAttributs;
/*      */   }
/*      */   
/*      */   public void setListeAttributs(ArrayList<Attribut> listeAttributs) {
/*  243 */     this.listeAttributs = listeAttributs;
/*      */   }
/*      */   
/*      */   public void setNom(String nom) {
/*  247 */     this.nom = nom;
/*      */   }
/*      */   
/*      */   public String getTypeEntite() {
/*  251 */     return this.typeEntite;
/*      */   }
/*      */   
/*      */   public void setTypeEntite(String typeEntite) {
/*  255 */     this.typeEntite = typeEntite;
/*      */   }
/*      */   
/*      */   public void setCommentaire(String commentaire) {
/*  259 */     this.commentaire = commentaire;
/*      */   }
/*      */   
/*      */   public boolean isVariable()
/*      */   {
/*  264 */     return this.variable;
/*      */   }
/*      */   
/*      */   public void setVariable(boolean variable)
/*      */   {
/*  269 */     super.setVariable(variable);
/*  270 */     this.variable = variable;
/*      */   }
/*      */   
/*      */   public boolean isOmbre()
/*      */   {
/*  275 */     return this.ombre;
/*      */   }
/*      */   
/*      */   public void setOmbre(boolean ombre)
/*      */   {
/*  280 */     super.setOmbre(ombre);
/*  281 */     this.ombre = ombre;
/*      */   }
/*      */   
/*      */   public boolean isPrkImage() {
/*  285 */     return this.prkImage;
/*      */   }
/*      */   
/*      */   public void setPrkImage(boolean prkImage) {
/*  289 */     this.prkImage = prkImage;
/*      */   }
/*      */   
/*      */   public boolean isPrkvisible() {
/*  293 */     return this.prkvisible;
/*      */   }
/*      */   
/*      */   public void setPrkvisible(boolean prkvisible) {
/*  297 */     this.prkvisible = prkvisible;
/*      */   }
/*      */   
/*      */   public Color getClFondTitre2() {
/*  301 */     return this.clFondTitre2;
/*      */   }
/*      */   
/*      */   public Font getFontTitre() {
/*  305 */     return this.fontTitre;
/*      */   }
/*      */   
/*      */   public boolean isComposer()
/*      */   {
/*  310 */     for (int i = 0; i < this.listeAttributs.size(); i++) {
/*  311 */       Attribut2 att = (Attribut2)this.listeAttributs.get(i);
/*  312 */       if (att.getListeAttributs().size() > 0) {
/*  313 */         return true;
/*      */       }
/*      */     }
/*  316 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   public void paint(Graphics g)
/*      */   {
/*  322 */     Graphics2D g2d = (Graphics2D)g;
/*  323 */     g2d = (Graphics2D)g.create();
/*      */     
/*  325 */     Stroke stro = g2d.getStroke();
/*  326 */     float[] style = { 5.0F, 0.0F };
/*  327 */     g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*      */     
/*  329 */     ajousterTaille(g2d);
/*  330 */     dessinerOmbre(g2d);
/*  331 */     dessinerFondEntite(g2d);
/*  332 */     dessinerEntete(g2d);
/*      */     
/*  334 */     ecrireAttributs(g2d);
/*  335 */     if (isSelected()) dessinerSelected(g2d);
/*  336 */     g2d.setStroke(stro);
/*      */   }
/*      */   
/*      */   private void ecrireAttribut(Graphics2D g, Attribut2 att, int x, int y, int profondeur) {
/*  340 */     int dec = g.getFontMetrics().stringWidth("MeSs");
/*  341 */     if (!this.prkvisible) {
/*  342 */       dec = 4 + g.getFontMetrics().stringWidth("H");
/*      */     }
/*  344 */     dec += this.decalCompose * profondeur;
/*  345 */     g.setColor(this.clText2);
/*  346 */     if (isVariable()) {
/*  347 */       g.setFont(this.fontNormal);
/*  348 */       if (this.prkvisible) {
/*  349 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Cle)) {
/*  350 */           if (this.prkImage) {
/*  351 */             int h = g.getFontMetrics().getHeight();
/*  352 */             if (!att.isForeingKey()) g.drawImage(Parametres.imageCle, getX() + 6, y - h + 2, h + 3, h, null); else {
/*  353 */               g.drawImage(Parametres.imageClePrimaireEtr, getX() + 6, y - h + 2, h + 3, h, null);
/*      */             }
/*  355 */           } else if (!att.isForeingKey()) { g.drawString(" Pk", getX() + 3, y);
/*  356 */           } else { g.drawString("PFk", getX() + 3, y);
/*      */           }
/*      */         }
/*      */         
/*  360 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Index))
/*  361 */           if (this.prkImage) {
/*  362 */             int h = g.getFontMetrics().getHeight();
/*  363 */             g.drawImage(Parametres.imageCleIndex, getX() + 6, y - h + 2, h + 3, h, null);
/*  364 */           } else { g.drawString("Idx", getX() + 3, y);
/*      */           }
/*  366 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) {
/*  367 */           if (this.prkImage) {
/*  368 */             int h = g.getFontMetrics().getHeight();
/*  369 */             g.drawImage(Parametres.imageCleUnique, getX() + 6, y - h + 2, h + 3, h, null);
/*  370 */           } else { g.drawString("Unq", getX() + 3, y);
/*      */           }
/*      */         }
/*  373 */         if (att.getKey().trim().toUpperCase().equals(Parametres.CleEtr)) {
/*  374 */           if (this.prkImage) {
/*  375 */             int h = g.getFontMetrics().getHeight();
/*      */             
/*  377 */             g.drawImage(Parametres.imageCleEtr, getX() + 6, y - h + 2, h + 3, h, null);
/*      */           }
/*      */           else {
/*  380 */             g.drawString(" Fk", getX() + 3, y);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  386 */       if (att.getKey().equals(Parametres.Cle))
/*      */       {
/*  388 */         g.setFont(this.font);
/*  389 */         g.setColor(getColor(att.getClNom()));
/*  390 */         g.drawString(att.getNom(), x + dec, y);
/*  391 */         if (this.epaisseur > 1.0F) {
/*  392 */           Stroke stro = g.getStroke();
/*      */           
/*  394 */           float[] style = { 20.0F, 0.0F };
/*  395 */           g.setStroke(new BasicStroke(1.0F, 0, 0, 10.0F, style, 0.0F));
/*  396 */           g.drawLine(getX() + dec, y + 2, getX() + dec + g.getFontMetrics().stringWidth(att.getNom()), y + 2);
/*  397 */           g.setStroke(stro);
/*      */         }
/*      */         else {
/*  400 */           g.drawLine(getX() + dec, y + 2, getX() + dec + g.getFontMetrics().stringWidth(att.getNom()), y + 2);
/*      */         }
/*  402 */         g.setFont(this.fontNormal);
/*      */       } else {
/*  404 */         g.setColor(getColor(att.getClNom()));
/*  405 */         if (att.getListeAttributs().size() > 0) g.setFont(this.fontNormalItalic);
/*  406 */         g.drawString(att.getNom(), x + dec, y);
/*      */       }
/*  408 */       g.setColor(getColor(att.getClType()));
/*      */       
/*  410 */       if (att.getListeAttributs().size() == 0) {
/*  411 */         if (this.attMajuscule) {
/*  412 */           g.drawString(getTypeAttributSansTaille(att).toUpperCase(), this.xType + x, y);
/*      */         } else {
/*  414 */           g.drawString(getTypeAttributSansTaille(att), this.xType + x, y);
/*      */         }
/*  416 */         drawTailleType(att, g, this.xType + x, y);
/*      */       }
/*      */     } else {
/*  419 */       g.setFont(this.fontNormal);
/*  420 */       if (this.prkvisible) {
/*  421 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Cle)) {
/*  422 */           if (this.prkImage) {
/*  423 */             int h = g.getFontMetrics().getHeight();
/*  424 */             if (!att.isForeingKey()) g.drawImage(Parametres.imageCle, getX() + 6, y - h + 2, h + 3, h, null); else {
/*  425 */               g.drawImage(Parametres.imageClePrimaireEtr, getX() + 6, y - h + 2, h + 3, h, null);
/*      */             }
/*  427 */           } else if (!att.isForeingKey()) { g.drawString(" Pk", getX() + 3, y);
/*  428 */           } else { g.drawString("PFk", getX() + 3, y);
/*      */           }
/*      */         }
/*      */         
/*  432 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Index))
/*  433 */           if (this.prkImage) {
/*  434 */             int h = g.getFontMetrics().getHeight();
/*  435 */             g.drawImage(Parametres.imageCleIndex, getX() + 6, y - h + 2, h + 3, h, null);
/*  436 */           } else { g.drawString("Idx", getX() + 3, y);
/*      */           }
/*  438 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) {
/*  439 */           if (this.prkImage) {
/*  440 */             int h = g.getFontMetrics().getHeight();
/*  441 */             g.drawImage(Parametres.imageCleUnique, getX() + 6, y - h + 2, h + 3, h, null);
/*  442 */           } else { g.drawString("Unq", getX() + 3, y);
/*      */           }
/*      */         }
/*  445 */         if (att.getKey().trim().toUpperCase().equals(Parametres.CleEtr)) {
/*  446 */           if (this.prkImage) {
/*  447 */             int h = g.getFontMetrics().getHeight();
/*  448 */             g.drawImage(Parametres.imageCleEtr, getX() + 6, y - h + 2, h + 3, h, null);
/*  449 */           } else { g.drawString("Fk", getX() + 3, y);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  454 */       if (att.getKey().equals(Parametres.Cle)) {
/*  455 */         g.setFont(this.font);
/*  456 */         g.setColor(getColor(att.getClNom()));
/*  457 */         g.drawString(att.getNom(), x + dec, y);
/*  458 */         if (this.epaisseur > 1.0F) {
/*  459 */           Stroke stro = g.getStroke();
/*  460 */           float[] style = { 20.0F, 0.0F };
/*  461 */           g.setStroke(new BasicStroke(1.0F, 0, 0, 10.0F, style, 0.0F));
/*  462 */           g.drawLine(getX() + dec, y + 2, getX() + dec + g.getFontMetrics().stringWidth(att.getNom()), y + 2);
/*  463 */           g.setStroke(stro);
/*      */         } else {
/*  465 */           g.drawLine(getX() + dec, y + 2, getX() + dec + g.getFontMetrics().stringWidth(att.getNom()), y + 2);
/*      */         }
/*  467 */         g.setFont(this.fontNormal);
/*      */       } else {
/*  469 */         g.setColor(getColor(att.getClNom()));
/*  470 */         if (att.getListeAttributs().size() > 0) g.setFont(this.fontNormalItalic);
/*  471 */         g.drawString(att.getNom(), x + dec, y);
/*      */       }
/*      */     }
/*  474 */     if (att.getListeAttributs().size() > 0) {
/*  475 */       profondeur++;
/*  476 */       int y1 = y + 4;
/*  477 */       int h = g.getFontMetrics().getHeight();
/*  478 */       for (int i = 0; i < att.getListeAttributs().size(); i++) {
/*  479 */         y += (int)(h * this.AttEspace);
/*  480 */         ecrireAttribut(g, (Attribut2)att.getListeAttributs().get(i), x, y, profondeur);
/*  481 */         int nbAtt = nbAttributProfondeur((Attribut2)att.getListeAttributs().get(i), ((Attribut2)att.getListeAttributs().get(i)).getListeAttributs().size());
/*  482 */         y += (int)(h * (nbAtt * this.AttEspace));
/*      */       }
/*      */       
/*  485 */       int y2 = y + 1;
/*  486 */       g.setColor(this.clText2);
/*      */       
/*  488 */       if (this.epaisseur > 1.0F) {
/*  489 */         Stroke stro = g.getStroke();
/*  490 */         float[] style = { 20.0F, 0.0F };
/*  491 */         g.setStroke(new BasicStroke(1.0F, 0, 0, 10.0F, style, 0.0F));
/*      */         
/*  493 */         g.drawLine(x + dec + 8, y1 + 1, x + dec + 8, y2 + 1);
/*  494 */         g.drawLine(x + dec + 8, y2 + 1, x + dec + 15, y2 + 1);
/*  495 */         g.setStroke(stro);
/*      */       } else {
/*  497 */         g.drawLine(x + dec + 8, y1 + 1, x + dec + 8, y2 + 1);
/*  498 */         g.drawLine(x + dec + 8, y2 + 1, x + dec + 15, y2 + 1);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void ecrireAttributs(Graphics2D g) {
/*  504 */     int nbAfficher = 0;
/*  505 */     if (getListeAttributs() != null)
/*      */     {
/*  507 */       int nb = getListeAttributs().size();
/*  508 */       int y = g.getFontMetrics().getHeight() * 3;
/*  509 */       int i = 0;
/*  510 */       int h = g.getFontMetrics().getHeight();
/*  511 */       this.yAttribut = y;
/*  512 */       this.hAttribut = h;
/*      */       
/*  514 */       while (i < nb) {
/*  515 */         if (((Attribut2)getListeAttributs().get(i)).isAfficher()) {
/*  516 */           ecrireAttribut(g, (Attribut2)getListeAttributs().get(i), getX(), getY() + y, 0);
/*  517 */           int nbAtt = nbAttributProfondeur((Attribut2)getListeAttributs().get(i), ((Attribut2)getListeAttributs().get(i)).getListeAttributs().size());
/*  518 */           y += (int)(h * (this.AttEspace * (nbAtt + 1)));
/*      */           
/*      */ 
/*  521 */           nbAfficher++;
/*      */         }
/*  523 */         i++;
/*      */       }
/*  525 */       if (nbAfficher < getListeAttributs().size()) {
/*  526 */         ecrireAttribut(g, "...", getX(), getY() + y);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void ecrireAttribut(Graphics g, String att, int x, int y) {
/*  532 */     int dec = g.getFontMetrics().stringWidth("MeSs");
/*  533 */     g.setColor(this.clText2);
/*  534 */     if (!this.prkvisible) {
/*  535 */       dec = 3;
/*      */     }
/*  537 */     g.drawString(att, x + dec, y);
/*      */   }
/*      */   
/*      */ 
/*      */   private void dessinerSelected(Graphics2D g)
/*      */   {
/*  543 */     Color clgard = g.getColor();
/*  544 */     g.setColor(this.clSelected);
/*  545 */     Stroke stro = g.getStroke();
/*  546 */     if (Setting.agraverSelection2) {
/*  547 */       g.setColor(this.clLienActiver);
/*  548 */       g.drawRect(getX() - 3, getY() - 3, getWidth() + 6, getHeight() + 6);
/*  549 */       float[] style = { 5.0F, 0.0F };
/*  550 */       g.setStroke(new BasicStroke(4.0F, 0, 0, 10.0F, style, 0.0F));
/*      */       
/*  552 */       g.setColor(this.clSelected);
/*      */     }
/*  554 */     g.drawRect(getX(), getY(), getWidth(), getHeight());
/*      */     
/*  556 */     g.setColor(Color.BLACK);
/*  557 */     g.fillRect(getX() - 1, getY() - 1, 4, 4);
/*  558 */     g.fillRect(getX() - 1, getY() - 2 + getHeight(), 4, 4);
/*  559 */     g.fillRect(getX() - 1 + getWidth(), getY() - 1, 4, 4);
/*  560 */     g.fillRect(getX() - 1 + getWidth(), getY() - 2 + getHeight(), 4, 4);
/*      */     
/*  562 */     g.fillRect(getCentreX() - 1, getY() + getHeight() - 1, 4, 4);
/*  563 */     g.fillRect(getCentreX() - 1, getY() - 1, 4, 4);
/*      */     
/*  565 */     g.fillRect(getX() - 1, getY() + getHeight() / 2 - 1, 4, 4);
/*  566 */     g.fillRect(getX() + getWidth() - 1, getY() + getHeight() / 2 - 1, 4, 4);
/*      */     
/*  568 */     g.setColor(clgard);
/*  569 */     g.setStroke(stro);
/*      */   }
/*      */   
/*      */   private void dessinerEntete(Graphics2D g) {
/*  573 */     Color clgard = g.getColor();
/*  574 */     Graphics2D g2d = g;
/*  575 */     int h = g.getFontMetrics().getHeight();
/*  576 */     int ht = h + h / 2;
/*  577 */     Paint p = g.getPaint();
/*      */     
/*  579 */     g.setColor(this.clFondTitre2);
/*  580 */     if (isClDegradee())
/*      */     {
/*  582 */       g2d.setPaint(new GradientPaint(getX(), getY(), getClFondTitre2(), getX() + getWidth(), getY() + ht, Color.WHITE, true));
/*      */     }
/*  584 */     if (this.arrondir) {
/*  585 */       RoundRectangle2D rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), ht, 10.0D, 10.0D);
/*  586 */       g.fill(rRect);
/*  587 */       g.setColor(this.clCadreTitre2);
/*  588 */       g.draw(rRect);
/*  589 */       g.setColor(this.clFondTitre2);
/*  590 */       if (isClDegradee()) {
/*  591 */         g.setPaint(p);
/*  592 */         g.setColor(this.clFondTitre2);
/*  593 */         g.fillRect(getX(), getY() + ht - 3, 8, 3);
/*  594 */         g.setColor(Color.WHITE);
/*  595 */         g.fillRect(getX() + getWidth() - 8, getY() + ht - 3, 8, 3);
/*      */       } else {
/*  597 */         g.setColor(this.clFondTitre2);
/*  598 */         g.fillRect(getX(), getY() + ht - 3, 8, 3);
/*  599 */         g.fillRect(getX() + getWidth() - 8, getY() + ht - 3, 8, 3);
/*      */       }
/*  601 */       rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), 10.0D, 10.0D);
/*  602 */       g.setColor(this.clCadreTitre2);
/*  603 */       g.draw(rRect);
/*  604 */       g.drawLine(getX(), getY() + ht, getX() + getWidth(), getY() + ht);
/*      */     }
/*      */     else {
/*  607 */       g2d.fillRect(getX(), getY(), getWidth(), ht);
/*  608 */       g.setColor(this.clCadreTitre2);
/*  609 */       g2d.drawRect(getX(), getY(), getWidth(), ht);
/*      */     }
/*  611 */     g.setFont(getFontTitre());
/*  612 */     g.setColor(this.clTextTitre2);
/*  613 */     String s = getNom();
/*  614 */     g.drawString(s, getX() + (getWidth() - g.getFontMetrics().stringWidth(s)) / 2, getY() + h);
/*  615 */     g.setColor(clgard);
/*      */   }
/*      */   
/*      */   private void dessinerOmbre(Graphics2D g) {
/*  619 */     if (!isOmbre()) return;
/*  620 */     Color clgard = g.getColor();
/*  621 */     g.setColor(this.clOmbre);
/*  622 */     if (this.arrondir) {
/*  623 */       RoundRectangle2D rRect = new RoundRectangle2D.Double(getX() + 5, getY() + 3, getWidth(), getHeight() + 2, 10.0D, 10.0D);
/*  624 */       g.fill(rRect);
/*      */     } else {
/*  626 */       g.fillRect(getX() + 5, getY() + 3, getWidth(), getHeight() + 3);
/*      */     }
/*  628 */     g.setColor(clgard);
/*      */   }
/*      */   
/*      */   private void dessinerFondEntite(Graphics2D g) {
/*  632 */     Color clgard = g.getColor();
/*  633 */     g.setColor(Color.GRAY);
/*  634 */     Graphics2D g2d = g;
/*  635 */     g.setColor(this.clFond2);
/*  636 */     if (isClDegradee()) {
/*  637 */       g2d.setPaint(new GradientPaint(getX(), getY(), this.clFond2, getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*      */     }
/*  639 */     if (this.arrondir) {
/*  640 */       RoundRectangle2D rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), 10.0D, 10.0D);
/*  641 */       g.fill(rRect);
/*  642 */       dessinerPrk(g);
/*  643 */       g.setColor(this.clCadre2);
/*  644 */       g.draw(rRect);
/*      */     } else {
/*  646 */       g.fillRect(getX(), getY(), getWidth(), getHeight());
/*  647 */       dessinerPrk(g);
/*  648 */       g.setColor(this.clCadre2);
/*  649 */       g.drawRect(getX(), getY(), getWidth(), getHeight());
/*      */     }
/*  651 */     g.setColor(clgard);
/*      */   }
/*      */   
/*      */   private void dessinerPrk(Graphics2D g) {
/*  655 */     if (isAffcher()) {
/*  656 */       Color clgard = g.getColor();
/*  657 */       g.setColor(Color.GRAY);
/*  658 */       Graphics2D g2d = g;
/*  659 */       g.setColor(this.clPrk);
/*  660 */       int larg = g.getFontMetrics().stringWidth("KPrk");
/*  661 */       g.fillRect(getX() + 2, getY(), larg, getHeight() - 2);
/*  662 */       g.setColor(clgard);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean isAffcher() {
/*  667 */     if (isPrkvisible()) {
/*  668 */       for (int i = 0; i < getListeAttributs().size(); i++) {
/*  669 */         if (((Attribut2)getListeAttributs().get(i)).isAfficher()) return true;
/*      */       }
/*      */     }
/*  672 */     return false;
/*      */   }
/*      */   
/*      */   public void ajousterTaille(Graphics2D g) {
/*  676 */     g.setFont(this.fontTitre);
/*  677 */     int h = calculerHeightEntite(g);
/*  678 */     int w = calculerWidthEntite(g);
/*  679 */     redimentionner(getX(), getY(), w, h);
/*      */   }
/*      */   
/*      */ 
/*      */   private int getWidthMaxSousAttribut(Graphics2D g, Attribut2 att, int max, int profondeur)
/*      */   {
/*  685 */     profondeur++;
/*  686 */     int nb = att.getListeAttributs().size();
/*  687 */     String pk = Parametres.Cle;
/*  688 */     for (int i = 0; i < nb; i++) {
/*  689 */       if (((Attribut2)att.getListeAttributs().get(i)).isAfficher()) {
/*  690 */         String s = ((Attribut2)att.getListeAttributs().get(i)).getNomHistrosation();
/*  691 */         int w; if (((Attribut)att.getListeAttributs().get(i)).getKey().equals(pk)) {
/*  692 */           g.setFont(this.font);
/*  693 */           w = g.getFontMetrics().stringWidth(s);
/*  694 */           g.setFont(this.fontNormal);
/*  695 */         } else { w = g.getFontMetrics().stringWidth(s); }
/*  696 */         if (w + this.decalCompose * profondeur > max) {
/*  697 */           max = w + this.decalCompose * profondeur;
/*      */         }
/*  699 */         max = getWidthMaxSousAttribut(g, (Attribut2)att.getListeAttributs().get(i), max, profondeur);
/*      */       }
/*      */     }
/*      */     
/*  703 */     return max;
/*      */   }
/*      */   
/*      */   private int getWidthNomAttribut(Graphics2D g)
/*      */   {
/*  708 */     int w = 0;
/*  709 */     int wMax = 0;
/*      */     
/*  711 */     String pk = Parametres.Cle;
/*  712 */     int nb = getListeAttributs().size();
/*  713 */     for (int i = 0; i < nb; i++) {
/*  714 */       if (((Attribut2)getListeAttributs().get(i)).isAfficher()) {
/*  715 */         String s = ((Attribut2)getListeAttributs().get(i)).getNomHistrosation();
/*  716 */         if (((Attribut)getListeAttributs().get(i)).getKey().equals(pk)) {
/*  717 */           g.setFont(this.font);
/*  718 */           w = g.getFontMetrics().stringWidth(s);
/*  719 */           g.setFont(this.fontNormal);
/*  720 */         } else { w = g.getFontMetrics().stringWidth(s); }
/*  721 */         if (w > wMax) {
/*  722 */           wMax = w;
/*      */         }
/*  724 */         if (((Attribut2)getListeAttributs().get(i)).getListeAttributs().size() > 0) {
/*  725 */           wMax = getWidthMaxSousAttribut(g, (Attribut2)getListeAttributs().get(i), wMax, 0);
/*      */         }
/*      */       }
/*      */     }
/*  729 */     return wMax;
/*      */   }
/*      */   
/*      */ 
/*      */   private int calculerWidthEntite(Graphics2D g)
/*      */   {
/*  735 */     int wEntete = g.getFontMetrics().stringWidth(getNom() + "MESS");
/*  736 */     int wAtt = getWidthNomAttribut(g);
/*  737 */     int wType = 0;
/*  738 */     int wPrk = wPrk = g.getFontMetrics().stringWidth("H");
/*  739 */     if (isVariable()) wType = getWidthType(g);
/*  740 */     if (this.prkvisible) wPrk = g.getFontMetrics().stringWidth("HHHH");
/*  741 */     int wtotal = g.getFontMetrics().stringWidth("H");
/*  742 */     this.xType = (wtotal + wAtt + wPrk);
/*  743 */     wtotal = wtotal + wAtt + wType + wPrk;
/*  744 */     if (wtotal < wEntete) {
/*  745 */       wtotal = wEntete;
/*      */     } else {
/*  747 */       wtotal += g.getFontMetrics().stringWidth("HH");
/*      */     }
/*  749 */     if (!this.prkvisible) {
/*  750 */       this.xType += 3;
/*      */     }
/*  752 */     if (!isVariable()) {
/*  753 */       wtotal += 8;
/*      */     }
/*  755 */     return wtotal - g.getFontMetrics().stringWidth("H");
/*      */   }
/*      */   
/*      */   private int getWidthType(Graphics2D g)
/*      */   {
/*  760 */     int w = 0;
/*  761 */     int wMax = 0;
/*  762 */     int nb = getListeAttributs().size();
/*  763 */     for (int i = 0; i < nb; i++) {
/*  764 */       if (((Attribut2)getListeAttributs().get(i)).isAfficher()) {
/*  765 */         w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)getListeAttributs().get(i)));
/*  766 */         if (this.attMajuscule) {
/*  767 */           w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)getListeAttributs().get(i)).toUpperCase());
/*      */         }
/*  769 */         if (w > wMax) {
/*  770 */           wMax = w + 4;
/*      */         }
/*      */         
/*  773 */         if (((Attribut2)getListeAttributs().get(i)).getListeAttributs().size() > 0) {
/*  774 */           wMax = getWidthMaxType(g, (Attribut2)getListeAttributs().get(i), wMax);
/*      */         }
/*      */       }
/*      */     }
/*  778 */     return wMax;
/*      */   }
/*      */   
/*      */ 
/*      */   private int getWidthMaxType(Graphics2D g, Attribut2 att, int max)
/*      */   {
/*  784 */     int nb = att.getListeAttributs().size();
/*  785 */     for (int i = 0; i < nb; i++) {
/*  786 */       if (((Attribut2)att.getListeAttributs().get(i)).isAfficher()) {
/*  787 */         int w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)att.getListeAttributs().get(i)));
/*  788 */         if (this.attMajuscule) {
/*  789 */           w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)att.getListeAttributs().get(i)).toUpperCase());
/*      */         }
/*  791 */         if (w > max) {
/*  792 */           max = w + 4;
/*      */         }
/*  794 */         max = getWidthMaxType(g, (Attribut2)att.getListeAttributs().get(i), max);
/*      */       }
/*      */     }
/*  797 */     return max;
/*      */   }
/*      */   
/*      */   private String getTypeAttribut(Attribut2 att) {
/*  801 */     if (att == null) return "";
/*  802 */     String t = "";
/*  803 */     if (att.getType().trim().length() == 0) return "";
/*  804 */     if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/*  805 */       t = att.getType();
/*  806 */       if (att.isUnSigned()) t = "+" + t;
/*  807 */       return t;
/*      */     }
/*      */     
/*  810 */     if ((att.getLongueur() < 0) && (att.getLongDecimale() < 0)) {
/*  811 */       t = att.getType();
/*  812 */       if (att.isUnSigned()) t = "+" + t;
/*  813 */       return t;
/*      */     }
/*  815 */     if (att.getLongueur() < 0) {
/*  816 */       t = att.getType();
/*  817 */       if (att.isUnSigned()) t = "+" + t;
/*  818 */       return t + " (0," + att.getLongDecimale() + ")";
/*      */     }
/*  820 */     if (att.getLongDecimale() > 0) {
/*  821 */       t = att.getType();
/*  822 */       if (att.isUnSigned()) t = "+" + t;
/*  823 */       return t + " (" + att.getLongueur() + "," + att.getLongDecimale() + ")";
/*      */     }
/*  825 */     t = att.getType();
/*  826 */     if (att.isUnSigned()) t = "+" + t;
/*  827 */     return t + " (" + att.getLongueur() + ")";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void drawTailleType(Attribut2 att, Graphics2D g, int x, int y)
/*      */   {
/*  836 */     String car = getTypeAttribut(att);
/*      */     
/*  838 */     if (!isDrawTaille(car)) { return;
/*      */     }
/*  840 */     String type = att.getType();
/*  841 */     if (att.isUnSigned()) { type = "+" + type;
/*      */     }
/*  843 */     if (this.attMajuscule) {
/*  844 */       type = type.toUpperCase();
/*      */     }
/*      */     
/*  847 */     type = type + " ";
/*      */     
/*  849 */     int wtype = g.getFontMetrics().stringWidth(type);
/*  850 */     g.drawString("(", x + wtype, y);
/*  851 */     Color cl = g.getColor();
/*      */     
/*  853 */     type = type + "(";
/*  854 */     wtype = g.getFontMetrics().stringWidth(type);
/*  855 */     int t = att.getLongueur();
/*  856 */     if (t < 0) { t = 0;
/*      */     }
/*  858 */     g.setColor(getColor(att.getClTaille()));
/*  859 */     g.drawString(t + "", x + wtype, y);
/*      */     
/*  861 */     if (att.getLongDecimale() > -1) {
/*  862 */       type = type + t;
/*  863 */       wtype = g.getFontMetrics().stringWidth(type);
/*  864 */       g.setColor(cl);
/*  865 */       g.drawString(",", x + wtype, y);
/*  866 */       type = type + ",";
/*  867 */       wtype = g.getFontMetrics().stringWidth(type);
/*  868 */       t = att.getLongDecimale();
/*  869 */       g.setColor(getColor(att.getClTailleDecimale()));
/*  870 */       g.drawString(t + "", x + wtype, y);
/*  871 */       type = type + t;
/*  872 */       wtype = g.getFontMetrics().stringWidth(type);
/*  873 */       g.setColor(cl);
/*  874 */       g.drawString(")", x + wtype, y);
/*      */     } else {
/*  876 */       type = type + t;
/*  877 */       wtype = g.getFontMetrics().stringWidth(type);
/*  878 */       g.setColor(cl);
/*  879 */       g.drawString(")", x + wtype, y);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean isDrawTaille(String car)
/*      */   {
/*  886 */     if ((car.contains("(")) && (car.contains(")"))) return true;
/*  887 */     return false;
/*      */   }
/*      */   
/*      */   private String getTypeAttributSansTaille(Attribut2 att) {
/*  891 */     if (att == null) return "";
/*  892 */     String t = "";
/*  893 */     if (att.getType().trim().length() == 0) return "";
/*  894 */     if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/*  895 */       t = att.getType();
/*  896 */       if (att.isUnSigned()) t = "+" + t;
/*  897 */       return t;
/*      */     }
/*  899 */     t = att.getType();
/*  900 */     if (att.isUnSigned()) t = "+" + t;
/*  901 */     return t;
/*      */   }
/*      */   
/*      */   private int calculerHeightEntite(Graphics2D g)
/*      */   {
/*  906 */     int h = g.getFontMetrics().getHeight();
/*  907 */     int hauteur = 0;
/*  908 */     int nbAfficher = 0;
/*      */     
/*  910 */     int nb = getListeAttributs().size();
/*  911 */     if (nb == 0) return (int)(h * 2.5D);
/*  912 */     for (int i = 0; i < nb; i++) {
/*  913 */       Attribut2 att = (Attribut2)getListeAttributs().get(i);
/*  914 */       if (att.isAfficher()) {
/*  915 */         int nbAtt = nbAttributProfondeur(att, att.getListeAttributs().size());
/*  916 */         hauteur = (int)((1 + nbAtt) * this.AttEspace * h) + hauteur;
/*  917 */         nbAfficher++;
/*      */       }
/*      */     }
/*  920 */     if (nbAfficher < nb) {
/*  921 */       hauteur += 1 * h;
/*      */     }
/*  923 */     if (nb > 0) {
/*  924 */       hauteur += 2 * h;
/*      */     }
/*      */     
/*  927 */     return hauteur + h;
/*      */   }
/*      */   
/*      */   private int nbAttributProfondeur(Attribut2 att, int nb) {
/*  931 */     if (att.getListeAttributs().size() == 0) { return 0;
/*      */     }
/*  933 */     for (int i = 0; i < att.getListeAttributs().size(); i++) {
/*  934 */       nb += nbAttributProfondeur((Attribut2)att.getListeAttributs().get(i), ((Attribut2)att.getListeAttributs().get(i)).getListeAttributs().size());
/*      */     }
/*  936 */     return nb;
/*      */   }
/*      */   
/*      */   public double getAttEspace() {
/*  940 */     return this.AttEspace;
/*      */   }
/*      */   
/*      */   public boolean isArrondir() {
/*  944 */     return this.arrondir;
/*      */   }
/*      */   
/*      */   public boolean isAttMajuscule() {
/*  948 */     return this.attMajuscule;
/*      */   }
/*      */   
/*      */   public Color getClCadre2() {
/*  952 */     return this.clCadre2;
/*      */   }
/*      */   
/*      */   public Color getClCadreTitre2() {
/*  956 */     return this.clCadreTitre2;
/*      */   }
/*      */   
/*      */   public Color getClFond2() {
/*  960 */     return this.clFond2;
/*      */   }
/*      */   
/*      */   public Color getClLienActiver() {
/*  964 */     return this.clLienActiver;
/*      */   }
/*      */   
/*      */   public Color getClOmbre() {
/*  968 */     return this.clOmbre;
/*      */   }
/*      */   
/*      */   public Color getClPrk() {
/*  972 */     return this.clPrk;
/*      */   }
/*      */   
/*      */   public Color getClSelected() {
/*  976 */     return this.clSelected;
/*      */   }
/*      */   
/*      */   public Color getClText2() {
/*  980 */     return this.clText2;
/*      */   }
/*      */   
/*      */   public Color getClTextTitre2() {
/*  984 */     return this.clTextTitre2;
/*      */   }
/*      */   
/*      */   public Color getClTextType2() {
/*  988 */     return this.clTextType2;
/*      */   }
/*      */   
/*      */   public boolean isMutex() {
/*  992 */     return this.mutex;
/*      */   }
/*      */   
/*      */   public int getDecalCompose() {
/*  996 */     return this.decalCompose;
/*      */   }
/*      */   
/*      */   public float getEpaisseur() {
/* 1000 */     return this.epaisseur;
/*      */   }
/*      */   
/*      */   public double getZoom() {
/* 1004 */     return this.zoom;
/*      */   }
/*      */   
/*      */   public void setAttEspace(double AttEspace) {
/* 1008 */     this.AttEspace = AttEspace;
/*      */   }
/*      */   
/*      */   public void setArrondir(boolean arrondir) {
/* 1012 */     this.arrondir = arrondir;
/*      */   }
/*      */   
/*      */   public void setAttMajuscule(boolean attMajuscule) {
/* 1016 */     this.attMajuscule = attMajuscule;
/*      */   }
/*      */   
/*      */   public void setClAttributSelect(Color clAttributSelect) {
/* 1020 */     this.clAttributSelect = clAttributSelect;
/*      */   }
/*      */   
/*      */   public void setClCadre2(Color clCadre2) {
/* 1024 */     this.clCadre2 = clCadre2;
/*      */   }
/*      */   
/*      */   public void setClCadreTitre2(Color clCadreTitre2) {
/* 1028 */     this.clCadreTitre2 = clCadreTitre2;
/*      */   }
/*      */   
/*      */   public void setClFond2(Color clFond2) {
/* 1032 */     this.clFond2 = clFond2;
/*      */   }
/*      */   
/*      */   public void setClFondTitre2(Color clFondTitre2) {
/* 1036 */     this.clFondTitre2 = clFondTitre2;
/*      */   }
/*      */   
/*      */   public void setClLienActiver(Color clLienActiver) {
/* 1040 */     this.clLienActiver = clLienActiver;
/*      */   }
/*      */   
/*      */   public void setClOmbre(Color clOmbre) {
/* 1044 */     this.clOmbre = clOmbre;
/*      */   }
/*      */   
/*      */   public void setClPrk(Color clPrk) {
/* 1048 */     this.clPrk = clPrk;
/*      */   }
/*      */   
/*      */   public void setClSelected(Color clSelected) {
/* 1052 */     this.clSelected = clSelected;
/*      */   }
/*      */   
/*      */   public void setClText2(Color clText2) {
/* 1056 */     this.clText2 = clText2;
/*      */   }
/*      */   
/*      */   public void setClTextTitre2(Color clTextTitre2) {
/* 1060 */     this.clTextTitre2 = clTextTitre2;
/*      */   }
/*      */   
/*      */   public void setClTextType2(Color clTextType2) {
/* 1064 */     this.clTextType2 = clTextType2;
/*      */   }
/*      */   
/*      */   public void setDecalCompose(int decalCompose) {
/* 1068 */     this.decalCompose = decalCompose;
/*      */   }
/*      */   
/*      */   public void setEpaisseur(float epaisseur) {
/* 1072 */     this.epaisseur = epaisseur;
/*      */   }
/*      */   
/*      */   public void setZoom(double zoom) {
/* 1076 */     this.zoom = zoom;
/*      */   }
/*      */   
/*      */   public void setMutex(boolean mutex) {
/* 1080 */     this.mutex = mutex;
/*      */   }
/*      */   
/*      */   public ArrayList<TableReference> getListeCNTALTERNATIVEKEY() {
/* 1084 */     return this.listeCNTAlternativeKey;
/*      */   }
/*      */   
/*      */   public ArrayList<TableReference> getListeCNTForeingKey() {
/* 1088 */     return this.listeCNTForeingKey;
/*      */   }
/*      */   
/*      */   public void setListeCNTALTERNATIVEKEY(ArrayList<TableReference> listeCNTALTERNATIVEKEY) {
/* 1092 */     this.listeCNTAlternativeKey = listeCNTALTERNATIVEKEY;
/*      */   }
/*      */   
/*      */   public void setListeCNTForeingKey(ArrayList<TableReference> listeCNTForeingKey) {
/* 1096 */     this.listeCNTForeingKey = listeCNTForeingKey;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void addContrainteFK(TableReference tab)
/*      */   {
/* 1103 */     this.listeCNTForeingKey.add(tab);
/*      */   }
/*      */   
/*      */   public void addContrainteAK_UNIQUE(TableReference tab)
/*      */   {
/* 1108 */     this.listeCNTAlternativeKey.add(tab);
/*      */   }
/*      */   
/*      */   public boolean isSQLGenerer() {
/* 1112 */     return this.SQLGenerer;
/*      */   }
/*      */   
/*      */   public void setSQLGenerer(boolean SQLGenerer) {
/* 1116 */     this.SQLGenerer = SQLGenerer;
/*      */   }
/*      */   
/*      */   public String afficherListecontrainteFK()
/*      */   {
/* 1121 */     String s = "\nContrainte de : " + getNom();
/*      */     
/* 1123 */     for (int i = 0; i < this.listeCNTForeingKey.size(); i++) {
/* 1124 */       s = s + "\n=============DEBUT FK =================\n";
/* 1125 */       s = s + ((TableReference)this.listeCNTForeingKey.get(i)).toString();
/* 1126 */       s = s + "\n=============FIN FK =================\n";
/*      */     }
/*      */     
/* 1129 */     for (int i = 0; i < this.listeCNTAlternativeKey.size(); i++) {
/* 1130 */       s = s + "\n=============DEBUT AK =================\n";
/* 1131 */       s = s + ((TableReference)this.listeCNTAlternativeKey.get(i)).toString();
/* 1132 */       s = s + "\n=============FIN AK =================\n";
/*      */     }
/*      */     
/* 1135 */     return s;
/*      */   }
/*      */   
/*      */ 
/*      */   private void getListeAttributCle(ArrayList<Attribut> listeKey, ArrayList<Attribut> listeAtt)
/*      */   {
/* 1141 */     for (int i = 0; i < listeAtt.size(); i++) {
/* 1142 */       Attribut2 att = (Attribut2)listeAtt.get(i);
/* 1143 */       if (att.getListeAttributs().size() == 0) {
/* 1144 */         if ((att.getKey().equals(Parametres.Cle)) && 
/* 1145 */           (!((Attribut2)listeAtt.get(i)).isForeingKey())) listeKey.add(listeAtt.get(i));
/*      */       }
/*      */       else {
/* 1148 */         getListeAttributCle(listeKey, att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Attribut> getListeKey() {
/* 1154 */     ArrayList<Attribut> listeKey = new ArrayList();
/* 1155 */     getListeAttributCle(listeKey, getListeAttributs());
/* 1156 */     return listeKey;
/*      */   }
/*      */   
/*      */   private void getListeAttributCleETEtrang(ArrayList<Attribut> listeKey, ArrayList<Attribut> listeAtt)
/*      */   {
/* 1161 */     for (int i = 0; i < listeAtt.size(); i++) {
/* 1162 */       Attribut2 att = (Attribut2)listeAtt.get(i);
/* 1163 */       if (att.getListeAttributs().size() == 0) {
/* 1164 */         if ((att.getKey().equals(Parametres.Cle)) && 
/* 1165 */           (((Attribut2)listeAtt.get(i)).isForeingKey())) listeKey.add(listeAtt.get(i));
/*      */       }
/*      */       else {
/* 1168 */         getListeAttributCleETEtrang(listeKey, att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Attribut> getListeKeyANDForeignKey() {
/* 1174 */     ArrayList<Attribut> listeKey = new ArrayList();
/* 1175 */     getListeAttributCleETEtrang(listeKey, getListeAttributs());
/* 1176 */     return listeKey;
/*      */   }
/*      */   
/*      */   private void trierListeContrainte()
/*      */   {
/* 1181 */     for (int i = 0; i < this.listeCNTAlternativeKey.size(); i++) {
/* 1182 */       ((TableReference)this.listeCNTAlternativeKey.get(i)).trierListeAttributReferent();
/*      */     }
/* 1184 */     for (int i = 0; i < this.listeCNTAlternativeKey.size(); i++) {
/* 1185 */       ((TableReference)this.listeCNTAlternativeKey.get(i)).trierListeAttributReferent();
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean existeDejaTableReference(ArrayList<TableReference> liste, TableReference tab) {
/* 1190 */     for (int i = 0; i < liste.size(); i++) {
/* 1191 */       if (liste.get(i) == tab) return true;
/*      */     }
/* 1193 */     return false;
/*      */   }
/*      */   
/*      */   private TableReference retournerTableReference(Attribut att)
/*      */   {
/* 1198 */     for (int i = 0; i < this.listeCNTForeingKey.size(); i++) {
/* 1199 */       ArrayList<AttributReference> listeAtt = ((TableReference)this.listeCNTForeingKey.get(i)).getListeAttributRef();
/* 1200 */       for (int j = 0; j < listeAtt.size(); j++) {
/* 1201 */         if (((AttributReference)listeAtt.get(j)).getAttribut() == att) return (TableReference)this.listeCNTForeingKey.get(i);
/*      */       }
/*      */     }
/* 1204 */     return null;
/*      */   }
/*      */   
/*      */   private void reorganiserLesCleEtrangere() {
/* 1208 */     if (!getTypeEntite().equals("RELATION")) return;
/* 1209 */     ArrayList<Attribut> listeCle = getListeKeyANDForeignKey();
/* 1210 */     ArrayList<TableReference> listeTabl = new ArrayList();
/*      */     
/* 1212 */     for (int i = 0; i < listeCle.size(); i++) {
/* 1213 */       TableReference tab = retournerTableReference((Attribut)listeCle.get(i));
/* 1214 */       if (tab != null) {
/* 1215 */         listeTabl.add(tab);
/*      */       } else {
/* 1217 */         JOptionPane.showMessageDialog(new JFrame(), " Tres grave Table Reference pour un attribut non trouvé:\n reorganiserLesCleEtrangere de la classe MLDEntite2");
/*      */       }
/*      */     }
/* 1220 */     setListeCNTForeingKey(listeTabl);
/*      */   }
/*      */   
/*      */   public void restructurerLesClesEtContrainte()
/*      */   {
/* 1225 */     trierListeContrainte();
/* 1226 */     reorganiserLesCleEtrangere();
/* 1227 */     setNomContraintes();
/*      */   }
/*      */   
/*      */   private String getSQLAttribut(Attribut2 att)
/*      */   {
/* 1232 */     String sAtt = "";
/* 1233 */     if (Setting.SQLUtiliserCode) {
/* 1234 */       sAtt = SQLOutil.remplaceChar(att.getCode());
/*      */     } else {
/* 1236 */       sAtt = SQLOutil.remplaceChar(att.getNom());
/*      */     }
/* 1238 */     return sAtt;
/*      */   }
/*      */   
/*      */   private String getPrimaryKeyForeing(TableReference tab) {
/* 1242 */     String s = "";
/* 1243 */     String sAtt = "";
/*      */     
/* 1245 */     for (int i = 0; i < tab.getListeAttributRef().size(); i++) {
/* 1246 */       Attribut2 att = (Attribut2)((AttributReference)tab.getListeAttributRef().get(i)).getAttribut();
/* 1247 */       sAtt = getSQLAttribut(att);
/* 1248 */       if (s.length() == 0) {
/* 1249 */         s = s + sAtt;
/*      */       } else {
/* 1251 */         s = s + ", " + sAtt;
/*      */       }
/*      */     }
/* 1254 */     return s;
/*      */   }
/*      */   
/*      */   private String getSQLPrimaryKey() {
/* 1258 */     String s = "";
/* 1259 */     String sPK = "";
/* 1260 */     if (this.typeEntite.equals("RELATION")) {
/* 1261 */       ArrayList<Attribut> listeAtt = getListeKey2();
/* 1262 */       for (int i = 0; i < listeAtt.size(); i++) {
/* 1263 */         sPK = getSQLAttribut((Attribut2)listeAtt.get(i));
/* 1264 */         if (s.length() == 0) s = sPK; else {
/* 1265 */           s = s + ", " + sPK;
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1272 */       return s;
/*      */     }
/* 1274 */     if (this.typeEntite.equals("ENTITE")) {
/* 1275 */       ArrayList<Attribut> listeAtt = getListeKey();
/* 1276 */       for (int i = 0; i < listeAtt.size(); i++) {
/* 1277 */         sPK = getSQLAttribut((Attribut2)listeAtt.get(i));
/* 1278 */         if (s.length() == 0) s = sPK; else
/* 1279 */           s = s + ", " + sPK;
/*      */       }
/* 1281 */       return s;
/*      */     }
/*      */     
/* 1284 */     return s;
/*      */   }
/*      */   
/*      */   public String _getSQLPKey() {
/* 1288 */     String s = getSQLPrimaryKey();
/* 1289 */     String nmCnt = getSQLNomTable();
/* 1290 */     if (Setting.SQLPrefixerLeNomContrainte2) {
/* 1291 */       nmCnt = "PK_" + nmCnt;
/*      */     } else {
/* 1293 */       nmCnt = nmCnt + "_PK";
/*      */     }
/*      */     
/* 1296 */     s = "\n\t, CONSTRAINT " + nmCnt + " PRIMARY KEY (" + s + ")";
/* 1297 */     if (Setting.SQLUtiliserCode) s = s.toUpperCase();
/* 1298 */     return s;
/*      */   }
/*      */   
/*      */   public String _getSQLALLContrainteInterne() {
/* 1302 */     String s = "";String c = "";
/* 1303 */     for (int i = 0; i < this.listeCNTForeingKey.size(); i++) {
/* 1304 */       s = ((TableReference)this.listeCNTForeingKey.get(i)).getSQLForeingKeyContrainte();
/* 1305 */       s = s.replace("\n\t", "");
/* 1306 */       s = "\n\t, CONSTRAINT " + ((TableReference)this.listeCNTForeingKey.get(i)).getSQLNomContrainte() + " " + s;
/* 1307 */       c = c + s;
/*      */     }
/*      */     
/* 1310 */     for (int i = 0; i < this.listeCNTAlternativeKey.size(); i++) {
/* 1311 */       s = ((TableReference)this.listeCNTAlternativeKey.get(i)).getSQLUniqueContrainte();
/* 1312 */       s = s.replace("\n\t", "");
/* 1313 */       s = "\n\t, CONSTRAINT " + ((TableReference)this.listeCNTAlternativeKey.get(i)).getSQLNomContrainte() + " " + s;
/*      */       
/* 1315 */       c = c + s;
/*      */     }
/*      */     
/* 1318 */     return c;
/*      */   }
/*      */   
/*      */   private String getSQLNomTable() {
/* 1322 */     String st = "";String s = "";
/* 1323 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 1324 */       s = SQLOutil.remplaceChar(Setting.developpeur);
/* 1325 */       s = s.toUpperCase();
/*      */     }
/* 1327 */     if (Setting.SQLUtiliserCode) {
/* 1328 */       st = SQLOutil.remplaceChar(getCode());
/*      */     } else {
/* 1330 */       st = SQLOutil.remplaceChar(getNom());
/*      */     }
/* 1332 */     if (s.length() == 0) s = st; else
/* 1333 */       s = s + "_" + st;
/* 1334 */     return s;
/*      */   }
/*      */   
/*      */   public String getSQLALLContrainteExternal(String nomTable) {
/* 1338 */     String s = "";String c = "";
/* 1339 */     for (int i = 0; i < this.listeCNTForeingKey.size(); i++) {
/* 1340 */       s = ((TableReference)this.listeCNTForeingKey.get(i)).getSQLForeingKeyContrainte();
/* 1341 */       s = "\n\nALTER TABLE " + nomTable + "\n\t ADD CONSTRAINT " + ((TableReference)this.listeCNTForeingKey.get(i)).getSQLNomContrainte() + " " + s + ";";
/* 1342 */       c = c + s;
/*      */     }
/*      */     
/* 1345 */     for (int i = 0; i < this.listeCNTAlternativeKey.size(); i++) {
/* 1346 */       s = ((TableReference)this.listeCNTAlternativeKey.get(i)).getSQLUniqueContrainte();
/* 1347 */       s = "\n\nALTER TABLE " + nomTable + "\n\t ADD CONSTRAINT " + ((TableReference)this.listeCNTAlternativeKey.get(i)).getSQLNomContrainte() + s + ";";
/* 1348 */       c = c + s;
/*      */     }
/*      */     
/* 1351 */     return c;
/*      */   }
/*      */   
/*      */   private void assignerNomContrainte() {
/* 1355 */     for (int i = 0; i < this.listeCNTAlternativeKey.size(); i++) {
/* 1356 */       ((TableReference)this.listeCNTAlternativeKey.get(i)).setNomContrainte();
/*      */     }
/* 1358 */     for (int i = 0; i < this.listeCNTForeingKey.size(); i++) {
/* 1359 */       ((TableReference)this.listeCNTForeingKey.get(i)).setNomContrainte();
/*      */     }
/*      */   }
/*      */   
/*      */   private void correctionNomContrainteFKAK(ArrayList<TableReference> liste, String nom) {
/* 1364 */     int nb = 1;
/* 1365 */     for (int i = 0; i < liste.size(); i++) {
/* 1366 */       if (((TableReference)liste.get(i)).getNom().equals(nom)) {
/* 1367 */         ((TableReference)liste.get(i)).setNom(nom + "_" + nb);
/* 1368 */         nb++;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void correctionNomCnt()
/*      */   {
/* 1375 */     for (int i = 0; i < this.listeCNTForeingKey.size(); i++) {
/* 1376 */       TableReference tab = (TableReference)this.listeCNTForeingKey.get(i);
/* 1377 */       for (int j = i + 1; j < this.listeCNTForeingKey.size(); j++) {
/* 1378 */         TableReference tab2 = (TableReference)this.listeCNTForeingKey.get(j);
/* 1379 */         if (tab.getNom().equals(tab2.getNom())) {
/* 1380 */           correctionNomContrainteFKAK(this.listeCNTForeingKey, tab.getNom());
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1385 */     for (int i = 0; i < this.listeCNTAlternativeKey.size(); i++) {
/* 1386 */       TableReference tab = (TableReference)this.listeCNTAlternativeKey.get(i);
/* 1387 */       for (int j = i + 1; j < this.listeCNTAlternativeKey.size(); j++) {
/* 1388 */         TableReference tab2 = (TableReference)this.listeCNTAlternativeKey.get(j);
/* 1389 */         if (tab.getNom().equals(tab2.getNom())) {
/* 1390 */           correctionNomContrainteFKAK(this.listeCNTAlternativeKey, tab.getNom());
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void setNomContraintes() {
/* 1397 */     assignerNomContrainte();
/* 1398 */     correctionNomCnt();
/*      */   }
/*      */   
/*      */ 
/*      */   private void getListeAttributCle2(ArrayList<Attribut> listeKey, ArrayList<Attribut> listeAtt)
/*      */   {
/* 1404 */     for (int i = 0; i < listeAtt.size(); i++) {
/* 1405 */       Attribut2 att = (Attribut2)listeAtt.get(i);
/* 1406 */       if (att.getListeAttributs().size() == 0) {
/* 1407 */         if (att.getKey().equals(Parametres.Cle)) {
/* 1408 */           listeKey.add(listeAtt.get(i));
/*      */         }
/*      */       } else {
/* 1411 */         getListeAttributCle2(listeKey, att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Attribut> getListeKey2() {
/* 1417 */     ArrayList<Attribut> listeKey = new ArrayList();
/* 1418 */     getListeAttributCle2(listeKey, getListeAttributs());
/* 1419 */     return listeKey;
/*      */   }
/*      */   
/*      */   public void corrigerLesTypesDesCles() {
/* 1423 */     ArrayList<Attribut> l = getListeKey2();
/*      */     
/* 1425 */     if (l.size() > 1) {
/* 1426 */       for (int i = 0; i < l.size(); i++) {
/* 1427 */         if (((Attribut)l.get(i)).getType().toUpperCase().equals("AUTO_INCREMENT"))
/*      */         {
/* 1429 */           Attribut2 att = (Attribut2)l.get(i);
/* 1430 */           att.setType("Int");
/* 1431 */           att.setLongueur(11);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public Color getColor(String color)
/*      */   {
/* 1439 */     return new Color(Integer.parseInt(color));
/*      */   }
/*      */   
/*      */   public String getColor(Color color) {
/* 1443 */     return color.getRGB() + "";
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntCle2() {
/* 1447 */     return this.afficherCntCle2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntCleEtrangere2() {
/* 1451 */     return this.afficherCntCleEtrangere2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntIndex2() {
/* 1455 */     return this.afficherCntIndex2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntUnique2() {
/* 1459 */     return this.afficherCntUnique2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCodeAttribut2() {
/* 1463 */     return this.afficherCodeAttribut2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCodeEntite2() {
/* 1467 */     return this.afficherCodeEntite2;
/*      */   }
/*      */   
/*      */   public String getAligne() {
/* 1471 */     return this.aligne;
/*      */   }
/*      */   
/*      */   public String getAligneTitre() {
/* 1475 */     return this.aligneTitre;
/*      */   }
/*      */   
/*      */   public String getAlignerAttribut() {
/* 1479 */     return this.alignerAttribut;
/*      */   }
/*      */   
/*      */   public String getAlignerType() {
/* 1483 */     return this.alignerType;
/*      */   }
/*      */   
/*      */   public Attribut getAttributSelect2() {
/* 1487 */     return this.attributSelect2;
/*      */   }
/*      */   
/*      */   public String getAugmentation2() {
/* 1491 */     return this.augmentation2;
/*      */   }
/*      */   
/*      */   public boolean isAugmentationPrefix2() {
/* 1495 */     return this.augmentationPrefix2;
/*      */   }
/*      */   
/*      */   public Color getClAttributSelect() {
/* 1499 */     return this.clAttributSelect;
/*      */   }
/*      */   
/*      */   public Color getClFillSelAttribut() {
/* 1503 */     return this.clFillSelAttribut;
/*      */   }
/*      */   
/*      */   public Color getClStrokeSelAttribut() {
/* 1507 */     return this.clStrokeSelAttribut;
/*      */   }
/*      */   
/*      */   public String getCodeAttribut2() {
/* 1511 */     return this.codeAttribut2;
/*      */   }
/*      */   
/*      */   public String getCodeEntete2() {
/* 1515 */     return this.codeEntete2;
/*      */   }
/*      */   
/*      */   public String getCodeFin2() {
/* 1519 */     return this.codeFin2;
/*      */   }
/*      */   
/*      */   public String getCodeMethodee() {
/* 1523 */     return this.codeMethodee;
/*      */   }
/*      */   
/*      */   public IhmEntiteRelation getEntiteRef() {
/* 1527 */     return this.entiteRef;
/*      */   }
/*      */   
/*      */   public Font getFont() {
/* 1531 */     return this.font;
/*      */   }
/*      */   
/*      */   public Font getFontAttribut() {
/* 1535 */     return this.fontAttribut;
/*      */   }
/*      */   
/*      */   public Font getFontNormal() {
/* 1539 */     return this.fontNormal;
/*      */   }
/*      */   
/*      */   public Font getFontNormalItalic() {
/* 1543 */     return this.fontNormalItalic;
/*      */   }
/*      */   
/*      */   public Font getFontType() {
/* 1547 */     return this.fontType;
/*      */   }
/*      */   
/*      */   public int gethAttribut() {
/* 1551 */     return this.hAttribut;
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> getHistorique() {
/* 1555 */     return this.historique;
/*      */   }
/*      */   
/*      */   public ArrayList<TableReference> getListeCNTAlternativeKey() {
/* 1559 */     return this.listeCNTAlternativeKey;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeCle2() {
/* 1563 */     return this.listeCle2;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeCleEtrangere2() {
/* 1567 */     return this.listeCleEtrangere2;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeIndex2() {
/* 1571 */     return this.listeIndex2;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeUnique2() {
/* 1575 */     return this.listeUnique2;
/*      */   }
/*      */   
/*      */   public boolean isMldGenerer2() {
/* 1579 */     return this.mldGenerer2;
/*      */   }
/*      */   
/*      */   public boolean isMldHeritageGenerer2() {
/* 1583 */     return this.mldHeritageGenerer2;
/*      */   }
/*      */   
/*      */   public String getOrigine2() {
/* 1587 */     return this.origine2;
/*      */   }
/*      */   
/*      */   public int getWidthMax() {
/* 1591 */     return this.widthMax;
/*      */   }
/*      */   
/*      */   public int getWidthMin() {
/* 1595 */     return this.widthMin;
/*      */   }
/*      */   
/*      */   public int getxAttribut() {
/* 1599 */     return this.xAttribut;
/*      */   }
/*      */   
/*      */   public int getxCle() {
/* 1603 */     return this.xCle;
/*      */   }
/*      */   
/*      */   public int getxType() {
/* 1607 */     return this.xType;
/*      */   }
/*      */   
/*      */   public int getyAttribut() {
/* 1611 */     return this.yAttribut;
/*      */   }
/*      */   
/*      */   public int getyEntete() {
/* 1615 */     return this.yEntete;
/*      */   }
/*      */   
/*      */   public void setAfficherCntCle2(boolean afficherCntCle2) {
/* 1619 */     this.afficherCntCle2 = afficherCntCle2;
/*      */   }
/*      */   
/*      */   public void setAfficherCntCleEtrangere2(boolean afficherCntCleEtrangere2) {
/* 1623 */     this.afficherCntCleEtrangere2 = afficherCntCleEtrangere2;
/*      */   }
/*      */   
/*      */   public void setAfficherCntIndex2(boolean afficherCntIndex2) {
/* 1627 */     this.afficherCntIndex2 = afficherCntIndex2;
/*      */   }
/*      */   
/*      */   public void setAfficherCntUnique2(boolean afficherCntUnique2) {
/* 1631 */     this.afficherCntUnique2 = afficherCntUnique2;
/*      */   }
/*      */   
/*      */   public void setAfficherCodeAttribut2(boolean afficherCodeAttribut2) {
/* 1635 */     this.afficherCodeAttribut2 = afficherCodeAttribut2;
/*      */   }
/*      */   
/*      */   public void setAfficherCodeEntite2(boolean afficherCodeEntite2) {
/* 1639 */     this.afficherCodeEntite2 = afficherCodeEntite2;
/*      */   }
/*      */   
/*      */   public void setAligne(String aligne) {
/* 1643 */     this.aligne = aligne;
/*      */   }
/*      */   
/*      */   public void setAligneTitre(String aligneTitre) {
/* 1647 */     this.aligneTitre = aligneTitre;
/*      */   }
/*      */   
/*      */   public void setAlignerAttribut(String alignerAttribut) {
/* 1651 */     this.alignerAttribut = alignerAttribut;
/*      */   }
/*      */   
/*      */   public void setAlignerType(String alignerType) {
/* 1655 */     this.alignerType = alignerType;
/*      */   }
/*      */   
/*      */   public void setAttributSelect2(Attribut attributSelect2) {
/* 1659 */     this.attributSelect2 = attributSelect2;
/*      */   }
/*      */   
/*      */   public void setAugmentation2(String augmentation2) {
/* 1663 */     this.augmentation2 = augmentation2;
/*      */   }
/*      */   
/*      */   public void setAugmentationPrefix2(boolean augmentationPrefix2) {
/* 1667 */     this.augmentationPrefix2 = augmentationPrefix2;
/*      */   }
/*      */   
/*      */   public void setClFillSelAttribut(Color clFillSelAttribut) {
/* 1671 */     this.clFillSelAttribut = clFillSelAttribut;
/*      */   }
/*      */   
/*      */   public void setClStrokeSelAttribut(Color clStrokeSelAttribut) {
/* 1675 */     this.clStrokeSelAttribut = clStrokeSelAttribut;
/*      */   }
/*      */   
/*      */   public void setCodeAttribut2(String codeAttribut2) {
/* 1679 */     this.codeAttribut2 = codeAttribut2;
/*      */   }
/*      */   
/*      */   public void setCodeEntete2(String codeEntete2) {
/* 1683 */     this.codeEntete2 = codeEntete2;
/*      */   }
/*      */   
/*      */   public void setCodeFin2(String codeFin2) {
/* 1687 */     this.codeFin2 = codeFin2;
/*      */   }
/*      */   
/*      */   public void setCodeMethodee(String codeMethodee) {
/* 1691 */     this.codeMethodee = codeMethodee;
/*      */   }
/*      */   
/*      */   public void setEntiteRef(IhmEntiteRelation entiteRef) {
/* 1695 */     this.entiteRef = entiteRef;
/*      */   }
/*      */   
/*      */   public void setFont(Font font) {
/* 1699 */     this.font = font;
/*      */   }
/*      */   
/*      */   public void setFontAttribut(Font fontAttribut) {
/* 1703 */     this.fontAttribut = fontAttribut;
/*      */   }
/*      */   
/*      */   public void setFontNormal(Font fontNormal) {
/* 1707 */     this.fontNormal = fontNormal;
/*      */   }
/*      */   
/*      */   public void setFontNormalItalic(Font fontNormalItalic) {
/* 1711 */     this.fontNormalItalic = fontNormalItalic;
/*      */   }
/*      */   
/*      */   public void setFontTitre(Font fontTitre) {
/* 1715 */     this.fontTitre = fontTitre;
/*      */   }
/*      */   
/*      */   public void setFontType(Font fontType) {
/* 1719 */     this.fontType = fontType;
/*      */   }
/*      */   
/*      */   public void sethAttribut(int hAttribut) {
/* 1723 */     this.hAttribut = hAttribut;
/*      */   }
/*      */   
/*      */   public void setHistorique(ArrayList<Historique> historique) {
/* 1727 */     this.historique = historique;
/*      */   }
/*      */   
/*      */   public void setListeCNTAlternativeKey(ArrayList<TableReference> listeCNTAlternativeKey) {
/* 1731 */     this.listeCNTAlternativeKey = listeCNTAlternativeKey;
/*      */   }
/*      */   
/*      */   public void setListeCle2(ArrayList<AttributContrainte2> listeCle2) {
/* 1735 */     this.listeCle2 = listeCle2;
/*      */   }
/*      */   
/*      */   public void setListeCleEtrangere2(ArrayList<AttributContrainte2> listeCleEtrangere2) {
/* 1739 */     this.listeCleEtrangere2 = listeCleEtrangere2;
/*      */   }
/*      */   
/*      */   public void setListeIndex2(ArrayList<AttributContrainte2> listeIndex2) {
/* 1743 */     this.listeIndex2 = listeIndex2;
/*      */   }
/*      */   
/*      */   public void setListeUnique2(ArrayList<AttributContrainte2> listeUnique2) {
/* 1747 */     this.listeUnique2 = listeUnique2;
/*      */   }
/*      */   
/*      */   public void setMldGenerer2(boolean mldGenerer2) {
/* 1751 */     this.mldGenerer2 = mldGenerer2;
/*      */   }
/*      */   
/*      */   public void setMldHeritageGenerer2(boolean mldHeritageGenerer2) {
/* 1755 */     this.mldHeritageGenerer2 = mldHeritageGenerer2;
/*      */   }
/*      */   
/*      */   public void setOrigine2(String origine2) {
/* 1759 */     this.origine2 = origine2;
/*      */   }
/*      */   
/*      */   public void setWidthMax(int widthMax) {
/* 1763 */     this.widthMax = widthMax;
/*      */   }
/*      */   
/*      */   public void setWidthMin(int widthMin) {
/* 1767 */     this.widthMin = widthMin;
/*      */   }
/*      */   
/*      */   public void setxAttribut(int xAttribut) {
/* 1771 */     this.xAttribut = xAttribut;
/*      */   }
/*      */   
/*      */   public void setxCle(int xCle) {
/* 1775 */     this.xCle = xCle;
/*      */   }
/*      */   
/*      */   public void setxType(int xType) {
/* 1779 */     this.xType = xType;
/*      */   }
/*      */   
/*      */   public void setyAttribut(int yAttribut) {
/* 1783 */     this.yAttribut = yAttribut;
/*      */   }
/*      */   
/*      */   public void setyEntete(int yEntete) {
/* 1787 */     this.yEntete = yEntete;
/*      */   }
/*      */   
/*      */   public Color getClTextTaille2() {
/* 1791 */     return this.clTextTaille2;
/*      */   }
/*      */   
/*      */   public Color getClTextTailleDec2() {
/* 1795 */     return this.clTextTailleDec2;
/*      */   }
/*      */   
/*      */   public void setClTextTaille2(Color clTextTaille2) {
/* 1799 */     this.clTextTaille2 = clTextTaille2;
/*      */   }
/*      */   
/*      */   public void setClTextTailleDec2(Color clTextTailleDec2) {
/* 1803 */     this.clTextTailleDec2 = clTextTailleDec2;
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD2\MLDEntite2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */