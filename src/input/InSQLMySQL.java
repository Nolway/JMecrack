/*    */ package input;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InSQLMySQL
/*    */ {
/* 13 */   public static String[] TYPE_TAB = { "Auto_increment", "Varchar", "Char", "Bool", "Date", "Int", "Float", "Money", "BigInt", "Blob", "Datetime", "Decimal", "Double", "Double Precision", "Enum", "Longblob", "Longtext", "Mediumblob", "Mediumint", "Mediumtext", "Numeric", "Real", "Set", "Smallint", "Text", "Time", "TimeStamp", "TinyBlob", "TinyINT", "TinyText", "Year", "Integer" };
/*    */   
/*    */ 
/*    */ 
/*    */   public static String getType(String type, boolean autoInc)
/*    */   {
/* 19 */     if (type.trim().toUpperCase().equals("VARCHAR")) return "Varchar";
/* 20 */     if (type.trim().toUpperCase().equals("Char")) return "Char";
/* 21 */     if (type.trim().toUpperCase().equals("Bool")) return "Bool";
/* 22 */     if (type.trim().toUpperCase().equals("Date")) return "Date";
/* 23 */     if (type.trim().toUpperCase().equals("Int")) return "Int";
/* 24 */     if (type.trim().toUpperCase().equals("Float")) return "Float";
/* 25 */     if (type.trim().toUpperCase().equals("BigInt")) return "BigInt";
/* 26 */     if (type.trim().toUpperCase().equals("Blob")) return "Blob";
/* 27 */     if (type.trim().toUpperCase().equals("Datetime")) return "Datetime";
/* 28 */     if (type.trim().toUpperCase().equals("Decimal")) return "Decimal";
/* 29 */     if (type.trim().toUpperCase().equals("Double")) return "Double";
/* 30 */     if (type.trim().toUpperCase().equals("Double Precision")) return "Double Precision";
/* 31 */     if (type.trim().toUpperCase().equals("Longblob")) return "Longblob";
/* 32 */     if (type.trim().toUpperCase().equals("Longtext")) return "Longtext";
/* 33 */     if (type.trim().toUpperCase().equals("Mediumblob")) return "Mediumblob";
/* 34 */     if (type.trim().toUpperCase().equals("Mediumint")) return "Mediumint";
/* 35 */     if (type.trim().toUpperCase().equals("Mediumtext")) return "Mediumtext";
/* 36 */     if (type.trim().toUpperCase().equals("Numeric")) return "Numeric";
/* 37 */     if (type.trim().toUpperCase().equals("Real")) return "Real";
/* 38 */     if (type.trim().toUpperCase().equals("Smallint")) return "Smallint";
/* 39 */     if (type.trim().toUpperCase().equals("Text")) return "Text";
/* 40 */     if (type.trim().toUpperCase().equals("Time")) return "Time";
/* 41 */     if (type.trim().toUpperCase().equals("TimeStamp")) return "TimeStamp";
/* 42 */     if (type.trim().toUpperCase().equals("TinyBlob")) return "TinyBlob";
/* 43 */     if (type.trim().toUpperCase().equals("TinyINT")) return "TinyINT";
/* 44 */     if (type.trim().toUpperCase().equals("TinyText")) return "TinyText";
/* 45 */     if (type.trim().toUpperCase().equals("Year")) return "Year";
/* 46 */     if (type.trim().toUpperCase().equals("Integer")) return "Integer";
/* 47 */     if (type.trim().toUpperCase().equals("Int")) {
/* 48 */       if (autoInc) return "Auto_increment";
/* 49 */       return "Int";
/*    */     }
/* 51 */     return "INDEFINI";
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\input\InSQLMySQL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */