package com.sayho.memoizer.util;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

public class NaverLoginUtil {
	//**Reference
	//https://www.wrapuppro.com/programing/view/X4uLaFMDTh6tVaN
	/* 인증 요청문을 구성하는 파라미터 
	CLIENT_ID : 애플리케이션 등록 후 발급받은 클라이언트 아이디
	RESPONSE_TYPE : 인증 과정에 대한 구분값. code로 고정되어 있음.
	REDIRECT_URI : 인증 결과를 전달받을 callback url. 애플리케이션 등록 시 callback url에 설정한 정보
	state : 애플리케이션이 생성한 상태 토큰
	*/
	private final static String CLIENT_ID = "a7c6RelyzCX6EJUpkB63";
	private final static String CLIENT_SECRET = "EP5dXHm7rH";
	private final static String REDIRECT_URI = "https://localhost:8080/naverLoginCallback";
	private final static String SESSION_STATE = "oauth_state";
	
	/* profile 조회 api url */
	private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid.me";
	
	//인증 요청문 형식 : https://nid.naver.com/oauth2.0/authorize?client_id={클라이언트 아이디}&response_type=code&redirect_uri={개발자 센터에 등록한 콜백 URL(URL 인코딩)}&state={상태 토큰}
	public String buildAuthUrl(String clientId,
			String responseType,
			String redirectUri,
			String stateToken) {
		String result = "https://nid.naver.com/oauth2.0/authorize?";
		result += ("client_id=" + clientId);
		result += ("&response_type=" + responseType);
		result += ("&redirect_uri=" + redirectUri);
		result += ("&state=" + stateToken);
		return result;
	}
	
	/* 네이버 아이디로 인증 URL 생성 method */
	public String getAuthorizationUrl(HttpSession session) {
		/* Session 유효성 검증을 위해 난수를 생성 */
		String state = generateRandomString();
		
		/* 생성한 난수 값을 session에 저장 */
		setSession(session, state);
		
		/* Scribe에서 제공하는 인증 URL 생성 기능을 이용하여 네아로 인증 URL 생성 */
		/*
		OAuth20Service oauthService = new ServiceBuilder()
				.apiKey(CLIENT_ID)
				.apiSecret(CLIENT_SECRET)
				.callback(REDIRECT_URI)
				.state(state) //앞서 생성한 난수값을 인증 URL생성시 사용함
				.build(NaverLoginApi.instance());
				*/
		
		return buildAuthUrl(CLIENT_ID, "code", REDIRECT_URI, state);
	}
	
	public String getAccessToken(HttpSession session, String code, String state) throws IOException {
		/* Callback으로 전달받은 세션검증용 난수값과 세션에 저장되어있는 값이 일치하는지 확인 */
		String sessionState = getSession(session);
		
		if(StringUtils.pathEquals(sessionState, state)) {
			
		}
		return null;
	}
	
	/* 세션 유효성 검증을 위한 난수 생성 */
	private String generateRandomString() {
		return UUID.randomUUID().toString();
	}
	
	/* http session에 데이터 저장 */
	private void setSession(HttpSession session, String state) {
		session.setAttribute(SESSION_STATE, state);
	}
	
	/* http session에서 데이터 가져오기 */
	private String getSession(HttpSession session) {
		return (String) session.getAttribute(SESSION_STATE);
	}
	
	/* Access Token을 이용하여 네이버 사용자 프로필 API를 호출 */
	public String getUserProfile() throws IOException {
		return "";
	}
	
}
