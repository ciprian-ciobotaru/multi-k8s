package com.demoapi.util;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ErrorType
 */

public class ErrorType   {
  /**
   * Gets or Sets msgCode
   */
  public enum MsgCodeEnum {
    NOT_FOUND_CLIENT_ID("NOT_FOUND_CLIENT_ID"),
    
    NOT_FOUND_ACC_NUMBER("NOT_FOUND_ACC_NUMBER"),
    
    NOT_FOUND_FORMAT_NAME("NOT_FOUND_FORMAT_NAME"),
    
    NOT_FOUND_FROM_DATE("NOT_FOUND_FROM_DATE"),
    
    NOT_FOUND_TO_DATE("NOT_FOUND_TO_DATE"),
    
    NOT_FOUND_STATEMENT_ID("NOT_FOUND_STATEMENT_ID"),
    
    NOT_FOUND_FIELDS("NOT_FOUND_FIELDS"),
    
    INVALID_INTERVAL("INVALID_INTERVAL"),
    
    INVALID_DATE_FORMAT("INVALID_DATE_FORMAT"),
    
    INVALID_FORMAT_NAME("INVALID_FORMAT_NAME"),
    
    INVALID_FILE_CHECKSUM("INVALID_FILE_CHECKSUM"),
    
    PREVIOUS_STATEMENT_IS_STILL_BEEN_PROCESSED("PREVIOUS_STATEMENT_IS_STILL_BEEN_PROCESSED"),
    
    NOT_ENTITLED_TO_DOWNLOAD_STATEMENT("NOT_ENTITLED_TO_DOWNLOAD_STATEMENT"),
    
    STATEMENT_NOT_READY("STATEMENT_NOT_READY"),
    
    STATEMENT_NOT_FOUND("STATEMENT_NOT_FOUND"),
    
    STATEMENT_EMPTY("STATEMENT_EMPTY"),
    
    STATEMENT_FILE_SIZE_EXCEEDED("STATEMENT_FILE_SIZE_EXCEEDED"),
    
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),
    
    UNMAPPED_CITI_ERROR("UNMAPPED_CITI_ERROR"),
    
    NOT_FOUND_ENCRYPTED_DATA("NOT_FOUND_ENCRYPTED_DATA"),
    
    NOT_FOUND_ENCRYPTED_KEY("NOT_FOUND_ENCRYPTED_KEY");

    private String value;

    MsgCodeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MsgCodeEnum fromValue(String text) {
      for (MsgCodeEnum b : MsgCodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("msgCode")
  private MsgCodeEnum msgCode;

  @JsonProperty("msgText")
  private String msgText;

  /**
   * Gets or Sets msgScope
   */
  public enum MsgScopeEnum {
    BUSINESS("business"),
    
    TECHNICAL("technical");

    private String value;

    MsgScopeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MsgScopeEnum fromValue(String text) {
      for (MsgScopeEnum b : MsgScopeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("msgScope")
  private MsgScopeEnum msgScope;

  @JsonProperty("requestId")
  private String requestId;

  public ErrorType msgCode(MsgCodeEnum msgCode) {
    this.msgCode = msgCode;
    return this;
  }

  /**
   * Get msgCode
   * @return msgCode
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public MsgCodeEnum getMsgCode() {
    return msgCode;
  }

  public void setMsgCode(MsgCodeEnum msgCode) {
    this.msgCode = msgCode;
  }

  public ErrorType msgText(String msgText) {
    this.msgText = msgText;
    return this;
  }

  /**
   * Get msgText
   * @return msgText
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getMsgText() {
    return msgText;
  }

  public void setMsgText(String msgText) {
    this.msgText = msgText;
  }

  public ErrorType msgScope(MsgScopeEnum msgScope) {
    this.msgScope = msgScope;
    return this;
  }

  /**
   * Get msgScope
   * @return msgScope
  */
  @ApiModelProperty(value = "")


  public MsgScopeEnum getMsgScope() {
    return msgScope;
  }

  public void setMsgScope(MsgScopeEnum msgScope) {
    this.msgScope = msgScope;
  }

  public ErrorType requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * Get requestId
   * @return requestId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorType errorType = (ErrorType) o;
    return Objects.equals(this.msgCode, errorType.msgCode) &&
        Objects.equals(this.msgText, errorType.msgText) &&
        Objects.equals(this.msgScope, errorType.msgScope) &&
        Objects.equals(this.requestId, errorType.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msgCode, msgText, msgScope, requestId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorType {\n");
    
    sb.append("    msgCode: ").append(toIndentedString(msgCode)).append("\n");
    sb.append("    msgText: ").append(toIndentedString(msgText)).append("\n");
    sb.append("    msgScope: ").append(toIndentedString(msgScope)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

