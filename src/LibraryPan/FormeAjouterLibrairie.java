/*     */ package LibraryPan;
/*     */ 
/*     */ import ihm.Principale;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class FormeAjouterLibrairie extends javax.swing.JDialog
/*     */ {
/*     */   Principale frm;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private JTextField jTFEmplacement;
/*     */   private JTextField jTFNom;
/*     */   
/*     */   public FormeAjouterLibrairie(Principale parent, boolean modal)
/*     */   {
/*  26 */     super(parent, modal);
/*  27 */     initComponents();
/*  28 */     this.frm = parent;
/*  29 */     setLocation(this.frm.getX() + 300, this.frm.getY() + 150);
/*  30 */     this.jTFEmplacement.setText(this.frm.getPanLibibrary().getPathLibraries());
/*     */   }
/*     */   
/*     */   private boolean existeDeja(String nom)
/*     */   {
/*  35 */     java.util.ArrayList<Library> liste = this.frm.getPanLibibrary().getLibList();
/*  36 */     for (int i = 0; i < liste.size(); i++) {
/*  37 */       if (((Library)liste.get(i)).getName().toUpperCase().equals(nom.toUpperCase())) {
/*  38 */         return true;
/*     */       }
/*     */     }
/*  41 */     return false;
/*     */   }
/*     */   
/*     */   private boolean existeDejaFile(String nom) {
/*  45 */     Library l = new Library("CC");
/*  46 */     if (l.existeLibFile(nom)) return true;
/*  47 */     return false;
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
/*  61 */     this.jPanel1 = new javax.swing.JPanel();
/*  62 */     this.jLabel1 = new JLabel();
/*  63 */     this.jLabel2 = new JLabel();
/*  64 */     this.jTFNom = new JTextField();
/*  65 */     this.jTFEmplacement = new JTextField();
/*  66 */     this.jButton1 = new JButton();
/*  67 */     this.jButton2 = new JButton();
/*     */     
/*  69 */     setDefaultCloseOperation(2);
/*  70 */     setTitle("Ajouter une nouvelle Librairie");
/*  71 */     setResizable(false);
/*     */     
/*  73 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  75 */     this.jLabel1.setText("Nom");
/*     */     
/*  77 */     this.jLabel2.setText("Emplacement ");
/*     */     
/*  79 */     this.jTFEmplacement.setEditable(false);
/*     */     
/*  81 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  82 */     this.jPanel1.setLayout(jPanel1Layout);
/*  83 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFEmplacement, -1, 468, 32767).addComponent(this.jTFNom, -1, 468, 32767)).addContainerGap()));
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
/*  96 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFNom, -2, 27, -2).addComponent(this.jLabel1)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFEmplacement, -2, 28, -2).addComponent(this.jLabel2)).addContainerGap(-1, 32767)));
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
/* 110 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 111 */     this.jButton1.setText("Valider");
/* 112 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 114 */         FormeAjouterLibrairie.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 117 */     });
/* 118 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 119 */     this.jButton2.setText("Annuler");
/* 120 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 122 */         FormeAjouterLibrairie.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 125 */     });
/* 126 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 127 */     getContentPane().setLayout(layout);
/* 128 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(368, 368, 368).addComponent(this.jButton2, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.jButton1, -1, 85, 32767))).addContainerGap()));
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
/* 141 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(-1, 32767)));
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
/* 153 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 157 */     String nom = this.jTFNom.getText().trim();
/* 158 */     if (nom.length() == 0) {
/* 159 */       javax.swing.JOptionPane.showMessageDialog(this, "Le nom de la librairie ne doit pas être vide", "Vérification", 0);
/*     */     }
/* 161 */     else if (!existeDeja(nom)) {
/* 162 */       if (!existeDejaFile(nom)) {
/* 163 */         Library lib = new Library(nom);
/* 164 */         this.frm.getPanLibibrary().addLibrary(lib);
/*     */         
/* 166 */         this.frm.getPanLibibrary().setLibSelected(lib);
/* 167 */         dispose();
/*     */       } else {
/* 169 */         javax.swing.JOptionPane.showMessageDialog(this, "Le fichier de la librairie existe déjà dans le répertoire des librairies \nRafraîchissez les librairies avec de créer une autre !! ", "Vérification", 0);
/*     */       }
/*     */     } else {
/* 172 */       javax.swing.JOptionPane.showMessageDialog(this, "Le nom de la librairie existe déjà dans la liste des librairies", "Vérification", 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/* 180 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\LibraryPan\FormeAjouterLibrairie.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */