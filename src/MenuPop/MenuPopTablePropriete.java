/*     */ package MenuPop;
/*     */ 
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import Merise.Attribut;
/*     */ import Merise.Domaine;
/*     */ import Merise2.Attribut2;
/*     */ import Outil.Parametres;
/*     */ import formes2.FormeEntite2;
/*     */ import formes2.ProprieteEntiteTableModel;
/*     */ import ihm.Principale;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JPopupMenu.Separator;
/*     */ import javax.swing.JTable;
/*     */ 
/*     */ public class MenuPopTablePropriete extends JPopupMenu implements Action
/*     */ {
/*     */   FormeEntite2 formeEnt;
/*     */   JMenuItem ajouter;
/*     */   JMenuItem supprimer;
/*     */   JMenu affecter;
/*     */   JMenuItem Type;
/*     */   JMenuItem longueur;
/*     */   JMenuItem longDecimal;
/*     */   
/*     */   public MenuPopTablePropriete(FormeEntite2 frm)
/*     */   {
/*  36 */     this.formeEnt = frm;
/*     */     
/*  38 */     this.ajouter = new JMenuItem("Ajouter");
/*  39 */     this.supprimer = new JMenuItem("Supprimer");
/*  40 */     this.Type = new JMenuItem("Valeur type");
/*  41 */     this.longueur = new JMenuItem("Taille");
/*  42 */     this.longDecimal = new JMenuItem("Taille Decimale");
/*     */     
/*  44 */     this.affecter = new JMenu("Affecter");
/*     */     
/*  46 */     this.ajouter.setIcon(new ImageIcon(getClass().getResource("/Images/Ajouter.png")));
/*  47 */     this.supprimer.setIcon(new ImageIcon(getClass().getResource("/Images/supprimer.png")));
/*  48 */     this.Type.setIcon(new ImageIcon(getClass().getResource("/Images/noteMCD.png")));
/*  49 */     this.longueur.setIcon(new ImageIcon(getClass().getResource("/Images/about.png")));
/*  50 */     this.longDecimal.setIcon(new ImageIcon(getClass().getResource("/Images/about.png")));
/*     */     
/*  52 */     this.ajouter.addActionListener(this);
/*  53 */     this.supprimer.addActionListener(this);
/*  54 */     this.Type.addActionListener(this);
/*  55 */     this.longueur.addActionListener(this);
/*  56 */     this.longDecimal.addActionListener(this);
/*     */     
/*  58 */     this.ajouter.setActionCommand("ADD");
/*  59 */     this.supprimer.setActionCommand("DELETE");
/*  60 */     this.Type.setActionCommand("TYPE");
/*  61 */     this.longueur.setActionCommand("LONG");
/*  62 */     this.longDecimal.setActionCommand("LONGDEC");
/*     */     
/*  64 */     add(this.ajouter);
/*  65 */     add(this.supprimer);
/*  66 */     add(new JPopupMenu.Separator());
/*  67 */     add(this.affecter);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  73 */     this.affecter.add(this.Type);
/*  74 */     this.affecter.add(this.longueur);
/*  75 */     this.affecter.add(this.longDecimal);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Object getValue(String key)
/*     */   {
/*  82 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void putValue(String key, Object value) {}
/*     */   
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/*  91 */     if (e.getActionCommand().equals("ADD")) {
/*  92 */       Attribut2 att = new Attribut2("", "", -1, -1, "", false, "", null);
/*  93 */       this.formeEnt.affectationReferenceAttribut(att);
/*  94 */       this.formeEnt.getListeAttribut().add(att);
/*  95 */       this.formeEnt.getTableModel().addAttribut(att);
/*  96 */       this.formeEnt.getjTableAttribut().setRowSelectionInterval(this.formeEnt.getListeAttribut().size() - 1, this.formeEnt.getListeAttribut().size() - 1);
/*  97 */       this.formeEnt.getjLabNbreAttribut().setText(this.formeEnt.getListeAttribut().size() + "");
/*  98 */       this.formeEnt.setModifier(true);
/*     */     }
/* 100 */     if (e.getActionCommand().equals("DELETE")) {
/* 101 */       this.formeEnt.supprimerSelection();
/*     */     }
/* 103 */     if (e.getActionCommand().equals("TYPE")) {
/* 104 */       affecterType();
/*     */     }
/* 106 */     if (e.getActionCommand().equals("LONGDEC")) {
/* 107 */       affecterLongueurD();
/*     */     }
/* 109 */     if (e.getActionCommand().equals("LONG")) {
/* 110 */       affecterLongueur();
/*     */     }
/* 112 */     this.formeEnt.getjTableAttribut().repaint();
/*     */   }
/*     */   
/*     */   private String[] remplirType() {
/*     */     String[] tab;
/* 118 */     if (!(this.formeEnt.getEntite() instanceof IhmRelation2)) {
/* 119 */       int taille = this.formeEnt.getFrm().getPage().getListeDomaine().size() == 0 ? 0 : this.formeEnt.getFrm().getPage().getListeDomaine().size() + 1;
/* 120 */       taille += Parametres.DomaineDefini.length;
/* 121 */       tab = new String[taille];
/*     */     } else {
/* 123 */       int taille = this.formeEnt.getFrm().getPage().getListeDomaine().size() == 0 ? 0 : this.formeEnt.getFrm().getPage().getListeDomaine().size() + 1;
/* 124 */       taille += Parametres.DomaineDefini.length;
/* 125 */       tab = new String[taille];
/*     */     }
/* 127 */     tab[0] = "        ";
/* 128 */     int nb = 1;
/* 129 */     for (int i = 0; i < this.formeEnt.getFrm().getPage().getListeDomaine().size(); i++) {
/* 130 */       tab[nb] = ((Domaine)this.formeEnt.getFrm().getPage().getListeDomaine().get(i)).getNom();
/* 131 */       nb++;
/*     */     }
/* 133 */     if (this.formeEnt.getFrm().getPage().getListeDomaine().size() > 0) {
/* 134 */       tab[nb] = "        ";
/* 135 */       nb++;
/*     */     }
/* 137 */     for (int i = 0; i < Parametres.DomaineDefini.length; i++) {
/* 138 */       if ((!Parametres.DomaineDefini[i].toUpperCase().equals("ENUM")) && (!Parametres.DomaineDefini[i].toUpperCase().equals("SET")))
/*     */       {
/* 140 */         if (Parametres.DomaineDefini[i].toUpperCase().equals("AUTO_INCREMENT")) {
/* 141 */           if (!(this.formeEnt.getEntite() instanceof IhmRelation2)) {
/* 142 */             tab[nb] = Parametres.DomaineDefini[i];
/* 143 */             nb++;
/*     */           }
/*     */         } else {
/* 146 */           tab[nb] = Parametres.DomaineDefini[i];
/* 147 */           nb++;
/*     */         }
/*     */       }
/*     */     }
/* 151 */     return tab;
/*     */   }
/*     */   
/*     */   public String getTypeAttribut() {
/* 155 */     String[] tabType = remplirType();
/* 156 */     return (String)JOptionPane.showInputDialog(this.formeEnt, "Veuillez indiquer le type !", "Type des attributs séléctionnés", 3, null, tabType, tabType[0]);
/*     */   }
/*     */   
/*     */   public void affecterType()
/*     */   {
/* 161 */     String val = getTypeAttribut();
/* 162 */     if (val == null) return;
/* 163 */     val = val == null ? "" : val.trim();
/* 164 */     int[] selection = this.formeEnt.getjTableAttribut().getSelectedRows();
/* 165 */     for (int i = selection.length - 1; i >= 0; i--) {
/* 166 */       ((Attribut)this.formeEnt.getTableModel().getListeAttribut().get(selection[i])).setType(val);
/* 167 */       ((Attribut)this.formeEnt.getListeAttribut().get(selection[i])).setType(val);
/* 168 */       this.formeEnt.setModifier(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean estEntier(String ent) {
/* 173 */     if (ent == null) return false;
/* 174 */     if (ent.trim().length() == 0) return true;
/*     */     try {
/* 176 */       int nb = Integer.parseInt(ent);
/* 177 */       if (nb >= 0) return true;
/* 178 */       return false;
/*     */     } catch (Exception e) {}
/* 180 */     return false;
/*     */   }
/*     */   
/*     */   public int getLongueur()
/*     */   {
/* 185 */     String nom = JOptionPane.showInputDialog(this.formeEnt, "Veuiller saisir la taille !", "La taille des attributs séléctionnés", 3);
/* 186 */     if (nom == null) return -2;
/* 187 */     if (estEntier(nom))
/* 188 */       return Integer.parseInt(nom);
/* 189 */     return -1;
/*     */   }
/*     */   
/*     */   public void affecterLongueur() {
/* 193 */     int val = getLongueur();
/* 194 */     if (val == -2) return;
/* 195 */     int[] selection = this.formeEnt.getjTableAttribut().getSelectedRows();
/* 196 */     for (int i = selection.length - 1; i >= 0; i--) {
/* 197 */       ((Attribut)this.formeEnt.getTableModel().getListeAttribut().get(selection[i])).setLongueur(val);
/* 198 */       ((Attribut)this.formeEnt.getListeAttribut().get(selection[i])).setLongueur(val);
/* 199 */       this.formeEnt.setModifier(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getLongueurD() {
/* 204 */     String nom = JOptionPane.showInputDialog(this.formeEnt, "Veuiller saisir la taille !", "La taille des attributs séléctionnés", 3);
/* 205 */     if (nom == null) return -2;
/* 206 */     if (estEntier(nom))
/* 207 */       return Integer.parseInt(nom);
/* 208 */     return -1;
/*     */   }
/*     */   
/*     */   public void affecterLongueurD() {
/* 212 */     int val = getLongueur();
/* 213 */     if (val == -2) return;
/* 214 */     int[] selection = this.formeEnt.getjTableAttribut().getSelectedRows();
/* 215 */     for (int i = selection.length - 1; i >= 0; i--) {
/* 216 */       ((Attribut)this.formeEnt.getTableModel().getListeAttribut().get(selection[i])).setLongDecimale(val);
/* 217 */       ((Attribut)this.formeEnt.getListeAttribut().get(selection[i])).setLongDecimale(val);
/* 218 */       this.formeEnt.setModifier(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MenuPop\MenuPopTablePropriete.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */