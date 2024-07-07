package teamproject.v3;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Pattern;

import lombok.Data;

@Data
public class ATM implements Serializable{

	private static final long serialVersionUID = -2619331884295674666L;
	
	private String accountNum;	// 계좌번호
	private String password;	// 비밀번호
	private String name;		// 이름
	private int balance;		// 잔액
	
	// 계좌번호를 생성하기 위한 초기화 블록(중복 x)
	{
		HashSet<String> set = new HashSet<String>();
		int min = 100000, max = 999999;
		do {
			int random = (int)(Math.random() * (max - min + 1) + min);
			accountNum = String.valueOf(random);
		}while(!set.add(accountNum));
		
		accountNum = String.format("%s-%s", accountNum.substring(0, 3), accountNum.substring(3));
	
	}
	
	public ATM(String name, String password) throws Exception {
		this.name = name;
		setPassword(password);
	}
	
	@Override
	public String toString() {
		return accountNum+"(예금주:"+name+") 잔고 : "+balance+"원";
	}
	
	// 이름과 비밀번호가 동일하다면 계좌개설이 안되게 하기 위함
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ATM other = (ATM) obj;
		return Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, password);
	}
	
	public void setPassword(String password) throws Exception {
		String regex = "^\\d{4}$";
		if(!Pattern.matches(regex, password)) {
			throw new Exception("잘못된 비밀번호 형식입니다. 다시 입력하세요.");
		}
		this.password = password;
	}
	
	public void deposit(int balance) {
		this.balance += balance;
	}
	
	public boolean withdraw(int balance) {
		if(this.balance < balance) {
			return false;
		}
		this.balance -= balance;
		return true;
	}

}
