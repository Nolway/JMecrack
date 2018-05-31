/*     */ package Outil;
/*     */ 
/*     */ import IhmMCD.BarOutil;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD2.ConfigurationMCD2;
/*     */ import LibraryPan.PanelEntiteRelation;
/*     */ import Menu.MyMenuItem;
/*     */ import Merise2.Attribut2;
/*     */ import MyExplorer.ExplorerPan;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.FormeInterneMLD;
/*     */ import ihm.FormeInterneRetro;
/*     */ import ihm.Principale;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JCheckBoxMenuItem;
/*     */ import javax.swing.JToggleButton;
/*     */ 
/*     */ public class DeskParamatres
/*     */ {
/*     */   private static String getBoolean(boolean rep)
/*     */   {
/*  27 */     if (rep) return "TRUE";
/*  28 */     return "FALSE";
/*     */   }
/*     */   
/*     */ 
/*     */   public static String bureauToString(Principale frm)
/*     */   {
/*  34 */     String s = "Toutes modifications de ce fichier entrainent un dysfonctionnement de JMerise\n";
/*  35 */     s = s + "Vous serez seul responsable des désagréments occasionnés\n";
/*  36 */     s = s + "<MRDESK>\n";
/*  37 */     s = s + "FENETREMCD_VISIBLE = TRUE;\n";
/*  38 */     s = s + "FENETREMCD_X = " + frm.getFormeMCD().getX() + ";\n";
/*  39 */     s = s + "FENETREMCD_Y = " + frm.getFormeMCD().getY() + ";\n";
/*  40 */     s = s + "FENETREMCD_W = " + frm.getFormeMCD().getWidth() + ";\n";
/*  41 */     s = s + "FENETREMCD_H = " + frm.getFormeMCD().getHeight() + ";\n";
/*  42 */     s = s + "OMBRE = " + getBoolean(frm.isOmbre()) + ";\n";
/*  43 */     s = s + "AFFICHER_TYPE = " + getBoolean(frm.isVariable()) + ";\n";
/*  44 */     s = s + "COULEURDEGRADEE = " + getBoolean(frm.isClDegradee()) + ";\n";
/*  45 */     s = s + "ARRONDIRANGLE = " + getBoolean(frm.isArrondirAngle()) + ";\n";
/*  46 */     s = s + "ACTIVERLIENSELECTION = " + getBoolean(frm.isActiverLienSelection()) + ";\n";
/*     */     
/*  48 */     s = s + "AFFICHER_CONSOLE = " + getBoolean(frm.getjMIConsole().isSelected()) + ";\n";
/*  49 */     s = s + "AFFICHER_EXPLORER = " + getBoolean(frm.getjMIExplorer().isSelected()) + ";\n";
/*  50 */     s = s + "AFFICHER_LOUPE = " + getBoolean(frm.getjCBMenuLoupe().isSelected()) + ";\n";
/*  51 */     s = s + "AFFICHER_LIBRAIRIE = " + getBoolean(frm.getjMILibrairie().isSelected()) + ";\n";
/*  52 */     s = s + "AFFICHER_GRILLE = " + getBoolean(frm.getBar().getBtRegle().isSelected()) + ";\n";
/*  53 */     s = s + "ZOOM = " + frm.getFormeMCD().getPage().getConfigurationMCD().zoom + ";\n";
/*  54 */     s = s + "COULEURPAGE = " + ConfigurationMCD2.getColor(frm.getPage().clPage) + ";\n";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  59 */     int i = 0;int nb = frm.getListeMenu().size();
/*  60 */     String p = i < nb ? ((MyMenuItem)frm.getListeMenu().get(i)).getChemin() : " ";i++;
/*  61 */     s = s + "FICHIER_1 = " + p + ";\n";
/*  62 */     p = i < nb ? ((MyMenuItem)frm.getListeMenu().get(i)).getChemin() : " ";i++;
/*  63 */     s = s + "FICHIER_2 = " + p + ";\n";
/*  64 */     p = i < nb ? ((MyMenuItem)frm.getListeMenu().get(i)).getChemin() : " ";i++;
/*  65 */     s = s + "FICHIER_3 = " + p + ";\n";
/*  66 */     p = i < nb ? ((MyMenuItem)frm.getListeMenu().get(i)).getChemin() : " ";i++;
/*  67 */     s = s + "FICHIER_4 = " + p + ";\n";
/*  68 */     p = i < nb ? ((MyMenuItem)frm.getListeMenu().get(i)).getChemin() : " ";i++;
/*  69 */     s = s + "FICHIER_5 = " + p + ";\n";
/*  70 */     s = s + "</MRDESK>\n";
/*  71 */     return s;
/*     */   }
/*     */   
/*     */   public static String settingToString(Principale frm) {
/*  75 */     String s = "";
/*  76 */     s = bureauToString(frm);
/*  77 */     s = s + "<MRPARAMETER>\n";
/*  78 */     s = s + "AFFICHER_PETITCAREEAU = " + getBoolean(Setting.petitCarreau) + ";\n";
/*  79 */     s = s + "ATTRIBUT_UNIQUE = " + getBoolean(Setting.attUniq) + ";\n";
/*  80 */     s = s + "REDONDANCE_NOM_ASSOCIATION = " + getBoolean(Setting.redondNomAss) + ";\n";
/*  81 */     s = s + "VIDE_NOM_ASSOCIATION = " + getBoolean(Setting.videNomAss) + ";\n";
/*  82 */     s = s + "INFORMER_PROPRIETE_MCD = " + getBoolean(Setting.informProprieteMCD) + ";\n";
/*  83 */     s = s + "HERITAGE_MULTIPLE = " + getBoolean(Setting.heritageMult) + ";\n";
/*  84 */     s = s + "HISTORIQUE_SAUVEGARDE = " + getBoolean(Setting.historiqueSave) + ";\n";
/*  85 */     s = s + "ATTRIBUT_MAJUSCULE = " + getBoolean(Setting.attMajuscule) + ";\n";
/*  86 */     s = s + "CARDINALITE_2_POINTS = " + getBoolean(Setting.cardinalite2points) + ";\n";
/*  87 */     s = s + "CARDINALITE_MAJUSCULE = " + getBoolean(Setting.cardinaliteMajuscule) + ";\n";
/*  88 */     s = s + "DESACTIVER_HERITAGE = " + getBoolean(Setting.desactiverHeritage) + ";\n";
/*  89 */     s = s + "PRK_VISIBLE = " + getBoolean(Setting.prkvisible) + ";\n";
/*     */     
/*  91 */     s = s + "VERIFIER_TYPE_ATT_RETRO = " + getBoolean(Setting.verifTypeAtt) + ";\n";
/*  92 */     s = s + "CONVERTIR_TYPE_ATT_RETRO = " + getBoolean(Setting.convertTypeAtt) + ";\n";
/*     */     
/*     */ 
/*  95 */     s = s + "SQL_DEFAUT = " + Setting.SQLDefaut + ";\n";
/*  96 */     s = s + "INCLURE_COMMENTAIRE_TABLE_SQL = " + getBoolean(Setting.inclureCommentTableSQL) + ";\n";
/*  97 */     s = s + "INCLURE_COMMENTAIRE_ATTRIBUT_SQL = " + getBoolean(Setting.inclureCommentAttSQL) + ";\n";
/*     */     
/*  99 */     s = s + "DEVELOPPEUR = " + Setting.developpeur + ";\n";
/* 100 */     s = s + "DATE_DERNIERE_USE = " + Setting.getDateJour() + ";\n";
/*     */     
/*     */ 
/* 103 */     s = s + "PROXY = " + getBoolean(Setting.proxy) + ";\n";
/* 104 */     s = s + "PROXY_HTTP = " + Setting.proxyHTTP + ";\n";
/* 105 */     s = s + "PROXY_PORT = " + Setting.proxyPort + ";\n";
/* 106 */     s = s + "PROXY_LOGIN = " + Setting.proxyLogin + ";\n";
/* 107 */     s = s + "PROXY_PW = " + Setting.proxyPassW + ";\n";
/*     */     
/*     */ 
/* 110 */     s = s + "CLE_MERE_HERITAGE = " + getBoolean(Setting.cleMere) + ";\n";
/* 111 */     s = s + "CLE_MERE_SI_NECESSAIRE_HERITAGE = " + getBoolean(Setting.cleSiNecessaireMere) + ";\n";
/* 112 */     s = s + "ATTRIBUT_MERE_HERITAGE = " + getBoolean(Setting.attMere) + ";\n";
/*     */     
/* 114 */     s = s + "SURCHARGER_ATTRIBUT_MERE_HERITAGE = " + getBoolean(Setting.surchargeAttMere) + ";\n";
/* 115 */     s = s + "SURCHARGER_NOM_HERITAGE = " + getBoolean(Setting.surchargeNom) + ";\n";
/* 116 */     s = s + "ME_LAISSER_LECHOIX_HERITAGE = " + getBoolean(Setting.meLaisserChoix) + ";\n";
/*     */     
/*     */ 
/* 119 */     s = s + "IMPRIMER_ORIENTATION = " + Setting.imprimerOrientation + ";\n";
/* 120 */     s = s + "IMPRIMER_MARGE_G = " + Setting.imprimerMargeG + ";\n";
/* 121 */     s = s + "IMPRIMER_MARGE_D = " + Setting.imprimerMargeD + ";\n";
/* 122 */     s = s + "IMPRIMER_MARGE_H = " + Setting.imprimerMargeH + ";\n";
/* 123 */     s = s + "IMPRIMER_MARGE_B = " + Setting.imprimerMargeB + ";\n";
/* 124 */     s = s + "IMPRIMER_NOM_MCD = " + getBoolean(Setting.imprimerNomMcd) + ";\n";
/* 125 */     s = s + "IMPRIMER_NOM_DEV = " + getBoolean(Setting.imprimerNomDev) + ";\n";
/* 126 */     s = s + "IMPRIMER_NUM_PAGE = " + getBoolean(Setting.imprimerNumPage) + ";\n";
/* 127 */     s = s + "AFFICHER_DONATION = " + Setting.afficherDonation + ";\n";
/*     */     
/*     */ 
/* 130 */     s = s + "AUGMENTATION = " + getBoolean(Setting.augmentation) + ";\n";
/* 131 */     s = s + "AUGMENTATIONNBCARACTERE = " + Setting.augmentationNBCaractere + ";\n";
/* 132 */     s = s + "AUGMENTATIONNOMCOMPLET = " + getBoolean(Setting.augmentationNomComplet) + ";\n";
/*     */     
/* 134 */     s = s + "SELECTATTRIBUT = " + getBoolean(Setting.selectAttribut) + ";\n";
/* 135 */     s = s + "ZOOMTOUTPAGE = " + getBoolean(Setting.zoomToutPage) + ";\n";
/* 136 */     s = s + "ACTIVERLIEN = " + getBoolean(Setting.activerLien2) + ";\n";
/* 137 */     s = s + "ISATTRIBUTPARDEFAUTPOURENTITE = " + getBoolean(Setting.isAttributCleParDefautPourEntite) + ";\n";
/* 138 */     s = s + "ATTRIBUTDEFAUTNOM = " + Setting.attributCle.getNom() + ";\n";
/* 139 */     s = s + "ATTRIBUTDEFAUTCODE = " + Setting.attributCle.getCode() + ";\n";
/* 140 */     s = s + "ATTRIBUTDEFAUTTYPE = " + Setting.attributCle.getType() + ";\n";
/* 141 */     s = s + "ATTRIBUTDEFAUTLONG = " + Setting.attributCle.getLongueur() + ";\n";
/* 142 */     s = s + "ATTRIBUTDEFAUTLONGDEC = " + Setting.attributCle.getLongDecimale() + ";\n";
/*     */     
/* 144 */     s = s + "COULEURLIBRAIRIESEL = " + Setting.couleurLibrairieSel + ";\n";
/* 145 */     s = s + "DRAGANDDROPAFFICHERATTRIBUT = " + getBoolean(Setting.dragNdropAfficherAttribut) + ";\n";
/* 146 */     s = s + "AFFICHEROPTIONSELECTIONLIB = " + getBoolean(Setting.afficherOptionSelectionLib) + ";\n";
/*     */     
/* 148 */     s = s + "SQLUTILISERCODE = " + getBoolean(Setting.SQLUtiliserCode) + ";\n";
/* 149 */     s = s + "SQLVERIFIERMOTRESERVER2 = " + getBoolean(Setting.SQLVerifierMotReserver2) + ";\n";
/* 150 */     s = s + "SQLCARDINALITEMAX = " + Setting.SQLCardinaliteMax + ";\n";
/* 151 */     s = s + "AGGRAVERSELECTION2 = " + getBoolean(Setting.agraverSelection2) + ";\n";
/*     */     
/* 153 */     s = s + "MLDSTRUCTUREATT2 = " + getBoolean(Setting.MLDStructurerAtt2) + ";\n";
/* 154 */     s = s + "MLDAFFICHERNOMLIEN2 = " + getBoolean(Setting.MLDAfficherNomLien2) + ";\n";
/*     */     
/* 156 */     s = s + "OUVRIRCREERUNECOPIE = " + getBoolean(Setting.ouvrirCreerUneCopie2) + ";\n";
/* 157 */     s = s + "SQLAUGMENTERNOMTABLEPARDEVELOPPEUR2 = " + getBoolean(Setting.SQLAugmenterNomTableParDeveloppeur2) + ";\n";
/* 158 */     s = s + "HERITAGEMEMESPECIALISATION2 = " + getBoolean(Setting.heritageMemeSpecialisation2) + ";\n";
/*     */     
/* 160 */     s = s + "SQLPREFIXERLENOMCONTRAINTE2 = " + getBoolean(Setting.SQLPrefixerLeNomContrainte2) + ";\n";
/* 161 */     s = s + "CLSELECTED2 = " + ConfigurationMCD2.getColor(Setting.clSelected2) + ";\n";
/* 162 */     s = s + "VERSION = " + Parametres.version + ";\n";
/* 163 */     s = s + "AFFICHERFANDL2 = " + Setting.afficherFAndL2 + ";\n";
/* 164 */     s = s + "</MRPARAMETER>\n";
/*     */     
/*     */ 
/* 167 */     s = s + "<MRPAGEMCD>\n";
/* 168 */     s = s + "CLENTITECADRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clEntiteCadre2) + ";\n";
/* 169 */     s = s + "CLENTITEFOND2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clEntiteFond2) + ";\n";
/* 170 */     s = s + "CLENTITETEXT2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clEntiteText2) + ";\n";
/* 171 */     s = s + "CLENTITETEXTTYPE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clEntiteTextType2) + ";\n";
/* 172 */     s = s + "CLENTITETEXTTAILLE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clEntiteTextTaille2) + ";\n";
/* 173 */     s = s + "CLENTITETEXTTAILLEDEC2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clEntiteTextTailleDec2) + ";\n";
/* 174 */     s = s + "CLENTITETEXTCODE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clEntiteTextCode2) + ";\n";
/* 175 */     s = s + "CLENTITEFONDTITRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clEntiteFondTitre2) + ";\n";
/* 176 */     s = s + "CLENTITETEXTTITRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clEntiteTextTitre2) + ";\n";
/* 177 */     s = s + "CLLIENACTIVER2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienActiver2) + ";\n";
/* 178 */     s = s + "CLPRK2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clPrk2) + ";\n";
/*     */     
/* 180 */     s = s + "CLRELATIONCADRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clRelationCadre2) + ";\n";
/* 181 */     s = s + "CLRELATIONFOND2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clRelationFond2) + ";\n";
/* 182 */     s = s + "CLRELATIONTEXT2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clRelationText2) + ";\n";
/* 183 */     s = s + "CLRELATIONTEXTTYPE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clRelationTextType2) + ";\n";
/* 184 */     s = s + "CLRELATIONTEXTTAILLE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clRelationTextTaille2) + ";\n";
/* 185 */     s = s + "CLRELATIONTEXTTAILLEDEC2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clRelationTextTailleDec2) + ";\n";
/* 186 */     s = s + "CLRELATIONTEXTCODE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clRelationTextCode2) + ";\n";
/* 187 */     s = s + "CLRELATIONFODTITRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clRelationFondTitre2) + ";\n";
/* 188 */     s = s + "CLRELATIONTEXTTITRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clRelationTextTitre2) + ";\n";
/* 189 */     s = s + "CLLIENACTIVERRELATION2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienActiverRelation2) + ";\n";
/*     */     
/* 191 */     s = s + "CLLIEN2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLien2) + ";\n";
/* 192 */     s = s + "CLLIENTEXT2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienText2) + ";\n";
/* 193 */     s = s + "CLLIENNOM2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienNom2) + ";\n";
/* 194 */     s = s + "CLLIENNOMCARDINALITE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienNomCardinalite2) + ";\n";
/* 195 */     s = s + "CLLIENFONDCARDINALITE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienFondCardinalite2) + ";\n";
/*     */     
/* 197 */     s = s + "CLCIFCADRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clCIFCadre2) + ";\n";
/* 198 */     s = s + "CLCIFFOND2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clCIFFond2) + ";\n";
/* 199 */     s = s + "CLCIFTEXT2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clCIFText2) + ";\n";
/* 200 */     s = s + "CLLIENACTIVERCIF2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienActiverCIF2) + ";\n";
/*     */     
/* 202 */     s = s + "CLLIENCIF2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienCIF2) + ";\n";
/* 203 */     s = s + "CLLIENTEXTCIF2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienTextCIF2) + ";\n";
/* 204 */     s = s + "CLLIENNOMCIF2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienNomCIF2) + ";\n";
/*     */     
/* 206 */     s = s + "CLCONTRAINTECADRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clContrainteCadre2) + ";\n";
/* 207 */     s = s + "CLCONTRAINTEFOND2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clContrainteFond2) + ";\n";
/* 208 */     s = s + "CLCONTRAINTETEXT2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clContrainteText2) + ";\n";
/*     */     
/* 210 */     s = s + "CLLIENCONTRAINTE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienContrainte2) + ";\n";
/* 211 */     s = s + "CLLIENTEXTCONTRAINTE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienTextContrainte2) + ";\n";
/* 212 */     s = s + "CLLIENNOMCONTRAINTE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienNomContrainte2) + ";\n";
/* 213 */     s = s + "CLLIENACTIVERCONTRAINTE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienActiverContainte2) + ";\n";
/*     */     
/* 215 */     s = s + "CLCOMMENTAIRECADRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clCommentaireCadre2) + ";\n";
/* 216 */     s = s + "CLCOMMENTAIREFOND2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clCommentaireFond2) + ";\n";
/* 217 */     s = s + "CLCOMMENTAIRETEXT2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clCommentaireText2) + ";\n";
/*     */     
/* 219 */     s = s + "CLLIENCOMMENTAIRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienCommentaire2) + ";\n";
/*     */     
/* 221 */     s = s + "CLPOSTITCADRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clPostItCadre2) + ";\n";
/* 222 */     s = s + "CLPOSTITFOND2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clPostItFond2) + ";\n";
/* 223 */     s = s + "CLPOSTITTEXT2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clPostItText2) + ";\n";
/*     */     
/* 225 */     s = s + "CLPOSTITPUNAISE = " + ConfigurationMCD2.getColor(FormeInterneMCD.clPostItPunaise2) + ";\n";
/*     */     
/* 227 */     s = s + "CLHERITAGECADRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clHeritageCadre2) + ";\n";
/* 228 */     s = s + "CLHERITAGEFOND2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clHeritageFond2) + ";\n";
/* 229 */     s = s + "CLHERITAGETEXT2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clHeritageText2) + ";\n";
/*     */     
/* 231 */     s = s + "CLLIENACTIVERHERITAGE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienActiverHeritage2) + ";\n";
/*     */     
/* 233 */     s = s + "CLLIENHERITAGE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienHeritage2) + ";\n";
/* 234 */     s = s + "CLLIENNOMHERITAGE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienNomHeritage2) + ";\n";
/* 235 */     s = s + "CLLIENFONDNOMHERITAGE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clLienFondNomHeritage2) + ";\n";
/*     */     
/* 237 */     s = s + "CLPAGE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clPage2) + ";\n";
/* 238 */     s = s + "CLOMBRE2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clOmbre2) + ";\n";
/*     */     
/* 240 */     s = s + "CLSELECTED2 = " + ConfigurationMCD2.getColor(FormeInterneMCD.clSelected) + ";\n";
/*     */     
/* 242 */     s = s + "ALIGNER = " + FormeInterneMCD.aligner + ";\n";
/* 243 */     s = s + "ALIGNERPOSTIT = " + FormeInterneMCD.alignerPostIt + ";\n";
/* 244 */     s = s + "ALIGNERCOMMENTAIRE = " + FormeInterneMCD.alignerCommentaire + ";\n";
/*     */     
/* 246 */     s = s + "MCDZOM2 = " + FormeInterneMCD.zoom + ";\n";
/*     */     
/* 248 */     s = s + "MCDISOMBREE2 = " + getBoolean(FormeInterneMCD.isOmbree2) + ";\n";
/* 249 */     s = s + "MCDISDEGRADEE2 = " + getBoolean(FormeInterneMCD.isDegradee2) + ";\n";
/*     */     
/* 251 */     s = s + "MCDCARDINALITEMAJUSCULE2 = " + getBoolean(FormeInterneMCD.cardinaliteMajuscule2) + ";\n";
/* 252 */     s = s + "MCDCARDINALITEDEUXPOINTS2 = " + getBoolean(FormeInterneMCD.cardinalite2points2) + ";\n";
/*     */     
/* 254 */     s = s + "MCDCAFFICHETYPE2 = " + getBoolean(FormeInterneMCD.afficheType2) + ";\n";
/*     */     
/* 256 */     s = s + "MCDCAFFICHEPRK2 = " + getBoolean(FormeInterneMCD.afficherPrk2) + ";\n";
/* 257 */     s = s + "MCDCAFFICHEPRKIMAGE2 = " + getBoolean(FormeInterneMCD.afficherPrkImage2) + ";\n";
/*     */     
/* 259 */     s = s + "MCDTYPEMAJUSCULE2 = " + getBoolean(FormeInterneMCD.typeMajuscule2) + ";\n";
/*     */     
/* 261 */     s = s + "MCDINTERLIGNE2 = " + FormeInterneMCD.interLigne2 + ";\n";
/* 262 */     s = s + "MCDTRAITENTITERELATION2 = " + FormeInterneMCD.traitEntiteRelation2 + ";\n";
/*     */     
/* 264 */     s = s + "MCDLIENENTITERELATION2 = " + FormeInterneMCD.lienEntiteRelation2 + ";\n";
/*     */     
/* 266 */     s = s + "MCDTRAITCONTRAINTE2 = " + FormeInterneMCD.traitContraintes2 + ";\n";
/* 267 */     s = s + "MCDLIENCONTRAINTE2 = " + FormeInterneMCD.lienContraintes2 + ";\n";
/*     */     
/* 269 */     s = s + "MCDARRONDIRENTITE2 = " + getBoolean(FormeInterneMCD.arrondirEntite2) + ";\n";
/*     */     
/* 271 */     s = s + "</MRPAGEMCD>\n";
/*     */     
/* 273 */     return s;
/*     */   }
/*     */   
/*     */   public static String getValeurChamp(String ch, String settin)
/*     */   {
/* 278 */     String s = settin.substring(settin.indexOf(ch));
/* 279 */     if ((s == null) || (s.length() == 0)) return "";
/* 280 */     s = s.substring(s.indexOf("=") + 1, s.length());
/* 281 */     s = s.substring(0, s.indexOf(";"));
/* 282 */     return s.trim();
/*     */   }
/*     */   
/*     */   private static boolean getStringToBoolean(String st) {
/* 286 */     if (st.equals("TRUE")) return true;
/* 287 */     return false;
/*     */   }
/*     */   
/*     */   public static void stringToSetting(String s, Principale frm) throws Exception
/*     */   {
/* 292 */     Setting.petitCarreau = getStringToBoolean(getValeurChamp("AFFICHER_PETITCAREEAU", s));
/* 293 */     Setting.attUniq = getStringToBoolean(getValeurChamp("ATTRIBUT_UNIQUE", s));
/* 294 */     Setting.redondNomAss = getStringToBoolean(getValeurChamp("REDONDANCE_NOM_ASSOCIATION", s));
/* 295 */     Setting.videNomAss = getStringToBoolean(getValeurChamp("VIDE_NOM_ASSOCIATION", s));
/* 296 */     Setting.informProprieteMCD = getStringToBoolean(getValeurChamp("INFORMER_PROPRIETE_MCD", s));
/* 297 */     Setting.heritageMult = getStringToBoolean(getValeurChamp("HERITAGE_MULTIPLE", s));
/* 298 */     Setting.historiqueSave = getStringToBoolean(getValeurChamp("HISTORIQUE_SAUVEGARDE", s));
/* 299 */     Setting.attMajuscule = getStringToBoolean(getValeurChamp("ATTRIBUT_MAJUSCULE", s));
/* 300 */     Setting.cardinalite2points = getStringToBoolean(getValeurChamp("CARDINALITE_2_POINTS", s));
/* 301 */     Setting.cardinaliteMajuscule = getStringToBoolean(getValeurChamp("CARDINALITE_MAJUSCULE", s));
/* 302 */     Setting.desactiverHeritage = getStringToBoolean(getValeurChamp("DESACTIVER_HERITAGE", s));
/* 303 */     Setting.prkvisible = getStringToBoolean(getValeurChamp("PRK_VISIBLE", s));
/*     */     
/* 305 */     Setting.verifTypeAtt = getStringToBoolean(getValeurChamp("VERIFIER_TYPE_ATT_RETRO", s));
/* 306 */     Setting.convertTypeAtt = getStringToBoolean(getValeurChamp("CONVERTIR_TYPE_ATT_RETRO", s));
/*     */     
/*     */ 
/* 309 */     Setting.SQLDefaut = getValeurChamp("SQL_DEFAUT", s);
/* 310 */     Setting.inclureCommentTableSQL = getStringToBoolean(getValeurChamp("INCLURE_COMMENTAIRE_TABLE_SQL", s));
/* 311 */     Setting.inclureCommentAttSQL = getStringToBoolean(getValeurChamp("INCLURE_COMMENTAIRE_ATTRIBUT_SQL", s));
/*     */     
/* 313 */     Setting.developpeur = getValeurChamp("DEVELOPPEUR", s);
/* 314 */     Setting.dateDerUse = getValeurChamp("DATE_DERNIERE_USE", s);
/*     */     
/*     */ 
/* 317 */     Setting.proxy = getStringToBoolean(getValeurChamp("PROXY", s));
/* 318 */     Setting.proxyHTTP = getValeurChamp("PROXY_HTTP", s);
/* 319 */     Setting.proxyPort = getValeurChamp("PROXY_PORT", s);
/* 320 */     Setting.proxyLogin = getValeurChamp("PROXY_LOGIN", s);
/* 321 */     Setting.proxyPassW = getValeurChamp("PROXY_PW", s);
/*     */     
/*     */ 
/* 324 */     Setting.cleMere = getStringToBoolean(getValeurChamp("CLE_MERE_HERITAGE", s));
/* 325 */     Setting.cleSiNecessaireMere = getStringToBoolean(getValeurChamp("CLE_MERE_SI_NECESSAIRE_HERITAGE", s));
/* 326 */     Setting.attMere = getStringToBoolean(getValeurChamp("ATTRIBUT_MERE_HERITAGE", s));
/*     */     
/* 328 */     Setting.surchargeAttMere = getStringToBoolean(getValeurChamp("SURCHARGER_ATTRIBUT_MERE_HERITAGE", s));
/* 329 */     Setting.surchargeNom = getStringToBoolean(getValeurChamp("SURCHARGER_NOM_HERITAGE", s));
/* 330 */     Setting.meLaisserChoix = getStringToBoolean(getValeurChamp("ME_LAISSER_LECHOIX_HERITAGE", s));
/*     */     
/*     */ 
/* 333 */     Setting.imprimerOrientation = getValeurChamp("IMPRIMER_ORIENTATION", s);
/* 334 */     Setting.imprimerMargeG = getValeurChamp("IMPRIMER_MARGE_G", s);
/* 335 */     Setting.imprimerMargeD = getValeurChamp("IMPRIMER_MARGE_D", s);
/* 336 */     Setting.imprimerMargeH = getValeurChamp("IMPRIMER_MARGE_H", s);
/* 337 */     Setting.imprimerMargeB = getValeurChamp("IMPRIMER_MARGE_B", s);
/* 338 */     Setting.imprimerNomMcd = getStringToBoolean(getValeurChamp("IMPRIMER_NOM_MCD", s));
/* 339 */     Setting.imprimerNomDev = getStringToBoolean(getValeurChamp("IMPRIMER_NOM_DEV", s));
/* 340 */     Setting.imprimerNumPage = getStringToBoolean(getValeurChamp("IMPRIMER_NUM_PAGE", s));
/* 341 */     Setting.afficherDonation = Integer.parseInt(getValeurChamp("AFFICHER_DONATION", s));
/*     */     
/*     */ 
/* 344 */     Setting.augmentation = getStringToBoolean(getValeurChamp("AUGMENTATION", s));
/* 345 */     Setting.augmentationNBCaractere = Integer.parseInt(getValeurChamp("AUGMENTATIONNBCARACTERE", s));
/* 346 */     Setting.augmentationNomComplet = getStringToBoolean(getValeurChamp("AUGMENTATIONNOMCOMPLET", s));
/*     */     
/* 348 */     Setting.selectAttribut = getStringToBoolean(getValeurChamp("SELECTATTRIBUT", s));
/* 349 */     Setting.zoomToutPage = getStringToBoolean(getValeurChamp("ZOOMTOUTPAGE", s));
/* 350 */     Setting.activerLien2 = getStringToBoolean(getValeurChamp("ACTIVERLIEN", s));
/* 351 */     Setting.isAttributCleParDefautPourEntite = getStringToBoolean(getValeurChamp("ISATTRIBUTPARDEFAUTPOURENTITE", s));
/*     */     
/* 353 */     Setting.attributCle = new Attribut2("", "", 1, 1, Parametres.Cle, false, "", null);
/* 354 */     Setting.attributCle.setNom(getValeurChamp("ATTRIBUTDEFAUTNOM", s));
/* 355 */     Setting.attributCle.setCode(getValeurChamp("ATTRIBUTDEFAUTCODE", s));
/* 356 */     Setting.attributCle.setType(getValeurChamp("ATTRIBUTDEFAUTTYPE", s));
/* 357 */     Setting.attributCle.setLongueur(Integer.parseInt(getValeurChamp("ATTRIBUTDEFAUTLONG", s)));
/* 358 */     Setting.attributCle.setLongDecimale(Integer.parseInt(getValeurChamp("ATTRIBUTDEFAUTLONGDEC", s)));
/*     */     
/*     */ 
/* 361 */     Setting.couleurLibrairieSel = getValeurChamp("COULEURLIBRAIRIESEL", s);
/* 362 */     Setting.dragNdropAfficherAttribut = getStringToBoolean(getValeurChamp("DRAGANDDROPAFFICHERATTRIBUT", s));
/* 363 */     Setting.afficherOptionSelectionLib = getStringToBoolean(getValeurChamp("AFFICHEROPTIONSELECTIONLIB", s));
/*     */     
/* 365 */     Setting.SQLUtiliserCode = getStringToBoolean(getValeurChamp("SQLUTILISERCODE", s));
/*     */     
/* 367 */     Setting.SQLVerifierMotReserver2 = getStringToBoolean(getValeurChamp("SQLVERIFIERMOTRESERVER2", s));
/*     */     
/* 369 */     Setting.SQLCardinaliteMax = Integer.parseInt(getValeurChamp("SQLCARDINALITEMAX", s));
/* 370 */     Setting.agraverSelection2 = getStringToBoolean(getValeurChamp("AGGRAVERSELECTION2", s));
/*     */     
/* 372 */     Setting.MLDStructurerAtt2 = getStringToBoolean(getValeurChamp("MLDSTRUCTUREATT2", s));
/* 373 */     Setting.MLDAfficherNomLien2 = getStringToBoolean(getValeurChamp("MLDAFFICHERNOMLIEN2", s));
/*     */     
/* 375 */     Setting.ouvrirCreerUneCopie2 = getStringToBoolean(getValeurChamp("OUVRIRCREERUNECOPIE", s));
/* 376 */     Setting.SQLAugmenterNomTableParDeveloppeur2 = getStringToBoolean(getValeurChamp("SQLAUGMENTERNOMTABLEPARDEVELOPPEUR2", s));
/* 377 */     Setting.heritageMemeSpecialisation2 = getStringToBoolean(getValeurChamp("HERITAGEMEMESPECIALISATION2", s));
/*     */     
/* 379 */     Setting.SQLPrefixerLeNomContrainte2 = getStringToBoolean(getValeurChamp("SQLPREFIXERLENOMCONTRAINTE2", s));
/* 380 */     Setting.clSelected2 = ConfigurationMCD2.getColor(getValeurChamp("CLSELECTED2", s));
/* 381 */     Setting.afficherFAndL2 = getValeurChamp("AFFICHERFANDL2", s);
/*     */     
/*     */ 
/*     */ 
/* 385 */     String gard = s;
/* 386 */     s = s.substring(s.indexOf("<MRDESK>"), s.indexOf("</MRDESK>"));
/*     */     
/* 388 */     frm.getFormeMCD().setVisible(true);
/* 389 */     frm.getFormeMCD().setLocation(5, 5);
/*     */     
/* 391 */     frm.getFormeMLD().setVisible(false);
/* 392 */     frm.getFormeRetro().setVisible(false);
/* 393 */     frm.getFormeSQL().setVisible(false);
/* 394 */     frm.getFormeXML().setVisible(false);
/*     */     
/* 396 */     frm.getFormeMCD().setSize(Integer.parseInt(getValeurChamp("FENETREMCD_W", s)), Integer.parseInt(getValeurChamp("FENETREMCD_H", s)));
/*     */     
/* 398 */     boolean rep = getStringToBoolean(getValeurChamp("OMBRE", s));
/* 399 */     frm.setOmbre(rep);
/* 400 */     frm.getPage().getConfigurationMCD().isOmbree2 = rep;
/*     */     
/* 402 */     rep = getStringToBoolean(getValeurChamp("ARRONDIRANGLE", s));
/* 403 */     frm.setArrondirAngle(rep);
/* 404 */     frm.getPage().getConfigurationMCD().arrondirEntite2 = rep;
/*     */     
/* 406 */     rep = getStringToBoolean(getValeurChamp("ACTIVERLIENSELECTION", s));
/* 407 */     frm.setActiverLienSelection(rep);
/* 408 */     Setting.activerLien2 = rep;
/* 409 */     frm.getjMIActiverLien().setSelected(rep);
/*     */     
/*     */ 
/* 412 */     rep = getStringToBoolean(getValeurChamp("AFFICHER_TYPE", s));
/* 413 */     frm.setVariable(rep);
/*     */     
/* 415 */     rep = getStringToBoolean(getValeurChamp("COULEURDEGRADEE", s));
/* 416 */     frm.setClDegradee(rep);
/*     */     
/* 418 */     rep = getStringToBoolean(getValeurChamp("AFFICHER_CONSOLE", s));
/* 419 */     if (!rep) {
/* 420 */       frm.getjMIConsole().setSelected(false);
/* 421 */       frm.getConsole().setVisible(rep);
/*     */     }
/*     */     
/* 424 */     rep = getStringToBoolean(getValeurChamp("AFFICHER_EXPLORER", s));
/* 425 */     if (!rep) {
/* 426 */       frm.getjMIExplorer().setSelected(false);
/* 427 */       frm.getExplorer().setVisible(rep);
/*     */     }
/*     */     
/* 430 */     rep = getStringToBoolean(getValeurChamp("AFFICHER_LOUPE", s));
/* 431 */     if (!rep) {
/* 432 */       frm.getjCBMenuLoupe().setSelected(false);
/* 433 */       frm.getPanelLoupe().setVisible(rep);
/*     */     }
/*     */     
/* 436 */     rep = getStringToBoolean(getValeurChamp("AFFICHER_LIBRAIRIE", s));
/* 437 */     if (!rep) {
/* 438 */       frm.getjMILibrairie().setSelected(false);
/* 439 */       frm.getPanLibibrary().setVisible(rep);
/*     */     }
/* 441 */     rep = getStringToBoolean(getValeurChamp("AFFICHER_LIBRAIRIE", s));
/* 442 */     frm.getBar().getBtRegle().setSelected(rep);
/*     */     
/* 444 */     double z = Double.parseDouble(getValeurChamp("ZOOM", s));
/* 445 */     frm.getBar().setZoomPage(z);
/*     */     
/* 447 */     frm.getPage().setZoom(z);
/* 448 */     frm.getPage().getConfigurationMCD().zoom = z;
/*     */     
/* 450 */     rep = getStringToBoolean(getValeurChamp("AFFICHER_GRILLE", s));
/* 451 */     frm.getBar().getBtRegle().setSelected(rep);
/* 452 */     frm.getBar().setAfficheRegle(rep);
/*     */     
/*     */ 
/* 455 */     frm.getPage().setClPage(ConfigurationMCD2.getColor(getValeurChamp("COULEURPAGE", s)));
/* 456 */     frm.getPage().getConfigurationMCD().clPage2 = ConfigurationMCD2.getColor(frm.getPage().clPage);
/*     */     
/*     */ 
/* 459 */     String ch = getValeurChamp("FICHIER_5", s);
/* 460 */     if ((ch.trim().length() > 0) && 
/* 461 */       (Parametres.existeFichier(ch))) {
/* 462 */       frm.ajouterUnnouveauFichier(ch);
/* 463 */       frm.setCheminFichier(ch);
/* 464 */       frm.setCheminDernierMCD(ch);
/*     */     }
/*     */     
/*     */ 
/* 468 */     ch = getValeurChamp("FICHIER_4", s);
/* 469 */     if ((ch.trim().length() > 0) && 
/* 470 */       (Parametres.existeFichier(ch))) {
/* 471 */       frm.ajouterUnnouveauFichier(ch);
/* 472 */       frm.setCheminFichier(ch);
/* 473 */       frm.setCheminDernierMCD(ch);
/*     */     }
/*     */     
/* 476 */     ch = getValeurChamp("FICHIER_3", s);
/* 477 */     if ((ch.trim().length() > 0) && 
/* 478 */       (Parametres.existeFichier(ch))) {
/* 479 */       frm.ajouterUnnouveauFichier(ch);
/* 480 */       frm.setCheminFichier(ch);
/* 481 */       frm.setCheminDernierMCD(ch);
/*     */     }
/*     */     
/* 484 */     ch = getValeurChamp("FICHIER_2", s);
/* 485 */     if ((ch.trim().length() > 0) && 
/* 486 */       (Parametres.existeFichier(ch))) {
/* 487 */       frm.ajouterUnnouveauFichier(ch);
/* 488 */       frm.setCheminFichier(ch);
/* 489 */       frm.setCheminDernierMCD(ch);
/*     */     }
/*     */     
/* 492 */     ch = getValeurChamp("FICHIER_1", s);
/* 493 */     if ((ch.trim().length() > 0) && 
/* 494 */       (Parametres.existeFichier(ch))) {
/* 495 */       frm.ajouterUnnouveauFichier(ch);
/* 496 */       frm.setCheminFichier(ch);
/* 497 */       frm.setCheminDernierMCD(ch);
/*     */     }
/*     */     
/*     */ 
/* 501 */     s = gard;
/* 502 */     s = s.substring(s.indexOf("<MRPAGEMCD>"), s.indexOf("</MRPAGEMCD>"));
/*     */     
/*     */ 
/* 505 */     FormeInterneMCD.clEntiteCadre2 = ConfigurationMCD2.getColor(getValeurChamp("CLENTITECADRE2", s));
/*     */     
/* 507 */     FormeInterneMCD.clEntiteFond2 = ConfigurationMCD2.getColor(getValeurChamp("CLENTITEFOND2", s));
/* 508 */     FormeInterneMCD.clEntiteText2 = ConfigurationMCD2.getColor(getValeurChamp("CLENTITETEXT2", s));
/* 509 */     FormeInterneMCD.clEntiteTextType2 = ConfigurationMCD2.getColor(getValeurChamp("CLENTITETEXTTYPE2", s));
/* 510 */     FormeInterneMCD.clEntiteTextTaille2 = ConfigurationMCD2.getColor(getValeurChamp("CLENTITETEXTTAILLE2", s));
/* 511 */     FormeInterneMCD.clEntiteTextTailleDec2 = ConfigurationMCD2.getColor(getValeurChamp("CLENTITETEXTTAILLEDEC2", s));
/* 512 */     FormeInterneMCD.clEntiteTextCode2 = ConfigurationMCD2.getColor(getValeurChamp("CLENTITETEXTCODE2", s));
/* 513 */     FormeInterneMCD.clEntiteFondTitre2 = ConfigurationMCD2.getColor(getValeurChamp("CLENTITEFONDTITRE2", s));
/* 514 */     FormeInterneMCD.clEntiteTextTitre2 = ConfigurationMCD2.getColor(getValeurChamp("CLENTITETEXTTITRE2", s));
/* 515 */     FormeInterneMCD.clLienActiver2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENACTIVER2", s));
/* 516 */     FormeInterneMCD.clPrk2 = ConfigurationMCD2.getColor(getValeurChamp("CLPRK2", s));
/*     */     
/* 518 */     FormeInterneMCD.clRelationCadre2 = ConfigurationMCD2.getColor(getValeurChamp("CLRELATIONCADRE2", s));
/* 519 */     FormeInterneMCD.clRelationFond2 = ConfigurationMCD2.getColor(getValeurChamp("CLRELATIONFOND2", s));
/* 520 */     FormeInterneMCD.clRelationText2 = ConfigurationMCD2.getColor(getValeurChamp("CLRELATIONTEXT2", s));
/* 521 */     FormeInterneMCD.clRelationTextType2 = ConfigurationMCD2.getColor(getValeurChamp("CLRELATIONTEXTTYPE2", s));
/* 522 */     FormeInterneMCD.clRelationTextTaille2 = ConfigurationMCD2.getColor(getValeurChamp("CLRELATIONTEXTTAILLE2", s));
/* 523 */     FormeInterneMCD.clRelationTextTailleDec2 = ConfigurationMCD2.getColor(getValeurChamp("CLRELATIONTEXTTAILLEDEC2", s));
/* 524 */     FormeInterneMCD.clRelationTextCode2 = ConfigurationMCD2.getColor(getValeurChamp("CLRELATIONTEXTCODE2", s));
/* 525 */     FormeInterneMCD.clRelationFondTitre2 = ConfigurationMCD2.getColor(getValeurChamp("CLRELATIONFODTITRE2", s));
/* 526 */     FormeInterneMCD.clRelationTextTitre2 = ConfigurationMCD2.getColor(getValeurChamp("CLRELATIONTEXTTITRE2", s));
/* 527 */     FormeInterneMCD.clLienActiverRelation2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENACTIVERRELATION2", s));
/*     */     
/* 529 */     FormeInterneMCD.clLien2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIEN2", s));
/* 530 */     FormeInterneMCD.clLienText2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENTEXT2", s));
/* 531 */     FormeInterneMCD.clLienNom2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENNOM2", s));
/* 532 */     FormeInterneMCD.clLienNomCardinalite2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENNOMCARDINALITE2", s));
/* 533 */     FormeInterneMCD.clLienFondCardinalite2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENFONDCARDINALITE2", s));
/*     */     
/* 535 */     FormeInterneMCD.clCIFCadre2 = ConfigurationMCD2.getColor(getValeurChamp("CLCIFCADRE2", s));
/* 536 */     FormeInterneMCD.clCIFFond2 = ConfigurationMCD2.getColor(getValeurChamp("CLCIFFOND2", s));
/* 537 */     FormeInterneMCD.clCIFText2 = ConfigurationMCD2.getColor(getValeurChamp("CLCIFTEXT2", s));
/* 538 */     FormeInterneMCD.clLienActiverCIF2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENACTIVERCIF2", s));
/*     */     
/* 540 */     FormeInterneMCD.clLienCIF2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENCIF2", s));
/* 541 */     FormeInterneMCD.clLienTextCIF2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENTEXTCIF2", s));
/* 542 */     FormeInterneMCD.clLienNomCIF2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENNOMCIF2", s));
/*     */     
/* 544 */     FormeInterneMCD.clContrainteCadre2 = ConfigurationMCD2.getColor(getValeurChamp("CLCONTRAINTECADRE2", s));
/* 545 */     FormeInterneMCD.clContrainteFond2 = ConfigurationMCD2.getColor(getValeurChamp("CLCONTRAINTEFOND2", s));
/* 546 */     FormeInterneMCD.clContrainteText2 = ConfigurationMCD2.getColor(getValeurChamp("CLCONTRAINTETEXT2", s));
/*     */     
/* 548 */     FormeInterneMCD.clLienContrainte2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENCONTRAINTE2", s));
/* 549 */     FormeInterneMCD.clLienTextContrainte2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENTEXTCONTRAINTE2", s));
/* 550 */     FormeInterneMCD.clLienNomContrainte2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENNOMCONTRAINTE2", s));
/* 551 */     FormeInterneMCD.clLienActiverContainte2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENACTIVERCONTRAINTE2", s));
/*     */     
/* 553 */     FormeInterneMCD.clCommentaireCadre2 = ConfigurationMCD2.getColor(getValeurChamp("CLCOMMENTAIRECADRE2", s));
/* 554 */     FormeInterneMCD.clCommentaireFond2 = ConfigurationMCD2.getColor(getValeurChamp("CLCOMMENTAIREFOND2", s));
/* 555 */     FormeInterneMCD.clCommentaireText2 = ConfigurationMCD2.getColor(getValeurChamp("CLCOMMENTAIRETEXT2", s));
/*     */     
/* 557 */     FormeInterneMCD.clLienCommentaire2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENCOMMENTAIRE2", s));
/*     */     
/* 559 */     FormeInterneMCD.clPostItCadre2 = ConfigurationMCD2.getColor(getValeurChamp("CLPOSTITCADRE2", s));
/* 560 */     FormeInterneMCD.clPostItFond2 = ConfigurationMCD2.getColor(getValeurChamp("CLPOSTITFOND2", s));
/* 561 */     FormeInterneMCD.clPostItText2 = ConfigurationMCD2.getColor(getValeurChamp("CLPOSTITTEXT2", s));
/*     */     
/* 563 */     FormeInterneMCD.clPostItPunaise2 = ConfigurationMCD2.getColor(getValeurChamp("CLPOSTITPUNAISE", s));
/*     */     
/* 565 */     FormeInterneMCD.clHeritageCadre2 = ConfigurationMCD2.getColor(getValeurChamp("CLHERITAGECADRE2", s));
/* 566 */     FormeInterneMCD.clHeritageFond2 = ConfigurationMCD2.getColor(getValeurChamp("CLHERITAGEFOND2", s));
/* 567 */     FormeInterneMCD.clHeritageText2 = ConfigurationMCD2.getColor(getValeurChamp("CLHERITAGETEXT2", s));
/*     */     
/* 569 */     FormeInterneMCD.clLienActiverHeritage2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENACTIVERHERITAGE2", s));
/*     */     
/* 571 */     FormeInterneMCD.clLienHeritage2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENHERITAGE2", s));
/* 572 */     FormeInterneMCD.clLienNomHeritage2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENNOMHERITAGE2", s));
/* 573 */     FormeInterneMCD.clLienFondNomHeritage2 = ConfigurationMCD2.getColor(getValeurChamp("CLLIENFONDNOMHERITAGE2", s));
/*     */     
/* 575 */     FormeInterneMCD.clPage2 = ConfigurationMCD2.getColor(getValeurChamp("CLPAGE2", s));
/* 576 */     FormeInterneMCD.clOmbre2 = ConfigurationMCD2.getColor(getValeurChamp("CLOMBRE2", s));
/*     */     
/* 578 */     FormeInterneMCD.clSelected = ConfigurationMCD2.getColor(getValeurChamp("CLSELECTED2", s));
/*     */     
/* 580 */     FormeInterneMCD.aligner = getValeurChamp("ALIGNER", s);
/* 581 */     FormeInterneMCD.alignerPostIt = getValeurChamp("ALIGNERPOSTIT", s);
/* 582 */     FormeInterneMCD.alignerCommentaire = getValeurChamp("ALIGNERCOMMENTAIRE", s);
/*     */     
/* 584 */     FormeInterneMCD.zoom = Double.parseDouble(getValeurChamp("MCDZOM2", s));
/*     */     
/* 586 */     FormeInterneMCD.isOmbree2 = getStringToBoolean(getValeurChamp("MCDISOMBREE2", s));
/* 587 */     FormeInterneMCD.isDegradee2 = getStringToBoolean(getValeurChamp("MCDISDEGRADEE2", s));
/*     */     
/* 589 */     FormeInterneMCD.cardinaliteMajuscule2 = getStringToBoolean(getValeurChamp("MCDCARDINALITEMAJUSCULE2", s));
/* 590 */     FormeInterneMCD.cardinalite2points2 = getStringToBoolean(getValeurChamp("MCDCARDINALITEDEUXPOINTS2", s));
/*     */     
/* 592 */     FormeInterneMCD.afficheType2 = getStringToBoolean(getValeurChamp("MCDCAFFICHETYPE2", s));
/*     */     
/* 594 */     FormeInterneMCD.afficherPrk2 = getStringToBoolean(getValeurChamp("MCDCAFFICHEPRK2", s));
/* 595 */     FormeInterneMCD.afficherPrkImage2 = getStringToBoolean(getValeurChamp("MCDCAFFICHEPRKIMAGE2", s));
/*     */     
/* 597 */     FormeInterneMCD.typeMajuscule2 = getStringToBoolean(getValeurChamp("MCDTYPEMAJUSCULE2", s));
/*     */     
/* 599 */     FormeInterneMCD.interLigne2 = Float.parseFloat(getValeurChamp("MCDINTERLIGNE2", s));
/* 600 */     FormeInterneMCD.traitEntiteRelation2 = Float.parseFloat(getValeurChamp("MCDTRAITENTITERELATION2", s));
/*     */     
/* 602 */     FormeInterneMCD.lienEntiteRelation2 = Float.parseFloat(getValeurChamp("MCDLIENENTITERELATION2", s));
/*     */     
/* 604 */     FormeInterneMCD.traitContraintes2 = Float.parseFloat(getValeurChamp("MCDTRAITCONTRAINTE2", s));
/* 605 */     FormeInterneMCD.lienContraintes2 = Float.parseFloat(getValeurChamp("MCDLIENCONTRAINTE2", s));
/*     */     
/* 607 */     FormeInterneMCD.arrondirEntite2 = getStringToBoolean(getValeurChamp("MCDARRONDIRENTITE2", s));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean saveParametreDESK(Principale frm, String nameFile)
/*     */   {
/* 616 */     String txt = settingToString(frm);
/*     */     try {
/* 618 */       PrintWriter out = new PrintWriter(nameFile);
/* 619 */       out.write(txt);
/* 620 */       out.close();
/* 621 */       return true;
/*     */     } catch (FileNotFoundException ex) {
/* 623 */       Logger.getLogger(DeskParamatres.class.getName()).log(Level.SEVERE, null, ex); }
/* 624 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public static String openParametreDESK(Principale frm, String nameFile)
/*     */   {
/* 630 */     String txt = "";
/*     */     try
/*     */     {
/* 633 */       BufferedReader fichier = new BufferedReader(new java.io.FileReader(nameFile));
/* 634 */       String ligne; while ((ligne = fichier.readLine()) != null) {
/* 635 */         txt = txt + ligne;
/*     */       }
/* 637 */       fichier.close();
/* 638 */       return txt;
/*     */     } catch (Exception e) {
/* 640 */       e.printStackTrace(); }
/* 641 */     return txt;
/*     */   }
/*     */   
/*     */   public static boolean personnaliserParametreDESK(Principale frm, String nameFile)
/*     */   {
/* 646 */     String txt = openParametreDESK(frm, nameFile);
/* 647 */     if (txt.length() < 10) return false;
/*     */     try {
/* 649 */       stringToSetting(txt, frm);
/* 650 */       frm.getPage().setConfigurationMCD(frm.getFormeMCD().miseAjourParametreMCD(frm.getPage().getConfigurationMCD()));
/* 651 */       frm.getFormeMCD().initialiserParametreMCD(frm.getPage().getConfigurationMCD());
/* 652 */       return true;
/*     */     } catch (Exception ex) {
/* 654 */       Logger.getLogger(DeskParamatres.class.getName()).log(Level.SEVERE, null, ex); }
/* 655 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Outil\DeskParamatres.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */