package sample1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class TestXValueXML {

    public static void main(String[] args) throws Exception {
        Document doc = convertXmlStringToDocument(getXValueXML());
        if (checkIfTagPresent(getXValueXML(), "clientFraudIndicator")) {
            System.out.println(fetchValueByTagName(doc, "clientFraudIndicator"));
        }
    }

    private static String convertDocumentToXmlString(Document doc) throws TransformerException {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(doc), new StreamResult(out));

        return out.toString();
    }

    private static Document convertXmlStringToDocument(String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
        return doc;
    }

    private static String getXValueXML() {
        return "<XArrangmentContractComponentDetail xsi:type=\"ns0:XArrangmentContractComponentDetailType\" xmlns:ns0=\"http://www.ibm.com/mdm/schema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "   <CrossSellDetails>\n" +
                "      <Optionality>Optional</Optionality>\n" +
                "      <acceptanceStatus>TakenUp</acceptanceStatus>\n" +
                "   </CrossSellDetails>\n" +
                "   <requestedLoanAmount>5788</requestedLoanAmount>\n" +
                "   <originallyRequestedLoanAmount>3000</originallyRequestedLoanAmount>\n" +
                "   <customerRequestOption>1</customerRequestOption>\n" +
                "   <loanPurposeType>1008</loanPurposeType>\n" +
                "   <AcceptedEvidence>\n" +
                "      <Evidence>\n" +
                "         <Type>NotUnderCreditAdministration</Type>\n" +
                "         <AcceptedBy>\n" +
                "            <ClientID>600000243253</ClientID>\n" +
                "            <Timestamp>Thu Jul 26 2018 14:36:22 GMT+0200 (South Africa Standard Time)</Timestamp>\n" +
                "            <Response>true</Response>\n" +
                "        </AcceptedBy>\n" +
                "      </Evidence>\n" +
                "      <Evidence>\n" +
                "         <Type>BureauCheckConsent</Type>\n" +
                "         <AcceptedBy>\n" +
                "            <ClientID>600000243253</ClientID>\n" +
                "            <Timestamp>Thu Jul 26 2018 14:36:22 GMT+0200 (South Africa Standard Time)</Timestamp>\n" +
                "            <Response>true</Response>\n" +
                "         </AcceptedBy>\n" +
                "      </Evidence>\n" +
                "      <Evidence>\n" +
                "         <Type>AcceptNedbankInsurance</Type>\n" +
                "         <AcceptedBy>\n" +
                "            <ClientID>600000243253</ClientID>\n" +
                "            <Timestamp>Thu Jul 26 2018 14:37:12 GMT+0200 (South Africa Standard Time)</Timestamp>\n" +
                "            <Response>true</Response>\n" +
                "         </AcceptedBy>\n" +
                "      </Evidence>\n" +
                "      <Evidence>\n" +
                "         <Type>ConfirmConsent</Type>\n" +
                "         <AcceptedBy>\n" +
                "            <ClientID>600000243253</ClientID>\n" +
                "            <Timestamp>Thu Jul 26 2018 14:40:09 GMT+0200 (South Africa Standard Time)</Timestamp>\n" +
                "            <Response>false</Response>\n" +
                "         </AcceptedBy>\n" +
                "      </Evidence>\n" +
                "      <Evidence>\n" +
                "         <Type>ConfirmSpouseCreditCheck</Type>\n" +
                "         <AcceptedBy>\n" +
                "            <ClientID>600000243253</ClientID>\n" +
                "            <Timestamp>Thu Jul 26 2018 14:40:09 GMT+0200 (South Africa Standard Time)</Timestamp>\n" +
                "            <Response>false</Response>\n" +
                "         </AcceptedBy>\n" +
                "      </Evidence>\n" +
                "      <Evidence>\n" +
                "         <Type>ConfirmAccurateInformation</Type>\n" +
                "         <AcceptedBy>\n" +
                "            <ClientID>600000243253</ClientID>\n" +
                "            <Timestamp>Thu Jul 26 2018 14:40:09 GMT+0200 (South Africa Standard Time)</Timestamp>\n" +
                "            <Response>true</Response>\n" +
                "         </AcceptedBy>\n" +
                "      </Evidence>\n" +
                "      <Evidence>\n" +
                "         <Type>LoanConfirmed</Type>\n" +
                "         <AcceptedBy>\n" +
                "            <ClientID>600000243253</ClientID>\n" +
                "            <Timestamp>Thu Jul 26 2018 14:41:36 GMT+0200 (South Africa Standard Time)</Timestamp>\n" +
                "            <Response>true</Response>\n" +
                "         </AcceptedBy>\n" +
                "      </Evidence>\n" +
                "      <Evidence>\n" +
                "         <Type>confirmRepayment</Type>\n" +
                "         <AcceptedBy>\n" +
                "           <ClientID>600000243253</ClientID>\n" +
                "            <Timestamp>Thu Jul 26 2018 14:42:16 GMT+0200 (South Africa Standard Time)</Timestamp>\n" +
                "            <Response>true</Response>\n" +
                "         </AcceptedBy>\n" +
                "      </Evidence>\n" +
                "   </AcceptedEvidence>\n" +
                "   <loanRepayment>\n" +
                "      <currency>ZAR</currency>\n" +
                "      <creditCostMultiple>1.48</creditCostMultiple>\n" +
                "      <amount>5788.0</amount>\n" +
                "      <totalFeeAndCreditCost>1781.16</totalFeeAndCreditCost>\n" +
                "      <creditAdvanced>6528.36</creditAdvanced>\n" +
                "      <frequency>Monthly</frequency>\n" +
                "      <totalRepayment>8583.6</totalRepayment>\n" +
                "      <baseInstallmentAmount>623.46</baseInstallmentAmount>\n" +
                "      <totalInstallmentAmount>715.3</totalInstallmentAmount>\n" +
                "      <totalPaymentToLenders>2788.0</totalPaymentToLenders>\n" +
                "   </loanRepayment>\n" +
                "   <offerDetails>\n" +
                "      <creditOfferTerm>\n" +
                "         <minAmount>2786.0</minAmount>\n" +
                "         <maxAmount>146581.72</maxAmount>\n" +
                "         <allowedTerms>\n" +
                "            <termDetails>\n" +
                "               <CDEOfferId>0010000_12</CDEOfferId>\n" +
                "               <term>12</term>\n" +
                "            </termDetails>\n" +
                "         </allowedTerms>\n" +
                "      </creditOfferTerm>\n" +
                "   </offerDetails>\n" +
                "   <interest>\n" +
                "      <rate>20.599999999999998</rate>\n" +
                "      <type>1001</type>\n" +
                "      <friendlyDesc>Fixed Interest Rate</friendlyDesc>\n" +
                "      <isStaffPreferentialRate>false</isStaffPreferentialRate>\n" +
                "      <decimalRate>0.206</decimalRate>\n" +
                "   </interest>\n" +
                "   <productPricing>\n" +
                "      <fee>\n" +
                "         <currency>ZAR</currency>\n" +
                "         <amount>69.0</amount>\n" +
                "         <type>AdminFee</type>\n" +
                "         <frequency>Monthly</frequency>\n" +
                "         <description>Monthly Service Fee</description>\n" +
                "      </fee>\n" +
                "      <fee>\n" +
                "         <currency>ZAR</currency>\n" +
                "         <amount>740.36</amount>\n" +
                "         <type>initiationFee</type>\n" +
                "         <frequency>OnceOff</frequency>\n" +
                "         <description>Initiation Fee</description>\n" +
                "      </fee>\n" +
                "   </productPricing>\n" +
                "   <loanAmount>5788.0</loanAmount>\n" +
                "   <repaymentTerm>12</repaymentTerm>\n" +
                "   <consolidationDetails>\n" +
                "      <consolidationIsAvailable>true</consolidationIsAvailable>\n" +
                "      <acceptanceStatus>TakenUp</acceptanceStatus>\n" +
                "      <existingClientLoanDetails>\n" +
                "         <LoanType>OK FURNITURE</LoanType>\n" +
                "         <AccountBank>1033</AccountBank>\n" +
                "         <AccountBranchCode>51001</AccountBranchCode>\n" +
                "         <OutstandingLoanAmountZAR>2788.0</OutstandingLoanAmountZAR>\n" +
                "         <MinimumOutstandingLoanAmountZAR>0.0</MinimumOutstandingLoanAmountZAR>\n" +
                "         <MaximumOutstandingLoanAmountZAR>3262.0</MaximumOutstandingLoanAmountZAR>\n" +
                "         <SupplierName>OK FURNITURE</SupplierName>\n" +
                "         <InstallmentAmount>474.0</InstallmentAmount>\n" +
                "         <SettlementDocumentRequired>true</SettlementDocumentRequired>\n" +
                "         <Category>IN</Category>\n" +
                "         <NedbankFlag>false</NedbankFlag>\n" +
                "         <Account>000992291</Account>\n" +
                "         <RefNumberSuppliedByClient>true</RefNumberSuppliedByClient>\n" +
                "         <ReferenceNumberModifiableByClient>true</ReferenceNumberModifiableByClient>\n" +
                "         <BranchCodeModifiableByClient>true</BranchCodeModifiableByClient>\n" +
                "         <SettlementAmountModifiableByClient>true</SettlementAmountModifiableByClient>\n" +
                "      </existingClientLoanDetails>\n" +
                "   </consolidationDetails>\n" +
                "   <requestedRepaymentTerm>12</requestedRepaymentTerm>\n" +
                "   <bankAccount>\n" +
                "      <type>Disbursement</type>\n" +
                "      <bank>ABSA BANK</bank>\n" +
                "      <branchCode>632005</branchCode>\n" +
                "      <accountType>Current</accountType>\n" +
                "      <accountNumber>238260922</accountNumber>\n" +
                "   </bankAccount>\n" +
                "   <bankAccount>\n" +
                "      <type>Collection</type>\n" +
                "      <bank>ABSA BANK</bank>\n" +
                "      <branchCode>632005</branchCode>\n" +
                "      <accountType>Current</accountType>\n" +
                "      <accountNumber>238260922</accountNumber>\n" +
                "   </bankAccount>\n" +
                "   <facilityDetails>\n" +
                "      <number>8003168106201</number>\n" +
                "      <loanReferenceNumber>600000041227</loanReferenceNumber>\n" +
                "   </facilityDetails>\n" +
                "   <DocumentSubmissionSelection>\n" +
                "      <code>1</code>\n" +
                "      <description>Online now</description>\n" +
                "   </DocumentSubmissionSelection>\n" +
                "   <p:activitiesRequiredToBeExecuted xmlns:p=\"http://contracts.it.nednet.co.za/services/biz/arrangementmanagement/ArrangementManagement/v1\">\n" +
                "      <p:activitiesToExecute>\n" +
                "         <p:partyId>600000243253</p:partyId>\n" +
                "         <p:activity>\n" +
                "            <p:action>VerifyEmployment</p:action>\n" +
                "         </p:activity>\n" +
                "         <p:activity>\n" +
                "            <p:action>VerifyBankDetails</p:action>\n" +
                "         </p:activity>\n" +
                "         <p:activity>\n" +
                "            <p:action>VerifyIncomeExpenses</p:action>\n" +
                "         </p:activity>\n" +
                "         <p:activity>\n" +
                "            <p:action>GatherDocuments</p:action>\n" +
                "            <p:documentGatherDetails>\n" +
                "               <p:taxonomyLevel1>CLIENT</p:taxonomyLevel1>\n" +
                "               <p:taxonomyLevel2>PROOFOFINCOME</p:taxonomyLevel2>\n" +
                "               <p:taxonomyLevel3>Payslip</p:taxonomyLevel3>\n" +
                "               <p:taxonomyLevel4>Payslip</p:taxonomyLevel4>\n" +
                "               <p:frequency>Months</p:frequency>\n" +
                "               <p:interval>3</p:interval>\n" +
                "            </p:documentGatherDetails>\n" +
                "            <p:documentGatherDetails>\n" +
                "               <p:taxonomyLevel1>CLIENT</p:taxonomyLevel1>\n" +
                "               <p:taxonomyLevel2>PROOFOFINCOME</p:taxonomyLevel2>\n" +
                "               <p:taxonomyLevel3>Statement</p:taxonomyLevel3>\n" +
                "               <p:taxonomyLevel4>Bank Statement</p:taxonomyLevel4>\n" +
                "               <p:frequency>Months</p:frequency>\n" +
                "               <p:interval>3</p:interval>\n" +
                "            </p:documentGatherDetails>\n" +
                "         </p:activity>\n" +
                "      </p:activitiesToExecute>\n" +
                "   </p:activitiesRequiredToBeExecuted>\n" +
                "   <requestedCDEOfferId>0010000_12</requestedCDEOfferId>\n" +
                "   <fraudDetail>\n" +
                "      <fraudScore>0.0</fraudScore>\n" +
                "      <fraudRisk>0.0</fraudRisk>\n" +
                "      <StaffFacingFraudReasons>\n" +
                "         <StaffFraudReason>\n" +
                "            <FraudCode>3001</FraudCode>\n" +
                "            <FraudReason>Low Black-box Risk</FraudReason>\n" +
                "         </StaffFraudReason>\n" +
                "      </StaffFacingFraudReasons>\n" +
                "   </fraudDetail>\n" +
                "   <clientFraudIndicator>true</clientFraudIndicator>\n" +
                "</XArrangmentContractComponentDetail>";
    }

    private static boolean checkIfTagPresent(String xml, String tagName) throws IOException, SAXException, ParserConfigurationException {
        Document doc = convertXmlStringToDocument(xml);

        NodeList nodeList = doc.getElementsByTagName(tagName);
        System.out.println(tagName + " TagCount ::" + nodeList.getLength() + " and TagIsPresent ::" + (nodeList.getLength() > 0));
        return nodeList.getLength() > 0;
    }

    private static String fetchValueByTagName(Document document, String tagName) {
        System.out.println(document.getElementsByTagName(tagName).item(0).getTextContent());
        return document.getElementsByTagName(tagName).item(0).getTextContent();
    }

    private static String fetchValueByTagName(String xml, String tagName) throws IOException, SAXException, ParserConfigurationException {
        Document document = convertXmlStringToDocument(xml);
        System.out.println(document.getElementsByTagName(tagName).item(0).getTextContent());
        return document.getElementsByTagName(tagName).item(0).getTextContent();
    }
}
