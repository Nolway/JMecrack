/*     */ package MyExplorer;
/*     */ 
/*     */ import IhmMCD.IhmProjet;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.FormeInterneMLD;
/*     */ import ihm.FormeInterneSQL;
/*     */ import ihm.FormeInterneXML;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.tree.DefaultTreeCellRenderer;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyRenderer
/*     */   extends DefaultTreeCellRenderer
/*     */ {
/*     */   private Icon entiteIcon;
/*     */   private Icon relationIcon;
/*     */   private Icon mcdIcon;
/*     */   private Icon sqlIcon;
/*     */   private Icon mldRIcon;
/*     */   private Icon mldIcon;
/*     */   private Icon xmlIcon;
/*     */   private Icon proIcon;
/*     */   private Font fontGras;
/*     */   private Font fontNormal;
/*     */   private Color clText;
/*     */   private Color clSelect;
/*     */   private Font fontTitre;
/*     */   private Color clTextTitre;
/*     */   
/*     */   public MyRenderer()
/*     */   {
/*  38 */     this.entiteIcon = new ImageIcon(getClass().getResource("/Images/entiteP.PNG"));
/*  39 */     this.relationIcon = new ImageIcon(getClass().getResource("/Images/relationP.PNG"));
/*  40 */     this.mcdIcon = new ImageIcon(getClass().getResource("/Images/lienP.PNG"));
/*  41 */     this.sqlIcon = new ImageIcon(getClass().getResource("/Images/sql16.png"));
/*  42 */     this.mldRIcon = new ImageIcon(getClass().getResource("/Images/mld16.png"));
/*  43 */     this.mldIcon = new ImageIcon(getClass().getResource("/Images/MLDP.png"));
/*  44 */     this.xmlIcon = new ImageIcon(getClass().getResource("/Images/xml.png"));
/*  45 */     this.proIcon = new ImageIcon(getClass().getResource("/Images/mainIcone16.png"));
/*     */     
/*  47 */     this.fontGras = new Font("Tahoma", 1, 13);
/*  48 */     this.fontNormal = new Font("Tahoma", 0, 11);
/*  49 */     this.fontTitre = new Font("Arial", 1, 12);
/*  50 */     this.clText = Color.BLACK;
/*  51 */     this.clSelect = Color.BLACK;
/*  52 */     this.clTextTitre = Color.BLUE;
/*     */   }
/*     */   
/*     */   public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus)
/*     */   {
/*  57 */     super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
/*  58 */     setFont(this.fontTitre);
/*     */     
/*  60 */     if ((value instanceof NodeEntite)) {
/*  61 */       setIcon(this.entiteIcon);
/*  62 */       setFont(this.fontNormal);
/*  63 */       setForeground(this.clText);
/*     */     }
/*     */     
/*  66 */     if ((value instanceof NodeRelation)) {
/*  67 */       setIcon(this.relationIcon);
/*  68 */       setFont(this.fontNormal);
/*  69 */       setForeground(this.clText);
/*     */     }
/*  71 */     if ((value instanceof NodeRootSql)) {
/*  72 */       setIcon(this.sqlIcon);
/*  73 */       setFont(this.fontNormal);
/*  74 */       setForeground(this.clText);
/*  75 */       if ((((NodeRootSql)value).getFormeSql().getProjet().isMainProject()) && 
/*  76 */         (((NodeRootSql)value).getFormeSql().isSelected())) {
/*  77 */         setFont(this.fontGras);
/*  78 */         setForeground(this.clText);
/*     */       }
/*     */     }
/*     */     
/*  82 */     if ((value instanceof NodeRootMLD)) {
/*  83 */       setIcon(this.mldRIcon);
/*  84 */       setFont(this.fontNormal);
/*  85 */       setForeground(this.clText);
/*  86 */       if ((((NodeRootMLD)value).getFormeMLD().getProjet().isMainProject()) && 
/*  87 */         (((NodeRootMLD)value).getFormeMLD().isSelected())) {
/*  88 */         setFont(this.fontGras);
/*  89 */         setForeground(this.clText);
/*     */       }
/*     */     }
/*     */     
/*  93 */     if ((value instanceof NodeEntiteMLD)) {
/*  94 */       setIcon(this.mldIcon);
/*  95 */       setFont(this.fontNormal);
/*  96 */       setForeground(this.clText);
/*     */     }
/*  98 */     if ((value instanceof NodeRootEntite)) {
/*  99 */       setIcon(this.entiteIcon);
/* 100 */       setFont(this.fontNormal);
/* 101 */       setForeground(this.clText);
/*     */     }
/* 103 */     if ((value instanceof NodeRootRelation)) {
/* 104 */       setIcon(this.relationIcon);
/* 105 */       setFont(this.fontNormal);
/* 106 */       setForeground(this.clText);
/*     */     }
/* 108 */     if ((value instanceof NodeRootMCD)) {
/* 109 */       setIcon(this.mcdIcon);
/* 110 */       setFont(this.fontNormal);
/* 111 */       setForeground(this.clText);
/* 112 */       if ((((NodeRootMCD)value).getFormeMCD().getProjet().isMainProject()) && 
/* 113 */         (((NodeRootMCD)value).getFormeMCD().isSelected())) {
/* 114 */         setFont(this.fontGras);
/* 115 */         setForeground(this.clText);
/*     */       }
/*     */     }
/*     */     
/* 119 */     if ((value instanceof NodeRootXML)) {
/* 120 */       setIcon(this.xmlIcon);
/* 121 */       setFont(this.fontNormal);
/* 122 */       setForeground(this.clText);
/* 123 */       if ((((NodeRootXML)value).getFormeXML().getProjet().isMainProject()) && 
/* 124 */         (((NodeRootXML)value).getFormeXML().isSelected())) {
/* 125 */         setFont(this.fontGras);
/* 126 */         setForeground(this.clText);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 131 */     if ((value instanceof NodeProjet)) {
/* 132 */       if (((NodeProjet)value).getProjet().isMainProject()) {
/* 133 */         setFont(this.fontGras);
/* 134 */         setForeground(this.clSelect);
/*     */       }
/*     */       else {
/* 137 */         setFont(this.fontNormal);
/* 138 */         setForeground(this.clText);
/*     */       }
/* 140 */       setIcon(this.proIcon);
/*     */     }
/* 142 */     return this;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorer\MyRenderer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */