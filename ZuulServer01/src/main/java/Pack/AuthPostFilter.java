package Pack;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
class AuthPostFilter extends ZuulFilter {
	@Autowired
	JwtManager jwtManager;

	private final String FILTER_TYPE = "post";
	private final int FILTER_ORDER = 1;

	@Override
	public boolean shouldFilter() {
		System.out.println("Auth Post shouldFilter");

		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest req = context.getRequest();
		String uri = req.getRequestURI();
		System.out.println(uri);
		boolean excludeFiltering = uri.matches("/app.*");
		return excludeFiltering; // true일 경우 run() 실행.
	}

	@Override
	public Object run() throws ZuulException { // filtering 메서드
		System.out.println("Auth Post run");
		RequestContext context = RequestContext.getCurrentContext();
		System.out.println(context.getResponseStatusCode());
		try {
			InputStream responseDataStream = context.getResponseDataStream();
			String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));

			System.out.println(responseData);
			Member member = new Gson().fromJson(responseData, Member.class);
			System.out.println(member.getId() + ", " + member.getPw());

			if (context.getResponseStatusCode() == 400)
				return null;

			// 여기서 JWT 생성
			String token = jwtManager.generateJwtToken(member);
			System.out.println(token);

			context.setResponseBody(token);
			context.getResponse().setHeader("Content-Type", "text/plain;charset=UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	@Override
	public String filterType() {
		return FILTER_TYPE;
	}

	@Override
	public int filterOrder() {
		return FILTER_ORDER;
	}
}