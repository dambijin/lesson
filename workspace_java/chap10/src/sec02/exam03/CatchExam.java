package sec02.exam03;

public class CatchExam {

	public static void main(String[] args) {

		try {

			System.out.println(1);
//			System.out.println(args[10]);
			System.out.println(2);

			String a = "abc";
			int b = Integer.parseInt(a);
			System.out.println(b + 1);
		} catch (ArrayIndexOutOfBoundsException e) {
			// }catch(Exception e){
			System.out.println("ArrayIndexOutOfBoundsException 예외 발생");
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException 예외 발생");
		} catch (Exception e) {
			System.out.println("그 외 예외");
		} finally {
			System.out.println("무조건 실행");
		}
		System.out.println("완료");
	}

}
