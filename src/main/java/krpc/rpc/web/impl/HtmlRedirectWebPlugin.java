package krpc.rpc.web.impl;

import java.util.Map;

import krpc.rpc.core.Plugin;
import krpc.rpc.web.RenderPlugin;
import krpc.rpc.web.WebContextData;
import krpc.rpc.web.WebPlugin;
import krpc.rpc.web.WebReq;
import krpc.rpc.web.WebRes;

public class HtmlRedirectWebPlugin implements WebPlugin, RenderPlugin {
	
	String key = "redirectUrl";
	
	public void config(String paramsStr) {
		Map<String,String> params = Plugin.defaultSplitParams(paramsStr);
		String s = params.get("key");
		if ( s != null && !s.isEmpty() )
			key = s;				
	}
	String htmlStart = "<!DOCTYPE html><html><body><script language=\"javascript\">window.location.href=\"";
	String htmlEnd = "\"</script></body></html>";

	public void render(WebContextData ctx,WebReq req,WebRes res) {
		String redirectUrl = res.getStringResult(key);
		if( redirectUrl == null ) redirectUrl = "";
		String content = htmlStart + redirectUrl + htmlEnd;
		res.setContent(content);
		res.setContentType("text/html");
	}
	
}