package sample1;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class XPathTest2 {

    public static void main(String[] args) throws Exception {
        String xpathString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<NS1:Envelope xmlns:NS1=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <NS1:Header>\n" +
                "      <kd4:KD4SoapHeaderV2 xmlns:kd4=\"http://www.ibm.com/KD4Soap\" xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">AFIAAgAkNzZiZmUxMDctOGEwMC04OGRjLTEyYzUtOGE1MDBkYzZkNmIxACQ5MmEzYjkzNS1mMTk2LWQ0YWUtYWJlMC04NzEzZWZlNzFjMTIABA==</kd4:KD4SoapHeaderV2>\n" +
                "      <ent:EnterpriseContext xmlns:ent=\"http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext\" xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
                "         <ent:ContextInfo>\n" +
                "            <ent:ProcessContextId>1bc6a045-9ce8-4a2a-828f-9e88bf7f6e4f</ent:ProcessContextId>\n" +
                "            <ent:ExecutionContextId>b29524df-61f7-45d3-b708-d1d068363e15</ent:ExecutionContextId>\n" +
                "         </ent:ContextInfo>\n" +
                "         <ent:RequestOriginator>\n" +
                "            <ent:MachineIPAddress>10.59.115.84</ent:MachineIPAddress>\n" +
                "            <ent:UserPrincipleName>AP411120</ent:UserPrincipleName>\n" +
                "            <ent:MachineDNSName>zeb1swn1.it.nednet.co.za</ent:MachineDNSName>\n" +
                "            <ent:ChannelId>397</ent:ChannelId>\n" +
                "         </ent:RequestOriginator>\n" +
                "         <ent:InstrumentationInfo>\n" +
                "            <ent:ParentInstrumentationId>86280c9e-d0cc-4f4b-985a-d40c60630191</ent:ParentInstrumentationId>\n" +
                "            <ent:ChildInstrumentationId>7a4e625e-6389-48a9-ae2c-ec0d66a709f6</ent:ChildInstrumentationId>\n" +
                "         </ent:InstrumentationInfo>\n" +
                "      </ent:EnterpriseContext>\n" +
                "   </NS1:Header>\n" +
                "   <NS1:Body>\n" +
                "      <NS2:GetPartyAssociationsResponse xmlns:NS2=\"http://contracts.it.nednet.co.za/services/app/clientprofilemanagement/PartyDueDiligenceAdaptor/v1\">\n" +
                "         <NS2:RequestId>cd049b77-1185-406c-968c-a03e320872de</NS2:RequestId>\n" +
                "         <NS2:ResultSet>\n" +
                "            <NS2:ResultCd>R01</NS2:ResultCd>\n" +
                "            <NS2:BusinessRelationshipStatus />\n" +
                "            <NS2:ConditionCd>0</NS2:ConditionCd>\n" +
                "            <NS2:CommentLine>Failed to update RiskCompliance for : 6</NS2:CommentLine>\n" +
                "            <NS2:MsgDesc />\n" +
                "         </NS2:ResultSet>\n" +
                "      </NS2:GetPartyAssociationsResponse>\n" +
                "   </NS1:Body>\n" +
                "</NS1:Envelope>";

//        String reasonCode = xpathString.stringValue(party,"//*[local-name()='TCRMPartyIdentificationBObj'][*[local-name()='IdentificationType' and text()='1018']]/*[local-name()='IdentificationNumber']/text()");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("C://Users//cc317978//IntellijProjects//resources//sample1//dueDiligenceResponse.xml");

        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        XPathExpression expr = xpath.compile("//body/GetPartyAssociationsResponse/ResultSet/ResultCd/text()");
//        XPathExpression expr = xpath.compile("//book[@year>2001]/title/text()");
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        System.out.println(result.toString());
        /*NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }*/
    }
}
