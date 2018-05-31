/*     */ package formes2;
/*     */ 
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import Merise.Attribut;
/*     */ import Merise2.Attribut2;
/*     */ import ihm.Principale;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class FormeUtilisationAttribut extends javax.swing.JDialog
/*     */ {
/*     */   Principale frm;
/*     */   IhmPageMCD page;
/*     */   Attribut2 attribut;
/*     */   ArrayList<IhmMCD.IhmEntiteRelation> listeEntiteRelation;
/*     */   private JButton jBtAnnuler;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private javax.swing.JList jListEntRel;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private JTextField jTFNom;
/*     */   private JTextField jTFType;
/*     */   
/*     */   public FormeUtilisationAttribut(Principale parent, IhmPageMCD page, Attribut2 attribut, boolean modal)
/*     */   {
/*  37 */     super(parent, modal);
/*  38 */     initComponents();
/*  39 */     this.frm = parent;
/*  40 */     this.page = page;
/*  41 */     this.attribut = attribut;
/*  42 */     this.listeEntiteRelation = new ArrayList();
/*  43 */     setLocation(this.frm.getX() + 250, this.frm.getY() + 90);
/*  44 */     initData();
/*  45 */     this.jBtAnnuler.setMnemonic(65);
/*     */   }
/*     */   
/*     */   private boolean isUsed(Attribut2 att, ArrayList<Attribut> liste) {
/*  49 */     String n = att.getNom().trim().toUpperCase();
/*  50 */     String t = att.getType();
/*  51 */     for (int i = 0; i < liste.size(); i++) {
/*  52 */       if ((n.equals(((Attribut)liste.get(i)).getNom().trim().toUpperCase())) && (t.equals(((Attribut)liste.get(i)).getType()))) {
/*  53 */         return true;
/*     */       }
/*     */     }
/*  56 */     return false;
/*     */   }
/*     */   
/*     */   private void getListeEntRel()
/*     */   {
/*  61 */     this.listeEntiteRelation.clear();
/*  62 */     ArrayList<IhmMCD.IhmEntiteRelation> listeER = this.page.getListeEntiteRelation();
/*  63 */     for (int i = 0; i < listeER.size(); i++) {
/*  64 */       if (((listeER.get(i) instanceof IhmEntite2)) && 
/*  65 */         (isUsed(this.attribut, ((IhmEntite2)listeER.get(i)).getEntite().getListeAttributs()))) {
/*  66 */         this.listeEntiteRelation.add(listeER.get(i));
/*     */       }
/*     */       
/*  69 */       if (((listeER.get(i) instanceof IhmRelation2)) && 
/*  70 */         (isUsed(this.attribut, ((IhmRelation2)listeER.get(i)).getRelation().getListeAttributs()))) {
/*  71 */         this.listeEntiteRelation.add(listeER.get(i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void initData()
/*     */   {
/*  78 */     this.jTFNom.setText(this.attribut.getNom());
/*  79 */     this.jTFType.setText(this.attribut.getType());
/*  80 */     getListeEntRel();
/*  81 */     this.jListEntRel.setListData(this.listeEntiteRelation.toArray());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  99 */     this.jPanel1 = new javax.swing.JPanel();
/* 100 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 101 */     this.jListEntRel = new javax.swing.JList();
/* 102 */     this.jLabel3 = new JLabel();
/* 103 */     this.jLabel1 = new JLabel();
/* 104 */     this.jTFNom = new JTextField();
/* 105 */     this.jLabel2 = new JLabel();
/* 106 */     this.jTFType = new JTextField();
/* 107 */     this.jBtAnnuler = new JButton();
/*     */     
/* 109 */     setDefaultCloseOperation(2);
/* 110 */     setTitle("Les entités ou les relations qui utilisent cet attribut ");
/*     */     
/* 112 */     this.jScrollPane1.setViewportView(this.jListEntRel);
/*     */     
/* 114 */     this.jLabel3.setText("Utilisé par ");
/*     */     
/* 116 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 117 */     this.jPanel1.setLayout(jPanel1Layout);
/* 118 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 632, 32767).addComponent(this.jLabel3)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 127 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3).addGap(11, 11, 11).addComponent(this.jScrollPane1, -1, 231, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 136 */     this.jLabel1.setText("Nom Attribut ");
/*     */     
/* 138 */     this.jTFNom.setEditable(false);
/*     */     
/* 140 */     this.jLabel2.setText("Type");
/*     */     
/* 142 */     this.jTFType.setEditable(false);
/*     */     
/* 144 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 145 */     this.jBtAnnuler.setText("Fermer");
/* 146 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 148 */         FormeUtilisationAttribut.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 151 */     });
/* 152 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 153 */     getContentPane().setLayout(layout);
/* 154 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jTFNom, -2, 258, -2).addGap(39, 39, 39).addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jTFType, -1, 231, 32767))).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 102, -2).addGap(20, 20, 20)))));
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
/* 175 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFNom, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.jTFType, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jPanel1, -1, -1, 32767).addGap(11, 11, 11).addComponent(this.jBtAnnuler).addContainerGap()));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 191 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(ActionEvent evt) {
/* 195 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeUtilisationAttribut.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */