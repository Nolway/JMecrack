/*     */ package Outil;
/*     */ 
/*     */ import IhmMCD.BarOutil;
/*     */ import Menu.MyMenuItem;
/*     */ import MyExplorer.ConsolePane;
/*     */ import MyExplorer.ExplorerPan;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.FormeInterneMLD;
/*     */ import ihm.FormeInterneSQL;
/*     */ import ihm.Principale;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JCheckBoxMenuItem;
/*     */ import javax.swing.JToggleButton;
/*     */ 
/*     */ public class BureauParametre
/*     */ {
/*     */   public static String valeurChamp(String ch, String settin)
/*     */   {
/*  19 */     String s = settin.substring(settin.indexOf(ch));
/*  20 */     if ((s == null) || (s.length() == 0)) return "";
/*  21 */     s = s.substring(s.indexOf(">") + 1);
/*  22 */     s = s.substring(0, s.indexOf("<"));
/*  23 */     return s.trim();
/*     */   }
/*     */   
/*     */   public static String bureauToString(Principale frm)
/*     */   {
/*  28 */     String s = "<BUREAU><FenMCD><visible>";
/*     */     
/*     */ 
/*  31 */     String p = frm.getFormeMCD().isVisible() ? "true" : "false";
/*  32 */     s = s + p + "</visible>" + "<x>";
/*  33 */     s = s + frm.getFormeMCD().getX() + "";
/*  34 */     s = s + "</x>";
/*  35 */     s = s + "<y>";
/*  36 */     s = s + frm.getFormeMCD().getY() + "";
/*  37 */     s = s + "</y>";
/*     */     
/*  39 */     s = s + "<w>";
/*  40 */     s = s + frm.getFormeMCD().getWidth() + "";
/*  41 */     s = s + "</w>";
/*     */     
/*  43 */     s = s + "<h>";
/*  44 */     s = s + frm.getFormeMCD().getHeight() + "";
/*  45 */     s = s + "</h>";
/*     */     
/*  47 */     s = s + "</FenMCD>";
/*     */     
/*  49 */     s = s + "<FenMLD>";
/*  50 */     p = frm.getFormeMLD().isVisible() ? "true" : "false";
/*  51 */     s = s + p + "</FenMLD>";
/*     */     
/*  53 */     s = s + "<FenSQL>";
/*  54 */     p = frm.getFormeSQL().isVisible() ? "true" : "false";
/*     */     
/*  56 */     s = s + p + "</FenSQL>";
/*     */     
/*  58 */     s = s + "<CouleurDef>";
/*  59 */     s = s + FormeInterneMCD.etatColor;
/*  60 */     s = s + "</CouleurDef>";
/*     */     
/*  62 */     s = s + "<Ombre>";
/*  63 */     p = frm.isOmbre() ? "true" : "false";
/*  64 */     s = s + p + "</Ombre>";
/*     */     
/*     */ 
/*  67 */     s = s + "<tailleEnt>";
/*  68 */     p = frm.isVariable() ? "true" : "false";
/*  69 */     s = s + p + "</tailleEnt>";
/*     */     
/*  71 */     s = s + "<coulourDegradee>";
/*  72 */     p = frm.isClDegradee() ? "true" : "false";
/*  73 */     s = s + p + "</coulourDegradee>";
/*     */     
/*  75 */     s = s + "<Fenconsole>";
/*  76 */     p = frm.getjMIConsole().isSelected() ? "true" : "false";
/*  77 */     s = s + p + "</Fenconsole>";
/*     */     
/*     */ 
/*  80 */     s = s + "<FenExplorer>";
/*  81 */     p = frm.getjMIExplorer().isSelected() ? "true" : "false";
/*  82 */     s = s + p + "</FenExplorer>";
/*     */     
/*  84 */     s = s + "<FenCadrage>";
/*  85 */     p = frm.getjCBMenuLoupe().isSelected() ? "true" : "false";
/*  86 */     s = s + p + "</FenCadrage>";
/*     */     
/*  88 */     s = s + "<Grille>";
/*  89 */     p = frm.getBar().isAfficheRegle() ? "true" : "false";
/*  90 */     s = s + p + "</Grille>";
/*     */     
/*  92 */     s = s + "<FichierMCD>";
/*  93 */     s = s + "<Fic1>";
/*  94 */     int i = 0;int nb = frm.getListeMenu().size();
/*  95 */     p = i < nb ? ((MyMenuItem)frm.getListeMenu().get(i)).getChemin() : " ";i++;
/*  96 */     s = s + p + "</Fic1>";
/*  97 */     s = s + "<Fic2>";
/*  98 */     p = i < nb ? ((MyMenuItem)frm.getListeMenu().get(i)).getChemin() : " ";i++;
/*  99 */     s = s + p + "</Fic2>";
/*     */     
/* 101 */     s = s + "<Fic3>";
/* 102 */     p = i < nb ? ((MyMenuItem)frm.getListeMenu().get(i)).getChemin() : " ";i++;
/* 103 */     s = s + p + "</Fic3>";
/*     */     
/* 105 */     s = s + "<Fic4>";
/* 106 */     p = i < nb ? ((MyMenuItem)frm.getListeMenu().get(i)).getChemin() : " ";i++;
/* 107 */     s = s + p + "</Fic4>";
/*     */     
/* 109 */     s = s + "<Fic5>";
/* 110 */     p = i < nb ? ((MyMenuItem)frm.getListeMenu().get(i)).getChemin() : " ";i++;
/* 111 */     s = s + p + "</Fic5>";
/*     */     
/* 113 */     s = s + "</FichierMCD>";
/*     */     
/* 115 */     s = s + "</BUREAU>";
/* 116 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void initialiserBureau(Principale frm, String st)
/*     */   {
/* 123 */     String ch = valeurChamp("<visible>", st);
/* 124 */     if (ch.equals("true")) {
/* 125 */       frm.getFormeMCD().setVisible(true);
/*     */     } else {
/* 127 */       frm.getFormeMCD().setVisible(false);
/*     */     }
/*     */     
/* 130 */     ch = valeurChamp("<x>", st);
/* 131 */     frm.getFormeMCD().setLocation(Integer.parseInt(ch), Integer.parseInt(valeurChamp("<y>", st)));
/*     */     
/* 133 */     frm.getFormeMCD().setSize(Integer.parseInt(valeurChamp("<w>", st)), Integer.parseInt(valeurChamp("<h>", st)));
/*     */     
/*     */ 
/* 136 */     if (valeurChamp("<FenMLD>", st).equals("true")) {
/* 137 */       frm.getFormeMLD().setVisible(true);
/*     */     } else {
/* 139 */       frm.getFormeMLD().setVisible(false);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 144 */     if (valeurChamp("<FenSQL>", st).equals("true")) {
/* 145 */       frm.getFormeSQL().setVisible(true);
/*     */     } else {
/* 147 */       frm.getFormeSQL().setVisible(false);
/*     */     }
/*     */     
/*     */ 
/* 151 */     ch = valeurChamp("<CouleurDef>", st);
/* 152 */     if (ch.trim().equals(Parametres.etatAUCUNEColor)) {
/* 153 */       FormeInterneMCD.setEtatColor(Parametres.etatAUCUNEColor);
/* 154 */       FormeInterneMCD.etatColor = Parametres.etatAUCUNEColor;
/* 155 */       FormeInterneMCD.initialiserAucuneColor();
/*     */     } else {
/* 157 */       FormeInterneMCD.setEtatColor(Parametres.etatDefautColor);
/* 158 */       FormeInterneMCD.etatColor = Parametres.etatDefautColor;
/* 159 */       FormeInterneMCD.initialiserDefaultColor();
/*     */     }
/* 161 */     ch = st.substring(st.indexOf("<Ombre>"), st.indexOf("</Ombre>"));
/* 162 */     ch = valeurChamp("<Ombre>", st);
/* 163 */     if (ch.trim().equals("true")) {
/* 164 */       frm.getFormeMCD().getConfig().setIsOmbre(true);
/* 165 */       frm.setOmbre(true);
/*     */     } else {
/* 167 */       frm.setOmbre(false);
/* 168 */       frm.getFormeMCD().getConfig().setIsOmbre(false);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 173 */     ch = valeurChamp("<tailleEnt>", st);
/* 174 */     if (ch.trim().equals("true")) {
/* 175 */       frm.setTailleVariable(true);
/* 176 */       frm.getFormeMCD().getConfig().setIsVariable(true);
/*     */     } else {
/* 178 */       frm.setTailleVariable(false);
/* 179 */       frm.getFormeMCD().getConfig().setIsVariable(false);
/*     */     }
/* 181 */     frm.getFormeMCD().getPage().setTailleVariable(frm.isTailleVariable());
/* 182 */     frm.getFormeMCD().getPage().setTailleVariable(frm.isTailleVariable());
/*     */     
/*     */ 
/* 185 */     ch = valeurChamp("<coulourDegradee>", st);
/* 186 */     if (ch.trim().equals("true")) {
/* 187 */       frm.setClDegradee(true);
/* 188 */       frm.getFormeMCD().getConfig().setIsDegradee(true);
/*     */     } else {
/* 190 */       frm.setClDegradee(false);
/* 191 */       frm.getFormeMCD().getConfig().setIsDegradee(false);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 196 */     ch = valeurChamp("<Grille>", st);
/* 197 */     if (ch.trim().equals("true")) {
/* 198 */       frm.getBar().getBtRegle().setSelected(true);
/*     */     } else {
/* 200 */       frm.getBar().getBtRegle().setSelected(false);
/*     */     }
/* 202 */     frm.getBar().setAfficheRegle(frm.getBar().getBtRegle().isSelected());
/*     */     
/* 204 */     ch = valeurChamp("<Fenconsole>", st);
/* 205 */     if (ch.trim().equals("true")) {
/* 206 */       frm.getjMIConsole().setSelected(true);
/*     */     } else {
/* 208 */       frm.getjMIConsole().setSelected(false);
/*     */     }
/* 210 */     frm.getConsole().setVisible(frm.getjMIConsole().isSelected());
/*     */     
/* 212 */     if (frm.getjMIConsole().isSelected()) {
/* 213 */       frm.getConsole().setSize(frm.getConsole().getWidth(), 20);
/* 214 */       frm.getSplitCon().setDividerLocation(frm.getHeight() - 200 - frm.getConsole().getHeight());
/*     */     }
/*     */     
/* 217 */     ch = valeurChamp("<FenExplorer>", st);
/* 218 */     if (ch.trim().equals("true")) {
/* 219 */       frm.getjMIExplorer().setSelected(true);
/*     */     } else {
/* 221 */       frm.getjMIExplorer().setSelected(false);
/*     */     }
/* 223 */     frm.getExplorer().setVisible(frm.getjMIExplorer().isSelected());
/* 224 */     if (frm.getjMIExplorer().isSelected()) {
/* 225 */       frm.getSplit().setDividerLocation(frm.getExplorer().getWidth());
/*     */     }
/*     */     
/* 228 */     ch = valeurChamp("<FenCadrage>", st);
/* 229 */     if (ch.length() == 0) {
/* 230 */       frm.afficherCadrage(frm.getjMIExplorer().isSelected());
/* 231 */       frm.getExplorer().setVisible(frm.getjMIExplorer().isSelected());
/* 232 */       if (frm.getjMIExplorer().isSelected()) {
/* 233 */         frm.getSplit().setDividerLocation(frm.getExplorer().getWidth());
/*     */       }
/*     */     }
/* 236 */     else if (ch.trim().equals("true")) {
/* 237 */       frm.afficherCadrage(true);
/*     */     } else {
/* 239 */       frm.afficherCadrage(false);
/*     */     }
/*     */     
/* 242 */     ch = valeurChamp("<Fic5>", st);
/* 243 */     if ((ch.trim().length() > 0) && 
/* 244 */       (Parametres.existeFichier(ch))) {
/* 245 */       frm.ajouterUnnouveauFichier(ch);
/* 246 */       frm.setCheminFichier(ch);
/* 247 */       frm.setCheminDernierMCD(ch);
/*     */     }
/*     */     
/* 250 */     ch = valeurChamp("<Fic4>", st);
/* 251 */     if ((ch.trim().length() > 0) && 
/* 252 */       (Parametres.existeFichier(ch))) {
/* 253 */       frm.ajouterUnnouveauFichier(ch);
/* 254 */       frm.setCheminDernierMCD(ch);
/*     */     }
/*     */     
/* 257 */     ch = valeurChamp("<Fic3>", st);
/* 258 */     if ((ch.trim().length() > 0) && 
/* 259 */       (Parametres.existeFichier(ch))) {
/* 260 */       frm.ajouterUnnouveauFichier(ch);
/* 261 */       frm.setCheminDernierMCD(ch);
/*     */     }
/*     */     
/* 264 */     ch = valeurChamp("<Fic2>", st);
/* 265 */     if ((ch.trim().length() > 0) && 
/* 266 */       (Parametres.existeFichier(ch))) {
/* 267 */       frm.ajouterUnnouveauFichier(ch);
/* 268 */       frm.setCheminDernierMCD(ch);
/*     */     }
/*     */     
/* 271 */     ch = valeurChamp("<Fic1>", st);
/* 272 */     if ((ch.trim().length() > 0) && 
/* 273 */       (Parametres.existeFichier(ch))) {
/* 274 */       frm.ajouterUnnouveauFichier(ch);
/* 275 */       frm.setCheminDernierMCD(ch);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Outil\BureauParametre.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */