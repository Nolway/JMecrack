/*    */ package MenuPop;
/*    */ 
/*    */ import IhmMCD.IhmPageMCD;
/*    */ import IhmMCD.IhmProjet;
/*    */ import formes.About;
/*    */ import formes.FormeInformationSite;
/*    */ import formes.FormeNomDeveloppeur;
/*    */ import formes.FormeText;
/*    */ import ihm.FormeInterneMCD;
/*    */ import ihm.Principale;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.Action;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JPopupMenu;
/*    */ import javax.swing.JPopupMenu.Separator;
/*    */ 
/*    */ 
/*    */ public class MenuPopInformation
/*    */   extends JPopupMenu
/*    */   implements Action
/*    */ {
/*    */   Principale frm;
/*    */   JMenuItem infoSite;
/*    */   JMenuItem dev;
/*    */   JMenuItem noteMCD;
/*    */   JMenuItem version;
/*    */   
/*    */   public MenuPopInformation(Principale frm)
/*    */   {
/* 31 */     this.frm = frm;
/* 32 */     this.infoSite = new JMenuItem("Voir les dernières informations disponibles sur site web");
/* 33 */     this.dev = new JMenuItem("Personnaliser le nom du développeur");
/* 34 */     this.noteMCD = new JMenuItem("Notes / commentaires MCD");
/* 35 */     this.version = new JMenuItem("Version");
/*    */     
/* 37 */     this.infoSite.setIcon(new ImageIcon(getClass().getResource("/Images/infosite.jpg")));
/* 38 */     this.dev.setIcon(new ImageIcon(getClass().getResource("/Images/user.png")));
/* 39 */     this.noteMCD.setIcon(new ImageIcon(getClass().getResource("/Images/noteMCD.png")));
/* 40 */     this.version.setIcon(new ImageIcon(getClass().getResource("/Images/about.png")));
/*    */     
/* 42 */     this.infoSite.addActionListener(this);
/* 43 */     this.dev.addActionListener(this);
/* 44 */     this.noteMCD.addActionListener(this);
/* 45 */     this.version.addActionListener(this);
/*    */     
/* 47 */     this.infoSite.setActionCommand("INFO");
/* 48 */     this.dev.setActionCommand("DEV");
/* 49 */     this.noteMCD.setActionCommand("NOTE");
/* 50 */     this.version.setActionCommand("VER");
/*    */     
/* 52 */     add(this.noteMCD);
/* 53 */     add(this.dev);
/* 54 */     add(new JPopupMenu.Separator());
/* 55 */     add(this.infoSite);
/*    */   }
/*    */   
/*    */ 
/*    */   public Object getValue(String key)
/*    */   {
/* 61 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void putValue(String key, Object value) {}
/*    */   
/*    */ 
/*    */   public void actionPerformed(ActionEvent e)
/*    */   {
/* 70 */     if (e.getActionCommand().equals("INFO")) {
/* 71 */       new FormeInformationSite(this.frm, true).setVisible(true);
/*    */     }
/* 73 */     else if (e.getActionCommand().equals("DEV")) {
/* 74 */       new FormeNomDeveloppeur(this.frm, true).setVisible(true);
/*    */     }
/* 76 */     else if (e.getActionCommand().equals("NOTE")) {
/* 77 */       new FormeText(this.frm, true, this.frm.getProjetSel().getFormeMCD().getPage().getConfigurationMCD(), false).setVisible(true);
/*    */     }
/* 79 */     else if (e.getActionCommand().equals("VER")) {
/* 80 */       new About(this.frm, true).setVisible(true);
/*    */     }
/*    */   }
/*    */   
/*    */   public Principale getFrm() {
/* 85 */     return this.frm;
/*    */   }
/*    */   
/*    */   public void setFrm(Principale frm) {
/* 89 */     this.frm = frm;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MenuPop\MenuPopInformation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */