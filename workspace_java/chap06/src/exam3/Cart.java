package exam3;

import java.util.ArrayList;

public class Cart {

	private ArrayList list = new ArrayList(); // 장바구니
//	상품을 전달받아
//	장바구니에 추가

	boolean add(Goods goods) {
		if (goods != null) {
			this.list.add(goods);
			return true;
		} else {
			return false;
		}
	}

//	장바구니에 담긴 모든 상품의 가격의 합을 출력
	int print() {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			Goods g = (Goods) list.get(i);
			System.out.println("상품명 : " + g.getName() + "\t가격 : " + g.getPrice());
			sum += g.getPrice();
		}
		System.out.println("---------------------");
		System.out.println("합계 : " + sum);

		return sum;
	}
}
