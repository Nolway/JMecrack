/*     */ package Output;
/*     */ 
/*     */ import IhmMLD2.MLDEntite2;
/*     */ import Merise.Attribut;
/*     */ import Merise2.Attribut2;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SQLOutil
/*     */ {
/*     */   public static String getCentLignes(String txt)
/*     */   {
/*  20 */     int nb = 0;
/*  21 */     String s = "";
/*  22 */     while (txt.indexOf("\n") >= 0) {
/*  23 */       nb++;
/*  24 */       s = s + txt.substring(0, txt.indexOf("\n") + 1);
/*  25 */       txt = txt.substring(txt.indexOf("\n") + 1, txt.length());
/*  26 */       if (nb > 300) break;
/*     */     }
/*  28 */     if (nb > 300) {
/*  29 */       if (txt.length() > 1)
/*  30 */         s = s + "\n";
/*  31 */       s = s + "\n\n\n\t=======================================================================\n";
/*  32 */       s = s + "\t   Désolé, il faut activer cette version pour voir la suite du script ! \n";
/*  33 */       s = s + "\t=======================================================================\n";
/*     */     }
/*     */     
/*  36 */     return s;
/*     */   }
/*     */   
/*     */   public static String remplaceChar(String s) {
/*  40 */     String st = s;
/*  41 */     st = st.trim();
/*  42 */     st = st.replace(" ", "_");
/*  43 */     st = st.replace("\"", "_");
/*  44 */     st = st.replace("'", "_");
/*  45 */     st = st.replace("?", "_");
/*  46 */     st = st.replace("<", "_");
/*  47 */     st = st.replace(">", "_");
/*  48 */     st = st.replace("°", "_");
/*  49 */     st = st.replace("#", "_");
/*  50 */     st = st.replace("&", "_");
/*  51 */     st = st.replace("*", "_");
/*  52 */     st = st.replace(",", "_");
/*  53 */     st = st.replace(";", "_");
/*  54 */     st = st.replace(":", "_");
/*  55 */     st = st.replace("!", "_");
/*     */     
/*  57 */     st = st.replace("-", "_");
/*  58 */     st = st.replace("à", "a");
/*  59 */     st = st.replace("â", "a");
/*  60 */     st = st.replace("ä", "a");
/*  61 */     st = st.replace("Ä", "A");
/*  62 */     st = st.replace("Â", "A");
/*     */     
/*  64 */     st = st.replace("é", "e");
/*  65 */     st = st.replace("è", "e");
/*  66 */     st = st.replace("ê", "e");
/*  67 */     st = st.replace("ë", "e");
/*  68 */     st = st.replace("Ë", "E");
/*  69 */     st = st.replace("Ê", "E");
/*     */     
/*  71 */     st = st.replace("ô", "o");
/*  72 */     st = st.replace("Ô", "O");
/*     */     
/*  74 */     st = st.replace("ü", "u");
/*  75 */     st = st.replace("û", "u");
/*  76 */     st = st.replace("ù", "u");
/*  77 */     st = st.replace("Ü", "U");
/*  78 */     st = st.replace("Û", "U");
/*     */     
/*  80 */     st = st.replace("ç", "c");
/*  81 */     st = st.replace("(", "_");
/*  82 */     st = st.replace(")", "_");
/*  83 */     return st;
/*     */   }
/*     */   
/*     */   public static String remplacerCharCommentaire(String comm) {
/*  87 */     comm = comm.replace("'", "\\'");
/*  88 */     return comm;
/*     */   }
/*     */   
/*     */   public static String SQLCommenaire(MLDEntite2 ent) {
/*  92 */     String s = "";
/*  93 */     if (ent.getCommentaire().trim().length() > 0) {
/*  94 */       s = " COMMENT \"" + SQLRemplaceParenthese(ent.getCommentaire()) + "\" ";
/*     */     }
/*  96 */     return s;
/*     */   }
/*     */   
/*     */   public static String SQLCommenaire(Attribut att) {
/* 100 */     String s = "";
/* 101 */     if (att.getCommentaire().trim().length() > 0) {
/* 102 */       s = " COMMENT \"" + SQLRemplaceParenthese(att.getCommentaire()) + "\" ";
/*     */     }
/* 104 */     return s;
/*     */   }
/*     */   
/*     */   public static String SQLRemplaceParenthese(String s) {
/* 108 */     s = s.replace("\"", "\\\"");
/* 109 */     s = s.replace("\n", " ");
/*     */     
/* 111 */     return s;
/*     */   }
/*     */   
/*     */   public static void decomposeAttributs(ArrayList<Attribut> listeC, ArrayList<Attribut> liste)
/*     */   {
/* 116 */     for (int i = 0; i < liste.size(); i++) {
/* 117 */       Attribut2 att = (Attribut2)liste.get(i);
/* 118 */       if (att.getListeAttributs().size() == 0) {
/* 119 */         listeC.add(att);
/*     */       } else {
/* 121 */         decomposeAttributs(listeC, att.getListeAttributs());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static ArrayList<Attribut> decomposerLesAttributsMLDEntite(MLDEntite2 ent)
/*     */   {
/* 128 */     ArrayList<Attribut> liste = new ArrayList();
/* 129 */     decomposeAttributs(liste, ent.getListeAttributs());
/* 130 */     return liste;
/*     */   }
/*     */   
/*     */   public static ArrayList<Attribut> decomposerLesAttributsListe(ArrayList<Attribut> l)
/*     */   {
/* 135 */     ArrayList<Attribut> liste = new ArrayList();
/* 136 */     decomposeAttributs(liste, l);
/* 137 */     return liste;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 142 */   public static String SQLMYSQL = "MYSQL";
/* 143 */   public static String SQLITE = "SQLITE";
/* 144 */   public static String SQLPOSTGRE = "POSTGRE";
/* 145 */   public static String SQLDERBY = "DERBY";
/* 146 */   public static String SQLFIREBIRD = "FIREBIRD";
/* 147 */   public static String HSQLDB = "HSQLDB";
/* 148 */   public static String SQLACCESS = "ACCESS";
/* 149 */   public static String SQLSERVER = "SQLSERVER";
/* 150 */   public static String SQLORACLE = "SQLORACLE";
/*     */   
/* 152 */   public static String PORTMYSQL = "3306";
/* 153 */   public static String PORTPOSTGRE = "5432";
/* 154 */   public static String PORTDERBY = "1527";
/* 155 */   public static String PORTFIREBIRD = "3050";
/* 156 */   public static String PORTACCESS = "";
/* 157 */   public static String PORTSQLSERVER = "";
/* 158 */   public static String PORTORACLE = "1521";
/*     */   
/* 160 */   public static String SERVERPOSTGRE = "localhost";
/* 161 */   public static String SERVERMYSQL = "localhost";
/* 162 */   public static String SERVERFIREBIRD = "localhost";
/* 163 */   public static String SERVERDERBY = "localhost";
/* 164 */   public static String SERVERACCESS = "localhost";
/* 165 */   public static String SERVERSQLSERVER = "localhost";
/* 166 */   public static String SERVERORACLE = "localhost";
/*     */   
/*     */ 
/* 169 */   public static String USERPOSTGRE = "postgres";
/* 170 */   public static String USERMYSQL = "root";
/* 171 */   public static String USERDERBY = "";
/* 172 */   public static String USERFIREBIRD = "SYSDBA";
/* 173 */   public static String USERHSQLDB = "sa";
/* 174 */   public static String USERACCESS = "";
/* 175 */   public static String USERSQLSERVER = "";
/* 176 */   public static String USERORACLE = "system";
/*     */   
/* 178 */   public static String PWPOSTGRE = "";
/* 179 */   public static String PWMYSQL = "";
/* 180 */   public static String PWDERBY = "";
/* 181 */   public static String PWFIREBIRD = "";
/* 182 */   public static String PWHSQLDB = "";
/* 183 */   public static String PWACCESS = "";
/* 184 */   public static String PWSQLSERVER = "";
/* 185 */   public static String PWORACLE = "";
/*     */   
/* 187 */   public static String DBPOSTGRE = "";
/* 188 */   public static String DBMYSQL = "";
/* 189 */   public static String DBDERBY = "";
/* 190 */   public static String DBFIREBIRD = "";
/* 191 */   public static String DBHSQLDB = "";
/* 192 */   public static String DBACCESS = "";
/* 193 */   public static String DBSQLSERVER = "";
/* 194 */   public static String DBORACLE = "";
/* 195 */   public static String DBSQLITE = "";
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\SQLOutil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */