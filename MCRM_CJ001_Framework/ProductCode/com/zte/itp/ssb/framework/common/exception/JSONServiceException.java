package com.zte.itp.ssb.framework.common.exception;

public class JSONServiceException extends SSBRuntimeException
{
  private static final long serialVersionUID = -5829545098534135052L;
  private String message;

  public JSONServiceException()
  {
  }

  public JSONServiceException(String message)
  {
    super(message);
    this.message = message;
  }

  public JSONServiceException(Throwable ex)
  {
    super(ex);
  }

  public JSONServiceException(String message, Throwable e)
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