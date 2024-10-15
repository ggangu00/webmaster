package 박주현;

import java.util.Scanner;

public class BankApp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account[] ac = new Account[100];
		
		boolean run = true;
		int num = 0;
		String searchNo = "";
		int cnt = 0;
		
		while(run) {			
			System.out.println("--------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("--------------------------------------");
			System.out.print("▶ 번호 선택 : ");
			int temp = sc.nextInt();
			sc.nextLine();
			
			switch(temp) {
				case 1:
					System.out.println("****************계좌생성****************");
					
					for(int i=num; i<ac.length; i++) {
						if(ac[i] == null) {
							ac[i] = new Account();
							System.out.print("계좌번호> ");
							String newAc = sc.nextLine();
							ac[i].setNo(newAc);
							
							System.out.print("계좌주> ");
							ac[i].setOwner(sc.nextLine());
							
							System.out.print("초기입금액> ");
							ac[i].setBalence(sc.nextInt());
							sc.nextLine();
							
							System.out.println("결과 : 계좌가 생성되었습니다.");
							num = i;
							break;
						}	
					}		
					break;
				case 2:
					System.out.println("*************************");
					System.out.println("순번|계좌번호\t|계좌주\t|잔고");
					System.out.println("*************************");
					
					for(Account ele:ac) {
						cnt++;
						if(ele != null) {
							System.out.printf("%d번|%s\t|%s\t|%d\n", cnt, ele.getNo(), ele.getOwner(), ele.getBalence());		
						}else {
							break;
						}
					}
					break;
				case 3:
					System.out.println("*****************예금*****************");
					
					System.out.print("계좌번호> ");
					searchNo = sc.nextLine();
					
					System.out.print("예금액> ");
					int inMoney = Integer.parseInt(sc.nextLine());	
					
					for(Account ele:ac) {
						if(ele.getNo().equals(searchNo)) {
							ele.setBalence(ele.getBalence()+inMoney);
							break;
						}
						System.out.println();
					}
					
					break;
				case 4:
					System.out.println("*****************출금*****************");
					
					System.out.print("계좌번호> ");
					searchNo = sc.nextLine();
					
					System.out.print("출금액> ");
					int outMoney = Integer.parseInt(sc.nextLine());	
					
					for(Account ele:ac) {
						if(ele.getNo().equals(searchNo)) {
							ele.setBalence(ele.getBalence()-outMoney);
							break;
						}
						System.out.println();
					}
					
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
