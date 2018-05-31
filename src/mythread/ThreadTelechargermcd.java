/*     */ package mythread;
/*     */ 
/*     */ import IhmMCD.IhmCadre;
/*     */ import IhmMCD.IhmCommentaireIndip;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmHeritage;
/*     */ import IhmMCD.IhmLien;
/*     */ import IhmMCD.IhmLienCommentaire;
/*     */ import IhmMCD.IhmLienContrainteHeritage;
/*     */ import IhmMCD.IhmLienContraintes;
/*     */ import IhmMCD.IhmLienHeritage;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmProjet;
/*     */ import IhmMCD2.ConfigurationMCD2;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmHeritage2;
/*     */ import IhmMCD2.IhmLien2;
/*     */ import IhmMCD2.IhmLienContrainteHeritage2;
/*     */ import IhmMCD2.IhmLienHeritage2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import IhmMLD.IhmPageMLD;
/*     */ import Merise.Domaine;
/*     */ import Merise2.Historique;
/*     */ import MyExplorer.ExplorerPan;
/*     */ import MySqlEditor.MySqlTextPane;
/*     */ import MyXMLEditor.MyXMLTextPane;
/*     */ import Outil.ConfigSave;
/*     */ import Outil.ProprieteMCD;
/*     */ import Outil.Setting;
/*     */ import Output.SQLSave;
/*     */ import formes.FormeBibioMCD;
/*     */ import formes.FormeConstruction;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.FormeInterneMLD;
/*     */ import ihm.FormeInterneSQL;
/*     */ import ihm.FormeInterneXML;
/*     */ import ihm.Principale;
/*     */ import java.beans.PropertyVetoException;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Properties;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JProgressBar;
/*     */ import verificationAdaptation.ConversionMerise2;
/*     */ 
/*     */ public class ThreadTelechargermcd extends javax.swing.SwingWorker
/*     */ {
/*     */   private Principale frm;
/*     */   private String urlFile;
/*     */   private String id;
/*     */   FormeConstruction frmCons;
/*     */   
/*     */   public ThreadTelechargermcd(Principale frm, String urlFile, String id)
/*     */   {
/*  64 */     this.frm = frm;
/*  65 */     this.id = id;
/*  66 */     this.urlFile = ("http://jfreesoft.com/" + urlFile);
/*  67 */     this.frmCons = new FormeConstruction(frm, true);
/*  68 */     this.frmCons.setModal(false);
/*  69 */     this.frmCons.getjLabNom().setText("Télécharger le MCD");
/*  70 */     this.frmCons.getjProgBar().setValue(20);
/*     */   }
/*     */   
/*     */   private void initialiserCouleurCadre() {
/*  74 */     for (int i = 0; i < this.frm.getPage().getListeCadre().size(); i++) {
/*  75 */       ((IhmCadre)this.frm.getPage().getListeCadre().get(i)).initialiserCouleurCadre();
/*     */     }
/*     */   }
/*     */   
/*     */   private void initialiserCouleurCommentaire() {
/*  80 */     for (int i = 0; i < this.frm.getPage().getListeCommentaire().size(); i++) {
/*  81 */       ((IhmCommentaireIndip)this.frm.getPage().getListeCommentaire().get(i)).initialiserCouleur();
/*     */     }
/*     */   }
/*     */   
/*     */   private void initialiserCouleurs() {
/*  86 */     initialiserCouleurCadre();
/*  87 */     initialiserCouleurCommentaire();
/*     */   }
/*     */   
/*     */   private int nombreDeJour(Date d1, Date d2) {
/*  91 */     long MILLISECONDS_PER_DAY = 86400000L;
/*  92 */     long delta = d1.getTime() - d2.getTime();
/*  93 */     return (int)(delta / 86400000L);
/*     */   }
/*     */   
/*     */   private String inverserDate(String d) {
/*  97 */     String jj = d.substring(0, 2);
/*  98 */     String mm = d.substring(3, 5);
/*  99 */     String aa = d.substring(6, 10);
/* 100 */     return aa + "/" + mm + "/" + jj;
/*     */   }
/*     */   
/*     */   private void verifierLaSynchronisation(Principale frm, ConfigurationMCD2 config) {
/* 104 */     if (!config.isCorrectForOpen()) {
/* 105 */       JOptionPane.showMessageDialog(frm, "JM 0.5 ERREUR : Problème de synchronisation N°Sy1.0 Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/* 106 */       frm.setDefaultCloseOperation(3);
/* 107 */       frm.dispose();
/*     */     }
/*     */   }
/*     */   
/*     */   private void verifierLaSynchronisation(Principale frm, ProprieteMCD propriete) {
/* 112 */     String dMCD = propriete.getDateDerniereUtilisation();
/*     */     
/* 114 */     if ((dMCD == null) || (dMCD.length() == 0)) {
/* 115 */       dMCD = propriete.getDateCreation();
/*     */     }
/* 117 */     if ((dMCD == null) || (dMCD.length() == 0)) return;
/* 118 */     String djour = propriete.getDateJour();
/* 119 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
/* 120 */     Date datMCD = new Date(inverserDate(dMCD));
/* 121 */     Date datjour = new Date();
/*     */     
/* 123 */     int nb = nombreDeJour(datjour, datMCD);
/* 124 */     if (nb <= -3) {
/* 125 */       JOptionPane.showMessageDialog(frm, "ERREUR : Problème N°Sy1.0 Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/* 126 */       frm.setDefaultCloseOperation(3);
/* 127 */       frm.dispose();
/*     */     }
/* 129 */     Date datFin = new Date(Setting.dateFin);
/* 130 */     nb = nombreDeJour(datFin, datjour);
/* 131 */     if (nb <= -3) {
/* 132 */       JOptionPane.showMessageDialog(frm, "ERREUR : Problème N°Sy1.2 Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/* 133 */       frm.setDefaultCloseOperation(3);
/* 134 */       frm.dispose();
/*     */     }
/*     */   }
/*     */   
/*     */   public ObjectInputStream dump(String URLName) {
/* 139 */     String s = "";
/* 140 */     ObjectInputStream di = null;
/* 141 */     java.io.FileOutputStream fo = null;
/*     */     
/* 143 */     if (Setting.proxy) {
/* 144 */       System.getProperties().put("http.proxyHost", Setting.proxyHTTP);
/* 145 */       System.getProperties().put("http.proxyPort", Setting.proxyPort);
/* 146 */       System.getProperties().put("http.proxyUser", Setting.proxyLogin);
/* 147 */       System.getProperties().put("http.proxyPassword", Setting.proxyPassW);
/*     */     }
/*     */     else {
/* 150 */       System.getProperties().put("http.proxyHost", "");
/* 151 */       System.getProperties().put("http.proxyPort", "");
/* 152 */       System.getProperties().put("http.proxyUser", "");
/* 153 */       System.getProperties().put("http.proxyPassword", "");
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 158 */       URL u = new URL(URLName);
/*     */       try {
/* 160 */         HttpURLConnection con = (HttpURLConnection)u.openConnection();
/* 161 */         di = new ObjectInputStream(con.getInputStream());
/*     */       } catch (IOException ex) {
/* 163 */         return null;
/*     */       }
/*     */     } catch (MalformedURLException ex) {
/* 166 */       return null;
/*     */     }
/* 168 */     return di;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean existeLienHeritage(IhmLienHeritage2 lien, ArrayList<IhmLienContrainteHeritage> liste)
/*     */   {
/* 175 */     for (int i = 0; i < liste.size(); i++) {
/* 176 */       IhmLienContrainteHeritage2 lc = (IhmLienContrainteHeritage2)liste.get(i);
/* 177 */       if ((lc.getEntiteRelation() != lc.getHeritage().getPere()) && (
/* 178 */         ((lc.getHeritage().getPere() == lien.getPere()) && (lc.getEntiteRelation() == lien.getFils())) || ((lc.getHeritage().getPere() == lien.getFils()) && (lc.getEntiteRelation() == lien.getPere()))))
/*     */       {
/* 180 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 184 */     return false;
/*     */   }
/*     */   
/*     */   private void corrigerLesHeritage(ArrayList<IhmLienHeritage> listeLienH, ArrayList<IhmLienContrainteHeritage> listeLienCntH, ArrayList<IhmHeritage> listeHeritage)
/*     */   {
/* 189 */     for (int i = 0; i < listeLienH.size(); i++) {
/* 190 */       IhmLienHeritage2 lien = (IhmLienHeritage2)listeLienH.get(i);
/* 191 */       int x = (lien.getFils().getCentreX() + lien.getPere().getCentreX()) / 2;
/* 192 */       int y = (lien.getFils().getCentreY() + lien.getPere().getCentreY()) / 2;
/*     */       
/* 194 */       if (!existeLienHeritage(lien, listeLienCntH)) {
/* 195 */         IhmHeritage2 h = new IhmHeritage2(x, y, lien.getPere(), 0);
/* 196 */         IhmLienContrainteHeritage2 ch = new IhmLienContrainteHeritage2(h, lien.getPere());
/* 197 */         listeLienCntH.add(ch);
/* 198 */         ch = new IhmLienContrainteHeritage2(h, lien.getFils());
/* 199 */         listeLienCntH.add(ch);
/* 200 */         listeHeritage.add(h);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void setConfiguration(ConfigSave config, ConfigurationMCD2 config2)
/*     */   {
/* 208 */     config2.isDegradee2 = config.isIsDegradee();
/* 209 */     config2.isOmbree2 = config.isIsOmbre();
/* 210 */     config2.afficheType2 = config.isIsVariable();
/* 211 */     ArrayList<IhmEntiteRelation> listeEn = this.frm.getFormeMCD().getPage().getListeEntiteRelation();
/*     */     
/* 213 */     for (int i = 0; i < listeEn.size(); i++) {
/* 214 */       if ((listeEn.get(i) instanceof IhmEntite2)) {
/* 215 */         IhmEntite2 ent = (IhmEntite2)listeEn.get(i);
/* 216 */         ent.setClCadre2(ConfigurationMCD2.getColor(config.getClEntiteCadre()));
/* 217 */         ent.setClCadreTitre2(ConfigurationMCD2.getColor(config.getClEntiteCadre()));
/* 218 */         ent.setClFond2(ConfigurationMCD2.getColor(config.getClEntiteFond()));
/* 219 */         ent.setClFondTitre2(ConfigurationMCD2.getColor(config.getClEntiteFond()));
/* 220 */         ent.setClText2(ConfigurationMCD2.getColor(config.getClEntiteText()));
/* 221 */         ent.setClTextTitre2(ConfigurationMCD2.getColor(config.getClEntiteText()));
/* 222 */         ent.setVariable(config.isIsVariable());
/* 223 */         ent.setOmbre(config.isIsOmbre());
/* 224 */         ent.setClDegradee(config.isIsDegradee());
/*     */       }
/*     */       
/* 227 */       if ((listeEn.get(i) instanceof IhmRelation2)) {
/* 228 */         IhmRelation2 rel = (IhmRelation2)listeEn.get(i);
/* 229 */         rel.setClCadre2(ConfigurationMCD2.getColor(config.getClRelationCadre()));
/* 230 */         rel.setClCadreTitre2(ConfigurationMCD2.getColor(config.getClRelationCadre()));
/* 231 */         rel.setClFond2(ConfigurationMCD2.getColor(config.getClRelationFond()));
/* 232 */         rel.setClFondTitre2(ConfigurationMCD2.getColor(config.getClRelationFond()));
/* 233 */         rel.setClText2(ConfigurationMCD2.getColor(config.getClRelationText()));
/* 234 */         rel.setClTextTitre2(ConfigurationMCD2.getColor(config.getClRelationText()));
/* 235 */         rel.setVariable(config.isIsVariable());
/* 236 */         rel.setOmbre(config.isIsOmbre());
/* 237 */         rel.setClDegradee(config.isIsDegradee());
/*     */       }
/*     */     }
/*     */     
/* 241 */     ArrayList<IhmLien> listeLien = this.frm.getFormeMCD().getPage().getListeLien();
/*     */     
/* 243 */     for (int i = 0; i < listeLien.size(); i++) {
/* 244 */       IhmLien2 l2 = (IhmLien2)listeLien.get(i);
/* 245 */       l2.setClLien2(ConfigurationMCD2.getColor(config.getClLien()));
/* 246 */       l2.setClLienNom2(ConfigurationMCD2.getColor(config.getClString()));
/* 247 */       l2.setClLienText2(ConfigurationMCD2.getColor(config.getClString()));
/* 248 */       l2.getCardinalites().setClText2(ConfigurationMCD2.getColor(config.getClString()));
/*     */     }
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
/*     */   private String getNomMCD0491(String s)
/*     */   {
/* 284 */     if ((s == null) || (s.length() == 0)) return "";
/* 285 */     if (s.indexOf("<action>") < 0) return "";
/* 286 */     if (s.indexOf("</action>") < 0) return "";
/* 287 */     if (s.indexOf("<nommcd>") < 0) return "";
/* 288 */     if (s.indexOf("</nommcd>") < 0) return "";
/* 289 */     s = s.substring(s.indexOf("<nommcd>") + 8, s.indexOf("</nommcd>"));
/* 290 */     return s;
/*     */   }
/*     */   
/*     */   private String getRegleMCD0491(String s) {
/* 294 */     if ((s == null) || (s.length() == 0)) return "";
/* 295 */     if (s.indexOf("<regle>") < 0) return "";
/* 296 */     s = s.substring(s.indexOf("<regle>") + 7, s.length() - 8);
/* 297 */     return s;
/*     */   }
/*     */   
/*     */   private String getActionMCD(String s) {
/* 301 */     s = s.substring(s.indexOf("<Action>") + 8, s.indexOf("</Action>"));
/* 302 */     s = s.trim();
/* 303 */     return s;
/*     */   }
/*     */   
/*     */   private String getDeveloppeurMCD(String s) {
/* 307 */     s = s.substring(s.indexOf("<Dev>") + 5, s.indexOf("</Dev>"));
/* 308 */     s = s.trim();
/* 309 */     return s;
/*     */   }
/*     */   
/*     */   private String getDateMCD(String s) {
/* 313 */     s = s.substring(s.indexOf("<Date>") + 6, s.indexOf("</Date>"));
/* 314 */     s = s.trim();
/* 315 */     return s;
/*     */   }
/*     */   
/*     */   private void setHistoriqueMCD(ConfigurationMCD2 config, ProprieteMCD propriete)
/*     */   {
/* 320 */     config.regleGestion = getRegleMCD0491(propriete.getNote());
/* 321 */     config.nomMCD = getNomMCD0491(propriete.getNote());
/* 322 */     config.Commentaire = propriete.getCommentaire();
/*     */     
/* 324 */     config.getHistorique().clear();
/* 325 */     Historique h = new Historique("CREATION", propriete.createur);
/* 326 */     h.setVersion("---");
/* 327 */     h.setDate(propriete.getDateCreation());
/* 328 */     config.getHistorique().add(h);
/* 329 */     config.setDateDerniereSauvegarde(propriete.getDateDerniereUtilisation());
/* 330 */     String s = propriete.getHistorique();
/* 331 */     while (s.contains("<H>")) {
/* 332 */       String date = getDateMCD(s);
/* 333 */       String dev = getDeveloppeurMCD(s);
/* 334 */       String action = getActionMCD(s);
/* 335 */       h = new Historique(action.toUpperCase(), dev);
/* 336 */       h.setVersion("---");
/* 337 */       h.setDate(date);
/* 338 */       config.getHistorique().add(h);
/* 339 */       s = s.substring(s.indexOf("</H>") + 4, s.length());
/* 340 */       s = s.trim();
/*     */     }
/*     */   }
/*     */   
/*     */   private void setParametreMLD_SQL(ConfigurationMCD2 conf, SQLSave save) {
/* 345 */     IhmPageMLD pm = this.frm.getFormeMLD().getPageMld();
/* 346 */     pm.setClPage(ConfigurationMCD2.getColor(conf.MLDclPage));
/* 347 */     pm.getFormeMLD().zoom = conf.MLDZoom;
/* 348 */     pm.setZoom(conf.MLDZoom);
/* 349 */     pm.getFormeMLD().afficheType2 = conf.MLDAfficheType2;
/* 350 */     pm.getFormeMLD().arrondirEntite2 = conf.MLDArrondire2;
/* 351 */     pm.getFormeMLD().isDegradee2 = conf.MLDClDegradee2;
/* 352 */     pm.getFormeMLD().isOmbree2 = conf.MLDOmbree2;
/* 353 */     this.frm.getFormeSQL().getPanelsql().setTypeSql(save.getType());
/* 354 */     this.frm.getFormeSQL().getPanelsql().getPane().setText(save.getScript());
/*     */   }
/*     */   
/*     */   public void ouvrirMCD_JUSQUA_0401(ObjectInputStream ois, FormeConstruction frmCons, Object ob)
/*     */   {
/* 359 */     ArrayList<IhmEntiteRelation> listeER = (ArrayList)ob;
/*     */     try
/*     */     {
/* 362 */       this.frm.getPage().repaint();
/*     */       
/* 364 */       ArrayList<IhmLien> listeLien = (ArrayList)ois.readObject();
/* 365 */       frmCons.getjProgBar().setValue(30);
/* 366 */       ArrayList<IhmMCD.IhmCIF> listeCif = (ArrayList)ois.readObject();
/* 367 */       frmCons.getjProgBar().setValue(40);
/* 368 */       ArrayList<IhmMCD.IhmLienCif> listeLienCif = (ArrayList)ois.readObject();
/* 369 */       frmCons.getjProgBar().setValue(50);
/* 370 */       ArrayList<IhmCommentaireIndip> listeCommentaireInd = (ArrayList)ois.readObject();
/* 371 */       frmCons.getjProgBar().setValue(60);
/* 372 */       ArrayList<IhmLienHeritage> listeLienHeritage = (ArrayList)ois.readObject();
/* 373 */       frmCons.getjProgBar().setValue(70);
/* 374 */       ArrayList<IhmEntiteRelation> listeContrainte = (ArrayList)ois.readObject();
/* 375 */       frmCons.getjProgBar().setValue(80);
/* 376 */       ArrayList<IhmLienContraintes> listelienContrainte = (ArrayList)ois.readObject();
/*     */       
/* 378 */       frmCons.getjProgBar().setValue(85);
/* 379 */       ArrayList<IhmCadre> listeCadre = (ArrayList)ois.readObject();
/* 380 */       frmCons.getjProgBar().setValue(90);
/* 381 */       ArrayList<IhmLienCommentaire> listeLienCommentaire = (ArrayList)ois.readObject();
/* 382 */       frmCons.getjProgBar().setValue(95);
/*     */       
/*     */ 
/* 385 */       ConfigSave config = (ConfigSave)ois.readObject();
/*     */       
/*     */ 
/* 388 */       ArrayList<Merise.Attribut> listeAttribut = (ArrayList)ois.readObject();
/* 389 */       ArrayList<IhmHeritage> listeHeritage = (ArrayList)ois.readObject();
/* 390 */       ArrayList<IhmLienContrainteHeritage> listeLienContrainteHeritage = (ArrayList)ois.readObject();
/* 391 */       ArrayList<Domaine> listeDomaine = (ArrayList)ois.readObject();
/*     */       
/* 393 */       ConversionMerise2.listeCorresp.clear();
/*     */       
/* 395 */       this.frm.getFormeMCD().getPage().setListeEntiteRelation(ConversionMerise2.conversionEntitreRelation(listeER));
/* 396 */       setConfiguration(config, this.frm.getFormeMCD().getPage().getConfigurationMCD());
/* 397 */       this.frm.getFormeMCD().getPage().setListeLien(ConversionMerise2.conversionLien(listeLien));
/*     */       
/* 399 */       this.frm.getFormeMCD().getPage().setListeCIF(ConversionMerise2.conversionCIF(listeCif));
/* 400 */       this.frm.getFormeMCD().getPage().setListelienCIF(ConversionMerise2.conversionLienCIF(listeLienCif));
/*     */       
/* 402 */       this.frm.getFormeMCD().getPage().setListeContrainte(ConversionMerise2.conversionContrainte(listeContrainte));
/* 403 */       this.frm.getFormeMCD().getPage().setListeLienContrainte(ConversionMerise2.conversionLienContrainte(listelienContrainte));
/*     */       
/*     */ 
/* 406 */       this.frm.getFormeMCD().getPage().setListeHeritage(ConversionMerise2.conversionHeritage(listeHeritage));
/* 407 */       this.frm.getFormeMCD().getPage().setListeLienHeritage(ConversionMerise2.conversionLienHeritage(listeLienHeritage));
/* 408 */       this.frm.getFormeMCD().getPage().setListeLienContrainteHeritage(ConversionMerise2.conversionLienContrainteHeritage(listeLienContrainteHeritage));
/*     */       
/* 410 */       corrigerLesHeritage(this.frm.getFormeMCD().getPage().getListeLienHeritage(), this.frm.getFormeMCD().getPage().getListeLienContrainteHeritage(), this.frm.getFormeMCD().getPage().getListeHeritage());
/*     */       
/*     */ 
/* 413 */       this.frm.getFormeMCD().getPage().setListeCommentaire(ConversionMerise2.conversionCommentaire(listeCommentaireInd));
/* 414 */       this.frm.getFormeMCD().getPage().setListeLienCommentaire(ConversionMerise2.conversionLienCommentaire(listeLienCommentaire));
/*     */       
/* 416 */       this.frm.getFormeMCD().getPage().setListeAttribut(ConversionMerise2.conversionListeAttribut(listeAttribut));
/*     */       
/* 418 */       this.frm.getFormeMCD().setConfig(config);
/*     */       
/* 420 */       this.frm.getFormeMCD().getPage().setListeDomaine(listeDomaine);
/* 421 */       this.frm.getFormeMCD().getPage().setListeCadre(listeCadre);
/*     */       
/*     */ 
/*     */ 
/* 425 */       this.frm.getFormeMCD().setNomFichier("");
/* 426 */       this.frm.getFormeMCD().setCheminFichier("");
/* 427 */       this.frm.setTitle("JMerise :");
/*     */       
/*     */       try
/*     */       {
/* 431 */         this.frm.getExplorer().initialiserTree();
/*     */       }
/*     */       catch (Exception ex) {}
/*     */       try
/*     */       {
/* 436 */         this.frm.getFormeMCD().getPage().setProprieteMCD((ProprieteMCD)ois.readObject());
/* 437 */         setHistoriqueMCD(this.frm.getFormeMCD().getPage().getConfigurationMCD(), this.frm.getFormeMCD().getPage().getProprieteMCD());
/* 438 */         verifierLaSynchronisation(this.frm, this.frm.getFormeMCD().getPage().getConfigurationMCD());
/*     */       } catch (IOException e) {
/* 440 */         this.frm.getFormeMCD().getPage().setProprieteMCD(new ProprieteMCD(Setting.developpeur));
/*     */       }
/*     */     } catch (IOException e) {
/* 443 */       this.frm.getFormeMCD().setNomFichier("");
/* 444 */       this.frm.getFormeMCD().setCheminFichier("");
/* 445 */       this.frm.setTitle("JMerise :");
/* 446 */       JOptionPane.showMessageDialog(this.frm, " Une exception est survenue lors de l'ouveture \n" + e.toString(), "Exceptions", 0);
/*     */     } catch (ClassNotFoundException e) {
/* 448 */       JOptionPane.showMessageDialog(this.frm, " Une exception est survenue lors de l'ouveture \n" + e.toString(), "Exceptions", 0);
/*     */     }
/* 450 */     this.frm.getFormeMCD().initialiserMenu();
/* 451 */     this.frm.getFormeMCD().getFormeMLD().getPageMld().effacerAllEntite();
/* 452 */     this.frm.getFormeSQL().getPanelsql().getPane().setText("");
/* 453 */     this.frm.getFormeXML().getPanelXML().getPane().setText("");
/* 454 */     this.frm.getFormeMCD().setModifier(true);
/* 455 */     this.frm.getFormeMCD().setVisible(true);
/* 456 */     this.frm.getFormeMCD().getPage().setSelected(false);
/*     */     try {
/* 458 */       this.frm.getFormeMCD().setIcon(false);
/*     */     } catch (PropertyVetoException ex) {
/* 460 */       Logger.getLogger(ThreadTelechargermcd.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 462 */     this.frm.getFormeMCD().toFront();
/*     */   }
/*     */   
/*     */   public void ouvrirMCD_05(ObjectInputStream ois, FormeConstruction frmCons, Object ob)
/*     */   {
/*     */     try {
/* 468 */       this.frm.getFormeMCD().getPage().setConfigurationMCD((ConfigurationMCD2)ob);
/*     */       
/* 470 */       this.frm.getFormeMCD().getPage().setListeEntiteRelation((ArrayList)ois.readObject());
/*     */       
/* 472 */       this.frm.getFormeMCD().getPage().setListeLien((ArrayList)ois.readObject());
/*     */       
/* 474 */       this.frm.getFormeMCD().getPage().setListeCIF((ArrayList)ois.readObject());
/*     */       
/* 476 */       this.frm.getFormeMCD().getPage().setListelienCIF((ArrayList)ois.readObject());
/*     */       
/* 478 */       this.frm.getFormeMCD().getPage().setListeCommentaire((ArrayList)ois.readObject());
/*     */       
/* 480 */       this.frm.getFormeMCD().getPage().setListeLienCommentaire((ArrayList)ois.readObject());
/*     */       
/* 482 */       this.frm.getFormeMCD().getPage().setListeLienHeritage((ArrayList)ois.readObject());
/*     */       
/* 484 */       this.frm.getFormeMCD().getPage().setListeHeritage((ArrayList)ois.readObject());
/*     */       
/* 486 */       this.frm.getFormeMCD().getPage().setListeLienContrainteHeritage((ArrayList)ois.readObject());
/*     */       
/* 488 */       this.frm.getFormeMCD().getPage().setListeContrainte((ArrayList)ois.readObject());
/*     */       
/* 490 */       this.frm.getFormeMCD().getPage().setListeLienContrainte((ArrayList)ois.readObject());
/*     */       
/* 492 */       this.frm.getFormeMCD().getPage().setListeCadre((ArrayList)ois.readObject());
/*     */       
/*     */ 
/* 495 */       this.frm.getFormeMCD().getPage().setListeAttribut((ArrayList)ois.readObject());
/*     */       
/* 497 */       this.frm.getFormeMCD().getPage().setListeDomaine((ArrayList)ois.readObject());
/*     */       
/* 499 */       this.frm.getFormeMCD().getFormeMLD().getPageMld().effacerAllEntite();
/* 500 */       this.frm.getFormeSQL().getPanelsql().getPane().setText("");
/* 501 */       this.frm.getFormeXML().getPanelXML().getPane().setText("");
/*     */       
/* 503 */       if (Principale.isActiverJMerise())
/*     */       {
/* 505 */         SQLSave sqlSave = (SQLSave)ois.readObject();
/* 506 */         ArrayList<IhmMLD2.MLDEntite2> listeMLDEntite = (ArrayList)ois.readObject();
/* 507 */         ArrayList<IhmMLD2.MLDLienEntite2> listeLien = (ArrayList)ois.readObject();
/*     */         
/* 509 */         ArrayList<IhmCadre> listeCadre = (ArrayList)ois.readObject();
/* 510 */         ArrayList<IhmCommentaireIndip> listeCommentaire = (ArrayList)ois.readObject();
/* 511 */         ArrayList<IhmLienCommentaire> listeLienCommentaire = (ArrayList)ois.readObject();
/* 512 */         ArrayList<Merise2.EntiteRelationContrainte2> listeEntRelContrainte = (ArrayList)ois.readObject();
/*     */         
/* 514 */         this.frm.getFormeMLD().getPageMld().setListeMLDEntite(listeMLDEntite);
/* 515 */         this.frm.getFormeMLD().getPageMld().setListeLien(listeLien);
/* 516 */         this.frm.getFormeMLD().getPageMld().setListeCadre(listeCadre);
/* 517 */         this.frm.getFormeMLD().getPageMld().setListeCommentaire(listeCommentaire);
/* 518 */         this.frm.getFormeMLD().getPageMld().setListeLienCommentaire(listeLienCommentaire);
/* 519 */         this.frm.getFormeMLD().getPageMld().setListeEntRelContrainte(listeEntRelContrainte);
/*     */         
/* 521 */         setParametreMLD_SQL(this.frm.getFormeMCD().getPage().getConfigurationMCD(), sqlSave);
/*     */       }
/*     */       
/* 524 */       verifierLaSynchronisation(this.frm, this.frm.getFormeMCD().getPage().getConfigurationMCD());
/*     */       
/* 526 */       this.frm.getFormeMCD().setNomFichier("");
/* 527 */       this.frm.getFormeMCD().setCheminFichier("");
/* 528 */       this.frm.setTitle("JMerise :");
/*     */       
/* 530 */       this.frm.getFormeMCD().initialiserParametreMCD(this.frm.getFormeMCD().getPage().getConfigurationMCD());
/*     */       try
/*     */       {
/* 533 */         this.frm.getExplorer().initialiserTree();
/*     */       } catch (Exception ex) {
/* 535 */         JOptionPane.showMessageDialog(this.frm, " Une exception est survenue lors de l'initialisation de l'explorer \n" + ex.toString(), "Exceptions", 0);
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 540 */       this.frm.getFormeMCD().setNomFichier("");
/* 541 */       this.frm.getFormeMCD().setCheminFichier("");
/* 542 */       this.frm.setTitle("JMerise :");
/* 543 */       JOptionPane.showMessageDialog(this.frm, " Une exception est survenue lors de l'ouveture \n" + e.toString(), "Exceptions", 0);
/*     */     } catch (ClassNotFoundException e) {
/* 545 */       JOptionPane.showMessageDialog(this.frm, " Une exception est survenue lors de l'ouveture \n" + e.toString(), "Exceptions", 0);
/*     */     }
/*     */     
/* 548 */     this.frm.getFormeMCD().setModifier(false);
/* 549 */     this.frm.getFormeMCD().setVisible(true);
/*     */     try {
/* 551 */       this.frm.getFormeMCD().setIcon(false);
/*     */     } catch (PropertyVetoException ex) {
/* 553 */       Logger.getLogger(ThreadTelechargermcd.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 555 */     this.frm.getFormeMCD().toFront();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void ouvrirMCD(ObjectInputStream ois, FormeConstruction frmCons)
/*     */   {
/*     */     try
/*     */     {
/* 564 */       Object ob = ois.readObject();
/* 565 */       if (!(ob instanceof ConfigurationMCD2)) {
/* 566 */         ouvrirMCD_JUSQUA_0401(ois, frmCons, ob);
/* 567 */         return;
/*     */       }
/* 569 */       ouvrirMCD_05(ois, frmCons, ob);
/*     */     }
/*     */     catch (IOException ex)
/*     */     {
/* 573 */       Logger.getLogger(ThreadTelechargermcd.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (ClassNotFoundException ex) {
/* 575 */       Logger.getLogger(ThreadTelechargermcd.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected Object doInBackground()
/*     */     throws Exception
/*     */   {
/* 583 */     this.frmCons.setVisible(true);
/* 584 */     this.frmCons.getjProgBar().setValue(1);
/* 585 */     ObjectInputStream ios = dump(this.urlFile);
/* 586 */     if (ios != null) {
/* 587 */       this.frm.getFormeBibioMCD().dispose();
/* 588 */       this.frm.creerNouveauProjet();
/* 589 */       this.frm.getFormeMCD().getPage().effacerAllMCD();
/* 590 */       ouvrirMCD(ios, this.frmCons);
/* 591 */       this.frmCons.getjProgBar().setValue(100);
/* 592 */       this.frmCons.dispose();
/* 593 */       this.frm.getFormeMCD().getPage().repaint();
/* 594 */       this.frm.getFormeMCD().repaint();
/* 595 */       this.frm.getPage().repaint();
/* 596 */       this.frm.repaint();
/* 597 */       this.frm.getFormeMCD().setModifier(true);
/* 598 */       this.frm.getProjetSel().getFormeMCD().getPage().requestFocus();
/* 599 */       new ThreadIncrementLoad(this.frm, this.id);
/*     */     } else {
/* 601 */       JOptionPane.showMessageDialog(this.frm.getFormeBibioMCD(), "Erreur de connexion \n Vérifiez votre connexion ou vos paramêtres proxy\n dans configuration -> parametres -> onglet réseau");
/* 602 */       this.frmCons.getjProgBar().setValue(100);
/* 603 */       this.frmCons.dispose();
/* 604 */       this.frm.getFormeMCD().getPage().repaint();
/* 605 */       this.frm.getFormeMCD().repaint();
/* 606 */       this.frm.getPage().repaint();
/* 607 */       this.frm.repaint();
/* 608 */       this.frm.getProjetSel().getFormeMCD().getPage().requestFocus();
/* 609 */       this.frm.getFormeBibioMCD().dispose();
/*     */     }
/* 611 */     return Integer.valueOf(1);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadTelechargermcd.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */