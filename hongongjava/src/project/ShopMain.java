package project;

import java.util.List;
import java.util.Scanner;

public class ShopMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("나는 누구인가요?");
		while(true) {
			System.out.print("1.점원 / 2.손님 > ");
			String mode = sc.nextLine();
			
			
			if(mode.equals("1")) { //점원
				mode = "emp";
				EmpMode();
				break;
			}else if(mode.equals("2")) { //손님
				mode = "cus";
				CusMode();
				break;
			}else {
				System.out.println("값을 잘못 입력하셨습니다.");
			}
		}
	}

	static void EmpMode() {
		String type = "";
		String cate = "";
		String code = "";
		String name = "";
		int price = 0;
		String cnt = "";
		int rsCnt = 0;
		
		ProductDao pdao = null;
		pdao = new ProductDao();
		
		BoardDao bdao = null;
		bdao = new BoardDao();
		
		Product product = new Product(code, cate, name, price, cnt);
		boolean run = true;
		while(run) {
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("1. 현재 재고 파악 | 2. 상품 등록 | 3. 상품 변경 | 4. 상품 삭제 | 5. 카테고리별 매출현황 | 6. 공지사항 | 7. 종료");
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.print("▶ 메뉴선택 : ");
			int temp = sc.nextInt();
			sc.nextLine();
			
			switch(temp) {
				case 1:				
					
					System.out.println("---------------------------------------------------------------------------------------------");
					System.out.println("번호\t|상품코드\t|카테고리\t|상품명\t|가격\t|수량\t|별점\t");
					System.out.println("---------------------------------------------------------------------------------------------");
					pdao.productList();
					
					List<Product> list = pdao.productList();
					for(Product pro : list) {
						System.out.println(pro.toString());
					}
					
					System.out.println("D : 상품상세정보");
					System.out.println("Q : 메뉴");
					System.out.print(">");
					type = sc.nextLine();
					
					if(type.equals("d") || type.equals("D")) {
						System.out.println("**********상품 상세정보**********");
						System.out.print("상품코드를 입력해주세요> ");
						code = sc.nextLine();
						
						pdao.productDetail(code);
						
						System.out.println("Q : 메뉴");
						System.out.print(">");
						type = sc.nextLine();
						
						if(type.equals("q") || type.equals("Q")) {
							break;
						}
					}else {
						break;
					}
					
				case 2:		
					System.out.print("등록할 상품의 상품코드>");
					code = sc.nextLine();
					
					System.out.print("등록할 상품의 카테고리>");
					cate = sc.nextLine();
					
					System.out.print("등록할 상품명>");
					name = sc.nextLine();
					
					System.out.print("등록할 상품의 가격>");
					price = Integer.parseInt(sc.nextLine());
					
					System.out.print("등록할 상품의 수량>");
					cnt = sc.nextLine();
					
					rsCnt = pdao.productInsert(product);
					
					if(rsCnt > 0){
						System.out.println("상품이 등록되었습니다.");
					}else {
						System.out.println("상품등록 실패\n관리자에게 문의하세요");						
					}
					break;
					
					
				case 3:				
					System.out.print("변경할 상품의 상품코드>");
					code = sc.nextLine();
					
					System.out.println("-----------------------------");
					pdao.productSearch(code);
					System.out.println("-----------------------------");
					
					System.out.print("변경할 상품의 카테고리>");
					cate = sc.nextLine();
					
					System.out.print("변경할 상품명>");
					name = sc.nextLine();
					
					System.out.print("변경할 상품의 가격>");
					price = Integer.parseInt(sc.nextLine());
					
					System.out.print("변경할 상품의 수량>");
					cnt = sc.nextLine();
					
					rsCnt = pdao.productUpdate(product);
					
					if(rsCnt > 0){
						System.out.println("상품정보가 변경되었습니다.");
					}else {
						System.out.println("상품변경 실패\n관리자에게 문의하세요");						
					}
					break;
					
					
				case 4:
					System.out.print("삭제할 상품의 상품코드>");
					code = sc.nextLine();
					
					System.out.println("-----------------------------");
					pdao.productSearch(code);
					System.out.println("-----------------------------");
					
					System.out.print("상품을 정말 삭제하시겠습니까? (Y/N) > ");
					type = sc.nextLine();
					
					if(type.equals("Y") || type.equals("y")) {
						rsCnt = pdao.productDelete(code);
						if(rsCnt > 0){
							System.out.println("상품을 삭제하였습니다.");
						}else {
							System.out.println("상품삭제 실패\n관리자에게 문의하세요");						
						}
						break;
					} else {
						break;
					}
					
				case 5:					
					System.out.println("----------------------------------------------------------------");
					System.out.println("순위\t|카테고리\t|통합 판매량\t|월간 판매량\t|주간 판매량");
					System.out.println("----------------------------------------------------------------");

					pdao.productStats("1");
					break;
				
				case 6:

					System.out.println("---------------------------------------------------------------------------------------------");
					System.out.println("번호\t|게시글코드\t|제목\t|등록일");
					System.out.println("---------------------------------------------------------------------------------------------");
					bdao.noticeList();
					
					List<Notice> list2 = bdao.noticeList();
					for(Notice no : list2) {
						System.out.println(no.toString());
					}
					
					System.out.println("W : 공지추가");
					System.out.println("D : 공지삭제");
					System.out.println("E : 공지수정");
					System.out.println("Q : 메뉴");
					System.out.print(">");
					type = sc.nextLine();
					
					if(type.equals("d") || type.equals("D")) {
						System.out.print("삭제할 게시글 코드>");
						code = sc.nextLine();
						
						System.out.print("게시글을 정말 삭제하시겠습니까? (Y/N) > ");
						type = sc.nextLine();
						
						if(type.equals("Y") || type.equals("y")) {
							rsCnt = bdao.noticeDelete(code);
							if(rsCnt > 0){
								System.out.println("게시글을 삭제하였습니다.");
							}else {
								System.out.println("게시글 삭제 실패\n관리자에게 문의하세요");						
							}
							break;
						} else {
							break;
						}
					}else {
						break;
					}
					
				default:
					System.out.println("잘못된 값이 입력되었습니다.");
			}
		}//end of while
	
	}
	
	static void CusMode() {
		
	}
}
