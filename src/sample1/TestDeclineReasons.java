package sample1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


// Reference Link: https://mkyong.com/java/how-to-modify-xml-file-in-java-dom-parser/
// Reference Link: https://mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
public class TestDeclineReasons {

    // ArrangementUtil.java file present this method
    public String injectDeclineReasonsXML(String pXValueXML, Map<String, String> pClientDeclineReasons, Map<String, String> pStaffDeclineReasons) throws Exception {
        System.out.println("Trace 1");

        String modifiedXML = pXValueXML;

        // Are there valid decline reasons?
        if ((pClientDeclineReasons != null && pClientDeclineReasons.size() > 0) || (pStaffDeclineReasons != null && pStaffDeclineReasons.size() > 0)) {
            System.out.println("Trace 2");

            // Is there valid XML. If not then setup the base structure.
            if (modifiedXML == null || modifiedXML.trim().equalsIgnoreCase("")) {
                modifiedXML = "<XArrangmentContractComponentDetail></XArrangmentContractComponentDetail>";
            }

        }

        /*String CDEDeclineReasons = "<CDEDeclineReasons>";

        // Are there client decline reasons
        if ((pClientDeclineReasons != null && pClientDeclineReasons.size() > 0)) {
            System.out.println("Trace 3");
            String vClientDeclineReasonsXML = "<ClientFacingDeclineReasons>";

            Iterator<String> vDeclineCodeIterator = pClientDeclineReasons.keySet().iterator();

            while (vDeclineCodeIterator.hasNext()) {
                System.out.println("Trace 4");
                String vDeclineCode = vDeclineCodeIterator.next();
                String vDeclineReason = pClientDeclineReasons.get(vDeclineCode);

                String vClientDeclineDetails = "<ClientDeclineReason><DeclineCode>" + vDeclineCode + "</DeclineCode><DeclineReason>" + vDeclineReason + "</DeclineReason></ClientDeclineReason>";

                vClientDeclineReasonsXML = vClientDeclineReasonsXML + vClientDeclineDetails;
            }

            System.out.println("Trace 5");

            vClientDeclineReasonsXML = vClientDeclineReasonsXML + "</ClientFacingDeclineReasons>";

            System.out.println("Trace 6");

            CDEDeclineReasons = CDEDeclineReasons + vClientDeclineReasonsXML;

            System.out.println("Trace 7 >>" + CDEDeclineReasons + "<<");
        }

        // Are there staff decline reasons
        if ((pStaffDeclineReasons != null && pStaffDeclineReasons.size() > 0)) {
            System.out.println("Trace 8");
            String vStaffDeclineReasonsXML = "<StaffFacingDeclineReasons>";

            Iterator<String> vDeclineCodeIterator = pStaffDeclineReasons.keySet().iterator();

            while (vDeclineCodeIterator.hasNext()) {
                System.out.println("Trace 9");
                String vDeclineCode = vDeclineCodeIterator.next();
                String vDeclineReason = pStaffDeclineReasons.get(vDeclineCode);

                String vStaffDeclineDetails = "<StaffDeclineReason><DeclineCode>" + vDeclineCode + "</DeclineCode><DeclineReason>" + vDeclineReason + "</DeclineReason></StaffDeclineReason>";

                vStaffDeclineReasonsXML = vStaffDeclineReasonsXML + vStaffDeclineDetails;

                System.out.println("Trace 10");
            }

            vStaffDeclineReasonsXML = vStaffDeclineReasonsXML + "</StaffFacingDeclineReasons>";

            CDEDeclineReasons = CDEDeclineReasons + vStaffDeclineReasonsXML;

            System.out.println("Trace 11 >>" + CDEDeclineReasons + "<<");
        }

        CDEDeclineReasons = CDEDeclineReasons + "</CDEDeclineReasons>";

        System.out.println("Trace 12 >>" + CDEDeclineReasons + "<<");*/

//        modifiedXML = modifiedXML.replaceAll("</XArrangmentContractComponentDetail>", CDEDeclineReasons + "</XArrangmentContractComponentDetail>");

        if (checkIfTagPresent(modifiedXML, "CDEDeclineReasons")) {

            if (checkIfTagPresent(modifiedXML, "StaffFacingDeclineReasons")) {
                modifiedXML = addDeclineReasonsElement(modifiedXML, "StaffFacingDeclineReasons", pStaffDeclineReasons, "StaffDeclineReason");
            } else {
                modifiedXML = addFacingDeclineReasonElement(modifiedXML, "StaffFacingDeclineReasons", "StaffDeclineReason", pStaffDeclineReasons);
            }
            if (checkIfTagPresent(modifiedXML, "ClientFacingDeclineReasons")) {
                modifiedXML = addDeclineReasonsElement(modifiedXML, "ClientFacingDeclineReasons", pStaffDeclineReasons, "ClientDeclineReason");
            } else {
                modifiedXML = addFacingDeclineReasonElement(modifiedXML, "StaffFacingDeclineReasons", "ClientDeclineReason", pStaffDeclineReasons);
            }
        } else {
            String CDEDeclineReasons = createCDEDeclineReason(pClientDeclineReasons, pStaffDeclineReasons);
            modifiedXML = modifiedXML.replaceAll("</XArrangmentContractComponentDetail>", CDEDeclineReasons + "</XArrangmentContractComponentDetail>");
        }

        System.out.println("Final >>" + modifiedXML + "<<");

        return modifiedXML;
    }

    private static String addFacingDeclineReasonElement(String xml, String facingDeclineReason, String declineReason, Map<String, String> declineReasons) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        Document doc = convertXmlStringToDocument(xml);

        NodeList nodeList = doc.getElementsByTagName("CDEDeclineReasons");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            Element facingDeclineReasons = doc.createElement(facingDeclineReason);
            Element staffDeclineReason = doc.createElement(declineReason);

            if ((declineReasons != null && declineReasons.size() > 0)) {
                Iterator<String> vDeclineCodeIterator = declineReasons.keySet().iterator();
                while (vDeclineCodeIterator.hasNext()) {
                    String vDeclineCode = vDeclineCodeIterator.next();
                    String vDeclineReason = declineReasons.get(vDeclineCode);

                    Element newDeclineCode = doc.createElement("DeclineCode");
                    newDeclineCode.appendChild(doc.createTextNode(vDeclineCode));
                    Element newDeclineReason = doc.createElement("DeclineReason");
                    newDeclineReason.appendChild(doc.createTextNode(vDeclineReason));
                    staffDeclineReason.appendChild(newDeclineCode);
                    staffDeclineReason.appendChild(newDeclineReason);
                }
            }

            facingDeclineReasons.appendChild(staffDeclineReason);
            nNode.appendChild(facingDeclineReasons);
        }

        return convertDocumentToXmlString(doc);
    }

    private static String addDeclineReasonsElement(String xml, String tagName, Map<String, String> declineReasons, String reason) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        Document doc = convertXmlStringToDocument(xml);

        NodeList nodeList = doc.getElementsByTagName(tagName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
//            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            Element newStaffDeclineReason = doc.createElement(reason);

            if ((declineReasons != null && declineReasons.size() > 0)) {
                Iterator<String> vDeclineCodeIterator = declineReasons.keySet().iterator();
                while (vDeclineCodeIterator.hasNext()) {
                    String vDeclineCode = vDeclineCodeIterator.next();
                    String vDeclineReason = declineReasons.get(vDeclineCode);

                    Element newDeclineCode = doc.createElement("DeclineCode");
                    newDeclineCode.appendChild(doc.createTextNode(vDeclineCode));
                    Element newDeclineReason = doc.createElement("DeclineReason");
                    newDeclineReason.appendChild(doc.createTextNode(vDeclineReason));
                    newStaffDeclineReason.appendChild(newDeclineCode);
                    newStaffDeclineReason.appendChild(newDeclineReason);
                }
            }

            nNode.appendChild(newStaffDeclineReason);

        }

        return convertDocumentToXmlString(doc);
    }

    private static boolean checkIfTagPresent(String xml, String tagName) throws IOException, SAXException, ParserConfigurationException {
        Document doc = convertXmlStringToDocument(xml);

        NodeList nodeList = doc.getElementsByTagName(tagName);
        System.out.println(tagName + " TagCount ::" + nodeList.getLength() + " and TagIsPresent ::" + (nodeList.getLength() > 0));
        return nodeList.getLength() > 0;
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

    private static String createCDEDeclineReason(Map<String, String> pClientDeclineReasons, Map<String, String> pStaffDeclineReasons) {
        String CDEDeclineReasons = "<CDEDeclineReasons>";

        // Are there client decline reasons
        if ((pClientDeclineReasons != null && pClientDeclineReasons.size() > 0)) {
            System.out.println("Trace 3");
            String vClientDeclineReasonsXML = "<ClientFacingDeclineReasons>";

            Iterator<String> vDeclineCodeIterator = pClientDeclineReasons.keySet().iterator();

            while (vDeclineCodeIterator.hasNext()) {
                System.out.println("Trace 4");
                String vDeclineCode = vDeclineCodeIterator.next();
                String vDeclineReason = pClientDeclineReasons.get(vDeclineCode);

                String vClientDeclineDetails = "<ClientDeclineReason><DeclineCode>" + vDeclineCode + "</DeclineCode><DeclineReason>" + vDeclineReason + "</DeclineReason></ClientDeclineReason>";

                vClientDeclineReasonsXML = vClientDeclineReasonsXML + vClientDeclineDetails;
            }

            System.out.println("Trace 5");

            vClientDeclineReasonsXML = vClientDeclineReasonsXML + "</ClientFacingDeclineReasons>";

            System.out.println("Trace 6");

            CDEDeclineReasons = CDEDeclineReasons + vClientDeclineReasonsXML;

            System.out.println("Trace 7 >>" + CDEDeclineReasons + "<<");
        }

        // Are there staff decline reasons
        if ((pStaffDeclineReasons != null && pStaffDeclineReasons.size() > 0)) {
            System.out.println("Trace 8");
            String vStaffDeclineReasonsXML = "<StaffFacingDeclineReasons>";

            Iterator<String> vDeclineCodeIterator = pStaffDeclineReasons.keySet().iterator();

            while (vDeclineCodeIterator.hasNext()) {
                System.out.println("Trace 9");
                String vDeclineCode = vDeclineCodeIterator.next();
                String vDeclineReason = pStaffDeclineReasons.get(vDeclineCode);

                String vStaffDeclineDetails = "<StaffDeclineReason><DeclineCode>" + vDeclineCode + "</DeclineCode><DeclineReason>" + vDeclineReason + "</DeclineReason></StaffDeclineReason>";

                vStaffDeclineReasonsXML = vStaffDeclineReasonsXML + vStaffDeclineDetails;

                System.out.println("Trace 10");
            }

            vStaffDeclineReasonsXML = vStaffDeclineReasonsXML + "</StaffFacingDeclineReasons>";

            CDEDeclineReasons = CDEDeclineReasons + vStaffDeclineReasonsXML;

            System.out.println("Trace 11 >>" + CDEDeclineReasons + "<<");
        }

        CDEDeclineReasons = CDEDeclineReasons + "</CDEDeclineReasons>";

        System.out.println("Trace 12 >>" + CDEDeclineReasons + "<<");

        return CDEDeclineReasons;
    }

    private static String xValueXML() {
        return "<XArrangmentContractComponentDetail>\n" +
                "    <assessmentOutcome>\n" +
                "        <outcome>declined</outcome>\n" +
                "    </assessmentOutcome>\n" +
                "    <CrossSellDetails>\n" +
                "        <acceptanceStatus>TakenUp</acceptanceStatus>\n" +
                "        <Optionality>Optional</Optionality>\n" +
                "    </CrossSellDetails>\n" +
                "    <requestedLoanAmount>500.00</requestedLoanAmount>\n" +
                "    <originallyRequestedLoanAmount>500.00</originallyRequestedLoanAmount>\n" +
                "    <CDEDeclineReasons>\n" +
                "        <StaffFacingDeclineReasons>\n" +
                "            <StaffDeclineReason>\n" +
                "                <DeclineCode>1055</DeclineCode>\n" +
                "                <DeclineReason>Nedbank PL or RCF account in Arrears</DeclineReason>\n" +
                "            </StaffDeclineReason>\n" +
                "        </StaffFacingDeclineReasons>\n" +
                "        <ClientFacingDeclineReasons>\n" +
                "            <ClientDeclineReason>\n" +
                "                <DeclineCode>1055</DeclineCode>\n" +
                "                <DeclineReason>Our records show that you have missed payments on a previous Nedbank debt. Unfortunately you do not meet our lending criteria for this product at this time.</DeclineReason>\n" +
                "            </ClientDeclineReason>\n" +
                "        </ClientFacingDeclineReasons>\n" +
                "    </CDEDeclineReasons>\n" +
                "    <isChangeAllowed>false</isChangeAllowed>\n" +
                "    <isAppealAllowed>false</isAppealAllowed>\n" +
                "    <salesMilestones>\n" +
                "        <milestone>\n" +
                "            <agentName>Simon Mathew</agentName>\n" +
                "            <milestoneType>ArrangementCapture</milestoneType>\n" +
                "            <channelID>378</channelID>\n" +
                "            <milestoneDate>2020-08-28T16:59:52.000</milestoneDate>\n" +
                "            <agentNumber>cc308729</agentNumber>\n" +
                "            <branchCode>09700</branchCode>\n" +
                "        </milestone>\n" +
                "    </salesMilestones>\n" +
                "</XArrangmentContractComponentDetail>\n";
    }

    public static void main(String args[]) throws Exception {
        TestDeclineReasons reasons = new TestDeclineReasons();

        String clientFacingDeclineReason = "The user is not FAIS Accredited for the product. Refer user to the manager";
        String staffFacingDeclineReason = new String(clientFacingDeclineReason);

        Map<String, String> clientDeclineReasons = new HashMap<String, String>();
        Map<String, String> staffDeclineReasons = new HashMap<String, String>();
        clientDeclineReasons.put("FAIS01", clientFacingDeclineReason);
        staffDeclineReasons.put("FAIS01", staffFacingDeclineReason);

        reasons.injectDeclineReasonsXML(xValueXML(), clientDeclineReasons, staffDeclineReasons);
    }

}
