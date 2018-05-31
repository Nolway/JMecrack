/*     */ package ihm;
/*     */ 
/*     */ import IhmMCD.BarOutil;
/*     */ import IhmMCD.IhmProjet;
/*     */ import IhmMLD.IhmPageMLD;
/*     */ import IhmMLD2.MLDEntite2;
/*     */ import MyExplorer.NodeRootMLD;
/*     */ import formes.PanelLoupe;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Container;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.event.InternalFrameEvent;
/*     */ import javax.swing.event.InternalFrameListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormeInterneMLD
/*     */   extends FormeInterneMerise
/*     */ {
/*     */   public IhmPageMLD pageMld;
/*     */   private NodeRootMLD racineMLD;
/*     */   private Principale frm;
/*     */   private IhmProjet projet;
/*  30 */   public double zoom = 1.0D;
/*  31 */   public boolean isOmbree2 = false;
/*  32 */   public boolean isDegradee2 = false;
/*  33 */   public boolean afficheType2 = true;
/*  34 */   public boolean arrondirEntite2 = true;
/*     */   
/*     */   public FormeInterneMLD(Principale formePrincipale, IhmPageMLD pageMld, IhmProjet projet) {
/*  37 */     super(formePrincipale);
/*  38 */     this.frm = formePrincipale;
/*  39 */     this.pageMld = pageMld;
/*  40 */     this.racineMLD = new NodeRootMLD(this);
/*  41 */     this.projet = projet;
/*  42 */     if (this.pageMld == null) {
/*  43 */       this.pageMld = new IhmPageMLD(this, new ArrayList(), new ArrayList(), new ArrayList(), formePrincipale);
/*     */     }
/*     */     
/*     */ 
/*  47 */     setTitle("MLD");
/*  48 */     setFrameIcon(new ImageIcon(getClass().getResource("/Images/mld16.png")));
/*     */     
/*  50 */     this.pageMld.setAutoscrolls(true);
/*     */     
/*  52 */     JScrollPane sc = new JScrollPane();
/*  53 */     sc.setViewportView(this.pageMld);
/*     */     
/*  55 */     getContentPane().setLayout(new BorderLayout());
/*  56 */     getContentPane().add(sc, "Center");
/*     */     
/*  58 */     addInternalFrameListener(new InternalFrameListener()
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
/*  73 */         FormeInterneMLD.this.setFrameIcon(new ImageIcon(getClass().getResource("/Images/mldG.png")));
/*     */       }
/*     */       
/*     */       public void internalFrameDeiconified(InternalFrameEvent e) {
/*  77 */         FormeInterneMLD.this.setFrameIcon(new ImageIcon(getClass().getResource("/Images/mld16.png")));
/*     */       }
/*     */       
/*     */       public void internalFrameActivated(InternalFrameEvent e) {
/*  81 */         FormeInterneMLD.this.getFormePrincipale().setProjetMain(FormeInterneMLD.this.getProjet());
/*  82 */         FormeInterneMLD.this.toFront();
/*  83 */         FormeInterneMLD.this.setTitle("MLD : " + FormeInterneMLD.this.getProjet().toString());
/*  84 */         FormeInterneMLD.this.getFrm().getPanelLoupe().setFrmInterne(FormeInterneMLD.this.getFormeMLD());
/*     */         
/*  86 */         FormeInterneMLD.this.frm.setMenuDegradeeOmbreTypeArrondir(FormeInterneMLD.this.isDegradee2, FormeInterneMLD.this.afficheType2, FormeInterneMLD.this.isOmbree2, FormeInterneMLD.this.arrondirEntite2);
/*  87 */         FormeInterneMLD.this.frm.getBar().setZoomPage(FormeInterneMLD.this.getPageMld().getZoom());
/*  88 */         System.gc();
/*     */       }
/*     */       
/*     */ 
/*     */       public void internalFrameDeactivated(InternalFrameEvent e) {}
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   public IhmPageMLD getPageMld()
/*     */   {
/*  99 */     return this.pageMld;
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
/*     */   public String toString()
/*     */   {
/* 112 */     return getTitle();
/*     */   }
/*     */   
/* 115 */   public FormeInterneMLD getFormeMLD() { return this; }
/*     */   
/*     */   public NodeRootMLD getRacineMLD() {
/* 118 */     return this.racineMLD;
/*     */   }
/*     */   
/*     */   public Principale getFrm() {
/* 122 */     return this.frm;
/*     */   }
/*     */   
/*     */   public IhmProjet getProjet() {
/* 126 */     return this.projet;
/*     */   }
/*     */   
/*     */   public void setFrm(Principale frm) {
/* 130 */     this.frm = frm;
/*     */   }
/*     */   
/*     */   public void setProjet(IhmProjet projet) {
/* 134 */     this.projet = projet;
/*     */   }
/*     */   
/*     */   public void setRacineMLD(NodeRootMLD racineMLD) {
/* 138 */     this.racineMLD = racineMLD;
/*     */   }
/*     */   
/*     */   public void modifierParametreMLD(boolean isOmbre, boolean istype, boolean isDegradee, boolean isArrondi) {
/* 142 */     this.isOmbree2 = isOmbre;
/* 143 */     this.isDegradee2 = isDegradee;
/* 144 */     this.afficheType2 = istype;
/* 145 */     this.arrondirEntite2 = isArrondi;
/* 146 */     this.frm.getFormeMCD().setModifier(true);
/* 147 */     for (int i = 0; i < this.pageMld.getListeMLDEntite().size(); i++) {
/* 148 */       ((MLDEntite2)this.pageMld.getListeMLDEntite().get(i)).setVariable(istype);
/* 149 */       ((MLDEntite2)this.pageMld.getListeMLDEntite().get(i)).setOmbre(isOmbre);
/* 150 */       ((MLDEntite2)this.pageMld.getListeMLDEntite().get(i)).setClDegradee(isDegradee);
/* 151 */       ((MLDEntite2)this.pageMld.getListeMLDEntite().get(i)).setArrondir(isArrondi);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\ihm\FormeInterneMLD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */