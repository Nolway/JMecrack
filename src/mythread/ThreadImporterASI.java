/*     */ package mythread;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmLien;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmRelation;
/*     */ import IhmMCD2.IhmCardinalite;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmLien2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import Merise.Attribut;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Merise2.Attribut2;
/*     */ import Merise2.Entite2;
/*     */ import Merise2.Relation2;
/*     */ import MyExplorer.ExplorerPan;
/*     */ import Outil.Parametres;
/*     */ import formes.FormeConstruction;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.Principale;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.SwingWorker;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThreadImporterASI
/*     */   extends SwingWorker
/*     */ {
/*     */   private Principale frm;
/*     */   private String cheminFichier;
/*     */   private Map<String, Attribut> dictionnaire;
/*     */   private ArrayList<IhmEntiteRelation> listeEntRel;
/*     */   private ArrayList<IhmLien> listeLien;
/*     */   
/*     */   public ThreadImporterASI(Principale frm, String cheminFichier)
/*     */   {
/*  58 */     this.frm = frm;
/*  59 */     this.cheminFichier = cheminFichier;
/*  60 */     this.dictionnaire = new HashMap();
/*  61 */     this.listeEntRel = new ArrayList();
/*  62 */     this.listeLien = new ArrayList();
/*     */   }
/*     */   
/*     */ 
/*     */   private void ajouterListeAttribut(String s)
/*     */   {
/*  68 */     String code = s.substring(s.indexOf("code=") + 6, s.indexOf("nom="));
/*  69 */     String nom = s.substring(s.indexOf("nom=") + 5, s.indexOf("type="));
/*  70 */     String type = s.substring(s.indexOf("type=") + 6, s.indexOf("taille="));
/*  71 */     String taill = s.substring(s.indexOf("taille=") + 8, s.indexOf("utilise="));
/*     */     
/*  73 */     code = code.replaceAll("\"", "");
/*  74 */     code = code.replaceAll(" ", "");
/*  75 */     nom = nom.replaceAll("\"", "");
/*  76 */     nom = nom.replaceAll(" ", "");
/*  77 */     type = type.replaceAll("\"", "");
/*  78 */     type = type.replaceAll(" ", "");
/*  79 */     taill = taill.replaceAll("\"", "");
/*  80 */     taill = taill.replaceAll(" ", "");
/*  81 */     int t = Integer.parseInt(taill);
/*  82 */     if (t <= 0) t = -1;
/*  83 */     type = getMyType(type);
/*  84 */     Attribut2 attributt = new Attribut2(nom, code, type, t, 0, "", true, "", null);
/*  85 */     this.dictionnaire.put(code, attributt);
/*     */   }
/*     */   
/*     */   private String getMyType(String typ) {
/*  89 */     for (int i = 0; i < Parametres.DomaineDefini.length; i++) {
/*  90 */       if (Parametres.DomaineDefini[i].trim().toUpperCase().equals(typ.trim().toUpperCase())) return Parametres.DomaineDefini[i];
/*     */     }
/*  92 */     return "Varchar";
/*     */   }
/*     */   
/*     */ 
/*     */   private IhmEntite getMyIhmEntite(String chaine)
/*     */   {
/*  98 */     String nom = chaine.substring(chaine.indexOf("nom=") + 5, chaine.indexOf("x="));
/*  99 */     nom = nom.replace("\"", "");
/* 100 */     nom = nom.replace(" ", "");
/*     */     
/* 102 */     String x = chaine.substring(chaine.indexOf("x=") + 3, chaine.indexOf("y="));
/* 103 */     x = x.replaceAll("\"", "");
/* 104 */     x = x.replaceAll(" ", "");
/*     */     
/* 106 */     String y = chaine.substring(chaine.indexOf("y=") + 3, chaine.indexOf(">"));
/* 107 */     y = y.replaceAll("\"", "");
/* 108 */     y = y.replaceAll(" ", "");
/*     */     
/* 110 */     return new IhmEntite2(new Entite2(nom), Integer.parseInt(x), Integer.parseInt(y), this.frm.isTailleVariable());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private IhmRelation getMyIhmRelation(String chaine)
/*     */   {
/* 117 */     String nom = chaine.substring(chaine.indexOf("nom=") + 5, chaine.indexOf("x="));
/* 118 */     nom = nom.replace("\"", "");
/* 119 */     nom = nom.replace(" ", "");
/*     */     
/* 121 */     String x = chaine.substring(chaine.indexOf("x=") + 3, chaine.indexOf("y="));
/* 122 */     x = x.replaceAll("\"", "");
/* 123 */     x = x.replaceAll(" ", "");
/*     */     
/* 125 */     String y = chaine.substring(chaine.indexOf("y=") + 3, chaine.indexOf(">"));
/* 126 */     y = y.replaceAll("\"", "");
/* 127 */     y = y.replaceAll(" ", "");
/* 128 */     return new IhmRelation2(new Relation2(nom), Integer.parseInt(x), Integer.parseInt(y), this.frm.isTailleVariable());
/*     */   }
/*     */   
/*     */   private Attribut getAttribut(String code) {
/* 132 */     return (Attribut)this.dictionnaire.get(code);
/*     */   }
/*     */   
/*     */   private void insererAttribut(IhmEntite ent, String s, boolean cle) {
/* 136 */     s = s.substring(s.indexOf("code=") + 6, s.indexOf("/>"));
/* 137 */     s = s.replaceAll("\"", "");
/* 138 */     s = s.replaceAll(" ", "");
/*     */     
/* 140 */     Attribut att = getAttribut(s);
/* 141 */     if (att != null) {
/* 142 */       att = att.copier();
/* 143 */       att.setEntiteRelation(ent.getEntite());
/* 144 */       if (cle) att.setKey(Parametres.Cle);
/* 145 */       ent.getEntite().getListeAttributs().add(att);
/*     */     }
/*     */   }
/*     */   
/*     */   private void insererAttribut(IhmRelation rel, String s) {
/* 150 */     s = s.substring(s.indexOf("code=") + 6, s.indexOf("/>"));
/* 151 */     s = s.replaceAll("\"", "");
/* 152 */     s = s.replaceAll(" ", "");
/*     */     
/* 154 */     Attribut att = getAttribut(s);
/* 155 */     if (att != null) {
/* 156 */       att = att.copier();
/* 157 */       att.setEntiteRelation(rel.getRelation());
/* 158 */       rel.getRelation().getListeAttributs().add(att);
/*     */     }
/*     */   }
/*     */   
/*     */   private IhmEntiteRelation getEntiteRelation(String nom)
/*     */   {
/* 164 */     for (int i = 0; i < this.listeEntRel.size(); i++) {
/* 165 */       if ((this.listeEntRel.get(i) instanceof IhmEntite2)) {
/* 166 */         if (((IhmEntite2)this.listeEntRel.get(i)).getEntite().getNom().trim().toUpperCase().equals(nom.trim().toUpperCase())) return (IhmEntiteRelation)this.listeEntRel.get(i);
/*     */       }
/* 168 */       else if (((IhmRelation2)this.listeEntRel.get(i)).getRelation().getNom().trim().toUpperCase().equals(nom.trim().toUpperCase())) { return (IhmEntiteRelation)this.listeEntRel.get(i);
/*     */       }
/*     */     }
/* 171 */     return null;
/*     */   }
/*     */   
/*     */   private void ajouterLien(String s)
/*     */   {
/* 176 */     String min = s.substring(s.indexOf("cardmin=") + 9, s.indexOf("cardmax="));
/* 177 */     String max = s.substring(s.indexOf("cardmax=") + 9, s.indexOf("elem1="));
/* 178 */     String el1 = s.substring(s.indexOf("elem1=") + 7, s.indexOf("elem2="));
/* 179 */     String el2 = s.substring(s.indexOf("elem2=") + 7, s.indexOf("/>"));
/*     */     
/* 181 */     min = min.replaceAll("\"", "");
/* 182 */     min = min.replaceAll(" ", "");
/*     */     
/* 184 */     max = max.replaceAll("\"", "");
/* 185 */     max = max.replaceAll(" ", "");
/*     */     
/* 187 */     el1 = el1.replaceAll("\"", "");
/* 188 */     el1 = el1.replaceAll(" ", "");
/*     */     
/* 190 */     el2 = el2.replaceAll("\"", "");
/* 191 */     el2 = el2.replaceAll(" ", "");
/*     */     
/*     */ 
/* 194 */     IhmEntiteRelation e1 = getEntiteRelation(el1);
/* 195 */     IhmEntiteRelation e2 = getEntiteRelation(el2);
/* 196 */     IhmLien2 li = null;
/* 197 */     if ((e1 instanceof IhmEntite2)) {
/* 198 */       li = new IhmLien2((IhmEntite2)e1, (IhmRelation2)e2);
/*     */     } else {
/* 200 */       li = new IhmLien2((IhmEntite2)e2, (IhmRelation2)e1);
/*     */     }
/* 202 */     if (li != null) {
/* 203 */       li.setCardinalite(getCardinalite(min, max));
/* 204 */       li.getCardinalites().setNom(li.getCardinalite());
/* 205 */       this.listeLien.add(li);
/*     */     }
/*     */   }
/*     */   
/*     */   private String getCardinalite(String min, String max)
/*     */   {
/* 211 */     if (max.equals("N")) return min + ",n";
/* 212 */     return min + "," + max;
/*     */   }
/*     */   
/*     */   private ArrayList<Attribut> remplirDictionnire()
/*     */   {
/* 217 */     ArrayList<Attribut> li = new ArrayList();
/* 218 */     Object[] k = this.dictionnaire.keySet().toArray();
/* 219 */     for (int i = 0; i < k.length; i++) {
/* 220 */       li.add(this.dictionnaire.get((String)k[i]));
/*     */     }
/* 222 */     return li;
/*     */   }
/*     */   
/*     */   public void importer(String nomFichier, FormeConstruction frmCons)
/*     */   {
/* 227 */     BufferedReader in = null;
/*     */     try {
/* 229 */       frmCons.getjProgBar().setValue(10);
/* 230 */       in = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(new File(nomFichier)))));
/*     */       
/* 232 */       String type = "";
/*     */       
/*     */ 
/* 235 */       frmCons.getjProgBar().setValue(20);
/* 236 */       for (;;) { String s; if ((s = in.readLine()) == null) break;
/* 237 */         if (s.indexOf("<dictionnaire") > -1) {
/* 238 */           while ((s = in.readLine()).indexOf("</dictionnaire>") == -1) {
/* 239 */             if (s.indexOf("information") > -1) ajouterListeAttribut(s);
/*     */           }
/*     */         }
/* 242 */         frmCons.getjProgBar().setValue(30);
/* 243 */         if (s.indexOf("<mcd>") > -1)
/*     */         {
/* 245 */           if ((s = in.readLine()).indexOf("</mcd") == -1) {
/* 246 */             if (s.indexOf("<entite") > -1) {
/* 247 */               IhmEntite ent = getMyIhmEntite(s);
/* 248 */               if (ent != null) {
/* 249 */                 boolean cle = true;
/* 250 */                 this.listeEntRel.add(ent);
/* 251 */                 while ((s = in.readLine()).indexOf("</entite>") == -1) {
/* 252 */                   if (s.indexOf("information") > -1) {
/* 253 */                     insererAttribut(ent, s, cle);
/* 254 */                     cle = false;
/*     */                   }
/* 256 */                   if (s.indexOf("</entite>") > -1)
/*     */                     break;
/*     */                 }
/*     */               }
/*     */             }
/* 261 */             if (s.indexOf("<association") >= 0) {
/* 262 */               IhmRelation rel = getMyIhmRelation(s);
/* 263 */               frmCons.getjProgBar().setValue(40);
/* 264 */               if (rel != null) {
/* 265 */                 this.listeEntRel.add(rel);
/* 266 */                 while (!(s = in.readLine()).equals("</association>"))
/*     */                 {
/* 268 */                   if (s.indexOf("information") > -1) {
/* 269 */                     insererAttribut(rel, s);
/*     */                   }
/* 271 */                   if (s.indexOf("</association>") > -1) break;
/*     */                 }
/*     */               }
/*     */             }
/* 275 */             frmCons.getjProgBar().setValue(50);
/* 276 */             if (s.indexOf("<lien") >= 0)
/*     */             {
/* 278 */               ajouterLien(s);
/*     */             }
/*     */             
/* 281 */             if (s.indexOf("</mcd>") <= -1) break;
/*     */           } }
/*     */       }
/*     */       label374:
/* 285 */       frmCons.getjProgBar().setValue(60);
/* 286 */       this.frm.getFormeMCD().toFront();
/* 287 */       this.frm.getPage().setListeEntiteRelation(this.listeEntRel);
/* 288 */       this.frm.getPage().setListeLien(this.listeLien);
/* 289 */       this.frm.getPage().setListeAttribut(remplirDictionnire());
/*     */       
/* 291 */       frmCons.getjProgBar().setValue(70);
/* 292 */       this.frm.getPage().setListeCIF(new ArrayList());
/* 293 */       this.frm.getPage().setListelienCIF(new ArrayList());
/* 294 */       frmCons.getjProgBar().setValue(80);
/*     */       
/* 296 */       this.frm.getPage().setListeCommentaire(new ArrayList());
/* 297 */       this.frm.getPage().setListeLienHeritage(new ArrayList());
/* 298 */       this.frm.getPage().setListeContrainte(new ArrayList());
/* 299 */       this.frm.getPage().setListeLienContrainte(new ArrayList());
/* 300 */       this.frm.getPage().setListeCadre(new ArrayList());
/* 301 */       this.frm.getPage().setListeLienCommentaire(new ArrayList());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 306 */       this.frm.getPage().setListeHeritage(new ArrayList());
/* 307 */       this.frm.getPage().setListeLienContrainteHeritage(new ArrayList());
/* 308 */       this.frm.getPage().setListeDomaine(new ArrayList());
/*     */       
/* 310 */       frmCons.getjProgBar().setValue(90);
/* 311 */       this.frm.setNomFichier("");
/* 312 */       this.frm.setCheminFichier("");
/* 313 */       this.frm.setTitle("JMerise :" + this.frm.getNomFichier());
/* 314 */       this.frm.getFormeMCD().setModifier(true);
/* 315 */       this.frm.getPage().repaint();
/*     */       try {
/* 317 */         this.frm.getExplorer().initialiserTree();
/*     */       }
/*     */       catch (Exception ex) {}
/*     */       return;
/*     */     } catch (IOException ex) {
/* 322 */       Logger.getLogger(ThreadImporterASI.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } finally {
/*     */       try {
/* 325 */         in.close();
/* 326 */         frmCons.getjProgBar().setValue(100);
/*     */       } catch (IOException ex) {
/* 328 */         Logger.getLogger(ThreadImporterASI.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected Object doInBackground() throws Exception
/*     */   {
/* 335 */     this.frm.getPage().effacerAllMCD();
/* 336 */     FormeConstruction frmCons = new FormeConstruction(this.frm, true);
/* 337 */     frmCons.setModal(false);
/* 338 */     frmCons.getjLabNom().setText("ouvrir un MCD");
/*     */     
/* 340 */     frmCons.setVisible(true);
/* 341 */     frmCons.getjProgBar().setValue(1);
/* 342 */     importer(this.cheminFichier, frmCons);
/* 343 */     frmCons.getjProgBar().setValue(100);
/* 344 */     frmCons.dispose();
/* 345 */     this.frm.getPage().setSelected(false);
/* 346 */     this.frm.getPage().repaint();
/*     */     
/* 348 */     return Integer.valueOf(1);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadImporterASI.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */