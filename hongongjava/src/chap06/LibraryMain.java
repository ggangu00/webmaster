package chap06;

import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		int libCnt = 0;
		int sum=0;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		Library[] books = null;
		
		while(run) {			
			System.out.println("-----------------------------------------------------------");
			System.out.println("1. 도서 수 입력 | 2. 도서 입력 | 3. 도서목록 조회 | 4. 도서분석 | 5. 종료");
			System.out.println("-----------------------------------------------------------");
			System.out.print("▶ 번호 선택 : ");
			int temp = sc.nextInt();
			sc.nextLine();
			
			switch(temp) {
				case 1:
					System.out.print("도서 수 입력 > ");
					libCnt = sc.nextInt();
					sc.nextLine();
					books = new Library[libCnt];
					break;
				case 2:
					for(int i=0; i<libCnt; i++) {
						
						System.out.print((i+1)+"번째 도서명 입력> ");
						String name = sc.nextLine();
						
						System.out.print((i+1)+"번째 도서번호 입력> ");
						String num = sc.nextLine();
						
						System.out.print((i+1)+"번째 도서가격 입력> ");
						int price = Integer.parseInt(sc.nextLine());
						System.out.println();
						
						books[i] = new Library(name, num, price);
					}
					
					break;
				case 3:
					for(Library book:books) {
						System.out.printf("%s\t%s\t%d\n", book.getName(), book.getNum(), book.getPrice());
					}
					break;
				case 4:
						for(Library book:books) {
							int p = book.getPrice();
							sum += p;
							if(max < p)max = p;
							if(min > p)min = p;	
						}	
						System.out.println("도서 가격 합 : "+sum);
						System.out.println("도서 최대가격 : "+max);
						System.out.println("도서 최소가격 : "+min);						
					break;
				case 5:
					run = false;
					break;
				default:
					System.out.println("잘못된 값이 입력되었습니다.");
			}	
			
		}
		System.out.println("program end");
		sc.close();

	}

}
