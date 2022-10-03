import java.io.IOException;
import java.util.*;

public class Ex02 {
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		String infixa, posfixa;
		String n1, n2, n3, n4, n5, n6;
		
		System.out.println("Digite a expressão: ");
		infixa = key.nextLine();
		infixa = infixa.toUpperCase();
		posfixa = traduzir(infixa);
		System.out.println("Expressão pós-fixa: " +posfixa);
		infixa = (((((infixa.replace("A", "n1")).replace("B", "n2")).replace("C", "n3")).replace("D", "n4")).replace("E", "n5")).replace("F", "n6");
		System.out.println("Digite o número: ");
		n1 = key.nextLine();
		System.out.println("Digite o número: ");
		n2 = key.nextLine();
		System.out.println("Digite o número: ");
		n3 = key.nextLine();
		System.out.println("Digite o número: ");
		n4 = key.nextLine();
		System.out.println("Digite o número: ");
		n5 = key.nextLine();
		System.out.println("Digite o número: ");
		n6 = key.nextLine();
		
}

	private static String traduzir(String infixa) {
		Stack<Character> pilha = new Stack<Character>();
		String posfixa = "";
		char ch;
		for(int i = 0; i < infixa.length(); i++) {
			ch = infixa.charAt(i);
			if(ch != ' ') {
				switch(ch) {
					case '+':
					case '-':
					case '*':
					case '/':
					case '%':
					case '^':
						while(!pilha.isEmpty() && (prioridade(pilha.peek()) >= prioridade(ch))) {
							posfixa += pilha.pop();
							
						}
						pilha.push(ch);
						break;
					case '(':
						pilha.push(ch);
						break;
					case ')':
						while(pilha.peek() != '(') {
							posfixa += pilha.pop();
							
						}
						pilha.pop();
						break;
					default:
						posfixa += ch;
						
						
				}
			}
		}	
	
		// se sobrar algum operador na pilha: 
		while(!pilha.isEmpty()) {
			posfixa += pilha.pop();
		}
	
		return posfixa;
	}

	private static int prioridade(char ch) {

		int p = 0;
		switch(ch) {
			case '(':
				p = 1;
				break;
			case '+':
			case '-':
				p = 2;
				break;
			case '*':
			case '/':
			case '%':
				p = 3;
				break;
			case '^':
				p = 4;
		}
		
		return p;
	}
	
	
	
	 public static int calcular(String conta, int left, int right) {
	        switch (conta) {
	            case "+": return left + right;
	            case "-": return left - right;
	            case "*": return left * right;
	            case "/": {
	                if (right == 0) {
	                    System.out.println("Número inválido");
	                    return left;
	                }
	                return left / right;
	            }
	            default: return left;

	        }
			System.out.println("O valor da sua expressão é: " +left);
   
	 }
}
