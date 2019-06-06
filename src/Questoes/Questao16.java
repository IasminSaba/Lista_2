package Questoes;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class Questao16 {
	
	
	public void construirRwTrie(BufferedReader stringD,RwTries rw) throws IOException {

		try {
		String lines = stringD.readLine();
				
		while(lines!=null) {
			
			String string = stringD.readLine();
			String[] temp = string.split(" \\(");
			char[] caracteres = temp[0].toCharArray();
			
			String y = "";
				for(int u = 0;u<caracteres.length;u++) 
					y = y+normalizar(caracteres[u]);;
	
			System.out.println(y);
			rw.put(y, temp[0]);
			
			lines = stringD.readLine();
		}
		}catch(Exception e) {
			System.out.println();
		}
	}
	
	public String normalizarCasosEspeciais(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	
	public char normalizar(char c) {
		int n = (int) c;
		if(n>=65 && n<= 90) {
			n = n + 32;
			return (char) n;
		}
		else if((n<=57 && n>=48) || (n>=97 && n<=122))return c;
		else if(n==146 || n == 145)return 'a';
		else if(n==209)return 'd';
		else if((c=='�') ||  (c == '�') || (c=='�') || (c=='�') || 
				(c=='�') || (c=='�') || (c=='�')|| (c=='�')|| (c=='�')|| (c=='�') || (c=='�')|| (c=='�')|| (c=='�') ||(c=='�')||
				(c=='�')|| (c=='�')|| (c=='�') ||(c=='�')|| (c=='�')||(c=='�')|| (c=='�')  ||(c=='�')||
				(c=='�')|| (c=='�') ||(c=='�')|| (c=='�')|| (c=='�')|| (c=='�')|| (c=='�')|| (c=='�')||(c=='�')|| (c=='�')|| (c=='�')||
				(c=='�')|| (c=='�')|| (c=='�')|| (c=='�')|| (c=='�')|| (c=='�')|| (c=='�')|| (c=='�')|| (c=='�')|| (c== '�')||
				(c=='�')|| (c=='�') ||(c=='�')|| (c=='�')|| (c=='�')|| (c=='�') ||(c=='�')|| (c=='�')|| (c=='�')|| (c=='�')){
			String sc = "" + c;
			String string = normalizarCasosEspeciais(sc);
			char[] chars = string.toCharArray();
			n = (int) chars[0];
			if(n>=65 && n<= 90) {
				n = n + 32;
				return (char) n;
			}
			return chars[0];
		}
		else if(c==' ') return c;
		else
			return '?';
		
		
	}
	
}

