package quiz;

public class Quiz6_1 {
	



//	멜론
//	노래, 가수, 소속사, 장르
//	발매일, 가사
	
	String platform="멜론"; //멜론
	String music; //노래
	String signer; // 가수
	String agency; // 소속사
	String genre; // 장르
	String day; // 발매일
	String lyrics; // 가사

//	1. Song, SongExam
//	제목, 가수, 재생시간, 가사
//	재생, 일시정지, 멈춤, 정보보기
//	생성자, setter, getter


//	2. 로그인
//	* 단, 계정이란 : 아이디 비밀번호
//	private으로 저장되어있는 계정 정보가 이미 있음
//  시도 시 계정은 필수


//	메소드명 : loginCheck
//	시도한 계정과 저장된 계정을 비교
//	결과를 알려줌


//	메소드명 : doLogin
//	loginCheck를 호출해서 
//	결과를 받고
//	결과에 따라 메인페이지로 보내기 / "계정이 없습니다" 출력

//	메소드명 : goMain
//	"환영합니다 {id}님" 출력


//	2.1 로그인 심화 1
//	계정이 두개 이상 있음
//	그 중 하나는 관리자 계정(id:admin)
//	goMain에서 계정에따라 
//	"관리자 페이지 입니다." / "{id}님 환영합니다"

	
//	2.2 로그인 심화 2
//	회원가입 기능 추가
//	loginCheck에서 가입된 회원 계정인지 판단
//	단, admin 계정은 미리 저장된 상태로 시작

//	*. 원카드
//	모양 2~4개
//	숫자 1~9
//	카드를 나누어 갖기
//	낼 수 있는 카드 : 같은 모양 또는 같은 숫자
//	1. 첫 차례는 첫번째 카드 내기
//	2. 낼 수 있는 경우 무조건 내기
//	(두개 이상인 경우 첫번째 카드 내기)
//	3. 낼 수 없는 경우 카드 추가
//	승패 결정

//	**. 오목
//	10x10 이상에서
//	가로, 세로, 정 대각선 두방향으로 
//	5개가 연결되면 승리
//	표시는 x와 o로


}
