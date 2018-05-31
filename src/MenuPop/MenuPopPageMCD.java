/*     */ package MenuPop;
/*     */ 
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import formes.FormeRecherche;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.Principale;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JSeparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MenuPopPageMCD
/*     */   extends JPopupMenu
/*     */   implements Action
/*     */ {
/*     */   private JMenuItem pmCopier;
/*     */   private JMenuItem pmColler;
/*     */   private JMenuItem pmSupprimer;
/*     */   private JMenuItem pmEnregistrer;
/*     */   private JMenuItem pmEnregistrerSous;
/*     */   private JMenuItem pmFermer;
/*     */   private JMenuItem pmChercher;
/*     */   private JMenuItem pmPropriete;
/*     */   private JMenuItem pmTransformer;
/*     */   private JMenuItem pmInsererLib;
/*     */   private JMenu aligneMenu;
/*     */   private IhmPageMCD page;
/*     */   private Principale frm;
/*     */   
/*     */   public MenuPopPageMCD(IhmPageMCD page)
/*     */   {
/*  40 */     this.page = page;
/*     */     
/*  42 */     this.frm = page.getFrm();
/*  43 */     this.aligneMenu = new JMenu("Aligner");
/*  44 */     JMenuItem mAligneTop = new JMenuItem("Haut   ");
/*  45 */     JMenuItem mAligneGauche = new JMenuItem("Gauche ");
/*  46 */     JMenuItem mAligneBas = new JMenuItem("Bas    ");
/*  47 */     JMenuItem mAligneDroit = new JMenuItem("Droit  ");
/*  48 */     this.aligneMenu.add(mAligneDroit);
/*  49 */     this.aligneMenu.add(mAligneGauche);
/*  50 */     this.aligneMenu.add(mAligneTop);
/*  51 */     this.aligneMenu.add(mAligneBas);
/*     */     
/*  53 */     this.pmCopier = new JMenuItem("Copier");
/*  54 */     this.pmChercher = new JMenuItem("Chercher");
/*  55 */     this.pmColler = new JMenuItem("Coller");
/*  56 */     this.pmPropriete = new JMenuItem("Propriete");
/*  57 */     this.pmSupprimer = new JMenuItem("Supprimer");
/*  58 */     this.pmTransformer = new JMenuItem("Transformer relation ...");
/*  59 */     this.pmEnregistrer = new JMenuItem("Enregistrer");
/*  60 */     this.pmEnregistrerSous = new JMenuItem("Enregistrer Sous");
/*  61 */     this.pmFermer = new JMenuItem("Fermer");
/*  62 */     this.pmInsererLib = new JMenuItem("Inserer dans la Librairie");
/*     */     
/*  64 */     this.pmChercher.setIcon(new ImageIcon(getClass().getResource("/Images/recherche.gif")));
/*  65 */     this.pmColler.setIcon(new ImageIcon(getClass().getResource("/Images/paste.png")));
/*  66 */     this.pmCopier.setIcon(new ImageIcon(getClass().getResource("/Images/copy.png")));
/*  67 */     this.pmPropriete.setIcon(new ImageIcon(getClass().getResource("/Images/options.png")));
/*  68 */     this.pmSupprimer.setIcon(new ImageIcon(getClass().getResource("/Images/delete.png")));
/*     */     
/*  70 */     this.pmEnregistrer.setIcon(new ImageIcon(getClass().getResource("/Images/save.png")));
/*  71 */     this.pmEnregistrerSous.setIcon(new ImageIcon(getClass().getResource("/Images/saveas.png")));
/*  72 */     this.pmFermer.setIcon(new ImageIcon(getClass().getResource("/Images/fermer.png")));
/*     */     
/*  74 */     this.pmTransformer.setIcon(new ImageIcon(getClass().getResource("/Images/transformeRel.png")));
/*     */     
/*  76 */     this.aligneMenu.setIcon(new ImageIcon(getClass().getResource("/Images/left.png")));
/*  77 */     mAligneDroit.setIcon(new ImageIcon(getClass().getResource("/Images/right.png")));
/*  78 */     mAligneGauche.setIcon(new ImageIcon(getClass().getResource("/Images/left.png")));
/*  79 */     mAligneTop.setIcon(new ImageIcon(getClass().getResource("/Images/top.png")));
/*  80 */     mAligneBas.setIcon(new ImageIcon(getClass().getResource("/Images/enbas.png")));
/*  81 */     this.pmInsererLib.setIcon(new ImageIcon(getClass().getResource("/Images/ajoutEntiteLib.png")));
/*     */     
/*  83 */     this.pmSupprimer.setActionCommand("supprimer");
/*  84 */     this.pmTransformer.setActionCommand("transformer");
/*  85 */     this.pmChercher.setActionCommand("chercher");
/*  86 */     this.pmColler.setActionCommand("coller");
/*  87 */     this.pmCopier.setActionCommand("copier");
/*  88 */     this.pmPropriete.setActionCommand("propriete");
/*     */     
/*  90 */     this.pmEnregistrer.setActionCommand("enregistrer");
/*  91 */     this.pmEnregistrerSous.setActionCommand("enregistrersous");
/*  92 */     this.pmFermer.setActionCommand("fermer");
/*  93 */     this.pmInsererLib.setActionCommand("insererlib");
/*     */     
/*  95 */     mAligneBas.setActionCommand("Bas");
/*  96 */     mAligneTop.setActionCommand("Top");
/*  97 */     mAligneGauche.setActionCommand("Gauche");
/*  98 */     mAligneDroit.setActionCommand("Droite");
/*     */     
/* 100 */     this.pmPropriete.setEnabled(true);
/* 101 */     this.pmChercher.setEnabled(true);
/*     */     
/* 103 */     add(this.pmPropriete);
/* 104 */     add(new JSeparator());
/* 105 */     add(this.pmEnregistrer);
/* 106 */     add(this.pmEnregistrerSous);
/* 107 */     add(this.pmFermer);
/* 108 */     add(new JSeparator());
/* 109 */     add(this.pmTransformer);
/* 110 */     add(new JSeparator());
/* 111 */     add(this.pmInsererLib);
/* 112 */     add(new JSeparator());
/* 113 */     add(this.pmCopier);
/* 114 */     add(this.pmColler);
/* 115 */     add(this.pmSupprimer);
/* 116 */     add(new JSeparator());
/* 117 */     add(this.aligneMenu);
/* 118 */     add(new JSeparator());
/* 119 */     add(this.pmChercher);
/*     */     
/* 121 */     this.pmChercher.addActionListener(this);
/* 122 */     this.pmColler.addActionListener(this);
/* 123 */     this.pmCopier.addActionListener(this);
/* 124 */     this.pmPropriete.addActionListener(this);
/* 125 */     this.pmSupprimer.addActionListener(this);
/* 126 */     this.pmEnregistrer.addActionListener(this);
/* 127 */     this.pmEnregistrerSous.addActionListener(this);
/* 128 */     this.pmFermer.addActionListener(this);
/* 129 */     this.pmTransformer.addActionListener(this);
/*     */     
/* 131 */     mAligneBas.addActionListener(this);
/* 132 */     mAligneTop.addActionListener(this);
/* 133 */     mAligneGauche.addActionListener(this);
/* 134 */     mAligneDroit.addActionListener(this);
/* 135 */     this.pmInsererLib.addActionListener(this);
/*     */   }
/*     */   
/*     */   public Object getValue(String key)
/*     */   {
/* 140 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void putValue(String key, Object value) {}
/*     */   
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/* 148 */     if (e.getActionCommand().equals("insererlib")) {
/* 149 */       this.page.insererDansLaLibrairie();
/*     */     }
/*     */     
/* 152 */     if (e.getActionCommand().equals("copier")) {
/* 153 */       this.frm.copierObjet();
/*     */     }
/* 155 */     if (e.getActionCommand().equals("coller")) {
/* 156 */       this.frm.collerObjet();
/*     */     }
/* 158 */     if ((e.getActionCommand().equals("supprimer")) && 
/* 159 */       (JOptionPane.showConfirmDialog(this.frm, "Voulez-vous supprimer les éléments sélectionnés ?", "Suppression", 0) == 0)) {
/* 160 */       this.page.supprimerObjetSelect();
/*     */     }
/*     */     
/* 163 */     if (e.getActionCommand().equals("transformer")) {
/* 164 */       this.page.transformerRelation();
/*     */     }
/*     */     
/* 167 */     if (e.getActionCommand().equals("chercher")) {
/* 168 */       FormeRecherche form = new FormeRecherche(this.frm, true, this.page.getListeEntiteRelation());
/* 169 */       form.setVisible(true);
/* 170 */       if ((form.isResultFermer()) && 
/* 171 */         (form.getEntiteSelect() != null)) {
/* 172 */         this.page.scrollRectToVisible(new Rectangle(form.getEntiteSelect().getX() - 10, form.getEntiteSelect().getY() - 20, form.getEntiteSelect().getWidth() + 30, form.getEntiteSelect().getHeight() + 30));
/* 173 */         this.page.setSelected(false);
/* 174 */         form.getEntiteSelect().setSelected(true);
/*     */       }
/*     */     }
/*     */     
/* 178 */     if (e.getActionCommand().equals("propriete")) {
/* 179 */       this.page.getFormeMcd().afficherPropriete(this.frm.getWidth() / 2, this.frm.getHeight() / 2);
/*     */     }
/* 181 */     if (e.getActionCommand().equals("Top")) {
/* 182 */       this.page.alignerGroupe("TOP");
/*     */     }
/* 184 */     if (e.getActionCommand().equals("Gauche")) {
/* 185 */       this.page.alignerGroupe("GAUCHE");
/*     */     }
/* 187 */     if (e.getActionCommand().equals("Droite")) {
/* 188 */       this.page.alignerGroupe("DROITE");
/*     */     }
/* 190 */     if (e.getActionCommand().equals("Bas")) {
/* 191 */       this.page.alignerGroupe("BAS");
/*     */     }
/*     */     
/* 194 */     if (e.getActionCommand().equals("enregistrer")) {
/* 195 */       this.frm.getFormeMCD().enregistrerMCD();
/*     */     }
/*     */     
/* 198 */     if (e.getActionCommand().equals("enregistrersous")) {
/* 199 */       this.frm.getFormeMCD().enregistrerSousMCD();
/*     */     }
/*     */     
/* 202 */     if ((e.getActionCommand().equals("fermer")) && 
/* 203 */       (this.frm.getProjetSel() != null) && 
/* 204 */       (this.frm.getFormeMCD().fermerMCD())) this.frm.supprimerProjet(this.frm.getProjetSel());
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MenuPop\MenuPopPageMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */