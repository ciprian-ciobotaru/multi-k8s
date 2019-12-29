package com.demoapi.handler;
/*
import static sdxro.citiconnect.util.Constants.CITI_HTTP_ERROR_FIELD;
import static sdxro.citiconnect.util.Constants.CITI_HTTP_ERROR_MORE_INFORMATION;
import static sdxro.citiconnect.util.Constants.RESOURCE_BUNDLE_ERROR_MESSAGES;
import static sdxro.citiconnect.util.Util.checkCertificateValidity;
import static sdxro.citiconnect.util.Util.createXmlDocument;
import static sdxro.citiconnect.util.Util.decryptXmlDocument;
import static sdxro.citiconnect.util.Util.getTagValueFromXMLDocument;
import static sdxro.citiconnect.util.Util.initXmlSecurityContext;
*/
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Locale;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.w3c.dom.Document;

import com.demoapi.util.ErrorType.MsgCodeEnum;
import com.demoapi.util.ErrorType.MsgScopeEnum;
import com.demoapi.util.ServiceException;
/*
import sdxro.citiconnect.service.model.generated.ErrorType.MsgCodeEnum;
import sdxro.citiconnect.service.model.generated.ErrorType.MsgScopeEnum;
import sdxro.citiconnect.util.CitiConnectServiceException;
import sdxro.citiconnect.util.ErrorMsgKeysResBundle;
*/
public class CustomResponseErrorHandler extends DefaultResponseErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomResponseErrorHandler.class);

    //private X509Certificate sodexoXencDsigCert;
    //private PrivateKey sodexoXencDsigKey;

    public CustomResponseErrorHandler() {
       
    }
    
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {       
        String respBody = StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()).replaceAll("(\\r|\\n)", "");
        try {
        logger.error("Response error status: '{}' with body '{}'", response.getStatusCode(), respBody);
        
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(MsgCodeEnum.INTERNAL_SERVER_ERROR, null, MsgScopeEnum.TECHNICAL);
        }
    }
    
    /*
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        ResourceBundle messages = ResourceBundle
            .getBundle(RESOURCE_BUNDLE_ERROR_MESSAGES, new Locale(LocaleContextHolder.getLocale().getLanguage()));

        String respBody = StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()).replaceAll("(\\r|\\n)", "");
        logger.error("Response error status: '{}' with body '{}'", response.getStatusCode(), respBody);

        String citiErrCode;
        Document xmlDocResp;
        String citiErrMsg;

        try {
            initXmlSecurityContext();
            checkCertificateValidity(sodexoXencDsigCert);
            xmlDocResp = createXmlDocument(respBody);
            Document decryptedDoc = decryptXmlDocument(xmlDocResp, sodexoXencDsigKey);
            citiErrCode = getTagValueFromXMLDocument(decryptedDoc, decryptedDoc.getDocumentElement(), CITI_HTTP_ERROR_FIELD);
            citiErrMsg = getTagValueFromXMLDocument(decryptedDoc, decryptedDoc.getDocumentElement(), CITI_HTTP_ERROR_MORE_INFORMATION);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CitiConnectServiceException(MsgCodeEnum.INTERNAL_SERVER_ERROR, null, MsgScopeEnum.TECHNICAL);
        }

        switch (response.getStatusCode().series()) {
            case CLIENT_ERROR:
            case SERVER_ERROR:
                MsgCodeEnum msgCode;
                try {
                    msgCode = MsgCodeEnum.valueOf(citiErrCode);
                } catch (IllegalArgumentException e) {
                    logger.error(e.getMessage(), e);
                    String errMsg = messages.getString(ErrorMsgKeysResBundle.UNMAPPED_CITI_ERROR)
                        + " with code='" + citiErrCode + "' and message='" + citiErrMsg + "'";
                    throw new CitiConnectServiceException(MsgCodeEnum.UNMAPPED_CITI_ERROR, errMsg, MsgScopeEnum.TECHNICAL);
                }
                throw new CitiConnectServiceException(msgCode, null, MsgScopeEnum.BUSINESS);
            default:
                throw new CitiConnectServiceException(MsgCodeEnum.INTERNAL_SERVER_ERROR, null, MsgScopeEnum.TECHNICAL);
        }
    }
    */

}