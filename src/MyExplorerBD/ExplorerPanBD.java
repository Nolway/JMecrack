/*     */ package MyExplorerBD;
/*     */ 
/*     */ import composantSQL.Column;
/*     */ import composantSQL.MyDataBase;
/*     */ import composantSQL.Table;
/*     */ import ihm.FormeInterneRetro;
/*     */ import ihm.Principale;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.TreeSelectionModel;
/*     */ 
/*     */ 
/*     */ public class ExplorerPanBD
/*     */   extends JPanel
/*     */ {
/*     */   private Principale frm;
/*     */   private JTree tree;
/*     */   private DefaultMutableTreeNode racine;
/*     */   private JScrollPane jScrollPane1;
/*     */   
/*     */   public ExplorerPanBD(Principale frm)
/*     */   {
/*  33 */     initComponents();
/*  34 */     this.frm = frm;
/*     */     
/*  36 */     this.racine = new DefaultMutableTreeNode("Base De Données");
/*  37 */     this.tree = new JTree(this.racine);
/*  38 */     this.tree.setRootVisible(true);
/*  39 */     this.tree.setFont(new Font("Arial", 0, 12));
/*     */     
/*  41 */     this.tree.setCellRenderer(new MyRenderBD());
/*  42 */     this.tree.getSelectionModel().setSelectionMode(1);
/*     */     
/*     */ 
/*     */ 
/*  46 */     this.jScrollPane1.setViewportView(this.tree);
/*     */     
/*  48 */     this.tree.addMouseListener(new MouseListener()
/*     */     {
/*     */       public void mouseClicked(MouseEvent e) {
/*  51 */         if ((ExplorerPanBD.this.tree.getLastSelectedPathComponent() instanceof NodeTable)) {
/*  52 */           ExplorerPanBD.this.getFrm().getFormeRetro().afficherListeAttribut(((NodeTable)ExplorerPanBD.this.tree.getLastSelectedPathComponent()).getTable());
/*  53 */           ExplorerPanBD.this.getFrm().getFormeRetro().getjCBTable().setSelectedItem(((NodeTable)ExplorerPanBD.this.tree.getLastSelectedPathComponent()).getTable());
/*  54 */           ExplorerPanBD.this.getFrm().getFormeRetro().getjCBTable().setSelectedItem((NodeTable)ExplorerPanBD.this.tree.getLastSelectedPathComponent());
/*     */         }
/*  56 */         if ((ExplorerPanBD.this.tree.getLastSelectedPathComponent() instanceof NodeColumn)) {
/*  57 */           NodeTable nt = (NodeTable)((DefaultMutableTreeNode)ExplorerPanBD.this.tree.getLastSelectedPathComponent()).getParent();
/*  58 */           ExplorerPanBD.this.getFrm().getFormeRetro().afficherColonne(((NodeColumn)ExplorerPanBD.this.tree.getLastSelectedPathComponent()).getColumn());
/*  59 */           ExplorerPanBD.this.getFrm().getFormeRetro().getjCBTable().setSelectedItem(nt.getTable());
/*     */         }
/*     */       }
/*     */       
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
/*     */ 
/*     */       public void mouseExited(MouseEvent e) {}
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void ajouterBase(MyDataBase db)
/*     */   {
/*  86 */     for (int i = 0; i < db.getTableList().size(); i++) {
/*  87 */       NodeTable t = new NodeTable((Table)db.getTableList().get(i));
/*     */       
/*  89 */       for (int j = 0; j < ((Table)db.getTableList().get(i)).getColumnList().size(); j++) {
/*  90 */         NodeColumn c = new NodeColumn((Column)((Table)db.getTableList().get(i)).getColumnList().get(j));
/*  91 */         t.add(c);
/*     */       }
/*     */       
/*  94 */       this.racine.add(t);
/*     */     }
/*  96 */     if (db.getTableList().size() > 0) this.tree.expandRow(0);
/*  97 */     this.tree.updateUI();
/*     */   }
/*     */   
/*     */   public Principale getFrm()
/*     */   {
/* 102 */     return this.frm;
/*     */   }
/*     */   
/*     */   public void supprimerTout() {
/* 106 */     this.racine.removeAllChildren();
/* 107 */     this.tree.updateUI();
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
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 121 */     this.jScrollPane1 = new JScrollPane();
/*     */     
/* 123 */     GroupLayout layout = new GroupLayout(this);
/* 124 */     setLayout(layout);
/* 125 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 172, 32767));
/*     */     
/*     */ 
/*     */ 
/* 129 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 393, 32767));
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorerBD\ExplorerPanBD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */