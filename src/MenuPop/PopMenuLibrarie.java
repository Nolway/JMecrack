/*     */ package MenuPop;
/*     */ 
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import LibraryPan.FormeAjouterLibrairie;
/*     */ import LibraryPan.FormeCouleurLibrairie;
/*     */ import LibraryPan.FormeProprieteLibrairie;
/*     */ import LibraryPan.Library;
/*     */ import LibraryPan.LibraryPanel;
/*     */ import LibraryPan.PanelEntiteRelation;
/*     */ import formes2.FormeEntite2;
/*     */ import ihm.Principale;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JSeparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PopMenuLibrarie
/*     */   extends JPopupMenu
/*     */   implements Action
/*     */ {
/*     */   private JMenuItem pmProprieteLib;
/*     */   private JMenuItem pmCouleurSel;
/*     */   private JMenuItem pmSupprimerLib;
/*     */   private JMenuItem pmAjouterLib;
/*     */   private JMenuItem pmRechargerLib;
/*     */   private JSeparator sep1;
/*     */   private JMenuItem pmProprieteAtt;
/*     */   private JMenuItem pmSupprimerAtt;
/*     */   private LibraryPanel libPan;
/*     */   private Principale frm;
/*     */   
/*     */   public PopMenuLibrarie(LibraryPanel libPan, Principale frm)
/*     */   {
/*  44 */     this.libPan = libPan;
/*  45 */     this.frm = frm;
/*  46 */     this.pmCouleurSel = new JMenuItem("Couleur ... ");
/*  47 */     this.pmProprieteAtt = new JMenuItem("Proppriété Entité/Relation  ");
/*  48 */     this.pmProprieteLib = new JMenuItem("Proppriété Librairie  ");
/*  49 */     this.pmSupprimerAtt = new JMenuItem("Supprimer l'élément sélectionné ");
/*  50 */     this.pmSupprimerLib = new JMenuItem("Supprimer la librairie");
/*  51 */     this.pmAjouterLib = new JMenuItem("Nouvelle ...  ");
/*  52 */     this.pmRechargerLib = new JMenuItem("Recharger ");
/*     */     
/*  54 */     this.pmCouleurSel.setIcon(new ImageIcon(getClass().getResource("/Images/colorie.png")));
/*  55 */     this.pmProprieteAtt.setIcon(new ImageIcon(getClass().getResource("/Images/infoMCD.png")));
/*  56 */     this.pmProprieteLib.setIcon(new ImageIcon(getClass().getResource("/Images/infoMCD.png")));
/*  57 */     this.pmSupprimerAtt.setIcon(new ImageIcon(getClass().getResource("/Images/supprimer.png")));
/*  58 */     this.pmSupprimerLib.setIcon(new ImageIcon(getClass().getResource("/Images/supprimerLib.png")));
/*  59 */     this.pmAjouterLib.setIcon(new ImageIcon(getClass().getResource("/Images/new.gif")));
/*  60 */     this.pmRechargerLib.setIcon(new ImageIcon(getClass().getResource("/Images/refresh_mini.png")));
/*     */     
/*     */ 
/*  63 */     this.pmCouleurSel.setActionCommand("couleur");
/*  64 */     this.pmProprieteAtt.setActionCommand("propAtt");
/*  65 */     this.pmProprieteLib.setActionCommand("propLib");
/*  66 */     this.pmAjouterLib.setActionCommand("ajoutLib");
/*  67 */     this.pmSupprimerAtt.setActionCommand("supAtt");
/*  68 */     this.pmSupprimerLib.setActionCommand("suppLib");
/*  69 */     this.pmRechargerLib.setActionCommand("chargerLib");
/*     */     
/*  71 */     add(this.pmProprieteLib);
/*  72 */     add(this.pmAjouterLib);
/*  73 */     add(this.pmRechargerLib);
/*  74 */     add(this.pmSupprimerLib);
/*  75 */     add(this.pmCouleurSel);
/*  76 */     add(new JSeparator());
/*  77 */     add(this.pmProprieteAtt);
/*  78 */     add(this.pmSupprimerAtt);
/*     */     
/*     */ 
/*     */ 
/*  82 */     this.pmCouleurSel.addActionListener(this);
/*  83 */     this.pmProprieteAtt.addActionListener(this);
/*  84 */     this.pmProprieteLib.addActionListener(this);
/*  85 */     this.pmSupprimerAtt.addActionListener(this);
/*  86 */     this.pmSupprimerLib.addActionListener(this);
/*  87 */     this.pmAjouterLib.addActionListener(this);
/*  88 */     this.pmRechargerLib.addActionListener(this);
/*     */   }
/*     */   
/*     */   public Object getValue(String key) {
/*  92 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void putValue(String key, Object value) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/* 103 */     if (e.getActionCommand().equals("chargerLib")) {
/* 104 */       this.frm.getPanLibibrary().openLibraries();
/*     */     }
/*     */     
/* 107 */     if (e.getActionCommand().equals("couleur")) {
/* 108 */       new FormeCouleurLibrairie(this.frm, true).setVisible(true);
/*     */     }
/*     */     
/* 111 */     if (e.getActionCommand().equals("ajoutLib")) {
/* 112 */       new FormeAjouterLibrairie(this.frm, true).setVisible(true);
/*     */     }
/*     */     
/* 115 */     if (e.getActionCommand().equals("propAtt")) {
/* 116 */       IhmEntiteRelation ent = this.libPan.getModelSelected();
/* 117 */       if (ent != null) {
/* 118 */         new FormeEntite2(this.frm, true, ent, new ArrayList(), "VISUALISER").setVisible(true);
/* 119 */         this.libPan.cacherAttribut(ent);
/* 120 */         this.libPan.corrigeNomEntite(ent);
/* 121 */         if (!this.libPan.getModel().saveLib()) {
/* 122 */           JOptionPane.showMessageDialog(this.frm, "Erreur est survenue lors de la sauvegade de la librairie", "Sauvegarde", 0);
/*     */         }
/*     */       } else {
/* 125 */         JOptionPane.showMessageDialog(this.frm, "Aucun élément de la librairie n'est sélectionné !! ", "Propriété", 1);
/*     */       }
/*     */     }
/* 128 */     if ((e.getActionCommand().equals("propLib")) && 
/* 129 */       (this.libPan.getModel() != null)) {
/* 130 */       new FormeProprieteLibrairie(this.frm, true, this.libPan.getModel()).setVisible(true);
/*     */     }
/*     */     
/*     */ 
/* 134 */     if (e.getActionCommand().equals("supAtt")) {
/* 135 */       if (this.libPan.getModelSelected() != null) {
/* 136 */         if (JOptionPane.showConfirmDialog(this.frm, "Êtes vous sûr de vouloir supprimer \n" + this.libPan.getName(this.libPan.getModelSelected()) + " de la librairie " + this.libPan.getModel().getName() + " ?", "Suppression", 0) == 0) {
/* 137 */           this.libPan.getModel().getListModels().remove(this.libPan.getModelSelected());
/* 138 */           if (!this.libPan.getModel().saveLib()) {
/* 139 */             JOptionPane.showMessageDialog(this.frm, "Erreur est survenue lors de la sauvegade de la librairie", "Sauvegarde", 0);
/*     */           }
/* 141 */           this.libPan.repaint();
/*     */         }
/*     */       } else {
/* 144 */         JOptionPane.showMessageDialog(this.frm, "Aucun élément de la librairie n'est sélectionné !! ", "Suppression", 1);
/*     */       }
/*     */     }
/* 147 */     if (e.getActionCommand().equals("suppLib")) {
/* 148 */       String nomLib = this.libPan.getModel().getName();
/* 149 */       if (JOptionPane.showConfirmDialog(this, "Etes vous sûr de vouloir supprimer la librairie " + nomLib + "?", "Suppression", 0) == 0) {
/* 150 */         this.frm.getPanLibibrary().deleteLibrairy(this.libPan.getModel());
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MenuPop\PopMenuLibrarie.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */