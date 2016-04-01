package com.zte.itp.ssb.framework.common.exception;

public class SSBRuntimeException extends RuntimeException
{
  private static final long serialVersionUID = 2792047199528030753L;
  private String message;

  public SSBRuntimeException()
  {
  }

  public SSBRuntimeException(String message)
  {
    super(message);
    this.message = message;
  }

  public SSBRuntimeException(Throwable ex)
  {
    super(ex);
  }

  public SSBRuntimeException(String message, Throwable e)
  {
    super(message, e);
    this.message = message;
  }

  @Override
public String getMessage()
  {
    return this.message;
  }
}