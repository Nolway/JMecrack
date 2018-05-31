/*     */ package IhmMCD2;
/*     */ 
/*     */ import Merise2.Attribut2;
/*     */ import Merise2.Entite2;
/*     */ import Merise2.Relation2;
/*     */ import ihm.FormeInterneMCD;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class ApercuProprieteMCD
/*     */   extends JPanel implements Serializable
/*     */ {
/*     */   IhmEntite2 ent1;
/*     */   IhmEntite2 ent2;
/*     */   IhmEntite2 ent3;
/*     */   IhmRelation2 rel1;
/*     */   IhmRelation2 rel2;
/*     */   IhmLien2 lien1;
/*     */   IhmLien2 lien2;
/*     */   IhmLien2 lien3;
/*     */   IhmLien2 lien4;
/*     */   IhmContrainte2 cnt;
/*     */   IhmLienContraintes2 lienCnt1;
/*     */   IhmLienContraintes2 lienCnt2;
/*     */   IhmLienContraintes2 lienCnt3;
/*     */   IhmCIF2 cif;
/*     */   IhmLienCIF2 lienCif1;
/*     */   IhmLienCIF2 lienCif2;
/*     */   IhmLienCIF2 lienCif3;
/*     */   IhmHeritage2 her;
/*     */   IhmLienContrainteHeritage2 lienHer1;
/*     */   IhmLienContrainteHeritage2 lienHer2;
/*     */   IhmCommentaire2 com;
/*     */   IhmLienCommentaire2 lienCom;
/*     */   IhmPostIt2 post;
/*     */   Color clPage;
/*     */   
/*     */   public ApercuProprieteMCD()
/*     */   {
/*  48 */     initComponents();
/*  49 */     creerEntiteRelation();
/*  50 */     this.clPage = Color.WHITE;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void paintComponent(Graphics g)
/*     */   {
/*  56 */     super.paintComponent(g);
/*  57 */     dessinerEntite((Graphics2D)g);
/*     */   }
/*     */   
/*     */   private void creerEntiteRelation()
/*     */   {
/*  62 */     Entite2 e1 = new Entite2("Entite1");
/*  63 */     Entite2 e2 = new Entite2("Entite2");
/*  64 */     Entite2 e3 = new Entite2("Entite3");
/*     */     
/*  66 */     Attribut2 at = new Attribut2("att1", "Varchar", 25, -1, "PRIMARY KEY", false, "", e3);
/*  67 */     e1.getListeAttributs().add(at);
/*     */     
/*  69 */     Attribut2 at2 = new Attribut2("att2", "Double", 12, 3, "", false, "", e3);
/*     */     
/*  71 */     e1.getListeAttributs().add(at2);
/*     */     
/*  73 */     e2.getListeAttributs().add(at);
/*     */     
/*     */ 
/*  76 */     this.ent1 = new IhmEntite2(e1, 20, 20, true);
/*  77 */     this.ent2 = new IhmEntite2(e2, 475, 30, true);
/*  78 */     this.ent3 = new IhmEntite2(e3, 50, 185, true);
/*     */     
/*  80 */     Relation2 r = new Relation2("relation_1");
/*  81 */     r.getListeAttributs().add(at2);
/*  82 */     this.rel1 = new IhmRelation2(r, 230, 10, true);
/*     */     
/*  84 */     r = new Relation2("relation_2");
/*  85 */     this.rel2 = new IhmRelation2(r, 255, 125, true);
/*     */     
/*  87 */     this.lien1 = new IhmLien2(this.ent1, this.rel1);
/*  88 */     this.lien1.setCardinalite("1,1");
/*     */     
/*  90 */     this.lien2 = new IhmLien2(this.ent2, this.rel1);
/*  91 */     this.lien3 = new IhmLien2(this.ent1, this.rel2);
/*  92 */     this.lien3.setFleche(true);
/*  93 */     this.lien4 = new IhmLien2(this.ent2, this.rel2);
/*  94 */     this.lien4.setNom("lien");
/*  95 */     this.lien4.setCardinalite("(1,1)");
/*     */     
/*  97 */     this.cnt = new IhmContrainte2(275, 75, 0, 0);
/*  98 */     this.lienCnt1 = new IhmLienContraintes2(this.ent1, this.cnt);
/*  99 */     this.lienCnt2 = new IhmLienContraintes2(this.rel1, this.cnt);
/* 100 */     this.lienCnt3 = new IhmLienContraintes2(this.rel2, this.cnt);
/*     */     
/* 102 */     this.com = new IhmCommentaire2("Commentaire", 650, 25, 0, 10);
/* 103 */     this.lienCom = new IhmLienCommentaire2(this.ent2, this.com);
/*     */     
/* 105 */     this.post = new IhmPostIt2("   PostIt ", 600, 125, 0, 10);
/* 106 */     this.post.setCommentaire(" Vos notes dans ce PostIt");
/* 107 */     this.her = new IhmHeritage2(55, 140, this.ent1);
/* 108 */     this.her.setClFond2(FormeInterneMCD.clHeritageFond2);
/* 109 */     this.her.setNom("XT");
/* 110 */     this.her.setClCadre2(FormeInterneMCD.clHeritageCadre2);
/* 111 */     this.lienHer1 = new IhmLienContrainteHeritage2(this.her, this.ent1);
/* 112 */     this.lienHer1.setNom("Héritage");
/* 113 */     this.lienHer2 = new IhmLienContrainteHeritage2(this.her, this.ent3);
/*     */     
/* 115 */     this.cif = new IhmCIF2(390, 185, 0, 0);
/* 116 */     this.lienCif1 = new IhmLienCIF2(this.ent1, this.cif);
/* 117 */     this.lienCif1.getPointCassure().add(new IhmPoint(250, 203));
/* 118 */     this.lienCif2 = new IhmLienCIF2(this.ent2, this.cif);
/* 119 */     this.lienCif2.getPointCassure().add(new IhmPoint(450, 203));
/*     */     
/* 121 */     this.lienCif3 = new IhmLienCIF2(this.rel2, this.cif, "");
/*     */     
/* 123 */     this.lien1.setSelected(false);
/* 124 */     this.lien2.setSelected(false);
/* 125 */     this.lien3.setSelected(false);
/* 126 */     this.lien4.setSelected(false);
/* 127 */     this.cnt.setSelected(false);
/* 128 */     this.com.setSelected(false);
/* 129 */     this.post.setSelected(false);
/* 130 */     this.ent1.setSelected(false);
/* 131 */     this.ent2.setSelected(false);
/* 132 */     this.ent3.setSelected(false);
/* 133 */     this.rel1.setSelected(false);
/* 134 */     this.rel2.setSelected(false);
/* 135 */     this.her.setSelected(false);
/* 136 */     this.lienHer1.setSelected(false);
/* 137 */     this.lienHer2.setSelected(false);
/* 138 */     this.cif.setSelected(false);
/* 139 */     this.lienCif1.setSelected(false);
/* 140 */     this.lienCif2.setSelected(false);
/* 141 */     this.lienCif3.setSelected(false);
/*     */   }
/*     */   
/*     */   private void dessinerEntite(Graphics2D g)
/*     */   {
/* 146 */     g.setColor(this.clPage);
/* 147 */     g.fillRect(0, 0, getWidth(), getHeight());
/* 148 */     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 149 */     this.lien1.paint(g);
/* 150 */     this.lien2.paint(g);
/* 151 */     this.lien3.paint(g);
/* 152 */     this.lien4.paint(g);
/*     */     
/* 154 */     this.lienCnt1.paint(g);
/* 155 */     this.lienCnt2.paint(g);
/* 156 */     this.lienCnt3.paint(g);
/* 157 */     this.lienHer1.paint(g);
/* 158 */     this.lienHer2.paint(g);
/* 159 */     this.lienCif1.paint(g);
/* 160 */     this.lienCif2.paint(g);
/* 161 */     this.lienCif3.paint(g);
/* 162 */     this.lienCom.paint(g);
/*     */     
/* 164 */     this.ent1.paint(g);
/* 165 */     this.ent2.paint(g);
/* 166 */     this.ent3.paint(g);
/* 167 */     this.rel1.paint(g);
/* 168 */     this.rel2.paint(g);
/* 169 */     this.cnt.paint(g);
/* 170 */     this.com.paint(g);
/* 171 */     this.post.paint(g);
/* 172 */     this.her.paint(g);
/* 173 */     this.cif.paint(g);
/*     */   }
/*     */   
/*     */   public void setClPage(Color cl)
/*     */   {
/* 178 */     this.clPage = cl;
/* 179 */     this.lien1.getCardinalites().setClFond2(cl);
/* 180 */     this.lien2.getCardinalites().setClFond2(cl);
/* 181 */     this.lien3.getCardinalites().setClFond2(cl);
/* 182 */     this.lien4.getCardinalites().setClFond2(cl);
/*     */     
/* 184 */     this.lienHer1.setClLienFondNom(this.clPage);
/* 185 */     repaint();
/*     */   }
/*     */   
/*     */   public void setCouleurConfiguration(ConfigurationMCD2 config) {
/* 189 */     this.ent1.setClCadre2(ConfigurationMCD2.getColor(config.clEntiteCadre2));
/* 190 */     this.ent1.setClFond2(ConfigurationMCD2.getColor(config.clEntiteFond2));
/* 191 */     this.ent1.setClDegradee(config.isDegradee2);
/* 192 */     this.ent1.setClFondTitre2(ConfigurationMCD2.getColor(config.clEntiteFondTitre2));
/* 193 */     this.ent1.setClText2(ConfigurationMCD2.getColor(config.clEntiteText2));
/* 194 */     this.ent1.setClTextTitre2(ConfigurationMCD2.getColor(config.clEntiteTextTitre2));
/* 195 */     this.ent1.setAttMajuscule(config.typeMajuscule2);
/* 196 */     this.ent1.setAttEspace(config.interLigne2);
/* 197 */     this.ent1.setEpaisseur(config.traitEntiteRelation2);
/* 198 */     this.ent1.setPrkvisible(config.afficherPrk2);
/* 199 */     this.ent1.setClTextType2(ConfigurationMCD2.getColor(config.clEntiteTextType2));
/* 200 */     this.ent1.setOmbre(config.isOmbree2);
/*     */     
/* 202 */     this.ent2.setClCadre2(ConfigurationMCD2.getColor(config.clEntiteCadre2));
/* 203 */     this.ent2.setClFond2(ConfigurationMCD2.getColor(config.clEntiteFond2));
/* 204 */     this.ent2.setClDegradee(config.isDegradee2);
/* 205 */     this.ent2.setClFondTitre2(ConfigurationMCD2.getColor(config.clEntiteFondTitre2));
/* 206 */     this.ent2.setClText2(ConfigurationMCD2.getColor(config.clEntiteText2));
/* 207 */     this.ent2.setClTextTitre2(ConfigurationMCD2.getColor(config.clEntiteTextTitre2));
/* 208 */     this.ent2.setAttMajuscule(config.typeMajuscule2);
/* 209 */     this.ent2.setAttEspace(config.interLigne2);
/* 210 */     this.ent2.setEpaisseur(config.traitEntiteRelation2);
/* 211 */     this.ent2.setPrkvisible(config.afficherPrk2);
/* 212 */     this.ent2.setClTextType2(ConfigurationMCD2.getColor(config.clEntiteTextType2));
/* 213 */     this.ent2.setOmbre(config.isOmbree2);
/*     */     
/*     */ 
/* 216 */     this.ent3.setClCadre2(ConfigurationMCD2.getColor(config.clEntiteCadre2));
/* 217 */     this.ent3.setClFond2(ConfigurationMCD2.getColor(config.clEntiteFond2));
/* 218 */     this.ent3.setClDegradee(config.isDegradee2);
/* 219 */     this.ent3.setClFondTitre2(ConfigurationMCD2.getColor(config.clEntiteFondTitre2));
/* 220 */     this.ent3.setClText2(ConfigurationMCD2.getColor(config.clEntiteText2));
/* 221 */     this.ent3.setClTextTitre2(ConfigurationMCD2.getColor(config.clEntiteTextTitre2));
/* 222 */     this.ent3.setAttMajuscule(config.typeMajuscule2);
/* 223 */     this.ent3.setAttEspace(config.interLigne2);
/* 224 */     this.ent3.setEpaisseur(config.traitEntiteRelation2);
/* 225 */     this.ent3.setPrkvisible(config.afficherPrk2);
/* 226 */     this.ent3.setClTextType2(ConfigurationMCD2.getColor(config.clEntiteTextType2));
/* 227 */     this.ent3.setOmbre(config.isOmbree2);
/*     */     
/* 229 */     this.rel1.setClCadre2(ConfigurationMCD2.getColor(config.clRelationCadre2));
/* 230 */     this.rel1.setClFond2(ConfigurationMCD2.getColor(config.clRelationFond2));
/* 231 */     this.rel1.setClDegradee(config.isDegradee2);
/* 232 */     this.rel1.setClFondTitre2(ConfigurationMCD2.getColor(config.clRelationFondTitre2));
/* 233 */     this.rel1.setClText2(ConfigurationMCD2.getColor(config.clRelationText2));
/* 234 */     this.rel1.setClTextTitre2(ConfigurationMCD2.getColor(config.clRelationTextTitre2));
/* 235 */     this.rel1.setAttMajuscule(config.typeMajuscule2);
/* 236 */     this.rel1.setAttEspace(config.interLigne2);
/* 237 */     this.rel1.setEpaisseur(config.traitEntiteRelation2);
/* 238 */     this.rel1.setPrkvisible(config.afficherPrk2);
/* 239 */     this.rel1.setClTextType2(ConfigurationMCD2.getColor(config.clRelationTextType2));
/* 240 */     this.rel1.setOmbre(config.isOmbree2);
/*     */     
/* 242 */     this.rel2.setClCadre2(ConfigurationMCD2.getColor(config.clRelationCadre2));
/* 243 */     this.rel2.setClFond2(ConfigurationMCD2.getColor(config.clRelationFond2));
/* 244 */     this.rel2.setClDegradee(config.isDegradee2);
/* 245 */     this.rel2.setClFondTitre2(ConfigurationMCD2.getColor(config.clRelationFondTitre2));
/* 246 */     this.rel2.setClText2(ConfigurationMCD2.getColor(config.clRelationText2));
/* 247 */     this.rel2.setClTextTitre2(ConfigurationMCD2.getColor(config.clRelationTextTitre2));
/* 248 */     this.rel2.setAttMajuscule(config.typeMajuscule2);
/* 249 */     this.rel2.setAttEspace(config.interLigne2);
/* 250 */     this.rel2.setEpaisseur(config.traitEntiteRelation2);
/* 251 */     this.rel2.setPrkvisible(config.afficherPrk2);
/* 252 */     this.rel2.setClTextType2(ConfigurationMCD2.getColor(config.clRelationTextType2));
/* 253 */     this.rel2.setOmbre(config.isOmbree2);
/*     */     
/* 255 */     this.lien1.setClLien2(ConfigurationMCD2.getColor(config.clLien2));
/* 256 */     this.lien1.setClLienNom2(ConfigurationMCD2.getColor(config.clLienNom2));
/* 257 */     this.lien1.setClLienText2(ConfigurationMCD2.getColor(config.clLienText2));
/* 258 */     this.lien1.getCardinalites().setClFond2(ConfigurationMCD2.getColor(config.clPage2));
/* 259 */     this.lien1.getCardinalites().setClText2(ConfigurationMCD2.getColor(config.clLienNomCardinalite2));
/* 260 */     this.lien1.setEpaisseur(config.lienEntiteRelation2);
/*     */     
/* 262 */     this.lien2.setClLien2(ConfigurationMCD2.getColor(config.clLien2));
/* 263 */     this.lien2.setClLienNom2(ConfigurationMCD2.getColor(config.clLienNom2));
/* 264 */     this.lien2.setClLienText2(ConfigurationMCD2.getColor(config.clLienText2));
/* 265 */     this.lien2.getCardinalites().setClFond2(ConfigurationMCD2.getColor(config.clPage2));
/* 266 */     this.lien2.getCardinalites().setClText2(ConfigurationMCD2.getColor(config.clLienNomCardinalite2));
/* 267 */     this.lien2.setEpaisseur(config.lienEntiteRelation2);
/*     */     
/* 269 */     this.lien3.setClLien2(ConfigurationMCD2.getColor(config.clLien2));
/* 270 */     this.lien3.setClLienNom2(ConfigurationMCD2.getColor(config.clLienNom2));
/* 271 */     this.lien3.setClLienText2(ConfigurationMCD2.getColor(config.clLienText2));
/* 272 */     this.lien3.getCardinalites().setClFond2(ConfigurationMCD2.getColor(config.clPage2));
/* 273 */     this.lien3.getCardinalites().setClText2(ConfigurationMCD2.getColor(config.clLienNomCardinalite2));
/* 274 */     this.lien3.setEpaisseur(config.lienEntiteRelation2);
/*     */     
/* 276 */     this.lien4.setClLien2(ConfigurationMCD2.getColor(config.clLien2));
/* 277 */     this.lien4.setClLienNom2(ConfigurationMCD2.getColor(config.clLienNom2));
/* 278 */     this.lien4.setClLienText2(ConfigurationMCD2.getColor(config.clLienText2));
/* 279 */     this.lien4.getCardinalites().setClFond2(ConfigurationMCD2.getColor(config.clPage2));
/* 280 */     this.lien4.getCardinalites().setClText2(ConfigurationMCD2.getColor(config.clLienNomCardinalite2));
/* 281 */     this.lien4.setEpaisseur(config.lienEntiteRelation2);
/*     */     
/* 283 */     this.cnt.setClCadre2(ConfigurationMCD2.getColor(config.clContrainteCadre2));
/* 284 */     this.cnt.setClFond2(ConfigurationMCD2.getColor(config.clContrainteFond2));
/* 285 */     this.cnt.setClText2(ConfigurationMCD2.getColor(config.clContrainteText2));
/* 286 */     this.cnt.setEpaisseur(config.lienContraintes2);
/* 287 */     this.cnt.setOmbre(config.isOmbree2);
/* 288 */     this.cnt.setClDegradee(config.isDegradee2);
/*     */     
/* 290 */     this.cif.setClCadre2(ConfigurationMCD2.getColor(config.clCIFCadre2));
/* 291 */     this.cif.setClFond2(ConfigurationMCD2.getColor(config.clCIFFond2));
/* 292 */     this.cif.setClText2(ConfigurationMCD2.getColor(config.clCIFText2));
/* 293 */     this.cif.setEpaisseur(config.traitContraintes2);
/* 294 */     this.cif.setOmbre(config.isOmbree2);
/* 295 */     this.cif.setClDegradee(config.isDegradee2);
/*     */     
/* 297 */     this.her.setClCadre2(ConfigurationMCD2.getColor(config.clHeritageCadre2));
/* 298 */     this.her.setClFond2(ConfigurationMCD2.getColor(config.clHeritageFond2));
/* 299 */     this.her.setClText2(ConfigurationMCD2.getColor(config.clHeritageText2));
/* 300 */     this.her.setEpaisseur(config.traitContraintes2);
/* 301 */     this.her.setOmbre(config.isOmbree2);
/* 302 */     this.her.setClDegradee(config.isDegradee2);
/*     */     
/* 304 */     this.com.setClCadre(ConfigurationMCD2.getColor(config.clCommentaireCadre2));
/* 305 */     this.com.setClFond(ConfigurationMCD2.getColor(config.clCommentaireFond2));
/* 306 */     this.com.setClTexte(ConfigurationMCD2.getColor(config.clCommentaireText2));
/* 307 */     this.com.setOmbre(config.isOmbree2);
/* 308 */     this.com.setClDegradee(config.isDegradee2);
/*     */     
/* 310 */     this.post.setClCadre(ConfigurationMCD2.getColor(config.clPostItCadre2));
/* 311 */     this.post.setClFond(ConfigurationMCD2.getColor(config.clPostItFond2));
/* 312 */     this.post.setClTexte(ConfigurationMCD2.getColor(config.clPostItText2));
/* 313 */     this.post.setClPunaise(ConfigurationMCD2.getColor(config.clPostItPunaise2));
/* 314 */     this.post.setClDegradee(config.isDegradee2);
/*     */     
/* 316 */     this.lienCnt1.setClLienContrainte2(ConfigurationMCD2.getColor(config.clLienContrainte2));
/* 317 */     this.lienCnt1.setClLienTextContrainte2(ConfigurationMCD2.getColor(config.clLienTextContrainte2));
/* 318 */     this.lienCnt1.setEpaisseur(config.lienContraintes2);
/*     */     
/* 320 */     this.lienCnt2.setClLienContrainte2(ConfigurationMCD2.getColor(config.clLienContrainte2));
/* 321 */     this.lienCnt2.setClLienTextContrainte2(ConfigurationMCD2.getColor(config.clLienTextContrainte2));
/* 322 */     this.lienCnt2.setEpaisseur(config.lienContraintes2);
/*     */     
/* 324 */     this.lienCnt3.setClLienContrainte2(ConfigurationMCD2.getColor(config.clLienContrainte2));
/* 325 */     this.lienCnt3.setClLienTextContrainte2(ConfigurationMCD2.getColor(config.clLienTextContrainte2));
/* 326 */     this.lienCnt3.setEpaisseur(config.lienContraintes2);
/*     */     
/* 328 */     this.lienCif1.setClLienCIF2(ConfigurationMCD2.getColor(config.clLienCIF2));
/* 329 */     this.lienCif1.setClLienNomCIF2(ConfigurationMCD2.getColor(config.clLienNomCIF2));
/* 330 */     this.lienCif1.setClLienTextCIF2(ConfigurationMCD2.getColor(config.clLienTextCIF2));
/* 331 */     this.lienCif1.setEpaisseur(config.lienContraintes2);
/*     */     
/* 333 */     this.lienCif2.setClLienCIF2(ConfigurationMCD2.getColor(config.clLienCIF2));
/* 334 */     this.lienCif2.setClLienNomCIF2(ConfigurationMCD2.getColor(config.clLienNomCIF2));
/* 335 */     this.lienCif2.setClLienTextCIF2(ConfigurationMCD2.getColor(config.clLienTextCIF2));
/* 336 */     this.lienCif2.setEpaisseur(config.lienContraintes2);
/*     */     
/* 338 */     this.lienCif3.setClLienCIF2(ConfigurationMCD2.getColor(config.clLienCIF2));
/* 339 */     this.lienCif3.setClLienNomCIF2(ConfigurationMCD2.getColor(config.clLienNomCIF2));
/* 340 */     this.lienCif3.setClLienTextCIF2(ConfigurationMCD2.getColor(config.clLienTextCIF2));
/* 341 */     this.lienCif3.setEpaisseur(config.lienContraintes2);
/*     */     
/* 343 */     this.lienHer1.setClLienHeritage2(ConfigurationMCD2.getColor(config.clLienHeritage2));
/* 344 */     this.lienHer1.setClLienNomHeritage2(ConfigurationMCD2.getColor(config.clLienNomHeritage2));
/* 345 */     this.lienHer1.setClLienFondNom(ConfigurationMCD2.getColor(config.clPage2));
/* 346 */     this.lienHer1.setEpaisseur(config.lienContraintes2);
/*     */     
/* 348 */     this.lienHer2.setClLienHeritage2(ConfigurationMCD2.getColor(config.clLienHeritage2));
/* 349 */     this.lienHer2.setClLienNomHeritage2(ConfigurationMCD2.getColor(config.clLienNomHeritage2));
/* 350 */     this.lienHer2.setClLienFondNom(ConfigurationMCD2.getColor(config.clPage2));
/* 351 */     this.lienHer2.setEpaisseur(config.lienContraintes2);
/*     */     
/*     */ 
/* 354 */     this.lienCom.setClFond2(ConfigurationMCD2.getColor(config.clLienCommentaire2));
/*     */     
/*     */ 
/* 357 */     this.clPage = ConfigurationMCD2.getColor(config.clPage2);
/* 358 */     setClPage(this.clPage);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCouleurEntite(Color clEntiteCadre2, Color clEntiteFond2, Color clEntiteFondTitre2, Color clEntiteText2, Color clEntiteTextTitre2, Color clEntiteTextType2)
/*     */   {
/* 366 */     this.ent1.setClCadre2(clEntiteCadre2);
/* 367 */     this.ent1.setClFond2(clEntiteFond2);
/* 368 */     this.ent1.setClFondTitre2(clEntiteFondTitre2);
/* 369 */     this.ent1.setClText2(clEntiteText2);
/* 370 */     this.ent1.setClTextTitre2(clEntiteTextTitre2);
/* 371 */     this.ent1.setClTextType2(clEntiteTextType2);
/*     */     
/* 373 */     this.ent2.setClCadre2(clEntiteCadre2);
/* 374 */     this.ent2.setClFond2(clEntiteFond2);
/* 375 */     this.ent2.setClFondTitre2(clEntiteFondTitre2);
/* 376 */     this.ent2.setClText2(clEntiteText2);
/* 377 */     this.ent2.setClTextTitre2(clEntiteTextTitre2);
/* 378 */     this.ent2.setClTextType2(clEntiteTextType2);
/*     */     
/* 380 */     this.ent3.setClCadre2(clEntiteCadre2);
/* 381 */     this.ent3.setClFond2(clEntiteFond2);
/* 382 */     this.ent3.setClFondTitre2(clEntiteFondTitre2);
/* 383 */     this.ent3.setClText2(clEntiteText2);
/* 384 */     this.ent3.setClTextTitre2(clEntiteTextTitre2);
/* 385 */     this.ent3.setClTextType2(clEntiteTextType2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProprieteEntiteRelation(boolean typeMajuscule2, float interLigne2, float traitEntiteRelation2, boolean afficherPrk2, boolean afficherType)
/*     */   {
/* 392 */     this.ent1.setAttMajuscule(typeMajuscule2);
/* 393 */     this.ent1.setAttEspace(interLigne2);
/* 394 */     this.ent1.setEpaisseur(traitEntiteRelation2);
/* 395 */     this.ent1.setPrkvisible(afficherPrk2);
/* 396 */     this.ent1.setVariable(afficherType);
/*     */     
/* 398 */     this.ent2.setAttMajuscule(typeMajuscule2);
/* 399 */     this.ent2.setAttEspace(interLigne2);
/* 400 */     this.ent2.setEpaisseur(traitEntiteRelation2);
/* 401 */     this.ent2.setPrkvisible(afficherPrk2);
/* 402 */     this.ent2.setVariable(afficherType);
/*     */     
/* 404 */     this.ent3.setAttMajuscule(typeMajuscule2);
/* 405 */     this.ent3.setAttEspace(interLigne2);
/* 406 */     this.ent3.setEpaisseur(traitEntiteRelation2);
/* 407 */     this.ent3.setPrkvisible(afficherPrk2);
/* 408 */     this.ent3.setVariable(afficherType);
/*     */     
/* 410 */     this.rel1.setAttMajuscule(typeMajuscule2);
/* 411 */     this.rel1.setAttEspace(interLigne2);
/* 412 */     this.rel1.setEpaisseur(traitEntiteRelation2);
/* 413 */     this.rel1.setPrkvisible(afficherPrk2);
/* 414 */     this.rel1.setVariable(afficherType);
/*     */     
/* 416 */     this.rel2.setAttMajuscule(typeMajuscule2);
/* 417 */     this.rel2.setAttEspace(interLigne2);
/* 418 */     this.rel2.setEpaisseur(traitEntiteRelation2);
/* 419 */     this.rel2.setPrkvisible(afficherPrk2);
/* 420 */     this.rel2.setVariable(afficherType);
/*     */   }
/*     */   
/*     */   public void setOmbreDegradee(boolean degrad, boolean ombre, Color clOmbre)
/*     */   {
/* 425 */     this.ent1.setOmbre(ombre);
/* 426 */     this.ent1.setClDegradee(degrad);
/* 427 */     this.ent1.setClOmbre(clOmbre);
/*     */     
/* 429 */     this.ent2.setOmbre(ombre);
/* 430 */     this.ent2.setClDegradee(degrad);
/* 431 */     this.ent2.setClOmbre(clOmbre);
/*     */     
/* 433 */     this.ent3.setOmbre(ombre);
/* 434 */     this.ent3.setClDegradee(degrad);
/* 435 */     this.ent3.setClOmbre(clOmbre);
/*     */     
/* 437 */     this.rel1.setOmbre(ombre);
/* 438 */     this.rel1.setClDegradee(degrad);
/* 439 */     this.rel1.setClOmbre(clOmbre);
/*     */     
/* 441 */     this.rel2.setOmbre(ombre);
/* 442 */     this.rel2.setClDegradee(degrad);
/* 443 */     this.rel2.setClOmbre(clOmbre);
/*     */     
/* 445 */     this.cif.setOmbre(ombre);
/* 446 */     this.cif.setClDegradee(degrad);
/* 447 */     this.cif.setClOmbre(clOmbre);
/*     */     
/* 449 */     this.cnt.setOmbre(ombre);
/* 450 */     this.cnt.setClDegradee(degrad);
/* 451 */     this.cnt.setClOmbre(clOmbre);
/*     */     
/* 453 */     this.com.setOmbre(ombre);
/* 454 */     this.com.setClDegradee(degrad);
/* 455 */     this.com.setClOmbre(clOmbre);
/*     */     
/*     */ 
/* 458 */     this.post.setClDegradee(degrad);
/*     */   }
/*     */   
/*     */   public void setArrondir(boolean arrondir) {
/* 462 */     this.ent1.setArrondir(arrondir);
/* 463 */     this.ent2.setArrondir(arrondir);
/* 464 */     this.ent3.setArrondir(arrondir);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 477 */     GroupLayout layout = new GroupLayout(this);
/* 478 */     setLayout(layout);
/* 479 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 713, 32767));
/*     */     
/*     */ 
/*     */ 
/* 483 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 284, 32767));
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\ApercuProprieteMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */