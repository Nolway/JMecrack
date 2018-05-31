/*     */ package ihm;
/*     */ 
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmProjet;
/*     */ import IhmMLD.IhmPageMLD;
/*     */ import MyExplorer.NodeRootXML;
/*     */ import MyXMLEditor.JTextEditorPan;
/*     */ import MyXMLEditor.MyXMLTextPane;
/*     */ import Output.DTDScript;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Container;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.event.InternalFrameEvent;
/*     */ import javax.swing.event.InternalFrameListener;
/*     */ 
/*     */ 
/*     */ public class FormeInterneXML
/*     */   extends FormeInterneMerise
/*     */ {
/*     */   private JTextEditorPan panelxml;
/*     */   private DTDScript xmlString;
/*     */   private NodeRootXML racineXML;
/*     */   private IhmProjet projet;
/*     */   
/*     */   public FormeInterneXML(Principale formePrincipale, IhmProjet projet)
/*     */   {
/*  27 */     super(formePrincipale);
/*  28 */     setTitle("DTD et XML");
/*  29 */     this.panelxml = new JTextEditorPan();
/*  30 */     this.panelxml.getPane().setText("");
/*  31 */     this.projet = projet;
/*     */     
/*  33 */     setFrameIcon(new ImageIcon(getClass().getResource("/Images/xml.png")));
/*  34 */     getContentPane().setLayout(new BorderLayout());
/*  35 */     getContentPane().add(this.panelxml, "Center");
/*  36 */     this.xmlString = new DTDScript(formePrincipale.getFormeMLD().getPageMld().getListeMLDEntite(), formePrincipale.getFormeMCD().getPage().getListeEntiteRelation());
/*  37 */     this.panelxml.setFrmPrincipale(formePrincipale);
/*  38 */     this.racineXML = new NodeRootXML(this);
/*  39 */     addInternalFrameListener(new InternalFrameListener()
/*     */     {
/*     */       public void internalFrameOpened(InternalFrameEvent e) {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void internalFrameClosing(InternalFrameEvent e) {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void internalFrameClosed(InternalFrameEvent e) {}
/*     */       
/*     */ 
/*     */       public void internalFrameIconified(InternalFrameEvent e)
/*     */       {
/*  54 */         FormeInterneXML.this.setFrameIcon(new ImageIcon(getClass().getResource("/Images/xml.png")));
/*     */       }
/*     */       
/*     */       public void internalFrameDeiconified(InternalFrameEvent e) {
/*  58 */         FormeInterneXML.this.setFrameIcon(new ImageIcon(getClass().getResource("/Images/xml.png")));
/*     */       }
/*     */       
/*     */       public void internalFrameActivated(InternalFrameEvent e) {
/*  62 */         FormeInterneXML.this.getFormePrincipale().setProjetMain(FormeInterneXML.this.getProjet());
/*  63 */         FormeInterneXML.this.toFront();
/*  64 */         FormeInterneXML.this.setTitle("DTD et XML : " + FormeInterneXML.this.getProjet().toString());
/*     */       }
/*     */       
/*     */ 
/*     */       public void internalFrameDeactivated(InternalFrameEvent e) {}
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   public JTextEditorPan getPanelXML()
/*     */   {
/*  75 */     return this.panelxml;
/*     */   }
/*     */   
/*     */   public DTDScript getXmlString() {
/*  79 */     return this.xmlString;
/*     */   }
/*     */   
/*     */   public void setPanelxml(JTextEditorPan panelxml) {
/*  83 */     this.panelxml = panelxml;
/*     */   }
/*     */   
/*     */   public void setXmlString(DTDScript xmlString) {
/*  87 */     this.xmlString = xmlString;
/*     */   }
/*     */   
/*     */   public NodeRootXML getRacineXML() {
/*  91 */     return this.racineXML;
/*     */   }
/*     */   
/*     */   public JTextEditorPan getPanelxml() {
/*  95 */     return this.panelxml;
/*     */   }
/*     */   
/*     */   public IhmProjet getProjet() {
/*  99 */     return this.projet;
/*     */   }
/*     */   
/*     */   public void setProjet(IhmProjet projet) {
/* 103 */     this.projet = projet;
/*     */   }
/*     */   
/*     */   public void setRacineXML(NodeRootXML racineXML) {
/* 107 */     this.racineXML = racineXML;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\ihm\FormeInterneXML.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */