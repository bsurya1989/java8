package sample1;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class ParseXML2 {

    public static void main(String args[]) {
        String mdmXValue = "<XArrangmentContractComponentDetail><BaseInvestmentProduct><investorNumber>7831035710</investorNumber><investmentNumber/><investmentAmount>1000</investmentAmount><useExistingInvestorAccount/><investmentMaturityDate>2020-02-28</investmentMaturityDate><investmentInterestRates><interestPaidDayOfMonth/><duration>7</duration><interestFrequency>000</interestFrequency><interestRateExpiryDate>2020-02-21T16:00:00.000</interestRateExpiryDate></investmentInterestRates><investmentInterestRatesPayment><investmentRatePaymentMethod/><investmentPaymentBankAccount><investmentAccountName/><investmentAccountNumber/></investmentPaymentBankAccount></investmentInterestRatesPayment><investmentGeneralContactPersons><firstName/><lastName/><identityType/><identityNumber/><contactNumber/><contactMethod/></investmentGeneralContactPersons><investmentDealContactPersons><firstName/><lastName/><identityType/><identityNumber/><contactNumber/><contactMethod/></investmentDealContactPersons><investmentSourceOfFunds><investmentAccountName/><investmentAccountNumber/></investmentSourceOfFunds><investmentStatements><investmentStatementContactDetails><firstName/><lastName/><identityType/><identityNumber/><contactNumber/><contactMethod/></investmentStatementContactDetails><investmentStatementDeliveryDetails/></investmentStatements></BaseInvestmentProduct><caseID>3744941</caseID></XArrangmentContractComponentDetail>";
        String curXValue = "<XArrangmentContractComponentDetail><BaseInvestmentProduct><investorNumber>7831035710</investorNumber><investmentNumber/><investmentAmount>1000</investmentAmount><useExistingInvestorAccount/><investmentMaturityDate>2020-02-28</investmentMaturityDate><investmentInterestRates><interestPaidDayOfMonth/><interestFrequency>000</interestFrequency><interestRateExpiryDate>2020-02-21T16:00:00.000</interestRateExpiryDate></investmentInterestRates><investmentInterestRatesPayment><investmentRatePaymentMethod/><investmentPaymentBankAccount><investmentAccountName/><investmentAccountNumber/></investmentPaymentBankAccount></investmentInterestRatesPayment><investmentGeneralContactPersons><firstName>Surya</firstName><lastName>Bhadragiri</lastName><identityType/><identityNumber/><contactNumber/><contactMethod/></investmentGeneralContactPersons><investmentDealContactPersons><firstName/><lastName/><identityType/><identityNumber/><contactNumber/><contactMethod/></investmentDealContactPersons><investmentSourceOfFunds><investmentAccountName/><investmentAccountNumber/></investmentSourceOfFunds><investmentStatements><investmentStatementContactDetails><firstName/><lastName/><identityType/><identityNumber/><contactNumber/><contactMethod/></investmentStatementContactDetails><investmentStatementDeliveryDetails/></investmentStatements></BaseInvestmentProduct><caseID>3744941</caseID></XArrangmentContractComponentDetail>";
        String response = mergeXMLStrings(mdmXValue, curXValue);
        System.out.println("Response : " + response);

    }

    public static String mergeXMLStrings(String mdmXValueXml, String currentXValueXML) {
        System.out.println("Trace 1");

        String vMergedXMLString = new String(mdmXValueXml);

        // Convert both XMLs to a DOM.
        try {
            System.out.println("Trace 2");

            DocumentBuilderFactory vDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            System.out.println("Trace 3");
            DocumentBuilder vDocumentBuilder = vDocumentBuilderFactory.newDocumentBuilder();
            System.out.println("Trace 4");

            ByteArrayInputStream vMergeIntoXMLStringByteArrayInputStream = new ByteArrayInputStream(mdmXValueXml.getBytes());
            System.out.println("Trace 5");
            ByteArrayInputStream vXMLStringToMergeByteArrayInputStream = new ByteArrayInputStream(currentXValueXML.getBytes());
            System.out.println("Trace 6");

            Document vMergeIntoXMLDocument = vDocumentBuilder.parse(vMergeIntoXMLStringByteArrayInputStream); // MDM
            System.out.println("Trace 7");
            Document vXMLDocumentToMerge = vDocumentBuilder.parse(vXMLStringToMergeByteArrayInputStream); // current
            System.out.println("Trace 8 MDM >>" + getXMLStringFromXMLDocument(vMergeIntoXMLDocument) + "<<");
            System.out.println("Trace 9 Current >>" + getXMLStringFromXMLDocument(vXMLDocumentToMerge) + "<<");

            // Loop through all the root elements on the document to merge to
            // get a list of elements to merge into the base document.
            NodeList vXMLDocumentToMergeChildNodes = getRootElementChildNodes(vXMLDocumentToMerge); // current
            System.out.println("Trace 10");
            NodeList vMergeIntoXMLDocumentChildNodes = getRootElementChildNodes(vMergeIntoXMLDocument); // MDM
            System.out.println("Trace 11");

            int mergeIntoCount = vMergeIntoXMLDocumentChildNodes.getLength(); // MDM Count
            System.out.println("Trace 12  >> " + mergeIntoCount);

            for (int i = 0; i < vXMLDocumentToMergeChildNodes.getLength(); i++) { // looping current request
//				System.out.println("Trace 13 >>" + vXMLDocumentToMergeChildNodes.item(i).getNodeName() + "<<");

                boolean vNodeFoundInXML = false;
                System.out.println("Trace 14");
                // Loop through the child nodes of the item we want to merge
                // into and look for a matching node.
                for (int j = 0; j < vMergeIntoXMLDocumentChildNodes.getLength(); j++) { // looping MDM
                    System.out.println("Trace 15 >>" + vMergeIntoXMLDocumentChildNodes.item(j).getNodeName() + "<<");

                    if (elementsMatchOnBusinessKeys(vXMLDocumentToMergeChildNodes.item(i), vMergeIntoXMLDocumentChildNodes.item(j))) {
                        System.out.println("Elements matched " + vXMLDocumentToMergeChildNodes.item(i).getNodeName());
                        if (vXMLDocumentToMergeChildNodes.item(i).getNodeName().equalsIgnoreCase("BaseInvestmentProduct")) {
                            HashMap<String, String> keyValues = new HashMap<String, String>();
                            HashMap<String, String> xPathExpressions = new HashMap<String, String>();
                            xPathExpressions.put("interestRate", "//*[local-name()='XArrangmentContractComponentDetail']/*[local-name()='BaseInvestmentProduct']/*[local-name()='investmentInterestRates']/*[local-name()='interestRate']/text()");
                            xPathExpressions.put("duration", "//*[local-name()='XArrangmentContractComponentDetail']/*[local-name()='BaseInvestmentProduct']/*[local-name()='investmentInterestRates']/*[local-name()='duration']/text()");
                            loopBaseInvetmentProductElement(vMergeIntoXMLDocument, keyValues, xPathExpressions);
                            System.out.println("Size::: " + keyValues.size());
                            if (keyValues.size() > 0)
                                addSensitiveFieldsToRequest(vXMLDocumentToMerge, keyValues);
                        }

                        Node vNewNode = vMergeIntoXMLDocument.importNode(vXMLDocumentToMergeChildNodes.item(i), true);
                        System.out.println("Trace 16");
                        vMergeIntoXMLDocumentChildNodes.item(j).getParentNode().replaceChild(vNewNode, vMergeIntoXMLDocumentChildNodes.item(j));
                        System.out.println("Trace 17");
                        vNodeFoundInXML = true;
//                    }
                        System.out.println("Trace 18");
                    }

                    System.out.println("Trace 19");
                }

                if (!vNodeFoundInXML) {
                    System.out.println("Trace 20");

                    // We need to insert the node.
                    Node vNewNode = vMergeIntoXMLDocument.importNode(vXMLDocumentToMergeChildNodes.item(i), true);
                    System.out.println("Trace 21");
                    if (!elementShouldGroup(vNewNode, vMergeIntoXMLDocument)) {
                        System.out.println("Trace 22");
                        vMergeIntoXMLDocument.getChildNodes().item(0).appendChild(vNewNode);
                    }
                    System.out.println("Trace 23");
                }
            }

            System.out.println("Trace 24");

            int finalMergeIntoCount = getRootElementChildNodes(vMergeIntoXMLDocument).getLength();
            System.out.println("Trace 25 - final:" + finalMergeIntoCount + " before:" + mergeIntoCount);
            if (finalMergeIntoCount < mergeIntoCount)
                System.out.println("Failed here with count");

            vMergedXMLString = getXMLStringFromXMLDocument(vMergeIntoXMLDocument);

            System.out.println("Trace 26 >>" + vMergedXMLString + "<<");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Trace 27");
        return vMergedXMLString;
    }

    private static String getXMLStringFromXMLDocument(Document pDocument) {
        System.out.println("Trace 1");

        try {
            Transformer vTransformer = TransformerFactory.newInstance()
                    .newTransformer();
            System.out.println("Trace 2");
            vTransformer.setOutputProperty(OutputKeys.INDENT, "no");
            System.out.println("Trace 3");
            vTransformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
                    "yes");
            System.out.println("Trace 3");
            vTransformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "2");
            System.out.println("Trace 4");

            // initialize StreamResult with File object to save to file
            StreamResult vStreamResult = new StreamResult(new StringWriter());
            System.out.println("Trace 5");
            DOMSource vDOMSource = new DOMSource(pDocument);
            System.out.println("Trace 6");
            vTransformer.transform(vDOMSource, vStreamResult);
            System.out.println("Trace 7");
            String vXMLlString = vStreamResult.getWriter().toString();
            System.out.println("Trace 8");
            return vXMLlString;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static NodeList getRootElementChildNodes(Document pDocument) {
        System.out.println("Trace 1");
        return pDocument.getChildNodes().item(0).getChildNodes();
    }

    private static boolean elementsMatchOnBusinessKeys(Node pLeftNode, Node pRightNode) {
        System.out.println("Trace 1");
        if (pLeftNode.getNodeName().equalsIgnoreCase("bankAccount")) {
            System.out.println("Trace 3");
            // Check the bank account type
            NodeList vLeftChildNodeList = pLeftNode.getChildNodes();
            System.out.println("Trace 4");
            NodeList vRightChildNodeList = pRightNode.getChildNodes();
            System.out.println("Trace 5");

            for (int i = 0; i < vLeftChildNodeList.getLength(); i++) {
                System.out.println("Trace 6");
                if (vLeftChildNodeList.item(i).getNodeName().equalsIgnoreCase("type")) {
                    System.out.println("Trace 7");
                    for (int j = 0; j < vRightChildNodeList.getLength(); j++) {
                        System.out.println("Trace 8");
                        if (vRightChildNodeList.item(j).getNodeName().equalsIgnoreCase("type")) {
                            System.out.println("Trace 9");
                            return vLeftChildNodeList.item(i).getTextContent().equalsIgnoreCase(vRightChildNodeList.item(j).getTextContent());
                        }
                    }
                }
            }

            System.out.println("Trace 10");
            // Shouldn't get here if there's a match
            return false;
        } else if (pLeftNode.getNodeName().equalsIgnoreCase("interest")) {
            System.out.println("Trace 11");
            // Check the bank account type
            NodeList vLeftChildNodeList = pLeftNode.getChildNodes();
            System.out.println("Trace 12");
            NodeList vRightChildNodeList = pRightNode.getChildNodes();
            System.out.println("Trace 13");
            for (int i = 0; i < vLeftChildNodeList.getLength(); i++) {
                System.out.println("Trace 14");
                if (vLeftChildNodeList.item(i).getNodeName()
                        .equalsIgnoreCase("type")) {
                    System.out.println("Trace 15");
                    for (int j = 0; j < vRightChildNodeList.getLength(); j++) {
                        System.out.println("Trace 16");
                        if (vRightChildNodeList.item(j).getNodeName()
                                .equalsIgnoreCase("type")) {
                            System.out.println("Trace 17");
                            return vLeftChildNodeList
                                    .item(i)
                                    .getTextContent()
                                    .equalsIgnoreCase(
                                            vRightChildNodeList.item(j)
                                                    .getTextContent());
                        }
                    }
                }
            }

            System.out.println("Trace 18");
            // Shouldn't get here if there's a match
            return false;
        } else {
//			System.out.println(pLeftNode.getNodeName());
            System.out.println("Trace 19" + pLeftNode.getNodeName().equalsIgnoreCase(
                    pRightNode.getNodeName()));
            return pLeftNode.getNodeName().equalsIgnoreCase(
                    pRightNode.getNodeName());
        }
    }

    private static boolean elementShouldGroup(Node node, Document document) {
        System.out.println("Trace 1");
        // Check if the node should be merged at a different location in the XML
        // to keep the structure grouped
        NodeList nodeList = getRootElementChildNodes(document);
        System.out.println("Trace 2");
        if (node.getNodeName().equalsIgnoreCase("bankAccount")) {
            System.out.println("Trace 3");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Trace 4");
                Node findNode = nodeList.item(i);
//				NodeList findNodeChildren = findNode.getChildNodes();
//				String nodeType = "";
//				String findNodeType = "";
//				for (int j = 0; j < node.getChildNodes().getLength(); j++) {
//				       if (node.getChildNodes().item(j).getNodeName()
//						.equalsIgnoreCase("type")) {
//						    nodeType = node.getChildNodes().item(j)
//									.getTextContent();
//						}
//				}
//				for (int j = 0; j < findNodeChildren.getLength(); j++) {
//				       if (findNodeChildren.item(j).getNodeName()
//						.equalsIgnoreCase("type")) {
//						    findNodeType = findNodeChildren.item(j)
//									.getTextContent();
//						}
//				}
                System.out.println("Trace 5");
                if (findNode.getNodeName().equalsIgnoreCase("AcceptedEvidence")) {
                    System.out.println("Trace 6");
                    document.getChildNodes().item(0)
                            .insertBefore(node, nodeList.item(i + 1));
                    System.out.println("Trace 7");
                    return true;
                }
            }
        }
        System.out.println("Trace 8");
        return false;
    }

    private static void addSensitiveFieldsToRequest(Document vXMLDocumentToMerge, HashMap<String, String> keyValues) {
        NodeList nodeInterestFrequency = vXMLDocumentToMerge.getElementsByTagName("interestFrequency");

        for (Map.Entry<String,String> entry : keyValues.entrySet()) {
            Text value = vXMLDocumentToMerge.createTextNode(entry.getValue());
            Element xmlElement = vXMLDocumentToMerge.createElement(entry.getKey());
            xmlElement.appendChild(value);

            nodeInterestFrequency.item(0).getParentNode().insertBefore(xmlElement, nodeInterestFrequency.item(0));
        }
    }

    private static void loopBaseInvetmentProductElement(Document mdmXvalueXML, HashMap<String, String> hm, HashMap<String, String> expressions) {
        // Sensitive Field - interest rate
        for (Map.Entry<String, String> entry : expressions.entrySet()) {
            XPathFactory xpathfactory = XPathFactory.newInstance();
            XPath xpath = xpathfactory.newXPath();
            String expression = entry.getValue();
            XPathExpression expr = null;
            try {
                expr = xpath.compile(expression);
                Object result = expr.evaluate(mdmXvalueXML, XPathConstants.NODESET);
                NodeList nodes = (NodeList) result;
                for (int i = 0; i < nodes.getLength(); i++) {
                    System.out.println(entry.getKey() + ":::" +nodes.item(i).getNodeValue());
                    hm.put(entry.getKey(), nodes.item(i).getNodeValue());
                }
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
        }
    }

}
