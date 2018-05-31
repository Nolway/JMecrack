/*    */ package mythread;
/*    */ 
/*    */ import MyXMLEditor.JTextEditorPan;
/*    */ import MyXMLEditor.MyXMLTextPane;
/*    */ import Output.XMLScript;
/*    */ import formes.FormeConstruction;
/*    */ import ihm.FormeInterneXML;
/*    */ import ihm.Principale;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JProgressBar;
/*    */ import javax.swing.SwingWorker;
/*    */ 
/*    */ 
/*    */ public class ThreadGenererXML
/*    */   extends SwingWorker
/*    */ {
/*    */   private Principale frm;
/*    */   
/*    */   public ThreadGenererXML(Principale frm)
/*    */   {
/* 21 */     this.frm = frm;
/*    */   }
/*    */   
/*    */   protected Object doInBackground() throws Exception
/*    */   {
/* 26 */     String s = " ";
/* 27 */     FormeConstruction frmCons = new FormeConstruction(this.frm, true);
/* 28 */     frmCons.setModal(false);
/* 29 */     frmCons.getjLabNom().setText("Génération du script XML");
/* 30 */     frmCons.setVisible(true);
/* 31 */     s = XMLScript.getXmlOfWork(this.frm.getPage(), frmCons);
/* 32 */     this.frm.getFormeXML().getPanelXML().getPane().setText(s);
/* 33 */     frmCons.getjProgBar().setValue(100);
/* 34 */     frmCons.dispose();
/*    */     
/* 36 */     return Integer.valueOf(1);
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadGenererXML.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */