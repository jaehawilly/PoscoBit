package Pack;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
class SimpleFilter extends ZuulFilter{
	@Override
	public int filterOrder() {
		return 1; // "pre"
	}
	@Override
	public String filterType() {
		return "pre"; // "post", "routing", "error"
	}
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		
		String param = request.getHeader("token");
		
		if(param == null) return null;
		
		Integer token = Integer.parseInt(param);
		
		if (!(token == 3000)) {
	    	ctx.setSendZuulResponse(false);
	    	ctx.setResponseBody("인증 실패");
	    	ctx.getResponse().setHeader("Content-Type", "text/plain;charset=UTF-8");
	    }
		
		return null;
	}
}