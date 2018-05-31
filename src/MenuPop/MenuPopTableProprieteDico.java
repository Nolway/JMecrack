/*     */ package MenuPop;
/*     */ 
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import Merise.Attribut;
/*     */ import Merise.Domaine;
/*     */ import Merise2.Attribut2;
/*     */ import Outil.Parametres;
/*     */ import formes2.FormeDictionnaireDeDonnees2;
/*     */ import formes2.ProprieteEntiteTableModelDico;
/*     */ import ihm.Principale;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JPopupMenu.Separator;
/*     */ import javax.swing.JTable;
/*     */ 
/*     */ public class MenuPopTableProprieteDico extends JPopupMenu implements Action
/*     */ {
/*     */   FormeDictionnaireDeDonnees2 formeEnt;
/*     */   JMenuItem ajouter;
/*     */   JMenuItem supprimer;
/*     */   JMenu affecter;
/*     */   JMenuItem Type;
/*     */   JMenuItem longueur;
/*     */   JMenuItem longDecimal;
/*     */   
/*     */   public MenuPopTableProprieteDico(FormeDictionnaireDeDonnees2 frm)
/*     */   {
/*  34 */     this.formeEnt = frm;
/*     */     
/*  36 */     this.ajouter = new JMenuItem("Ajouter");
/*  37 */     this.supprimer = new JMenuItem("Supprimer");
/*  38 */     this.Type = new JMenuItem("Valeur type");
/*  39 */     this.longueur = new JMenuItem("Taille");
/*  40 */     this.longDecimal = new JMenuItem("Taille Decimale");
/*     */     
/*  42 */     this.affecter = new JMenu("Affecter");
/*     */     
/*  44 */     this.ajouter.setIcon(new ImageIcon(getClass().getResource("/Images/Ajouter.png")));
/*  45 */     this.supprimer.setIcon(new ImageIcon(getClass().getResource("/Images/supprimer.png")));
/*  46 */     this.Type.setIcon(new ImageIcon(getClass().getResource("/Images/noteMCD.png")));
/*  47 */     this.longueur.setIcon(new ImageIcon(getClass().getResource("/Images/about.png")));
/*  48 */     this.longDecimal.setIcon(new ImageIcon(getClass().getResource("/Images/about.png")));
/*     */     
/*  50 */     this.ajouter.addActionListener(this);
/*  51 */     this.supprimer.addActionListener(this);
/*  52 */     this.Type.addActionListener(this);
/*  53 */     this.longueur.addActionListener(this);
/*  54 */     this.longDecimal.addActionListener(this);
/*     */     
/*  56 */     this.ajouter.setActionCommand("ADD");
/*  57 */     this.supprimer.setActionCommand("DELETE");
/*  58 */     this.Type.setActionCommand("TYPE");
/*  59 */     this.longueur.setActionCommand("LONG");
/*  60 */     this.longDecimal.setActionCommand("LONGDEC");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  66 */     add(this.ajouter);
/*  67 */     add(this.supprimer);
/*  68 */     add(new JPopupMenu.Separator());
/*  69 */     add(this.affecter);
/*     */     
/*  71 */     this.affecter.add(this.Type);
/*  72 */     this.affecter.add(this.longueur);
/*  73 */     this.affecter.add(this.longDecimal);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Object getValue(String key)
/*     */   {
/*  80 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void putValue(String key, Object value) {}
/*     */   
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/*  89 */     if (e.getActionCommand().equals("ADD")) {
/*  90 */       Attribut2 att = new Attribut2("", "", -1, -1, "", false, "", null);
/*  91 */       this.formeEnt.getListeAttribut().add(att);
/*  92 */       this.formeEnt.getTableModel().addAttribut(att);
/*  93 */       this.formeEnt.getjTableAttribut().setRowSelectionInterval(this.formeEnt.getListeAttribut().size() - 1, this.formeEnt.getListeAttribut().size() - 1);
/*     */     }
/*     */     
/*  96 */     if (e.getActionCommand().equals("DELETE")) {
/*  97 */       this.formeEnt.supprimerSelection();
/*     */     }
/*  99 */     if (e.getActionCommand().equals("TYPE")) {
/* 100 */       affecterType();
/*     */     }
/* 102 */     if (e.getActionCommand().equals("LONGDEC")) {
/* 103 */       affecterLongueurD();
/*     */     }
/* 105 */     if (e.getActionCommand().equals("LONG")) {
/* 106 */       affecterLongueur();
/*     */     }
/* 108 */     this.formeEnt.getjTableAttribut().repaint();
/*     */   }
/*     */   
/*     */ 
/*     */   private String[] remplirType()
/*     */   {
/* 114 */     int taille = this.formeEnt.getFrm().getPage().getListeDomaine().size() == 0 ? 0 : this.formeEnt.getFrm().getPage().getListeDomaine().size() + 1;
/* 115 */     taille += Parametres.DomaineDefini.length;
/* 116 */     String[] tab = new String[taille];
/* 117 */     tab[0] = "        ";
/* 118 */     int nb = 1;
/*     */     
/* 120 */     for (int i = 0; i < this.formeEnt.getFrm().getPage().getListeDomaine().size(); i++) {
/* 121 */       tab[nb] = ((Domaine)this.formeEnt.getFrm().getPage().getListeDomaine().get(i)).getNom();
/* 122 */       nb++;
/*     */     }
/* 124 */     if (this.formeEnt.getFrm().getPage().getListeDomaine().size() > 0) {
/* 125 */       tab[nb] = "        ";
/* 126 */       nb++;
/*     */     }
/* 128 */     for (int i = 0; i < Parametres.DomaineDefini.length; i++) {
/* 129 */       if ((!Parametres.DomaineDefini[i].toUpperCase().equals("ENUM")) && (!Parametres.DomaineDefini[i].toUpperCase().equals("SET")))
/*     */       {
/* 131 */         tab[nb] = Parametres.DomaineDefini[i];
/* 132 */         nb++;
/*     */       }
/*     */     }
/*     */     
/* 136 */     return tab;
/*     */   }
/*     */   
/*     */   public String getTypeAttribut() {
/* 140 */     String[] tabType = remplirType();
/* 141 */     return (String)JOptionPane.showInputDialog(this.formeEnt, "Veuillez indiquer le type !", "Type des attributs séléctionnés", 3, null, tabType, tabType[0]);
/*     */   }
/*     */   
/*     */   public void affecterType() {
/* 145 */     String val = getTypeAttribut();
/* 146 */     if (val == null) return;
/* 147 */     val = val == null ? "" : val.trim();
/* 148 */     int[] selection = this.formeEnt.getjTableAttribut().getSelectedRows();
/* 149 */     for (int i = selection.length - 1; i >= 0; i--) {
/* 150 */       ((Attribut)this.formeEnt.getTableModel().getListeAttribut().get(selection[i])).setType(val);
/* 151 */       ((Attribut)this.formeEnt.getListeAttribut().get(selection[i])).setType(val);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean estEntier(String ent)
/*     */   {
/* 157 */     if (ent == null) return false;
/* 158 */     if (ent.trim().length() == 0) return true;
/*     */     try {
/* 160 */       int nb = Integer.parseInt(ent);
/* 161 */       if (nb >= 0) return true;
/* 162 */       return false;
/*     */     } catch (Exception e) {}
/* 164 */     return false;
/*     */   }
/*     */   
/*     */   public int getLongueur()
/*     */   {
/* 169 */     String nom = JOptionPane.showInputDialog(this.formeEnt, "Veuiller saisir la taille !", "La taille des attributs séléctionnés", 3);
/* 170 */     if (nom == null) return -2;
/* 171 */     if (estEntier(nom))
/* 172 */       return Integer.parseInt(nom);
/* 173 */     return -1;
/*     */   }
/*     */   
/*     */   public void affecterLongueur() {
/* 177 */     int val = getLongueur();
/* 178 */     if (val == -2) return;
/* 179 */     int[] selection = this.formeEnt.getjTableAttribut().getSelectedRows();
/* 180 */     for (int i = selection.length - 1; i >= 0; i--) {
/* 181 */       ((Attribut)this.formeEnt.getTableModel().getListeAttribut().get(selection[i])).setLongueur(val);
/* 182 */       ((Attribut)this.formeEnt.getListeAttribut().get(selection[i])).setLongueur(val);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getLongueurD()
/*     */   {
/* 188 */     String nom = JOptionPane.showInputDialog(this.formeEnt, "Veuiller saisir la taille !", "La taille des attributs séléctionnés", 3);
/* 189 */     if (nom == null) return -2;
/* 190 */     if (estEntier(nom))
/* 191 */       return Integer.parseInt(nom);
/* 192 */     return -1;
/*     */   }
/*     */   
/*     */   public void affecterLongueurD() {
/* 196 */     int val = getLongueur();
/* 197 */     if (val == -2) return;
/* 198 */     int[] selection = this.formeEnt.getjTableAttribut().getSelectedRows();
/* 199 */     for (int i = selection.length - 1; i >= 0; i--) {
/* 200 */       ((Attribut)this.formeEnt.getTableModel().getListeAttribut().get(selection[i])).setLongDecimale(val);
/* 201 */       ((Attribut)this.formeEnt.getListeAttribut().get(selection[i])).setLongDecimale(val);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MenuPop\MenuPopTableProprieteDico.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */