/*     */ package MyExplorer;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmProjet;
/*     */ import IhmMCD.IhmRelation;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import IhmMLD.IhmPageMLD;
/*     */ import IhmMLD2.MLDEntite2;
/*     */ import MenuPop.MenuPopTree;
/*     */ import formes2.FormeEntite2;
/*     */ import formes2.FormeMLDEntite2;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.FormeInterneMLD;
/*     */ import ihm.FormeInterneSQL;
/*     */ import ihm.FormeInterneXML;
/*     */ import ihm.Principale;
/*     */ import java.awt.Font;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.beans.PropertyVetoException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.TreeNode;
/*     */ import javax.swing.tree.TreeSelectionModel;
/*     */ 
/*     */ public class ExplorerPan extends JPanel
/*     */ {
/*     */   private JTree tree;
/*     */   public DefaultMutableTreeNode racineArbre;
/*     */   private Principale frm;
/*     */   private MenuPopTree menu;
/*     */   private JScrollPane jScrollPane1;
/*     */   
/*     */   public ExplorerPan(Principale frm)
/*     */   {
/*  48 */     initComponents();
/*  49 */     this.frm = frm;
/*  50 */     this.racineArbre = new DefaultMutableTreeNode("JMerise");
/*     */     
/*  52 */     this.menu = new MenuPopTree(frm);
/*  53 */     this.tree = new JTree(this.racineArbre);
/*  54 */     this.tree.setRootVisible(true);
/*  55 */     this.tree.setFont(new Font("Arial", 1, 12));
/*  56 */     add(this.menu);
/*  57 */     this.tree.setCellRenderer(new MyRenderer());
/*  58 */     this.tree.getSelectionModel().setSelectionMode(1);
/*     */     
/*     */ 
/*     */ 
/*  62 */     this.jScrollPane1.setViewportView(this.tree);
/*  63 */     this.jScrollPane1.setVisible(true);
/*  64 */     this.tree.setVisible(true);
/*  65 */     this.tree.addMouseListener(new MouseListener()
/*     */     {
/*     */       public void mouseClicked(MouseEvent e) {
/*  68 */         if (e.getButton() == 1) {
/*  69 */           if ((e.getClickCount() == 1) && 
/*  70 */             (ExplorerPan.this.tree.getLastSelectedPathComponent() != null)) {
/*  71 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeEntite)) {
/*  72 */               ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().setSelected(false);
/*  73 */               ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().repaint();
/*  74 */               ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().setVisible(true);
/*     */               try {
/*  76 */                 ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().setIcon(false);
/*  77 */                 ExplorerPan.this.getFrm().setProjetMain(((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getProjet());
/*     */               } catch (PropertyVetoException ex) {
/*  79 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/*  81 */               ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().toFront();
/*  82 */               NodeEntite ent = (NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent();
/*  83 */               ent.getEntite().setSelected(true);
/*     */               
/*  85 */               ExplorerPan.this.getFrm().getPage().desactiverAllLien();
/*  86 */               ExplorerPan.this.getFrm().getPage().activerAllLien(ent.getEntite());
/*  87 */               double zoom = ExplorerPan.this.getFrm().getPage().getZoom();
/*  88 */               ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().repaint();
/*  89 */               ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().scrollRectToVisible(new Rectangle((int)(zoom * (ent.getEntite().getX() - 10)), (int)(zoom * (ent.getEntite().getY() - 10)), (int)(zoom * (ent.getEntite().getWidth() + 20)), (int)(zoom * (ent.getEntite().getHeight() + 20))));
/*     */             }
/*     */             
/*  92 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeRelation)) {
/*  93 */               ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().setSelected(false);
/*  94 */               ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().repaint();
/*  95 */               ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().setVisible(true);
/*     */               try {
/*  97 */                 ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().setIcon(false);
/*  98 */                 ExplorerPan.this.getFrm().setProjetMain(((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getProjet());
/*     */               } catch (PropertyVetoException ex) {
/* 100 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 102 */               ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().toFront();
/* 103 */               NodeRelation rel = (NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent();
/* 104 */               rel.getRelation().setSelected(true);
/*     */               
/* 106 */               ExplorerPan.this.getFrm().getPage().desactiverAllLien();
/* 107 */               ExplorerPan.this.getFrm().getPage().activerAllLien(rel.getRelation());
/* 108 */               double zoom = ExplorerPan.this.getFrm().getPage().getZoom();
/* 109 */               ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().repaint();
/* 110 */               ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().scrollRectToVisible(new Rectangle((int)(zoom * (rel.getRelation().getX() - 10)), (int)(zoom * (rel.getRelation().getY() - 10)), (int)(zoom * (rel.getRelation().getWidth() + 20)), (int)(zoom * (rel.getRelation().getHeight() + 20))));
/*     */             }
/*     */             
/* 113 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeEntiteMLD)) {
/* 114 */               ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().setVisible(true);
/*     */               try {
/* 116 */                 ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().setIcon(false);
/* 117 */                 ExplorerPan.this.getFrm().setProjetMain(((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().getProjet());
/*     */               } catch (PropertyVetoException ex) {
/* 119 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 121 */               ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().toFront();
/* 122 */               ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().getPageMld().setSelected(false);
/* 123 */               ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().toFront();
/* 124 */               NodeEntiteMLD rel = (NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent();
/* 125 */               rel.getEntiteMLD().setSelected(true);
/* 126 */               ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().getPageMld().repaint();
/* 127 */               ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().getPageMld().scrollRectToVisible(new Rectangle(rel.getEntiteMLD().getX() - 10, rel.getEntiteMLD().getY() - 10, rel.getEntiteMLD().getWidth() + 20, rel.getEntiteMLD().getHeight() + 20));
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 132 */           if (e.getClickCount() == 2) {
/* 133 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeEntite)) {
/* 134 */               ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().setVisible(true);
/*     */               try {
/* 136 */                 ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().setIcon(false);
/* 137 */                 ExplorerPan.this.getFrm().setProjetMain(((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getProjet());
/*     */               } catch (PropertyVetoException ex) {
/* 139 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 141 */               ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().toFront();
/*     */               
/* 143 */               NodeEntite ent = (NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent();
/* 144 */               ent.getEntite().setSelected(true);
/* 145 */               double zoom = ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().getZoom();
/* 146 */               ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().repaint();
/* 147 */               ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().scrollRectToVisible(new Rectangle((int)(zoom * (ent.getEntite().getX() - 10)), (int)(zoom * (ent.getEntite().getY() - 10)), (int)(zoom * (ent.getEntite().getWidth() + 20)), (int)(zoom * (ent.getEntite().getHeight() + 20))));
/* 148 */               new FormeEntite2(ExplorerPan.this.getFrm(), true, (IhmEntite2)ent.getEntite(), ((NodeRootMCD)((NodeEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().getListeEntiteRelation()).setVisible(true);
/*     */             }
/*     */             
/* 151 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeRelation)) {
/* 152 */               ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().setVisible(true);
/*     */               try {
/* 154 */                 ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().setIcon(false);
/* 155 */                 ExplorerPan.this.getFrm().setProjetMain(((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getProjet());
/*     */               } catch (PropertyVetoException ex) {
/* 157 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 159 */               ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().toFront();
/*     */               
/* 161 */               NodeRelation rel = (NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent();
/* 162 */               rel.getRelation().setSelected(true);
/* 163 */               double zoom = ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().getZoom();
/* 164 */               ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().repaint();
/* 165 */               ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().scrollRectToVisible(new Rectangle((int)(zoom * (rel.getRelation().getX() - 10)), (int)(zoom * (rel.getRelation().getY() - 10)), (int)(zoom * (rel.getRelation().getWidth() + 20)), (int)(zoom * (rel.getRelation().getHeight() + 20))));
/*     */               
/* 167 */               new FormeEntite2(ExplorerPan.this.getFrm(), true, (IhmRelation2)rel.getRelation(), ((NodeRootMCD)((NodeRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getFormeMCD().getPage().getListeEntiteRelation()).setVisible(true);
/*     */             }
/*     */             
/* 170 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeEntiteMLD)) {
/* 171 */               ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().setVisible(true);
/*     */               try {
/* 173 */                 ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().setIcon(false);
/* 174 */                 ExplorerPan.this.getFrm().setProjetMain(((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet());
/*     */               } catch (PropertyVetoException ex) {
/* 176 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 178 */               ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().toFront();
/* 179 */               ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().getPageMld().setSelected(false);
/* 180 */               ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().getPageMld().repaint();
/* 181 */               NodeEntiteMLD rel = (NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent();
/* 182 */               rel.getEntiteMLD().setSelected(true);
/* 183 */               new FormeMLDEntite2(ExplorerPan.this.getFrm(), ((NodeProjet)((NodeEntiteMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent().getParent()).getProjet().getFormeMLD().getPageMld(), rel.getEntiteMLD(), true).setVisible(true);
/*     */             }
/*     */             
/*     */ 
/* 187 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeRootMCD)) {
/* 188 */               ((NodeProjet)((NodeRootMCD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet().getFormeMCD().setVisible(true);
/*     */               try
/*     */               {
/* 191 */                 ExplorerPan.this.getFrm().getFormeMCD().setIcon(false);
/*     */               } catch (PropertyVetoException ex) {
/* 193 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 195 */               ((NodeProjet)((NodeRootMCD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet().getFormeMCD().toFront();
/* 196 */               ExplorerPan.this.getFrm().setProjetMain(((NodeProjet)((NodeRootMCD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet());
/*     */             }
/*     */             
/* 199 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeRootSql)) {
/* 200 */               ((NodeProjet)((NodeRootSql)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet().getFormeSQL().setVisible(true);
/*     */               try {
/* 202 */                 ((NodeProjet)((NodeRootSql)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet().getFormeSQL().setIcon(false);
/*     */               } catch (PropertyVetoException ex) {
/* 204 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 206 */               ((NodeProjet)((NodeRootSql)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet().getFormeSQL().toFront();
/* 207 */               ExplorerPan.this.getFrm().setProjetMain(((NodeProjet)((NodeRootSql)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet());
/*     */             }
/* 209 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeRootMLD)) {
/* 210 */               ((NodeProjet)((NodeRootMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet().getFormeMLD().setVisible(true);
/*     */               try {
/* 212 */                 ((NodeProjet)((NodeRootMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet().getFormeMLD().setIcon(false);
/*     */               } catch (PropertyVetoException ex) {
/* 214 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 216 */               ((NodeProjet)((NodeRootMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet().getFormeMLD().toFront();
/* 217 */               ExplorerPan.this.getFrm().setProjetMain(((NodeProjet)((NodeRootMLD)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet());
/*     */             }
/*     */             
/* 220 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeRootXML)) {
/* 221 */               ((NodeProjet)((NodeRootXML)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet().getFormeXML().setVisible(true);
/*     */               try {
/* 223 */                 ((NodeProjet)((NodeRootXML)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet().getFormeXML().setIcon(false);
/*     */               } catch (PropertyVetoException ex) {
/* 225 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 227 */               ((NodeProjet)((NodeRootXML)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet().getFormeXML().toFront();
/* 228 */               ExplorerPan.this.getFrm().setProjetMain(((NodeProjet)((NodeRootXML)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getProjet());
/*     */             }
/*     */             
/* 231 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeProjet)) {
/* 232 */               ExplorerPan.this.getFrm().setProjetMain(((NodeProjet)ExplorerPan.this.tree.getLastSelectedPathComponent()).getProjet());
/* 233 */               ((NodeProjet)ExplorerPan.this.tree.getLastSelectedPathComponent()).getProjet().getFormeMCD().setVisible(true);
/*     */               try
/*     */               {
/* 236 */                 ExplorerPan.this.getFrm().getFormeMCD().setIcon(false);
/*     */               } catch (PropertyVetoException ex) {
/* 238 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 240 */               ((NodeProjet)ExplorerPan.this.tree.getLastSelectedPathComponent()).getProjet().getFormeMCD().toFront();
/*     */             }
/*     */             
/* 243 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeRootEntite)) {
/* 244 */               ((NodeProjet)((NodeRootMCD)((NodeRootEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getParent()).getProjet().getFormeMCD().setVisible(true);
/*     */               try {
/* 246 */                 ((NodeProjet)((NodeRootMCD)((NodeRootEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getParent()).getProjet().getFormeMCD().setIcon(false);
/*     */               }
/*     */               catch (PropertyVetoException ex) {
/* 249 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 251 */               ((NodeProjet)((NodeRootMCD)((NodeRootEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getParent()).getProjet().getFormeMCD().toFront();
/* 252 */               ExplorerPan.this.getFrm().setProjetMain(((NodeProjet)((NodeRootMCD)((NodeRootEntite)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getParent()).getProjet());
/*     */             }
/*     */             
/* 255 */             if ((ExplorerPan.this.tree.getLastSelectedPathComponent() instanceof NodeRootRelation)) {
/* 256 */               ((NodeProjet)((NodeRootMCD)((NodeRootRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getParent()).getProjet().getFormeMCD().setVisible(true);
/*     */               try {
/* 258 */                 ((NodeProjet)((NodeRootMCD)((NodeRootRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getParent()).getProjet().getFormeMCD().setIcon(false);
/*     */               }
/*     */               catch (PropertyVetoException ex) {
/* 261 */                 Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 263 */               ((NodeProjet)((NodeRootMCD)((NodeRootRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getParent()).getProjet().getFormeMCD().toFront();
/* 264 */               ExplorerPan.this.getFrm().setProjetMain(((NodeProjet)((NodeRootMCD)((NodeRootRelation)ExplorerPan.this.tree.getLastSelectedPathComponent()).getParent()).getParent()).getProjet());
/*     */             }
/*     */           }
/*     */         }
/*     */         else {
/* 269 */           ExplorerPan.this.menu.setNomProjet(ExplorerPan.this.getFrm().getProjetSel().toString());
/* 270 */           ExplorerPan.this.menu.show(ExplorerPan.this.getFrm().getExplorer(), e.getX(), e.getY());
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void mousePressed(MouseEvent e) {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void mouseReleased(MouseEvent e) {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void mouseEntered(MouseEvent e) {}
/*     */       
/*     */ 
/*     */       public void mouseExited(MouseEvent e) {}
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   public final Principale getFrm()
/*     */   {
/* 294 */     return this.frm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public JTree getTree()
/*     */   {
/* 302 */     return this.tree;
/*     */   }
/*     */   
/*     */   public DefaultMutableTreeNode getRacineArbre() {
/* 306 */     return this.racineArbre;
/*     */   }
/*     */   
/*     */   public void ajouterNode(IhmEntite ent, NodeRootEntite entitNod) {
/* 310 */     NodeEntite nod = new NodeEntite(ent);
/* 311 */     entitNod.add(nod);
/*     */   }
/*     */   
/*     */   public void ajouterNode(IhmRelation rel, NodeRootRelation relNod)
/*     */   {
/* 316 */     NodeRelation nod = new NodeRelation(rel);
/* 317 */     relNod.add(nod);
/*     */   }
/*     */   
/*     */   public void ajouterNode(MLDEntite2 ent, NodeRootMLD racinMLD)
/*     */   {
/* 322 */     NodeEntiteMLD nod = new NodeEntiteMLD(ent);
/* 323 */     racinMLD.add(nod);
/*     */   }
/*     */   
/*     */   public void supprimerNode(IhmRelation rel, NodeRootRelation relNod)
/*     */   {
/* 328 */     for (int i = 0; i < relNod.getChildCount(); i++) {
/* 329 */       if (((NodeRelation)relNod.getChildAt(i)).getRelation() == rel) {
/* 330 */         relNod.remove(i);
/* 331 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void supprimerNode(IhmEntite ent, NodeRootEntite entitNod)
/*     */   {
/* 338 */     for (int i = 0; i < entitNod.getChildCount(); i++) {
/* 339 */       if (((NodeEntite)entitNod.getChildAt(i)).getEntite() == ent) {
/* 340 */         entitNod.remove(i);
/* 341 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void supprimerNode(MLDEntite2 ent, NodeRootMLD racinMLD)
/*     */   {
/* 348 */     for (int i = 0; i < racinMLD.getChildCount(); i++) {
/* 349 */       if (((NodeEntiteMLD)racinMLD.getChildAt(i)).getEntiteMLD() == ent) {
/* 350 */         racinMLD.remove(i);
/* 351 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void supprimerNode(IhmProjet pr)
/*     */   {
/* 358 */     for (int i = 0; i < this.racineArbre.getChildCount(); i++) {
/* 359 */       if (((NodeProjet)this.racineArbre.getChildAt(i)).getProjet() == pr) {
/* 360 */         this.racineArbre.remove(i);
/* 361 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void initialiserTree()
/*     */   {
/* 368 */     getFrm().getFormeMCD().getEntiteNode().removeAllChildren();
/* 369 */     getFrm().getFormeMCD().getRelationNode().removeAllChildren();
/* 370 */     getFrm().getFormeMLD().getRacineMLD().removeAllChildren();
/*     */     
/*     */ 
/* 373 */     if (getFrm().getFormeMCD().getPage().getListeEntiteRelation().size() == 0) return;
/* 374 */     for (int i = 0; i < getFrm().getFormeMCD().getPage().getListeEntiteRelation().size(); i++) {
/* 375 */       if (((IhmEntiteRelation)getFrm().getFormeMCD().getPage().getListeEntiteRelation().get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) {
/* 376 */         NodeEntite nodE = new NodeEntite((IhmEntite2)getFrm().getFormeMCD().getPage().getListeEntiteRelation().get(i));
/* 377 */         getFrm().getFormeMCD().getEntiteNode().add(nodE);
/*     */       } else {
/* 379 */         NodeRelation nodR = new NodeRelation((IhmRelation2)getFrm().getFormeMCD().getPage().getListeEntiteRelation().get(i));
/* 380 */         getFrm().getFormeMCD().getRelationNode().add(nodR);
/*     */       }
/*     */     }
/* 383 */     if (this.tree != null) {
/* 384 */       this.tree.updateUI();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void expandAll()
/*     */   {
/* 391 */     int row = 0;
/* 392 */     while (row < this.tree.getRowCount()) {
/* 393 */       this.tree.expandRow(row);
/* 394 */       row++;
/*     */     }
/*     */   }
/*     */   
/*     */   public void expandDernierNode() {
/* 399 */     int row = 0;
/* 400 */     while (row < this.tree.getRowCount())
/*     */     {
/* 402 */       row++;
/* 403 */       if (row == this.tree.getRowCount()) {
/* 404 */         this.tree.expandRow(row - 1);
/*     */       }
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
/*     */   private void initComponents()
/*     */   {
/* 419 */     this.jScrollPane1 = new JScrollPane();
/*     */     
/* 421 */     GroupLayout layout = new GroupLayout(this);
/* 422 */     setLayout(layout);
/* 423 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 243, 32767));
/*     */     
/*     */ 
/*     */ 
/* 427 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 407, 32767));
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorer\ExplorerPan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */