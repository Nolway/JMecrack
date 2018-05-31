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
/*     */ import IhmMLD2.MLDEntite2;
/*     */ import Merise.Attribut;
/*     */ import Merise.Domaine;
/*     */ import Merise2.Historique;
/*     */ import MyExplorer.ExplorerPan;
/*     */ import MySqlEditor.MySqlTextPane;
/*     */ import MyXMLEditor.MyXMLTextPane;
/*     */ import Outil.ConfigSave;
/*     */ import Outil.ProprieteMCD;
/*     */ import Outil.Setting;
/*     */ import Output.SQLSave;
/*     */ import formes.FormeConstruction;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.FormeInterneMLD;
/*     */ import ihm.FormeInterneSQL;
/*     */ import ihm.FormeInterneXML;
/*     */ import ihm.Principale;
/*     */ import java.beans.PropertyVetoException;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JProgressBar;
/*     */ import verificationAdaptation.ConversionMerise2;
/*     */ 
/*     */ public class ThreadOuvrir extends javax.swing.SwingWorker
/*     */ {
/*     */   private Principale frm;
/*     */   private String cheminFichier;
/*     */   
/*     */   public ThreadOuvrir(Principale frm, String cheminFichier)
/*     */   {
/*  59 */     this.frm = frm;
/*  60 */     this.cheminFichier = cheminFichier;
/*     */   }
/*     */   
/*     */   private void verifierLaSynchronisation(Principale frm, ConfigurationMCD2 config) {
/*  64 */     if (!config.isCorrectForOpen()) {
/*  65 */       JOptionPane.showMessageDialog(frm, "JM 0.5 ERREUR : Problème de synchronisation N°Sy1.0 Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*  66 */       frm.setDefaultCloseOperation(3);
/*  67 */       frm.dispose();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean existeLienHeritage(IhmLienHeritage2 lien, ArrayList<IhmLienContrainteHeritage> liste)
/*     */   {
/*  74 */     for (int i = 0; i < liste.size(); i++) {
/*  75 */       IhmLienContrainteHeritage2 lc = (IhmLienContrainteHeritage2)liste.get(i);
/*  76 */       if ((lc.getEntiteRelation() != lc.getHeritage().getPere()) && (
/*  77 */         ((lc.getHeritage().getPere() == lien.getPere()) && (lc.getEntiteRelation() == lien.getFils())) || ((lc.getHeritage().getPere() == lien.getFils()) && (lc.getEntiteRelation() == lien.getPere()))))
/*     */       {
/*  79 */         return true;
/*     */       }
/*     */     }
/*     */     
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   private void corrigerLesHeritage(ArrayList<IhmLienHeritage> listeLienH, ArrayList<IhmLienContrainteHeritage> listeLienCntH, ArrayList<IhmHeritage> listeHeritage)
/*     */   {
/*  88 */     for (int i = 0; i < listeLienH.size(); i++) {
/*  89 */       IhmLienHeritage2 lien = (IhmLienHeritage2)listeLienH.get(i);
/*  90 */       int x = (lien.getFils().getCentreX() + lien.getPere().getCentreX()) / 2;
/*  91 */       int y = (lien.getFils().getCentreY() + lien.getPere().getCentreY()) / 2;
/*     */       
/*  93 */       if (!existeLienHeritage(lien, listeLienCntH)) {
/*  94 */         IhmHeritage2 h = new IhmHeritage2(x, y, lien.getPere(), 0);
/*  95 */         IhmLienContrainteHeritage2 ch = new IhmLienContrainteHeritage2(h, lien.getPere());
/*  96 */         listeLienCntH.add(ch);
/*  97 */         ch = new IhmLienContrainteHeritage2(h, lien.getFils());
/*  98 */         listeLienCntH.add(ch);
/*  99 */         listeHeritage.add(h);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private String getNomMCD0491(String s)
/*     */   {
/* 107 */     if ((s == null) || (s.length() == 0)) return "";
/* 108 */     if (s.indexOf("<action>") < 0) return "";
/* 109 */     if (s.indexOf("</action>") < 0) return "";
/* 110 */     if (s.indexOf("<nommcd>") < 0) return "";
/* 111 */     if (s.indexOf("</nommcd>") < 0) return "";
/* 112 */     s = s.substring(s.indexOf("<nommcd>") + 8, s.indexOf("</nommcd>"));
/* 113 */     return s;
/*     */   }
/*     */   
/*     */   private String getRegleMCD0491(String s) {
/* 117 */     if ((s == null) || (s.length() == 0)) return "";
/* 118 */     if (s.indexOf("<regle>") < 0) return "";
/* 119 */     s = s.substring(s.indexOf("<regle>") + 7, s.length() - 8);
/* 120 */     return s;
/*     */   }
/*     */   
/*     */   private String getActionMCD(String s) {
/* 124 */     s = s.substring(s.indexOf("<Action>") + 8, s.indexOf("</Action>"));
/* 125 */     s = s.trim();
/* 126 */     return s;
/*     */   }
/*     */   
/*     */   private String getDeveloppeurMCD(String s) {
/* 130 */     s = s.substring(s.indexOf("<Dev>") + 5, s.indexOf("</Dev>"));
/* 131 */     s = s.trim();
/* 132 */     return s;
/*     */   }
/*     */   
/*     */   private String getDateMCD(String s) {
/* 136 */     s = s.substring(s.indexOf("<Date>") + 6, s.indexOf("</Date>"));
/* 137 */     s = s.trim();
/* 138 */     return s;
/*     */   }
/*     */   
/*     */   private String copieNomMCD(String nom) {
/* 142 */     String n = "" + System.currentTimeMillis();
/* 143 */     n = n.substring(n.length() - 5, n.length());
/* 144 */     if (nom.toUpperCase().endsWith(".MCD")) {
/* 145 */       nom = nom.replace(".mcd", "V05_" + n + ".mcd");
/*     */     } else {
/* 147 */       nom = nom + "V05_" + n + ".mcd";
/*     */     }
/* 149 */     return nom;
/*     */   }
/*     */   
/*     */   private void setConfiguration(ConfigSave config, ConfigurationMCD2 config2) {
/* 153 */     config2.isDegradee2 = config.isIsDegradee();
/* 154 */     config2.isOmbree2 = config.isIsOmbre();
/* 155 */     config2.afficheType2 = config.isIsVariable();
/* 156 */     ArrayList<IhmEntiteRelation> listeEn = this.frm.getFormeMCD().getPage().getListeEntiteRelation();
/*     */     
/* 158 */     for (int i = 0; i < listeEn.size(); i++) {
/* 159 */       if ((listeEn.get(i) instanceof IhmEntite2)) {
/* 160 */         IhmEntite2 ent = (IhmEntite2)listeEn.get(i);
/* 161 */         ent.setClCadre2(ConfigurationMCD2.getColor(config.getClEntiteCadre()));
/* 162 */         ent.setClCadreTitre2(ConfigurationMCD2.getColor(config.getClEntiteCadre()));
/* 163 */         ent.setClFond2(ConfigurationMCD2.getColor(config.getClEntiteFond()));
/* 164 */         ent.setClFondTitre2(ConfigurationMCD2.getColor(config.getClEntiteFond()));
/* 165 */         ent.setClText2(ConfigurationMCD2.getColor(config.getClEntiteText()));
/* 166 */         ent.setClTextTitre2(ConfigurationMCD2.getColor(config.getClEntiteText()));
/* 167 */         ent.setVariable(config.isIsVariable());
/* 168 */         ent.setOmbre(config.isIsOmbre());
/* 169 */         ent.setClDegradee(config.isIsDegradee());
/*     */       }
/*     */       
/* 172 */       if ((listeEn.get(i) instanceof IhmRelation2)) {
/* 173 */         IhmRelation2 rel = (IhmRelation2)listeEn.get(i);
/* 174 */         rel.setClCadre2(ConfigurationMCD2.getColor(config.getClRelationCadre()));
/* 175 */         rel.setClCadreTitre2(ConfigurationMCD2.getColor(config.getClRelationCadre()));
/* 176 */         rel.setClFond2(ConfigurationMCD2.getColor(config.getClRelationFond()));
/* 177 */         rel.setClFondTitre2(ConfigurationMCD2.getColor(config.getClRelationFond()));
/* 178 */         rel.setClText2(ConfigurationMCD2.getColor(config.getClRelationText()));
/* 179 */         rel.setClTextTitre2(ConfigurationMCD2.getColor(config.getClRelationText()));
/* 180 */         rel.setVariable(config.isIsVariable());
/* 181 */         rel.setOmbre(config.isIsOmbre());
/* 182 */         rel.setClDegradee(config.isIsDegradee());
/*     */       }
/*     */     }
/*     */     
/* 186 */     ArrayList<IhmLien> listeLien = this.frm.getFormeMCD().getPage().getListeLien();
/*     */     
/* 188 */     for (int i = 0; i < listeLien.size(); i++) {
/* 189 */       IhmLien2 l2 = (IhmLien2)listeLien.get(i);
/* 190 */       l2.setClLien2(ConfigurationMCD2.getColor(config.getClLien()));
/* 191 */       l2.setClLienNom2(ConfigurationMCD2.getColor(config.getClString()));
/* 192 */       l2.setClLienText2(ConfigurationMCD2.getColor(config.getClString()));
/* 193 */       l2.getCardinalites().setClText2(ConfigurationMCD2.getColor(config.getClString()));
/*     */     }
/*     */   }
/*     */   
/*     */   private void setHistoriqueMCD(ConfigurationMCD2 config, ProprieteMCD propriete)
/*     */   {
/* 199 */     config.regleGestion = getRegleMCD0491(propriete.getNote());
/* 200 */     config.nomMCD = getNomMCD0491(propriete.getNote());
/* 201 */     config.Commentaire = propriete.getCommentaire();
/*     */     
/* 203 */     config.getHistorique().clear();
/* 204 */     Historique h = new Historique("CREATION", propriete.createur);
/* 205 */     h.setDate(propriete.getDateCreation());
/* 206 */     h.setVersion("0.4.0.1");
/* 207 */     config.getHistorique().add(h);
/* 208 */     config.setDateDerniereSauvegarde(propriete.getDateDerniereUtilisation());
/* 209 */     String s = propriete.getHistorique();
/* 210 */     while (s.contains("<H>")) {
/* 211 */       String date = getDateMCD(s);
/* 212 */       String dev = getDeveloppeurMCD(s);
/* 213 */       String action = getActionMCD(s);
/* 214 */       h = new Historique(action.toUpperCase(), dev);
/* 215 */       h.setDate(date);
/* 216 */       h.setVersion("0.4.0.1");
/* 217 */       config.getHistorique().add(h);
/* 218 */       s = s.substring(s.indexOf("</H>") + 4, s.length());
/* 219 */       s = s.trim();
/*     */     }
/*     */   }
/*     */   
/*     */   private void setParametreMLD_SQL(ConfigurationMCD2 conf, SQLSave save)
/*     */   {
/* 225 */     IhmPageMLD pm = this.frm.getFormeMLD().getPageMld();
/* 226 */     pm.setClPage(ConfigurationMCD2.getColor(conf.MLDclPage));
/* 227 */     pm.getFormeMLD().zoom = conf.MLDZoom;
/* 228 */     pm.setZoom(conf.MLDZoom);
/* 229 */     pm.getFormeMLD().afficheType2 = conf.MLDAfficheType2;
/* 230 */     pm.getFormeMLD().arrondirEntite2 = conf.MLDArrondire2;
/* 231 */     pm.getFormeMLD().isDegradee2 = conf.MLDClDegradee2;
/* 232 */     pm.getFormeMLD().isOmbree2 = conf.MLDOmbree2;
/* 233 */     this.frm.getFormeSQL().getPanelsql().setTypeSql(save.getType());
/* 234 */     this.frm.getFormeSQL().getPanelsql().getPane().setText(save.getScript());
/*     */   }
/*     */   
/*     */   public void ouvrirMCD_05(ObjectInputStream ois, FormeConstruction frmCons, Object ob, String nomFichier)
/*     */   {
/*     */     try {
/* 240 */       this.frm.getFormeMCD().getPage().setConfigurationMCD((ConfigurationMCD2)ob);
/*     */       
/* 242 */       this.frm.getFormeMCD().getPage().setListeEntiteRelation((ArrayList)ois.readObject());
/* 243 */       frmCons.getjProgBar().setValue(30);
/* 244 */       this.frm.getFormeMCD().getPage().setListeLien((ArrayList)ois.readObject());
/*     */       
/* 246 */       this.frm.getFormeMCD().getPage().setListeCIF((ArrayList)ois.readObject());
/*     */       
/* 248 */       this.frm.getFormeMCD().getPage().setListelienCIF((ArrayList)ois.readObject());
/* 249 */       frmCons.getjProgBar().setValue(40);
/* 250 */       this.frm.getFormeMCD().getPage().setListeCommentaire((ArrayList)ois.readObject());
/*     */       
/* 252 */       this.frm.getFormeMCD().getPage().setListeLienCommentaire((ArrayList)ois.readObject());
/*     */       
/* 254 */       this.frm.getFormeMCD().getPage().setListeLienHeritage((ArrayList)ois.readObject());
/*     */       
/* 256 */       this.frm.getFormeMCD().getPage().setListeHeritage((ArrayList)ois.readObject());
/* 257 */       frmCons.getjProgBar().setValue(50);
/* 258 */       this.frm.getFormeMCD().getPage().setListeLienContrainteHeritage((ArrayList)ois.readObject());
/*     */       
/* 260 */       this.frm.getFormeMCD().getPage().setListeContrainte((ArrayList)ois.readObject());
/*     */       
/* 262 */       this.frm.getFormeMCD().getPage().setListeLienContrainte((ArrayList)ois.readObject());
/* 263 */       frmCons.getjProgBar().setValue(60);
/* 264 */       this.frm.getFormeMCD().getPage().setListeCadre((ArrayList)ois.readObject());
/*     */       
/*     */ 
/* 267 */       this.frm.getFormeMCD().getPage().setListeAttribut((ArrayList)ois.readObject());
/*     */       
/* 269 */       this.frm.getFormeMCD().getPage().setListeDomaine((ArrayList)ois.readObject());
/* 270 */       frmCons.getjProgBar().setValue(70);
/*     */       
/* 272 */       verifierLaSynchronisation(this.frm, this.frm.getFormeMCD().getPage().getConfigurationMCD());
/*     */       
/*     */ 
/* 275 */       if (Principale.isActiverJMerise())
/*     */       {
/* 277 */         SQLSave sqlSave = (SQLSave)ois.readObject();
/* 278 */         ArrayList<MLDEntite2> listeMLDEntite = (ArrayList)ois.readObject();
/* 279 */         ArrayList<IhmMLD2.MLDLienEntite2> listeLien = (ArrayList)ois.readObject();
/*     */         
/* 281 */         ArrayList<IhmCadre> listeCadre = (ArrayList)ois.readObject();
/* 282 */         ArrayList<IhmCommentaireIndip> listeCommentaire = (ArrayList)ois.readObject();
/* 283 */         ArrayList<IhmLienCommentaire> listeLienCommentaire = (ArrayList)ois.readObject();
/* 284 */         ArrayList<Merise2.EntiteRelationContrainte2> listeEntRelContrainte = (ArrayList)ois.readObject();
/*     */         
/* 286 */         this.frm.getFormeMLD().getPageMld().setListeMLDEntite(listeMLDEntite);
/* 287 */         this.frm.getFormeMLD().getPageMld().setListeLien(listeLien);
/* 288 */         this.frm.getFormeMLD().getPageMld().setListeCadre(listeCadre);
/* 289 */         this.frm.getFormeMLD().getPageMld().setListeCommentaire(listeCommentaire);
/* 290 */         this.frm.getFormeMLD().getPageMld().setListeLienCommentaire(listeLienCommentaire);
/* 291 */         this.frm.getFormeMLD().getPageMld().setListeEntRelContrainte(listeEntRelContrainte);
/*     */         
/* 293 */         setParametreMLD_SQL(this.frm.getFormeMCD().getPage().getConfigurationMCD(), sqlSave);
/*     */       } else {
/* 295 */         JOptionPane.showMessageDialog(this.frm, "Il faut activer cette version pour lire le MLD et le script sauvegardés  ! ");
/*     */       }
/*     */       
/*     */ 
/* 299 */       this.frm.getFormeMCD().getPage().setZoom(this.frm.getFormeMCD().getPage().getConfigurationMCD().zoom);
/* 300 */       this.frm.getFormeMCD().setNomFichier(nomFichier);
/* 301 */       this.frm.getFormeMCD().setCheminFichier(nomFichier);
/* 302 */       this.frm.setTitle("JMerise :" + nomFichier);
/* 303 */       this.frm.ajouterUnnouveauFichier(nomFichier);
/* 304 */       this.frm.setCheminDernierMCD(nomFichier);
/* 305 */       this.frm.getFormeMCD().getPage().getConfigurationMCD().setChemin(nomFichier);
/*     */       
/* 307 */       this.frm.getFormeMCD().getPage().setZoom(this.frm.getFormeMCD().getPage().getConfigurationMCD().zoom);
/* 308 */       this.frm.getFormeMCD().initialiserParametreMCD(this.frm.getFormeMCD().getPage().getConfigurationMCD());
/* 309 */       frmCons.getjProgBar().setValue(80);
/*     */       try {
/* 311 */         this.frm.getExplorer().initialiserTree();
/*     */       } catch (Exception ex) {
/* 313 */         JOptionPane.showMessageDialog(this.frm, " Une exception est survenue lors de l'initialisation de l'explorer \n" + ex.toString(), "Exceptions", 0);
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 318 */       this.frm.getFormeMCD().setNomFichier("");
/* 319 */       this.frm.getFormeMCD().setCheminFichier("");
/* 320 */       this.frm.setTitle("JMerise :");
/* 321 */       JOptionPane.showMessageDialog(this.frm, " Une exception est survenue lors de l'ouveture \n" + e.toString(), "Exceptions", 0);
/*     */     } catch (ClassNotFoundException e) {
/* 323 */       JOptionPane.showMessageDialog(this.frm, " Une exception est survenue lors de l'ouveture \n" + e.toString(), "Exceptions", 0);
/*     */     }
/*     */     
/* 326 */     this.frm.getFormeMCD().setModifier(false);
/* 327 */     this.frm.getFormeMCD().setVisible(true);
/*     */     try {
/* 329 */       this.frm.getFormeMCD().setIcon(false);
/*     */     } catch (PropertyVetoException ex) {
/* 331 */       Logger.getLogger(ThreadTelechargermcd.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 333 */     this.frm.getFormeMCD().toFront();
/* 334 */     frmCons.getjProgBar().setValue(90);
/*     */   }
/*     */   
/*     */   public void ouvrirMCD_JUSQUA_0401(ObjectInputStream ois, FormeConstruction frmCons, Object ob, String nomFichier) {
/* 338 */     ArrayList<IhmEntiteRelation> listeER = (ArrayList)ob;
/*     */     try
/*     */     {
/* 341 */       this.frm.getPage().repaint();
/*     */       
/* 343 */       ArrayList<IhmLien> listeLien = (ArrayList)ois.readObject();
/* 344 */       ArrayList<IhmMCD.IhmCIF> listeCif = (ArrayList)ois.readObject();
/* 345 */       ArrayList<IhmMCD.IhmLienCif> listeLienCif = (ArrayList)ois.readObject();
/* 346 */       frmCons.getjProgBar().setValue(30);
/* 347 */       ArrayList<IhmCommentaireIndip> listeCommentaireInd = (ArrayList)ois.readObject();
/* 348 */       ArrayList<IhmLienHeritage> listeLienHeritage = (ArrayList)ois.readObject();
/* 349 */       ArrayList<IhmEntiteRelation> listeContrainte = (ArrayList)ois.readObject();
/* 350 */       frmCons.getjProgBar().setValue(40);
/* 351 */       ArrayList<IhmLienContraintes> listelienContrainte = (ArrayList)ois.readObject();
/* 352 */       ArrayList<IhmCadre> listeCadre = (ArrayList)ois.readObject();
/* 353 */       ArrayList<IhmLienCommentaire> listeLienCommentaire = (ArrayList)ois.readObject();
/* 354 */       frmCons.getjProgBar().setValue(50);
/*     */       
/* 356 */       ConfigSave config = (ConfigSave)ois.readObject();
/*     */       
/* 358 */       ArrayList<Attribut> listeAttribut = (ArrayList)ois.readObject();
/* 359 */       ArrayList<IhmHeritage> listeHeritage = (ArrayList)ois.readObject();
/* 360 */       ArrayList<IhmLienContrainteHeritage> listeLienContrainteHeritage = (ArrayList)ois.readObject();
/* 361 */       ArrayList<Domaine> listeDomaine = (ArrayList)ois.readObject();
/* 362 */       frmCons.getjProgBar().setValue(60);
/* 363 */       ConversionMerise2.listeCorresp.clear();
/*     */       
/* 365 */       this.frm.getFormeMCD().getPage().setListeEntiteRelation(ConversionMerise2.conversionEntitreRelation(listeER));
/* 366 */       setConfiguration(config, this.frm.getFormeMCD().getPage().getConfigurationMCD());
/* 367 */       this.frm.getFormeMCD().getPage().setListeLien(ConversionMerise2.conversionLien(listeLien));
/*     */       
/* 369 */       this.frm.getFormeMCD().getPage().setListeCIF(ConversionMerise2.conversionCIF(listeCif));
/* 370 */       this.frm.getFormeMCD().getPage().setListelienCIF(ConversionMerise2.conversionLienCIF(listeLienCif));
/*     */       
/* 372 */       this.frm.getFormeMCD().getPage().setListeContrainte(ConversionMerise2.conversionContrainte(listeContrainte));
/* 373 */       this.frm.getFormeMCD().getPage().setListeLienContrainte(ConversionMerise2.conversionLienContrainte(listelienContrainte));
/*     */       
/* 375 */       frmCons.getjProgBar().setValue(70);
/* 376 */       this.frm.getFormeMCD().getPage().setListeHeritage(ConversionMerise2.conversionHeritage(listeHeritage));
/* 377 */       this.frm.getFormeMCD().getPage().setListeLienHeritage(ConversionMerise2.conversionLienHeritage(listeLienHeritage));
/* 378 */       this.frm.getFormeMCD().getPage().setListeLienContrainteHeritage(ConversionMerise2.conversionLienContrainteHeritage(listeLienContrainteHeritage));
/*     */       
/* 380 */       corrigerLesHeritage(this.frm.getFormeMCD().getPage().getListeLienHeritage(), this.frm.getFormeMCD().getPage().getListeLienContrainteHeritage(), this.frm.getFormeMCD().getPage().getListeHeritage());
/*     */       
/*     */ 
/* 383 */       this.frm.getFormeMCD().getPage().setListeCommentaire(ConversionMerise2.conversionCommentaire(listeCommentaireInd));
/* 384 */       this.frm.getFormeMCD().getPage().setListeLienCommentaire(ConversionMerise2.conversionLienCommentaire(listeLienCommentaire));
/*     */       
/* 386 */       this.frm.getFormeMCD().getPage().setListeAttribut(ConversionMerise2.conversionListeAttribut(listeAttribut));
/*     */       
/* 388 */       this.frm.getFormeMCD().setConfig(config);
/*     */       
/* 390 */       this.frm.getFormeMCD().getPage().setListeDomaine(listeDomaine);
/* 391 */       this.frm.getFormeMCD().getPage().setListeCadre(listeCadre);
/* 392 */       frmCons.getjProgBar().setValue(80);
/*     */       
/*     */ 
/* 395 */       if (Setting.ouvrirCreerUneCopie2) { nomFichier = copieNomMCD(nomFichier);
/*     */       }
/* 397 */       this.frm.getFormeMCD().setNomFichier(nomFichier);
/* 398 */       this.frm.getFormeMCD().setCheminFichier(nomFichier);
/* 399 */       this.frm.setTitle("JMerise :" + nomFichier);
/* 400 */       this.frm.ajouterUnnouveauFichier(nomFichier);
/* 401 */       this.frm.setCheminDernierMCD(nomFichier);
/* 402 */       this.frm.getFormeMCD().getPage().getConfigurationMCD().setChemin(nomFichier);
/*     */       try {
/* 404 */         this.frm.getExplorer().initialiserTree();
/*     */       }
/*     */       catch (Exception ex) {}
/*     */       try
/*     */       {
/* 409 */         this.frm.getFormeMCD().getPage().setProprieteMCD((ProprieteMCD)ois.readObject());
/* 410 */         setHistoriqueMCD(this.frm.getFormeMCD().getPage().getConfigurationMCD(), this.frm.getFormeMCD().getPage().getProprieteMCD());
/* 411 */         verifierLaSynchronisation(this.frm, this.frm.getFormeMCD().getPage().getConfigurationMCD());
/* 412 */         frmCons.getjProgBar().setValue(85);
/*     */       } catch (IOException e) {
/* 414 */         this.frm.getFormeMCD().getPage().setProprieteMCD(new ProprieteMCD(Setting.developpeur));
/*     */       }
/*     */     } catch (IOException e) {
/* 417 */       this.frm.getFormeMCD().setNomFichier("");
/* 418 */       this.frm.getFormeMCD().setCheminFichier("");
/* 419 */       this.frm.setTitle("JMerise :");
/* 420 */       JOptionPane.showMessageDialog(this.frm, " Une exception est survenue lors de l'ouveture \n" + e.toString(), "Exceptions", 0);
/*     */     } catch (ClassNotFoundException e) {
/* 422 */       JOptionPane.showMessageDialog(this.frm, " Une exception est survenue lors de l'ouveture \n" + e.toString(), "Exceptions", 0);
/*     */     }
/* 424 */     this.frm.getFormeMCD().initialiserMenu();
/* 425 */     this.frm.getFormeMCD().getFormeMLD().getPageMld().effacerAllEntite();
/* 426 */     this.frm.getFormeSQL().getPanelsql().getPane().setText("");
/* 427 */     this.frm.getFormeXML().getPanelXML().getPane().setText("");
/* 428 */     this.frm.getFormeMCD().setModifier(true);
/* 429 */     this.frm.getFormeMCD().setVisible(true);
/* 430 */     this.frm.getFormeMCD().getPage().setSelected(false);
/*     */     try {
/* 432 */       this.frm.getFormeMCD().setIcon(false);
/*     */     } catch (PropertyVetoException ex) {
/* 434 */       Logger.getLogger(ThreadOuvrir.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 436 */     this.frm.getFormeMCD().toFront();
/* 437 */     frmCons.getjProgBar().setValue(90);
/*     */   }
/*     */   
/*     */   public void ouvrirMCD(String nomFichier, FormeConstruction frmCons) {
/*     */     try {
/* 442 */       this.frm.setCheminDernierMCD(this.cheminFichier);
/* 443 */       this.frm.getPage().repaint();
/* 444 */       frmCons.getjProgBar().setValue(10);
/* 445 */       FileInputStream fichier = new FileInputStream(nomFichier);
/* 446 */       ObjectInputStream ois = new ObjectInputStream(fichier);
/*     */       
/* 448 */       Object ob = ois.readObject();
/*     */       
/* 450 */       if (!(ob instanceof ConfigurationMCD2)) {
/* 451 */         ouvrirMCD_JUSQUA_0401(ois, frmCons, ob, nomFichier);
/* 452 */         return;
/*     */       }
/* 454 */       ouvrirMCD_05(ois, frmCons, ob, nomFichier);
/*     */       
/* 456 */       frmCons.getjProgBar().setValue(100);
/*     */     } catch (IOException ex) {
/* 458 */       Logger.getLogger(ThreadOuvrir.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 461 */       Logger.getLogger(ThreadOuvrir.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   protected Object doInBackground()
/*     */     throws Exception
/*     */   {
/* 468 */     this.frm.getFormeMCD().getPage().effacerAllMCD();
/* 469 */     FormeConstruction frmCons = new FormeConstruction(this.frm, true);
/* 470 */     frmCons.setModal(false);
/* 471 */     frmCons.getjLabNom().setText("Ouvrir un MCD");
/*     */     
/* 473 */     frmCons.setVisible(true);
/* 474 */     frmCons.getjProgBar().setValue(1);
/* 475 */     ouvrirMCD(this.cheminFichier, frmCons);
/* 476 */     frmCons.getjProgBar().setValue(100);
/* 477 */     frmCons.dispose();
/* 478 */     this.frm.getFormeMCD().getPage().repaint();
/* 479 */     this.frm.getFormeMCD().repaint();
/* 480 */     this.frm.getPage().repaint();
/* 481 */     this.frm.getFormeMLD().getPageMld().remplirTree();
/* 482 */     this.frm.repaint();
/* 483 */     this.frm.getProjetSel().getFormeMCD().getPage().requestFocus();
/* 484 */     return Integer.valueOf(1);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadOuvrir.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */