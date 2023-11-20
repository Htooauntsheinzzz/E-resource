package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import beans.biblioxml;
import dao.XmlDaoTest;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LibraryController {
	
	
	
	  @Autowired
	  @Qualifier("xmlDaoTest")
	  private XmlDaoTest dao;
	  // Autowire your data source
	

	@GetMapping("/xmlform")
		public String createBiblio(Model m,HttpServletRequest req, HttpServletResponse res) {
			// For View collection Form
		
		m.addAttribute("command", new biblioxml());
		
		return "xml";
			}
	
			
	
			  @RequestMapping(value = "/createXML", method = RequestMethod.POST)
			    @ResponseBody
			    
			    public String generateXML(@RequestBody String xmlData) {
			        String inputData = xmlData;
			        System.out.println(inputData);
			        
			        // Decode URL-encoded data
			        Map<String, String> decodedData = decodeUrlEncodedData(inputData);

			        // Construct XML from the decoded data
			        StringBuilder xmlBuilder = new StringBuilder();
			        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<record>\n");

			        for (Map.Entry<String, String> entry : decodedData.entrySet()) {
			            String key = entry.getKey();
			            String value = entry.getValue();
			            String[] parts = key.split(",");
			            if (parts.length == 2) {
			                String tag = parts[0];
			                String subfield = parts[1];
			                xmlBuilder.append("\t<datafield tag=\"").append(tag).append("\">\n");
			                xmlBuilder.append("\t\t<subfield code=\"").append(subfield).append("\">").append(value).append("</subfield>\n");
			                xmlBuilder.append("\t</datafield>\n");
			            }
			        }

			        xmlBuilder .append("</record>");
			      String xml = xmlBuilder.toString();
					 dao.saveXml(xml); 
			        System.out.println(xml);
			        return xml;
			    }
			
			    // Method to decode URL-encoded data
			    private Map<String, String> decodeUrlEncodedData(String data) {
			        Map<String, String> decodedData = new HashMap<>();
			        String[] pairs = data.split("&");
			        System.out.println(pairs);
			        for (String pair : pairs) {
			            String[] keyValue = pair.split("=");
			            if (keyValue.length == 2) {
			                String key = java.net.URLDecoder.decode(keyValue[0], java.nio.charset.StandardCharsets.UTF_8);
			                String value = java.net.URLDecoder.decode(keyValue[1], java.nio.charset.StandardCharsets.UTF_8);
			                decodedData.put(key, value);
			            }
			        }
			        System.out.println(decodedData);
			        return decodedData;
			    }

	

		

	}





