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
	public String getLinkZingTV(String link) {
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60);
	    webClient.getOptions().setJavaScriptEnabled(false);
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
		String xml = page.asXml();
		String player = getPlayer(xml);
		String sourceLevel = getSourceLevel(player);
		String result = "["+sourceLevel+"]";
	    return result;
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
	
	public String getLinkPhimMoi(String link) {
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60);
	    webClient.getOptions().setJavaScriptEnabled(false);
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
		String xml = page.asXml();
		
	    return xml;
	}

	private static String getSourceLevel(String player) {
		int indexbd = player.indexOf("sourceLevel");
		indexbd = player.indexOf("[", indexbd);
		String result = player.substring(indexbd+1);
		return result;
	}

	private static String getPlayer(String xml) {
		int indexbd = xml.indexOf("HTML5_PLAYER.player");
		int indexkt = xml.indexOf("]", indexbd);
		String result = xml.substring(indexbd, indexkt);
		return result;
	}
	
	
//    ScriptResult scriptResult = page.executeJavaScript("HTML5_PLAYER.player._options.source");
//    System.out.println(scriptResult.getJavaScriptResult());
}
