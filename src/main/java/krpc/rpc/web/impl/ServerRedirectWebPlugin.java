package krpc.rpc.web.impl;

import java.util.Map;

import krpc.rpc.core.Plugin;
import krpc.rpc.web.RenderPlugin;
import krpc.rpc.web.WebContextData;
import krpc.rpc.web.WebPlugin;
import krpc.rpc.web.WebReq;
import krpc.rpc.web.WebRes;

public class ServerRedirectWebPlugin implements WebPlugin, RenderPlugin {
	
	String key = "redirectUrl";
	
	public void config(String paramsStr) {
		Map<String,String> params = Plugin.defaultSplitParams(paramsStr);
		String s = params.get("key");
		if ( s != null && !s.isEmpty() )
			key = s;				
	}

	public void render(WebContextData ctx,WebReq req,WebRes res) {
		String redirectUrl = res.getStringResult(key);
		if( redirectUrl == null ) redirectUrl = "";
		res.setHeader("location",redirectUrl);
		res.setHttpCode(302);
	}
	
}