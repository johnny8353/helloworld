/*    */ package com.zte.itp.ssb.framework.common;
/*    */ 
/*    */ public class ResultData
/*    */ {
/* 25 */   private boolean Succeed = true;
/*    */ 
/* 27 */   private String ErrMsg = "";
/*    */ 
/* 29 */   private Object Data = null;
/*    */ 
/*    */   public String getErrMsg()
/*    */   {
/* 37 */     return this.ErrMsg;
/*    */   }
/*    */ 
/*    */   public void setErrMsg(String errMsg)
/*    */   {
/* 46 */     this.ErrMsg = errMsg;
/*    */   }
/*    */ 
/*    */   public boolean isSucceed()
/*    */   {
/* 55 */     return this.Succeed;
/*    */   }
/*    */ 
/*    */   public void setSucceed(boolean succeed)
/*    */   {
/* 64 */     this.Succeed = succeed;
/*    */   }
/*    */ 
/*    */   public Object getData()
/*    */   {
/* 73 */     return this.Data;
/*    */   }
/*    */ 
/*    */   public void setData(Object data)
/*    */   {
/* 82 */     this.Data = data;
/*    */   }
/*    */ }

/* Location:           E:\Project\中兴通讯\JAVA\jar\zte\jssb.jar
 * Qualified Name:     com.zte.itp.ssb.framework.common.ResultData
 * JD-Core Version:    0.6.0
 */