package test;

import java.io.IOException;
import java.util.ArrayList;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;

public class XuLy {
	public ArrayList<String> getLinkBiLuTV(String link) {
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60);
	    webClient.getOptions().setJavaScriptEnabled(true);
	    webClient.getOptions().setThrowExceptionOnScriptError(false);
	    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
	    webClient.waitForBackgroundJavaScript(1000);
	    webClient.waitForBackgroundJavaScriptStartingBefore(1000);
	    webClient.getOptions().setCssEnabled(false);
	    HtmlPage page = null;
		try {
			page = webClient.getPage(link);
		} catch (IOException e) {
			e.printStackTrace();
		}
		webClient.close();
		
		// lấy chiều dài link
	    ScriptResult scriptResult = page.executeJavaScript("playerSetting.sourceLinks.length");
	    Double sizeLink = (Double) scriptResult.getJavaScriptResult();
	    
	    // link video
	    ArrayList<String> links = new ArrayList<>();
	    for(int i=0; i<sizeLink; i++) {
	    	scriptResult = page.executeJavaScript("playerSetting.sourceLinks["+i+"].links[0].file");
	    	links.add((String) scriptResult.getJavaScriptResult());
	    }
	    
	    return links;
	}
	
	public String getLinkAnimeHay(String link) {
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60);
	    webClient.getOptions().setJavaScriptEnabled(true);
	    webClient.getOptions().setThrowExceptionOnScriptError(false);
	    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
	    webClient.waitForBackgroundJavaScript(1000);
	    webClient.waitForBackgroundJavaScriptStartingBefore(1000);
	    webClient.getOptions().setCssEnabled(false);
	    HtmlPage page = null;
		try {
			page = webClient.getPage(link);
		} catch (IOException e) {
			e.printStackTrace();
		}
		webClient.close();
	    ScriptResult scriptResult = page.executeJavaScript("infoLoad.link_main");
	    String result = (String) scriptResult.getJavaScriptResult();
	    return result;
	}
	
	public String covertFromStringToJson(ArrayList<String> result) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		for(int i=0; i<result.size(); i++) {
			json.append("{");
			json.append("link: "+result.get(i));
			json.append("}");
			if(result.size()-1 != i) {
				json.append(",");
			}
		}
		json.append("]");
		return json.toString();
	}
	
//    ScriptResult scriptResult = page.executeJavaScript("HTML5_PLAYER.player._options.source");
//    System.out.println(scriptResult.getJavaScriptResult());
}
