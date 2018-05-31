/*    */ package ihm;
/*    */ 
/*    */ import IhmMCD.IhmProjet;
/*    */ import MyExplorer.NodeRootSql;
/*    */ import MySqlEditor.JTextEditorPan;
/*    */ import MySqlEditor.MySqlTextPane;
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Container;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.event.InternalFrameEvent;
/*    */ import javax.swing.event.InternalFrameListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FormeInterneSQL
/*    */   extends FormeInterneMerise
/*    */ {
/*    */   private JTextEditorPan panelsql;
/*    */   private NodeRootSql racineSQL;
/*    */   private IhmProjet projet;
/*    */   
/*    */   public FormeInterneSQL(Principale formePrincipale, IhmProjet projet)
/*    */   {
/* 27 */     super(formePrincipale);
/* 28 */     setTitle("SQL");
/* 29 */     this.panelsql = new JTextEditorPan();
/* 30 */     this.panelsql.getPane().setText("");
/* 31 */     this.projet = projet;
/*    */     
/* 33 */     setFrameIcon(new ImageIcon(getClass().getResource("/Images/sql16.png")));
/* 34 */     getContentPane().setLayout(new BorderLayout());
/* 35 */     getContentPane().add(this.panelsql, "Center");
/*    */     
/* 37 */     this.panelsql.setFrmPrincipale(formePrincipale);
/* 38 */     this.racineSQL = new NodeRootSql(this);
/* 39 */     addInternalFrameListener(new InternalFrameListener()
/*    */     {
/*    */       public void internalFrameOpened(InternalFrameEvent e) {}
/*    */       
/*    */ 
/*    */ 
/*    */       public void internalFrameClosing(InternalFrameEvent e) {}
/*    */       
/*    */ 
/*    */ 
/*    */       public void internalFrameClosed(InternalFrameEvent e) {}
/*    */       
/*    */ 
/*    */       public void internalFrameIconified(InternalFrameEvent e)
/*    */       {
/* 54 */         FormeInterneSQL.this.setFrameIcon(new ImageIcon(getClass().getResource("/Images/sql16.png")));
/*    */       }
/*    */       
/*    */       public void internalFrameDeiconified(InternalFrameEvent e) {
/* 58 */         FormeInterneSQL.this.setFrameIcon(new ImageIcon(getClass().getResource("/Images/sql16.png")));
/*    */       }
/*    */       
/*    */       public void internalFrameActivated(InternalFrameEvent e) {
/* 62 */         FormeInterneSQL.this.getFormePrincipale().setProjetMain(FormeInterneSQL.this.getProjet());
/* 63 */         FormeInterneSQL.this.toFront();
/* 64 */         FormeInterneSQL.this.setTitle("SQL : " + FormeInterneSQL.this.getProjet().toString());
/*    */       }
/*    */       
/*    */ 
/*    */       public void internalFrameDeactivated(InternalFrameEvent e) {}
/*    */     });
/*    */   }
/*    */   
/*    */   public JTextEditorPan getPanelsql()
/*    */   {
/* 74 */     return this.panelsql;
/*    */   }
/*    */   
/*    */   public void setPanelsql(JTextEditorPan panelsql) {
/* 78 */     this.panelsql = panelsql;
/*    */   }
/*    */   
/*    */   public NodeRootSql getRacineNodeSQL() {
/* 82 */     return this.racineSQL;
/*    */   }
/*    */   
/*    */   public IhmProjet getProjet() {
/* 86 */     return this.projet;
/*    */   }
/*    */   
/*    */   public NodeRootSql getRacineSQL() {
/* 90 */     return this.racineSQL;
/*    */   }
/*    */   
/*    */   public void setProjet(IhmProjet projet) {
/* 94 */     this.projet = projet;
/*    */   }
/*    */   
/*    */   public void setRacineSQL(NodeRootSql racineSQL) {
/* 98 */     this.racineSQL = racineSQL;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\ihm\FormeInterneSQL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */