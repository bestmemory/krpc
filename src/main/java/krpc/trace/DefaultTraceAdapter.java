package krpc.trace;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultTraceAdapter implements TraceAdapter {

	public DefaultTraceAdapter(Map<String,String> params) {
	}
	
	public void init() {}
	
	public void close() {}
	
	public void send(TraceContext ctx, Span span) {
	}
	
	public String newTraceId() {
		String s = UUID.randomUUID().toString();
	    return s.replaceAll("-", "");		
	}
	
	public String newZeroRpcId(boolean isServer) {
		if( isServer)
			return "0.1";
		else
			return "0";
	}
	
	public String newEntryRpcId(String parentRpcId) {
		return parentRpcId;
	}
	
	public String newChildRpcId(String parentRpcId,AtomicInteger subCalls) {
		return parentRpcId+"."+subCalls.incrementAndGet();  // 0.1.1.1
	}

} 