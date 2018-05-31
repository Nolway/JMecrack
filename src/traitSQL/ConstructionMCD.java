/*     */ package traitSQL;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmLien;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmRelation;
/*     */ import Merise.Attribut;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Outil.Parametres;
/*     */ import composantSQL.Column;
/*     */ import composantSQL.MyDataBase;
/*     */ import composantSQL.Table;
/*     */ import ihm.Principale;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConstructionMCD
/*     */ {
/*     */   private MyDataBase maBase;
/*     */   private Principale frm;
/*     */   
/*     */   public ConstructionMCD(Principale frm, MyDataBase maBase)
/*     */   {
/*  30 */     this.maBase = maBase;
/*  31 */     this.frm = frm;
/*     */   }
/*     */   
/*     */   private boolean estRelation(Table tab) {
/*  35 */     boolean verif = true;
/*  36 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/*  37 */       if ((((Column)tab.getColumnList().get(i)).getKey().equals(Parametres.Cle)) && 
/*  38 */         (((Column)tab.getColumnList().get(i)).getFrkey().trim().length() == 0)) { return false;
/*     */       }
/*     */     }
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   private Entite convertirTabEntite(Table tab) {
/*  45 */     Entite ent = new Entite(tab.getName());
/*  46 */     ent.setCommentaire(tab.getComment());
/*  47 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/*  48 */       Attribut att = new Attribut(((Column)tab.getColumnList().get(i)).getName(), ((Column)tab.getColumnList().get(i)).getType(), ((Column)tab.getColumnList().get(i)).getSize(), 0, ((Column)tab.getColumnList().get(i)).getKey(), ((Column)tab.getColumnList().get(i)).isNull(), ((Column)tab.getColumnList().get(i)).getComment(), ent);
/*     */       
/*  50 */       ent.getListeAttributs().add(att);
/*     */     }
/*  52 */     return ent;
/*     */   }
/*     */   
/*     */   private Relation convertirTabRelation(Table tab) {
/*  56 */     Relation ent = new Relation(tab.getName());
/*  57 */     ent.setCommentaire(tab.getComment());
/*  58 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/*  59 */       Attribut att = new Attribut(((Column)tab.getColumnList().get(i)).getName(), ((Column)tab.getColumnList().get(i)).getType(), ((Column)tab.getColumnList().get(i)).getSize(), 0, ((Column)tab.getColumnList().get(i)).getKey(), ((Column)tab.getColumnList().get(i)).isNull(), ((Column)tab.getColumnList().get(i)).getComment(), ent);
/*     */       
/*  61 */       ent.getListeAttributs().add(att);
/*     */     }
/*  63 */     return ent;
/*     */   }
/*     */   
/*     */   public void construireMCD() {
/*  67 */     this.frm.getPage().effacerAllMCD();
/*  68 */     for (int i = 0; i < this.maBase.getTableList().size(); i++) {
/*  69 */       if (estRelation((Table)this.maBase.getTableList().get(i))) {
/*  70 */         this.frm.getPage().getListeEntiteRelation().add(new IhmRelation(convertirTabRelation((Table)this.maBase.getTableList().get(i)), i, i, true));
/*     */       } else {
/*  72 */         this.frm.getPage().getListeEntiteRelation().add(new IhmEntite(convertirTabEntite((Table)this.maBase.getTableList().get(i)), i, i, true));
/*     */       }
/*     */     }
/*  75 */     this.frm.getPage().repaint();
/*     */   }
/*     */   
/*     */   public void repositionnerMCD()
/*     */   {
/*  80 */     int h = 0;
/*  81 */     int nb = 0;
/*  82 */     for (int i = 0; i < this.frm.getPage().getListeEntiteRelation().size(); i++) {
/*  83 */       if ((this.frm.getPage().getListeEntiteRelation().get(i) instanceof IhmEntite)) {
/*  84 */         ((IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i)).setX(nb * 400);
/*  85 */         ((IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i)).setY(i * 30);
/*  86 */         nb++;
/*  87 */         if (nb == 2) { nb = 0;
/*     */         }
/*     */       }
/*     */     }
/*  91 */     for (int i = 0; i < this.frm.getPage().getListeEntiteRelation().size(); i++) {
/*  92 */       if ((this.frm.getPage().getListeEntiteRelation().get(i) instanceof IhmRelation)) {
/*  93 */         ((IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i)).setX(200);
/*  94 */         ((IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i)).setY(i * 30);
/*  95 */         nb++;
/*  96 */         if (nb == 2) nb = 0;
/*     */       }
/*     */     }
/*  99 */     this.frm.repaint();
/*     */   }
/*     */   
/*     */   private IhmEntiteRelation trouverEntRel(String s) {
/* 103 */     for (int i = 0; i < this.frm.getPage().getListeEntiteRelation().size(); i++) {
/* 104 */       if ((this.frm.getPage().getListeEntiteRelation().get(i) instanceof IhmEntite)) {
/* 105 */         if (((IhmEntite)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(s.trim().toUpperCase())) {
/* 106 */           return (IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i);
/*     */         }
/* 108 */       } else if (((IhmRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(s.trim().toUpperCase())) {
/* 109 */         return (IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i);
/*     */       }
/*     */     }
/* 112 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   private void construireLienDeRelation(Table tab, IhmRelation rel)
/*     */   {
/* 118 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/* 119 */       Column c = (Column)tab.getColumnList().get(i);
/* 120 */       if ((c.getKey().equals(Parametres.Cle)) && (c.getFrkey().trim().length() != 0)) {
/* 121 */         IhmEntiteRelation ent = trouverEntRel(c.getFrkey());
/* 122 */         if (ent != null) {
/* 123 */           this.frm.getPage().getListeLien().add(new IhmLien((IhmEntite)ent, rel));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void construireLienEntite(Table tab, IhmEntite ent)
/*     */   {
/* 132 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/* 133 */       Column c = (Column)tab.getColumnList().get(i);
/* 134 */       if ((c.getKey().equals(Parametres.Cle)) && (c.getFrkey().trim().length() != 0)) {
/* 135 */         IhmEntiteRelation e = trouverEntRel(c.getFrkey());
/* 136 */         if ((e instanceof IhmEntite)) {
/* 137 */           IhmRelation r = new IhmRelation(new Relation("Relation"), 10, 10, this.frm.isTailleVariable());
/* 138 */           IhmLien l = new IhmLien(ent, r);
/* 139 */           l.setCardinalite("0,n");
/*     */           
/* 141 */           this.frm.getPage().getListeEntiteRelation().add(r);
/* 142 */           this.frm.getPage().getListeLien().add(l);
/* 143 */           l = new IhmLien((IhmEntite)e, r);
/* 144 */           l.setCardinalite("0,1");
/* 145 */           this.frm.getPage().getListeLien().add(l);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void construireLesLiens()
/*     */   {
/* 153 */     for (int i = 0; i < this.maBase.getTableList().size(); i++) {
/* 154 */       IhmEntiteRelation ent = trouverEntRel(((Table)this.maBase.getTableList().get(i)).getName());
/* 155 */       if ((ent instanceof IhmEntite)) {
/* 156 */         construireLienEntite((Table)this.maBase.getTableList().get(i), (IhmEntite)ent);
/*     */       }
/* 158 */       else if ((ent instanceof IhmRelation)) {
/* 159 */         construireLienDeRelation((Table)this.maBase.getTableList().get(i), (IhmRelation)ent);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\traitSQL\ConstructionMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */