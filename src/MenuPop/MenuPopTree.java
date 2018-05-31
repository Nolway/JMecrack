/*     */ package MenuPop;
/*     */ 
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD2.IhmCadre2;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmHeritage2;
/*     */ import IhmMCD2.IhmLien2;
/*     */ import IhmMCD2.IhmLienContrainteHeritage2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import MyExplorer.ExplorerPan;
/*     */ import formes.FormeCommentaireIndep;
/*     */ import formes.FormeContrainte;
/*     */ import formes.FormeLienCif;
/*     */ import formes.FormeLienHeritageIndep;
/*     */ import formes.FormeMLDLien;
/*     */ import formes2.FormeCadre2;
/*     */ import formes2.FormeCardinalite2;
/*     */ import formes2.FormeContrainteHeritage2;
/*     */ import formes2.FormeEntite2;
/*     */ import formes2.FormeLienHeritageContrainte2;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.Principale;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.JTree;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MenuPopTree
/*     */   extends JPopupMenu
/*     */   implements Action
/*     */ {
/*     */   private JMenuItem pmEnregistrer;
/*     */   private JMenuItem pmEnregistrerSous;
/*     */   private JMenuItem pmFermer;
/*     */   private Principale frm;
/*     */   private String nomProjet;
/*     */   
/*     */   public MenuPopTree(Principale frm)
/*     */   {
/*  47 */     this.frm = frm;
/*  48 */     this.nomProjet = "";
/*  49 */     this.pmEnregistrer = new JMenuItem("Enregistrer " + this.nomProjet);
/*  50 */     this.pmEnregistrerSous = new JMenuItem("Enregistrer sous " + this.nomProjet);
/*  51 */     this.pmFermer = new JMenuItem("Fermer " + this.nomProjet);
/*     */     
/*  53 */     this.pmEnregistrer.setIcon(new ImageIcon(getClass().getResource("/Images/save.png")));
/*  54 */     this.pmEnregistrerSous.setIcon(new ImageIcon(getClass().getResource("/Images/saveas.png")));
/*  55 */     this.pmFermer.setIcon(new ImageIcon(getClass().getResource("/Images/fermer.png")));
/*     */     
/*     */ 
/*  58 */     this.pmEnregistrer.setActionCommand("enregistrer");
/*  59 */     this.pmEnregistrerSous.setActionCommand("enregistrersous");
/*  60 */     this.pmFermer.setActionCommand("fermer");
/*     */     
/*  62 */     add(this.pmEnregistrer);
/*  63 */     add(this.pmEnregistrerSous);
/*  64 */     add(new JSeparator());
/*  65 */     add(this.pmFermer);
/*     */     
/*     */ 
/*  68 */     this.pmEnregistrer.addActionListener(this);
/*  69 */     this.pmEnregistrerSous.addActionListener(this);
/*  70 */     this.pmFermer.addActionListener(this);
/*     */   }
/*     */   
/*     */   private void afficherPropriete(int x, int y) {
/*  74 */     this.frm.getFormeMCD().getPage().proprieteElementSel();
/*  75 */     if (this.frm.getFormeMCD().getPage().getEntRelaSelect() != null) {
/*  76 */       if (this.frm.getFormeMCD().getPage().getEntRelaSelect().getClass().getName().equals("IhmMCD2.IhmEntite2"))
/*  77 */         new FormeEntite2(this.frm, true, (IhmEntite2)this.frm.getFormeMCD().getPage().getEntRelaSelect(), this.frm.getFormeMCD().getPage().getListeEntiteRelation()).setVisible(true); else
/*  78 */         new FormeEntite2(this.frm, true, (IhmRelation2)this.frm.getFormeMCD().getPage().getEntRelaSelect(), this.frm.getFormeMCD().getPage().getListeEntiteRelation()).setVisible(true);
/*  79 */       this.frm.getExplorer().getTree().updateUI();
/*     */     }
/*  81 */     if (this.frm.getFormeMCD().getPage().getLienSel() != null) {
/*  82 */       new FormeCardinalite2(this.frm, true, (IhmLien2)this.frm.getFormeMCD().getPage().getLienSel(), x, y).setVisible(true);
/*     */     }
/*  84 */     if (this.frm.getFormeMCD().getPage().getCommSelect() != null) {
/*  85 */       new FormeCommentaireIndep(this.frm, true, this.frm.getFormeMCD().getPage().getCommSelect(), x, y).setVisible(true);
/*     */     }
/*  87 */     if (this.frm.getFormeMCD().getPage().getLienCifSel() != null) {
/*  88 */       new FormeLienCif(this.frm, true, this.frm.getFormeMCD().getPage().getLienCifSel(), x, y).setVisible(true);
/*     */     }
/*  90 */     if (this.frm.getFormeMCD().getPage().getLienHeritageSel() != null) {
/*  91 */       new FormeLienHeritageIndep(this.frm, true, this.frm.getFormeMCD().getPage().getLienHeritageSel(), x, y).setVisible(true);
/*     */     }
/*  93 */     if (this.frm.getFormeMCD().getPage().getContrainteSel() != null) {
/*  94 */       new FormeContrainte(this.frm, true, this.frm.getFormeMCD().getPage().getContrainteSel(), x, y).setVisible(true);
/*     */     }
/*  96 */     if (this.frm.getFormeMCD().getPage().getHeritageSelect() != null) {
/*  97 */       new FormeContrainteHeritage2(this.frm, true, (IhmHeritage2)this.frm.getFormeMCD().getPage().getHeritageSelect()).setVisible(true);
/*     */     }
/*     */     
/* 100 */     if (this.frm.getFormeMCD().getPage().getLienContrHeritageSel() != null) {
/* 101 */       new FormeLienHeritageContrainte2(this.frm, true, (IhmLienContrainteHeritage2)this.frm.getFormeMCD().getPage().getLienContrHeritageSel()).setVisible(true);
/*     */     }
/* 103 */     if (this.frm.getFormeMCD().getPage().getLienContrSel() != null) {
/* 104 */       new FormeMLDLien(this.frm, true, this.frm.getFormeMCD().getPage().getLienContrSel(), x, y).setVisible(true);
/*     */     }
/* 106 */     if (this.frm.getFormeMCD().getPage().getLienCommSelect() != null) {
/* 107 */       new FormeMLDLien(this.frm, true, this.frm.getFormeMCD().getPage().getLienCommSelect(), x, y).setVisible(true);
/*     */     }
/* 109 */     if (this.frm.getFormeMCD().getPage().getCadreSelect() != null) {
/* 110 */       new FormeCadre2(this.frm, true, (IhmCadre2)this.frm.getFormeMCD().getPage().getCadreSelect()).setVisible(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setNomProjet(String nomProjet)
/*     */   {
/* 116 */     this.pmEnregistrer.setText("Enregistrer ..." + nomProjet);
/* 117 */     this.pmEnregistrerSous.setText("Enregistrer sous ..." + nomProjet);
/* 118 */     this.pmFermer.setText("Fermer ..." + nomProjet);
/* 119 */     this.nomProjet = nomProjet;
/*     */   }
/*     */   
/*     */   public String getNomProjet() {
/* 123 */     return this.nomProjet;
/*     */   }
/*     */   
/*     */   public Object getValue(String key) {
/* 127 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void putValue(String key, Object value) {}
/*     */   
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/* 136 */     if (e.getActionCommand().equals("propriete")) {
/* 137 */       afficherPropriete(this.frm.getWidth() / 2, this.frm.getHeight() / 2);
/*     */     }
/*     */     
/* 140 */     if (e.getActionCommand().equals("enregistrer")) {
/* 141 */       this.frm.getFormeMCD().enregistrerMCD();
/*     */     }
/*     */     
/* 144 */     if (e.getActionCommand().equals("enregistrersous")) {
/* 145 */       this.frm.getFormeMCD().enregistrerSousMCD();
/*     */     }
/*     */     
/* 148 */     if ((e.getActionCommand().equals("fermer")) && 
/* 149 */       (this.frm.getProjetSel() != null) && 
/* 150 */       (this.frm.getFormeMCD().fermerMCD())) this.frm.supprimerProjet(this.frm.getProjetSel());
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MenuPop\MenuPopTree.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */